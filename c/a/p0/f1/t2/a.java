package c.a.p0.f1.t2;

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
import c.a.p0.c3.c;
import c.a.p0.c3.h;
import c.a.p0.c3.u;
import c.a.p0.f1.j1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
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
/* loaded from: classes2.dex */
public class a extends c.a.p0.h0.b<c.a.p0.f1.j1.g> implements c.a.p0.f1.j1.c, c.a.p0.b2.o.l.j, c.a.p0.b2.o.l.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.p0.f1.j1.h B;
    public u C;
    public u D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public String M;
    public String N;
    public View O;
    public View P;
    public c.a.p0.f1.t2.c Q;
    public Animation R;
    public Animation S;
    public c.a.p0.f1.t2.j.a T;
    public c.a.p0.b2.o.l.f U;
    public s V;
    public VideoNetworkStateTipView W;
    public c.a.e.m.d X;
    public c.a.p0.f1.t2.b Y;
    public c.a.x.c Z;
    public c.a.p0.b2.o.l.g g0;
    public boolean h0;
    public FrameLayout i;
    public boolean i0;
    public FrameLayout j;
    public boolean j0;
    public ExpandableTextView k;
    public long k0;
    public View l;
    public int l0;
    public HeadImageView m;
    public Animation.AnimationListener m0;
    public TextView n;
    public Animation.AnimationListener n0;
    public AgreeView o;
    public Runnable o0;
    public TextView p;
    public Runnable p0;
    public ImageView q;
    public View r;
    public TextView s;
    public ImageView t;
    public View u;
    public c.a.p0.c3.c v;
    public FrameLayout w;
    public TextView x;
    public TbPageContext<?> y;
    public c.a.p0.f1.j1.g z;

    /* renamed from: c.a.p0.f1.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1110a implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14655b;

        public C1110a(a aVar, c.a.p0.f1.j1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14655b = aVar;
            this.a = gVar;
        }

        @Override // c.a.p0.c3.h.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.f14655b.k0 <= 0) {
                    this.f14655b.k0 = i2;
                }
                a aVar = this.f14655b;
                g.a aVar2 = aVar.z.v.o;
                boolean z = true;
                if (aVar2 == null) {
                    if (i2 >= i) {
                        c.a.e.m.d dVar = aVar.X;
                        boolean z2 = this.f14655b.G;
                        c.a.p0.c3.c cVar = this.f14655b.v;
                        dVar.I(z2, cVar != null && cVar.S0(), "VIDEO_LIST");
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        aVar.X.K(this.f14655b.T(this.a));
                    }
                }
                if (aVar2 == null || this.f14655b.G || this.f14655b.v.S0() || c.a.x.b.b().a(aVar2.f14132d)) {
                    return;
                }
                boolean z3 = this.f14655b.k0 >= (aVar2.a * 1000) + 1000;
                long j = i2;
                if ((j < aVar2.a * 1000 || j >= aVar2.f14130b * 1000) ? false : false) {
                    if (this.f14655b.Z.c()) {
                        return;
                    }
                    c.a.x.a aVar3 = new c.a.x.a();
                    aVar3.f21975b = aVar2.f14133e;
                    aVar3.f21976c = aVar2.f14134f;
                    aVar3.f21977d = aVar2.f14132d;
                    aVar3.a = aVar2.f14131c;
                    c.a.p0.f1.j1.g gVar = this.f14655b.z;
                    aVar3.f21979f = gVar != null ? gVar.a : null;
                    c.a.p0.f1.j1.g gVar2 = this.f14655b.z;
                    aVar3.f21978e = gVar2 != null ? gVar2.f14123b : null;
                    aVar3.f21980g = 3;
                    if (z3) {
                        this.f14655b.Z.f(aVar3, (ViewGroup) this.f14655b.v.E0());
                    } else {
                        this.f14655b.Z.e(aVar3, (ViewGroup) this.f14655b.v.E0());
                    }
                } else if (this.f14655b.Z.c()) {
                    this.f14655b.Z.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f14657c;

        public b(a aVar, c.a.p0.f1.j1.a aVar2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14657c = aVar;
            this.a = aVar2;
            this.f14656b = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.m.d dVar = this.f14657c.X;
                boolean z = this.f14657c.G;
                c.a.p0.c3.c cVar = this.f14657c.v;
                if (dVar.I(z, cVar != null && cVar.S0(), "VIDEO_LIST")) {
                    return;
                }
                if (this.f14657c.G) {
                    this.f14657c.H = true;
                    this.f14657c.I = true;
                    this.f14657c.F = false;
                }
                if (this.a == null || this.f14657c.G) {
                    return;
                }
                this.a.a(this.f14656b);
                this.f14657c.v.Z0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14658b;

        public c(a aVar, c.a.p0.f1.j1.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14658b = aVar;
            this.a = aVar2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                c.a.p0.f1.j1.g gVar = this.f14658b.z;
                if (gVar != null && gVar.v != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.f14658b.z.v.f14149d);
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
    public class d implements d.InterfaceC0114d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f14660c;

        public d(a aVar, c.a.p0.f1.j1.a aVar2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14660c = aVar;
            this.a = aVar2;
            this.f14659b = i;
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14660c.G) {
                    this.f14660c.H = true;
                    this.f14660c.I = true;
                    this.f14660c.F = false;
                }
                if (this.a == null || this.f14660c.G) {
                    return;
                }
                this.a.a(this.f14659b);
                this.f14660c.v.Z0();
            }
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void b() {
            c.a.p0.c3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f14660c.v) == null) {
                return;
            }
            cVar.e1(4);
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f14660c.I = false;
            }
        }

        @Override // c.a.e.m.d.InterfaceC0114d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14660c.P() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.O == null) {
                return;
            }
            this.a.O.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.a.O == null) {
                return;
            }
            this.a.O.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.O == null) {
                return;
            }
            this.a.O.setVisibility(0);
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || this.a.O == null) {
                return;
            }
            this.a.O.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14661b;

        public g(a aVar, c.a.p0.f1.j1.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14661b = aVar;
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.getAgreeData().hasAgree && this.a.getAgreeData().agreeType == 2) {
                this.f14661b.V.g(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w.getVisibility() == 0) {
                this.a.w.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
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

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.c3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.a.v) == null) {
                return;
            }
            cVar.j2();
        }
    }

    /* loaded from: classes2.dex */
    public class j implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public j(a aVar) {
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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            a aVar;
            c.a.p0.f1.t2.j.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.a).T) == null) {
                return;
            }
            g.c cVar = aVar.z.v;
            if (cVar.f14150e > 8) {
                aVar2.a(aVar.E, cVar.f14149d);
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.p0.c3.c.r
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.V == null) {
                return;
            }
            if (z) {
                this.a.V.g(0);
            } else {
                this.a.V.g(1);
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.p0.c3.c.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.a.k0 = -1L;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14662b;

        public m(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14662b = aVar;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f14662b.j().getPageActivity()), new String[]{this.a}, true);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public n(a aVar) {
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
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK));
                this.a.W.setHasAgreeToPlay(true);
                this.a.v.m1(false);
                this.a.W.g();
                if (this.a.X.r()) {
                    this.a.X.E();
                    return;
                }
                a aVar = this.a;
                c.a.p0.f1.j1.g gVar = aVar.z;
                if (gVar == null || (cVar = gVar.v) == null) {
                    return;
                }
                aVar.v.c2(cVar.f14149d, gVar.f14123b);
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.z.D = z;
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.p0.c3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Q();
                if (this.a.X != null) {
                    this.a.X.x();
                }
            }
        }

        @Override // c.a.p0.c3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.R();
                this.a.v.T0();
                if (this.a.H || (this.a.X != null && this.a.X.r())) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.p0);
                    c.a.d.f.m.e.a().post(this.a.p0);
                }
                if (this.a.X != null) {
                    this.a.X.y();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.p0.c3.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.a;
                aVar.onClick(aVar.i);
            }
        }

        @Override // c.a.p0.c3.c.c0
        public void b() {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.f1.j1.g gVar = this.a.z;
                if (gVar != null && (cVar = gVar.v) != null && c.a.d.f.m.b.e(cVar.f14152g, 0) > c.a.d.f.m.b.e(this.a.z.v.f14151f, 0)) {
                    this.a.v.L1(false, false);
                } else {
                    this.a.v.L1(true, false);
                }
                this.a.H = false;
                a aVar = this.a;
                aVar.g0(aVar.J ? "1" : "2");
                a aVar2 = this.a;
                aVar2.onClick(aVar2.j);
                if (this.a.U != null) {
                    this.a.U.h(this.a);
                }
                if (this.a.g0 != null) {
                    this.a.g0.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // c.a.p0.c3.c.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                a aVar = this.a;
                c.a.p0.c3.c cVar = aVar.v;
                c.a.p0.f1.j1.g gVar = aVar.z;
                cVar.c2(gVar.v.f14149d, gVar.f14123b);
                this.a.g0("2");
                a aVar2 = this.a;
                aVar2.onClick(aVar2.j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, c.a.p0.f1.t2.b bVar) {
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
        this.F = true;
        this.K = false;
        this.L = false;
        this.h0 = false;
        this.i0 = false;
        this.j0 = false;
        this.k0 = -1L;
        this.l0 = 0;
        this.m0 = new e(this);
        this.n0 = new f(this);
        this.o0 = new h(this);
        this.p0 = new i(this);
        this.M = str;
        this.N = str2;
        this.Y = bVar;
        View k2 = k();
        this.y = tbPageContext;
        this.i = (FrameLayout) k2.findViewById(R.id.obfuscated_res_0x7f09230e);
        this.l = k2.findViewById(R.id.obfuscated_res_0x7f0904f0);
        FrameLayout frameLayout = (FrameLayout) k2.findViewById(R.id.obfuscated_res_0x7f09231b);
        this.j = frameLayout;
        c.a.p0.c3.c cVar = new c.a.p0.c3.c(tbPageContext, frameLayout, false);
        this.v = cVar;
        cVar.N1("2005");
        this.v.p1(z);
        this.v.J1(new j(this));
        this.v.o1(new k(this));
        this.v.M1(new l(this));
        this.k = (ExpandableTextView) k2.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.m = (HeadImageView) k2.findViewById(R.id.obfuscated_res_0x7f0922a8);
        this.n = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.o = (AgreeView) k2.findViewById(R.id.obfuscated_res_0x7f09015d);
        c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
        fVar.f10853c = 2;
        fVar.f10858h = 6;
        this.o.setStatisticData(fVar);
        this.o.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.p = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f091fb0);
        this.q = (ImageView) k2.findViewById(R.id.obfuscated_res_0x7f091faf);
        this.r = k2.findViewById(R.id.obfuscated_res_0x7f091fac);
        this.s = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f091fb7);
        this.t = (ImageView) k2.findViewById(R.id.obfuscated_res_0x7f091ccc);
        this.u = k2.findViewById(R.id.obfuscated_res_0x7f091ccb);
        this.w = (FrameLayout) k2.findViewById(R.id.obfuscated_res_0x7f090825);
        this.x = (TextView) k2.findViewById(R.id.obfuscated_res_0x7f090826);
        this.w.setVisibility(8);
        String q2 = c.a.o0.r.j0.b.k().q("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(q2)) {
            this.x.setText(q2);
        }
        this.x.setOnClickListener(new m(this, c.a.o0.r.j0.b.k().q("nani_key_download_link_url", null)));
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) k2.findViewById(R.id.obfuscated_res_0x7f091540);
        this.W = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new n(this));
        this.O = k2.findViewById(R.id.obfuscated_res_0x7f09230f);
        this.P = k2.findViewById(R.id.obfuscated_res_0x7f092035);
        this.O.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.l.setOnClickListener(this);
        int k3 = c.a.d.f.p.n.k(tbPageContext.getPageActivity());
        this.A = k3;
        this.l0 = k3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.A * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.m.setIsRound(true);
        this.m.setPlaceHolder(1);
        this.B = new c.a.p0.f1.j1.h(this.y, this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.R = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.R.setAnimationListener(this.n0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.S = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.S.setAnimationListener(this.m0);
        this.V = new s(this, null);
        this.X = new c.a.e.m.d(getContext(), this.j);
        this.Z = new c.a.x.c(this.f15305c);
    }

    public final boolean P() {
        InterceptResult invokeV;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.v != null && this.j != null && (tbPageContext = this.y) != null && tbPageContext.getPageActivity() != null && this.y.getPageActivity().getWindow() != null && (this.y.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) this.y.getPageActivity().getWindow().getDecorView();
                if (this.j.getParent() != null) {
                    if (this.j.getParent() == frameLayout) {
                        if (this.h0) {
                            this.h0 = false;
                            return true;
                        } else if (!this.i0) {
                            this.i0 = true;
                            return true;
                        }
                    } else if (this.j.getParent() == this.i) {
                        if (this.i0) {
                            this.i0 = false;
                            this.j0 = true;
                            return true;
                        } else if (!this.h0 && this.j0) {
                            this.h0 = true;
                            this.j0 = false;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.v == null || this.j == null || (tbPageContext = this.y) == null || tbPageContext.getPageActivity() == null || this.y.getPageActivity().getWindow() == null || !(this.y.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.y.getPageActivity().getWindow().getDecorView();
        this.G = true;
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
        c.a.x.c cVar = this.Z;
        if (cVar != null && cVar.c()) {
            this.Z.a();
        }
        c.a.o0.c1.j.m().n(true);
    }

    public final void R() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.v == null || this.j == null || (tbPageContext = this.y) == null || tbPageContext.getPageActivity() == null || this.y.getPageActivity().getWindow() == null || !(this.y.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.y.getPageActivity().getWindow().getDecorView();
        this.G = false;
        if (this.j.getParent() != null) {
            if (this.j.getParent() == frameLayout) {
                S();
                frameLayout.removeView(this.j);
            } else if (this.j.getParent() == this.i) {
                S();
                this.i.removeView(this.j);
            }
        }
        if (this.j.getParent() != null) {
            return;
        }
        this.i.addView(this.j, 0);
        i0();
        this.v.q0();
        this.k0 = -1L;
        c.a.o0.c1.j.m().n(false);
    }

    public final void S() {
        c.a.e.m.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dVar = this.X) != null && dVar.r()) {
            this.X.F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.e.m.a T(c.a.p0.f1.j1.g gVar) {
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
            c.a.p0.f1.t2.b bVar = this.Y;
            c.a.e.m.e.b c2 = bVar != null ? bVar.c(gVar.g()) : null;
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
                    cVar = gVar.v;
                    if (cVar == null) {
                        i3 = c.a.d.f.m.b.e(cVar.f14151f, 0);
                        i4 = c.a.d.f.m.b.e(gVar.v.f14152g, 0);
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", gVar.f14123b);
                    hashMap.put("video_title", gVar.t);
                    hashMap.put("forum_id", gVar.a);
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
            cVar = gVar.v;
            if (cVar == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", gVar.f14123b);
            hashMap2.put("video_title", gVar.t);
            hashMap2.put("forum_id", gVar.a);
            hashMap2.put("forum_name", "");
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.e.m.a h22 = c.a.e.m.c.h(3, 0, "1546857125210", a + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.e.m.a) invokeL.objValue;
    }

    public final void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
            CustomMessage customMessage = new CustomMessage(2921317);
            if (z) {
                customMessage.setExtra("high");
            } else {
                customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
            }
            customResponsedMessage.setmOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void V(c.a.p0.f1.j1.g gVar, int i2, c.a.p0.f1.j1.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, Integer.valueOf(i2), aVar, Boolean.valueOf(z)}) == null) || gVar == null || gVar.v == null) {
            return;
        }
        this.v.j2();
        this.v.r1(true);
        this.v.u1(true);
        this.v.s1(true);
        this.v.L1(false, false);
        this.v.K1(i2);
        this.v.x1(new p(this));
        this.v.F1(new q(this));
        this.v.z1(new r(this));
        this.v.n1(false);
        c.a.x.c cVar = this.Z;
        if (cVar != null) {
            cVar.d();
        }
        this.k0 = -1L;
        if (this.v.I0() != null && this.v.I0().getMediaProgressObserver() != null) {
            this.v.I0().getMediaProgressObserver().j(new C1110a(this, gVar));
        }
        u uVar = new u();
        this.C = uVar;
        uVar.f13504c = gVar.f14123b;
        uVar.t = gVar.f14124c;
        uVar.f13505d = gVar.a;
        uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
        u uVar2 = this.C;
        uVar2.a = "13";
        uVar2.f13507f = gVar.m;
        uVar2.f13508g = gVar.n;
        uVar2.i = this.M;
        uVar2.l = gVar.p;
        uVar2.k = this.N;
        uVar2.o = gVar.o;
        uVar2.p = "0";
        uVar2.j = gVar.i();
        u uVar3 = new u();
        this.D = uVar3;
        uVar3.f13504c = gVar.f14123b;
        uVar3.f13505d = gVar.a;
        uVar3.f13506e = TbadkCoreApplication.getCurrentAccount();
        u uVar4 = this.D;
        uVar4.f13508g = "auto_midpage";
        uVar4.a = "auto_midpage";
        uVar4.i = this.M;
        uVar4.f13507f = gVar.m;
        uVar4.p = "0";
        g.c cVar2 = gVar.v;
        if (cVar2 != null) {
            u uVar5 = this.C;
            String str = cVar2.f14148c;
            uVar5.m = str;
            uVar4.m = str;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar.f14123b);
        statisticItem.param("nid", gVar.f14124c);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("fid", gVar.a);
        statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(gVar.n) ? "0" : gVar.n);
        statisticItem.param("extra", c.a.d.f.p.m.isEmpty(gVar.o) ? "0" : gVar.o);
        statisticItem.param("obj_id", this.N);
        statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(gVar.p) ? "0" : gVar.p);
        statisticItem.param("obj_type", this.M);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.i());
        statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(gVar.m) ? "0" : gVar.m);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 0);
        BaijiahaoData baijiahaoData = gVar.w;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, gVar.w.oriUgcVid);
        }
        TiebaStatic.log(statisticItem);
        this.v.I0().setVideoStatData(this.C);
        this.v.q0();
        this.v.H1(new b(this, aVar, i2));
        this.v.I1(new c(this, aVar));
        if (!z || !gVar.B) {
            this.X.B();
        }
        this.X.G(new d(this, aVar, i2));
        this.v.R1(gVar.v.j);
        this.v.S1(gVar.v.f14150e);
        this.v.X1(gVar.v.f14149d, gVar.f14123b);
        this.v.l1(gVar.a);
        this.v.Z0();
        this.v.Z1();
        r0(false);
        if (gVar.B) {
            onClick(this.j);
            if (this.W.d()) {
                this.v.b2(false);
                this.W.f();
                this.v.m1(true);
                if (this.X.r()) {
                    this.X.L();
                    this.X.J();
                }
            } else {
                this.v.m1(false);
                this.v.b2(false);
                this.W.b();
                c.a.e.m.d dVar = this.X;
                if (dVar == null || (dVar != null && !dVar.r())) {
                    this.v.h2(gVar.v.f14149d, gVar.f14123b, null, new Object[0]);
                }
            }
            if (i2 == 0 && gVar.C) {
                this.O.setVisibility(8);
                this.V.g(3);
            } else {
                if (this.O.getVisibility() == 0) {
                    this.O.startAnimation(this.S);
                }
                this.V.g(0);
            }
            gVar.C = false;
        } else {
            this.O.setVisibility(0);
            this.W.b();
            this.v.b2(true);
            this.V.g(3);
        }
        this.H = false;
        this.I = false;
        if (z || !this.X.r()) {
            return;
        }
        stopPlay();
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            s sVar = this.V;
            if (sVar != null) {
                return sVar.f() == 2 || this.V.f() == 3;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                int parseInt = Integer.parseInt(this.z.v.f14151f);
                return parseInt <= 0 || ((float) Integer.parseInt(this.z.v.f14152g)) / ((float) parseInt) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.X.r() : invokeV.booleanValue;
    }

    public void Z(c.a.p0.f1.j1.g gVar, int i2, c.a.p0.f1.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, gVar, i2, aVar) == null) {
            this.z = gVar;
            this.J = gVar.B;
            V(gVar, i2, aVar, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: a0 */
    public void l(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
        }
    }

    @Override // c.a.p0.f1.j1.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.y.showToast(str);
        }
    }

    public void b0(c.a.p0.f1.j1.g gVar, int i2, c.a.p0.f1.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048589, this, gVar, i2, aVar) == null) || gVar == null || gVar.v == null) {
            return;
        }
        boolean z = this.z == gVar;
        this.z = gVar;
        this.J = gVar.B;
        this.L = false;
        r0(false);
        this.k.setVisibility(0);
        this.k.setTextSize(c.a.d.f.p.n.f(getContext(), R.dimen.tbfontsize40));
        this.k.setTextColor(R.color.CAM_X0101);
        this.k.setLineSpacingExtra(c.a.d.f.p.n.f(getContext(), R.dimen.tbds14));
        g.c cVar = gVar.v;
        if (cVar != null && !StringUtils.isNull(cVar.n)) {
            this.k.setTextMaxLine(2);
            this.k.setExpandable(false);
            c.a.p0.f1.t2.k.a.a(this.f15305c, this.k.getContentView(), gVar.t, gVar.v.n, gVar.g());
        } else {
            this.k.setTextMaxLine(Integer.MAX_VALUE);
            this.k.setExpandable(true);
            this.k.setOnStatusChangedListener(new o(this));
            this.k.setData(gVar.t, gVar.D, gVar.A);
        }
        int k2 = c.a.d.f.p.n.k(this.f15305c);
        this.A = k2;
        if (k2 != this.l0) {
            this.v.b1();
            this.l0 = this.A;
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.j.setLayoutParams(layoutParams);
        }
        h0();
        V(gVar, i2, aVar, z);
        q0(gVar);
        m(this.y, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // c.a.p0.f1.j1.c
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.z == null) {
            return;
        }
        this.o.u();
    }

    public void c0(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, configuration) == null) || this.v == null || this.j == null || (tbPageContext = this.y) == null || tbPageContext.getPageActivity() == null || this.y.getPageActivity().getWindow() == null || !(this.y.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.y.getPageActivity().getWindow().getDecorView();
        if (this.F) {
            this.v.j1();
        }
        if (configuration.orientation == 2) {
            configuration.orientation = 2;
            Q();
        } else {
            configuration.orientation = 1;
            R();
            this.F = true;
        }
        this.v.U0(this.y, configuration);
    }

    @Override // c.a.p0.f1.j1.c
    public void d(boolean z) {
        c.a.p0.f1.j1.g gVar;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (gVar = this.z) == null || (bVar = gVar.u) == null) {
            return;
        }
        bVar.f14138e = z;
    }

    public boolean d0(int i2) {
        InterceptResult invokeI;
        c.a.e.m.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            if (i2 == 4 && (dVar = this.X) != null && ((dVar.r() || this.I) && this.v != null)) {
                this.X.D(i2);
                if (this.G) {
                    if (this.X.a()) {
                        this.v.p2();
                        return true;
                    }
                    this.v.l2();
                    return true;
                }
            }
            return this.v.e1(i2);
        }
        return invokeI.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && isPlaying()) {
            this.v.V0();
        }
    }

    public void f0() {
        c.a.p0.c3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.v) == null) {
            return;
        }
        cVar.v0();
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c8 : invokeV.intValue;
    }

    public final void g0(String str) {
        c.a.p0.f1.j1.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (gVar = this.z) == null || gVar.v == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            c.a.p0.c3.j.e(this.z.v.f14148c, "", str, this.D, this.v.I0().getPcdnState());
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!X()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = (int) (this.A * 0.875f);
                this.i.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.height = (int) (this.A * 0.5625f);
            this.i.setLayoutParams(layoutParams2);
        }
    }

    public final void i0() {
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!X()) {
                f2 = 0.875f;
                i2 = this.A;
            } else {
                f2 = 0.5625f;
                i2 = this.A;
            }
            int i3 = (int) (i2 * f2);
            if (i3 <= 0) {
                return;
            }
            this.j.setLayoutParams(new FrameLayout.LayoutParams(this.A, i3));
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v.T0() : invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.X.E();
        }
    }

    public void k0(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, gVar) == null) || gVar == null) {
            return;
        }
        this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0808e9, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.f14128g;
        if (j2 > 0) {
            this.p.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.p.setText(this.f15305c.getString(R.string.obfuscated_res_0x7f0f0f88));
        }
    }

    public void l0(boolean z) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (frameLayout = this.i) == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 4);
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, tbPageContext, i2) == null) {
            this.o.v(i2);
            this.p.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f0808ed, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0808e9, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.k.w();
        }
    }

    public void m0(c.a.p0.b2.o.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, gVar) == null) {
            this.g0 = gVar;
        }
    }

    public void n0(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.getAgreeData() != null) {
            gVar.getAgreeData().isInThread = true;
            gVar.getAgreeData().nid = gVar.f14124c;
            if (this.z.i() == 1) {
                gVar.getAgreeData().cardType = 2;
            } else if (this.z.i() == 2) {
                gVar.getAgreeData().cardType = 8;
            } else if (this.z.i() == 3) {
                gVar.getAgreeData().cardType = 6;
            }
            gVar.getAgreeData().baijiahaoData = gVar.w;
            gVar.getAgreeData().recomSource = gVar.m;
            gVar.getAgreeData().recomWeight = gVar.n;
            gVar.getAgreeData().recomAbTag = gVar.p;
            gVar.getAgreeData().recomExtra = gVar.o;
        }
        this.o.setAgreeAlone(true);
        this.o.setIsFromMiddlePage(true);
        this.o.setData(gVar.getAgreeData());
        this.o.setAfterClickListener(new g(this, gVar));
    }

    public void o0(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, gVar) == null) || gVar == null) {
            return;
        }
        this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f0808ed, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.f14129h;
        if (j2 > 0) {
            this.s.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.s.setText(this.f15305c.getString(R.string.obfuscated_res_0x7f0f1107));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        c.a.p0.f1.t2.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            if (h() != null) {
                view.setTag(this);
                h().a(view, this.z);
            }
            boolean z = true;
            if (view != this.m && view != this.n) {
                if (view == this.r) {
                    if (this.z == null) {
                        return;
                    }
                    this.V.g(0);
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f15305c);
                    pbActivityConfig.createNormalCfg(this.z.f14123b, null, null);
                    pbActivityConfig.setVideo_source("auto_midpage");
                    pbActivityConfig.setBjhData(this.z.w);
                    pbActivityConfig.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                } else if (view != this.k && view != this.l) {
                    if (view == this.u) {
                        this.V.g(0);
                        s0();
                        return;
                    }
                    View view2 = this.O;
                    if (view == view2 && view2.getVisibility() == 0 && (cVar = this.Q) != null) {
                        cVar.p0(this.E);
                        return;
                    }
                    return;
                } else if (this.z == null) {
                    return;
                } else {
                    if (this.V.f() != 2 && this.V.f() != 3) {
                        z = false;
                    }
                    this.V.g(0);
                    if (z) {
                        return;
                    }
                    PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f15305c);
                    pbActivityConfig2.createNormalCfg(this.z.f14123b, null, null);
                    pbActivityConfig2.setVideo_source("auto_midpage");
                    pbActivityConfig2.setBjhData(this.z.w);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                    return;
                }
            }
            c.a.p0.f1.j1.g gVar = this.z;
            if (gVar == null || (bVar = gVar.u) == null || TextUtils.isEmpty(bVar.a)) {
                return;
            }
            this.V.g(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.y.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.z.u.a, 0L), (TbadkCoreApplication.isLogin() && this.z.u.a.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false, this.z.u.f14139f)));
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            f0();
            c.a.p0.f1.j1.h hVar = this.B;
            if (hVar != null) {
                hVar.b();
            }
            View view = this.O;
            if (view != null) {
                view.clearAnimation();
            }
            this.X.w();
        }
    }

    public final void p0(c.a.p0.f1.j1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, gVar) == null) || (bVar = gVar.u) == null) {
            return;
        }
        if (!StringUtils.isNull(bVar.f14137d) && gVar.u.f14137d.startsWith("http")) {
            this.m.J(gVar.u.f14137d, 10, false);
        } else {
            this.m.J(gVar.u.f14137d, 12, false);
        }
        this.m.setBjhAuthIconRes(0);
        g.b bVar2 = gVar.u;
        boolean z = bVar2.f14140g;
        if (z) {
            this.m.setShowV(z);
            this.m.setIsBigV(gVar.u.f14140g);
        } else {
            boolean z2 = bVar2.f14139f;
            if (z2) {
                this.m.setShowV(z2);
                this.m.setIsBigV(gVar.u.f14139f);
            } else {
                this.m.setShowV(z2);
                this.m.setIsBigV(gVar.u.f14139f);
            }
        }
        this.m.setGodIconWidth(R.dimen.tbds36);
    }

    @Override // c.a.p0.b2.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            e0();
        }
    }

    public void q0(c.a.p0.f1.j1.g gVar) {
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, gVar) == null) || gVar == null || (bVar = gVar.u) == null) {
            return;
        }
        this.n.setText(TextUtils.isEmpty(bVar.f14136c) ? gVar.u.f14135b : gVar.u.f14136c);
        p0(gVar);
        n0(gVar);
        k0(gVar);
        o0(gVar);
    }

    public final void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            c.a.p0.f1.t2.j.a aVar = this.T;
            boolean z2 = this.E == (aVar == null ? -1 : aVar.b());
            this.K = z2;
            if (z2 && z && isPlaying() && this.J && !this.L) {
                this.w.setVisibility(0);
                this.L = true;
                this.w.postDelayed(this.o0, 5000L);
                c.a.p0.f1.t2.j.a aVar2 = this.T;
                if (aVar2 != null) {
                    aVar2.c(System.currentTimeMillis());
                    return;
                }
                return;
            }
            this.w.setVisibility(8);
            Runnable runnable = this.o0;
            if (runnable != null) {
                this.w.removeCallbacks(runnable);
            }
        }
    }

    public final void s0() {
        c.a.p0.f1.j1.g gVar;
        String str;
        String str2;
        String format;
        g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (gVar = this.z) == null || this.f15305c == null) {
            return;
        }
        String valueOf = String.valueOf(gVar.a);
        c.a.p0.f1.j1.g gVar2 = this.z;
        String str3 = gVar2.t;
        BaijiahaoData baijiahaoData = gVar2.w;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.z.w.oriUgcType + "&dvid=" + this.z.w.oriUgcVid + "&nid=" + this.z.w.oriUgcNid;
        } else {
            str = gVar2.f14123b;
            str2 = "?share=9105&fr=share";
        }
        String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str5 = this.z.v.j;
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = this.z.t;
        String string = this.f15305c.getResources().getString(R.string.obfuscated_res_0x7f0f110f);
        String string2 = this.f15305c.getResources().getString(R.string.obfuscated_res_0x7f0f047a);
        c.a.p0.f1.j1.g gVar3 = this.z;
        if (gVar3.w != null && (bVar = gVar3.u) != null) {
            format = MessageFormat.format(string2, bVar.f14136c, this.f15305c.getResources().getString(R.string.obfuscated_res_0x7f0f047b));
        } else {
            format = MessageFormat.format(string, str3, str6);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        c.a.p0.f1.j1.g gVar4 = this.z;
        if (gVar4.w != null) {
            shareItem.D = format;
            shareItem.R = -1L;
        } else {
            shareItem.D = str6;
            shareItem.R = gVar4.f14127f;
        }
        shareItem.t = str4;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = "";
        shareItem.K = str;
        shareItem.f30356f = true;
        shareItem.E = 11;
        if (this.z.i() == 1) {
            shareItem.M = 2;
        } else if (this.z.i() == 2) {
            shareItem.M = 8;
        } else if (this.z.i() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.z.w != null) {
            shareItem.m0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.f29823c = str5;
        originalThreadInfo.a = 3;
        originalThreadInfo.f29822b = str3;
        originalThreadInfo.f29826f = str;
        originalThreadInfo.p = this.z.w;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 12);
        statisticItem.param("nid", this.z.f14124c);
        BaijiahaoData baijiahaoData2 = this.z.w;
        if (baijiahaoData2 != null && !c.a.d.f.p.m.isEmpty(baijiahaoData2.oriUgcVid)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.z.w.oriUgcVid);
        }
        if (this.z.i() == 1) {
            statisticItem.param("card_type", 2);
        } else if (this.z.i() == 2) {
            statisticItem.param("card_type", 8);
        } else if (this.z.i() == 3) {
            statisticItem.param("card_type", 6);
        }
        statisticItem.param("recom_source", this.z.m);
        statisticItem.param("ab_tag", this.z.p);
        statisticItem.param("weight", this.z.n);
        statisticItem.param("extra", this.z.o);
        statisticItem.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        TbPageContext<?> tbPageContext = this.y;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && c.a.o0.o0.c.j(this.y.getPageActivity()) != null && c.a.o0.o0.c.j(this.y.getPageActivity()).b() != null && !TextUtils.isEmpty(c.a.o0.o0.c.j(this.y.getPageActivity()).b().locatePage) && "a002".equals(c.a.o0.o0.c.j(this.y.getPageActivity()).b().locatePage)) {
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
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f15305c, shareItem, true, true);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
        c.a.p0.l0.h.c().l(shareDialogConfig);
    }

    @Override // c.a.p0.b2.o.l.h
    public void setAutoPlayCallBack(c.a.p0.f1.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.h
    public void setCurrentPlayCallBack(c.a.p0.b2.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            this.U = fVar;
        }
    }

    @Override // c.a.p0.b2.o.l.h
    public void setOnVideoContainerForegroundClickListener(c.a.p0.f1.t2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, cVar) == null) {
            this.Q = cVar;
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            u0();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.X.L();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.L = false;
            this.v.j2();
            ExpandableTextView expandableTextView = this.k;
            if (expandableTextView != null) {
                expandableTextView.setVisibility(0);
            }
            s sVar = this.V;
            if (sVar != null) {
                sVar.g(2);
            }
            r0(false);
            this.K = true;
            c.a.e.m.d dVar = this.X;
            if (dVar == null || !dVar.r()) {
                return;
            }
            this.X.L();
        }
    }

    /* loaded from: classes2.dex */
    public class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f14663b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f14664c;

        /* renamed from: c.a.p0.f1.t2.a$s$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1111a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public RunnableC1111a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.f14663b);
                    this.a.g(2);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14664c = aVar;
            this.a = -1;
            this.f14663b = new RunnableC1111a(this);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f14663b);
                c.a.d.f.m.e.a().postDelayed(this.f14663b, 3000L);
            }
        }

        public final int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f14664c.P.setVisibility(8);
                this.f14664c.U(true);
                return i;
            }
            return invokeI.intValue;
        }

        public final int d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f14664c.P.setVisibility(0);
                this.f14664c.U(true);
                return i;
            }
            return invokeI.intValue;
        }

        public final int e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f14664c.P.setVisibility(0);
                if (i2 != 3 || this.f14664c.z.B) {
                    this.f14664c.U(false);
                    return i;
                }
                return i;
            }
            return invokeI.intValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                if (i == 0) {
                    this.a = c(i);
                    b();
                } else if (i == 1) {
                    this.a = c(i);
                    c.a.d.f.m.e.a().removeCallbacks(this.f14663b);
                } else if (i == 2) {
                    this.a = e(i);
                } else if (i != 3) {
                    this.a = e(i);
                } else {
                    this.a = d(i);
                    b();
                }
            }
        }

        public /* synthetic */ s(a aVar, j jVar) {
            this(aVar);
        }
    }
}
