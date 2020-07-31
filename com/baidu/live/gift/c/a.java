package com.baidu.live.gift.c;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.b.d;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.gift.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.p;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements c {
    private c.a aQp;
    private HttpMessageListener aQq;
    private HttpMessageListener aQr;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.aQp = aVar;
    }

    @Override // com.baidu.live.gift.c.c
    public void fo(String str) {
        com.baidu.live.gift.message.a aVar = new com.baidu.live.gift.message.a(str);
        aVar.addParam("scene_from", p.Jx());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", null));
    }

    @Override // com.baidu.live.gift.c.c
    public void a(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, long j) {
        d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE);
        q qVar = new q();
        qVar.a(str, str3, str4, str5, i, i2, str6);
        qVar.aIQ = j;
        qVar.aIR.put(Long.valueOf(j), Long.valueOf(i));
        MessageManager.getInstance().sendMessage(qVar);
    }

    @Override // com.baidu.live.gift.c.c
    public void release() {
        this.aQp = null;
        unregisterListener();
    }

    private void registerListener() {
        BC();
        BD();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aQq);
        MessageManager.getInstance().unRegisterListener(this.aQr);
    }

    private void BC() {
        this.aQq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    if (a.this.aQp != null) {
                        a.this.aQp.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.Bv(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.Bw());
                    }
                    a.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQq);
    }

    private void BD() {
        this.aQr = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    a.this.a(httpResponsedMessage, giftPackageConsumeHttpResponsedMessage);
                    if (a.this.aQp != null) {
                        a.this.aQp.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.aJw, giftPackageConsumeHttpResponsedMessage.aJx);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQr);
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
            } else if (giftPackageListHttpResponsedMessage.Bv() == null || giftPackageListHttpResponsedMessage.Bv().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
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
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.Bx())) {
                    try {
                        jSONObject.put("req_loc", giftPackageListHttpResponsedMessage.Bx());
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
            if (httpResponsedMessage.getOrginalMessage() instanceof q) {
                q qVar = (q) httpResponsedMessage.getOrginalMessage();
                d.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE_SUCC, qVar.sceneFrom, qVar.giftId, String.valueOf(qVar.aJv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
            }
        } else if (httpResponsedMessage.getOrginalMessage() instanceof q) {
            q qVar2 = (q) httpResponsedMessage.getOrginalMessage();
            d.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE, qVar2.sceneFrom, qVar2.giftId, String.valueOf(qVar2.aJv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
        }
    }
}
