package com.baidu.live.gift.c;

import android.location.Address;
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
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d.l;
import com.baidu.live.gift.i;
import com.baidu.live.gift.m;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.p;
import com.baidu.live.im.message.AlaLuckBagSendHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
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
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private a bgZ;
    private BdPageContext bha;
    private CustomMessageListener bhb;
    private HttpMessageListener bhc;
    private HttpMessageListener bhd;
    private HttpMessageListener bhe;
    public boolean mIsSending;
    private volatile long pkId;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.pkId = 0L;
        this.bhb = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.c.1
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
        this.bhc = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (c.this.bgZ != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                            i iVar = (i) httpResponsedMessage.getOrginalMessage();
                            if (b.JW().gX(iVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", iVar.giftId).param("obj_param1", iVar.aYv).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.JW().gV(iVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bgZ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Kl()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Km());
                        com.baidu.live.gift.a.a Kn = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).Kn();
                        if (Kn != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(c.this.bha.getPageActivity(), Kn.beo, Kn.bep, Kn.beq, Kn.ber)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    i iVar2 = null;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                        iVar2 = (i) httpResponsedMessage.getOrginalMessage();
                        c.this.a(iVar2.liveId, iVar2.roomId, iVar2.aYx, iVar2.aYw, iVar2.giftId, iVar2.giftName, iVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        try {
                            com.baidu.live.q.a.c(Long.parseLong(iVar2.liveId), 4);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        c.this.a(iVar2, httpResponsedMessage);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU_SUCC, iVar2.sceneFrom, iVar2.giftId, String.valueOf(iVar2.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                        z = true;
                    } else if (!(httpResponsedMessage.getOrginalMessage() instanceof i) || !(httpResponsedMessage instanceof AlaGiftSendHttpResponseMessage)) {
                        z = false;
                    } else {
                        long logId = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).getLogId();
                        i iVar3 = (i) httpResponsedMessage.getOrginalMessage();
                        AlaGiftSendHttpResponseMessage alaGiftSendHttpResponseMessage = (AlaGiftSendHttpResponseMessage) httpResponsedMessage;
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                        alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                        alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, iVar3.liveId);
                        alaStatsItem.addValue(LogConfig.LOG_ROOMID, iVar3.roomId);
                        alaStatsItem.addValue("giftid", iVar3.giftId);
                        alaStatsItem.addValue("giftcount", Long.valueOf(iVar3.aYv));
                        alaStatsItem.addValue("giftname", iVar3.giftName);
                        alaStatsItem.addValue("giftprice", Long.valueOf(iVar3.aYw));
                        alaStatsItem.addValue("other", iVar3.otherParams);
                        alaStatsItem.addValue("leftscores", Long.valueOf(alaGiftSendHttpResponseMessage.Kl()));
                        alaStatsItem.addValue("tdounum", Long.valueOf(alaGiftSendHttpResponseMessage.Km()));
                        AlaStatManager.getInstance().debug("gift_send_fail", logId, "", alaStatsItem);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU, iVar3.sceneFrom, iVar3.giftId, String.valueOf(iVar3.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                        iVar2 = iVar3;
                        z = false;
                    }
                    if (iVar2 != null && iVar2.aYC != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (z) {
                                jSONObject.put("status", 0);
                            } else {
                                jSONObject.put("status", 1);
                            }
                            jSONObject.put("message", "");
                            jSONObject.put("uniqueId", iVar2.aYC.getId());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        ExtraParamsManager.getInstance();
                        ExtraParamsManager.handleH5SendTagGiftResultCallback(jSONObject);
                    }
                }
            }
        };
        this.bhd = new HttpMessageListener(1021229) { // from class: com.baidu.live.gift.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z = true;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021229 && (httpResponsedMessage instanceof AlaLuckBagSendHttpResponseMessage)) {
                    c.this.mIsSending = false;
                    AlaLuckBagSendHttpResponseMessage alaLuckBagSendHttpResponseMessage = (AlaLuckBagSendHttpResponseMessage) httpResponsedMessage;
                    if (c.this.bgZ != null) {
                        c.this.bgZ.b(alaLuckBagSendHttpResponseMessage.getError(), alaLuckBagSendHttpResponseMessage.getErrorString(), 3, Long.valueOf(alaLuckBagSendHttpResponseMessage.Kl()), alaLuckBagSendHttpResponseMessage.Km());
                    }
                    m mVar = (m) httpResponsedMessage.getOrginalMessage();
                    if (alaLuckBagSendHttpResponseMessage.getError() == 0 && !alaLuckBagSendHttpResponseMessage.hasError() && (alaLuckBagSendHttpResponseMessage.getOrginalMessage() instanceof m)) {
                        e.a(alaLuckBagSendHttpResponseMessage, UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, UbcStatConstant.Value.VALUE_LUCKYBAG_SEND_SUCC, mVar.sceneFrom, mVar.giftId, String.valueOf(mVar.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    } else {
                        if (alaLuckBagSendHttpResponseMessage.getOrginalMessage() instanceof m) {
                            long logId = alaLuckBagSendHttpResponseMessage.getLogId();
                            AlaStatsItem alaStatsItem = new AlaStatsItem();
                            alaStatsItem.addValue("err", Integer.valueOf(alaLuckBagSendHttpResponseMessage.getError()));
                            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, alaLuckBagSendHttpResponseMessage.getErrorString());
                            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, mVar.liveId);
                            alaStatsItem.addValue(LogConfig.LOG_ROOMID, mVar.roomId);
                            alaStatsItem.addValue("giftid", mVar.giftId);
                            alaStatsItem.addValue("giftcount", Long.valueOf(mVar.aYv));
                            alaStatsItem.addValue("giftname", mVar.giftName);
                            alaStatsItem.addValue("giftprice", Long.valueOf(mVar.aYw));
                            alaStatsItem.addValue("other", mVar.otherParams);
                            alaStatsItem.addValue("leftscores", Long.valueOf(alaLuckBagSendHttpResponseMessage.Kl()));
                            alaStatsItem.addValue("tdounum", Long.valueOf(alaLuckBagSendHttpResponseMessage.Km()));
                            alaStatsItem.addValue("luckybagid", alaLuckBagSendHttpResponseMessage.Oa());
                            alaStatsItem.addValue("luckybagname", alaLuckBagSendHttpResponseMessage.NZ());
                            alaStatsItem.addValue("luckybagimage", alaLuckBagSendHttpResponseMessage.NY());
                            alaStatsItem.addValue("luckybagtotalvalue", Long.valueOf(alaLuckBagSendHttpResponseMessage.NX()));
                            alaStatsItem.addValue("luckybagprizelist", alaLuckBagSendHttpResponseMessage.NV());
                            alaStatsItem.addValue("luckybagsurpriselist", alaLuckBagSendHttpResponseMessage.NW());
                            AlaStatManager.getInstance().debug("luckybag_send_fail", logId, "", alaStatsItem);
                            e.a(alaLuckBagSendHttpResponseMessage, UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, UbcStatConstant.Value.VALUE_LUCKYBAG_SEND_FAIL, mVar.sceneFrom, mVar.giftId, String.valueOf(mVar.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                        }
                        z = false;
                    }
                    if (mVar != null && mVar.aYC != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (z) {
                                jSONObject.put("status", 0);
                            } else {
                                jSONObject.put("status", 1);
                            }
                            jSONObject.put("message", "");
                            jSONObject.put("uniqueId", mVar.aYC.getId());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ExtraParamsManager.getInstance();
                        ExtraParamsManager.handleH5SendTagGiftResultCallback(jSONObject);
                    }
                }
            }
        };
        this.bhe = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (c.this.bgZ != null) {
                        c.this.bgZ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Kk()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof p)) {
                        p pVar = (p) httpResponsedMessage.getOrginalMessage();
                        c.this.a(pVar.liveId, pVar.roomId, pVar.aYx, 0L, pVar.giftId, pVar.giftName, pVar.otherParams);
                        c.this.a(pVar);
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE_SUCC, pVar.sceneFrom, pVar.giftId, String.valueOf(pVar.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                        try {
                            com.baidu.live.q.a.c(Long.parseLong(pVar.liveId), 3);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof p) {
                        p pVar2 = (p) httpResponsedMessage.getOrginalMessage();
                        e.a(httpResponsedMessage, UbcStatisticLiveKey.KEY_ID_SEND_GIFT_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE, pVar2.sceneFrom, pVar2.giftId, String.valueOf(pVar2.aYv), String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum), true);
                    }
                }
            }
        };
        this.bha = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bhd);
        MessageManager.getInstance().registerListener(this.bhc);
        MessageManager.getInstance().registerListener(this.bhe);
        MessageManager.getInstance().registerListener(this.bhb);
    }

    public void a(a aVar) {
        this.bgZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, HttpResponsedMessage httpResponsedMessage) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "paygift_send");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, iVar.giftId);
            jSONObject.put("gfit_name", iVar.giftName);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, iVar.aYw);
            jSONObject.putOpt("gift_num", Long.valueOf(iVar.aYv));
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
        if (bVar != null && !StringUtils.isNull(bVar.userId) && this.bha != null && this.bha.getPageActivity() != null) {
            this.mIsSending = true;
            if (bVar.Jj()) {
                e.ax(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                i iVar = new i();
                iVar.aYv = bVar.bes;
                iVar.giftId = bVar.aPa;
                iVar.giftName = this.bha.getPageActivity().getString(a.h.text_gift_graffiti);
                iVar.liveId = bVar.liveId;
                iVar.roomId = bVar.roomId;
                iVar.aYx = bVar.aYx;
                iVar.otherParams = bVar.otherParams;
                iVar.aYy = bVar.aYy;
                iVar.aYz = bVar.aYz;
                iVar.aYA = String.valueOf(this.pkId);
                iVar.aYB.putAll(bVar.bev);
                iVar.aYw = JavaTypesHelper.toLong(bVar.bdZ != null ? bVar.bdZ.getPrice() : "0", 0L) * bVar.bes;
                long j2 = iVar.aYw;
                iVar.sceneFrom = bVar.sceneFrom;
                iVar.aYC = bVar.aYC;
                iVar.addParam("pk_id", this.pkId);
                iVar.addParam("scene_from", bVar.sceneFrom);
                iVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aPa);
                iVar.addParam("benefit_username", bVar.userName);
                iVar.addParam("benefit_userid", bVar.userId);
                iVar.addParam("num", bVar.bes);
                iVar.addParam("ala_live_id", bVar.liveId);
                iVar.addParam("is_combo", bVar.aZB);
                iVar.addParam("tbs", bVar.beu);
                if (bVar.bdZ != null && bVar.bdZ.aXM != null) {
                    iVar.addParam("gift_mul", bVar.bdZ.aXM.Hs());
                    iVar.addParam("attach_new", bVar.bdZ.aXM.Hr());
                }
                iVar.addParam("scene_from", q.XF());
                MessageManager.getInstance().sendMessage(iVar);
                j = j2;
            } else if (bVar.GZ()) {
                e.s(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, UbcStatConstant.Value.VALUE_LUCKYBAG_SEND_REQUEST);
                m mVar = new m();
                Address address = BdLocationMananger.getInstance().getAddress(false);
                if (address != null) {
                    mVar.b(address.getLongitude(), address.getLatitude());
                } else {
                    mVar.b(0.0d, 0.0d);
                }
                mVar.aYv = bVar.bes;
                mVar.giftId = bVar.aPa;
                mVar.giftName = bVar.mGiftName;
                mVar.liveId = bVar.liveId;
                mVar.roomId = bVar.roomId;
                mVar.aYx = bVar.aYx;
                mVar.otherParams = bVar.otherParams;
                mVar.aYy = bVar.aYy;
                mVar.userId = bVar.userId;
                mVar.userName = bVar.userName;
                mVar.aYA = String.valueOf(this.pkId);
                mVar.aYB.putAll(bVar.bev);
                mVar.aYw = JavaTypesHelper.toLong(bVar.bdZ != null ? bVar.bdZ.getPrice() : "0", 0L) * bVar.bes;
                long j3 = mVar.aYw;
                mVar.sceneFrom = bVar.sceneFrom;
                mVar.aYC = bVar.aYC;
                mVar.addParam("pk_id", this.pkId);
                mVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aPa);
                mVar.addParam("benefit_username", bVar.userName);
                mVar.addParam("benefit_userid", bVar.userId);
                mVar.addParam("num", bVar.bes);
                mVar.addParam("live_id", bVar.liveId);
                mVar.addParam("is_combo", bVar.aZB);
                mVar.addParam("tbs", bVar.beu);
                mVar.addParam("scene_from", q.Ia());
                MessageManager.getInstance().sendMessage(mVar);
                j = j3;
            } else if (bVar.GJ()) {
                e.ax(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_FREE);
                p pVar = new p();
                pVar.aYv = bVar.bes;
                pVar.giftId = bVar.aPa;
                pVar.giftName = bVar.mGiftName;
                pVar.liveId = bVar.liveId;
                pVar.roomId = bVar.roomId;
                pVar.aYx = bVar.aYx;
                pVar.otherParams = bVar.otherParams;
                pVar.aYy = bVar.aYy;
                pVar.aYz = bVar.aYz;
                pVar.aYB.putAll(bVar.bev);
                pVar.aYw = JavaTypesHelper.toLong(bVar.bdZ != null ? bVar.bdZ.getPrice() : "0", 0L) * bVar.bes;
                long j4 = pVar.aYw;
                pVar.sceneFrom = bVar.sceneFrom;
                pVar.aYC = bVar.aYC;
                pVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aPa);
                pVar.addParam("benefit_username", bVar.userName);
                pVar.addParam("benefit_userid", bVar.userId);
                pVar.addParam("num", bVar.bes);
                pVar.addParam("ala_live_id", bVar.liveId);
                pVar.addParam("is_combo", bVar.aZB);
                pVar.addParam("live_id", bVar.liveId);
                pVar.addParam("tbs", bVar.beu);
                pVar.addParam("scene_from", q.XF());
                MessageManager.getInstance().sendMessage(pVar);
                j = j4;
            } else {
                e.ax(UbcStatisticLiveKey.KEY_ID_SEND_GIFT_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_SEND_TDOU);
                i iVar2 = new i();
                iVar2.aYv = bVar.bes;
                iVar2.giftId = bVar.aPa;
                iVar2.giftName = bVar.mGiftName;
                iVar2.liveId = bVar.liveId;
                iVar2.roomId = bVar.roomId;
                iVar2.aYx = bVar.aYx;
                iVar2.otherParams = bVar.otherParams;
                iVar2.aYy = bVar.aYy;
                iVar2.aYz = bVar.aYz;
                iVar2.aYB.putAll(bVar.bev);
                iVar2.aYw = JavaTypesHelper.toLong(bVar.bdZ != null ? bVar.bdZ.getPrice() : "0", 0L) * bVar.bes;
                long j5 = iVar2.aYw;
                iVar2.sceneFrom = bVar.sceneFrom;
                iVar2.aYC = bVar.aYC;
                iVar2.addParam("pk_id", this.pkId);
                iVar2.addParam("scene_from", bVar.sceneFrom);
                iVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aPa);
                iVar2.addParam("benefit_username", bVar.userName);
                iVar2.addParam("benefit_userid", bVar.userId);
                iVar2.addParam("num", bVar.bes);
                iVar2.addParam("ala_live_id", bVar.liveId);
                iVar2.addParam("is_combo", bVar.aZB);
                iVar2.addParam("tbs", bVar.beu);
                iVar2.addParam("scene_from", q.XF());
                MessageManager.getInstance().sendMessage(iVar2);
                j = j5;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aYx, bVar.aPa, bVar.aPa, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bhd);
        MessageManager.getInstance().unRegisterListener(this.bhc);
        MessageManager.getInstance().unRegisterListener(this.bhe);
        MessageManager.getInstance().unRegisterListener(this.bhb);
    }
}
