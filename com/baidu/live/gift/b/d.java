package com.baidu.live.gift.b;

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
import com.baidu.live.c.h;
import com.baidu.live.gift.j;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.o;
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
import com.baidu.live.utils.q;
/* loaded from: classes2.dex */
public class d extends BdBaseModel {
    private a akQ;
    private BdPageContext akR;
    private HttpMessageListener akS;
    private HttpMessageListener akT;
    public boolean mIsSending;

    /* loaded from: classes2.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public d(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.mIsSending = false;
        this.akS = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                    if (d.this.akQ != null) {
                        if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                            j jVar = (j) httpResponsedMessage.getOrginalMessage();
                            if (b.ta().de(jVar.giftId)) {
                                TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.aeQ).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.ta().dc(jVar.giftId) ? 1 : 0));
                            }
                        }
                        d.this.akQ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).ts()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).tt());
                        com.baidu.live.gift.a.a tu = ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).tu();
                        if (tu != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new h(d.this.akR.getPageActivity(), tu.ajh, tu.aji, tu.ajj, tu.ajk)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                        }
                    }
                    d.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                        d.this.a(jVar2.liveId, jVar2.roomId, jVar2.aeS, jVar2.aeR, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                    }
                }
            }
        };
        this.akT = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                o oVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                    if (d.this.akQ != null) {
                        d.this.akQ.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).tr()), 0L);
                    }
                    d.this.mIsSending = false;
                    if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof o) && (oVar = (o) httpResponsedMessage.getOrginalMessage()) != null) {
                        d.this.a(oVar.liveId, oVar.roomId, oVar.aeS, 0L, oVar.giftId, oVar.giftName, oVar.otherParams);
                    }
                }
            }
        };
        this.akR = bdPageContext;
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.akS);
        MessageManager.getInstance().registerListener(this.akT);
    }

    public void a(a aVar) {
        this.akQ = aVar;
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
            if (bVar.sC()) {
                j jVar = new j();
                jVar.aeQ = String.valueOf(bVar.ajl);
                jVar.giftId = bVar.Zb;
                jVar.giftName = bVar.mGiftName;
                jVar.liveId = bVar.liveId;
                jVar.roomId = bVar.roomId;
                jVar.aeS = bVar.aeS;
                jVar.otherParams = bVar.otherParams;
                jVar.aeR = JavaTypesHelper.toLong(bVar.aiX != null ? bVar.aiX.getPrice() : "0", 0L) * bVar.ajl;
                long j2 = jVar.aeR;
                jVar.addParam("scene_from", bVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, bVar.Zb);
                jVar.addParam("benefit_username", bVar.userName);
                jVar.addParam("benefit_userid", bVar.userId);
                jVar.addParam("num", bVar.ajl);
                jVar.addParam("ala_live_id", bVar.liveId);
                jVar.addParam("is_combo", bVar.afv);
                jVar.addParam("tbs", bVar.ajm);
                if (bVar.aiX != null && bVar.aiX.ael != null) {
                    jVar.addParam("gift_mul", bVar.aiX.ael.ro());
                    jVar.addParam("attach_new", bVar.aiX.ael.rn());
                }
                jVar.addParam("scene_from", q.yO());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (bVar.qP()) {
                o oVar = new o();
                oVar.aeQ = String.valueOf(bVar.ajl);
                oVar.giftId = bVar.Zb;
                oVar.giftName = bVar.mGiftName;
                oVar.liveId = bVar.liveId;
                oVar.roomId = bVar.roomId;
                oVar.aeS = bVar.aeS;
                oVar.otherParams = bVar.otherParams;
                oVar.aeR = JavaTypesHelper.toLong(bVar.aiX != null ? bVar.aiX.getPrice() : "0", 0L) * bVar.ajl;
                long j3 = oVar.aeR;
                oVar.addParam("scene_from", bVar.sceneFrom);
                oVar.addParam(LogConfig.LOG_GIFT_ID, bVar.Zb);
                oVar.addParam("benefit_username", bVar.userName);
                oVar.addParam("benefit_userid", bVar.userId);
                oVar.addParam("num", bVar.ajl);
                oVar.addParam("ala_live_id", bVar.liveId);
                oVar.addParam("is_combo", bVar.afv);
                oVar.addParam("tbs", bVar.ajm);
                oVar.addParam("scene_from", q.yO());
                MessageManager.getInstance().sendMessage(oVar);
                j = j3;
            } else {
                j jVar2 = new j();
                jVar2.aeQ = String.valueOf(bVar.ajl);
                jVar2.giftId = bVar.Zb;
                jVar2.giftName = bVar.mGiftName;
                jVar2.liveId = bVar.liveId;
                jVar2.roomId = bVar.roomId;
                jVar2.aeS = bVar.aeS;
                jVar2.otherParams = bVar.otherParams;
                jVar2.aeR = JavaTypesHelper.toLong(bVar.aiX != null ? bVar.aiX.getPrice() : "0", 0L) * bVar.ajl;
                long j4 = jVar2.aeR;
                jVar2.addParam("scene_from", bVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, bVar.Zb);
                jVar2.addParam("benefit_username", bVar.userName);
                jVar2.addParam("benefit_userid", bVar.userId);
                jVar2.addParam("num", bVar.ajl);
                jVar2.addParam("ala_live_id", bVar.liveId);
                jVar2.addParam("is_combo", bVar.afv);
                jVar2.addParam("tbs", bVar.ajm);
                jVar2.addParam("scene_from", q.yO());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(bVar.liveId, bVar.roomId, bVar.aeS, bVar.Zb, bVar.Zb, j + "", bVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.akS);
        MessageManager.getInstance().unRegisterListener(this.akT);
    }
}
