package com.baidu.live.gift.d;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.c.e;
import com.baidu.live.gift.d.c;
import com.baidu.live.gift.http.GiftPackageFragmentCompositeHttpResponsedMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.q;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements c {
    public static long pkId = 0;
    private CustomMessageListener bft;
    private c.a bgo;
    private HttpMessageListener bgp;
    private HttpMessageListener bgq;
    private HttpMessageListener bgr;

    public a() {
        registerListener();
    }

    @Override // com.baidu.live.gift.d.c
    public void a(c.a aVar) {
        this.bgo = aVar;
    }

    @Override // com.baidu.live.gift.d.c
    public void gN(String str) {
        com.baidu.live.gift.message.a aVar = new com.baidu.live.gift.message.a(str);
        aVar.addParam("scene_from", q.Vu());
        aVar.addParam("platform", "2");
        MessageManager.getInstance().sendMessage(aVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_PACKAGE_LIST, "liveroom", ""));
    }

    @Override // com.baidu.live.gift.d.c
    public void b(d dVar) {
        e.aw(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE);
        com.baidu.live.gift.q qVar = new com.baidu.live.gift.q();
        qVar.a(dVar.itemId, dVar.aWl, dVar.bdf, dVar.liveId, dVar.bdg, dVar.aXW, dVar.bdh, pkId);
        qVar.aWR = dVar.aWR;
        qVar.aWT.put(Long.valueOf(dVar.aWR), Long.valueOf(dVar.bdg));
        MessageManager.getInstance().sendMessage(qVar);
    }

    public void b(String str, String str2, String str3, int i, String str4) {
        com.baidu.live.gift.http.a aVar = new com.baidu.live.gift.http.a();
        aVar.a(str, str2, str3, i, pkId);
        aVar.setThumbUrl(str4);
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.gift.d.c
    public void release() {
        this.bgo = null;
        unregisterListener();
    }

    private void registerListener() {
        HK();
        HL();
        HJ();
        HM();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bgp);
        MessageManager.getInstance().unRegisterListener(this.bgq);
        MessageManager.getInstance().unRegisterListener(this.bft);
        MessageManager.getInstance().unRegisterListener(this.bgr);
    }

    private void HJ() {
        this.bft = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.d.a.1
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
        MessageManager.getInstance().registerListener(this.bft);
    }

    private void HK() {
        this.bgp = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST) { // from class: com.baidu.live.gift.d.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageListHttpResponsedMessage) {
                    GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage = (GiftPackageListHttpResponsedMessage) httpResponsedMessage;
                    com.baidu.live.gift.c.b.Hr().e(giftPackageListHttpResponsedMessage.getSceneFrom(), giftPackageListHttpResponsedMessage.HC());
                    if (a.this.bgo != null) {
                        a.this.bgo.a(!giftPackageListHttpResponsedMessage.hasError() && giftPackageListHttpResponsedMessage.getError() == 0, giftPackageListHttpResponsedMessage.getError(), giftPackageListHttpResponsedMessage.getErrorString(), giftPackageListHttpResponsedMessage.HC(), giftPackageListHttpResponsedMessage.getCategoryList(), giftPackageListHttpResponsedMessage.HD(), giftPackageListHttpResponsedMessage.Fh(), giftPackageListHttpResponsedMessage.getFlag());
                    }
                    a.this.a(giftPackageListHttpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgp);
    }

    private void HL() {
        this.bgq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.gift.d.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) {
                    GiftPackageConsumeHttpResponsedMessage giftPackageConsumeHttpResponsedMessage = (GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage;
                    a.this.a(httpResponsedMessage, giftPackageConsumeHttpResponsedMessage);
                    if (a.this.bgo != null) {
                        a.this.bgo.a(!giftPackageConsumeHttpResponsedMessage.hasError() && giftPackageConsumeHttpResponsedMessage.getError() == 0, giftPackageConsumeHttpResponsedMessage.getError(), giftPackageConsumeHttpResponsedMessage.getErrorString(), giftPackageConsumeHttpResponsedMessage.aXU, giftPackageConsumeHttpResponsedMessage.aXV);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgq);
    }

    private void HM() {
        this.bgr = new HttpMessageListener(1021232) { // from class: com.baidu.live.gift.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                boolean z = false;
                if (httpResponsedMessage instanceof GiftPackageFragmentCompositeHttpResponsedMessage) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (httpResponsedMessage.getmOrginalMessage() instanceof com.baidu.live.gift.http.a) {
                        str = ((com.baidu.live.gift.http.a) httpResponsedMessage.getmOrginalMessage()).itemId;
                        str2 = ((com.baidu.live.gift.http.a) httpResponsedMessage.getmOrginalMessage()).aWl;
                        str3 = ((com.baidu.live.gift.http.a) httpResponsedMessage.getmOrginalMessage()).thumbUrl;
                        i = ((com.baidu.live.gift.http.a) httpResponsedMessage.getmOrginalMessage()).count;
                    } else {
                        i = 0;
                    }
                    if (a.this.bgo != null) {
                        c.a aVar = a.this.bgo;
                        if (httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0) {
                            z = true;
                        }
                        aVar.b(z, httpResponsedMessage.getErrorString(), str, str2, str3, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GiftPackageListHttpResponsedMessage giftPackageListHttpResponsedMessage) {
        if (giftPackageListHttpResponsedMessage != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = null;
            if (giftPackageListHttpResponsedMessage.getError() != 0) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                    jSONObject.put("result", jSONObject3);
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    BdLog.e(e);
                    jSONObject2 = jSONObject3;
                }
            } else if (giftPackageListHttpResponsedMessage.HC() == null || giftPackageListHttpResponsedMessage.HC().isEmpty() || giftPackageListHttpResponsedMessage.getCategoryList() == null || giftPackageListHttpResponsedMessage.getCategoryList().isEmpty()) {
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
                if (!TextUtils.isEmpty(giftPackageListHttpResponsedMessage.HE())) {
                    try {
                        jSONObject2.put("req_loc", giftPackageListHttpResponsedMessage.HE());
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
            if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.q) {
                com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) httpResponsedMessage.getOrginalMessage();
                e.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE_SUCC, qVar.sceneFrom, qVar.giftId, String.valueOf(qVar.aXz), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
            }
        } else if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.gift.q) {
            com.baidu.live.gift.q qVar2 = (com.baidu.live.gift.q) httpResponsedMessage.getOrginalMessage();
            e.a(giftPackageConsumeHttpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_PACKAGE, qVar2.sceneFrom, qVar2.giftId, String.valueOf(qVar2.aXz), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
        }
    }
}
