package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class SlideActiviy extends BaseActivity {
    public static final String A = "SlideActivity";
    public static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    public static final String ADDRESS_PAGE_NAME = "address";
    public static final boolean B = true;
    public static final String EXTRAS_ACTION = "action";
    public static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    public static final String INVOICE_PAGE_NAME = "invoice";
    public static final String SLIDE_ACTION_QUIT = "quit";
    public SlideHelper mSlideHelper;
    public SlideInterceptor w;
    public SlidingPaneLayout.PanelSlideListener x;
    public WeakReference<Activity> z;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean y = true;

    /* loaded from: classes2.dex */
    public class PassSlideInterceptor implements SlideInterceptor {
        public PassSlideInterceptor() {
        }

        @Override // com.baidu.searchbox.widget.SlideInterceptor
        public boolean isSlidable(MotionEvent motionEvent) {
            return SlideActiviy.this.y;
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void forceActivityTransparent(boolean z) {
        this.v = z;
    }

    public void loadSlideWebview(String str, String str2, String str3) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(A, "onConfigurationChanged: ");
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.setCanSlide(configuration.orientation != 2);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ViewUtility.setOrientationToUndefined(this);
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
        Log.d(A, "onDetachedFromWindow: ");
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(A, "onPostCreate");
        a();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        Log.d(A, "onPostResume: ");
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(A, "onResume: ");
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Log.d(A, "onStart: ");
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
                    Log.d(SlideActiviy.A, "Slide should be opened now");
                    SlideActiviy.this.y = false;
                } else {
                    Log.d(SlideActiviy.A, "Slide should be closed now");
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

    private void a() {
        if (this.t) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.u && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                Log.e(A, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            final int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
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
                public void onPanelSlide(View view, float f2) {
                    View maskView = SlideActiviy.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f3 = 1.0f - f2;
                        if (f3 < 0.0f) {
                            f3 = 0.0f;
                        }
                        maskView.setAlpha(f3);
                    }
                    if (SlideActiviy.this.x != null) {
                        SlideActiviy.this.x.onPanelSlide(view, f2);
                    }
                    float f4 = i2 >> 2;
                    SlideActiviy.this.a((f2 * f4) - f4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        try {
            if (this.z == null || this.z.get() == null) {
                this.z = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
            }
            if (this.z.get() != null) {
                Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                Activity activity = this.z.get();
                if (realTopActivity != null && activity != null && realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
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
        ViewGroup viewGroup;
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) == null) {
            return;
        }
        viewGroup.setX(f2);
    }
}
