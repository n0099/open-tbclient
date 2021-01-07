package com.baidu.live.yuyingift.giftlist;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.t;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private boolean bgw;
    private HttpMessageListener bgz;
    private InterfaceC0245a cag;
    private boolean isHost;

    /* renamed from: com.baidu.live.yuyingift.giftlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0245a {
        void n(ArrayList<com.baidu.live.gift.c> arrayList);
    }

    public void bY(boolean z) {
        this.bgw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.live.gift.c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.aWY != null) {
                        com.baidu.live.gift.c cVar = new com.baidu.live.gift.c();
                        cVar.aXc = com.baidu.live.ah.b.in(bVar.aWY.zipName);
                        cVar.upZipDirPath = com.baidu.live.ah.b.io(bVar.aWY.zipName);
                        cVar.aXb = bVar;
                        arrayList.add(cVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public a(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.bgz = new HttpMessageListener(1031058) { // from class: com.baidu.live.yuyingift.giftlist.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinAlaDynamicGiftListHttpResponseMessage)) {
                    YuyinAlaDynamicGiftListHttpResponseMessage yuyinAlaDynamicGiftListHttpResponseMessage = (YuyinAlaDynamicGiftListHttpResponseMessage) httpResponsedMessage;
                    ArrayList<com.baidu.live.gift.b> JU = yuyinAlaDynamicGiftListHttpResponseMessage.JU();
                    ArrayList<com.baidu.live.gift.c> arrayList = new ArrayList<>();
                    if (JU != null) {
                        a.this.d(arrayList, JU);
                    }
                    if (a.this.cag != null) {
                        a.this.cag.n(arrayList);
                    }
                    a.this.a(yuyinAlaDynamicGiftListHttpResponseMessage);
                }
            }
        };
        registerListener(this.bgz);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void hz(String str) {
        c cVar = new c(this.isHost, this.bgw, str);
        cVar.addParam("need_dynamic_gift", "1");
        cVar.addParam("need_sticker_gift", "0");
        cVar.addParam("scene_from", t.XG());
        sendMessage(cVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bgz);
    }

    public void a(InterfaceC0245a interfaceC0245a) {
        this.cag = interfaceC0245a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinAlaDynamicGiftListHttpResponseMessage yuyinAlaDynamicGiftListHttpResponseMessage) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (yuyinAlaDynamicGiftListHttpResponseMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                jSONObject2.put("result", jSONObject3);
                jSONObject = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject = jSONObject3;
            }
        } else if (yuyinAlaDynamicGiftListHttpResponseMessage.JU() == null || yuyinAlaDynamicGiftListHttpResponseMessage.JU().isEmpty()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                jSONObject2.put("result", jSONObject4);
                jSONObject = jSONObject4;
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject = jSONObject4;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_DYNAMIC_LIST, yuyinAlaDynamicGiftListHttpResponseMessage.FS() ? "author_liveroom" : "liveroom", null).setContentExt(jSONObject2), yuyinAlaDynamicGiftListHttpResponseMessage, true);
        }
    }
}
