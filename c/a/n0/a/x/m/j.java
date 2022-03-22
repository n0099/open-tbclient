package c.a.n0.a.x.m;

import android.util.Log;
import c.a.n0.a.g2.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends o {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708385, "Lc/a/n0/a/x/m/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708385, "Lc/a/n0/a/x/m/j;");
                return;
            }
        }
        l = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(c.a.n0.a.p2.g1.c<Exception> cVar) {
        this(cVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.a.n0.a.p2.g1.c) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> C = super.C();
            if (this.k && c.a.n0.q.j.i.n.a) {
                if (C == null) {
                    C = new HashMap<>();
                }
                C.put("hb_type", "1");
                C.put("lastsynctime", String.valueOf(c.a.n0.q.j.i.n.f9256c));
                C.put("SWAN-TIMEOUT-SETTING", String.valueOf(c.a.n0.q.j.i.n.b(60) * 1000));
            }
            return C;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.x.m.o
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.n0.a.x.m.u.a.d() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.n0.a.x.m.u.a.h() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public c.a.n0.a.k2.a c0(c.a.n0.q.h.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(14L);
                aVar.b(2908L);
                aVar.d("小程序Extension包 Extension null");
                return aVar;
            }
            c.a.n0.a.f0.g.a aVar2 = new c.a.n0.a.f0.g.a();
            aVar2.f4405b = cVar.i;
            aVar2.a = cVar.j;
            aVar2.f4406c = cVar.a;
            aVar2.f4407d = cVar.m;
            if (c.a.n0.a.f0.b.b(0, aVar2) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = c.a.n0.a.s0.a.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    c.a.n0.a.f0.d.b f2 = c.a.n0.a.f0.b.f(0);
                    if (f2 == null) {
                        return null;
                    }
                    long g2 = f2.f().g();
                    if (g2 > 0) {
                        if (l) {
                            Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                        }
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g2);
                    }
                }
                return null;
            }
            c.a.n0.a.k2.a aVar3 = new c.a.n0.a.k2.a();
            aVar3.k(14L);
            aVar3.b(2908L);
            aVar3.d("小程序Extension包更新失败");
            return aVar3;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public c.a.n0.a.k2.a d0(c.a.n0.q.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + eVar);
            }
            if (eVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(13L);
                aVar.b(2907L);
                aVar.d("小程序Core包 Framework null");
                return aVar;
            }
            a.b c2 = c.a.n0.a.g2.f.a.c(eVar, 0);
            c.a.n0.a.u.d.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c2);
            c.a.n0.w.d.k(eVar.a);
            if (c2.c()) {
                long e2 = c.a.n0.a.g2.f.a.e(0);
                if (e2 > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e2);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e2);
                    return null;
                }
                return null;
            }
            c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
            aVar2.k(13L);
            aVar2.b(2907L);
            aVar2.d("小程序Core包更新失败");
            return aVar2;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(c.a.n0.a.p2.g1.c<Exception> cVar, boolean z) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.p2.g1.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
