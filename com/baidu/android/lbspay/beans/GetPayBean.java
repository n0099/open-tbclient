package com.baidu.android.lbspay.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetPayBean extends PayBaseBean<GetPayContent> {
    public NewCashierContent mCashierContent;
    public CashierDataNew mCashierData;
    public NewCashierContent.IBaseChannel mChannel;
    public List<RestNameValuePair> mParam;
    public String mReqData;

    public GetPayBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        execBean(GetPayContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> list = this.mParam;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.mReqData)) {
            CashierDataNew cashierDataNew = this.mCashierData;
            if (cashierDataNew != null) {
                cashierDataNew.addParams(arrayList);
            }
            try {
                JSONObject jSONObject2 = new JSONObject(this.mReqData);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    jSONObject.put(valueOf, jSONObject2.get(valueOf));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (this.mChannel == null) {
            return arrayList;
        } else {
            CashierDataNew cashierDataNew2 = this.mCashierData;
            if (cashierDataNew2 != null) {
                cashierDataNew2.addParams(arrayList);
            }
            try {
                if (!TextUtils.isEmpty(this.mChannel.getChannelAlias())) {
                    jSONObject.put("payChannel", this.mChannel.getChannelAlias());
                }
                jSONObject.put("token", this.mCashierContent.bdstoken);
                if (!TextUtils.isEmpty(this.mChannel.getBankId())) {
                    jSONObject.put("quickpay_bank_id", this.mChannel.getBankId());
                }
                if (!TextUtils.isEmpty(this.mChannel.getShortCard())) {
                    jSONObject.put("quickpay_short_card", this.mChannel.getShortCard());
                }
                if (!TextUtils.isEmpty(this.mChannel.getUc_ext())) {
                    jSONObject.put("uc_ext", this.mChannel.getUc_ext());
                }
            } catch (Exception unused) {
            }
        }
        try {
            jSONObject.put("ua", BussinessUtils.getUA(this.mContext));
            jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(this.mContext)));
            jSONObject.put("wcp", PhoneUtils.getWCPParams(this.mContext));
            jSONObject.put("key", SafePay.getInstance().getpwProxy());
            String cookie = PayUtils.getCookie(this.mContext);
            if (!TextUtils.isEmpty(cookie)) {
                jSONObject.put(NetworkBean.PARAM_COOKIE, SafePay.getInstance().encryptProxy(cookie));
            } else {
                jSONObject.put(NetworkBean.PARAM_COOKIE, "");
            }
            String newCookie = PayUtils.getNewCookie(this.mContext);
            if (!TextUtils.isEmpty(newCookie)) {
                jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, SafePay.getInstance().encryptProxy(newCookie));
            } else {
                jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, "");
            }
            if (WalletLoginHelper.getInstance().isLogin()) {
                jSONObject.put("preOrder", "1");
            } else {
                jSONObject.put("preOrder", "0");
            }
            if (WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint()) {
                jSONObject.put("enroll_fingerprint", "1");
            }
        } catch (Exception unused2) {
        }
        arrayList.add(new RestNameValuePair("reqData", jSONObject.toString()));
        this.mParam = arrayList;
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 2;
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        return super.getRequestParams();
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getZhiFuHost() + "/proxy/req/getpay";
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean isLbsPayBean() {
        return true;
    }

    public void setmCashierContent(NewCashierContent newCashierContent) {
        this.mCashierContent = newCashierContent;
    }

    public void setmCashierData(CashierDataNew cashierDataNew) {
        this.mCashierData = cashierDataNew;
    }

    public void setmChannel(NewCashierContent.IBaseChannel iBaseChannel) {
        this.mChannel = iBaseChannel;
    }

    public void setmReqData(String str) {
        this.mReqData = str;
    }
}
