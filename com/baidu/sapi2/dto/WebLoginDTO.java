package com.baidu.sapi2.dto;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class WebLoginDTO extends SapiWebDTO {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT = "extra_join_login_without_third_account";
    public static final String EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT = "extra_join_login_with_third_account";
    public static final String EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL = "extra_login_with_name_phone_email";
    public static final String EXTRA_LOGIN_WITH_SMS = "extra_login_with_sms";
    public static final String EXTRA_LOGIN_WITH_USERNAME = "extra_login_with_username";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, String> agreement;
    public int businessType;
    public Config config;
    public String encryptedId;
    public String extraJson;
    public List<PassNameValuePair> extraParams;
    public boolean finishActivityAfterSuc;
    public boolean hideSuccessTip;
    public boolean isAcceptBrowseModeAgreement;
    public boolean isWithYouthStyle;
    public String loginType;
    public String preSetUname;
    public int screenType;
    public boolean shareV2Disable;
    public String statExtra;
    public String uid;

    /* loaded from: classes3.dex */
    public static class Config {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<FastLoginFeature> fastLoginFeatureList;
        public boolean supportTouchGuide;

        public Config() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.supportTouchGuide = true;
        }
    }

    public WebLoginDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loginType = EXTRA_LOGIN_WITH_USERNAME;
        this.finishActivityAfterSuc = true;
        this.extraParams = new ArrayList();
        this.shareV2Disable = false;
        this.businessType = 0;
        this.screenType = 0;
    }

    public static String getStatExtraDecode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return TextUtils.isEmpty(str) ? "" : URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean statExtraValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? SapiUtils.statExtraValid(str) : invokeL.booleanValue;
    }
}
