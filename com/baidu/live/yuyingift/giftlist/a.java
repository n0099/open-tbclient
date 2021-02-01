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
    private InterfaceC0237a bZw;
    private boolean beM;
    private HttpMessageListener beP;
    private boolean isHost;

    /* renamed from: com.baidu.live.yuyingift.giftlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0237a {
        void i(ArrayList<com.baidu.live.gift.c> arrayList);
    }

    public void bZ(boolean z) {
        this.beM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.live.gift.c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.aVp != null) {
                        com.baidu.live.gift.c cVar = new com.baidu.live.gift.c();
                        cVar.aVt = com.baidu.live.storage.b.hy(bVar.aVp.zipName);
                        cVar.upZipDirPath = com.baidu.live.storage.b.hz(bVar.aVp.zipName);
                        cVar.aVs = bVar;
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
        this.beP = new HttpMessageListener(1031058) { // from class: com.baidu.live.yuyingift.giftlist.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinAlaDynamicGiftListHttpResponseMessage)) {
                    YuyinAlaDynamicGiftListHttpResponseMessage yuyinAlaDynamicGiftListHttpResponseMessage = (YuyinAlaDynamicGiftListHttpResponseMessage) httpResponsedMessage;
                    ArrayList<com.baidu.live.gift.b> Hp = yuyinAlaDynamicGiftListHttpResponseMessage.Hp();
                    ArrayList<com.baidu.live.gift.c> arrayList = new ArrayList<>();
                    if (Hp != null) {
                        a.this.d(arrayList, Hp);
                    }
                    if (a.this.bZw != null) {
                        a.this.bZw.i(arrayList);
                    }
                    a.this.a(yuyinAlaDynamicGiftListHttpResponseMessage);
                }
            }
        };
        registerListener(this.beP);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void gL(String str) {
        c cVar = new c(this.isHost, this.beM, str);
        cVar.addParam("need_dynamic_gift", "1");
        cVar.addParam("need_sticker_gift", "0");
        cVar.addParam("scene_from", t.Vu());
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
        MessageManager.getInstance().unRegisterListener(this.beP);
    }

    public void a(InterfaceC0237a interfaceC0237a) {
        this.bZw = interfaceC0237a;
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
        } else if (yuyinAlaDynamicGiftListHttpResponseMessage.Hp() == null || yuyinAlaDynamicGiftListHttpResponseMessage.Hp().isEmpty()) {
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
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_DYNAMIC_LIST, yuyinAlaDynamicGiftListHttpResponseMessage.Dm() ? "author_liveroom" : "liveroom", null).setContentExt(jSONObject2), yuyinAlaDynamicGiftListHttpResponseMessage, true);
        }
    }
}
