package com.baidu.android.lbspay.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewCashierBean extends PayBaseBean<NewCashierContent> {
    public CashierDataNew mCashierData;

    public NewCashierBean(Context context) {
        super(context);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        execBean(NewCashierContent.class);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        CashierDataNew cashierDataNew = this.mCashierData;
        if (cashierDataNew == null) {
            return arrayList;
        }
        cashierDataNew.addParams(arrayList);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", BussinessUtils.getUA(this.mContext));
            jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(this.mContext)));
            jSONObject.put("supportList", String.valueOf(343L));
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
            if (this.mCashierData.isShowAllPayType()) {
                jSONObject.put("bfb_only_but_show", "1");
            }
        } catch (Exception unused) {
        }
        arrayList.add(new RestNameValuePair("reqData", jSONObject.toString()));
        LogUtil.d("NewCashierBean.generateRequestParam!");
        return arrayList;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return 1;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        return DomainConfig.getInstance().getZhiFuHost() + "/proxy/req/newcashier";
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean isLbsPayBean() {
        return true;
    }

    public void setmCashierData(CashierDataNew cashierDataNew) {
        this.mCashierData = cashierDataNew;
    }
}
