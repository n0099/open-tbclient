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
import com.baidu.live.d.ad;
import com.baidu.live.gift.an;
import com.baidu.live.gift.ao;
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
    private a bUD;
    private BdPageContext bfr;
    private HttpMessageListener bft;
    private HttpMessageListener bfv;
    public boolean mIsSending;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bft = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bUD != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                            an anVar = (an) httpResponsedMessage.getOrginalMessage();
                            if (b.Zu().hm(anVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", anVar.giftId).param("obj_param1", anVar.aWP).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.Zu().hk(anVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bUD.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).KK()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).KL());
                        com.baidu.live.yuyingift.a.a Zv = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Zv();
                        if (Zv != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ad(c.this.bfr.getPageActivity(), Zv.bcF, Zv.bcG, Zv.bcH, Zv.bcI)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                        an anVar2 = (an) httpResponsedMessage.getOrginalMessage();
                        c.this.a(anVar2.liveId, anVar2.roomId, anVar2.aWR, anVar2.aWQ, anVar2.giftId, anVar2.giftName, anVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(anVar2);
                    }
                }
            }
        };
        this.bfv = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bUD != null) {
                        c.this.bUD.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).KJ()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof ao)) {
                        ao aoVar = (ao) httpResponsedMessage.getOrginalMessage();
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof ao) {
                        ao aoVar2 = (ao) httpResponsedMessage.getOrginalMessage();
                    }
                }
            }
        };
        this.bfr = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bft);
        MessageManager.getInstance().registerListener(this.bfv);
    }

    public void a(a aVar) {
        this.bUD = aVar;
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
            if (bVar.JH()) {
                an anVar = new an();
                anVar.aWP = bVar.bcJ;
                anVar.giftId = bVar.aOt;
                anVar.giftName = "手绘礼物";
                anVar.liveId = bVar.liveId;
                anVar.roomId = bVar.roomId;
                anVar.aWR = bVar.aWR;
                anVar.otherParams = bVar.otherParams;
                anVar.aWS = bVar.aWS;
                anVar.aWT = bVar.aWT;
                anVar.aWV.putAll(bVar.bcL);
                anVar.aWQ = JavaTypesHelper.toLong(bVar.bcr != null ? bVar.bcr.getPrice() : "0", 0L) * bVar.bcJ;
                long j2 = anVar.aWQ;
                anVar.sceneFrom = bVar.sceneFrom;
                anVar.aYl = bVar.bnb;
                anVar.addParam("scene_from", s.WB());
                anVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aOt);
                anVar.addParam("benefit_username", bVar.userName);
                anVar.addParam("benefit_userid", bVar.userId);
                anVar.addParam("num", bVar.bcJ);
                anVar.addParam("ala_live_id", bVar.liveId);
                anVar.addParam("is_combo", bVar.aXW);
                anVar.addParam("benefit_info", r.jg(bVar.bnb));
                if (bVar.bcr != null && bVar.bcr.aWg != null) {
                    anVar.addParam("gift_mul", bVar.bcr.aWg.HR());
                    anVar.addParam("attach_new", bVar.bcr.aWg.HQ());
                }
                MessageManager.getInstance().sendMessage(anVar);
                j = j2;
            } else if (bVar.Hi()) {
                ao aoVar = new ao();
                aoVar.aWP = bVar.bcJ;
                aoVar.giftId = bVar.aOt;
                aoVar.giftName = bVar.mGiftName;
                aoVar.liveId = bVar.liveId;
                aoVar.roomId = bVar.roomId;
                aoVar.aWR = bVar.aWR;
                aoVar.otherParams = bVar.otherParams;
                aoVar.aWS = bVar.aWS;
                aoVar.aWT = bVar.aWT;
                aoVar.aWV.putAll(bVar.bcL);
                aoVar.aWQ = JavaTypesHelper.toLong(bVar.bcr != null ? bVar.bcr.getPrice() : "0", 0L) * bVar.bcJ;
                long j3 = aoVar.aWQ;
                aoVar.sceneFrom = bVar.sceneFrom;
                aoVar.aYl = bVar.bnb;
                aoVar.addParam("scene_from", s.WB());
                aoVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aOt);
                aoVar.addParam("benefit_username", bVar.userName);
                aoVar.addParam("benefit_userid", bVar.userId);
                aoVar.addParam("num", bVar.bcJ);
                aoVar.addParam("ala_live_id", bVar.liveId);
                aoVar.addParam("is_combo", bVar.aXW);
                aoVar.addParam("tbs", bVar.bcK);
                aoVar.addParam("benefit_info", r.jg(bVar.bnb));
                MessageManager.getInstance().sendMessage(aoVar);
                j = j3;
            } else {
                an anVar2 = new an();
                anVar2.aWP = bVar.bcJ;
                anVar2.giftId = bVar.aOt;
                anVar2.giftName = bVar.mGiftName;
                anVar2.liveId = bVar.liveId;
                anVar2.roomId = bVar.roomId;
                anVar2.aWR = bVar.aWR;
                anVar2.otherParams = bVar.otherParams;
                anVar2.aWS = bVar.aWS;
                anVar2.aWT = bVar.aWT;
                anVar2.aWV.putAll(bVar.bcL);
                anVar2.aWQ = JavaTypesHelper.toLong(bVar.bcr != null ? bVar.bcr.getPrice() : "0", 0L) * bVar.bcJ;
                long j4 = anVar2.aWQ;
                anVar2.aYl = bVar.bnb;
                anVar2.sceneFrom = bVar.sceneFrom;
                anVar2.addParam("scene_from", s.WB());
                anVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aOt);
                anVar2.addParam("benefit_username", bVar.userName);
                anVar2.addParam("benefit_userid", bVar.userId);
                anVar2.addParam("num", bVar.bcJ);
                anVar2.addParam("ala_live_id", bVar.liveId);
                anVar2.addParam("is_combo", bVar.aXW);
                anVar2.addParam("tbs", bVar.bcK);
                anVar2.addParam("benefit_info", r.jg(bVar.bnb));
                MessageManager.getInstance().sendMessage(anVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aWR, bVar.aOt, bVar.aOt, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bft);
        MessageManager.getInstance().unRegisterListener(this.bfv);
    }
}
