package c.a.p0.c0.f.c.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<c.a.p0.c0.f.c.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaBannerRecyclerView i;
    public AlaBannerRecyclerAdapter j;
    public View k;
    public View l;
    public TextView m;
    public int n;
    public int o;
    public int[] p;
    public boolean q;
    public c.a.p0.c0.f.i.a.a r;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.c0.f.i.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.p0.c0.f.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0979a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public View f13011b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f13012c;

            /* renamed from: d  reason: collision with root package name */
            public int f13013d;

            /* renamed from: e  reason: collision with root package name */
            public int f13014e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f13015f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0979a(a aVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13015f = aVar;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    this.f13012c = (TabLiveStageLiveView) view.findViewById(R.id.obfuscated_res_0x7f091d90);
                    this.a = view.findViewById(R.id.obfuscated_res_0x7f0919e7);
                    this.f13011b = view.findViewById(R.id.obfuscated_res_0x7f0919e8);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    this.f13012c.c();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, SdkLiveInfoData sdkLiveInfoData) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i, sdkLiveInfoData) == null) {
                    this.f13012c.setData(sdkLiveInfoData, 102);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13011b.getLayoutParams();
                    if (i == 0) {
                        if (this.f13015f.a.q) {
                            layoutParams.width = this.f13015f.a.f15304b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            layoutParams2.width = this.f13015f.a.f15304b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f13011b.setVisibility(0);
                        } else {
                            layoutParams.width = this.f13015f.a.f15304b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f13011b.setVisibility(8);
                        }
                    } else {
                        layoutParams.width = this.f13015f.a.f15304b.getResources().getDimensionPixelSize(R.dimen.tbds12);
                        if (this.f13015f.a.j.getItemCount() - 1 == i) {
                            this.f13011b.setVisibility(0);
                        } else {
                            this.f13011b.setVisibility(8);
                        }
                    }
                    this.a.setLayoutParams(layoutParams);
                    this.f13011b.setLayoutParams(layoutParams2);
                    e();
                    StatisticItem statisticItem = new StatisticItem("c13558");
                    if (sdkLiveInfoData != null) {
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
                        if (alaLiveInfo != null) {
                            int a = c.a.p0.c0.f.c.c.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, c.a.p0.c0.f.c.c.k(yYExt, sdkLiveInfoData.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        statisticItem.param("nid", sdkLiveInfoData.nid);
                        statisticItem.param(TiebaStatic.Params.LOGID, sdkLiveInfoData.logid);
                    }
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                }
            }

            public final void e() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    this.f13013d = this.f13015f.a.w();
                    this.f13014e = this.f13015f.a.v();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13012c.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f13013d, this.f13014e);
                    } else {
                        layoutParams.width = this.f13013d;
                        layoutParams.height = this.f13014e;
                    }
                    layoutParams.gravity = 1;
                    this.f13012c.setLayoutParams(layoutParams);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c0.f.i.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) ? new C0979a(this, LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07f6, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = new a(this);
        this.q = false;
        int k = (int) (n.k(getContext()) * 0.76d);
        this.n = k;
        this.o = (int) ((k * 9.0d) / 16.0d);
        this.p = c.a.p0.c0.f.c.c.b(this.f15305c);
        x();
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07f5 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q ? this.p[1] : this.o : invokeV.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q ? this.p[0] : this.n : invokeV.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = k().findViewById(R.id.obfuscated_res_0x7f0919e6);
            this.m = (TextView) k().findViewById(R.id.obfuscated_res_0x7f0919e9);
            this.l = k().findViewById(R.id.obfuscated_res_0x7f0919e5);
            this.i = (AlaBannerRecyclerView) k().findViewById(R.id.obfuscated_res_0x7f091a24);
            this.i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            z();
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(getContext(), this.r, false);
            this.j = alaBannerRecyclerAdapter;
            this.i.setAdapter(alaBannerRecyclerAdapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: y */
    public void l(c.a.p0.c0.f.c.e.c cVar) {
        c.a.p0.c0.f.c.e.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || (dVar = cVar.a) == null) {
            return;
        }
        this.q = ListUtils.getCount(dVar.a) == 1;
        z();
        this.j.setData(cVar.a.a);
        this.j.notifyDataSetChanged();
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int v = v();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, v);
            } else {
                layoutParams.width = -1;
                layoutParams.height = v;
            }
            this.i.setLayoutParams(layoutParams);
        }
    }
}
