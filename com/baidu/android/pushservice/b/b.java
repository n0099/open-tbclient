package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f2749a;

    /* renamed from: b  reason: collision with root package name */
    public String f2750b;

    /* renamed from: c  reason: collision with root package name */
    public String f2751c;

    public b(Context context) {
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
        this.f2749a = context;
    }

    public boolean a() {
        InterceptResult invokeV;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = new File(this.f2751c).exists() ? a.a(this.f2749a, this.f2751c) : a.a();
            if (!TextUtils.isEmpty(a2)) {
                try {
                    byte[] decode = Base64.decode(a2.getBytes(), 2);
                    if (decode != null && decode.length > 0) {
                        this.f2750b = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
                    }
                } catch (Exception e2) {
                    e = e2;
                    cVar = new b.c(this.f2749a);
                    cVar.a(Log.getStackTraceString(e)).a();
                    return !TextUtils.isEmpty(this.f2750b);
                } catch (UnsatisfiedLinkError e3) {
                    e = e3;
                    cVar = new b.c(this.f2749a);
                    cVar.a(Log.getStackTraceString(e)).a();
                    return !TextUtils.isEmpty(this.f2750b);
                }
            }
            return !TextUtils.isEmpty(this.f2750b);
        }
        return invokeV.booleanValue;
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? a.a(context, this.f2751c, str) : invokeLL.booleanValue;
    }
}
