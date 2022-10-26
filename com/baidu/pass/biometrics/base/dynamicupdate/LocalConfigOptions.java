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
/* loaded from: classes2.dex */
public class LocalConfigOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ILLUM_GRAY = -1;
    public static final int DEFAULT_ILLUM_VALUE = 8;
    public static final String d = "pass_face_sdk";
    public static final String e = "illum_gray";
    public static LocalConfigOptions f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public SharedPreferences b;
    public Context c;

    public LocalConfigOptions(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context.getApplicationContext();
        this.b = context.getApplicationContext().getSharedPreferences("bio_pass_face_system", 0);
    }

    public void setBioOptions(SdkConfigOptions sdkConfigOptions) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, sdkConfigOptions) == null) && sdkConfigOptions != null) {
            Log.e("actions-setBioOptions", sdkConfigOptions);
            a(d, PassBioDataEncryptor.encryptAccountInfo(sdkConfigOptions.toJSON().toString(), a(this.c)));
        }
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                try {
                    this.a = SecurityUtil.md5((context.getPackageName() + PassBiometricUtil.getPackageSign(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
            return this.a;
        }
        return (String) invokeL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            return this.b.getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public static LocalConfigOptions getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f == null) {
                f = new LocalConfigOptions(context);
            }
            return f;
        }
        return (LocalConfigOptions) invokeL.objValue;
    }

    public void setIllumValueGray(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            put(e, i);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            this.b.edit().putString(str, str2).apply();
        }
    }

    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            return this.b.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public void put(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            this.b.edit().putInt(str, i).apply();
        }
    }

    public SdkConfigOptions getBioOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = a(d);
            if (!TextUtils.isEmpty(a)) {
                String decryptAccountInfo = PassBioDataEncryptor.decryptAccountInfo(a, a(this.c));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getInt(e, -1);
        }
        return invokeV.intValue;
    }
}
