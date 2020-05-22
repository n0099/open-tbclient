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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends BdBaseModel {
    private a aLu;
    private BdPageContext aLv;
    private HttpMessageListener aLw;
    private HttpMessageListener aLx;
    public boolean mIsSending;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.aLw = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.aLu != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                            j jVar = (j) httpResponsedMessage.getOrginalMessage();
                            if (b.Ah().eL(jVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.aEV).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.Ah().eJ(jVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.aLu.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Ax()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Ay());
                        com.baidu.live.gift.a.a Az = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Az();
                        if (Az != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new h(c.this.aLv.getPageActivity(), Az.aJu, Az.aJv, Az.aJw, Az.aJx)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                        c.this.a(jVar2.liveId, jVar2.roomId, jVar2.aEX, jVar2.aEW, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        c.this.a(jVar2);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU_SUCC, jVar2.sceneFrom, jVar2.giftId, String.valueOf(jVar2.aEV), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
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
                        alaStatsItem.addValue("giftcount", Long.valueOf(jVar3.aEV));
                        alaStatsItem.addValue("giftname", jVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(jVar3.aEW));
                        alaStatsItem.addValue("other", jVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.Ax()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.Ay()));
                        AlaStatManager.getInstance().debug("gift_send_fail", logId, "", alaStatsItem);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU, jVar3.sceneFrom, jVar3.giftId, String.valueOf(jVar3.aEV), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aLx = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.aLu != null) {
                        c.this.aLu.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Aw()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof p)) {
                        p pVar = (p) httpResponsedMessage.getOrginalMessage();
                        c.this.a(pVar.liveId, pVar.roomId, pVar.aEX, 0L, pVar.giftId, pVar.giftName, pVar.otherParams);
                        c.this.a(pVar);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE_SUCC, pVar.sceneFrom, pVar.giftId, String.valueOf(pVar.aEV), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof p) {
                        p pVar2 = (p) httpResponsedMessage.getOrginalMessage();
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE, pVar2.sceneFrom, pVar2.giftId, String.valueOf(pVar2.aEV), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aLv = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.aLw);
        MessageManager.getInstance().registerListener(this.aLx);
    }

    public void a(a aVar) {
        this.aLu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, jVar.giftId);
            jSONObject.put("gfit_name", jVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, jVar.aEW);
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
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName) && this.aLv != null && this.aLv.getPageActivity() != null) {
            this.mIsSending = true;
            if (bVar.zC()) {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar = new j();
                jVar.aEV = bVar.aJy;
                jVar.giftId = bVar.ayw;
                jVar.giftName = this.aLv.getPageActivity().getString(a.i.text_gift_graffiti);
                jVar.liveId = bVar.liveId;
                jVar.roomId = bVar.roomId;
                jVar.aEX = bVar.aEX;
                jVar.otherParams = bVar.otherParams;
                jVar.aEY = bVar.aEY;
                jVar.aEZ = bVar.aEZ;
                jVar.aFa.putAll(bVar.aJA);
                jVar.aEW = JavaTypesHelper.toLong(bVar.aJk != null ? bVar.aJk.getPrice() : "0", 0L) * bVar.aJy;
                long j2 = jVar.aEW;
                jVar.sceneFrom = bVar.sceneFrom;
                jVar.addParam("scene_from", bVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, bVar.ayw);
                jVar.addParam("benefit_username", bVar.userName);
                jVar.addParam("benefit_userid", bVar.userId);
                jVar.addParam("num", bVar.aJy);
                jVar.addParam("ala_live_id", bVar.liveId);
                jVar.addParam("is_combo", bVar.aFF);
                jVar.addParam("tbs", bVar.aJz);
                if (bVar.aJk != null && bVar.aJk.aEq != null) {
                    jVar.addParam("gift_mul", bVar.aJk.aEq.yd());
                    jVar.addParam("attach_new", bVar.aJk.aEq.yc());
                }
                jVar.addParam("scene_from", q.Id());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (bVar.xw()) {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE);
                p pVar = new p();
                pVar.aEV = bVar.aJy;
                pVar.giftId = bVar.ayw;
                pVar.giftName = bVar.mGiftName;
                pVar.liveId = bVar.liveId;
                pVar.roomId = bVar.roomId;
                pVar.aEX = bVar.aEX;
                pVar.otherParams = bVar.otherParams;
                pVar.aEY = bVar.aEY;
                pVar.aEZ = bVar.aEZ;
                pVar.aFa.putAll(bVar.aJA);
                pVar.aEW = JavaTypesHelper.toLong(bVar.aJk != null ? bVar.aJk.getPrice() : "0", 0L) * bVar.aJy;
                long j3 = pVar.aEW;
                pVar.sceneFrom = bVar.sceneFrom;
                pVar.addParam("scene_from", bVar.sceneFrom);
                pVar.addParam(LogConfig.LOG_GIFT_ID, bVar.ayw);
                pVar.addParam("benefit_username", bVar.userName);
                pVar.addParam("benefit_userid", bVar.userId);
                pVar.addParam("num", bVar.aJy);
                pVar.addParam("ala_live_id", bVar.liveId);
                pVar.addParam("is_combo", bVar.aFF);
                pVar.addParam("tbs", bVar.aJz);
                pVar.addParam("scene_from", q.Id());
                MessageManager.getInstance().sendMessage(pVar);
                j = j3;
            } else {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar2 = new j();
                jVar2.aEV = bVar.aJy;
                jVar2.giftId = bVar.ayw;
                jVar2.giftName = bVar.mGiftName;
                jVar2.liveId = bVar.liveId;
                jVar2.roomId = bVar.roomId;
                jVar2.aEX = bVar.aEX;
                jVar2.otherParams = bVar.otherParams;
                jVar2.aEY = bVar.aEY;
                jVar2.aEZ = bVar.aEZ;
                jVar2.aFa.putAll(bVar.aJA);
                jVar2.aEW = JavaTypesHelper.toLong(bVar.aJk != null ? bVar.aJk.getPrice() : "0", 0L) * bVar.aJy;
                long j4 = jVar2.aEW;
                jVar2.sceneFrom = bVar.sceneFrom;
                jVar2.addParam("scene_from", bVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.ayw);
                jVar2.addParam("benefit_username", bVar.userName);
                jVar2.addParam("benefit_userid", bVar.userId);
                jVar2.addParam("num", bVar.aJy);
                jVar2.addParam("ala_live_id", bVar.liveId);
                jVar2.addParam("is_combo", bVar.aFF);
                jVar2.addParam("tbs", bVar.aJz);
                jVar2.addParam("scene_from", q.Id());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aEX, bVar.ayw, bVar.ayw, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.aLw);
        MessageManager.getInstance().unRegisterListener(this.aLx);
    }
}
