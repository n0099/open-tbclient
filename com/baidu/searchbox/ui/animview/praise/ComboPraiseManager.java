package com.baidu.searchbox.ui.animview.praise;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseConfig;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.PraiseInteractGuideRuntime;
import com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import com.baidu.searchbox.ui.animview.praise.view.IPraiseStatusListener;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import java.util.ArrayDeque;
/* loaded from: classes13.dex */
public class ComboPraiseManager {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final int INTERCEPT_MODE_DEFAULT = 0;
    public static final int INTERCEPT_MODE_DISABLE = 0;
    public static final int INTERCEPT_MODE_ENABLE = 1;
    public static final int INTERCEPT_MODE_IGNORE = 2;
    private static final int LONG_PRESS_TIME_MS = 300;
    private static final int MOTIONEVENT_DOWN = 0;
    private static final int MOTIONEVENT_UP = 1;
    private static final String PRAISE_SOURCE_PREFIX_H5 = "h5";
    private static final String PRAISE_SOURCE_PREFIX_HN = "hn";
    private static final String PRAISE_SOURCE_PREFIX_NA = "na";
    private static final String PRAISE_SOURCE_SEPARATE = "_";
    private static final String SEARCH_BAR_NAME_H5_FEEDNEWS = "LightBrowserView";
    private static final String SEARCH_BAR_NAME_H5_WENDA = "SimpleFloatSearchBoxLayout";
    private static final String SEARCH_BAR_NAME_HN_BIG = "HomeHeaderLayout";
    private static final String SEARCH_BAR_NAME_HN_FEED_TAB_LAYOUT = "FeedTabLayout";
    private static final String SEARCH_BAR_NAME_HN_SMALL = "SearchBoxViewHome";
    private static final String SEARCH_BAR_NAME_HOME_BACKGROUND = "HomeBackground";
    private static final String TAG = "ComboPraiseManager";
    private ComboPraiseView mComboPraiseView;
    private Activity mCtx;
    private IExPraiseAnimListener mExAnimListener;
    private IPraiseManagerCallback mICallback;
    private boolean mInterceptTouchEvent;
    private boolean mIsH5OrHNCall;
    private boolean mIsNAOrWebCall;
    private boolean mIsPopupWindowShowing;
    private boolean mLastNetworkEnable;
    private IResourceProvider mLastProvider;
    private NetworkMonitor mNetworkMonitor;
    private PopupWindow mPopupWindow;
    private View mWindowTokenView;
    private ComboPraiseConfig mPraiseConfig = new ComboPraiseConfig();
    private TouchListener mTouchListener = new TouchListener();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes13.dex */
    public interface NotifyPraiseAnimCallBack {
        void notifyPraiseAnimStatus(boolean z);
    }

