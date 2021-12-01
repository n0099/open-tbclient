package c.a.r0.a0.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f13995b;

    /* renamed from: c  reason: collision with root package name */
    public View f13996c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f13997d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13998e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f13999f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14000g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f14001h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f14002i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f14003j;

    /* renamed from: k  reason: collision with root package name */
    public d2 f14004k;
    public c.a.r0.a0.f.a.e l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.r = false;
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
                this.a.r = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14005b;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14005b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f14005b.o && !this.f14005b.r) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    c cVar = this.f14005b;
                    cVar.f13997d.startAnimation(cVar.p);
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

    /* renamed from: c.a.r0.a0.f.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0848c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14006e;

        public View$OnClickListenerC0848c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14006e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f14006e.l == null || this.f14006e.l.f13853h == null || this.f14006e.m == null) {
                        return;
                    }
                    this.f14006e.m.a(this.f14006e.l);
                    return;
                }
                l.J(this.f14006e.f13995b.getPageActivity(), this.f14006e.f13995b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1769911222, "Lc/a/r0/a0/f/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1769911222, "Lc/a/r0/a0/f/c/f/d/c;");
                return;
            }
        }
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        t = dimension;
        u = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f14003j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC0848c(this);
        this.f13995b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f13996c = inflate;
        this.f13997d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f13998e = (TextView) this.f13996c.findViewById(R.id.tvLiveCount);
        this.f13999f = (RelativeLayout) this.f13996c.findViewById(R.id.rlSquareLivePanel);
        this.f14000g = (TextView) this.f13996c.findViewById(R.id.tvUserName);
        this.f14001h = (LinearLayout) this.f13996c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f13996c.findViewById(R.id.ivUserAvatar);
        this.f14002i = headImageView;
        headImageView.setIsRound(true);
        this.f14002i.setBorderWidth(l.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f13996c.setOnClickListener(this.s);
        this.f13997d.setBorderSurroundContent(true);
        this.f13997d.setDrawBorder(true);
        this.f13997d.setBorderWidth(l.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13999f.getLayoutParams();
        int k2 = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k2;
        layoutParams.height = k2;
        this.f13999f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13996c : (View) invokeV.objValue;
    }

    public void i(c.a.r0.a0.f.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            j(eVar, -1);
        }
    }

    public void j(c.a.r0.a0.f.a.e eVar, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (eVar != null && (d2Var = eVar.f13853h) != null && d2Var.o1() != null) {
                h().setVisibility(0);
                this.l = eVar;
                this.f14004k = eVar.f13853h;
                int i3 = eVar.f13850e;
                if (TextUtils.isEmpty(eVar.f13852g)) {
                    String str = eVar.f13851f;
                } else {
                    String str2 = eVar.f13852g;
                }
                Object tag = this.f13997d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.f14004k.o1().cover) && !((String) tag).equals(this.f14004k.o1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.f14004k.o1().cover) && !this.n.equals(this.f14004k.o1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f14003j);
                String str3 = this.f14004k.o1().cover;
                this.n = str3;
                this.f13997d.setTag(str3);
                if (eVar.f13856k) {
                    this.f13997d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f13997d.setPlaceHolder(3);
                } else if (eVar.l) {
                    this.f13997d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f13997d.setPlaceHolder(3);
                } else if (eVar.m) {
                    this.f13997d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f13997d.setPlaceHolder(3);
                }
                this.f13997d.setRadius((int) t);
                this.f13997d.startLoad(this.f14004k.o1().cover, 10, false);
                this.f14001h.setBackgroundDrawable(gradientDrawable);
                this.f13997d.setEvent(new b(this));
                this.f13998e.setText(this.f13995b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.f14004k.o1().audience_count)));
                if (this.f14004k.J() != null) {
                    String name_show = this.f14004k.J().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f14000g.setText(name_show);
                    }
                    this.f14002i.startLoad(this.f14004k.J().getPortrait(), 12, false);
                }
                k(this.f13995b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f13998e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14000g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f14002i.setBorderColor(this.f13995b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f14002i.setBorderColor(this.f13995b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f13995b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f13995b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f13995b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f13998e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f13998e.setCompoundDrawablePadding(this.f13995b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
