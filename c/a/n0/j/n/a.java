package c.a.n0.j.n;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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
import c.a.n0.a.p2.f0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.x;
import c.a.n0.a.p2.y0;
import c.a.n0.a.s1.b.c.a;
import c.a.n0.j.p0.g.f.c;
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
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c.a.n0.a.x.g.d implements c.a.n0.j.f0.a.b.b, a.InterfaceC0451a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView F0;
    public View G0;
    public ImageView H0;
    public View I0;
    public ImageView J0;
    public FrameLayout K0;
    public View L0;
    public c.a.n0.j.p0.c M0;
    public c.a.n0.j.p0.c N0;
    public c.a.n0.j.f0.a.b.a O0;
    public c.a.n0.a.s1.b.c.a P0;
    public c.a.n0.j.p0.a Q0;
    public TextView R0;
    public boolean S0;
    public m T0;
    public volatile boolean U0;
    public AudioManager V0;
    public boolean W0;
    public l X0;
    public OrientationEventListener Y0;
    public String Z0;
    public GameCloseGuidePopView a1;
    public c.a.n0.j.p0.g.f.c b1;
    public boolean c1;
    public View d1;
    public boolean e1;
    public long f1;
    public long g1;
    public boolean h1;

    /* renamed from: c.a.n0.j.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0714a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0714a(a aVar) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K0.removeView(this.a.L0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.b0.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8827b;

        /* renamed from: c.a.n0.j.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0715a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0715a(b bVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f0.q(this.a.f8827b.getActivity(), this.a.f8827b.G0) && (b2 = f0.b(this.a.f8827b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.f8827b.G0.getLayoutParams();
                    layoutParams.rightMargin += b2;
                    this.a.f8827b.G0.setLayoutParams(layoutParams);
                    c.a.n0.j.u.a.e().b(b2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, int i, c.a.n0.a.b0.a aVar2) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Integer.valueOf(i), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8827b = aVar;
            this.a = aVar2;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.f8827b.M0.h()) {
                return;
            }
            if (260 >= i || i >= 280 || this.f8827b.Z0.equals("landscape")) {
                if (80 >= i || i >= 100 || this.f8827b.Z0.endsWith("landscapeReverse")) {
                    return;
                }
                this.f8827b.i0.setRequestedOrientation(8);
                this.f8827b.Z0 = "landscapeReverse";
                c.a.n0.j.k0.a.a(this.a, this.f8827b.Z0);
                if (a.i1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.f8827b.Z0);
                }
                this.f8827b.G0.postDelayed(new RunnableC0715a(this), 100L);
                return;
            }
            this.f8827b.i0.setRequestedOrientation(0);
            this.f8827b.Z0 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8827b.G0.getLayoutParams();
            layoutParams.rightMargin = this.f8827b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070170);
            this.f8827b.G0.setLayoutParams(layoutParams);
            c.a.n0.j.u.a.e().b(0);
            c.a.n0.j.k0.a.a(this.a, this.f8827b.Z0);
            if (a.i1) {
                Log.d("SwanGameFragment", "onOrientationChanged: " + this.f8827b.Z0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.j.u.a.j().a(this.a.j0, this.a.getContext());
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (a.i1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + this.a.U0);
                }
                if (this.a.U0 || this.a.C3()) {
                    c.a.n0.a.p2.f.e(this.a.i0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.a.getContext());
                if (!f0.q(this.a.getActivity(), this.a.G0) || ((SwanAppActivity) this.a.getActivity()).isLandScape()) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.G0.getLayoutParams();
                layoutParams.topMargin = this.a.G0.getTop() + e2;
                this.a.G0.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.h2();
                c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
                fVar.f4191e = SupportMenuInflater.XML_MENU;
                this.a.y1(fVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
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
                if (a.i1 && c.a.n0.a.n1.a.a.e()) {
                    return;
                }
                c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                if (L != null && TextUtils.equals(c.a.n0.a.t1.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.a.J3();
                } else if (L != null && c.a.n0.a.l0.c.c().h()) {
                    this.a.I3("exitButton");
                } else {
                    c.a.n0.j.r.a aVar = new c.a.n0.j.r.a();
                    aVar.e();
                    if (aVar.f()) {
                        c.a.n0.j.u.a.h().a(this.a.i0, aVar, this.a.q3());
                    } else {
                        this.a.I3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.a {
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

        @Override // c.a.n0.j.p0.g.f.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F3("pandacontinue");
                this.a.b1.dismiss();
            }
        }

        @Override // c.a.n0.j.p0.g.f.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.F3("pandaclose");
                this.a.b1.dismiss();
            }
        }

        @Override // c.a.n0.j.p0.g.f.c.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.F3("pandaexit");
                this.a.b1.dismiss();
                this.a.p3();
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.p3();
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.a1 == null) {
                return;
            }
            this.a.K0.removeView(this.a.a1);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements c.a.n0.j.u.c.k {
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

        @Override // c.a.n0.j.u.c.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p3();
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d1 != null) {
                    this.a.K0.removeView(this.a.d1);
                    this.a.d1 = null;
                }
                this.a.p3();
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

    /* loaded from: classes2.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.j.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0716a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f8828b;

            public RunnableC0716a(l lVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8828b = lVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8828b.a.D3()) {
                    return;
                }
                int i = this.a;
                if (i == -2) {
                    if (a.i1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    this.f8828b.a.S2();
                } else if (i != -1) {
                } else {
                    if (a.i1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    this.f8828b.a.S2();
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

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                q0.e0(new RunnableC0716a(this, i));
            }
        }

        public /* synthetic */ l(a aVar, c cVar) {
            this(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TextView> a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f8829b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(textView);
            this.f8829b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.f8829b.get();
                if (textView != null) {
                    String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                    textView.setText(valueOf);
                    if (a.i1) {
                        Log.d("SwanGameFragment", "gameFps:" + valueOf);
                    }
                }
                sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781270457, "Lc/a/n0/j/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781270457, "Lc/a/n0/j/n/a;");
                return;
            }
        }
        i1 = c.a.n0.a.a.a;
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
        this.O0 = new c.a.n0.j.f0.a.b.a();
        this.Q0 = new c.a.n0.j.p0.a();
        this.U0 = true;
        this.Z0 = "landscape";
        this.c1 = false;
        this.h1 = false;
    }

    public static a E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public void A3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f090184);
            this.K0 = frameLayout;
            DuMixGameSurfaceView r = c.a.n0.j.o.c.m().r();
            this.F0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.F0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (i1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (i1 && !c.a.n0.a.n1.a.a.n()) {
                View inflate = ((ViewStub) view.findViewById(R.id.obfuscated_res_0x7f090182)).inflate();
                if (inflate != null) {
                    this.R0 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090181);
                }
                K3();
            }
            y3(view);
            this.N0 = new c.a.n0.j.p0.c((FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f090185));
            this.M0 = new c.a.n0.j.p0.c(this.K0);
        }
    }

    public boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !this.U0 : invokeV.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.n0.a.x.g.g K1 = K1();
            return K1 != null && (K1.m() instanceof a);
        }
        return invokeV.booleanValue;
    }

    public final boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            boolean booleanValue = L == null ? false : L.T().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            if (i1) {
                Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public final void F3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.f4191e = str;
        y1(fVar);
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || D3() || this.W0) {
            return;
        }
        if (this.V0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.V0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.X0 == null) {
            this.X0 = new l(this, null);
        }
        this.W0 = this.V0.requestAudioFocus(this.X0, 3, 1) == 1;
        if (i1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    public void H3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.c1 = z;
        }
    }

    public boolean I3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String a = c.a.n0.j.p0.g.f.b.a();
            if (TextUtils.equals(a, c.a.n0.j.p0.g.f.b.b("date"))) {
                if (TextUtils.equals(str, "exitButton")) {
                    p3();
                    return false;
                }
                return false;
            }
            View a2 = c.a.n0.j.u.a.e().a(this.i0, r3());
            this.d1 = a2;
            if (a2 != null) {
                this.K0.addView(a2);
                this.e1 = true;
                c.a.n0.j.p0.g.f.b.c("date", a);
                return true;
            }
            if (this.a1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.a1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.K0.addView(this.a1);
            c.a.n0.j.p0.g.f.b.c("date", a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b1 == null) {
                c.a.n0.j.p0.g.f.c cVar = new c.a.n0.j.p0.g.f.c(getContext());
                this.b1 = cVar;
                cVar.e(new h(this));
            }
            F3("pandadialog");
            this.b1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void K2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (duMixGameSurfaceView = this.F0) == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.F0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
    }

    public final void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.S0) {
                if (i1) {
                    Log.d("SwanGameFragment", "Fps monitor already started");
                    return;
                }
                return;
            }
            this.S0 = true;
            m mVar = new m(this.R0, this.F0);
            this.T0 = mVar;
            mVar.sendEmptyMessage(0);
            if (i1) {
                Log.d("SwanGameFragment", "Start fps monitor");
            }
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            if (L != null && TextUtils.equals(c.a.n0.a.t1.e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return J3();
            }
            if (L != null && c.a.n0.a.l0.c.c().h()) {
                return I3("backButton");
            }
            c.a.n0.j.r.a aVar = new c.a.n0.j.r.a();
            aVar.e();
            if (aVar.f()) {
                c.a.n0.j.u.a.h().a(this.i0, aVar, q3());
                return true;
            }
            return I3("backButton");
        }
        return invokeV.booleanValue;
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.S0) {
                if (i1) {
                    Log.d("SwanGameFragment", "fps monitor not started yet");
                    return;
                }
                return;
            }
            this.S0 = false;
            m mVar = this.T0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.T0 = null;
            }
            if (i1) {
                Log.d("SwanGameFragment", "Stop fps monitor");
            }
        }
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && n0.F(this.i0)) {
            c.a.n0.a.s1.b.f.e.f(c.a.n0.a.s0.a.c(), R.string.obfuscated_res_0x7f0f0175).G();
            this.i0.finishAndRemoveTask();
        }
    }

    public void S2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.W0) {
            AudioManager audioManager = this.V0;
            if (audioManager != null && (lVar = this.X0) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.V0 = null;
                this.X0 = null;
            }
            this.W0 = false;
            if (i1) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.j.f0.a.b.b
    @NonNull
    public c.a.n0.j.f0.a.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.O0 : (c.a.n0.j.f0.a.b.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s1.b.c.a.InterfaceC0451a
    public c.a.n0.a.s1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        c.a.n0.j.p0.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.P0 == null && (cVar = this.N0) != null && cVar.getRootView() != null) {
                this.P0 = new c.a.n0.a.s1.b.c.a(this, this.N0.getRootView(), 0);
            }
            return this.P0;
        }
        return (c.a.n0.a.s1.b.c.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            z3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId()));
            }
            if (c.a.n0.a.t1.e.a0() != null) {
                this.m0.p(c.a.n0.a.t1.e.a0().V().d0());
            }
            this.m0.u(c.a.n0.a.s0.a.M().a(), F1(), this.n0, false);
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.k1(z);
            if (i1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (e0()) {
                if (z) {
                    resume();
                } else {
                    pause();
                }
            }
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            M3();
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (O()) {
                pause();
            }
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (O()) {
                resume();
            }
        }
    }

    public final void p3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (activity = this.i0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            fVar.f4191e = IntentConfig.CLOSE;
            y1(fVar);
            ((SwanAppActivity) this.i0).handleSwanAppExit(1);
            y0.b().e(2);
            c.a.n0.j.b.e.g("0");
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.U0 = false;
            S2();
            if (this.L0 == null) {
                this.L0 = new View(this.i0);
            }
            this.K0.removeView(this.L0);
            this.K0.addView(this.L0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.a1;
            if (gameCloseGuidePopView != null) {
                this.K0.removeView(gameCloseGuidePopView);
                this.a1 = null;
            }
            c.a.n0.j.p0.c cVar = this.M0;
            if (cVar != null) {
                cVar.k();
            }
            c.a.n0.j.p0.c cVar2 = this.N0;
            if (cVar2 != null) {
                cVar2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            c.a.n0.a.b0.a v8Engine = this.F0.getV8Engine();
            if (i1) {
                Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            if (!v8Engine.u0()) {
                v8Engine.onPause();
                v8Engine.dispatchEvent(new JSEvent("apphide"));
                c.a.n0.j.k0.b.a(v8Engine);
                EventTarget p = v8Engine.p();
                if (p instanceof c.a.n0.j.d.b) {
                    ((c.a.n0.j.d.b) p).hideKeyboard();
                }
            }
            c.a.n0.j.c.j.b.h().l();
            if (this.h1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.g1 = currentTimeMillis;
                c.a.n0.j.j.a.d(this.f1, currentTimeMillis);
            }
            c.a.n0.j.b.d.o().n();
            c.a.n0.a.z0.b.j(false);
            this.F0.r();
            OrientationEventListener orientationEventListener = this.Y0;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            c.a.n0.n.f fVar = this.m0;
            if (fVar == null || !fVar.j()) {
                return;
            }
            this.m0.g(false);
        }
    }

    public final c.a.n0.j.u.c.k q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new j(this) : (c.a.n0.j.u.c.k) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new k(this) : (GameCloseGuidePopView.e) invokeV.objValue;
    }

    public void resume() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            G3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
                return;
            }
            c.a.n0.a.b0.a v8Engine = this.F0.getV8Engine();
            if (i1) {
                Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
            }
            this.U0 = true;
            this.F0.s();
            c.a.n0.j.c.j.b.h().k();
            c.a.n0.j.k0.b.b(v8Engine);
            Activity activity2 = this.i0;
            if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                v8Engine.dispatchEvent(new c.a.n0.j.x.e(((SwanAppActivity) activity2).getLaunchInfo()));
            }
            v8Engine.onResume();
            if (this.K0 != null && this.L0 != null) {
                q0.b0(new RunnableC0714a(this), 500L);
            }
            Activity activity3 = this.i0;
            if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
                if (!this.M0.h()) {
                    this.i0.setRequestedOrientation(isLandScape ? this.Z0.equals("landscape") ? 0 : 8 : 1);
                    this.M0.n(isLandScape);
                    this.N0.n(isLandScape);
                }
                c.a.n0.a.p2.f.e(this.i0);
            }
            if (this.Y0 == null) {
                this.Y0 = new b(this, this.i0, 3, v8Engine);
            }
            if (this.Y0.canDetectOrientation() && (activity = this.i0) != null && ((SwanAppActivity) activity).isLandScape()) {
                this.Y0.enable();
            } else {
                this.Y0.disable();
            }
            this.h1 = false;
            if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                try {
                    this.h1 = new JSONObject(c.a.n0.a.t1.e.L().X().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                    this.f1 = System.currentTimeMillis();
                } catch (Exception e2) {
                    if (i1) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.d1 != null) {
                c.a.n0.j.u.a.e().c();
            }
            c.a.n0.j.b.d.o().x();
            c.a.n0.a.z0.b.j(true);
            c.a.n0.j.p0.c cVar = this.M0;
            if (cVar != null) {
                cVar.m();
            }
            c.a.n0.j.p0.c cVar2 = this.N0;
            if (cVar2 != null) {
                cVar2.m();
            }
            M3();
        }
    }

    @NonNull
    public c.a.n0.j.p0.a s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.Q0 : (c.a.n0.j.p0.a) invokeV.objValue;
    }

    public View t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.G0 : (View) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.u0(bundle);
            q.j(new c(this), "SwanGamePageHistory");
        }
    }

    public c.a.n0.j.p0.c u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.M0 : (c.a.n0.j.p0.c) invokeV.objValue;
    }

    public c.a.n0.n.f v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m0 : (c.a.n0.n.f) invokeV.objValue;
    }

    public c.a.n0.j.p0.c w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.N0 : (c.a.n0.j.p0.c) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (f0.p(getActivity())) {
                f0.s(getActivity());
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008e, viewGroup, false);
            A3(inflate);
            x3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public final void x3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (duMixGameSurfaceView = this.F0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                L3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.F0.p();
            }
            if (this.e1) {
                this.d1 = null;
                c.a.n0.j.u.a.e().release();
            }
            c.a.n0.j.p0.c cVar = this.M0;
            if (cVar != null) {
                cVar.l();
            }
            c.a.n0.j.p0.c cVar2 = this.N0;
            if (cVar2 != null) {
                cVar2.l();
            }
            this.Q0.e();
            c.a.n0.a.z0.b.c();
            c.a.n0.j.q.c.b.g(false);
            c.a.n0.j.q.c.b.k();
            super.y0();
        }
    }

    public final void y3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f092070);
            this.G0 = findViewById;
            findViewById.post(new e(this));
            this.H0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092072);
            this.I0 = view.findViewById(R.id.obfuscated_res_0x7f092073);
            this.J0 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092071);
            this.H0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080124));
            this.J0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08010f));
            this.I0.setBackgroundResource(R.color.obfuscated_res_0x7f060377);
            this.G0.setBackgroundResource(R.drawable.obfuscated_res_0x7f080120);
            this.H0.setOnClickListener(new f(this));
            this.J0.setOnClickListener(new g(this));
        }
    }

    public void z3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.c1) {
            c.a.n0.n.f fVar = this.m0;
            if (fVar != null && fVar.j()) {
                this.m0.g(false);
            }
            this.m0 = null;
            this.c1 = false;
        }
        if (this.n0 == null) {
            this.n0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.m0 == null) {
            c.a.n0.n.f fVar2 = new c.a.n0.n.f(activity, this.G0, 0, c.a.n0.a.s0.a.K(), new c.a.n0.a.q2.h.b());
            this.m0 = fVar2;
            fVar2.n(c.a.n0.a.p2.f.c());
            this.O0.b(this.m0);
            c.a.n0.a.f.b.a.k F = c.a.n0.a.w0.f.U().F();
            if (F != null) {
                F.b(this.m0);
            }
            new c.a.n0.a.a1.a(this.m0, this, this.n0).z();
        }
    }
}
