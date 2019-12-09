package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes2.dex */
public class SlideActiviy extends BaseActivity {
    public static final String ADDRESS_PAGE_NAME = "address";
    public static final String INVOICE_PAGE_NAME = "invoice";
    private static final boolean r = true;
    private static final String s = "SlideActivity";
    public SlideHelper aKm;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private SlideInterceptor w;
    private SlidingPaneLayout.PanelSlideListener x;
    private WeakReference<Activity> y;

    private void e() {
        if (this.t) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.u && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(s, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            final int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
            this.aKm = new SlideHelper();
            this.aKm.attachSlideActivity(this);
            this.aKm.setCanSlide(z);
            this.aKm.forceActivityTransparent(this.v);
            this.aKm.setSlideInterceptor(this.w);
            this.aKm.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.3
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
                    SlideActiviy.this.aKm.setShadowDrawable(null);
                    SlideActiviy.this.finishActivityAfterSlideOver();
                    SlideActiviy.this.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = SlideActiviy.this.aKm.getMaskView();
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
        Log.d(s, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.aKm;
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
        Log.d(s, "onDetachedFromWindow: ");
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(s, "onPostCreate");
        e();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        Log.d(s, "onPostResume: ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(s, "onResume: ");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Log.d(s, "onStart: ");
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.sapi2.activity.SlideActiviy.2
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
                }
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
            if (this.y == null || this.y.get() == null) {
                this.y = new WeakReference<>(b.b().c());
            }
            if (this.y.get() != null) {
                Activity d = b.b().d();
                Activity activity = this.y.get();
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
