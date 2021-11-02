package b.a.p0.a.v2;

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
import b.a.p0.a.f1.e.b;
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
/* loaded from: classes.dex */
public class e implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f8584i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f8585e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f8586f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.g2.b f8587g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f8588h;

    /* loaded from: classes.dex */
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
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.f8585e != null) {
                    this.this$0.f8585e.closePane();
                    this.this$0.f8585e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8589a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f8590b;

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
            this.f8590b = eVar;
            this.f8589a = swanAppActivity;
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
                this.f8589a.onBackPressed(3);
                this.f8590b.i();
                this.f8589a.overridePendingTransition(0, 0);
                b.a.p0.a.m1.g.f().i();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) || (maskView = this.f8590b.f8585e.getMaskView()) == null) {
                return;
            }
            maskView.setAlpha(1.0f - f2);
            if (this.f8589a.hasActivedFrame()) {
                this.f8589a.getFrame().i0();
            }
            if (f2 == 0.0f) {
                maskView.setBackgroundColor(Color.parseColor(SlideHelper.DEFAULT_MASK_COLOR));
            }
            if (f2 == 1.0f) {
                maskView.setBackgroundColor(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337554611, "Lb/a/p0/a/v2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337554611, "Lb/a/p0/a/v2/e;");
                return;
            }
        }
        f8584i = b.a.p0.a.k.f6397a;
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
        this.f8588h = new a(this);
        this.f8586f = new WeakReference<>(swanAppActivity);
        this.f8585e = new SlideHelper();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SwanAppActivity swanAppActivity = this.f8586f.get();
            return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f8585e.closePane();
        }
    }

    public void f() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (swanAppActivity = this.f8586f.get()) == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f8585e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f8585e.attachActivity(swanAppActivity);
        this.f8585e.setEnableReleaseWhenNoTranslucent(false);
        this.f8585e.setFadeColor(0);
        this.f8585e.setSlideInterceptor(this);
        this.f8585e.setSlideListener(new b(this, swanAppActivity));
        b.a.p0.a.p.e.b g2 = g();
        if (g2 != null) {
            this.f8585e.setRegionFactor(g2.A());
        }
    }

    public final b.a.p0.a.p.e.b g() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.g swanAppFragmentManager;
        b.a.p0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.f8586f.get();
            if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof b.a.p0.a.h0.g.f)) {
                return null;
            }
            return ((b.a.p0.a.h0.g.f) m).V2();
        }
        return (b.a.p0.a.p.e.b) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b.a.p0.a.c1.a.H().a()) {
            this.f8587g.c(8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [b.a.p0.a.p.e.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b.a.p0.a.h0.g.g swanAppFragmentManager;
        b.a.p0.a.p.e.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.f8586f.get();
            if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
                return false;
            }
            b.a.p0.a.p.e.e k = g2.k();
            return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(k != null && k.s() != 0 && k.s().canGoBack()) && l();
        }
        return invokeL.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppActivity swanAppActivity = this.f8586f.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
                b.a.p0.a.h0.g.f o = swanAppActivity.getSwanAppFragmentManager().o();
                if (o != null) {
                    b.a.p0.a.a2.n.g x1 = o.x1();
                    if (x1 == null) {
                        return true;
                    }
                    if (x1.l || x1.m) {
                        b.a.p0.a.e2.c.f fVar = b.a.p0.a.n1.q.c.a.g(true).get("scope_disable_swipe_back");
                        if (fVar == null || fVar.f4907d) {
                            return false;
                        }
                        SlideHelper slideHelper = this.f8585e;
                        if (slideHelper != null) {
                            slideHelper.setRegionFactor(0.1d);
                        }
                    }
                    return true;
                }
                boolean z = f8584i;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (swanAppActivity = this.f8586f.get()) == null) {
            return;
        }
        b.a.p0.a.g2.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f8587g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (b.a.p0.a.f1.c.a.c(false).booleanValue()) {
            this.f8587g.c(0);
        }
        f();
    }

    public void o() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (swanAppActivity = this.f8586f.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f8588h, intentFilter);
    }

    public void p() {
        WeakReference<SwanAppActivity> weakReference;
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (weakReference = this.f8586f) == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f8588h);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f8586f.get() == null) {
            return;
        }
        this.f8585e.setCanSlide(c());
    }

    public void s() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (swanAppActivity = this.f8586f.get()) == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.S())) || swanAppActivity.getFrameType() == 1) {
            this.f8585e.setCanSlide(false);
        } else {
            this.f8585e.setCanSlide(c());
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && b.a.p0.a.f1.c.a.c(true).booleanValue()) {
            this.f8587g.c(0);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f8585e.setCanSlide(z);
        }
    }
}
