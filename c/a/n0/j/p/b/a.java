package c.a.n0.j.p.b;

import android.util.Log;
import c.a.n0.a.f0.b;
import c.a.n0.a.g2.f.a;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.x.m.o;
import c.a.n0.q.h.e;
import c.a.n0.w.d;
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
/* loaded from: classes2.dex */
public class a extends o {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948321554, "Lc/a/n0/j/p/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948321554, "Lc/a/n0/j/p/b/a;");
                return;
            }
        }
        k = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.x.m.o
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.x.m.o
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.n0.a.x.m.u.a.f() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.n0.a.x.m.u.a.e() : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public c.a.n0.a.k2.a c0(c.a.n0.q.h.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (cVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(14L);
                aVar.b(2908L);
                aVar.d("小游戏Extension包 Extension null");
                return aVar;
            }
            c.a.n0.a.f0.g.a aVar2 = new c.a.n0.a.f0.g.a();
            aVar2.f4405b = cVar.i;
            aVar2.a = cVar.j;
            aVar2.f4406c = cVar.a;
            aVar2.f4407d = cVar.m;
            if (b.b(1, aVar2) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            c.a.n0.a.k2.a aVar3 = new c.a.n0.a.k2.a();
            aVar3.k(14L);
            aVar3.b(2908L);
            aVar3.d("小游戏Extension包更新失败");
            return aVar3;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }

    @Override // c.a.n0.a.x.m.o
    public c.a.n0.a.k2.a d0(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + eVar);
            }
            if (eVar == null) {
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(13L);
                aVar.b(2907L);
                aVar.d("小游戏GameCore包 Framework null");
                return aVar;
            }
            a.b c2 = c.a.n0.a.g2.f.a.c(eVar, 1);
            d.k(eVar.a);
            if (c2.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e2 = c.a.n0.a.g2.f.a.e(1);
                if (e2 > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e2);
                    return null;
                }
                return null;
            }
            c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
            aVar2.k(13L);
            aVar2.b(2907L);
            aVar2.d("小游戏GameCore包更新失败");
            return aVar2;
        }
        return (c.a.n0.a.k2.a) invokeL.objValue;
    }
}
