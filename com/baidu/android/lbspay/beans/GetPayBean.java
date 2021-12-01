package com.baidu.android.lbspay.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.network.NewCashierContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetPayBean extends BaseBean<GetPayContent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewCashierContent mCashierContent;
    public CashierDataNew mCashierData;
    public NewCashierContent.IBaseChannel mChannel;
    public List<RestNameValuePair> mParam;
    public String mReqData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPayBean(Context context) {
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

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            execBean(GetPayContent.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                jSONObject.put("key", SecurePay.getInstance().getpwProxy());
                String cookie = PayUtils.getCookie(this.mContext);
                if (!TextUtils.isEmpty(cookie)) {
                    jSONObject.put(NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie));
                } else {
                    jSONObject.put(NetworkBean.PARAM_COOKIE, "");
                }
                String newCookie = PayUtils.getNewCookie(this.mContext);
                if (!TextUtils.isEmpty(newCookie)) {
                    jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, SecurePay.getInstance().encryptProxy(newCookie));
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
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean, com.dxmpay.apollon.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.getRequestParams() : (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return DomainConfig.getInstance().getZhiFuHost() + "/proxy/req/getpay";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public boolean isLbsPayBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setmCashierContent(NewCashierContent newCashierContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, newCashierContent) == null) {
            this.mCashierContent = newCashierContent;
        }
    }

    public void setmCashierData(CashierDataNew cashierDataNew) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cashierDataNew) == null) {
            this.mCashierData = cashierDataNew;
        }
    }

    public void setmChannel(NewCashierContent.IBaseChannel iBaseChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iBaseChannel) == null) {
            this.mChannel = iBaseChannel;
        }
    }

    public void setmReqData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mReqData = str;
        }
    }
}
