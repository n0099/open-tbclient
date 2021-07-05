package com.baidu.media.ext;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.media.duplayer.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.a.c;
import d.a.b0.a.e;
import d.a.b0.b.a;
import java.io.File;
@Keep
/* loaded from: classes3.dex */
public class CyberMediaExtLoader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ClassLoader f8092a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(582962233, "Lcom/baidu/media/ext/CyberMediaExtLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(582962233, "Lcom/baidu/media/ext/CyberMediaExtLoader;");
        }
    }

    public CyberMediaExtLoader() {
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

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            CyberLog.i("CyberMediaExtInvoker", "tryLoadExtJar isExtJarLoader = " + a.d());
            if (context == null || a.d()) {
                return;
            }
            String str = c.k() + File.separator + "libs";
            File file = new File(e.b().a(2048).j());
            if (file.exists()) {
                f8092a = new CyberClassLoader(file.getAbsolutePath(), new File(str), null, context.getClassLoader());
            } else {
                CyberLog.e("CyberMediaExtInvoker", "dexFile = null or dexFile not exist!");
            }
        }
    }

    public static synchronized boolean init(Context context) {
        InterceptResult invokeL;
        boolean d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (CyberMediaExtLoader.class) {
                a(context);
                a.e(f8092a);
                d2 = a.d();
            }
            return d2;
        }
        return invokeL.booleanValue;
    }
}
