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
    private a ach;
    public boolean mIsSending = false;
    private HttpMessageListener aci = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                if (d.this.ach != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                        i iVar = (i) httpResponsedMessage.getOrginalMessage();
                        if (b.rd().ck(iVar.giftId)) {
                            TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", iVar.giftId).param("obj_param1", iVar.WC).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.rd().ci(iVar.giftId) ? 1 : 0));
                        }
                    }
                    d.this.ach.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).rn()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).ro());
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof i)) {
                    i iVar2 = (i) httpResponsedMessage.getOrginalMessage();
                    d.this.a(iVar2.liveId, iVar2.roomId, iVar2.WE, iVar2.WD, iVar2.giftId, iVar2.giftName, iVar2.otherParams);
                }
            }
        }
    };
    private HttpMessageListener acj = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            m mVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                if (d.this.ach != null) {
                    d.this.ach.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).rm()), 0L);
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof m) && (mVar = (m) httpResponsedMessage.getOrginalMessage()) != null) {
                    d.this.a(mVar.liveId, mVar.roomId, mVar.WE, 0L, mVar.giftId, mVar.giftName, mVar.otherParams);
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.aci);
        MessageManager.getInstance().registerListener(this.acj);
    }

    public void a(a aVar) {
        this.ach = aVar;
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
            if (cVar.qD()) {
                i iVar = new i();
                iVar.WC = String.valueOf(cVar.aaw);
                iVar.giftId = cVar.aav;
                iVar.giftName = cVar.mGiftName;
                iVar.liveId = cVar.liveId;
                iVar.roomId = cVar.roomId;
                iVar.WE = cVar.WE;
                iVar.otherParams = cVar.otherParams;
                iVar.WD = JavaTypesHelper.toLong(cVar.aak != null ? cVar.aak.getPrice() : "0", 0L) * cVar.aaw;
                long j2 = iVar.WD;
                iVar.addParam("scene_from", cVar.sceneFrom);
                iVar.addParam(LogConfig.LOG_GIFT_ID, cVar.aav);
                iVar.addParam("benefit_username", cVar.userName);
                iVar.addParam("benefit_userid", cVar.userId);
                iVar.addParam("num", cVar.aaw);
                iVar.addParam("ala_live_id", cVar.liveId);
                iVar.addParam("is_combo", cVar.Wi);
                iVar.addParam("tbs", cVar.aax);
                if (cVar.aak != null && cVar.aak.Wq != null) {
                    iVar.addParam("attach", cVar.aak.Wq.pD());
                }
                iVar.addParam("scene_from", o.wv());
                MessageManager.getInstance().sendMessage(iVar);
                j = j2;
            } else if (cVar.pm()) {
                m mVar = new m();
                mVar.WC = String.valueOf(cVar.aaw);
                mVar.giftId = cVar.aav;
                mVar.giftName = cVar.mGiftName;
                mVar.liveId = cVar.liveId;
                mVar.roomId = cVar.roomId;
                mVar.WE = cVar.WE;
                mVar.otherParams = cVar.otherParams;
                mVar.WD = JavaTypesHelper.toLong(cVar.aak != null ? cVar.aak.getPrice() : "0", 0L) * cVar.aaw;
                long j3 = mVar.WD;
                mVar.addParam("scene_from", cVar.sceneFrom);
                mVar.addParam(LogConfig.LOG_GIFT_ID, cVar.aav);
                mVar.addParam("benefit_username", cVar.userName);
                mVar.addParam("benefit_userid", cVar.userId);
                mVar.addParam("num", cVar.aaw);
                mVar.addParam("ala_live_id", cVar.liveId);
                mVar.addParam("is_combo", cVar.Wi);
                mVar.addParam("tbs", cVar.aax);
                mVar.addParam("scene_from", o.wv());
                MessageManager.getInstance().sendMessage(mVar);
                j = j3;
            } else {
                i iVar2 = new i();
                iVar2.WC = String.valueOf(cVar.aaw);
                iVar2.giftId = cVar.aav;
                iVar2.giftName = cVar.mGiftName;
                iVar2.liveId = cVar.liveId;
                iVar2.roomId = cVar.roomId;
                iVar2.WE = cVar.WE;
                iVar2.otherParams = cVar.otherParams;
                iVar2.WD = JavaTypesHelper.toLong(cVar.aak != null ? cVar.aak.getPrice() : "0", 0L) * cVar.aaw;
                long j4 = iVar2.WD;
                iVar2.addParam("scene_from", cVar.sceneFrom);
                iVar2.addParam(LogConfig.LOG_GIFT_ID, cVar.aav);
                iVar2.addParam("benefit_username", cVar.userName);
                iVar2.addParam("benefit_userid", cVar.userId);
                iVar2.addParam("num", cVar.aaw);
                iVar2.addParam("ala_live_id", cVar.liveId);
                iVar2.addParam("is_combo", cVar.Wi);
                iVar2.addParam("tbs", cVar.aax);
                iVar2.addParam("scene_from", o.wv());
                MessageManager.getInstance().sendMessage(iVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(cVar.liveId, cVar.roomId, cVar.WE, cVar.aav, cVar.aav, j + "", cVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.aci);
        MessageManager.getInstance().unRegisterListener(this.acj);
    }
}
