package com.baidu.searchbox.ugc.lightbrowser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes11.dex */
public class LightBrowserView extends FrameLayout {
    public static final int NORMAL_LOADING = 1;
    public static final int SHIMMER_LOADING = 2;
    private boolean isFirstPage;
    private Context mContext;
    private LightBrowserWebView mExploreView;

    public LightBrowserView(Context context) {
        super(context);
        this.isFirstPage = false;
        init(context, 1);
    }

    public LightBrowserView(Context context, int i) {
        super(context);
        this.isFirstPage = false;
        this.mContext = context;
        init(context, i);
    }

    public void init(Context context, int i) {
        initView(i);
    }

    @SuppressLint({"JavascriptInterface"})
    private void initView(int i) {
        this.mExploreView = new LightBrowserWebView(getContext());
        this.mExploreView.addJavascriptInterface(getHtmlAndroidUtils(), SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.mExploreView.addJavascriptInterface(getHtmlAndroidNet(), "Bdbox_android_net");
        this.mExploreView.addJavascriptInterface(getHtmlSearchboxInterface(), "bd_searchbox_interface");
        addView(this.mExploreView, new FrameLayout.LayoutParams(-1, -1));
    }

    private Object getHtmlAndroidUtils() {
        return new Object() { // from class: com.baidu.searchbox.ugc.lightbrowser.LightBrowserView.1
            public String toString() {
                return super.toString();
            }

            @JavascriptInterface
            public String getcuid() {
                return "Html call getcuid";
            }

            @JavascriptInterface
            public String hideLoadingView() {
                return "Html call hideLoadingView ";
            }
        };
    }

    private Object getHtmlAndroidNet() {
        return new Object() { // from class: com.baidu.searchbox.ugc.lightbrowser.LightBrowserView.2
            @JavascriptInterface
            public String hideLoadingView(String str) {
                return "Html call hideLoadingView ";
            }

            public String toString() {
                return super.toString();
            }
        };
    }

    private Object getHtmlSearchboxInterface() {
        return new Object() { // from class: com.baidu.searchbox.ugc.lightbrowser.LightBrowserView.3
            @JavascriptInterface
            public String progressCompleted() {
                return "Html call hideLoadingView ";
            }

            public String toString() {
                return super.toString();
            }
        };
    }

    public LightBrowserWebView getWebView() {
        return this.mExploreView;
    }

    public void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.isFirstPage = true;
            this.mExploreView.loadUrl(str);
        }
    }
}
