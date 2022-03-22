package c.a.p0.c0.f.g.e.a;

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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import c.a.p0.c0.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f13089b;

    /* renamed from: c  reason: collision with root package name */
    public View f13090c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f13091d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13092e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13093f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f13094g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13095h;
    public TextView i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public ThreadData n;
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

    /* renamed from: c.a.p0.c0.f.g.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class animation.Animation$AnimationListenerC0986a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public animation.Animation$AnimationListenerC0986a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f13096b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13096b = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f13096b.q && !this.f13096b.t) {
                if (StringUtils.isNull(this.a) || !this.a.equals(str)) {
                    a aVar = this.f13096b;
                    aVar.f13091d.startAnimation(aVar.r);
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                layoutParams.rightMargin = this.a.f13089b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
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

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.a.n == null || this.a.n.getThreadAlaInfo() == null || this.a.o == null) {
                        return;
                    }
                    this.a.o.a(this.a.l, this.a.m, this.a.n);
                    return;
                }
                n.K(this.a.f13089b.getPageActivity(), this.a.f13089b.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c4c));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f13089b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d010c, (ViewGroup) null, false);
        this.f13090c = inflate;
        this.f13091d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e97);
        this.f13092e = (TextView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f09216b);
        this.f13093f = (TextView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f09216a);
        this.f13094g = (RelativeLayout) this.f13090c.findViewById(R.id.obfuscated_res_0x7f091ac1);
        this.f13095h = (TextView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f092177);
        this.i = (TextView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f0921ab);
        this.j = (LinearLayout) this.f13090c.findViewById(R.id.obfuscated_res_0x7f0905de);
        this.f13090c.setOnClickListener(this.z);
        this.f13091d.setBorderSurroundContent(true);
        this.f13091d.setDrawBorder(true);
        this.k = (ImageView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f0912c0);
        this.v = (TbImageView) this.f13090c.findViewById(R.id.obfuscated_res_0x7f0912c6);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC0986a(this));
        this.w = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? (int) (this.w * (i2 / i)) : invokeII.intValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13090c : (View) invokeV.objValue;
    }

    public void n(c.a.p0.c0.f.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            o(cVar, -1, this.x, this.y);
        }
    }

    public void o(c.a.p0.c0.f.a.c cVar, int i, long j, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{cVar, Integer.valueOf(i), Long.valueOf(j), str}) == null) {
            if (cVar != null && (threadData = cVar.f12865d) != null && threadData.getThreadAlaInfo() != null) {
                if (this.u != n.k(this.f13090c.getContext())) {
                    this.u = n.k(this.f13090c.getContext());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13094g.getLayoutParams();
                    int dimensionPixelSize = (this.u - (this.f13090c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f13094g.setLayoutParams(layoutParams);
                }
                m().setVisibility(0);
                this.n = cVar.f12865d;
                this.l = cVar.a;
                this.y = str;
                this.x = j;
                this.m = !TextUtils.isEmpty(cVar.f12864c) ? cVar.f12864c : cVar.f12863b;
                Object tag = this.f13091d.getTag();
                if (this.s) {
                    this.q = true;
                    this.s = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.n.getThreadAlaInfo().cover) && !((String) tag).equals(this.n.getThreadAlaInfo().cover)) {
                    this.q = true;
                } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.getThreadAlaInfo().cover) && !this.p.equals(this.n.getThreadAlaInfo().cover)) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                String str2 = this.n.getThreadAlaInfo().cover;
                this.p = str2;
                this.f13091d.setTag(str2);
                this.f13091d.J(this.n.getThreadAlaInfo().cover, 10, false);
                this.f13091d.setEvent(new b(this));
                if (!StringUtils.isNull(this.n.modeUrl)) {
                    this.v.setVisibility(0);
                    this.v.J(this.n.modeUrl, 10, false);
                    this.v.setEvent(new c(this));
                } else {
                    this.v.setVisibility(8);
                }
                this.f13093f.setText(this.f13089b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11b4, StringHelper.numberUniformFormatExtra(this.n.getThreadAlaInfo().audience_count)));
                if (this.n.getAuthor() != null) {
                    String name_show = this.n.getAuthor().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f13095h.setText(name_show);
                }
                int i2 = 5;
                if (!StringUtils.isNull(this.n.mRecomExtra)) {
                    this.i.setVisibility(0);
                    this.j.setVisibility(8);
                    this.i.setText(this.n.mRecomExtra);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float dimensionPixelSize2 = this.f13089b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                    gradientDrawable.setColor(-50901);
                    this.i.setBackgroundDrawable(gradientDrawable);
                } else if (this.n.getThreadAlaInfo().label != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    float dimensionPixelSize3 = this.f13089b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                    if (!StringUtils.isNull(this.n.getThreadAlaInfo().label.f10864b)) {
                        gradientDrawable2.setColor(Color.parseColor(this.n.getThreadAlaInfo().label.f10864b));
                    }
                    this.i.setBackgroundDrawable(gradientDrawable2);
                    this.i.setText(this.n.getThreadAlaInfo().label.a);
                    this.i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (this.n.getThreadAlaInfo().mChallengeInfoData != null && this.n.getThreadAlaInfo().mChallengeInfoData.challenge_id > 0) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    float dimensionPixelSize4 = this.f13089b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                    gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                    gradientDrawable3.setColor(-50901);
                    this.j.setBackground(gradientDrawable3);
                    this.j.setVisibility(0);
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (this.n.getThreadAlaInfo().haveRedpkg) {
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (this.n != null) {
                    String str3 = TiebaStatic.YYValues.YY_LIVE;
                    if (i == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.n.getTid());
                        param.param("fid", this.x);
                        param.param("fname", this.y);
                        if (this.n.getThreadAlaInfo() == null || !this.n.getThreadAlaInfo().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            i2 = YYLiveUtil.calculateLiveType(this.n.getThreadAlaInfo());
                            TiebaStaticHelper.addYYParam(param, this.n.getThreadAlaInfo().mYyExtData);
                        }
                        param.param("obj_param1", i2);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.getTid());
                        param2.param("fid", this.x);
                        param2.param("fname", this.y);
                        int calculateLiveType = YYLiveUtil.calculateLiveType(this.n.getThreadAlaInfo());
                        if (this.n.getThreadAlaInfo() == null || !this.n.getThreadAlaInfo().isLegalYYLiveData()) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, this.n.getThreadAlaInfo().mYyExtData);
                        }
                        param2.param("obj_param1", calculateLiveType);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param2);
                    }
                }
                p(this.f13089b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            m().setVisibility(4);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.f13094g, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f13093f, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13095h, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0111, 1, 0);
        SkinManager.getDrawable(this.f13089b.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f13089b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f13089b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
        this.f13093f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f13089b.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
        this.a = i;
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }
}
