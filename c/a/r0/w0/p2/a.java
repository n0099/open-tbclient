package c.a.r0.w0.p2;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.f.m.d;
import c.a.r0.p2.c;
import c.a.r0.p2.f;
import c.a.r0.w0.h1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends c.a.r0.a0.b<c.a.r0.w0.h1.g> implements c.a.r0.w0.h1.c, c.a.r0.p1.o.l.j, c.a.r0.p1.o.l.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public TextView B;
    public TbPageContext<?> C;
    public c.a.r0.w0.h1.g D;
    public int E;
    public c.a.r0.w0.h1.h F;
    public c.a.r0.p2.o G;
    public c.a.r0.p2.o H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public String Q;
    public String R;
    public View S;
    public View T;
    public c.a.r0.w0.p2.c U;
    public Animation V;
    public Animation W;
    public c.a.r0.w0.p2.j.a X;
    public c.a.r0.p1.o.l.f Y;
    public s Z;
    public VideoNetworkStateTipView a0;
    public c.a.f.m.d b0;
    public c.a.r0.w0.p2.b c0;
    public c.a.y.c i0;
    public c.a.r0.p1.o.l.g j0;
    public boolean k0;
    public boolean l0;
    public FrameLayout m;
    public boolean m0;
    public FrameLayout n;
    public long n0;
    public ExpandableTextView o;
    public int o0;
    public View p;
    public Animation.AnimationListener p0;
    public HeadImageView q;
    public Animation.AnimationListener q0;
    public TextView r;
    public Runnable r0;
    public AgreeView s;
    public Runnable s0;
    public TextView t;
    public ImageView u;
    public View v;
    public TextView w;
    public ImageView x;
    public View y;
    public c.a.r0.p2.c z;

    /* renamed from: c.a.r0.w0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1293a implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.h1.g f27495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27496f;

        public C1293a(a aVar, c.a.r0.w0.h1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27496f = aVar;
            this.f27495e = gVar;
        }

        @Override // c.a.r0.p2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f27496f.n0 <= 0) {
                    this.f27496f.n0 = i3;
                }
                a aVar = this.f27496f;
                g.a aVar2 = aVar.D.z.o;
                boolean z = true;
                if (aVar2 == null) {
                    if (i3 >= i2) {
                        c.a.f.m.d dVar = aVar.b0;
                        boolean z2 = this.f27496f.K;
                        c.a.r0.p2.c cVar = this.f27496f.z;
                        dVar.I(z2, cVar != null && cVar.S0(), "VIDEO_LIST");
                    } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                        aVar.b0.K(this.f27496f.Z(this.f27495e));
                    }
                }
                if (aVar2 == null || this.f27496f.K || this.f27496f.z.S0() || c.a.y.b.b().a(aVar2.f26812d)) {
                    return;
                }
                boolean z3 = this.f27496f.n0 >= (aVar2.f26809a * 1000) + 1000;
                long j2 = i3;
                if ((j2 < aVar2.f26809a * 1000 || j2 >= aVar2.f26810b * 1000) ? false : false) {
                    if (this.f27496f.i0.c()) {
                        return;
                    }
                    c.a.y.a aVar3 = new c.a.y.a();
                    aVar3.f31184b = aVar2.f26813e;
                    aVar3.f31185c = aVar2.f26814f;
                    aVar3.f31186d = aVar2.f26812d;
                    aVar3.f31183a = aVar2.f26811c;
                    c.a.r0.w0.h1.g gVar = this.f27496f.D;
                    aVar3.f31188f = gVar != null ? gVar.f26803e : null;
                    c.a.r0.w0.h1.g gVar2 = this.f27496f.D;
                    aVar3.f31187e = gVar2 != null ? gVar2.f26804f : null;
                    aVar3.f31189g = 3;
                    if (z3) {
                        this.f27496f.i0.f(aVar3, (ViewGroup) this.f27496f.z.E0());
                    } else {
                        this.f27496f.i0.e(aVar3, (ViewGroup) this.f27496f.z.E0());
                    }
                } else if (this.f27496f.i0.c()) {
                    this.f27496f.i0.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.h1.a f27497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27498f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f27499g;

        public b(a aVar, c.a.r0.w0.h1.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27499g = aVar;
            this.f27497e = aVar2;
            this.f27498f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.f.m.d dVar = this.f27499g.b0;
                boolean z = this.f27499g.K;
                c.a.r0.p2.c cVar = this.f27499g.z;
                if (dVar.I(z, cVar != null && cVar.S0(), "VIDEO_LIST")) {
                    return;
                }
                if (this.f27499g.K) {
                    this.f27499g.L = true;
                    this.f27499g.M = true;
                    this.f27499g.J = false;
                }
                if (this.f27497e == null || this.f27499g.K) {
                    return;
                }
                this.f27497e.a(this.f27498f);
                this.f27499g.z.a1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.h1.a f27500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27501f;

        public c(a aVar, c.a.r0.w0.h1.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27501f = aVar;
            this.f27500e = aVar2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                c.a.r0.w0.h1.g gVar = this.f27501f.D;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f27501f.D.z.f26832d);
                }
                c.a.r0.w0.h1.a aVar = this.f27500e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.InterfaceC0068d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.h1.a f27502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f27503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f27504c;

        public d(a aVar, c.a.r0.w0.h1.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27504c = aVar;
            this.f27502a = aVar2;
            this.f27503b = i2;
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f27504c.K) {
                    this.f27504c.L = true;
                    this.f27504c.M = true;
                    this.f27504c.J = false;
                }
                if (this.f27502a == null || this.f27504c.K) {
                    return;
                }
                this.f27502a.a(this.f27503b);
                this.f27504c.z.a1();
            }
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void b() {
            c.a.r0.p2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f27504c.z) == null) {
                return;
            }
            cVar.f1(4);
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f27504c.M = false;
            }
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27504c.V() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27505a;

        public e(a aVar) {
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
            this.f27505a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f27505a.S == null) {
                return;
            }
            this.f27505a.S.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f27505a.S == null) {
                return;
            }
            this.f27505a.S.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27506a;

        public f(a aVar) {
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
            this.f27506a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f27506a.S == null) {
                return;
            }
            this.f27506a.S.setVisibility(0);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.f27506a.S == null) {
                return;
            }
            this.f27506a.S.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.h1.g f27507e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27508f;

        public g(a aVar, c.a.r0.w0.h1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27508f = aVar;
            this.f27507e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f27507e.i().hasAgree && this.f27507e.i().agreeType == 2) {
                this.f27508f.Z.g(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27509e;

        public h(a aVar) {
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
            this.f27509e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27509e.A.getVisibility() == 0) {
                this.f27509e.A.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27510e;

        public i(a aVar) {
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
            this.f27510e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.r0.p2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f27510e.z) == null) {
                return;
            }
            cVar.k2();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27511e;

        public j(a aVar) {
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
            this.f27511e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            a aVar;
            c.a.r0.w0.p2.j.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.f27511e).X) == null) {
                return;
            }
            g.c cVar = aVar.D.z;
            if (cVar.f26833e > 8) {
                aVar2.a(aVar.I, cVar.f26832d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements c.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27512a;

        public k(a aVar) {
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
            this.f27512a = aVar;
        }

        @Override // c.a.r0.p2.c.v
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f27512a.Z == null) {
                return;
            }
            if (z) {
                this.f27512a.Z.g(0);
            } else {
                this.f27512a.Z.g(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c.i0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27513a;

        public l(a aVar) {
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
            this.f27513a = aVar;
        }

        @Override // c.a.r0.p2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.f27513a.n0 = -1L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27515f;

        public m(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27515f = aVar;
            this.f27514e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f27514e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f27515f.i().getPageActivity()), new String[]{this.f27514e}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27516e;

        public n(a aVar) {
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
            this.f27516e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK));
                this.f27516e.a0.setHasAgreeToPlay(true);
                this.f27516e.z.n1(false);
                this.f27516e.a0.showPlayTips();
                if (this.f27516e.b0.r()) {
                    this.f27516e.b0.E();
                    return;
                }
                a aVar = this.f27516e;
                c.a.r0.w0.h1.g gVar = aVar.D;
                if (gVar == null || (cVar = gVar.z) == null) {
                    return;
                }
                aVar.z.d2(cVar.f26832d, gVar.f26804f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27517a;

        public o(a aVar) {
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
            this.f27517a = aVar;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f27517a.D.H = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27518a;

        public p(a aVar) {
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
            this.f27518a = aVar;
        }

        @Override // c.a.r0.p2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27518a.W();
                if (this.f27518a.b0 != null) {
                    this.f27518a.b0.x();
                }
            }
        }

        @Override // c.a.r0.p2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27518a.X();
                this.f27518a.z.T0();
                if (this.f27518a.L || (this.f27518a.b0 != null && this.f27518a.b0.r())) {
                    c.a.e.e.m.e.a().removeCallbacks(this.f27518a.s0);
                    c.a.e.e.m.e.a().post(this.f27518a.s0);
                }
                if (this.f27518a.b0 != null) {
                    this.f27518a.b0.y();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27519a;

        public q(a aVar) {
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
            this.f27519a = aVar;
        }

        @Override // c.a.r0.p2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f27519a;
                aVar.onClick(aVar.m);
            }
        }

        @Override // c.a.r0.p2.c.g0
        public void b() {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.r0.w0.h1.g gVar = this.f27519a.D;
                if (gVar != null && (cVar = gVar.z) != null && c.a.e.e.m.b.e(cVar.f26835g, 0) > c.a.e.e.m.b.e(this.f27519a.D.z.f26834f, 0)) {
                    this.f27519a.z.M1(false, false);
                } else {
                    this.f27519a.z.M1(true, false);
                }
                this.f27519a.L = false;
                a aVar = this.f27519a;
                aVar.m0(aVar.N ? "1" : "2");
                a aVar2 = this.f27519a;
                aVar2.onClick(aVar2.n);
                if (this.f27519a.Y != null) {
                    this.f27519a.Y.h(this.f27519a);
                }
                if (this.f27519a.j0 != null) {
                    this.f27519a.j0.b(this.f27519a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27520a;

        public r(a aVar) {
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
            this.f27520a = aVar;
        }

        @Override // c.a.r0.p2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                a aVar = this.f27520a;
                c.a.r0.p2.c cVar = aVar.z;
                c.a.r0.w0.h1.g gVar = aVar.D;
                cVar.d2(gVar.z.f26832d, gVar.f26804f);
                this.f27520a.m0("2");
                a aVar2 = this.f27520a;
                aVar2.onClick(aVar2.n);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, c.a.r0.w0.p2.b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), str, str2, bVar};
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
        this.J = true;
        this.O = false;
        this.P = false;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = -1L;
        this.o0 = 0;
        this.p0 = new e(this);
        this.q0 = new f(this);
        this.r0 = new h(this);
        this.s0 = new i(this);
        this.Q = str;
        this.R = str2;
        this.c0 = bVar;
        View j2 = j();
        this.C = tbPageContext;
        this.m = (FrameLayout) j2.findViewById(R.id.video_agg_container);
        this.p = j2.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) j2.findViewById(R.id.video_container);
        this.n = frameLayout;
        c.a.r0.p2.c cVar = new c.a.r0.p2.c(tbPageContext, frameLayout, false);
        this.z = cVar;
        cVar.O1("2005");
        this.z.q1(z);
        this.z.K1(new j(this));
        this.z.p1(new k(this));
        this.z.N1(new l(this));
        this.o = (ExpandableTextView) j2.findViewById(R.id.title);
        this.q = (HeadImageView) j2.findViewById(R.id.user_icon);
        this.r = (TextView) j2.findViewById(R.id.user_name);
        this.s = (AgreeView) j2.findViewById(R.id.agree_view);
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f14168c = 2;
        fVar.f14173h = 6;
        this.s.setStatisticData(fVar);
        this.s.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.t = (TextView) j2.findViewById(R.id.thread_info_commont_num);
        this.u = (ImageView) j2.findViewById(R.id.thread_info_commont_img);
        this.v = j2.findViewById(R.id.thread_info_commont_container);
        this.w = (TextView) j2.findViewById(R.id.thread_info_share_num);
        this.x = (ImageView) j2.findViewById(R.id.share_num_img);
        this.y = j2.findViewById(R.id.share_num_container);
        this.A = (FrameLayout) j2.findViewById(R.id.download_nani_guide_container);
        this.B = (TextView) j2.findViewById(R.id.download_nani_guide_txt);
        this.A.setVisibility(8);
        String p2 = c.a.q0.s.d0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.B.setText(p2);
        }
        this.B.setOnClickListener(new m(this, c.a.q0.s.d0.b.j().p("nani_key_download_link_url", null)));
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) j2.findViewById(R.id.network_state_tip);
        this.a0 = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new n(this));
        this.S = j2.findViewById(R.id.video_agg_container_foreground);
        this.T = j2.findViewById(R.id.title_and_comment_container_foreground);
        this.S.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.p.setOnClickListener(this);
        int k2 = c.a.e.e.p.l.k(tbPageContext.getPageActivity());
        this.E = k2;
        this.o0 = k2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.E * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.q.setIsRound(true);
        this.q.setPlaceHolder(1);
        this.F = new c.a.r0.w0.h1.h(this.C, this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.V = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.V.setAnimationListener(this.q0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.W = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.W.setAnimationListener(this.p0);
        this.Z = new s(this, null);
        this.b0 = new c.a.f.m.d(d(), this.n);
        this.i0 = new c.a.y.c(this.f15550g);
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.P = false;
            this.z.k2();
            ExpandableTextView expandableTextView = this.o;
            if (expandableTextView != null) {
                expandableTextView.setVisibility(0);
            }
            s sVar = this.Z;
            if (sVar != null) {
                sVar.g(2);
            }
            x0(false);
            this.O = true;
            c.a.f.m.d dVar = this.b0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            this.b0.L();
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.z != null && this.n != null && (tbPageContext = this.C) != null && tbPageContext.getPageActivity() != null && this.C.getPageActivity().getWindow() != null && (this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
                if (this.n.getParent() != null) {
                    if (this.n.getParent() == frameLayout) {
                        if (this.k0) {
                            this.k0 = false;
                            return true;
                        } else if (!this.l0) {
                            this.l0 = true;
                            return true;
                        }
                    } else if (this.n.getParent() == this.m) {
                        if (this.l0) {
                            this.l0 = false;
                            this.m0 = true;
                            return true;
                        } else if (!this.k0 && this.m0) {
                            this.k0 = true;
                            this.m0 = false;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = true;
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
        c.a.y.c cVar = this.i0;
        if (cVar != null && cVar.c()) {
            this.i0.a();
        }
        c.a.q0.d1.e.m().n(true);
    }

    public final void X() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = false;
        if (this.n.getParent() != null) {
            if (this.n.getParent() == frameLayout) {
                Y();
                frameLayout.removeView(this.n);
            } else if (this.n.getParent() == this.m) {
                Y();
                this.m.removeView(this.n);
            }
        }
        if (this.n.getParent() != null) {
            return;
        }
        this.m.addView(this.n, 0);
        o0();
        this.z.q0();
        this.n0 = -1L;
        c.a.q0.d1.e.m().n(false);
    }

    public final void Y() {
        c.a.f.m.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (dVar = this.b0) != null && dVar.r()) {
            this.b0.F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.f.m.a Z(c.a.r0.w0.h1.g gVar) {
        InterceptResult invokeL;
        int i2;
        g.c cVar;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            c.a.r0.w0.p2.b bVar = this.c0;
            c.a.f.m.e.b c2 = bVar != null ? bVar.c(gVar.k()) : null;
            if (c2 == null) {
                return null;
            }
            int c3 = c2.c();
            int b2 = c2.b();
            int a2 = c2.a();
            int i5 = -1;
            if (a2 != -1) {
                int i6 = c3 != -1 ? (a2 - c3) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a2) - 1;
                    cVar = gVar.z;
                    if (cVar == null) {
                        i3 = c.a.e.e.m.b.e(cVar.f26834f, 0);
                        i4 = c.a.e.e.m.b.e(gVar.z.f26835g, 0);
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", gVar.f26804f);
                    hashMap.put("video_title", gVar.x);
                    hashMap.put("forum_id", gVar.f26803e);
                    hashMap.put("forum_name", "");
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    c.a.f.m.a h2 = c.a.f.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            cVar = gVar.z;
            if (cVar == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", gVar.f26804f);
            hashMap2.put("video_title", gVar.x);
            hashMap2.put("forum_id", gVar.f26803e);
            hashMap2.put("forum_name", "");
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.f.m.a h22 = c.a.f.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.f.m.a) invokeL.objValue;
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
            CustomMessage customMessage = new CustomMessage(2921317);
            if (z) {
                customMessage.setExtra("high");
            } else {
                customMessage.setExtra("low");
            }
            customResponsedMessage.setmOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // c.a.r0.w0.h1.c
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.D == null) {
            return;
        }
        this.s.onAgreeClick();
    }

    public final void b0(c.a.r0.w0.h1.g gVar, int i2, c.a.r0.w0.h1.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{gVar, Integer.valueOf(i2), aVar, Boolean.valueOf(z)}) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.z.k2();
        this.z.s1(true);
        this.z.v1(true);
        this.z.t1(true);
        this.z.M1(false, false);
        this.z.L1(i2);
        this.z.y1(new p(this));
        this.z.G1(new q(this));
        this.z.A1(new r(this));
        this.z.o1(false);
        c.a.y.c cVar = this.i0;
        if (cVar != null) {
            cVar.d();
        }
        this.n0 = -1L;
        if (this.z.I0() != null && this.z.I0().getMediaProgressObserver() != null) {
            this.z.I0().getMediaProgressObserver().j(new C1293a(this, gVar));
        }
        c.a.r0.p2.o oVar = new c.a.r0.p2.o();
        this.G = oVar;
        oVar.f23808c = gVar.f26804f;
        oVar.t = gVar.f26805g;
        oVar.f23809d = gVar.f26803e;
        oVar.f23810e = TbadkCoreApplication.getCurrentAccount();
        c.a.r0.p2.o oVar2 = this.G;
        oVar2.f23806a = "13";
        oVar2.f23811f = gVar.q;
        oVar2.f23812g = gVar.r;
        oVar2.f23814i = this.Q;
        oVar2.l = gVar.t;
        oVar2.k = this.R;
        oVar2.o = gVar.s;
        oVar2.p = "0";
        oVar2.f23815j = gVar.o();
        c.a.r0.p2.o oVar3 = new c.a.r0.p2.o();
        this.H = oVar3;
        oVar3.f23808c = gVar.f26804f;
        oVar3.f23809d = gVar.f26803e;
        oVar3.f23810e = TbadkCoreApplication.getCurrentAccount();
        c.a.r0.p2.o oVar4 = this.H;
        oVar4.f23812g = "auto_midpage";
        oVar4.f23806a = "auto_midpage";
        oVar4.f23814i = this.Q;
        oVar4.f23811f = gVar.q;
        oVar4.p = "0";
        g.c cVar2 = gVar.z;
        if (cVar2 != null) {
            c.a.r0.p2.o oVar5 = this.G;
            String str = cVar2.f26831c;
            oVar5.m = str;
            oVar4.m = str;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar.f26804f);
        statisticItem.param("nid", gVar.f26805g);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("fid", gVar.f26803e);
        statisticItem.param("obj_param1", c.a.e.e.p.k.isEmpty(gVar.r) ? "0" : gVar.r);
        statisticItem.param("extra", c.a.e.e.p.k.isEmpty(gVar.s) ? "0" : gVar.s);
        statisticItem.param("obj_id", this.R);
        statisticItem.param("ab_tag", c.a.e.e.p.k.isEmpty(gVar.t) ? "0" : gVar.t);
        statisticItem.param("obj_type", this.Q);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
        statisticItem.param("obj_source", c.a.e.e.p.k.isEmpty(gVar.q) ? "0" : gVar.q);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 0);
        BaijiahaoData baijiahaoData = gVar.A;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, gVar.A.oriUgcVid);
        }
        TiebaStatic.log(statisticItem);
        this.z.I0().setVideoStatData(this.G);
        this.z.q0();
        this.z.I1(new b(this, aVar, i2));
        this.z.J1(new c(this, aVar));
        if (!z || !gVar.F) {
            this.b0.B();
        }
        this.b0.G(new d(this, aVar, i2));
        this.z.S1(gVar.z.f26838j);
        this.z.T1(gVar.z.f26833e);
        this.z.Y1(gVar.z.f26832d, gVar.f26804f);
        this.z.m1(gVar.f26803e);
        this.z.a1();
        this.z.a2();
        x0(false);
        if (gVar.F) {
            onClick(this.n);
            if (this.a0.isShowNetworkTips()) {
                this.z.c2(false);
                this.a0.showNetWorkTips();
                this.z.n1(true);
                this.z.U0(gVar.z.f26832d, gVar.f26804f);
                if (this.b0.r()) {
                    this.b0.L();
                    this.b0.J();
                }
            } else {
                this.z.n1(false);
                this.z.c2(false);
                this.a0.hide();
                c.a.f.m.d dVar = this.b0;
                if (dVar == null || (dVar != null && !dVar.r())) {
                    this.z.i2(gVar.z.f26832d, gVar.f26804f, null, new Object[0]);
                }
            }
            if (i2 == 0 && gVar.G) {
                this.S.setVisibility(8);
                this.Z.g(3);
            } else {
                if (this.S.getVisibility() == 0) {
                    this.S.startAnimation(this.W);
                }
                this.Z.g(0);
            }
            gVar.G = false;
        } else {
            this.S.setVisibility(0);
            this.a0.hide();
            this.z.c2(true);
            this.Z.g(3);
            this.z.U0(gVar.z.f26832d, gVar.f26804f);
        }
        this.L = false;
        this.M = false;
        if (z || !this.b0.r()) {
            return;
        }
        stopPlay();
    }

    @Override // c.a.r0.w0.h1.c
    public void c(boolean z) {
        c.a.r0.w0.h1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (gVar = this.D) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f26819e = z;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            s sVar = this.Z;
            if (sVar != null) {
                return sVar.f() == 2 || this.Z.f() == 3;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                int parseInt = Integer.parseInt(this.D.z.f26834f);
                return parseInt <= 0 || ((float) Integer.parseInt(this.D.z.f26835g)) / ((float) parseInt) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b0.r() : invokeV.booleanValue;
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.card_video_middle_page_layout : invokeV.intValue;
    }

    public void f0(c.a.r0.w0.h1.g gVar, int i2, c.a.r0.w0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, gVar, i2, aVar) == null) {
            this.D = gVar;
            this.N = gVar.F;
            b0(gVar, i2, aVar, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: g0 */
    public void k(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
        }
    }

    public void h0(c.a.r0.w0.h1.g gVar, int i2, c.a.r0.w0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048592, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        boolean z = this.D == gVar;
        this.D = gVar;
        this.N = gVar.F;
        this.P = false;
        x0(false);
        this.o.setVisibility(0);
        this.o.setTextSize(c.a.e.e.p.l.g(d(), R.dimen.tbfontsize40));
        this.o.setTextColor(R.color.CAM_X0101);
        this.o.setLineSpacingExtra(c.a.e.e.p.l.g(d(), R.dimen.tbds14));
        g.c cVar = gVar.z;
        if (cVar != null && !StringUtils.isNull(cVar.n)) {
            this.o.setTextMaxLine(2);
            this.o.setExpandable(false);
            c.a.r0.w0.p2.k.a.a(this.f15550g, this.o.getContentView(), gVar.x, gVar.z.n, gVar.k());
        } else {
            this.o.setTextMaxLine(Integer.MAX_VALUE);
            this.o.setExpandable(true);
            this.o.setOnStatusChangedListener(new o(this));
            this.o.setData(gVar.x, gVar.H, gVar.E);
        }
        int k2 = c.a.e.e.p.l.k(this.f15550g);
        this.E = k2;
        if (k2 != this.o0) {
            this.z.c1();
            this.o0 = this.E;
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        }
        n0();
        b0(gVar, i2, aVar, z);
        w0(gVar);
        l(this.C, TbadkCoreApplication.getInst().getSkinType());
    }

    public void i0(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        if (this.J) {
            this.z.k1();
        }
        if (configuration.orientation == 2) {
            configuration.orientation = 2;
            W();
        } else {
            configuration.orientation = 1;
            X();
            this.J = true;
        }
        this.z.V0(this.C, configuration);
    }

    @Override // c.a.r0.p1.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.z.T0() : invokeV.booleanValue;
    }

    public boolean j0(int i2) {
        InterceptResult invokeI;
        c.a.f.m.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (i2 == 4 && (dVar = this.b0) != null && ((dVar.r() || this.M) && this.z != null)) {
                this.b0.D(i2);
                if (this.K) {
                    if (this.b0.a()) {
                        this.z.q2();
                        return true;
                    }
                    this.z.m2();
                    return true;
                }
            }
            return this.z.f1(i2);
        }
        return invokeI.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && isPlaying()) {
            this.z.W0();
        }
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, tbPageContext, i2) == null) {
            this.s.onChangeSkinType(i2);
            this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.o.onChangeSkinType();
        }
    }

    public void l0() {
        c.a.r0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.z) == null) {
            return;
        }
        cVar.v0();
    }

    public final void m0(String str) {
        c.a.r0.w0.h1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (gVar = this.D) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.r0.p2.h.e(this.D.z.f26831c, "", str, this.H, this.z.I0().getPcdnState());
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!d0()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = (int) (this.E * 0.875f);
                this.m.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.height = (int) (this.E * 0.5625f);
            this.m.setLayoutParams(layoutParams2);
        }
    }

    public final void o0() {
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!d0()) {
                f2 = 0.875f;
                i2 = this.E;
            } else {
                f2 = 0.5625f;
                i2 = this.E;
            }
            int i3 = (int) (i2 * f2);
            if (i3 <= 0) {
                return;
            }
            this.n.setLayoutParams(new FrameLayout.LayoutParams(this.E, i3));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        c.a.r0.w0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            if (g() != null) {
                view.setTag(this);
                g().a(view, this.D);
            }
            boolean z = true;
            if (view != this.q && view != this.r) {
                if (view == this.v) {
                    if (this.D == null) {
                        return;
                    }
                    this.Z.g(0);
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f15550g);
                    pbActivityConfig.createNormalCfg(this.D.f26804f, null, null);
                    pbActivityConfig.setVideo_source("auto_midpage");
                    pbActivityConfig.setBjhData(this.D.A);
                    pbActivityConfig.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                } else if (view != this.o && view != this.p) {
                    if (view == this.y) {
                        this.Z.g(0);
                        y0();
                        return;
                    }
                    View view2 = this.S;
                    if (view == view2 && view2.getVisibility() == 0 && (cVar = this.U) != null) {
                        cVar.onVideoContainerForegroundClick(this.I);
                        return;
                    }
                    return;
                } else if (this.D == null) {
                    return;
                } else {
                    if (this.Z.f() != 2 && this.Z.f() != 3) {
                        z = false;
                    }
                    this.Z.g(0);
                    if (z) {
                        return;
                    }
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f15550g);
                    pbActivityConfig2.createNormalCfg(this.D.f26804f, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    pbActivityConfig2.setBjhData(this.D.A);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                    return;
                }
            }
            c.a.r0.w0.h1.g gVar = this.D;
            if (gVar == null || (bVar = gVar.y) == null || TextUtils.isEmpty(bVar.f26815a)) {
                return;
            }
            this.Z.g(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.C.getPageActivity()).createNormalConfig(c.a.e.e.m.b.g(this.D.y.f26815a, 0L), (TbadkCoreApplication.isLogin() && this.D.y.f26815a.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false, this.D.y.f26820f)));
        }
    }

    @Override // c.a.r0.p1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            l0();
            c.a.r0.w0.h1.h hVar = this.F;
            if (hVar != null) {
                hVar.b();
            }
            View view = this.S;
            if (view != null) {
                view.clearAnimation();
            }
            this.b0.w();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.b0.E();
        }
    }

    @Override // c.a.r0.p1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            k0();
        }
    }

    public void q0(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) || gVar == null) {
            return;
        }
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.k;
        if (j2 > 0) {
            this.t.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.t.setText(this.f15550g.getString(R.string.reply));
        }
    }

    public void r0(boolean z) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (frameLayout = this.m) == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 4);
    }

    public void s0(c.a.r0.p1.o.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gVar) == null) {
            this.j0 = gVar;
        }
    }

    @Override // c.a.r0.p1.o.l.h
    public void setAutoPlayCallBack(c.a.r0.w0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
        }
    }

    @Override // c.a.r0.p1.o.l.h
    public void setCurrentPlayCallBack(c.a.r0.p1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    @Override // c.a.r0.p1.o.l.h
    public void setOnVideoContainerForegroundClickListener(c.a.r0.w0.p2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, cVar) == null) {
            this.U = cVar;
        }
    }

    @Override // c.a.r0.w0.h1.c
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.C.showToast(str);
        }
    }

    @Override // c.a.r0.p1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            A0();
        }
    }

    public void t0(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.i() != null) {
            gVar.i().isInThread = true;
            gVar.i().nid = gVar.f26805g;
            if (this.D.o() == 1) {
                gVar.i().cardType = 2;
            } else if (this.D.o() == 2) {
                gVar.i().cardType = 8;
            } else if (this.D.o() == 3) {
                gVar.i().cardType = 6;
            }
            gVar.i().baijiahaoData = gVar.A;
            gVar.i().recomSource = gVar.q;
            gVar.i().recomWeight = gVar.r;
            gVar.i().recomAbTag = gVar.t;
            gVar.i().recomExtra = gVar.s;
        }
        this.s.setAgreeAlone(true);
        this.s.setIsFromMiddlePage(true);
        this.s.setData(gVar.i());
        this.s.setAfterClickListener(new g(this, gVar));
    }

    public void u0(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, gVar) == null) || gVar == null) {
            return;
        }
        this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.l;
        if (j2 > 0) {
            this.w.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.w.setText(this.f15550g.getString(R.string.share));
        }
    }

    public final void v0(c.a.r0.w0.h1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, gVar) == null) || (bVar = gVar.y) == null) {
            return;
        }
        g.b.a aVar = bVar.f26822h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f26824b)) {
            this.q.startLoad(gVar.y.f26822h.f26824b, 12, false);
        } else if (!StringUtils.isNull(gVar.y.f26818d) && gVar.y.f26818d.startsWith("http")) {
            this.q.startLoad(gVar.y.f26818d, 10, false);
        } else {
            this.q.startLoad(gVar.y.f26818d, 12, false);
        }
        g.b.a aVar2 = gVar.y.f26822h;
        if (aVar2 != null && aVar2.f26827e.intValue() > 0) {
            this.q.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.y.f26822h.f26827e.intValue(), 1));
            this.q.setShowV(true);
            this.q.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.q.setBjhAuthIconRes(0);
        g.b bVar2 = gVar.y;
        boolean z = bVar2.f26821g;
        if (z) {
            this.q.setShowV(z);
            this.q.setIsBigV(gVar.y.f26821g);
        } else {
            boolean z2 = bVar2.f26820f;
            if (z2) {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f26820f);
            } else {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f26820f);
            }
        }
        this.q.setGodIconWidth(R.dimen.tbds31);
    }

    public void w0(c.a.r0.w0.h1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.r.setText(TextUtils.isEmpty(bVar.f26817c) ? gVar.y.f26816b : gVar.y.f26817c);
        v0(gVar);
        t0(gVar);
        q0(gVar);
        u0(gVar);
    }

    public final void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            c.a.r0.w0.p2.j.a aVar = this.X;
            boolean z2 = this.I == (aVar == null ? -1 : aVar.b());
            this.O = z2;
            if (z2 && z && isPlaying() && this.N && !this.P) {
                this.A.setVisibility(0);
                this.P = true;
                this.A.postDelayed(this.r0, 5000L);
                c.a.r0.w0.p2.j.a aVar2 = this.X;
                if (aVar2 != null) {
                    aVar2.c(System.currentTimeMillis());
                    return;
                }
                return;
            }
            this.A.setVisibility(8);
            Runnable runnable = this.r0;
            if (runnable != null) {
                this.A.removeCallbacks(runnable);
            }
        }
    }

    public final void y0() {
        c.a.r0.w0.h1.g gVar;
        String str;
        String str2;
        String format;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (gVar = this.D) == null || this.f15550g == null) {
            return;
        }
        String valueOf = String.valueOf(gVar.f26803e);
        c.a.r0.w0.h1.g gVar2 = this.D;
        String str3 = gVar2.x;
        BaijiahaoData baijiahaoData = gVar2.A;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.D.A.oriUgcType + "&dvid=" + this.D.A.oriUgcVid + "&nid=" + this.D.A.oriUgcNid;
        } else {
            str = gVar2.f26804f;
            str2 = "?share=9105&fr=share";
        }
        String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str5 = this.D.z.f26838j;
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = this.D.x;
        String string = this.f15550g.getResources().getString(R.string.share_content_tpl);
        String string2 = this.f15550g.getResources().getString(R.string.default_share_content_tpl);
        c.a.r0.w0.h1.g gVar3 = this.D;
        if (gVar3.A != null && (bVar = gVar3.y) != null) {
            format = MessageFormat.format(string2, bVar.f26817c, this.f15550g.getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str3, str6);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        c.a.r0.w0.h1.g gVar4 = this.D;
        if (gVar4.A != null) {
            shareItem.D = format;
            shareItem.R = -1L;
        } else {
            shareItem.D = str6;
            shareItem.R = gVar4.f26808j;
        }
        shareItem.t = str4;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = "";
        shareItem.K = str;
        shareItem.f48110f = true;
        shareItem.E = 11;
        if (this.D.o() == 1) {
            shareItem.M = 2;
        } else if (this.D.o() == 2) {
            shareItem.M = 8;
        } else if (this.D.o() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.D.A != null) {
            shareItem.j0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.f47419c = str5;
        originalThreadInfo.f47417a = 3;
        originalThreadInfo.f47418b = str3;
        originalThreadInfo.f47422f = str;
        originalThreadInfo.p = this.D.A;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 12);
        statisticItem.param("nid", this.D.f26805g);
        BaijiahaoData baijiahaoData2 = this.D.A;
        if (baijiahaoData2 != null && !c.a.e.e.p.k.isEmpty(baijiahaoData2.oriUgcVid)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.A.oriUgcVid);
        }
        if (this.D.o() == 1) {
            statisticItem.param("card_type", 2);
        } else if (this.D.o() == 2) {
            statisticItem.param("card_type", 8);
        } else if (this.D.o() == 3) {
            statisticItem.param("card_type", 6);
        }
        statisticItem.param("recom_source", this.D.q);
        statisticItem.param("ab_tag", this.D.t);
        statisticItem.param("weight", this.D.r);
        statisticItem.param("extra", this.D.s);
        statisticItem.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        TbPageContext<?> tbPageContext = this.C;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && c.a.q0.n0.c.j(this.C.getPageActivity()) != null && c.a.q0.n0.c.j(this.C.getPageActivity()).b() != null && !TextUtils.isEmpty(c.a.q0.n0.c.j(this.C.getPageActivity()).b().locatePage) && "a002".equals(c.a.q0.n0.c.j(this.C.getPageActivity()).b().locatePage)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
        }
        TiebaStatic.log(statisticItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f15550g, shareItem, true, true);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
        c.a.r0.e0.f.b().k(shareDialogConfig);
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.b0.L();
        }
    }

    /* loaded from: classes4.dex */
    public class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f27521a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f27522b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f27523c;

        /* renamed from: c.a.r0.w0.p2.a$s$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1294a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f27524e;

            public RunnableC1294a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27524e = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.e.e.m.e.a().removeCallbacks(this.f27524e.f27522b);
                    this.f27524e.g(2);
                }
            }
        }

        public s(a aVar) {
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
            this.f27523c = aVar;
            this.f27521a = -1;
            this.f27522b = new RunnableC1294a(this);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f27522b);
                c.a.e.e.m.e.a().postDelayed(this.f27522b, 3000L);
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f27521a;
                if (i2 == i3) {
                    return i3;
                }
                this.f27523c.T.setVisibility(8);
                this.f27523c.a0(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f27521a;
                if (i2 == i3) {
                    return i3;
                }
                this.f27523c.T.setVisibility(0);
                this.f27523c.a0(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f27521a;
                if (i2 == i3) {
                    return i3;
                }
                this.f27523c.T.setVisibility(0);
                if (i3 != 3 || this.f27523c.D.F) {
                    this.f27523c.a0(false);
                    return i2;
                }
                return i2;
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27521a : invokeV.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                if (i2 == 0) {
                    this.f27521a = c(i2);
                    b();
                } else if (i2 == 1) {
                    this.f27521a = c(i2);
                    c.a.e.e.m.e.a().removeCallbacks(this.f27522b);
                } else if (i2 == 2) {
                    this.f27521a = e(i2);
                } else if (i2 != 3) {
                    this.f27521a = e(i2);
                } else {
                    this.f27521a = d(i2);
                    b();
                }
            }
        }

        public /* synthetic */ s(a aVar, j jVar) {
            this(aVar);
        }
    }
}
