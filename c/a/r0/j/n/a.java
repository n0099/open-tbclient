package c.a.r0.j.n;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c2.b.c.a;
import c.a.r0.a.z2.f0;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.x;
import c.a.r0.a.z2.y0;
import c.a.r0.n.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class a extends c.a.r0.a.h0.g.d implements c.a.r0.j.f0.a.b.b, a.InterfaceC0285a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView J0;
    public View K0;
    public ImageView L0;
    public View M0;
    public ImageView N0;
    public FrameLayout O0;
    public View P0;
    public c.a.r0.j.p0.c Q0;
    public c.a.r0.j.p0.c R0;
    public c.a.r0.j.f0.a.b.a S0;
    public c.a.r0.a.c2.b.c.a T0;
    public c.a.r0.j.p0.a U0;
    public TextView V0;
    public boolean W0;
    public m X0;
    public volatile boolean Y0;
    public AudioManager Z0;
    public boolean a1;
    public l b1;
    public OrientationEventListener c1;
    public String d1;
    public GameCloseGuidePopView e1;
    public PandaParkCloseDialog f1;
    public boolean g1;
    public View h1;
    public boolean i1;
    public long j1;
    public long k1;
    public boolean l1;

    /* renamed from: c.a.r0.j.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0755a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11086e;

        public RunnableC0755a(a aVar) {
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
            this.f11086e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11086e.O0.removeView(this.f11086e.P0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.l0.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11087b;

        /* renamed from: c.a.r0.j.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0756a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f11088e;

            public RunnableC0756a(b bVar) {
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
                this.f11088e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f0.q(this.f11088e.f11087b.getActivity(), this.f11088e.f11087b.K0) && (b2 = f0.b(this.f11088e.f11087b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11088e.f11087b.K0.getLayoutParams();
                    layoutParams.rightMargin += b2;
                    this.f11088e.f11087b.K0.setLayoutParams(layoutParams);
                    c.a.r0.j.u.a.e().b(b2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, int i2, c.a.r0.a.l0.a aVar2) {
            super(context, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11087b = aVar;
            this.a = aVar2;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f11087b.Q0.h()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || this.f11087b.d1.equals("landscape")) {
                if (80 >= i2 || i2 >= 100 || this.f11087b.d1.endsWith("landscapeReverse")) {
                    return;
                }
                this.f11087b.g0.setRequestedOrientation(8);
                this.f11087b.d1 = "landscapeReverse";
                c.a.r0.j.k0.a.a(this.a, this.f11087b.d1);
                if (a.m1) {
                    String str = "onOrientationChanged: " + this.f11087b.d1;
                }
                this.f11087b.K0.postDelayed(new RunnableC0756a(this), 100L);
                return;
            }
            this.f11087b.g0.setRequestedOrientation(0);
            this.f11087b.d1 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11087b.K0.getLayoutParams();
            layoutParams.rightMargin = this.f11087b.getResources().getDimensionPixelSize(c.a.r0.a.d.aigames_action_bar_right_operation_margin);
            this.f11087b.K0.setLayoutParams(layoutParams);
            c.a.r0.j.u.a.e().b(0);
            c.a.r0.j.k0.a.a(this.a, this.f11087b.d1);
            if (a.m1) {
                String str2 = "onOrientationChanged: " + this.f11087b.d1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11089e;

        public c(a aVar) {
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
            this.f11089e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.j.u.a.j().a(this.f11089e.h0, this.f11089e.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
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

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.m1) {
                    String str = "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + this.a.Y0;
                }
                if (this.a.Y0 || this.a.y3()) {
                    c.a.r0.a.z2.f.e(this.a.g0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11090e;

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
            this.f11090e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f11090e.getContext());
                if (!f0.q(this.f11090e.getActivity(), this.f11090e.K0) || ((SwanAppActivity) this.f11090e.getActivity()).isLandScape()) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11090e.K0.getLayoutParams();
                layoutParams.topMargin = this.f11090e.K0.getTop() + e2;
                this.f11090e.K0.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11091e;

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
            this.f11091e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11091e.d2();
                c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
                fVar.f7980e = SupportMenuInflater.XML_MENU;
                this.f11091e.u1(fVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11092e;

        public g(a aVar) {
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
            this.f11092e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (a.m1 && c.a.r0.a.x1.a.a.e()) {
                    return;
                }
                c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                if (L != null && TextUtils.equals(c.a.r0.a.d2.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.f11092e.F3();
                } else if (L != null && c.a.r0.a.v0.c.c().h()) {
                    this.f11092e.E3("exitButton");
                } else {
                    c.a.r0.j.r.a aVar = new c.a.r0.j.r.a();
                    aVar.e();
                    if (aVar.f()) {
                        c.a.r0.j.u.a.h().a(this.f11092e.g0, aVar, this.f11092e.m3());
                    } else {
                        this.f11092e.E3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PandaParkCloseDialog.a {
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

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B3("pandacontinue");
                this.a.f1.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.B3("pandaclose");
                this.a.f1.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.B3("pandaexit");
                this.a.f1.dismiss();
                this.a.l3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements GameCloseGuidePopView.e {
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

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.e1 == null) {
                return;
            }
            this.a.O0.removeView(this.a.e1);
        }
    }

    /* loaded from: classes6.dex */
    public class j implements c.a.r0.j.u.c.k {
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

        @Override // c.a.r0.j.u.c.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements GameCloseGuidePopView.e {
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

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h1 != null) {
                    this.a.O0.removeView(this.a.h1);
                    this.a.h1 = null;
                }
                this.a.l3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.j.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0757a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11093e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f11094f;

            public RunnableC0757a(l lVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11094f = lVar;
                this.f11093e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11094f.a.z3()) {
                    return;
                }
                int i2 = this.f11093e;
                if (i2 == -2) {
                    boolean unused = a.m1;
                    this.f11094f.a.O2();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = a.m1;
                    this.f11094f.a.O2();
                }
            }
        }

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

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.e0(new RunnableC0757a(this, i2));
            }
        }

        public /* synthetic */ l(a aVar, c cVar) {
            this(aVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TextView> a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f11095b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(textView);
            this.f11095b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.f11095b.get();
                if (textView != null) {
                    String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                    textView.setText(valueOf);
                    if (a.m1) {
                        String str = "gameFps:" + valueOf;
                    }
                }
                sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421153717, "Lc/a/r0/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421153717, "Lc/a/r0/j/n/a;");
                return;
            }
        }
        m1 = c.a.r0.a.k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.S0 = new c.a.r0.j.f0.a.b.a();
        this.U0 = new c.a.r0.j.p0.a();
        this.Y0 = true;
        this.d1 = "landscape";
        this.g1 = false;
        this.l1 = false;
    }

    public static a A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public final void B3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
        fVar.f7980e = str;
        u1(fVar);
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || z3() || this.a1) {
            return;
        }
        if (this.Z0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.Z0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.b1 == null) {
            this.b1 = new l(this, null);
        }
        this.a1 = this.Z0.requestAudioFocus(this.b1, 3, 1) == 1;
        boolean z = m1;
    }

    public void D3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g1 = z;
        }
    }

    public boolean E3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String a = c.a.r0.j.p0.g.f.b.a();
            if (TextUtils.equals(a, c.a.r0.j.p0.g.f.b.b("date"))) {
                if (TextUtils.equals(str, "exitButton")) {
                    l3();
                    return false;
                }
                return false;
            }
            View a2 = c.a.r0.j.u.a.e().a(this.g0, n3());
            this.h1 = a2;
            if (a2 != null) {
                this.O0.addView(a2);
                this.i1 = true;
                c.a.r0.j.p0.g.f.b.c("date", a);
                return true;
            }
            if (this.e1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.e1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.O0.addView(this.e1);
            c.a.r0.j.p0.g.f.b.c("date", a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f1 == null) {
                PandaParkCloseDialog pandaParkCloseDialog = new PandaParkCloseDialog(getContext());
                this.f1 = pandaParkCloseDialog;
                pandaParkCloseDialog.setOnClickListener(new h(this));
            }
            B3("pandadialog");
            this.f1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void G2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (duMixGameSurfaceView = this.J0) == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.J0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.W0) {
                boolean z = m1;
                return;
            }
            this.W0 = true;
            m mVar = new m(this.V0, this.J0);
            this.X0 = mVar;
            mVar.sendEmptyMessage(0);
            boolean z2 = m1;
        }
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.W0) {
                boolean z = m1;
                return;
            }
            this.W0 = false;
            m mVar = this.X0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.X0 = null;
            }
            boolean z2 = m1;
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && n0.G(this.g0)) {
            c.a.r0.a.c2.b.f.e.f(c.a.r0.a.c1.a.c(), c.a.r0.h.g.aiapps_game_not_support_split_screen).G();
            this.g0.finishAndRemoveTask();
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L != null && TextUtils.equals(c.a.r0.a.d2.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return F3();
            }
            if (L != null && c.a.r0.a.v0.c.c().h()) {
                return E3(com.alipay.sdk.widget.d.x);
            }
            c.a.r0.j.r.a aVar = new c.a.r0.j.r.a();
            aVar.e();
            if (aVar.f()) {
                c.a.r0.j.u.a.h().a(this.g0, aVar, m3());
                return true;
            }
            return E3(com.alipay.sdk.widget.d.x);
        }
        return invokeV.booleanValue;
    }

    public void O2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a1) {
            AudioManager audioManager = this.Z0;
            if (audioManager != null && (lVar = this.b1) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.Z0 = null;
                this.b1 = null;
            }
            this.a1 = false;
            boolean z = m1;
        }
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.j.f0.a.b.b
    @NonNull
    public c.a.r0.j.f0.a.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.S0 : (c.a.r0.j.f0.a.b.a) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            v3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.r0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.r0.a.j0.b.a.n(c.a.r0.a.d2.d.J().getAppId()));
            }
            if (c.a.r0.a.d2.e.a0() != null) {
                this.q0.s(c.a.r0.a.d2.e.a0().V().d0());
            }
            this.q0.x(c.a.r0.a.c1.a.M().a(), B1(), this.r0, false);
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.g1(z);
            if (m1) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (g0()) {
                if (z) {
                    resume();
                } else {
                    pause();
                }
            }
        }
    }

    @Override // c.a.r0.a.c2.b.c.a.InterfaceC0285a
    public c.a.r0.a.c2.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        c.a.r0.j.p0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.T0 == null && (cVar = this.R0) != null && cVar.getRootView() != null) {
                this.T0 = new c.a.r0.a.c2.b.c.a(this, this.R0.getRootView(), 0);
            }
            return this.T0;
        }
        return (c.a.r0.a.c2.b.c.a) invokeV.objValue;
    }

    public final void l3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (activity = this.g0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.f7980e = IntentConfig.CLOSE;
            u1(fVar);
            ((SwanAppActivity) this.g0).handleSwanAppExit(1);
            y0.b().e(2);
            c.a.r0.j.b.e.g("0");
        }
    }

    public final c.a.r0.j.u.c.k m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new j(this) : (c.a.r0.j.u.c.k) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new k(this) : (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public c.a.r0.j.p0.a o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.U0 : (c.a.r0.j.p0.a) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            I3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            q.j(new c(this), "SwanGamePageHistory");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (m1) {
                String str = "onDestroy() obj: " + this;
                H3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.J0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.J0.onDestroy();
            }
            if (this.i1) {
                this.h1 = null;
                c.a.r0.j.u.a.e().release();
            }
            c.a.r0.j.p0.c cVar = this.Q0;
            if (cVar != null) {
                cVar.l();
            }
            c.a.r0.j.p0.c cVar2 = this.R0;
            if (cVar2 != null) {
                cVar2.l();
            }
            this.U0.e();
            c.a.r0.a.j1.b.c();
            c.a.r0.j.q.c.b.g(false);
            c.a.r0.j.q.c.b.k();
            super.onDestroy();
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (m1) {
                String str = "onPause() obj: " + this;
            }
            super.onPause();
            if (U()) {
                pause();
            }
        }
    }

    @Override // c.a.r0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (m1) {
                String str = "onResume() obj: " + this;
            }
            super.onResume();
            if (U()) {
                resume();
            }
        }
    }

    public View p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.K0 : (View) invokeV.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.Y0 = false;
            O2();
            if (this.P0 == null) {
                this.P0 = new View(this.g0);
            }
            this.O0.removeView(this.P0);
            this.O0.addView(this.P0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.e1;
            if (gameCloseGuidePopView != null) {
                this.O0.removeView(gameCloseGuidePopView);
                this.e1 = null;
            }
            c.a.r0.j.p0.c cVar = this.Q0;
            if (cVar != null) {
                cVar.k();
            }
            c.a.r0.j.p0.c cVar2 = this.R0;
            if (cVar2 != null) {
                cVar2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.J0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            c.a.r0.a.l0.a v8Engine = this.J0.getV8Engine();
            if (m1) {
                String str = "pause() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            if (!v8Engine.u0()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                c.a.r0.j.k0.b.a(v8Engine);
                EventTarget o = v8Engine.o();
                if (o instanceof c.a.r0.j.d.b) {
                    ((c.a.r0.j.d.b) o).hideKeyboard();
                }
            }
            c.a.r0.j.c.j.b.h().l();
            if (this.l1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.k1 = currentTimeMillis;
                c.a.r0.j.j.a.d(this.j1, currentTimeMillis);
            }
            c.a.r0.j.b.d.o().n();
            c.a.r0.a.j1.b.j(false);
            this.J0.onPause();
            OrientationEventListener orientationEventListener = this.c1;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            n nVar = this.q0;
            if (nVar == null || !nVar.l()) {
                return;
            }
            this.q0.j(false);
        }
    }

    public c.a.r0.j.p0.c q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.Q0 : (c.a.r0.j.p0.c) invokeV.objValue;
    }

    public n r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.q0 : (n) invokeV.objValue;
    }

    public void resume() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            C3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.J0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            c.a.r0.a.l0.a v8Engine = this.J0.getV8Engine();
            if (m1) {
                String str = "resume() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            this.Y0 = true;
            this.J0.onResume();
            c.a.r0.j.c.j.b.h().k();
            c.a.r0.j.k0.b.b(v8Engine);
            Activity activity2 = this.g0;
            if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new c.a.r0.j.x.e(((SwanAppActivity) activity2).getLaunchInfo()));
            }
            v8Engine.onResume();
            if (this.O0 != null && this.P0 != null) {
                q0.b0(new RunnableC0755a(this), 500L);
            }
            Activity activity3 = this.g0;
            if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
                if (!this.Q0.h()) {
                    this.g0.setRequestedOrientation(isLandScape ? this.d1.equals("landscape") ? 0 : 8 : 1);
                    this.Q0.n(isLandScape);
                    this.R0.n(isLandScape);
                }
                c.a.r0.a.z2.f.e(this.g0);
            }
            if (this.c1 == null) {
                this.c1 = new b(this, this.g0, 3, v8Engine);
            }
            if (this.c1.canDetectOrientation() && (activity = this.g0) != null && ((SwanAppActivity) activity).isLandScape()) {
                this.c1.enable();
            } else {
                this.c1.disable();
            }
            this.l1 = false;
            if (c.a.r0.a.d2.e.L() != null && c.a.r0.a.d2.e.L().X() != null) {
                try {
                    this.l1 = new JSONObject(c.a.r0.a.d2.e.L().X().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                    this.j1 = System.currentTimeMillis();
                } catch (Exception e2) {
                    if (m1) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.h1 != null) {
                c.a.r0.j.u.a.e().c();
            }
            c.a.r0.j.b.d.o().x();
            c.a.r0.a.j1.b.j(true);
            c.a.r0.j.p0.c cVar = this.Q0;
            if (cVar != null) {
                cVar.m();
            }
            c.a.r0.j.p0.c cVar2 = this.R0;
            if (cVar2 != null) {
                cVar2.m();
            }
            I3();
        }
    }

    public c.a.r0.j.p0.c s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.R0 : (c.a.r0.j.p0.c) invokeV.objValue;
    }

    public final void t3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (duMixGameSurfaceView = this.J0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public final void u3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            View findViewById = view.findViewById(c.a.r0.a.f.titlebar_right_menu);
            this.K0 = findViewById;
            findViewById.post(new e(this));
            this.L0 = (ImageView) view.findViewById(c.a.r0.a.f.titlebar_right_menu_img);
            this.M0 = view.findViewById(c.a.r0.a.f.titlebar_right_menu_line);
            this.N0 = (ImageView) view.findViewById(c.a.r0.a.f.titlebar_right_menu_exit);
            this.L0.setImageDrawable(getResources().getDrawable(c.a.r0.a.e.aiapps_action_bar_single_menu_white_selector));
            this.N0.setImageDrawable(getResources().getDrawable(c.a.r0.a.e.aiapps_action_bar_exit_white_selector));
            this.M0.setBackgroundResource(c.a.r0.a.c.aiapps_action_bar_menu_line_white);
            this.K0.setBackgroundResource(c.a.r0.a.e.aiapps_action_bar_right_menu_bg_solid);
            this.L0.setOnClickListener(new f(this));
            this.N0.setOnClickListener(new g(this));
        }
    }

    public void v3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.g1) {
            n nVar = this.q0;
            if (nVar != null && nVar.l()) {
                this.q0.j(false);
            }
            this.q0 = null;
            this.g1 = false;
        }
        if (this.r0 == null) {
            this.r0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.q0 == null) {
            n nVar2 = new n(activity, this.K0, 0, c.a.r0.a.c1.a.K(), new c.a.r0.a.a3.h.b());
            this.q0 = nVar2;
            nVar2.q(c.a.r0.a.z2.f.c());
            this.S0.b(this.q0);
            c.a.r0.a.p.b.a.k F = c.a.r0.a.g1.f.U().F();
            if (F != null) {
                F.b(this.q0);
            }
            new c.a.r0.a.k1.a(this.q0, this, this.r0).z();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            if (m1) {
                String str = "onCreateView obj: " + this;
            }
            if (f0.p(getActivity())) {
                f0.s(getActivity());
            }
            View inflate = layoutInflater.inflate(c.a.r0.a.g.ai_games_fragment, viewGroup, false);
            w3(inflate);
            t3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void w3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(c.a.r0.a.f.ai_games_layout);
            this.O0 = frameLayout;
            DuMixGameSurfaceView r = c.a.r0.j.o.c.m().r();
            this.J0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.J0, 0, new FrameLayout.LayoutParams(-1, -1));
                boolean z = m1;
            }
            if (m1 && !c.a.r0.a.x1.a.a.n()) {
                View inflate = ((ViewStub) view.findViewById(c.a.r0.a.f.ai_games_fps_text_view_stub)).inflate();
                if (inflate != null) {
                    this.V0 = (TextView) inflate.findViewById(c.a.r0.a.f.ai_games_fps_text);
                }
                G3();
            }
            u3(view);
            this.R0 = new c.a.r0.j.p0.c((FrameLayout) view.findViewById(c.a.r0.a.f.ai_games_na_layout));
            this.Q0 = new c.a.r0.j.p0.c(this.O0);
        }
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? !this.Y0 : invokeV.booleanValue;
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            c.a.r0.a.h0.g.g G1 = G1();
            return G1 != null && (G1.m() instanceof a);
        }
        return invokeV.booleanValue;
    }

    public final boolean z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            boolean booleanValue = L == null ? false : L.T().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (m1) {
                String str = "   isMixWithOther -> " + booleanValue;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }
}
