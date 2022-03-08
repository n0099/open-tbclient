package c.a.r0.o1.i.k;

import c.a.d.f.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final g k;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile DataRes a;

    /* renamed from: b  reason: collision with root package name */
    public volatile DataRes f20115b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f20116c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f20117d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f20118e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f20119f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f20120g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f20121h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f20122i;

    /* renamed from: j  reason: collision with root package name */
    public volatile RecPersonalizePageModel.c f20123j;

    /* loaded from: classes2.dex */
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
                synchronized (this.a) {
                    this.a.f20115b = dataRes;
                    this.a.f20118e = z;
                    this.a.f20119f = z2;
                    if (this.a.f20120g && this.a.f20123j != null) {
                        this.a.f20123j.a(this.a.f20115b, this.a.f20118e, this.a.f20119f);
                    }
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
                }
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                synchronized (this.a) {
                    this.a.f20116c = i2;
                    this.a.f20117d = str;
                    if (this.a.f20120g && this.a.f20123j != null) {
                        this.a.f20123j.onLoadError(i2, str);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-709959840, "Lc/a/r0/o1/i/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-709959840, "Lc/a/r0/o1/i/k/g;");
                return;
            }
        }
        k = new g();
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
        this.f20116c = 0;
        this.f20120g = false;
        this.f20121h = false;
        this.f20122i = false;
    }

    public static synchronized g n() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (g.class) {
                gVar = k;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public synchronized DataRes k() {
        InterceptResult invokeV;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f20121h) {
                    p();
                }
                this.f20121h = true;
                if (this.a != null) {
                    this.f20120g = true;
                }
                dataRes = this.a;
            }
            return dataRes;
        }
        return (DataRes) invokeV.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                this.f20120g = true;
                if (this.f20122i) {
                    this.f20122i = false;
                    RecPersonalizePageModel.c f2 = RecPersonalizePageModel.g().f();
                    if (f2 != null && (this.f20116c != 0 || this.f20115b != null)) {
                        if (this.f20116c == 0) {
                            f2.a(this.f20115b, this.f20118e, this.f20119f);
                        } else {
                            f2.onLoadError(this.f20116c, this.f20117d);
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public RecPersonalizePageModel.c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20123j : (RecPersonalizePageModel.c) invokeV.objValue;
    }

    public synchronized boolean o() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                long m = c.a.q0.r.j0.b.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
                c.a.q0.r.j0.b k2 = c.a.q0.r.j0.b.k();
                long m2 = k2.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (m2 != 0) {
                    z = Math.abs(System.currentTimeMillis() - m2) > m;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        l<byte[]> e2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                c.a.q0.r.m.b.t().A();
            }
            if (!o() || MainTabDataSwitch.isCacheOpen()) {
                if ((c.a.q0.r.h0.a.q().u() && c.a.q0.r.h0.a.q().o() >= c.a.q0.r.h0.a.q().p()) || (e2 = c.a.q0.r.s.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e2.get("0")) == null || bArr.length == 0) {
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

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                RecPersonalizePageModel.g().q(new a(this));
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    p();
                    if (this.a == null) {
                        if (MainTabDataSwitch.isPrefetchOpen()) {
                            c.a.q0.c1.g gVar = new c.a.q0.c1.g();
                            gVar.f12177b = "";
                            gVar.a = 0;
                            RecPersonalizePageModel.g().n(1, 0, gVar, 1, 0);
                            this.f20122i = true;
                        }
                    } else {
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
                    }
                }
            }
        }
    }

    public synchronized void r(RecPersonalizePageModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            synchronized (this) {
                this.f20123j = cVar;
            }
        }
    }
}
