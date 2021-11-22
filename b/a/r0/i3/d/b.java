package b.a.r0.i3.d;

import android.widget.RelativeLayout;
import b.a.e.f.p.l;
import b.a.r0.i3.b.d;
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
/* loaded from: classes4.dex */
public class b implements b.a.q0.z0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.i3.b.c f19458a;

    /* renamed from: b  reason: collision with root package name */
    public final d f19459b;

    /* renamed from: c  reason: collision with root package name */
    public final c f19460c;

    public b(b.a.r0.i3.b.c cVar, d dVar, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar, cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19458a = cVar;
        this.f19459b = dVar;
        this.f19460c = cVar2;
    }

    @Override // b.a.q0.z0.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_locate", 1));
            this.f19460c.d();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921638));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    @Override // b.a.q0.z0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            if (this.f19460c.e() != null) {
                if (this.f19460c.e().getHeight() == l.i(this.f19458a.getActivity())) {
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
                    b.a.r0.l3.c.g().c(this.f19458a.getUniqueId(), statisticItem);
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                    this.f19458a.getActivity().overridePendingTransition(0, 0);
                    this.f19459b.a();
                }
            }
            z2 = false;
            TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
            StatisticItem statisticItem2 = new StatisticItem("common_click");
            statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (!z) {
            }
            b.a.r0.l3.c.g().c(this.f19458a.getUniqueId(), statisticItem2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.f19458a.getActivity().overridePendingTransition(0, 0);
            this.f19459b.a();
        }
    }

    @Override // b.a.q0.z0.b
    public void c(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f19460c.d();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
            if (this.f19460c.e() != null) {
                int k = l.k(this.f19458a.getActivity());
                int i2 = l.i(this.f19458a.getActivity());
                if (!z2) {
                    i2 = (int) (l.i(this.f19458a.getActivity()) * 0.8125d);
                }
                this.f19460c.e().setLayoutParams(new RelativeLayout.LayoutParams(k, i2));
                this.f19458a.getRootView().addView(this.f19460c.e());
                if (this.f19458a.isFromHotSplash()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.f19458a.getActivity()));
                }
                b.a.q0.q0.l.b().m(System.currentTimeMillis());
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
                b.a.r0.l3.c.g().d(this.f19458a.getUniqueId(), str, statisticItem);
                b.a.r0.l3.c.g().h(this.f19458a.getUniqueId(), false);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
                return;
            }
            this.f19459b.a();
        }
    }

    @Override // b.a.q0.z0.b
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.f19458a.f();
            if (this.f19458a.e()) {
                this.f19459b.a();
            }
        }
    }
}
