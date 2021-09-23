package c.a.r0.j3.k0;

import c.a.e.e.p.j;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.e.n.a f20933a;

    /* renamed from: b  reason: collision with root package name */
    public String f20934b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20935c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20934b = null;
        this.f20935c = false;
        e(str, false);
    }

    public void a() {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20933a == null || (c2 = c()) == null || c2.f20946f == null) {
            return;
        }
        long e2 = this.f20933a.e();
        if (e2 > 3000) {
            d dVar = c2.f20946f;
            dVar.f20937a += e2;
            dVar.f20938b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i2, String str, long j2, long j3, long j4) {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f20933a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f20944d;
            if (dVar == null) {
                return;
            }
            dVar.f20938b++;
            if (z2) {
                dVar.f20937a += j3;
                dVar.f20940d += j2;
            } else {
                dVar.f20939c++;
            }
        } else {
            d dVar2 = c2.f20945e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f20938b++;
            if (z2) {
                dVar2.f20937a += j4;
                dVar2.f20940d += j2;
            } else {
                dVar2.f20939c++;
            }
            j3 = j4;
        }
        this.f20933a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f20934b == "frsStat") {
            if (!z2 || j3 > 3000) {
                c.a.e.e.n.a aVar = new c.a.e.e.n.a("dbg");
                aVar.b("act", "frs");
                aVar.b("result", z2 ? "0" : "1");
                aVar.b("isHttp", z ? "1" : "0");
                aVar.b("timeCost", String.valueOf(j3));
                aVar.b("errCode", String.valueOf(i2));
                aVar.b("errMsg", str);
                aVar.b("down", String.valueOf(j2));
                BdStatisticsManager.getInstance().debug("frs", aVar);
            }
        }
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.e(this.f20934b, d(), this.f20935c) : (e) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = j.I();
            return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? "3G" : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.f20934b = str;
            this.f20935c = z;
            this.f20933a = new c.a.e.e.n.a("dbg");
            c.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f20933a.g();
        }
    }
}
