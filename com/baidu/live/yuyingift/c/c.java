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
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private a bVX;
    private HttpMessageListener bVY;
    private BdPageContext bcj;
    private HttpMessageListener bcl;
    private HttpMessageListener bcn;
    public boolean mIsSending;

    /* loaded from: classes10.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bcl = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bVX != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                            an anVar = (an) httpResponsedMessage.getOrginalMessage();
                            if (com.baidu.live.yuyingift.b.b.Xh().fL(anVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", anVar.giftId).param("obj_param1", anVar.aTI).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, com.baidu.live.yuyingift.b.b.Xh().fJ(anVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bVX.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Gq()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Gr());
                        com.baidu.live.yuyingift.a.a Xi = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Xi();
                        if (Xi != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ad(c.this.bcj.getPageActivity(), Xi.aZz, Xi.aZA, Xi.aZB, Xi.aZC)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                        an anVar2 = (an) httpResponsedMessage.getOrginalMessage();
                        c.this.a(anVar2.liveId, anVar2.roomId, anVar2.aTK, anVar2.aTJ, anVar2.giftId, anVar2.giftName, anVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(anVar2);
                    }
                }
            }
        };
        this.bVY = new HttpMessageListener(1031088) { // from class: com.baidu.live.yuyingift.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c.this.mIsSending = false;
            }
        };
        this.bcn = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bVX != null) {
                        c.this.bVX.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).Gp()), 0L);
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
        this.bcj = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bcl);
        MessageManager.getInstance().registerListener(this.bVY);
        MessageManager.getInstance().registerListener(this.bcn);
    }

    public void a(a aVar) {
        this.bVX = aVar;
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
            aoVar.addParam("benefit_info", s.hL(str3));
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
            if (bVar.Fo()) {
                an anVar = new an();
                anVar.aVd = bVar.bUZ;
                anVar.aTI = bVar.aZD;
                anVar.giftId = bVar.aKn;
                anVar.giftName = "手绘礼物";
                anVar.liveId = bVar.liveId;
                anVar.roomId = bVar.roomId;
                anVar.aTK = bVar.aTK;
                anVar.otherParams = bVar.otherParams;
                anVar.aTL = bVar.aTL;
                anVar.aTM = bVar.aTM;
                anVar.aTO.putAll(bVar.aZF);
                anVar.aTJ = JavaTypesHelper.toLong(bVar.aZl != null ? bVar.aZl.getPrice() : "0", 0L) * bVar.aZD;
                long j2 = anVar.aTJ;
                anVar.sceneFrom = bVar.sceneFrom;
                anVar.aVe = bVar.bjV;
                anVar.addParam("scene_from", t.TN());
                anVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aKn);
                anVar.addParam("benefit_username", bVar.userName);
                anVar.addParam("benefit_userid", bVar.userId);
                anVar.addParam("num", bVar.aZD);
                anVar.addParam("ala_live_id", bVar.liveId);
                anVar.addParam("is_combo", bVar.aUO);
                anVar.addParam("benefit_info", s.hL(bVar.bjV));
                if (bVar.aZl != null && bVar.aZl.aSZ != null) {
                    anVar.addParam("gift_mul", bVar.aZl.aSZ.Dx());
                    anVar.addParam("attach_new", bVar.aZl.aSZ.Dw());
                }
                MessageManager.getInstance().sendMessage(anVar);
                j = j2;
            } else if (bVar.CO()) {
                ap apVar = new ap();
                apVar.aTI = bVar.aZD;
                apVar.aVd = bVar.bUZ;
                apVar.giftId = bVar.aKn;
                apVar.giftName = bVar.mGiftName;
                apVar.liveId = bVar.liveId;
                apVar.roomId = bVar.roomId;
                apVar.aTK = bVar.aTK;
                apVar.otherParams = bVar.otherParams;
                apVar.aTL = bVar.aTL;
                apVar.aTM = bVar.aTM;
                apVar.aTO.putAll(bVar.aZF);
                apVar.aTJ = JavaTypesHelper.toLong(bVar.aZl != null ? bVar.aZl.getPrice() : "0", 0L) * bVar.aZD;
                long j3 = apVar.aTJ;
                apVar.sceneFrom = bVar.sceneFrom;
                apVar.aVe = bVar.bjV;
                apVar.addParam("scene_from", t.TN());
                apVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aKn);
                apVar.addParam("benefit_username", bVar.userName);
                apVar.addParam("benefit_userid", bVar.userId);
                apVar.addParam("num", bVar.aZD);
                apVar.addParam("ala_live_id", bVar.liveId);
                apVar.addParam("is_combo", bVar.aUO);
                apVar.addParam("tbs", bVar.aZE);
                apVar.addParam("benefit_info", s.hL(bVar.bjV));
                MessageManager.getInstance().sendMessage(apVar);
                j = j3;
            } else {
                an anVar2 = new an();
                anVar2.aVd = bVar.bUZ;
                anVar2.aTI = bVar.aZD;
                anVar2.giftId = bVar.aKn;
                anVar2.giftName = bVar.mGiftName;
                anVar2.liveId = bVar.liveId;
                anVar2.roomId = bVar.roomId;
                anVar2.aTK = bVar.aTK;
                anVar2.otherParams = bVar.otherParams;
                anVar2.aTL = bVar.aTL;
                anVar2.aTM = bVar.aTM;
                anVar2.aTO.putAll(bVar.aZF);
                anVar2.aTJ = JavaTypesHelper.toLong(bVar.aZl != null ? bVar.aZl.getPrice() : "0", 0L) * bVar.aZD;
                long j4 = anVar2.aTJ;
                anVar2.aVe = bVar.bjV;
                anVar2.sceneFrom = bVar.sceneFrom;
                anVar2.addParam("scene_from", t.TN());
                anVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aKn);
                anVar2.addParam("benefit_username", bVar.userName);
                anVar2.addParam("benefit_userid", bVar.userId);
                anVar2.addParam("num", bVar.aZD);
                anVar2.addParam("ala_live_id", bVar.liveId);
                anVar2.addParam("is_combo", bVar.aUO);
                anVar2.addParam("is_comboGift", bVar.aSI);
                anVar2.addParam("combo_groupid", bVar.bUZ);
                anVar2.addParam("tbs", bVar.aZE);
                anVar2.addParam("benefit_info", s.hL(bVar.bjV));
                MessageManager.getInstance().sendMessage(anVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aTK, bVar.aKn, bVar.aKn, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bcl);
        MessageManager.getInstance().unRegisterListener(this.bVY);
        MessageManager.getInstance().unRegisterListener(this.bcn);
    }
}
