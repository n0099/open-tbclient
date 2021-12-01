package c.a.r0.a0.f.g.e.a;

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
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.q.d2;
import c.a.r0.a0.f.a.e;
import c.a.r0.a0.f.h.d.f;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14148b;

    /* renamed from: c  reason: collision with root package name */
    public View f14149c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f14150d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14151e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14152f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f14153g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14154h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14155i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f14156j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f14157k;
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

    /* renamed from: c.a.r0.a0.f.g.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class animation.Animation$AnimationListenerC0858a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public animation.Animation$AnimationListenerC0858a(a aVar) {
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
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.t = false;
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
                this.a.t = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14158b;

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
            this.f14158b = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f14158b.q && !this.f14158b.t) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    a aVar = this.f14158b;
                    aVar.f14150d.startAnimation(aVar.r);
                    this.a = str;
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

    /* loaded from: classes5.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                a aVar = this.a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.l(aVar.v.getLoadedHeight(), this.a.v.getLoadedWidth()), this.a.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.a.f14148b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.a.v.setLayoutParams(layoutParams);
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14159e;

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
            this.f14159e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f14159e.n == null || this.f14159e.n.o1() == null || this.f14159e.o == null) {
                        return;
                    }
                    this.f14159e.o.a(this.f14159e.l, this.f14159e.m, this.f14159e.n);
                    return;
                }
                l.J(this.f14159e.f14148b.getPageActivity(), this.f14159e.f14148b.getPageActivity().getString(R.string.no_network_guide));
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
        this.a = 3;
        this.q = false;
        this.s = true;
        this.t = false;
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = 0L;
        this.y = "";
        this.z = new d(this);
        this.f14148b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f14149c = inflate;
        this.f14150d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f14151e = (TextView) this.f14149c.findViewById(R.id.tvLiveFrom);
        this.f14152f = (TextView) this.f14149c.findViewById(R.id.tvLiveCount);
        this.f14153g = (RelativeLayout) this.f14149c.findViewById(R.id.rlSquareLivePanel);
        this.f14154h = (TextView) this.f14149c.findViewById(R.id.tvUserName);
        this.f14155i = (TextView) this.f14149c.findViewById(R.id.tv_extra);
        this.f14156j = (LinearLayout) this.f14149c.findViewById(R.id.challenge_root);
        this.f14149c.setOnClickListener(this.z);
        this.f14150d.setBorderSurroundContent(true);
        this.f14150d.setDrawBorder(true);
        this.f14157k = (ImageView) this.f14149c.findViewById(R.id.live_redpacket_label);
        this.v = (TbImageView) this.f14149c.findViewById(R.id.live_status_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC0858a(this));
        this.w = l.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? (int) (this.w * (i3 / i2)) : invokeII.intValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14149c : (View) invokeV.objValue;
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            o(eVar, -1, this.x, this.y);
        }
    }

    public void o(e eVar, int i2, long j2, String str) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{eVar, Integer.valueOf(i2), Long.valueOf(j2), str}) == null) {
            if (eVar != null && (d2Var = eVar.f13853h) != null && d2Var.o1() != null) {
                if (this.u != l.k(this.f14149c.getContext())) {
                    this.u = l.k(this.f14149c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14153g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.f14149c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f14153g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = eVar.f13853h;
                this.l = eVar.f13850e;
                this.y = str;
                this.x = j2;
                this.m = !TextUtils.isEmpty(eVar.f13852g) ? eVar.f13852g : eVar.f13851f;
                Object tag = this.f14150d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.o1().cover) && !((String) tag).equals(this.n.o1().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.o1().cover) && !this.p.equals(this.n.o1().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str2 = this.n.o1().cover;
                this.p = str2;
                this.f14150d.setTag(str2);
                this.f14150d.startLoad(this.n.o1().cover, 10, false);
                this.f14150d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.S2)) {
                    this.v.setVisibility(0);
                    this.v.startLoad(this.n.S2, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f14152f.setText(this.f14148b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.o1().audience_count)));
                if (this.n.J() != null) {
                    String name_show = this.n.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f14154h.setText(name_show);
                }
                int i3 = 5;
                if (!StringUtils.isNull(this.n.c1)) {
                    this.f14155i.setVisibility(0);
                    this.f14156j.setVisibility(8);
                    this.f14155i.setText(this.n.c1);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.f14148b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.f14155i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.o1().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.f14148b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.o1().label.f12945b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.o1().label.f12945b));
                    }
                    this.f14155i.setBackgroundDrawable(gradientDrawable2);
                    this.f14155i.setText(this.n.o1().label.a);
                    this.f14155i.setVisibility(0);
                    this.f14156j.setVisibility(8);
                } else if (this.n.o1().mChallengeInfoData != null && this.n.o1().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.f14148b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.f14156j.setBackground(gradientDrawable3);
                    this.f14156j.setVisibility(0);
                    this.f14155i.setVisibility(8);
                } else {
                    this.f14155i.setVisibility(8);
                    this.f14156j.setVisibility(8);
                }
                if (this.n.o1().haveRedpkg) {
                    this.f14157k.setVisibility(0);
                } else {
                    this.f14157k.setVisibility(8);
                }
                if (this.n != null) {
                    String str3 = TiebaStatic.YYValues.YY_LIVE;
                    if (i2 == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.v1());
                        param.param("fid", this.x);
                        param.param("fname", this.y);
                        if (this.n.o1() == null || !this.n.o1().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            i3 = YYLiveUtil.calculateLiveType(this.n.o1());
                            TiebaStaticHelper.addYYParam(param, this.n.o1().mYyExtData);
                        }
                        param.param("obj_param1", i3);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i2 == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.v1());
                        param2.param("fid", this.x);
                        param2.param("fname", this.y);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(this.n.o1());
                        if (this.n.o1() == null || !this.n.o1().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, this.n.o1().mYyExtData);
                        }
                        param2.param("obj_param1", calculateLiveType);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.f14148b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14153g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14152f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14154h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14155i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.f14148b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f14148b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f14148b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f14152f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f14148b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.a = i2;
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }
}
