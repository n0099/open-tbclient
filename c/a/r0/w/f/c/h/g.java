package c.a.r0.w.f.c.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g implements c.a.r0.w.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25912a;

    /* renamed from: b  reason: collision with root package name */
    public int f25913b;

    /* renamed from: c  reason: collision with root package name */
    public View f25914c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f25915d;

    /* renamed from: e  reason: collision with root package name */
    public View f25916e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25917f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f25918g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f25919h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f25920i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f25921j;
    public int k;
    public c.a.r0.w.f.a.a l;
    public SdkLiveInfoData m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final View.OnClickListener r;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f25922a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25922a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                g gVar = this.f25922a;
                this.f25922a.f25921j.setLayoutParams(new RelativeLayout.LayoutParams(gVar.i(gVar.f25921j.getLoadedHeight(), this.f25922a.f25921j.getLoadedWidth()), g.s));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f25923e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25923e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.r0.w.f.c.c.d(this.f25923e.m)) {
                    if (this.f25923e.l.f25659f) {
                        str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f25923e.f25913b;
                    } else {
                        str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f25923e.f25913b;
                    }
                    c.a.r0.w.f.c.c.j(this.f25923e.f25912a, this.f25923e.m, str2);
                }
                if (this.f25923e.l == null || !this.f25923e.l.f25659f) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
                if (this.f25923e.m != null) {
                    statisticItem.param("tid", this.f25923e.m.tid);
                    statisticItem.param("fid", this.f25923e.l.f25660g);
                    statisticItem.param("fname", this.f25923e.l.f25661h);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", this.f25923e.p);
                if (this.f25923e.m != null && this.f25923e.m.liveInfo != null) {
                    int a2 = c.a.r0.w.f.c.c.a(this.f25923e.m.liveInfo);
                    if (this.f25923e.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, c.a.r0.w.f.c.c.k(this.f25923e.m.liveInfo.yyExt, this.f25923e.m.roomId));
                        str = TiebaStatic.YYValues.YY_LIVE;
                    } else {
                        str = "";
                    }
                    statisticItem.param("obj_param1", a2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78547283, "Lc/a/r0/w/f/c/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78547283, "Lc/a/r0/w/f/c/h/g;");
                return;
            }
        }
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds55);
    }

    public g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 3;
        this.n = 0;
        this.o = 2;
        this.p = 6;
        this.q = 9;
        this.r = new b(this);
        this.f25912a = tbPageContext;
        this.f25913b = i2;
        j(tbPageContext);
    }

    @Override // c.a.r0.w.f.c.b
    public void a(c.a.r0.w.f.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f25658e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f25658e;
                int k = l.k(this.f25914c.getContext());
                if (k != this.n) {
                    ViewGroup.LayoutParams layoutParams = this.f25914c.getLayoutParams();
                    int k2 = l.k(this.f25914c.getContext()) - this.f25914c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                    int dimensionPixelSize = this.f25914c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                    int i2 = this.o;
                    int i3 = k2 - (dimensionPixelSize * i2);
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i3 / this.o, -2);
                    } else {
                        layoutParams.width = i3 / i2;
                        layoutParams.height = -2;
                    }
                    this.f25914c.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = this.f25915d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.o, (i3 / 32) * this.q);
                    } else {
                        layoutParams2.width = i3 / this.o;
                        layoutParams2.height = (i3 / 32) * this.q;
                    }
                    this.f25915d.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = this.f25916e.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.o, this.f25914c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                    } else {
                        layoutParams3.width = i3 / this.o;
                        layoutParams3.height = this.f25914c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                    }
                    this.f25916e.setLayoutParams(layoutParams3);
                    this.n = k;
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                        this.f25915d.startLoad(this.m.liveInfo.coverWide, 10, false);
                    }
                    if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                        this.f25917f.setText(this.m.liveAuthor.nameShow);
                    }
                    this.f25918g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                    if (!TextUtils.isEmpty(this.m.title)) {
                        this.f25919h.setText(this.m.title);
                    }
                    if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                        this.f25920i.setText(this.m.liveInfo.showLabel);
                    }
                    if (!StringUtils.isNull(this.m.labelUrl)) {
                        this.f25921j.setVisibility(0);
                        this.f25921j.startLoad(this.m.labelUrl, 10, false);
                        this.f25921j.setEvent(new a(this));
                    } else {
                        this.f25921j.setVisibility(8);
                    }
                    if (aVar.f25659f) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                        SdkLiveInfoData sdkLiveInfoData = this.m;
                        if (sdkLiveInfoData != null) {
                            statisticItem.param("tid", sdkLiveInfoData.tid);
                            statisticItem.param("fid", aVar.f25660g);
                            statisticItem.param("fname", aVar.f25661h);
                        }
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", this.p);
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                            int a2 = c.a.r0.w.f.c.c.a(alaLiveInfo);
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, c.a.r0.w.f.c.c.k(yYExt, sdkLiveInfoData3.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param("obj_param1", a2);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                }
                onChangeSkinType(this.f25912a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            getView().setVisibility(4);
        }
    }

    @Override // c.a.r0.w.f.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25914c : (View) invokeV.objValue;
    }

    public final int i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? (int) (s * (i3 / i2)) : invokeII.intValue;
    }

    public final void j(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.yy_tab_live_item_view, (ViewGroup) null, false);
            this.f25914c = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
            this.f25915d = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f25915d.setConrers(3);
            this.f25915d.setRadiusById(R.string.J_X13);
            this.f25915d.setPlaceHolder(2);
            this.f25916e = this.f25914c.findViewById(R.id.img_mask);
            this.f25917f = (TextView) this.f25914c.findViewById(R.id.text_name);
            this.f25918g = (EMTextView) this.f25914c.findViewById(R.id.text_audience_count);
            EMTextView eMTextView = (EMTextView) this.f25914c.findViewById(R.id.text_title);
            this.f25919h = eMTextView;
            c.a.q0.s.u.c.d(eMTextView).A(R.string.F_X02);
            this.f25920i = (EMTextView) this.f25914c.findViewById(R.id.text_label);
            this.f25914c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TbImageView tbImageView2 = (TbImageView) this.f25914c.findViewById(R.id.special_label);
            this.f25921j = tbImageView2;
            tbImageView2.setDrawCorner(true);
            this.f25921j.setConrers(1);
            this.f25921j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f25914c);
            d2.m(0);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.f25914c.setOnClickListener(this.r);
        }
    }

    @Override // c.a.r0.w.f.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.k == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f25917f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25918g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25919h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25920i, R.color.CAM_X0109);
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f25914c);
        d2.m(0);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.k = i2;
    }
}
