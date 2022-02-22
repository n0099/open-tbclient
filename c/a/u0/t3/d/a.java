package c.a.u0.t3.d;

import androidx.annotation.NonNull;
import c.a.t0.s0.l;
import c.a.u0.t3.b.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements c.a.t0.l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.u0.t3.b.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final c f22816b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b f22817c;

    public a(@NonNull c.a.u0.t3.b.b bVar, @NonNull c cVar, @NonNull b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.f22816b = cVar;
        this.f22817c = bVar2;
    }

    @Override // c.a.t0.l.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SpeedStatsManager.getInstance().setAdSource(str);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SDK_DO_SHOW_STAMP_KEY);
            this.f22817c.l();
        }
    }

    @Override // c.a.t0.l.a
    public void b(boolean z, boolean z2, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, str2, str3}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            SpeedStatsManager.getInstance().setStatsFlag(false);
            this.a.f();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK);
            this.a.getActivity().overridePendingTransition(0, 0);
            statisticItem.param("obj_type", z2 ? 2 : 1).param("obj_source", i2);
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            if (str3 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str3);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
            statisticItem2.param("obj_source", i2).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.j());
            if (!StringUtils.isNull(str)) {
                statisticItem2.param("nid", str);
            }
            if (!StringUtils.isNull(str2)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            if (!StringUtils.isNull(str3)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
            }
            TiebaStatic.log(statisticItem2);
            StatisticItem statisticItem3 = new StatisticItem("common_click");
            statisticItem3.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem3.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem3.param("obj_type", z2 ? 2 : 1);
            }
            c.a.u0.y3.c.g().c(this.a.getUniqueId(), statisticItem3);
        }
    }

    @Override // c.a.t0.l.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f22817c.n(true);
            this.a.getRootView().removeView(this.f22817c.j());
            this.f22817c.m();
            this.f22816b.a();
            l.b().k(System.currentTimeMillis() - this.f22817c.i());
        }
    }

    @Override // c.a.t0.l.a
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if ("5".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XUZHANG_WILL_SHOW_STAMP_KEY);
            } else if ("6".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XIAOXIONG_WILL_SHOW_STAMP_KEY);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SDK_WILL_SHOW_STAMP_KEY);
            this.a.d();
        }
    }

    @Override // c.a.t0.l.a
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if ("5".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XUZHANG_LOAD_END_STAMP_KEY);
            } else if ("6".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XIAOXIONG_LOAD_END_STAMP_KEY);
            }
        }
    }

    @Override // c.a.t0.l.a
    public void f(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            this.f22817c.n(true);
            this.a.c(i2);
            if (this.f22817c.k() > 0) {
                c.a.t0.s.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - this.f22817c.k()));
            }
            this.f22817c.m();
            if (z2) {
                this.a.getRootView().setBackgroundDrawable(null);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            c.a.u0.y3.c.g().d(this.a.getUniqueId(), "bes_ad_id", statisticItem);
            c.a.u0.y3.c.g().h(this.a.getUniqueId(), false);
            if (this.a.i()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a.getActivity()));
            }
            l.b().m(System.currentTimeMillis());
            l.b().k(System.currentTimeMillis() - this.f22817c.i());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
        }
    }

    @Override // c.a.t0.l.a
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.f();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.e())));
            if (this.a.e()) {
                this.f22816b.a();
            }
        }
    }
}
