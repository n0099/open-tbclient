package com.baidu.live.gift.c;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.b.e;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
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
    public static long pkId = 0;
    private CustomMessageListener bbt;
    private c.a bco;
    private HttpMessageListener bcp;
    private HttpMessageListener bcq;

    public a() {
        registerListener();
    }

    public void a(c.a aVar) {
        this.bco = aVar;
    }

    @Override // com.baidu.live.gift.c.c
    public void hs(String str) {
        com.baidu.live.gift.message.a aVar = new com.baidu.live.gift.message.a(str);
        aVar.addParam("scene_from", p.Ub());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", ""));
    }

    @Override // com.baidu.live.gift.c.c
    public void a(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, long j) {
        e.av(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE);
        com.baidu.live.gift.p pVar = new com.baidu.live.gift.p();
        pVar.a(str, str3, str4, str5, i, i2, str6, pkId);
        pVar.aTP = j;
        pVar.aTR.put(Long.valueOf(j), Long.valueOf(i));
        MessageManager.getInstance().sendMessage(pVar);
    }

    @Override // com.baidu.live.gift.c.c
    public void release() {
        this.bco = null;
        unregisterListener();
    }

    private void registerListener() {
        IO();
        IP();
        IN();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bcp);
        MessageManager.getInstance().unRegisterListener(this.bcq);
        MessageManager.getInstance().unRegisterListener(this.bbt);
    }

    private void IN() {
        this.bbt = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    if (((Long) customResponsedMessage.getData()).longValue() != -1) {
                        a.pkId = ((Long) customResponsedMessage.getData()).longValue();
                        return;
                    } else {
                        a.pkId = 0L;
                        return;
                    }
                }
                a.pkId = 0L;
            }
        };
        MessageManager.getInstance().registerListener(this.bbt);
    }

    private void IO() {
        this.bcp = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    com.baidu.live.gift.b.b.Iv().e(giftPackageListHttpResponsedMessage.getSceneFrom(), giftPackageListHttpResponsedMessage.IG());
                    if (a.this.bco != null) {
                        a.this.bco.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.IG(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.IH());
                    }
                    a.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcp);
    }

    private void IP() {
        this.bcq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.gift.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    a.this.a(httpResponsedMessage, giftPackageConsumeHttpResponsedMessage);
                    if (a.this.bco != null) {
                        a.this.bco.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.aUN, giftPackageConsumeHttpResponsedMessage.aUO);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage) {
        if (giftPackageListHttpResponsedMessage != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = null;
            if (giftPackageListHttpResponsedMessage.getError() != 0) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                    jSONObject.put("result", jSONObject3);
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    BdLog.e(e);
                    jSONObject2 = jSONObject3;
                }
            } else if (giftPackageListHttpResponsedMessage.IG() == null || giftPackageListHttpResponsedMessage.IG().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                    jSONObject.put("result", jSONObject4);
                    jSONObject2 = jSONObject4;
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    jSONObject2 = jSONObject4;
                }
            }
            if (jSONObject2 != null) {
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.II())) {
                    try {
                        jSONObject2.put("req_loc", giftPackageListHttpResponsedMessage.II());
                        jSONObject.put("result", jSONObject2);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", "").setContentExt(jSONObject), giftPackageListHttpResponsedMessage, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage) {
        if (giftPackageConsumeHttpResponsedMessage.getError() == 0 && !giftPackageConsumeHttpResponsedMessage.hasError()) {
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.p) {
                com.baidu.live.gift.p pVar = (com.baidu.live.gift.p) httpResponsedMessage.getOrginalMessage();
                e.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE_SUCC, pVar.sceneFrom, pVar.giftId, String.valueOf(pVar.aUv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
            }
        } else if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.p) {
            com.baidu.live.gift.p pVar2 = (com.baidu.live.gift.p) httpResponsedMessage.getOrginalMessage();
            e.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE, pVar2.sceneFrom, pVar2.giftId, String.valueOf(pVar2.aUv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
        }
    }
}
