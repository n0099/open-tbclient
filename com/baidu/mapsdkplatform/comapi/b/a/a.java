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
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URLEncoder;
/* loaded from: classes10.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f36839b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: c  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f36840c;

    /* renamed from: com.baidu.mapsdkplatform.comapi.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1802a {
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

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f36840c = Thread.getDefaultUncaughtExceptionHandler();
    }

    public /* synthetic */ a(b bVar) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1802a.a : (a) invokeV.objValue;
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, th) == null) || th == null) {
            return;
        }
        String th2 = th.toString();
        if (th2.isEmpty() || th2.contains("BDMapSDKException")) {
            return;
        }
        if (th2.contains("com.baidu.platform") || th2.contains("com.baidu.mapsdkplatform") || th2.contains("com.baidu.mapsdkvi")) {
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
                if (!obj.isEmpty() && this.a != null && !this.a.isEmpty()) {
                    File file = new File(URLEncoder.encode(this.a + (System.currentTimeMillis() / 1000) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION, "UTF-8"));
                    if (file.exists() || file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(obj.getBytes());
                        fileOutputStream.close();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
            if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thread, th) == null) || f36839b) {
            return;
        }
        f36839b = true;
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f36840c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
