package com.baidu.swan.games.network.websocket;

import c.a.p0.a.a;
import c.a.p0.j.z.h.e;
import c.a.p0.j.z.h.f;
import c.a.p0.j.z.h.h;
import c.a.p0.j.z.h.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WebSocketEventTarget extends EventTargetImpl implements IWebSocketListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f38451f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SocketTaskState f38452e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class SocketTaskState {
        public static final /* synthetic */ SocketTaskState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SocketTaskState CLOSE;
        public static final SocketTaskState IDLE;
        public static final SocketTaskState OPEN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1837085147, "Lcom/baidu/swan/games/network/websocket/WebSocketEventTarget$SocketTaskState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1837085147, "Lcom/baidu/swan/games/network/websocket/WebSocketEventTarget$SocketTaskState;");
                    return;
                }
            }
            IDLE = new SocketTaskState("IDLE", 0);
            OPEN = new SocketTaskState("OPEN", 1);
            SocketTaskState socketTaskState = new SocketTaskState("CLOSE", 2);
            CLOSE = socketTaskState;
            $VALUES = new SocketTaskState[]{IDLE, OPEN, socketTaskState};
        }

        public SocketTaskState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SocketTaskState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SocketTaskState) Enum.valueOf(SocketTaskState.class, str) : (SocketTaskState) invokeL.objValue;
        }

        public static SocketTaskState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SocketTaskState[]) $VALUES.clone() : (SocketTaskState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1533247568, "Lcom/baidu/swan/games/network/websocket/WebSocketEventTarget;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1533247568, "Lcom/baidu/swan/games/network/websocket/WebSocketEventTarget;");
                return;
            }
        }
        f38451f = a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketEventTarget(JSRuntime jSRuntime) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
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
        this.f38452e = SocketTaskState.IDLE;
    }

    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f38452e = SocketTaskState.CLOSE;
            x(IntentConfig.CLOSE, new e(jSONObject != null ? jSONObject.optInt("code", 0) : 0, jSONObject == null ? "" : jSONObject.optString("reason")));
        }
    }

    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) && this.f38452e == SocketTaskState.IDLE) {
            x("error", new f(th.getMessage()));
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            x("message", new h(str));
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onOpen(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.f38452e = SocketTaskState.OPEN;
            x("open", new i(new JSONObject(map)));
        }
    }

    public final void x(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            if (f38451f) {
                String str2 = "dispatchEvent:" + str;
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            x("message", new h(new JsArrayBuffer(bArr, remaining)));
        }
    }
}
