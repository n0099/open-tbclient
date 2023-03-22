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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.nadcore.widget.SlideHelper;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.d31;
import com.baidu.tieba.o41;
import com.baidu.tieba.sf0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.uf0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.xa1;
import com.baidu.tieba.z31;
import com.baidu.tieba.za1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class BaseActivity extends FragmentActivity {
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static boolean s;
    public static ArrayList<d> t = new ArrayList<>();
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public boolean e = true;
    public boolean f = false;
    public boolean g = true;
    public boolean h = false;
    public boolean i = false;
    public SlideInterceptor j;
    public SlideHelper k;
    public SlidingPaneLayout.e l;
    public WeakReference<Activity> m;
    public SlidingPaneLayout.e n;

    /* loaded from: classes2.dex */
    public interface d {
        void a(Object obj);
    }

    @CallSuper
    public void B1(Bundle bundle) {
    }

    @CallSuper
    public void C1() {
    }

    @CallSuper
    public void E1(Intent intent) {
    }

    @CallSuper
    public void F1() {
    }

    @CallSuper
    public void G1(Bundle bundle) {
    }

    @CallSuper
    public void H1() {
    }

    @CallSuper
    public void I1() {
    }

    @CallSuper
    public void J1() {
    }

    @CallSuper
    public void K1() {
    }

    @CallSuper
    public boolean L1(Bundle bundle) {
        return true;
    }

    /* loaded from: classes2.dex */
    public class a implements xa1 {
        @Override // com.baidu.tieba.xa1
        public void onTranslucent(boolean z) {
        }

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SlidingPaneLayout.e {
        public boolean a = true;
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelClosed(View view2) {
            if (BaseActivity.this.n != null) {
                BaseActivity.this.n.onPanelClosed(view2);
            }
            if (BaseActivity.this.l != null) {
                BaseActivity.this.l.onPanelClosed(view2);
            }
            if (!BaseActivity.this.g && !BaseActivity.this.i && this.a) {
                this.a = false;
                za1.c(BaseActivity.this, null);
            }
            BaseActivity.this.T1(0.0f);
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelOpened(View view2) {
            if (BaseActivity.this.n != null) {
                BaseActivity.this.n.onPanelOpened(view2);
            }
            if (BaseActivity.this.l != null) {
                BaseActivity.this.l.onPanelOpened(view2);
            }
            BaseActivity.this.T1(0.0f);
            BaseActivity.this.k.setShadowDrawable(null);
            BaseActivity.this.finish();
            BaseActivity.this.overridePendingTransition(0, 0);
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelSlide(View view2, float f) {
            View maskView = BaseActivity.this.k.getMaskView();
            if (maskView != null) {
                float f2 = 1.0f - f;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                maskView.setAlpha(f2);
            }
            if (BaseActivity.this.n != null) {
                BaseActivity.this.n.onPanelSlide(view2, f);
            }
            if (BaseActivity.this.l != null) {
                BaseActivity.this.l.onPanelSlide(view2, f);
            }
            if (!BaseActivity.this.g && !BaseActivity.this.i && !this.a) {
                this.a = true;
                za1.d(BaseActivity.this, null);
            }
            float f3 = this.b >> 2;
            BaseActivity.this.T1((f * f3) - f3);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity baseActivity = BaseActivity.this;
            baseActivity.N1(baseActivity.getWindow().getDecorView());
        }
    }

    public void M1() {
        if (o != 0 || p != 0) {
            this.a = o;
            this.b = p;
        }
        if (q != 0 || r != 0) {
            this.c = q;
            this.d = r;
        }
        Q1(0, 0, 0, 0);
    }

    public final void V1() {
        if (this.a != 0 || this.b != 0) {
            overridePendingTransition(this.a, this.b);
            this.a = 0;
            this.b = 0;
        }
    }

    public final void W1() {
        if (this.c != 0 || this.d != 0) {
            overridePendingTransition(this.c, this.d);
            this.c = 0;
            this.d = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        W1();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        V1();
        A1();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        C1();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        F1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        H1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        I1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        J1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        K1();
    }

    public void setCurrentActivityNoTransparent() {
        za1.c(this, new a());
    }

    public static void P1(boolean z) {
        s = z;
    }

    public void U1(boolean z) {
        this.g = z;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        if (z31.b.d()) {
            return super.checkSelfPermission(str);
        }
        return 0;
    }

    public void forceActivityTransparent(boolean z) {
        this.i = z;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (z && !s) {
            d31.a().b(getApplicationContext(), R.string.nad_androidn_multiwindow_user_toast, 1);
            P1(true);
        } else if (!z && !z31.c()) {
            P1(false);
        }
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        z1();
        G1(bundle);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setEnableSliding(boolean z) {
        this.f = z;
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        if (z31.b.d() && super.shouldShowRequestPermissionRationale(str)) {
            return true;
        }
        return false;
    }

    public static void Q1(int i, int i2, int i3, int i4) {
        o = i;
        p = i2;
        q = i3;
        r = i4;
    }

    public void R1(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public void O1(boolean z, SlideInterceptor slideInterceptor) {
        this.f = z;
        this.j = slideInterceptor;
    }

    public final void S1(Activity activity, float f) {
        View decorView;
        if (activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setX(f);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void A1() {
        String str;
        if (getIntent() != null && getIntent().hasExtra("winAccelerate")) {
            str = getIntent().getStringExtra("winAccelerate");
        } else {
            str = "0";
        }
        if ((this.e || TextUtils.equals("1", str)) && findViewById(16908290) != null) {
            wi0.b(new c());
        }
    }

    public final void N1(View view2) {
        if (Build.VERSION.SDK_INT > 23) {
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
    public final void onNewIntent(Intent intent) {
        ArrayList arrayList;
        super.onNewIntent(intent);
        M1();
        V1();
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
            E1(intent);
        } catch (Throwable th) {
            if (!sf0.a) {
                finish();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public final void T1(float f) {
        try {
            if (this.m == null || this.m.get() == null) {
                this.m = new WeakReference<>(tm0.d());
            }
            if (this.m.get() != null) {
                Activity e = tm0.e();
                Activity activity = this.m.get();
                if (e != null && activity != null && e.getLocalClassName().equals(activity.getLocalClassName())) {
                    S1(activity, 0.0f);
                } else {
                    S1(activity, f);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        if (uf0.a(this)) {
            return;
        }
        try {
            if (!L1(bundle)) {
                if (!sf0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException("Class " + getClass() + " failed at preCreate");
            }
            int d2 = o41.d(this);
            super.onCreate(bundle);
            o41.a(this, d2);
            M1();
            try {
                B1(bundle);
            } catch (Throwable th) {
                if (!sf0.a) {
                    finish();
                    return;
                }
                throw new RuntimeException(th);
            }
        } catch (Throwable unused) {
            if (!sf0.a) {
                finish();
                return;
            }
            throw new RuntimeException("Class " + getClass() + " failed at preCreate");
        }
    }

    public final void z1() {
        if (this.f) {
            boolean z = true;
            boolean z2 = false;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            }
            if (this.h || !isTaskRoot()) {
                z2 = z;
            }
            int e = z31.c.e(this);
            SlideHelper slideHelper = new SlideHelper();
            this.k = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.k.setCanSlide(z2);
            this.k.forceActivityTransparent(this.i);
            this.k.attachActivity(this);
            this.k.setSlideInterceptor(this.j);
            this.k.setSlideListener(new b(e));
        }
    }
}
