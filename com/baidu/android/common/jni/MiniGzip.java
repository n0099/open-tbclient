package com.baidu.android.common.jni;

import android.os.SystemClock;
import c.a.c.a.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import java.io.File;
/* loaded from: classes4.dex */
public final class MiniGzip {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36740a = "MiniGzip";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964768630, "Lcom/baidu/android/common/jni/MiniGzip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964768630, "Lcom/baidu/android/common/jni/MiniGzip;");
                return;
            }
        }
        System.loadLibrary("minigzip_v1");
    }

    public MiniGzip() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void unGzipFile(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (str == null || str2 == null || str.equals("") || str2.equals("")) {
                String str3 = f36740a;
                LogUtil.logD(str3, "parameters invalid : srcFile=" + str + "//destFile=" + str2);
            } else if (!new File(str).exists()) {
                String str4 = f36740a;
                LogUtil.logD(str4, str + "  not exists.");
            } else if (new a(new File(str)).a()) {
                uncompressFile(str, str2);
                String str5 = f36740a;
                LogUtil.logD(str5, "native ungzip use time : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    public static native void uncompressFile(String str, String str2);
}
