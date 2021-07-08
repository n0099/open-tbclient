package com.baidu.apollon.statistics;

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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3974a = "en";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3975b = "et";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3976c = "ev";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3977d = "eg";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3978e = "lk";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3979f = "nu";

    /* renamed from: g  reason: collision with root package name */
    public static final String f3980g = "at";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f3981h;

    /* renamed from: i  reason: collision with root package name */
    public long f3982i;
    public String j;
    public String k;
    public String l;
    public long m;
    public String n;

    public e() {
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

    public JSONObject a() throws NullPointerException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("en", this.f3981h);
                jSONObject.put("et", this.f3982i);
                jSONObject.put("nu", this.m);
                if (!TextUtils.isEmpty(this.k)) {
                    jSONObject.put("eg", this.k);
                }
                jSONObject.putOpt("lk", this.l);
                if (this.j != null) {
                    jSONObject.put("ev", this.j);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.put("at", this.n);
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

    public static e a(String str, long j, String str2, long j2, String str3, Collection<String> collection, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2), str3, collection, str4})) == null) {
            e eVar = new e();
            eVar.f3981h = str;
            eVar.f3982i = j;
            eVar.k = str2;
            eVar.m = j2;
            eVar.l = str3;
            eVar.n = str4;
            if (collection != null) {
                new JSONArray();
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                eVar.j = jSONArray.toString();
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }
}
