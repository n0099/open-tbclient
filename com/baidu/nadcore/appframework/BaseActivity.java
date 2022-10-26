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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.SlideHelper;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.b21;
import com.baidu.tieba.j31;
import com.baidu.tieba.jn0;
import com.baidu.tieba.og0;
import com.baidu.tieba.oj0;
import com.baidu.tieba.p61;
import com.baidu.tieba.qg0;
import com.baidu.tieba.r61;
import com.baidu.tieba.u21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static ArrayList t;
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
    public WeakReference m;
    public SlidingPaneLayout.e n;

    /* loaded from: classes2.dex */
    public interface d {
        void a(Object obj);
    }

    public void Y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void a1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void c1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
        }
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public boolean j1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class a implements p61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        @Override // com.baidu.tieba.p61
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

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
                    r61.c(this.c, null);
                }
                this.c.r1(0.0f);
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
                this.c.r1(0.0f);
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
                    r61.d(this.c, null);
                }
                float f3 = this.b >> 2;
                this.c.r1((f * f3) - f3);
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
                baseActivity.l1(baseActivity.getWindow().getDecorView());
            }
        }
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
        t = new ArrayList();
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.finish();
            u1();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onAttachedToWindow();
            t1();
            V0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            Z0();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onPostResume();
            e1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            g1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onStart();
            h1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onStop();
            i1();
        }
    }

    public void setCurrentActivityNoTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            r61.c(this, new a(this));
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.a != 0 || this.b != 0) {
                overridePendingTransition(this.a, this.b);
                this.a = 0;
                this.b = 0;
            }
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.c != 0 || this.d != 0) {
                overridePendingTransition(this.c, this.d);
                this.c = 0;
                this.d = 0;
            }
        }
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

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (o != 0 || p != 0) {
                this.a = o;
                this.b = p;
            }
            if (q != 0 || r != 0) {
                this.c = q;
                this.d = r;
            }
            o1(0, 0, 0, 0);
        }
    }

    public static void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            s = z;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (u21.b.d()) {
                return super.checkSelfPermission(str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fragment) == null) {
            super.onAttachFragment(fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            SlideHelper slideHelper = this.k;
            if (slideHelper != null) {
                if (configuration.orientation != 2) {
                    z = true;
                } else {
                    z = false;
                }
                slideHelper.setCanSlide(z);
            }
        }
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onPostCreate(bundle);
            U0();
            c1(bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public void s1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.g = z;
        }
    }

    public void setEnableSliding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.f = z;
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (u21.b.d() && super.shouldShowRequestPermissionRationale(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m1(boolean z, SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, slideInterceptor) == null) {
            this.f = z;
            this.j = slideInterceptor;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i, keyEvent)) == null) {
            if (i == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void q1(Activity activity, float f) {
        View decorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048616, this, activity, f) == null) && activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setX(f);
        }
    }

    public static void o1(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65546, null, i, i2, i3, i4) == null) {
            o = i;
            p = i2;
            q = i3;
            r = i4;
        }
    }

    public void p1(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048615, this, i, i2, i3, i4) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
            boolean z = true;
            boolean z2 = false;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            }
            if (this.h || !isTaskRoot()) {
                z2 = z;
            }
            int e = u21.c.e(this);
            SlideHelper slideHelper = new SlideHelper();
            this.k = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.k.setCanSlide(z2);
            this.k.forceActivityTransparent(this.i);
            this.k.attachActivity(this);
            this.k.setSlideInterceptor(this.j);
            this.k.setSlideListener(new b(this, e));
        }
    }

    public final void V0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (getIntent() != null && getIntent().hasExtra("winAccelerate")) {
                str = getIntent().getStringExtra("winAccelerate");
            } else {
                str = "0";
            }
            if ((this.e || TextUtils.equals("1", str)) && findViewById(16908290) != null) {
                oj0.b(new c(this));
            }
        }
    }

    public final void l1(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, view2) != null) || Build.VERSION.SDK_INT > 23) {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.onMultiWindowModeChanged(z);
            if (z && !s) {
                b21.a().b(getApplicationContext(), R.string.obfuscated_res_0x7f0f0b8b, 1);
                n1(true);
            } else if (!z && !u21.a()) {
                n1(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, bundle) != null) || qg0.a(this)) {
            return;
        }
        try {
            if (!j1(bundle)) {
                if (!og0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException("Class " + getClass() + " failed at preCreate");
            }
            int d2 = j31.d(this);
            super.onCreate(bundle);
            j31.a(this, d2);
            k1();
            try {
                Y0(bundle);
            } catch (Throwable th) {
                if (!og0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException(th);
            }
        } catch (Throwable unused) {
            if (!og0.a) {
                finish();
                return;
            }
            throw new RuntimeException("Class " + getClass() + " failed at preCreate");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
            super.onNewIntent(intent);
            k1();
            t1();
            ArrayList arrayList2 = t;
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
                a1(intent);
            } catch (Throwable th) {
                if (!og0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException(th);
            }
        }
    }

    public final void r1(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f) == null) {
            try {
                if (this.m == null || this.m.get() == null) {
                    this.m = new WeakReference(jn0.d());
                }
                if (this.m.get() != null) {
                    Activity e = jn0.e();
                    Activity activity = (Activity) this.m.get();
                    if (e != null && activity != null && e.getLocalClassName().equals(activity.getLocalClassName())) {
                        q1(activity, 0.0f);
                    } else {
                        q1(activity, f);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
