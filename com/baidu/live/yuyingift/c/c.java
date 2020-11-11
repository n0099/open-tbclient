package com.baidu.live.yuyingift.c;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.YuyinGiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.an;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.c.b;
import com.baidu.live.yuyingift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements b {
    private b.a bRr;
    private HttpMessageListener bea;
    private HttpMessageListener beb;

    public c() {
        registerListener();
    }

    public void a(b.a aVar) {
        this.bRr = aVar;
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void hy(String str) {
        com.baidu.live.yuyingift.message.a aVar = new com.baidu.live.yuyingift.message.a(str);
        aVar.addParam("scene_from", s.UK());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, UbcStatConstant.Page.VOICE_ROOM, null));
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, long j) {
        an anVar = new an();
        anVar.c(str, str2, str3, str4, i, i2, str5, str6);
        anVar.aVA = j;
        anVar.aVC.put(Long.valueOf(j), Long.valueOf(i));
        MessageManager.getInstance().sendMessage(anVar);
    }

    @Override // com.baidu.live.yuyingift.c.b
    public void release() {
        this.bRr = null;
        unregisterListener();
    }

    private void registerListener() {
        Jx();
        Jy();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bea);
        MessageManager.getInstance().unRegisterListener(this.beb);
    }

    private void Jx() {
        this.bea = new HttpMessageListener(1031065) { // from class: com.baidu.live.yuyingift.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (c.this.bRr != null) {
                        c.this.bRr.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.Jp(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.Jq());
                    }
                    c.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bea);
    }

    private void Jy() {
        this.beb = new HttpMessageListener(1031057) { // from class: com.baidu.live.yuyingift.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) {
                    YuyinGiftPackageConsumeHttpResponsedMessage yuyinGiftPackageConsumeHttpResponsedMessage = (YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    c.this.a(httpResponsedMessage, yuyinGiftPackageConsumeHttpResponsedMessage);
                    if (c.this.bRr != null) {
                        c.this.bRr.a(!yuyinGiftPackageConsumeHttpResponsedMessage.hasError() && yuyinGiftPackageConsumeHttpResponsedMessage.getError() == 0, yuyinGiftPackageConsumeHttpResponsedMessage.getError(), yuyinGiftPackageConsumeHttpResponsedMessage.getErrorString(), yuyinGiftPackageConsumeHttpResponsedMessage.aWy, yuyinGiftPackageConsumeHttpResponsedMessage.aWz);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.beb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage) {
        JSONObject jSONObject;
        if (giftPackageListHttpResponsedMessage != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (giftPackageListHttpResponsedMessage.getError() != 0) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                    jSONObject2.put("result", jSONObject3);
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    BdLog.e(e);
                    jSONObject = jSONObject3;
                }
            } else if (giftPackageListHttpResponsedMessage.Jp() == null || giftPackageListHttpResponsedMessage.Jp().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
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
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.Jr())) {
                    try {
                        jSONObject.put("req_loc", giftPackageListHttpResponsedMessage.Jr());
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
