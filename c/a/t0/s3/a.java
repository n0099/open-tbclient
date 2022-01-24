package c.a.t0.s3;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.s0.q0.d;
import c.a.t0.s3.b.b;
import c.a.t0.s3.b.e;
import c.a.t0.s3.b.f;
import c.a.t0.s3.b.g;
import c.a.t0.w3.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.s3.b.a f22167b;

    /* renamed from: c  reason: collision with root package name */
    public long f22168c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22168c = -3L;
    }

    public void a(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{baseFragmentActivity, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || baseFragmentActivity == null) {
            return;
        }
        this.f22168c = j2;
        b(baseFragmentActivity, viewGroup, i2);
        c();
    }

    public final void b(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, viewGroup, i2) == null) {
            f fVar = new f(baseFragmentActivity, viewGroup, i2, this.f22168c);
            this.a = fVar;
            g gVar = new g(fVar);
            this.f22167b = new c.a.t0.s3.d.b(this.a, gVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            c.g().i(this.a.getUniqueId());
            baseFragmentActivity.registerListener(new e(this.a, gVar));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", TbadkCoreApplication.getInst().isNeedBearAd(c.a.s0.s.i0.b.k().l("splash_ad_strategy_key", 0)) ? 1 : 0).param("pid", c.a.s0.s.i0.b.k().l("splash_origin_ad_strategy_key", 1) != 0 ? 1 : 0).param("obj_param1", this.a.i() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f22168c).eventStat();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_START_STAMP_KEY);
            this.f22167b.b();
        }
    }

    public void d(Configuration configuration) {
        c.a.t0.s3.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (aVar = this.f22167b) == null) {
            return;
        }
        aVar.onConfigurationChanged(configuration);
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.b(false);
    }

    public void f() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.b(true);
        d pageStayDurationItem = this.a.getActivity().getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.r(this.a.getAdSource());
        }
        if (this.a.g()) {
            c.a.t0.s3.c.a.g(this.a).b();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.t0.s3.b.a aVar = this.f22167b;
            if (aVar != null) {
                aVar.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}
