package c.a.n0.a.u.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.u.h.a;
import c.a.n0.a.u.h.c.c;
import c.a.n0.a.u.h.d.a;
import c.a.n0.a.x.l.e;
import c.a.n0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.tieba.R;
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

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6524h;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public OutputStream f6525b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.u.h.d.a f6526c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedBlockingQueue<String> f6527d;

    /* renamed from: e  reason: collision with root package name */
    public InspectorNativeClient f6528e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.b0.a f6529f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f6530g;

    /* renamed from: c.a.n0.a.u.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0472a implements a.InterfaceC0476a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.a.u.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0473a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0472a a;

            public RunnableC0473a(C0472a c0472a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0472a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0472a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.a.a.f6527d.poll();
                    while (str != null) {
                        this.a.a.f6528e.dispatchProtocolMessage(str);
                        this.a.d(str);
                        str = (String) this.a.a.f6527d.poll();
                    }
                }
            }
        }

        /* renamed from: c.a.n0.a.u.h.c.a$a$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0472a a;

            public b(C0472a c0472a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0472a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0472a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f6530g.onConnected();
                    this.a.a.f6530g = null;
                    int unused = a.i = 2;
                }
            }
        }

        public C0472a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.u.h.d.a.InterfaceC0476a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.a.f6527d.offer(webSocketFrame.g());
                this.a.f6529f.postOnJSThread(new RunnableC0473a(this));
            }
        }

        @Override // c.a.n0.a.u.h.d.a.InterfaceC0476a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                c.a.n0.a.u.d.d("ClientHandler", "V8 inspector exception", iOException);
                this.a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || this.a.f6530g == null || a.i == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
                    SwanAppActivity x = c.a.n0.a.t1.d.J().x();
                    if (J.D() && x != null) {
                        x.runOnUiThread(new b(this));
                    }
                }
            } catch (JSONException e2) {
                if (a.f6524h) {
                    Log.e("ClientHandler", "message is not a Json object", e2);
                }
            }
        }

        @Override // c.a.n0.a.u.h.d.a.InterfaceC0476a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                c.a.n0.a.u.d.i("ClientHandler", "V8 inspector closed");
                this.a.l();
            }
        }

        @Override // c.a.n0.a.u.h.d.a.InterfaceC0476a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                c.a.n0.a.u.d.i("ClientHandler", "V8 inspector opened");
                c.a.n0.a.x.l.a W = g.U().W();
                if (W instanceof e) {
                    this.a.f6529f = (c.a.n0.a.b0.a) W.h();
                }
                if (this.a.f6529f != null) {
                    if (this.a.f6528e != null) {
                        this.a.f6528e.destroy();
                    }
                    a aVar = this.a;
                    aVar.f6528e = aVar.f6529f.t0(new b(this.a));
                    int unused = a.i = 1;
                    return;
                }
                c.a.n0.a.u.d.i("ClientHandler", "inner error, V8 mEngine is null");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (a.f6524h) {
                    Log.d("ClientHandler", "getInspectorMessage");
                }
                try {
                    return (String) this.a.f6527d.take();
                } catch (InterruptedException e2) {
                    if (a.f6524h) {
                        Log.e("ClientHandler", "awaitMessage on Debugger", e2);
                        return "";
                    }
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
                    this.a.f6526c.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    if (a.f6524h) {
                        Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1795836988, "Lc/a/n0/a/u/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1795836988, "Lc/a/n0/a/u/h/c/a;");
                return;
            }
        }
        f6524h = c.a.n0.a.a.a;
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
        this.f6527d = new LinkedBlockingQueue<>();
        this.a = inputStream;
        this.f6525b = outputStream;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return URLDecoder.decode(str, StringUtils.UTF8);
            } catch (UnsupportedEncodingException unused) {
                if (f6524h) {
                    Log.d("ClientHandler", "Encoding not supported, ignored");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedBlockingQueue<String> linkedBlockingQueue = this.f6527d;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.f6527d = null;
            }
            InspectorNativeClient inspectorNativeClient = this.f6528e;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.f6528e = null;
            }
            InputStream inputStream = this.a;
            if (inputStream != null) {
                c.a.n0.w.d.d(inputStream);
                this.a = null;
            }
            OutputStream outputStream = this.f6525b;
            if (outputStream != null) {
                c.a.n0.w.d.d(outputStream);
                this.f6525b = null;
            }
            this.f6526c = null;
            this.f6529f = null;
            i = 3;
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
                    aVar.f6542b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f6543c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.f6544d = stringTokenizer.nextToken();
                        } else {
                            aVar.f6544d = "HTTP/1.1";
                            if (f6524h) {
                                Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                            }
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (f6524h) {
                                Log.d("ClientHandler", "Http header :" + readLine2);
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
            } catch (IOException e2) {
                if (f6524h) {
                    Log.e("ClientHandler", "Decode header exception", e2);
                }
            }
        }
    }

    public void o(a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && i == 0) {
            this.f6530g = bVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
                    c.a aVar = new c.a();
                    m(bufferedReader, aVar);
                    d.a(aVar).e(this.f6525b);
                    if (aVar.f6545e) {
                        if (i != 0 && i != 3) {
                            c.a.n0.a.s1.b.f.e.f(c.a.n0.a.s0.a.c(), R.string.obfuscated_res_0x7f0f012f).G();
                            return;
                        }
                        c.a.n0.a.u.h.d.a aVar2 = new c.a.n0.a.u.h.d.a();
                        this.f6526c = aVar2;
                        aVar2.k(new C0472a(this));
                        this.f6526c.h(this.a, this.f6525b);
                    }
                } catch (RuntimeException e2) {
                    if (f6524h) {
                        Log.e("ClientHandler", "Request parse fail", e2);
                    }
                }
            } finally {
                c.a.n0.w.d.d(this.a);
                c.a.n0.w.d.d(this.f6525b);
            }
        }
    }
}
