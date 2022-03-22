package com.baidu.sofire;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.MethodImpl;
import com.baidu.sofire.mutiprocess.SubProcessManager;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.DbUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MyProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUNDLE_AGREE_POLICY = "_agree_policy";
    public static final String BUNDLE_KEY_HANDLE_FLAG = "handle_flag";
    public static final String BUNDLE_KEY_SERVER_VERSION = "server_version";
    public static final String BUNDLE_KEY_ZID = "_zid";
    public static final String CALL_METHOD_SET_AGREE_POLICY = "setAgreePolicy";
    public static final String CALL_METHOD_ZID = "getRemoteZid";
    public static final String METHOD_CALL_ARGS = "args";
    public static final String METHOD_CALL_RESULT = "result";
    public static boolean sIsProviderProcess;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1258633103, "Lcom/baidu/sofire/MyProvider;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1258633103, "Lcom/baidu/sofire/MyProvider;");
        }
    }

    public MyProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isProviderProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sIsProviderProcess : invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Bundle ppcall;
        String callingPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
            try {
                if ((Build.VERSION.SDK_INT < 19 || (callingPackage = getCallingPackage()) == null || callingPackage.equals(getContext().getPackageName())) && !TextUtils.isEmpty(str)) {
                    if (CALL_METHOD_SET_AGREE_POLICY.equals(str)) {
                        MethodImpl.setAgreePolicy(getContext(), bundle.getBoolean(BUNDLE_AGREE_POLICY, true));
                        ppcall = new Bundle();
                        ppcall.putBoolean(BUNDLE_KEY_HANDLE_FLAG, true);
                    } else if (SharedPreferenceManager.PROVIDER_METHOD_CALL_PREFERENCE.equals(str)) {
                        ppcall = SharedPreferenceManager.getInstance(getContext()).handleRemoteCall(bundle);
                        if (ppcall == null) {
                            ppcall = new Bundle();
                        }
                        ppcall.putBoolean(BUNDLE_KEY_HANDLE_FLAG, true);
                    } else if (str.startsWith(SubProcessManager.CALL_METHOD_SUB_PROCESS_PREFIX)) {
                        ppcall = SubProcessManager.handleProviderWork(str, str2, bundle);
                        if (ppcall == null) {
                            ppcall = new Bundle();
                        }
                        ppcall.putBoolean(BUNDLE_KEY_HANDLE_FLAG, true);
                    } else if (CALL_METHOD_ZID.equals(str)) {
                        String cuid = DbUtil.getCUID(getContext());
                        new Bundle();
                        Bundle bundle2 = new Bundle();
                        if (!TextUtils.isEmpty(cuid)) {
                            bundle2.putString(BUNDLE_KEY_ZID, cuid);
                        }
                        bundle2.putBoolean(BUNDLE_KEY_HANDLE_FLAG, true);
                        ppcall = bundle2;
                    } else {
                        ppcall = MethodImpl.ppcall(getContext().getApplicationContext(), str, str2, bundle);
                    }
                    if (ppcall != null) {
                        ppcall.putString(BUNDLE_KEY_SERVER_VERSION, LocalConstant.V);
                    }
                    return ppcall;
                }
                return null;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            sIsProviderProcess = true;
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, uri, strArr, str, strArr2, str2)) == null) {
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
