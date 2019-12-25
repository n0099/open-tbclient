package com.baidu.live.gift.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.j;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.gift.o;
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
import com.baidu.live.utils.p;
/* loaded from: classes2.dex */
public class d extends BdBaseModel {
    private a akf;
    public boolean mIsSending = false;
    private HttpMessageListener akg = new HttpMessageListener(1021015) { // from class: com.baidu.live.gift.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021015) {
                if (d.this.akf != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                        j jVar = (j) httpResponsedMessage.getOrginalMessage();
                        if (b.sK().dc(jVar.giftId)) {
                            TiebaInitialize.log(new StatisticItem("c12793").param("obj_id", jVar.giftId).param("obj_param1", jVar.aeh).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, b.sK().da(jVar.giftId) ? 1 : 0));
                        }
                    }
                    d.this.akf.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Long.valueOf(((AlaGiftSendHttpResponseMessage) httpResponsedMessage).tb()), ((AlaGiftSendHttpResponseMessage) httpResponsedMessage).tc());
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof j)) {
                    j jVar2 = (j) httpResponsedMessage.getOrginalMessage();
                    d.this.a(jVar2.liveId, jVar2.roomId, jVar2.aej, jVar2.aei, jVar2.giftId, jVar2.giftName, jVar2.otherParams);
                }
            }
        }
    };
    private HttpMessageListener akh = new HttpMessageListener(1021014) { // from class: com.baidu.live.gift.b.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            o oVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021014) {
                if (d.this.akf != null) {
                    d.this.akf.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, Long.valueOf(((AlaGiftFreeSendHttpResponseMessage) httpResponsedMessage).ta()), 0L);
                }
                d.this.mIsSending = false;
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError() && (httpResponsedMessage.getOrginalMessage() instanceof o) && (oVar = (o) httpResponsedMessage.getOrginalMessage()) != null) {
                    d.this.a(oVar.liveId, oVar.roomId, oVar.aej, 0L, oVar.giftId, oVar.giftName, oVar.otherParams);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(int i, String str, int i2, Object obj, long j);
    }

    public void initListener() {
        MessageManager.getInstance().registerListener(this.akg);
        MessageManager.getInstance().registerListener(this.akh);
    }

    public void a(a aVar) {
        this.akf = aVar;
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

    public void a(com.baidu.live.gift.a.a aVar) {
        long j;
        if (aVar != null && !StringUtils.isNull(aVar.userId) && !StringUtils.isNull(aVar.userName)) {
            this.mIsSending = true;
            if (aVar.sm()) {
                j jVar = new j();
                jVar.aeh = String.valueOf(aVar.aiz);
                jVar.giftId = aVar.YP;
                jVar.giftName = aVar.mGiftName;
                jVar.liveId = aVar.liveId;
                jVar.roomId = aVar.roomId;
                jVar.aej = aVar.aej;
                jVar.otherParams = aVar.otherParams;
                jVar.aei = JavaTypesHelper.toLong(aVar.aip != null ? aVar.aip.getPrice() : "0", 0L) * aVar.aiz;
                long j2 = jVar.aei;
                jVar.addParam("scene_from", aVar.sceneFrom);
                jVar.addParam(LogConfig.LOG_GIFT_ID, aVar.YP);
                jVar.addParam("benefit_username", aVar.userName);
                jVar.addParam("benefit_userid", aVar.userId);
                jVar.addParam("num", aVar.aiz);
                jVar.addParam("ala_live_id", aVar.liveId);
                jVar.addParam("is_combo", aVar.aeM);
                jVar.addParam("tbs", aVar.aiA);
                if (aVar.aip != null && aVar.aip.adW != null) {
                    jVar.addParam("gift_mul", aVar.aip.adW.rc());
                    jVar.addParam("attach_new", aVar.aip.adW.rb());
                }
                jVar.addParam("scene_from", p.yv());
                MessageManager.getInstance().sendMessage(jVar);
                j = j2;
            } else if (aVar.qI()) {
                o oVar = new o();
                oVar.aeh = String.valueOf(aVar.aiz);
                oVar.giftId = aVar.YP;
                oVar.giftName = aVar.mGiftName;
                oVar.liveId = aVar.liveId;
                oVar.roomId = aVar.roomId;
                oVar.aej = aVar.aej;
                oVar.otherParams = aVar.otherParams;
                oVar.aei = JavaTypesHelper.toLong(aVar.aip != null ? aVar.aip.getPrice() : "0", 0L) * aVar.aiz;
                long j3 = oVar.aei;
                oVar.addParam("scene_from", aVar.sceneFrom);
                oVar.addParam(LogConfig.LOG_GIFT_ID, aVar.YP);
                oVar.addParam("benefit_username", aVar.userName);
                oVar.addParam("benefit_userid", aVar.userId);
                oVar.addParam("num", aVar.aiz);
                oVar.addParam("ala_live_id", aVar.liveId);
                oVar.addParam("is_combo", aVar.aeM);
                oVar.addParam("tbs", aVar.aiA);
                oVar.addParam("scene_from", p.yv());
                MessageManager.getInstance().sendMessage(oVar);
                j = j3;
            } else {
                j jVar2 = new j();
                jVar2.aeh = String.valueOf(aVar.aiz);
                jVar2.giftId = aVar.YP;
                jVar2.giftName = aVar.mGiftName;
                jVar2.liveId = aVar.liveId;
                jVar2.roomId = aVar.roomId;
                jVar2.aej = aVar.aej;
                jVar2.otherParams = aVar.otherParams;
                jVar2.aei = JavaTypesHelper.toLong(aVar.aip != null ? aVar.aip.getPrice() : "0", 0L) * aVar.aiz;
                long j4 = jVar2.aei;
                jVar2.addParam("scene_from", aVar.sceneFrom);
                jVar2.addParam(LogConfig.LOG_GIFT_ID, aVar.YP);
                jVar2.addParam("benefit_username", aVar.userName);
                jVar2.addParam("benefit_userid", aVar.userId);
                jVar2.addParam("num", aVar.aiz);
                jVar2.addParam("ala_live_id", aVar.liveId);
                jVar2.addParam("is_combo", aVar.aeM);
                jVar2.addParam("tbs", aVar.aiA);
                jVar2.addParam("scene_from", p.yv());
                MessageManager.getInstance().sendMessage(jVar2);
                j = j4;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                LogManager.getGiftLogger().doNoticeLiveGiftSendRequest(aVar.liveId, aVar.roomId, aVar.aej, aVar.YP, aVar.YP, j + "", aVar.otherParams);
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
        MessageManager.getInstance().unRegisterListener(this.akg);
        MessageManager.getInstance().unRegisterListener(this.akh);
    }
}
