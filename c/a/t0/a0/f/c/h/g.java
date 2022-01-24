package c.a.t0.a0.f.c.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes6.dex */
public class g implements c.a.t0.a0.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public int f14689b;

    /* renamed from: c  reason: collision with root package name */
    public View f14690c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f14691d;

    /* renamed from: e  reason: collision with root package name */
    public View f14692e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14693f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f14694g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f14695h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f14696i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f14697j;
    public int k;
    public c.a.t0.a0.f.a.a l;
    public SdkLiveInfoData m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final View.OnClickListener r;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                g gVar = this.a;
                this.a.f14697j.setLayoutParams(new RelativeLayout.LayoutParams(gVar.i(gVar.f14697j.getLoadedHeight(), this.a.f14697j.getLoadedWidth()), g.s));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14698e;

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
            this.f14698e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.t0.a0.f.c.c.d(this.f14698e.m)) {
                    if (this.f14698e.l.f14468f) {
                        str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f14698e.f14689b;
                    } else {
                        str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f14698e.f14689b;
                    }
                    c.a.t0.a0.f.c.c.j(this.f14698e.a, this.f14698e.m, str2);
                }
                if (this.f14698e.l == null || !this.f14698e.l.f14468f) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
                if (this.f14698e.m != null) {
                    statisticItem.param("tid", this.f14698e.m.tid);
                    statisticItem.param("fid", this.f14698e.l.f14469g);
                    statisticItem.param("fname", this.f14698e.l.f14470h);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", this.f14698e.p);
                if (this.f14698e.m != null && this.f14698e.m.liveInfo != null) {
                    int a = c.a.t0.a0.f.c.c.a(this.f14698e.m.liveInfo);
                    if (this.f14698e.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, c.a.t0.a0.f.c.c.k(this.f14698e.m.liveInfo.yyExt, this.f14698e.m.roomId));
                        str = TiebaStatic.YYValues.YY_LIVE;
                    } else {
                        str = "";
                    }
                    statisticItem.param("obj_param1", a);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1961170077, "Lc/a/t0/a0/f/c/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1961170077, "Lc/a/t0/a0/f/c/h/g;");
                return;
            }
        }
        s = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds55);
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
        this.a = tbPageContext;
        this.f14689b = i2;
        j(tbPageContext);
    }

    @Override // c.a.t0.a0.f.c.b
    public void a(c.a.t0.a0.f.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f14467e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f14467e;
                int k = n.k(this.f14690c.getContext());
                if (k != this.n) {
                    ViewGroup.LayoutParams layoutParams = this.f14690c.getLayoutParams();
                    int k2 = n.k(this.f14690c.getContext()) - this.f14690c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                    int dimensionPixelSize = this.f14690c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                    int i2 = this.o;
                    int i3 = k2 - (dimensionPixelSize * i2);
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i3 / this.o, -2);
                    } else {
                        layoutParams.width = i3 / i2;
                        layoutParams.height = -2;
                    }
                    this.f14690c.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = this.f14691d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.o, (i3 / 32) * this.q);
                    } else {
                        layoutParams2.width = i3 / this.o;
                        layoutParams2.height = (i3 / 32) * this.q;
                    }
                    this.f14691d.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = this.f14692e.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.o, this.f14690c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                    } else {
                        layoutParams3.width = i3 / this.o;
                        layoutParams3.height = this.f14690c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                    }
                    this.f14692e.setLayoutParams(layoutParams3);
                    this.n = k;
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                        this.f14691d.startLoad(this.m.liveInfo.coverWide, 10, false);
                    }
                    if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                        this.f14693f.setText(this.m.liveAuthor.nameShow);
                    }
                    this.f14694g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                    if (!TextUtils.isEmpty(this.m.title)) {
                        this.f14695h.setText(this.m.title);
                    }
                    if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                        this.f14696i.setText(this.m.liveInfo.showLabel);
                    }
                    if (!StringUtils.isNull(this.m.labelUrl)) {
                        this.f14697j.setVisibility(0);
                        this.f14697j.startLoad(this.m.labelUrl, 10, false);
                        this.f14697j.setEvent(new a(this));
                    } else {
                        this.f14697j.setVisibility(8);
                    }
                    if (aVar.f14468f) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                        SdkLiveInfoData sdkLiveInfoData = this.m;
                        if (sdkLiveInfoData != null) {
                            statisticItem.param("tid", sdkLiveInfoData.tid);
                            statisticItem.param("fid", aVar.f14469g);
                            statisticItem.param("fname", aVar.f14470h);
                        }
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", this.p);
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                            int a2 = c.a.t0.a0.f.c.c.a(alaLiveInfo);
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, c.a.t0.a0.f.c.c.k(yYExt, sdkLiveInfoData3.roomId));
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
                onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            getView().setVisibility(4);
        }
    }

    @Override // c.a.t0.a0.f.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14690c : (View) invokeV.objValue;
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
            this.f14690c = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
            this.f14691d = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f14691d.setConrers(3);
            this.f14691d.setRadiusById(R.string.J_X13);
            this.f14691d.setPlaceHolder(2);
            this.f14692e = this.f14690c.findViewById(R.id.img_mask);
            this.f14693f = (TextView) this.f14690c.findViewById(R.id.text_name);
            this.f14694g = (EMTextView) this.f14690c.findViewById(R.id.text_audience_count);
            EMTextView eMTextView = (EMTextView) this.f14690c.findViewById(R.id.text_title);
            this.f14695h = eMTextView;
            c.a.s0.s.u.c.d(eMTextView).A(R.string.F_X02);
            this.f14696i = (EMTextView) this.f14690c.findViewById(R.id.text_label);
            this.f14690c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TbImageView tbImageView2 = (TbImageView) this.f14690c.findViewById(R.id.special_label);
            this.f14697j = tbImageView2;
            tbImageView2.setDrawCorner(true);
            this.f14697j.setConrers(1);
            this.f14697j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f14690c);
            d2.m(0);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.f14690c.setOnClickListener(this.r);
        }
    }

    @Override // c.a.t0.a0.f.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.k == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f14693f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14694g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14695h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14696i, R.color.CAM_X0109);
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f14690c);
        d2.m(0);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.k = i2;
    }
}
