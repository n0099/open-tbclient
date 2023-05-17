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
import com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext;
import com.baidu.searchbox.ui.animview.praise.ioc.PraiseInteractGuideRuntime;
import com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import com.baidu.searchbox.ui.animview.praise.view.IPraiseStatusListener;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
import java.util.ArrayDeque;
import java.util.Locale;
/* loaded from: classes4.dex */
public class ComboPraiseManager {
    public static final String HOT_PRAISE_ANIM_CONFIG = "hot_resource_praise_config";
    public static final int INTERCEPT_MODE_DEFAULT = 0;
    public static final int INTERCEPT_MODE_DISABLE = 0;
    public static final int INTERCEPT_MODE_ENABLE = 1;
    public static final int INTERCEPT_MODE_IGNORE = 2;
    public static final int MOTIONEVENT_DOWN = 0;
    public static final int MOTIONEVENT_UP = 1;
    public static final String PRAISE_NID = "praise_nid";
    public static final String PRAISE_SOURCE = "praise_source";
    public static final String PRAISE_SOURCE_PREFIX_H5 = "h5";
    public static final String PRAISE_SOURCE_PREFIX_HN = "hn";
    public static final String PRAISE_SOURCE_PREFIX_HN_SN = "sn";
    public static final String PRAISE_SOURCE_PREFIX_NA = "na";
    public static final String PRAISE_SOURCE_SEPARATE = "_";
    public static final String SEARCH_BAR_NAME_H5_FEEDNEWS = "LightBrowserView";
    public static final String SEARCH_BAR_NAME_H5_WENDA = "SimpleFloatSearchBoxLayout";
    public static final String SEARCH_BAR_NAME_HN_BIG = "HomeHeaderLayout";
    public static final String SEARCH_BAR_NAME_HN_FEED_TAB_LAYOUT = "FeedTabLayout";
    public static final String SEARCH_BAR_NAME_HN_SMALL = "SearchBoxViewHome";
    public static final String SEARCH_BAR_NAME_HOME_BACKGROUND = "HomeBackground";
    public static final String TAG = "ComboPraiseManager";
    public ComboPraiseLongPressListener mComboPraiseLongPressListener;
    public ComboPraiseView mComboPraiseView;
    public Activity mCtx;
    public PraiseEncourageController mEncourageController;
    public IExPraiseAnimListener mExAnimListener;
    public IPraiseManagerCallback mICallback;
    public boolean mInterceptTouchEvent;
    public boolean mIsH5OrHNCall;
    public boolean mIsNAOrWebCall;
    public boolean mIsPopupWindowShowing;
    public boolean mLastNetworkEnable;
    public IResourceProvider mLastProvider;
    public NetworkMonitor mNetworkMonitor;
    public PopupWindow mPopupWindow;
    public View mWindowTokenView;
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static int sLongPressTimeMs = 450;
    public ComboPraiseConfig mPraiseConfig = new ComboPraiseConfig();
    public boolean mPraiseStatusListenerEnabled = true;
    public TouchListener mTouchListener = new TouchListener();
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public interface ComboPraiseLongPressListener {
        void onComboPraiseLongPressCancel();

        void onComboPraiseLongPressStart();
    }

    /* loaded from: classes4.dex */
    public interface NotifyPraiseAnimCallBack {
        void notifyPraiseAnimStatus(boolean z);
    }

    /* loaded from: classes4.dex */
    public class TouchListener implements View.OnTouchListener {
        public static final int CANCEL_PRAISE_MS = 2000;
        public static final int MOCK_CLICK_INTERVAL_TIME_MS = 100;
        public static final int PREVENT_CALL_FROM_CLICK = 0;
        public static final int PREVENT_CALL_FROM_LONGPRESS = 1;
        public static final int PREVENT_CALL_FROM_MOVE = 2;
        public static final int VALID_CLICK_RECT_HEIGHT_DP = 61;
        public static final int VALID_CLICK_RECT_WIDTH_DP = 61;
        public boolean mBeyondSectionForNA;
        public boolean mCallFromOuter;
        public boolean mCancelAnimForced;
        public boolean mInterceptMode;
        public boolean mIsLongPress;
        public boolean mIsNAFirstDown;
        public boolean mIsWebMode;
        public long mLastDownTimeMs;
        public int mLastXForNA;
        public int mLastYForNA;
        public Runnable mLongClick;
        public Runnable mMockClick;
        public boolean mUnlimitedCreateRectForWeb;
        public Rect mValidClickRectForNA;

