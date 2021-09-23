package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LocalConfigOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ILLUM_VALUE = 8;

    /* renamed from: d  reason: collision with root package name */
    public static final String f44038d = "pass_face_sdk";

    /* renamed from: e  reason: collision with root package name */
    public static final String f44039e = "illum_gray";

    /* renamed from: f  reason: collision with root package name */
    public static LocalConfigOptions f44040f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44041a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f44042b;

    /* renamed from: c  reason: collision with root package name */
    public Context f44043c;

    public LocalConfigOptions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44043c = context.getApplicationContext();
        this.f44042b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f44042b.getString(str, "") : (String) invokeL.objValue;
    }

    public static LocalConfigOptions getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f44040f == null) {
                f44040f = new LocalConfigOptions(context);
            }
            return f44040f;
        }
        return (LocalConfigOptions) invokeL.objValue;
    }

    public SdkConfigOptions getBioOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = a(f44038d);
            if (!TextUtils.isEmpty(a2)) {
                String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a2, a(this.f44043c));
                if (!TextUtils.isEmpty(decryptAccountInfo)) {
                    try {
                        return SdkConfigOptions.fromLocalJson(new JSONObject(decryptAccountInfo));
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
            }
            return new SdkConfigOptions();
        }
        return (SdkConfigOptions) invokeV.objValue;
    }

    public int getIllumVlaueGray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getInt(f44039e, -1) : invokeV.intValue;
    }

    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) ? this.f44042b.getInt(str, i2) : invokeLI.intValue;
    }

    public void put(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            this.f44042b.edit().putInt(str, i2).apply();
        }
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, sdkConfigOptions) == null) || sdkConfigOptions == null) {
            return;
        }
        Log.e("actions-setBioOptions", sdkConfigOptions);
        a(f44038d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.f44043c)));
    }

    public void setIllumValueGray(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            put(f44039e, i2);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            this.f44042b.edit().putString(str, str2).apply();
        }
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            if (TextUtils.isEmpty(this.f44041a)) {
                try {
                    this.f44041a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
            return this.f44041a;
        }
        return (String) invokeL.objValue;
    }
}
