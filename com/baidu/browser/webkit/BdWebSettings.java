package com.baidu.browser.webkit;

import android.os.Message;
import android.webkit.WebSettings;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webkit.sys.BdSysWebSettings;
import com.baidu.browser.webkit.zeus.BdZeusWebSettings;
import com.baidu.zeus.WebChromeClient;
import com.baidu.zeus.WebSettings;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class BdWebSettings extends Observable implements BdNoProGuard, Cloneable, Observer {
    private static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$LayoutAlgorithm = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$PluginState = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$TextSize = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$ZoomDensity = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$LayoutAlgorithm = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$PluginState = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$RenderPriority = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$TextSize = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$ZoomDensity = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$LayoutAlgorithm = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$PluginState = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$TextSize = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$ZoomDensity = null;
    private static final boolean DEBUG = false;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private static final String LOG_TAG = "BdWebSettings";
    private static final int MSG_setAllowFileAccess = 4;
    private static final int MSG_setAppCacheEnabled = 31;
    private static final int MSG_setAppCacheMaxSize = 33;
    private static final int MSG_setAppCachePath = 32;
    private static final int MSG_setBlockNetworkImage = 25;
    private static final int MSG_setBlockNetworkLoads = 26;
    private static final int MSG_setBuiltInZoomControls = 3;
    private static final int MSG_setCacheMode = 42;
    private static final int MSG_setCollectMainAction = 54;
    private static final int MSG_setCursiveFontFamily = 18;
    private static final int MSG_setDatabaseEnabled = 34;
    private static final int MSG_setDatabasePath = 29;
    private static final int MSG_setDefaultFixedFontSize = 23;
    private static final int MSG_setDefaultFontSize = 22;
    private static final int MSG_setDefaultTextEncodingName = 38;
    private static final int MSG_setDefaultZoom = 9;
    private static final int MSG_setDomStorageEnabled = 35;
    private static final int MSG_setEnableFlashFullScreenMode = 58;
    private static final int MSG_setEnableVideo = 47;
    private static final int MSG_setFantasyFontFamily = 19;
    private static final int MSG_setFixedFontFamily = 15;
    private static final int MSG_setForcePageCanBeScaled = 57;
    private static final int MSG_setGeolocationDatabasePath = 30;
    private static final int MSG_setGeolocationEnabled = 36;
    private static final int MSG_setImageMaxWidth = 55;
    private static final int MSG_setJavaScriptCanOpenWindowsAutomatically = 37;
    private static final int MSG_setJavaScriptEnabled = 27;
    private static final int MSG_setLayoutAlgorithm = 13;
    private static final int MSG_setLightTouchEnabled = 10;
    private static final int MSG_setLoadWithOverviewMode = 5;
    private static final int MSG_setLoadsImagesAutomatically = 24;
    private static final int MSG_setMarkSubjectEnabled = 53;
    private static final int MSG_setMinimumFontSize = 20;
    private static final int MSG_setMinimumLogicalFontSize = 21;
    private static final int MSG_setNavDump = 1;
    private static final int MSG_setNeedInitialFocus = 40;
    private static final int MSG_setNightModeEnabled = 50;
    private static final int MSG_setPageCacheCapacity = 52;
    private static final int MSG_setPauseAudioEnabled = 59;
    private static final int MSG_setPluginState = 28;
    private static final int MSG_setPreloadEnabled = 49;
    private static final int MSG_setRenderPriority = 41;
    private static final int MSG_setSansSerifFontFamily = 16;
    private static final int MSG_setSaveFormData = 6;
    private static final int MSG_setSavePassword = 7;
    private static final int MSG_setSerifFontFamily = 17;
    private static final int MSG_setShrinksStandaloneImagesToFit = 56;
    private static final int MSG_setStandardFontFamily = 14;
    private static final int MSG_setSupportMultipleWindows = 12;
    private static final int MSG_setSupportZoom = 2;
    private static final int MSG_setTextSize = 8;
    private static final int MSG_setUseGLRendering = 43;
    private static final int MSG_setUseGifLoadProxy = 46;
    private static final int MSG_setUseImageLoadProxy = 44;
    private static final int MSG_setUseScaleStore = 48;
    private static final int MSG_setUseUnderLine = 45;
    private static final int MSG_setUseWideViewPort = 11;
    private static final int MSG_setUserAgentString = 39;
    private static final int MSG_setWorkersEnabled = 51;
    private BdSysWebSettings mSysWebSettings;
    private BdZeusWebSettings mZeusWebSettings;
    private String mGeolocationDatabasePath = "";
    private boolean mAppCacheEnabled = false;
    private String mAppCachePath = "";
    private long mAppCacheMaxSize = Long.MAX_VALUE;
    private boolean mGeolocationEnabled = true;
    private boolean mNeedInitialFocus = true;
    private RenderPriority mRenderPriority = RenderPriority.NORMAL;
    private boolean mWorkersEnabled = false;
    private int mPageCacheCapacity = 0;

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

    static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$LayoutAlgorithm() {
        int[] iArr = $SWITCH_TABLE$android$webkit$WebSettings$LayoutAlgorithm;
        if (iArr == null) {
            iArr = new int[WebSettings.LayoutAlgorithm.valuesCustom().length];
            try {
                iArr[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$android$webkit$WebSettings$LayoutAlgorithm = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$PluginState() {
        int[] iArr = $SWITCH_TABLE$android$webkit$WebSettings$PluginState;
        if (iArr == null) {
            iArr = new int[WebSettings.PluginState.valuesCustom().length];
            try {
                iArr[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$android$webkit$WebSettings$PluginState = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$TextSize() {
        int[] iArr = $SWITCH_TABLE$android$webkit$WebSettings$TextSize;
        if (iArr == null) {
            iArr = new int[WebSettings.TextSize.valuesCustom().length];
            try {
                iArr[WebSettings.TextSize.LARGER.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.TextSize.LARGEST.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.TextSize.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WebSettings.TextSize.SMALLER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WebSettings.TextSize.SMALLEST.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$android$webkit$WebSettings$TextSize = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$WebSettings$ZoomDensity() {
        int[] iArr = $SWITCH_TABLE$android$webkit$WebSettings$ZoomDensity;
        if (iArr == null) {
            iArr = new int[WebSettings.ZoomDensity.valuesCustom().length];
            try {
                iArr[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$android$webkit$WebSettings$ZoomDensity = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$LayoutAlgorithm() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$LayoutAlgorithm;
        if (iArr == null) {
            iArr = new int[LayoutAlgorithm.valuesCustom().length];
            try {
                iArr[LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$LayoutAlgorithm = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$PluginState() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$PluginState;
        if (iArr == null) {
            iArr = new int[PluginState.valuesCustom().length];
            try {
                iArr[PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$PluginState = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$RenderPriority() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$RenderPriority;
        if (iArr == null) {
            iArr = new int[RenderPriority.valuesCustom().length];
            try {
                iArr[RenderPriority.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RenderPriority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[RenderPriority.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$RenderPriority = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$TextSize() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$TextSize;
        if (iArr == null) {
            iArr = new int[TextSize.valuesCustom().length];
            try {
                iArr[TextSize.LARGER.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TextSize.LARGERLITTLE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TextSize.LARGERMORE.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TextSize.LARGEST.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TextSize.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TextSize.SMALLER.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[TextSize.SMALLEST.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$TextSize = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$ZoomDensity() {
        int[] iArr = $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$ZoomDensity;
        if (iArr == null) {
            iArr = new int[ZoomDensity.valuesCustom().length];
            try {
                iArr[ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$ZoomDensity = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$LayoutAlgorithm() {
        int[] iArr = $SWITCH_TABLE$com$baidu$zeus$WebSettings$LayoutAlgorithm;
        if (iArr == null) {
            iArr = new int[WebSettings.LayoutAlgorithm.values().length];
            try {
                iArr[WebSettings.LayoutAlgorithm.NARROW_COLUMNS.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.LayoutAlgorithm.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.LayoutAlgorithm.SINGLE_COLUMN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$zeus$WebSettings$LayoutAlgorithm = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$PluginState() {
        int[] iArr = $SWITCH_TABLE$com$baidu$zeus$WebSettings$PluginState;
        if (iArr == null) {
            iArr = new int[WebSettings.PluginState.values().length];
            try {
                iArr[WebSettings.PluginState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.PluginState.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.PluginState.ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$zeus$WebSettings$PluginState = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$TextSize() {
        int[] iArr = $SWITCH_TABLE$com$baidu$zeus$WebSettings$TextSize;
        if (iArr == null) {
            iArr = new int[WebSettings.TextSize.values().length];
            try {
                iArr[WebSettings.TextSize.LARGER.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.TextSize.LARGERLITTLE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.TextSize.LARGERMORE.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WebSettings.TextSize.LARGEST.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WebSettings.TextSize.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WebSettings.TextSize.SMALLER.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[WebSettings.TextSize.SMALLEST.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            $SWITCH_TABLE$com$baidu$zeus$WebSettings$TextSize = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$WebSettings$ZoomDensity() {
        int[] iArr = $SWITCH_TABLE$com$baidu$zeus$WebSettings$ZoomDensity;
        if (iArr == null) {
            iArr = new int[WebSettings.ZoomDensity.values().length];
            try {
                iArr[WebSettings.ZoomDensity.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WebSettings.ZoomDensity.FAR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WebSettings.ZoomDensity.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$zeus$WebSettings$ZoomDensity = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public enum TextSize {
        SMALLEST(BdWebSettings.MSG_setNightModeEnabled),
        SMALLER(75),
        NORMAL(100),
        LARGERLITTLE(125),
        LARGER(WebChromeClient.STRING_DLG_BTN_SET),
        LARGERMORE(175),
        LARGEST(200);
        
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
        FAR(WebChromeClient.STRING_DLG_BTN_SET),
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

    public BdWebSettings(BdSysWebSettings bdSysWebSettings) {
        this.mSysWebSettings = bdSysWebSettings;
    }

    public BdWebSettings(BdZeusWebSettings bdZeusWebSettings) {
        this.mZeusWebSettings = bdZeusWebSettings;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebSettings) && unwrap() == ((BdWebSettings) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.hashCode() : this.mSysWebSettings.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings == obj : this.mSysWebSettings == obj;
    }

    public Object unwrap() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings : this.mSysWebSettings;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BdWebSettings m0clone() {
        return this.mZeusWebSettings != null ? new BdWebSettings(this.mZeusWebSettings) : new BdWebSettings(this.mSysWebSettings);
    }

    public void attach(BdWebSettings bdWebSettings) {
        attach(bdWebSettings, true);
    }

    public void attach(BdWebSettings bdWebSettings, boolean z) {
        if (bdWebSettings != null) {
            if (z) {
                syncWebSettings(bdWebSettings);
            }
            addObserver(bdWebSettings);
        }
    }

    public void detach(BdWebSettings bdWebSettings) {
        deleteObserver(bdWebSettings);
    }

    private void syncWebSettings(BdWebSettings bdWebSettings) {
        bdWebSettings.setNavDump(getNavDump());
        bdWebSettings.setSupportZoom(supportZoom());
        bdWebSettings.setBuiltInZoomControls(getBuiltInZoomControls());
        bdWebSettings.setAllowFileAccess(getAllowFileAccess());
        bdWebSettings.setLoadWithOverviewMode(getLoadWithOverviewMode());
        bdWebSettings.setSaveFormData(getSaveFormData());
        bdWebSettings.setSavePassword(getSavePassword());
        bdWebSettings.setTextSize(getTextSize());
        bdWebSettings.setDefaultZoom(getDefaultZoom());
        bdWebSettings.setLightTouchEnabled(getLightTouchEnabled());
        bdWebSettings.setUseWideViewPort(getUseWideViewPort());
        bdWebSettings.setSupportMultipleWindows(supportMultipleWindows());
        bdWebSettings.setLayoutAlgorithm(getLayoutAlgorithm());
        bdWebSettings.setStandardFontFamily(getStandardFontFamily());
        bdWebSettings.setFixedFontFamily(getFixedFontFamily());
        bdWebSettings.setSansSerifFontFamily(getSansSerifFontFamily());
        bdWebSettings.setSerifFontFamily(getSerifFontFamily());
        bdWebSettings.setCursiveFontFamily(getCursiveFontFamily());
        bdWebSettings.setFantasyFontFamily(getFantasyFontFamily());
        bdWebSettings.setMinimumFontSize(getMinimumFontSize());
        bdWebSettings.setMinimumLogicalFontSize(getMinimumLogicalFontSize());
        bdWebSettings.setDefaultFontSize(getDefaultFontSize());
        bdWebSettings.setDefaultFixedFontSize(getDefaultFixedFontSize());
        bdWebSettings.setLoadsImagesAutomatically(getLoadsImagesAutomatically());
        bdWebSettings.setBlockNetworkImage(getBlockNetworkImage());
        bdWebSettings.setBlockNetworkLoads(getBlockNetworkLoads());
        bdWebSettings.setJavaScriptEnabled(getJavaScriptEnabled());
        bdWebSettings.setPluginState(getPluginState());
        bdWebSettings.setDatabasePath(getDatabasePath());
        bdWebSettings.setGeolocationDatabasePath(this.mGeolocationDatabasePath);
        bdWebSettings.setAppCacheEnabled(this.mAppCacheEnabled);
        bdWebSettings.setAppCachePath(this.mAppCachePath);
        bdWebSettings.setAppCacheMaxSize(this.mAppCacheMaxSize);
        bdWebSettings.setDatabaseEnabled(getDatabaseEnabled());
        bdWebSettings.setDomStorageEnabled(getDomStorageEnabled());
        bdWebSettings.setGeolocationEnabled(this.mGeolocationEnabled);
        bdWebSettings.setJavaScriptCanOpenWindowsAutomatically(getJavaScriptCanOpenWindowsAutomatically());
        bdWebSettings.setDefaultTextEncodingName(getDefaultTextEncodingName());
        bdWebSettings.setUserAgentString(getUserAgentString());
        bdWebSettings.setNeedInitialFocus(this.mNeedInitialFocus);
        bdWebSettings.setRenderPriority(this.mRenderPriority);
        bdWebSettings.setCacheMode(getCacheMode());
        bdWebSettings.setWorkersEnabled(this.mWorkersEnabled);
        bdWebSettings.setPageCacheCapacity(this.mPageCacheCapacity);
        bdWebSettings.setUseGLRendering(getUseGLRendering());
        bdWebSettings.setUseUnderLine(getUseUnderLine());
        bdWebSettings.setUseImageLoadProxy(getUseImageLoadProxy());
        bdWebSettings.setUseGifLoadProxy(getUseGifLoadProxy());
        bdWebSettings.setEnableVideo(getEnableVideo());
        bdWebSettings.setUseScaleStore(getUseScaleStore());
        bdWebSettings.setPreloadEnabled(getPreloadEnabled());
        bdWebSettings.setNightModeEnabled(getNightModeEnabled());
        bdWebSettings.setMarkSubjectEnabled(getMarkSubjectEnabled());
        bdWebSettings.setCollectMainAction(getCollectMainAction());
        bdWebSettings.setForcePageCanBeScaled(getForcePageCanBeScaled());
        bdWebSettings.setEnableFlashFullScreenMode(getEnableFlashFullScreenMode());
        bdWebSettings.setPauseAudioEnabled(getPauseAudioEnabled());
    }

    public void setNavDump(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setNavDump(z);
        } else {
            this.mSysWebSettings.setNavDump(z);
        }
        notifyObservers(1, Boolean.valueOf(z));
    }

    public boolean getNavDump() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getNavDump() : this.mSysWebSettings.getNavDump();
    }

    public void setSupportZoom(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSupportZoom(z);
        } else {
            this.mSysWebSettings.setSupportZoom(z);
        }
        notifyObservers(2, Boolean.valueOf(z));
    }

    public boolean supportZoom() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.supportZoom() : this.mSysWebSettings.supportZoom();
    }

    public void setBuiltInZoomControls(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setBuiltInZoomControls(z);
        } else {
            this.mSysWebSettings.setBuiltInZoomControls(z);
        }
        notifyObservers(3, Boolean.valueOf(z));
    }

    public boolean getBuiltInZoomControls() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getBuiltInZoomControls() : this.mSysWebSettings.getBuiltInZoomControls();
    }

    public void setAllowFileAccess(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setAllowFileAccess(z);
        } else {
            this.mSysWebSettings.setAllowFileAccess(z);
        }
        notifyObservers(4, Boolean.valueOf(z));
    }

    public boolean getAllowFileAccess() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getAllowFileAccess() : this.mSysWebSettings.getAllowFileAccess();
    }

    public void setLoadWithOverviewMode(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setLoadWithOverviewMode(z);
        } else {
            this.mSysWebSettings.setLoadWithOverviewMode(z);
        }
        notifyObservers(5, Boolean.valueOf(z));
    }

    public boolean getLoadWithOverviewMode() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getLoadWithOverviewMode() : this.mSysWebSettings.getLoadWithOverviewMode();
    }

    public void setSaveFormData(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSaveFormData(z);
        } else {
            this.mSysWebSettings.setSaveFormData(z);
        }
        notifyObservers(6, Boolean.valueOf(z));
    }

    public boolean getSaveFormData() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getSaveFormData() : this.mSysWebSettings.getSaveFormData();
    }

    public void setSavePassword(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSavePassword(z);
        } else {
            this.mSysWebSettings.setSavePassword(z);
        }
        notifyObservers(7, Boolean.valueOf(z));
    }

    public boolean getSavePassword() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getSavePassword() : this.mSysWebSettings.getSavePassword();
    }

    public synchronized void setTextSize(TextSize textSize) {
        switch ($SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$TextSize()[textSize.ordinal()]) {
            case 1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.SMALLEST);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.SMALLEST);
                    break;
                }
            case 2:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.SMALLER);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.SMALLER);
                    break;
                }
            case 3:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.NORMAL);
                    break;
                }
            case 4:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.LARGERLITTLE);
                    break;
                }
                break;
            case 5:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.LARGER);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.LARGER);
                    break;
                }
            case 6:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.LARGERMORE);
                    break;
                }
                break;
            case 7:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.LARGEST);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.LARGEST);
                    break;
                }
            default:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setTextSize(WebSettings.TextSize.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setTextSize(WebSettings.TextSize.NORMAL);
                    break;
                }
        }
        notifyObservers(8, textSize);
    }

    public synchronized TextSize getTextSize() {
        TextSize textSize;
        if (this.mZeusWebSettings != null) {
            switch ($SWITCH_TABLE$com$baidu$zeus$WebSettings$TextSize()[this.mZeusWebSettings.getTextSize().ordinal()]) {
                case 1:
                    textSize = TextSize.SMALLEST;
                    break;
                case 2:
                    textSize = TextSize.SMALLER;
                    break;
                case 3:
                    textSize = TextSize.NORMAL;
                    break;
                case 4:
                    textSize = TextSize.LARGERLITTLE;
                    break;
                case 5:
                    textSize = TextSize.LARGER;
                    break;
                case 6:
                    textSize = TextSize.LARGERMORE;
                    break;
                case 7:
                    textSize = TextSize.LARGEST;
                    break;
                default:
                    textSize = TextSize.NORMAL;
                    break;
            }
        } else {
            switch ($SWITCH_TABLE$android$webkit$WebSettings$TextSize()[this.mSysWebSettings.getTextSize().ordinal()]) {
                case 1:
                    textSize = TextSize.SMALLEST;
                    break;
                case 2:
                    textSize = TextSize.SMALLER;
                    break;
                case 3:
                    textSize = TextSize.NORMAL;
                    break;
                case 4:
                    textSize = TextSize.LARGER;
                    break;
                case 5:
                    textSize = TextSize.LARGEST;
                    break;
                default:
                    textSize = TextSize.NORMAL;
                    break;
            }
        }
        return textSize;
    }

    public void setDefaultZoom(ZoomDensity zoomDensity) {
        switch ($SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$ZoomDensity()[zoomDensity.ordinal()]) {
            case 1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
                    break;
                } else {
                    this.mSysWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
                    break;
                }
            case 2:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
                    break;
                } else {
                    this.mSysWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
                    break;
                }
            case 3:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
                    break;
                } else {
                    this.mSysWebSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
                    break;
                }
            default:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
                    break;
                } else {
                    this.mSysWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
                    break;
                }
        }
        notifyObservers(9, zoomDensity);
    }

    public ZoomDensity getDefaultZoom() {
        if (this.mZeusWebSettings != null) {
            switch ($SWITCH_TABLE$com$baidu$zeus$WebSettings$ZoomDensity()[this.mZeusWebSettings.getDefaultZoom().ordinal()]) {
                case 1:
                    return ZoomDensity.FAR;
                case 2:
                    return ZoomDensity.MEDIUM;
                case 3:
                    return ZoomDensity.CLOSE;
                default:
                    return ZoomDensity.MEDIUM;
            }
        }
        switch ($SWITCH_TABLE$android$webkit$WebSettings$ZoomDensity()[this.mSysWebSettings.getDefaultZoom().ordinal()]) {
            case 1:
                return ZoomDensity.FAR;
            case 2:
                return ZoomDensity.MEDIUM;
            case 3:
                return ZoomDensity.CLOSE;
            default:
                return ZoomDensity.MEDIUM;
        }
    }

    public void setLightTouchEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setLightTouchEnabled(z);
        } else {
            this.mSysWebSettings.setLightTouchEnabled(z);
        }
        notifyObservers(10, Boolean.valueOf(z));
    }

    public boolean getLightTouchEnabled() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getLightTouchEnabled() : this.mSysWebSettings.getLightTouchEnabled();
    }

    public synchronized void setUseWideViewPort(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseWideViewPort(z);
        } else {
            this.mSysWebSettings.setUseWideViewPort(z);
        }
        notifyObservers(11, Boolean.valueOf(z));
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getUseWideViewPort() : this.mSysWebSettings.getUseWideViewPort();
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSupportMultipleWindows(z);
        } else {
            this.mSysWebSettings.setSupportMultipleWindows(z);
        }
        notifyObservers(12, Boolean.valueOf(z));
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.supportMultipleWindows() : this.mSysWebSettings.supportMultipleWindows();
    }

    public synchronized void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        switch ($SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$LayoutAlgorithm()[layoutAlgorithm.ordinal()]) {
            case 1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    break;
                }
            case 2:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    break;
                } else {
                    this.mSysWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    break;
                }
            case 3:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                    break;
                } else {
                    this.mSysWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                    break;
                }
            default:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    break;
                }
        }
        notifyObservers(13, layoutAlgorithm);
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm layoutAlgorithm;
        if (this.mZeusWebSettings != null) {
            switch ($SWITCH_TABLE$com$baidu$zeus$WebSettings$LayoutAlgorithm()[this.mZeusWebSettings.getLayoutAlgorithm().ordinal()]) {
                case 1:
                    layoutAlgorithm = LayoutAlgorithm.NORMAL;
                    break;
                case 2:
                    layoutAlgorithm = LayoutAlgorithm.SINGLE_COLUMN;
                    break;
                case 3:
                    layoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
                    break;
                default:
                    layoutAlgorithm = LayoutAlgorithm.NORMAL;
                    break;
            }
        } else {
            switch ($SWITCH_TABLE$android$webkit$WebSettings$LayoutAlgorithm()[this.mSysWebSettings.getLayoutAlgorithm().ordinal()]) {
                case 1:
                    layoutAlgorithm = LayoutAlgorithm.NORMAL;
                    break;
                case 2:
                    layoutAlgorithm = LayoutAlgorithm.SINGLE_COLUMN;
                    break;
                case 3:
                    layoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
                    break;
                default:
                    layoutAlgorithm = LayoutAlgorithm.NORMAL;
                    break;
            }
        }
        return layoutAlgorithm;
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setStandardFontFamily(str);
        } else {
            this.mSysWebSettings.setStandardFontFamily(str);
        }
        notifyObservers(14, str);
    }

    public synchronized String getStandardFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getStandardFontFamily() : this.mSysWebSettings.getStandardFontFamily();
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setFixedFontFamily(str);
        } else {
            this.mSysWebSettings.setFixedFontFamily(str);
        }
        notifyObservers(15, str);
    }

    public synchronized String getFixedFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getFixedFontFamily() : this.mSysWebSettings.getFixedFontFamily();
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSansSerifFontFamily(str);
        } else {
            this.mSysWebSettings.setSansSerifFontFamily(str);
        }
        notifyObservers(16, str);
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getSansSerifFontFamily() : this.mSysWebSettings.getSansSerifFontFamily();
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setSerifFontFamily(str);
        } else {
            this.mSysWebSettings.setSerifFontFamily(str);
        }
        notifyObservers(17, str);
    }

    public synchronized String getSerifFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getSerifFontFamily() : this.mSysWebSettings.getSerifFontFamily();
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setCursiveFontFamily(str);
        } else {
            this.mSysWebSettings.setCursiveFontFamily(str);
        }
        notifyObservers(18, str);
    }

    public synchronized String getCursiveFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getCursiveFontFamily() : this.mSysWebSettings.getCursiveFontFamily();
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setFantasyFontFamily(str);
        } else {
            this.mSysWebSettings.setFantasyFontFamily(str);
        }
        notifyObservers(19, str);
    }

    public synchronized String getFantasyFontFamily() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getFantasyFontFamily() : this.mSysWebSettings.getFantasyFontFamily();
    }

    public synchronized void setMinimumFontSize(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setMinimumFontSize(i);
        } else {
            this.mSysWebSettings.setMinimumFontSize(i);
        }
        notifyObservers(20, Integer.valueOf(i));
    }

    public synchronized int getMinimumFontSize() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getMinimumFontSize() : this.mSysWebSettings.getMinimumFontSize();
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setMinimumLogicalFontSize(i);
        } else {
            this.mSysWebSettings.setMinimumLogicalFontSize(i);
        }
        notifyObservers(21, Integer.valueOf(i));
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getMinimumLogicalFontSize() : this.mSysWebSettings.getMinimumLogicalFontSize();
    }

    public synchronized void setDefaultFontSize(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDefaultFontSize(i);
        } else {
            this.mSysWebSettings.setDefaultFontSize(i);
        }
        notifyObservers(22, Integer.valueOf(i));
    }

    public synchronized int getDefaultFontSize() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDefaultFontSize() : this.mSysWebSettings.getDefaultFontSize();
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDefaultFixedFontSize(i);
        } else {
            this.mSysWebSettings.setDefaultFixedFontSize(i);
        }
        notifyObservers(23, Integer.valueOf(i));
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDefaultFixedFontSize() : this.mSysWebSettings.getDefaultFixedFontSize();
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setLoadsImagesAutomatically(z);
        } else {
            this.mSysWebSettings.setLoadsImagesAutomatically(z);
        }
        notifyObservers(24, Boolean.valueOf(z));
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getLoadsImagesAutomatically() : this.mSysWebSettings.getLoadsImagesAutomatically();
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setBlockNetworkImage(z);
        } else {
            this.mSysWebSettings.setBlockNetworkImage(z);
        }
        notifyObservers(25, Boolean.valueOf(z));
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getBlockNetworkImage() : this.mSysWebSettings.getBlockNetworkImage();
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setBlockNetworkLoads(z);
        } else {
            this.mSysWebSettings.setBlockNetworkLoads(z);
        }
        notifyObservers(26, Boolean.valueOf(z));
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getBlockNetworkLoads() : this.mSysWebSettings.getBlockNetworkLoads();
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setJavaScriptEnabled(z);
        } else {
            this.mSysWebSettings.setJavaScriptEnabled(z);
        }
        notifyObservers(27, Boolean.valueOf(z));
    }

    public synchronized void setPluginState(PluginState pluginState) {
        try {
            switch ($SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$PluginState()[pluginState.ordinal()]) {
                case 1:
                    if (this.mZeusWebSettings != null) {
                        this.mZeusWebSettings.setPluginState(WebSettings.PluginState.ON);
                        break;
                    } else {
                        this.mSysWebSettings.setPluginState(WebSettings.PluginState.ON);
                        break;
                    }
                case 2:
                    if (this.mZeusWebSettings != null) {
                        this.mZeusWebSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
                        break;
                    } else {
                        this.mSysWebSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
                        break;
                    }
                case 3:
                    if (this.mZeusWebSettings != null) {
                        this.mZeusWebSettings.setPluginState(WebSettings.PluginState.OFF);
                        break;
                    } else {
                        this.mSysWebSettings.setPluginState(WebSettings.PluginState.OFF);
                        break;
                    }
                default:
                    if (this.mZeusWebSettings != null) {
                        this.mZeusWebSettings.setPluginState(WebSettings.PluginState.ON);
                        break;
                    } else {
                        this.mSysWebSettings.setPluginState(WebSettings.PluginState.ON);
                        break;
                    }
            }
            notifyObservers(28, pluginState);
        } catch (Exception e) {
        } catch (NoSuchMethodError e2) {
        }
    }

    public synchronized void setDatabasePath(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDatabasePath(str);
        } else {
            this.mSysWebSettings.setDatabasePath(str);
        }
        notifyObservers(MSG_setDatabasePath, str);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setGeolocationDatabasePath(str);
        } else {
            this.mSysWebSettings.setGeolocationDatabasePath(str);
        }
        if (str != null) {
            this.mGeolocationDatabasePath = str;
        }
        notifyObservers(30, str);
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setAppCacheEnabled(z);
        } else {
            this.mSysWebSettings.setAppCacheEnabled(z);
        }
        this.mAppCacheEnabled = z;
        notifyObservers(MSG_setAppCacheEnabled, Boolean.valueOf(z));
    }

    public synchronized void setAppCachePath(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setAppCachePath(str);
        } else {
            this.mSysWebSettings.setAppCachePath(str);
        }
        if (str != null) {
            this.mAppCachePath = str;
        }
        notifyObservers(32, str);
    }

    public synchronized void setAppCacheMaxSize(long j) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setAppCacheMaxSize(j);
        } else {
            this.mSysWebSettings.setAppCacheMaxSize(j);
        }
        this.mAppCacheMaxSize = j;
        notifyObservers(MSG_setAppCacheMaxSize, Long.valueOf(j));
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDatabaseEnabled(z);
        } else {
            this.mSysWebSettings.setDatabaseEnabled(z);
        }
        notifyObservers(MSG_setDatabaseEnabled, Boolean.valueOf(z));
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDomStorageEnabled(z);
        } else {
            this.mSysWebSettings.setDomStorageEnabled(z);
        }
        notifyObservers(MSG_setDomStorageEnabled, Boolean.valueOf(z));
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDomStorageEnabled() : this.mSysWebSettings.getDomStorageEnabled();
    }

    public synchronized String getDatabasePath() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDatabasePath() : this.mSysWebSettings.getDatabasePath();
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDatabaseEnabled() : this.mSysWebSettings.getDatabaseEnabled();
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setGeolocationEnabled(z);
        } else {
            this.mSysWebSettings.setGeolocationEnabled(z);
        }
        this.mGeolocationEnabled = z;
        notifyObservers(MSG_setGeolocationEnabled, Boolean.valueOf(z));
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getJavaScriptEnabled() : this.mSysWebSettings.getJavaScriptEnabled();
    }

    public synchronized PluginState getPluginState() {
        PluginState pluginState;
        try {
            if (this.mZeusWebSettings != null) {
                switch ($SWITCH_TABLE$com$baidu$zeus$WebSettings$PluginState()[this.mZeusWebSettings.getPluginState().ordinal()]) {
                    case 1:
                        pluginState = PluginState.ON;
                        break;
                    case 2:
                        pluginState = PluginState.ON_DEMAND;
                        break;
                    case 3:
                        pluginState = PluginState.OFF;
                        break;
                    default:
                        pluginState = PluginState.ON;
                        break;
                }
            } else {
                switch ($SWITCH_TABLE$android$webkit$WebSettings$PluginState()[this.mSysWebSettings.getPluginState().ordinal()]) {
                    case 1:
                        pluginState = PluginState.ON;
                        break;
                    case 2:
                        pluginState = PluginState.ON_DEMAND;
                        break;
                    case 3:
                        pluginState = PluginState.OFF;
                        break;
                    default:
                        pluginState = PluginState.ON;
                        break;
                }
            }
        } catch (Exception e) {
            pluginState = null;
            return pluginState;
        } catch (NoSuchMethodError e2) {
            pluginState = null;
            return pluginState;
        }
        return pluginState;
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        } else {
            this.mSysWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
        notifyObservers(MSG_setJavaScriptCanOpenWindowsAutomatically, Boolean.valueOf(z));
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getJavaScriptCanOpenWindowsAutomatically() : this.mSysWebSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setDefaultTextEncodingName(str);
        } else {
            this.mSysWebSettings.setDefaultTextEncodingName(str);
        }
        notifyObservers(MSG_setDefaultTextEncodingName, str);
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getDefaultTextEncodingName() : this.mSysWebSettings.getDefaultTextEncodingName();
    }

    public synchronized void setUserAgentString(String str) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUserAgentString(str);
        } else {
            this.mSysWebSettings.setUserAgentString(str);
        }
        notifyObservers(MSG_setUserAgentString, str);
    }

    public synchronized String getUserAgentString() {
        return this.mZeusWebSettings != null ? this.mZeusWebSettings.getUserAgentString() : this.mSysWebSettings.getUserAgentString();
    }

    public void setNeedInitialFocus(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setNeedInitialFocus(z);
        } else {
            this.mSysWebSettings.setNeedInitialFocus(z);
        }
        this.mNeedInitialFocus = z;
        notifyObservers(MSG_setNeedInitialFocus, Boolean.valueOf(z));
    }

    public synchronized void setRenderPriority(RenderPriority renderPriority) {
        switch ($SWITCH_TABLE$com$baidu$browser$webkit$BdWebSettings$RenderPriority()[renderPriority.ordinal()]) {
            case 1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
                    break;
                }
            case 2:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                    break;
                } else {
                    this.mSysWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                    break;
                }
            case 3:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setRenderPriority(WebSettings.RenderPriority.LOW);
                    break;
                } else {
                    this.mSysWebSettings.setRenderPriority(WebSettings.RenderPriority.LOW);
                    break;
                }
            default:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
                    break;
                } else {
                    this.mSysWebSettings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
                    break;
                }
        }
        this.mRenderPriority = renderPriority;
        notifyObservers(MSG_setRenderPriority, renderPriority);
    }

    public void setCacheMode(int i) {
        switch (i) {
            case -1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(-1);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(-1);
                    break;
                }
            case 0:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(0);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(0);
                    break;
                }
            case 1:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(1);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(1);
                    break;
                }
            case 2:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(2);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(2);
                    break;
                }
            case 3:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(3);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(3);
                    break;
                }
            default:
                if (this.mZeusWebSettings != null) {
                    this.mZeusWebSettings.setCacheMode(-1);
                    break;
                } else {
                    this.mSysWebSettings.setCacheMode(-1);
                    break;
                }
        }
        notifyObservers(MSG_setCacheMode, Integer.valueOf(i));
    }

    public int getCacheMode() {
        if (this.mZeusWebSettings != null) {
            switch (this.mZeusWebSettings.getCacheMode()) {
                case -1:
                default:
                    return -1;
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
            }
        }
        switch (this.mSysWebSettings.getCacheMode()) {
            case -1:
            default:
                return -1;
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    public void setWorkersEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setWorkersEnabled(z);
        } else {
            this.mSysWebSettings.setWorkersEnabled(z);
        }
        this.mWorkersEnabled = z;
        notifyObservers(MSG_setWorkersEnabled, Boolean.valueOf(z));
    }

    public void setPageCacheCapacity(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setPageCacheCapacity(i);
        } else {
            this.mSysWebSettings.setPageCacheCapacity(i);
        }
        this.mPageCacheCapacity = i;
        notifyObservers(MSG_setPageCacheCapacity, Integer.valueOf(i));
    }

    public void setUseImageLoadProxy(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseImageLoadProxy(z);
        }
        notifyObservers(MSG_setUseImageLoadProxy, Boolean.valueOf(z));
    }

    public boolean getUseImageLoadProxy() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getUseImageLoadProxy();
        }
        return false;
    }

    public void setUseUnderLine(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseUnderLine(z);
        }
        notifyObservers(MSG_setUseUnderLine, Boolean.valueOf(z));
    }

    public boolean getUseUnderLine() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getUseUnderLine();
        }
        return false;
    }

    public void setUseGifLoadProxy(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseGifLoadProxy(z);
        }
        notifyObservers(MSG_setUseGifLoadProxy, Boolean.valueOf(z));
    }

    public boolean getUseGifLoadProxy() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getUseGifLoadProxy();
        }
        return false;
    }

    public void setEnableVideo(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setEnableVideo(z);
        }
        notifyObservers(MSG_setEnableVideo, Boolean.valueOf(z));
    }

    public boolean getEnableVideo() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getEnableVideo();
        }
        return false;
    }

    public void setUseScaleStore(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseScaleStore(z);
        }
        notifyObservers(MSG_setUseScaleStore, Boolean.valueOf(z));
    }

    public boolean getUseScaleStore() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getUseScaleStore();
        }
        return false;
    }

    public void setUseGLRendering(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setUseGLRendering(z);
        }
        notifyObservers(MSG_setUseGLRendering, Boolean.valueOf(z));
    }

    public boolean getUseGLRendering() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getUseGLRendering();
        }
        return false;
    }

    public void setPreloadEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setPreloadEnabled(z);
        }
        notifyObservers(MSG_setPreloadEnabled, Boolean.valueOf(z));
    }

    public boolean getPreloadEnabled() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getPreloadEnabled();
        }
        return false;
    }

    public void setNightModeEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setNightModeEnabled(z);
        }
        notifyObservers(MSG_setNightModeEnabled, Boolean.valueOf(z));
    }

    public boolean getNightModeEnabled() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getNightModeEnabled();
        }
        return false;
    }

    public void setMarkSubjectEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setMarkSubjectEnabled(z);
        }
        notifyObservers(MSG_setMarkSubjectEnabled, Boolean.valueOf(z));
    }

    public boolean getMarkSubjectEnabled() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getMarkSubjectEnabled();
        }
        return false;
    }

    public void setCollectMainAction(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setCollectMainAction(z);
        }
        notifyObservers(MSG_setCollectMainAction, Boolean.valueOf(z));
    }

    public boolean getCollectMainAction() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getCollectMainAction();
        }
        return false;
    }

    public void setImageMaxWidth(int i) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setImageMaxWidth(i);
        }
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setShrinksStandaloneImagesToFit(z);
        }
    }

    public void setForcePageCanBeScaled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setForcePageCanBeScaled(z);
        }
    }

    public boolean getForcePageCanBeScaled() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getForcePageCanBeScaled();
        }
        return false;
    }

    public void setEnableFlashFullScreenMode(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setEnableFlashFullScreenMode(z);
        }
    }

    public boolean getEnableFlashFullScreenMode() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getEnableFlashFullScreenMode();
        }
        return false;
    }

    public void setPauseAudioEnabled(boolean z) {
        if (this.mZeusWebSettings != null) {
            this.mZeusWebSettings.setPauseAudioEnabled(z);
        }
    }

    public boolean getPauseAudioEnabled() {
        if (this.mZeusWebSettings != null) {
            return this.mZeusWebSettings.getPauseAudioEnabled();
        }
        return false;
    }

    private void notifyObservers(int i, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        setChanged();
        notifyObservers(obtain);
        obtain.recycle();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Message message = (Message) obj;
        switch (message.what) {
            case 1:
                setNavDump(((Boolean) message.obj).booleanValue());
                return;
            case 2:
                setSupportZoom(((Boolean) message.obj).booleanValue());
                return;
            case 3:
                setBuiltInZoomControls(((Boolean) message.obj).booleanValue());
                return;
            case 4:
                setAllowFileAccess(((Boolean) message.obj).booleanValue());
                return;
            case 5:
                setLoadWithOverviewMode(((Boolean) message.obj).booleanValue());
                return;
            case 6:
                setSaveFormData(((Boolean) message.obj).booleanValue());
                return;
            case 7:
                setSavePassword(((Boolean) message.obj).booleanValue());
                return;
            case 8:
                setTextSize((TextSize) message.obj);
                return;
            case 9:
                setDefaultZoom((ZoomDensity) message.obj);
                return;
            case 10:
                setLightTouchEnabled(((Boolean) message.obj).booleanValue());
                return;
            case 11:
                setUseWideViewPort(((Boolean) message.obj).booleanValue());
                return;
            case 12:
                setSupportMultipleWindows(((Boolean) message.obj).booleanValue());
                return;
            case 13:
                setLayoutAlgorithm((LayoutAlgorithm) message.obj);
                return;
            case 14:
                setStandardFontFamily((String) message.obj);
                return;
            case 15:
                setFixedFontFamily((String) message.obj);
                return;
            case 16:
                setSansSerifFontFamily((String) message.obj);
                return;
            case 17:
                setSerifFontFamily((String) message.obj);
                return;
            case 18:
                setCursiveFontFamily((String) message.obj);
                return;
            case 19:
                setFantasyFontFamily((String) message.obj);
                return;
            case 20:
                setMinimumFontSize(((Integer) message.obj).intValue());
                return;
            case 21:
                setMinimumLogicalFontSize(((Integer) message.obj).intValue());
                return;
            case 22:
                setDefaultFontSize(((Integer) message.obj).intValue());
                return;
            case 23:
                setDefaultFixedFontSize(((Integer) message.obj).intValue());
                return;
            case 24:
                setLoadsImagesAutomatically(((Boolean) message.obj).booleanValue());
                return;
            case 25:
                setBlockNetworkImage(((Boolean) message.obj).booleanValue());
                return;
            case 26:
                setBlockNetworkLoads(((Boolean) message.obj).booleanValue());
                return;
            case 27:
                setJavaScriptEnabled(((Boolean) message.obj).booleanValue());
                return;
            case 28:
                setPluginState((PluginState) message.obj);
                return;
            case MSG_setDatabasePath /* 29 */:
                setDatabasePath((String) message.obj);
                return;
            case 30:
                setGeolocationDatabasePath((String) message.obj);
                return;
            case MSG_setAppCacheEnabled /* 31 */:
                setAppCacheEnabled(((Boolean) message.obj).booleanValue());
                return;
            case 32:
                setAppCachePath((String) message.obj);
                return;
            case MSG_setAppCacheMaxSize /* 33 */:
                setAppCacheMaxSize(((Long) message.obj).longValue());
                return;
            case MSG_setDatabaseEnabled /* 34 */:
                setDatabaseEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setDomStorageEnabled /* 35 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setGeolocationEnabled /* 36 */:
                setGeolocationEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setJavaScriptCanOpenWindowsAutomatically /* 37 */:
                setJavaScriptCanOpenWindowsAutomatically(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setDefaultTextEncodingName /* 38 */:
                setDefaultTextEncodingName((String) message.obj);
                return;
            case MSG_setUserAgentString /* 39 */:
                setUserAgentString((String) message.obj);
                return;
            case MSG_setNeedInitialFocus /* 40 */:
                setNeedInitialFocus(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setRenderPriority /* 41 */:
                setRenderPriority((RenderPriority) message.obj);
                return;
            case MSG_setCacheMode /* 42 */:
                setCacheMode(((Integer) message.obj).intValue());
                return;
            case MSG_setUseGLRendering /* 43 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setUseImageLoadProxy /* 44 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setUseUnderLine /* 45 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setUseGifLoadProxy /* 46 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setEnableVideo /* 47 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setUseScaleStore /* 48 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setPreloadEnabled /* 49 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setNightModeEnabled /* 50 */:
                setDomStorageEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setWorkersEnabled /* 51 */:
                setWorkersEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setPageCacheCapacity /* 52 */:
                setPageCacheCapacity(((Integer) message.obj).intValue());
                return;
            case MSG_setMarkSubjectEnabled /* 53 */:
                setMarkSubjectEnabled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setCollectMainAction /* 54 */:
                setCollectMainAction(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setImageMaxWidth /* 55 */:
                setImageMaxWidth(((Integer) message.obj).intValue());
                return;
            case MSG_setShrinksStandaloneImagesToFit /* 56 */:
                setShrinksStandaloneImagesToFit(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setForcePageCanBeScaled /* 57 */:
                setForcePageCanBeScaled(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setEnableFlashFullScreenMode /* 58 */:
                setEnableFlashFullScreenMode(((Boolean) message.obj).booleanValue());
                return;
            case MSG_setPauseAudioEnabled /* 59 */:
                setPauseAudioEnabled(((Boolean) message.obj).booleanValue());
                return;
            default:
                return;
        }
    }
}
