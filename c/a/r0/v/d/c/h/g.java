package c.a.r0.v.d.c.h;

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
public class g implements c.a.r0.v.d.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25714a;

    /* renamed from: b  reason: collision with root package name */
    public int f25715b;

    /* renamed from: c  reason: collision with root package name */
    public View f25716c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f25717d;

    /* renamed from: e  reason: collision with root package name */
    public View f25718e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25719f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f25720g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f25721h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f25722i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f25723j;
    public int k;
    public c.a.r0.v.d.a.a l;
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
        public final /* synthetic */ g f25724a;

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
            this.f25724a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                g gVar = this.f25724a;
                this.f25724a.f25723j.setLayoutParams(new RelativeLayout.LayoutParams(gVar.i(gVar.f25723j.getLoadedHeight(), this.f25724a.f25723j.getLoadedWidth()), g.s));
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
        public final /* synthetic */ g f25725e;

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
            this.f25725e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.r0.v.d.c.c.d(this.f25725e.m)) {
                    if (this.f25725e.l.f25461f) {
                        str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f25725e.f25715b;
                    } else {
                        str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f25725e.f25715b;
                    }
                    c.a.r0.v.d.c.c.j(this.f25725e.f25714a, this.f25725e.m, str2);
                }
                if (this.f25725e.l == null || !this.f25725e.l.f25461f) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
                if (this.f25725e.m != null) {
                    statisticItem.param("tid", this.f25725e.m.tid);
                    statisticItem.param("fid", this.f25725e.l.f25462g);
                    statisticItem.param("fname", this.f25725e.l.f25463h);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", this.f25725e.p);
                if (this.f25725e.m != null && this.f25725e.m.liveInfo != null) {
                    int a2 = c.a.r0.v.d.c.c.a(this.f25725e.m.liveInfo);
                    if (this.f25725e.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, c.a.r0.v.d.c.c.k(this.f25725e.m.liveInfo.yyExt, this.f25725e.m.roomId));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1084407414, "Lc/a/r0/v/d/c/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1084407414, "Lc/a/r0/v/d/c/h/g;");
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
        this.f25714a = tbPageContext;
        this.f25715b = i2;
        j(tbPageContext);
    }

    @Override // c.a.r0.v.d.c.b
    public void a(c.a.r0.v.d.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f25460e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f25460e;
                int k = l.k(this.f25716c.getContext());
                if (k != this.n) {
                    ViewGroup.LayoutParams layoutParams = this.f25716c.getLayoutParams();
                    int k2 = l.k(this.f25716c.getContext()) - this.f25716c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                    int dimensionPixelSize = this.f25716c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                    int i2 = this.o;
                    int i3 = k2 - (dimensionPixelSize * i2);
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i3 / this.o, -2);
                    } else {
                        layoutParams.width = i3 / i2;
                        layoutParams.height = -2;
                    }
                    this.f25716c.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = this.f25717d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.o, (i3 / 32) * this.q);
                    } else {
                        layoutParams2.width = i3 / this.o;
                        layoutParams2.height = (i3 / 32) * this.q;
                    }
                    this.f25717d.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = this.f25718e.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.o, this.f25716c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                    } else {
                        layoutParams3.width = i3 / this.o;
                        layoutParams3.height = this.f25716c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                    }
                    this.f25718e.setLayoutParams(layoutParams3);
                    this.n = k;
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                        this.f25717d.startLoad(this.m.liveInfo.coverWide, 10, false);
                    }
                    if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                        this.f25719f.setText(this.m.liveAuthor.nameShow);
                    }
                    this.f25720g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                    if (!TextUtils.isEmpty(this.m.title)) {
                        this.f25721h.setText(this.m.title);
                    }
                    if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                        this.f25722i.setText(this.m.liveInfo.showLabel);
                    }
                    if (!StringUtils.isNull(this.m.labelUrl)) {
                        this.f25723j.setVisibility(0);
                        this.f25723j.startLoad(this.m.labelUrl, 10, false);
                        this.f25723j.setEvent(new a(this));
                    } else {
                        this.f25723j.setVisibility(8);
                    }
                    if (aVar.f25461f) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                        SdkLiveInfoData sdkLiveInfoData = this.m;
                        if (sdkLiveInfoData != null) {
                            statisticItem.param("tid", sdkLiveInfoData.tid);
                            statisticItem.param("fid", aVar.f25462g);
                            statisticItem.param("fname", aVar.f25463h);
                        }
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", this.p);
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                            int a2 = c.a.r0.v.d.c.c.a(alaLiveInfo);
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, c.a.r0.v.d.c.c.k(yYExt, sdkLiveInfoData3.roomId));
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
                onChangeSkinType(this.f25714a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            getView().setVisibility(4);
        }
    }

    @Override // c.a.r0.v.d.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25716c : (View) invokeV.objValue;
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
            this.f25716c = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
            this.f25717d = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f25717d.setConrers(3);
            this.f25717d.setRadiusById(R.string.J_X13);
            this.f25717d.setPlaceHolder(2);
            this.f25718e = this.f25716c.findViewById(R.id.img_mask);
            this.f25719f = (TextView) this.f25716c.findViewById(R.id.text_name);
            this.f25720g = (EMTextView) this.f25716c.findViewById(R.id.text_audience_count);
            EMTextView eMTextView = (EMTextView) this.f25716c.findViewById(R.id.text_title);
            this.f25721h = eMTextView;
            c.a.q0.s.u.c.d(eMTextView).B(R.string.F_X02);
            this.f25722i = (EMTextView) this.f25716c.findViewById(R.id.text_label);
            this.f25716c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TbImageView tbImageView2 = (TbImageView) this.f25716c.findViewById(R.id.special_label);
            this.f25723j = tbImageView2;
            tbImageView2.setDrawCorner(true);
            this.f25723j.setConrers(1);
            this.f25723j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f25716c);
            d2.n(0);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.f25716c.setOnClickListener(this.r);
        }
    }

    @Override // c.a.r0.v.d.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.k == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f25719f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25720g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25721h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25722i, R.color.CAM_X0109);
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f25716c);
        d2.n(0);
        d2.o(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.k = i2;
    }
}
