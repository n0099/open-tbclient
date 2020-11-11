package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.h;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.f;
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
public class c extends BdBaseModel {
    private HttpMessageListener bcA;
    private a bcC;
    private boolean bcD;
    private BdUniqueId bcE;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.bcD = false;
        this.bcE = BdUniqueId.gen();
        this.bcA = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.c.3
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
        this.bcA.setTag(bdPageContext.getUniqueId());
        registerListener(this.bcA);
    }

    public void a(final String str, final boolean z, final String str2, final String str3) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: Jc */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                String Ho = aa.Ho();
                if (Ho == null || Ho.length() == 0) {
                    return null;
                }
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
                try {
                    alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(Ho), true);
                    return alaSdkGetGiftListHttpResponseMessage;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return alaSdkGetGiftListHttpResponseMessage;
                }
            }
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: b */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Jp())) {
                    c.this.bcD = false;
                    c.this.o(str, str2, str3);
                    return;
                }
                c.this.bcD = true;
                c.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                if (z) {
                    c.this.o(str, str2, str3);
                }
            }
        });
    }

    public void o(String str, String str2, String str3) {
        String str4;
        String Hl = StringUtils.isNull(str) ? com.baidu.live.gift.b.b.Je().Hl() : str;
        String str5 = "";
        String str6 = "";
        w Hn = aa.Hn();
        if (Hn != null) {
            if (Hn.mLiveInfo != null) {
                str5 = String.valueOf(Hn.mLiveInfo.live_id);
            }
            if (Hn.aIV != null) {
                str6 = String.valueOf(Hn.aIV.userId);
                str4 = str5;
                f fVar = new f(Hl, str4, str6, str2, str3);
                fVar.setTag(this.bcE);
                sendMessage(fVar);
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", ""));
            }
        }
        str4 = str5;
        f fVar2 = new f(Hl, str4, str6, str2, str3);
        fVar2.setTag(this.bcE);
        sendMessage(fVar2);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        if (alaSdkGetGiftListHttpResponseMessage.getError() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, ETAG.KEY_NET_ERROR);
                jSONObject.put("result", jSONObject3);
                jSONObject2 = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject2 = jSONObject3;
            }
        } else if (alaSdkGetGiftListHttpResponseMessage.Jp() == null || alaSdkGetGiftListHttpResponseMessage.Jp().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(PushMessageHelper.ERROR_TYPE, "list_empty");
                jSONObject.put("result", jSONObject4);
                jSONObject2 = jSONObject4;
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject2 = jSONObject4;
            }
        }
        if (jSONObject2 != null) {
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.Jr())) {
                try {
                    jSONObject2.put("req_loc", alaSdkGetGiftListHttpResponseMessage.Jr());
                    jSONObject.put("result", jSONObject2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_RESP, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", "").setContentExt(jSONObject), alaSdkGetGiftListHttpResponseMessage, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage, boolean z) {
        com.baidu.live.gift.b.b.Je().e(str, alaSdkGetGiftListHttpResponseMessage.Jp());
        if (this.bcC != null) {
            this.bcC.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.Jp(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.Jq(), alaSdkGetGiftListHttpResponseMessage.Of());
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
        MessageManager.getInstance().unRegisterListener(this.bcA);
    }

    public void a(a aVar) {
        this.bcC = aVar;
    }
}
