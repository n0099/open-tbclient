package c.a.p0.h.p.b;

import c.a.p0.a.h0.m.l;
import c.a.p0.a.k;
import c.a.p0.a.m2.f.a;
import c.a.p0.a.v2.e1.b;
import c.a.p0.n.h.d;
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
/* loaded from: classes3.dex */
public class a extends l {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-836234538, "Lc/a/p0/h/p/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-836234538, "Lc/a/p0/h/p/b/a;");
                return;
            }
        }
        o = k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b<Exception> bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.h0.m.l
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.a.h0.m.l
    public PMSDownloadType U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.m.l
    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.h0.m.r.a.f() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.m.l
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.p0.a.h0.m.r.a.e() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.m.l
    public c.a.p0.a.q2.a a0(c.a.p0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(14L);
                aVar.b(2908L);
                aVar.c("小游戏Extension包 Extension null");
                return aVar;
            }
            c.a.p0.a.p0.g.a aVar2 = new c.a.p0.a.p0.g.a();
            aVar2.f7981b = bVar.f11887i;
            aVar2.f7980a = bVar.f11888j;
            aVar2.f7982c = bVar.f11879a;
            aVar2.f7983d = bVar.m;
            if (c.a.p0.a.p0.b.b(1, aVar2) == null) {
                boolean z = o;
                return null;
            }
            c.a.p0.a.q2.a aVar3 = new c.a.p0.a.q2.a();
            aVar3.j(14L);
            aVar3.b(2908L);
            aVar3.c("小游戏Extension包更新失败");
            return aVar3;
        }
        return (c.a.p0.a.q2.a) invokeL.objValue;
    }

    @Override // c.a.p0.a.h0.m.l
    public c.a.p0.a.q2.a b0(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            if (o) {
                String str = "onFrameworkDownloadFinish framework = " + dVar;
            }
            if (dVar == null) {
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(13L);
                aVar.b(2907L);
                aVar.c("小游戏GameCore包 Framework null");
                return aVar;
            }
            a.b c2 = c.a.p0.a.m2.f.a.c(dVar, 1);
            c.a.p0.t.d.j(dVar.f11879a);
            if (c2.c()) {
                boolean z = o;
                long e2 = c.a.p0.a.m2.f.a.e(1);
                if (e2 > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e2);
                    return null;
                }
                return null;
            }
            c.a.p0.a.q2.a aVar2 = new c.a.p0.a.q2.a();
            aVar2.j(13L);
            aVar2.b(2907L);
            aVar2.c("小游戏GameCore包更新失败");
            return aVar2;
        }
        return (c.a.p0.a.q2.a) invokeL.objValue;
    }
}
