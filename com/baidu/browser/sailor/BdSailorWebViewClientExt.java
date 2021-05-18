package com.baidu.browser.sailor;

import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebViewClient;
/* loaded from: classes.dex */
public class BdSailorWebViewClientExt implements INoProGuard {
    public static final BdSailorWebViewClientExt DEFAULT = new BdSailorWebViewClientExt();

    /* loaded from: classes.dex */
    public enum ENativeViewType {
        ERROR_PAGE_VEIEW,
        SAFE_PAGE_VIEW
    }

    /* loaded from: classes.dex */
    public static class FirstScreenImageInfo implements INoProGuard {
        public boolean bHaveImageInScreen;
        public int nErrorOccurredCount;
        public int nImageCount;
        public long nMaxTimeStamp;
        public int nPaintHeightForMaxImage;
        public int nPaintWidthForMaxImage;
        public int nPosXForMaxImage;
        public int nPosYForMaxImage;
        public long nTimeStampForMaxImage;
        public String url;

        public int getErrorOccurredCount() {
            return this.nErrorOccurredCount;
        }

        public boolean getHaveImageInScreen() {
            return this.bHaveImageInScreen;
        }

        public int getImageCount() {
            return this.nImageCount;
        }

        public long getMaxTimeStamp() {
            return this.nMaxTimeStamp;
        }

        public int getPaintHeightForMaxImage() {
            return this.nPaintHeightForMaxImage;
        }

        public int getPaintWidthForMaxImage() {
            return this.nPaintWidthForMaxImage;
        }

        public int getPosXForMaxImage() {
            return this.nPosXForMaxImage;
        }

        public int getPosYForMaxImage() {
            return this.nPosYForMaxImage;
        }

        public long getTimeStampForMaxImage() {
            return this.nTimeStampForMaxImage;
        }

        public String getUrl() {
            return this.url;
        }

        public void setErrorOccurredCount(int i2) {
            this.nErrorOccurredCount = i2;
        }

        public void setHaveImageInScreen(boolean z) {
            this.bHaveImageInScreen = z;
        }

        public void setImageCount(int i2) {
            this.nImageCount = i2;
        }

        public void setMaxTimeStamp(long j) {
            this.nMaxTimeStamp = j;
        }

        public void setPaintHeightForMaxImage(int i2) {
            this.nPaintHeightForMaxImage = i2;
        }

        public void setPaintWidthForMaxImage(int i2) {
            this.nPaintWidthForMaxImage = i2;
        }

        public void setPosXForMaxImage(int i2) {
            this.nPosXForMaxImage = i2;
        }

        public void setPosYForMaxImage(int i2) {
            this.nPosYForMaxImage = i2;
        }

        public void setTimeStampForMaxImage(long j) {
            this.nTimeStampForMaxImage = j;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes.dex */
    public static class FirstScreenInfo implements INoProGuard {
        public int diffDomcompleteAndFspTime;

        public int getDiffDomcompleteAndFspTime() {
            return this.diffDomcompleteAndFspTime;
        }

        public void setDiffDomcompleteAndFspTime(int i2) {
            this.diffDomcompleteAndFspTime = i2;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSailorWebView f4281e;

        public a(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
            this.f4281e = bdSailorWebView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4281e.showEmbeddedTitleBar(false);
        }
    }

    public void antiHijackSignExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public int computeHookH5NavigationStep(int i2) {
        return i2;
    }

    public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
    }

    public void onAbortResourceRequest(BdSailorWebView bdSailorWebView, String str, String str2, long j) {
    }

    public String onBrowserPageEventExt(BdSailorWebView bdSailorWebView, int i2, String str) {
        return "";
    }

    public void onCheckHasManifestAndServiceWorker(BdSailorWebView bdSailorWebView, String str, String str2, boolean z) {
    }

    public void onDidAsyncWiseSearchStatusChangedExt(BdSailorWebView bdSailorWebView, String str, int i2, long j) {
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

    public void onFirstScreenImagePaint(BdSailorWebView bdSailorWebView, FirstScreenImageInfo firstScreenImageInfo) {
    }

    @Deprecated
    public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str, FirstScreenInfo firstScreenInfo) {
    }

    public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
    }

    public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
    }

    public void onGestureFlingEnded(BdSailorWebView bdSailorWebView, int i2, int i3) {
    }

    public void onGestureScrollEnded(BdSailorWebView bdSailorWebView, int i2, int i3) {
    }

    public void onGestureScrollStarted(BdSailorWebView bdSailorWebView, int i2, int i3) {
    }

    public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
        return null;
    }

    public Class<? extends View> onGetNativeViewClass(BdSailorWebView bdSailorWebView, ENativeViewType eNativeViewType) {
        return null;
    }

    public void onGoBackOrForwardAnimationFinish(BdSailorWebView bdSailorWebView, int i2) {
    }

    public void onGoBackOrForwardAnimationStart(BdSailorWebView bdSailorWebView, int i2) {
        if (bdSailorWebView == null || !bdSailorWebView.isAutoShowTitlebar()) {
            return;
        }
        bdSailorWebView.post(new a(this, bdSailorWebView));
    }

    public void onGoPreloadForwardExt(BdSailorWebView bdSailorWebView) {
    }

    public void onGotNotResponse(BdSailorWebView bdSailorWebView) {
    }

    public void onHandleBackForwardBeyondHistory(int i2) {
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

    public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
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

    public void onShowHotWordExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
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

    public void onSubjectsCollectedExt(BdSailorWebView bdSailorWebView, boolean z, int i2) {
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
