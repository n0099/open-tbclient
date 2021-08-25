package c.a.q0.v.d.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends c.a.q0.a0.b<c.a.q0.v.d.c.e.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public TabLiveStageLiveView n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        p();
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_live_stage_item_view : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0201);
            TabLiveStageLiveView tabLiveStageLiveView = this.n;
            if (tabLiveStageLiveView != null) {
                tabLiveStageLiveView.onChangeSkinType();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = j();
            int[] b2 = c.a.q0.v.d.c.c.b(d());
            int i2 = b2[0];
            int i3 = b2[1];
            TabLiveStageLiveView tabLiveStageLiveView = (TabLiveStageLiveView) this.m.findViewById(R.id.stage_live_view);
            this.n = tabLiveStageLiveView;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tabLiveStageLiveView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (FrameLayout.LayoutParams) new ViewGroup.LayoutParams(i2, i3);
            } else {
                layoutParams.width = i2;
                layoutParams.height = i3;
            }
            layoutParams.gravity = 1;
            this.n.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: q */
    public void k(c.a.q0.v.d.c.e.f fVar) {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.f25087e == null) {
            return;
        }
        int k = l.k(this.f15233g);
        if (k != this.o) {
            int[] b2 = c.a.q0.v.d.c.c.b(d());
            int i2 = b2[0];
            int i3 = b2[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.n.setLayoutParams(layoutParams);
            this.o = k;
        }
        this.n.setData(fVar.f25087e.f25088a, 101);
        StatisticItem statisticItem = new StatisticItem("c13551");
        c.a.q0.v.d.c.e.g gVar = fVar.f25087e;
        if (gVar != null && (sdkLiveInfoData = gVar.f25088a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
            int a2 = c.a.q0.v.d.c.c.a(alaLiveInfo);
            SdkLiveInfoData sdkLiveInfoData2 = fVar.f25087e.f25088a;
            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData2.liveInfo.yyExt;
            if (yYExt != null) {
                TiebaStaticHelper.addYYParam(statisticItem, c.a.q0.v.d.c.c.k(yYExt, sdkLiveInfoData2.roomId));
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param("obj_param1", a2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
        statisticItem.param("nid", fVar.f25087e.f25088a.nid);
        statisticItem.param(TiebaStatic.Params.LOGID, fVar.f25087e.f25088a.logid);
        TiebaStatic.log(statisticItem);
    }
}
