package com.baidu.browser.webpool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.baidu.browser.webkit.BdWebJsEngine;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webpool.BdWebPoolView;
/* loaded from: classes.dex */
public class BdWebPoolCustomView extends BdWebView {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdWebPoolCustomView";
    private String mClickLink;
    private int mHistoryCount;
    private BdWebJsEngine mJsEngine;
    private int mLastIndex;
    private LoadMode mLoadMode;
    private BdWebPoolView mWebPoolView;

    /* loaded from: classes.dex */
    public enum LoadMode {
        LOAD_NORMAL,
        LOAD_BACKORFORWARD,
        LOAD_RELOAD,
        LOAD_BACKORFORWARD_BY_NEW_WEBVIEW,
        LOAD_REPLACE;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static LoadMode[] valuesCustom() {
            LoadMode[] valuesCustom = values();
            int length = valuesCustom.length;
            LoadMode[] loadModeArr = new LoadMode[length];
            System.arraycopy(valuesCustom, 0, loadModeArr, 0, length);
            return loadModeArr;
        }
    }

    public BdWebPoolCustomView(Context context, boolean z) {
        super(context, z);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
    }

    public BdWebPoolCustomView(Context context) {
        super(context);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
    }

    public BdWebPoolCustomView(BdWebPoolView bdWebPoolView, Context context) {
        super(context);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
        this.mWebPoolView = bdWebPoolView;
    }

    public BdWebPoolCustomView(BdWebPoolView bdWebPoolView, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, false);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
        this.mWebPoolView = bdWebPoolView;
    }

    public BdWebPoolCustomView(BdWebPoolView bdWebPoolView, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, false);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
        this.mWebPoolView = bdWebPoolView;
    }

    public BdWebPoolCustomView(BdWebPoolView bdWebPoolView, WebView webView) {
        super(webView);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
        this.mWebPoolView = bdWebPoolView;
    }

    public BdWebPoolCustomView(BdWebPoolView bdWebPoolView, com.baidu.zeus.WebView webView) {
        super(webView);
        this.mLoadMode = LoadMode.LOAD_NORMAL;
        this.mWebPoolView = bdWebPoolView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWebPoolView(BdWebPoolView bdWebPoolView) {
        this.mWebPoolView = bdWebPoolView;
    }

    protected BdWebPoolView getWebPoolView() {
        return this.mWebPoolView;
    }

    @Override // com.baidu.browser.webkit.BdWebView
    public boolean drawChild(Canvas canvas, View view, long j) {
        return this.mWebPoolView.drawChild(canvas, view, j);
    }

    @Override // com.baidu.browser.webkit.BdWebView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWebPoolView.onTouchEvent(motionEvent);
    }

    public void setHistoryCount(int i) {
        this.mHistoryCount = i;
    }

    public int getHistoryCount() {
        return this.mHistoryCount;
    }

    public void setLastIndex(int i) {
        this.mLastIndex = i;
    }

    public int getLastIndex() {
        return this.mLastIndex;
    }

    public void setClickLink(String str) {
        this.mClickLink = str;
    }

    public String getClickLink() {
        return this.mClickLink;
    }

    public void setLoadMode(LoadMode loadMode) {
        this.mLoadMode = loadMode;
    }

    public LoadMode getLoadMode() {
        return this.mLoadMode;
    }

    public void setWebJsClient(BdWebPoolView.BdWebPoolCustomJsClient bdWebPoolCustomJsClient) {
        if (this.mJsEngine == null) {
            this.mJsEngine = new BdWebJsEngine(this);
        }
        this.mJsEngine.setWebJsClient(bdWebPoolCustomJsClient);
    }

    public void runJavaScript(String str) {
        if (this.mJsEngine != null) {
            this.mJsEngine.runJavaScript(str);
        }
    }

    public void runWebJsClientJavaScript() {
        if (this.mJsEngine != null) {
            this.mJsEngine.runWebJsClientJavaScript();
        }
    }
}
