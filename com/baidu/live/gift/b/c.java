package com.baidu.live.gift.b;

import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.j;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends BdBaseModel {
    private a aUJ;
    private BdPageContext aUK;
    private HttpMessageListener aUL;
    private HttpMessageListener aUM;
    public boolean mIsSending;

    /* loaded from: classes7.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.aUL = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.aUJ != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                            j jVar = (j) httpResponsedMessage.getOrginalMessage();
                            if (b.GM().gk(jVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.aNX).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.GM().gi(jVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.aUJ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Hc()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Hd());
                        com.baidu.live.gift.a.a He = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).He();
                        if (He != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.j(c.this.aUK.getPageActivity(), He.aSI, He.aSJ, He.aSK, He.aSL)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                        c.this.a(jVar2.liveId, jVar2.roomId, jVar2.aNZ, jVar2.aNY, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        c.this.a(jVar2);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU_SUCC, jVar2.sceneFrom, jVar2.giftId, String.valueOf(jVar2.aNX), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else if ((httpResponsedMessage.getOrginalMessage() instanceof j) && (httpResponsedMessage instanceof AlaGiftSendHttpResponseMessage)) {
                        long logId = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).getLogId();
                        j jVar3 = (j) httpResponsedMessage.getOrginalMessage();
                        AlaGiftSendHttpResponseMessage alaGiftSendHttpResponseMessage = (AlaGiftSendHttpResponseMessage) httpResponsedMessage;
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                        alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                        alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, jVar3.liveId);
                        alaStatsItem.addValue(LogConfig.LOG_ROOMID, jVar3.roomId);
                        alaStatsItem.addValue("giftid", jVar3.giftId);
                        alaStatsItem.addValue("giftcount", Long.valueOf(jVar3.aNX));
                        alaStatsItem.addValue("giftname", jVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(jVar3.aNY));
                        alaStatsItem.addValue("other", jVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.Hc()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.Hd()));
                        AlaStatManager.getInstance().debug("gift_send_fail", logId, "", alaStatsItem);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU, jVar3.sceneFrom, jVar3.giftId, String.valueOf(jVar3.aNX), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aUM = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.aUJ != null) {
                        c.this.aUJ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Hb()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof p)) {
                        p pVar = (p) httpResponsedMessage.getOrginalMessage();
                        c.this.a(pVar.liveId, pVar.roomId, pVar.aNZ, 0L, pVar.giftId, pVar.giftName, pVar.otherParams);
                        c.this.a(pVar);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE_SUCC, pVar.sceneFrom, pVar.giftId, String.valueOf(pVar.aNX), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof p) {
                        p pVar2 = (p) httpResponsedMessage.getOrginalMessage();
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE, pVar2.sceneFrom, pVar2.giftId, String.valueOf(pVar2.aNX), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aUK = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.aUL);
        MessageManager.getInstance().registerListener(this.aUM);
    }

    public void a(a aVar) {
        this.aUJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, jVar.giftId);
            jSONObject.put("gfit_name", jVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, jVar.aNY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "freegift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, pVar.giftId);
            jSONObject.put("gfit_name", pVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_GIFTS);
            alaStaticItem.addParams("live_id", str);
            alaStaticItem.addParams("room_id", str2);
            alaStaticItem.addParams("feed_id", str3);
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, str4);
            alaStaticItem.addParams("gifts_value", j + "");
            alaStaticItem.addParams("other_params", str6);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_GIFTS);
            alaStaticItem2.addParams("live_id", str);
            alaStaticItem2.addParams("room_id", str2);
            alaStaticItem2.addParams("gifts_value", j + "");
            alaStaticItem2.addParams(SdkStaticKeys.KEY_GIFTS_ID, str4);
            alaStaticItem2.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, str5);
            alaStaticItem2.addParams("feed_id", str3);
            alaStaticItem2.addParams("other_params", str6);
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
    }

    public void a(com.baidu.live.gift.a.b bVar) {
        long j;
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName) && this.aUK != null && this.aUK.getPageActivity() != null) {
            this.mIsSending = true;
            if (bVar.Gh()) {
                d.as(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar = new j();
                jVar.aNX = bVar.aSM;
                jVar.giftId = bVar.aHi;
                jVar.giftName = this.aUK.getPageActivity().getString(a.i.text_gift_graffiti);
                jVar.liveId = bVar.liveId;
                jVar.roomId = bVar.roomId;
                jVar.aNZ = bVar.aNZ;
                jVar.otherParams = bVar.otherParams;
                jVar.aOa = bVar.aOa;
                jVar.aOb = bVar.aOb;
                jVar.aOc.putAll(bVar.aSO);
                jVar.aNY = JavaTypesHelper.toLong(bVar.aSz != null ? bVar.aSz.getPrice() : "0", 0L) * bVar.aSM;
                long j2 = jVar.aNY;
                jVar.sceneFrom = bVar.sceneFrom;
                jVar.addParam("scene_from", bVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aHi);
                jVar.addParam("benefit_username", bVar.userName);
                jVar.addParam("benefit_userid", bVar.userId);
                jVar.addParam("num", bVar.aSM);
                jVar.addParam("ala_live_id", bVar.liveId);
                jVar.addParam("is_combo", bVar.aOJ);
                jVar.addParam("tbs", bVar.aSN);
                if (bVar.aSz != null && bVar.aSz.aNs != null) {
                    jVar.addParam("gift_mul", bVar.aSz.aNs.EI());
                    jVar.addParam("attach_new", bVar.aSz.aNs.EH());
                }
                jVar.addParam("scene_from", com.baidu.live.utils.p.Pp());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (bVar.Eb()) {
                d.as(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE);
                p pVar = new p();
                pVar.aNX = bVar.aSM;
                pVar.giftId = bVar.aHi;
                pVar.giftName = bVar.mGiftName;
                pVar.liveId = bVar.liveId;
                pVar.roomId = bVar.roomId;
                pVar.aNZ = bVar.aNZ;
                pVar.otherParams = bVar.otherParams;
                pVar.aOa = bVar.aOa;
                pVar.aOb = bVar.aOb;
                pVar.aOc.putAll(bVar.aSO);
                pVar.aNY = JavaTypesHelper.toLong(bVar.aSz != null ? bVar.aSz.getPrice() : "0", 0L) * bVar.aSM;
                long j3 = pVar.aNY;
                pVar.sceneFrom = bVar.sceneFrom;
                pVar.addParam("scene_from", bVar.sceneFrom);
                pVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aHi);
                pVar.addParam("benefit_username", bVar.userName);
                pVar.addParam("benefit_userid", bVar.userId);
                pVar.addParam("num", bVar.aSM);
                pVar.addParam("ala_live_id", bVar.liveId);
                pVar.addParam("is_combo", bVar.aOJ);
                pVar.addParam("tbs", bVar.aSN);
                pVar.addParam("scene_from", com.baidu.live.utils.p.Pp());
                MessageManager.getInstance().sendMessage(pVar);
                j = j3;
            } else {
                d.as(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar2 = new j();
                jVar2.aNX = bVar.aSM;
                jVar2.giftId = bVar.aHi;
                jVar2.giftName = bVar.mGiftName;
                jVar2.liveId = bVar.liveId;
                jVar2.roomId = bVar.roomId;
                jVar2.aNZ = bVar.aNZ;
                jVar2.otherParams = bVar.otherParams;
                jVar2.aOa = bVar.aOa;
                jVar2.aOb = bVar.aOb;
                jVar2.aOc.putAll(bVar.aSO);
                jVar2.aNY = JavaTypesHelper.toLong(bVar.aSz != null ? bVar.aSz.getPrice() : "0", 0L) * bVar.aSM;
                long j4 = jVar2.aNY;
                jVar2.sceneFrom = bVar.sceneFrom;
                jVar2.addParam("scene_from", bVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aHi);
                jVar2.addParam("benefit_username", bVar.userName);
                jVar2.addParam("benefit_userid", bVar.userId);
                jVar2.addParam("num", bVar.aSM);
                jVar2.addParam("ala_live_id", bVar.liveId);
                jVar2.addParam("is_combo", bVar.aOJ);
                jVar2.addParam("tbs", bVar.aSN);
                jVar2.addParam("scene_from", com.baidu.live.utils.p.Pp());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aNZ, bVar.aHi, bVar.aHi, j + "", bVar.otherParams);
            }
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        this.mIsSending = false;
        MessageManager.getInstance().unRegisterListener(this.aUL);
        MessageManager.getInstance().unRegisterListener(this.aUM);
    }
}
