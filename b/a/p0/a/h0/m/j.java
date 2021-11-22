package b.a.p0.a.h0.m;

import b.a.p0.a.q2.f.a;
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
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581860, "Lb/a/p0/a/h0/m/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581860, "Lb/a/p0/a/h0/m/j;");
                return;
            }
        }
        p = b.a.p0.a.k.f6863a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(b.a.p0.a.z2.g1.c<Exception> cVar) {
        this(cVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b.a.p0.a.z2.g1.c) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.q.f.i
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.o && b.a.p0.q.k.i.n.f11931a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(b.a.p0.q.k.i.n.f11933c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(b.a.p0.q.k.i.n.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.a.h0.m.u.a.d() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.a.h0.m.u.a.h() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public b.a.p0.a.u2.a b0(b.a.p0.q.i.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(14L);
                aVar.b(2908L);
                aVar.d("小程序Extension包 Extension null");
                return aVar;
            }
            b.a.p0.a.p0.g.a aVar2 = new b.a.p0.a.p0.g.a();
            aVar2.f7706b = cVar.f11776i;
            aVar2.f7705a = cVar.j;
            aVar2.f7707c = cVar.f11768a;
            aVar2.f7708d = cVar.m;
            if (b.a.p0.a.p0.b.b(0, aVar2) == null) {
                boolean z = p;
                boolean m = b.a.p0.a.c1.a.g0().m();
                if (p) {
                    String str = "onExtensionDownloadFinish: extension js 热应用实验开关 " + m;
                }
                if (m) {
                    boolean z2 = p;
                    b.a.p0.a.p0.d.b f2 = b.a.p0.a.p0.b.f(0);
                    if (f2 == null) {
                        return null;
                    }
                    long g2 = f2.f().g();
                    if (g2 > 0) {
                        boolean z3 = p;
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g2);
                    }
                }
                return null;
            }
            b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
            aVar3.k(14L);
            aVar3.b(2908L);
            aVar3.d("小程序Extension包更新失败");
            return aVar3;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public b.a.p0.a.u2.a c0(b.a.p0.q.i.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (p) {
                String str = "onFrameworkDownloadFinish framework = " + eVar;
            }
            if (eVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(13L);
                aVar.b(2907L);
                aVar.d("小程序Core包 Framework null");
                return aVar;
            }
            a.b c2 = b.a.p0.a.q2.f.a.c(eVar, 0);
            b.a.p0.a.e0.d.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c2);
            b.a.p0.w.d.k(eVar.f11768a);
            if (c2.c()) {
                long e2 = b.a.p0.a.q2.f.a.e(0);
                if (e2 > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e2);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e2);
                    return null;
                }
                return null;
            }
            b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
            aVar2.k(13L);
            aVar2.b(2907L);
            aVar2.d("小程序Core包更新失败");
            return aVar2;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b.a.p0.a.z2.g1.c<Exception> cVar, boolean z) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.z2.g1.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = z;
    }
}
