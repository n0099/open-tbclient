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
/* loaded from: classes7.dex */
public class e implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f38318a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38319b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f38320c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Thread, Throwable> f38321d;

    /* renamed from: e  reason: collision with root package name */
    public String f38322e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f38323a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004189578, "Lcom/baidu/fsg/base/statistics/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004189578, "Lcom/baidu/fsg/base/statistics/e$a;");
                    return;
                }
            }
            f38323a = new e(null);
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

    public e() {
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
        this.f38318a = null;
        this.f38319b = null;
        this.f38320c = null;
        this.f38321d = new ConcurrentHashMap<>();
    }

    public /* synthetic */ e(d dVar) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f38323a : (e) invokeV.objValue;
    }

    private void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), str, str2}) == null) && this.f38319b != null && str != null && !str.trim().equals("")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dim_excep_time", j);
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
                    jSONObject.put("dim_excep_free_mem", com.baidu.fsg.base.statistics.a.a(this.f38319b));
                } catch (Exception unused2) {
                }
                try {
                    jSONObject.put("dim_excep_total_mem", com.baidu.fsg.base.statistics.a.b(this.f38319b));
                } catch (Exception unused3) {
                }
                g.b().a(jSONObject);
                com.baidu.fsg.base.statistics.a.a(this.f38319b, b.n, g.b().a().toString(), false);
            } catch (Exception unused4) {
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.f38319b == null) {
                if (context == null) {
                    return;
                }
                this.f38319b = context.getApplicationContext();
            }
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (this != defaultUncaughtExceptionHandler) {
                this.f38318a = defaultUncaughtExceptionHandler;
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
            if (this.f38322e == null) {
                this.f38322e = "com.baidu.fsg.rimdemo," + com.baidu.fsg.base.a.f38137b + ",";
            }
            return this.f38322e;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String stringWriter;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, thread, th) == null) {
            if (th == this.f38321d.get(thread)) {
                if (thread.isAlive()) {
                    thread.stop(th);
                }
                this.f38321d.remove(thread);
                return;
            }
            this.f38321d.put(thread, th);
            String th2 = th.toString();
            if (th2 != null && !th2.equals("")) {
                try {
                    str = th2.length() > 0 ? th2.split(":")[0] : th2;
                } catch (Exception unused) {
                }
                if (str != null && !str.equals("")) {
                    th2 = str;
                }
                StringWriter stringWriter2 = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter2);
                th.printStackTrace(printWriter);
                printWriter.close();
                stringWriter = stringWriter2.toString();
                if (a(this.f38319b, stringWriter)) {
                    a(System.currentTimeMillis(), stringWriter, th2);
                    new Thread(new d(this)).start();
                }
                uncaughtExceptionHandler = this.f38318a;
                if (this != uncaughtExceptionHandler || uncaughtExceptionHandler == null) {
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            str = "";
            if (str != null) {
                th2 = str;
            }
            StringWriter stringWriter22 = new StringWriter();
            PrintWriter printWriter2 = new PrintWriter(stringWriter22);
            th.printStackTrace(printWriter2);
            printWriter2.close();
            stringWriter = stringWriter22.toString();
            if (a(this.f38319b, stringWriter)) {
            }
            uncaughtExceptionHandler = this.f38318a;
            if (this != uncaughtExceptionHandler) {
            }
        }
    }
}
