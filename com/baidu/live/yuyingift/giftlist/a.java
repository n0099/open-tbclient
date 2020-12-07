package com.baidu.live.yuyingift.giftlist;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.s;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private InterfaceC0245a bUr;
    private HttpMessageListener beN;
    private boolean isHost;

    /* renamed from: com.baidu.live.yuyingift.giftlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0245a {
        void n(ArrayList<com.baidu.live.gift.c> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.live.gift.c> arrayList, ArrayList<com.baidu.live.gift.b> arrayList2) {
        if (!ListUtils.isEmpty(arrayList2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList2.size()) {
                    com.baidu.live.gift.b bVar = arrayList2.get(i2);
                    if (bVar != null && bVar.aVt != null) {
                        com.baidu.live.gift.c cVar = new com.baidu.live.gift.c();
                        cVar.aVw = com.baidu.live.ag.b.iA(bVar.aVt.zipName);
                        cVar.upZipDirPath = com.baidu.live.ag.b.iB(bVar.aVt.zipName);
                        cVar.aVv = bVar;
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
        this.beN = new HttpMessageListener(1031058) { // from class: com.baidu.live.yuyingift.giftlist.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof YuyinAlaDynamicGiftListHttpResponseMessage)) {
                    YuyinAlaDynamicGiftListHttpResponseMessage yuyinAlaDynamicGiftListHttpResponseMessage = (YuyinAlaDynamicGiftListHttpResponseMessage) httpResponsedMessage;
                    ArrayList<com.baidu.live.gift.b> Ks = yuyinAlaDynamicGiftListHttpResponseMessage.Ks();
                    ArrayList<com.baidu.live.gift.c> arrayList = new ArrayList<>();
                    if (Ks != null) {
                        a.this.d(arrayList, Ks);
                    }
                    if (a.this.bUr != null) {
                        a.this.bUr.n(arrayList);
                    }
                    a.this.a(yuyinAlaDynamicGiftListHttpResponseMessage);
                }
            }
        };
        registerListener(this.beN);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void hO(String str) {
        c cVar = new c(this.isHost, str);
        cVar.addParam("need_dynamic_gift", "1");
        cVar.addParam("need_sticker_gift", "0");
        cVar.addParam("scene_from", s.WB());
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
        MessageManager.getInstance().unRegisterListener(this.beN);
    }

    public void a(InterfaceC0245a interfaceC0245a) {
        this.bUr = interfaceC0245a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinAlaDynamicGiftListHttpResponseMessage yuyinAlaDynamicGiftListHttpResponseMessage) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (yuyinAlaDynamicGiftListHttpResponseMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                jSONObject2.put("result", jSONObject3);
                jSONObject = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject = jSONObject3;
            }
        } else if (yuyinAlaDynamicGiftListHttpResponseMessage.Ks() == null || yuyinAlaDynamicGiftListHttpResponseMessage.Ks().isEmpty()) {
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
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, "dynamic_list", yuyinAlaDynamicGiftListHttpResponseMessage.Gz() ? "author_liveroom" : "liveroom", null).setContentExt(jSONObject2), yuyinAlaDynamicGiftListHttpResponseMessage, true);
        }
    }
}
