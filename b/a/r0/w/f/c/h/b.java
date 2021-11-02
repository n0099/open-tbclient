package b.a.r0.w.f.c.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.a.e.e.p.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.w.f.c.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaBannerRecyclerView m;
    public AlaBannerRecyclerAdapter n;
    public View o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public b.a.r0.w.f.i.h.a v;

    /* loaded from: classes5.dex */
    public class a implements b.a.r0.w.f.i.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24729a;

        /* renamed from: b.a.r0.w.f.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1207a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f24730a;

            /* renamed from: b  reason: collision with root package name */
            public View f24731b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f24732c;

            /* renamed from: d  reason: collision with root package name */
            public int f24733d;

            /* renamed from: e  reason: collision with root package name */
            public int f24734e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f24735f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1207a(a aVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24735f = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: a */
            public void bindData(int i2, SdkLiveInfoData sdkLiveInfoData) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, sdkLiveInfoData) == null) {
                    this.f24732c.setData(sdkLiveInfoData, 102);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24730a.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24731b.getLayoutParams();
                    if (i2 == 0) {
                        if (this.f24735f.f24729a.u) {
                            layoutParams.width = this.f24735f.f24729a.f14737f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            layoutParams2.width = this.f24735f.f24729a.f14737f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f24731b.setVisibility(0);
                        } else {
                            layoutParams.width = this.f24735f.f24729a.f14737f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f24731b.setVisibility(8);
                        }
                    } else {
                        layoutParams.width = this.f24735f.f24729a.f14737f.getResources().getDimensionPixelSize(R.dimen.tbds12);
                        if (this.f24735f.f24729a.n.getItemCount() - 1 == i2) {
                            this.f24731b.setVisibility(0);
                        } else {
                            this.f24731b.setVisibility(8);
                        }
                    }
                    this.f24730a.setLayoutParams(layoutParams);
                    this.f24731b.setLayoutParams(layoutParams2);
                    b();
                    StatisticItem statisticItem = new StatisticItem("c13558");
                    if (sdkLiveInfoData != null) {
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
                        if (alaLiveInfo != null) {
                            int a2 = b.a.r0.w.f.c.c.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, b.a.r0.w.f.c.c.k(yYExt, sdkLiveInfoData.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        statisticItem.param("nid", sdkLiveInfoData.nid);
                        statisticItem.param(TiebaStatic.Params.LOGID, sdkLiveInfoData.logid);
                    }
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                }
            }

            public final void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f24733d = this.f24735f.f24729a.u();
                    this.f24734e = this.f24735f.f24729a.t();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24732c.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f24733d, this.f24734e);
                    } else {
                        layoutParams.width = this.f24733d;
                        layoutParams.height = this.f24734e;
                    }
                    layoutParams.gravity = 1;
                    this.f24732c.setLayoutParams(layoutParams);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void initView(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                    this.f24732c = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                    this.f24730a = view.findViewById(R.id.recom_live_item_left_space);
                    this.f24731b = view.findViewById(R.id.recom_live_item_right_space);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void onChangeSkinType(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f24732c.onChangeSkinType();
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24729a = bVar;
        }

        @Override // b.a.r0.w.f.i.h.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new C1207a(this, LayoutInflater.from(this.f24729a.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.u = false;
        this.v = new a(this);
        this.u = false;
        int k = (int) (l.k(getContext()) * 0.76d);
        this.r = k;
        this.s = (int) ((k * 9.0d) / 16.0d);
        this.t = b.a.r0.w.f.c.c.b(this.f14738g);
        v();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_live_official_recom_live_item_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u ? this.t[1] : this.s : invokeV.intValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u ? this.t[0] : this.r : invokeV.intValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o = i().findViewById(R.id.recom_live_divider);
            this.q = (TextView) i().findViewById(R.id.recom_live_title);
            this.p = i().findViewById(R.id.recom_live_bottom_divider);
            this.m = (AlaBannerRecyclerView) i().findViewById(R.id.recycle_view);
            this.m.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            x();
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(getContext(), this.v, false);
            this.n = alaBannerRecyclerAdapter;
            this.m.setAdapter(alaBannerRecyclerAdapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: w */
    public void j(b.a.r0.w.f.c.e.c cVar) {
        b.a.r0.w.f.c.e.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || (dVar = cVar.f24600e) == null) {
            return;
        }
        this.u = ListUtils.getCount(dVar.f24601a) == 1;
        x();
        this.n.setData(cVar.f24600e.f24601a);
        this.n.notifyDataSetChanged();
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int t = t();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, t);
            } else {
                layoutParams.width = -1;
                layoutParams.height = t;
            }
            this.m.setLayoutParams(layoutParams);
        }
    }
}
