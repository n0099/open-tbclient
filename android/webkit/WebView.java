package android.webkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsoluteLayout;
import android.widget.ZoomButtonsController;
import com.baidu.browser.core.BdNoProGuard;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class WebView extends AbsoluteLayout implements ViewGroup.OnHierarchyChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener, BdNoProGuard {
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";

    /* loaded from: classes.dex */
    public interface PictureListener extends BdNoProGuard {
        void onNewPicture(WebView webView, Picture picture);
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static void disablePlatformNotifications() {
        throw new RuntimeException("stub!");
    }

    public static void enablePlatformNotifications() {
        throw new RuntimeException("stub!");
    }

    public static String findAddress(String str) {
        throw new RuntimeException("stub!");
    }

    public static String findAddress(String str, boolean z) {
        throw new RuntimeException("stub!");
    }

    public void addJavascriptInterface(Object obj, String str) {
        throw new RuntimeException("stub!");
    }

    public void removeJavascriptInterface(String str) {
        throw new RuntimeException("stub!");
    }

    public void addPackageName(String str) {
        throw new RuntimeException("stub!");
    }

    public void addPackageNames(Set<String> set) {
        throw new RuntimeException("stub!");
    }

    public boolean canGoBack() {
        throw new RuntimeException("stub!");
    }

    public boolean canGoBackOrForward(int i) {
        throw new RuntimeException("stub!");
    }

    public boolean canGoForward() {
        throw new RuntimeException("stub!");
    }

    public Picture capturePicture() {
        throw new RuntimeException("stub!");
    }

    public void clearCache(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void clearFormData() {
        throw new RuntimeException("stub!");
    }

    public void clearHistory() {
        throw new RuntimeException("stub!");
    }

    public void clearMatches() {
        throw new RuntimeException("stub!");
    }

    public void clearSslPreferences() {
        throw new RuntimeException("stub!");
    }

    public void clearView() {
        throw new RuntimeException("stub!");
    }

    public WebBackForwardList copyBackForwardList() {
        throw new RuntimeException("stub!");
    }

    public boolean copySelection() {
        throw new RuntimeException("stub!");
    }

    public void debugDump() {
        throw new RuntimeException("stub!");
    }

    public void destroy() {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        throw new RuntimeException("stub!");
    }

    public void documentAsText(Message message) {
        throw new RuntimeException("stub!");
    }

    public void documentHasImages(Message message) {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        throw new RuntimeException("stub!");
    }

    public void drawPage(Canvas canvas) {
        throw new RuntimeException("stub!");
    }

    public void dumpDisplayTree() {
        throw new RuntimeException("stub!");
    }

    public void dumpDomTree(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void dumpRenderTree(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void dumpV8Counters() {
        throw new RuntimeException("stub!");
    }

    public void emulateShiftHeld() {
        throw new RuntimeException("stub!");
    }

    public void enableSmartZoom() {
    }

    public void externalRepresentation(Message message) {
        throw new RuntimeException("stub!");
    }

    public int findAll(String str) {
        throw new RuntimeException("stub!");
    }

    public int findIndex() {
        throw new RuntimeException("stub!");
    }

    public void findNext(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void flingScroll(int i, int i2) {
        throw new RuntimeException("stub!");
    }

    public void freeMemory() {
        throw new RuntimeException("stub!");
    }

    public SslCertificate getCertificate() {
        throw new RuntimeException("stub!");
    }

    public int getContentHeight() {
        throw new RuntimeException("stub!");
    }

    public int getContentWidth() {
        throw new RuntimeException("stub!");
    }

    public DragTracker getDragTracker() {
        throw new RuntimeException("stub!");
    }

    public Bitmap getFavicon() {
        throw new RuntimeException("stub!");
    }

    public HitTestResult getHitTestResult() {
        throw new RuntimeException("stub!");
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        throw new RuntimeException("stub!");
    }

    public String getOriginalUrl() {
        throw new RuntimeException("stub!");
    }

    public int getProgress() {
        throw new RuntimeException("stub!");
    }

    public float getScale() {
        throw new RuntimeException("stub!");
    }

    public String getSelection() {
        throw new RuntimeException("stub!");
    }

    public WebSettings getSettings() {
        throw new RuntimeException("stub!");
    }

    public String getTitle() {
        throw new RuntimeException("stub!");
    }

    public String getTouchIconUrl() {
        throw new RuntimeException("stub!");
    }

    public String getUrl() {
        throw new RuntimeException("stub!");
    }

    public int getVisibleTitleHeight() {
        throw new RuntimeException("stub!");
    }

    public WebBackForwardListClient getWebBackForwardListClient() {
        throw new RuntimeException("stub!");
    }

    public WebChromeClient getWebChromeClient() {
        throw new RuntimeException("stub!");
    }

    public WebViewClient getWebViewClient() {
        throw new RuntimeException("stub!");
    }

    public ZoomButtonsController getZoomButtonsController() {
        throw new RuntimeException("stub!");
    }

    public View getZoomControls() {
        throw new RuntimeException("stub!");
    }

    public void goBack() {
        throw new RuntimeException("stub!");
    }

    public void goBackOrForward(int i) {
        throw new RuntimeException("stub!");
    }

    public void goForward() {
        throw new RuntimeException("stub!");
    }

    public void invokeZoomPicker() {
        throw new RuntimeException("stub!");
    }

    public boolean isPaused() {
        throw new RuntimeException("stub!");
    }

    public boolean isPrivateBrowsingEnabled() {
        throw new RuntimeException("stub!");
    }

    public void loadData(String str, String str2, String str3) {
        throw new RuntimeException("stub!");
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        throw new RuntimeException("stub!");
    }

    public void loadUrl(String str) {
        throw new RuntimeException("stub!");
    }

    public void loadUrl(String str, Map<String, String> map) {
        throw new RuntimeException("stub!");
    }

    public void notifyFindDialogDismissed() {
        throw new RuntimeException("stub!");
    }

    public void notifySelectDialogDismissed() {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        throw new RuntimeException("stub!");
    }

    public void onPause() {
        throw new RuntimeException("stub!");
    }

    public void onResume() {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        throw new RuntimeException("stub!");
    }

    public boolean overlayHorizontalScrollbar() {
        throw new RuntimeException("stub!");
    }

    public boolean overlayVerticalScrollbar() {
        throw new RuntimeException("stub!");
    }

    public boolean pageDown(boolean z) {
        throw new RuntimeException("stub!");
    }

    public boolean pageUp(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void pauseTimers() {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View
    public boolean performLongClick() {
        throw new RuntimeException("stub!");
    }

    public void postUrl(String str, byte[] bArr) {
        throw new RuntimeException("stub!");
    }

    public void refreshPlugins(boolean z) {
    }

    public void reload() {
        throw new RuntimeException("stub!");
    }

    public void removePackageName(String str) {
        throw new RuntimeException("stub!");
    }

    public void requestFocusNodeHref(Message message) {
        throw new RuntimeException("stub!");
    }

    public void requestImageRef(Message message) {
        throw new RuntimeException("stub!");
    }

    public boolean restorePicture(Bundle bundle, File file) {
        throw new RuntimeException("stub!");
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        throw new RuntimeException("stub!");
    }

    public void resumeTimers() {
        throw new RuntimeException("stub!");
    }

    public void savePassword(String str, String str2, String str3) {
        throw new RuntimeException("stub!");
    }

    public boolean savePicture(Bundle bundle, File file) {
        throw new RuntimeException("stub!");
    }

    public WebBackForwardList saveState(Bundle bundle) {
        throw new RuntimeException("stub!");
    }

    public void saveWebArchive(String str) {
        throw new RuntimeException("stub!");
    }

    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        throw new RuntimeException("stub!");
    }

    public void selectAll() {
        throw new RuntimeException("stub!");
    }

    public boolean selectDialogIsUp() {
        throw new RuntimeException("stub!");
    }

    public boolean selectText() {
        throw new RuntimeException("stub!");
    }

    public void selectionDone() {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        throw new RuntimeException("stub!");
    }

    public void setCertificate(SslCertificate sslCertificate) {
        throw new RuntimeException("stub!");
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        throw new RuntimeException("stub!");
    }

    public void setDragTracker(DragTracker dragTracker) {
        throw new RuntimeException("stub!");
    }

    public void setEmbeddedTitleBar(View view) {
        throw new RuntimeException("stub!");
    }

    public void setFindDialogHeight(int i) {
        throw new RuntimeException("stub!");
    }

    public void setFindIsUp(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        throw new RuntimeException("stub!");
    }

    public void setInitialScale(int i) {
        throw new RuntimeException("stub!");
    }

    public void setJsFlags(String str) {
        throw new RuntimeException("stub!");
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        throw new RuntimeException("stub!");
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setNetworkAvailable(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setNetworkType(String str, String str2) {
        throw new RuntimeException("stub!");
    }

    public void setPictureListener(PictureListener pictureListener) {
        throw new RuntimeException("stub!");
    }

    public void setTouchInterval(int i) {
        throw new RuntimeException("stub!");
    }

    public void setUpSelect() {
        throw new RuntimeException("stub!");
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        throw new RuntimeException("stub!");
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        throw new RuntimeException("stub!");
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        throw new RuntimeException("stub!");
    }

    public boolean showFindDialog(String str, boolean z) {
        throw new RuntimeException("stub!");
    }

    public void stopLoading() {
        throw new RuntimeException("stub!");
    }

    public boolean zoomIn() {
        throw new RuntimeException("stub!");
    }

    public boolean zoomOut() {
        throw new RuntimeException("stub!");
    }

    public boolean canZoomIn() {
        throw new RuntimeException("stub!");
    }

    public boolean canZoomOut() {
        throw new RuntimeException("stub!");
    }

    /* loaded from: classes.dex */
    public class DragTracker implements BdNoProGuard {
        public void onStartDrag(float f, float f2) {
        }

        public boolean onStretchChange(float f, float f2) {
            return false;
        }

        public void onStopDrag() {
        }

        public void onBitmapChange(Bitmap bitmap) {
        }

        public void onDraw(Canvas canvas) {
        }
    }

    /* loaded from: classes.dex */
    public class HitTestResult implements BdNoProGuard {
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private String mExtra;
        private int mType = 0;

        HitTestResult() {
        }

        private void setType(int i) {
            this.mType = i;
        }

        private void setExtra(String str) {
            this.mExtra = str;
        }

        public int getType() {
            return this.mType;
        }

        public String getExtra() {
            return this.mExtra;
        }
    }

    /* loaded from: classes.dex */
    public class WebViewTransport implements BdNoProGuard {
        private WebView mWebview;

        public WebViewTransport() {
        }

        public synchronized void setWebView(WebView webView) {
            this.mWebview = webView;
        }

        public synchronized WebView getWebView() {
            return this.mWebview;
        }
    }
}
