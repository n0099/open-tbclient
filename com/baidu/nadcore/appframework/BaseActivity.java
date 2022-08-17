package com.baidu.nadcore.appframework;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.nadcore.widget.SlideHelper;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c11;
import com.repackage.i41;
import com.repackage.il0;
import com.repackage.j41;
import com.repackage.p01;
import com.repackage.qh0;
import com.repackage.te0;
import com.repackage.ve0;
import com.repackage.xz0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class BaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static boolean s;
    public static ArrayList<d> t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public SlideInterceptor j;
    public SlideHelper k;
    public SlidingPaneLayout.e l;
    public WeakReference<Activity> m;
    public SlidingPaneLayout.e n;

    /* loaded from: classes2.dex */
    public class a implements i41 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        public a(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivity;
        }

        @Override // com.repackage.i41
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SlidingPaneLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseActivity c;

        public b(BaseActivity baseActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseActivity;
            this.b = i;
            this.a = true;
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.n != null) {
                    this.c.n.onPanelClosed(view2);
                }
                if (this.c.l != null) {
                    this.c.l.onPanelClosed(view2);
                }
                if (!this.c.g && !this.c.i && this.a) {
                    this.a = false;
                    j41.c(this.c, null);
                }
                this.c.m1(0.0f);
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.c.n != null) {
                    this.c.n.onPanelOpened(view2);
                }
                if (this.c.l != null) {
                    this.c.l.onPanelOpened(view2);
                }
                this.c.m1(0.0f);
                this.c.k.setShadowDrawable(null);
                this.c.finish();
                this.c.overridePendingTransition(0, 0);
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                View maskView = this.c.k.getMaskView();
                if (maskView != null) {
                    float f2 = 1.0f - f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    maskView.setAlpha(f2);
                }
                if (this.c.n != null) {
                    this.c.n.onPanelSlide(view2, f);
                }
                if (this.c.l != null) {
                    this.c.l.onPanelSlide(view2, f);
                }
                if (!this.c.g && !this.c.i && !this.a) {
                    this.a = true;
                    j41.d(this.c, null);
                }
                float f3 = this.b >> 2;
                this.c.m1((f * f3) - f3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        public c(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseActivity baseActivity = this.a;
                baseActivity.f1(baseActivity.getWindow().getDecorView());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(115536470, "Lcom/baidu/nadcore/appframework/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(115536470, "Lcom/baidu/nadcore/appframework/BaseActivity;");
                return;
            }
        }
        t = new ArrayList<>();
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = true;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = false;
    }

    public static void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            s = z;
        }
    }

    public static void j1(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65546, null, i, i2, i3, i4) == null) {
            o = i;
            p = i2;
            q = i3;
            r = i4;
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
            boolean z = false;
            boolean z2 = getResources().getConfiguration().orientation != 2;
            if (this.h || !isTaskRoot()) {
                z = z2;
            }
            int e = p01.c.e(this);
            SlideHelper slideHelper = new SlideHelper();
            this.k = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.k.setCanSlide(z);
            this.k.forceActivityTransparent(this.i);
            this.k.attachActivity(this);
            this.k.setSlideInterceptor(this.j);
            this.k.setSlideListener(new b(this, e));
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String stringExtra = (getIntent() == null || !getIntent().hasExtra("winAccelerate")) ? "0" : getIntent().getStringExtra("winAccelerate");
            if ((this.e || TextUtils.equals("1", stringExtra)) && findViewById(16908290) != null) {
                qh0.b(new c(this));
            }
        }
    }

    @CallSuper
    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
        }
    }

    @CallSuper
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @CallSuper
    public void T0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
        }
    }

    @CallSuper
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @CallSuper
    public void V0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
        }
    }

    @CallSuper
    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @CallSuper
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @CallSuper
    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @CallSuper
    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @CallSuper
    public boolean c1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (p01.b.d()) {
                return super.checkSelfPermission(str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (o != 0 || p != 0) {
                this.a = o;
                this.b = p;
            }
            if (q != 0 || r != 0) {
                this.c = q;
                this.d = r;
            }
            j1(0, 0, 0, 0);
        }
    }

    public final void f1(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view2) == null) || Build.VERSION.SDK_INT > 23) {
            return;
        }
        try {
            ViewParent parent = view2.getRootView().getParent();
            Method declaredMethod = parent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(parent, Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.finish();
            p1();
        }
    }

    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.i = z;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? super.getResources() : (Resources) invokeV.objValue;
    }

    public void h1(boolean z, SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, slideInterceptor) == null) {
            this.f = z;
            this.j = slideInterceptor;
        }
    }

    public void k1(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i, i2, i3, i4) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public final void l1(Activity activity, float f) {
        View decorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048596, this, activity, f) == null) || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        decorView.setX(f);
    }

    public final void m1(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            try {
                if (this.m == null || this.m.get() == null) {
                    this.m = new WeakReference<>(il0.d());
                }
                if (this.m.get() != null) {
                    Activity e = il0.e();
                    Activity activity = this.m.get();
                    if (e != null && activity != null && e.getLocalClassName().equals(activity.getLocalClassName())) {
                        l1(activity, 0.0f);
                    } else {
                        l1(activity, f);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.g = z;
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.a == 0 && this.b == 0) {
                return;
            }
            overridePendingTransition(this.a, this.b);
            this.a = 0;
            this.b = 0;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fragment) == null) {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onAttachedToWindow();
            o1();
            O0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            SlideHelper slideHelper = this.k;
            if (slideHelper != null) {
                slideHelper.setCanSlide(configuration.orientation != 2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            if (ve0.a(this)) {
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            try {
                if (!c1(bundle)) {
                    if (!te0.a) {
                        finish();
                        LogUtil.logActivity(this, "onCreate");
                        return;
                    }
                    RuntimeException runtimeException = new RuntimeException("Class " + getClass() + " failed at preCreate");
                    LogUtil.logActivity(this, "onCreate");
                    throw runtimeException;
                }
                int d2 = c11.d(this);
                super.onCreate(bundle);
                c11.a(this, d2);
                d1();
                try {
                    P0(bundle);
                } catch (Throwable th) {
                    if (!te0.a) {
                        finish();
                    } else {
                        RuntimeException runtimeException2 = new RuntimeException(th);
                        LogUtil.logActivity(this, "onCreate");
                        throw runtimeException2;
                    }
                }
                LogUtil.logActivity(this, "onCreate");
            } catch (Throwable unused) {
                if (!te0.a) {
                    finish();
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
                RuntimeException runtimeException3 = new RuntimeException("Class " + getClass() + " failed at preCreate");
                LogUtil.logActivity(this, "onCreate");
                throw runtimeException3;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDestroy();
            S0();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i, keyEvent)) == null) {
            if (i == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            super.onMultiWindowModeChanged(z);
            if (z && !s) {
                xz0.a().b(getApplicationContext(), R.string.obfuscated_res_0x7f0f0b60, 1);
                i1(true);
            } else if (z || p01.a()) {
            } else {
                i1(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, intent) == null) {
            super.onNewIntent(intent);
            d1();
            o1();
            ArrayList<d> arrayList2 = t;
            if (arrayList2 != null) {
                synchronized (arrayList2) {
                    arrayList = new ArrayList(t);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(intent);
                }
            }
            try {
                T0(intent);
            } catch (Throwable th) {
                if (!te0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException(th);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            U0();
        }
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onPostCreate(bundle);
            N0();
            V0(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPostResume();
            W0();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onResume();
            Z0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStart();
            a1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStop();
            b1();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.c == 0 && this.d == 0) {
                return;
            }
            overridePendingTransition(this.c, this.d);
            this.c = 0;
            this.d = 0;
        }
    }

    public void setCurrentActivityNoTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            j41.c(this, new a(this));
        }
    }

    public void setEnableSliding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.f = z;
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) ? p01.b.d() && super.shouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }
}
