package com.baidu.live.yuyingift.giftlist;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.aj;
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
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    private a bZy;
    private HttpMessageListener beP;
    private boolean beS;
    private BdUniqueId beT;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public b(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.beS = false;
        this.beT = BdUniqueId.gen();
        this.beP = new HttpMessageListener(1021120) { // from class: com.baidu.live.yuyingift.giftlist.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                    if (!b.this.beS) {
                        b.this.a(alaSdkGetGiftListHttpResponseMessage.getSceneFrom(), alaSdkGetGiftListHttpResponseMessage, false);
                    }
                    b.this.a(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        };
        this.beP.setTag(bdPageContext.getUniqueId());
        registerListener(this.beP);
    }

    public void a(final String str, final boolean z, final String str2, final String str3) {
        TbSingleExecutor.execute(new SingleRunnable<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.yuyingift.giftlist.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.SingleRunnable
            /* renamed from: YR */
            public AlaSdkGetGiftListHttpResponseMessage doInBackground() {
                String Fs = aj.Fs();
                if (Fs == null || Fs.length() == 0) {
                    return null;
                }
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
                try {
                    alaSdkGetGiftListHttpResponseMessage.c(new JSONObject(Fs), true);
                    return alaSdkGetGiftListHttpResponseMessage;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return alaSdkGetGiftListHttpResponseMessage;
                }
            }
        }, new ISingleRunnableCallback<AlaSdkGetGiftListHttpResponseMessage>() { // from class: com.baidu.live.yuyingift.giftlist.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.tbadk.util.ISingleRunnableCallback
            /* renamed from: b */
            public void onReturnDataInUI(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage) {
                if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HC())) {
                    b.this.beS = false;
                    b.this.q(str, str2, str3);
                    return;
                }
                b.this.beS = true;
                b.this.a(str, alaSdkGetGiftListHttpResponseMessage, true);
                if (z) {
                    b.this.q(str, str2, str3);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(String str, String str2, String str3) {
        String str4;
        Address address;
        String Fp = StringUtils.isNull(str) ? com.baidu.live.yuyingift.b.b.YX().Fp() : str;
        String str5 = "";
        String str6 = "";
        ab Fr = aj.Fr();
        if (Fr != null) {
            if (Fr.mLiveInfo != null) {
                str5 = String.valueOf(Fr.mLiveInfo.live_id);
            }
            if (Fr.aId != null) {
                str6 = String.valueOf(Fr.aId.userId);
                str4 = str5;
                f fVar = new f(Fp, str4, str6, str2, str3);
                fVar.setTag(this.beT);
                address = BdLocationMananger.getInstance().getAddress(false);
                if (address == null) {
                    fVar.b(address.getLongitude(), address.getLatitude());
                } else {
                    fVar.b(0.0d, 0.0d);
                }
                sendMessage(fVar);
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, UbcStatConstant.Page.VOICE_ROOM, null));
            }
        }
        str4 = str5;
        f fVar2 = new f(Fp, str4, str6, str2, str3);
        fVar2.setTag(this.beT);
        address = BdLocationMananger.getInstance().getAddress(false);
        if (address == null) {
        }
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
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                jSONObject2.put("result", jSONObject3);
                jSONObject = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject = jSONObject3;
            }
        } else if (alaSdkGetGiftListHttpResponseMessage.HC() == null || alaSdkGetGiftListHttpResponseMessage.HC().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
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
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HE())) {
                try {
                    jSONObject.put("req_loc", alaSdkGetGiftListHttpResponseMessage.HE());
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
        com.baidu.live.yuyingift.b.b.YX().e(str, alaSdkGetGiftListHttpResponseMessage.HC());
        if (this.bZy != null) {
            this.bZy.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.HC(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.HD(), alaSdkGetGiftListHttpResponseMessage.Or());
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
        MessageManager.getInstance().unRegisterListener(this.beP);
    }

    public void a(a aVar) {
        this.bZy = aVar;
    }
}