    public ComboPraiseManager(Activity activity, String str) {
        this.mCtx = activity;
        this.mNetworkMonitor = new NetworkMonitor(this.mCtx);
        this.mNetworkMonitor.setNetworkMonitorCb(new NetworkMonitor.INetworkMonitorCb() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.1
            @Override // com.baidu.searchbox.ui.animview.praise.NetworkMonitor.INetworkMonitorCb
            public void onNetworkStateChanged() {
                if (!ComboPraiseManager.this.mIsNAOrWebCall && ComboPraiseManager.this.mLastNetworkEnable && !ComboPraiseManager.this.mNetworkMonitor.isNetworkEnable()) {
                    if (ComboPraiseManager.DEBUG) {
                        Log.d(ComboPraiseManager.TAG, "The current is web call, and network has changed to be not connected");
                    }
                    ComboPraiseManager.this.mMainHandler.removeCallbacksAndMessages(null);
                }
            }
        });
        setPraiseSource(str);
        initWindowTokenView();
        updatePraiseResourceIfNeeded();
    }

    private void initWindowTokenView() {
        if (this.mCtx == null) {
            this.mWindowTokenView = null;
        } else {
            this.mWindowTokenView = this.mCtx.getWindow().getDecorView();
        }
    }

    private void updatePraiseResourceIfNeeded() {
        IResourceProvider provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL);
        if (this.mLastProvider != provider) {
            getPraiseView().setProvider(provider);
            this.mLastProvider = provider;
        }
    }

    public ComboPraiseManager setPraiseManagerCallback(IPraiseManagerCallback iPraiseManagerCallback) {
        this.mICallback = iPraiseManagerCallback;
        return this;
    }

    private void updateByCallbackIfNeeded() {
        if (this.mICallback != null) {
            if (this.mICallback.getAnchorLeft() >= 0) {
                setLeft(this.mICallback.getAnchorLeft());
            }
            if (this.mICallback.getAnchorTop() >= 0) {
                setTop(this.mICallback.getAnchorTop());
            }
            if (this.mICallback.getAnchorWidth() > 0) {
                setWidth(this.mICallback.getAnchorWidth());
            }
            if (this.mICallback.getAnchorHeight() > 0) {
                setHeight(this.mICallback.getAnchorHeight());
            }
            if (!TextUtils.isEmpty(this.mICallback.getPraiseSource())) {
                setPraiseSource(this.mICallback.getPraiseSource());
            }
            if (!TextUtils.isEmpty(this.mICallback.getPraiseId())) {
                setPraiseId(this.mICallback.getPraiseId());
            }
        }
    }

    public void cancelAnimForced() {
        this.mTouchListener.cancelAnimForced(null);
    }

    public boolean isAnimationRunning() {
        return getPraiseView().isAnimationRunning();
    }

    public ComboPraiseManager setLeft(int i) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mBaseRect.left = i;
        }
        return this;
    }

    public ComboPraiseManager setTop(int i) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mBaseRect.top = i;
        }
        return this;
    }

    public ComboPraiseManager setWidth(int i) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mBaseRect.right = this.mPraiseConfig.mBaseRect.left + i;
        }
        return this;
    }

    public ComboPraiseManager setHeight(int i) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mBaseRect.bottom = this.mPraiseConfig.mBaseRect.top + i;
        }
        return this;
    }

    public ComboPraiseManager setUBCParams(ComboPraiseUBC comboPraiseUBC) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mUBC = comboPraiseUBC;
        }
        return this;
    }

    public ComboPraiseManager setPraiseSource(String str) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mPraiseSource = TextUtils.isEmpty(str) ? "" : str.toLowerCase();
            parsePraiseSource();
        }
        return this;
    }

    private void parsePraiseSource() {
        if (this.mPraiseConfig == null) {
            this.mIsNAOrWebCall = true;
            return;
        }
        boolean[] zArr = new boolean[2];
        parsePraiseSource(this.mPraiseConfig.mPraiseSource, zArr);
        this.mIsNAOrWebCall = zArr[0];
        this.mIsH5OrHNCall = zArr[1];
        if (DEBUG) {
            Log.d(TAG, "IsNAOrWebCall:" + this.mIsNAOrWebCall + ", IsH5OrHNCall:" + this.mIsH5OrHNCall);
        }
    }

    private static void parsePraiseSource(String str, boolean[] zArr) {
        if (TextUtils.isEmpty(str) || zArr == null || zArr.length != 2) {
            if (zArr != null) {
                zArr[0] = true;
                return;
            }
            return;
        }
        int indexOf = str.indexOf("_");
        if (indexOf == -1) {
            zArr[0] = true;
            return;
        }
        String substring = str.substring(0, indexOf);
        str.substring(indexOf + 1);
        if (TextUtils.isEmpty(substring)) {
            zArr[0] = true;
        } else if (substring.equalsIgnoreCase("h5")) {
            zArr[0] = false;
            zArr[1] = true;
        } else if (substring.equalsIgnoreCase("hn")) {
            zArr[0] = false;
            zArr[1] = false;
        } else {
            zArr[0] = true;
        }
    }

    public ComboPraiseManager setPraiseId(String str) {
        if (!getPraiseView().isAnimationRunning()) {
            this.mPraiseConfig.mPraiseId = TextUtils.isEmpty(str) ? "" : str.toLowerCase();
        }
        return this;
    }

    public static boolean isPraiseEnabled(String str) {
        if (!PraiseResourceAPSManager.getInstance().hasValidProvider()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, PraiseResourceAPSManager does not have ValidProvider");
                return false;
            }
            return false;
        } else if (ComboPraiseRuntime.getContext() != null && !ComboPraiseRuntime.getContext().getPraiseSwitchState()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, ComboPraiseRuntime is null or PraiseSwitchState is false");
                return false;
            }
            return false;
        } else if (PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL) == null) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, PraiseResourceAPSManager getProvider failed");
                return false;
            }
            return false;
        } else if (Build.VERSION.SDK_INT <= 21 && TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED)) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, praiseSource = na_feed, Build.VERSION.SDK_INT = 21");
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean isPraiseEnabled() {
        return isPraiseEnabled(this.mPraiseConfig.mPraiseSource);
    }

    public ComboPraiseManager setPraiseAnimListener(IExPraiseAnimListener iExPraiseAnimListener) {
        this.mExAnimListener = iExPraiseAnimListener;
        return this;
    }

    private void setInterceptTouchEvent(int i) {
        if (i == 2) {
            i = 0;
        }
        this.mInterceptTouchEvent = i == 1;
    }

    public ComboPraiseManager setInterceptModeForNA() {
        if (!getPraiseView().isAnimationRunning()) {
            setInterceptTouchEvent(2);
        }
        return this;
    }

    public ComboPraiseManager setInterceptModeForWeb(int i) {
        if (!getPraiseView().isAnimationRunning()) {
            setInterceptTouchEvent(i);
        }
        return this;
    }

    public void onTouchForNA(MotionEvent motionEvent) {
        if (!isPraiseEnabled()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false");
                return;
            }
            return;
        }
        this.mIsNAOrWebCall = true;
        updatePraiseResourceIfNeeded();
        if (enableInterceptionForNA()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mTouchListener.setInterceptMode(true);
                    this.mTouchListener.setWebMode(false);
                    this.mTouchListener.handleDownEventForInterceptionNA(motionEvent, true);
                    return;
                case 1:
                case 3:
                    this.mTouchListener.onTouch(null, motionEvent);
                    return;
                case 2:
                    this.mTouchListener.onTouch(null, motionEvent);
                    return;
                default:
                    return;
            }
        }
        onTouch(motionEvent, true);
    }

    private boolean enableInterceptionForNA() {
        if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_LIST)) {
            this.mInterceptTouchEvent = true;
            return true;
        } else if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_LIST)) {
            this.mInterceptTouchEvent = true;
            return true;
        } else if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HEADER)) {
            this.mInterceptTouchEvent = true;
            return true;
        } else if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_COMMENT_DETAIL_HOT)) {
            this.mInterceptTouchEvent = true;
            return true;
        } else if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED)) {
            this.mInterceptTouchEvent = true;
            return true;
        } else {
            return false;
        }
    }

    public void onTouchForWeb(int i) {
        if (!isPraiseEnabled()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false");
                return;
            }
            return;
        }
        this.mIsNAOrWebCall = false;
        updatePraiseResourceIfNeeded();
        MotionEvent motionEvent = null;
        switch (i) {
            case 0:
                motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
                break;
            case 1:
                motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
                break;
        }
        if (motionEvent != null) {
            if (this.mInterceptTouchEvent) {
                onTouch(false);
            } else {
                onTouch(motionEvent, false);
            }
            motionEvent.recycle();
        }
    }

    private boolean disableNoInterceptionForWeb() {
        return !TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST);
    }

    private void onTouch(MotionEvent motionEvent, boolean z) {
        if (!this.mInterceptTouchEvent) {
            if (z) {
                this.mTouchListener.setWebMode(false);
                this.mTouchListener.setInterceptMode(false);
                this.mTouchListener.onTouch(null, motionEvent);
            } else if (!disableNoInterceptionForWeb()) {
                this.mTouchListener.setWebMode(true);
                this.mTouchListener.setInterceptMode(false);
                this.mTouchListener.onTouch(null, motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouch(boolean z) {
        if (this.mInterceptTouchEvent) {
            this.mTouchListener.setInterceptMode(true);
            this.mTouchListener.setWebMode(z ? false : true);
            if (!z) {
                this.mTouchListener.autoCancelIfNeeded(null);
            }
            configPopupWindow();
            runTaskWhenFirstShow(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ComboPraiseManager.this.getPraiseView().click();
                }
            });
            show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskWhenFirstShow(final Runnable runnable) {
        if (runnable != null && getPraiseView() != null) {
            getPraiseView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ComboPraiseManager.this.getPraiseView().getViewTreeObserver().removeOnPreDrawListener(this);
                    ComboPraiseManager.this.mMainHandler.postDelayed(runnable, 350L);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPopupWindowShowing() {
        if (this.mPopupWindow == null) {
            return false;
        }
        return this.mIsPopupWindowShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class TouchListener implements View.OnTouchListener {
        private static final int CANCEL_PRAISE_MS = 1000;
        private static final int MOCK_CLICK_INTERVAL_TIME_MS = 100;
        private static final int PREVENT_CALL_FROM_CLICK = 0;
        private static final int PREVENT_CALL_FROM_LONGPRESS = 1;
        private static final int PREVENT_CALL_FROM_MOVE = 2;
        private static final int VALID_CLICK_RECT_HEIGHT_DP = 61;
        private static final int VALID_CLICK_RECT_WIDTH_DP = 61;
        private boolean mBeyondSectionForNA;
        private boolean mCallFromOuter;
        private boolean mCancelAnimForced;
        private boolean mInterceptMode;
        private boolean mIsLongPress;
        private boolean mIsNAFirstDown;
        private boolean mIsWebMode;
        private long mLastDownTimeMs;
        private int mLastXForNA;
        private int mLastYForNA;
        private Runnable mLongClick;
        private Runnable mMockClick;
        private boolean mUnlimitedCreateRectForWeb;
        private Rect mValidClickRectForNA;

        private TouchListener() {
            this.mMockClick = new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ComboPraiseManager.this.getPraiseView().click();
                    ComboPraiseManager.this.mMainHandler.postDelayed(TouchListener.this.mMockClick, 100L);
                }
            };
            this.mLongClick = new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!TouchListener.this.performAnimPrevented(1)) {
                        if (TouchListener.this.mCallFromOuter) {
                            ComboPraiseManager.this.onTouch(true);
                        }
                        TouchListener.this.mIsLongPress = true;
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(TouchListener.this.mMockClick);
                        ComboPraiseManager.this.mMainHandler.post(TouchListener.this.mMockClick);
                    }
                }
            };
        }

        public void setWebMode(boolean z) {
            this.mIsWebMode = z;
            if (this.mIsWebMode) {
                this.mUnlimitedCreateRectForWeb = true;
            }
        }

        public void setInterceptMode(boolean z) {
            this.mInterceptMode = z;
        }

        private void createValidClickRectForNA(MotionEvent motionEvent) {
            if (!ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                createValidClickRect(motionEvent);
            }
        }

        private void createValidClickRectForWeb(MotionEvent motionEvent) {
            if (this.mUnlimitedCreateRectForWeb || !ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                createValidClickRect(motionEvent);
                this.mUnlimitedCreateRectForWeb = false;
            }
        }

        private void createValidClickRect(MotionEvent motionEvent) {
            int rawX;
            int rawY;
            int dp2px = DeviceUtil.ScreenInfo.dp2px(ComboPraiseManager.this.mCtx, 61.0f);
            int dp2px2 = DeviceUtil.ScreenInfo.dp2px(ComboPraiseManager.this.mCtx, 61.0f);
            if (this.mIsWebMode && this.mInterceptMode) {
                rawX = ComboPraiseManager.this.mPraiseConfig.mBaseRect.centerX();
                rawY = ComboPraiseManager.this.mPraiseConfig.mBaseRect.centerY();
            } else {
                rawX = (int) motionEvent.getRawX();
                rawY = (int) motionEvent.getRawY();
            }
            this.mCancelAnimForced = false;
            this.mBeyondSectionForNA = false;
            this.mValidClickRectForNA = new Rect((int) ((rawX - (dp2px / 2)) + 0.5f), (int) ((rawY - (dp2px2 / 2)) + 0.5f), (int) (rawX + (dp2px / 2) + 0.5f), (int) (rawY + (dp2px2 / 2) + 0.5f));
            if (ComboPraiseManager.DEBUG) {
                Log.d(ComboPraiseManager.TAG, "mValidClickRectForNA: " + this.mValidClickRectForNA.toShortString());
            }
        }

        private void updateBeyondStateForNA(MotionEvent motionEvent) {
            if (!this.mBeyondSectionForNA) {
                if (this.mValidClickRectForNA == null || motionEvent == null) {
                    this.mBeyondSectionForNA = false;
                    return;
                }
                this.mLastXForNA = (int) motionEvent.getRawX();
                this.mLastYForNA = (int) motionEvent.getRawY();
                this.mBeyondSectionForNA = this.mValidClickRectForNA.contains(this.mLastXForNA, this.mLastYForNA) ? false : true;
                if (ComboPraiseManager.DEBUG) {
                    Log.d(ComboPraiseManager.TAG, "x=" + this.mLastXForNA + ", y=" + this.mLastYForNA + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelAnimForced(MotionEvent motionEvent) {
            if (PraiseEnvironment.isCancelPraiseEnabled(ComboPraiseManager.this.mPraiseConfig.mPraiseSource) && ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                if (motionEvent != null && this.mValidClickRectForNA != null) {
                    if (!this.mValidClickRectForNA.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        if (ComboPraiseManager.DEBUG) {
                            Log.d(ComboPraiseManager.TAG, "outOfBound, PraiseAnim will not be cancelled, x=" + motionEvent.getRawX() + ", y=" + motionEvent.getRawY() + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString());
                            return;
                        }
                        return;
                    }
                }
                if (ComboPraiseManager.DEBUG) {
                    Log.d(ComboPraiseManager.TAG, "PraiseAnim cancelled");
                }
                this.mBeyondSectionForNA = true;
                this.mCancelAnimForced = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void autoCancelIfNeeded(MotionEvent motionEvent) {
            if (PraiseEnvironment.isCancelPraiseEnabled(ComboPraiseManager.this.mPraiseConfig.mPraiseSource)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (ComboPraiseManager.this.isAnimationRunning() && currentTimeMillis - this.mLastDownTimeMs > 1000) {
                    cancelAnimForced(motionEvent);
                }
                this.mLastDownTimeMs = currentTimeMillis;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean performAnimPrevented(int i) {
            if (this.mBeyondSectionForNA) {
                if (ComboPraiseManager.DEBUG) {
                    if (!this.mCancelAnimForced) {
                        Log.d(ComboPraiseManager.TAG, "out of valid bound");
                    } else {
                        Log.d(ComboPraiseManager.TAG, "force cancel anim");
                    }
                }
                if (i == 1) {
                    this.mIsLongPress = true;
                } else if (i == 0) {
                    ComboPraiseManager.this.getPraiseView().setClickBlock(true);
                } else if (this.mIsLongPress) {
                    return false;
                }
                if (ComboPraiseManager.this.mExAnimListener != null) {
                    ComboPraiseManager.this.mExAnimListener.onPraiseAnimPrevented(this.mCancelAnimForced ? 1 : 0);
                }
                if (!ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                    ComboPraiseManager.this.dismiss();
                }
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void performPraiseClickIfNeeded() {
            if (!performAnimPrevented(0)) {
                ComboPraiseManager.this.getPraiseView().click();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.mIsWebMode) {
                if (this.mInterceptMode) {
                    return processInterceptionForNA(motionEvent);
                }
                return processNoInterceptionForNA(motionEvent);
            } else if (this.mInterceptMode) {
                return processInterceptionForWeb(motionEvent);
            } else {
                return processNoInterceptionForWeb(motionEvent);
            }
        }

        public void handleDownEventForInterceptionNA(MotionEvent motionEvent, boolean z) {
            if (motionEvent.getAction() == 0) {
                createValidClickRectForNA(motionEvent);
                autoCancelIfNeeded(motionEvent);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                this.mIsLongPress = false;
                this.mCallFromOuter = z;
                ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, 300L);
            }
        }

        private boolean processInterceptionForNA(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    handleDownEventForInterceptionNA(motionEvent, false);
                    break;
                case 1:
                case 3:
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                        break;
                    } else if (motionEvent.getAction() == 3) {
                        this.mCallFromOuter = false;
                        if (ComboPraiseManager.DEBUG) {
                            Log.d(ComboPraiseManager.TAG, "cancel praise animation");
                            break;
                        }
                    } else if (this.mCallFromOuter) {
                        if (!this.mBeyondSectionForNA) {
                            ComboPraiseManager.this.onTouch(true);
                        } else if (ComboPraiseManager.DEBUG) {
                            Log.d(ComboPraiseManager.TAG, "out of valid bound");
                        }
                        this.mCallFromOuter = false;
                        break;
                    } else {
                        performPraiseClickIfNeeded();
                        break;
                    }
                    break;
                case 2:
                    updateBeyondStateForNA(motionEvent);
                    if (performAnimPrevented(2)) {
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        break;
                    }
                    break;
            }
            return false;
        }

        private boolean processInterceptionForWeb(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    createValidClickRectForWeb(motionEvent);
                    autoCancelIfNeeded(motionEvent);
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                    this.mIsLongPress = false;
                    ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, 300L);
                    break;
                case 1:
                case 3:
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                        break;
                    } else {
                        performPraiseClickIfNeeded();
                        break;
                    }
                case 2:
                    updateBeyondStateForNA(motionEvent);
                    if (performAnimPrevented(2)) {
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        break;
                    }
                    break;
            }
            return false;
        }

        private boolean processNoInterceptionForNA(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    createValidClickRectForNA(motionEvent);
                    autoCancelIfNeeded(motionEvent);
                    ComboPraiseManager.this.mMainHandler.removeCallbacksAndMessages(null);
                    this.mIsLongPress = false;
                    this.mIsNAFirstDown = false;
                    if (!ComboPraiseManager.this.isPopupWindowShowing()) {
                        ComboPraiseManager.this.configPopupWindow();
                        ComboPraiseManager.this.show();
                        this.mIsNAFirstDown = true;
                        ComboPraiseManager.this.runTaskWhenFirstShow(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!TouchListener.this.mIsLongPress) {
                                    TouchListener.this.performPraiseClickIfNeeded();
                                }
                            }
                        });
                    }
                    ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, 300L);
                    break;
                case 1:
                case 3:
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                        break;
                    } else if (motionEvent.getAction() == 3) {
                        if (ComboPraiseManager.DEBUG) {
                            Log.d(ComboPraiseManager.TAG, "cancel praise animation");
                            break;
                        }
                    } else if (this.mIsNAFirstDown) {
                        this.mIsNAFirstDown = false;
                        break;
                    } else {
                        performPraiseClickIfNeeded();
                        break;
                    }
                    break;
                case 2:
                    updateBeyondStateForNA(motionEvent);
                    if (performAnimPrevented(2)) {
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        break;
                    }
                    break;
            }
            return false;
        }

        private boolean processNoInterceptionForWeb(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (!ComboPraiseManager.this.isPopupWindowShowing()) {
                        ComboPraiseManager.this.configPopupWindow();
                        ComboPraiseManager.this.show();
                    }
                    ComboPraiseManager.this.mMainHandler.removeCallbacksAndMessages(null);
                    ComboPraiseManager.this.mMainHandler.post(this.mMockClick);
                    return false;
                case 1:
                case 3:
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    return false;
                case 2:
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComboPraiseView getPraiseView() {
        if (this.mComboPraiseView == null) {
            this.mComboPraiseView = new ComboPraiseView(this.mCtx);
            this.mComboPraiseView.addPraiseAnimListener(new IPraiseAnimListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.4
                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                public void onPraiseAnimStart() {
                    if (ComboPraiseManager.this.mExAnimListener != null) {
                        ComboPraiseManager.this.mExAnimListener.onPraiseAnimStart();
                    }
                    if (!ComboPraiseManager.this.mIsNAOrWebCall && ComboPraiseRuntime.getContext() != null) {
                        ComboPraiseRuntime.getContext().notifyPraiseAnimationEvent(ComboPraiseManager.this.mCtx, ComboPraiseManager.this.mPraiseConfig.mPraiseId, "0");
                        ComboPraiseManager.this.mNetworkMonitor.init();
                        ComboPraiseManager.this.mLastNetworkEnable = ComboPraiseManager.this.mNetworkMonitor.isNetworkEnable();
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                public void onPraiseAnimEnd() {
                    ComboPraiseManager.this.dismiss();
                }
            });
            this.mComboPraiseView.addPraiseStatusListener(new IPraiseStatusListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.5
                @Override // com.baidu.searchbox.ui.animview.praise.view.IPraiseStatusListener
                public void onTargetPraiseCntReached(int i, String str, String str2, String str3) {
                    if (ComboPraiseRuntime.getContext() != null) {
                        NotifyPraiseAnimCallBack notifyPraiseAnimCallBack = new NotifyPraiseAnimCallBack() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.5.1
                            @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.NotifyPraiseAnimCallBack
                            public void notifyPraiseAnimStatus(boolean z) {
                                ComboPraiseManager.this.notifyPraiseAnimStatus(z);
                            }
                        };
                        if (PraiseInteractGuideRuntime.getContext() != null) {
                            PraiseInteractGuideRuntime.getContext().guideLuckMoney(ComboPraiseManager.this.mCtx, str, str2, str3, notifyPraiseAnimCallBack);
                        }
                    }
                }
            });
        }
        return this.mComboPraiseView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.mWindowTokenView != null && this.mPopupWindow != null && !this.mIsPopupWindowShowing && this.mCtx != null && !this.mCtx.isFinishing()) {
            this.mPopupWindow.showAtLocation(this.mWindowTokenView, 17, 0, 0);
            this.mIsPopupWindowShowing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        if (this.mPopupWindow != null && this.mIsPopupWindowShowing && this.mCtx != null) {
            if (!this.mCtx.isFinishing()) {
                this.mPopupWindow.dismiss();
            }
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mIsPopupWindowShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configPopupWindow() {
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow((View) getPraiseView(), -1, -1, false);
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.6
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (ComboPraiseManager.this.mExAnimListener != null) {
                        ComboPraiseManager.this.mExAnimListener.onPraiseAnimEnd();
                    }
                    if (!ComboPraiseManager.this.mIsNAOrWebCall && ComboPraiseRuntime.getContext() != null) {
                        ComboPraiseRuntime.getContext().notifyPraiseAnimationEvent(ComboPraiseManager.this.mCtx, ComboPraiseManager.this.mPraiseConfig.mPraiseId, ComboPraiseManager.this.mTouchListener.mCancelAnimForced ? "2" : "1");
                        ComboPraiseManager.this.mNetworkMonitor.release();
                    }
                    ComboPraiseManager.this.getPraiseView().setClickBlock(false);
                    ComboPraiseManager.this.mMainHandler.removeCallbacksAndMessages(null);
                    ComboPraiseManager.this.mIsPopupWindowShowing = false;
                    if (ComboPraiseManager.this.mTouchListener.mCancelAnimForced) {
                        PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(ComboPraiseManager.this.mPraiseConfig.mPraiseSource, ComboPraiseManager.this.mPraiseConfig.mPraiseId), 0L);
                    }
                }
            });
        }
        updateByCallbackIfNeeded();
        if (!this.mIsNAOrWebCall) {
            this.mPraiseConfig.mBaseRect.left = DeviceUtil.ScreenInfo.dp2px(this.mCtx, this.mPraiseConfig.mBaseRect.left);
            this.mPraiseConfig.mBaseRect.top = DeviceUtil.ScreenInfo.dp2px(this.mCtx, this.mPraiseConfig.mBaseRect.top);
            this.mPraiseConfig.mBaseRect.right = DeviceUtil.ScreenInfo.dp2px(this.mCtx, this.mPraiseConfig.mBaseRect.right);
            this.mPraiseConfig.mBaseRect.bottom = DeviceUtil.ScreenInfo.dp2px(this.mCtx, this.mPraiseConfig.mBaseRect.bottom);
        }
        this.mPraiseConfig.mBaseRect.offset(0, getOffsetY());
        this.mPraiseConfig.mIsH5OrHNCall = this.mIsH5OrHNCall;
        this.mPraiseConfig.mIsNAOrWebCall = this.mIsNAOrWebCall;
        this.mPraiseConfig.mInterceptTouchEvent = this.mInterceptTouchEvent;
        this.mPraiseConfig.mNightMode = NightModeHelper.getNightModeSwitcherState();
        getPraiseView().setPraiseConfig(this.mPraiseConfig);
        this.mPopupWindow.setTouchable(this.mInterceptTouchEvent);
        this.mPopupWindow.setOutsideTouchable(false);
        getPraiseView().setClickable(false);
        if (this.mInterceptTouchEvent) {
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mPopupWindow.setTouchInterceptor(this.mTouchListener);
        } else {
            this.mPopupWindow.setBackgroundDrawable(null);
            this.mPopupWindow.setTouchInterceptor(null);
        }
        this.mPopupWindow.update();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getOffsetY() {
        char c;
        int offsetY;
        boolean z = true;
        String makePraiseInfoKey = PraiseInfoManager.makePraiseInfoKey(this.mPraiseConfig.mPraiseSource, this.mPraiseConfig.mPraiseId);
        String str = this.mPraiseConfig.mPraiseSource;
        switch (str.hashCode()) {
            case -2030277797:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_SUPERSTAR)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1031662980:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_WENDA_SEARCH)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 169716899:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_FEEDNEWS)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 867471159:
                if (str.equals(PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 873977699:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_PROFILE_SEARCHBAR)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1092288197:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_NACMT)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1293675129:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_SEARCHBAR)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                z = false;
                break;
        }
        if (z || (offsetY = PraiseInfoManager.getInstance().getOffsetY(makePraiseInfoKey)) == -1) {
            int calculateOffsetY = calculateOffsetY();
            PraiseInfoManager.getInstance().updateOffsetY(makePraiseInfoKey, calculateOffsetY);
            return calculateOffsetY;
        }
        return offsetY;
    }

    private int calculateOffsetY() {
        View searchTargetView;
        if (this.mIsNAOrWebCall || this.mCtx == null) {
            return 0;
        }
        View decorView = this.mCtx.getWindow().getDecorView();
        if (decorView == null) {
            return 0;
        }
        String str = this.mPraiseConfig.mPraiseSource;
        char c = 65535;
        switch (str.hashCode()) {
            case -2030277797:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_SUPERSTAR)) {
                    c = 1;
                    break;
                }
                break;
            case -1031662980:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_WENDA_SEARCH)) {
                    c = 5;
                    break;
                }
                break;
            case 169716899:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_FEEDNEWS)) {
                    c = 0;
                    break;
                }
                break;
            case 867471159:
                if (str.equals(PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
                    c = 6;
                    break;
                }
                break;
            case 873977699:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_PROFILE_SEARCHBAR)) {
                    c = 3;
                    break;
                }
                break;
            case 1092288197:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_NACMT)) {
                    c = 2;
                    break;
                }
                break;
            case 1293675129:
                if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_SEARCHBAR)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                View searchTargetView2 = searchTargetView(decorView, SEARCH_BAR_NAME_H5_FEEDNEWS);
                if (searchTargetView2 == null) {
                    return 0;
                }
                return searchTargetView2.getTop();
            case 3:
            case 4:
            case 5:
                View searchTargetView3 = searchTargetView(decorView, SEARCH_BAR_NAME_H5_WENDA);
                if (searchTargetView3 == null) {
                    return 0;
                }
                int[] iArr = new int[2];
                searchTargetView3.getLocationOnScreen(iArr);
                return searchTargetView3.getHeight() + (iArr[1] - DeviceUtil.ScreenInfo.getStatusBarHeight());
            case 6:
                View searchTargetView4 = searchTargetView(decorView, SEARCH_BAR_NAME_HN_SMALL);
                if (searchTargetView4 == null || searchTargetView4.getParent() == null) {
                    return 0;
                }
                ViewGroup viewGroup = (ViewGroup) searchTargetView4.getParent();
                if (viewGroup == null || viewGroup.getParent() == null) {
                    return 0;
                }
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                View searchTargetView5 = searchTargetView(decorView, SEARCH_BAR_NAME_HN_BIG);
                if (searchTargetView5 != null && (searchTargetView = searchTargetView(decorView, SEARCH_BAR_NAME_HOME_BACKGROUND)) != null) {
                    if (viewGroup2.getVisibility() == 0 && searchTargetView.getVisibility() != 0) {
                        View searchTargetView6 = searchTargetView(decorView, SEARCH_BAR_NAME_HN_FEED_TAB_LAYOUT);
                        if (searchTargetView6 == null) {
                            return 0;
                        }
                        return viewGroup2.getHeight() + searchTargetView6.getHeight();
                    }
                    return searchTargetView5.getHeight();
                }
                return 0;
            default:
                return 0;
        }
    }

    private static View searchTargetView(View view, String... strArr) {
        if (view == null || isTargetView(view, strArr)) {
            return view;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(view);
        while (!arrayDeque.isEmpty()) {
            View view2 = (View) arrayDeque.removeFirst();
            if (view2 != null) {
                if (!isTargetView(view2, strArr)) {
                    if (view2 instanceof ViewGroup) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < ((ViewGroup) view2).getChildCount()) {
                                arrayDeque.addLast(((ViewGroup) view2).getChildAt(i2));
                                i = i2 + 1;
                            }
                        }
                    }
                } else {
                    return view2;
                }
            }
        }
        return null;
    }

    private static boolean isTargetView(View view, String... strArr) {
        if (view == null || strArr == null || strArr.length <= 0) {
            return false;
        }
        String lowerCase = view.getClass().getSimpleName().toLowerCase();
        for (String str : strArr) {
            if (TextUtils.equals(lowerCase, str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasWindowFullscreenFlag(Window window) {
        return (window == null || window.getAttributes() == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
    }

    public void notifyPraiseAnimStatus(boolean z) {
        getPraiseView().setClickBlock(z);
    }
}
