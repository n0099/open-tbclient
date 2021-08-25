package c.a.o0.a.u.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.e;
import c.a.o0.a.k;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d implements c.a.o0.a.u.c.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8699c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.u.c.b f8700a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f8701b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.u.h.b f8703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f8704g;

        public a(d dVar, String str, c.a.o0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8704g = dVar;
            this.f8702e = str;
            this.f8703f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8704g.q(this.f8702e, this.f8703f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        c.a.o0.a.u.h.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1789122003, "Lc/a/o0/a/u/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1789122003, "Lc/a/o0/a/u/c/d;");
                return;
            }
        }
        f8699c = k.f7049a;
    }

    public d(@NonNull c.a.o0.a.u.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8700a = bVar;
        this.f8701b = bVar.h();
    }

    @Nullable
    public static JSONObject m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (f8699c) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    public static Pair<c.a.o0.a.u.h.a, JSONObject> n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject)) == null) {
            boolean z = f8699c;
            if (jsObject == null) {
                if (!f8699c) {
                    return new Pair<>(new c.a.o0.a.u.h.b(202, "parseParams(JsObject): jsObject cannot be null"), null);
                }
                throw new RuntimeException("parseParams(JsObject): jsObject cannot be null");
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                if (!f8699c) {
                    jsObject.release();
                    return new Pair<>(new c.a.o0.a.u.h.b(202, str), null);
                }
                throw new RuntimeException(str);
            }
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    int propertyType = jsObject.getPropertyType(i2);
                    String propertyName = jsObject.getPropertyName(i2);
                    switch (propertyType) {
                        case 1:
                            jSONObject.put(propertyName, jsObject.toBoolean(i2));
                            break;
                        case 2:
                            jSONObject.put(propertyName, jsObject.toInteger(i2));
                            break;
                        case 3:
                            jSONObject.put(propertyName, jsObject.toLong(i2));
                            break;
                        case 5:
                            try {
                                jSONObject.put(propertyName, jsObject.toDouble(i2));
                                break;
                            } catch (JSONException e2) {
                                if (f8699c) {
                                    e2.printStackTrace();
                                    break;
                                } else {
                                    break;
                                }
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(i2);
                            if (objectArray == null) {
                                if (f8699c) {
                                    throw new RuntimeException("parseParams(JsObject): jsObjects cannot be null");
                                }
                                break;
                            } else {
                                jSONObject.put(propertyName, p(objectArray));
                                break;
                            }
                        case 7:
                            jSONObject.put(propertyName, jsObject.toString(i2));
                            break;
                        case 8:
                            jSONObject.put(propertyName, jsObject.toJsFunction(i2));
                            break;
                        case 9:
                            jSONObject.put(propertyName, n(jsObject.toJsObject(i2)).second);
                            break;
                        case 10:
                            jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i2));
                            break;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String str2 = "parseParams(JsObject): with exception " + e3.getMessage();
                    if (!f8699c) {
                        jsObject.release();
                        return new Pair<>(new c.a.o0.a.u.h.b(202, str2), null);
                    }
                    throw new RuntimeException(str2, e3);
                }
            }
            jsObject.release();
            return new Pair<>(new c.a.o0.a.u.h.b(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<c.a.o0.a.u.h.a, JSONObject> o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            boolean z = f8699c;
            if (TextUtils.isEmpty(str)) {
                boolean z2 = f8699c;
                return new Pair<>(new c.a.o0.a.u.h.b(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair<>(new c.a.o0.a.u.h.b(0), new JSONObject(str));
            } catch (JSONException e2) {
                if (f8699c) {
                    e2.printStackTrace();
                }
                return new Pair<>(new c.a.o0.a.u.h.b(202, "parseParams(String): with json exception "), null);
            }
        }
        return (Pair) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
        continue;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray p(@NonNull JsObject[] jsObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jsObjectArr)) == null) {
            boolean z = f8699c;
            JSONArray jSONArray = new JSONArray();
            for (JsObject jsObject : jsObjectArr) {
                if (jsObject == null) {
                    if (!f8699c) {
                        jSONArray.put((Object) null);
                    } else {
                        throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be null");
                    }
                } else {
                    switch (jsObject.getType()) {
                        case 0:
                            if (!f8699c) {
                                jSONArray.put((Object) null);
                                continue;
                            } else {
                                throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be JNONSUPPORT");
                            }
                        case 1:
                            jSONArray.put(jsObject.toBoolean(0));
                            continue;
                        case 2:
                            jSONArray.put(jsObject.toInteger(0));
                            continue;
                        case 3:
                            jSONArray.put(jsObject.toLong(0));
                            continue;
                        case 5:
                            try {
                                jSONArray.put(jsObject.toDouble(0));
                                continue;
                            } catch (JSONException e2) {
                                if (f8699c) {
                                    e2.printStackTrace();
                                }
                                jSONArray.put((Object) null);
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(0);
                            if (objectArray == null) {
                                if (!f8699c) {
                                    jSONArray.put((Object) null);
                                    continue;
                                } else {
                                    throw new RuntimeException("parseParams(JsObject[]): objects is null");
                                }
                            } else {
                                jSONArray.put(p(objectArray));
                                break;
                            }
                        case 7:
                            jSONArray.put(jsObject.toString(0));
                            continue;
                        case 8:
                            jSONArray.put(jsObject.toJsFunction(0));
                            continue;
                        case 9:
                            jSONArray.put(n(jsObject).second);
                            continue;
                        case 10:
                            jSONArray.put(jsObject.toJsArrayBuffer(0));
                            continue;
                        case 11:
                            jSONArray.put((Object) null);
                            continue;
                        case 12:
                            jSONArray.put((Object) null);
                            continue;
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // c.a.o0.a.u.c.a
    @NonNull
    public final c.a.o0.a.u.c.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8700a : (c.a.o0.a.u.c.b) invokeV.objValue;
    }

    @Override // c.a.o0.a.u.c.a
    public final void d(String str, c.a.o0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            if (f8699c) {
                String str2 = "invokeCallback: " + str;
            }
            if (TextUtils.isEmpty(str)) {
                if (f8699c) {
                    throw new RuntimeException("invokeCallback: do callback with a empty callback");
                }
            } else if (bVar == null) {
                if (f8699c) {
                    throw new RuntimeException("invokeCallback: do callback with a null result");
                }
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                q(str, bVar);
            } else {
                if (f8699c) {
                    String str3 = "invokeCallback: other thread " + Thread.currentThread().getName();
                }
                if (c.a.o0.a.r1.l.e.a()) {
                    q(str, bVar);
                } else {
                    q0.X(new a(this, str, bVar));
                }
            }
        }
    }

    @NonNull
    public final Context i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8700a.getContext() : (Context) invokeV.objValue;
    }

    public c.a.o0.a.u.h.b j(String str, boolean z, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bVar})) == null) {
            e i2 = e.i();
            if (i2 == null) {
                return new c.a.o0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar2 = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar2.isSuccess()) {
                c.a.o0.a.e0.d.b("Api-Base", "parse fail");
                return bVar2;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String str2 = null;
            if (z) {
                str2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(str2)) {
                    c.a.o0.a.e0.d.b("Api-Base", "callback is null");
                    return new c.a.o0.a.u.h.b(202, "callback is null");
                }
            }
            return bVar.a(i2, jSONObject, str2);
        }
        return (c.a.o0.a.u.h.b) invokeCommon.objValue;
    }

    public c.a.o0.a.u.h.b k(@Nullable String str, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cVar)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (f8699c) {
                    c.a.o0.a.e0.d.b("Api-Base", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.o0.a.e0.d.b("Api-Base", "cb is required");
                return new c.a.o0.a.u.h.b(202, "cb is required");
            }
            return cVar.f(jSONObject, optString, this);
        }
        return (c.a.o0.a.u.h.b) invokeLL.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e Q = e.Q();
            if (Q == null) {
                return true;
            }
            return Q.d0();
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public final void q(@NonNull String str, @NonNull c.a.o0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str) && !(this.f8701b instanceof NullableCallbackHandler)) {
                if (f8699c) {
                    String str2 = "realInvokeCallback: callback check fail: " + str;
                    return;
                }
                return;
            }
            if (f8699c) {
                String str3 = "realInvokeCallback: invoke 【" + str + "】 with 【" + bVar + "】";
            }
            this.f8701b.handleSchemeDispatchCallback(str, bVar.a());
        }
    }
}
