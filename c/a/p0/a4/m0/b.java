package c.a.p0.a4.m0;

import c.a.d.f.p.l;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public String f12290b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12291c;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12290b = null;
        this.f12291c = false;
        e(str, false);
    }

    public void a() {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || (c2 = c()) == null || c2.f12299f == null) {
            return;
        }
        long e2 = this.a.e();
        if (e2 > 3000) {
            d dVar = c2.f12299f;
            dVar.a += e2;
            dVar.f12292b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f12297d;
            if (dVar == null) {
                return;
            }
            dVar.f12292b++;
            if (z2) {
                dVar.a += j2;
                dVar.f12294d += j;
            } else {
                dVar.f12293c++;
            }
        } else {
            d dVar2 = c2.f12298e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f12292b++;
            if (z2) {
                dVar2.a += j3;
                dVar2.f12294d += j;
            } else {
                dVar2.f12293c++;
            }
            j2 = j3;
        }
        this.a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f12290b == "frsStat") {
            if (!z2 || j2 > 3000) {
                c.a.d.f.n.a aVar = new c.a.d.f.n.a("dbg");
                aVar.b("act", "frs");
                aVar.b("result", z2 ? "0" : "1");
                aVar.b("isHttp", z ? "1" : "0");
                aVar.b("timeCost", String.valueOf(j2));
                aVar.b(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(i));
                aVar.b(StatConstants.KEY_EXT_ERR_MSG, str);
                aVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", aVar);
            }
        }
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.e(this.f12290b, d(), this.f12291c) : (e) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int I = l.I();
            return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? "3G" : I == 2 ? "2G" : "N";
        }
        return (String) invokeV.objValue;
    }

    public void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            this.f12290b = str;
            this.f12291c = z;
            this.a = new c.a.d.f.n.a("dbg");
            c.c(str, d(), z);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g();
        }
    }
}
