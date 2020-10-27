package com.baidu.live.yuyingift.giftlist;

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
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.f;
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
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a bLl;
    private HttpMessageListener bbi;
    private boolean bbl;
    private BdUniqueId bbm;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public b(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.bbl = false;
        this.bbm = BdUniqueId.gen();
        this.bbi = new HttpMessageListener(1021120) { // from class: com.baidu.live.yuyingift.giftlist.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                    b.this.a(alaSdkGetGiftListHttpResponseMessage.getSceneFrom(), alaSdkGetGiftListHttpResponseMessage, false);
                    b.this.a(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        };
        this.bbi.setTag(bdPageContext.getUniqueId());
        registerListener(this.bbi);
    }

    public void a(final String str, final boolean z, final String str2, final String str3) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.yuyingift.giftlist.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: IB */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                BdKVCache<String> stringCacheWithSapce = DBKVCacheManager.getInstance().getStringCacheWithSapce(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
                if (stringCacheWithSapce == null) {
                    return null;
                }
                String str4 = stringCacheWithSapce.get(com.baidu.live.gift.h.e(str, 0L));
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
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.yuyingift.giftlist.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: b */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IO())) {
                    b.this.bbl = false;
                    b.this.o(str, str2, str3);
                    return;
                }
                b.this.bbl = true;
                b.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                if (z) {
                    b.this.o(str, str2, str3);
                }
            }
        });
    }

    public void o(String str, String str2, String str3) {
        String str4;
        String GK = StringUtils.isNull(str) ? com.baidu.live.yuyingift.b.b.Vf().GK() : str;
        String str5 = "";
        String str6 = "";
        w GM = ai.GM();
        if (GM != null) {
            if (GM.mLiveInfo != null) {
                str5 = String.valueOf(GM.mLiveInfo.live_id);
            }
            if (GM.aIe != null) {
                str6 = String.valueOf(GM.aIe.userId);
                str4 = str5;
                f fVar = new f(GK, str4, str6, str2, str3);
                fVar.setTag(this.bbm);
                sendMessage(fVar);
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, UbcStatConstant.Page.VOICE_ROOM, null));
            }
        }
        str4 = str5;
        f fVar2 = new f(GK, str4, str6, str2, str3);
        fVar2.setTag(this.bbm);
        sendMessage(fVar2);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, UbcStatConstant.Page.VOICE_ROOM, null));
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
        } else if (alaSdkGetGiftListHttpResponseMessage.IO() == null || alaSdkGetGiftListHttpResponseMessage.IO().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
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
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IQ())) {
                try {
                    jSONObject.put("req_loc", alaSdkGetGiftListHttpResponseMessage.IQ());
                    jSONObject2.put("result", jSONObject);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, UbcStatConstant.Page.VOICE_ROOM, null).setContentExt(jSONObject2), alaSdkGetGiftListHttpResponseMessage, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage, boolean z) {
        com.baidu.live.yuyingift.b.b.Vf().e(str, alaSdkGetGiftListHttpResponseMessage.IO());
        if (this.bLl != null) {
            this.bLl.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.IO(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.IP(), alaSdkGetGiftListHttpResponseMessage.NF());
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
        MessageManager.getInstance().unRegisterListener(this.bbi);
    }

    public void a(a aVar) {
        this.bLl = aVar;
    }
}
