package b.a.p0.h.n;

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
import b.a.p0.a.v0.c;
import b.a.p0.a.v2.f0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x;
import b.a.p0.a.v2.x0;
import b.a.p0.a.z1.b.c.a;
import b.a.p0.k.n;
import com.baidu.android.imsdk.internal.Constants;
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
public class a extends b.a.p0.a.h0.g.d implements b.a.p0.h.e0.a.b.b, a.InterfaceC0478a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView C0;
    public View D0;
    public ImageView E0;
    public View F0;
    public ImageView G0;
    public FrameLayout H0;
    public View I0;
    public b.a.p0.h.o0.c J0;
    public b.a.p0.h.o0.c K0;
    public b.a.p0.h.e0.a.b.a L0;
    public b.a.p0.a.z1.b.c.a M0;
    public b.a.p0.h.o0.a N0;
    public TextView O0;
    public boolean P0;
    public m Q0;
    public volatile boolean R0;
    public AudioManager S0;
    public boolean T0;
    public l U0;
    public OrientationEventListener V0;
    public String W0;
    public GameCloseGuidePopView X0;
    public PandaParkCloseDialog Y0;
    public boolean Z0;
    public View a1;
    public boolean b1;
    public long c1;
    public long d1;
    public boolean e1;

    /* renamed from: b.a.p0.h.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0573a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10556e;

        public RunnableC0573a(a aVar) {
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
            this.f10556e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10556e.H0.removeView(this.f10556e.I0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.l0.a f10557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10558b;

        /* renamed from: b.a.p0.h.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0574a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10559e;

            public RunnableC0574a(b bVar) {
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
                this.f10559e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f0.q(this.f10559e.f10558b.getActivity(), this.f10559e.f10558b.D0) && (b2 = f0.b(this.f10559e.f10558b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10559e.f10558b.D0.getLayoutParams();
                    layoutParams.rightMargin += b2;
                    this.f10559e.f10558b.D0.setLayoutParams(layoutParams);
                    b.a.p0.h.t.a.e().b(b2);
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
            this.f10558b = aVar;
            this.f10557a = aVar2;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f10558b.J0.h()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || this.f10558b.W0.equals("landscape")) {
                if (80 >= i2 || i2 >= 100 || this.f10558b.W0.endsWith("landscapeReverse")) {
                    return;
                }
                this.f10558b.k0.setRequestedOrientation(8);
                this.f10558b.W0 = "landscapeReverse";
                b.a.p0.h.j0.a.a(this.f10557a, this.f10558b.W0);
                if (a.f1) {
                    String str = "onOrientationChanged: " + this.f10558b.W0;
                }
                this.f10558b.D0.postDelayed(new RunnableC0574a(this), 100L);
                return;
            }
            this.f10558b.k0.setRequestedOrientation(0);
            this.f10558b.W0 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10558b.D0.getLayoutParams();
            layoutParams.rightMargin = this.f10558b.getResources().getDimensionPixelSize(b.a.p0.a.d.aigames_action_bar_right_operation_margin);
            this.f10558b.D0.setLayoutParams(layoutParams);
            b.a.p0.h.t.a.e().b(0);
            b.a.p0.h.j0.a.a(this.f10557a, this.f10558b.W0);
            if (a.f1) {
                String str2 = "onOrientationChanged: " + this.f10558b.W0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10560e;

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
            this.f10560e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.h.t.a.i().a(this.f10560e.l0, this.f10560e.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10561a;

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
            this.f10561a = aVar;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.f1) {
                    String str = "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + this.f10561a.R0;
                }
                if (this.f10561a.R0 || this.f10561a.k3()) {
                    b.a.p0.a.v2.f.e(this.f10561a.k0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10562e;

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
            this.f10562e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f10562e.getContext());
                if (!f0.q(this.f10562e.getActivity(), this.f10562e.D0) || ((SwanAppActivity) this.f10562e.getActivity()).isLandScape()) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f10562e.D0.getLayoutParams();
                layoutParams.topMargin = this.f10562e.D0.getTop() + e2;
                this.f10562e.D0.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10563e;

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
            this.f10563e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10563e.Y1();
                b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
                fVar.f6387e = SupportMenuInflater.XML_MENU;
                this.f10563e.s1(fVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10564e;

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
            this.f10564e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (a.f1 && b.a.p0.a.u1.a.a.e()) {
                    return;
                }
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                if (i2 != null && TextUtils.equals(b.a.p0.a.a2.e.U(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.f10564e.r3();
                } else if (i2 != null && b.a.p0.a.v0.c.c().h()) {
                    this.f10564e.q3("exitButton");
                } else {
                    b.a.p0.a.v0.b bVar = new b.a.p0.a.v0.b();
                    bVar.h();
                    if (bVar.k()) {
                        b.a.p0.a.v0.c.c().j(this.f10564e.k0, bVar.f(), bVar.e(), bVar, this.f10564e.w1());
                        return;
                    }
                    this.f10564e.q3("exitButton");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements PandaParkCloseDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10565a;

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
            this.f10565a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10565a.n3("pandacontinue");
                this.f10565a.Y0.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f10565a.n3("pandaclose");
                this.f10565a.Y0.dismiss();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.PandaParkCloseDialog.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f10565a.n3("pandaexit");
                this.f10565a.Y0.dismiss();
                this.f10565a.Y2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10566a;

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
            this.f10566a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10566a.Y2();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f10566a.Y2();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f10566a.X0 == null) {
                return;
            }
            this.f10566a.H0.removeView(this.f10566a.X0);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10567a;

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
            this.f10567a = aVar;
        }

        @Override // b.a.p0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10567a.Y2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10568a;

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
            this.f10568a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10568a.a1 != null) {
                    this.f10568a.H0.removeView(this.f10568a.a1);
                    this.f10568a.a1 = null;
                }
                this.f10568a.Y2();
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
        public final /* synthetic */ a f10569a;

        /* renamed from: b.a.p0.h.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0575a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f10570e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f10571f;

            public RunnableC0575a(l lVar, int i2) {
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
                this.f10571f = lVar;
                this.f10570e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10571f.f10569a.l3()) {
                    return;
                }
                int i2 = this.f10570e;
                if (i2 == -2) {
                    boolean unused = a.f1;
                    this.f10571f.f10569a.B2();
                } else if (i2 != -1) {
                } else {
                    boolean unused2 = a.f1;
                    this.f10571f.f10569a.B2();
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
            this.f10569a = aVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                q0.b0(new RunnableC0575a(this, i2));
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
        public WeakReference<TextView> f10572a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f10573b;

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
            this.f10572a = new WeakReference<>(textView);
            this.f10573b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.f10572a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.f10573b.get();
                if (textView != null) {
                    String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                    textView.setText(valueOf);
                    if (a.f1) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865067382, "Lb/a/p0/h/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865067382, "Lb/a/p0/h/n/a;");
                return;
            }
        }
        f1 = b.a.p0.a.k.f6397a;
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
        this.L0 = new b.a.p0.h.e0.a.b.a();
        this.N0 = new b.a.p0.h.o0.a();
        this.R0 = true;
        this.W0 = "landscape";
        this.Z0 = false;
        this.e1 = false;
    }

    public static a m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.b w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) ? new j(this) : (c.b) invokeV.objValue;
    }

    public void B2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.T0) {
            AudioManager audioManager = this.S0;
            if (audioManager != null && (lVar = this.U0) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.S0 = null;
                this.U0 = null;
            }
            this.T0 = false;
            boolean z = f1;
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (b.a.d0.a.j()) {
                return b.a.d0.a.j();
            }
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 != null && TextUtils.equals(b.a.p0.a.a2.e.U(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return r3();
            }
            if (i2 != null && b.a.p0.a.v0.c.c().h()) {
                return q3(com.alipay.sdk.widget.d.x);
            }
            b.a.p0.a.v0.b bVar = new b.a.p0.a.v0.b();
            bVar.h();
            if (bVar.k()) {
                b.a.p0.a.v0.c.c().j(this.k0, bVar.f(), bVar.e(), bVar, w1());
                return true;
            }
            return q3(com.alipay.sdk.widget.d.x);
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            h3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.p0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.a2.d.g().getAppId()));
            }
            if (b.a.p0.a.a2.e.P() != null) {
                this.o0.m(b.a.p0.a.a2.e.P().K().c0());
            }
            this.o0.r(b.a.p0.a.c1.a.H().a(), y1(), this.p0, false);
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Activity activity = this.k0;
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = IntentConfig.CLOSE;
            s1(fVar);
            ((SwanAppActivity) this.k0).handleSwanAppExit(1);
            x0.b().e(2);
        }
    }

    public final GameCloseGuidePopView.e Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new k(this) : (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public b.a.p0.h.o0.a a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.N0 : (b.a.p0.h.o0.a) invokeV.objValue;
    }

    @Override // b.a.p0.h.e0.a.b.b
    @NonNull
    public b.a.p0.h.e0.a.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.L0 : (b.a.p0.h.e0.a.b.a) invokeV.objValue;
    }

    public View b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.D0 : (View) invokeV.objValue;
    }

    public b.a.p0.h.o0.c c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.J0 : (b.a.p0.h.o0.c) invokeV.objValue;
    }

    public n d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o0 : (n) invokeV.objValue;
    }

    public b.a.p0.h.o0.c e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.K0 : (b.a.p0.h.o0.c) invokeV.objValue;
    }

    public final void f3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (duMixGameSurfaceView = this.C0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.g1(z);
            if (f1) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (k0()) {
                if (z) {
                    resume();
                } else {
                    pause();
                }
            }
        }
    }

    public final void g3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            View findViewById = view.findViewById(b.a.p0.a.f.titlebar_right_menu);
            this.D0 = findViewById;
            findViewById.post(new e(this));
            this.E0 = (ImageView) view.findViewById(b.a.p0.a.f.titlebar_right_menu_img);
            this.F0 = view.findViewById(b.a.p0.a.f.titlebar_right_menu_line);
            this.G0 = (ImageView) view.findViewById(b.a.p0.a.f.titlebar_right_menu_exit);
            this.E0.setImageDrawable(getResources().getDrawable(b.a.p0.a.e.aiapps_action_bar_single_menu_white_selector));
            this.G0.setImageDrawable(getResources().getDrawable(b.a.p0.a.e.aiapps_action_bar_exit_white_selector));
            this.F0.setBackgroundResource(b.a.p0.a.c.aiapps_action_bar_menu_line_white);
            this.D0.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
            this.E0.setOnClickListener(new f(this));
            this.G0.setOnClickListener(new g(this));
        }
    }

    @Override // b.a.p0.a.z1.b.c.a.InterfaceC0478a
    public b.a.p0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        b.a.p0.h.o0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.M0 == null && (cVar = this.K0) != null && cVar.getRootView() != null) {
                this.M0 = new b.a.p0.a.z1.b.c.a(this, this.K0.getRootView(), 0);
            }
            return this.M0;
        }
        return (b.a.p0.a.z1.b.c.a) invokeV.objValue;
    }

    public void h3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.Z0) {
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.e(false);
            }
            this.o0 = null;
            this.Z0 = false;
        }
        if (this.p0 == null) {
            this.p0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.o0 == null) {
            n nVar2 = new n(activity, this.D0, 0, b.a.p0.a.c1.a.G(), new b.a.p0.a.w2.h.b());
            this.o0 = nVar2;
            nVar2.k(b.a.p0.a.v2.f.c());
            this.L0.b(this.o0);
            b.a.p0.a.p.b.a.k F = b.a.p0.a.g1.f.T().F();
            if (F != null) {
                F.b(this.o0);
            }
            new b.a.p0.a.j1.a(this.o0, this, this.p0).z();
        }
    }

    public void i3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(b.a.p0.a.f.ai_games_layout);
            this.H0 = frameLayout;
            DuMixGameSurfaceView r = b.a.p0.h.o.c.m().r();
            this.C0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.C0, 0, new FrameLayout.LayoutParams(-1, -1));
                boolean z = f1;
            }
            if (f1 && !b.a.p0.a.u1.a.a.n()) {
                View inflate = ((ViewStub) view.findViewById(b.a.p0.a.f.ai_games_fps_text_view_stub)).inflate();
                if (inflate != null) {
                    this.O0 = (TextView) inflate.findViewById(b.a.p0.a.f.ai_games_fps_text);
                }
                s3();
            }
            g3(view);
            this.K0 = new b.a.p0.h.o0.c((FrameLayout) view.findViewById(b.a.p0.a.f.ai_games_na_layout));
            this.J0 = new b.a.p0.h.o0.c(this.H0);
        }
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? !this.R0 : invokeV.booleanValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            b.a.p0.a.h0.g.g D1 = D1();
            return D1 != null && (D1.m() instanceof a);
        }
        return invokeV.booleanValue;
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            boolean booleanValue = i2 == null ? false : i2.I().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (f1) {
                String str = "   isMixWithOther -> " + booleanValue;
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public final void n3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
        fVar.f6387e = str;
        s1(fVar);
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || l3() || this.T0) {
            return;
        }
        if (this.S0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.S0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.U0 == null) {
            this.U0 = new l(this, null);
        }
        this.T0 = this.S0.requestAudioFocus(this.U0, 3, 1) == 1;
        boolean z = f1;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            u3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onCreate(bundle);
            q.i(new c(this), "SwanGamePageHistory");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (f1) {
                String str = "onDestroy() obj: " + this;
                t3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.C0.onDestroy();
            }
            if (this.b1) {
                this.a1 = null;
                b.a.p0.h.t.a.e().release();
            }
            b.a.p0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.l();
            }
            b.a.p0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.l();
            }
            this.N0.e();
            b.a.p0.a.i1.b.c();
            b.a.p0.h.q.c.b.g(false);
            b.a.p0.h.q.c.b.k();
            super.onDestroy();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (f1) {
                String str = "onPause() obj: " + this;
            }
            super.onPause();
            if (a0()) {
                pause();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (f1) {
                String str = "onResume() obj: " + this;
            }
            super.onResume();
            if (a0()) {
                resume();
            }
        }
    }

    public void p3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.Z0 = z;
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.R0 = false;
            B2();
            if (this.I0 == null) {
                this.I0 = new View(this.k0);
            }
            this.H0.removeView(this.I0);
            this.H0.addView(this.I0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.X0;
            if (gameCloseGuidePopView != null) {
                this.H0.removeView(gameCloseGuidePopView);
                this.X0 = null;
            }
            b.a.p0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.k();
            }
            b.a.p0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            b.a.p0.a.l0.a v8Engine = this.C0.getV8Engine();
            if (f1) {
                String str = "pause() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            if (!v8Engine.s0()) {
                v8Engine.onPause();
                v8Engine.i0(new JSEvent("apphide"));
                b.a.p0.h.j0.b.a(v8Engine);
                EventTarget n = v8Engine.n();
                if (n instanceof b.a.p0.h.d.b) {
                    ((b.a.p0.h.d.b) n).hideKeyboard();
                }
            }
            b.a.p0.h.c.j.b.h().l();
            if (this.e1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.d1 = currentTimeMillis;
                b.a.p0.h.j.a.d(this.c1, currentTimeMillis);
            }
            b.a.p0.h.b.d.o().n();
            b.a.p0.a.i1.b.i(false);
            this.C0.onPause();
            OrientationEventListener orientationEventListener = this.V0;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            n nVar = this.o0;
            if (nVar == null || !nVar.g()) {
                return;
            }
            this.o0.e(false);
        }
    }

    public boolean q3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            String a2 = b.a.p0.h.o0.g.f.b.a();
            if (TextUtils.equals(a2, b.a.p0.h.o0.g.f.b.b("date"))) {
                if (TextUtils.equals(str, "exitButton")) {
                    Y2();
                    return false;
                }
                return false;
            }
            View a3 = b.a.p0.h.t.a.e().a(this.k0, Z2());
            this.a1 = a3;
            if (a3 != null) {
                this.H0.addView(a3);
                this.b1 = true;
                b.a.p0.h.o0.g.f.b.c("date", a2);
                return true;
            }
            if (this.X0 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.X0 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.H0.addView(this.X0);
            b.a.p0.h.o0.g.f.b.c("date", a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.Y0 == null) {
                PandaParkCloseDialog pandaParkCloseDialog = new PandaParkCloseDialog(getContext());
                this.Y0 = pandaParkCloseDialog;
                pandaParkCloseDialog.setOnClickListener(new h(this));
            }
            n3("pandadialog");
            this.Y0.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void resume() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            o3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.C0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            b.a.p0.a.l0.a v8Engine = this.C0.getV8Engine();
            if (f1) {
                String str = "resume() obj: " + this + " ,v8Engine: " + v8Engine;
            }
            this.R0 = true;
            this.C0.onResume();
            b.a.p0.h.c.j.b.h().k();
            b.a.p0.h.j0.b.b(v8Engine);
            Activity activity2 = this.k0;
            if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                v8Engine.i0(new b.a.p0.h.w.e(((SwanAppActivity) activity2).getLaunchInfo()));
            }
            v8Engine.onResume();
            if (this.H0 != null && this.I0 != null) {
                q0.Y(new RunnableC0573a(this), 500L);
            }
            Activity activity3 = this.k0;
            if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
                if (!this.J0.h()) {
                    this.k0.setRequestedOrientation(isLandScape ? this.W0.equals("landscape") ? 0 : 8 : 1);
                    this.J0.n(isLandScape);
                    this.K0.n(isLandScape);
                }
                b.a.p0.a.v2.f.e(this.k0);
            }
            if (this.V0 == null) {
                this.V0 = new b(this, this.k0, 3, v8Engine);
            }
            if (this.V0.canDetectOrientation() && (activity = this.k0) != null && ((SwanAppActivity) activity).isLandScape()) {
                this.V0.enable();
            } else {
                this.V0.disable();
            }
            this.e1 = false;
            if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                try {
                    this.e1 = new JSONObject(b.a.p0.a.a2.e.i().M().O().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                    this.c1 = System.currentTimeMillis();
                } catch (Exception e2) {
                    if (f1) {
                        e2.printStackTrace();
                    }
                }
            }
            b.a.p0.h.b.d.o().x();
            b.a.p0.a.i1.b.i(true);
            b.a.p0.h.o0.c cVar = this.J0;
            if (cVar != null) {
                cVar.m();
            }
            b.a.p0.h.o0.c cVar2 = this.K0;
            if (cVar2 != null) {
                cVar2.m();
            }
            u3();
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.P0) {
                boolean z = f1;
                return;
            }
            this.P0 = true;
            m mVar = new m(this.O0, this.C0);
            this.Q0 = mVar;
            mVar.sendEmptyMessage(0);
            boolean z2 = f1;
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!this.P0) {
                boolean z = f1;
                return;
            }
            this.P0 = false;
            m mVar = this.Q0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.Q0 = null;
            }
            boolean z2 = f1;
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && n0.E(this.k0)) {
            b.a.p0.a.z1.b.f.e.f(b.a.p0.a.c1.a.b(), b.a.p0.f.g.aiapps_game_not_support_split_screen).F();
            this.k0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, layoutInflater, viewGroup, bundle)) == null) {
            if (f1) {
                String str = "onCreateView obj: " + this;
            }
            if (f0.p(getActivity())) {
                f0.s(getActivity());
            }
            View inflate = layoutInflater.inflate(b.a.p0.a.g.ai_games_fragment, viewGroup, false);
            i3(inflate);
            f3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void w2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (duMixGameSurfaceView = this.C0) == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.C0.getV8Engine().i0(new JSEvent("sharebtn"));
    }
}