        public TouchListener() {
            this.mMockClick = new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ComboPraiseManager.this.getPraiseView().click(true);
                    ComboPraiseManager.this.mMainHandler.postDelayed(TouchListener.this.mMockClick, 100L);
                }
            };
            this.mLongClick = new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TouchListener.this.performAnimPrevented(1)) {
                        return;
                    }
                    if (TouchListener.this.mCallFromOuter) {
                        ComboPraiseManager.this.onTouch(true, true);
                    }
                    TouchListener.this.mIsLongPress = true;
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(TouchListener.this.mMockClick);
                    ComboPraiseManager.this.mMainHandler.post(TouchListener.this.mMockClick);
                    if (ComboPraiseManager.this.mComboPraiseLongPressListener != null) {
                        ComboPraiseManager.this.mComboPraiseLongPressListener.onComboPraiseLongPressStart();
                        ComboPraiseManager.this.mMainHandler.removeCallbacks(TouchListener.this.mMockClick);
                    }
                    ComboPraiseManager.this.updatePraiseClickNum();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void autoCancelIfNeeded(MotionEvent motionEvent) {
            if (!PraiseEnvironment.isCancelPraiseEnabled(ComboPraiseManager.this.mPraiseConfig.mPraiseSource)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (ComboPraiseManager.this.isAnimationRunning() && currentTimeMillis - this.mLastDownTimeMs > 2000) {
                cancelAnimForced(motionEvent);
            }
            this.mLastDownTimeMs = currentTimeMillis;
        }

        private void createValidClickRectForNA(MotionEvent motionEvent) {
            if (ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                return;
            }
            createValidClickRect(motionEvent);
        }

        private void createValidClickRectForWeb(MotionEvent motionEvent) {
            if (!this.mUnlimitedCreateRectForWeb && ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                return;
            }
            createValidClickRect(motionEvent);
            this.mUnlimitedCreateRectForWeb = false;
        }

        public void setInterceptMode(boolean z) {
            this.mInterceptMode = z;
        }

        public void setWebMode(boolean z) {
            this.mIsWebMode = z;
            if (z) {
                this.mUnlimitedCreateRectForWeb = true;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelAnimForced(MotionEvent motionEvent) {
            Rect rect;
            if (!PraiseEnvironment.isCancelPraiseEnabled(ComboPraiseManager.this.mPraiseConfig.mPraiseSource) || !ComboPraiseManager.this.getPraiseView().isAnimationRunning()) {
                return;
            }
            if (motionEvent != null && (rect = this.mValidClickRectForNA) != null && (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()))) {
                if (ComboPraiseManager.DEBUG) {
                    Log.d(ComboPraiseManager.TAG, "outOfBound, PraiseAnim will not be cancelled, x=" + motionEvent.getRawX() + ", y=" + motionEvent.getRawY() + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString());
                    return;
                }
                return;
            }
            if (ComboPraiseManager.DEBUG) {
                Log.d(ComboPraiseManager.TAG, "PraiseAnim cancelled");
            }
            this.mBeyondSectionForNA = true;
            this.mCancelAnimForced = true;
        }

        private void createValidClickRect(MotionEvent motionEvent) {
            int rawY;
            int i;
            int dp2px = DeviceUtil.ScreenInfo.dp2px(ComboPraiseManager.this.mCtx, 61.0f);
            int dp2px2 = DeviceUtil.ScreenInfo.dp2px(ComboPraiseManager.this.mCtx, 61.0f);
            if (this.mIsWebMode && this.mInterceptMode) {
                i = ComboPraiseManager.this.mPraiseConfig.mBaseRect.centerX();
                rawY = ComboPraiseManager.this.mPraiseConfig.mBaseRect.centerY();
            } else {
                int rawX = (int) motionEvent.getRawX();
                rawY = (int) motionEvent.getRawY();
                i = rawX;
            }
            this.mCancelAnimForced = false;
            this.mBeyondSectionForNA = false;
            int i2 = dp2px / 2;
            int i3 = dp2px2 / 2;
            this.mValidClickRectForNA = new Rect((int) ((i - i2) + 0.5f), (int) ((rawY - i3) + 0.5f), (int) (i + i2 + 0.5f), (int) (rawY + i3 + 0.5f));
            if (ComboPraiseManager.DEBUG) {
                Log.d(ComboPraiseManager.TAG, "mValidClickRectForNA: " + this.mValidClickRectForNA.toShortString());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
            if (r0 != 3) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processInterceptionForNA(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        updateBeyondStateForNA(motionEvent);
                        if (performAnimPrevented(2)) {
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        }
                    }
                }
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                updateBeyondStateForNA(motionEvent);
                if (this.mIsLongPress) {
                    this.mIsLongPress = false;
                } else if (motionEvent.getAction() == 3) {
                    this.mCallFromOuter = false;
                    if (ComboPraiseManager.DEBUG) {
                        Log.d(ComboPraiseManager.TAG, "cancel praise animation");
                    }
                    return false;
                } else if (this.mCallFromOuter) {
                    if (this.mBeyondSectionForNA) {
                        if (ComboPraiseManager.DEBUG) {
                            Log.d(ComboPraiseManager.TAG, "out of valid bound");
                        }
                    } else {
                        ComboPraiseManager.this.onTouch(true, false);
                    }
                    this.mCallFromOuter = false;
                } else {
                    performPraiseClickIfNeeded();
                }
            } else {
                handleDownEventForInterceptionNA(motionEvent, false);
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
            if (r0 != 3) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processInterceptionForWeb(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        updateBeyondStateForNA(motionEvent);
                        if (performAnimPrevented(2)) {
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        }
                    }
                }
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                updateBeyondStateForNA(motionEvent);
                if (this.mIsLongPress) {
                    this.mIsLongPress = false;
                } else {
                    performPraiseClickIfNeeded();
                }
            } else {
                createValidClickRectForWeb(motionEvent);
                autoCancelIfNeeded(motionEvent);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                this.mIsLongPress = false;
                ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.sLongPressTimeMs);
            }
            return false;
        }

        private void updateBeyondStateForNA(MotionEvent motionEvent) {
            if (this.mBeyondSectionForNA) {
                return;
            }
            boolean z = false;
            if (this.mValidClickRectForNA != null && motionEvent != null) {
                this.mLastXForNA = (int) motionEvent.getRawX();
                this.mLastYForNA = (int) motionEvent.getRawY();
                if (LinkageControlUtil.isPraiseOptimized()) {
                    this.mBeyondSectionForNA = (motionEvent.getAction() == 3 || !this.mValidClickRectForNA.contains(this.mLastXForNA, this.mLastYForNA)) ? true : true;
                } else {
                    this.mBeyondSectionForNA = !this.mValidClickRectForNA.contains(this.mLastXForNA, this.mLastYForNA);
                }
                if (ComboPraiseManager.DEBUG) {
                    Log.d(ComboPraiseManager.TAG, "x=" + this.mLastXForNA + ", y=" + this.mLastYForNA + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString() + ", current event=" + motionEvent);
                    return;
                }
                return;
            }
            this.mBeyondSectionForNA = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean performAnimPrevented(int i) {
            if (!this.mBeyondSectionForNA) {
                return false;
            }
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

        private boolean processNoInterceptionForWeb(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                    return false;
                }
                return false;
            }
            ComboPraiseManager.this.updatePraiseClickNum();
            if (!ComboPraiseManager.this.isPopupWindowShowing()) {
                ComboPraiseManager.this.configPopupWindow();
                ComboPraiseManager.this.show();
            }
            ComboPraiseManager.this.mMainHandler.removeCallbacksAndMessages(null);
            ComboPraiseManager.this.mMainHandler.post(this.mMockClick);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void performPraiseClickIfNeeded() {
            if (!performAnimPrevented(0)) {
                ComboPraiseManager.this.updatePraiseClickNum();
                ComboPraiseManager.this.getPraiseView().click(true);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
            if (r0 != 3) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processNoInterceptionForNA(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        updateBeyondStateForNA(motionEvent);
                        if (performAnimPrevented(2)) {
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                        }
                    }
                }
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
                ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
                updateBeyondStateForNA(motionEvent);
                if (ComboPraiseManager.this.mComboPraiseLongPressListener != null && this.mIsLongPress) {
                    if (ComboPraiseManager.DEBUG) {
                        Log.d(ComboPraiseManager.TAG, "#processNoInterceptionForNA, handle longPressCancel");
                    }
                    ComboPraiseManager.this.mComboPraiseLongPressListener.onComboPraiseLongPressCancel();
                    ComboPraiseManager.this.dismiss();
                }
                if (this.mIsLongPress) {
                    this.mIsLongPress = false;
                } else if (motionEvent.getAction() == 3) {
                    if (ComboPraiseManager.DEBUG) {
                        Log.d(ComboPraiseManager.TAG, "cancel praise animation");
                    }
                    return false;
                } else if (this.mIsNAFirstDown) {
                    this.mIsNAFirstDown = false;
                } else {
                    performPraiseClickIfNeeded();
                }
            } else {
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
                ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.sLongPressTimeMs);
            }
            return false;
        }

        public void handleDownEventForInterceptionNA(MotionEvent motionEvent, boolean z) {
            if (motionEvent.getAction() != 0) {
                return;
            }
            createValidClickRectForNA(motionEvent);
            autoCancelIfNeeded(motionEvent);
            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mMockClick);
            ComboPraiseManager.this.mMainHandler.removeCallbacks(this.mLongClick);
            this.mIsLongPress = false;
            this.mCallFromOuter = z;
            ComboPraiseManager.this.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.sLongPressTimeMs);
        }
    }

    private boolean disableNoInterceptionForWeb() {
        if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.mPraiseConfig.mPraiseSource) && this.mPraiseConfig.mPraiseSource.indexOf(PraiseSourceDef.HN_PRAISE_SRC_SN_PREFIX) != -1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        Activity activity;
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mPopupWindow != null && this.mIsPopupWindowShowing && (activity = this.mCtx) != null) {
            if (!activity.isFinishing()) {
                this.mPopupWindow.dismiss();
            }
            Handler handler2 = this.mMainHandler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.mIsPopupWindowShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComboPraiseView getPraiseView() {
        if (this.mComboPraiseView == null) {
            ComboPraiseView comboPraiseView = new ComboPraiseView(this.mCtx);
            this.mComboPraiseView = comboPraiseView;
            comboPraiseView.addPraiseAnimListener(new IPraiseAnimListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.4
                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                public void onPraiseAnimEnd() {
                    ComboPraiseManager.this.dismiss();
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                public void onPraiseAnimStart() {
                    if (ComboPraiseManager.this.mExAnimListener != null) {
                        ComboPraiseManager.this.mExAnimListener.onPraiseAnimStart();
                    }
                    if (!ComboPraiseManager.this.mIsNAOrWebCall && ComboPraiseRuntime.getContext() != null) {
                        ComboPraiseRuntime.getContext().notifyPraiseAnimationEvent(ComboPraiseManager.this.mCtx, ComboPraiseManager.this.mPraiseConfig.mPraiseId, "0");
                        ComboPraiseManager.this.mNetworkMonitor.init();
                        ComboPraiseManager comboPraiseManager = ComboPraiseManager.this;
                        comboPraiseManager.mLastNetworkEnable = comboPraiseManager.mNetworkMonitor.isNetworkEnable();
                    }
                }
            });
            this.mComboPraiseView.addPraiseStatusListener(new IPraiseStatusListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.5
                @Override // com.baidu.searchbox.ui.animview.praise.view.IPraiseStatusListener
                public void onTargetPraiseCntReached(int i, String str, String str2, String str3) {
                    if (ComboPraiseManager.this.mPraiseStatusListenerEnabled && ComboPraiseRuntime.getContext() != null) {
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
            this.mComboPraiseView.setEncourageAnimListener(new IPraiseEncourageAnimListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.6
                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseEncourageAnimListener
                public boolean encourageAnimStart() {
                    if (ComboPraiseManager.this.mEncourageController != null && ComboPraiseManager.this.showPraiseEncourageAnim()) {
                        ComboPraiseManager.this.updatePraiseTime();
                        return true;
                    }
                    ComboPraiseManager.this.updatePraiseTime();
                    return false;
                }
            });
        }
        return this.mComboPraiseView;
    }

    private void initWindowTokenView() {
        Activity activity = this.mCtx;
        if (activity == null) {
            this.mWindowTokenView = null;
            return;
        }
        try {
            this.mWindowTokenView = activity.getWindow().getDecorView();
        } catch (Exception e) {
            this.mWindowTokenView = null;
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPopupWindowShowing() {
        if (this.mPopupWindow == null) {
            return false;
        }
        return this.mIsPopupWindowShowing;
    }

    private boolean isPraiseEnabled() {
        return isPraiseEnabled(this.mPraiseConfig.mPraiseSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        Activity activity;
        if (this.mWindowTokenView != null && this.mPopupWindow != null && !this.mIsPopupWindowShowing && (activity = this.mCtx) != null && !activity.isFinishing()) {
            this.mPopupWindow.showAtLocation(this.mWindowTokenView, 17, 0, 0);
            this.mIsPopupWindowShowing = true;
        }
    }

    private void updatePraiseResourceIfNeeded() {
        IResourceProvider provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL);
        if (this.mLastProvider != provider) {
            getPraiseView().setProvider(provider);
            this.mLastProvider = provider;
        }
    }

    public void cancelAnimForced() {
        this.mTouchListener.cancelAnimForced(null);
    }

    public void clearLongPressCallback() {
        if (this.mComboPraiseLongPressListener != null) {
            this.mComboPraiseLongPressListener = null;
        }
    }

    public boolean isAnimationRunning() {
        return getPraiseView().isAnimationRunning();
    }

    public void performAnimPrevented() {
        TouchListener touchListener = this.mTouchListener;
        if (touchListener == null) {
            return;
        }
        touchListener.mBeyondSectionForNA = true;
        this.mTouchListener.performAnimPrevented(0);
    }

    public ComboPraiseManager setInterceptModeForNA() {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        setInterceptTouchEvent(2);
        return this;
    }

    public boolean showPraiseEncourageAnim() {
        ComboPraiseConfig comboPraiseConfig;
        PraiseEncourageController praiseEncourageController = this.mEncourageController;
        if (praiseEncourageController != null && (comboPraiseConfig = this.mPraiseConfig) != null) {
            return praiseEncourageController.showEasterEgg(comboPraiseConfig.mUBC, null);
        }
        return false;
    }

    public void updatePraiseClickNum() {
        this.mEncourageController.updatePraiseClickNum();
    }

    public void updatePraiseTime() {
        this.mEncourageController.updatePraiseTime();
    }

    public ComboPraiseManager(Activity activity, String str) {
        int i;
        this.mCtx = activity;
        NetworkMonitor networkMonitor = new NetworkMonitor(this.mCtx);
        this.mNetworkMonitor = networkMonitor;
        networkMonitor.setNetworkMonitorCb(new NetworkMonitor.INetworkMonitorCb() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.1
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
        if (LinkageControlUtil.isPraiseOptimized()) {
            i = 450;
        } else {
            i = 300;
        }
        sLongPressTimeMs = i;
        setPraiseSource(str);
        initWindowTokenView();
        updatePraiseResourceIfNeeded();
        this.mEncourageController = new PraiseEncourageController(activity);
    }

    public static void parsePraiseSource(String str, boolean[] zArr) {
        if (!TextUtils.isEmpty(str) && zArr != null && zArr.length == 2) {
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
            } else if (!substring.equalsIgnoreCase("hn") && !substring.equalsIgnoreCase(PRAISE_SOURCE_PREFIX_HN_SN)) {
                zArr[0] = true;
            } else {
                zArr[0] = false;
                zArr[1] = false;
            }
        } else if (zArr != null) {
            zArr[0] = true;
        }
    }

    public static boolean hasWindowFullscreenFlag(Window window) {
        if (window != null && window.getAttributes() != null && (window.getAttributes().flags & 1024) == 1024) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskWhenFirstShow(final Runnable runnable) {
        if (runnable != null && getPraiseView() != null) {
            getPraiseView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ComboPraiseManager.this.getPraiseView().getViewTreeObserver().removeOnPreDrawListener(this);
                    ComboPraiseManager.this.mMainHandler.postDelayed(runnable, ComboPraiseManager.sLongPressTimeMs + 50);
                    return true;
                }
            });
        }
    }

    private void setInterceptTouchEvent(int i) {
        boolean z = false;
        if (i == 2) {
            i = 0;
        }
        if (i == 1) {
            z = true;
        }
        this.mInterceptTouchEvent = z;
    }

    public void enablePraiseStatusListener(boolean z) {
        this.mPraiseStatusListenerEnabled = z;
    }

    public void notifyPraiseAnimStatus(boolean z) {
        getPraiseView().setClickBlock(z);
    }

    public void setComboPraiseLongPressListener(ComboPraiseLongPressListener comboPraiseLongPressListener) {
        if (this.mComboPraiseLongPressListener == null) {
            this.mComboPraiseLongPressListener = comboPraiseLongPressListener;
        }
    }

    public void setEncourageController(PraiseEncourageController praiseEncourageController) {
        this.mEncourageController = praiseEncourageController;
    }

    public ComboPraiseManager setFirstPraiseAnimEnabled(boolean z) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        this.mPraiseConfig.mFirstPraiseAnimEnabled = z;
        return this;
    }

    public ComboPraiseManager setHeight(int i) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        Rect rect = this.mPraiseConfig.mBaseRect;
        rect.bottom = rect.top + i;
        return this;
    }

    public ComboPraiseManager setInterceptModeForWeb(int i) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        setInterceptTouchEvent(i);
        return this;
    }

    public ComboPraiseManager setLeft(int i) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        this.mPraiseConfig.mBaseRect.left = i;
        return this;
    }

    public ComboPraiseManager setPraiseAnimListener(IExPraiseAnimListener iExPraiseAnimListener) {
        this.mExAnimListener = iExPraiseAnimListener;
        return this;
    }

    public ComboPraiseManager setPraiseId(String str) {
        String lowerCase;
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
        if (TextUtils.isEmpty(str)) {
            lowerCase = "";
        } else {
            lowerCase = str.toLowerCase(Locale.getDefault());
        }
        comboPraiseConfig.mPraiseId = lowerCase;
        return this;
    }

    public ComboPraiseManager setPraiseManagerCallback(IPraiseManagerCallback iPraiseManagerCallback) {
        this.mICallback = iPraiseManagerCallback;
        return this;
    }

    public ComboPraiseManager setPraiseSource(String str) {
        String lowerCase;
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
        if (TextUtils.isEmpty(str)) {
            lowerCase = "";
        } else {
            lowerCase = str.toLowerCase(Locale.getDefault());
        }
        comboPraiseConfig.mPraiseSource = lowerCase;
        parsePraiseSource();
        return this;
    }

    public ComboPraiseManager setTop(int i) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        this.mPraiseConfig.mBaseRect.top = i;
        return this;
    }

    public ComboPraiseManager setUBCParams(ComboPraiseUBC comboPraiseUBC) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        this.mPraiseConfig.mUBC = comboPraiseUBC;
        return this;
    }

    public ComboPraiseManager setWidth(int i) {
        if (getPraiseView().isAnimationRunning()) {
            return this;
        }
        Rect rect = this.mPraiseConfig.mBaseRect;
        rect.right = rect.left + i;
        return this;
    }

    private void onTouch(MotionEvent motionEvent, boolean z) {
        if (this.mInterceptTouchEvent) {
            return;
        }
        if (z) {
            this.mTouchListener.setWebMode(false);
            this.mTouchListener.setInterceptMode(false);
            this.mTouchListener.onTouch(null, motionEvent);
        } else if (disableNoInterceptionForWeb()) {
        } else {
            this.mTouchListener.setWebMode(true);
            this.mTouchListener.setInterceptMode(false);
            this.mTouchListener.onTouch(null, motionEvent);
        }
    }

    private int calculateOffsetY() {
        Activity activity;
        View decorView;
        View searchTargetView;
        if (this.mIsNAOrWebCall || (activity = this.mCtx) == null || (decorView = activity.getWindow().getDecorView()) == null) {
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
        if (c != 0 && c != 1 && c != 2) {
            if ((c != 3 && c != 4 && c != 5) || (searchTargetView = searchTargetView(decorView, SEARCH_BAR_NAME_H5_WENDA)) == null) {
                return 0;
            }
            int[] iArr = new int[2];
            searchTargetView.getLocationOnScreen(iArr);
            return (iArr[1] - DeviceUtil.ScreenInfo.getStatusBarHeight()) + searchTargetView.getHeight();
        }
        View searchTargetView2 = searchTargetView(decorView, SEARCH_BAR_NAME_H5_FEEDNEWS);
        if (searchTargetView2 == null) {
            return 0;
        }
        return searchTargetView2.getTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configPopupWindow() {
        if (this.mPopupWindow == null) {
            PopupWindow popupWindow = new PopupWindow((View) getPraiseView(), -1, -1, false);
            this.mPopupWindow = popupWindow;
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.7
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    String str;
                    if (ComboPraiseManager.this.mExAnimListener != null) {
                        ComboPraiseManager.this.mExAnimListener.onPraiseAnimEnd();
                    }
                    if (!ComboPraiseManager.this.mIsNAOrWebCall && ComboPraiseRuntime.getContext() != null) {
                        IComboPraiseContext context = ComboPraiseRuntime.getContext();
                        Activity activity = ComboPraiseManager.this.mCtx;
                        String str2 = ComboPraiseManager.this.mPraiseConfig.mPraiseId;
                        if (ComboPraiseManager.this.mTouchListener.mCancelAnimForced) {
                            str = "2";
                        } else {
                            str = "1";
                        }
                        context.notifyPraiseAnimationEvent(activity, str2, str);
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
            Rect rect = this.mPraiseConfig.mBaseRect;
            rect.left = DeviceUtil.ScreenInfo.dp2px(this.mCtx, rect.left);
            Rect rect2 = this.mPraiseConfig.mBaseRect;
            rect2.top = DeviceUtil.ScreenInfo.dp2px(this.mCtx, rect2.top);
            Rect rect3 = this.mPraiseConfig.mBaseRect;
            rect3.right = DeviceUtil.ScreenInfo.dp2px(this.mCtx, rect3.right);
            Rect rect4 = this.mPraiseConfig.mBaseRect;
            rect4.bottom = DeviceUtil.ScreenInfo.dp2px(this.mCtx, rect4.bottom);
        }
        this.mPraiseConfig.mBaseRect.offset(0, getOffsetY());
        ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
        comboPraiseConfig.mIsH5OrHNCall = this.mIsH5OrHNCall;
        comboPraiseConfig.mIsNAOrWebCall = this.mIsNAOrWebCall;
        comboPraiseConfig.mInterceptTouchEvent = this.mInterceptTouchEvent;
        comboPraiseConfig.mNightMode = NightModeHelper.getNightModeSwitcherState();
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
        ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
        String makePraiseInfoKey = PraiseInfoManager.makePraiseInfoKey(comboPraiseConfig.mPraiseSource, comboPraiseConfig.mPraiseId);
        String str = this.mPraiseConfig.mPraiseSource;
        boolean z = false;
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
                z = true;
                break;
        }
        if (z || (offsetY = PraiseInfoManager.getInstance().getOffsetY(makePraiseInfoKey)) == -1) {
            int calculateOffsetY = calculateOffsetY();
            PraiseInfoManager.getInstance().updateOffsetY(makePraiseInfoKey, calculateOffsetY);
            return calculateOffsetY;
        }
        return offsetY;
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

    public static boolean isPraiseEnabled(String str) {
        if (!PraiseResourceAPSManager.getInstance().hasValidProvider()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, PraiseResourceAPSManager does not have ValidProvider");
            }
            return false;
        } else if (ComboPraiseRuntime.getContext() != null && !ComboPraiseRuntime.getContext().getPraiseSwitchState()) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, ComboPraiseRuntime is null or PraiseSwitchState is false");
            }
            return false;
        } else {
            IResourceProvider provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL);
            if (provider != null && provider.getPackageList() != null && !provider.getPackageList().isEmpty()) {
                if (Build.VERSION.SDK_INT <= 21 && TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED)) {
                    if (DEBUG) {
                        Log.d(TAG, "isPraiseEnabled return false, praiseSource = na_feed, Build.VERSION.SDK_INT = 21");
                    }
                    return false;
                }
                return true;
            }
            if (DEBUG) {
                Log.d(TAG, "isPraiseEnabled return false, PraiseResourceAPSManager getProvider failed");
            }
            return false;
        }
    }

    public static boolean isTargetView(View view2, String... strArr) {
        if (view2 != null && strArr != null && strArr.length > 0) {
            String lowerCase = view2.getClass().getSimpleName().toLowerCase(Locale.getDefault());
            for (String str : strArr) {
                if (TextUtils.equals(lowerCase, str.toLowerCase(Locale.getDefault()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static View searchTargetView(View view2, String... strArr) {
        if (view2 != null && !isTargetView(view2, strArr)) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.addLast(view2);
            while (!arrayDeque.isEmpty()) {
                View view3 = (View) arrayDeque.removeFirst();
                if (view3 != null) {
                    if (isTargetView(view3, strArr)) {
                        return view3;
                    }
                    if (view3 instanceof ViewGroup) {
                        int i = 0;
                        while (true) {
                            ViewGroup viewGroup = (ViewGroup) view3;
                            if (i < viewGroup.getChildCount()) {
                                arrayDeque.addLast(viewGroup.getChildAt(i));
                                i++;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouch(boolean z, final boolean z2) {
        if (!this.mInterceptTouchEvent) {
            return;
        }
        this.mTouchListener.setInterceptMode(true);
        this.mTouchListener.setWebMode(!z);
        if (!z) {
            this.mTouchListener.autoCancelIfNeeded(null);
        }
        configPopupWindow();
        runTaskWhenFirstShow(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z2) {
                    ComboPraiseManager.this.updatePraiseClickNum();
                }
                ComboPraiseManager.this.getPraiseView().click(true);
            }
        });
        show();
    }

    private void parsePraiseSource() {
        ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
        if (comboPraiseConfig == null) {
            this.mIsNAOrWebCall = true;
            return;
        }
        boolean[] zArr = new boolean[2];
        parsePraiseSource(comboPraiseConfig.mPraiseSource, zArr);
        this.mIsNAOrWebCall = zArr[0];
        this.mIsH5OrHNCall = zArr[1];
        if (DEBUG) {
            Log.d(TAG, "IsNAOrWebCall:" + this.mIsNAOrWebCall + ", IsH5OrHNCall:" + this.mIsH5OrHNCall);
        }
    }

    private void updateByCallbackIfNeeded() {
        IPraiseManagerCallback iPraiseManagerCallback = this.mICallback;
        if (iPraiseManagerCallback == null) {
            return;
        }
        if (iPraiseManagerCallback.getAnchorLeft() >= 0) {
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
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    } else {
                        this.mTouchListener.onTouch(null, motionEvent);
                        return;
                    }
                }
                this.mTouchListener.onTouch(null, motionEvent);
                return;
            }
            this.mTouchListener.setInterceptMode(true);
            this.mTouchListener.setWebMode(false);
            this.mTouchListener.handleDownEventForInterceptionNA(motionEvent, true);
            return;
        }
        onTouch(motionEvent, true);
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
        if (i != 0) {
            if (i == 1) {
                motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
            }
        } else {
            motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
        }
        if (motionEvent != null) {
            if (this.mInterceptTouchEvent) {
                onTouch(false, false);
            } else {
                onTouch(motionEvent, false);
            }
            motionEvent.recycle();
        }
    }
}
