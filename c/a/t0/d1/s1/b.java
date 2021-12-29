package c.a.t0.d1.s1;

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
import c.a.d.f.p.n;
import c.a.t0.d1.s1.g;
import c.a.t0.z2.c;
import c.a.t0.z2.j;
import c.a.t0.z2.t;
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
/* loaded from: classes7.dex */
public class b extends c.a.t0.g0.b<c.a.t0.d1.s1.g> implements c.a.t0.d1.s1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public c.a.t0.z2.c C;
    public TbPageContext<?> D;
    public c.a.t0.d1.s1.g E;
    public int F;
    public h G;
    public t H;
    public t I;
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

    /* loaded from: classes7.dex */
    public class a implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.t0.z2.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C.T0()) {
                this.a.p.setVisibility(8);
            }
        }

        @Override // c.a.t0.z2.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.C.T0()) {
                    this.a.p.setVisibility(8);
                }
                if (this.a.M) {
                    this.a.C.j2();
                }
            }
        }
    }

    /* renamed from: c.a.t0.d1.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1031b implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1031b(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.t0.z2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.setVisibility(8);
                b bVar = this.a;
                bVar.onClick(bVar.m);
            }
        }

        @Override // c.a.t0.z2.c.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M = false;
                this.a.p.setVisibility(8);
                b bVar = this.a;
                bVar.H(bVar.Q ? "1" : "2");
                b bVar2 = this.a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.t0.z2.c.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.D.showToast(this.a.r.getText().toString());
                    b bVar = this.a;
                    c.a.t0.z2.c cVar = bVar.C;
                    c.a.t0.d1.s1.g gVar = bVar.E;
                    cVar.c2(gVar.z.f16889d, gVar.f16864f);
                    this.a.p.setVisibility(8);
                    this.a.H("2");
                } else {
                    this.a.q.setVisibility(0);
                }
                b bVar2 = this.a;
                bVar2.onClick(bVar2.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.t0.z2.c.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.C.T0()) {
                    this.a.o.setVisibility(0);
                } else if (z) {
                    if (this.a.o.getVisibility() == 0) {
                        this.a.o.setVisibility(8);
                        b bVar = this.a;
                        bVar.o.startAnimation(bVar.N);
                    }
                } else if (this.a.o.getVisibility() == 8) {
                    this.a.o.setVisibility(0);
                    b bVar2 = this.a;
                    bVar2.o.startAnimation(bVar2.O);
                }
            }
        }

        @Override // c.a.t0.z2.c.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.C.T0()) {
                    this.a.o.setVisibility(0);
                } else if (this.a.o.getVisibility() == 0) {
                    this.a.o.setVisibility(8);
                    b bVar = this.a;
                    bVar.o.startAnimation(bVar.N);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.a f16849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16850f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f16851g;

        public e(b bVar, c.a.t0.d1.s1.a aVar, int i2) {
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
            this.f16851g = bVar;
            this.f16849e = aVar;
            this.f16850f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f16851g.L) {
                    this.f16851g.M = true;
                    this.f16851g.K = false;
                }
                if (this.f16849e == null || this.f16851g.L) {
                    return;
                }
                this.f16849e.a(this.f16850f);
                this.f16851g.C.Z0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.a f16852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16853f;

        public f(b bVar, c.a.t0.d1.s1.a aVar) {
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
            this.f16853f = bVar;
            this.f16852e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                c.a.t0.d1.s1.g gVar = this.f16853f.E;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f16853f.E.z.f16889d);
                }
                c.a.t0.d1.s1.a aVar = this.f16852e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.t0.z2.c.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.setVisibility(8);
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
        View j2 = j();
        this.D = tbPageContext;
        this.m = (FrameLayout) j2.findViewById(R.id.video_agg_container);
        FrameLayout frameLayout = (FrameLayout) j2.findViewById(R.id.video_container);
        this.n = frameLayout;
        c.a.t0.z2.c cVar = new c.a.t0.z2.c(tbPageContext, frameLayout, false);
        this.C = cVar;
        cVar.N1("2005");
        this.o = (TextView) j2.findViewById(R.id.title);
        this.p = (TextView) j2.findViewById(R.id.duration);
        this.q = (FrameLayout) j2.findViewById(R.id.mobile_network_container);
        this.r = (TextView) j2.findViewById(R.id.mobile_network_text);
        this.s = (TextView) j2.findViewById(R.id.mobile_network_play);
        this.t = (HeadImageView) j2.findViewById(R.id.user_icon);
        this.u = (TextView) j2.findViewById(R.id.user_name);
        this.v = (TextView) j2.findViewById(R.id.attention);
        this.A = (LinearLayout) j2.findViewById(R.id.thread_info_commont_container);
        this.B = (LinearLayout) j2.findViewById(R.id.agree_view_container);
        this.w = (TextView) j2.findViewById(R.id.thread_info_commont_num);
        this.x = (TextView) j2.findViewById(R.id.thread_info_praise_num);
        this.y = (ImageView) j2.findViewById(R.id.thread_info_commont_img);
        this.z = (ImageView) j2.findViewById(R.id.thread_info_praise_img);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        j2.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.F = n.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.F * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.t.setIsRound(true);
        this.G = new h(this.D, this);
        this.N = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.O = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public final void A(c.a.t0.d1.s1.g gVar, int i2, c.a.t0.d1.s1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.C.j2();
        this.C.r1(true);
        this.C.u1(false);
        this.C.x1(new a(this));
        this.C.F1(new C1031b(this));
        this.C.z1(new c(this));
        this.C.n1(false);
        t tVar = new t();
        this.H = tVar;
        tVar.f26871c = gVar.f16864f;
        tVar.f26872d = gVar.f16863e;
        tVar.f26873e = TbadkCoreApplication.getCurrentAccount();
        t tVar2 = new t();
        this.I = tVar2;
        tVar2.f26871c = gVar.f16864f;
        tVar2.f26872d = gVar.f16863e;
        tVar2.f26873e = TbadkCoreApplication.getCurrentAccount();
        if (this.R) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f16864f);
            statisticItem.param("nid", gVar.f16865g);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.f16863e);
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            t tVar3 = this.H;
            tVar3.f26875g = "auto_midpage";
            tVar3.a = "13";
            tVar3.f26877i = "1";
            t tVar4 = this.I;
            tVar4.f26875g = "auto_midpage";
            tVar4.a = "auto_midpage";
            tVar4.f26877i = "1";
        } else {
            t tVar5 = this.H;
            tVar5.f26877i = "frs_bavideotab";
            tVar5.a = "12";
            t tVar6 = this.I;
            tVar6.f26877i = "frs_bavideotab";
            tVar6.a = "frs_bavideotab";
        }
        g.c cVar = gVar.z;
        if (cVar != null) {
            t tVar7 = this.H;
            String str = cVar.f16888c;
            tVar7.m = str;
            this.I.m = str;
        }
        this.C.I0().setVideoStatData(this.H);
        this.C.q0();
        this.C.y1(new d(this));
        this.C.H1(new e(this, aVar, i2));
        this.C.I1(new f(this, aVar));
        this.C.R1(gVar.z.f16895j);
        this.C.X1(gVar.z.f16889d, gVar.f16864f);
        this.C.W1(gVar.x);
        this.C.C1(new g(this));
        this.C.Z0();
        this.C.Z1();
        if (gVar.F) {
            onClick(this.n);
            this.M = false;
            this.C.h2(gVar.z.f16889d, gVar.f16864f, null, new Object[0]);
        }
        this.M = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: B */
    public void k(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
        }
    }

    public void C(c.a.t0.d1.s1.g gVar, int i2, c.a.t0.d1.s1.a aVar) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.E = gVar;
        this.Q = gVar.F;
        this.o.setVisibility(0);
        this.o.setText(gVar.x);
        this.p.setVisibility(0);
        this.p.setText(StringHelper.stringForVideoTime(gVar.z.f16890e * 1000));
        long j2 = gVar.z.f16893h;
        if (j2 == 0) {
            format = this.D.getString(R.string.video_mobile_play_tips);
        } else {
            format = String.format(this.D.getString(R.string.video_mobile_network_tips), N(String.format("%.1f", Float.valueOf(((float) j2) / 1048576.0f))));
        }
        this.r.setText(format);
        this.q.setVisibility(8);
        A(gVar, i2, aVar);
        J(gVar);
        l(this.D, TbadkCoreApplication.getInst().getSkinType());
    }

    public void D(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || this.C == null || this.n == null || (tbPageContext = this.D) == null || tbPageContext.getPageActivity() == null || this.D.getPageActivity().getWindow() == null || !(this.D.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.D.getPageActivity().getWindow().getDecorView();
        if (this.K) {
            this.C.j1();
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
        this.C.U0(this.D, configuration);
        this.p.setVisibility(8);
    }

    public boolean E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.C.e1(i2) : invokeI.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && isPlaying()) {
            this.C.V0();
        }
    }

    public void G() {
        c.a.t0.z2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.C) == null) {
            return;
        }
        cVar.v0();
    }

    public final void H(String str) {
        c.a.t0.d1.s1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (gVar = this.E) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            j.e(this.E.z.f16888c, "", str, this.I, this.C.I0().getPcdnState());
        }
    }

    public void I(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) || gVar == null || gVar.y == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.y.a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.y.a)) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        if (gVar.y.f16878e) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            this.v.setCompoundDrawables(null, null, null, null);
            this.v.setText(this.D.getString(R.string.relate_forum_is_followed));
            return;
        }
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, n.f(this.f18211g, R.dimen.ds20), n.f(this.f18211g, R.dimen.ds20));
        this.v.setCompoundDrawables(drawable, null, null, null);
        this.v.setText(this.D.getString(R.string.attention));
    }

    public void J(c.a.t0.d1.s1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.u.setText(TextUtils.isEmpty(bVar.f16876c) ? gVar.y.f16875b : gVar.y.f16876c);
        this.t.startLoad(gVar.y.f16877d, 12, false);
        this.t.setShowV(gVar.y.f16879f);
        this.t.setIsBigV(gVar.y.f16879f);
        I(gVar);
        L(gVar);
        K(gVar);
    }

    public void K(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106);
        this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.w.setText(StringHelper.numFormatOverWan(gVar.f16869k));
    }

    public void L(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) || gVar == null) {
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

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q.setVisibility(8);
            this.C.j2();
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

    public String N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str : (String) invokeL.objValue;
    }

    @Override // c.a.t0.d1.s1.c
    public void b() {
        c.a.t0.d1.s1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (gVar = this.E) == null) {
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
            imageView.startAnimation(z());
        }
        L(this.E);
    }

    @Override // c.a.t0.d1.s1.c
    public void c(boolean z) {
        c.a.t0.d1.s1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (gVar = this.E) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f16878e = z;
        I(gVar);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.card_video_aggregation_layout : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.C.T0() : invokeV.booleanValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i2) == null) {
            if (this.f18209e != i2) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(j());
                SkinManager.setBackgroundColor(j(), R.color.CAM_X0201);
                c.a.t0.d1.s1.g gVar = this.E;
                if (gVar != null && (bVar = gVar.y) != null) {
                    if (bVar.f16878e) {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
                        this.v.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.v, R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, n.f(this.f18211g, R.dimen.ds20), n.f(this.f18211g, R.dimen.ds20));
                        this.v.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                c.a.t0.d1.s1.g gVar2 = this.E;
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
            this.f18209e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (g() != null) {
                view.setTag(this);
                g().a(view, this.E);
            }
            if (view != this.t && view != this.u) {
                if (view != this.A && view != this.o && view != j()) {
                    if (view == this.s) {
                        c.a.t0.d1.s1.g gVar = this.E;
                        if (gVar == null || gVar.z == null) {
                            return;
                        }
                        this.q.setVisibility(8);
                        this.C.i1();
                        c.a.t0.z2.c cVar = this.C;
                        c.a.t0.d1.s1.g gVar2 = this.E;
                        cVar.c2(gVar2.z.f16889d, gVar2.f16864f);
                        H("2");
                        return;
                    } else if (view == this.v) {
                        c.a.t0.d1.s1.g gVar3 = this.E;
                        if (gVar3.y.f16878e) {
                            return;
                        }
                        this.G.c(gVar3);
                        return;
                    } else if (view == this.B) {
                        c.a.s0.o0.c k2 = TbPageExtraHelper.k(getContext());
                        if (k2 != null) {
                            this.E.u = k2.a();
                        }
                        this.G.d(this.E);
                        return;
                    } else {
                        return;
                    }
                } else if (this.E == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f18211g);
                    pbActivityConfig.createNormalCfg(this.E.f16864f, null, null);
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
            c.a.t0.d1.s1.g gVar4 = this.E;
            if (gVar4 == null || (bVar = gVar4.y) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.E.y.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.D.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.E.y.a, 0L), z, this.E.y.f16879f)));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            G();
            h hVar = this.G;
            if (hVar != null) {
                hVar.b();
            }
        }
    }

    @Override // c.a.t0.d1.s1.c
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.D.showToast(str);
        }
    }

    public final Animation z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.P == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.P = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.P;
        }
        return (Animation) invokeV.objValue;
    }
}
