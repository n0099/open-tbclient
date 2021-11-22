package b.a.r0.w.f.c.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class g implements b.a.r0.w.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f26268a;

    /* renamed from: b  reason: collision with root package name */
    public int f26269b;

    /* renamed from: c  reason: collision with root package name */
    public View f26270c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f26271d;

    /* renamed from: e  reason: collision with root package name */
    public View f26272e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26273f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f26274g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f26275h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f26276i;
    public TbImageView j;
    public int k;
    public b.a.r0.w.f.a.a l;
    public SdkLiveInfoData m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f26277a;

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
            this.f26277a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                g gVar = this.f26277a;
                this.f26277a.j.setLayoutParams(new RelativeLayout.LayoutParams(gVar.i(gVar.j.getLoadedHeight(), this.f26277a.j.getLoadedWidth()), g.s));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26278e;

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
            this.f26278e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (b.a.r0.w.f.c.c.d(this.f26278e.m)) {
                    if (this.f26278e.l.f26013f) {
                        str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f26278e.f26269b;
                    } else {
                        str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f26278e.f26269b;
                    }
                    b.a.r0.w.f.c.c.j(this.f26278e.f26268a, this.f26278e.m, str2);
                }
                if (this.f26278e.l == null || !this.f26278e.l.f26013f) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
                if (this.f26278e.m != null) {
                    statisticItem.param("tid", this.f26278e.m.tid);
                    statisticItem.param("fid", this.f26278e.l.f26014g);
                    statisticItem.param("fname", this.f26278e.l.f26015h);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", this.f26278e.p);
                if (this.f26278e.m != null && this.f26278e.m.liveInfo != null) {
                    int a2 = b.a.r0.w.f.c.c.a(this.f26278e.m.liveInfo);
                    if (this.f26278e.m.liveInfo.yyExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, b.a.r0.w.f.c.c.k(this.f26278e.m.liveInfo.yyExt, this.f26278e.m.roomId));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1274762414, "Lb/a/r0/w/f/c/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1274762414, "Lb/a/r0/w/f/c/h/g;");
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
        this.f26268a = tbPageContext;
        this.f26269b = i2;
        j(tbPageContext);
    }

    @Override // b.a.r0.w.f.c.b
    public void a(b.a.r0.w.f.a.a aVar) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f26012e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f26012e;
                int k = l.k(this.f26270c.getContext());
                if (k != this.n) {
                    ViewGroup.LayoutParams layoutParams = this.f26270c.getLayoutParams();
                    int k2 = l.k(this.f26270c.getContext()) - this.f26270c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                    int dimensionPixelSize = this.f26270c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                    int i2 = this.o;
                    int i3 = k2 - (dimensionPixelSize * i2);
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i3 / this.o, -2);
                    } else {
                        layoutParams.width = i3 / i2;
                        layoutParams.height = -2;
                    }
                    this.f26270c.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = this.f26271d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(i3 / this.o, (i3 / 32) * this.q);
                    } else {
                        layoutParams2.width = i3 / this.o;
                        layoutParams2.height = (i3 / 32) * this.q;
                    }
                    this.f26271d.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = this.f26272e.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(i3 / this.o, this.f26270c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                    } else {
                        layoutParams3.width = i3 / this.o;
                        layoutParams3.height = this.f26270c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                    }
                    this.f26272e.setLayoutParams(layoutParams3);
                    this.n = k;
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                        this.f26271d.startLoad(this.m.liveInfo.coverWide, 10, false);
                    }
                    if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                        this.f26273f.setText(this.m.liveAuthor.nameShow);
                    }
                    this.f26274g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                    if (!TextUtils.isEmpty(this.m.title)) {
                        this.f26275h.setText(this.m.title);
                    }
                    if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                        this.f26276i.setText(this.m.liveInfo.showLabel);
                    }
                    if (!StringUtils.isNull(this.m.labelUrl)) {
                        this.j.setVisibility(0);
                        this.j.startLoad(this.m.labelUrl, 10, false);
                        this.j.setEvent(new a(this));
                    } else {
                        this.j.setVisibility(8);
                    }
                    if (aVar.f26013f) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                        SdkLiveInfoData sdkLiveInfoData = this.m;
                        if (sdkLiveInfoData != null) {
                            statisticItem.param("tid", sdkLiveInfoData.tid);
                            statisticItem.param("fid", aVar.f26014g);
                            statisticItem.param("fname", aVar.f26015h);
                        }
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", this.p);
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                            int a2 = b.a.r0.w.f.c.c.a(alaLiveInfo);
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, b.a.r0.w.f.c.c.k(yYExt, sdkLiveInfoData3.roomId));
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
                onChangeSkinType(this.f26268a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            getView().setVisibility(4);
        }
    }

    @Override // b.a.r0.w.f.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26270c : (View) invokeV.objValue;
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
            this.f26270c = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_cover);
            this.f26271d = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f26271d.setConrers(3);
            this.f26271d.setRadiusById(R.string.J_X13);
            this.f26271d.setPlaceHolder(2);
            this.f26272e = this.f26270c.findViewById(R.id.img_mask);
            this.f26273f = (TextView) this.f26270c.findViewById(R.id.text_name);
            this.f26274g = (EMTextView) this.f26270c.findViewById(R.id.text_audience_count);
            EMTextView eMTextView = (EMTextView) this.f26270c.findViewById(R.id.text_title);
            this.f26275h = eMTextView;
            b.a.q0.s.u.c.d(eMTextView).A(R.string.F_X02);
            this.f26276i = (EMTextView) this.f26270c.findViewById(R.id.text_label);
            this.f26270c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TbImageView tbImageView2 = (TbImageView) this.f26270c.findViewById(R.id.special_label);
            this.j = tbImageView2;
            tbImageView2.setDrawCorner(true);
            this.j.setConrers(1);
            this.j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f26270c);
            d2.m(0);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
            this.f26270c.setOnClickListener(this.r);
        }
    }

    @Override // b.a.r0.w.f.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.k == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f26273f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26274g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26275h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26276i, R.color.CAM_X0109);
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f26270c);
        d2.m(0);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0201);
        this.k = i2;
    }
}
