package c.a.t0.o1.h.k;

import c.a.d.f.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final h f20573j;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile DataRes a;

    /* renamed from: b  reason: collision with root package name */
    public volatile DataRes f20574b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f20575c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f20576d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f20577e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f20578f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f20579g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f20580h;

    /* renamed from: i  reason: collision with root package name */
    public volatile RecPersonalizePageModel.c f20581i;

    /* loaded from: classes8.dex */
    public class a implements RecPersonalizePageModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                synchronized (this.a) {
                    this.a.f20574b = dataRes;
                    this.a.f20577e = z;
                    this.a.f20578f = z2;
                    if (this.a.f20579g && this.a.f20581i != null) {
                        this.a.f20581i.a(this.a.f20574b, this.a.f20577e, this.a.f20578f);
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
                    this.a.f20575c = i2;
                    this.a.f20576d = str;
                    if (this.a.f20579g && this.a.f20581i != null) {
                        this.a.f20581i.onLoadError(i2, str);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480423522, "Lc/a/t0/o1/h/k/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-480423522, "Lc/a/t0/o1/h/k/h;");
                return;
            }
        }
        f20573j = new h();
    }

    public h() {
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
        this.f20575c = 0;
        this.f20579g = false;
        this.f20580h = false;
    }

    public static synchronized h m() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (h.class) {
                hVar = f20573j;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    public synchronized DataRes k() {
        InterceptResult invokeV;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.f20579g = true;
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
                this.f20579g = true;
                if (this.f20580h) {
                    this.f20580h = false;
                    RecPersonalizePageModel.c f2 = RecPersonalizePageModel.g().f();
                    if (f2 != null && (this.f20575c != 0 || this.f20574b != null)) {
                        if (this.f20575c == 0) {
                            f2.a(this.f20574b, this.f20577e, this.f20578f);
                        } else {
                            f2.onLoadError(this.f20575c, this.f20576d);
                        }
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long m = c.a.s0.s.h0.b.k().m("recommend_frs_cache_time", 1800L) * 1000;
            c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
            long m2 = k.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return m2 == 0 || Math.abs(System.currentTimeMillis() - m2) > m;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        l<byte[]> e2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                c.a.s0.s.l.b.t().A();
            }
            if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
            } else if (n()) {
            } else {
                if ((c.a.s0.s.f0.a.q().u() && c.a.s0.s.f0.a.q().o() >= c.a.s0.s.f0.a.q().p()) || (e2 = c.a.s0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount())) == null || (bArr = e2.get("0")) == null || bArr.length == 0) {
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

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                RecPersonalizePageModel.g().q(new a(this));
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    o();
                    if (this.a == null) {
                        c.a.s0.e1.g gVar = new c.a.s0.e1.g();
                        gVar.f12366b = "";
                        gVar.a = 0;
                        RecPersonalizePageModel.g().n(1, 0, gVar, 1, 0);
                        this.f20580h = true;
                    } else {
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
                    }
                }
            }
        }
    }

    public synchronized void q(RecPersonalizePageModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            synchronized (this) {
                this.f20581i = cVar;
            }
        }
    }
}
