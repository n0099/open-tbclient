package com.baidu.live.sdk.goods.b;

import android.text.TextUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.goods.message.GetSingleGoodsHttpResponseMessage;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
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
public class d extends BdBaseModel {
    private List<com.baidu.live.sdk.goods.a.a> blP;
    private HttpMessageListener blS;
    HttpMessageListener blV;
    private c blW;
    private int mCount;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.blS = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage);
            }
        };
        this.blV = new HttpMessageListener(1021201) { // from class: com.baidu.live.sdk.goods.b.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.d(httpResponsedMessage);
            }
        };
        this.blP = null;
        this.mCount = 0;
    }

    public void init() {
        MessageManager.getInstance().registerListener(this.blS);
        MessageManager.getInstance().registerListener(this.blV);
    }

    public void a(c cVar) {
        this.blW = cVar;
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
        MessageManager.getInstance().unRegisterListener(this.blS);
        MessageManager.getInstance().unRegisterListener(this.blV);
    }

    public void a(String str, long j, boolean z, boolean z2, long j2, String str2, String str3, String str4) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) {
            com.baidu.live.sdk.goods.message.c cVar = new com.baidu.live.sdk.goods.message.c();
            cVar.aPZ = str;
            cVar.liveId = j;
            cVar.blL = z2;
            cVar.isHost = z;
            cVar.authorId = j2;
            cVar.tab = str2;
            cVar.tag = str3;
            cVar.source = str4;
            cVar.setParams();
            MessageManager.getInstance().sendMessage(cVar);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", "goods_list", z ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HttpResponsedMessage httpResponsedMessage) {
        if (!(httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
            a(httpResponsedMessage, false, "data_error", "goods_list");
            return;
        }
        GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
        com.baidu.live.sdk.goods.message.c cVar = (com.baidu.live.sdk.goods.message.c) httpResponsedMessage.getOrginalMessage();
        long j = cVar.liveId;
        String str = cVar.aPZ;
        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
            a(httpResponsedMessage, false, ETAG.KEY_NET_ERROR, "goods_list");
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(j));
            alaStatsItem.addValue("feedid", str);
            alaStatsItem.addValue("err", Integer.valueOf(getVideoGoodsListHttpResponseMessage.getError()));
            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, getVideoGoodsListHttpResponseMessage.getErrorString());
            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
            return;
        }
        this.blP = getVideoGoodsListHttpResponseMessage.blM;
        this.mCount = getVideoGoodsListHttpResponseMessage.count;
        a(httpResponsedMessage, false, null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
        if (this.blW != null) {
            this.blW.a(getVideoGoodsListHttpResponseMessage.getError(), getVideoGoodsListHttpResponseMessage.getErrorString(), cVar.blL, j, getVideoGoodsListHttpResponseMessage.count, getVideoGoodsListHttpResponseMessage.blM);
        }
    }

    private void a(HttpResponsedMessage httpResponsedMessage, boolean z, String str, String str2) {
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
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, z ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void c(String str, long j, String str2) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j > 0) {
            com.baidu.live.sdk.goods.message.b bVar = new com.baidu.live.sdk.goods.message.b();
            bVar.aPZ = str;
            bVar.liveId = j;
            bVar.c(j, str, str2);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof GetSingleGoodsHttpResponseMessage) {
            GetSingleGoodsHttpResponseMessage getSingleGoodsHttpResponseMessage = (GetSingleGoodsHttpResponseMessage) httpResponsedMessage;
            if (this.blW != null) {
                this.blW.c(getSingleGoodsHttpResponseMessage.blK);
            }
        }
    }
}
