package com.baidu.live.yuyingift.c;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.YuyinGiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.aq;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.t;
import com.baidu.live.yuyingift.c.b;
import com.baidu.live.yuyingift.http.GiftPackageListHttpResponsedMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d implements b {
    private b.a bWa;
    private HttpMessageListener bdg;
    private HttpMessageListener bdh;

    public d() {
        registerListener();
    }

    public void a(b.a aVar) {
        this.bWa = aVar;
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void gp(String str) {
        com.baidu.live.yuyingift.message.a aVar = new com.baidu.live.yuyingift.message.a(str);
        aVar.addParam("scene_from", t.TN());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, UbcStatConstant.Page.VOICE_ROOM, null));
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, long j, int i3, long j2) {
        aq aqVar = new aq();
        aqVar.c(str, str2, str3, str4, i, i2, str5, str6, i3, j2);
        aqVar.aTM = j;
        aqVar.aTO.put(Long.valueOf(j), Long.valueOf(i));
        MessageManager.getInstance().sendMessage(aqVar);
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void release() {
        this.bWa = null;
        unregisterListener();
    }

    private void registerListener() {
        Gu();
        Gv();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bdg);
        MessageManager.getInstance().unRegisterListener(this.bdh);
    }

    private void Gu() {
        this.bdg = new HttpMessageListener(1031065) { // from class: com.baidu.live.yuyingift.c.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (d.this.bWa != null) {
                        d.this.bWa.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.Gm(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.Gn());
                    }
                    d.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdg);
    }

    private void Gv() {
        this.bdh = new HttpMessageListener(1031057) { // from class: com.baidu.live.yuyingift.c.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) {
                    YuyinGiftPackageConsumeHttpResponsedMessage yuyinGiftPackageConsumeHttpResponsedMessage = (YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    d.this.a(httpResponsedMessage, yuyinGiftPackageConsumeHttpResponsedMessage);
                    if (d.this.bWa != null) {
                        d.this.bWa.a(!yuyinGiftPackageConsumeHttpResponsedMessage.hasError() && yuyinGiftPackageConsumeHttpResponsedMessage.getError() == 0, yuyinGiftPackageConsumeHttpResponsedMessage.getError(), yuyinGiftPackageConsumeHttpResponsedMessage.getErrorString(), yuyinGiftPackageConsumeHttpResponsedMessage.aUM, yuyinGiftPackageConsumeHttpResponsedMessage.aUN);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage) {
        JSONObject jSONObject;
        if (giftPackageListHttpResponsedMessage != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (giftPackageListHttpResponsedMessage.getError() != 0) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                    jSONObject2.put("result", jSONObject3);
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    BdLog.e(e);
                    jSONObject = jSONObject3;
                }
            } else if (giftPackageListHttpResponsedMessage.Gm() == null || giftPackageListHttpResponsedMessage.Gm().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
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
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.Go())) {
                    try {
                        jSONObject.put("req_loc", giftPackageListHttpResponsedMessage.Go());
                        jSONObject2.put("result", jSONObject);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, UbcStatConstant.Page.VOICE_ROOM, null).setContentExt(jSONObject2), giftPackageListHttpResponsedMessage, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, YuyinGiftPackageConsumeHttpResponsedMessage yuyinGiftPackageConsumeHttpResponsedMessage) {
    }
}
