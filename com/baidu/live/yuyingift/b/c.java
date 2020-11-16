package com.baidu.live.yuyingift.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.ac;
import com.baidu.live.gift.al;
import com.baidu.live.gift.am;
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
import com.baidu.live.utils.r;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.message.YuyinAlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.yuyingift.message.YuyinAlaGiftSendHttpResponseMessage;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private a bPt;
    private BdPageContext bbs;
    private HttpMessageListener bbu;
    private HttpMessageListener bbv;
    public boolean mIsSending;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bbu = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bPt != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof al)) {
                            al alVar = (al) httpResponsedMessage.getOrginalMessage();
                            if (b.WV().gR(alVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", alVar.giftId).param("obj_param1", alVar.aTL).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.WV().gP(alVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bPt.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).IK()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).IL());
                        com.baidu.live.yuyingift.a.a WW = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).WW();
                        if (WW != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ac(c.this.bbs.getPageActivity(), WW.aZi, WW.aZj, WW.aZk, WW.aZl)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof al)) {
                        al alVar2 = (al) httpResponsedMessage.getOrginalMessage();
                        c.this.a(alVar2.liveId, alVar2.roomId, alVar2.aTN, alVar2.aTM, alVar2.giftId, alVar2.giftName, alVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(alVar2);
                    }
                }
            }
        };
        this.bbv = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bPt != null) {
                        c.this.bPt.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).IJ()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof am)) {
                        am amVar = (am) httpResponsedMessage.getOrginalMessage();
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof am) {
                        am amVar2 = (am) httpResponsedMessage.getOrginalMessage();
                    }
                }
            }
        };
        this.bbs = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bbu);
        MessageManager.getInstance().registerListener(this.bbv);
    }

    public void a(a aVar) {
        this.bPt = aVar;
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

    public void a(com.baidu.live.yuyingift.a.b bVar) {
        long j;
        if (StringUtils.isNull(bVar.userId) || StringUtils.isNull(bVar.userName)) {
            bVar.userId = TbadkCoreApplication.getCurrentAccountId() + "";
            bVar.userName = TbadkCoreApplication.getCurrentAccountName();
        }
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName)) {
            this.mIsSending = true;
            if (bVar.HQ()) {
                al alVar = new al();
                alVar.aTL = bVar.aZm;
                alVar.giftId = bVar.aLy;
                alVar.giftName = "手绘礼物";
                alVar.liveId = bVar.liveId;
                alVar.roomId = bVar.roomId;
                alVar.aTN = bVar.aTN;
                alVar.otherParams = bVar.otherParams;
                alVar.aTO = bVar.aTO;
                alVar.aTP = bVar.aTP;
                alVar.aTR.putAll(bVar.aZo);
                alVar.aTM = JavaTypesHelper.toLong(bVar.aYV != null ? bVar.aYV.getPrice() : "0", 0L) * bVar.aZm;
                long j2 = alVar.aTM;
                alVar.sceneFrom = bVar.sceneFrom;
                alVar.aVa = bVar.biJ;
                alVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Ub() : bVar.sceneFrom);
                alVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aLy);
                alVar.addParam("benefit_username", bVar.userName);
                alVar.addParam("benefit_userid", bVar.userId);
                alVar.addParam("num", bVar.aZm);
                alVar.addParam("ala_live_id", bVar.liveId);
                alVar.addParam("is_combo", bVar.aUP);
                alVar.addParam("benefit_info", r.iC(bVar.biJ));
                if (bVar.aYV != null && bVar.aYV.aTc != null) {
                    alVar.addParam("gift_mul", bVar.aYV.aTc.Gc());
                    alVar.addParam("attach_new", bVar.aYV.aTc.Gb());
                }
                MessageManager.getInstance().sendMessage(alVar);
                j = j2;
            } else if (bVar.Fu()) {
                am amVar = new am();
                amVar.aTL = bVar.aZm;
                amVar.giftId = bVar.aLy;
                amVar.giftName = bVar.mGiftName;
                amVar.liveId = bVar.liveId;
                amVar.roomId = bVar.roomId;
                amVar.aTN = bVar.aTN;
                amVar.otherParams = bVar.otherParams;
                amVar.aTO = bVar.aTO;
                amVar.aTP = bVar.aTP;
                amVar.aTR.putAll(bVar.aZo);
                amVar.aTM = JavaTypesHelper.toLong(bVar.aYV != null ? bVar.aYV.getPrice() : "0", 0L) * bVar.aZm;
                long j3 = amVar.aTM;
                amVar.sceneFrom = bVar.sceneFrom;
                amVar.aVa = bVar.biJ;
                amVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Ub() : bVar.sceneFrom);
                amVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aLy);
                amVar.addParam("benefit_username", bVar.userName);
                amVar.addParam("benefit_userid", bVar.userId);
                amVar.addParam("num", bVar.aZm);
                amVar.addParam("ala_live_id", bVar.liveId);
                amVar.addParam("is_combo", bVar.aUP);
                amVar.addParam("tbs", bVar.aZn);
                amVar.addParam("benefit_info", r.iC(bVar.biJ));
                MessageManager.getInstance().sendMessage(amVar);
                j = j3;
            } else {
                al alVar2 = new al();
                alVar2.aTL = bVar.aZm;
                alVar2.giftId = bVar.aLy;
                alVar2.giftName = bVar.mGiftName;
                alVar2.liveId = bVar.liveId;
                alVar2.roomId = bVar.roomId;
                alVar2.aTN = bVar.aTN;
                alVar2.otherParams = bVar.otherParams;
                alVar2.aTO = bVar.aTO;
                alVar2.aTP = bVar.aTP;
                alVar2.aTR.putAll(bVar.aZo);
                alVar2.aTM = JavaTypesHelper.toLong(bVar.aYV != null ? bVar.aYV.getPrice() : "0", 0L) * bVar.aZm;
                long j4 = alVar2.aTM;
                alVar2.aVa = bVar.biJ;
                alVar2.sceneFrom = bVar.sceneFrom;
                alVar2.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Ub() : bVar.sceneFrom);
                alVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aLy);
                alVar2.addParam("benefit_username", bVar.userName);
                alVar2.addParam("benefit_userid", bVar.userId);
                alVar2.addParam("num", bVar.aZm);
                alVar2.addParam("ala_live_id", bVar.liveId);
                alVar2.addParam("is_combo", bVar.aUP);
                alVar2.addParam("tbs", bVar.aZn);
                alVar2.addParam("benefit_info", r.iC(bVar.biJ));
                MessageManager.getInstance().sendMessage(alVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aTN, bVar.aLy, bVar.aLy, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bbu);
        MessageManager.getInstance().unRegisterListener(this.bbv);
    }
}
