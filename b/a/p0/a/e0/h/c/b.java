package b.a.p0.a.e0.h.c;

import android.net.Uri;
import android.text.TextUtils;
import b.a.p0.a.e0.h.a;
import b.a.p0.a.h0.l.e;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.b.i.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements a.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4721g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.b f4722a;

    /* renamed from: b  reason: collision with root package name */
    public g.b.e.a f4723b;

    /* renamed from: c  reason: collision with root package name */
    public InspectorNativeClient f4724c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.l0.a f4725d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingQueue<String> f4726e;

    /* renamed from: f  reason: collision with root package name */
    public String f4727f;

    /* loaded from: classes.dex */
    public class a extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f4728a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4728a = bVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean unused = b.f4721g;
                try {
                    return (String) this.f4728a.f4726e.take();
                } catch (InterruptedException unused2) {
                    boolean unused3 = b.f4721g;
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    if (this.f4728a.f4723b != null) {
                        this.f4728a.f4723b.send(str);
                    }
                } catch (Exception unused) {
                    boolean unused2 = b.f4721g;
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.e0.h.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0159b extends g.b.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4729e;

        /* renamed from: b.a.p0.a.e0.h.c.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0159b f4730e;

            public a(C0159b c0159b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0159b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4730e = c0159b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f4730e.f4729e.f4726e.poll();
                    while (str != null) {
                        this.f4730e.f4729e.f4724c.dispatchProtocolMessage(str);
                        this.f4730e.c(str);
                        this.f4730e.d(str);
                        str = (String) this.f4730e.f4729e.f4726e.poll();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.e0.h.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0160b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0159b f4731e;

            public RunnableC0160b(C0159b c0159b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0159b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4731e = c0159b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4731e.f4729e.f4722a.onConnected();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0159b(b bVar, URI uri) {
            super(uri);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((URI) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4729e = bVar;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || this.f4729e.f4722a == null) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
                    SwanAppActivity x = J.x();
                    if (J.D() && x != null) {
                        x.runOnUiThread(new RunnableC0160b(this));
                    }
                }
            } catch (JSONException unused) {
                boolean unused2 = b.f4721g;
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("command");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -934641255) {
                    if (hashCode == 94756344 && optString.equals(IntentConfig.CLOSE)) {
                        c2 = 1;
                    }
                } else if (optString.equals("reload")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        b.a.p0.a.e0.d.c("V8InspectorClient", "Undefined command");
                        return;
                    }
                    b.a.p0.a.e0.d.i("V8InspectorClient", "v8 inspector close");
                    b.a.p0.a.e0.f.f.d.d();
                    return;
                }
                b.a.p0.a.e0.d.i("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException unused) {
                boolean unused2 = b.f4721g;
            }
        }

        @Override // g.b.e.a
        public void onClose(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                b.a.p0.a.e0.d.i("V8InspectorClient", "V8 inspector closed");
            }
        }

        @Override // g.b.e.a
        public void onError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                b.a.p0.a.e0.d.d("V8InspectorClient", "V8 inspector error", exc);
            }
        }

        @Override // g.b.e.a
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f4729e.f4726e.offer(str);
                this.f4729e.f4725d.postOnJSThread(new a(this));
            }
        }

        @Override // g.b.e.a
        public void onOpen(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                b.a.p0.a.e0.d.i("V8InspectorClient", "V8 inspector opened");
                b.a.p0.a.h0.l.a W = g.U().W();
                if (W instanceof e) {
                    this.f4729e.f4725d = (b.a.p0.a.l0.a) W.g();
                }
                if (this.f4729e.f4725d == null) {
                    b.a.p0.a.e0.d.i("V8InspectorClient", "inner error, V8 mEngine is null");
                    close();
                    return;
                }
                b bVar = this.f4729e;
                bVar.f4724c = bVar.f4725d.t0(new a(this.f4729e));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338091142, "Lb/a/p0/a/e0/h/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1338091142, "Lb/a/p0/a/e0/h/c/b;");
                return;
            }
        }
        f4721g = k.f6863a;
    }

    public b(String str, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4726e = new LinkedBlockingQueue<>();
        this.f4727f = str;
        this.f4722a = bVar;
    }

    @Override // b.a.p0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                C0159b c0159b = new C0159b(this, new URI(this.f4727f));
                this.f4723b = c0159b;
                c0159b.connect();
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.a.p0.a.e0.h.a.c
    public void stop() {
        g.b.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f4723b) == null) {
            return;
        }
        aVar.close();
        this.f4723b = null;
    }
}
