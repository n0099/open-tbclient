package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.d.j;
/* loaded from: classes3.dex */
public class FullScreenView extends LinearLayout {
    private static final String TAG = "FullScreenView";
    public static cn.jpush.android.e.a.f webViewHelper = null;
    private View.OnClickListener btnBackClickListener;
    private ImageButton imgBtnBack;
    private final Context mContext;
    private WebView mWebView;
    private ProgressBar pushPrograssBar;
    private RelativeLayout rlTitleBar;
    private TextView tvTitle;

    public FullScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btnBackClickListener = new a(this);
        this.mContext = context;
    }

    private void quitFullScreen() {
        try {
            WindowManager.LayoutParams attributes = ((Activity) this.mContext).getWindow().getAttributes();
            attributes.flags &= -1025;
            ((Activity) this.mContext).getWindow().setAttributes(attributes);
            ((Activity) this.mContext).getWindow().clearFlags(512);
        } catch (Exception e) {
        }
    }

    private void reflectAddJsInterface() {
        try {
            j.a(this.mWebView, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{webViewHelper, "JPushWeb"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destory() {
        removeAllViews();
        if (this.mWebView != null) {
            this.mWebView.removeAllViews();
            this.mWebView.clearSslPreferences();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public void initModule(Context context, cn.jpush.android.data.b bVar) {
        cn.jpush.android.data.g gVar = (cn.jpush.android.data.g) bVar;
        String str = gVar.J;
        setFocusable(true);
        this.mWebView = (WebView) findViewById(getResources().getIdentifier("fullWebView", "id", context.getPackageName()));
        this.rlTitleBar = (RelativeLayout) findViewById(getResources().getIdentifier("rlRichpushTitleBar", "id", context.getPackageName()));
        this.tvTitle = (TextView) findViewById(getResources().getIdentifier("tvRichpushTitle", "id", context.getPackageName()));
        this.imgBtnBack = (ImageButton) findViewById(getResources().getIdentifier("imgRichpushBtnBack", "id", context.getPackageName()));
        this.pushPrograssBar = (ProgressBar) findViewById(getResources().getIdentifier("pushPrograssBar", "id", context.getPackageName()));
        if (this.mWebView == null || this.rlTitleBar == null || this.tvTitle == null || this.imgBtnBack == null) {
            cn.jpush.android.d.f.d(TAG, "Please use default code in jpush_webview_layout.xml!");
            ((Activity) this.mContext).finish();
        }
        if (1 == gVar.L) {
            this.rlTitleBar.setVisibility(8);
            ((Activity) context).getWindow().setFlags(1024, 1024);
        } else {
            this.tvTitle.setText(str);
            this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
        }
        this.mWebView.setScrollbarFadingEnabled(true);
        this.mWebView.setScrollBarStyle(33554432);
        WebSettings settings = this.mWebView.getSettings();
        cn.jpush.android.d.a.a(settings);
        cn.jpush.android.d.a.a(this.mWebView);
        settings.setSavePassword(false);
        webViewHelper = new cn.jpush.android.e.a.f(context, bVar);
        if (Build.VERSION.SDK_INT >= 17) {
            cn.jpush.android.d.f.a(TAG, "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            reflectAddJsInterface();
        }
        this.mWebView.setWebChromeClient(new cn.jpush.android.e.a.a("JPushWeb", cn.jpush.android.e.a.b.class, this.pushPrograssBar, this.tvTitle));
        this.mWebView.setWebViewClient(new c(bVar, context));
        cn.jpush.android.e.a.b.setWebViewHelper(webViewHelper);
    }

    public void loadUrl(String str) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(str);
        }
    }

    public void pause() {
        if (this.mWebView == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mWebView.onPause();
    }

    public void resume() {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.onResume();
            }
            cn.jpush.android.e.a.b.setWebViewHelper(webViewHelper);
        }
    }

    public void showTitleBar() {
        if (this.rlTitleBar == null || this.rlTitleBar.getVisibility() != 8) {
            return;
        }
        this.rlTitleBar.setVisibility(0);
        quitFullScreen();
        this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
        if (this.mWebView != null) {
            this.mWebView.postDelayed(new b(this), 1000L);
        }
    }

    public boolean webviewCanGoBack() {
        if (this.mWebView != null) {
            return this.mWebView.canGoBack();
        }
        return false;
    }

    public void webviewGoBack() {
        if (this.mWebView != null) {
            this.mWebView.goBack();
        }
    }
}
