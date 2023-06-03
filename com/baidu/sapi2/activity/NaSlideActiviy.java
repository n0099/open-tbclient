package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class NaSlideActiviy extends AppCompatActivity {
    public static final String g = "NaSlideActivity";
    public static final boolean h = true;
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();
    public SlideInterceptor d;
    public SlidingPaneLayout.PanelSlideListener e;
    public WeakReference<Activity> f;
    public SlideHelper mSlideHelper;

    private void b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.sapi2.activity.NaSlideActiviy.1
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void forceActivityTransparent(boolean z) {
        this.c = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = true;
        Log.d(g, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            if (configuration.orientation == 2) {
                z = false;
            }
            slideHelper.setCanSlide(z);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            b();
        }
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.supportGestureSlide) {
            this.a = true;
        } else {
            this.a = false;
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(g, "onPostCreate");
        a();
    }

    public void setEnableSliding(boolean z) {
        this.a = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.b = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.e = panelSlideListener;
    }

    private void a() {
        boolean z;
        if (this.a) {
            final int i = 0;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            } else {
                z = true;
            }
            if (!this.b && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(g, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.widthPixels;
            }
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.c);
            this.mSlideHelper.setSlideInterceptor(this.d);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.sapi2.activity.NaSlideActiviy.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view2) {
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelClosed(view2);
                    }
                    NaSlideActiviy.this.a(0.0f);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view2) {
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelOpened(view2);
                    }
                    NaSlideActiviy.this.a(0.0f);
                    NaSlideActiviy.this.mSlideHelper.setShadowDrawable(null);
                    NaSlideActiviy.this.finishActivityAfterSlideOver();
                    NaSlideActiviy.this.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view2, float f) {
                    View maskView = NaSlideActiviy.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f2 = 1.0f - f;
                        if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        maskView.setAlpha(f2);
                    }
                    if (NaSlideActiviy.this.e != null) {
                        NaSlideActiviy.this.e.onPanelSlide(view2, f);
                    }
                    float f3 = i >> 2;
                    NaSlideActiviy.this.a((f * f3) - f3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        try {
            if (this.f == null || this.f.get() == null) {
                this.f = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
            }
            if (this.f.get() != null) {
                Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                Activity activity = this.f.get();
                if (realTopActivity != null && activity != null && realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
                    a(activity, 0.0f);
                } else {
                    a(activity, f);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Activity activity, float f) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.setX(f);
            }
        }
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.a = z;
        this.d = slideInterceptor;
    }
}
