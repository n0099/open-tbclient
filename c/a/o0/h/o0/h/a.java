package c.a.o0.h.o0.h;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.p.e.f;
import c.a.o0.a.v2.q0;
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
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11470h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f11471e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f11472f;

    /* renamed from: g  reason: collision with root package name */
    public e f11473g;

    /* renamed from: c.a.o0.h.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0590a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11475f;

        public RunnableC0590a(a aVar, String str) {
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
            this.f11475f = aVar;
            this.f11474e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11475f.f11471e == null) {
                    this.f11475f.F();
                }
                if (!this.f11475f.f11471e.e()) {
                    this.f11475f.f11471e.I();
                }
                this.f11475f.f11471e.loadUrl(this.f11474e);
                this.f11475f.D("open", new c.a.o0.h.o0.h.b(this.f11474e));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11476e;

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
            this.f11476e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f11476e.f11471e != null && this.f11476e.f11471e.e()) {
                this.f11476e.f11471e.removeFromParent();
                this.f11476e.f11471e.destroy();
                this.f11476e.f11471e = null;
                a aVar = this.f11476e;
                aVar.D(IntentConfig.CLOSE, new c.a.o0.h.o0.h.b(aVar.f11472f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11478f;

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
            this.f11478f = aVar;
            this.f11477e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11478f.f11471e == null) {
                return;
            }
            if (TextUtils.equals("1", this.f11477e)) {
                this.f11478f.f11471e.h(true);
            } else {
                this.f11478f.f11471e.h(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11479e;

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
            this.f11479e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11479e.close();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11480a;

        /* renamed from: b  reason: collision with root package name */
        public String f11481b;

        /* renamed from: c  reason: collision with root package name */
        public long f11482c;

        /* renamed from: d  reason: collision with root package name */
        public long f11483d;

        public /* synthetic */ e(String str, String str2, long j2, RunnableC0590a runnableC0590a) {
            this(str, str2, j2);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "H5GameInfo{mGameId='" + this.f11480a + ExtendedMessageFormat.QUOTE + ", mGameName='" + this.f11481b + ExtendedMessageFormat.QUOTE + ", mStartLoadingTimestamp=" + this.f11482c + ", mFinishLoadingTimestamp=" + this.f11483d + ExtendedMessageFormat.END_FE;
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
            this.f11480a = str;
            this.f11481b = str2;
            this.f11482c = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1186872448, "Lc/a/o0/h/o0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1186872448, "Lc/a/o0/h/o0/h/a;");
                return;
            }
        }
        f11470h = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.l0.c cVar) {
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
            c.a.o0.a.l0.a n = c.a.o0.h.o.c.m().n();
            if (n == null) {
                return null;
            }
            EventTarget o = n.o();
            if (o instanceof c.a.o0.h.d.b) {
                return ((c.a.o0.h.d.b) o).getWebViewManager();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final c.a.o0.h.o0.h.c C(String str, @NonNull String str2) {
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
                return new c.a.o0.h.o0.h.c(str, str2, "open:host not in white list");
            }
            return new c.a.o0.h.o0.h.c(str, str2, "open:url is invalid");
        }
        return (c.a.o0.h.o0.h.c) invokeLL.objValue;
    }

    public final void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (f11470h) {
                String str2 = "dispatchEvent:" + str + "," + obj;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f11471e == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(c.a.o0.a.c1.a.b());
            this.f11471e = gameWebViewManager;
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
            if (this.f11473g == null) {
                boolean z = f11470h;
                return;
            }
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            if (Q == null) {
                boolean z2 = f11470h;
                return;
            }
            this.f11473g.f11483d = System.currentTimeMillis();
            if (f11470h) {
                String str = "onGameLoadingFinish: " + this.f11473g;
            }
            c.a.o0.h.o0.h.d.a(Q, this.f11473g);
            this.f11473g = null;
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0.b0(new b(this));
        }
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        String C = G.C("gameId");
        String C2 = G.C("gameName");
        if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(C2)) {
            this.f11473g = new e(C, C2, System.currentTimeMillis(), null);
            if (f11470h) {
                String str = "onGameLoadingStart: " + this.f11473g;
            }
            c.a.o0.h.m0.c.a(G, true, null);
            return;
        }
        c.a.o0.h.m0.c.a(G, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                D("error", C(null, "1001"));
                return;
            }
            String D = G.D("url", null);
            if (!G(D)) {
                D("error", C(D, "1001"));
            } else if (!c.a.o0.a.b2.a.b.h(D)) {
                D("error", C(D, "1002"));
            } else {
                if (f11470h) {
                    String str = "open:" + D;
                }
                this.f11472f = D;
                q0.b0(new RunnableC0590a(this, D));
            }
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                D("error", C(null, "1001"));
            } else {
                q0.b0(new c(this, G.D("setCloseViewVisibility", null)));
            }
        }
    }
}
