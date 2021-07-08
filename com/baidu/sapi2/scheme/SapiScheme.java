package com.baidu.sapi2.scheme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class SapiScheme {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_SC_APP_OTP = "otp";
    public static final String EXTRA_ACHIEVE_SC_APP_DATA = "achieve_sc_app_data";
    public static final int REQUEST_CODE_START_SC_APP_VERIFY = 3001;
    public static final String SCHEME_CUR_SUP_SC_MIN_APP_VERSION = "3.0.5";
    public static final int SCHEME_PROTOCOL_VER = 2;
    public static final String SCHEME_SUP_MIN_SC_APP_VER = "3.0.5";
    public static final String SC_APP_PACKAGENAME = "com.baidu.passport.securitycenter";
    public static final String SC_APP_SCHEME = "baiduppscapp";
    public static final int SC_APP_STATE_APP_NOT_INVALID = 3;
    public static final int SC_APP_STATE_CAN_INVOKE = 0;
    public static final int SC_APP_STATE_NEED_UPGRADE = 1;
    public static final int SC_APP_STATE_UNINSTALLED = 2;
    public static final int SC_APP_STATE_UNSUP_INVOKE_SC = 4;
    public static final String TAG = "SapiScheme";
    public transient /* synthetic */ FieldHolder $fh;
    public SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult;
    public SchemeResult schemeResult;

    public SapiScheme() {
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

    private String buildResult(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, str)) == null) {
            SchemeResult schemeResult = new SchemeResult();
            this.schemeResult = schemeResult;
            schemeResult.setResultCode(i2);
            this.schemeResult.setResultMsg(str);
            return this.schemeResult.toJson();
        }
        return (String) invokeIL.objValue;
    }

    private String buildScheme(String str, String str2, List<PassNameValuePair> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, str2, list)) == null) {
            String str3 = "baiduppscapp://v2/" + str + "?";
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new PassNameValuePair("minver", str2));
            return str3 + SapiUtils.createRequestParams(list);
        }
        return (String) invokeLLL.objValue;
    }

    private void startActivityForResult(Activity activity, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, activity, str) == null) {
            activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), 3001);
        }
    }

    public boolean checkPackageSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(SapiContext.getInstance().getAuthorizedPackages());
                hashMap.putAll(SapiContext.getInstance().getSCAuthorizedPackages());
                String packageSign = SapiUtils.getPackageSign(context, str);
                if (!TextUtils.isEmpty(packageSign)) {
                    for (String str2 : hashMap.keySet()) {
                        if (str.matches(str2) && packageSign.equals(hashMap.get(str2))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public int getInvokeScState(Context context, String str, SapiWebView.InvokeScAppCallback invokeScAppCallback) {
        InterceptResult invokeLLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, invokeScAppCallback)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(SC_APP_PACKAGENAME, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                if (SapiUtils.versionCompareTo(packageInfo.versionName, str) < 0) {
                    return 1;
                }
                if (invokeScAppCallback == null) {
                    return 4;
                }
                return !checkPackageSign(context, context.getPackageName()) ? 3 : 0;
            }
            return 2;
        }
        return invokeLLL.intValue;
    }

    public void invokeScApp(Activity activity, String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, str2, list, invokeScAppResult) == null) {
            this.invokeScAppResult = invokeScAppResult;
            SapiScheme sapiScheme = new SapiScheme();
            if (!sapiScheme.checkPackageSign(activity, SC_APP_PACKAGENAME)) {
                this.invokeScAppResult.setInvokeResult(buildResult(SchemeResult.ERROR_CODE_SC_PACKAGE_SIGN_ERROR, SchemeResult.ERROR_MSG_SC_PACKAGE_SIGN_ERROR));
                return;
            }
            try {
                sapiScheme.startActivityForResult(activity, sapiScheme.buildScheme(str, str2, list));
            } catch (Exception unused) {
                this.invokeScAppResult.setInvokeResult(buildResult(SchemeResult.ERROR_CODE_SYSTEM_ERROR, SchemeResult.ERROR_MSG_SYSTEM_ERROR));
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) || this.invokeScAppResult == null) {
            return;
        }
        this.invokeScAppResult.setInvokeResult(intent != null ? intent.getExtras().getString(EXTRA_ACHIEVE_SC_APP_DATA) : null);
    }
}
