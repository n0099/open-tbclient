package b.c.a.a.a;

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
    public String f30970a;

    /* renamed from: b  reason: collision with root package name */
    public long f30971b;

    /* renamed from: c  reason: collision with root package name */
    public String f30972c;

    /* renamed from: d  reason: collision with root package name */
    public String f30973d;

    /* renamed from: e  reason: collision with root package name */
    public String f30974e;

    /* renamed from: f  reason: collision with root package name */
    public long f30975f;

    /* renamed from: g  reason: collision with root package name */
    public String f30976g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f30977h;

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
            fVar.f30970a = str;
            fVar.f30971b = j;
            fVar.f30973d = str2;
            fVar.f30975f = j2;
            fVar.f30974e = str3;
            fVar.f30976g = str4;
            if (collection != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str5 : collection) {
                    jSONArray.put(str5);
                }
                fVar.f30972c = jSONArray.toString();
            }
            if (map != null && !map.isEmpty()) {
                fVar.f30977h = map;
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
                jSONObject.put(com.baidu.fsg.base.statistics.h.f38333a, this.f30970a);
                jSONObject.put("et", this.f30971b);
                jSONObject.put(com.baidu.fsg.base.statistics.h.f38338f, this.f30975f);
                if (!TextUtils.isEmpty(this.f30973d)) {
                    jSONObject.put(com.baidu.fsg.base.statistics.h.f38336d, this.f30973d);
                }
                jSONObject.putOpt(com.baidu.fsg.base.statistics.h.f38337e, this.f30974e);
                if (this.f30972c != null) {
                    jSONObject.put("ev", this.f30972c);
                }
                if (!TextUtils.isEmpty(this.f30976g)) {
                    jSONObject.put("at", this.f30976g);
                }
                if (this.f30977h != null && !this.f30977h.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f30977h.entrySet()) {
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
