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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SdkConfigOptions";

    /* renamed from: b  reason: collision with root package name */
    public static final String f32633b = "global-config";

    /* renamed from: c  reason: collision with root package name */
    public static final String f32634c = "host_version";

    /* renamed from: d  reason: collision with root package name */
    public static final String f32635d = "zip_version";

    /* renamed from: e  reason: collision with root package name */
    public static final String f32636e = "updateFail";

    /* renamed from: f  reason: collision with root package name */
    public static final String f32637f = "distributedSdk";

    /* renamed from: g  reason: collision with root package name */
    public static final String f32638g = "files";

    /* renamed from: h  reason: collision with root package name */
    public static final String f32639h = "list";

    /* renamed from: i  reason: collision with root package name */
    public static final String f32640i = "cpu";

    /* renamed from: j  reason: collision with root package name */
    public static final String f32641j = "extra_params";
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
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
                cVar.n = jSONObject.optString(f32635d);
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

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: d  reason: collision with root package name */
        public static final String f32642d = "name";

        /* renamed from: e  reason: collision with root package name */
        public static final String f32643e = "url";

        /* renamed from: f  reason: collision with root package name */
        public static final String f32644f = "hash";
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f32645b;

        /* renamed from: c  reason: collision with root package name */
        public String f32646c;

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
            this.a = null;
            this.f32645b = null;
            this.f32646c = null;
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                a aVar = new a();
                if (jSONObject == null) {
                    return aVar;
                }
                aVar.a = jSONObject.optString("name");
                aVar.f32645b = jSONObject.optString("url");
                aVar.f32646c = jSONObject.optString("hash");
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
                    jSONObject.put("name", this.a);
                    jSONObject.put("url", this.f32645b);
                    jSONObject.put("hash", this.f32646c);
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
            cVar.n = jSONObject.optString(f32635d);
            cVar.p = jSONObject.optBoolean(f32636e);
            cVar.q = jSONObject.optBoolean(k);
            cVar.r = jSONObject.optBoolean(l);
            cVar.s = jSONObject.optInt("gray");
            cVar.o = a.a(jSONObject.optJSONObject(f32637f));
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
                jSONObject.put(f32635d, this.n);
                jSONObject.put(f32636e, this.p);
                jSONObject.put(k, this.q);
                jSONObject.put(l, this.r);
                jSONObject.put("gray", this.s);
                jSONObject.put(f32637f, this.o == null ? "" : this.o.a());
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
