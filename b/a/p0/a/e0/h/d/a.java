package b.a.p0.a.e0.h.d;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketException;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f4746g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f4747a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f4748b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f4749c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0161a f4750d;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f4751e;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f4752f;

    /* renamed from: b.a.p0.a.e0.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0161a {
        void a(WebSocketFrame webSocketFrame);

        void b(IOException iOException);

        void onClose();

        void onOpen();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338061382, "Lb/a/p0/a/e0/h/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1338061382, "Lb/a/p0/a/e0/h/d/a;");
                return;
            }
        }
        f4746g = k.f6863a;
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
                return;
            }
        }
        this.f4747a = 1;
        this.f4751e = null;
        this.f4752f = new LinkedList();
    }

    public static boolean f(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            String str = map.get("Upgrade".toLowerCase());
            String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
            return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
        }
        return invokeL.booleanValue;
    }

    public static String g(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update((str + WebSocketProtocol.ACCEPT_MAGIC).getBytes());
            return Base64.encodeToString(messageDigest.digest(), 2);
        }
        return (String) invokeL.objValue;
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, closeCode, str) == null) {
            int i2 = this.f4747a;
            this.f4747a = 3;
            if (i2 == 2) {
                j(new WebSocketFrame.b(closeCode, str));
            } else {
                b();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f4747a == 4) {
            return;
        }
        d.d(this.f4748b);
        d.d(this.f4749c);
        this.f4747a = 4;
        this.f4750d.onClose();
    }

    public final void c(WebSocketFrame webSocketFrame) throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webSocketFrame) == null) {
            WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
            if (webSocketFrame instanceof WebSocketFrame.b) {
                WebSocketFrame.b bVar = (WebSocketFrame.b) webSocketFrame;
                closeCode = bVar.v();
                str = bVar.w();
            } else {
                str = "";
            }
            if (this.f4747a == 3) {
                b();
            } else {
                a(closeCode, str);
            }
        }
    }

    public final void d(WebSocketFrame webSocketFrame) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webSocketFrame) == null) {
            if (webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
                if (this.f4751e != null && f4746g) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
                }
                this.f4751e = webSocketFrame.f();
                this.f4752f.clear();
                this.f4752f.add(webSocketFrame);
            } else if (webSocketFrame.h()) {
                if (this.f4751e != null) {
                    this.f4752f.add(webSocketFrame);
                    this.f4750d.a(new WebSocketFrame(this.f4751e, this.f4752f));
                    this.f4751e = null;
                    this.f4752f.clear();
                    return;
                }
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            } else if (this.f4751e != null) {
                this.f4752f.add(webSocketFrame);
            } else {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
        }
    }

    public final void e(WebSocketFrame webSocketFrame) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webSocketFrame) == null) {
            if (webSocketFrame.f() == WebSocketFrame.OpCode.Close) {
                c(webSocketFrame);
            } else if (webSocketFrame.f() == WebSocketFrame.OpCode.Ping) {
                j(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.d()));
            } else if (webSocketFrame.f() == WebSocketFrame.OpCode.Pong) {
                boolean z = f4746g;
            } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
                if (this.f4751e == null) {
                    if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                        throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                    }
                    this.f4750d.a(webSocketFrame);
                    return;
                }
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
            } else {
                d(webSocketFrame);
            }
        }
    }

    public void h(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, inputStream, outputStream) == null) {
            this.f4748b = inputStream;
            this.f4749c = outputStream;
            this.f4747a = 2;
            InterfaceC0161a interfaceC0161a = this.f4750d;
            if (interfaceC0161a != null) {
                interfaceC0161a.onOpen();
            }
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            while (this.f4747a == 2) {
                try {
                    try {
                        e(WebSocketFrame.k(this.f4748b));
                    } catch (IOException e2) {
                        if (this.f4750d != null) {
                            this.f4750d.b(e2);
                        }
                        b.a.p0.a.e0.d.d("V8WebSocket", "parse web socket frame fail", e2);
                    }
                } finally {
                    b();
                }
            }
        }
    }

    public synchronized void j(WebSocketFrame webSocketFrame) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, webSocketFrame) == null) {
            synchronized (this) {
                webSocketFrame.t(this.f4749c);
            }
        }
    }

    public void k(InterfaceC0161a interfaceC0161a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC0161a) == null) {
            this.f4750d = interfaceC0161a;
        }
    }
}
