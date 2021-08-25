package c.a.o0.a.n1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import c.a.o0.a.c2.f.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class n extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1021091811, "Lc/a/o0/a/n1/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1021091811, "Lc/a/o0/a/n1/n;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/webSocket");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, entity, callbackHandler, str, eVar)) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (a0.f4738b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (eVar == null) {
                c.a.o0.a.e0.d.b("websocket", "param is null");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4738b;
                return false;
            } else if (TextUtils.isEmpty(eVar.f4530f)) {
                c.a.o0.a.e0.d.b("websocket", "aiapp id is invalid");
                entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                boolean z2 = a0.f4738b;
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
                if (optParamsAsJo == null) {
                    c.a.o0.a.e0.d.b("websocket", "no params found");
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                    boolean z3 = a0.f4738b;
                    return false;
                }
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -1597844571) {
                        if (hashCode != -1293540435) {
                            if (hashCode == 1991859579 && str.equals("/swanAPI/webSocket/close")) {
                                return k(context, optParamsAsJo, entity, callbackHandler, eVar);
                            }
                        } else if (str.equals("/swanAPI/webSocket/connect")) {
                            return l(context, optParamsAsJo, entity, callbackHandler, eVar);
                        }
                    } else if (str.equals("/swanAPI/webSocket/send")) {
                        return m(context, optParamsAsJo, entity, callbackHandler, eVar);
                    }
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final IWebSocketListener j(JSONObject jSONObject, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, callbackHandler)) == null) ? new a(this, new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError")) : (IWebSocketListener) invokeLL.objValue;
    }

    public final boolean k(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, jSONObject, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!jSONObject.has("taskID")) {
                c.a.o0.a.e0.d.b("websocket", "taskID lose");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
                boolean z = a0.f4738b;
                return false;
            }
            String taskId = jSONObject.getString("taskID");
            int optInt = jSONObject.optInt("code", 1000);
            String reason = jSONObject.optString("reason", "close normally");
            try {
                try {
                    WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    Intrinsics.checkNotNullExpressionValue(reason, "reason");
                    webSocketManager.close(taskId, optInt, reason);
                    eVar.b0().c(taskId);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                } catch (Exception e2) {
                    c.a.o0.a.e0.d.b("websocket", e2.getMessage());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                    if (a0.f4738b) {
                        String str = "close --- " + e2.getMessage();
                    }
                    k b0 = eVar.b0();
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    b0.c(taskId);
                    return false;
                }
            } catch (Throwable th) {
                k b02 = eVar.b0();
                Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                b02.c(taskId);
                throw th;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean l(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, jSONObject, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (jSONObject.has("url") && jSONObject.has("cb")) {
                JSONObject cb = jSONObject.getJSONObject("cb");
                if (cb.has("onOpen") && cb.has("onMessage") && cb.has("onClose") && cb.has("onError")) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!eVar.b0().a()) {
                        jSONObject2.put("errno", "1");
                    } else {
                        String string = jSONObject.getString("url");
                        String optString = jSONObject.optString("__plugin__");
                        int c2 = c.a.o0.a.b2.a.b.c("socket", string, optString);
                        if (c2 == 1) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                            return false;
                        } else if (c2 != 2) {
                            WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
                            if (!TextUtils.isEmpty(optString)) {
                                c.a.o0.n.h.h h2 = c.a.o0.a.t1.g.b.h(optString);
                                Map<String, String> headers = fromJSON.getHeaders();
                                if (headers == null) {
                                    headers = new LinkedHashMap<>();
                                    fromJSON.setHeaders(headers);
                                }
                                String b2 = c.a.o0.a.t1.g.a.b(h2);
                                Intrinsics.checkNotNullExpressionValue(b2, "SwanPluginHostSign.hostSign(pmsPlugin)");
                                headers.put("X-SWAN-HOSTSIGN", b2);
                            }
                            Intrinsics.checkNotNullExpressionValue(cb, "cb");
                            try {
                                WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, j(cb, callbackHandler));
                                jSONObject2.put("errno", "0");
                                jSONObject2.put("task", connect.toJSON());
                                eVar.b0().b(connect);
                            } catch (Exception e2) {
                                c.a.o0.a.e0.d.b("websocket", e2.getMessage());
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                                if (a0.f4738b) {
                                    String str = "connect --- " + e2.getMessage();
                                }
                                return false;
                            }
                        } else {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
                            return false;
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    return true;
                }
                c.a.o0.a.e0.d.b("websocket", "websocket callback lose");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
                boolean z = a0.f4738b;
                return false;
            }
            c.a.o0.a.e0.d.b("websocket", "url or cb lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
            boolean z2 = a0.f4738b;
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean m(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, context, jSONObject, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (jSONObject.has("taskID") && jSONObject.has("data")) {
                String taskId = jSONObject.getString("taskID");
                String data = jSONObject.getString("data");
                try {
                    if (jSONObject.optString("dataType", "string").equals("arrayBuffer")) {
                        ByteBuffer buffer = ByteBuffer.wrap(Base64.decode(data, 2));
                        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                        Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                        webSocketManager.send(taskId, buffer);
                    } else {
                        WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                        Intrinsics.checkNotNullExpressionValue(data, "data");
                        webSocketManager2.send(taskId, data);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                } catch (Exception e2) {
                    c.a.o0.a.e0.d.b("websocket", e2.getMessage());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                    if (a0.f4738b) {
                        String str = "send --- " + e2.getMessage();
                    }
                    return false;
                }
            }
            c.a.o0.a.e0.d.b("websocket", "taskID or data lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
            boolean z = a0.f4738b;
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static final class a implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f7584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WeakReference f7585f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7586g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7587h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7588i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7589j;

        public a(n nVar, WeakReference weakReference, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, weakReference, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7584e = nVar;
            this.f7585f = weakReference;
            this.f7586g = str;
            this.f7587h = str2;
            this.f7588i = str3;
            this.f7589j = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            c.a.o0.a.a2.e c2;
            k b0;
            String optString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", jSONObject != null ? jSONObject.optInt("code") : 0);
                String str = "";
                if (jSONObject != null && (optString = jSONObject.optString("reason", "")) != null) {
                    str = optString;
                }
                jSONObject2.put("reason", str);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "websocket closed");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.f7585f.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f7588i, jSONObject3.toString());
                }
                String string = jSONObject != null ? jSONObject.getString("taskID") : null;
                if (string == null || (c2 = this.f7584e.c()) == null || (b0 = c2.b0()) == null) {
                    return;
                }
                b0.c(string);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable t, JSONObject jSONObject) {
            c.a.o0.a.a2.e c2;
            k b0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, jSONObject) == null) {
                Intrinsics.checkNotNullParameter(t, "t");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errMsg", t.getMessage());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "error happen");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.f7585f.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f7589j, jSONObject3.toString());
                }
                String string = jSONObject != null ? jSONObject.getString("taskID") : null;
                if (string == null || (c2 = this.f7584e.c()) == null || (b0 = c2.b0()) == null) {
                    return;
                }
                b0.c(string);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                Intrinsics.checkNotNullParameter(message, "message");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", message);
                jSONObject.put("dataType", "string");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", "0");
                jSONObject2.put("message", "message received");
                jSONObject2.put("data", jSONObject);
                CallbackHandler callbackHandler = (CallbackHandler) this.f7585f.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f7587h, jSONObject2.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> headers) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, headers) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                JSONObject jSONObject = new JSONObject(headers);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("header", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "websocket open success");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler = (CallbackHandler) this.f7585f.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f7586g, jSONObject3.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                Intrinsics.checkNotNullParameter(message, "message");
                byte[] bArr = new byte[message.remaining()];
                message.get(bArr);
                String encodeToString = Base64.encodeToString(bArr, 2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", encodeToString);
                jSONObject.put("dataType", "arrayBuffer");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", "0");
                jSONObject2.put("message", "message received");
                jSONObject2.put("data", jSONObject);
                CallbackHandler callbackHandler = (CallbackHandler) this.f7585f.get();
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(this.f7587h, jSONObject2.toString());
                }
            }
        }
    }
}
