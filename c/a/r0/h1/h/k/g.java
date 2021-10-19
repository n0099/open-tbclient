package c.a.r0.h1.h.k;

import c.a.e.e.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.LaunchUpPrefetchSwitch;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final g f18554i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f18555a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f18556b;

    /* renamed from: c  reason: collision with root package name */
    public int f18557c;

    /* renamed from: d  reason: collision with root package name */
    public String f18558d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18561g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18562h;

    /* loaded from: classes3.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f18563a;

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
            this.f18563a = gVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f18563a.f18556b = dataRes;
                this.f18563a.f18559e = z;
                this.f18563a.f18560f = z2;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f18563a.f18557c = i2;
                this.f18563a.f18558d = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g gVar) {
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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.d1.e eVar = new c.a.q0.d1.e();
                eVar.f12929b = "";
                eVar.f12928a = 0;
                RecPersonalizePageModel.f().g(1, 0, eVar, 1, 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-971309638, "Lc/a/r0/h1/h/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-971309638, "Lc/a/r0/h1/h/k/g;");
                return;
            }
        }
        f18554i = new g();
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
        this.f18557c = 0;
        this.f18561g = LaunchUpPrefetchSwitch.getIsOn();
        this.f18562h = false;
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f18554i : (g) invokeV.objValue;
    }

    public DataRes f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f18561g) {
                j();
            }
            return this.f18555a;
        }
        return (DataRes) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f18562h) {
                this.f18562h = false;
                RecPersonalizePageModel.b e2 = RecPersonalizePageModel.f().e();
                if (e2 != null) {
                    if (this.f18557c == 0 && this.f18556b == null) {
                        return true;
                    }
                    int i2 = this.f18557c;
                    if (i2 == 0) {
                        e2.a(this.f18556b, this.f18559e, this.f18560f);
                        return true;
                    }
                    e2.onLoadError(i2, this.f18558d);
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
            long l = c.a.q0.s.d0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            long l2 = j2.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return l2 == 0 || Math.abs(System.currentTimeMillis() - l2) > l;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                c.a.q0.s.l.b.s().z();
            }
            l<byte[]> e2 = c.a.q0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
            if (e2 == null || (bArr = e2.get("0")) == null || bArr.length == 0) {
                return;
            }
            try {
                DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                } else if (dataRes != null && dataRes.thread_list != null && dataRes.thread_list.size() > 0 && !i()) {
                    this.f18555a = dataRes;
                }
            } catch (IOException e3) {
                BdLog.e(e3);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && this.f18561g) {
            j();
            if (this.f18555a == null) {
                RecPersonalizePageModel.f().n(new a(this));
                c.a.e.e.m.e.a().post(new b(this));
                this.f18562h = true;
                return;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
        }
    }
}
