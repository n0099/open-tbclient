package b.a.r0.h3.e;

import androidx.annotation.NonNull;
import b.a.q0.q0.l;
import b.a.r0.h3.b.c;
import b.a.r0.h3.b.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes4.dex */
public class a implements b.a.q0.l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final c f17755a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final d f17756b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b f17757c;

    public a(@NonNull c cVar, @NonNull d dVar, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17755a = cVar;
        this.f17756b = dVar;
        this.f17757c = bVar;
    }

    @Override // b.a.q0.l.a
    public void a(boolean z, boolean z2, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, str2}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_END_STAMP_KEY);
            this.f17755a.f();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK);
            this.f17755a.getActivity().overridePendingTransition(0, 0);
            statisticItem.param("obj_type", z2 ? 2 : 1).param("obj_source", i2);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
            statisticItem2.param("obj_source", i2).param("obj_type", "a030").param("obj_locate", 0);
            TiebaStatic.log(statisticItem2);
            StatisticItem statisticItem3 = new StatisticItem("common_click");
            statisticItem3.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem3.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem3.param("obj_type", z2 ? 2 : 1);
            }
            b.a.r0.k3.c.g().c(this.f17755a.getUniqueId(), statisticItem3);
        }
    }

    @Override // b.a.q0.l.a
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f17757c.n(true);
            this.f17755a.getRootView().removeView(this.f17757c.j());
            this.f17757c.m();
            this.f17756b.a();
            l.b().k(System.currentTimeMillis() - this.f17757c.i());
        }
    }

    @Override // b.a.q0.l.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17757c.l();
        }
    }

    @Override // b.a.q0.l.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17755a.d();
        }
    }

    @Override // b.a.q0.l.a
    public void e(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            this.f17757c.n(true);
            this.f17755a.c(i2);
            if (this.f17757c.k() > 0) {
                b.a.q0.s.a0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - this.f17757c.k()));
            }
            this.f17757c.m();
            if (z2) {
                this.f17755a.getRootView().setBackgroundDrawable(null);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            b.a.r0.k3.c.g().d(this.f17755a.getUniqueId(), "bes_ad_id", statisticItem);
            b.a.r0.k3.c.g().h(this.f17755a.getUniqueId(), false);
            if (this.f17755a.isFromHotSplash()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.f17755a.getActivity()));
            }
            l.b().m(System.currentTimeMillis());
            l.b().k(System.currentTimeMillis() - this.f17757c.i());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_START_STAMP_KEY);
        }
    }

    @Override // b.a.q0.l.a
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SPLASHACTIVITY_ADSHOW_END_STAMP_KEY);
            this.f17755a.f();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f17755a.getActivity().getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.f17755a.e())));
            if (this.f17755a.e()) {
                this.f17756b.a();
            }
        }
    }

    @Override // b.a.q0.l.a
    public void onLpClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
