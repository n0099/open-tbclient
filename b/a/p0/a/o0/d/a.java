package b.a.p0.a.o0.d;

import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7098b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7099a;

    /* renamed from: b.a.p0.a.o0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0330a extends b.a.p0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.f.a f7100g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7101h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7102i;

        public C0330a(a aVar, b.a.p0.a.h0.f.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7102i = aVar;
            this.f7100g = aVar2;
            this.f7101h = str;
        }

        @Override // b.a.p0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7102i.e(this.f7100g, this.f7101h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.f.a f7103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7105g;

        public b(a aVar, b.a.p0.a.h0.f.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7105g = aVar;
            this.f7103e = aVar2;
            this.f7104f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7105g.e(this.f7103e, this.f7104f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-780095363, "Lb/a/p0/a/o0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-780095363, "Lb/a/p0/a/o0/d/a;");
                return;
            }
        }
        f7098b = k.f6397a;
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

    public String b(b.a.p0.a.h0.f.a aVar) {
        InterceptResult invokeL;
        String format;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar == null || TextUtils.isEmpty(this.f7099a)) {
                return null;
            }
            Locale locale = Locale.getDefault();
            if (aVar.isWebView()) {
                format = String.format(locale, "var %s = new Event('%s');", "event", this.f7099a);
                c2 = "";
            } else {
                format = String.format(locale, "var %s = new Object();", "event");
                c2 = b.a.p0.a.o0.a.c("event", "type", this.f7099a);
            }
            return String.format(locale, "javascript:(function(){%s %s %s})();", format, c2 + f("event"), String.format(locale, "%s.dispatchEvent(%s);", b.a.p0.a.o0.a.e(aVar), "event"));
        }
        return (String) invokeL.objValue;
    }

    public void c(b.a.p0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        b.a.p0.a.r1.g.a("postMessage", "dispatchJSEvent start.");
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        b.a.p0.a.r1.g.a("postMessage", "dispatchJSEvent buildEvent");
        if (f7098b) {
            String str = "dispatchJSEvent action: " + b2;
        }
        d(aVar, b2);
    }

    public void d(b.a.p0.a.h0.f.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, str) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.isWebView()) {
            if (b.a.p0.a.r1.l.e.a()) {
                b.a.p0.a.o0.b.b().c(new C0330a(this, aVar, str), null);
                return;
            } else {
                q0.b0(new b(this, aVar, str));
                return;
            }
        }
        e(aVar, str);
    }

    public final void e(b.a.p0.a.h0.f.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, str) == null) {
            if (aVar.isDestroyed()) {
                if (f7098b) {
                    Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str));
                    return;
                }
                return;
            }
            aVar.evaluateJavascript(str, null);
            b.a.p0.a.r1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }

    public abstract String f(String str);
}
