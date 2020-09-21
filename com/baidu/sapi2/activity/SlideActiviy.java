package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes25.dex */
public class SlideActiviy extends BaseActivity {
    protected static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    protected static final String ADDRESS_PAGE_NAME = "address";
    protected static final String EXTRAS_ACTION = "action";
    protected static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    protected static final String INVOICE_PAGE_NAME = "invoice";
    protected static final String SLIDE_ACTION_QUIT = "quit";
    private static final String w = "SlideActivity";
    private static final boolean x = true;
    public SlideHelper mSlideHelper;
    private SlideInterceptor s;
    private SlidingPaneLayout.PanelSlideListener t;
    private WeakReference<Activity> v;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean u = true;

    /* loaded from: classes25.dex */
    private class PassSlideInterceptor implements SlideInterceptor {
        private PassSlideInterceptor() {
        }

        @Override // com.baidu.searchbox.widget.SlideInterceptor
        public boolean isSlidable(MotionEvent motionEvent) {
            return SlideActiviy.this.u;
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void forceActivityTransparent(boolean z) {
        this.r = z;
    }

    protected void loadSlideWebview(String str, String str2, String str3) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(w, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.setCanSlide(configuration.orientation != 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            b();
        }
        super.onCreate(bundle);
        if (this.configuration.supportGestureSlide) {
            this.p = true;
        } else {
            this.p = false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(w, "onDetachedFromWindow: ");
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(w, "onPostCreate");
        a();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        Log.d(w, "onPostResume: ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(w, "onResume: ");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Log.d(w, "onStart: ");
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.3
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z) {
        this.p = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.q = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.t = panelSlideListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setLoadSlideWebViewCallback(new SapiWebView.LoadSlideWebViewCallback() { // from class: com.baidu.sapi2.activity.SlideActiviy.1
            @Override // com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback
            public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                SlideActiviy.this.loadSlideWebview(loadSlideWebViewResult.page, loadSlideWebViewResult.url, loadSlideWebViewResult.adapter);
            }
        });
        this.sapiWebView.setStopSlideWebviewCallback(new SapiJsCallBacks.StopSlideWebviewCallback() { // from class: com.baidu.sapi2.activity.SlideActiviy.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback
            public void onStopSlide(boolean z) {
                if (z) {
                    Log.d(SlideActiviy.w, "Slide should be opened now");
                    SlideActiviy.this.u = false;
                } else {
                    Log.d(SlideActiviy.w, "Slide should be closed now");
                    SlideActiviy.this.u = true;
                }
                SlideActiviy slideActiviy = SlideActiviy.this;
                slideActiviy.s = new PassSlideInterceptor();
                SlideActiviy slideActiviy2 = SlideActiviy.this;
                slideActiviy2.mSlideHelper.setSlideInterceptor(slideActiviy2.s);
            }
        });
    }

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

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.p = z;
        this.s = slideInterceptor;
    }

    private void a() {
        if (this.p) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.q && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(w, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            final int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
            this.mSlideHelper = new SlideHelper();
            this.mSlideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.r);
            this.mSlideHelper.setSlideInterceptor(this.s);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.4
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    if (SlideActiviy.this.t != null) {
                        SlideActiviy.this.t.onPanelClosed(view);
                    }
                    SlideActiviy.this.a(0.0f);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    if (SlideActiviy.this.t != null) {
                        SlideActiviy.this.t.onPanelOpened(view);
                    }
                    SlideActiviy.this.a(0.0f);
                    SlideActiviy.this.mSlideHelper.setShadowDrawable(null);
                    SlideActiviy.this.finishActivityAfterSlideOver();
                    SlideActiviy.this.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = SlideActiviy.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f2 = 1.0f - f;
                        maskView.setAlpha(f2 >= 0.0f ? f2 : 0.0f);
                    }
                    if (SlideActiviy.this.t != null) {
                        SlideActiviy.this.t.onPanelSlide(view, f);
                    }
                    float f3 = i >> 2;
                    SlideActiviy.this.a((f * f3) - f3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        try {
            if (this.v == null || this.v.get() == null) {
                this.v = new WeakReference<>(a.e().b());
            }
            if (this.v.get() != null) {
                Activity c = a.e().c();
                Activity activity = this.v.get();
                if (c != null && activity != null && c.getLocalClassName().equals(activity.getLocalClassName())) {
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
        ViewGroup viewGroup;
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) == null) {
            return;
        }
        viewGroup.setX(f);
    }
}
