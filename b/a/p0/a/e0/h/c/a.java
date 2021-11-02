package b.a.p0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.a.p0.a.e0.h.a;
import b.a.p0.a.e0.h.c.c;
import b.a.p0.a.e0.h.d.a;
import b.a.p0.a.h;
import b.a.p0.a.h0.l.e;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f4731e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f4732f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.e0.h.d.a f4733g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f4734h;

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f4735i;
    public b.a.p0.a.l0.a j;
    public a.b k;

    /* renamed from: b.a.p0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0153a implements a.InterfaceC0157a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f4736a;

        /* renamed from: b.a.p0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0154a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0153a f4737e;

            public RunnableC0154a(C0153a c0153a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0153a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4737e = c0153a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f4737e.f4736a.f4734h.poll();
                    while (str != null) {
                        this.f4737e.f4736a.f4735i.dispatchProtocolMessage(str);
                        this.f4737e.d(str);
                        str = (String) this.f4737e.f4736a.f4734h.poll();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.e0.h.c.a$a$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0153a f4738e;

            public b(C0153a c0153a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0153a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4738e = c0153a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4738e.f4736a.k.onConnected();
                    this.f4738e.f4736a.k = null;
                    int unused = a.m = 2;
                }
            }
        }

        public C0153a(a aVar) {
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
            this.f4736a = aVar;
        }

        @Override // b.a.p0.a.e0.h.d.a.InterfaceC0157a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.f4736a.f4734h.offer(webSocketFrame.g());
                this.f4736a.j.postOnJSThread(new RunnableC0154a(this));
            }
        }

        @Override // b.a.p0.a.e0.h.d.a.InterfaceC0157a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                b.a.p0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
                this.f4736a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || this.f4736a.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
                    SwanAppActivity x = b.a.p0.a.a2.d.g().x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new b(this));
                    }
                }
            } catch (JSONException unused) {
                boolean unused2 = a.l;
            }
        }

        @Override // b.a.p0.a.e0.h.d.a.InterfaceC0157a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.p0.a.e0.d.g("ClientHandler", "V8 inspector closed");
                this.f4736a.l();
            }
        }

        @Override // b.a.p0.a.e0.h.d.a.InterfaceC0157a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                b.a.p0.a.e0.d.g("ClientHandler", "V8 inspector opened");
                b.a.p0.a.h0.l.a O = g.M().O();
                if (O instanceof e) {
                    this.f4736a.j = (b.a.p0.a.l0.a) O.f();
                }
                if (this.f4736a.j != null) {
                    if (this.f4736a.f4735i != null) {
                        this.f4736a.f4735i.destroy();
                    }
                    a aVar = this.f4736a;
                    aVar.f4735i = aVar.j.r0(new b(this.f4736a));
                    int unused = a.m = 1;
                    return;
                }
                b.a.p0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
                this.f4736a.l();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f4739a;

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
            this.f4739a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean unused = a.l;
                try {
                    return (String) this.f4739a.f4734h.take();
                } catch (InterruptedException unused2) {
                    boolean unused3 = a.l;
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
                    this.f4739a.f4733g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    boolean unused2 = a.l;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338091173, "Lb/a/p0/a/e0/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1338091173, "Lb/a/p0/a/e0/h/c/a;");
                return;
            }
        }
        l = k.f6397a;
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4734h = new LinkedBlockingQueue<>();
        this.f4731e = inputStream;
        this.f4732f = outputStream;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return URLDecoder.decode(str, StringUtils.UTF8);
            } catch (UnsupportedEncodingException unused) {
                boolean z = l;
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedBlockingQueue<String> linkedBlockingQueue = this.f4734h;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.f4734h = null;
            }
            InspectorNativeClient inspectorNativeClient = this.f4735i;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.f4735i = null;
            }
            InputStream inputStream = this.f4731e;
            if (inputStream != null) {
                b.a.p0.t.d.d(inputStream);
                this.f4731e = null;
            }
            OutputStream outputStream = this.f4732f;
            if (outputStream != null) {
                b.a.p0.t.d.d(outputStream);
                this.f4732f = null;
            }
            this.f4733g = null;
            this.j = null;
            m = 3;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(BufferedReader bufferedReader, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader, aVar) == null) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f4758b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f4759c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.f4760d = stringTokenizer.nextToken();
                        } else {
                            aVar.f4760d = "HTTP/1.1";
                            boolean z = l;
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (l) {
                                String str = "Http header :" + readLine2;
                            }
                            int indexOf = readLine2.indexOf(58);
                            if (indexOf >= 0) {
                                aVar.f4757a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                            }
                            readLine2 = bufferedReader.readLine();
                        }
                        return;
                    }
                    throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            } catch (IOException unused) {
                boolean z2 = l;
            }
        }
    }

    public void o(a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && m == 0) {
            this.k = bVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f4731e));
                    c.a aVar = new c.a();
                    m(bufferedReader, aVar);
                    d.a(aVar).e(this.f4732f);
                    if (aVar.f4761e) {
                        if (m != 0 && m != 3) {
                            b.a.p0.a.z1.b.f.e.f(b.a.p0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                            return;
                        }
                        b.a.p0.a.e0.h.d.a aVar2 = new b.a.p0.a.e0.h.d.a();
                        this.f4733g = aVar2;
                        aVar2.k(new C0153a(this));
                        this.f4733g.h(this.f4731e, this.f4732f);
                    }
                } catch (RuntimeException unused) {
                    boolean z = l;
                }
            } finally {
                b.a.p0.t.d.d(this.f4731e);
                b.a.p0.t.d.d(this.f4732f);
            }
        }
    }
}
