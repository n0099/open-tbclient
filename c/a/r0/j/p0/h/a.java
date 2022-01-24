package c.a.r0.j.p0.h;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.p.e.f;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11361h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f11362e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f11363f;

    /* renamed from: g  reason: collision with root package name */
    public e f11364g;

    /* renamed from: c.a.r0.j.p0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0780a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11365e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11366f;

        public RunnableC0780a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11366f = aVar;
            this.f11365e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11366f.f11362e == null) {
                    this.f11366f.F();
                }
                if (!this.f11366f.f11362e.e()) {
                    this.f11366f.f11362e.J();
                }
                this.f11366f.f11362e.loadUrl(this.f11365e);
                this.f11366f.D("open", new c.a.r0.j.p0.h.b(this.f11365e));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11367e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11367e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f11367e.f11362e != null && this.f11367e.f11362e.e()) {
                this.f11367e.f11362e.removeFromParent();
                this.f11367e.f11362e.destroy();
                this.f11367e.f11362e = null;
                a aVar = this.f11367e;
                aVar.D(IntentConfig.CLOSE, new c.a.r0.j.p0.h.b(aVar.f11363f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11369f;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11369f = aVar;
            this.f11368e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11369f.f11362e == null) {
                return;
            }
            if (TextUtils.equals("1", this.f11368e)) {
                this.f11369f.f11362e.h(true);
            } else {
                this.f11369f.f11362e.h(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11370e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11370e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11370e.close();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f11371b;

        /* renamed from: c  reason: collision with root package name */
        public long f11372c;

        /* renamed from: d  reason: collision with root package name */
        public long f11373d;

        public /* synthetic */ e(String str, String str2, long j2, RunnableC0780a runnableC0780a) {
            this(str, str2, j2);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "H5GameInfo{mGameId='" + this.a + ExtendedMessageFormat.QUOTE + ", mGameName='" + this.f11371b + ExtendedMessageFormat.QUOTE + ", mStartLoadingTimestamp=" + this.f11372c + ", mFinishLoadingTimestamp=" + this.f11373d + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public e(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f11371b = str2;
            this.f11372c = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767937760, "Lc/a/r0/j/p0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(767937760, "Lc/a/r0/j/p0/h/a;");
                return;
            }
        }
        f11361h = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c.a.r0.a.l0.a n = c.a.r0.j.o.c.m().n();
            if (n == null) {
                return null;
            }
            EventTarget o = n.o();
            if (o instanceof c.a.r0.j.d.b) {
                return ((c.a.r0.j.d.b) o).getWebViewManager();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final c.a.r0.j.p0.h.c C(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            switch (str2.hashCode()) {
                case 1507424:
                    if (str2.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507425:
                    if (str2.equals("1002")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return new c.a.r0.j.p0.h.c(str, str2, "open:host not in white list");
            }
            return new c.a.r0.j.p0.h.c(str, str2, "open:url is invalid");
        }
        return (c.a.r0.j.p0.h.c) invokeLL.objValue;
    }

    public final void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (f11361h) {
                String str2 = "dispatchEvent:" + str + "," + obj;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f11362e == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(c.a.r0.a.c1.a.c());
            this.f11362e = gameWebViewManager;
            gameWebViewManager.j(new d(this));
        }
    }

    public final boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
        }
        return invokeL.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f11364g == null) {
                boolean z = f11361h;
                return;
            }
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                boolean z2 = f11361h;
                return;
            }
            this.f11364g.f11373d = System.currentTimeMillis();
            if (f11361h) {
                String str = "onGameLoadingFinish: " + this.f11364g;
            }
            c.a.r0.j.p0.h.d.a(a0, this.f11364g);
            this.f11364g = null;
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0.e0(new b(this));
        }
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        String B = F.B("gameId");
        String B2 = F.B("gameName");
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(B2)) {
            this.f11364g = new e(B, B2, System.currentTimeMillis(), null);
            if (f11361h) {
                String str = "onGameLoadingStart: " + this.f11364g;
            }
            c.a.r0.j.n0.c.call(F, true, null);
            return;
        }
        c.a.r0.j.n0.c.call(F, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            if (F == null) {
                D("error", C(null, "1001"));
                return;
            }
            String C = F.C("url", null);
            if (!G(C)) {
                D("error", C(C, "1001"));
            } else if (!c.a.r0.a.e2.a.b.h(C)) {
                D("error", C(C, "1002"));
            } else {
                if (f11361h) {
                    String str = "open:" + C;
                }
                this.f11363f = C;
                q0.e0(new RunnableC0780a(this, C));
            }
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            if (F == null) {
                D("error", C(null, "1001"));
            } else {
                q0.e0(new c(this, F.C("setCloseViewVisibility", null)));
            }
        }
    }
}
