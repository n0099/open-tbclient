package c.a.r0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.r0.a.e0.h.a;
import c.a.r0.a.e0.h.c.c;
import c.a.r0.a.e0.h.d.a;
import c.a.r0.a.h;
import c.a.r0.a.h0.l.e;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
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
    public InputStream f5882e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f5883f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.e0.h.d.a f5884g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f5885h;

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f5886i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.a.l0.a f5887j;
    public a.b k;

    /* renamed from: c.a.r0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0315a implements a.InterfaceC0319a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0316a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0315a f5888e;

            public RunnableC0316a(C0315a c0315a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0315a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5888e = c0315a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.f5888e.a.f5885h.poll();
                    while (str != null) {
                        this.f5888e.a.f5886i.dispatchProtocolMessage(str);
                        this.f5888e.d(str);
                        str = (String) this.f5888e.a.f5885h.poll();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.e0.h.c.a$a$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0315a f5889e;

            public b(C0315a c0315a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0315a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5889e = c0315a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5889e.a.k.onConnected();
                    this.f5889e.a.k = null;
                    int unused = a.m = 2;
                }
            }
        }

        public C0315a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.r0.a.e0.h.d.a.InterfaceC0319a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.a.f5885h.offer(webSocketFrame.g());
                this.a.f5887j.postOnJSThread(new RunnableC0316a(this));
            }
        }

        @Override // c.a.r0.a.e0.h.d.a.InterfaceC0319a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                c.a.r0.a.e0.d.d("ClientHandler", "V8 inspector exception", iOException);
                this.a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || this.a.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    c.a.r0.a.d2.d J = c.a.r0.a.d2.d.J();
                    SwanAppActivity x = c.a.r0.a.d2.d.J().x();
                    if (J.D() && x != null) {
                        x.runOnUiThread(new b(this));
                    }
                }
            } catch (JSONException unused) {
                boolean unused2 = a.l;
            }
        }

        @Override // c.a.r0.a.e0.h.d.a.InterfaceC0319a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                c.a.r0.a.e0.d.i("ClientHandler", "V8 inspector closed");
                this.a.l();
            }
        }

        @Override // c.a.r0.a.e0.h.d.a.InterfaceC0319a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                c.a.r0.a.e0.d.i("ClientHandler", "V8 inspector opened");
                c.a.r0.a.h0.l.a W = g.U().W();
                if (W instanceof e) {
                    this.a.f5887j = (c.a.r0.a.l0.a) W.g();
                }
                if (this.a.f5887j != null) {
                    if (this.a.f5886i != null) {
                        this.a.f5886i.destroy();
                    }
                    a aVar = this.a;
                    aVar.f5886i = aVar.f5887j.t0(new b(this.a));
                    int unused = a.m = 1;
                    return;
                }
                c.a.r0.a.e0.d.i("ClientHandler", "inner error, V8 mEngine is null");
                this.a.l();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean unused = a.l;
                try {
                    return (String) this.a.f5885h.take();
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
                    this.a.f5884g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    boolean unused2 = a.l;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(948686520, "Lc/a/r0/a/e0/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(948686520, "Lc/a/r0/a/e0/h/c/a;");
                return;
            }
        }
        l = k.a;
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
        this.f5885h = new LinkedBlockingQueue<>();
        this.f5882e = inputStream;
        this.f5883f = outputStream;
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
            LinkedBlockingQueue<String> linkedBlockingQueue = this.f5885h;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.f5885h = null;
            }
            InspectorNativeClient inspectorNativeClient = this.f5886i;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.f5886i = null;
            }
            InputStream inputStream = this.f5882e;
            if (inputStream != null) {
                c.a.r0.w.d.d(inputStream);
                this.f5882e = null;
            }
            OutputStream outputStream = this.f5883f;
            if (outputStream != null) {
                c.a.r0.w.d.d(outputStream);
                this.f5883f = null;
            }
            this.f5884g = null;
            this.f5887j = null;
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
                    aVar.f5904b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f5905c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.f5906d = stringTokenizer.nextToken();
                        } else {
                            aVar.f5906d = "HTTP/1.1";
                            boolean z = l;
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (l) {
                                String str = "Http header :" + readLine2;
                            }
                            int indexOf = readLine2.indexOf(58);
                            if (indexOf >= 0) {
                                aVar.a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f5882e));
                    c.a aVar = new c.a();
                    m(bufferedReader, aVar);
                    d.a(aVar).e(this.f5883f);
                    if (aVar.f5907e) {
                        if (m != 0 && m != 3) {
                            c.a.r0.a.c2.b.f.e.f(c.a.r0.a.c1.a.c(), h.aiapps_debug_inspect_doing).G();
                            return;
                        }
                        c.a.r0.a.e0.h.d.a aVar2 = new c.a.r0.a.e0.h.d.a();
                        this.f5884g = aVar2;
                        aVar2.k(new C0315a(this));
                        this.f5884g.h(this.f5882e, this.f5883f);
                    }
                } catch (RuntimeException unused) {
                    boolean z = l;
                }
            } finally {
                c.a.r0.w.d.d(this.f5882e);
                c.a.r0.w.d.d(this.f5883f);
            }
        }
    }
}
