package c.a.t0.d1.a3;

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
import c.a.e.m.d;
import c.a.t0.d1.s1.g;
import c.a.t0.z2.c;
import c.a.t0.z2.h;
import c.a.t0.z2.t;
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
/* loaded from: classes7.dex */
public class a extends c.a.t0.g0.b<c.a.t0.d1.s1.g> implements c.a.t0.d1.s1.c, c.a.t0.x1.o.l.j, c.a.t0.x1.o.l.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public TextView B;
    public TbPageContext<?> C;
    public c.a.t0.d1.s1.g D;
    public int E;
    public c.a.t0.d1.s1.h F;
    public t G;
    public t H;
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
    public c.a.t0.d1.a3.c U;
    public Animation V;
    public Animation W;
    public c.a.t0.d1.a3.j.a X;
    public c.a.t0.x1.o.l.f Y;
    public s Z;
    public VideoNetworkStateTipView a0;
    public c.a.e.m.d b0;
    public c.a.t0.d1.a3.b c0;
    public c.a.z.c d0;
    public c.a.t0.x1.o.l.g e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;
    public long i0;
    public int k0;
    public FrameLayout m;
    public FrameLayout n;
    public ExpandableTextView o;
    public View p;
    public HeadImageView q;
    public Animation.AnimationListener q0;
    public TextView r;
    public Animation.AnimationListener r0;
    public AgreeView s;
    public Runnable s0;
    public TextView t;
    public Runnable t0;
    public ImageView u;
    public View v;
    public TextView w;
    public ImageView x;
    public View y;
    public c.a.t0.z2.c z;

    /* renamed from: c.a.t0.d1.a3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0991a implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.g f16070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16071f;

        public C0991a(a aVar, c.a.t0.d1.s1.g gVar) {
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
            this.f16071f = aVar;
            this.f16070e = gVar;
        }

        @Override // c.a.t0.z2.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f16071f.i0 <= 0) {
                    this.f16071f.i0 = i3;
                }
                a aVar = this.f16071f;
                g.a aVar2 = aVar.D.z.o;
                boolean z = true;
                if (aVar2 == null) {
                    if (i3 >= i2) {
                        c.a.e.m.d dVar = aVar.b0;
                        boolean z2 = this.f16071f.K;
                        c.a.t0.z2.c cVar = this.f16071f.z;
                        dVar.I(z2, cVar != null && cVar.S0(), "VIDEO_LIST");
                    } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                        aVar.b0.K(this.f16071f.S(this.f16070e));
                    }
                }
                if (aVar2 == null || this.f16071f.K || this.f16071f.z.S0() || c.a.z.b.b().a(aVar2.f16872d)) {
                    return;
                }
                boolean z3 = this.f16071f.i0 >= (aVar2.a * 1000) + 1000;
                long j2 = i3;
                if ((j2 < aVar2.a * 1000 || j2 >= aVar2.f16870b * 1000) ? false : false) {
                    if (this.f16071f.d0.c()) {
                        return;
                    }
                    c.a.z.a aVar3 = new c.a.z.a();
                    aVar3.f27688b = aVar2.f16873e;
                    aVar3.f27689c = aVar2.f16874f;
                    aVar3.f27690d = aVar2.f16872d;
                    aVar3.a = aVar2.f16871c;
                    c.a.t0.d1.s1.g gVar = this.f16071f.D;
                    aVar3.f27692f = gVar != null ? gVar.f16863e : null;
                    c.a.t0.d1.s1.g gVar2 = this.f16071f.D;
                    aVar3.f27691e = gVar2 != null ? gVar2.f16864f : null;
                    aVar3.f27693g = 3;
                    if (z3) {
                        this.f16071f.d0.f(aVar3, (ViewGroup) this.f16071f.z.E0());
                    } else {
                        this.f16071f.d0.e(aVar3, (ViewGroup) this.f16071f.z.E0());
                    }
                } else if (this.f16071f.d0.c()) {
                    this.f16071f.d0.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.a f16072e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16073f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f16074g;

        public b(a aVar, c.a.t0.d1.s1.a aVar2, int i2) {
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
            this.f16074g = aVar;
            this.f16072e = aVar2;
            this.f16073f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.m.d dVar = this.f16074g.b0;
                boolean z = this.f16074g.K;
                c.a.t0.z2.c cVar = this.f16074g.z;
                if (dVar.I(z, cVar != null && cVar.S0(), "VIDEO_LIST")) {
                    return;
                }
                if (this.f16074g.K) {
                    this.f16074g.L = true;
                    this.f16074g.M = true;
                    this.f16074g.J = false;
                }
                if (this.f16072e == null || this.f16074g.K) {
                    return;
                }
                this.f16072e.a(this.f16073f);
                this.f16074g.z.Z0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.a f16075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16076f;

        public c(a aVar, c.a.t0.d1.s1.a aVar2) {
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
            this.f16076f = aVar;
            this.f16075e = aVar2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                c.a.t0.d1.s1.g gVar = this.f16076f.D;
                if (gVar != null && gVar.z != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", this.f16076f.D.z.f16889d);
                }
                c.a.t0.d1.s1.a aVar = this.f16075e;
                if (aVar != null) {
                    aVar.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.InterfaceC0124d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.t0.d1.s1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16077b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f16078c;

        public d(a aVar, c.a.t0.d1.s1.a aVar2, int i2) {
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
            this.f16078c = aVar;
            this.a = aVar2;
            this.f16077b = i2;
        }

        @Override // c.a.e.m.d.InterfaceC0124d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f16078c.K) {
                    this.f16078c.L = true;
                    this.f16078c.M = true;
                    this.f16078c.J = false;
                }
                if (this.a == null || this.f16078c.K) {
                    return;
                }
                this.a.a(this.f16077b);
                this.f16078c.z.Z0();
            }
        }

        @Override // c.a.e.m.d.InterfaceC0124d
        public void b() {
            c.a.t0.z2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f16078c.z) == null) {
                return;
            }
            cVar.e1(4);
        }

        @Override // c.a.e.m.d.InterfaceC0124d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f16078c.M = false;
            }
        }

        @Override // c.a.e.m.d.InterfaceC0124d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16078c.O() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.S == null) {
                return;
            }
            this.a.S.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.a.S == null) {
                return;
            }
            this.a.S.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.S == null) {
                return;
            }
            this.a.S.setVisibility(0);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.a.S == null) {
                return;
            }
            this.a.S.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.d1.s1.g f16079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16080f;

        public g(a aVar, c.a.t0.d1.s1.g gVar) {
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
            this.f16080f = aVar;
            this.f16079e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f16079e.i().hasAgree && this.f16079e.i().agreeType == 2) {
                this.f16080f.Z.g(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16081e;

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
            this.f16081e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16081e.A.getVisibility() == 0) {
                this.f16081e.A.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16082e;

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
            this.f16082e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.t0.z2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f16082e.z) == null) {
                return;
            }
            cVar.j2();
        }
    }

    /* loaded from: classes7.dex */
    public class j implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16083e;

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
            this.f16083e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            a aVar;
            c.a.t0.d1.a3.j.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.f16083e).X) == null) {
                return;
            }
            g.c cVar = aVar.D.z;
            if (cVar.f16890e > 8) {
                aVar2.a(aVar.I, cVar.f16889d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements c.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.z2.c.r
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.Z == null) {
                return;
            }
            if (z) {
                this.a.Z.g(0);
            } else {
                this.a.Z.g(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements c.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.z2.c.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.a.i0 = -1L;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16085f;

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
            this.f16085f = aVar;
            this.f16084e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f16084e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f16085f.i().getPageActivity()), new String[]{this.f16084e}, true);
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16086e;

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
            this.f16086e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK));
                this.f16086e.a0.setHasAgreeToPlay(true);
                this.f16086e.z.m1(false);
                this.f16086e.a0.showPlayTips();
                if (this.f16086e.b0.r()) {
                    this.f16086e.b0.E();
                    return;
                }
                a aVar = this.f16086e;
                c.a.t0.d1.s1.g gVar = aVar.D;
                if (gVar == null || (cVar = gVar.z) == null) {
                    return;
                }
                aVar.z.c2(cVar.f16889d, gVar.f16864f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.D.H = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.z2.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.P();
                if (this.a.b0 != null) {
                    this.a.b0.x();
                }
            }
        }

        @Override // c.a.t0.z2.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.Q();
                this.a.z.T0();
                if (this.a.L || (this.a.b0 != null && this.a.b0.r())) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.t0);
                    c.a.d.f.m.e.a().post(this.a.t0);
                }
                if (this.a.b0 != null) {
                    this.a.b0.y();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.z2.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.a;
                aVar.onClick(aVar.m);
            }
        }

        @Override // c.a.t0.z2.c.c0
        public void b() {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.t0.d1.s1.g gVar = this.a.D;
                if (gVar != null && (cVar = gVar.z) != null && c.a.d.f.m.b.e(cVar.f16892g, 0) > c.a.d.f.m.b.e(this.a.D.z.f16891f, 0)) {
                    this.a.z.L1(false, false);
                } else {
                    this.a.z.L1(true, false);
                }
                this.a.L = false;
                a aVar = this.a;
                aVar.f0(aVar.N ? "1" : "2");
                a aVar2 = this.a;
                aVar2.onClick(aVar2.n);
                if (this.a.Y != null) {
                    this.a.Y.h(this.a);
                }
                if (this.a.e0 != null) {
                    this.a.e0.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements c.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.z2.c.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                a aVar = this.a;
                c.a.t0.z2.c cVar = aVar.z;
                c.a.t0.d1.s1.g gVar = aVar.D;
                cVar.c2(gVar.z.f16889d, gVar.f16864f);
                this.a.f0("2");
                a aVar2 = this.a;
                aVar2.onClick(aVar2.n);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, c.a.t0.d1.a3.b bVar) {
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
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        this.i0 = -1L;
        this.k0 = 0;
        this.q0 = new e(this);
        this.r0 = new f(this);
        this.s0 = new h(this);
        this.t0 = new i(this);
        this.Q = str;
        this.R = str2;
        this.c0 = bVar;
        View j2 = j();
        this.C = tbPageContext;
        this.m = (FrameLayout) j2.findViewById(R.id.video_agg_container);
        this.p = j2.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) j2.findViewById(R.id.video_container);
        this.n = frameLayout;
        c.a.t0.z2.c cVar = new c.a.t0.z2.c(tbPageContext, frameLayout, false);
        this.z = cVar;
        cVar.N1("2005");
        this.z.p1(z);
        this.z.J1(new j(this));
        this.z.o1(new k(this));
        this.z.M1(new l(this));
        this.o = (ExpandableTextView) j2.findViewById(R.id.title);
        this.q = (HeadImageView) j2.findViewById(R.id.user_icon);
        this.r = (TextView) j2.findViewById(R.id.user_name);
        this.s = (AgreeView) j2.findViewById(R.id.agree_view);
        c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
        fVar.f13686c = 2;
        fVar.f13691h = 6;
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
        String p2 = c.a.s0.s.g0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.B.setText(p2);
        }
        this.B.setOnClickListener(new m(this, c.a.s0.s.g0.b.j().p("nani_key_download_link_url", null)));
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
        int k2 = c.a.d.f.p.n.k(tbPageContext.getPageActivity());
        this.E = k2;
        this.k0 = k2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.E * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.q.setIsRound(true);
        this.q.setPlaceHolder(1);
        this.F = new c.a.t0.d1.s1.h(this.C, this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.V = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.V.setAnimationListener(this.r0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.W = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.W.setAnimationListener(this.q0);
        this.Z = new s(this, null);
        this.b0 = new c.a.e.m.d(getContext(), this.n);
        this.d0 = new c.a.z.c(this.f18211g);
    }

    public final boolean O() {
        InterceptResult invokeV;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.z != null && this.n != null && (tbPageContext = this.C) != null && tbPageContext.getPageActivity() != null && this.C.getPageActivity().getWindow() != null && (this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
                if (this.n.getParent() != null) {
                    if (this.n.getParent() == frameLayout) {
                        if (this.f0) {
                            this.f0 = false;
                            return true;
                        } else if (!this.g0) {
                            this.g0 = true;
                            return true;
                        }
                    } else if (this.n.getParent() == this.m) {
                        if (this.g0) {
                            this.g0 = false;
                            this.h0 = true;
                            return true;
                        } else if (!this.f0 && this.h0) {
                            this.f0 = true;
                            this.h0 = false;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
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
        c.a.z.c cVar = this.d0;
        if (cVar != null && cVar.c()) {
            this.d0.a();
        }
        c.a.s0.e1.j.m().n(true);
    }

    public final void Q() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = false;
        if (this.n.getParent() != null) {
            if (this.n.getParent() == frameLayout) {
                R();
                frameLayout.removeView(this.n);
            } else if (this.n.getParent() == this.m) {
                R();
                this.m.removeView(this.n);
            }
        }
        if (this.n.getParent() != null) {
            return;
        }
        this.m.addView(this.n, 0);
        h0();
        this.z.q0();
        this.i0 = -1L;
        c.a.s0.e1.j.m().n(false);
    }

    public final void R() {
        c.a.e.m.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dVar = this.b0) != null && dVar.r()) {
            this.b0.F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.e.m.a S(c.a.t0.d1.s1.g gVar) {
        InterceptResult invokeL;
        int i2;
        g.c cVar;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            c.a.t0.d1.a3.b bVar = this.c0;
            c.a.e.m.e.b c2 = bVar != null ? bVar.c(gVar.k()) : null;
            if (c2 == null) {
                return null;
            }
            int c3 = c2.c();
            int b2 = c2.b();
            int a = c2.a();
            int i5 = -1;
            if (a != -1) {
                int i6 = c3 != -1 ? (a - c3) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a) - 1;
                    cVar = gVar.z;
                    if (cVar == null) {
                        i3 = c.a.d.f.m.b.e(cVar.f16891f, 0);
                        i4 = c.a.d.f.m.b.e(gVar.z.f16892g, 0);
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", gVar.f16864f);
                    hashMap.put("video_title", gVar.x);
                    hashMap.put("forum_id", gVar.f16863e);
                    hashMap.put("forum_name", "");
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    c.a.e.m.a h2 = c.a.e.m.c.h(3, 0, "1546857125210", a + 1, i3, i4);
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
            hashMap2.put("video_vid", gVar.f16864f);
            hashMap2.put("video_title", gVar.x);
            hashMap2.put("forum_id", gVar.f16863e);
            hashMap2.put("forum_name", "");
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.e.m.a h22 = c.a.e.m.c.h(3, 0, "1546857125210", a + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.e.m.a) invokeL.objValue;
    }

    public final void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
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

    public final void U(c.a.t0.d1.s1.g gVar, int i2, c.a.t0.d1.s1.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), aVar, Boolean.valueOf(z)}) == null) || gVar == null || gVar.z == null) {
            return;
        }
        this.z.j2();
        this.z.r1(true);
        this.z.u1(true);
        this.z.s1(true);
        this.z.L1(false, false);
        this.z.K1(i2);
        this.z.x1(new p(this));
        this.z.F1(new q(this));
        this.z.z1(new r(this));
        this.z.n1(false);
        c.a.z.c cVar = this.d0;
        if (cVar != null) {
            cVar.d();
        }
        this.i0 = -1L;
        if (this.z.I0() != null && this.z.I0().getMediaProgressObserver() != null) {
            this.z.I0().getMediaProgressObserver().j(new C0991a(this, gVar));
        }
        t tVar = new t();
        this.G = tVar;
        tVar.f26871c = gVar.f16864f;
        tVar.t = gVar.f16865g;
        tVar.f26872d = gVar.f16863e;
        tVar.f26873e = TbadkCoreApplication.getCurrentAccount();
        t tVar2 = this.G;
        tVar2.a = "13";
        tVar2.f26874f = gVar.q;
        tVar2.f26875g = gVar.r;
        tVar2.f26877i = this.Q;
        tVar2.l = gVar.t;
        tVar2.f26879k = this.R;
        tVar2.o = gVar.s;
        tVar2.p = "0";
        tVar2.f26878j = gVar.o();
        t tVar3 = new t();
        this.H = tVar3;
        tVar3.f26871c = gVar.f16864f;
        tVar3.f26872d = gVar.f16863e;
        tVar3.f26873e = TbadkCoreApplication.getCurrentAccount();
        t tVar4 = this.H;
        tVar4.f26875g = "auto_midpage";
        tVar4.a = "auto_midpage";
        tVar4.f26877i = this.Q;
        tVar4.f26874f = gVar.q;
        tVar4.p = "0";
        g.c cVar2 = gVar.z;
        if (cVar2 != null) {
            t tVar5 = this.G;
            String str = cVar2.f16888c;
            tVar5.m = str;
            tVar4.m = str;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar.f16864f);
        statisticItem.param("nid", gVar.f16865g);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("fid", gVar.f16863e);
        statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(gVar.r) ? "0" : gVar.r);
        statisticItem.param("extra", c.a.d.f.p.m.isEmpty(gVar.s) ? "0" : gVar.s);
        statisticItem.param("obj_id", this.R);
        statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(gVar.t) ? "0" : gVar.t);
        statisticItem.param("obj_type", this.Q);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.o());
        statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(gVar.q) ? "0" : gVar.q);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 0);
        BaijiahaoData baijiahaoData = gVar.A;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, gVar.A.oriUgcVid);
        }
        TiebaStatic.log(statisticItem);
        this.z.I0().setVideoStatData(this.G);
        this.z.q0();
        this.z.H1(new b(this, aVar, i2));
        this.z.I1(new c(this, aVar));
        if (!z || !gVar.F) {
            this.b0.B();
        }
        this.b0.G(new d(this, aVar, i2));
        this.z.R1(gVar.z.f16895j);
        this.z.S1(gVar.z.f16890e);
        this.z.X1(gVar.z.f16889d, gVar.f16864f);
        this.z.l1(gVar.f16863e);
        this.z.Z0();
        this.z.Z1();
        q0(false);
        if (gVar.F) {
            onClick(this.n);
            if (this.a0.isShowNetworkTips()) {
                this.z.b2(false);
                this.a0.showNetWorkTips();
                this.z.m1(true);
                if (this.b0.r()) {
                    this.b0.L();
                    this.b0.J();
                }
            } else {
                this.z.m1(false);
                this.z.b2(false);
                this.a0.hide();
                c.a.e.m.d dVar = this.b0;
                if (dVar == null || (dVar != null && !dVar.r())) {
                    this.z.h2(gVar.z.f16889d, gVar.f16864f, null, new Object[0]);
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
            this.z.b2(true);
            this.Z.g(3);
        }
        this.L = false;
        this.M = false;
        if (z || !this.b0.r()) {
            return;
        }
        stopPlay();
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            s sVar = this.Z;
            if (sVar != null) {
                return sVar.f() == 2 || this.Z.f() == 3;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                int parseInt = Integer.parseInt(this.D.z.f16891f);
                return parseInt <= 0 || ((float) Integer.parseInt(this.D.z.f16892g)) / ((float) parseInt) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b0.r() : invokeV.booleanValue;
    }

    public void Y(c.a.t0.d1.s1.g gVar, int i2, c.a.t0.d1.s1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, gVar, i2, aVar) == null) {
            this.D = gVar;
            this.N = gVar.F;
            U(gVar, i2, aVar, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: Z */
    public void k(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
        }
    }

    public void a0(c.a.t0.d1.s1.g gVar, int i2, c.a.t0.d1.s1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048588, this, gVar, i2, aVar) == null) || gVar == null || gVar.z == null) {
            return;
        }
        boolean z = this.D == gVar;
        this.D = gVar;
        this.N = gVar.F;
        this.P = false;
        q0(false);
        this.o.setVisibility(0);
        this.o.setTextSize(c.a.d.f.p.n.f(getContext(), R.dimen.tbfontsize40));
        this.o.setTextColor(R.color.CAM_X0101);
        this.o.setLineSpacingExtra(c.a.d.f.p.n.f(getContext(), R.dimen.tbds14));
        g.c cVar = gVar.z;
        if (cVar != null && !StringUtils.isNull(cVar.n)) {
            this.o.setTextMaxLine(2);
            this.o.setExpandable(false);
            c.a.t0.d1.a3.k.a.a(this.f18211g, this.o.getContentView(), gVar.x, gVar.z.n, gVar.k());
        } else {
            this.o.setTextMaxLine(Integer.MAX_VALUE);
            this.o.setExpandable(true);
            this.o.setOnStatusChangedListener(new o(this));
            this.o.setData(gVar.x, gVar.H, gVar.E);
        }
        int k2 = c.a.d.f.p.n.k(this.f18211g);
        this.E = k2;
        if (k2 != this.k0) {
            this.z.b1();
            this.k0 = this.E;
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        }
        g0();
        U(gVar, i2, aVar, z);
        p0(gVar);
        l(this.C, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.t0.d1.s1.c
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.D == null) {
            return;
        }
        this.s.onAgreeClick();
    }

    public void b0(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, configuration) == null) || this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        if (this.J) {
            this.z.j1();
        }
        if (configuration.orientation == 2) {
            configuration.orientation = 2;
            P();
        } else {
            configuration.orientation = 1;
            Q();
            this.J = true;
        }
        this.z.U0(this.C, configuration);
    }

    @Override // c.a.t0.d1.s1.c
    public void c(boolean z) {
        c.a.t0.d1.s1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (gVar = this.D) == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f16878e = z;
    }

    public boolean c0(int i2) {
        InterceptResult invokeI;
        c.a.e.m.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 == 4 && (dVar = this.b0) != null && ((dVar.r() || this.M) && this.z != null)) {
                this.b0.D(i2);
                if (this.K) {
                    if (this.b0.a()) {
                        this.z.p2();
                        return true;
                    }
                    this.z.l2();
                    return true;
                }
            }
            return this.z.e1(i2);
        }
        return invokeI.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && isPlaying()) {
            this.z.V0();
        }
    }

    public void e0() {
        c.a.t0.z2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (cVar = this.z) == null) {
            return;
        }
        cVar.v0();
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? R.layout.card_video_middle_page_layout : invokeV.intValue;
    }

    public final void f0(String str) {
        c.a.t0.d1.s1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (gVar = this.D) == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.t0.z2.j.e(this.D.z.f16888c, "", str, this.H, this.z.I0().getPcdnState());
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!W()) {
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

    public final void h0() {
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!W()) {
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

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.b0.E();
        }
    }

    @Override // c.a.t0.x1.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.z.T0() : invokeV.booleanValue;
    }

    public void j0(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, gVar) == null) || gVar == null) {
            return;
        }
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.f16869k;
        if (j2 > 0) {
            this.t.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.t.setText(this.f18211g.getString(R.string.reply));
        }
    }

    public void k0(boolean z) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || (frameLayout = this.m) == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 4);
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, tbPageContext, i2) == null) {
            this.s.onChangeSkinType(i2);
            this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.o.onChangeSkinType();
        }
    }

    public void l0(c.a.t0.x1.o.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) {
            this.e0 = gVar;
        }
    }

    public void m0(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.i() != null) {
            gVar.i().isInThread = true;
            gVar.i().nid = gVar.f16865g;
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

    public void n0(c.a.t0.d1.s1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) || gVar == null) {
            return;
        }
        this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.l;
        if (j2 > 0) {
            this.w.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.w.setText(this.f18211g.getString(R.string.share));
        }
    }

    public final void o0(c.a.t0.d1.s1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, gVar) == null) || (bVar = gVar.y) == null) {
            return;
        }
        if (!StringUtils.isNull(bVar.f16877d) && gVar.y.f16877d.startsWith("http")) {
            this.q.startLoad(gVar.y.f16877d, 10, false);
        } else {
            this.q.startLoad(gVar.y.f16877d, 12, false);
        }
        this.q.setBjhAuthIconRes(0);
        g.b bVar2 = gVar.y;
        boolean z = bVar2.f16880g;
        if (z) {
            this.q.setShowV(z);
            this.q.setIsBigV(gVar.y.f16880g);
        } else {
            boolean z2 = bVar2.f16879f;
            if (z2) {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f16879f);
            } else {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f16879f);
            }
        }
        this.q.setGodIconWidth(R.dimen.tbds36);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        c.a.t0.d1.a3.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
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
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f18211g);
                    pbActivityConfig.createNormalCfg(this.D.f16864f, null, null);
                    pbActivityConfig.setVideo_source("auto_midpage");
                    pbActivityConfig.setBjhData(this.D.A);
                    pbActivityConfig.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                } else if (view != this.o && view != this.p) {
                    if (view == this.y) {
                        this.Z.g(0);
                        r0();
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
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f18211g);
                    pbActivityConfig2.createNormalCfg(this.D.f16864f, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    pbActivityConfig2.setBjhData(this.D.A);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                    return;
                }
            }
            c.a.t0.d1.s1.g gVar = this.D;
            if (gVar == null || (bVar = gVar.y) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            this.Z.g(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.C.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.D.y.a, 0L), (TbadkCoreApplication.isLogin() && this.D.y.a.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false, this.D.y.f16879f)));
        }
    }

    @Override // c.a.t0.x1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            e0();
            c.a.t0.d1.s1.h hVar = this.F;
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

    public void p0(c.a.t0.d1.s1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, gVar) == null) || gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.r.setText(TextUtils.isEmpty(bVar.f16876c) ? gVar.y.f16875b : gVar.y.f16876c);
        o0(gVar);
        m0(gVar);
        j0(gVar);
        n0(gVar);
    }

    @Override // c.a.t0.x1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            d0();
        }
    }

    public final void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            c.a.t0.d1.a3.j.a aVar = this.X;
            boolean z2 = this.I == (aVar == null ? -1 : aVar.b());
            this.O = z2;
            if (z2 && z && isPlaying() && this.N && !this.P) {
                this.A.setVisibility(0);
                this.P = true;
                this.A.postDelayed(this.s0, 5000L);
                c.a.t0.d1.a3.j.a aVar2 = this.X;
                if (aVar2 != null) {
                    aVar2.c(System.currentTimeMillis());
                    return;
                }
                return;
            }
            this.A.setVisibility(8);
            Runnable runnable = this.s0;
            if (runnable != null) {
                this.A.removeCallbacks(runnable);
            }
        }
    }

    public final void r0() {
        c.a.t0.d1.s1.g gVar;
        String str;
        String str2;
        String format;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (gVar = this.D) == null || this.f18211g == null) {
            return;
        }
        String valueOf = String.valueOf(gVar.f16863e);
        c.a.t0.d1.s1.g gVar2 = this.D;
        String str3 = gVar2.x;
        BaijiahaoData baijiahaoData = gVar2.A;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.D.A.oriUgcType + "&dvid=" + this.D.A.oriUgcVid + "&nid=" + this.D.A.oriUgcNid;
        } else {
            str = gVar2.f16864f;
            str2 = "?share=9105&fr=share";
        }
        String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str5 = this.D.z.f16895j;
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = this.D.x;
        String string = this.f18211g.getResources().getString(R.string.share_content_tpl);
        String string2 = this.f18211g.getResources().getString(R.string.default_share_content_tpl);
        c.a.t0.d1.s1.g gVar3 = this.D;
        if (gVar3.A != null && (bVar = gVar3.y) != null) {
            format = MessageFormat.format(string2, bVar.f16876c, this.f18211g.getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str3, str6);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        c.a.t0.d1.s1.g gVar4 = this.D;
        if (gVar4.A != null) {
            shareItem.D = format;
            shareItem.R = -1L;
        } else {
            shareItem.D = str6;
            shareItem.R = gVar4.f16868j;
        }
        shareItem.t = str4;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = "";
        shareItem.K = str;
        shareItem.f42237f = true;
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
            shareItem.m0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.f41551c = str5;
        originalThreadInfo.a = 3;
        originalThreadInfo.f41550b = str3;
        originalThreadInfo.f41554f = str;
        originalThreadInfo.p = this.D.A;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 12);
        statisticItem.param("nid", this.D.f16865g);
        BaijiahaoData baijiahaoData2 = this.D.A;
        if (baijiahaoData2 != null && !c.a.d.f.p.m.isEmpty(baijiahaoData2.oriUgcVid)) {
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
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && c.a.s0.p0.c.j(this.C.getPageActivity()) != null && c.a.s0.p0.c.j(this.C.getPageActivity()).b() != null && !TextUtils.isEmpty(c.a.s0.p0.c.j(this.C.getPageActivity()).b().locatePage) && "a002".equals(c.a.s0.p0.c.j(this.C.getPageActivity()).b().locatePage)) {
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
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f18211g, shareItem, true, true);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
        c.a.t0.k0.h.c().l(shareDialogConfig);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.b0.L();
        }
    }

    @Override // c.a.t0.x1.o.l.h
    public void setAutoPlayCallBack(c.a.t0.d1.s1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
        }
    }

    @Override // c.a.t0.x1.o.l.h
    public void setCurrentPlayCallBack(c.a.t0.x1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    @Override // c.a.t0.x1.o.l.h
    public void setOnVideoContainerForegroundClickListener(c.a.t0.d1.a3.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cVar) == null) {
            this.U = cVar;
        }
    }

    @Override // c.a.t0.d1.s1.c
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.C.showToast(str);
        }
    }

    @Override // c.a.t0.x1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            t0();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.P = false;
            this.z.j2();
            ExpandableTextView expandableTextView = this.o;
            if (expandableTextView != null) {
                expandableTextView.setVisibility(0);
            }
            s sVar = this.Z;
            if (sVar != null) {
                sVar.g(2);
            }
            q0(false);
            this.O = true;
            c.a.e.m.d dVar = this.b0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            this.b0.L();
        }
    }

    /* loaded from: classes7.dex */
    public class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f16087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f16088c;

        /* renamed from: c.a.t0.d1.a3.a$s$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0992a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f16089e;

            public RunnableC0992a(s sVar) {
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
                this.f16089e = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.f16089e.f16087b);
                    this.f16089e.g(2);
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
            this.f16088c = aVar;
            this.a = -1;
            this.f16087b = new RunnableC0992a(this);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f16087b);
                c.a.d.f.m.e.a().postDelayed(this.f16087b, 3000L);
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.a;
                if (i2 == i3) {
                    return i3;
                }
                this.f16088c.T.setVisibility(8);
                this.f16088c.T(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.a;
                if (i2 == i3) {
                    return i3;
                }
                this.f16088c.T.setVisibility(0);
                this.f16088c.T(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.a;
                if (i2 == i3) {
                    return i3;
                }
                this.f16088c.T.setVisibility(0);
                if (i3 != 3 || this.f16088c.D.F) {
                    this.f16088c.T(false);
                    return i2;
                }
                return i2;
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                if (i2 == 0) {
                    this.a = c(i2);
                    b();
                } else if (i2 == 1) {
                    this.a = c(i2);
                    c.a.d.f.m.e.a().removeCallbacks(this.f16087b);
                } else if (i2 == 2) {
                    this.a = e(i2);
                } else if (i2 != 3) {
                    this.a = e(i2);
                } else {
                    this.a = d(i2);
                    b();
                }
            }
        }

        public /* synthetic */ s(a aVar, j jVar) {
            this(aVar);
        }
    }
}
