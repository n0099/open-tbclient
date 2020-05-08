package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.b;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class SlideActiviy extends BaseActivity {
    protected static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    protected static final String ADDRESS_PAGE_NAME = "address";
    protected static final String EXTRAS_ACTION = "action";
    protected static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    protected static final String INVOICE_PAGE_NAME = "invoice";
    protected static final String SLIDE_ACTION_QUIT = "quit";
    private static final String r = "SlideActivity";
    private static final boolean s = true;
    public SlideHelper mSlideHelper;
    private SlideInterceptor w;
    private SlidingPaneLayout.PanelSlideListener x;
    private WeakReference<Activity> z;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean y = true;

    /* loaded from: classes6.dex */
    private class PassSlideInterceptor implements SlideInterceptor {
        private PassSlideInterceptor() {
        }

        @Override // com.baidu.searchbox.widget.SlideInterceptor
        public boolean isSlidable(MotionEvent motionEvent) {
            return SlideActiviy.this.y;
        }
    }

    private void e() {
        if (this.t) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.u && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(r, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            final int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
            this.mSlideHelper = new SlideHelper();
            this.mSlideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.v);
            this.mSlideHelper.setSlideInterceptor(this.w);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.4
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    if (SlideActiviy.this.x != null) {
                        SlideActiviy.this.x.onPanelClosed(view);
                    }
                    SlideActiviy.this.a(0.0f);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    if (SlideActiviy.this.x != null) {
                        SlideActiviy.this.x.onPanelOpened(view);
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
                    if (SlideActiviy.this.x != null) {
                        SlideActiviy.this.x.onPanelSlide(view, f);
                    }
                    float f3 = i >> 2;
                    SlideActiviy.this.a((f * f3) - f3);
                }
            });
        }
    }

    private void f() {
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
        this.v = z;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(r, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.setCanSlide(configuration.orientation != 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            f();
        }
        super.onCreate(bundle);
        if (this.configuration.supportGestureSlide) {
            this.t = true;
        } else {
            this.t = false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(r, "onDetachedFromWindow: ");
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(r, "onPostCreate");
        e();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        Log.d(r, "onPostResume: ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(r, "onResume: ");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Log.d(r, "onStart: ");
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.3
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z) {
        this.t = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.u = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.x = panelSlideListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setLoadSlideWebViewCallback(new SapiWebView.LoadSlideWebViewCallback() { // from class: com.baidu.sapi2.activity.SlideActiviy.1
            @Override // com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback
            public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                String str = loadSlideWebViewResult.page;
                String str2 = loadSlideWebViewResult.placeholderTitle;
                String str3 = loadSlideWebViewResult.url;
                if (SlideActiviy.ADDRESS_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str3)) {
                    Intent intent = new Intent(SlideActiviy.this, AddressManageExternalActivity.class);
                    intent.putExtra("extra_external_url", str3);
                    SlideActiviy.this.startActivity(intent);
                } else if (SlideActiviy.INVOICE_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str3)) {
                    Intent intent2 = new Intent(SlideActiviy.this, InvoiceBuildExternalActivity.class);
                    intent2.putExtra("extra_external_url", str3);
                    SlideActiviy.this.startActivity(intent2);
                } else if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str3)) {
                    Intent intent3 = new Intent(SlideActiviy.this, AccountCenterExternalActivity.class);
                    intent3.putExtra("extra_external_url", str3);
                    SlideActiviy.this.startActivity(intent3);
                }
            }
        });
        this.sapiWebView.setStopSlideWebviewCallback(new SapiJsCallBacks.StopSlideWebviewCallback() { // from class: com.baidu.sapi2.activity.SlideActiviy.2
            @Override // com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback
            public void onStopSlide(boolean z) {
                if (z) {
                    Log.d(SlideActiviy.r, "Slide should be opened now");
                    SlideActiviy.this.y = false;
                } else {
                    Log.d(SlideActiviy.r, "Slide should be closed now");
                    SlideActiviy.this.y = true;
                }
                SlideActiviy slideActiviy = SlideActiviy.this;
                slideActiviy.w = new PassSlideInterceptor();
                SlideActiviy slideActiviy2 = SlideActiviy.this;
                slideActiviy2.mSlideHelper.setSlideInterceptor(slideActiviy2.w);
            }
        });
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.t = z;
        this.w = slideInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        try {
            if (this.z == null || this.z.get() == null) {
                this.z = new WeakReference<>(b.b().c());
            }
            if (this.z.get() != null) {
                Activity d = b.b().d();
                Activity activity = this.z.get();
                if (d != null && activity != null && d.getLocalClassName().equals(activity.getLocalClassName())) {
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
