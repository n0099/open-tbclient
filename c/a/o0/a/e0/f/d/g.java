package c.a.o0.a.e0.f.d;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
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
import com.kwad.sdk.api.core.RemoteViewBuilder;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5227a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1886833226, "Lc/a/o0/a/e0/f/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1886833226, "Lc/a/o0/a/e0/f/d/g;");
                return;
            }
        }
        f5227a = k.f7049a;
    }

    public static String d(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                return f("paramsMap is null");
            }
            String C = G.C(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID);
            int r = G.r("code");
            String C2 = G.C("reason");
            if (TextUtils.isEmpty(C)) {
                return f("taskId is empty");
            }
            try {
                WebSocketManager.INSTANCE.close(C, r, C2);
            } catch (Exception e2) {
                if (f5227a) {
                    e2.printStackTrace();
                }
            }
            return i(0, "close success", null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                return f("paramsMap is null");
            }
            String C = G.C("url");
            if (TextUtils.isEmpty(C)) {
                return f("url is null");
            }
            c.a.o0.a.y.b.a x = G.x("header");
            String[] E = G.E(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(C);
            builder.setHeaders(k(x));
            if (E != null && E.length > 0) {
                builder.setProtocols(Arrays.asList(E));
            }
            WebSocketTask connect = WebSocketManager.INSTANCE.connect(builder.build(), l(G));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, connect.getTaskId());
            } catch (JSONException e2) {
                if (f5227a) {
                    e2.printStackTrace();
                }
            }
            return i(0, "connect success", jSONObject);
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? i(202, str, null) : (String) invokeL.objValue;
    }

    public static String g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                try {
                    jSONObject.put("errMsg", String.valueOf(obj));
                } catch (Exception e2) {
                    if (f5227a) {
                        e2.printStackTrace();
                    }
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (f5227a) {
                String str = "getOnErrorParam - " + jSONObject2;
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (obj instanceof String) {
                    jSONObject.put("dataType", "string");
                    jSONObject.put("data", obj);
                } else if (obj instanceof ByteBuffer) {
                    jSONObject.put("dataType", "arrayBuffer");
                    ByteBuffer byteBuffer = (ByteBuffer) obj;
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    jSONObject.put("data", Base64.encodeToString(bArr, 2));
                }
            } catch (Exception e2) {
                if (f5227a) {
                    e2.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (f5227a) {
                String str = "getOnMessageParam - " + jSONObject2;
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String i(int i2, String str, JSONObject jSONObject) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65545, null, i2, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("reason", i2);
                jSONObject2.put("message", str);
                if (jSONObject != null) {
                    jSONObject2.put("data", jSONObject);
                }
            } catch (JSONException e2) {
                if (f5227a) {
                    e2.printStackTrace();
                }
            }
            String jSONObject3 = jSONObject2.toString();
            if (f5227a) {
                String str2 = "getResultMsg - " + jSONObject3;
            }
            return jSONObject3;
        }
        return (String) invokeILL.objValue;
    }

    public static JsFunction j(@NonNull c.a.o0.a.y.b.a aVar, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, aVar, str, z)) == null) {
            JsFunction v = aVar.v(str);
            if (v != null) {
                v.setReleaseMode(z);
            }
            return v;
        }
        return (JsFunction) invokeLLZ.objValue;
    }

    public static Map<String, String> k(c.a.o0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, aVar)) == null) {
            HashMap hashMap = new HashMap();
            if (aVar != null) {
                for (String str : aVar.k()) {
                    hashMap.put(str, aVar.C(str));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static IWebSocketListener l(@NonNull c.a.o0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, aVar)) == null) ? new a(j(aVar, "onOpen", true), j(aVar, "onMessage", false), j(aVar, "onClose", true), j(aVar, "onError", false)) : (IWebSocketListener) invokeL.objValue;
    }

    public static String m(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                return f("paramsMap is null");
            }
            String C = G.C(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID);
            String C2 = G.C("data");
            if (TextUtils.isEmpty(C)) {
                return f("taskId is empty");
            }
            try {
                WebSocketManager.INSTANCE.send(C, C2);
            } catch (Exception e2) {
                if (f5227a) {
                    e2.printStackTrace();
                }
            }
            return i(0, "send success", null);
        }
        return (String) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static class a implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsFunction f5228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JsFunction f5229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JsFunction f5230g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JsFunction f5231h;

        public a(JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, JsFunction jsFunction4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsFunction, jsFunction2, jsFunction3, jsFunction4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5228e = jsFunction;
            this.f5229f = jsFunction2;
            this.f5230g = jsFunction3;
            this.f5231h = jsFunction4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
                if (g.f5227a) {
                    String str = "onClose - " + jSONObject2;
                }
                JsFunction jsFunction = this.f5230g;
                if (jsFunction != null) {
                    jsFunction.call(jSONObject2);
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) {
                String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
                if (g.f5227a) {
                    String str = "onError throwable - " + th;
                    String str2 = "onError jsonObject - " + jSONObject2;
                }
                JsFunction jsFunction = this.f5231h;
                if (jsFunction != null) {
                    jsFunction.call(g.g(th));
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jsFunction = this.f5229f) == null) {
                return;
            }
            jsFunction.call(g.h(str));
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, map) == null) || (jsFunction = this.f5228e) == null) {
                return;
            }
            jsFunction.call();
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) || (jsFunction = this.f5229f) == null) {
                return;
            }
            jsFunction.call(g.h(byteBuffer));
        }
    }
}
