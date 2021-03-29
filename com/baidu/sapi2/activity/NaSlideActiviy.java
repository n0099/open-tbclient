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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class NaSlideActiviy extends AppCompatActivity {

    /* renamed from: g  reason: collision with root package name */
    public static final String f11017g = "NaSlideActivity";

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11018h = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11019a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11020b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11021c = false;
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();

    /* renamed from: d  reason: collision with root package name */
    public SlideInterceptor f11022d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingPaneLayout.PanelSlideListener f11023e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Activity> f11024f;
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

    public void forceActivityTransparent(boolean z) {
        this.f11021c = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(f11017g, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.setCanSlide(configuration.orientation != 2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            b();
        }
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.supportGestureSlide) {
            this.f11019a = true;
        } else {
            this.f11019a = false;
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(f11017g, "onPostCreate");
        a();
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.sapi2.activity.NaSlideActiviy.1
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z) {
        this.f11019a = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.f11020b = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.f11023e = panelSlideListener;
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.f11019a = z;
        this.f11022d = slideInterceptor;
    }

    private void a() {
        if (this.f11019a) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.f11020b && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                Log.e(f11017g, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            final int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.f11021c);
            this.mSlideHelper.setSlideInterceptor(this.f11022d);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.sapi2.activity.NaSlideActiviy.2
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    if (NaSlideActiviy.this.f11023e != null) {
                        NaSlideActiviy.this.f11023e.onPanelClosed(view);
                    }
                    NaSlideActiviy.this.a(0.0f);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    if (NaSlideActiviy.this.f11023e != null) {
                        NaSlideActiviy.this.f11023e.onPanelOpened(view);
                    }
                    NaSlideActiviy.this.a(0.0f);
                    NaSlideActiviy.this.mSlideHelper.setShadowDrawable(null);
                    NaSlideActiviy.this.finishActivityAfterSlideOver();
                    NaSlideActiviy.this.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f2) {
                    View maskView = NaSlideActiviy.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f3 = 1.0f - f2;
                        if (f3 < 0.0f) {
                            f3 = 0.0f;
                        }
                        maskView.setAlpha(f3);
                    }
                    if (NaSlideActiviy.this.f11023e != null) {
                        NaSlideActiviy.this.f11023e.onPanelSlide(view, f2);
                    }
                    float f4 = i >> 2;
                    NaSlideActiviy.this.a((f2 * f4) - f4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        try {
            if (this.f11024f == null || this.f11024f.get() == null) {
                this.f11024f = new WeakReference<>(a.e().b());
            }
            if (this.f11024f.get() != null) {
                Activity c2 = a.e().c();
                Activity activity = this.f11024f.get();
                if (c2 != null && activity != null && c2.getLocalClassName().equals(activity.getLocalClassName())) {
                    a(activity, 0.0f);
                } else {
                    a(activity, f2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Activity activity, float f2) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        activity.getWindow().getDecorView();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        if (viewGroup != null) {
            viewGroup.setX(f2);
        }
    }
}
