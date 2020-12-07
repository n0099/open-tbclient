package com.baidu.browser.sailor;

import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebViewClient;
/* loaded from: classes12.dex */
public class BdSailorWebViewClientExt implements INoProGuard {
    public static final BdSailorWebViewClientExt DEFAULT = new BdSailorWebViewClientExt();

    /* loaded from: classes12.dex */
    public enum ENativeViewType {
        ERROR_PAGE_VEIEW,
        SAFE_PAGE_VIEW
    }

    public void antiHijackSignExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public int computeHookH5NavigationStep(int i) {
        return i;
    }

    public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
    }

    public void onAbortResourceRequest(BdSailorWebView bdSailorWebView, String str, String str2, long j) {
    }

    public String onBrowserPageEventExt(BdSailorWebView bdSailorWebView, int i, String str) {
        return "";
    }

    public void onCheckHasManifestAndServiceWorker(BdSailorWebView bdSailorWebView, String str, String str2, boolean z) {
    }

    public void onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView bdSailorWebView, String str, int i, long j) {
    }

    public void onDisplaySoftKeyboardExt(BdSailorWebView bdSailorWebView) {
    }

    public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
    }

    public void onGestureFlingEnded(BdSailorWebView bdSailorWebView, int i, int i2) {
    }

    public void onGestureScrollEnded(BdSailorWebView bdSailorWebView, int i, int i2) {
    }

    public void onGestureScrollStarted(BdSailorWebView bdSailorWebView, int i, int i2) {
    }

    public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
        return null;
    }

    public Class<? extends View> onGetNativeViewClass(BdSailorWebView bdSailorWebView, ENativeViewType eNativeViewType) {
        return null;
    }

    public void onGoBackOrForwardAnimationFinish(BdSailorWebView bdSailorWebView, int i) {
    }

    public void onGoBackOrForwardAnimationStart(BdSailorWebView bdSailorWebView, int i) {
        if (bdSailorWebView == null || !bdSailorWebView.isAutoShowTitlebar()) {
            return;
        }
        bdSailorWebView.post(new b(this, bdSailorWebView));
    }

    public void onGoPreloadForwardExt(BdSailorWebView bdSailorWebView) {
    }

    public void onGotNotResponse(BdSailorWebView bdSailorWebView) {
    }

    public void onHandleBackForwardBeyondHistory(int i) {
    }

    public void onHasVideoExt(BdSailorWebView bdSailorWebView) {
    }

    public boolean onHideReaderViewExt(BdSailorWebView bdSailorWebView, View view) {
        return false;
    }

    public void onHideSoftKeyboardExt(BdSailorWebView bdSailorWebView) {
    }

    public boolean onHideSubjectExt(BdSailorWebView bdSailorWebView, View view) {
        return false;
    }

    public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
        return false;
    }

    public void onNativeViewDayNightChanged(BdSailorWebView bdSailorWebView, View view, ENativeViewType eNativeViewType) {
    }

    @Deprecated
    public void onNavigationAnimationFinish(BdSailorWebView bdSailorWebView) {
    }

    public void onNavigationAnimationFinish(BdSailorWebView bdSailorWebView, boolean z, boolean z2) {
    }

    @Deprecated
    public void onNavigationAnimationStart(BdSailorWebView bdSailorWebView) {
    }

    public void onNavigationAnimationStart(BdSailorWebView bdSailorWebView, boolean z) {
    }

    public void onNewPage(BdSailorWebView bdSailorWebView) {
    }

    public void onNextPagePreloadFinishedExt() {
    }

    public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
    }

    public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
    }

    @Deprecated
    public void onPageLoadTimeExt(BdSailorWebView bdSailorWebView, String str, long j) {
    }

    public void onPausePluginExt(BdSailorWebView bdSailorWebView) {
    }

    public void onPlayPluginExt(BdSailorWebView bdSailorWebView) {
    }

    public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onProceededAfterSslErrorExt(BdSailorWebView bdSailorWebView, SslError sslError) {
    }

    public String onProcessWebSearchUrl(BdSailorWebView bdSailorWebView, String str) {
        return null;
    }

    public void onReadModeExitExt(BdSailorWebView bdSailorWebView, String str, String str2) {
    }

    public void onReaderDetectedExt(boolean z) {
    }

    public boolean onReceivedSslErrorExt(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
        return false;
    }

    public void onRestoreFromCache(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onRestoreFromPageCacheDid(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onResumePluginExt(BdSailorWebView bdSailorWebView) {
    }

    public void onSearchLandingPageClicked(BdSailorWebView bdSailorWebView, String str, String str2, long j) {
    }

    public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
    }

    public void onShowHotWordExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str, String str2, String str3) {
    }

    public void onShowNativeView(BdSailorWebView bdSailorWebView, View view, ENativeViewType eNativeViewType) {
    }

    public boolean onShowReaderViewExt(BdSailorWebView bdSailorWebView, View view) {
        return false;
    }

    public boolean onShowSubjectExt(BdSailorWebView bdSailorWebView, View view) {
        return false;
    }

    public void onStartFirstNavigation(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3) {
    }

    public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
        return false;
    }

    public void onSubjectsCollectedExt(BdSailorWebView bdSailorWebView, boolean z, int i) {
    }

    public boolean onSupportsForceZoomScale(BdSailorWebView bdSailorWebView) {
        return false;
    }

    @Deprecated
    public boolean onTextCopiedExt(BdSailorWebView bdSailorWebView) {
        return false;
    }

    public void onUpdateTextFieldNextPreStatus(BdSailorWebView bdSailorWebView, boolean z, boolean z2) {
    }

    public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
    }

    public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
        return false;
    }

    @Deprecated
    public boolean shouldKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str) {
        return false;
    }

    @Deprecated
    public boolean shouldOpenFlashExt(BdSailorWebView bdSailorWebView, String str) {
        return false;
    }
}
