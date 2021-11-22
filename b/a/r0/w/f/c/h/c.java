package b.a.r0.w.f.c.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class c extends b.a.r0.b0.b<b.a.r0.w.f.c.e.f> {
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
        o();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_live_stage_item_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(i(), R.color.CAM_X0201);
            TabLiveStageLiveView tabLiveStageLiveView = this.n;
            if (tabLiveStageLiveView != null) {
                tabLiveStageLiveView.onChangeSkinType();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = i();
            int[] b2 = b.a.r0.w.f.c.c.b(getContext());
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.w.f.c.e.f fVar) {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.f26124e == null) {
            return;
        }
        int k = l.k(this.f16225g);
        if (k != this.o) {
            int[] b2 = b.a.r0.w.f.c.c.b(getContext());
            int i2 = b2[0];
            int i3 = b2[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.n.setLayoutParams(layoutParams);
            this.o = k;
        }
        this.n.setData(fVar.f26124e.f26125a, 101);
        StatisticItem statisticItem = new StatisticItem("c13551");
        b.a.r0.w.f.c.e.g gVar = fVar.f26124e;
        if (gVar != null && (sdkLiveInfoData = gVar.f26125a) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
            int a2 = b.a.r0.w.f.c.c.a(alaLiveInfo);
            SdkLiveInfoData sdkLiveInfoData2 = fVar.f26124e.f26125a;
            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData2.liveInfo.yyExt;
            if (yYExt != null) {
                TiebaStaticHelper.addYYParam(statisticItem, b.a.r0.w.f.c.c.k(yYExt, sdkLiveInfoData2.roomId));
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param("obj_param1", a2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
        statisticItem.param("nid", fVar.f26124e.f26125a.nid);
        statisticItem.param(TiebaStatic.Params.LOGID, fVar.f26124e.f26125a.logid);
        TiebaStatic.log(statisticItem);
    }
}
