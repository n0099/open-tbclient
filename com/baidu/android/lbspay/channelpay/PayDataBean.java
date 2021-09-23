package com.baidu.android.lbspay.channelpay;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class PayDataBean implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int alipayVersion;
    public String appid;
    public String appurl;
    public String auth_appurl;
    public String channel_code;
    public String new_baifubao_auth_pay;
    public String noncestr;
    public String packagealias;
    public String params;
    public String partnerid;
    public int paytype;
    public String payurl;
    public String prepayid;
    public String sign;
    public String timestamp;
    public String tn;
    public String transid;
    public String url;

    public PayDataBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean isAliAuthPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ALIPAY-WISE-AUTH-SIGN".equals(this.channel_code) && !TextUtils.isEmpty(this.auth_appurl) : invokeV.booleanValue;
    }

    public boolean isBaifubaoAuthPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "BAIFUBAO-WISE-AUTH-SIGN".equals(this.channel_code) && TextUtils.equals("1", this.new_baifubao_auth_pay) : invokeV.booleanValue;
    }
}
