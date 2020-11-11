package com.baidu.live.gift.b;

import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.l;
import com.baidu.live.gift.i;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.o;
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
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private a bdc;
    private BdPageContext bdd;
    private CustomMessageListener bde;
    private HttpMessageListener bdf;
    private HttpMessageListener bdg;
    public boolean mIsSending;
    private volatile long pkId;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.pkId = 0L;
        this.bde = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() == null) {
                    c.this.pkId = 0L;
                } else if (customResponsedMessage.getData() instanceof Long) {
                    if (((Long) customResponsedMessage.getData()).longValue() == -1) {
                        c.this.pkId = 0L;
                        return;
                    }
                    c.this.pkId = ((Long) customResponsedMessage.getData()).longValue();
                }
            }
        };
        this.bdf = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.bdc != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                            i iVar = (i) httpResponsedMessage.getOrginalMessage();
                            if (b.Je().gX(iVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", iVar.giftId).param("obj_param1", iVar.aVw).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.Je().gV(iVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bdc.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Jt()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Ju());
                        com.baidu.live.gift.a.a Jv = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Jv();
                        if (Jv != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(c.this.bdd.getPageActivity(), Jv.baU, Jv.baV, Jv.baW, Jv.baX)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                        i iVar2 = (i) httpResponsedMessage.getOrginalMessage();
                        c.this.a(iVar2.liveId, iVar2.roomId, iVar2.aVy, iVar2.aVx, iVar2.giftId, iVar2.giftName, iVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        try {
                            com.baidu.live.n.a.b(Long.parseLong(iVar2.liveId), 4);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        c.this.a(iVar2, httpResponsedMessage);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU_SUCC, iVar2.sceneFrom, iVar2.giftId, String.valueOf(iVar2.aVw), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else if ((httpResponsedMessage.getOrginalMessage() instanceof i) && (httpResponsedMessage instanceof AlaGiftSendHttpResponseMessage)) {
                        long logId = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).getLogId();
                        i iVar3 = (i) httpResponsedMessage.getOrginalMessage();
                        AlaGiftSendHttpResponseMessage alaGiftSendHttpResponseMessage = (AlaGiftSendHttpResponseMessage) httpResponsedMessage;
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                        alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                        alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, iVar3.liveId);
                        alaStatsItem.addValue(LogConfig.LOG_ROOMID, iVar3.roomId);
                        alaStatsItem.addValue("giftid", iVar3.giftId);
                        alaStatsItem.addValue("giftcount", Long.valueOf(iVar3.aVw));
                        alaStatsItem.addValue("giftname", iVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(iVar3.aVx));
                        alaStatsItem.addValue("other", iVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.Jt()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.Ju()));
                        AlaStatManager.getInstance().debug("gift_send_fail", logId, "", alaStatsItem);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU, iVar3.sceneFrom, iVar3.giftId, String.valueOf(iVar3.aVw), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.bdg = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.bdc != null) {
                        c.this.bdc.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Js()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof o)) {
                        o oVar = (o) httpResponsedMessage.getOrginalMessage();
                        c.this.a(oVar.liveId, oVar.roomId, oVar.aVy, 0L, oVar.giftId, oVar.giftName, oVar.otherParams);
                        c.this.a(oVar);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE_SUCC, oVar.sceneFrom, oVar.giftId, String.valueOf(oVar.aVw), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                        try {
                            com.baidu.live.n.a.b(Long.parseLong(oVar.liveId), 3);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof o) {
                        o oVar2 = (o) httpResponsedMessage.getOrginalMessage();
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE, oVar2.sceneFrom, oVar2.giftId, String.valueOf(oVar2.aVw), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.bdd = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bdf);
        MessageManager.getInstance().registerListener(this.bdg);
        MessageManager.getInstance().registerListener(this.bde);
    }

    public void a(a aVar) {
        this.bdc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, HttpResponsedMessage httpResponsedMessage) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, iVar.giftId);
            jSONObject.put("gfit_name", iVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, iVar.aVx);
            jSONObject.putOpt("gift_num", Long.valueOf(iVar.aVw));
            if (httpResponsedMessage instanceof AlaGiftSendHttpResponseMessage) {
                jSONObject.put("order_id", ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).orderId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "freegift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, oVar.giftId);
            jSONObject.put("gfit_name", oVar.giftName);
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
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
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
        if (bVar != null && !StringUtils.isNull(bVar.userId) && this.bdd != null && this.bdd.getPageActivity() != null) {
            this.mIsSending = true;
            if (bVar.Iz()) {
                e.aw(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                i iVar = new i();
                iVar.aVw = bVar.baY;
                iVar.giftId = bVar.aNj;
                iVar.giftName = this.bdd.getPageActivity().getString(a.h.text_gift_graffiti);
                iVar.liveId = bVar.liveId;
                iVar.roomId = bVar.roomId;
                iVar.aVy = bVar.aVy;
                iVar.otherParams = bVar.otherParams;
                iVar.aVz = bVar.aVz;
                iVar.aVA = bVar.aVA;
                iVar.aVB = String.valueOf(this.pkId);
                iVar.aVC.putAll(bVar.bba);
                iVar.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j2 = iVar.aVx;
                iVar.sceneFrom = bVar.sceneFrom;
                iVar.addParam("pk_id", this.pkId);
                iVar.addParam("scene_from", bVar.sceneFrom);
                iVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                iVar.addParam("benefit_username", bVar.userName);
                iVar.addParam("benefit_userid", bVar.userId);
                iVar.addParam("num", bVar.baY);
                iVar.addParam("ala_live_id", bVar.liveId);
                iVar.addParam("is_combo", bVar.aWA);
                iVar.addParam("tbs", bVar.baZ);
                if (bVar.baH != null && bVar.baH.aUN != null) {
                    iVar.addParam("gift_mul", bVar.baH.aUN.GL());
                    iVar.addParam("attach_new", bVar.baH.aUN.GK());
                }
                iVar.addParam("scene_from", p.UK());
                MessageManager.getInstance().sendMessage(iVar);
                j = j2;
            } else if (bVar.Gd()) {
                e.aw(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE);
                o oVar = new o();
                oVar.aVw = bVar.baY;
                oVar.giftId = bVar.aNj;
                oVar.giftName = bVar.mGiftName;
                oVar.liveId = bVar.liveId;
                oVar.roomId = bVar.roomId;
                oVar.aVy = bVar.aVy;
                oVar.otherParams = bVar.otherParams;
                oVar.aVz = bVar.aVz;
                oVar.aVA = bVar.aVA;
                oVar.aVC.putAll(bVar.bba);
                oVar.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j3 = oVar.aVx;
                oVar.sceneFrom = bVar.sceneFrom;
                oVar.addParam("scene_from", bVar.sceneFrom);
                oVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                oVar.addParam("benefit_username", bVar.userName);
                oVar.addParam("benefit_userid", bVar.userId);
                oVar.addParam("num", bVar.baY);
                oVar.addParam("ala_live_id", bVar.liveId);
                oVar.addParam("is_combo", bVar.aWA);
                oVar.addParam("tbs", bVar.baZ);
                oVar.addParam("scene_from", p.UK());
                MessageManager.getInstance().sendMessage(oVar);
                j = j3;
            } else {
                e.aw(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                i iVar2 = new i();
                iVar2.aVw = bVar.baY;
                iVar2.giftId = bVar.aNj;
                iVar2.giftName = bVar.mGiftName;
                iVar2.liveId = bVar.liveId;
                iVar2.roomId = bVar.roomId;
                iVar2.aVy = bVar.aVy;
                iVar2.otherParams = bVar.otherParams;
                iVar2.aVz = bVar.aVz;
                iVar2.aVA = bVar.aVA;
                iVar2.aVC.putAll(bVar.bba);
                iVar2.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j4 = iVar2.aVx;
                iVar2.sceneFrom = bVar.sceneFrom;
                iVar2.addParam("pk_id", this.pkId);
                iVar2.addParam("scene_from", bVar.sceneFrom);
                iVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                iVar2.addParam("benefit_username", bVar.userName);
                iVar2.addParam("benefit_userid", bVar.userId);
                iVar2.addParam("num", bVar.baY);
                iVar2.addParam("ala_live_id", bVar.liveId);
                iVar2.addParam("is_combo", bVar.aWA);
                iVar2.addParam("tbs", bVar.baZ);
                iVar2.addParam("scene_from", p.UK());
                MessageManager.getInstance().sendMessage(iVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aVy, bVar.aNj, bVar.aNj, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bdf);
        MessageManager.getInstance().unRegisterListener(this.bdg);
        MessageManager.getInstance().unRegisterListener(this.bde);
    }
}
