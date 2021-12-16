package c.a.s0.a0.f.c.f.d;

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
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14335b;

    /* renamed from: c  reason: collision with root package name */
    public View f14336c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f14337d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14338e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f14339f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14340g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f14341h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f14342i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f14343j;

    /* renamed from: k  reason: collision with root package name */
    public d2 f14344k;
    public c.a.s0.a0.f.a.e l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14345b;

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
            this.f14345b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f14345b.o && !this.f14345b.r) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    c cVar = this.f14345b;
                    cVar.f14337d.startAnimation(cVar.p);
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

    /* renamed from: c.a.s0.a0.f.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0884c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f14346e;

        public View$OnClickListenerC0884c(c cVar) {
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
            this.f14346e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    if (this.f14346e.l == null || this.f14346e.l.f14193h == null || this.f14346e.m == null) {
                        return;
                    }
                    this.f14346e.m.a(this.f14346e.l);
                    return;
                }
                m.J(this.f14346e.f14335b.getPageActivity(), this.f14346e.f14335b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1259377045, "Lc/a/s0/a0/f/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1259377045, "Lc/a/s0/a0/f/c/f/d/c;");
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
        this.f14343j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC0884c(this);
        this.f14335b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f14336c = inflate;
        this.f14337d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f14338e = (TextView) this.f14336c.findViewById(R.id.tvLiveCount);
        this.f14339f = (RelativeLayout) this.f14336c.findViewById(R.id.rlSquareLivePanel);
        this.f14340g = (TextView) this.f14336c.findViewById(R.id.tvUserName);
        this.f14341h = (LinearLayout) this.f14336c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f14336c.findViewById(R.id.ivUserAvatar);
        this.f14342i = headImageView;
        headImageView.setIsRound(true);
        this.f14342i.setBorderWidth(m.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f14336c.setOnClickListener(this.s);
        this.f14337d.setBorderSurroundContent(true);
        this.f14337d.setDrawBorder(true);
        this.f14337d.setBorderWidth(m.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14339f.getLayoutParams();
        int k2 = ((m.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k2;
        layoutParams.height = k2;
        this.f14339f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14336c : (View) invokeV.objValue;
    }

    public void i(c.a.s0.a0.f.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            j(eVar, -1);
        }
    }

    public void j(c.a.s0.a0.f.a.e eVar, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (eVar != null && (d2Var = eVar.f14193h) != null && d2Var.o1() != null) {
                h().setVisibility(0);
                this.l = eVar;
                this.f14344k = eVar.f14193h;
                int i3 = eVar.f14190e;
                if (TextUtils.isEmpty(eVar.f14192g)) {
                    String str = eVar.f14191f;
                } else {
                    String str2 = eVar.f14192g;
                }
                Object tag = this.f14337d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.f14344k.o1().cover) && !((String) tag).equals(this.f14344k.o1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.f14344k.o1().cover) && !this.n.equals(this.f14344k.o1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f14343j);
                String str3 = this.f14344k.o1().cover;
                this.n = str3;
                this.f14337d.setTag(str3);
                if (eVar.f14196k) {
                    this.f14337d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f14337d.setPlaceHolder(3);
                } else if (eVar.l) {
                    this.f14337d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f14337d.setPlaceHolder(3);
                } else if (eVar.m) {
                    this.f14337d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f14337d.setPlaceHolder(3);
                }
                this.f14337d.setRadius((int) t);
                this.f14337d.startLoad(this.f14344k.o1().cover, 10, false);
                this.f14341h.setBackgroundDrawable(gradientDrawable);
                this.f14337d.setEvent(new b(this));
                this.f14338e.setText(this.f14335b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.f14344k.o1().audience_count)));
                if (this.f14344k.J() != null) {
                    String name_show = this.f14344k.J().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f14340g.setText(name_show);
                    }
                    this.f14342i.startLoad(this.f14344k.J().getPortrait(), 12, false);
                }
                k(this.f14335b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setViewTextColor(this.f14338e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14340g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f14342i.setBorderColor(this.f14335b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f14342i.setBorderColor(this.f14335b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f14335b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f14335b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f14335b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f14338e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f14338e.setCompoundDrawablePadding(this.f14335b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
