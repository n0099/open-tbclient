package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39499a = "en";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39500b = "et";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39501c = "ev";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39502d = "eg";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39503e = "lk";

    /* renamed from: f  reason: collision with root package name */
    public static final String f39504f = "nu";

    /* renamed from: g  reason: collision with root package name */
    public static final String f39505g = "extra1";

    /* renamed from: h  reason: collision with root package name */
    public static final String f39506h = "extra2";

    /* renamed from: i  reason: collision with root package name */
    public static final String f39507i = "extra3";

    /* renamed from: j  reason: collision with root package name */
    public static final String f39508j = "extra4";
    public static final String k = "extra5";
    public static final String l = "extra6";
    public static final String m = "extra7";
    public static final String n = "extra8";
    public static final String o = "extra9";
    public transient /* synthetic */ FieldHolder $fh;
    public String p;
    public long q;
    public String r;
    public String s;
    public String t;
    public long u;

    public f() {
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

    public static f a(String str, long j2, String str2, String str3, Collection<String> collection) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j2), str2, str3, collection})) == null) {
            f fVar = new f();
            fVar.p = str;
            fVar.q = j2;
            fVar.s = str2;
            fVar.t = str3;
            if (collection != null) {
                new JSONArray();
                JSONArray jSONArray = new JSONArray();
                for (String str4 : collection) {
                    jSONArray.put(str4);
                }
                fVar.r = jSONArray.toString();
            }
            return fVar;
        }
        return (f) invokeCommon.objValue;
    }

    public JSONObject a() throws NullPointerException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f39499a, this.p);
                jSONObject.put("et", this.q);
                jSONObject.put(f39504f, this.u);
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.putOpt(f39502d, this.s);
                }
                jSONObject.putOpt(f39503e, this.t);
                if (this.r != null) {
                    jSONObject.put("ev", this.r);
                }
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return jSONObject;
            }
            throw null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
