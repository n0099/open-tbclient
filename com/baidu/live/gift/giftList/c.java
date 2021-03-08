package com.baidu.live.gift.giftList;

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
import com.baidu.live.gift.ac;
import com.baidu.live.gift.h;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.f;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private HttpMessageListener bgr;
    private a bgu;
    private boolean bgv;
    private BdUniqueId bgw;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public c(BdPageContext bdPageContext) {
        super(bdPageContext);
        this.bgv = false;
        this.bgw = BdUniqueId.gen();
        this.bgr = new HttpMessageListener(1021120) { // from class: com.baidu.live.gift.giftList.c.1
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
        this.bgr.setTag(bdPageContext.getUniqueId());
        registerListener(this.bgr);
    }

    public void a(String str, boolean z, String str2, String str3) {
        String Fv = ac.Fv();
        if (Fv == null || Fv.length() == 0) {
            this.bgv = false;
            q(str, str2, str3);
            return;
        }
        AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
        try {
            alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(Fv), true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (alaSdkGetGiftListHttpResponseMessage == null || ListUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HF())) {
            this.bgv = false;
            q(str, str2, str3);
            return;
        }
        this.bgv = true;
        a(str, alaSdkGetGiftListHttpResponseMessage, true);
        if (z) {
            q(str, str2, str3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(String str, String str2, String str3) {
        String str4;
        Address address;
        String Fs = StringUtils.isNull(str) ? com.baidu.live.gift.c.b.Hu().Fs() : str;
        String str5 = "";
        String str6 = "";
        ab Fu = ac.Fu();
        if (Fu != null) {
            if (Fu.mLiveInfo != null) {
                str5 = String.valueOf(Fu.mLiveInfo.live_id);
            }
            if (Fu.aJD != null) {
                str6 = String.valueOf(Fu.aJD.userId);
                str4 = str5;
                f fVar = new f(Fs, str4, str6, str2, str3);
                fVar.setTag(this.bgw);
                address = BdLocationMananger.getInstance().getAddress(false);
                if (address == null) {
                    fVar.b(address.getLongitude(), address.getLatitude());
                } else {
                    fVar.b(0.0d, 0.0d);
                }
                sendMessage(fVar);
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_GIFT_LIST_REQ, UbcStatConstant.ContentType.UBC_TYPE_GIFT_NORMAL_LIST, "liveroom", ""));
            }
        }
        str4 = str5;
        f fVar2 = new f(Fs, str4, str6, str2, str3);
        fVar2.setTag(this.bgw);
        address = BdLocationMananger.getInstance().getAddress(false);
        if (address == null) {
        }
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
                jSONObject3.put(PushMessageHelper.ERROR_TYPE, "net_error");
                jSONObject.put("result", jSONObject3);
                jSONObject2 = jSONObject3;
            } catch (JSONException e) {
                BdLog.e(e);
                jSONObject2 = jSONObject3;
            }
        } else if (alaSdkGetGiftListHttpResponseMessage.HF() == null || alaSdkGetGiftListHttpResponseMessage.HF().isEmpty() || alaSdkGetGiftListHttpResponseMessage.getCategoryList() == null || alaSdkGetGiftListHttpResponseMessage.getCategoryList().isEmpty()) {
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
            if (!TextUtils.isEmpty(alaSdkGetGiftListHttpResponseMessage.HH())) {
                try {
                    jSONObject2.put("req_loc", alaSdkGetGiftListHttpResponseMessage.HH());
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
        com.baidu.live.gift.c.b.Hu().e(str, alaSdkGetGiftListHttpResponseMessage.HF());
        if (this.bgu != null) {
            this.bgu.a(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString(), z, alaSdkGetGiftListHttpResponseMessage.HF(), alaSdkGetGiftListHttpResponseMessage.getCategoryList(), alaSdkGetGiftListHttpResponseMessage.HG(), alaSdkGetGiftListHttpResponseMessage.Ou());
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
        MessageManager.getInstance().unRegisterListener(this.bgr);
    }

    public void a(a aVar) {
        this.bgu = aVar;
    }
}
