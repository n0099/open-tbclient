package c.a.p0.c.a;

import c.a.p0.a.j2.k;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            boolean z = a.f10311a;
            c.a.p0.c.a.i.g m = g.l().m();
            if (m == null) {
                boolean z2 = a.f10311a;
                return;
            }
            try {
                int intValue = m.d() != null ? m.d().intValue() : -1;
                int intValue2 = m.f() != null ? m.f().intValue() : -1;
                int intValue3 = m.e() != null ? m.e().intValue() : -1;
                int intValue4 = m.g() != null ? m.g().intValue() : -1;
                boolean z3 = a.f10311a;
                c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
                fVar.f7064b = str;
                fVar.a("dh_group_id", Integer.valueOf(intValue));
                fVar.a("dh_secret", Integer.valueOf(intValue2));
                fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                boolean z4 = a.f10311a;
                k.d(fVar);
            } catch (Exception e2) {
                if (a.f10311a) {
                    String str2 = "bdtls ubc exception=" + e2.getMessage();
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(c.a.p0.c.a.i.g gVar, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gVar, bdtls$Alert) == null) {
            boolean z = a.f10311a;
            if (gVar != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = gVar.d() != null ? gVar.d().intValue() : -1;
                    int intValue2 = gVar.f() != null ? gVar.f().intValue() : -1;
                    int intValue3 = gVar.e() != null ? gVar.e().intValue() : -1;
                    int intValue4 = gVar.g() != null ? gVar.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    boolean z2 = a.f10311a;
                    c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
                    fVar.f7064b = "alert";
                    fVar.f7067e = str;
                    fVar.a("dh_group_id", Integer.valueOf(intValue));
                    fVar.a("dh_secret", Integer.valueOf(intValue2));
                    fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                    fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                    fVar.a("alert_msg", str2);
                    boolean z3 = a.f10311a;
                    k.d(fVar);
                    return;
                } catch (Exception e2) {
                    if (a.f10311a) {
                        String str3 = "bdtls ubc exception=" + e2.getMessage();
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            boolean z4 = a.f10311a;
        }
    }
}
