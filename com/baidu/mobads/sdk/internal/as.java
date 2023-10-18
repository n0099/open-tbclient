package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class as extends av.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "debug";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "debug" : (String) invokeV.objValue;
    }

    public as() {
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

    public static void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i, str, str2) == null) {
            try {
                if (i == 7) {
                    Log.wtf(str, str2);
                } else {
                    Log.println(i, str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public void a(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) {
            a(i, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    public boolean a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            return av.a.equals(str);
        }
        return invokeLI.booleanValue;
    }
}
