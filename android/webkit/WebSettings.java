package android.webkit;

import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webpool.BdWebPoolView;
/* loaded from: classes.dex */
public class WebSettings implements BdNoProGuard {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* loaded from: classes.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static LayoutAlgorithm[] valuesCustom() {
            LayoutAlgorithm[] valuesCustom = values();
            int length = valuesCustom.length;
            LayoutAlgorithm[] layoutAlgorithmArr = new LayoutAlgorithm[length];
            System.arraycopy(valuesCustom, 0, layoutAlgorithmArr, 0, length);
            return layoutAlgorithmArr;
        }
    }

    /* loaded from: classes.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PluginState[] valuesCustom() {
            PluginState[] valuesCustom = values();
            int length = valuesCustom.length;
            PluginState[] pluginStateArr = new PluginState[length];
            System.arraycopy(valuesCustom, 0, pluginStateArr, 0, length);
            return pluginStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static RenderPriority[] valuesCustom() {
            RenderPriority[] valuesCustom = values();
            int length = valuesCustom.length;
            RenderPriority[] renderPriorityArr = new RenderPriority[length];
            System.arraycopy(valuesCustom, 0, renderPriorityArr, 0, length);
            return renderPriorityArr;
        }
    }

    /* loaded from: classes.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(com.baidu.zeus.WebChromeClient.STRING_DLG_BTN_SET),
        LARGEST(BdWebPoolView.DELAYED_TIME);
        
        int value;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TextSize[] valuesCustom() {
            TextSize[] valuesCustom = values();
            int length = valuesCustom.length;
            TextSize[] textSizeArr = new TextSize[length];
            System.arraycopy(valuesCustom, 0, textSizeArr, 0, length);
            return textSizeArr;
        }

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public enum ZoomDensity {
        FAR(com.baidu.zeus.WebChromeClient.STRING_DLG_BTN_SET),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ZoomDensity[] valuesCustom() {
            ZoomDensity[] valuesCustom = values();
            int length = valuesCustom.length;
            ZoomDensity[] zoomDensityArr = new ZoomDensity[length];
            System.arraycopy(valuesCustom, 0, zoomDensityArr, 0, length);
            return zoomDensityArr;
        }

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    public boolean getAllowFileAccess() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getBlockNetworkImage() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getBlockNetworkLoads() {
        throw new RuntimeException("stub!");
    }

    public boolean getBuiltInZoomControls() {
        throw new RuntimeException("stub!");
    }

    public int getCacheMode() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getCursiveFontFamily() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getDatabaseEnabled() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getDatabasePath() {
        throw new RuntimeException("stub!");
    }

    public synchronized int getDefaultFixedFontSize() {
        throw new RuntimeException("stub!");
    }

    public synchronized int getDefaultFontSize() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getDefaultTextEncodingName() {
        throw new RuntimeException("stub!");
    }

    public ZoomDensity getDefaultZoom() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getDomStorageEnabled() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getFantasyFontFamily() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getFixedFontFamily() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getJavaScriptEnabled() {
        throw new RuntimeException("stub!");
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        throw new RuntimeException("stub!");
    }

    public boolean getLightTouchEnabled() {
        throw new RuntimeException("stub!");
    }

    public boolean getLoadWithOverviewMode() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        throw new RuntimeException("stub!");
    }

    public synchronized int getMinimumFontSize() {
        throw new RuntimeException("stub!");
    }

    public synchronized int getMinimumLogicalFontSize() {
        throw new RuntimeException("stub!");
    }

    public boolean getNavDump() {
        throw new RuntimeException("stub!");
    }

    public synchronized PluginState getPluginState() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getPluginsEnabled() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getPluginsPath() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getSansSerifFontFamily() {
        throw new RuntimeException("stub!");
    }

    public boolean getSaveFormData() {
        throw new RuntimeException("stub!");
    }

    public boolean getSavePassword() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getSerifFontFamily() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getStandardFontFamily() {
        throw new RuntimeException("stub!");
    }

    public synchronized TextSize getTextSize() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getUseDoubleTree() {
        throw new RuntimeException("stub!");
    }

    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean getUseWideViewPort() {
        throw new RuntimeException("stub!");
    }

    public synchronized int getUserAgent() {
        throw new RuntimeException("stub!");
    }

    public synchronized String getUserAgentString() {
        throw new RuntimeException("stub!");
    }

    boolean isPrivateBrowsingEnabled() {
        throw new RuntimeException("stub!");
    }

    public void setAllowContentAccess(boolean z) {
    }

    public void setAllowFileAccess(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setAppCacheMaxSize(long j) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setAppCachePath(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setBuiltInZoomControls(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setCacheMode(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setCursiveFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDatabasePath(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDefaultFontSize(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        throw new RuntimeException("stub!");
    }

    public void setDefaultZoom(ZoomDensity zoomDensity) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setEnableQuickSelection(boolean z) {
    }

    public void setEnableSmoothTransition(boolean z) {
    }

    public synchronized void setFantasyFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setFixedFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public void setFlashPluginsEnabled(boolean z) {
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        throw new RuntimeException("stub!");
    }

    public void setLightTouchEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setLoadWithOverviewMode(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setMinimumFontSize(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        throw new RuntimeException("stub!");
    }

    public void setNavDump(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setNeedFirstElement(boolean z) {
    }

    public void setNeedInitialFocus(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setPageCacheCapacity(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setPluginState(PluginState pluginState) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setPluginsEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setPluginsPath(String str) {
        throw new RuntimeException("stub!");
    }

    void setPrivateBrowsingEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setRenderPriority(RenderPriority renderPriority) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setSansSerifFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public void setSaveFormData(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setSavePassword(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setSerifFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setStandardFontFamily(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setSupportZoom(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setTextSize(TextSize textSize) {
        throw new RuntimeException("stub!");
    }

    public void setUAProfileURL(String str) {
    }

    public synchronized void setUseDoubleTree(boolean z) {
        throw new RuntimeException("stub!");
    }

    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setUseWideViewPort(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setUserAgent(int i) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setUserAgentString(String str) {
        throw new RuntimeException("stub!");
    }

    public synchronized void setWorkersEnabled(boolean z) {
        throw new RuntimeException("stub!");
    }

    public synchronized boolean supportMultipleWindows() {
        throw new RuntimeException("stub!");
    }

    public boolean supportZoom() {
        throw new RuntimeException("stub!");
    }

    public void setDisplayZoomControls(boolean z) {
        throw new RuntimeException("stub!");
    }
}
