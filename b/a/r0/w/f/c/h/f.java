package b.a.r0.w.f.c.h;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class f implements b.a.r0.w.f.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final float t;
    public static final int u;
    public static final int v;
    public static final float[] w;
    public static final float[] x;
    public static final float[] y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f26256a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f26257b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f26258c;

    /* renamed from: d  reason: collision with root package name */
    public View f26259d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26260e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f26261f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26262g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f26263h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f26264i;
    public TbImageView j;
    public TbImageView k;
    public b.a.r0.w.f.a.a l;
    public SdkLiveInfoData m;
    public String n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26265a;

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
            this.f26265a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.f26265a;
                this.f26265a.j.setLayoutParams(new RelativeLayout.LayoutParams(fVar.i(fVar.j.getLoadedHeight(), this.f26265a.j.getLoadedWidth()), f.s));
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
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26266a;

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
            this.f26266a = fVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                f fVar = this.f26266a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fVar.i(fVar.k.getLoadedHeight(), this.f26266a.k.getLoadedWidth()), f.s);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f26266a.f26258c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.f26266a.k.setLayoutParams(layoutParams);
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26267e;

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
            this.f26267e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean d2 = b.a.r0.w.f.c.c.d(this.f26267e.m);
                String str4 = TiebaStatic.YYValues.YY_LIVE;
                if (d2) {
                    if (this.f26267e.l.f26013f) {
                        str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.f26267e.p;
                    } else {
                        str3 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.f26267e.p;
                    }
                    b.a.r0.w.f.c.c.j(this.f26267e.f26258c, this.f26267e.m, str3);
                    if (!b.a.r0.w.f.c.c.d(this.f26267e.m) || this.f26267e.l == null) {
                        return;
                    }
                    if (this.f26267e.l.f26013f) {
                        this.f26267e.k();
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13557");
                    statisticItem.param("obj_locate", this.f26267e.l.f26016i);
                    statisticItem.param("obj_param1", this.f26267e.m.liveId);
                    if (this.f26267e.m.liveInfo != null) {
                        int a2 = b.a.r0.w.f.c.c.a(this.f26267e.m.liveInfo);
                        if (this.f26267e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, b.a.r0.w.f.c.c.k(this.f26267e.m.liveInfo.yyExt, this.f26267e.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem.param("nid", this.f26267e.m.nid);
                    statisticItem.param(TiebaStatic.Params.LOGID, this.f26267e.m.logid);
                    TiebaStatic.log(statisticItem);
                } else if (b.a.r0.w.f.c.c.c(this.f26267e.m)) {
                    if (103 == this.f26267e.p) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                        statisticItem2.param("obj_locate", 3);
                        statisticItem2.param("obj_param1", this.f26267e.m.liveId);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem2);
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                    } else {
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    b.a.r0.w.f.c.c.f(this.f26267e.f26258c, this.f26267e.m, str2);
                } else {
                    b.a.r0.w.f.c.c.h(this.f26267e.f26258c.getPageActivity(), this.f26267e.m);
                    if (this.f26267e.l == null || this.f26267e.m == null) {
                        return;
                    }
                    if (this.f26267e.l.f26013f) {
                        StatisticItem statisticItem3 = new StatisticItem("c13611");
                        statisticItem3.param("obj_param1", this.f26267e.m.liveId);
                        statisticItem3.param("fid", this.f26267e.l.f26014g);
                        statisticItem3.param("fname", this.f26267e.l.f26015h);
                        statisticItem3.param("obj_locate", this.f26267e.l.f26016i);
                        if (this.f26267e.m != null && this.f26267e.m.uiTransParam != null) {
                            statisticItem3.param("ab_tag", this.f26267e.m.uiTransParam.abTag);
                            statisticItem3.param(TiebaStatic.Params.STAR_ID, this.f26267e.m.uiTransParam.starId);
                            statisticItem3.param("extra", this.f26267e.m.uiTransParam.extra);
                            statisticItem3.param("source_from", this.f26267e.m.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(statisticItem3);
                        this.f26267e.k();
                        return;
                    }
                    StatisticItem statisticItem4 = new StatisticItem("c13557");
                    if (101 == this.f26267e.p) {
                        str = "推荐";
                    } else if (102 == this.f26267e.p) {
                        str = "颜值";
                    } else {
                        str = 103 == this.f26267e.p ? "交友" : "";
                    }
                    if (this.f26267e.m.liveInfo != null) {
                        int a3 = b.a.r0.w.f.c.c.a(this.f26267e.m.liveInfo);
                        if (this.f26267e.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem4, b.a.r0.w.f.c.c.k(this.f26267e.m.liveInfo.yyExt, this.f26267e.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem4.param("obj_param1", this.f26267e.m.liveId);
                    statisticItem4.param(TiebaStatic.Params.ENTRY_NAME, str);
                    statisticItem4.param("nid", this.f26267e.m.nid);
                    statisticItem4.param(TiebaStatic.Params.LOGID, this.f26267e.m.logid);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1274762445, "Lb/a/r0/w/f/c/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1274762445, "Lb/a/r0/w/f/c/h/f;");
                return;
            }
        }
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
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
        this.f26256a = 3;
        this.f26257b = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = 0;
        this.r = new c(this);
        this.f26258c = tbPageContext;
        this.p = i2;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.f26259d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f26260e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f26260e.setDrawBorder(true);
        this.f26260e.setPlaceHolder(2);
        this.f26260e.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f26261f = (EMTextView) this.f26259d.findViewById(R.id.tvLiveCount);
        this.f26262g = (TextView) this.f26259d.findViewById(R.id.tvUserName);
        this.f26264i = (LinearLayout) this.f26259d.findViewById(R.id.tvInfoWrapper);
        this.j = (TbImageView) this.f26259d.findViewById(R.id.live_label);
        this.k = (TbImageView) this.f26259d.findViewById(R.id.live_status_label);
        this.f26263h = (EMTextView) this.f26259d.findViewById(R.id.tvLocation);
        this.f26259d.setOnClickListener(this.r);
        this.q = ((l.k(TbadkCoreApplication.getInst()) - u) - (v * 2)) / 2;
    }

    @Override // b.a.r0.w.f.c.b
    public void a(b.a.r0.w.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            l(aVar, -1);
        }
    }

    @Override // b.a.r0.w.f.c.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26259d : (View) invokeV.objValue;
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
            layoutParams.rightMargin = this.f26258c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = this.f26258c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
            this.f26263h.setGravity(16);
            this.f26263h.setLayoutParams(layoutParams);
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
                statisticItem.param("fid", this.l.f26014g);
                statisticItem.param("fname", this.l.f26015h);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 6);
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

    public void l(b.a.r0.w.f.a.a aVar, int i2) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        SdkLiveInfoData.YYExt yYExt;
        String str3;
        SdkLiveInfoData.YYExt yYExt2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) {
            int k = l.k(this.f26259d.getContext());
            if (k != this.o) {
                ViewGroup.LayoutParams layoutParams = this.f26259d.getLayoutParams();
                if (layoutParams == null) {
                    int i3 = this.q;
                    layoutParams = new ViewGroup.LayoutParams(i3, i3);
                } else {
                    int i4 = this.q;
                    layoutParams.width = i4;
                    layoutParams.height = i4;
                }
                this.f26259d.setLayoutParams(layoutParams);
                this.o = k;
            }
            if (aVar != null && aVar.f26012e != null) {
                getView().setVisibility(0);
                this.l = aVar;
                this.m = aVar.f26012e;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f26257b);
                String str5 = this.m.liveInfo.cover;
                this.n = str5;
                this.f26260e.setTag(str5);
                int i5 = 5;
                if (aVar.j) {
                    this.f26260e.setConrers(5);
                    gradientDrawable.setCornerRadii(x);
                    this.f26260e.setPlaceHolder(2);
                } else if (aVar.k) {
                    this.f26260e.setConrers(10);
                    gradientDrawable.setCornerRadii(y);
                    this.f26260e.setPlaceHolder(2);
                } else if (aVar.l) {
                    this.f26260e.setConrers(15);
                    gradientDrawable.setCornerRadii(w);
                    this.f26260e.setPlaceHolder(2);
                }
                this.f26260e.setRadius((int) t);
                TbImageView tbImageView = this.f26260e;
                String str6 = this.m.liveInfo.cover;
                int i6 = this.q;
                tbImageView.startLoad(str6, 10, i6, i6, false, false);
                this.f26264i.setBackgroundDrawable(gradientDrawable);
                long j = this.m.liveInfo.audienceCount;
                if (j <= 0) {
                    this.f26261f.setVisibility(8);
                    if (this.f26263h.getVisibility() == 0) {
                        m();
                    }
                } else {
                    String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                    this.f26261f.setVisibility(0);
                    this.f26261f.setText(numberUniformFormatExtraWithRound);
                    j();
                }
                if (103 == this.p) {
                    if (!StringUtils.isNull(this.m.title)) {
                        this.f26262g.setText(this.m.title);
                    }
                } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                    this.f26262g.setText(this.m.liveAuthor.nameShow);
                }
                if (!StringUtils.isNull(this.m.labelUrl)) {
                    this.j.setVisibility(0);
                    this.j.startLoad(this.m.labelUrl, 10, false);
                    this.j.setEvent(new a(this));
                } else {
                    this.j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.modeUrl)) {
                    this.k.setVisibility(0);
                    this.k.startLoad(this.m.modeUrl, 10, false);
                    this.k.setEvent(new b(this));
                } else {
                    this.k.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.location)) {
                    this.f26263h.setVisibility(0);
                    if (this.m.location.length() <= 5) {
                        str4 = this.m.location;
                    } else {
                        str4 = this.m.location.substring(0, 5) + "...";
                    }
                    this.f26263h.setText(str4);
                } else {
                    this.f26263h.setVisibility(8);
                }
                SdkLiveInfoData sdkLiveInfoData = this.m;
                String str7 = TiebaStatic.YYValues.YY_LIVE;
                if (sdkLiveInfoData != null) {
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.m.tid);
                        b.a.r0.w.f.a.a aVar2 = this.l;
                        if (aVar2 != null) {
                            param.param("fid", aVar2.f26014g);
                            param.param("fname", this.l.f26015h);
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
                        b.a.r0.w.f.a.a aVar3 = this.l;
                        if (aVar3 != null) {
                            param2.param("fid", aVar3.f26014g);
                            param2.param("fname", this.l.f26015h);
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
                onChangeSkinType(this.f26258c, TbadkCoreApplication.getInst().getSkinType());
                if (aVar.f26013f) {
                    StatisticItem statisticItem = new StatisticItem("c13610");
                    SdkLiveInfoData sdkLiveInfoData6 = this.m;
                    statisticItem.param("obj_param1", sdkLiveInfoData6 != null ? sdkLiveInfoData6.liveId : "");
                    statisticItem.param("fid", aVar.f26014g);
                    statisticItem.param("fname", aVar.f26015h);
                    statisticItem.param("obj_locate", aVar.f26016i);
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
                        statisticItem2.param("fid", aVar.f26014g);
                        statisticItem2.param("fname", aVar.f26015h);
                    }
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 6);
                    SdkLiveInfoData.AlaLiveInfo alaLiveInfo3 = this.m.liveInfo;
                    if (alaLiveInfo3 != null) {
                        int a2 = b.a.r0.w.f.c.c.a(alaLiveInfo3);
                        SdkLiveInfoData sdkLiveInfoData9 = this.m;
                        SdkLiveInfoData.YYExt yYExt3 = sdkLiveInfoData9.liveInfo.yyExt;
                        if (yYExt3 != null) {
                            TiebaStaticHelper.addYYParam(statisticItem2, b.a.r0.w.f.c.c.k(yYExt3, sdkLiveInfoData9.roomId));
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
                    if (b.a.r0.w.f.c.c.c(this.m)) {
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
                    int a3 = b.a.r0.w.f.c.c.a(alaLiveInfo4);
                    SdkLiveInfoData sdkLiveInfoData10 = this.m;
                    SdkLiveInfoData.YYExt yYExt4 = sdkLiveInfoData10.liveInfo.yyExt;
                    if (yYExt4 != null) {
                        TiebaStaticHelper.addYYParam(statisticItem3, b.a.r0.w.f.c.c.k(yYExt4, sdkLiveInfoData10.roomId));
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
            layoutParams.rightMargin = this.f26258c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = 0;
            this.f26263h.setGravity(16);
            this.f26263h.setLayoutParams(layoutParams);
        }
    }

    @Override // b.a.r0.w.f.c.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) || this.f26256a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f26261f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26262g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26263h, R.color.CAM_X0101);
        this.f26256a = i2;
    }
}
