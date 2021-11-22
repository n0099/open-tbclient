package b.a.p0.j.n;

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
import b.a.p0.a.c2.b.c.a;
import b.a.p0.a.z2.f0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.x;
import b.a.p0.a.z2.y0;
import b.a.p0.n.n;
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
/* loaded from: classes4.dex */
public class a extends b.a.p0.a.h0.g.d implements b.a.p0.j.f0.a.b.b, a.InterfaceC0136a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView I0;
    public View J0;
    public ImageView K0;
    public View L0;
    public ImageView M0;
    public FrameLayout N0;
    public View O0;
    public b.a.p0.j.p0.c P0;
    public b.a.p0.j.p0.c Q0;
    public b.a.p0.j.f0.a.b.a R0;
    public b.a.p0.a.c2.b.c.a S0;
    public b.a.p0.j.p0.a T0;
    public TextView U0;
    public boolean V0;
    public m W0;
    public volatile boolean X0;
    public AudioManager Y0;
    public boolean Z0;
    public l a1;
    public OrientationEventListener b1;
    public String c1;
    public GameCloseGuidePopView d1;
    public PandaParkCloseDialog e1;
    public boolean f1;
    public View g1;
    public boolean h1;
    public long i1;
    public long j1;
    public boolean k1;

    /* renamed from: b.a.p0.j.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0606a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11249e;

        public RunnableC0606a(a aVar) {
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
            this.f11249e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11249e.N0.removeView(this.f11249e.O0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l0.a f11250a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11251b;

        /* renamed from: b.a.p0.j.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0607a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f11252e;

            public RunnableC0607a(b bVar) {
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
                this.f11252e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f0.q(this.f11252e.f11251b.getActivity(), this.f11252e.f11251b.J0) && (b2 = f0.b(this.f11252e.f11251b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11252e.f11251b.J0.getLayoutParams();
                    layoutParams.rightMargin += b2;
                    this.f11252e.f11251b.J0.setLayoutParams(layoutParams);
                    b.a.p0.j.u.a.e().b(b2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, int i2, b.a.p0.a.l0.a aVar2) {
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
            this.f11251b = aVar;
            this.f11250a = aVar2;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f11251b.P0.h()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || this.f11251b.c1.equals("landscape")) {
                if (80 >= i2 || i2 >= 100 || this.f11251b.c1.endsWith("landscapeReverse")) {
                    return;
                }
                this.f11251b.l0.setRequestedOrientation(8);
                this.f11251b.c1 = "landscapeReverse";
                b.a.p0.j.k0.a.a(this.f11250a, this.f11251b.c1);
                if (a.l1) {
                    String str = "onOrientationChanged: " + this.f11251b.c1;
                }
                this.f11251b.J0.postDelayed(new RunnableC0607a(this), 100L);
                return;
            }
            this.f11251b.l0.setRequestedOrientation(0);
            this.f11251b.c1 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11251b.J0.getLayoutParams();
            layoutParams.rightMargin = this.f11251b.getResources().getDimensionPixelSize(b.a.p0.a.d.aigames_action_bar_right_operation_margin);
            this.f11251b.J0.setLayoutParams(layoutParams);
            b.a.p0.j.u.a.e().b(0);
            b.a.p0.j.k0.a.a(this.f11250a, this.f11251b.c1);
            if (a.l1) {
                String str2 = "onOrientationChanged: " + this.f11251b.c1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11253e;

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
            this.f11253e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.j.u.a.j().a(this.f11253e.m0, this.f11253e.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11254a;

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
            this.f11254a = aVar;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.l1) {
                    String str = "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + this.f11254a.X0;
                }
                if (this.f11254a.X0 || this.f11254a.B3()) {
                    b.a.p0.a.z2.f.e(this.f11254a.l0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11255e;

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
            this.f11255e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f11255e.getContext());
                if (!f0.q(this.f11255e.getActivity(), this.f11255e.J0) || ((SwanAppActivity) this.f11255e.getActivity()).isLandScape()) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11255e.J0.getLayoutParams();
                layoutParams.topMargin = this.f11255e.J0.getTop() + e2;
                this.f11255e.J0.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11256e;

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
            this.f11256e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11256e.g2();
                b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
                fVar.f7383e = SupportMenuInflater.XML_MENU;
                this.f11256e.x1(fVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11257e;

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
            this.f11257e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (a.l1 && b.a.p0.a.x1.a.a.e()) {
                    return;
                }
                b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
                if (L != null && TextUtils.equals(b.a.p0.a.d2.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.f11257e.I3();
                } else if (L != null && b.a.p0.a.v0.c.c().h()) {
                    this.f11257e.H3("exitButton");
                } else {
                    b.a.p0.j.r.a aVar = new b.a.p0.j.r.a();
                    aVar.e();
                    if (aVar.f()) {
                        b.a.p0.j.u.a.h().a(this.f11257e.l0, aVar, this.f11257e.p3());
                    } else {
                        this.f11257e.H3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements PandaParkCloseDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11258a;

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
            this.f11258a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11258a.E3("pandacontinue");
                this.f11258a.e1.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f11258a.E3("pandaclose");
                this.f11258a.e1.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f11258a.E3("pandaexit");
                this.f11258a.e1.dismiss();
                this.f11258a.o3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11259a;

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
            this.f11259a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11259a.o3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f11259a.o3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f11259a.d1 == null) {
                return;
            }
            this.f11259a.N0.removeView(this.f11259a.d1);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements b.a.p0.j.u.c.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11260a;

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
            this.f11260a = aVar;
        }

        @Override // b.a.p0.j.u.c.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11260a.o3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11261a;

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
            this.f11261a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11261a.g1 != null) {
                    this.f11261a.N0.removeView(this.f11261a.g1);
                    this.f11261a.g1 = null;
                }
                this.f11261a.o3();
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

    /* loaded from: classes4.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11262a;

        /* renamed from: b.a.p0.j.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0608a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f11263e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f11264f;

            public RunnableC0608a(l lVar, int i2) {
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
                this.f11264f = lVar;
                this.f11263e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11264f.f11262a.C3()) {
                    return;
                }
                int i2 = this.f11263e;
                if (i2 == -2) {
                    boolean unused = a.l1;
                    this.f11264f.f11262a.R2();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = a.l1;
                    this.f11264f.f11262a.R2();
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
            this.f11262a = aVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.e0(new RunnableC0608a(this, i2));
            }
        }

        public /* synthetic */ l(a aVar, c cVar) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<TextView> f11265a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f11266b;

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
            this.f11265a = new WeakReference<>(textView);
            this.f11266b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.f11265a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.f11266b.get();
                if (textView != null) {
                    String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                    textView.setText(valueOf);
                    if (a.l1) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807809080, "Lb/a/p0/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807809080, "Lb/a/p0/j/n/a;");
                return;
            }
        }
        l1 = b.a.p0.a.k.f6863a;
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
        this.R0 = new b.a.p0.j.f0.a.b.a();
        this.T0 = new b.a.p0.j.p0.a();
        this.X0 = true;
        this.c1 = "landscape";
        this.f1 = false;
        this.k1 = false;
    }

    public static a D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.X0 : invokeV.booleanValue;
    }

    public final boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.h0.g.g J1 = J1();
            return J1 != null && (J1.m() instanceof a);
        }
        return invokeV.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            boolean booleanValue = L == null ? false : L.T().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (l1) {
                String str = "   isMixWithOther -> " + booleanValue;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public final void E3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
        fVar.f7383e = str;
        x1(fVar);
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || C3() || this.Z0) {
            return;
        }
        if (this.Y0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.Y0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.a1 == null) {
            this.a1 = new l(this, null);
        }
        this.Z0 = this.Y0.requestAudioFocus(this.a1, 3, 1) == 1;
        boolean z = l1;
    }

    public void G3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f1 = z;
        }
    }

    public boolean H3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String a2 = b.a.p0.j.p0.g.f.b.a();
            if (TextUtils.equals(a2, b.a.p0.j.p0.g.f.b.b("date"))) {
                if (TextUtils.equals(str, "exitButton")) {
                    o3();
                    return false;
                }
                return false;
            }
            View a3 = b.a.p0.j.u.a.e().a(this.l0, q3());
            this.g1 = a3;
            if (a3 != null) {
                this.N0.addView(a3);
                this.h1 = true;
                b.a.p0.j.p0.g.f.b.c("date", a2);
                return true;
            }
            if (this.d1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.d1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.N0.addView(this.d1);
            b.a.p0.j.p0.g.f.b.c("date", a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.e1 == null) {
                PandaParkCloseDialog pandaParkCloseDialog = new PandaParkCloseDialog(getContext());
                this.e1 = pandaParkCloseDialog;
                pandaParkCloseDialog.setOnClickListener(new h(this));
            }
            E3("pandadialog");
            this.e1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void J2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (duMixGameSurfaceView = this.I0) == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.I0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
    }

    public final void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.V0) {
                boolean z = l1;
                return;
            }
            this.V0 = true;
            m mVar = new m(this.U0, this.I0);
            this.W0 = mVar;
            mVar.sendEmptyMessage(0);
            boolean z2 = l1;
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            if (L != null && TextUtils.equals(b.a.p0.a.d2.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return I3();
            }
            if (L != null && b.a.p0.a.v0.c.c().h()) {
                return H3(com.alipay.sdk.widget.d.x);
            }
            b.a.p0.j.r.a aVar = new b.a.p0.j.r.a();
            aVar.e();
            if (aVar.f()) {
                b.a.p0.j.u.a.h().a(this.l0, aVar, p3());
                return true;
            }
            return H3(com.alipay.sdk.widget.d.x);
        }
        return invokeV.booleanValue;
    }

    public final void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.V0) {
                boolean z = l1;
                return;
            }
            this.V0 = false;
            m mVar = this.W0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.W0 = null;
            }
            boolean z2 = l1;
        }
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && n0.G(this.l0)) {
            b.a.p0.a.c2.b.f.e.f(b.a.p0.a.c1.a.c(), b.a.p0.h.g.aiapps_game_not_support_split_screen).G();
            this.l0.finishAndRemoveTask();
        }
    }

    public void R2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.Z0) {
            AudioManager audioManager = this.Y0;
            if (audioManager != null && (lVar = this.a1) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.Y0 = null;
                this.a1 = null;
            }
            this.Z0 = false;
            boolean z = l1;
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.j.f0.a.b.b
    @NonNull
    public b.a.p0.j.f0.a.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.R0 : (b.a.p0.j.f0.a.b.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            y3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.q0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId()));
            }
            if (b.a.p0.a.d2.e.a0() != null) {
                this.p0.o(b.a.p0.a.d2.e.a0().V().d0());
            }
            this.p0.t(b.a.p0.a.c1.a.M().a(), E1(), this.q0, false);
        }
    }

    @Override // b.a.p0.a.c2.b.c.a.InterfaceC0136a
    public b.a.p0.a.c2.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        b.a.p0.j.p0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.S0 == null && (cVar = this.Q0) != null && cVar.getRootView() != null) {
                this.S0 = new b.a.p0.a.c2.b.c.a(this, this.Q0.getRootView(), 0);
            }
            return this.S0;
        }
        return (b.a.p0.a.c2.b.c.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.j1(z);
            if (l1) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (n0()) {
                if (z) {
                    resume();
                } else {
                    pause();
                }
            }
        }
    }

    public final void o3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (activity = this.l0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7383e = IntentConfig.CLOSE;
            x1(fVar);
            ((SwanAppActivity) this.l0).handleSwanAppExit(1);
            y0.b().e(2);
            b.a.p0.j.b.e.g("0");
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            L3();
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
            if (l1) {
                String str = "onDestroy() obj: " + this;
                K3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.I0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.I0.onDestroy();
            }
            if (this.h1) {
                this.g1 = null;
                b.a.p0.j.u.a.e().release();
            }
            b.a.p0.j.p0.c cVar = this.P0;
            if (cVar != null) {
                cVar.l();
            }
            b.a.p0.j.p0.c cVar2 = this.Q0;
            if (cVar2 != null) {
                cVar2.l();
            }
            this.T0.e();
            b.a.p0.a.j1.b.c();
            b.a.p0.j.q.c.b.g(false);
            b.a.p0.j.q.c.b.k();
            super.onDestroy();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (l1) {
                String str = "onPause() obj: " + this;
            }
            super.onPause();
            if (c0()) {
                pause();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (l1) {
                String str = "onResume() obj: " + this;
            }
            super.onResume();
            if (c0()) {
                resume();
            }
        }
    }

    public final b.a.p0.j.u.c.k p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new j(this) : (b.a.p0.j.u.c.k) invokeV.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.X0 = false;
            R2();
            if (this.O0 == null) {
                this.O0 = new View(this.l0);
            }
            this.N0.removeView(this.O0);
            this.N0.addView(this.O0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.d1;
            if (gameCloseGuidePopView != null) {
                this.N0.removeView(gameCloseGuidePopView);
                this.d1 = null;
            }
            b.a.p0.j.p0.c cVar = this.P0;
            if (cVar != null) {
                cVar.k();
            }
            b.a.p0.j.p0.c cVar2 = this.Q0;
            if (cVar2 != null) {
                cVar2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.I0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            b.a.p0.a.l0.a v8Engine = this.I0.getV8Engine();
            if (l1) {
                String str = "pause() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            if (!v8Engine.u0()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                b.a.p0.j.k0.b.a(v8Engine);
                EventTarget o = v8Engine.o();
                if (o instanceof b.a.p0.j.d.b) {
                    ((b.a.p0.j.d.b) o).hideKeyboard();
                }
            }
            b.a.p0.j.c.j.b.h().l();
            if (this.k1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.j1 = currentTimeMillis;
                b.a.p0.j.j.a.d(this.i1, currentTimeMillis);
            }
            b.a.p0.j.b.d.o().n();
            b.a.p0.a.j1.b.j(false);
            this.I0.onPause();
            OrientationEventListener orientationEventListener = this.b1;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            n nVar = this.p0;
            if (nVar == null || !nVar.i()) {
                return;
            }
            this.p0.g(false);
        }
    }

    public final GameCloseGuidePopView.e q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? new k(this) : (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public b.a.p0.j.p0.a r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.T0 : (b.a.p0.j.p0.a) invokeV.objValue;
    }

    public void resume() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            F3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.I0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            b.a.p0.a.l0.a v8Engine = this.I0.getV8Engine();
            if (l1) {
                String str = "resume() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            this.X0 = true;
            this.I0.onResume();
            b.a.p0.j.c.j.b.h().k();
            b.a.p0.j.k0.b.b(v8Engine);
            Activity activity2 = this.l0;
            if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new b.a.p0.j.x.e(((SwanAppActivity) activity2).getLaunchInfo()));
            }
            v8Engine.onResume();
            if (this.N0 != null && this.O0 != null) {
                q0.b0(new RunnableC0606a(this), 500L);
            }
            Activity activity3 = this.l0;
            if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
                if (!this.P0.h()) {
                    this.l0.setRequestedOrientation(isLandScape ? this.c1.equals("landscape") ? 0 : 8 : 1);
                    this.P0.n(isLandScape);
                    this.Q0.n(isLandScape);
                }
                b.a.p0.a.z2.f.e(this.l0);
            }
            if (this.b1 == null) {
                this.b1 = new b(this, this.l0, 3, v8Engine);
            }
            if (this.b1.canDetectOrientation() && (activity = this.l0) != null && ((SwanAppActivity) activity).isLandScape()) {
                this.b1.enable();
            } else {
                this.b1.disable();
            }
            this.k1 = false;
            if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                try {
                    this.k1 = new JSONObject(b.a.p0.a.d2.e.L().X().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                    this.i1 = System.currentTimeMillis();
                } catch (Exception e2) {
                    if (l1) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.g1 != null) {
                b.a.p0.j.u.a.e().c();
            }
            b.a.p0.j.b.d.o().x();
            b.a.p0.a.j1.b.j(true);
            b.a.p0.j.p0.c cVar = this.P0;
            if (cVar != null) {
                cVar.m();
            }
            b.a.p0.j.p0.c cVar2 = this.Q0;
            if (cVar2 != null) {
                cVar2.m();
            }
            L3();
        }
    }

    public View s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.J0 : (View) invokeV.objValue;
    }

    public b.a.p0.j.p0.c t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.P0 : (b.a.p0.j.p0.c) invokeV.objValue;
    }

    public n u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.p0 : (n) invokeV.objValue;
    }

    public b.a.p0.j.p0.c v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.Q0 : (b.a.p0.j.p0.c) invokeV.objValue;
    }

    public final void w3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (duMixGameSurfaceView = this.I0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public final void x3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            View findViewById = view.findViewById(b.a.p0.a.f.titlebar_right_menu);
            this.J0 = findViewById;
            findViewById.post(new e(this));
            this.K0 = (ImageView) view.findViewById(b.a.p0.a.f.titlebar_right_menu_img);
            this.L0 = view.findViewById(b.a.p0.a.f.titlebar_right_menu_line);
            this.M0 = (ImageView) view.findViewById(b.a.p0.a.f.titlebar_right_menu_exit);
            this.K0.setImageDrawable(getResources().getDrawable(b.a.p0.a.e.aiapps_action_bar_single_menu_white_selector));
            this.M0.setImageDrawable(getResources().getDrawable(b.a.p0.a.e.aiapps_action_bar_exit_white_selector));
            this.L0.setBackgroundResource(b.a.p0.a.c.aiapps_action_bar_menu_line_white);
            this.J0.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
            this.K0.setOnClickListener(new f(this));
            this.M0.setOnClickListener(new g(this));
        }
    }

    public void y3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.f1) {
            n nVar = this.p0;
            if (nVar != null && nVar.i()) {
                this.p0.g(false);
            }
            this.p0 = null;
            this.f1 = false;
        }
        if (this.q0 == null) {
            this.q0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.p0 == null) {
            n nVar2 = new n(activity, this.J0, 0, b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            this.p0 = nVar2;
            nVar2.m(b.a.p0.a.z2.f.c());
            this.R0.b(this.p0);
            b.a.p0.a.p.b.a.k F = b.a.p0.a.g1.f.U().F();
            if (F != null) {
                F.b(this.p0);
            }
            new b.a.p0.a.k1.a(this.p0, this, this.q0).z();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048614, this, layoutInflater, viewGroup, bundle)) == null) {
            if (l1) {
                String str = "onCreateView obj: " + this;
            }
            if (f0.p(getActivity())) {
                f0.s(getActivity());
            }
            View inflate = layoutInflater.inflate(b.a.p0.a.g.ai_games_fragment, viewGroup, false);
            z3(inflate);
            w3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void z3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view) == null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(b.a.p0.a.f.ai_games_layout);
            this.N0 = frameLayout;
            DuMixGameSurfaceView r = b.a.p0.j.o.c.m().r();
            this.I0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.I0, 0, new FrameLayout.LayoutParams(-1, -1));
                boolean z = l1;
            }
            if (l1 && !b.a.p0.a.x1.a.a.n()) {
                View inflate = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_games_fps_text_view_stub)).inflate();
                if (inflate != null) {
                    this.U0 = (TextView) inflate.findViewById(b.a.p0.a.f.ai_games_fps_text);
                }
                J3();
            }
            x3(view);
            this.Q0 = new b.a.p0.j.p0.c((FrameLayout) view.findViewById(b.a.p0.a.f.ai_games_na_layout));
            this.P0 = new b.a.p0.j.p0.c(this.N0);
        }
    }
}
