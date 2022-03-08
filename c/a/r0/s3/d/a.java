package c.a.r0.s3.d;

import androidx.annotation.NonNull;
import c.a.q0.r0.k;
import c.a.r0.s3.b.c;
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
/* loaded from: classes2.dex */
public class a implements c.a.q0.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.r0.s3.b.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final c f22111b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b f22112c;

    public a(@NonNull c.a.r0.s3.b.b bVar, @NonNull c cVar, @NonNull b bVar2) {
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
        this.f22111b = cVar;
        this.f22112c = bVar2;
    }

    @Override // c.a.q0.k.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SpeedStatsManager.getInstance().setAdSource(str);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY);
        }
    }

    @Override // c.a.q0.k.a
    public void b(boolean z, boolean z2, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, str2, str3}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            SpeedStatsManager.getInstance().setStatsFlag(false);
            TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "click2"));
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
            c.a.r0.x3.c.g().c(this.a.getUniqueId(), statisticItem3);
        }
    }

    @Override // c.a.q0.k.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f22112c.n(true);
            this.a.getRootView().removeView(this.f22112c.j());
            this.f22112c.m();
            this.f22111b.a();
            k.b().k(System.currentTimeMillis() - this.f22112c.i());
        }
    }

    @Override // c.a.q0.k.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.d();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY);
            this.f22112c.l();
        }
    }

    @Override // c.a.q0.k.a
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if ("5".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_PROLOGUE_END_STAMP_KEY);
            } else if ("6".equals(str)) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY);
            }
        }
    }

    @Override // c.a.q0.k.a
    public void f(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            this.f22112c.n(true);
            this.a.c(i2);
            if (this.f22112c.k() > 0) {
                c.a.q0.r.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - this.f22112c.k()));
            }
            this.f22112c.m();
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
            c.a.r0.x3.c.g().d(this.a.getUniqueId(), "bes_ad_id", statisticItem);
            c.a.r0.x3.c.g().h(this.a.getUniqueId(), false);
            if (this.a.i()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a.getActivity()));
            }
            k.b().m(System.currentTimeMillis());
            k.b().k(System.currentTimeMillis() - this.f22112c.i());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
        }
    }

    @Override // c.a.q0.k.a
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.f();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.e())));
            if (this.a.e()) {
                this.f22111b.a();
                return;
            }
            SpeedStatsManager.getInstance().setStatsFlag(false);
            TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "dismiss"));
        }
    }
}
