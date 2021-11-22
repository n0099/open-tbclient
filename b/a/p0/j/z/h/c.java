package b.a.p0.j.z.h;

import android.text.TextUtils;
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
/* loaded from: classes4.dex */
public class c extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f11552g;

    /* renamed from: h  reason: collision with root package name */
    public b f11553h;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11554a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1788793756, "Lb/a/p0/j/z/h/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1788793756, "Lb/a/p0/j/z/h/c$a;");
                    return;
                }
            }
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            f11554a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11554a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, b.a.p0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11553h = bVar;
    }

    public final void A(b.a.p0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            String format = String.format("%s:ok", str);
            boolean z = WebSocketEventTarget.f45498f;
            b.a.p0.j.n0.c.call(aVar, true, new f(format));
        }
    }

    public c B(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
            b.a.p0.a.y.b.a D = D(jsObject);
            this.f11552g = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int type = D.getType("url");
            if (type != 7) {
                z(D, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", b.a.p0.j.h0.f.d.f(7), b.a.p0.j.h0.f.d.f(type)));
                return this;
            }
            String B = D.B("url");
            String B2 = D.B("__plugin__");
            if (!this.f11553h.a()) {
                z(D, "connectSocket", "up to max connect count");
                return this;
            } else if (!C(B, B2)) {
                z(D, "connectSocket", String.format("invalid url \"%s\"", B));
                return this;
            } else {
                WebSocketRequest y = y(B, D);
                E(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(y, this);
                    this.f11552g = connect.getTaskId();
                    this.f11553h.b(connect);
                    b.a.p0.j.n0.c.call(D, true, new g(this.f11552g, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e2) {
                    z(D, "connectSocket", e2.getMessage());
                    return this;
                }
            }
        }
        return (c) invokeL.objValue;
    }

    public final boolean C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (b.a.p0.a.x1.a.a.q()) {
                return true;
            }
            return str.startsWith("wss://") && b.a.p0.a.e2.a.b.c("socket", str, str2) == 0;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public final b.a.p0.a.y.b.a D(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            return F == null ? new b.a.p0.a.y.b.a() : F;
        }
        return (b.a.p0.a.y.b.a) invokeL.objValue;
    }

    public final void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            close(null);
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.f11553h == null || jSONObject == null) {
                return;
            }
            this.f11553h.c(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.f11553h == null || jSONObject == null) {
                return;
            }
            this.f11553h.c(jSONObject.optString("taskID"));
        }
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            b.a.p0.a.y.b.a D = D(jsObject);
            int i2 = a.f11554a[this.f45499e.ordinal()];
            if (i2 == 1) {
                z(D, "SocketTask.send", "SocketTask.readyState is not OPEN");
            } else if (i2 != 2) {
                int type = D.getType("data");
                String str = null;
                if (type == 7) {
                    str = D.C("data", null);
                    jsArrayBuffer = null;
                } else if (type != 10) {
                    z(D, "SocketTask.send", "invalid data type");
                    return;
                } else {
                    jsArrayBuffer = D.t("data", null);
                }
                if (str == null && jsArrayBuffer == null) {
                    z(D, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.f11552g, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.f11552g, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                    }
                    A(D, "SocketTask.send");
                } catch (Exception e2) {
                    z(D, "SocketTask.send", e2.getMessage());
                }
            } else {
                z(D, "SocketTask.send", "SocketTask.readyState is CLOSED");
            }
        }
    }

    public final WebSocketRequest y(String str, @NonNull b.a.p0.a.y.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, aVar)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(aVar.B("method"));
            b.a.p0.a.y.b.a w = aVar.w("header");
            if (w != null) {
                for (String str2 : w.j()) {
                    if (!TextUtils.isEmpty(str2) && !b.a.p0.a.p1.a.f7725d.contains(str2.toUpperCase(Locale.US))) {
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

    public final void z(b.a.p0.a.y.b.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, aVar, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            boolean z = WebSocketEventTarget.f45498f;
            b.a.p0.j.n0.c.call(aVar, false, new f(format));
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            b.a.p0.a.y.b.a D = D(jsObject);
            if (this.f45499e == WebSocketEventTarget.SocketTaskState.CLOSE) {
                z(D, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int r = D.r("code", 1000);
            String B = D.B("reason");
            try {
                if (!(r == 1000 || (r >= 3000 && r <= 4999))) {
                    z(D, "SocketTask.close", d.f11555a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.f11552g, r, B);
                    A(D, "SocketTask.close");
                } catch (Exception e2) {
                    z(D, "SocketTask.close", e2.getMessage());
                }
            } finally {
                this.f11553h.c(this.f11552g);
            }
        }
    }
}
