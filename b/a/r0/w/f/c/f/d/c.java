package b.a.r0.w.f.c.f.d;

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
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
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

    /* renamed from: a  reason: collision with root package name */
    public int f24663a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f24664b;

    /* renamed from: c  reason: collision with root package name */
    public View f24665c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f24666d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24667e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f24668f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24669g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24670h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f24671i;
    public int[] j;
    public d2 k;
    public b.a.r0.w.f.a.e l;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24672a;

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
            this.f24672a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f24672a.r = false;
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
                this.f24672a.r = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f24673a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f24674b;

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
            this.f24674b = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f24674b.o && !this.f24674b.r) {
                if (StringUtils.isNull(this.f24673a) || !this.f24673a.equals(str)) {
                    c cVar = this.f24674b;
                    cVar.f24666d.startAnimation(cVar.p);
                    this.f24673a = str;
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

    /* renamed from: b.a.r0.w.f.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1204c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24675e;

        public View$OnClickListenerC1204c(c cVar) {
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
            this.f24675e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f24675e.l == null || this.f24675e.l.f24510h == null || this.f24675e.m == null) {
                        return;
                    }
                    this.f24675e.m.a(this.f24675e.l);
                    return;
                }
                l.J(this.f24675e.f24664b.getPageActivity(), this.f24675e.f24664b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1038356573, "Lb/a/r0/w/f/c/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1038356573, "Lb/a/r0/w/f/c/f/d/c;");
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
        this.f24663a = 3;
        this.j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = false;
        this.q = true;
        this.r = false;
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1204c(this);
        this.f24664b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f24665c = inflate;
        this.f24666d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f24667e = (TextView) this.f24665c.findViewById(R.id.tvLiveCount);
        this.f24668f = (RelativeLayout) this.f24665c.findViewById(R.id.rlSquareLivePanel);
        this.f24669g = (TextView) this.f24665c.findViewById(R.id.tvUserName);
        this.f24670h = (LinearLayout) this.f24665c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f24665c.findViewById(R.id.ivUserAvatar);
        this.f24671i = headImageView;
        headImageView.setIsRound(true);
        this.f24671i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f24665c.setOnClickListener(this.s);
        this.f24666d.setBorderSurroundContent(true);
        this.f24666d.setDrawBorder(true);
        this.f24666d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24668f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f24668f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a(this));
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24665c : (View) invokeV.objValue;
    }

    public void i(b.a.r0.w.f.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            j(eVar, -1);
        }
    }

    public void j(b.a.r0.w.f.a.e eVar, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (eVar != null && (d2Var = eVar.f24510h) != null && d2Var.l1() != null) {
                h().setVisibility(0);
                this.l = eVar;
                this.k = eVar.f24510h;
                int i3 = eVar.f24507e;
                if (TextUtils.isEmpty(eVar.f24509g)) {
                    String str = eVar.f24508f;
                } else {
                    String str2 = eVar.f24509g;
                }
                Object tag = this.f24666d.getTag();
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
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
                String str3 = this.k.l1().cover;
                this.n = str3;
                this.f24666d.setTag(str3);
                if (eVar.k) {
                    this.f24666d.setConrers(5);
                    gradientDrawable.setCornerRadii(v);
                    this.f24666d.setPlaceHolder(3);
                } else if (eVar.l) {
                    this.f24666d.setConrers(10);
                    gradientDrawable.setCornerRadii(w);
                    this.f24666d.setPlaceHolder(3);
                } else if (eVar.m) {
                    this.f24666d.setConrers(15);
                    gradientDrawable.setCornerRadii(u);
                    this.f24666d.setPlaceHolder(3);
                }
                this.f24666d.setRadius((int) t);
                this.f24666d.startLoad(this.k.l1().cover, 10, false);
                this.f24670h.setBackgroundDrawable(gradientDrawable);
                this.f24666d.setEvent(new b(this));
                this.f24667e.setText(this.f24664b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.l1().audience_count)));
                if (this.k.J() != null) {
                    String name_show = this.k.J().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.f24669g.setText(name_show);
                    }
                    this.f24671i.startLoad(this.k.J().getPortrait(), 12, false);
                }
                k(this.f24664b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f24663a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f24667e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f24669g, R.color.CAM_X0101);
        if (i2 == 1) {
            this.f24671i.setBorderColor(this.f24664b.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f24671i.setBorderColor(this.f24664b.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f24664b.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f24664b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f24664b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f24667e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f24667e.setCompoundDrawablePadding(this.f24664b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        this.f24663a = i2;
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.m = iVar;
        }
    }
}
