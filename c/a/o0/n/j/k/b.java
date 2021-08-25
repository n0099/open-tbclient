package c.a.o0.n.j.k;

import android.text.TextUtils;
import c.a.o0.n.f.g;
import c.a.o0.n.h.h;
import c.a.o0.n.o.f;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f12026b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638829813, "Lc/a/o0/n/j/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1638829813, "Lc/a/o0/n/j/k/b;");
                return;
            }
        }
        f12025a = c.a.o0.n.c.f11828a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f12026b == null) {
                synchronized (b.class) {
                    if (f12026b == null) {
                        f12026b = new b();
                    }
                }
            }
            return f12026b;
        }
        return (b) invokeV.objValue;
    }

    public static void b(c.a.o0.n.h.e eVar, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, eVar, fVar) == null) || eVar == null) {
            return;
        }
        fVar.a(eVar, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, g gVar, g gVar2, g gVar3) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, gVar, gVar2, gVar3) == null) {
            if (f12025a) {
                String str = "updateConfig: soCallback=" + gVar3;
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            a aVar = new a();
            a aVar2 = new a();
            a aVar3 = new a();
            f fVar = new f();
            f fVar2 = new f();
            f fVar3 = new f();
            c v = gVar3 != null ? gVar3.v("so") : null;
            if (f12025a) {
                String str2 = "updateConfig: soNodeHandler=" + v;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("type");
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
                            switch (string.hashCode()) {
                                case -612557761:
                                    if (string.equals(ETAG.KEY_EXTENSION)) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3676:
                                    if (string.equals("so")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 99308:
                                    if (string.equals("ddl")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 54573042:
                                    if (string.equals("extension_game")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 714512640:
                                    if (string.equals("bbasp_core")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 714618195:
                                    if (string.equals("bbasp_game")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            if (c2 == 0) {
                                c.a.o0.n.h.d dVar = (c.a.o0.n.h.d) c.a.o0.n.o.e.i(jSONObject2, new c.a.o0.n.h.d());
                                if (dVar != null) {
                                    b(dVar, fVar);
                                    aVar.f12021b = dVar;
                                }
                            } else if (c2 == 1) {
                                c.a.o0.n.h.d dVar2 = (c.a.o0.n.h.d) c.a.o0.n.o.e.i(jSONObject2, new c.a.o0.n.h.d());
                                if (dVar2 != null) {
                                    b(dVar2, fVar2);
                                    aVar2.f12020a = dVar2;
                                }
                            } else if (c2 == 2) {
                                c.a.o0.n.h.b bVar = (c.a.o0.n.h.b) c.a.o0.n.o.e.i(jSONObject2, new c.a.o0.n.h.b());
                                if (bVar != null) {
                                    b(bVar, fVar);
                                    aVar.f12022c = bVar;
                                }
                            } else if (c2 == 3) {
                                c.a.o0.n.h.b bVar2 = (c.a.o0.n.h.b) c.a.o0.n.o.e.i(jSONObject2, new c.a.o0.n.h.b());
                                if (bVar2 != null) {
                                    b(bVar2, fVar2);
                                    aVar2.f12022c = bVar2;
                                }
                            } else if (c2 == 4) {
                                if (f12025a) {
                                    String str3 = "updateConfig: case so= " + jSONObject2 + " soNodeHandler=" + v;
                                }
                                if (v != null) {
                                    v.l(jSONObject2);
                                }
                            } else if (c2 == 5) {
                                if (aVar3.f12024e == null) {
                                    aVar3.f12024e = new ArrayList();
                                }
                                h hVar = (h) c.a.o0.n.o.e.i(jSONObject2, new h());
                                b(hVar, fVar3);
                                aVar3.f12024e.add(hVar);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    if (f12025a) {
                        String str4 = "updateConfig: end parse by catch=" + e2;
                    }
                }
            }
            if (f12025a) {
                String str5 = "updateConfig: end parse soNodeHandler=" + v;
            }
            if (gVar != null) {
                if (fVar.l() == 0) {
                    gVar.E();
                } else {
                    gVar.F(fVar);
                    c.a.o0.n.i.i.a.e(aVar, gVar);
                }
            }
            boolean z = f12025a;
            if (gVar2 != null) {
                if (fVar2.l() == 0) {
                    gVar2.E();
                } else {
                    gVar2.F(fVar2);
                    c.a.o0.n.i.i.a.e(aVar2, gVar2);
                }
            }
            boolean z2 = f12025a;
            if (v != null) {
                v.handle();
            }
            boolean z3 = f12025a;
            if (fVar3.l() > 0 && c.a.o0.n.c.b() != null) {
                c.a.o0.n.c.b().s(aVar3, fVar3);
            }
            boolean z4 = f12025a;
        }
    }
}
