package b.a.r0.x0.r1;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.q2.c;
import b.a.r0.q2.p;
import b.a.r0.x0.r1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.x0.r1.g> implements b.a.r0.x0.r1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public b.a.r0.q2.c C;
    public TbPageContext<?> D;
    public b.a.r0.x0.r1.g E;
    public int F;
    public h G;
    public p H;
    public p I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Animation N;
    public Animation O;
    public ScaleAnimation P;
    public boolean Q;
    public boolean R;
    public FrameLayout m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public HeadImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ImageView y;
    public ImageView z;

    /* loaded from: classes5.dex */
    public class a implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26238a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26238a = bVar;
        }

        @Override // b.a.r0.q2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f26238a.C.T0()) {
                this.f26238a.p.setVisibility(8);
            }
        }

        @Override // b.a.r0.q2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f26238a.C.T0()) {
                    this.f26238a.p.setVisibility(8);
                }
                if (this.f26238a.M) {
                    this.f26238a.C.k2();
                }
            }
        }
    }

    /* renamed from: b.a.r0.x0.r1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1288b implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26239a;

        public C1288b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26239a = bVar;
        }

        @Override // b.a.r0.q2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26239a.p.setVisibility(8);
                b bVar = this.f26239a;
                bVar.onClick(bVar.m);
            }
        }

        @Override // b.a.r0.q2.c.g0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26239a.M = false;
                this.f26239a.p.setVisibility(8);
                b bVar = this.f26239a;
                bVar.M(bVar.Q ? "1" : "2");
                b bVar2 = this.f26239a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26240a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26240a = bVar;
        }

        @Override // b.a.r0.q2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f26240a.D.showToast(this.f26240a.r.getText().toString());
                    b bVar = this.f26240a;
                    b.a.r0.q2.c cVar = bVar.C;
                    b.a.r0.x0.r1.g gVar = bVar.E;
                    cVar.d2(gVar.z.f26283d, gVar.f26256f);
                    this.f26240a.p.setVisibility(8);
                    this.f26240a.M("2");
                } else {
                    this.f26240a.q.setVisibility(0);
                }
                b bVar2 = this.f26240a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26241a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26241a = bVar;
        }

        @Override // b.a.r0.q2.c.y
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f26241a.C.T0()) {
                    this.f26241a.o.setVisibility(0);
                } else if (z) {
                    if (this.f26241a.o.getVisibility() == 0) {
                        this.f26241a.o.setVisibility(8);
                        b bVar = this.f26241a;
                        bVar.o.startAnimation(bVar.N);
                    }
                } else if (this.f26241a.o.getVisibility() == 8) {
                    this.f26241a.o.setVisibility(0);
                    b bVar2 = this.f26241a;
                    bVar2.o.startAnimation(bVar2.O);
                }
            }
        }

        @Override // b.a.r0.q2.c.y
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.f26241a.C.T0()) {
                    this.f26241a.o.setVisibility(0);
                } else if (this.f26241a.o.getVisibility() == 0) {
                    this.f26241a.o.setVisibility(8);
                    b bVar = this.f26241a;
                    bVar.o.startAnimation(bVar.N);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.x0.r1.a f26242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26243f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f26244g;

        public e(b bVar, b.a.r0.x0.r1.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26244g = bVar;
            this.f26242e = aVar;
            this.f26243f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26244g.L) {
                    this.f26244g.M = true;
                    this.f26244g.K = false;
                }
                if (this.f26242e == null || this.f26244g.L) {
                    return;
                }
                this.f26242e.a(this.f26243f);
                this.f26244g.C.a1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.x0.r1.a f26245e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f26246f;

        public f(b bVar, b.a.r0.x0.r1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26246f = bVar;
            this.f26245e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                b.a.r0.x0.r1.g gVar = this.f26246f.E;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f26246f.E.z.f26283d);
                }
                b.a.r0.x0.r1.a aVar = this.f26245e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26247a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26247a = bVar;
        }

        @Override // b.a.r0.q2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26247a.p.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = true;
        this.R = z;
        View i4 = i();
        this.D = tbPageContext;
        this.m = (FrameLayout) i4.findViewById(R.id.video_agg_container);
        FrameLayout frameLayout = (FrameLayout) i4.findViewById(R.id.video_container);
        this.n = frameLayout;
        b.a.r0.q2.c cVar = new b.a.r0.q2.c(tbPageContext, frameLayout, false);
        this.C = cVar;
        cVar.O1("2005");
        this.o = (TextView) i4.findViewById(R.id.title);
        this.p = (TextView) i4.findViewById(R.id.duration);
        this.q = (FrameLayout) i4.findViewById(R.id.mobile_network_container);
        this.r = (TextView) i4.findViewById(R.id.mobile_network_text);
        this.s = (TextView) i4.findViewById(R.id.mobile_network_play);
        this.t = (HeadImageView) i4.findViewById(R.id.user_icon);
        this.u = (TextView) i4.findViewById(R.id.user_name);
        this.v = (TextView) i4.findViewById(R.id.attention);
        this.A = (LinearLayout) i4.findViewById(R.id.thread_info_commont_container);
        this.B = (LinearLayout) i4.findViewById(R.id.agree_view_container);
        this.w = (TextView) i4.findViewById(R.id.thread_info_commont_num);
        this.x = (TextView) i4.findViewById(R.id.thread_info_praise_num);
        this.y = (ImageView) i4.findViewById(R.id.thread_info_commont_img);
        this.z = (ImageView) i4.findViewById(R.id.thread_info_praise_img);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        i4.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.F = l.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.F * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.t.setIsRound(true);
        this.G = new h(this.D, this);
        this.N = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.O = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: A */
    public void j(b.a.r0.x0.r1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
        }
    }

    public void B(b.a.r0.x0.r1.g gVar, int i2, b.a.r0.x0.r1.a aVar) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.E = gVar;
        this.Q = gVar.F;
        this.o.setVisibility(0);
        this.o.setText(gVar.x);
        this.p.setVisibility(0);
        this.p.setText(StringHelper.stringForVideoTime(gVar.z.f26284e * 1000));
        long j = gVar.z.f26287h;
        if (j == 0) {
            format = this.D.getString(R.string.video_mobile_play_tips);
        } else {
            format = String.format(this.D.getString(R.string.video_mobile_network_tips), T(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.r.setText(format);
        this.q.setVisibility(8);
        z(gVar, i2, aVar);
        P(gVar);
        k(this.D, TbadkCoreApplication.getInst().getSkinType());
    }

    public void D(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) || this.C == null || this.n == null || (tbPageContext = this.D) == null || tbPageContext.getPageActivity() == null || this.D.getPageActivity().getWindow() == null || !(this.D.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.D.getPageActivity().getWindow().getDecorView();
        if (this.K) {
            this.C.k1();
        }
        if (configuration.orientation == 2) {
            this.L = true;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent = this.n.getParent();
                    FrameLayout frameLayout2 = this.m;
                    if (parent == frameLayout2) {
                        frameLayout2.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            frameLayout.addView(this.n);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        } else {
            this.L = false;
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    frameLayout.removeView(this.n);
                } else {
                    ViewParent parent2 = this.n.getParent();
                    FrameLayout frameLayout3 = this.m;
                    if (parent2 == frameLayout3) {
                        frameLayout3.removeView(this.n);
                    }
                }
            }
            if (this.n.getParent() != null) {
                return;
            }
            this.m.addView(this.n, 0);
            int i2 = this.F;
            this.n.setLayoutParams(new FrameLayout.LayoutParams(i2, (int) (i2 * 0.5625f)));
            this.C.q0();
            this.K = true;
        }
        this.C.V0(this.D, configuration);
        this.p.setVisibility(8);
    }

    public boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.C.f1(i2) : invokeI.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isPlaying()) {
            this.C.W0();
        }
    }

    public void K() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.C) == null) {
            return;
        }
        cVar.v0();
    }

    public final void M(String str) {
        b.a.r0.x0.r1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (gVar = this.E) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            b.a.r0.q2.h.e(this.E.z.f26282c, "", str, this.I, this.C.I0().getPcdnState());
        }
    }

    public void O(b.a.r0.x0.r1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || gVar == null || gVar.y == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.y.f26266a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.y.f26266a)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (gVar.y.f26270e) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            this.v.setCompoundDrawables(null, null, null, null);
            this.v.setText(this.D.getString(R.string.relate_forum_is_followed));
            return;
        }
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, l.g(this.f14738g, R.dimen.ds20), l.g(this.f14738g, R.dimen.ds20));
        this.v.setCompoundDrawables(drawable, null, null, null);
        this.v.setText(this.D.getString(R.string.attention));
    }

    public void P(b.a.r0.x0.r1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.u.setText(TextUtils.isEmpty(bVar.f26268c) ? gVar.y.f26267b : gVar.y.f26268c);
        this.t.startLoad(gVar.y.f26269d, 12, false);
        this.t.setShowV(gVar.y.f26271f);
        this.t.setIsBigV(gVar.y.f26271f);
        O(gVar);
        R(gVar);
        Q(gVar);
    }

    public void Q(b.a.r0.x0.r1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
        this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.w.setText(StringHelper.numFormatOverWan(gVar.k));
    }

    public void R(b.a.r0.x0.r1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.p) {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
        } else {
            this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
        }
        this.x.setText(StringHelper.numFormatOverWan(gVar.m));
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.q.setVisibility(8);
            this.C.k2();
            TextView textView = this.o;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public String T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str : (String) invokeL.objValue;
    }

    @Override // b.a.r0.x0.r1.c
    public void b() {
        b.a.r0.x0.r1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gVar = this.E) == null) {
            return;
        }
        boolean z = !gVar.p;
        gVar.p = z;
        if (z) {
            gVar.m++;
        } else {
            gVar.m--;
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.startAnimation(y());
        }
        R(this.E);
    }

    @Override // b.a.r0.x0.r1.c
    public void c(boolean z) {
        b.a.r0.x0.r1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (gVar = this.E) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f26270e = z;
        O(gVar);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.card_video_aggregation_layout : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.C.T0() : invokeV.booleanValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, tbPageContext, i2) == null) {
            if (this.f14736e != i2) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(i());
                SkinManager.setBackgroundColor(i(), R.color.CAM_X0201);
                b.a.r0.x0.r1.g gVar = this.E;
                if (gVar != null && (bVar = gVar.y) != null) {
                    if (bVar.f26270e) {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
                        this.v.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, l.g(this.f14738g, R.dimen.ds20), l.g(this.f14738g, R.dimen.ds20));
                        this.v.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                b.a.r0.x0.r1.g gVar2 = this.E;
                if (gVar2 != null) {
                    if (gVar2.p) {
                        this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.x, R.color.CAM_X0301);
                    } else {
                        this.z.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.x, R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
                this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.f14736e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            if (f() != null) {
                view.setTag(this);
                f().a(view, this.E);
            }
            if (view != this.t && view != this.u) {
                if (view != this.A && view != this.o && view != i()) {
                    if (view == this.s) {
                        b.a.r0.x0.r1.g gVar = this.E;
                        if (gVar == null || gVar.z == null) {
                            return;
                        }
                        this.q.setVisibility(8);
                        this.C.j1();
                        b.a.r0.q2.c cVar = this.C;
                        b.a.r0.x0.r1.g gVar2 = this.E;
                        cVar.d2(gVar2.z.f26283d, gVar2.f26256f);
                        M("2");
                        return;
                    } else if (view == this.v) {
                        b.a.r0.x0.r1.g gVar3 = this.E;
                        if (gVar3.y.f26270e) {
                            return;
                        }
                        this.G.c(gVar3);
                        return;
                    } else if (view == this.B) {
                        b.a.q0.m0.c k = TbPageExtraHelper.k(getContext());
                        if (k != null) {
                            this.E.u = k.a();
                        }
                        this.G.d(this.E);
                        return;
                    } else {
                        return;
                    }
                } else if (this.E == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f14738g);
                    pbActivityConfig.createNormalCfg(this.E.f26256f, null, null);
                    if (!this.R) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            b.a.r0.x0.r1.g gVar4 = this.E;
            if (gVar4 == null || (bVar = gVar4.y) == null || TextUtils.isEmpty(bVar.f26266a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.E.y.f26266a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.D.getPageActivity()).createNormalConfig(b.a.e.e.m.b.g(this.E.y.f26266a, 0L), z, this.E.y.f26271f)));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            K();
            h hVar = this.G;
            if (hVar != null) {
                hVar.b();
            }
        }
    }

    @Override // b.a.r0.x0.r1.c
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.D.showToast(str);
        }
    }

    public final Animation y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.P == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.P = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.P;
        }
        return (Animation) invokeV.objValue;
    }

    public final void z(b.a.r0.x0.r1.g gVar, int i2, b.a.r0.x0.r1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048599, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.C.k2();
        this.C.s1(true);
        this.C.v1(false);
        this.C.y1(new a(this));
        this.C.G1(new C1288b(this));
        this.C.A1(new c(this));
        this.C.o1(false);
        p pVar = new p();
        this.H = pVar;
        pVar.f22884c = gVar.f26256f;
        pVar.f22885d = gVar.f26255e;
        pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
        p pVar2 = new p();
        this.I = pVar2;
        pVar2.f22884c = gVar.f26256f;
        pVar2.f22885d = gVar.f26255e;
        pVar2.f22886e = TbadkCoreApplication.getCurrentAccount();
        if (this.R) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f26256f);
            statisticItem.param("nid", gVar.f26257g);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.f26255e);
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            p pVar3 = this.H;
            pVar3.f22888g = "auto_midpage";
            pVar3.f22882a = "13";
            pVar3.f22890i = "1";
            p pVar4 = this.I;
            pVar4.f22888g = "auto_midpage";
            pVar4.f22882a = "auto_midpage";
            pVar4.f22890i = "1";
        } else {
            p pVar5 = this.H;
            pVar5.f22890i = "frs_bavideotab";
            pVar5.f22882a = "12";
            p pVar6 = this.I;
            pVar6.f22890i = "frs_bavideotab";
            pVar6.f22882a = "frs_bavideotab";
        }
        g.c cVar = gVar.z;
        if (cVar != null) {
            p pVar7 = this.H;
            String str = cVar.f26282c;
            pVar7.m = str;
            this.I.m = str;
        }
        this.C.I0().setVideoStatData(this.H);
        this.C.q0();
        this.C.z1(new d(this));
        this.C.I1(new e(this, aVar, i2));
        this.C.J1(new f(this, aVar));
        this.C.S1(gVar.z.j);
        this.C.Y1(gVar.z.f26283d, gVar.f26256f);
        this.C.X1(gVar.x);
        this.C.D1(new g(this));
        this.C.a1();
        this.C.a2();
        if (gVar.F) {
            onClick(this.n);
            this.M = false;
            this.C.i2(gVar.z.f26283d, gVar.f26256f, null, new Object[0]);
        }
        this.M = false;
    }
}
