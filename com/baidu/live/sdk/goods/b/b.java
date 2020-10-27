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
import com.baidu.live.data.bm;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.sdk.goods.message.HasGoodsAuthResponseMessage;
import com.baidu.live.sdk.goods.message.LiveGoodsIntroduceHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a bqy;
    private boolean brq;
    private List<com.baidu.live.sdk.goods.a.a> brr;
    private int brs;
    private HttpMessageListener brt;
    private HttpMessageListener bru;
    private HttpMessageListener brv;
    private int mCount;
    private Handler mHandler;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.brq = false;
        this.brr = null;
        this.mCount = 0;
        this.brs = 0;
        this.brt = new HttpMessageListener(1021143) { // from class: com.baidu.live.sdk.goods.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.a(httpResponsedMessage);
            }
        };
        this.bru = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.b(httpResponsedMessage);
            }
        };
        this.brv = new HttpMessageListener(1021208) { // from class: com.baidu.live.sdk.goods.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.c(httpResponsedMessage);
            }
        };
        this.mHandler = new Handler();
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.brt);
        MessageManager.getInstance().registerListener(this.bru);
        MessageManager.getInstance().registerListener(this.brv);
    }

    public void a(a aVar) {
        this.bqy = aVar;
    }

    public void MS() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage) {
        bm bmVar;
        boolean z = false;
        if (!(httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
            a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            if (httpResponsedMessage.getError() == 1001) {
                this.brs = 0;
                a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                return;
            }
            a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
            this.brs++;
            if (this.brs < 3) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.b.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.MS();
                    }
                }, 2000L);
            }
        } else {
            this.brs = 0;
            HasGoodsAuthResponseMessage hasGoodsAuthResponseMessage = (HasGoodsAuthResponseMessage) httpResponsedMessage;
            this.brq = hasGoodsAuthResponseMessage.brp;
            if (hasGoodsAuthResponseMessage.brp && (bmVar = com.baidu.live.z.a.Pq().bsy) != null && bmVar.aOE != null && !TextUtils.isEmpty(bmVar.aOE.aQZ)) {
                z = true;
            }
            if (this.bqy != null) {
                this.bqy.a(hasGoodsAuthResponseMessage.getError(), hasGoodsAuthResponseMessage.getErrorString(), hasGoodsAuthResponseMessage.brp, z);
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
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void a(String str, long j, long j2, String str2, String str3, String str4) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) {
            com.baidu.live.sdk.goods.message.c cVar = new com.baidu.live.sdk.goods.message.c();
            cVar.aUg = str;
            cVar.liveId = j;
            cVar.brl = false;
            cVar.authorId = j2;
            cVar.tab = str2;
            cVar.tag = str3;
            cVar.source = str4;
            cVar.setParams();
            MessageManager.getInstance().sendMessage(cVar);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", "goods_list", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
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
        String str = cVar.aUg;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            b(httpResponsedMessage, ETAG.KEY_NET_ERROR, "goods_list");
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(j));
            alaStatsItem.addValue("feedid", str);
            alaStatsItem.addValue("err", Integer.valueOf(getVideoGoodsListHttpResponseMessage.getError()));
            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, getVideoGoodsListHttpResponseMessage.getErrorString());
            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
            return;
        }
        this.brr = getVideoGoodsListHttpResponseMessage.brm;
        this.mCount = getVideoGoodsListHttpResponseMessage.count;
        b(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
        if (this.bqy != null) {
            this.bqy.a(getVideoGoodsListHttpResponseMessage.getError(), getVideoGoodsListHttpResponseMessage.getErrorString(), cVar.brl, j, getVideoGoodsListHttpResponseMessage.count, getVideoGoodsListHttpResponseMessage.brm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HttpResponsedMessage httpResponsedMessage) {
        int i;
        boolean z = false;
        if ((httpResponsedMessage instanceof LiveGoodsIntroduceHttpResponseMessage) && this.bqy != null) {
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
            a aVar = this.bqy;
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
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
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

    public boolean Pb() {
        return this.brq;
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
        MessageManager.getInstance().unRegisterListener(this.brt);
        MessageManager.getInstance().unRegisterListener(this.bru);
        MessageManager.getInstance().unRegisterListener(this.brv);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
