package com.baidu.android.lbspay.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CashierDataNew mCashierData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCashierBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            execBean(NewCashierContent.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getZhiFuHost() + "/proxy/req/newcashier";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean isLbsPayBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setmCashierData(CashierDataNew cashierDataNew) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cashierDataNew) == null) {
            this.mCashierData = cashierDataNew;
        }
    }
}
