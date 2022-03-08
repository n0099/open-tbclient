package c.a.p0.a.u.h.d;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.w.d;
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
    public static final boolean f7743g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f7744b;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f7745c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0484a f7746d;

    /* renamed from: e  reason: collision with root package name */
    public WebSocketFrame.OpCode f7747e;

    /* renamed from: f  reason: collision with root package name */
    public final List<WebSocketFrame> f7748f;

    /* renamed from: c.a.p0.a.u.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0484a {
        void a(WebSocketFrame webSocketFrame);

        void b(IOException iOException);

        void onClose();

        void onOpen();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209060765, "Lc/a/p0/a/u/h/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209060765, "Lc/a/p0/a/u/h/d/a;");
                return;
            }
        }
        f7743g = c.a.p0.a.a.a;
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
        this.a = 1;
        this.f7747e = null;
        this.f7748f = new LinkedList();
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
            int i2 = this.a;
            this.a = 3;
            if (i2 == 2) {
                j(new WebSocketFrame.b(closeCode, str));
            } else {
                b();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == 4) {
            return;
        }
        d.d(this.f7744b);
        d.d(this.f7745c);
        this.a = 4;
        this.f7746d.onClose();
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
            if (this.a == 3) {
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
                if (this.f7747e != null && f7743g) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
                }
                this.f7747e = webSocketFrame.f();
                this.f7748f.clear();
                this.f7748f.add(webSocketFrame);
            } else if (webSocketFrame.h()) {
                if (this.f7747e != null) {
                    this.f7748f.add(webSocketFrame);
                    this.f7746d.a(new WebSocketFrame(this.f7747e, this.f7748f));
                    this.f7747e = null;
                    this.f7748f.clear();
                    return;
                }
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            } else if (this.f7747e != null) {
                this.f7748f.add(webSocketFrame);
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
                boolean z = f7743g;
            } else if (webSocketFrame.h() && webSocketFrame.f() != WebSocketFrame.OpCode.Continuation) {
                if (this.f7747e == null) {
                    if (webSocketFrame.f() != WebSocketFrame.OpCode.Text && webSocketFrame.f() != WebSocketFrame.OpCode.Binary) {
                        throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                    }
                    this.f7746d.a(webSocketFrame);
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
            this.f7744b = inputStream;
            this.f7745c = outputStream;
            this.a = 2;
            InterfaceC0484a interfaceC0484a = this.f7746d;
            if (interfaceC0484a != null) {
                interfaceC0484a.onOpen();
            }
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            while (this.a == 2) {
                try {
                    try {
                        e(WebSocketFrame.k(this.f7744b));
                    } catch (IOException e2) {
                        if (this.f7746d != null) {
                            this.f7746d.b(e2);
                        }
                        c.a.p0.a.u.d.d("V8WebSocket", "parse web socket frame fail", e2);
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
                webSocketFrame.t(this.f7745c);
            }
        }
    }

    public void k(InterfaceC0484a interfaceC0484a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, interfaceC0484a) == null) {
            this.f7746d = interfaceC0484a;
        }
    }
}
