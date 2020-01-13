package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.c;
import com.baidu.live.data.d;
import com.baidu.live.gift.h;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.e;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.util.ISingleRunnableCallback;
import com.baidu.live.tbadk.util.SingleRunnable;
import com.baidu.live.tbadk.util.TbSingleExecutor;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends BdBaseModel {
    private HttpMessageListener akw;
    private a aky;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<c> arrayList2, ArrayList<d> arrayList3);
    }

    public b(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.akw = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                    b.this.a(alaSdkGetGiftListHttpResponseMessage.getSceneFrom(), alaSdkGetGiftListHttpResponseMessage, false);
                }
            }
        };
        this.akw.setTag(bdPageContext.getUniqueId());
        registerListener(this.akw);
    }

    public void i(final String str, final boolean z) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: sX */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                BdKVCache<String> stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
                if (stringCacheWithSapce == null) {
                    return null;
                }
                String str2 = stringCacheWithSapce.get(h.f(str, 0L));
                if (str2 == null || str2.length() == 0) {
                    return null;
                }
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
                try {
                    alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(str2), true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return alaSdkGetGiftListHttpResponseMessage;
            }
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: a */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage != null && !ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.tp())) {
                    b.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                    if (z) {
                        b.this.ds(str);
                        return;
                    }
                    return;
                }
                b.this.ds(str);
            }
        });
    }

    public void ds(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.live.gift.b.b.ta().td();
        }
        sendMessage(new e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage, boolean z) {
        com.baidu.live.gift.b.b.ta().f(str, alaSdkGetGiftListHttpResponseMessage.tp());
        if (this.aky != null) {
            this.aky.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.tp(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.tq());
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
        MessageManager.getInstance().unRegisterListener(this.akw);
    }

    public void a(a aVar) {
        this.aky = aVar;
    }
}
