package com.baidu.mapsdkplatform.comapi.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 10240;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public Thread.UncaughtExceptionHandler d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(363238427, "Lcom/baidu/mapsdkplatform/comapi/b/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(363238427, "Lcom/baidu/mapsdkplatform/comapi/b/a/a;");
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0110a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1179758334, "Lcom/baidu/mapsdkplatform/comapi/b/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1179758334, "Lcom/baidu/mapsdkplatform/comapi/b/a/a$a;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
        this.d = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return C0110a.a;
        }
        return (a) invokeV.objValue;
    }

    public /* synthetic */ a(b bVar) {
        this();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.b = str;
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof a)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        }
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, th) != null) || th == null) {
            return;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            Throwable cause = th.getCause();
            if (cause != null) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            String obj = stringWriter.toString();
            if (obj.isEmpty()) {
                return;
            }
            if (obj.length() > a) {
                obj = obj.substring(0, a);
            }
            if (!obj.contains("BDMapSDKException")) {
                if ((obj.contains("com.baidu.platform") || obj.contains("com.baidu.mapsdkplatform")) && this.b != null && !this.b.isEmpty()) {
                    c.a().a(this.b + (System.currentTimeMillis() / 1000) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION, obj);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread, th) != null) || c) {
            return;
        }
        c = true;
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
