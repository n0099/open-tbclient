package c.a.t0.a0.f.c.h;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
public class f implements c.a.t0.a0.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final float t;
    public static final int u;
    public static final int v;
    public static final float[] w;
    public static final float[] x;
    public static final float[] y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f14679b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f14680c;

    /* renamed from: d  reason: collision with root package name */
    public View f14681d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f14682e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f14683f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14684g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f14685h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f14686i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f14687j;
    public TbImageView k;
    public c.a.t0.a0.f.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.a;
                this.a.f14687j.setLayoutParams(new RelativeLayout.LayoutParams(fVar.i(fVar.f14687j.getLoadedHeight(), this.a.f14687j.getLoadedWidth()), f.s));
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
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fVar.i(fVar.k.getLoadedHeight(), this.a.k.getLoadedWidth()), f.s);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.a.f14680c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.a.k.setLayoutParams(layoutParams);
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14688e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14688e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean d2 = c.a.t0.a0.f.c.c.d(this.f14688e.m);
                String str4 = TiebaStatic.YYValues.YY_LIVE;
                if (d2) {
                    if (this.f14688e.l.f14468f) {
                        str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f14688e.p;
                    } else {
                        str3 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f14688e.p;
                    }
                    c.a.t0.a0.f.c.c.j(this.f14688e.f14680c, this.f14688e.m, str3);
                    if (!c.a.t0.a0.f.c.c.d(this.f14688e.m) || this.f14688e.l == null) {
                        return;
                    }
                    if (this.f14688e.l.f14468f) {
                        this.f14688e.k();
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13557");
                    statisticItem.param("obj_locate", this.f14688e.l.f14471i);
                    statisticItem.param("obj_param1", this.f14688e.m.liveId);
                    if (this.f14688e.m.liveInfo != null) {
                        int a = c.a.t0.a0.f.c.c.a(this.f14688e.m.liveInfo);
                        if (this.f14688e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, c.a.t0.a0.f.c.c.k(this.f14688e.m.liveInfo.yyExt, this.f14688e.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem.param("nid", this.f14688e.m.nid);
                    statisticItem.param(TiebaStatic.Params.LOGID, this.f14688e.m.logid);
                    TiebaStatic.log(statisticItem);
                } else if (c.a.t0.a0.f.c.c.c(this.f14688e.m)) {
                    if (103 == this.f14688e.p) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                        statisticItem2.param("obj_locate", 3);
                        statisticItem2.param("obj_param1", this.f14688e.m.liveId);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem2);
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                    } else {
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    c.a.t0.a0.f.c.c.f(this.f14688e.f14680c, this.f14688e.m, str2);
                } else {
                    c.a.t0.a0.f.c.c.h(this.f14688e.f14680c.getPageActivity(), this.f14688e.m);
                    if (this.f14688e.l == null || this.f14688e.m == null) {
                        return;
                    }
                    if (this.f14688e.l.f14468f) {
                        StatisticItem statisticItem3 = new StatisticItem("c13611");
                        statisticItem3.param("obj_param1", this.f14688e.m.liveId);
                        statisticItem3.param("fid", this.f14688e.l.f14469g);
                        statisticItem3.param("fname", this.f14688e.l.f14470h);
                        statisticItem3.param("obj_locate", this.f14688e.l.f14471i);
                        if (this.f14688e.m != null && this.f14688e.m.uiTransParam != null) {
                            statisticItem3.param("ab_tag", this.f14688e.m.uiTransParam.abTag);
                            statisticItem3.param(TiebaStatic.Params.STAR_ID, this.f14688e.m.uiTransParam.starId);
                            statisticItem3.param("extra", this.f14688e.m.uiTransParam.extra);
                            statisticItem3.param("source_from", this.f14688e.m.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(statisticItem3);
                        this.f14688e.k();
                        return;
                    }
                    StatisticItem statisticItem4 = new StatisticItem("c13557");
                    if (101 == this.f14688e.p) {
                        str = "推荐";
                    } else if (102 == this.f14688e.p) {
                        str = "颜值";
                    } else {
                        str = 103 == this.f14688e.p ? "交友" : "";
                    }
                    if (this.f14688e.m.liveInfo != null) {
                        int a2 = c.a.t0.a0.f.c.c.a(this.f14688e.m.liveInfo);
                        if (this.f14688e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem4, c.a.t0.a0.f.c.c.k(this.f14688e.m.liveInfo.yyExt, this.f14688e.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem4.param("obj_param1", this.f14688e.m.liveId);
                    statisticItem4.param(TiebaStatic.Params.ENTRY_NAME, str);
                    statisticItem4.param("nid", this.f14688e.m.nid);
                    statisticItem4.param(TiebaStatic.Params.LOGID, this.f14688e.m.logid);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1961170108, "Lc/a/t0/a0/f/c/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1961170108, "Lc/a/t0/a0/f/c/h/f;");
                return;
            }
        }
        s = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        t = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        float f2 = t;
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2};
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, f2};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, 0.0f, 0.0f};
    }

    public f(TbPageContext<?> tbPageContext, int i2) {
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
        this.a = 3;
        this.f14679b = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = 0;
        this.r = new c(this);
        this.f14680c = tbPageContext;
        this.p = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f14681d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f14682e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f14682e.setDrawBorder(true);
        this.f14682e.setPlaceHolder(2);
        this.f14682e.setBorderWidth(n.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f14683f = (EMTextView) this.f14681d.findViewById(R.id.tvLiveCount);
        this.f14684g = (TextView) this.f14681d.findViewById(R.id.tvUserName);
        this.f14686i = (LinearLayout) this.f14681d.findViewById(R.id.tvInfoWrapper);
        this.f14687j = (TbImageView) this.f14681d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f14681d.findViewById(R.id.live_status_label);
        this.f14685h = (EMTextView) this.f14681d.findViewById(R.id.tvLocation);
        this.f14681d.setOnClickListener(this.r);
        this.q = ((n.k(TbadkCoreApplication.getInst()) - u) - (v * 2)) / 2;
    }

    @Override // c.a.t0.a0.f.c.b
    public void a(c.a.t0.a0.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            l(aVar, -1);
        }
    }

    @Override // c.a.t0.a0.f.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14681d : (View) invokeV.objValue;
    }

    public final int i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? (int) (s * (i3 / i2)) : invokeII.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.f14680c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = this.f14680c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
            this.f14685h.setGravity(16);
            this.f14685h.setLayoutParams(layoutParams);
        }
    }

    public final void k() {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            SdkLiveInfoData sdkLiveInfoData = this.m;
            if (sdkLiveInfoData != null) {
                statisticItem.param("tid", sdkLiveInfoData.tid);
                statisticItem.param("fid", this.l.f14469g);
                statisticItem.param("fname", this.l.f14470h);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 6);
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

    public void l(c.a.t0.a0.f.a.a aVar, int i2) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        SdkLiveInfoData.YYExt yYExt;
        String str3;
        SdkLiveInfoData.YYExt yYExt2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) {
            int k = n.k(this.f14681d.getContext());
            if (k != this.o) {
                ViewGroup.LayoutParams layoutParams = this.f14681d.getLayoutParams();
                if (layoutParams == null) {
                    int i3 = this.q;
                    layoutParams = new ViewGroup.LayoutParams(i3, i3);
                } else {
                    int i4 = this.q;
                    layoutParams.width = i4;
                    layoutParams.height = i4;
                }
                this.f14681d.setLayoutParams(layoutParams);
                this.o = k;
            }
            if (aVar != null && aVar.f14467e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f14467e;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f14679b);
                String str5 = this.m.liveInfo.cover;
                this.n = str5;
                this.f14682e.setTag(str5);
                int i5 = 5;
                if (aVar.f14472j) {
                    this.f14682e.setConrers(5);
                    gradientDrawable.setCornerRadii(x);
                    this.f14682e.setPlaceHolder(2);
                } else if (aVar.k) {
                    this.f14682e.setConrers(10);
                    gradientDrawable.setCornerRadii(y);
                    this.f14682e.setPlaceHolder(2);
                } else if (aVar.l) {
                    this.f14682e.setConrers(15);
                    gradientDrawable.setCornerRadii(w);
                    this.f14682e.setPlaceHolder(2);
                }
                this.f14682e.setRadius((int) t);
                TbImageView tbImageView = this.f14682e;
                String str6 = this.m.liveInfo.cover;
                int i6 = this.q;
                tbImageView.startLoad(str6, 10, i6, i6, false, false);
                this.f14686i.setBackgroundDrawable(gradientDrawable);
                long j2 = this.m.liveInfo.audienceCount;
                if (j2 <= 0) {
                    this.f14683f.setVisibility(8);
                    if (this.f14685h.getVisibility() == 0) {
                        m();
                    }
                } else {
                    String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j2);
                    this.f14683f.setVisibility(0);
                    this.f14683f.setText(numberUniformFormatExtraWithRound);
                    j();
                }
                if (103 == this.p) {
                    if (!StringUtils.isNull(this.m.title)) {
                        this.f14684g.setText(this.m.title);
                    }
                } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                    this.f14684g.setText(this.m.liveAuthor.nameShow);
                }
                if (!StringUtils.isNull(this.m.labelUrl)) {
                    this.f14687j.setVisibility(0);
                    this.f14687j.startLoad(this.m.labelUrl, 10, false);
                    this.f14687j.setEvent(new a(this));
                } else {
                    this.f14687j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.modeUrl)) {
                    this.k.setVisibility(0);
                    this.k.startLoad(this.m.modeUrl, 10, false);
                    this.k.setEvent(new b(this));
                } else {
                    this.k.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.location)) {
                    this.f14685h.setVisibility(0);
                    if (this.m.location.length() <= 5) {
                        str4 = this.m.location;
                    } else {
                        str4 = this.m.location.substring(0, 5) + "...";
                    }
                    this.f14685h.setText(str4);
                } else {
                    this.f14685h.setVisibility(8);
                }
                SdkLiveInfoData sdkLiveInfoData = this.m;
                String str7 = TiebaStatic.YYValues.YY_LIVE;
                if (sdkLiveInfoData != null) {
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.m.tid);
                        c.a.t0.a0.f.a.a aVar2 = this.l;
                        if (aVar2 != null) {
                            param.param("fid", aVar2.f14469g);
                            param.param("fname", this.l.f14470h);
                        }
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData2.liveInfo;
                        if (alaLiveInfo == null || (yYExt2 = alaLiveInfo.yyExt) == null) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param, yYExt2.toYyExtData(sdkLiveInfoData2.roomId));
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            i5 = sdkLiveInfoData3.liveInfo.yyExt.toYyExtData(sdkLiveInfoData3.roomId).isYyGame ? 3 : 2;
                            str3 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param.param("obj_param1", i5);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.m.tid);
                        c.a.t0.a0.f.a.a aVar3 = this.l;
                        if (aVar3 != null) {
                            param2.param("fid", aVar3.f14469g);
                            param2.param("fname", this.l.f14470h);
                        }
                        SdkLiveInfoData sdkLiveInfoData4 = this.m;
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = sdkLiveInfoData4.liveInfo;
                        if (alaLiveInfo2 == null || (yYExt = alaLiveInfo2.yyExt) == null) {
                            str2 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, yYExt.toYyExtData(sdkLiveInfoData4.roomId));
                            SdkLiveInfoData sdkLiveInfoData5 = this.m;
                            i5 = sdkLiveInfoData5.liveInfo.yyExt.toYyExtData(sdkLiveInfoData5.roomId).isYyGame ? 3 : 2;
                            str2 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param2.param("obj_param1", i5);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                        TiebaStatic.log(param2);
                    }
                }
                onChangeSkinType(this.f14680c, TbadkCoreApplication.getInst().getSkinType());
                if (aVar.f14468f) {
                    StatisticItem statisticItem = new StatisticItem("c13610");
                    SdkLiveInfoData sdkLiveInfoData6 = this.m;
                    statisticItem.param("obj_param1", sdkLiveInfoData6 != null ? sdkLiveInfoData6.liveId : "");
                    statisticItem.param("fid", aVar.f14469g);
                    statisticItem.param("fname", aVar.f14470h);
                    statisticItem.param("obj_locate", aVar.f14471i);
                    SdkLiveInfoData sdkLiveInfoData7 = this.m;
                    if (sdkLiveInfoData7 != null && (uiTransParam = sdkLiveInfoData7.uiTransParam) != null) {
                        statisticItem.param("ab_tag", uiTransParam.abTag);
                        statisticItem.param(TiebaStatic.Params.STAR_ID, this.m.uiTransParam.starId);
                        statisticItem.param("extra", this.m.uiTransParam.extra);
                        statisticItem.param("source_from", this.m.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData8 = this.m;
                    if (sdkLiveInfoData8 != null) {
                        statisticItem2.param("tid", sdkLiveInfoData8.tid);
                        statisticItem2.param("fid", aVar.f14469g);
                        statisticItem2.param("fname", aVar.f14470h);
                    }
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 6);
                    SdkLiveInfoData.AlaLiveInfo alaLiveInfo3 = this.m.liveInfo;
                    if (alaLiveInfo3 != null) {
                        int a2 = c.a.t0.a0.f.c.c.a(alaLiveInfo3);
                        SdkLiveInfoData sdkLiveInfoData9 = this.m;
                        SdkLiveInfoData.YYExt yYExt3 = sdkLiveInfoData9.liveInfo.yyExt;
                        if (yYExt3 != null) {
                            TiebaStaticHelper.addYYParam(statisticItem2, c.a.t0.a0.f.c.c.k(yYExt3, sdkLiveInfoData9.roomId));
                        } else {
                            str7 = "";
                        }
                        statisticItem2.param("obj_param1", a2);
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str7);
                    }
                    TiebaStatic.log(statisticItem2);
                    return;
                }
                StatisticItem statisticItem3 = new StatisticItem("c13544");
                int i7 = this.p;
                if (101 == i7) {
                    str = "推荐";
                } else if (102 == i7) {
                    str = "颜值";
                } else if (103 == i7) {
                    if (c.a.t0.a0.f.c.c.c(this.m)) {
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                        statisticItem4.param("obj_locate", 3);
                        statisticItem4.param("obj_param1", this.m.liveId);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem4);
                    }
                    str = "交友";
                } else {
                    str = "";
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo4 = this.m.liveInfo;
                if (alaLiveInfo4 != null) {
                    int a3 = c.a.t0.a0.f.c.c.a(alaLiveInfo4);
                    SdkLiveInfoData sdkLiveInfoData10 = this.m;
                    SdkLiveInfoData.YYExt yYExt4 = sdkLiveInfoData10.liveInfo.yyExt;
                    if (yYExt4 != null) {
                        TiebaStaticHelper.addYYParam(statisticItem3, c.a.t0.a0.f.c.c.k(yYExt4, sdkLiveInfoData10.roomId));
                    } else {
                        str7 = "";
                    }
                    statisticItem3.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                    statisticItem3.param(TiebaStatic.Params.OBJ_PARAM3, str7);
                }
                SdkLiveInfoData sdkLiveInfoData11 = this.m;
                statisticItem3.param("obj_param1", sdkLiveInfoData11 != null ? sdkLiveInfoData11.liveId : "");
                statisticItem3.param(TiebaStatic.Params.ENTRY_NAME, str);
                statisticItem3.param("nid", this.m.nid);
                statisticItem3.param(TiebaStatic.Params.LOGID, this.m.logid);
                TiebaStatic.log(statisticItem3);
                return;
            }
            getView().setVisibility(4);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.f14680c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = 0;
            this.f14685h.setGravity(16);
            this.f14685h.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.t0.a0.f.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f14683f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14684g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14685h, R.color.CAM_X0101);
        this.a = i2;
    }
}
