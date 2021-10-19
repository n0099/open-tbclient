package c.a.r0.w.f.c.f.d;

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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25821a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25822b;

    /* renamed from: c  reason: collision with root package name */
    public View f25823c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f25824d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25825e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f25826f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25827g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f25828h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f25829i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f25830j;
    public d2 k;
    public c.a.r0.w.f.a.c l;
    public i m;
    public String n;
    public boolean o;
    public AlphaAnimation p;
    public boolean q;
    public boolean r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f25831a;

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
            this.f25831a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f25831a.r = false;
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
                this.f25831a.r = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f25832a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f25833b;

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
            this.f25833b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f25833b.o && !this.f25833b.r) {
                if (StringUtils.isNull(this.f25832a) || !this.f25832a.equals(str)) {
                    c cVar = this.f25833b;
                    cVar.f25824d.startAnimation(cVar.p);
                    this.f25832a = str;
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

    /* renamed from: c.a.r0.w.f.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1203c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25834e;

        public View$OnClickListenerC1203c(c cVar) {
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
            this.f25834e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25834e.l == null || this.f25834e.l.f25667h == null || this.f25834e.m == null) {
                        return;
                    }
                    this.f25834e.m.a(this.f25834e.l);
                    return;
                }
                l.J(this.f25834e.f25822b.getPageActivity(), this.f25834e.f25822b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1882828444, "Lc/a/r0/w/f/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1882828444, "Lc/a/r0/w/f/c/f/d/c;");
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
        this.f25821a = 3;
        this.f25830j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1203c(this);
        this.f25822b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f25823c = inflate;
        this.f25824d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f25825e = (TextView) this.f25823c.findViewById(R.id.tvLiveCount);
        this.f25826f = (RelativeLayout) this.f25823c.findViewById(R.id.rlSquareLivePanel);
        this.f25827g = (TextView) this.f25823c.findViewById(R.id.tvUserName);
        this.f25828h = (LinearLayout) this.f25823c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f25823c.findViewById(R.id.ivUserAvatar);
        this.f25829i = headImageView;
        headImageView.setIsRound(true);
        this.f25829i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f25823c.setOnClickListener(this.s);
        this.f25824d.setBorderSurroundContent(true);
        this.f25824d.setDrawBorder(true);
        this.f25824d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25826f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f25826f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25823c : (View) invokeV.objValue;
    }

    public void i(c.a.r0.w.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            j(cVar, -1);
        }
    }

    public void j(c.a.r0.w.f.a.c cVar, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            if (cVar != null && (d2Var = cVar.f25667h) != null && d2Var.l1() != null) {
                h().setVisibility(0);
                this.l = cVar;
                this.k = cVar.f25667h;
                int i3 = cVar.f25664e;
                if (TextUtils.isEmpty(cVar.f25666g)) {
                    String str = cVar.f25665f;
                } else {
                    String str2 = cVar.f25666g;
                }
                Object tag = this.f25824d.getTag();
                if (this.q) {
                    this.o = true;
                    this.q = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.l1().cover) && !((String) tag).equals(this.k.l1().cover)) {
                    this.o = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.l1().cover) && !this.n.equals(this.k.l1().cover)) {
                    this.o = true;
                } else {
                    this.o = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f25830j);
                String str3 = this.k.l1().cover;
                this.n = str3;
                this.f25824d.setTag(str3);
                if (cVar.f25669j) {
                    this.f25824d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f25824d.setPlaceHolder(3);
                } else if (cVar.k) {
                    this.f25824d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f25824d.setPlaceHolder(3);
                } else if (cVar.l) {
                    this.f25824d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f25824d.setPlaceHolder(3);
                }
                this.f25824d.setRadius((int) t);
                this.f25824d.startLoad(this.k.l1().cover, 10, false);
                this.f25828h.setBackgroundDrawable(gradientDrawable);
                this.f25824d.setEvent(new b(this));
                this.f25825e.setText(this.f25822b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.l1().audience_count)));
                if (this.k.J() != null) {
                    String name_show = this.k.J().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f25827g.setText(name_show);
                    }
                    this.f25829i.startLoad(this.k.J().getPortrait(), 12, false);
                }
                k(this.f25822b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f25821a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f25825e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25827g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f25829i.setBorderColor(this.f25822b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f25829i.setBorderColor(this.f25822b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f25822b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f25822b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f25822b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f25825e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f25825e.setCompoundDrawablePadding(this.f25822b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.f25821a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
