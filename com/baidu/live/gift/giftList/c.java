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
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.i;
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
    private HttpMessageListener bbi;
    private a bbk;
    private boolean bbl;
    private BdUniqueId bbm;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.bbl = false;
        this.bbm = BdUniqueId.gen();
        this.bbi = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.c.3
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
        this.bbi.setTag(bdPageContext.getUniqueId());
        registerListener(this.bbi);
    }

    public void a(final String str, final boolean z, final String str2, final String str3) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.gift.giftList.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: IB */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                String GN = ab.GN();
                if (GN == null || GN.length() == 0) {
                    return null;
                }
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
                try {
                    alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(GN), true);
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
                if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IO())) {
                    c.this.bbl = false;
                    c.this.o(str, str2, str3);
                    return;
                }
                c.this.bbl = true;
                c.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                if (z) {
                    c.this.o(str, str2, str3);
                }
            }
        });
    }

    public void o(String str, String str2, String str3) {
        String str4;
        String GK = StringUtils.isNull(str) ? com.baidu.live.gift.b.b.ID().GK() : str;
        String str5 = "";
        String str6 = "";
        w GM = ab.GM();
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
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", ""));
            }
        }
        str4 = str5;
        f fVar2 = new f(GK, str4, str6, str2, str3);
        fVar2.setTag(this.bbm);
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
        } else if (alaSdkGetGiftListHttpResponseMessage.IO() == null || alaSdkGetGiftListHttpResponseMessage.IO().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
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
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.IQ())) {
                try {
                    jSONObject2.put("req_loc", alaSdkGetGiftListHttpResponseMessage.IQ());
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
        com.baidu.live.gift.b.b.ID().e(str, alaSdkGetGiftListHttpResponseMessage.IO());
        if (this.bbk != null) {
            this.bbk.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.IO(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.IP(), alaSdkGetGiftListHttpResponseMessage.NF());
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
        this.bbk = aVar;
    }
}
