package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
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
    public Context a;
    public String b;
    public String c;

    public b(Context context) {
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
        this.a = context;
    }

    public boolean a() {
        InterceptResult invokeV;
        b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = new File(this.c).exists() ? a.a(this.a, this.c) : a.a();
            if (!TextUtils.isEmpty(a)) {
                try {
                    byte[] decode = Base64.decode(a.getBytes(), 2);
                    if (decode != null && decode.length > 0) {
                        this.b = new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), IMAudioTransRequest.CHARSET);
                    }
                } catch (Exception e) {
                    e = e;
                    cVar = new b.c(this.a);
                    cVar.a(Log.getStackTraceString(e)).a();
                    return !TextUtils.isEmpty(this.b);
                } catch (UnsatisfiedLinkError e2) {
                    e = e2;
                    cVar = new b.c(this.a);
                    cVar.a(Log.getStackTraceString(e)).a();
                    return !TextUtils.isEmpty(this.b);
                }
            }
            return !TextUtils.isEmpty(this.b);
        }
        return invokeV.booleanValue;
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? a.a(context, this.c, str) : invokeLL.booleanValue;
    }
}
