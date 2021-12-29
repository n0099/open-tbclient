package c.d.a.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f28464b;

    /* renamed from: c  reason: collision with root package name */
    public String f28465c;

    /* renamed from: d  reason: collision with root package name */
    public String f28466d;

    /* renamed from: e  reason: collision with root package name */
    public String f28467e;

    /* renamed from: f  reason: collision with root package name */
    public long f28468f;

    /* renamed from: g  reason: collision with root package name */
    public String f28469g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f28470h;

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

    public static f a(String str, long j2, String str2, long j3, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j2), str2, Long.valueOf(j3), str3, collection, map, str4})) == null) {
            f fVar = new f();
            fVar.a = str;
            fVar.f28464b = j2;
            fVar.f28466d = str2;
            fVar.f28468f = j3;
            fVar.f28467e = str3;
            fVar.f28469g = str4;
            if (collection != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                fVar.f28465c = jSONArray.toString();
            }
            if (map != null && !map.isEmpty()) {
                fVar.f28470h = map;
            }
            return fVar;
        }
        return (f) invokeCommon.objValue;
    }

    public JSONObject b() throws NullPointerException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.baidu.fsg.base.statistics.h.a, this.a);
                jSONObject.put("et", this.f28464b);
                jSONObject.put(com.baidu.fsg.base.statistics.h.f34920f, this.f28468f);
                if (!TextUtils.isEmpty(this.f28466d)) {
                    jSONObject.put(com.baidu.fsg.base.statistics.h.f34918d, this.f28466d);
                }
                jSONObject.putOpt(com.baidu.fsg.base.statistics.h.f34919e, this.f28467e);
                if (this.f28465c != null) {
                    jSONObject.put("ev", this.f28465c);
                }
                if (!TextUtils.isEmpty(this.f28469g)) {
                    jSONObject.put("at", this.f28469g);
                }
                if (this.f28470h != null && !this.f28470h.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f28470h.entrySet()) {
                        if (entry.getValue() instanceof Integer) {
                            jSONObject.put(entry.getKey(), ((Integer) entry.getValue()).intValue());
                        } else if (entry.getValue() instanceof Long) {
                            jSONObject.put(entry.getKey(), ((Long) entry.getValue()).longValue());
                        } else if (entry.getValue() instanceof Double) {
                            jSONObject.put(entry.getKey(), ((Double) entry.getValue()).doubleValue());
                        } else if (entry.getValue() instanceof Short) {
                            jSONObject.put(entry.getKey(), (int) ((Short) entry.getValue()).shortValue());
                        } else if (entry.getValue() instanceof Float) {
                            jSONObject.put(entry.getKey(), ((Float) entry.getValue()).floatValue());
                        } else if (entry.getValue() instanceof Byte) {
                            jSONObject.put(entry.getKey(), (int) ((Byte) entry.getValue()).byteValue());
                        } else if (entry.getValue() instanceof String) {
                            jSONObject.put(entry.getKey(), entry.getValue().toString());
                        }
                    }
                }
            } catch (Exception unused) {
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
