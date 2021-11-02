package b.a.p0.a.u.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
public abstract class d implements b.a.p0.a.u.c.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8000c;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.u.c.b f8001a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f8002b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.u.h.b f8004f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f8005g;

        public a(d dVar, String str, b.a.p0.a.u.h.b bVar) {
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
            this.f8005g = dVar;
            this.f8003e = str;
            this.f8004f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8005g.p(this.f8003e, this.f8004f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        b.a.p0.a.u.h.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1515381165, "Lb/a/p0/a/u/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1515381165, "Lb/a/p0/a/u/c/d;");
                return;
            }
        }
        f8000c = k.f6397a;
    }

    public d(@NonNull b.a.p0.a.u.c.b bVar) {
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
        this.f8001a = bVar;
        this.f8002b = bVar.g();
    }

    @Nullable
    public static JSONObject l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (f8000c) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    public static Pair<b.a.p0.a.u.h.a, JSONObject> m(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject)) == null) {
            boolean z = f8000c;
            if (jsObject == null) {
                if (!f8000c) {
                    return new Pair<>(new b.a.p0.a.u.h.b(202, "parseParams(JsObject): jsObject cannot be null"), null);
                }
                throw new RuntimeException("parseParams(JsObject): jsObject cannot be null");
            }
            int type = jsObject.getType();
            int length = jsObject.length();
            if (type != 9) {
                String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
                if (!f8000c) {
                    jsObject.release();
                    return new Pair<>(new b.a.p0.a.u.h.b(202, str), null);
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
                                if (f8000c) {
                                    e2.printStackTrace();
                                    break;
                                } else {
                                    break;
                                }
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(i2);
                            if (objectArray == null) {
                                if (f8000c) {
                                    throw new RuntimeException("parseParams(JsObject): jsObjects cannot be null");
                                }
                                break;
                            } else {
                                jSONObject.put(propertyName, o(objectArray));
                                break;
                            }
                        case 7:
                            jSONObject.put(propertyName, jsObject.toString(i2));
                            break;
                        case 8:
                            jSONObject.put(propertyName, jsObject.toJsFunction(i2));
                            break;
                        case 9:
                            jSONObject.put(propertyName, m(jsObject.toJsObject(i2)).second);
                            break;
                        case 10:
                            jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i2));
                            break;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String str2 = "parseParams(JsObject): with exception " + e3.getMessage();
                    if (!f8000c) {
                        jsObject.release();
                        return new Pair<>(new b.a.p0.a.u.h.b(202, str2), null);
                    }
                    throw new RuntimeException(str2, e3);
                }
            }
            jsObject.release();
            return new Pair<>(new b.a.p0.a.u.h.b(0), jSONObject);
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<b.a.p0.a.u.h.a, JSONObject> n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            boolean z = f8000c;
            if (TextUtils.isEmpty(str)) {
                boolean z2 = f8000c;
                return new Pair<>(new b.a.p0.a.u.h.b(202, "parseParams(String): json string cannot be empty"), null);
            }
            try {
                return new Pair<>(new b.a.p0.a.u.h.b(0), new JSONObject(str));
            } catch (JSONException e2) {
                if (f8000c) {
                    e2.printStackTrace();
                }
                return new Pair<>(new b.a.p0.a.u.h.b(202, "parseParams(String): with json exception "), null);
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
    public static JSONArray o(@NonNull JsObject[] jsObjectArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jsObjectArr)) == null) {
            boolean z = f8000c;
            JSONArray jSONArray = new JSONArray();
            for (JsObject jsObject : jsObjectArr) {
                if (jsObject == null) {
                    if (!f8000c) {
                        jSONArray.put((Object) null);
                    } else {
                        throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be null");
                    }
                } else {
                    switch (jsObject.getType()) {
                        case 0:
                            if (!f8000c) {
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
                                if (f8000c) {
                                    e2.printStackTrace();
                                }
                                jSONArray.put((Object) null);
                                break;
                            }
                        case 6:
                            JsObject[] objectArray = jsObject.toObjectArray(0);
                            if (objectArray == null) {
                                if (!f8000c) {
                                    jSONArray.put((Object) null);
                                    continue;
                                } else {
                                    throw new RuntimeException("parseParams(JsObject[]): objects is null");
                                }
                            } else {
                                jSONArray.put(o(objectArray));
                                break;
                            }
                        case 7:
                            jSONArray.put(jsObject.toString(0));
                            continue;
                        case 8:
                            jSONArray.put(jsObject.toJsFunction(0));
                            continue;
                        case 9:
                            jSONArray.put(m(jsObject).second);
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

    @Override // b.a.p0.a.u.c.a
    @NonNull
    public final b.a.p0.a.u.c.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8001a : (b.a.p0.a.u.c.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.a
    public final void d(String str, b.a.p0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            if (f8000c) {
                String str2 = "invokeCallback: " + str;
            }
            if (TextUtils.isEmpty(str)) {
                if (f8000c) {
                    throw new RuntimeException("invokeCallback: do callback with a empty callback");
                }
            } else if (bVar == null) {
                if (f8000c) {
                    throw new RuntimeException("invokeCallback: do callback with a null result");
                }
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                p(str, bVar);
            } else {
                if (f8000c) {
                    String str3 = "invokeCallback: other thread " + Thread.currentThread().getName();
                }
                if (b.a.p0.a.r1.l.e.a()) {
                    p(str, bVar);
                } else {
                    q0.X(new a(this, str, bVar));
                }
            }
        }
    }

    @NonNull
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8001a.getContext() : (Context) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b i(String str, boolean z, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bVar})) == null) {
            e i2 = e.i();
            if (i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar2 = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar2.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                return bVar2;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String str2 = null;
            if (z) {
                str2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(str2)) {
                    b.a.p0.a.e0.d.b("Api-Base", "callback is null");
                    return new b.a.p0.a.u.h.b(202, "callback is null");
                }
            }
            return bVar.a(i2, jSONObject, str2);
        }
        return (b.a.p0.a.u.h.b) invokeCommon.objValue;
    }

    public b.a.p0.a.u.h.b j(@Nullable String str, @NonNull c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cVar)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (f8000c) {
                    b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-Base", "cb is required");
                return new b.a.p0.a.u.h.b(202, "cb is required");
            }
            return cVar.f(jSONObject, optString, this);
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e P = e.P();
            if (P == null) {
                return true;
            }
            return P.c0();
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public final void p(@NonNull String str, @NonNull b.a.p0.a.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str) && !(this.f8002b instanceof NullableCallbackHandler)) {
                if (f8000c) {
                    String str2 = "realInvokeCallback: callback check fail: " + str;
                    return;
                }
                return;
            }
            if (f8000c) {
                String str3 = "realInvokeCallback: invoke 【" + str + "】 with 【" + bVar + "】";
            }
            this.f8002b.handleSchemeDispatchCallback(str, bVar.a());
        }
    }
}
