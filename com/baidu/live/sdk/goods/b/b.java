package com.baidu.live.sdk.goods.b;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.bv;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.sdk.goods.message.HasGoodsAuthResponseMessage;
import com.baidu.live.sdk.goods.message.LiveGoodsIntroduceHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private a bAs;
    private boolean bBk;
    private List<com.baidu.live.sdk.goods.a.a> bBl;
    private int bBm;
    private HttpMessageListener bBn;
    private HttpMessageListener bBo;
    private HttpMessageListener bBp;
    private int mCount;
    private Handler mHandler;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bBk = false;
        this.bBl = null;
        this.mCount = 0;
        this.bBm = 0;
        this.bBn = new HttpMessageListener(1021143) { // from class: com.baidu.live.sdk.goods.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.a(httpResponsedMessage);
            }
        };
        this.bBo = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.b(httpResponsedMessage);
            }
        };
        this.bBp = new HttpMessageListener(1021208) { // from class: com.baidu.live.sdk.goods.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.c(httpResponsedMessage);
            }
        };
        this.mHandler = new Handler();
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.bBn);
        MessageManager.getInstance().registerListener(this.bBo);
        MessageManager.getInstance().registerListener(this.bBp);
    }

    public void a(a aVar) {
        this.bAs = aVar;
    }

    public void Ms() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH, "author_liveroom", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage) {
        bv bvVar;
        boolean z = false;
        if (!(httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
            a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            if (httpResponsedMessage.getError() == 1001) {
                this.bBm = 0;
                a(httpResponsedMessage, "net_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                return;
            }
            a(httpResponsedMessage, "net_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
            this.bBm++;
            if (this.bBm < 3) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.b.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Ms();
                    }
                }, 2000L);
            }
        } else {
            this.bBm = 0;
            HasGoodsAuthResponseMessage hasGoodsAuthResponseMessage = (HasGoodsAuthResponseMessage) httpResponsedMessage;
            this.bBk = hasGoodsAuthResponseMessage.bBj;
            if (hasGoodsAuthResponseMessage.bBj && (bvVar = com.baidu.live.ae.a.Qm().bCs) != null && bvVar.aRq != null && !TextUtils.isEmpty(bvVar.aRq.aUf)) {
                z = true;
            }
            if (this.bAs != null) {
                this.bAs.b(hasGoodsAuthResponseMessage.getError(), hasGoodsAuthResponseMessage.getErrorString(), hasGoodsAuthResponseMessage.bBj, z);
            }
            a(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH_SUCC);
        }
    }

    private void a(HttpResponsedMessage httpResponsedMessage, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, str);
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void a(String str, long j, long j2, String str2, String str3, String str4) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) {
            com.baidu.live.sdk.goods.message.c cVar = new com.baidu.live.sdk.goods.message.c();
            cVar.aYp = str;
            cVar.liveId = j;
            cVar.bBf = false;
            cVar.authorId = j2;
            cVar.tab = str2;
            cVar.tag = str3;
            cVar.source = str4;
            cVar.setParams();
            MessageManager.getInstance().sendMessage(cVar);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", "goods_list", "author_liveroom", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HttpResponsedMessage httpResponsedMessage) {
        if (!(httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
            b(httpResponsedMessage, "data_error", "goods_list");
            return;
        }
        GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
        com.baidu.live.sdk.goods.message.c cVar = (com.baidu.live.sdk.goods.message.c) httpResponsedMessage.getOrginalMessage();
        long j = cVar.liveId;
        String str = cVar.aYp;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            b(httpResponsedMessage, "net_error", "goods_list");
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(j));
            alaStatsItem.addValue("feedid", str);
            alaStatsItem.addValue("err", Integer.valueOf(getVideoGoodsListHttpResponseMessage.getError()));
            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, getVideoGoodsListHttpResponseMessage.getErrorString());
            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
            return;
        }
        this.bBl = getVideoGoodsListHttpResponseMessage.bBg;
        this.mCount = getVideoGoodsListHttpResponseMessage.count;
        b(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
        if (this.bAs != null) {
            this.bAs.a(getVideoGoodsListHttpResponseMessage.getError(), getVideoGoodsListHttpResponseMessage.getErrorString(), cVar.bBf, j, getVideoGoodsListHttpResponseMessage.count, getVideoGoodsListHttpResponseMessage.bBg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HttpResponsedMessage httpResponsedMessage) {
        int i;
        boolean z = false;
        if ((httpResponsedMessage instanceof LiveGoodsIntroduceHttpResponseMessage) && this.bAs != null) {
            LiveGoodsIntroduceHttpResponseMessage liveGoodsIntroduceHttpResponseMessage = (LiveGoodsIntroduceHttpResponseMessage) httpResponsedMessage;
            String str = "";
            String str2 = "";
            if (liveGoodsIntroduceHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.sdk.goods.message.d) {
                com.baidu.live.sdk.goods.message.d dVar = (com.baidu.live.sdk.goods.message.d) liveGoodsIntroduceHttpResponseMessage.getOrginalMessage();
                str = dVar.liveId;
                str2 = dVar.gid;
                i = dVar.type;
            } else {
                i = 0;
            }
            a aVar = this.bAs;
            if (!liveGoodsIntroduceHttpResponseMessage.hasError() && liveGoodsIntroduceHttpResponseMessage.getError() == 0) {
                z = true;
            }
            aVar.a(z, liveGoodsIntroduceHttpResponseMessage.getErrorString(), str, str2, i);
        }
    }

    private void b(HttpResponsedMessage httpResponsedMessage, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, str);
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void a(String str, String str2, int i, String str3, String str4, String str5) {
        com.baidu.live.sdk.goods.message.d dVar = new com.baidu.live.sdk.goods.message.d();
        dVar.setLiveId(str);
        dVar.setGid(str2);
        dVar.setType(i);
        dVar.addParam("room_id", str3);
        dVar.addParam("anchor_id", str4);
        dVar.addParam("group_id", str5);
        MessageManager.getInstance().sendMessage(dVar);
    }

    public boolean PW() {
        return this.bBk;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bBn);
        MessageManager.getInstance().unRegisterListener(this.bBo);
        MessageManager.getInstance().unRegisterListener(this.bBp);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
