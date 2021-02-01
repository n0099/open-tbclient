package com.baidu.live.yuyingift.c;

import android.text.TextUtils;
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
import com.baidu.live.gift.ap;
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
import com.baidu.live.utils.s;
import com.baidu.live.utils.t;
import com.baidu.live.yuyingift.message.YuyinAlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.yuyingift.message.YuyinAlaGiftSendHttpResponseMessage;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private a bZZ;
    private BdPageContext bfr;
    private HttpMessageListener bfu;
    private HttpMessageListener bfw;
    private HttpMessageListener caa;
    public boolean mIsSending;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bfu = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bZZ != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                            an anVar = (an) httpResponsedMessage.getOrginalMessage();
                            if (com.baidu.live.yuyingift.b.b.YX().gg(anVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", anVar.giftId).param("obj_param1", anVar.aWN).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, com.baidu.live.yuyingift.b.b.YX().ge(anVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bZZ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).HG()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).HH());
                        com.baidu.live.yuyingift.a.a YY = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).YY();
                        if (YY != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ad(c.this.bfr.getPageActivity(), YY.bcG, YY.bcH, YY.bcI, YY.bcJ)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                        an anVar2 = (an) httpResponsedMessage.getOrginalMessage();
                        c.this.a(anVar2.liveId, anVar2.roomId, anVar2.aWP, anVar2.aWO, anVar2.giftId, anVar2.giftName, anVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(anVar2);
                    }
                }
            }
        };
        this.caa = new HttpMessageListener(1031088) { // from class: com.baidu.live.yuyingift.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c.this.mIsSending = false;
            }
        };
        this.bfw = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bZZ != null) {
                        c.this.bZZ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).HF()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof ap)) {
                        ap apVar = (ap) httpResponsedMessage.getOrginalMessage();
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof ap) {
                        ap apVar2 = (ap) httpResponsedMessage.getOrginalMessage();
                    }
                }
            }
        };
        this.bfr = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bfu);
        MessageManager.getInstance().registerListener(this.caa);
        MessageManager.getInstance().registerListener(this.bfw);
    }

    public void a(a aVar) {
        this.bZZ = aVar;
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

    public void a(String str, long j, int i, String str2, String str3) {
        if (j > 0) {
            ao aoVar = new ao();
            aoVar.addParam("benefit_info", s.ig(str3));
            aoVar.addParam("ala_live_id", str2);
            aoVar.addParam(LogConfig.LOG_GIFT_ID, str);
            aoVar.addParam("combo_groupid", j);
            aoVar.addParam("combo_count_total", i);
            this.mIsSending = true;
            MessageManager.getInstance().sendMessage(aoVar);
        }
    }

    public void a(com.baidu.live.yuyingift.a.b bVar) {
        long j;
        if (StringUtils.isNull(bVar.userId) || StringUtils.isNull(bVar.userName)) {
            bVar.userId = TbadkCoreApplication.getCurrentAccountId() + "";
            bVar.userName = TbadkCoreApplication.getCurrentAccountName();
        }
        if (TextUtils.isEmpty(bVar.userName)) {
            bVar.userName = "某人";
        }
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.userName)) {
            this.mIsSending = true;
            if (bVar.GE()) {
                an anVar = new an();
                anVar.aYl = bVar.bZb;
                anVar.aWN = bVar.bcK;
                anVar.giftId = bVar.aNa;
                anVar.giftName = "手绘礼物";
                anVar.liveId = bVar.liveId;
                anVar.roomId = bVar.roomId;
                anVar.aWP = bVar.aWP;
                anVar.otherParams = bVar.otherParams;
                anVar.aWQ = bVar.aWQ;
                anVar.aWR = bVar.aWR;
                anVar.aWT.putAll(bVar.bcM);
                anVar.aWO = JavaTypesHelper.toLong(bVar.bct != null ? bVar.bct.getPrice() : "0", 0L) * bVar.bcK;
                long j2 = anVar.aWO;
                anVar.sceneFrom = bVar.sceneFrom;
                anVar.aYm = bVar.bno;
                anVar.addParam("scene_from", t.Vu());
                anVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNa);
                anVar.addParam("benefit_username", bVar.userName);
                anVar.addParam("benefit_userid", bVar.userId);
                anVar.addParam("num", bVar.bcK);
                anVar.addParam("ala_live_id", bVar.liveId);
                anVar.addParam("is_combo", bVar.aXW);
                anVar.addParam("benefit_info", s.ig(bVar.bno));
                if (bVar.bct != null && bVar.bct.aWe != null) {
                    anVar.addParam("gift_mul", bVar.bct.aWe.EN());
                    anVar.addParam("attach_new", bVar.bct.aWe.EM());
                }
                MessageManager.getInstance().sendMessage(anVar);
                j = j2;
            } else if (bVar.Ee()) {
                ap apVar = new ap();
                apVar.aWN = bVar.bcK;
                apVar.aYl = bVar.bZb;
                apVar.giftId = bVar.aNa;
                apVar.giftName = bVar.mGiftName;
                apVar.liveId = bVar.liveId;
                apVar.roomId = bVar.roomId;
                apVar.aWP = bVar.aWP;
                apVar.otherParams = bVar.otherParams;
                apVar.aWQ = bVar.aWQ;
                apVar.aWR = bVar.aWR;
                apVar.aWT.putAll(bVar.bcM);
                apVar.aWO = JavaTypesHelper.toLong(bVar.bct != null ? bVar.bct.getPrice() : "0", 0L) * bVar.bcK;
                long j3 = apVar.aWO;
                apVar.sceneFrom = bVar.sceneFrom;
                apVar.aYm = bVar.bno;
                apVar.addParam("scene_from", t.Vu());
                apVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aNa);
                apVar.addParam("benefit_username", bVar.userName);
                apVar.addParam("benefit_userid", bVar.userId);
                apVar.addParam("num", bVar.bcK);
                apVar.addParam("ala_live_id", bVar.liveId);
                apVar.addParam("is_combo", bVar.aXW);
                apVar.addParam("tbs", bVar.bcL);
                apVar.addParam("benefit_info", s.ig(bVar.bno));
                MessageManager.getInstance().sendMessage(apVar);
                j = j3;
            } else {
                an anVar2 = new an();
                anVar2.aYl = bVar.bZb;
                anVar2.aWN = bVar.bcK;
                anVar2.giftId = bVar.aNa;
                anVar2.giftName = bVar.mGiftName;
                anVar2.liveId = bVar.liveId;
                anVar2.roomId = bVar.roomId;
                anVar2.aWP = bVar.aWP;
                anVar2.otherParams = bVar.otherParams;
                anVar2.aWQ = bVar.aWQ;
                anVar2.aWR = bVar.aWR;
                anVar2.aWT.putAll(bVar.bcM);
                anVar2.aWO = JavaTypesHelper.toLong(bVar.bct != null ? bVar.bct.getPrice() : "0", 0L) * bVar.bcK;
                long j4 = anVar2.aWO;
                anVar2.aYm = bVar.bno;
                anVar2.sceneFrom = bVar.sceneFrom;
                anVar2.addParam("scene_from", t.Vu());
                anVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aNa);
                anVar2.addParam("benefit_username", bVar.userName);
                anVar2.addParam("benefit_userid", bVar.userId);
                anVar2.addParam("num", bVar.bcK);
                anVar2.addParam("ala_live_id", bVar.liveId);
                anVar2.addParam("is_combo", bVar.aXW);
                anVar2.addParam("is_comboGift", bVar.aVN);
                anVar2.addParam("combo_groupid", bVar.bZb);
                anVar2.addParam("tbs", bVar.bcL);
                anVar2.addParam("benefit_info", s.ig(bVar.bno));
                MessageManager.getInstance().sendMessage(anVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aWP, bVar.aNa, bVar.aNa, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bfu);
        MessageManager.getInstance().unRegisterListener(this.caa);
        MessageManager.getInstance().unRegisterListener(this.bfw);
    }
}
