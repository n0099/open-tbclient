package c.a.n0.a.a1.f;

import android.util.Log;
import c.a.n0.a.e0.d.h;
import c.a.n0.a.k.e.p.l;
import c.a.n0.a.w0.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Integer num, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, num, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("level", String.valueOf(num));
            hashMap.put("percentage", str + "%");
            f.U().u(new c.a.n0.a.e0.d.c("text-size-adjust", hashMap));
            l.d(num.intValue());
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            h hVar = new h();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "text-size-adjust");
                jSONObject.put("percentage", str3 + "%");
                jSONObject.put("level", str2);
            } catch (JSONException e2) {
                c.a.n0.a.m1.e.a.b(Log.getStackTraceString(e2));
            }
            hVar.f4243c = jSONObject;
            f.U().m(str, hVar);
        }
    }
}
