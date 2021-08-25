package c.a.o0.a.e0.h.c;

import android.net.Uri;
import android.text.TextUtils;
import c.a.o0.a.e0.h.a;
import c.a.o0.a.h0.l.e;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
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
import h.b.i.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements a.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5340g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.b f5341a;

    /* renamed from: b  reason: collision with root package name */
    public h.b.e.a f5342b;

    /* renamed from: c  reason: collision with root package name */
    public InspectorNativeClient f5343c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.l0.a f5344d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingQueue<String> f5345e;

    /* renamed from: f  reason: collision with root package name */
    public String f5346f;

    /* loaded from: classes.dex */
    public class a extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5347a;

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
            this.f5347a = bVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean unused = b.f5340g;
                try {
                    return (String) this.f5347a.f5345e.take();
                } catch (InterruptedException unused2) {
                    boolean unused3 = b.f5340g;
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
                    if (this.f5347a.f5342b != null) {
                        this.f5347a.f5342b.send(str);
                    }
                } catch (Exception unused) {
                    boolean unused2 = b.f5340g;
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.e0.h.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0158b extends h.b.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5348e;

        /* renamed from: c.a.o0.a.e0.h.c.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0158b f5349e;

            public a(C0158b c0158b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0158b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5349e = c0158b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f5349e.f5348e.f5345e.poll();
                    while (str != null) {
                        this.f5349e.f5348e.f5343c.dispatchProtocolMessage(str);
                        this.f5349e.c(str);
                        this.f5349e.d(str);
                        str = (String) this.f5349e.f5348e.f5345e.poll();
                    }
                }
            }
        }

        /* renamed from: c.a.o0.a.e0.h.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0159b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0158b f5350e;

            public RunnableC0159b(C0158b c0158b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0158b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5350e = c0158b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5350e.f5348e.f5341a.onConnected();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0158b(b bVar, URI uri) {
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
            this.f5348e = bVar;
        }

        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || this.f5348e.f5341a == null) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    c.a.o0.a.a2.d g2 = c.a.o0.a.a2.d.g();
                    SwanAppActivity x = g2.x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new RunnableC0159b(this));
                    }
                }
            } catch (JSONException unused) {
                boolean unused2 = b.f5340g;
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
                        c.a.o0.a.e0.d.b("V8InspectorClient", "Undefined command");
                        return;
                    }
                    c.a.o0.a.e0.d.g("V8InspectorClient", "v8 inspector close");
                    c.a.o0.a.e0.f.f.d.d();
                    return;
                }
                c.a.o0.a.e0.d.g("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException unused) {
                boolean unused2 = b.f5340g;
            }
        }

        @Override // h.b.e.a
        public void onClose(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                c.a.o0.a.e0.d.g("V8InspectorClient", "V8 inspector closed");
            }
        }

        @Override // h.b.e.a
        public void onError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                c.a.o0.a.e0.d.c("V8InspectorClient", "V8 inspector error", exc);
            }
        }

        @Override // h.b.e.a
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f5348e.f5345e.offer(str);
                this.f5348e.f5344d.postOnJSThread(new a(this));
            }
        }

        @Override // h.b.e.a
        public void onOpen(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                c.a.o0.a.e0.d.g("V8InspectorClient", "V8 inspector opened");
                c.a.o0.a.h0.l.a P = g.N().P();
                if (P instanceof e) {
                    this.f5348e.f5344d = (c.a.o0.a.l0.a) P.g();
                }
                if (this.f5348e.f5344d == null) {
                    c.a.o0.a.e0.d.g("V8InspectorClient", "inner error, V8 mEngine is null");
                    close();
                    return;
                }
                b bVar = this.f5348e;
                bVar.f5343c = bVar.f5344d.r0(new a(this.f5348e));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1829604870, "Lc/a/o0/a/e0/h/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1829604870, "Lc/a/o0/a/e0/h/c/b;");
                return;
            }
        }
        f5340g = k.f7049a;
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
        this.f5345e = new LinkedBlockingQueue<>();
        this.f5346f = str;
        this.f5341a = bVar;
    }

    @Override // c.a.o0.a.e0.h.a.c
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                C0158b c0158b = new C0158b(this, new URI(this.f5346f));
                this.f5342b = c0158b;
                c0158b.connect();
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.o0.a.e0.h.a.c
    public void stop() {
        h.b.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f5342b) == null) {
            return;
        }
        aVar.close();
        this.f5342b = null;
    }
}
