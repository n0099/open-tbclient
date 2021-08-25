package c.a.q0.v.d.c.f.d;

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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25145a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25146b;

    /* renamed from: c  reason: collision with root package name */
    public View f25147c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f25148d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25149e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25150f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25151g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25152h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f25153i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f25154j;
    public c2 k;
    public c.a.q0.v.d.a.c l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f25155a;

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
            this.f25155a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f25155a.r = false;
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
                this.f25155a.r = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f25156a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f25157b;

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
            this.f25157b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f25157b.o && !this.f25157b.r) {
                if (StringUtils.isNull(this.f25156a) || !this.f25156a.equals(str)) {
                    c cVar = this.f25157b;
                    cVar.f25148d.startAnimation(cVar.p);
                    this.f25156a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.v.d.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1172c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25158e;

        public View$OnClickListenerC1172c(c cVar) {
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
            this.f25158e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25158e.l == null || this.f25158e.l.f24991h == null || this.f25158e.m == null) {
                        return;
                    }
                    this.f25158e.m.a(this.f25158e.l);
                    return;
                }
                l.J(this.f25158e.f25146b.getPageActivity(), this.f25158e.f25146b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168531334, "Lc/a/q0/v/d/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1168531334, "Lc/a/q0/v/d/c/f/d/c;");
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
        this.f25145a = 3;
        this.f25154j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1172c(this);
        this.f25146b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f25147c = inflate;
        this.f25148d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f25149e = (TextView) this.f25147c.findViewById(R.id.tvLiveCount);
        this.f25150f = (RelativeLayout) this.f25147c.findViewById(R.id.rlSquareLivePanel);
        this.f25151g = (TextView) this.f25147c.findViewById(R.id.tvUserName);
        this.f25152h = (LinearLayout) this.f25147c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f25147c.findViewById(R.id.ivUserAvatar);
        this.f25153i = headImageView;
        headImageView.setIsRound(true);
        this.f25153i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f25147c.setOnClickListener(this.s);
        this.f25148d.setBorderSurroundContent(true);
        this.f25148d.setDrawBorder(true);
        this.f25148d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25150f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f25150f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25147c : (View) invokeV.objValue;
    }

    public void i(c.a.q0.v.d.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            j(cVar, -1);
        }
    }

    public void j(c.a.q0.v.d.a.c cVar, int i2) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            if (cVar != null && (c2Var = cVar.f24991h) != null && c2Var.j1() != null) {
                h().setVisibility(0);
                this.l = cVar;
                this.k = cVar.f24991h;
                int i3 = cVar.f24988e;
                if (TextUtils.isEmpty(cVar.f24990g)) {
                    String str = cVar.f24989f;
                } else {
                    String str2 = cVar.f24990g;
                }
                Object tag = this.f25148d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.j1().cover) && !((String) tag).equals(this.k.j1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.j1().cover) && !this.n.equals(this.k.j1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f25154j);
                String str3 = this.k.j1().cover;
                this.n = str3;
                this.f25148d.setTag(str3);
                if (cVar.f24993j) {
                    this.f25148d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f25148d.setPlaceHolder(3);
                } else if (cVar.k) {
                    this.f25148d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f25148d.setPlaceHolder(3);
                } else if (cVar.l) {
                    this.f25148d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f25148d.setPlaceHolder(3);
                }
                this.f25148d.setRadius((int) t);
                this.f25148d.startLoad(this.k.j1().cover, 10, false);
                this.f25152h.setBackgroundDrawable(gradientDrawable);
                this.f25148d.setEvent(new b(this));
                this.f25149e.setText(this.f25146b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.j1().audience_count)));
                if (this.k.J() != null) {
                    String name_show = this.k.J().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f25151g.setText(name_show);
                    }
                    this.f25153i.startLoad(this.k.J().getPortrait(), 12, false);
                }
                k(this.f25146b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f25145a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f25149e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25151g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f25153i.setBorderColor(this.f25146b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f25153i.setBorderColor(this.f25146b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f25146b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f25146b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f25146b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f25149e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f25149e.setCompoundDrawablePadding(this.f25146b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.f25145a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
