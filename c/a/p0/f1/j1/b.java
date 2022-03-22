package c.a.p0.f1.j1;

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
import c.a.p0.c3.c;
import c.a.p0.c3.j;
import c.a.p0.c3.u;
import c.a.p0.f1.j1.g;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.h0.b<c.a.p0.f1.j1.g> implements c.a.p0.f1.j1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.f1.j1.g A;
    public int B;
    public h C;
    public u D;
    public u E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public Animation J;
    public Animation K;
    public ScaleAnimation L;
    public boolean M;
    public boolean N;
    public FrameLayout i;
    public FrameLayout j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public LinearLayout w;
    public LinearLayout x;
    public c.a.p0.c3.c y;
    public TbPageContext<?> z;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.T0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // c.a.p0.c3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.y.T0()) {
                    this.a.l.setVisibility(8);
                }
                if (this.a.I) {
                    this.a.y.j2();
                }
            }
        }
    }

    /* renamed from: c.a.p0.f1.j1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1065b implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1065b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                b bVar = this.a;
                bVar.onClick(bVar.i);
            }
        }

        @Override // c.a.p0.c3.c.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                b bVar = this.a;
                bVar.I(bVar.M ? "1" : "2");
                b bVar2 = this.a;
                bVar2.onClick(bVar2.j);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.c.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    b bVar = this.a;
                    c.a.p0.c3.c cVar = bVar.y;
                    c.a.p0.f1.j1.g gVar = bVar.A;
                    cVar.c2(gVar.v.f14149d, gVar.f14123b);
                    this.a.l.setVisibility(8);
                    this.a.I("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                b bVar2 = this.a;
                bVar2.onClick(bVar2.j);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.c.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.T0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        b bVar = this.a;
                        bVar.k.startAnimation(bVar.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    b bVar2 = this.a;
                    bVar2.k.startAnimation(bVar2.K);
                }
            }
        }

        @Override // c.a.p0.c3.c.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.T0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    b bVar = this.a;
                    bVar.k.startAnimation(bVar.J);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f14114c;

        public e(b bVar, c.a.p0.f1.j1.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14114c = bVar;
            this.a = aVar;
            this.f14113b = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14114c.H) {
                    this.f14114c.I = true;
                    this.f14114c.G = false;
                }
                if (this.a == null || this.f14114c.H) {
                    return;
                }
                this.a.a(this.f14113b);
                this.f14114c.y.Z0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f14115b;

        public f(b bVar, c.a.p0.f1.j1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14115b = bVar;
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                c.a.p0.f1.j1.g gVar = this.f14115b.A;
                if (gVar != null && gVar.v != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.f14115b.A.v.f14149d);
                }
                c.a.p0.f1.j1.a aVar = this.a;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.c.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = true;
        this.N = z;
        View k = k();
        this.z = tbPageContext;
        this.i = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f09230e);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f09231b);
        this.j = frameLayout;
        c.a.p0.c3.c cVar = new c.a.p0.c3.c(tbPageContext, frameLayout, false);
        this.y = cVar;
        cVar.N1("2005");
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090842);
        this.m = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f091429);
        this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09142b);
        this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09142a);
        this.p = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f0922a8);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.r = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0902b9);
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091fac);
        this.x = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f09015e);
        this.s = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fb0);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091fb5);
        this.u = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091faf);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091fb4);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        k.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = n.k(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new h(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010034);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f01002b);
    }

    public final Animation A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.L == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.L = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.L;
        }
        return (Animation) invokeV.objValue;
    }

    public final void B(c.a.p0.f1.j1.g gVar, int i, c.a.p0.f1.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i, aVar) == null) || gVar == null || gVar.v == null) {
            return;
        }
        this.y.j2();
        this.y.r1(true);
        this.y.u1(false);
        this.y.x1(new a(this));
        this.y.F1(new C1065b(this));
        this.y.z1(new c(this));
        this.y.n1(false);
        u uVar = new u();
        this.D = uVar;
        uVar.f13504c = gVar.f14123b;
        uVar.f13505d = gVar.a;
        uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
        u uVar2 = new u();
        this.E = uVar2;
        uVar2.f13504c = gVar.f14123b;
        uVar2.f13505d = gVar.a;
        uVar2.f13506e = TbadkCoreApplication.getCurrentAccount();
        if (this.N) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar.f14123b);
            statisticItem.param("nid", gVar.f14124c);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.i());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gVar.a);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            TiebaStatic.log(statisticItem);
            u uVar3 = this.D;
            uVar3.f13508g = "auto_midpage";
            uVar3.a = "13";
            uVar3.i = "1";
            u uVar4 = this.E;
            uVar4.f13508g = "auto_midpage";
            uVar4.a = "auto_midpage";
            uVar4.i = "1";
        } else {
            u uVar5 = this.D;
            uVar5.i = "frs_bavideotab";
            uVar5.a = "12";
            u uVar6 = this.E;
            uVar6.i = "frs_bavideotab";
            uVar6.a = "frs_bavideotab";
        }
        g.c cVar = gVar.v;
        if (cVar != null) {
            u uVar7 = this.D;
            String str = cVar.f14148c;
            uVar7.m = str;
            this.E.m = str;
        }
        this.y.I0().setVideoStatData(this.D);
        this.y.q0();
        this.y.y1(new d(this));
        this.y.H1(new e(this, aVar, i));
        this.y.I1(new f(this, aVar));
        this.y.R1(gVar.v.j);
        this.y.X1(gVar.v.f14149d, gVar.f14123b);
        this.y.W1(gVar.t);
        this.y.C1(new g(this));
        this.y.Z0();
        this.y.Z1();
        if (gVar.B) {
            onClick(this.j);
            this.I = false;
            this.y.h2(gVar.v.f14149d, gVar.f14123b, null, new Object[0]);
        }
        this.I = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: C */
    public void l(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
        }
    }

    public void D(c.a.p0.f1.j1.g gVar, int i, c.a.p0.f1.j1.a aVar) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048579, this, gVar, i, aVar) == null) || gVar == null || gVar.v == null) {
            return;
        }
        this.A = gVar;
        this.M = gVar.B;
        this.k.setVisibility(0);
        this.k.setText(gVar.t);
        this.l.setVisibility(0);
        this.l.setText(StringHelper.stringForVideoTime(gVar.v.f14150e * 1000));
        long j = gVar.v.f14153h;
        if (j == 0) {
            format = this.z.getString(R.string.obfuscated_res_0x7f0f14da);
        } else {
            format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f14d9), O(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
        }
        this.n.setText(format);
        this.m.setVisibility(8);
        B(gVar, i, aVar);
        K(gVar);
        m(this.z, TbadkCoreApplication.getInst().getSkinType());
    }

    public void E(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) || this.y == null || this.j == null || (tbPageContext = this.z) == null || tbPageContext.getPageActivity() == null || this.z.getPageActivity().getWindow() == null || !(this.z.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.z.getPageActivity().getWindow().getDecorView();
        if (this.G) {
            this.y.j1();
        }
        if (configuration.orientation == 2) {
            this.H = true;
            if (this.j.getParent() != null) {
                if (this.j.getParent() == frameLayout) {
                    frameLayout.removeView(this.j);
                } else {
                    ViewParent parent = this.j.getParent();
                    FrameLayout frameLayout2 = this.i;
                    if (parent == frameLayout2) {
                        frameLayout2.removeView(this.j);
                    }
                }
            }
            if (this.j.getParent() != null) {
                return;
            }
            frameLayout.addView(this.j);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.j.setLayoutParams(layoutParams);
        } else {
            this.H = false;
            if (this.j.getParent() != null) {
                if (this.j.getParent() == frameLayout) {
                    frameLayout.removeView(this.j);
                } else {
                    ViewParent parent2 = this.j.getParent();
                    FrameLayout frameLayout3 = this.i;
                    if (parent2 == frameLayout3) {
                        frameLayout3.removeView(this.j);
                    }
                }
            }
            if (this.j.getParent() != null) {
                return;
            }
            this.i.addView(this.j, 0);
            int i = this.B;
            this.j.setLayoutParams(new FrameLayout.LayoutParams(i, (int) (i * 0.5625f)));
            this.y.q0();
            this.G = true;
        }
        this.y.U0(this.z, configuration);
        this.l.setVisibility(8);
    }

    public boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.y.e1(i) : invokeI.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && isPlaying()) {
            this.y.V0();
        }
    }

    public void H() {
        c.a.p0.c3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.y) == null) {
            return;
        }
        cVar.v0();
    }

    public final void I(String str) {
        c.a.p0.f1.j1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (gVar = this.A) == null || gVar.v == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            j.e(this.A.v.f14148c, "", str, this.E, this.y.I0().getPcdnState());
        }
    }

    public void J(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null || gVar.u == null) {
            return;
        }
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.u.a) && TbadkCoreApplication.getCurrentAccount().equals(gVar.u.a)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (gVar.u.f14138e) {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            this.r.setCompoundDrawables(null, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f0f68));
            return;
        }
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
        drawable.setBounds(0, 0, n.f(this.f15305c, R.dimen.obfuscated_res_0x7f0701d5), n.f(this.f15305c, R.dimen.obfuscated_res_0x7f0701d5));
        this.r.setCompoundDrawables(drawable, null, null, null);
        this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f029b));
    }

    public void K(c.a.p0.f1.j1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null || (bVar = gVar.u) == null) {
            return;
        }
        this.q.setText(TextUtils.isEmpty(bVar.f14136c) ? gVar.u.f14135b : gVar.u.f14136c);
        this.p.J(gVar.u.f14137d, 12, false);
        this.p.setShowV(gVar.u.f14139f);
        this.p.setIsBigV(gVar.u.f14139f);
        J(gVar);
        M(gVar);
        L(gVar);
    }

    public void L(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) || gVar == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(gVar.f14128g));
    }

    public void M(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.l) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(gVar.i));
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m.setVisibility(8);
            this.y.j2();
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public String O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str : (String) invokeL.objValue;
    }

    @Override // c.a.p0.f1.j1.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // c.a.p0.f1.j1.c
    public void c() {
        c.a.p0.f1.j1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gVar = this.A) == null) {
            return;
        }
        boolean z = !gVar.l;
        gVar.l = z;
        if (z) {
            gVar.i++;
        } else {
            gVar.i--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(A());
        }
        M(this.A);
    }

    @Override // c.a.p0.f1.j1.c
    public void d(boolean z) {
        c.a.p0.f1.j1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gVar = this.A) == null || (bVar = gVar.u) == null) {
            return;
        }
        bVar.f14138e = z;
        J(gVar);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c6 : invokeV.intValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.y.T0() : invokeV.booleanValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, tbPageContext, i) == null) {
            if (this.a != i) {
                tbPageContext.getLayoutMode().k(i == 1);
                tbPageContext.getLayoutMode().j(k());
                SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
                c.a.p0.f1.j1.g gVar = this.A;
                if (gVar != null && (bVar = gVar.u) != null) {
                    if (bVar.f14138e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, n.f(this.f15305c, R.dimen.obfuscated_res_0x7f0701d5), n.f(this.f15305c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                c.a.p0.f1.j1.g gVar2 = this.A;
                if (gVar2 != null) {
                    if (gVar2.l) {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
                    } else {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
                this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            if (h() != null) {
                view.setTag(this);
                h().a(view, this.A);
            }
            if (view != this.p && view != this.q) {
                if (view != this.w && view != this.k && view != k()) {
                    if (view == this.o) {
                        c.a.p0.f1.j1.g gVar = this.A;
                        if (gVar == null || gVar.v == null) {
                            return;
                        }
                        this.m.setVisibility(8);
                        this.y.i1();
                        c.a.p0.c3.c cVar = this.y;
                        c.a.p0.f1.j1.g gVar2 = this.A;
                        cVar.c2(gVar2.v.f14149d, gVar2.f14123b);
                        I("2");
                        return;
                    } else if (view == this.r) {
                        c.a.p0.f1.j1.g gVar3 = this.A;
                        if (gVar3.u.f14138e) {
                            return;
                        }
                        this.C.c(gVar3);
                        return;
                    } else if (view == this.x) {
                        c.a.o0.n0.c currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                        if (currentVisiblePageExtra != null) {
                            this.A.q = currentVisiblePageExtra.a();
                        }
                        this.C.d(this.A);
                        return;
                    } else {
                        return;
                    }
                } else if (this.A == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f15305c);
                    pbActivityConfig.createNormalCfg(this.A.f14123b, null, null);
                    if (!this.N) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            c.a.p0.f1.j1.g gVar4 = this.A;
            if (gVar4 == null || (bVar = gVar4.u) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            if (TbadkCoreApplication.isLogin() && this.A.u.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.A.u.a, 0L), z, this.A.u.f14139f)));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            H();
            h hVar = this.C;
            if (hVar != null) {
                hVar.b();
            }
        }
    }
}
