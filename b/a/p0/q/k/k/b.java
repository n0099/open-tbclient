package b.a.p0.q.k.k;

import android.text.TextUtils;
import b.a.p0.q.f.i;
import b.a.p0.q.i.f;
import b.a.p0.q.p.g;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f11961a;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11961a == null) {
                synchronized (b.class) {
                    if (f11961a == null) {
                        f11961a = new b();
                    }
                }
            }
            return f11961a;
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
        c w = iVar3 != null ? iVar3.w("so") : null;
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
                            b.a.p0.q.i.e eVar = (b.a.p0.q.i.e) b.a.p0.q.p.f.j(jSONObject2, new b.a.p0.q.i.e());
                            if (eVar != null) {
                                b(eVar, gVar);
                                aVar.f11957b = eVar;
                            }
                        } else if (c2 == 1) {
                            b.a.p0.q.i.e eVar2 = (b.a.p0.q.i.e) b.a.p0.q.p.f.j(jSONObject2, new b.a.p0.q.i.e());
                            if (eVar2 != null) {
                                b(eVar2, gVar2);
                                aVar2.f11956a = eVar2;
                            }
                        } else if (c2 == 2) {
                            b.a.p0.q.i.c cVar = (b.a.p0.q.i.c) b.a.p0.q.p.f.j(jSONObject2, new b.a.p0.q.i.c());
                            if (cVar != null) {
                                b(cVar, gVar);
                                aVar.f11958c = cVar;
                            }
                        } else if (c2 == 3) {
                            b.a.p0.q.i.c cVar2 = (b.a.p0.q.i.c) b.a.p0.q.p.f.j(jSONObject2, new b.a.p0.q.i.c());
                            if (cVar2 != null) {
                                b(cVar2, gVar2);
                                aVar2.f11958c = cVar2;
                            }
                        } else if (c2 != 4) {
                            if (c2 == 5) {
                                if (aVar3.f11960e == null) {
                                    aVar3.f11960e = new ArrayList();
                                }
                                b.a.p0.q.i.i iVar4 = (b.a.p0.q.i.i) b.a.p0.q.p.f.j(jSONObject2, new b.a.p0.q.i.i());
                                b(iVar4, gVar3);
                                aVar3.f11960e.add(iVar4);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (iVar != null) {
            if (gVar.n() == 0) {
                iVar.F();
            } else {
                iVar.G(gVar);
                b.a.p0.q.j.i.a.e(aVar, iVar);
            }
        }
        if (iVar2 != null) {
            if (gVar2.n() == 0) {
                iVar2.F();
            } else {
                iVar2.G(gVar2);
                b.a.p0.q.j.i.a.e(aVar2, iVar2);
            }
        }
        if (w != null) {
            w.handle();
        }
        if (gVar3.n() <= 0 || b.a.p0.q.c.b() == null) {
            return;
        }
        b.a.p0.q.c.b().t(aVar3, gVar3);
    }
}
