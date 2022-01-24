package c.a.r0.a.z2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class e implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10096i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f10097e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f10098f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.j2.b f10099g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f10100h;

    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.f10097e != null) {
                    this.this$0.f10097e.closePane();
                    this.this$0.f10097e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10101b;

        public b(e eVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10101b = eVar;
            this.a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.onBackPressed(3);
                this.f10101b.h();
                this.a.overridePendingTransition(0, 0);
                c.a.r0.a.n1.h.e().g();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) || (maskView = this.f10101b.f10097e.getMaskView()) == null) {
                return;
            }
            maskView.setAlpha(1.0f - f2);
            if (this.a.hasActivedFrame()) {
                this.a.getFrame().t0();
            }
            if (f2 == 0.0f) {
                maskView.setBackgroundColor(Color.parseColor("#40000000"));
            }
            if (f2 == 1.0f) {
                maskView.setBackgroundColor(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442663060, "Lc/a/r0/a/z2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(442663060, "Lc/a/r0/a/z2/e;");
                return;
            }
        }
        f10096i = c.a.r0.a.k.a;
    }

    public e(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10100h = new a(this);
        this.f10098f = new WeakReference<>(swanAppActivity);
        this.f10097e = new SlideHelper();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SwanAppActivity swanAppActivity = this.f10098f.get();
            return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10097e.closePane();
        }
    }

    public void f() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (swanAppActivity = this.f10098f.get()) == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f10097e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f10097e.attachActivity(swanAppActivity);
        this.f10097e.setEnableReleaseWhenNoTranslucent(false);
        this.f10097e.setFadeColor(0);
        this.f10097e.setSlideInterceptor(this);
        this.f10097e.setSlideListener(new b(this, swanAppActivity));
        c.a.r0.a.p.e.b g2 = g();
        if (g2 != null) {
            this.f10097e.setRegionFactor(g2.B());
        }
    }

    public final c.a.r0.a.p.e.b g() {
        InterceptResult invokeV;
        c.a.r0.a.h0.g.g swanAppFragmentManager;
        c.a.r0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.f10098f.get();
            if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof c.a.r0.a.h0.g.f)) {
                return null;
            }
            return ((c.a.r0.a.h0.g.f) m).i3();
        }
        return (c.a.r0.a.p.e.b) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && c.a.r0.a.c1.a.M().a()) {
            this.f10099g.c(8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [c.a.r0.a.p.e.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c.a.r0.a.h0.g.g swanAppFragmentManager;
        c.a.r0.a.p.e.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.f10098f.get();
            if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
                return false;
            }
            c.a.r0.a.p.e.e l = g2.l();
            return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(l != null && l.t() != 0 && l.t().canGoBack()) && j();
        }
        return invokeL.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppActivity swanAppActivity = this.f10098f.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
                c.a.r0.a.h0.g.f o = swanAppActivity.getSwanAppFragmentManager().o();
                if (o != null) {
                    c.a.r0.a.d2.n.g A1 = o.A1();
                    if (A1 == null) {
                        return true;
                    }
                    if (A1.l || A1.m) {
                        c.a.r0.a.h2.c.f fVar = c.a.r0.a.p1.r.c.a.g(true).get("scope_disable_swipe_back");
                        if (fVar == null || fVar.f7267d) {
                            return false;
                        }
                        SlideHelper slideHelper = this.f10097e;
                        if (slideHelper != null) {
                            slideHelper.setRegionFactor(0.1d);
                        }
                    }
                    return true;
                }
                boolean z = f10096i;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (swanAppActivity = this.f10098f.get()) == null) {
            return;
        }
        c.a.r0.a.j2.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f10099g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (c.a.r0.a.f1.c.a.c(false).booleanValue()) {
            this.f10099g.c(0);
        }
        f();
    }

    public void o() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (swanAppActivity = this.f10098f.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f10100h, intentFilter);
    }

    public void p() {
        WeakReference<SwanAppActivity> weakReference;
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (weakReference = this.f10098f) == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f10100h);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f10098f.get() == null) {
            return;
        }
        this.f10097e.setCanSlide(c());
    }

    public void r() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (swanAppActivity = this.f10098f.get()) == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.T())) || swanAppActivity.getFrameType() == 1) {
            this.f10097e.setCanSlide(false);
        } else {
            this.f10097e.setCanSlide(c());
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && c.a.r0.a.f1.c.a.c(true).booleanValue()) {
            this.f10099g.c(0);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f10097e.setCanSlide(z);
        }
    }
}
