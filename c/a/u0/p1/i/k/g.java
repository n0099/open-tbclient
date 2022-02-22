package c.a.u0.p1.i.k;

import c.a.d.f.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final g f20773h;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f20774b;

    /* renamed from: c  reason: collision with root package name */
    public int f20775c;

    /* renamed from: d  reason: collision with root package name */
    public String f20776d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20777e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20778f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20779g;

    /* loaded from: classes8.dex */
    public class a implements RecPersonalizePageModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.f20774b = dataRes;
                this.a.f20777e = z;
                this.a.f20778f = z2;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.f20775c = i2;
                this.a.f20776d = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2130166146, "Lc/a/u0/p1/i/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2130166146, "Lc/a/u0/p1/i/k/g;");
                return;
            }
        }
        f20773h = new g();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20775c = 0;
        this.f20779g = false;
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f20773h : (g) invokeV.objValue;
    }

    public DataRes f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (DataRes) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f20779g) {
                this.f20779g = false;
                RecPersonalizePageModel.c f2 = RecPersonalizePageModel.g().f();
                if (f2 != null) {
                    if (this.f20775c == 0 && this.f20774b == null) {
                        return true;
                    }
                    int i2 = this.f20775c;
                    if (i2 == 0) {
                        f2.a(this.f20774b, this.f20777e, this.f20778f);
                        return true;
                    }
                    f2.onLoadError(i2, this.f20776d);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long m = c.a.t0.s.j0.b.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
            c.a.t0.s.j0.b k = c.a.t0.s.j0.b.k();
            long m2 = k.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return m2 == 0 || Math.abs(System.currentTimeMillis() - m2) > m;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        l<byte[]> e2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                c.a.t0.s.m.b.t().A();
            }
            if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
            } else if (i()) {
            } else {
                if ((c.a.t0.s.h0.a.q().u() && c.a.t0.s.h0.a.q().o() >= c.a.t0.s.h0.a.q().p()) || (e2 = c.a.t0.s.s.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e2.get("0")) == null || bArr.length == 0) {
                    return;
                }
                try {
                    DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    if (dataRes == null || dataRes.thread_list == null || dataRes.thread_list.size() <= 0) {
                        return;
                    }
                    this.a = dataRes;
                } catch (IOException e3) {
                    BdLog.e(e3);
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            j();
            if (this.a == null) {
                RecPersonalizePageModel.g().q(new a(this));
                c.a.t0.d1.g gVar = new c.a.t0.d1.g();
                gVar.f12760b = "";
                gVar.a = 0;
                RecPersonalizePageModel.g().n(1, 0, gVar, 1, 0);
                this.f20779g = true;
                return;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
        }
    }
}
