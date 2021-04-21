package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Rect;
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
import d.b.y.a.c;
import d.b.y.a.f;
/* loaded from: classes2.dex */
public class HorizontalScreenLoginActivity extends LoginActivity {
    public static int D;

    /* loaded from: classes2.dex */
    public static class AndroidBug5497Workaround {

        /* renamed from: a  reason: collision with root package name */
        public final int f10564a;

        /* renamed from: b  reason: collision with root package name */
        public View f10565b;

        /* renamed from: c  reason: collision with root package name */
        public WebView f10566c;

        /* renamed from: d  reason: collision with root package name */
        public int f10567d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout.LayoutParams f10568e;

        public AndroidBug5497Workaround(Activity activity) {
            View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
            this.f10565b = childAt;
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AndroidBug5497Workaround.this.b();
                }
            });
            this.f10568e = (FrameLayout.LayoutParams) this.f10565b.getLayoutParams();
            this.f10566c = a((ViewGroup) this.f10565b);
            this.f10564a = activity.getWindowManager().getDefaultDisplay().getWidth();
        }

        public static void assistActivity(Activity activity) {
            new AndroidBug5497Workaround(activity);
        }

        private WebView a(ViewGroup viewGroup) {
            WebView a2;
            if (viewGroup == null) {
                return null;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof WebView) {
                    return (WebView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                    return a2;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int a2 = a();
            if (a2 != this.f10567d) {
                int i = this.f10564a;
                int i2 = i - a2;
                int i3 = i / 4;
                if (i2 > i3) {
                    this.f10568e.height = i - i2;
                } else {
                    this.f10568e.height = i;
                }
                this.f10565b.requestLayout();
                if (i2 > i3) {
                    if (this.f10566c.getUrl() != null && (this.f10566c.getUrl().endsWith("/sms_login_new") || this.f10566c.getUrl().contains("sms_login") || this.f10566c.getUrl().contains("act=bind_mobile"))) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AndroidBug5497Workaround.this.f10566c.scrollTo(0, HorizontalScreenLoginActivity.D);
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
                                AndroidBug5497Workaround.this.f10566c.scrollTo(0, 0);
                            } catch (Exception unused) {
                            }
                        }
                    }, 200L);
                }
                this.f10567d = a2;
            }
        }

        private int a() {
            Rect rect = new Rect();
            this.f10565b.getWindowVisibleDisplayFrame(rect);
            return rect.bottom - rect.top;
        }
    }

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ViewUtility.setOrientationToUndefined(this);
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_horizontal_screen_webview_with_title_bar);
            AndroidBug5497Workaround.assistActivity(this);
            init();
            setupViews();
            ((LoginActivity) this).sapiWebView.setVerticalScrollBarEnabled(false);
            ((LoginActivity) this).sapiWebView.setVerticalFadingEdgeEnabled(false);
            ((LoginActivity) this).sapiWebView.setFocusEdittextCoordinateYCallBack(new SapiJsCallBacks.FocusEdittextCoordinateYCallBack() { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.1
                @Override // com.baidu.sapi2.SapiJsCallBacks.FocusEdittextCoordinateYCallBack
                public void onCallback(int i) {
                    int unused = HorizontalScreenLoginActivity.D = (int) (i * HorizontalScreenLoginActivity.this.getResources().getDisplayMetrics().density);
                }
            });
            ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
            SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
            if (sapiWebView instanceof RoundWebview) {
                RoundWebview roundWebview = (RoundWebview) sapiWebView;
                roundWebview.a(getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius));
                roundWebview.setLayerType(1, null);
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
            loginFail(this.webAuthResult);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
