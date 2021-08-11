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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31478a;

    /* renamed from: b  reason: collision with root package name */
    public long f31479b;

    /* renamed from: c  reason: collision with root package name */
    public String f31480c;

    /* renamed from: d  reason: collision with root package name */
    public String f31481d;

    /* renamed from: e  reason: collision with root package name */
    public String f31482e;

    /* renamed from: f  reason: collision with root package name */
    public long f31483f;

    /* renamed from: g  reason: collision with root package name */
    public String f31484g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f31485h;

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
            fVar.f31478a = str;
            fVar.f31479b = j2;
            fVar.f31481d = str2;
            fVar.f31483f = j3;
            fVar.f31482e = str3;
            fVar.f31484g = str4;
            if (collection != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                fVar.f31480c = jSONArray.toString();
            }
            if (map != null && !map.isEmpty()) {
                fVar.f31485h = map;
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
                jSONObject.put(com.baidu.fsg.base.statistics.f.f39281a, this.f31478a);
                jSONObject.put("et", this.f31479b);
                jSONObject.put(com.baidu.fsg.base.statistics.f.f39286f, this.f31483f);
                if (!TextUtils.isEmpty(this.f31481d)) {
                    jSONObject.put(com.baidu.fsg.base.statistics.f.f39284d, this.f31481d);
                }
                jSONObject.putOpt(com.baidu.fsg.base.statistics.f.f39285e, this.f31482e);
                if (this.f31480c != null) {
                    jSONObject.put("ev", this.f31480c);
                }
                if (!TextUtils.isEmpty(this.f31484g)) {
                    jSONObject.put("at", this.f31484g);
                }
                if (this.f31485h != null && !this.f31485h.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f31485h.entrySet()) {
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
