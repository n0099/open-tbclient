package com.baidu.searchbox.ui.animview.praise.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.ClickIntervalTracker;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.praise.PraiseInfoManager;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseConfig;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.data.PraiseSourceDef;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx;
import com.baidu.searchbox.ui.animview.praise.element.PraiseLevelAnimElement;
import com.baidu.searchbox.ui.animview.praise.element.ShakeAnimElement;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class ComboPraiseView extends View implements IPraiseAnimListener {
    private static final int DEBUG_PAINT_COLOR = -65536;
    private static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    private static final int DEBUG_PAINT_TEXT_SIZE = 15;
    private static final String DEBUG_TEXT_CONSTANT = "浮层显示中(DEBUG模式，仅用于测试)";
    private static final int ERUPTION_ANIM_MAX_COUNTS = 2;
    private static final int ERUPTION_MAX_DURATION_MS = 1000;
    private static final int NUMBER_VISIBLE_MAX_CLICK_COUNTS = 2000;
    private static final int PERFORM_STATE_INIT = 0;
    private static final int PERFORM_STATE_RUNNING = 1;
    private static final String PKG_TAG_DAY_L = "day_l";
    private static final String PKG_TAG_DAY_M = "day_m";
    private static final String PKG_TAG_DAY_R = "day_r";
    private static final String PKG_TAG_NIGHT_L = "night_l";
    private static final String PKG_TAG_NIGHT_M = "night_m";
    private static final String PKG_TAG_NIGHT_R = "night_r";
    private static final int PRAISELEVEL_DURATION_MS_SCALE_IN = 700;
    private static final int PRAISELEVEL_DURATION_MS_SCALE_OUT = 200;
    private static final int PRAISELEVEL_DURATION_MS_VIBRATION_V1 = 350;
    private static final int PRAISELEVEL_DURATION_MS_VIBRATION_V2 = 250;
    private static final int PRAISELEVEL_DURATION_MS_VIBRATION_V3 = 150;
    private static final int SHAKE_DURATION_MS_SCALE_IN = 400;
    private static final int SHAKE_DURATION_MS_SHAKE_V1 = 400;
    private static final int SHAKE_DURATION_MS_SHAKE_V2 = 300;
    private static final int SHAKE_DURATION_MS_SHAKE_V3 = 200;
    private static final String TAG = "ComboPraiseView";
    private static final int WAVE_DURATION_MS = 400;
    private Map<Integer, AnimHolder> mAnimateMap;
    private Rect mBaseRect;
    private long mClickCounts;
    private boolean mClickLocked;
    private ClickIntervalTracker mClickTracker;
    private Context mContext;
    private String mDebugInfoText;
    private Paint mDebugPaint;
    private boolean mElementInitialed;
    private String mEruptionStrategy;
    private boolean mFirstPraiseAnimEnabled;
    private int mHeight;
    private long mInitClickCounts;
    private int mInteractRandomNum;
    private boolean mInteractShow;
    private boolean mIsDegradedMode;
    private ClickIntervalTracker.SpeedLevel mLastSpeedLevel;
    private int mLayoutStrategy;
    private List<IPraiseAnimListener> mListeners;
    private boolean mNightMode;
    private int mPerformState;
    private String mPkgTag;
    private String mPraiseId;
    private boolean mPraiseLevelTriggered;
    private String mPraiseSource;
    private IResourceProvider mResourceProvider;
    private int mRunningAnimeCounts;
    private boolean mStatusBarHeightFixed;
    private List<IPraiseStatusListener> mStatusListeners;
    private ComboPraiseUBC mUBC;
    private int mWidth;
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static boolean DEBUG_INFO_SWITCH = false;
    private static boolean ANCHOR_ZONE_SWITCH = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface IAction<T> {
        public static final int ACTION_BREAK = 1;
        public static final int ACTION_CONTINUE = 0;

        int doAction(T t);
    }

    public ComboPraiseView(Context context) {
        super(context);
        this.mDebugInfoText = "";
        this.mPerformState = 0;
        this.mPraiseLevelTriggered = false;
        this.mLayoutStrategy = -1;
        this.mBaseRect = new Rect();
        this.mPkgTag = "INVALID";
        this.mClickLocked = false;
        this.mClickTracker = new ClickIntervalTracker();
        this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
        this.mEruptionStrategy = "";
        this.mRunningAnimeCounts = 0;
        this.mFirstPraiseAnimEnabled = false;
        init(context);
    }

    public ComboPraiseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDebugInfoText = "";
        this.mPerformState = 0;
        this.mPraiseLevelTriggered = false;
        this.mLayoutStrategy = -1;
        this.mBaseRect = new Rect();
        this.mPkgTag = "INVALID";
        this.mClickLocked = false;
        this.mClickTracker = new ClickIntervalTracker();
        this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
        this.mEruptionStrategy = "";
        this.mRunningAnimeCounts = 0;
        this.mFirstPraiseAnimEnabled = false;
        init(context);
    }

    public ComboPraiseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDebugInfoText = "";
        this.mPerformState = 0;
        this.mPraiseLevelTriggered = false;
        this.mLayoutStrategy = -1;
        this.mBaseRect = new Rect();
        this.mPkgTag = "INVALID";
        this.mClickLocked = false;
        this.mClickTracker = new ClickIntervalTracker();
        this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
        this.mEruptionStrategy = "";
        this.mRunningAnimeCounts = 0;
        this.mFirstPraiseAnimEnabled = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addPraiseAnimListener(this);
        initDebugPaint();
        initInteractNum();
    }

    private void initDebugPaint() {
        if (this.mDebugPaint == null) {
            this.mDebugPaint = new Paint();
            this.mDebugPaint.setAntiAlias(true);
            this.mDebugPaint.setColor(-65536);
            this.mDebugPaint.setTextSize(DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f));
        }
    }

    public static void setDebugInfoVisibility(boolean z) {
        if (DEBUG) {
            DEBUG_INFO_SWITCH = z;
        }
    }

    public static boolean isDebugInfoVisible() {
        if (DEBUG) {
            return DEBUG_INFO_SWITCH;
        }
        return false;
    }

    public static void setAnchorZoneVisibility(boolean z) {
        if (DEBUG) {
            ANCHOR_ZONE_SWITCH = z;
        }
    }

    public static boolean isAnchorZoneVisible() {
        if (DEBUG) {
            return ANCHOR_ZONE_SWITCH;
        }
        return false;
    }

    public void setPraiseConfig(ComboPraiseConfig comboPraiseConfig) {
        setDebugInfo(comboPraiseConfig);
        setNightMode(comboPraiseConfig);
        setUBC(comboPraiseConfig);
        setCallerSource(comboPraiseConfig);
        setBaseRect(comboPraiseConfig);
        setOtherConfig(comboPraiseConfig);
    }

    private void setOtherConfig(ComboPraiseConfig comboPraiseConfig) {
        if (comboPraiseConfig != null) {
            this.mFirstPraiseAnimEnabled = comboPraiseConfig.mFirstPraiseAnimEnabled;
            comboPraiseConfig.mFirstPraiseAnimEnabled = false;
        }
    }

    private void setDebugInfo(ComboPraiseConfig comboPraiseConfig) {
        if (comboPraiseConfig != null) {
            StringBuilder sb = new StringBuilder();
            if (comboPraiseConfig.mIsNAOrWebCall) {
                sb.append("Caller: NA, ");
            } else if (comboPraiseConfig.mIsH5OrHNCall) {
                sb.append("Caller: H5, ");
            } else {
                sb.append("Caller: HN, ");
            }
            if (comboPraiseConfig.mInterceptTouchEvent) {
                sb.append("触摸事件: 点赞View接管");
            } else {
                sb.append("触摸事件: 点赞View不接管");
            }
            this.mDebugInfoText = sb.toString();
        }
    }

    private boolean setBaseRect(ComboPraiseConfig comboPraiseConfig) {
        if (isAnimationRunning() || comboPraiseConfig == null || comboPraiseConfig.mBaseRect == null) {
            return false;
        }
        this.mBaseRect = comboPraiseConfig.mBaseRect;
        this.mStatusBarHeightFixed = false;
        this.mPkgTag = "";
        this.mElementInitialed = false;
        return true;
    }

    private void applyCurrentPackage() {
        if (this.mBaseRect == null || this.mResourceProvider == null) {
            if (DEBUG) {
                Log.d(TAG, "applyCurrentPackage failed, mBaseRect or mResourceProvider is null");
                return;
            }
            return;
        }
        fixStatusBarHeightIfNeeded();
        String str = "";
        int calculateLayoutStrategy = ILayoutStrategy.Factory.calculateLayoutStrategy(this.mBaseRect, this.mWidth, this.mHeight);
        if (this.mNightMode) {
            switch (calculateLayoutStrategy) {
                case 0:
                    str = PKG_TAG_NIGHT_L;
                    break;
                case 1:
                    str = PKG_TAG_NIGHT_M;
                    break;
                case 2:
                    str = PKG_TAG_NIGHT_R;
                    break;
            }
        } else {
            switch (calculateLayoutStrategy) {
                case 0:
                    str = PKG_TAG_DAY_L;
                    break;
                case 1:
                    str = PKG_TAG_DAY_M;
                    break;
                case 2:
                    str = PKG_TAG_DAY_R;
                    break;
            }
        }
        if (!this.mResourceProvider.containPackage(str)) {
            if (DEBUG) {
                Log.d(TAG, "applyCurrentPackage failed, " + str + " is not contained");
            }
        } else if (!TextUtils.equals(str, this.mPkgTag) || calculateLayoutStrategy != this.mLayoutStrategy) {
            this.mResourceProvider.setCurrentPackage(str);
            this.mPkgTag = str;
            this.mLayoutStrategy = calculateLayoutStrategy;
            this.mElementInitialed = false;
            if (DEBUG) {
                Log.d(TAG, "applyCurrentPackage success, LayoutStrategy:" + calculateLayoutStrategy + ", PkgTag:" + this.mPkgTag);
            }
        }
    }

    private boolean setNightMode(ComboPraiseConfig comboPraiseConfig) {
        if (isAnimationRunning() || comboPraiseConfig == null) {
            return false;
        }
        this.mNightMode = comboPraiseConfig.mNightMode;
        return true;
    }

    private boolean setUBC(ComboPraiseConfig comboPraiseConfig) {
        if (isAnimationRunning() || comboPraiseConfig == null || comboPraiseConfig.mUBC == null) {
            return false;
        }
        this.mUBC = comboPraiseConfig.mUBC;
        return true;
    }

    private boolean setCallerSource(ComboPraiseConfig comboPraiseConfig) {
        if (isAnimationRunning()) {
            return false;
        }
        if (comboPraiseConfig == null) {
            this.mPraiseSource = "";
            this.mPraiseId = "";
            this.mClickCounts = 0L;
            this.mInitClickCounts = this.mClickCounts;
            return false;
        }
        this.mPraiseSource = TextUtils.isEmpty(comboPraiseConfig.mPraiseSource) ? "" : comboPraiseConfig.mPraiseSource;
        this.mPraiseId = TextUtils.isEmpty(comboPraiseConfig.mPraiseId) ? "" : comboPraiseConfig.mPraiseId;
        this.mClickCounts = PraiseInfoManager.getInstance().getPraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId));
        if (this.mClickCounts == -1) {
            this.mClickCounts = 0L;
        }
        this.mInitClickCounts = this.mClickCounts;
        return true;
    }

    public boolean setProvider(String str, String str2) {
        if (isAnimationRunning() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.mResourceProvider != null) {
            this.mResourceProvider.releaseResource();
        }
        this.mResourceProvider = new ComboPraiseProvider.Builder(this.mContext).setZipInputPath(str).setUnZipOutputPath(str2).build();
        this.mElementInitialed = false;
        return this.mResourceProvider != null;
    }

    public boolean setProvider(String str) {
        if (isAnimationRunning() || TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mResourceProvider != null) {
            this.mResourceProvider.releaseResource();
        }
        this.mResourceProvider = new ComboPraiseProvider.Builder(this.mContext).setProcessedResourcePath(str).build();
        this.mElementInitialed = false;
        return this.mResourceProvider != null;
    }

    public boolean setProvider(IResourceProvider iResourceProvider) {
        if (isAnimationRunning()) {
            return false;
        }
        if (this.mResourceProvider != null) {
            this.mResourceProvider.releaseResource();
        }
        this.mResourceProvider = iResourceProvider;
        this.mElementInitialed = false;
        return this.mResourceProvider != null;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        applyCurrentPackage();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        applyCurrentPackage();
    }

    private boolean generateAnimationIfNeeded() {
        if (this.mResourceProvider == null) {
            if (DEBUG) {
                Log.d(TAG, "generateAnimationIfNeeded failed, mResourceProvider is null");
                return false;
            }
            return false;
        } else if (!this.mResourceProvider.containPackage(this.mPkgTag)) {
            if (DEBUG) {
                Log.d(TAG, "generateAnimationIfNeeded failed, " + this.mPkgTag + " is not contained");
                return false;
            }
            return false;
        } else if (this.mElementInitialed) {
            return true;
        } else {
            releaseResource();
            Map<Integer, List<IAnimatedElement>> elementsWithPreBuild = getElementsWithPreBuild();
            addDataToAnimateMap(elementsWithPreBuild, 0);
            addDataToAnimateMap(elementsWithPreBuild, 1);
            addDataToAnimateMap(elementsWithPreBuild, 2);
            addDataToAnimateMap(elementsWithPreBuild, 3);
            addDataToAnimateMap(elementsWithPreBuild, 4);
            this.mElementInitialed = true;
            if (DEBUG) {
                Log.d(TAG, "generateAnimationIfNeeded success, LayoutStrategy:" + this.mLayoutStrategy + ", PkgTag:" + this.mPkgTag);
            }
            return true;
        }
    }

    private Map<Integer, List<IAnimatedElement>> getElements() {
        HashMap hashMap = new HashMap();
        hashMap.put(4, 2);
        return new PraiseAnimElementBuilder(this.mContext, 0).setBaseLeft(this.mBaseRect.left).setBaseTop(this.mBaseRect.top).setBaseWidth(this.mBaseRect.width()).setBaseHeight(this.mBaseRect.height()).setDrawableCallback(this).setResourceProvider(this.mResourceProvider).setLayoutStrategy(this.mLayoutStrategy).setCanvasSize(this.mWidth, this.mHeight).setElementCnts(hashMap).build();
    }

    private Map<Integer, List<IAnimatedElement>> getElementsWithPreBuild() {
        IPraiseElementBuilder.FetchConfig fetchConfig = new IPraiseElementBuilder.FetchConfig();
        fetchConfig.setLeft(this.mBaseRect.left).setTop(this.mBaseRect.top).setWidth(this.mBaseRect.width()).setHeight(this.mBaseRect.height()).setDrawableCallback(this).setStrategy(this.mLayoutStrategy).setCanvasHeight(this.mHeight).setCanvasWidth(this.mWidth).setPkgTag(this.mPkgTag);
        return PraiseAnimElementBuilderEx.getInstance().getResult(fetchConfig);
    }

    private void addDataToAnimateMap(Map<Integer, List<IAnimatedElement>> map, int i) {
        if (map != null && !map.isEmpty()) {
            if (this.mAnimateMap == null) {
                this.mAnimateMap = new HashMap();
            }
            List<IAnimatedElement> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                AnimHolder newInstance = AnimHolder.newInstance(i, list);
                if (newInstance.mHeader != null) {
                    newInstance.mHeader.animHolderUnusedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                        public int doAction(AnimHolder animHolder) {
                            animHolder.mAnimatedElement.setVisibility(false);
                            return 0;
                        }
                    });
                }
                this.mAnimateMap.put(Integer.valueOf(i), newInstance);
                initValueAnimator(i, newInstance);
            }
        }
    }

    private void initValueAnimator(int i, AnimHolder animHolder) {
        if (animHolder != null) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 4:
                    if (animHolder.mHeader != null) {
                        animHolder.mHeader.animHolderUnusedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                            public int doAction(AnimHolder animHolder2) {
                                animHolder2.mAnimator.setDuration(ComboPraiseView.this.getElementDuration(animHolder2, ClickIntervalTracker.SpeedLevel.V1));
                                animHolder2.mAnimator.addUpdateListener(ComboPraiseView.this.getAnimatorUpdateListener(animHolder2));
                                animHolder2.mAnimator.addListener(ComboPraiseView.this.getAnimatorListener(animHolder2));
                                return 0;
                            }
                        });
                        return;
                    }
                    animHolder.mAnimator.setDuration(getElementDuration(animHolder, ClickIntervalTracker.SpeedLevel.V1));
                    animHolder.mAnimator.addUpdateListener(getAnimatorUpdateListener(animHolder));
                    animHolder.mAnimator.addListener(getAnimatorListener(animHolder));
                    return;
                case 3:
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator.AnimatorUpdateListener getAnimatorUpdateListener(final AnimHolder animHolder) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (animHolder != null) {
                    animHolder.mCurrentFraction = valueAnimator.getAnimatedFraction();
                    ComboPraiseView.this.invalidate();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener getAnimatorListener(final AnimHolder animHolder) {
        return new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ComboPraiseView.this.processAnimationStart(animHolder);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ComboPraiseView.this.post(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ComboPraiseView.this.processAnimationEnd(animHolder);
                    }
                });
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ComboPraiseView.this.processAnimationCancel(animHolder);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
    }

    private String speedLvlToEruptionStrategy(ClickIntervalTracker.SpeedLevel speedLevel) {
        if (DEBUG) {
            Log.d(TAG, "SpeedLevel = " + speedLevel);
        }
        if (speedLevel == this.mLastSpeedLevel) {
            return this.mEruptionStrategy;
        }
        this.mLastSpeedLevel = speedLevel;
        StringBuilder sb = new StringBuilder();
        switch (this.mLayoutStrategy) {
            case 0:
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_LEFT);
                break;
            case 1:
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_MIDDLE);
                break;
            case 2:
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_RIGHT);
                break;
            default:
                this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
                break;
        }
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        switch (speedLevel) {
            case V1:
                sb.append("M");
                break;
            case V2:
                sb.append("N");
                break;
            case V3:
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_H);
                break;
            default:
                this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
                break;
        }
        this.mEruptionStrategy = sb.toString();
        if (DEBUG) {
            Log.d(TAG, "EruptionStrategy = " + this.mEruptionStrategy);
        }
        return this.mEruptionStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationStart(AnimHolder animHolder) {
        if (animHolder != null) {
            animHolder.mHasPendingClickEvent = false;
            animHolder.mPerformCounts++;
            animHolder.mState = 1;
            animHolder.mAnimatedElement.setVisibility(true);
            switch (animHolder.mKey) {
                case 0:
                    this.mRunningAnimeCounts++;
                    return;
                case 1:
                    animHolder.mAnimatedElement.setVisibility(false);
                    this.mRunningAnimeCounts++;
                    ((ShakeAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
                    return;
                case 2:
                    this.mRunningAnimeCounts++;
                    ((PraiseLevelAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
                    return;
                case 3:
                default:
                    return;
                case 4:
                    this.mRunningAnimeCounts++;
                    ((EruptionAnimatedGroup) animHolder.mAnimatedElement).updateCurrentStrategy(speedLvlToEruptionStrategy(this.mClickTracker.getSpeedLevel()));
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationEnd(AnimHolder animHolder) {
        if (animHolder != null) {
            switch (animHolder.mKey) {
                case 0:
                case 4:
                    this.mRunningAnimeCounts--;
                    if (willRepeat(animHolder)) {
                        animHolder.mAnimator.start();
                        break;
                    } else {
                        animHolder.mState = 0;
                        animHolder.mPerformCounts = 0L;
                        setElementInvisible(animHolder);
                        break;
                    }
                case 1:
                    this.mRunningAnimeCounts--;
                    if (willRepeat(animHolder)) {
                        animHolder.mAnimatedElement.setInterpolator(null);
                        animHolder.mShowType = 1;
                        animHolder.mAnimator.setDuration(getElementDuration(animHolder, this.mClickTracker.getSpeedLevel()));
                        animHolder.mAnimator.start();
                        break;
                    } else {
                        animHolder.mState = 0;
                        animHolder.mPerformCounts = 0L;
                        setElementInvisible(animHolder);
                        break;
                    }
                case 2:
                    this.mRunningAnimeCounts--;
                    if (willRepeat(animHolder)) {
                        animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                        animHolder.mShowType = 1;
                        animHolder.mAnimator.setDuration(getElementDuration(animHolder, this.mClickTracker.getSpeedLevel()));
                        animHolder.mAnimator.start();
                        break;
                    } else if (animHolder.mState == 1) {
                        animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                        animHolder.mShowType = 2;
                        animHolder.mAnimator.setDuration(getElementDuration(animHolder, ClickIntervalTracker.SpeedLevel.V1));
                        animHolder.mAnimator.start();
                        animHolder.mState = 0;
                        if (this.mAnimateMap != null) {
                            setElementInvisible(this.mAnimateMap.get(3));
                        }
                        this.mClickLocked = true;
                        return;
                    } else {
                        animHolder.mPerformCounts = 0L;
                        setElementInvisible(animHolder);
                        break;
                    }
            }
            notifyAnimationEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getElementDuration(AnimHolder animHolder, ClickIntervalTracker.SpeedLevel speedLevel) {
        if (animHolder == null) {
            return 0;
        }
        switch (animHolder.mKey) {
            case 0:
                return 400;
            case 1:
                if (animHolder.mShowType != 0 && speedLevel != ClickIntervalTracker.SpeedLevel.V1) {
                    if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                        return 300;
                    }
                    return speedLevel == ClickIntervalTracker.SpeedLevel.V3 ? 200 : 0;
                }
                return 400;
            case 2:
                if (animHolder.mShowType == 0) {
                    return 700;
                }
                if (animHolder.mShowType == 2) {
                    return 200;
                }
                if (speedLevel == ClickIntervalTracker.SpeedLevel.V1) {
                    return PRAISELEVEL_DURATION_MS_VIBRATION_V1;
                }
                if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                    return 250;
                }
                return speedLevel == ClickIntervalTracker.SpeedLevel.V3 ? 150 : 0;
            case 3:
            default:
                return 0;
            case 4:
                return 1000;
        }
    }

    private void setElementInvisible(AnimHolder animHolder) {
        AnimHolder animHolder2;
        if (animHolder != null) {
            switch (animHolder.mKey) {
                case 0:
                    animHolder.mAnimatedElement.setVisibility(false);
                    return;
                case 1:
                default:
                    return;
                case 2:
                    animHolder.mAnimatedElement.setVisibility(false);
                    if (this.mAnimateMap != null && (animHolder2 = this.mAnimateMap.get(1)) != null) {
                        animHolder2.mAnimatedElement.setVisibility(false);
                        return;
                    }
                    return;
                case 3:
                    animHolder.mAnimatedElement.setVisibility(false);
                    return;
                case 4:
                    animHolder.mAnimatedElement.setVisibility(false);
                    return;
            }
        }
    }

    private boolean willRepeat(AnimHolder animHolder) {
        if (this.mPerformState != 1 || animHolder == null) {
            return false;
        }
        switch (animHolder.mKey) {
            case 0:
            case 3:
            default:
                return false;
            case 1:
            case 2:
                return animHolder.mHasPendingClickEvent;
            case 4:
                if (animHolder.mHeader != null) {
                    animHolder.mHeader.recycleUsedAnimHolder(animHolder);
                    return false;
                }
                return animHolder.mHasPendingClickEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationCancel(AnimHolder animHolder) {
        if (animHolder != null) {
            animHolder.mState = 0;
            animHolder.mPerformCounts = 0L;
        }
    }

    public void setClickBlock(boolean z) {
        this.mClickLocked = z;
    }

    public void click() {
        if (!this.mClickLocked) {
            if (!generateAnimationIfNeeded()) {
                applyCurrentPackage();
                notifyAnimationStart();
                notifyAnimationEnd();
                if (DEBUG) {
                    Log.d(TAG, "generateAnimationIfNeeded failed");
                    return;
                }
                return;
            }
            if (PraiseEnvironment.getPerformanceLevel() == PraiseEnvironment.Performance.LEVEL_1) {
                this.mIsDegradedMode = true;
                this.mClickLocked = true;
            }
            if (TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST)) {
                this.mClickLocked = true;
            }
            this.mClickTracker.setInitialClickCounts(this.mInitClickCounts);
            this.mClickTracker.addClick();
            sendPendingClickEvent();
            this.mClickCounts++;
            switch (this.mPerformState) {
                case 0:
                    this.mPerformState = 1;
                    this.mInitClickCounts = this.mClickCounts - 1;
                    batchStartAnimation();
                    if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource) && this.mFirstPraiseAnimEnabled) {
                        if (DEBUG) {
                            Log.d(TAG, "FirstPraiseAnim trigger");
                        }
                        triggerPraiseLevelAnimationIfNeeded();
                        break;
                    }
                    break;
                case 1:
                    triggerPraiseLevelAnimationIfNeeded();
                    triggerEruptionAnimation(false);
                    break;
            }
            triggerPraiseNumberAnimation();
        }
    }

    private void sendPendingClickEvent() {
        mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
            public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                AnimHolder value = entry.getValue();
                if (value.mHeader != null) {
                    value.mHeader.animHolderUsedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                        public int doAction(AnimHolder animHolder) {
                            animHolder.mHasPendingClickEvent = true;
                            return 0;
                        }
                    });
                    return 0;
                }
                value.mHasPendingClickEvent = true;
                return 0;
            }
        });
    }

    private void batchStartAnimation() {
        notifyAnimationStart();
        mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
            public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                AnimHolder value = entry.getValue();
                if (value.mHeader == null) {
                    value.mPerformCounts = ComboPraiseView.this.mClickCounts - 1;
                    value.mState = 0;
                    value.mCurrentFraction = 0.0f;
                    value.mAnimatedElement.setVisibility(false);
                }
                switch (value.mKey) {
                    case 0:
                        if (!TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) && !TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                            value.mAnimator.start();
                            break;
                        }
                        break;
                    case 1:
                        if (!TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) && !TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                            value.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                            value.mShowType = 0;
                            value.mAnimator.start();
                            break;
                        }
                        break;
                    case 2:
                        value.mShowType = 0;
                        break;
                    case 3:
                        value.mAnimatedElement.setVisibility(true);
                        break;
                    case 4:
                        if (!PraiseEnvironment.isFirstPraiseAnimSupported(ComboPraiseView.this.mPraiseSource) || !ComboPraiseView.this.mFirstPraiseAnimEnabled) {
                            ComboPraiseView.this.triggerEruptionAnimation(true);
                            break;
                        } else if (ComboPraiseView.DEBUG) {
                            Log.d(ComboPraiseView.TAG, "FirstPraiseAnim trigger");
                            break;
                        }
                        break;
                }
                return 0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEruptionAnimation(boolean z) {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(4)) != null) {
            if (animHolder.mHeader != null || z) {
                if (animHolder.mHeader != null) {
                    animHolder = animHolder.mHeader.getUnunsedAnimHolder();
                }
                if (animHolder != null) {
                    animHolder.mPerformCounts = this.mClickCounts - 1;
                    animHolder.mState = 0;
                    animHolder.mCurrentFraction = 0.0f;
                    animHolder.mAnimatedElement.setVisibility(false);
                    animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                    animHolder.mAnimator.start();
                }
            }
        }
    }

    private void triggerPraiseLevelAnimationIfNeeded() {
        AnimHolder animHolder;
        if (!TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) && !this.mPraiseLevelTriggered && this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(2)) != null) {
            this.mPraiseLevelTriggered = true;
            animHolder.mAnimator.start();
        }
    }

    private void triggerPraiseNumberAnimation() {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(3)) != null && animHolder.mHasPendingClickEvent) {
            animHolder.mPerformCounts++;
            animHolder.mHasPendingClickEvent = false;
        }
    }

    private void drawDebugInfo(Canvas canvas) {
        if (DEBUG_INFO_SWITCH) {
            this.mDebugPaint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f));
            this.mDebugPaint.setStyle(Paint.Style.FILL);
            float measureText = (this.mWidth - this.mDebugPaint.measureText(DEBUG_TEXT_CONSTANT)) / 2.0f;
            float f = this.mHeight / 5.0f;
            float f2 = this.mDebugPaint.getFontMetrics().descent - this.mDebugPaint.getFontMetrics().ascent;
            canvas.drawText(DEBUG_TEXT_CONSTANT, measureText, f, this.mDebugPaint);
            String[] strArr = {this.mDebugInfoText, String.format("praiseSrc: %s", this.mPraiseSource), String.format("praiseId: %s", this.mPraiseId), String.format("资源名: %s", this.mPkgTag)};
            for (int i = 0; i < strArr.length; i++) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    f += 50.0f + f2;
                    canvas.drawText(strArr[i], (this.mWidth - this.mDebugPaint.measureText(strArr[i])) / 2.0f, f, this.mDebugPaint);
                }
            }
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
        }
    }

    private void drawAnchorZone(Canvas canvas) {
        if (ANCHOR_ZONE_SWITCH && this.mBaseRect != null) {
            this.mDebugPaint.setStrokeWidth(1.0f);
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(this.mBaseRect.left, this.mBaseRect.top, this.mBaseRect.right, this.mBaseRect.bottom, this.mDebugPaint);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawDebugInfo(canvas);
        drawAnchorZone(canvas);
        if (isAnimationRunning()) {
            performWaveAnimation(canvas);
            performEruptionAnimation(canvas);
            performPraiseLevelAnimation(canvas);
            performPraiseNumberAnimation(canvas);
            performShakeAnimation(canvas);
            notifyPraiseCntReachedIfNeeded();
        }
    }

    private void performEruptionAnimation(final Canvas canvas) {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(4)) != null) {
            if (animHolder.mHeader != null) {
                animHolder.mHeader.animHolderUsedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                    public int doAction(AnimHolder animHolder2) {
                        animHolder2.mAnimatedElement.dispatchAnimate(canvas, animHolder2.mCurrentFraction, animHolder2.mPerformCounts);
                        return 0;
                    }
                });
            } else {
                animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
            }
        }
    }

    private void performShakeAnimation(Canvas canvas) {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(1)) != null) {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
        }
    }

    private void performWaveAnimation(Canvas canvas) {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(0)) != null) {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
        }
    }

    private void performPraiseLevelAnimation(Canvas canvas) {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(2)) != null) {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, this.mClickCounts);
        }
    }

    private void performPraiseNumberAnimation(Canvas canvas) {
        AnimHolder animHolder;
        if (!TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) && this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(3)) != null && animHolder.mPerformCounts > this.mInitClickCounts + 1 && animHolder.mPerformCounts <= 2000) {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, 1.0f, animHolder.mPerformCounts);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseResource();
    }

    private void releaseResource() {
        mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
            public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                if (entry.getValue().mHeader == null) {
                    entry.getValue().mAnimatedElement.releaseResouces();
                    return 0;
                }
                return 0;
            }
        });
        if (this.mAnimateMap != null) {
            this.mAnimateMap.clear();
        }
        this.mElementInitialed = false;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
    public void onPraiseAnimStart() {
        this.mPraiseLevelTriggered = false;
        PraiseUBCHelper.beginPraiseAnimeFlow();
    }

    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
    public void onPraiseAnimEnd() {
        this.mInteractShow = false;
        this.mPerformState = 0;
        this.mStatusBarHeightFixed = false;
        this.mClickLocked = false;
        this.mClickTracker.reset();
        PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId), this.mClickCounts);
        this.mFirstPraiseAnimEnabled = false;
        PraiseUBCHelper.endPraiseAnimeFlow(this.mUBC, !this.mIsDegradedMode ? 1 : 0);
        PraiseUBCHelper.praiseUBCEvent(this.mUBC, this.mIsDegradedMode ? 0 : 1, this.mClickCounts - this.mInitClickCounts, PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId));
        this.mIsDegradedMode = false;
        invalidate();
    }

    public boolean isAnimationRunning() {
        return this.mPerformState != 0;
    }

    private void notifyAnimationStart() {
        if (this.mListeners != null && !this.mListeners.isEmpty()) {
            for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
                iPraiseAnimListener.onPraiseAnimStart();
            }
        }
    }

    private void notifyAnimationEnd() {
        if (this.mRunningAnimeCounts == 0 && this.mListeners != null && !this.mListeners.isEmpty()) {
            for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
                iPraiseAnimListener.onPraiseAnimEnd();
            }
        }
    }

    private void notifyPraiseCntReachedIfNeeded() {
        AnimHolder animHolder;
        if (this.mAnimateMap != null && !this.mAnimateMap.isEmpty() && (animHolder = this.mAnimateMap.get(3)) != null && animHolder.mPerformCounts == this.mInteractRandomNum && !this.mInteractShow && this.mStatusListeners != null && !this.mStatusListeners.isEmpty() && this.mUBC != null) {
            for (IPraiseStatusListener iPraiseStatusListener : this.mStatusListeners) {
                iPraiseStatusListener.onTargetPraiseCntReached(this.mInteractRandomNum, "praise_combo", this.mUBC.getUBCSource(), this.mUBC.getNid());
                this.mInteractShow = true;
            }
        }
    }

    public void addPraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(iPraiseAnimListener);
    }

    public void removePraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        if (this.mListeners != null) {
            this.mListeners.remove(iPraiseAnimListener);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
            }
        }
    }

    public void addPraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        if (this.mStatusListeners == null) {
            this.mStatusListeners = new ArrayList();
        }
        this.mStatusListeners.add(iPraiseStatusListener);
    }

    public void removePraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        if (this.mStatusListeners != null) {
            this.mStatusListeners.remove(iPraiseStatusListener);
            if (this.mStatusListeners.isEmpty()) {
                this.mStatusListeners = null;
            }
        }
    }

    private void mapForEach(IAction<Map.Entry<Integer, AnimHolder>> iAction) {
        if (iAction != null && this.mAnimateMap != null && !this.mAnimateMap.isEmpty()) {
            for (Map.Entry<Integer, AnimHolder> entry : this.mAnimateMap.entrySet()) {
                if (iAction != null && iAction.doAction(entry) == 1) {
                    return;
                }
            }
        }
    }

    private void fixStatusBarHeightIfNeeded() {
        if (!this.mStatusBarHeightFixed) {
            if (Build.VERSION.SDK_INT > 21) {
                if (DEBUG) {
                    Log.d(TAG, "no need to fix status bar height, API = " + Build.VERSION.SDK_INT + ", praiseSource = " + this.mPraiseSource);
                    return;
                }
                return;
            }
            boolean hasWindowFullscreenFlag = hasWindowFullscreenFlag();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (iArr[1] != 0 || hasWindowFullscreenFlag) {
                if (DEBUG) {
                    Log.d(TAG, "no need to fix status bar height, pos = " + Arrays.toString(iArr) + ", hasWindowFullscreenFlag return " + hasWindowFullscreenFlag);
                    return;
                }
                return;
            }
            this.mBaseRect.offset(0, DeviceUtil.ScreenInfo.getStatusBarHeight());
            this.mStatusBarHeightFixed = true;
            if (DEBUG) {
                Log.d(TAG, "need to fix status bar height(" + DeviceUtil.ScreenInfo.getStatusBarHeight() + ")");
            }
        }
    }

    private boolean hasWindowFullscreenFlag() {
        if (!(getContext() instanceof Activity)) {
            return false;
        }
        return ComboPraiseManager.hasWindowFullscreenFlag(((Activity) getContext()).getWindow());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class MultiAnimHolder extends AnimHolder {
        public List<AnimHolder> mUnusedAnimHolder;
        public List<AnimHolder> mUsedAnimHolder;

        private MultiAnimHolder() {
            super();
        }

        public void animHolderUnusedForEach(IAction<AnimHolder> iAction) {
            if (iAction != null && this.mUnusedAnimHolder != null && !this.mUnusedAnimHolder.isEmpty()) {
                Iterator<AnimHolder> it = this.mUnusedAnimHolder.iterator();
                while (it.hasNext() && iAction.doAction(it.next()) != 1) {
                }
            }
        }

        public void animHolderUsedForEach(IAction<AnimHolder> iAction) {
            if (iAction != null && this.mUsedAnimHolder != null && !this.mUsedAnimHolder.isEmpty()) {
                Iterator<AnimHolder> it = this.mUsedAnimHolder.iterator();
                while (it.hasNext() && iAction.doAction(it.next()) != 1) {
                }
            }
        }

        public AnimHolder getUnunsedAnimHolder() {
            if (this.mUnusedAnimHolder == null || this.mUnusedAnimHolder.isEmpty()) {
                return null;
            }
            AnimHolder remove = this.mUnusedAnimHolder.remove(0);
            if (this.mUsedAnimHolder == null) {
                this.mUsedAnimHolder = new ArrayList();
            }
            this.mUsedAnimHolder.add(remove);
            remove.mUsedCnts++;
            return remove;
        }

        public void recycleUsedAnimHolder(AnimHolder animHolder) {
            if (animHolder != null && !(animHolder instanceof MultiAnimHolder)) {
                animHolder.mAnimator.setStartDelay(0L);
                if (this.mUsedAnimHolder != null && !this.mUsedAnimHolder.isEmpty()) {
                    this.mUsedAnimHolder.remove(animHolder);
                }
                if (this.mUnusedAnimHolder == null) {
                    this.mUnusedAnimHolder = new ArrayList();
                }
                this.mUnusedAnimHolder.add(animHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class AnimHolder {
        public IAnimatedElement mAnimatedElement;
        public ValueAnimator mAnimator;
        public float mCurrentFraction;
        public boolean mHasPendingClickEvent;
        public MultiAnimHolder mHeader;
        public int mKey;
        public long mPerformCounts;
        public int mShowType;
        public int mState;
        public int mUsedCnts;

        private AnimHolder() {
        }

        private static ValueAnimator createValueAnimator(int i) {
            return ValueAnimator.ofFloat(0.0f, 1.0f);
        }

        public static AnimHolder newInstance(int i, IAnimatedElement iAnimatedElement) {
            AnimHolder animHolder = new AnimHolder();
            animHolder.mKey = i;
            animHolder.mUsedCnts = 0;
            animHolder.mState = 0;
            animHolder.mAnimatedElement = iAnimatedElement;
            animHolder.mAnimator = createValueAnimator(i);
            return animHolder;
        }

        public static AnimHolder newInstance(int i, List<IAnimatedElement> list) {
            int i2 = 0;
            if (list == null || list.isEmpty()) {
                return null;
            }
            if (list.size() == 1) {
                return newInstance(i, list.get(0));
            }
            MultiAnimHolder newHeaderInstance = newHeaderInstance(i);
            while (true) {
                int i3 = i2;
                if (i3 >= list.size()) {
                    return newHeaderInstance;
                }
                AnimHolder newInstance = newInstance(i, list.get(i3));
                newInstance.mHeader = newHeaderInstance;
                newHeaderInstance.mUnusedAnimHolder.add(newInstance);
                i2 = i3 + 1;
            }
        }

        private static MultiAnimHolder newHeaderInstance(int i) {
            MultiAnimHolder multiAnimHolder = new MultiAnimHolder();
            multiAnimHolder.mKey = i;
            multiAnimHolder.mState = 0;
            multiAnimHolder.mAnimatedElement = null;
            multiAnimHolder.mAnimator = null;
            multiAnimHolder.mUnusedAnimHolder = new ArrayList();
            multiAnimHolder.mHeader = multiAnimHolder;
            return multiAnimHolder;
        }
    }

    private void initInteractNum() {
        this.mInteractRandomNum = 1;
    }
}
