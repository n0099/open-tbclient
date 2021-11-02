package b.d.a.a.a;

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
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30112a;

    /* renamed from: b  reason: collision with root package name */
    public long f30113b;

    /* renamed from: c  reason: collision with root package name */
    public String f30114c;

    /* renamed from: d  reason: collision with root package name */
    public String f30115d;

    /* renamed from: e  reason: collision with root package name */
    public String f30116e;

    /* renamed from: f  reason: collision with root package name */
    public long f30117f;

    /* renamed from: g  reason: collision with root package name */
    public String f30118g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f30119h;

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

    public static f a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2), str3, collection, map, str4})) == null) {
            f fVar = new f();
            fVar.f30112a = str;
            fVar.f30113b = j;
            fVar.f30115d = str2;
            fVar.f30117f = j2;
            fVar.f30116e = str3;
            fVar.f30118g = str4;
            if (collection != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                fVar.f30114c = jSONArray.toString();
            }
            if (map != null && !map.isEmpty()) {
                fVar.f30119h = map;
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
                jSONObject.put(com.baidu.fsg.base.statistics.h.f37503a, this.f30112a);
                jSONObject.put("et", this.f30113b);
                jSONObject.put(com.baidu.fsg.base.statistics.h.f37508f, this.f30117f);
                if (!TextUtils.isEmpty(this.f30115d)) {
                    jSONObject.put(com.baidu.fsg.base.statistics.h.f37506d, this.f30115d);
                }
                jSONObject.putOpt(com.baidu.fsg.base.statistics.h.f37507e, this.f30116e);
                if (this.f30114c != null) {
                    jSONObject.put("ev", this.f30114c);
                }
                if (!TextUtils.isEmpty(this.f30118g)) {
                    jSONObject.put("at", this.f30118g);
                }
                if (this.f30119h != null && !this.f30119h.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f30119h.entrySet()) {
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
