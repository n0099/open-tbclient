package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class HorizontalScreenLoginActivity extends LoginActivity {
    public static int I;

    /* loaded from: classes3.dex */
    public static class AndroidBug5497Workaround {
        public final int a;
        public View b;
        public WebView c;
        public int d;
        public FrameLayout.LayoutParams e;

        public AndroidBug5497Workaround(Activity activity) {
            View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
            this.b = childAt;
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AndroidBug5497Workaround.this.b();
                }
            });
            this.e = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            this.c = a((ViewGroup) this.b);
            this.a = activity.getWindowManager().getDefaultDisplay().getWidth();
        }

        private int a() {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            return rect.bottom - rect.top;
        }

        private WebView a(ViewGroup viewGroup) {
            WebView a;
            if (viewGroup == null) {
                return null;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof WebView) {
                    return (WebView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                    return a;
                }
            }
            return null;
        }

        public static void assistActivity(Activity activity) {
            new AndroidBug5497Workaround(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int a = a();
            if (a != this.d) {
                int i = this.a;
                int i2 = i - a;
                int i3 = i / 4;
                if (i2 > i3) {
                    this.e.height = i - i2;
                } else {
                    this.e.height = i;
                }
                this.b.requestLayout();
                if (i2 > i3) {
                    if (this.c.getUrl() != null && (this.c.getUrl().endsWith("/sms_login_new") || this.c.getUrl().contains("sms_login") || this.c.getUrl().contains("act=bind_mobile"))) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AndroidBug5497Workaround.this.c.scrollTo(0, HorizontalScreenLoginActivity.I);
                                } catch (Exception unused) {
                                }
                            }
                        }, 200L);
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AndroidBug5497Workaround.this.c.scrollTo(0, 0);
                            } catch (Exception unused) {
                            }
                        }
                    }, 200L);
                }
                this.d = a;
            }
        }
    }

    @Override // com.baidu.sapi2.activity.LoginActivity
    public void lockScreenOrientation() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28 && i > 25) {
            return;
        }
        setRequestedOrientation(0);
    }

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ViewUtility.setOrientationToUndefined(this);
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_horizontal_screen_webview_with_title_bar);
            AndroidBug5497Workaround.assistActivity(this);
            init();
            setupViews();
            ((LoginActivity) this).sapiWebView.setVerticalScrollBarEnabled(false);
            ((LoginActivity) this).sapiWebView.setVerticalFadingEdgeEnabled(false);
            ((LoginActivity) this).sapiWebView.setFocusEdittextCoordinateYCallBack(new SapiJsCallBacks.FocusEdittextCoordinateYCallBack() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FocusEdittextCoordinateYCallBack
                public void onCallback(int i) {
                    int unused = HorizontalScreenLoginActivity.I = (int) (i * HorizontalScreenLoginActivity.this.getResources().getDisplayMetrics().density);
                }
            });
            ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
            SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
            if (sapiWebView instanceof RoundWebview) {
                RoundWebview roundWebview = (RoundWebview) sapiWebView;
                roundWebview.a(getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius));
                roundWebview.setLayerType(1, null);
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
            loginFail(this.webAuthResult);
        }
    }
}
