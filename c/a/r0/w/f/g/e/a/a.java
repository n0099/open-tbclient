package c.a.r0.w.f.g.e.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.q.d2;
import c.a.r0.w.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f26011a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f26012b;

    /* renamed from: c  reason: collision with root package name */
    public View f26013c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f26014d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26015e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26016f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26017g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26018h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26019i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f26020j;
    public ImageView k;
    public int l;
    public String m;
    public d2 n;
    public f o;
    public String p;
    public boolean q;
    public AlphaAnimation r;
    public boolean s;
    public boolean t;
    public int u;
    public TbImageView v;
    public int w;
    public long x;
    public String y;
    public View.OnClickListener z;

    /* renamed from: c.a.r0.w.f.g.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1213a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26021a;

        public animation.Animation$AnimationListenerC1213a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26021a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f26021a.t = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.f26021a.t = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26022a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f26023b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26023b = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f26023b.q && !this.f26023b.t) {
                if (StringUtils.isNull(this.f26022a) || !this.f26022a.equals(str)) {
                    a aVar = this.f26023b;
                    aVar.f26014d.startAnimation(aVar.r);
                    this.f26022a = str;
                }
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
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26024a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26024a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                a aVar = this.f26024a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.l(aVar.v.getLoadedHeight(), this.f26024a.v.getLoadedWidth()), this.f26024a.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f26024a.f26012b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.f26024a.v.setLayoutParams(layoutParams);
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26025e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26025e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26025e.n == null || this.f26025e.n.l1() == null || this.f26025e.o == null) {
                        return;
                    }
                    this.f26025e.o.a(this.f26025e.l, this.f26025e.m, this.f26025e.n);
                    return;
                }
                l.J(this.f26025e.f26012b.getPageActivity(), this.f26025e.f26012b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26011a = 3;
        this.q = false;
        this.s = true;
        this.t = false;
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = 0L;
        this.y = "";
        this.z = new d(this);
        this.f26012b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f26013c = inflate;
        this.f26014d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f26015e = (TextView) this.f26013c.findViewById(R.id.tvLiveFrom);
        this.f26016f = (TextView) this.f26013c.findViewById(R.id.tvLiveCount);
        this.f26017g = (RelativeLayout) this.f26013c.findViewById(R.id.rlSquareLivePanel);
        this.f26018h = (TextView) this.f26013c.findViewById(R.id.tvUserName);
        this.f26019i = (TextView) this.f26013c.findViewById(R.id.tv_extra);
        this.f26020j = (LinearLayout) this.f26013c.findViewById(R.id.challenge_root);
        this.f26013c.setOnClickListener(this.z);
        this.f26014d.setBorderSurroundContent(true);
        this.f26014d.setDrawBorder(true);
        this.k = (ImageView) this.f26013c.findViewById(R.id.live_redpacket_label);
        this.v = (TbImageView) this.f26013c.findViewById(R.id.live_status_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1213a(this));
        this.w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? (int) (this.w * (i3 / i2)) : invokeII.intValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26013c : (View) invokeV.objValue;
    }

    public void n(c.a.r0.w.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            o(cVar, -1, this.x, this.y);
        }
    }

    public void o(c.a.r0.w.f.a.c cVar, int i2, long j2, String str) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{cVar, Integer.valueOf(i2), Long.valueOf(j2), str}) == null) {
            if (cVar != null && (d2Var = cVar.f25667h) != null && d2Var.l1() != null) {
                if (this.u != l.k(this.f26013c.getContext())) {
                    this.u = l.k(this.f26013c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26017g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.f26013c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f26017g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = cVar.f25667h;
                this.l = cVar.f25664e;
                this.y = str;
                this.x = j2;
                this.m = !TextUtils.isEmpty(cVar.f25666g) ? cVar.f25666g : cVar.f25665f;
                Object tag = this.f26014d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.l1().cover) && !((String) tag).equals(this.n.l1().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.l1().cover) && !this.p.equals(this.n.l1().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str2 = this.n.l1().cover;
                this.p = str2;
                this.f26014d.setTag(str2);
                this.f26014d.startLoad(this.n.l1().cover, 10, false);
                this.f26014d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.P2)) {
                    this.v.setVisibility(0);
                    this.v.startLoad(this.n.P2, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f26016f.setText(this.f26012b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.l1().audience_count)));
                if (this.n.J() != null) {
                    String name_show = this.n.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f26018h.setText(name_show);
                }
                int i3 = 5;
                if (!StringUtils.isNull(this.n.a1)) {
                    this.f26019i.setVisibility(0);
                    this.f26020j.setVisibility(8);
                    this.f26019i.setText(this.n.a1);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.f26012b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.f26019i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.l1().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.f26012b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.l1().label.f14209b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.l1().label.f14209b));
                    }
                    this.f26019i.setBackgroundDrawable(gradientDrawable2);
                    this.f26019i.setText(this.n.l1().label.f14208a);
                    this.f26019i.setVisibility(0);
                    this.f26020j.setVisibility(8);
                } else if (this.n.l1().mChallengeInfoData != null && this.n.l1().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.f26012b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.f26020j.setBackground(gradientDrawable3);
                    this.f26020j.setVisibility(0);
                    this.f26019i.setVisibility(8);
                } else {
                    this.f26019i.setVisibility(8);
                    this.f26020j.setVisibility(8);
                }
                if (this.n.l1().haveRedpkg) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (this.n != null) {
                    String str3 = TiebaStatic.YYValues.YY_LIVE;
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.s1());
                        param.param("fid", this.x);
                        param.param("fname", this.y);
                        if (this.n.l1() == null || !this.n.l1().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            i3 = YYLiveUtil.calculateLiveType(this.n.l1());
                            TiebaStaticHelper.addYYParam(param, this.n.l1().mYyExtData);
                        }
                        param.param("obj_param1", i3);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.s1());
                        param2.param("fid", this.x);
                        param2.param("fname", this.y);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(this.n.l1());
                        if (this.n.l1() == null || !this.n.l1().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, this.n.l1().mYyExtData);
                        }
                        param2.param("obj_param1", calculateLiveType);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.f26012b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.f26011a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26017g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26016f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26018h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26019i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.f26012b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f26012b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f26012b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f26016f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f26012b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f26011a = i2;
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }
}
