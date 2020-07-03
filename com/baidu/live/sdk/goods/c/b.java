package com.baidu.live.sdk.goods.c;

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
import com.baidu.live.data.bb;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.sdk.goods.message.HasGoodsAuthResponseMessage;
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
/* loaded from: classes3.dex */
public class b extends BdBaseModel {
    private boolean bcW;
    private List<com.baidu.live.sdk.goods.a.a> bcX;
    private int bcY;
    private HttpMessageListener bcZ;
    private a bcj;
    private HttpMessageListener bda;
    private int mCount;
    private Handler mHandler;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bcW = false;
        this.bcX = null;
        this.mCount = 0;
        this.bcY = 0;
        this.bcZ = new HttpMessageListener(1021143) { // from class: com.baidu.live.sdk.goods.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.a(httpResponsedMessage);
            }
        };
        this.bda = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b.this.b(httpResponsedMessage);
            }
        };
        this.mHandler = new Handler();
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.bcZ);
        MessageManager.getInstance().registerListener(this.bda);
    }

    public void a(a aVar) {
        this.bcj = aVar;
    }

    public void Fm() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021143));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage) {
        bb bbVar;
        boolean z = false;
        if (!(httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
            a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            if (httpResponsedMessage.getError() == 1001) {
                this.bcY = 0;
                a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
                return;
            }
            a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_AUTH);
            this.bcY++;
            if (this.bcY < 3) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.c.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Fm();
                    }
                }, 2000L);
            }
        } else {
            this.bcY = 0;
            HasGoodsAuthResponseMessage hasGoodsAuthResponseMessage = (HasGoodsAuthResponseMessage) httpResponsedMessage;
            this.bcW = hasGoodsAuthResponseMessage.bcV;
            if (hasGoodsAuthResponseMessage.bcV && (bbVar = com.baidu.live.v.a.Hm().bdV) != null && bbVar.aCX != null && !TextUtils.isEmpty(bbVar.aCX.aEU)) {
                z = true;
            }
            if (this.bcj != null) {
                this.bcj.a(hasGoodsAuthResponseMessage.getError(), hasGoodsAuthResponseMessage.getErrorString(), hasGoodsAuthResponseMessage.bcV, z);
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
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void d(String str, long j, long j2) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) {
            com.baidu.live.sdk.goods.message.c cVar = new com.baidu.live.sdk.goods.message.c();
            cVar.aHt = str;
            cVar.liveId = j;
            cVar.bcT = false;
            cVar.authorId = j2;
            cVar.setParams();
            MessageManager.getInstance().sendMessage(cVar);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HttpResponsedMessage httpResponsedMessage) {
        if (!(httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
            b(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
            return;
        }
        GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
        com.baidu.live.sdk.goods.message.c cVar = (com.baidu.live.sdk.goods.message.c) httpResponsedMessage.getOrginalMessage();
        long j = cVar.liveId;
        String str = cVar.aHt;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            b(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(j));
            alaStatsItem.addValue("feedid", str);
            alaStatsItem.addValue("err", Integer.valueOf(getVideoGoodsListHttpResponseMessage.getError()));
            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, getVideoGoodsListHttpResponseMessage.getErrorString());
            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
            return;
        }
        this.bcX = getVideoGoodsListHttpResponseMessage.bcU;
        this.mCount = getVideoGoodsListHttpResponseMessage.count;
        b(httpResponsedMessage, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
        if (this.bcj != null) {
            this.bcj.a(getVideoGoodsListHttpResponseMessage.getError(), getVideoGoodsListHttpResponseMessage.getErrorString(), cVar.bcT, j, getVideoGoodsListHttpResponseMessage.count, getVideoGoodsListHttpResponseMessage.bcU);
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
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public boolean GW() {
        return this.bcW;
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
        MessageManager.getInstance().unRegisterListener(this.bcZ);
        MessageManager.getInstance().unRegisterListener(this.bda);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
