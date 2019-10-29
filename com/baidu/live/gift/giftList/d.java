package com.baidu.live.gift.giftList;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.h;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.util.ISingleRunnableCallback;
import com.baidu.live.tbadk.util.SingleRunnable;
import com.baidu.live.tbadk.util.TbSingleExecutor;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends BdBaseModel {
    private HttpMessageListener acf;
    private a acj;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3);
    }

    public d(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.acf = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                    d.this.a(alaSdkGetGiftListHttpResponseMessage.getSceneFrom(), alaSdkGetGiftListHttpResponseMessage, false);
                }
            }
        };
        this.acf.setTag(bdPageContext.getUniqueId());
        registerListener(this.acf);
    }

    public void f(final String str, final boolean z) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: qZ */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                BdKVCache<String> stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
                if (stringCacheWithSapce == null) {
                    return null;
                }
                String str2 = stringCacheWithSapce.get(b.h(str, 0L));
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
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: a */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage != null && !ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.qX())) {
                    d.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                    if (z) {
                        d.this.cy(str);
                        return;
                    }
                    return;
                }
                d.this.cy(str);
            }
        });
    }

    public void cy(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.live.gift.b.b.rc().rf();
        }
        sendMessage(new c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage, boolean z) {
        com.baidu.live.gift.b.b.rc().e(str, alaSdkGetGiftListHttpResponseMessage.qX());
        if (this.acj != null) {
            this.acj.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.qX(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.qY());
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
        MessageManager.getInstance().unRegisterListener(this.acf);
    }

    public void a(a aVar) {
        this.acj = aVar;
    }
}
