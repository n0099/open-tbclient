package c.a.s0.r3.d;

import android.widget.RelativeLayout;
import c.a.d.f.p.m;
import c.a.r0.r0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c.a.r0.a1.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.s0.r3.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.s0.r3.b.c f21971b;

    /* renamed from: c  reason: collision with root package name */
    public final c f21972c;

    public b(c.a.s0.r3.b.b bVar, c.a.s0.r3.b.c cVar, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, cVar2};
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
        this.f21971b = cVar;
        this.f21972c = cVar2;
    }

    @Override // c.a.r0.a1.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_locate", 1));
            this.f21972c.d();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921638));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    @Override // c.a.r0.a1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            if (this.f21972c.e() != null) {
                if (this.f21972c.e().getHeight() == m.i(this.a.getActivity())) {
                    z2 = true;
                    TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                    if (!z) {
                        statisticItem.param("obj_type", z2 ? 4 : 3);
                    } else {
                        statisticItem.param("obj_type", z2 ? 2 : 1);
                    }
                    c.a.s0.u3.c.g().c(this.a.getUniqueId(), statisticItem);
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                    this.a.getActivity().overridePendingTransition(0, 0);
                    this.f21971b.a();
                }
            }
            z2 = false;
            TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
            StatisticItem statisticItem2 = new StatisticItem("common_click");
            statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (!z) {
            }
            c.a.s0.u3.c.g().c(this.a.getUniqueId(), statisticItem2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.getActivity().overridePendingTransition(0, 0);
            this.f21971b.a();
        }
    }

    @Override // c.a.r0.a1.b
    public void c(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f21972c.d();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
            if (this.f21972c.e() != null) {
                int k2 = m.k(this.a.getActivity());
                int i2 = m.i(this.a.getActivity());
                if (!z2) {
                    i2 = (int) (m.i(this.a.getActivity()) * 0.8125d);
                }
                this.f21972c.e().setLayoutParams(new RelativeLayout.LayoutParams(k2, i2));
                this.a.getRootView().addView(this.f21972c.e());
                if (this.a.i()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a.getActivity()));
                }
                l.b().m(System.currentTimeMillis());
                TiebaStatic.log(new StatisticItem("c13331").param("obj_id", str).param("obj_type", z2 ? 2 : 1));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param("obj_locate", 0));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 2).param("obj_type", "a064").param("obj_locate", 0));
                StatisticItem statisticItem = new StatisticItem("common_exp");
                statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem.param("obj_type", z2 ? 2 : 1);
                }
                c.a.s0.u3.c.g().d(this.a.getUniqueId(), str, statisticItem);
                c.a.s0.u3.c.g().h(this.a.getUniqueId(), false);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
                return;
            }
            this.f21971b.a();
        }
    }

    @Override // c.a.r0.a1.b
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.f();
            if (this.a.e()) {
                this.f21971b.a();
            }
        }
    }
}
