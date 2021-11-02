package b.a.p0.a.j1.e;

import android.util.Log;
import b.a.p0.a.g1.f;
import b.a.p0.a.o0.d.g;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
            hashMap.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, String.valueOf(num));
            hashMap.put("percentage", str + "%");
            f.T().u(new b.a.p0.a.o0.d.b("text-size-adjust", hashMap));
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            g gVar = new g();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "text-size-adjust");
                jSONObject.put("percentage", str3 + "%");
                jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, str2);
            } catch (JSONException e2) {
                b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            gVar.f7118c = jSONObject;
            f.T().l(str, gVar);
        }
    }
}
