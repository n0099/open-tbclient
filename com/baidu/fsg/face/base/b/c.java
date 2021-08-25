package com.baidu.fsg.face.base.b;

import com.baidu.android.common.logging.Log;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39670a = "SdkConfigOptions";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39671b = "global-config";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39672c = "host_version";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39673d = "zip_version";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39674e = "updateFail";

    /* renamed from: f  reason: collision with root package name */
    public static final String f39675f = "distributedSdk";

    /* renamed from: g  reason: collision with root package name */
    public static final String f39676g = "files";

    /* renamed from: h  reason: collision with root package name */
    public static final String f39677h = "list";

    /* renamed from: i  reason: collision with root package name */
    public static final String f39678i = "cpu";

    /* renamed from: j  reason: collision with root package name */
    public static final String f39679j = "extra_params";
    public static final String k = "extra_global_enable";
    public static final String l = "enable";
    public static final String m = "gray";
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public a o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        r5.o = com.baidu.fsg.face.base.b.c.a.a(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(JSONObject jSONObject, b.a aVar) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, aVar)) == null) {
            c cVar = new c();
            cVar.q = jSONObject.optBoolean(k, true);
            try {
                cVar.n = jSONObject.optString(f39673d);
                cVar.r = jSONObject.optBoolean(l, true);
                cVar.s = jSONObject.optInt("gray");
                jSONArray = jSONObject.getJSONArray("list");
            } catch (JSONException e2) {
                Log.e("SdkConfigOptions", e2);
            }
            if (jSONArray == null) {
                return cVar;
            }
            String e3 = h.e();
            if ("armeabi".equals(e3)) {
                e3 = "armeabi-v7a";
            }
            int i2 = 0;
            while (true) {
                if (i2 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null && e3.equals(jSONObject2.optString("cpu"))) {
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: d  reason: collision with root package name */
        public static final String f39680d = "name";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39681e = "url";

        /* renamed from: f  reason: collision with root package name */
        public static final String f39682f = "hash";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39683a;

        /* renamed from: b  reason: collision with root package name */
        public String f39684b;

        /* renamed from: c  reason: collision with root package name */
        public String f39685c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39683a = null;
            this.f39684b = null;
            this.f39685c = null;
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                a aVar = new a();
                if (jSONObject == null) {
                    return aVar;
                }
                aVar.f39683a = jSONObject.optString("name");
                aVar.f39684b = jSONObject.optString("url");
                aVar.f39685c = jSONObject.optString("hash");
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f39683a);
                    jSONObject.put("url", this.f39684b);
                    jSONObject.put("hash", this.f39685c);
                    return jSONObject;
                } catch (JSONException e2) {
                    com.baidu.fsg.face.base.d.d.a(e2);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public static c a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            c cVar = new c();
            cVar.n = jSONObject.optString(f39673d);
            cVar.p = jSONObject.optBoolean(f39674e);
            cVar.q = jSONObject.optBoolean(k);
            cVar.r = jSONObject.optBoolean(l);
            cVar.s = jSONObject.optInt("gray");
            cVar.o = a.a(jSONObject.optJSONObject(f39675f));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f39673d, this.n);
                jSONObject.put(f39674e, this.p);
                jSONObject.put(k, this.q);
                jSONObject.put(l, this.r);
                jSONObject.put("gray", this.s);
                jSONObject.put(f39675f, this.o == null ? "" : this.o.a());
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
