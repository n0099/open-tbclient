package b.a.p0.j.p.b;

import b.a.p0.a.h0.m.o;
import b.a.p0.a.k;
import b.a.p0.a.p0.b;
import b.a.p0.a.q2.f.a;
import b.a.p0.a.z2.g1.c;
import b.a.p0.q.i.e;
import b.a.p0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends o {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1141834323, "Lb/a/p0/j/p/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1141834323, "Lb/a/p0/j/p/b/a;");
                return;
            }
        }
        o = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c<Exception> cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.h0.m.o
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.h0.m.u.a.f() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.a.h0.m.u.a.e() : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public b.a.p0.a.u2.a b0(b.a.p0.q.i.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(14L);
                aVar.b(2908L);
                aVar.d("小游戏Extension包 Extension null");
                return aVar;
            }
            b.a.p0.a.p0.g.a aVar2 = new b.a.p0.a.p0.g.a();
            aVar2.f7706b = cVar.f11776i;
            aVar2.f7705a = cVar.j;
            aVar2.f7707c = cVar.f11768a;
            aVar2.f7708d = cVar.m;
            if (b.b(1, aVar2) == null) {
                boolean z = o;
                return null;
            }
            b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
            aVar3.k(14L);
            aVar3.b(2908L);
            aVar3.d("小游戏Extension包更新失败");
            return aVar3;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.m.o
    public b.a.p0.a.u2.a c0(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (o) {
                String str = "onFrameworkDownloadFinish framework = " + eVar;
            }
            if (eVar == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(13L);
                aVar.b(2907L);
                aVar.d("小游戏GameCore包 Framework null");
                return aVar;
            }
            a.b c2 = b.a.p0.a.q2.f.a.c(eVar, 1);
            d.k(eVar.f11768a);
            if (c2.c()) {
                boolean z = o;
                long e2 = b.a.p0.a.q2.f.a.e(1);
                if (e2 > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e2);
                    return null;
                }
                return null;
            }
            b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
            aVar2.k(13L);
            aVar2.b(2907L);
            aVar2.d("小游戏GameCore包更新失败");
            return aVar2;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }
}
