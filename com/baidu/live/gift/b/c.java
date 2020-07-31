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
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private a aPv;
    private BdPageContext aPw;
    private HttpMessageListener aPx;
    private HttpMessageListener aPy;
    public boolean mIsSending;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.aPx = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.aPv != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                            j jVar = (j) httpResponsedMessage.getOrginalMessage();
                            if (b.Bj().eQ(jVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.aIM).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.Bj().eO(jVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.aPv.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Bz()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).BA());
                        com.baidu.live.gift.a.a BB = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).BB();
                        if (BB != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.j(c.this.aPw.getPageActivity(), BB.aNv, BB.aNw, BB.aNx, BB.aNy)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                        c.this.a(jVar2.liveId, jVar2.roomId, jVar2.aIO, jVar2.aIN, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        c.this.a(jVar2);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU_SUCC, jVar2.sceneFrom, jVar2.giftId, String.valueOf(jVar2.aIM), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
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
                        alaStatsItem.addValue("giftcount", Long.valueOf(jVar3.aIM));
                        alaStatsItem.addValue("giftname", jVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(jVar3.aIN));
                        alaStatsItem.addValue("other", jVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.Bz()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.BA()));
                        AlaStatManager.getInstance().debug("gift_send_fail", logId, "", alaStatsItem);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU, jVar3.sceneFrom, jVar3.giftId, String.valueOf(jVar3.aIM), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aPy = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.aPv != null) {
                        c.this.aPv.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).By()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof p)) {
                        p pVar = (p) httpResponsedMessage.getOrginalMessage();
                        c.this.a(pVar.liveId, pVar.roomId, pVar.aIO, 0L, pVar.giftId, pVar.giftName, pVar.otherParams);
                        c.this.a(pVar);
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE_SUCC, pVar.sceneFrom, pVar.giftId, String.valueOf(pVar.aIM), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof p) {
                        p pVar2 = (p) httpResponsedMessage.getOrginalMessage();
                        d.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE, pVar2.sceneFrom, pVar2.giftId, String.valueOf(pVar2.aIM), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.aPw = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.aPx);
        MessageManager.getInstance().registerListener(this.aPy);
    }

    public void a(a aVar) {
        this.aPv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, jVar.giftId);
            jSONObject.put("gfit_name", jVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, jVar.aIN);
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
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName) && this.aPw != null && this.aPw.getPageActivity() != null) {
            this.mIsSending = true;
            if (bVar.AE()) {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar = new j();
                jVar.aIM = bVar.aNz;
                jVar.giftId = bVar.aBY;
                jVar.giftName = this.aPw.getPageActivity().getString(a.i.text_gift_graffiti);
                jVar.liveId = bVar.liveId;
                jVar.roomId = bVar.roomId;
                jVar.aIO = bVar.aIO;
                jVar.otherParams = bVar.otherParams;
                jVar.aIP = bVar.aIP;
                jVar.aIQ = bVar.aIQ;
                jVar.aIR.putAll(bVar.aNB);
                jVar.aIN = JavaTypesHelper.toLong(bVar.aNm != null ? bVar.aNm.getPrice() : "0", 0L) * bVar.aNz;
                long j2 = jVar.aIN;
                jVar.sceneFrom = bVar.sceneFrom;
                jVar.addParam("scene_from", bVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aBY);
                jVar.addParam("benefit_username", bVar.userName);
                jVar.addParam("benefit_userid", bVar.userId);
                jVar.addParam("num", bVar.aNz);
                jVar.addParam("ala_live_id", bVar.liveId);
                jVar.addParam("is_combo", bVar.aJy);
                jVar.addParam("tbs", bVar.aNA);
                if (bVar.aNm != null && bVar.aNm.aIh != null) {
                    jVar.addParam("gift_mul", bVar.aNm.aIh.zf());
                    jVar.addParam("attach_new", bVar.aNm.aIh.ze());
                }
                jVar.addParam("scene_from", com.baidu.live.utils.p.Jx());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (bVar.yy()) {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE);
                p pVar = new p();
                pVar.aIM = bVar.aNz;
                pVar.giftId = bVar.aBY;
                pVar.giftName = bVar.mGiftName;
                pVar.liveId = bVar.liveId;
                pVar.roomId = bVar.roomId;
                pVar.aIO = bVar.aIO;
                pVar.otherParams = bVar.otherParams;
                pVar.aIP = bVar.aIP;
                pVar.aIQ = bVar.aIQ;
                pVar.aIR.putAll(bVar.aNB);
                pVar.aIN = JavaTypesHelper.toLong(bVar.aNm != null ? bVar.aNm.getPrice() : "0", 0L) * bVar.aNz;
                long j3 = pVar.aIN;
                pVar.sceneFrom = bVar.sceneFrom;
                pVar.addParam("scene_from", bVar.sceneFrom);
                pVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aBY);
                pVar.addParam("benefit_username", bVar.userName);
                pVar.addParam("benefit_userid", bVar.userId);
                pVar.addParam("num", bVar.aNz);
                pVar.addParam("ala_live_id", bVar.liveId);
                pVar.addParam("is_combo", bVar.aJy);
                pVar.addParam("tbs", bVar.aNA);
                pVar.addParam("scene_from", com.baidu.live.utils.p.Jx());
                MessageManager.getInstance().sendMessage(pVar);
                j = j3;
            } else {
                d.ao(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                j jVar2 = new j();
                jVar2.aIM = bVar.aNz;
                jVar2.giftId = bVar.aBY;
                jVar2.giftName = bVar.mGiftName;
                jVar2.liveId = bVar.liveId;
                jVar2.roomId = bVar.roomId;
                jVar2.aIO = bVar.aIO;
                jVar2.otherParams = bVar.otherParams;
                jVar2.aIP = bVar.aIP;
                jVar2.aIQ = bVar.aIQ;
                jVar2.aIR.putAll(bVar.aNB);
                jVar2.aIN = JavaTypesHelper.toLong(bVar.aNm != null ? bVar.aNm.getPrice() : "0", 0L) * bVar.aNz;
                long j4 = jVar2.aIN;
                jVar2.sceneFrom = bVar.sceneFrom;
                jVar2.addParam("scene_from", bVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aBY);
                jVar2.addParam("benefit_username", bVar.userName);
                jVar2.addParam("benefit_userid", bVar.userId);
                jVar2.addParam("num", bVar.aNz);
                jVar2.addParam("ala_live_id", bVar.liveId);
                jVar2.addParam("is_combo", bVar.aJy);
                jVar2.addParam("tbs", bVar.aNA);
                jVar2.addParam("scene_from", com.baidu.live.utils.p.Jx());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aIO, bVar.aBY, bVar.aBY, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.aPx);
        MessageManager.getInstance().unRegisterListener(this.aPy);
    }
}
