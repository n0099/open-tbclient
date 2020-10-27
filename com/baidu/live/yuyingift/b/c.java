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
import com.baidu.live.gift.am;
import com.baidu.live.gift.an;
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
    private a bLv;
    private BdPageContext bbK;
    private HttpMessageListener bbM;
    private HttpMessageListener bbN;
    public boolean mIsSending;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.bbM = new HttpMessageListener(1031055) { // from class: com.baidu.live.yuyingift.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031055) {
                    if (c.this.bLv != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof am)) {
                            am amVar = (am) httpResponsedMessage.getOrginalMessage();
                            if (b.Vf().gS(amVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", amVar.giftId).param("obj_param1", amVar.aUe).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.Vf().gQ(amVar.giftId) ? 1 : 0));
                            }
                        }
                        c.this.bLv.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).IS()), ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).IT());
                        com.baidu.live.yuyingift.a.a Vg = ((YuyinAlaGiftSendHttpResponseMessage) httpResponsedMessage).Vg();
                        if (Vg != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ac(c.this.bbK.getPageActivity(), Vg.aZB, Vg.aZC, Vg.aZD, Vg.aZE)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof am)) {
                        am amVar2 = (am) httpResponsedMessage.getOrginalMessage();
                        c.this.a(amVar2.liveId, amVar2.roomId, amVar2.aUg, amVar2.aUf, amVar2.giftId, amVar2.giftName, amVar2.otherParams);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "consumeSuc"));
                        com.baidu.live.yuyingift.b.a.a(amVar2);
                    }
                }
            }
        };
        this.bbN = new HttpMessageListener(1031056) { // from class: com.baidu.live.yuyingift.b.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031056) {
                    if (c.this.bLv != null) {
                        c.this.bLv.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((YuyinAlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).IR()), 0L);
                    }
                    c.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof an)) {
                        an anVar = (an) httpResponsedMessage.getOrginalMessage();
                    } else if (httpResponsedMessage.getOrginalMessage() instanceof an) {
                        an anVar2 = (an) httpResponsedMessage.getOrginalMessage();
                    }
                }
            }
        };
        this.bbK = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.bbM);
        MessageManager.getInstance().registerListener(this.bbN);
    }

    public void a(a aVar) {
        this.bLv = aVar;
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
            if (bVar.HY()) {
                am amVar = new am();
                amVar.aUe = bVar.aZF;
                amVar.giftId = bVar.aMj;
                amVar.giftName = "手绘礼物";
                amVar.liveId = bVar.liveId;
                amVar.roomId = bVar.roomId;
                amVar.aUg = bVar.aUg;
                amVar.otherParams = bVar.otherParams;
                amVar.aUh = bVar.aUh;
                amVar.aUi = bVar.aUi;
                amVar.aUk.putAll(bVar.aZH);
                amVar.aUf = JavaTypesHelper.toLong(bVar.aZo != null ? bVar.aZo.getPrice() : "0", 0L) * bVar.aZF;
                long j2 = amVar.aUf;
                amVar.sceneFrom = bVar.sceneFrom;
                amVar.aVt = bVar.bja;
                amVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Sc() : bVar.sceneFrom);
                amVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aMj);
                amVar.addParam("benefit_username", bVar.userName);
                amVar.addParam("benefit_userid", bVar.userId);
                amVar.addParam("num", bVar.aZF);
                amVar.addParam("ala_live_id", bVar.liveId);
                amVar.addParam("is_combo", bVar.aVi);
                amVar.addParam("benefit_info", r.ip(bVar.bja));
                if (bVar.aZo != null && bVar.aZo.aTv != null) {
                    amVar.addParam("gift_mul", bVar.aZo.aTv.Gk());
                    amVar.addParam("attach_new", bVar.aZo.aTv.Gj());
                }
                MessageManager.getInstance().sendMessage(amVar);
                j = j2;
            } else if (bVar.FC()) {
                an anVar = new an();
                anVar.aUe = bVar.aZF;
                anVar.giftId = bVar.aMj;
                anVar.giftName = bVar.mGiftName;
                anVar.liveId = bVar.liveId;
                anVar.roomId = bVar.roomId;
                anVar.aUg = bVar.aUg;
                anVar.otherParams = bVar.otherParams;
                anVar.aUh = bVar.aUh;
                anVar.aUi = bVar.aUi;
                anVar.aUk.putAll(bVar.aZH);
                anVar.aUf = JavaTypesHelper.toLong(bVar.aZo != null ? bVar.aZo.getPrice() : "0", 0L) * bVar.aZF;
                long j3 = anVar.aUf;
                anVar.sceneFrom = bVar.sceneFrom;
                anVar.aVt = bVar.bja;
                anVar.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Sc() : bVar.sceneFrom);
                anVar.addParam(LogConfig.LOG_GIFT_ID, bVar.aMj);
                anVar.addParam("benefit_username", bVar.userName);
                anVar.addParam("benefit_userid", bVar.userId);
                anVar.addParam("num", bVar.aZF);
                anVar.addParam("ala_live_id", bVar.liveId);
                anVar.addParam("is_combo", bVar.aVi);
                anVar.addParam("tbs", bVar.aZG);
                anVar.addParam("benefit_info", r.ip(bVar.bja));
                MessageManager.getInstance().sendMessage(anVar);
                j = j3;
            } else {
                am amVar2 = new am();
                amVar2.aUe = bVar.aZF;
                amVar2.giftId = bVar.aMj;
                amVar2.giftName = bVar.mGiftName;
                amVar2.liveId = bVar.liveId;
                amVar2.roomId = bVar.roomId;
                amVar2.aUg = bVar.aUg;
                amVar2.otherParams = bVar.otherParams;
                amVar2.aUh = bVar.aUh;
                amVar2.aUi = bVar.aUi;
                amVar2.aUk.putAll(bVar.aZH);
                amVar2.aUf = JavaTypesHelper.toLong(bVar.aZo != null ? bVar.aZo.getPrice() : "0", 0L) * bVar.aZF;
                long j4 = amVar2.aUf;
                amVar2.aVt = bVar.bja;
                amVar2.sceneFrom = bVar.sceneFrom;
                amVar2.addParam("scene_from", StringUtils.isNull(bVar.sceneFrom) ? s.Sc() : bVar.sceneFrom);
                amVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.aMj);
                amVar2.addParam("benefit_username", bVar.userName);
                amVar2.addParam("benefit_userid", bVar.userId);
                amVar2.addParam("num", bVar.aZF);
                amVar2.addParam("ala_live_id", bVar.liveId);
                amVar2.addParam("is_combo", bVar.aVi);
                amVar2.addParam("tbs", bVar.aZG);
                amVar2.addParam("benefit_info", r.ip(bVar.bja));
                MessageManager.getInstance().sendMessage(amVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aUg, bVar.aMj, bVar.aMj, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.bbM);
        MessageManager.getInstance().unRegisterListener(this.bbN);
    }
}
