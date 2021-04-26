package com.baidu.mobads.container.landingpage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.landingpage.NativeActionBar;
import com.baidu.mobads.container.util.EuiLeakFixUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.sdk.api.IActivityImpl;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppPriActivity implements IActivityImpl {
    public static final int ACTIONBAR_VIEW_ID = 1010;
    public static final String PRIVACY_LINK = "privacy_link";
    public static final String TAG = "AppPriActivity";
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public LinearLayout mLlContainer;
    public NativeActionBar mNativeActionBar;
    public RelativeLayout mRlContainer;
    public XMyWebView mXMyWebView;
    public Activity proxyActivity;
    public RelativeLayout wvTool;

    /* loaded from: classes2.dex */
    public class CustomProgressBar extends View {
        public Paint mPaint;
        public int mProgress;
        public int mScreenWidth;

        public CustomProgressBar(Context context) {
            super(context);
            this.mProgress = 0;
            this.mScreenWidth = 0;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setColor(Color.parseColor("#483D8B"));
            this.mScreenWidth = ScreenUtils.getScreenRect(AppPriActivity.this.proxyActivity.getApplicationContext()).width();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (this.mScreenWidth * this.mProgress) / 100, getLayoutParams().height, this.mPaint);
        }

        public void setProgress(int i2) {
            if (i2 != this.mProgress) {
                this.mProgress = i2;
                postInvalidate();
            }
        }
    }

    private void addGlobalViews(String str) {
        this.wvTool = new RelativeLayout(this.proxyActivity);
        this.mLlContainer = new LinearLayout(this.proxyActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mLlContainer.setOrientation(1);
        this.wvTool.addView(this.mLlContainer, layoutParams);
        initActionBar();
        this.mLlContainer.addView(this.mNativeActionBar, new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(this.proxyActivity, 46)));
        this.mRlContainer = initFrame(str);
        this.mLlContainer.addView(this.mRlContainer, new RelativeLayout.LayoutParams(-1, -1));
        this.wvTool.setBackgroundColor(-1);
        this.proxyActivity.setContentView(this.wvTool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        this.proxyActivity.finish();
    }

    private void initActionBar() {
        NativeActionBar nativeActionBar = new NativeActionBar(this.proxyActivity);
        this.mNativeActionBar = nativeActionBar;
        nativeActionBar.setId(1010);
        this.mNativeActionBar.setmGButtonClickListener(new NativeActionBar.OnGButtonClickListener() { // from class: com.baidu.mobads.container.landingpage.AppPriActivity.2
            @Override // com.baidu.mobads.container.landingpage.NativeActionBar.OnGButtonClickListener
            public void onGoBackBttonClick() {
                AppPriActivity.this.finishActivity();
            }
        });
    }

    @TargetApi(3)
    private RelativeLayout initFrame(String str) {
        final CustomProgressBar customProgressBar = new CustomProgressBar(this.proxyActivity);
        XMyWebView.ParameterInfo parameterInfo = new XMyWebView.ParameterInfo();
        parameterInfo.mCloseHardwareAccelerated = false;
        XMyWebView create = XMyWebView.create(this.proxyActivity, RemoteXAdLogger.getInstance(), true, true, parameterInfo);
        this.mXMyWebView = create;
        create.curUrl = str;
        create.getSettings().setUseWideViewPort(true);
        this.mXMyWebView.getSettings().setBuiltInZoomControls(true);
        try {
            this.mXMyWebView.loadUrl(str);
        } catch (Exception unused) {
        }
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.mXMyWebView.getSettings(), Boolean.FALSE);
        } catch (Exception e2) {
            this.mAdLogger.d(TAG, e2.getMessage());
        }
        this.mXMyWebView.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.mobads.container.landingpage.AppPriActivity.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                CustomProgressBar customProgressBar2 = customProgressBar;
                if (customProgressBar2 != null) {
                    customProgressBar2.setProgress(i2);
                    if (i2 > 50) {
                        customProgressBar.setVisibility(i2 >= 100 ? 4 : 0);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str2) {
                super.onReceivedTitle(webView, str2);
                if (AppPriActivity.this.mNativeActionBar != null) {
                    AppPriActivity.this.mNativeActionBar.setTitle(str2);
                }
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.proxyActivity);
        relativeLayout.addView(this.mXMyWebView, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(customProgressBar, new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(this.proxyActivity.getApplicationContext(), 2)));
        return relativeLayout;
    }

    private void sendLpBroadcast() {
        if (this.proxyActivity != null) {
            Intent intent = new Intent();
            intent.setAction("lp_close");
            this.proxyActivity.sendBroadcast(intent);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        Intent intent = this.proxyActivity.getIntent();
        if (intent != null) {
            addGlobalViews(intent.getStringExtra(PRIVACY_LINK));
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        try {
            if (this.mXMyWebView != null) {
                this.mXMyWebView.removeAllViews();
                ((ViewGroup) this.mXMyWebView.getParent()).removeView(this.mXMyWebView);
                this.mXMyWebView.stopLoading();
                this.mXMyWebView.destroy();
                this.mXMyWebView = null;
            }
        } catch (Exception e2) {
            this.mAdLogger.d(TAG, e2.getMessage());
        }
        sendLpBroadcast();
        try {
            EuiLeakFixUtils.fixLeakCanaryOnEui(this.proxyActivity.getApplicationContext());
        } catch (Throwable th) {
            this.mAdLogger.d(TAG, th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.proxyActivity = activity;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
    }
}
