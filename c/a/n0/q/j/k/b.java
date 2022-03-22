package c.a.n0.q.j.k;

import android.text.TextUtils;
import c.a.n0.q.e.i;
import c.a.n0.q.h.f;
import c.a.n0.q.o.g;
import com.baidu.swan.pms.model.PMSPkgStatus;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b a;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            return a;
        }
        return (b) invokeV.objValue;
    }

    public static void b(f fVar, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, fVar, gVar) == null) || fVar == null) {
            return;
        }
        gVar.a(fVar, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, i iVar, i iVar2, i iVar3) {
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, iVar, iVar2, iVar3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        g gVar = new g();
        g gVar2 = new g();
        g gVar3 = new g();
        c x = iVar3 != null ? iVar3.x("so") : null;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
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
                            c.a.n0.q.h.e eVar = (c.a.n0.q.h.e) c.a.n0.q.o.f.j(jSONObject2, new c.a.n0.q.h.e());
                            if (eVar != null) {
                                b(eVar, gVar);
                                aVar.f9270b = eVar;
                            }
                        } else if (c2 == 1) {
                            c.a.n0.q.h.e eVar2 = (c.a.n0.q.h.e) c.a.n0.q.o.f.j(jSONObject2, new c.a.n0.q.h.e());
                            if (eVar2 != null) {
                                b(eVar2, gVar2);
                                aVar2.a = eVar2;
                            }
                        } else if (c2 == 2) {
                            c.a.n0.q.h.c cVar = (c.a.n0.q.h.c) c.a.n0.q.o.f.j(jSONObject2, new c.a.n0.q.h.c());
                            if (cVar != null) {
                                b(cVar, gVar);
                                aVar.f9271c = cVar;
                            }
                        } else if (c2 == 3) {
                            c.a.n0.q.h.c cVar2 = (c.a.n0.q.h.c) c.a.n0.q.o.f.j(jSONObject2, new c.a.n0.q.h.c());
                            if (cVar2 != null) {
                                b(cVar2, gVar2);
                                aVar2.f9271c = cVar2;
                            }
                        } else if (c2 != 4) {
                            if (c2 == 5) {
                                if (aVar3.f9273e == null) {
                                    aVar3.f9273e = new ArrayList();
                                }
                                c.a.n0.q.h.i iVar4 = (c.a.n0.q.h.i) c.a.n0.q.o.f.j(jSONObject2, new c.a.n0.q.h.i());
                                b(iVar4, gVar3);
                                aVar3.f9273e.add(iVar4);
                            }
                        } else if (x != null) {
                            x.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (iVar != null) {
            if (gVar.n() == 0) {
                iVar.G();
            } else {
                iVar.H(gVar);
                c.a.n0.q.i.i.a.e(aVar, iVar);
            }
        }
        if (iVar2 != null) {
            if (gVar2.n() == 0) {
                iVar2.G();
            } else {
                iVar2.H(gVar2);
                c.a.n0.q.i.i.a.e(aVar2, iVar2);
            }
        }
        if (x != null) {
            x.p();
        }
        if (gVar3.n() <= 0 || c.a.n0.q.c.b() == null) {
            return;
        }
        c.a.n0.q.c.b().t(aVar3, gVar3);
    }
}
