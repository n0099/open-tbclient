package c.a.o0.a.r1.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile d f8442d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, e> f8443a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, e> f8444b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, e> f8445c;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8442d == null) {
                synchronized (d.class) {
                    if (f8442d == null) {
                        f8442d = new d();
                    }
                }
            }
            return f8442d;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (d.class) {
                if (f8442d != null) {
                    f8442d.e();
                    f8442d = null;
                }
            }
        }
    }

    public final void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 767526192) {
            if (hashCode != 1331686101) {
                if (hashCode == 1390184462 && str.equals("PageUpdateRender")) {
                    c2 = 2;
                }
            } else if (str.equals("PageInitRender")) {
                c2 = 1;
            }
        } else if (str.equals("PageSwitchCost")) {
            c2 = 0;
        }
        if (c2 == 0) {
            c.a.o0.a.q2.d.f8099d.d(Long.valueOf(j2));
        } else if (c2 == 1) {
            c.a.o0.a.q2.d.f8100e.d(Long.valueOf(j2));
        } else if (c2 != 2) {
        } else {
            c.a.o0.a.q2.d.f8101f.d(Long.valueOf(j2));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f8443a == null) {
                this.f8443a = new HashMap<>();
            }
            if (this.f8444b == null) {
                this.f8444b = new HashMap<>();
            }
            if (this.f8445c == null) {
                this.f8445c = new HashMap<>();
            }
        }
    }

    public void d(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j2 < 0) {
            return;
        }
        c();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1880922749:
                if (str2.equals("pageUpdateEnd")) {
                    c2 = 5;
                    break;
                }
                break;
            case -964566145:
                if (str2.equals("pageSwitchStart")) {
                    c2 = 0;
                    break;
                }
                break;
            case -410083667:
                if (str2.equals("pageInitRenderStart")) {
                    c2 = 1;
                    break;
                }
                break;
            case 4028902:
                if (str2.equals("pageInitRenderEnd")) {
                    c2 = 4;
                    break;
                }
                break;
            case 627578634:
                if (str2.equals("pageUpdateStart")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1719651128:
                if (str2.equals("pageSwitchEnd")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            h(str, str2, j2);
        } else if (c2 == 3 || c2 == 4 || c2 == 5) {
            g(str, str2, j2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashMap<String, e> hashMap = this.f8443a;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, e> hashMap2 = this.f8444b;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            HashMap<String, e> hashMap3 = this.f8445c;
            if (hashMap3 != null) {
                hashMap3.clear();
            }
        }
    }

    public final void g(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e eVar = null;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -1880922749) {
            if (hashCode != 4028902) {
                if (hashCode == 1719651128 && str2.equals("pageSwitchEnd")) {
                    c2 = 0;
                }
            } else if (str2.equals("pageInitRenderEnd")) {
                c2 = 1;
            }
        } else if (str2.equals("pageUpdateEnd")) {
            c2 = 2;
        }
        if (c2 == 0) {
            eVar = this.f8443a.remove(str);
        } else if (c2 == 1) {
            eVar = this.f8444b.remove(str);
        } else if (c2 == 2) {
            eVar = this.f8445c.remove(str);
        }
        if (eVar == null) {
            return;
        }
        eVar.b(j2);
        a(eVar.getType(), eVar.a());
    }

    public final void h(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e eVar = null;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -964566145) {
            if (hashCode != -410083667) {
                if (hashCode == 627578634 && str2.equals("pageUpdateStart")) {
                    c2 = 2;
                }
            } else if (str2.equals("pageInitRenderStart")) {
                c2 = 1;
            }
        } else if (str2.equals("pageSwitchStart")) {
            c2 = 0;
        }
        if (c2 == 0) {
            eVar = this.f8443a.get(str);
            if (eVar == null) {
                eVar = new b();
                this.f8443a.put(str, eVar);
            }
        } else if (c2 == 1) {
            eVar = this.f8444b.get(str);
            if (eVar == null) {
                eVar = new a();
                this.f8444b.put(str, eVar);
            }
        } else if (c2 == 2 && (eVar = this.f8445c.get(str)) == null) {
            eVar = new c();
            this.f8445c.put(str, eVar);
        }
        if (eVar != null) {
            eVar.c(j2);
        }
    }
}
