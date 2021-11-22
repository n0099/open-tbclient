package b.a.r0.h1.h.k;

import b.a.e.f.d.l;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final g f18955i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DataRes f18956a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f18957b;

    /* renamed from: c  reason: collision with root package name */
    public int f18958c;

    /* renamed from: d  reason: collision with root package name */
    public String f18959d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18960e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18961f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18962g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18963h;

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f18964a;

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
            this.f18964a = gVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f18964a.f18957b = dataRes;
                this.f18964a.f18960e = z;
                this.f18964a.f18961f = z2;
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f18964a.f18958c = i2;
                this.f18964a.f18959d = str;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                b.a.q0.c1.e eVar = new b.a.q0.c1.e();
                eVar.f12764b = "";
                eVar.f12763a = 0;
                RecPersonalizePageModel.f().g(1, 0, eVar, 1, 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-460775461, "Lb/a/r0/h1/h/k/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-460775461, "Lb/a/r0/h1/h/k/g;");
                return;
            }
        }
        f18955i = new g();
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
        this.f18958c = 0;
        this.f18962g = LaunchUpPrefetchSwitch.getIsOn();
        this.f18963h = false;
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f18955i : (g) invokeV.objValue;
    }

    public DataRes f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f18962g) {
                j();
            }
            return this.f18956a;
        }
        return (DataRes) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f18963h) {
                this.f18963h = false;
                RecPersonalizePageModel.b e2 = RecPersonalizePageModel.f().e();
                if (e2 != null) {
                    if (this.f18958c == 0 && this.f18957b == null) {
                        return true;
                    }
                    int i2 = this.f18958c;
                    if (i2 == 0) {
                        e2.a(this.f18957b, this.f18960e, this.f18961f);
                        return true;
                    }
                    e2.onLoadError(i2, this.f18959d);
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
            long l = b.a.q0.s.e0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            long l2 = j.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return l2 == 0 || Math.abs(System.currentTimeMillis() - l2) > l;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                b.a.q0.s.l.b.s().z();
            }
            l<byte[]> e2 = b.a.q0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
            if (e2 == null || (bArr = e2.get("0")) == null || bArr.length == 0) {
                return;
            }
            try {
                DataRes dataRes = (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                    TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                } else if (dataRes != null && dataRes.thread_list != null && dataRes.thread_list.size() > 0 && !i()) {
                    this.f18956a = dataRes;
                }
            } catch (IOException e3) {
                BdLog.e(e3);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && this.f18962g) {
            j();
            if (this.f18956a == null) {
                RecPersonalizePageModel.f().n(new a(this));
                b.a.e.f.m.e.a().post(new b(this));
                this.f18963h = true;
                return;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_CACHE_KEY);
        }
    }
}
