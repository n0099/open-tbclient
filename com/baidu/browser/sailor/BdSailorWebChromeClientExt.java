package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public class BdSailorWebChromeClientExt implements INoProGuard {
    public static final BdSailorWebChromeClientExt DEFAULT = new BdSailorWebChromeClientExt();

    @Deprecated
    public void copyTextExt(BdSailorWebView bdSailorWebView, String str) {
    }

    @Deprecated
    public void doTextSearchExt(BdSailorWebView bdSailorWebView, String str) {
    }

    @Deprecated
    public void doTextTranslateExt(BdSailorWebView bdSailorWebView, String str) {
    }

    @Deprecated
    public void hideMagnifierExt(BdSailorWebView bdSailorWebView, int i, int i2) {
    }

    public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
    }

    @Deprecated
    public void moveMagnifierExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public boolean needNotifyNativeExitFullScreenExt(BdSailorWebView bdSailorWebView) {
        return false;
    }

    @Deprecated
    public void notifyClickWhenLoadExt(BdSailorWebView bdSailorWebView) {
    }

    @Deprecated
    public void notifyClientStatusExt(BdSailorWebView bdSailorWebView, int i) {
    }

    @Deprecated
    public void onFeaturePermissionsHidePromptExt(BdSailorWebView bdSailorWebView) {
    }

    public boolean onFlyflowJsiConsole(BdSailorWebView bdSailorWebView, String str, String str2) {
        return false;
    }

    public boolean onFlyflowJsiPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public void onNativeElementEnterFullScreenExt(BdSailorWebView bdSailorWebView) {
    }

    public void onNativeElementExitFullScreenExt(BdSailorWebView bdSailorWebView) {
    }

    public void onNextPagePreloadFinishedExt() {
    }

    public void onPrerenderChanged(int i, WebView.PrerenderStatus prerenderStatus) {
    }

    public void onReceivedFocusNodeHrefExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
    }

    @Deprecated
    public void onSetLoadURLExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onSetWallPaperExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onShowCommentPanel(BdSailorWebView bdSailorWebView, String str, String str2) {
    }

    public void onShowValidateComponent(BdSailorWebView bdSailorWebView, String str, String str2) {
    }

    @Deprecated
    public void performLongClickExt(BdSailorWebView bdSailorWebView, int i, String str, String str2, int i2, int i3) {
    }

    public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
    }

    @Deprecated
    public void showMagnifierExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4) {
    }

    public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
    }
}
