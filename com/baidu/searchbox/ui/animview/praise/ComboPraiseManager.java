package com.baidu.searchbox.ui.animview.praise;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Locale;
/* loaded from: classes7.dex */
public class ComboPraiseManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int INTERCEPT_MODE_DEFAULT = 0;
    public static final int INTERCEPT_MODE_DISABLE = 0;
    public static final int INTERCEPT_MODE_ENABLE = 1;
    public static final int INTERCEPT_MODE_IGNORE = 2;
    public static int LONG_PRESS_TIME_MS = 0;
    public static final int MOTIONEVENT_DOWN = 0;
    public static final int MOTIONEVENT_UP = 1;
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
    public transient /* synthetic */ FieldHolder $fh;
    public ComboPraiseLongPressListener mComboPraiseLongPressListener;
    public ComboPraiseView mComboPraiseView;
    public Activity mCtx;
    public IExPraiseAnimListener mExAnimListener;
    public IPraiseManagerCallback mICallback;
    public boolean mInterceptTouchEvent;
    public boolean mIsH5OrHNCall;
    public boolean mIsNAOrWebCall;
    public boolean mIsPopupWindowShowing;
    public boolean mLastNetworkEnable;
    public IResourceProvider mLastProvider;
    public Handler mMainHandler;
    public NetworkMonitor mNetworkMonitor;
    public PopupWindow mPopupWindow;
    public ComboPraiseConfig mPraiseConfig;
    public boolean mPraiseStatusListenerEnabled;
    public TouchListener mTouchListener;
    public View mWindowTokenView;

    /* loaded from: classes7.dex */
    public interface ComboPraiseLongPressListener {
        void onComboPraiseLongPressCancel();

        void onComboPraiseLongPressStart();
    }

    /* loaded from: classes7.dex */
    public interface NotifyPraiseAnimCallBack {
        void notifyPraiseAnimStatus(boolean z);
    }

    /* loaded from: classes7.dex */
    public class TouchListener implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CANCEL_PRAISE_MS = 2000;
        public static final int MOCK_CLICK_INTERVAL_TIME_MS = 100;
        public static final int PREVENT_CALL_FROM_CLICK = 0;
        public static final int PREVENT_CALL_FROM_LONGPRESS = 1;
        public static final int PREVENT_CALL_FROM_MOVE = 2;
        public static final int VALID_CLICK_RECT_HEIGHT_DP = 61;
        public static final int VALID_CLICK_RECT_WIDTH_DP = 61;
        public transient /* synthetic */ FieldHolder $fh;
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
        public final /* synthetic */ ComboPraiseManager this$0;

        public TouchListener(ComboPraiseManager comboPraiseManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comboPraiseManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = comboPraiseManager;
            this.mMockClick = new Runnable(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TouchListener this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$1.this$0.getPraiseView().click();
                        this.this$1.this$0.mMainHandler.postDelayed(this.this$1.mMockClick, 100L);
                    }
                }
            };
            this.mLongClick = new Runnable(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TouchListener this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.performAnimPrevented(1)) {
                        return;
                    }
                    if (this.this$1.mCallFromOuter) {
                        this.this$1.this$0.onTouch(true);
                    }
                    this.this$1.mIsLongPress = true;
                    this.this$1.this$0.mMainHandler.removeCallbacks(this.this$1.mMockClick);
                    this.this$1.this$0.mMainHandler.post(this.this$1.mMockClick);
                    if (this.this$1.this$0.mComboPraiseLongPressListener != null) {
                        this.this$1.this$0.mComboPraiseLongPressListener.onComboPraiseLongPressStart();
                        this.this$1.this$0.mMainHandler.removeCallbacks(this.this$1.mMockClick);
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void autoCancelIfNeeded(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65547, this, motionEvent) == null) && PraiseEnvironment.isCancelPraiseEnabled(this.this$0.mPraiseConfig.mPraiseSource)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.this$0.isAnimationRunning() && currentTimeMillis - this.mLastDownTimeMs > 2000) {
                    cancelAnimForced(motionEvent);
                }
                this.mLastDownTimeMs = currentTimeMillis;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelAnimForced(MotionEvent motionEvent) {
            Rect rect;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65548, this, motionEvent) == null) && PraiseEnvironment.isCancelPraiseEnabled(this.this$0.mPraiseConfig.mPraiseSource) && this.this$0.getPraiseView().isAnimationRunning()) {
                if (motionEvent == null || (rect = this.mValidClickRectForNA) == null || !(!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()))) {
                    boolean unused = ComboPraiseManager.DEBUG;
                    this.mBeyondSectionForNA = true;
                    this.mCancelAnimForced = true;
                } else if (ComboPraiseManager.DEBUG) {
                    String str = "outOfBound, PraiseAnim will not be cancelled, x=" + motionEvent.getRawX() + ", y=" + motionEvent.getRawY() + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString();
                }
            }
        }

        private void createValidClickRect(MotionEvent motionEvent) {
            int rawY;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65549, this, motionEvent) == null) {
                int dp2px = DeviceUtil.ScreenInfo.dp2px(this.this$0.mCtx, 61.0f);
                int dp2px2 = DeviceUtil.ScreenInfo.dp2px(this.this$0.mCtx, 61.0f);
                if (this.mIsWebMode && this.mInterceptMode) {
                    i2 = this.this$0.mPraiseConfig.mBaseRect.centerX();
                    rawY = this.this$0.mPraiseConfig.mBaseRect.centerY();
                } else {
                    int rawX = (int) motionEvent.getRawX();
                    rawY = (int) motionEvent.getRawY();
                    i2 = rawX;
                }
                this.mCancelAnimForced = false;
                this.mBeyondSectionForNA = false;
                int i3 = dp2px / 2;
                int i4 = dp2px2 / 2;
                this.mValidClickRectForNA = new Rect((int) ((i2 - i3) + 0.5f), (int) ((rawY - i4) + 0.5f), (int) (i2 + i3 + 0.5f), (int) (rawY + i4 + 0.5f));
                if (ComboPraiseManager.DEBUG) {
                    String str = "mValidClickRectForNA: " + this.mValidClickRectForNA.toShortString();
                }
            }
        }

        private void createValidClickRectForNA(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65550, this, motionEvent) == null) || this.this$0.getPraiseView().isAnimationRunning()) {
                return;
            }
            createValidClickRect(motionEvent);
        }

        private void createValidClickRectForWeb(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65551, this, motionEvent) == null) {
                if (this.mUnlimitedCreateRectForWeb || !this.this$0.getPraiseView().isAnimationRunning()) {
                    createValidClickRect(motionEvent);
                    this.mUnlimitedCreateRectForWeb = false;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean performAnimPrevented(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) {
                if (this.mBeyondSectionForNA) {
                    if (ComboPraiseManager.DEBUG) {
                        boolean z = this.mCancelAnimForced;
                    }
                    if (i2 == 1) {
                        this.mIsLongPress = true;
                    } else if (i2 == 0) {
                        this.this$0.getPraiseView().setClickBlock(true);
                    } else if (this.mIsLongPress) {
                        return false;
                    }
                    if (this.this$0.mExAnimListener != null) {
                        this.this$0.mExAnimListener.onPraiseAnimPrevented(this.mCancelAnimForced ? 1 : 0);
                    }
                    if (!this.this$0.getPraiseView().isAnimationRunning()) {
                        this.this$0.dismiss();
                    }
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void performPraiseClickIfNeeded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || performAnimPrevented(0)) {
                return;
            }
            this.this$0.getPraiseView().click();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
            if (r0 != 3) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processInterceptionForNA(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            updateBeyondStateForNA(motionEvent);
                            if (performAnimPrevented(2)) {
                                this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                                this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                            }
                        }
                    }
                    this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                    this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                    } else if (motionEvent.getAction() == 3) {
                        this.mCallFromOuter = false;
                        boolean unused = ComboPraiseManager.DEBUG;
                        return false;
                    } else if (this.mCallFromOuter) {
                        if (!this.mBeyondSectionForNA) {
                            this.this$0.onTouch(true);
                        } else {
                            boolean unused2 = ComboPraiseManager.DEBUG;
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
            return invokeL.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r0 != 3) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processInterceptionForWeb(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            updateBeyondStateForNA(motionEvent);
                            if (performAnimPrevented(2)) {
                                this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                                this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                            }
                        }
                    }
                    this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                    this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                    } else {
                        performPraiseClickIfNeeded();
                    }
                } else {
                    createValidClickRectForWeb(motionEvent);
                    autoCancelIfNeeded(motionEvent);
                    this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                    this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                    this.mIsLongPress = false;
                    this.this$0.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.LONG_PRESS_TIME_MS);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
            if (r0 != 3) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean processNoInterceptionForNA(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            updateBeyondStateForNA(motionEvent);
                            if (performAnimPrevented(2)) {
                                this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                                this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                            }
                        }
                    }
                    this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                    this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                    updateBeyondStateForNA(motionEvent);
                    if (this.this$0.mComboPraiseLongPressListener != null && this.mIsLongPress) {
                        boolean unused = ComboPraiseManager.DEBUG;
                        this.this$0.mComboPraiseLongPressListener.onComboPraiseLongPressCancel();
                    }
                    if (this.mIsLongPress) {
                        this.mIsLongPress = false;
                    } else if (motionEvent.getAction() == 3) {
                        boolean unused2 = ComboPraiseManager.DEBUG;
                        return false;
                    } else if (this.mIsNAFirstDown) {
                        this.mIsNAFirstDown = false;
                    } else {
                        performPraiseClickIfNeeded();
                    }
                } else {
                    createValidClickRectForNA(motionEvent);
                    autoCancelIfNeeded(motionEvent);
                    this.this$0.mMainHandler.removeCallbacksAndMessages(null);
                    this.mIsLongPress = false;
                    this.mIsNAFirstDown = false;
                    if (!this.this$0.isPopupWindowShowing()) {
                        this.this$0.configPopupWindow();
                        this.this$0.show();
                        this.mIsNAFirstDown = true;
                        this.this$0.runTaskWhenFirstShow(new Runnable(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.TouchListener.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TouchListener this$1;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.mIsLongPress) {
                                    return;
                                }
                                this.this$1.performPraiseClickIfNeeded();
                            }
                        });
                    }
                    this.this$0.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.LONG_PRESS_TIME_MS);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        private boolean processNoInterceptionForWeb(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                        return false;
                    }
                    return false;
                }
                if (!this.this$0.isPopupWindowShowing()) {
                    this.this$0.configPopupWindow();
                    this.this$0.show();
                }
                this.this$0.mMainHandler.removeCallbacksAndMessages(null);
                this.this$0.mMainHandler.post(this.mMockClick);
                return false;
            }
            return invokeL.booleanValue;
        }

        private void updateBeyondStateForNA(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65558, this, motionEvent) == null) || this.mBeyondSectionForNA) {
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
                    String str = "x=" + this.mLastXForNA + ", y=" + this.mLastYForNA + ", mValidClickRectForNA:" + this.mValidClickRectForNA.toShortString() + ", current event=" + motionEvent;
                    return;
                }
                return;
            }
            this.mBeyondSectionForNA = false;
        }

        public void handleDownEventForInterceptionNA(MotionEvent motionEvent, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, motionEvent, z) == null) && motionEvent.getAction() == 0) {
                createValidClickRectForNA(motionEvent);
                autoCancelIfNeeded(motionEvent);
                this.this$0.mMainHandler.removeCallbacks(this.mMockClick);
                this.this$0.mMainHandler.removeCallbacks(this.mLongClick);
                this.mIsLongPress = false;
                this.mCallFromOuter = z;
                this.this$0.mMainHandler.postDelayed(this.mLongClick, ComboPraiseManager.LONG_PRESS_TIME_MS);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
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
            return invokeLL.booleanValue;
        }

        public void setInterceptMode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.mInterceptMode = z;
            }
        }

        public void setWebMode(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.mIsWebMode = z;
                if (z) {
                    this.mUnlimitedCreateRectForWeb = true;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(455963325, "Lcom/baidu/searchbox/ui/animview/praise/ComboPraiseManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(455963325, "Lcom/baidu/searchbox/ui/animview/praise/ComboPraiseManager;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
        LONG_PRESS_TIME_MS = 450;
    }

    public ComboPraiseManager(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPraiseConfig = new ComboPraiseConfig();
        this.mPraiseStatusListenerEnabled = true;
        this.mTouchListener = new TouchListener();
        this.mCtx = activity;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        NetworkMonitor networkMonitor = new NetworkMonitor(this.mCtx);
        this.mNetworkMonitor = networkMonitor;
        networkMonitor.setNetworkMonitorCb(new NetworkMonitor.INetworkMonitorCb(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.NetworkMonitor.INetworkMonitorCb
            public void onNetworkStateChanged() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mIsNAOrWebCall || !this.this$0.mLastNetworkEnable || this.this$0.mNetworkMonitor.isNetworkEnable()) {
                    return;
                }
                boolean unused = ComboPraiseManager.DEBUG;
                this.this$0.mMainHandler.removeCallbacksAndMessages(null);
            }
        });
        LONG_PRESS_TIME_MS = LinkageControlUtil.isPraiseOptimized() ? 450 : 300;
        setPraiseSource(str);
        initWindowTokenView();
        updatePraiseResourceIfNeeded();
    }

    private int calculateOffsetY() {
        InterceptResult invokeV;
        Activity activity;
        View decorView;
        View searchTargetView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (this.mIsNAOrWebCall || (activity = this.mCtx) == null || (decorView = activity.getWindow().getDecorView()) == null) {
                return 0;
            }
            String str = this.mPraiseConfig.mPraiseSource;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2030277797:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_SUPERSTAR)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1031662980:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_WENDA_SEARCH)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 169716899:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_FEEDNEWS)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 867471159:
                    if (str.equals(PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 873977699:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_PROFILE_SEARCHBAR)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1092288197:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_NACMT)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1293675129:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_SEARCHBAR)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1 || c2 == 2) {
                View searchTargetView2 = searchTargetView(decorView, SEARCH_BAR_NAME_H5_FEEDNEWS);
                if (searchTargetView2 == null) {
                    return 0;
                }
                return searchTargetView2.getTop();
            } else if ((c2 == 3 || c2 == 4 || c2 == 5) && (searchTargetView = searchTargetView(decorView, SEARCH_BAR_NAME_H5_WENDA)) != null) {
                int[] iArr = new int[2];
                searchTargetView.getLocationOnScreen(iArr);
                return (iArr[1] - DeviceUtil.ScreenInfo.getStatusBarHeight()) + searchTargetView.getHeight();
            } else {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (this.mPopupWindow == null) {
                PopupWindow popupWindow = new PopupWindow((View) getPraiseView(), -1, -1, false);
                this.mPopupWindow = popupWindow;
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComboPraiseManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.this$0.mExAnimListener != null) {
                                this.this$0.mExAnimListener.onPraiseAnimEnd();
                            }
                            if (!this.this$0.mIsNAOrWebCall && ComboPraiseRuntime.getContext() != null) {
                                ComboPraiseRuntime.getContext().notifyPraiseAnimationEvent(this.this$0.mCtx, this.this$0.mPraiseConfig.mPraiseId, this.this$0.mTouchListener.mCancelAnimForced ? "2" : "1");
                                this.this$0.mNetworkMonitor.release();
                            }
                            this.this$0.getPraiseView().setClickBlock(false);
                            this.this$0.mMainHandler.removeCallbacksAndMessages(null);
                            this.this$0.mIsPopupWindowShowing = false;
                            if (this.this$0.mTouchListener.mCancelAnimForced) {
                                PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.this$0.mPraiseConfig.mPraiseSource, this.this$0.mPraiseConfig.mPraiseId), 0L);
                            }
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
    }

    private boolean disableNoInterceptionForWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            if (TextUtils.equals(this.mPraiseConfig.mPraiseSource, PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
                return false;
            }
            return TextUtils.isEmpty(this.mPraiseConfig.mPraiseSource) || this.mPraiseConfig.mPraiseSource.indexOf(PraiseSourceDef.HN_PRAISE_SRC_SN_PREFIX) == -1;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            Handler handler = this.mMainHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (this.mPopupWindow == null || !this.mIsPopupWindowShowing || (activity = this.mCtx) == null) {
                return;
            }
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

    private boolean enableInterceptionForNA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getOffsetY() {
        InterceptResult invokeV;
        char c2;
        int offsetY;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            ComboPraiseConfig comboPraiseConfig = this.mPraiseConfig;
            String makePraiseInfoKey = PraiseInfoManager.makePraiseInfoKey(comboPraiseConfig.mPraiseSource, comboPraiseConfig.mPraiseId);
            String str = this.mPraiseConfig.mPraiseSource;
            boolean z = false;
            switch (str.hashCode()) {
                case -2030277797:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_SUPERSTAR)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1031662980:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_WENDA_SEARCH)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 169716899:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_FEEDNEWS)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 867471159:
                    if (str.equals(PraiseSourceDef.HN_PRAISE_SRC_DYNAMIC_LIST)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 873977699:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_PROFILE_SEARCHBAR)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1092288197:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_NACMT)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1293675129:
                    if (str.equals(PraiseSourceDef.H5_PRAISE_SRC_DYNAMIC_SEARCHBAR)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
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
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComboPraiseView getPraiseView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if (this.mComboPraiseView == null) {
                ComboPraiseView comboPraiseView = new ComboPraiseView(this.mCtx);
                this.mComboPraiseView = comboPraiseView;
                comboPraiseView.addPraiseAnimListener(new IPraiseAnimListener(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComboPraiseManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                    public void onPraiseAnimEnd() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.dismiss();
                        }
                    }

                    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                    public void onPraiseAnimStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            if (this.this$0.mExAnimListener != null) {
                                this.this$0.mExAnimListener.onPraiseAnimStart();
                            }
                            if (this.this$0.mIsNAOrWebCall || ComboPraiseRuntime.getContext() == null) {
                                return;
                            }
                            ComboPraiseRuntime.getContext().notifyPraiseAnimationEvent(this.this$0.mCtx, this.this$0.mPraiseConfig.mPraiseId, "0");
                            this.this$0.mNetworkMonitor.init();
                            ComboPraiseManager comboPraiseManager = this.this$0;
                            comboPraiseManager.mLastNetworkEnable = comboPraiseManager.mNetworkMonitor.isNetworkEnable();
                        }
                    }
                });
                this.mComboPraiseView.addPraiseStatusListener(new IPraiseStatusListener(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComboPraiseManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.ui.animview.praise.view.IPraiseStatusListener
                    public void onTargetPraiseCntReached(int i2, String str, String str2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) && this.this$0.mPraiseStatusListenerEnabled && ComboPraiseRuntime.getContext() != null) {
                            NotifyPraiseAnimCallBack notifyPraiseAnimCallBack = new NotifyPraiseAnimCallBack(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass5 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.NotifyPraiseAnimCallBack
                                public void notifyPraiseAnimStatus(boolean z) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) {
                                        this.this$1.this$0.notifyPraiseAnimStatus(z);
                                    }
                                }
                            };
                            if (PraiseInteractGuideRuntime.getContext() != null) {
                                PraiseInteractGuideRuntime.getContext().guideLuckMoney(this.this$0.mCtx, str, str2, str3, notifyPraiseAnimCallBack);
                            }
                        }
                    }
                });
            }
            return this.mComboPraiseView;
        }
        return (ComboPraiseView) invokeV.objValue;
    }

    public static boolean hasWindowFullscreenFlag(Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, window)) == null) ? (window == null || window.getAttributes() == null || (window.getAttributes().flags & 1024) != 1024) ? false : true : invokeL.booleanValue;
    }

    private void initWindowTokenView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            Activity activity = this.mCtx;
            if (activity == null) {
                this.mWindowTokenView = null;
            } else {
                this.mWindowTokenView = activity.getWindow().getDecorView();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPopupWindowShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            if (this.mPopupWindow == null) {
                return false;
            }
            return this.mIsPopupWindowShowing;
        }
        return invokeV.booleanValue;
    }

    public static boolean isPraiseEnabled(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (!PraiseResourceAPSManager.getInstance().hasValidProvider()) {
                boolean z = DEBUG;
                return false;
            } else if (ComboPraiseRuntime.getContext() != null && !ComboPraiseRuntime.getContext().getPraiseSwitchState()) {
                boolean z2 = DEBUG;
                return false;
            } else {
                IResourceProvider provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL);
                if (provider != null && provider.getPackageList() != null && !provider.getPackageList().isEmpty()) {
                    if (Build.VERSION.SDK_INT > 21 || !TextUtils.equals(str, PraiseSourceDef.NA_PRAISE_SRC_FEED)) {
                        return true;
                    }
                    boolean z3 = DEBUG;
                    return false;
                }
                boolean z4 = DEBUG;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isTargetView(View view, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, view, strArr)) == null) {
            if (view != null && strArr != null && strArr.length > 0) {
                String lowerCase = view.getClass().getSimpleName().toLowerCase(Locale.getDefault());
                for (String str : strArr) {
                    if (TextUtils.equals(lowerCase, str.toLowerCase(Locale.getDefault()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void onTouch(MotionEvent motionEvent, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65572, this, motionEvent, z) == null) || this.mInterceptTouchEvent) {
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

    private void parsePraiseSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
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
                String str = "IsNAOrWebCall:" + this.mIsNAOrWebCall + ", IsH5OrHNCall:" + this.mIsH5OrHNCall;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskWhenFirstShow(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, runnable) == null) || runnable == null || getPraiseView() == null) {
            return;
        }
        getPraiseView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this, runnable) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseManager this$0;
            public final /* synthetic */ Runnable val$runnable;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, runnable};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$runnable = runnable;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    this.this$0.getPraiseView().getViewTreeObserver().removeOnPreDrawListener(this);
                    this.this$0.mMainHandler.postDelayed(this.val$runnable, ComboPraiseManager.LONG_PRESS_TIME_MS + 50);
                    return true;
                }
                return invokeV.booleanValue;
            }
        });
    }

    public static View searchTargetView(View view, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, view, strArr)) == null) {
            if (view == null || isTargetView(view, strArr)) {
                return view;
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.addLast(view);
            while (!arrayDeque.isEmpty()) {
                View view2 = (View) arrayDeque.removeFirst();
                if (view2 != null) {
                    if (isTargetView(view2, strArr)) {
                        return view2;
                    }
                    if (view2 instanceof ViewGroup) {
                        int i2 = 0;
                        while (true) {
                            ViewGroup viewGroup = (ViewGroup) view2;
                            if (i2 < viewGroup.getChildCount()) {
                                arrayDeque.addLast(viewGroup.getChildAt(i2));
                                i2++;
                            }
                        }
                    }
                }
            }
            return null;
        }
        return (View) invokeLL.objValue;
    }

    private void setInterceptTouchEvent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65578, this, i2) == null) {
            if (i2 == 2) {
                i2 = 0;
            }
            this.mInterceptTouchEvent = i2 == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || this.mWindowTokenView == null || this.mPopupWindow == null || this.mIsPopupWindowShowing || (activity = this.mCtx) == null || activity.isFinishing()) {
            return;
        }
        this.mPopupWindow.showAtLocation(this.mWindowTokenView, 17, 0, 0);
        this.mIsPopupWindowShowing = true;
    }

    private void updateByCallbackIfNeeded() {
        IPraiseManagerCallback iPraiseManagerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65580, this) == null) || (iPraiseManagerCallback = this.mICallback) == null) {
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
        if (TextUtils.isEmpty(this.mICallback.getPraiseId())) {
            return;
        }
        setPraiseId(this.mICallback.getPraiseId());
    }

    private void updatePraiseResourceIfNeeded() {
        IResourceProvider provider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65581, this) == null) || this.mLastProvider == (provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL))) {
            return;
        }
        getPraiseView().setProvider(provider);
        this.mLastProvider = provider;
    }

    public void cancelAnimForced() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTouchListener.cancelAnimForced(null);
        }
    }

    public void enablePraiseStatusListener(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mPraiseStatusListenerEnabled = z;
        }
    }

    public boolean isAnimationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getPraiseView().isAnimationRunning() : invokeV.booleanValue;
    }

    public void notifyPraiseAnimStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            getPraiseView().setClickBlock(z);
        }
    }

    public void onTouchForNA(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            if (!isPraiseEnabled()) {
                boolean z = DEBUG;
                return;
            }
            this.mIsNAOrWebCall = true;
            updatePraiseResourceIfNeeded();
            if (enableInterceptionForNA()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.mTouchListener.onTouch(null, motionEvent);
                            return;
                        } else if (action != 3) {
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
    }

    public void onTouchForWeb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (!isPraiseEnabled()) {
                boolean z = DEBUG;
                return;
            }
            this.mIsNAOrWebCall = false;
            updatePraiseResourceIfNeeded();
            MotionEvent motionEvent = null;
            if (i2 == 0) {
                motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
            } else if (i2 == 1) {
                motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
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
    }

    public void setComboPraiseLongPressListener(ComboPraiseLongPressListener comboPraiseLongPressListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, comboPraiseLongPressListener) == null) && this.mComboPraiseLongPressListener == null) {
            this.mComboPraiseLongPressListener = comboPraiseLongPressListener;
        }
    }

    public ComboPraiseManager setFirstPraiseAnimEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mFirstPraiseAnimEnabled = z;
            return this;
        }
        return (ComboPraiseManager) invokeZ.objValue;
    }

    public ComboPraiseManager setHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            Rect rect = this.mPraiseConfig.mBaseRect;
            rect.bottom = rect.top + i2;
            return this;
        }
        return (ComboPraiseManager) invokeI.objValue;
    }

    public ComboPraiseManager setInterceptModeForNA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            setInterceptTouchEvent(2);
            return this;
        }
        return (ComboPraiseManager) invokeV.objValue;
    }

    public ComboPraiseManager setInterceptModeForWeb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            setInterceptTouchEvent(i2);
            return this;
        }
        return (ComboPraiseManager) invokeI.objValue;
    }

    public ComboPraiseManager setLeft(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mBaseRect.left = i2;
            return this;
        }
        return (ComboPraiseManager) invokeI.objValue;
    }

    public ComboPraiseManager setPraiseAnimListener(IExPraiseAnimListener iExPraiseAnimListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iExPraiseAnimListener)) == null) {
            this.mExAnimListener = iExPraiseAnimListener;
            return this;
        }
        return (ComboPraiseManager) invokeL.objValue;
    }

    public ComboPraiseManager setPraiseId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mPraiseId = TextUtils.isEmpty(str) ? "" : str.toLowerCase(Locale.getDefault());
            return this;
        }
        return (ComboPraiseManager) invokeL.objValue;
    }

    public ComboPraiseManager setPraiseManagerCallback(IPraiseManagerCallback iPraiseManagerCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, iPraiseManagerCallback)) == null) {
            this.mICallback = iPraiseManagerCallback;
            return this;
        }
        return (ComboPraiseManager) invokeL.objValue;
    }

    public ComboPraiseManager setPraiseSource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mPraiseSource = TextUtils.isEmpty(str) ? "" : str.toLowerCase(Locale.getDefault());
            parsePraiseSource();
            return this;
        }
        return (ComboPraiseManager) invokeL.objValue;
    }

    public ComboPraiseManager setTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mBaseRect.top = i2;
            return this;
        }
        return (ComboPraiseManager) invokeI.objValue;
    }

    public ComboPraiseManager setUBCParams(ComboPraiseUBC comboPraiseUBC) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, comboPraiseUBC)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            this.mPraiseConfig.mUBC = comboPraiseUBC;
            return this;
        }
        return (ComboPraiseManager) invokeL.objValue;
    }

    public ComboPraiseManager setWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (getPraiseView().isAnimationRunning()) {
                return this;
            }
            Rect rect = this.mPraiseConfig.mBaseRect;
            rect.right = rect.left + i2;
            return this;
        }
        return (ComboPraiseManager) invokeI.objValue;
    }

    public static void parsePraiseSource(String str, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, str, zArr) == null) {
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
            } else if (!substring.equalsIgnoreCase("hn") && !substring.equalsIgnoreCase("sn")) {
                zArr[0] = true;
            } else {
                zArr[0] = false;
                zArr[1] = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouch(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65573, this, z) == null) && this.mInterceptTouchEvent) {
            this.mTouchListener.setInterceptMode(true);
            this.mTouchListener.setWebMode(!z);
            if (!z) {
                this.mTouchListener.autoCancelIfNeeded(null);
            }
            configPopupWindow();
            runTaskWhenFirstShow(new Runnable(this) { // from class: com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.getPraiseView().click();
                    }
                }
            });
            show();
        }
    }

    private boolean isPraiseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) ? isPraiseEnabled(this.mPraiseConfig.mPraiseSource) : invokeV.booleanValue;
    }
}
