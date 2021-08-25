package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f39372a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39373b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f39374c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Thread, Throwable> f39375d;

    /* renamed from: e  reason: collision with root package name */
    public String f39376e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f39378a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004159787, "Lcom/baidu/fsg/base/statistics/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004159787, "Lcom/baidu/fsg/base/statistics/d$a;");
                    return;
                }
            }
            f39378a = new d();
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
                }
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39372a = null;
        this.f39373b = null;
        this.f39374c = null;
        this.f39375d = new ConcurrentHashMap<>();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f39378a : (d) invokeV.objValue;
    }

    private void a(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), str, str2}) == null) && this.f39373b != null && str != null && !str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dim_excep_time", j2);
                if (str.getBytes().length > 51200) {
                    byte[] bArr = new byte[51200];
                    str.getBytes(0, 51200, bArr, 0);
                    str = new String(bArr);
                }
                jSONObject.put("dim_excep_cont", str);
                jSONObject.put("dim_excep_type", com.baidu.fsg.base.statistics.a.a(jSONObject.getString("dim_excep_cont").getBytes(), false));
                try {
                    jSONObject.put("dim_excep_line_way", com.baidu.fsg.base.statistics.a.a());
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("dim_excep_free_mem", com.baidu.fsg.base.statistics.a.b(this.f39373b));
                } catch (Exception unused2) {
                }
                try {
                    jSONObject.put("dim_excep_total_mem", com.baidu.fsg.base.statistics.a.c(this.f39373b));
                } catch (Exception unused3) {
                }
                e.a().a(jSONObject);
                com.baidu.fsg.base.statistics.a.a(this.f39373b, b.n, e.a().d().toString(), false);
            } catch (Exception unused4) {
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.f39373b == null) {
                if (context == null) {
                    return;
                }
                this.f39373b = context.getApplicationContext();
            }
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (this != defaultUncaughtExceptionHandler) {
                this.f39372a = defaultUncaughtExceptionHandler;
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        }
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                String b2 = b();
                if (!TextUtils.isEmpty(b2) && (split = b2.split(",")) != null && split.length > 0) {
                    for (String str2 : split) {
                        if (str.contains(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f39376e == null) {
                this.f39376e = "com.baidu.fsg.rimdemo," + com.baidu.fsg.base.a.f39185b + ",";
            }
            return this.f39376e;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String obj;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, thread, th) == null) {
            if (th == this.f39375d.get(thread)) {
                if (thread.isAlive()) {
                    thread.stop(th);
                }
                this.f39375d.remove(thread);
                return;
            }
            this.f39375d.put(thread, th);
            String th2 = th.toString();
            if (th2 != null && !th2.equals("")) {
                try {
                    str = th2.length() > 0 ? th2.split(":")[0] : th2;
                } catch (Exception unused) {
                }
                if (str != null && !str.equals("")) {
                    th2 = str;
                }
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.close();
                obj = stringWriter.toString();
                if (a(this.f39373b, obj)) {
                    a(System.currentTimeMillis(), obj, th2);
                    new Thread(new Runnable(this) { // from class: com.baidu.fsg.base.statistics.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f39377a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39377a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                i.a().a(b.o);
                            }
                        }
                    }).start();
                }
                uncaughtExceptionHandler = this.f39372a;
                if (this != uncaughtExceptionHandler || uncaughtExceptionHandler == null) {
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            str = "";
            if (str != null) {
                th2 = str;
            }
            StringWriter stringWriter2 = new StringWriter();
            PrintWriter printWriter2 = new PrintWriter(stringWriter2);
            th.printStackTrace(printWriter2);
            printWriter2.close();
            obj = stringWriter2.toString();
            if (a(this.f39373b, obj)) {
            }
            uncaughtExceptionHandler = this.f39372a;
            if (this != uncaughtExceptionHandler) {
            }
        }
    }
}
