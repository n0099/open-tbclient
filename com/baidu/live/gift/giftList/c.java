package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.e;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ISingleRunnableCallback;
import com.baidu.live.tbadk.util.SingleRunnable;
import com.baidu.live.tbadk.util.TbSingleExecutor;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends BdBaseModel {
    private HttpMessageListener aKU;
    private a aKW;
    private boolean aKX;
    private BdUniqueId aKY;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<f> arrayList2, ArrayList<g> arrayList3);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.aKX = false;
        this.aKY = BdUniqueId.gen();
        this.aKU = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                    c.this.a(alaSdkGetGiftListHttpResponseMessage.getSceneFrom(), alaSdkGetGiftListHttpResponseMessage, false);
                    c.this.a(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        };
        this.aKU.setTag(bdPageContext.getUniqueId());
        registerListener(this.aKU);
    }

    public void a(final String str, final boolean z, final String str2, final String str3) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: Ae */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                BdKVCache<String> stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
                if (stringCacheWithSapce == null) {
                    return null;
                }
                String str4 = stringCacheWithSapce.get(h.f(str, 0L));
                if (str4 == null || str4.length() == 0) {
                    return null;
                }
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
                try {
                    alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(str4), true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return alaSdkGetGiftListHttpResponseMessage;
            }
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: b */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.At())) {
                    c.this.aKX = false;
                    c.this.m(str, str2, str3);
                    return;
                }
                c.this.aKX = true;
                c.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                if (z) {
                    c.this.m(str, str2, str3);
                }
            }
        });
    }

    public void m(String str, String str2, String str3) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.live.gift.b.b.Ah().yr();
        }
        e eVar = new e(str, str2, str3);
        eVar.setTag(this.aKY);
        sendMessage(eVar);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (alaSdkGetGiftListHttpResponseMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                jSONObject2.put("result", jSONObject3);
                jSONObject = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject = jSONObject3;
            }
        } else if (alaSdkGetGiftListHttpResponseMessage.At() == null || alaSdkGetGiftListHttpResponseMessage.At().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                jSONObject2.put("result", jSONObject4);
                jSONObject = jSONObject4;
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject = jSONObject4;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Av())) {
                try {
                    jSONObject.put("req_loc", alaSdkGetGiftListHttpResponseMessage.Av());
                    jSONObject2.put("result", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", null).setContentExt(jSONObject2), alaSdkGetGiftListHttpResponseMessage, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage, boolean z) {
        com.baidu.live.gift.b.b.Ah().e(str, alaSdkGetGiftListHttpResponseMessage.At());
        if (this.aKW != null) {
            this.aKW.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.At(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.Au());
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().removeMessage(1021120, getUniqueId());
        return false;
    }

    public void onDestroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.aKU);
    }

    public void a(a aVar) {
        this.aKW = aVar;
    }
}
