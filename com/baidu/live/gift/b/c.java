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
import com.baidu.live.c.h;
import com.baidu.live.gift.j;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.p;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends BdBaseModel {
    private a aFM;
    private BdPageContext aFN;
    private HttpMessageListener aFO;
    private HttpMessageListener aFP;
    public boolean mIsSending;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.aFO = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.aFM != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                            j jVar = (j) httpResponsedMessage.getOrginalMessage();
                            if (b.yS().ee(jVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.azD).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.yS().ec(jVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.aFM.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).zi()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).zj());
                        com.baidu.live.gift.a.a zl = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).zl();
                        if (zl != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new h(c.this.aFN.getPageActivity(), zl.aDV, zl.aDW, zl.aDX, zl.aDY)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                        c.this.a(jVar2.liveId, jVar2.roomId, jVar2.azF, jVar2.azE, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        c.this.a(jVar2);
                    } else if ((httpResponsedMessage.getOrginalMessage() instanceof j) && (httpResponsedMessage instanceof AlaGiftSendHttpResponseMessage)) {
                        long zk = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).zk();
                        j jVar3 = (j) httpResponsedMessage.getOrginalMessage();
                        AlaGiftSendHttpResponseMessage alaGiftSendHttpResponseMessage = (AlaGiftSendHttpResponseMessage) httpResponsedMessage;
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                        alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                        alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, jVar3.liveId);
                        alaStatsItem.addValue(LogConfig.LOG_ROOMID, jVar3.roomId);
                        alaStatsItem.addValue("giftid", jVar3.giftId);
                        alaStatsItem.addValue("giftcount", Long.valueOf(jVar3.azD));
                        alaStatsItem.addValue("giftname", jVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(jVar3.azE));
                        alaStatsItem.addValue("other", jVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.zi()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.zj()));
                        AlaStatManager.getInstance().debug("gift_send_fail", zk, "", alaStatsItem);
                    }
                }
            }
        };
        this.aFP = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                p pVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.aFM != null) {
                        c.this.aFM.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).zh()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof p) && (pVar = (p) httpResponsedMessage.getOrginalMessage()) != null) {
                        c.this.a(pVar.liveId, pVar.roomId, pVar.azF, 0L, pVar.giftId, pVar.giftName, pVar.otherParams);
                        c.this.a(pVar);
                    }
                }
            }
        };
        this.aFN = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.aFO);
        MessageManager.getInstance().registerListener(this.aFP);
    }

    public void a(a aVar) {
        this.aFM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem("1395", "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, jVar.giftId);
            jSONObject.put("gfit_name", jVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, jVar.azE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt(jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem("1395", "click", "liveroom", "freegift_send");
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
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName)) {
            this.mIsSending = true;
            if (bVar.ym()) {
                j jVar = new j();
                jVar.azD = bVar.aDZ;
                jVar.giftId = bVar.aty;
                jVar.giftName = this.aFN.getPageActivity().getString(a.i.text_gift_graffiti);
                jVar.liveId = bVar.liveId;
                jVar.roomId = bVar.roomId;
                jVar.azF = bVar.azF;
                jVar.otherParams = bVar.otherParams;
                jVar.azG = bVar.azG;
                jVar.azH = bVar.azH;
                jVar.azI.putAll(bVar.aEb);
                jVar.azE = JavaTypesHelper.toLong(bVar.aDL != null ? bVar.aDL.getPrice() : "0", 0L) * bVar.aDZ;
                long j2 = jVar.azE;
                jVar.addParam("scene_from", bVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aty);
                jVar.addParam("benefit_username", bVar.userName);
                jVar.addParam("benefit_userid", bVar.userId);
                jVar.addParam("num", bVar.aDZ);
                jVar.addParam("ala_live_id", bVar.liveId);
                jVar.addParam("is_combo", bVar.aAm);
                jVar.addParam("tbs", bVar.aEa);
                if (bVar.aDL != null && bVar.aDL.ayY != null) {
                    jVar.addParam("gift_mul", bVar.aDL.ayY.wM());
                    jVar.addParam("attach_new", bVar.aDL.ayY.wL());
                }
                jVar.addParam("scene_from", q.Gk());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (bVar.wf()) {
                p pVar = new p();
                pVar.azD = bVar.aDZ;
                pVar.giftId = bVar.aty;
                pVar.giftName = bVar.mGiftName;
                pVar.liveId = bVar.liveId;
                pVar.roomId = bVar.roomId;
                pVar.azF = bVar.azF;
                pVar.otherParams = bVar.otherParams;
                pVar.azG = bVar.azG;
                pVar.azH = bVar.azH;
                pVar.azI.putAll(bVar.aEb);
                pVar.azE = JavaTypesHelper.toLong(bVar.aDL != null ? bVar.aDL.getPrice() : "0", 0L) * bVar.aDZ;
                long j3 = pVar.azE;
                pVar.addParam("scene_from", bVar.sceneFrom);
                pVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aty);
                pVar.addParam("benefit_username", bVar.userName);
                pVar.addParam("benefit_userid", bVar.userId);
                pVar.addParam("num", bVar.aDZ);
                pVar.addParam("ala_live_id", bVar.liveId);
                pVar.addParam("is_combo", bVar.aAm);
                pVar.addParam("tbs", bVar.aEa);
                pVar.addParam("scene_from", q.Gk());
                MessageManager.getInstance().sendMessage(pVar);
                j = j3;
            } else {
                j jVar2 = new j();
                jVar2.azD = bVar.aDZ;
                jVar2.giftId = bVar.aty;
                jVar2.giftName = bVar.mGiftName;
                jVar2.liveId = bVar.liveId;
                jVar2.roomId = bVar.roomId;
                jVar2.azF = bVar.azF;
                jVar2.otherParams = bVar.otherParams;
                jVar2.azG = bVar.azG;
                jVar2.azH = bVar.azH;
                jVar2.azI.putAll(bVar.aEb);
                jVar2.azE = JavaTypesHelper.toLong(bVar.aDL != null ? bVar.aDL.getPrice() : "0", 0L) * bVar.aDZ;
                long j4 = jVar2.azE;
                jVar2.addParam("scene_from", bVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aty);
                jVar2.addParam("benefit_username", bVar.userName);
                jVar2.addParam("benefit_userid", bVar.userId);
                jVar2.addParam("num", bVar.aDZ);
                jVar2.addParam("ala_live_id", bVar.liveId);
                jVar2.addParam("is_combo", bVar.aAm);
                jVar2.addParam("tbs", bVar.aEa);
                jVar2.addParam("scene_from", q.Gk());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.azF, bVar.aty, bVar.aty, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.aFO);
        MessageManager.getInstance().unRegisterListener(this.aFP);
    }
}
