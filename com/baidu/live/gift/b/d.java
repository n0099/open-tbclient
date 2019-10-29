package com.baidu.live.gift.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.i;
import com.baidu.live.gift.m;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.utils.o;
/* loaded from: classes6.dex */
public class d extends BdBaseModel {
    private a acB;
    public boolean mIsSending = false;
    private HttpMessageListener acC = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                if (d.this.acB != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                        i iVar = (i) httpResponsedMessage.getOrginalMessage();
                        if (b.rc().ck(iVar.giftId)) {
                            TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", iVar.giftId).param("obj_param1", iVar.WV).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.rc().ci(iVar.giftId) ? 1 : 0));
                        }
                    }
                    d.this.acB.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).rm()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).rn());
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                    i iVar2 = (i) httpResponsedMessage.getOrginalMessage();
                    d.this.a(iVar2.liveId, iVar2.roomId, iVar2.WX, iVar2.WW, iVar2.giftId, iVar2.giftName, iVar2.otherParams);
                }
            }
        }
    };
    private HttpMessageListener acD = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            m mVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                if (d.this.acB != null) {
                    d.this.acB.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).rl()), 0L);
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof m) && (mVar = (m) httpResponsedMessage.getOrginalMessage()) != null) {
                    d.this.a(mVar.liveId, mVar.roomId, mVar.WX, 0L, mVar.giftId, mVar.giftName, mVar.otherParams);
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.acC);
        MessageManager.getInstance().registerListener(this.acD);
    }

    public void a(a aVar) {
        this.acB = aVar;
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

    public void a(com.baidu.live.gift.a.c cVar) {
        long j;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.userName)) {
            this.mIsSending = true;
            if (cVar.qC()) {
                i iVar = new i();
                iVar.WV = String.valueOf(cVar.aaO);
                iVar.giftId = cVar.aaN;
                iVar.giftName = cVar.mGiftName;
                iVar.liveId = cVar.liveId;
                iVar.roomId = cVar.roomId;
                iVar.WX = cVar.WX;
                iVar.otherParams = cVar.otherParams;
                iVar.WW = JavaTypesHelper.toLong(cVar.aaC != null ? cVar.aaC.getPrice() : "0", 0L) * cVar.aaO;
                long j2 = iVar.WW;
                iVar.addParam("scene_from", cVar.sceneFrom);
                iVar.addParam(LogConfig.LOG_GIFT_ID, cVar.aaN);
                iVar.addParam("benefit_username", cVar.userName);
                iVar.addParam("benefit_userid", cVar.userId);
                iVar.addParam("num", cVar.aaO);
                iVar.addParam("ala_live_id", cVar.liveId);
                iVar.addParam("is_combo", cVar.WB);
                iVar.addParam("tbs", cVar.aaP);
                if (cVar.aaC != null && cVar.aaC.WJ != null) {
                    iVar.addParam("attach", cVar.aaC.WJ.pD());
                }
                iVar.addParam("scene_from", o.wu());
                MessageManager.getInstance().sendMessage(iVar);
                j = j2;
            } else if (cVar.pm()) {
                m mVar = new m();
                mVar.WV = String.valueOf(cVar.aaO);
                mVar.giftId = cVar.aaN;
                mVar.giftName = cVar.mGiftName;
                mVar.liveId = cVar.liveId;
                mVar.roomId = cVar.roomId;
                mVar.WX = cVar.WX;
                mVar.otherParams = cVar.otherParams;
                mVar.WW = JavaTypesHelper.toLong(cVar.aaC != null ? cVar.aaC.getPrice() : "0", 0L) * cVar.aaO;
                long j3 = mVar.WW;
                mVar.addParam("scene_from", cVar.sceneFrom);
                mVar.addParam(LogConfig.LOG_GIFT_ID, cVar.aaN);
                mVar.addParam("benefit_username", cVar.userName);
                mVar.addParam("benefit_userid", cVar.userId);
                mVar.addParam("num", cVar.aaO);
                mVar.addParam("ala_live_id", cVar.liveId);
                mVar.addParam("is_combo", cVar.WB);
                mVar.addParam("tbs", cVar.aaP);
                mVar.addParam("scene_from", o.wu());
                MessageManager.getInstance().sendMessage(mVar);
                j = j3;
            } else {
                i iVar2 = new i();
                iVar2.WV = String.valueOf(cVar.aaO);
                iVar2.giftId = cVar.aaN;
                iVar2.giftName = cVar.mGiftName;
                iVar2.liveId = cVar.liveId;
                iVar2.roomId = cVar.roomId;
                iVar2.WX = cVar.WX;
                iVar2.otherParams = cVar.otherParams;
                iVar2.WW = JavaTypesHelper.toLong(cVar.aaC != null ? cVar.aaC.getPrice() : "0", 0L) * cVar.aaO;
                long j4 = iVar2.WW;
                iVar2.addParam("scene_from", cVar.sceneFrom);
                iVar2.addParam(LogConfig.LOG_GIFT_ID, cVar.aaN);
                iVar2.addParam("benefit_username", cVar.userName);
                iVar2.addParam("benefit_userid", cVar.userId);
                iVar2.addParam("num", cVar.aaO);
                iVar2.addParam("ala_live_id", cVar.liveId);
                iVar2.addParam("is_combo", cVar.WB);
                iVar2.addParam("tbs", cVar.aaP);
                iVar2.addParam("scene_from", o.wu());
                MessageManager.getInstance().sendMessage(iVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(cVar.liveId, cVar.roomId, cVar.WX, cVar.aaN, cVar.aaN, j + "", cVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.acC);
        MessageManager.getInstance().unRegisterListener(this.acD);
    }
}
