package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sofire.ac.FH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Security {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Security() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getZid(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            String gzfi = FH.gzfi(context, null, i);
            if (TextUtils.isEmpty(gzfi)) {
                return "NoZidYet";
            }
            return gzfi;
        }
        return (String) invokeLI.objValue;
    }

    public String encryptSsoHash(Long l, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, l, str, str2)) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            String packageName = confignation.context.getPackageName();
            String packageSign = SapiUtils.getPackageSign(confignation.context, packageName);
            String packageSign2 = SapiUtils.getPackageSign(confignation.context, str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "native");
                jSONObject.put("timestamp", l);
                jSONObject.put("host_api_key", confignation.bdOauthAppId);
                jSONObject.put("host_pkgname", packageName);
                jSONObject.put("host_key_hash", packageSign);
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount == null) {
                    str3 = "";
                } else {
                    str3 = currentAccount.bduss;
                }
                jSONObject.put("bduss_sign", SecurityUtil.md5(str3.getBytes(), false));
                jSONObject.put("pkgname", str);
                jSONObject.put("key_hash", packageSign2);
                jSONObject.put("app_id", str2);
            } catch (JSONException e) {
                Log.e(e);
            }
            String md5 = SecurityUtil.md5(("as#JU*342ns" + str2 + "#$FW34sfs").getBytes(), false);
            try {
                return SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(jSONObject.toString(), new StringBuffer(md5.substring(md5.length() - 16, md5.length())).reverse().toString(), md5.substring(0, 16)));
            } catch (Exception e2) {
                Log.e(e2);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
