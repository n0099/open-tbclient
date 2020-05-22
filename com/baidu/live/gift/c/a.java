package com.baidu.live.gift.c;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.b.d;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.http.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.q;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements c {
    private c.a aMq;
    private HttpMessageListener aMr;
    private HttpMessageListener aMs;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.aMq = aVar;
    }

    @Override // com.baidu.live.gift.c.c
    public void fj(String str) {
        com.baidu.live.gift.message.a aVar = new com.baidu.live.gift.message.a(str);
        aVar.addParam("scene_from", q.Id());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", null));
    }

    @Override // com.baidu.live.gift.c.c
    public void d(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE);
        com.baidu.live.gift.q qVar = new com.baidu.live.gift.q();
        qVar.a(str, str2, str3, str4, i, i2, str5);
        MessageManager.getInstance().sendMessage(qVar);
    }

    @Override // com.baidu.live.gift.c.c
    public void release() {
        this.aMq = null;
        unregisterListener();
    }

    private void registerListener() {
        AA();
        AB();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aMr);
        MessageManager.getInstance().unRegisterListener(this.aMs);
    }

    private void AA() {
        this.aMr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.aMq != null) {
                        a.this.aMq.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.At(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.Au());
                    }
                    a.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMr);
    }

    private void AB() {
        this.aMs = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    a.this.a(httpResponsedMessage, giftPackageConsumeHttpResponsedMessage);
                    if (a.this.aMq != null) {
                        a.this.aMq.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.aMj, giftPackageConsumeHttpResponsedMessage.aMk);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMs);
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
            } else if (giftPackageListHttpResponsedMessage.At() == null || giftPackageListHttpResponsedMessage.At().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
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
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.Av())) {
                    try {
                        jSONObject.put("req_loc", giftPackageListHttpResponsedMessage.Av());
                        jSONObject2.put("result", jSONObject);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", null).setContentExt(jSONObject2), giftPackageListHttpResponsedMessage, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage) {
        if (giftPackageConsumeHttpResponsedMessage.getError() == 0 && !giftPackageConsumeHttpResponsedMessage.hasError()) {
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.q) {
                com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) httpResponsedMessage.getOrginalMessage();
                d.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE_SUCC, qVar.sceneFrom, qVar.giftId, String.valueOf(qVar.aFE), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
            }
        } else if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.q) {
            com.baidu.live.gift.q qVar2 = (com.baidu.live.gift.q) httpResponsedMessage.getOrginalMessage();
            d.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE, qVar2.sceneFrom, qVar2.giftId, String.valueOf(qVar2.aFE), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
        }
    }
}
