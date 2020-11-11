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
    private a bRd;
    private BdPageContext bdd;
    private HttpMessageListener bdf;
    private HttpMessageListener bdg;
    public boolean mIsSending;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bdf = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bRd != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof al)) {
                            al alVar = (al) httpResponsedMessage.getOrginalMessage();
                            if (b.XE().gX(alVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", alVar.giftId).param("obj_param1", alVar.aVw).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.XE().gV(alVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bRd.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Jt()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Ju());
                        com.baidu.live.yuyingift.a.a XF = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).XF();
                        if (XF != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ac(c.this.bdd.getPageActivity(), XF.baU, XF.baV, XF.baW, XF.baX)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof al)) {
                        al alVar2 = (al) httpResponsedMessage.getOrginalMessage();
                        c.this.a(alVar2.liveId, alVar2.roomId, alVar2.aVy, alVar2.aVx, alVar2.giftId, alVar2.giftName, alVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(alVar2);
                    }
                }
            }
        };
        this.bdg = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bRd != null) {
                        c.this.bRd.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Js()), 0L);
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
        this.bdd = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bdf);
        MessageManager.getInstance().registerListener(this.bdg);
    }

    public void a(a aVar) {
        this.bRd = aVar;
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
            if (bVar.Iz()) {
                al alVar = new al();
                alVar.aVw = bVar.baY;
                alVar.giftId = bVar.aNj;
                alVar.giftName = "手绘礼物";
                alVar.liveId = bVar.liveId;
                alVar.roomId = bVar.roomId;
                alVar.aVy = bVar.aVy;
                alVar.otherParams = bVar.otherParams;
                alVar.aVz = bVar.aVz;
                alVar.aVA = bVar.aVA;
                alVar.aVC.putAll(bVar.bba);
                alVar.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j2 = alVar.aVx;
                alVar.sceneFrom = bVar.sceneFrom;
                alVar.aWL = bVar.bku;
                alVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.UK() : bVar.sceneFrom);
                alVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                alVar.addParam("benefit_username", bVar.userName);
                alVar.addParam("benefit_userid", bVar.userId);
                alVar.addParam("num", bVar.baY);
                alVar.addParam("ala_live_id", bVar.liveId);
                alVar.addParam("is_combo", bVar.aWA);
                alVar.addParam("benefit_info", r.iI(bVar.bku));
                if (bVar.baH != null && bVar.baH.aUN != null) {
                    alVar.addParam("gift_mul", bVar.baH.aUN.GL());
                    alVar.addParam("attach_new", bVar.baH.aUN.GK());
                }
                MessageManager.getInstance().sendMessage(alVar);
                j = j2;
            } else if (bVar.Gd()) {
                am amVar = new am();
                amVar.aVw = bVar.baY;
                amVar.giftId = bVar.aNj;
                amVar.giftName = bVar.mGiftName;
                amVar.liveId = bVar.liveId;
                amVar.roomId = bVar.roomId;
                amVar.aVy = bVar.aVy;
                amVar.otherParams = bVar.otherParams;
                amVar.aVz = bVar.aVz;
                amVar.aVA = bVar.aVA;
                amVar.aVC.putAll(bVar.bba);
                amVar.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j3 = amVar.aVx;
                amVar.sceneFrom = bVar.sceneFrom;
                amVar.aWL = bVar.bku;
                amVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.UK() : bVar.sceneFrom);
                amVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                amVar.addParam("benefit_username", bVar.userName);
                amVar.addParam("benefit_userid", bVar.userId);
                amVar.addParam("num", bVar.baY);
                amVar.addParam("ala_live_id", bVar.liveId);
                amVar.addParam("is_combo", bVar.aWA);
                amVar.addParam("tbs", bVar.baZ);
                amVar.addParam("benefit_info", r.iI(bVar.bku));
                MessageManager.getInstance().sendMessage(amVar);
                j = j3;
            } else {
                al alVar2 = new al();
                alVar2.aVw = bVar.baY;
                alVar2.giftId = bVar.aNj;
                alVar2.giftName = bVar.mGiftName;
                alVar2.liveId = bVar.liveId;
                alVar2.roomId = bVar.roomId;
                alVar2.aVy = bVar.aVy;
                alVar2.otherParams = bVar.otherParams;
                alVar2.aVz = bVar.aVz;
                alVar2.aVA = bVar.aVA;
                alVar2.aVC.putAll(bVar.bba);
                alVar2.aVx = JavaTypesHelper.toLong(bVar.baH != null ? bVar.baH.getPrice() : "0", 0L) * bVar.baY;
                long j4 = alVar2.aVx;
                alVar2.aWL = bVar.bku;
                alVar2.sceneFrom = bVar.sceneFrom;
                alVar2.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.UK() : bVar.sceneFrom);
                alVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aNj);
                alVar2.addParam("benefit_username", bVar.userName);
                alVar2.addParam("benefit_userid", bVar.userId);
                alVar2.addParam("num", bVar.baY);
                alVar2.addParam("ala_live_id", bVar.liveId);
                alVar2.addParam("is_combo", bVar.aWA);
                alVar2.addParam("tbs", bVar.baZ);
                alVar2.addParam("benefit_info", r.iI(bVar.bku));
                MessageManager.getInstance().sendMessage(alVar2);
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
    }
}
