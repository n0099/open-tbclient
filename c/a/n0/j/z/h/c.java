package c.a.n0.j.z.h;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f8996c;

    /* renamed from: d  reason: collision with root package name */
    public b f8997d;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(151321955, "Lc/a/n0/j/z/h/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(151321955, "Lc/a/n0/j/z/h/c$a;");
                    return;
                }
            }
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, c.a.n0.a.b0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8997d = bVar;
    }

    public final void A(c.a.n0.a.o.b.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, aVar, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            if (WebSocketEventTarget.f29564b) {
                Log.i("WebSocket", format);
            }
            c.a.n0.j.n0.c.call(aVar, false, new f(format));
        }
    }

    public final void B(c.a.n0.a.o.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str) == null) {
            String format = String.format("%s:ok", str);
            if (WebSocketEventTarget.f29564b) {
                Log.i("WebSocket", format);
            }
            c.a.n0.j.n0.c.call(aVar, true, new f(format));
        }
    }

    public c C(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            c.a.n0.a.o.b.a E = E(jsObject);
            this.f8996c = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int type = E.getType("url");
            if (type != 7) {
                A(E, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", c.a.n0.j.h0.f.d.f(7), c.a.n0.j.h0.f.d.f(type)));
                return this;
            }
            String B = E.B("url");
            String B2 = E.B("__plugin__");
            if (!this.f8997d.a()) {
                A(E, "connectSocket", "up to max connect count");
                return this;
            } else if (!D(B, B2)) {
                A(E, "connectSocket", String.format("invalid url \"%s\"", B));
                return this;
            } else {
                WebSocketRequest z = z(B, E);
                F(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(z, this);
                    this.f8996c = connect.getTaskId();
                    this.f8997d.b(connect);
                    c.a.n0.j.n0.c.call(E, true, new g(this.f8996c, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e2) {
                    A(E, "connectSocket", e2.getMessage());
                    return this;
                }
            }
        }
        return (c) invokeL.objValue;
    }

    public final boolean D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.a.n0.a.n1.a.a.q()) {
                return true;
            }
            return str.startsWith("wss://") && c.a.n0.a.u1.a.b.c("socket", str, str2) == 0;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public final c.a.n0.a.o.b.a E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            return F == null ? new c.a.n0.a.o.b.a() : F;
        }
        return (c.a.n0.a.o.b.a) invokeL.objValue;
    }

    public final void F(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            close(null);
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.f8997d == null || jSONObject == null) {
                return;
            }
            this.f8997d.c(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.f8997d == null || jSONObject == null) {
                return;
            }
            this.f8997d.c(jSONObject.optString("taskID"));
        }
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            c.a.n0.a.o.b.a E = E(jsObject);
            int i = a.a[this.a.ordinal()];
            if (i == 1) {
                A(E, "SocketTask.send", "SocketTask.readyState is not OPEN");
            } else if (i != 2) {
                int type = E.getType("data");
                String str = null;
                if (type == 7) {
                    str = E.C("data", null);
                    jsArrayBuffer = null;
                } else if (type != 10) {
                    A(E, "SocketTask.send", "invalid data type");
                    return;
                } else {
                    jsArrayBuffer = E.t("data", null);
                }
                if (str == null && jsArrayBuffer == null) {
                    A(E, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.f8996c, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.f8996c, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                    }
                    B(E, "SocketTask.send");
                } catch (Exception e2) {
                    A(E, "SocketTask.send", e2.getMessage());
                }
            } else {
                A(E, "SocketTask.send", "SocketTask.readyState is CLOSED");
            }
        }
    }

    public final WebSocketRequest z(String str, @NonNull c.a.n0.a.o.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, aVar)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(aVar.B("method"));
            c.a.n0.a.o.b.a w = aVar.w("header");
            if (w != null) {
                for (String str2 : w.j()) {
                    if (!TextUtils.isEmpty(str2) && !c.a.n0.a.f1.a.f4418d.contains(str2.toUpperCase(Locale.US))) {
                        builder.addHeader(str2, w.H(str2));
                    }
                }
            }
            String[] D = aVar.D(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            ArrayList arrayList = new ArrayList();
            if (D != null && D.length != 0) {
                arrayList.addAll(Arrays.asList(D));
            } else {
                arrayList.add("");
            }
            builder.setProtocols(arrayList);
            builder.setConnectionLostTimeout(0);
            return builder.build();
        }
        return (WebSocketRequest) invokeLL.objValue;
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            c.a.n0.a.o.b.a E = E(jsObject);
            if (this.a == WebSocketEventTarget.SocketTaskState.CLOSE) {
                A(E, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int r = E.r("code", 1000);
            String B = E.B("reason");
            try {
                if (!(r == 1000 || (r >= 3000 && r <= 4999))) {
                    A(E, "SocketTask.close", d.a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.f8996c, r, B);
                    B(E, "SocketTask.close");
                } catch (Exception e2) {
                    A(E, "SocketTask.close", e2.getMessage());
                }
            } finally {
                this.f8997d.c(this.f8996c);
            }
        }
    }
}
