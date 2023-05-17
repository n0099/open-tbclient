package com.baidu.searchbox.ui.animview.praise.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.android.VibrateUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.IPraiseAnimView;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.ClickIntervalTracker;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener;
import com.baidu.searchbox.ui.animview.praise.IPraiseEncourageAnimListener;
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
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class ComboPraiseView extends View implements IPraiseAnimListener, IPraiseAnimView {
    public static final int DEBUG_PAINT_COLOR = -65536;
    public static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    public static final int DEBUG_PAINT_TEXT_SIZE = 15;
    public static final String DEBUG_TEXT_CONSTANT = "浮层显示中(DEBUG模式，仅用于测试)";
    public static final int DEFAULT_VIBRATE_AMPLITUDE = 30;
    public static final int DEFAULT_VIBRATE_TIMING = 90;
    public static final int ERUPTION_ANIM_MAX_COUNTS = 2;
    public static final int ERUPTION_MAX_DURATION_MS = 1000;
    public static final int NUMBER_VISIBLE_MAX_CLICK_COUNTS = 2000;
    public static final int PERFORM_STATE_INIT = 0;
    public static final int PERFORM_STATE_RUNNING = 1;
    public static final String PKG_TAG_DAY_L = "day_l";
    public static final String PKG_TAG_DAY_M = "day_m";
    public static final String PKG_TAG_DAY_R = "day_r";
    public static final String PKG_TAG_NIGHT_L = "night_l";
    public static final String PKG_TAG_NIGHT_M = "night_m";
    public static final String PKG_TAG_NIGHT_R = "night_r";
    public static final int PRAISELEVEL_DURATION_MS_SCALE_IN = 700;
    public static final int PRAISELEVEL_DURATION_MS_SCALE_OUT = 200;
    public static final int PRAISELEVEL_DURATION_MS_VIBRATION_V1 = 350;
    public static final int PRAISELEVEL_DURATION_MS_VIBRATION_V2 = 250;
    public static final int PRAISELEVEL_DURATION_MS_VIBRATION_V3 = 150;
    public static final int SHAKE_DURATION_MS_SCALE_IN = 400;
    public static final int SHAKE_DURATION_MS_SHAKE_V1 = 400;
    public static final int SHAKE_DURATION_MS_SHAKE_V2 = 300;
    public static final int SHAKE_DURATION_MS_SHAKE_V3 = 200;
    public static final String TAG = "ComboPraiseView";
    public static final int WAVE_DURATION_MS = 400;
    public Map<Integer, AnimHolder> mAnimateMap;
    public Rect mBaseRect;
    public long mClickCounts;
    public boolean mClickLocked;
    public ClickIntervalTracker mClickTracker;
    public Context mContext;
    public String mDebugInfoText;
    public Paint mDebugPaint;
    public boolean mElementInitialed;
    public boolean mEnableVibrate;
    public IPraiseEncourageAnimListener mEncourageAnimListener;
    public String mEruptionStrategy;
    public boolean mFirstPraiseAnimEnabled;
    public int mHeight;
    public long mInitClickCounts;
    public int mInteractRandomNum;
    public boolean mInteractShow;
    public boolean mIsDegradedMode;
    public ClickIntervalTracker.SpeedLevel mLastSpeedLevel;
    public int mLayoutStrategy;
    public List<IPraiseAnimListener> mListeners;
    public boolean mNightMode;
    public int mPerformState;
    public String mPkgTag;
    public String mPraiseId;
    public boolean mPraiseLevelTriggered;
    public String mPraiseSource;
    public IResourceProvider mResourceProvider;
    public int mRunningAnimeCounts;
    public boolean mStatusBarHeightFixed;
    public List<IPraiseStatusListener> mStatusListeners;
    public ComboPraiseUBC mUBC;
    public int mVibrateAmplitude;
    public long mVibrateTime;
    public int mWidth;
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static boolean sDebugInfoSwitch = false;
    public static boolean sAnchorZoneSwitch = false;

    /* loaded from: classes4.dex */
    public interface IAction<T> {
        public static final int ACTION_BREAK = 1;
        public static final int ACTION_CONTINUE = 0;

        int doAction(T t);
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public boolean enablePopTouchable() {
        return false;
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    @NonNull
    public View getViewInstance() {
        return this;
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void setLongClickStatus(boolean z) {
    }

    /* renamed from: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel;

        static {
            int[] iArr = new int[ClickIntervalTracker.SpeedLevel.values().length];
            $SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel = iArr;
            try {
                iArr[ClickIntervalTracker.SpeedLevel.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel[ClickIntervalTracker.SpeedLevel.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel[ClickIntervalTracker.SpeedLevel.V3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
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

        public AnimHolder() {
        }

        public static ValueAnimator createValueAnimator(int i) {
            return ValueAnimator.ofFloat(0.0f, 1.0f);
        }

        public static MultiAnimHolder newHeaderInstance(int i) {
            MultiAnimHolder multiAnimHolder = new MultiAnimHolder();
            multiAnimHolder.mKey = i;
            multiAnimHolder.mState = 0;
            multiAnimHolder.mAnimatedElement = null;
            multiAnimHolder.mAnimator = null;
            multiAnimHolder.mUnusedAnimHolder = new ArrayList();
            multiAnimHolder.mHeader = multiAnimHolder;
            return multiAnimHolder;
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
            if (list != null && !list.isEmpty()) {
                if (list.size() == 1) {
                    return newInstance(i, list.get(0));
                }
                MultiAnimHolder newHeaderInstance = newHeaderInstance(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    AnimHolder newInstance = newInstance(i, list.get(i2));
                    newInstance.mHeader = newHeaderInstance;
                    newHeaderInstance.mUnusedAnimHolder.add(newInstance);
                }
                return newHeaderInstance;
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class MultiAnimHolder extends AnimHolder {
        public List<AnimHolder> mUnusedAnimHolder;
        public List<AnimHolder> mUsedAnimHolder;

        public MultiAnimHolder() {
            super();
        }

        public AnimHolder getUnunsedAnimHolder() {
            List<AnimHolder> list = this.mUnusedAnimHolder;
            if (list != null && !list.isEmpty()) {
                AnimHolder remove = this.mUnusedAnimHolder.remove(0);
                if (this.mUsedAnimHolder == null) {
                    this.mUsedAnimHolder = new ArrayList();
                }
                this.mUsedAnimHolder.add(remove);
                remove.mUsedCnts++;
                return remove;
            }
            return null;
        }

        public void animHolderUnusedForEach(IAction<AnimHolder> iAction) {
            List<AnimHolder> list;
            if (iAction != null && (list = this.mUnusedAnimHolder) != null && !list.isEmpty()) {
                Iterator<AnimHolder> it = this.mUnusedAnimHolder.iterator();
                while (it.hasNext() && iAction.doAction(it.next()) != 1) {
                }
            }
        }

        public void animHolderUsedForEach(IAction<AnimHolder> iAction) {
            List<AnimHolder> list;
            if (iAction != null && (list = this.mUsedAnimHolder) != null && !list.isEmpty()) {
                Iterator<AnimHolder> it = this.mUsedAnimHolder.iterator();
                while (it.hasNext() && iAction.doAction(it.next()) != 1) {
                }
            }
        }

        public void recycleUsedAnimHolder(AnimHolder animHolder) {
            if (animHolder != null && !(animHolder instanceof MultiAnimHolder)) {
                animHolder.mAnimator.setStartDelay(0L);
                List<AnimHolder> list = this.mUsedAnimHolder;
                if (list != null && !list.isEmpty()) {
                    this.mUsedAnimHolder.remove(animHolder);
                }
                if (this.mUnusedAnimHolder == null) {
                    this.mUnusedAnimHolder = new ArrayList();
                }
                this.mUnusedAnimHolder.add(animHolder);
            }
        }
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
                int i = value.mKey;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    if (PraiseEnvironment.isFirstPraiseAnimSupported(ComboPraiseView.this.mPraiseSource) && ComboPraiseView.this.mFirstPraiseAnimEnabled) {
                                        if (ComboPraiseView.DEBUG) {
                                            Log.d(ComboPraiseView.TAG, "FirstPraiseAnim trigger");
                                        }
                                    } else {
                                        ComboPraiseView.this.triggerEruptionAnimation(true);
                                    }
                                }
                            } else {
                                value.mAnimatedElement.setVisibility(true);
                            }
                        } else {
                            value.mShowType = 0;
                        }
                    } else if (TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) || TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                        return 0;
                    } else {
                        value.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                        value.mShowType = 0;
                        value.mAnimator.start();
                    }
                } else if (!TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) && !TextUtils.equals(ComboPraiseView.this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                    value.mAnimator.start();
                }
                return 0;
            }
        });
    }

    private boolean hasWindowFullscreenFlag() {
        if (!(getContext() instanceof Activity)) {
            return false;
        }
        return ComboPraiseManager.hasWindowFullscreenFlag(((Activity) getContext()).getWindow());
    }

    private void initDebugPaint() {
        if (this.mDebugPaint != null) {
            return;
        }
        Paint paint = new Paint();
        this.mDebugPaint = paint;
        paint.setAntiAlias(true);
        this.mDebugPaint.setColor(-65536);
        this.mDebugPaint.setTextSize(DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f));
    }

    private void initInteractNum() {
        this.mInteractRandomNum = 1;
    }

    public static boolean isAnchorZoneVisible() {
        if (DEBUG) {
            return sAnchorZoneSwitch;
        }
        return false;
    }

    public static boolean isDebugInfoVisible() {
        if (DEBUG) {
            return sDebugInfoSwitch;
        }
        return false;
    }

    private void notifyAnimationEnd() {
        List<IPraiseAnimListener> list;
        if (this.mRunningAnimeCounts == 0 && (list = this.mListeners) != null && !list.isEmpty()) {
            for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
                iPraiseAnimListener.onPraiseAnimEnd();
            }
        }
    }

    private void notifyAnimationStart() {
        List<IPraiseAnimListener> list = this.mListeners;
        if (list != null && !list.isEmpty()) {
            for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
                iPraiseAnimListener.onPraiseAnimStart();
            }
        }
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
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map != null) {
            map.clear();
        }
        this.mElementInitialed = false;
    }

    private void sendPendingClickEvent() {
        mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
            public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                AnimHolder value = entry.getValue();
                MultiAnimHolder multiAnimHolder = value.mHeader;
                if (multiAnimHolder != null) {
                    multiAnimHolder.animHolderUsedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5.1
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

    private void triggerPraiseNumberAnimation() {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map != null && !map.isEmpty() && (animHolder = this.mAnimateMap.get(3)) != null && animHolder.mHasPendingClickEvent) {
            animHolder.mPerformCounts++;
            animHolder.mHasPendingClickEvent = false;
        }
    }

    private void vibrate() {
        new VibrateUtils.Builder((Vibrator) AppRuntime.getAppContext().getSystemService("vibrator"), new long[]{this.mVibrateTime}, AppRuntime.getAppContext()).amplitudes(new int[]{this.mVibrateAmplitude}).build().vibrateStart();
    }

    public boolean isAnimationRunning() {
        if (this.mPerformState != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseResource();
    }

    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
    public void onPraiseAnimStart() {
        this.mPraiseLevelTriggered = false;
        PraiseUBCHelper.beginPraiseAnimeFlow();
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
        this.mEnableVibrate = true;
        this.mVibrateAmplitude = 30;
        this.mVibrateTime = 90L;
        init(context);
    }

    private void performPraiseNumberAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        if (TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(3)) == null) {
            return;
        }
        long j = animHolder.mPerformCounts;
        if (j > this.mInitClickCounts + 1 && j <= 2000) {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, 1.0f, j);
        }
    }

    private void setDebugInfo(ComboPraiseConfig comboPraiseConfig) {
        if (comboPraiseConfig == null) {
            return;
        }
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

    private void setElementInvisible(AnimHolder animHolder) {
        AnimHolder animHolder2;
        if (animHolder == null) {
            return;
        }
        int i = animHolder.mKey;
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        animHolder.mAnimatedElement.setVisibility(false);
                        return;
                    }
                    return;
                }
                animHolder.mAnimatedElement.setVisibility(false);
                return;
            }
            animHolder.mAnimatedElement.setVisibility(false);
            Map<Integer, AnimHolder> map = this.mAnimateMap;
            if (map != null && (animHolder2 = map.get(1)) != null) {
                animHolder2.mAnimatedElement.setVisibility(false);
                return;
            }
            return;
        }
        animHolder.mAnimatedElement.setVisibility(false);
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
        this.mEnableVibrate = true;
        this.mVibrateAmplitude = 30;
        this.mVibrateTime = 90L;
        init(context);
    }

    private void addDataToAnimateMap(Map<Integer, List<IAnimatedElement>> map, int i) {
        if (map != null && !map.isEmpty()) {
            if (this.mAnimateMap == null) {
                this.mAnimateMap = new HashMap();
            }
            List<IAnimatedElement> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                AnimHolder newInstance = AnimHolder.newInstance(i, list);
                MultiAnimHolder multiAnimHolder = newInstance.mHeader;
                if (multiAnimHolder != null) {
                    multiAnimHolder.animHolderUnusedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.1
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
        if (animHolder == null) {
            return;
        }
        if (i == 0 || i == 1 || i == 2 || i == 4) {
            MultiAnimHolder multiAnimHolder = animHolder.mHeader;
            if (multiAnimHolder != null) {
                multiAnimHolder.animHolderUnusedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.2
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
        }
    }

    public boolean setProvider(String str, String str2) {
        if (isAnimationRunning() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        IResourceProvider iResourceProvider = this.mResourceProvider;
        if (iResourceProvider != null) {
            iResourceProvider.releaseResource();
        }
        IResourceProvider build = new ComboPraiseProvider.Builder(this.mContext).setZipInputPath(str).setUnZipOutputPath(str2).build();
        this.mResourceProvider = build;
        this.mElementInitialed = false;
        if (build == null) {
            return false;
        }
        return true;
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
        this.mEnableVibrate = true;
        this.mVibrateAmplitude = 30;
        this.mVibrateTime = 90L;
        init(context);
    }

    private void drawAnchorZone(Canvas canvas) {
        if (sAnchorZoneSwitch && this.mBaseRect != null) {
            this.mDebugPaint.setStrokeWidth(1.0f);
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            Rect rect = this.mBaseRect;
            canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, this.mDebugPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener getAnimatorListener(final AnimHolder animHolder) {
        return new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ComboPraiseView.this.processAnimationCancel(animHolder);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ComboPraiseView.this.post(new Runnable() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        ComboPraiseView.this.processAnimationEnd(animHolder);
                    }
                });
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ComboPraiseView.this.processAnimationStart(animHolder);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator.AnimatorUpdateListener getAnimatorUpdateListener(final AnimHolder animHolder) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimHolder animHolder2 = animHolder;
                if (animHolder2 != null) {
                    animHolder2.mCurrentFraction = valueAnimator.getAnimatedFraction();
                    ComboPraiseView.this.invalidate();
                }
            }
        };
    }

    private void init(Context context) {
        this.mContext = context;
        addPraiseAnimListener(this);
        initDebugPaint();
        initInteractNum();
    }

    private void mapForEach(IAction<Map.Entry<Integer, AnimHolder>> iAction) {
        Map<Integer, AnimHolder> map;
        if (iAction != null && (map = this.mAnimateMap) != null && !map.isEmpty()) {
            for (Map.Entry<Integer, AnimHolder> entry : this.mAnimateMap.entrySet()) {
                if (iAction != null && iAction.doAction(entry) == 1) {
                    return;
                }
            }
        }
    }

    private void performEruptionAnimation(final Canvas canvas) {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(4)) == null) {
            return;
        }
        MultiAnimHolder multiAnimHolder = animHolder.mHeader;
        if (multiAnimHolder != null) {
            multiAnimHolder.animHolderUsedForEach(new IAction<AnimHolder>() { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.7
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

    private void performPraiseLevelAnimation(Canvas canvas) {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(2)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, this.mClickCounts);
    }

    private void performShakeAnimation(Canvas canvas) {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(1)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
    }

    private void performWaveAnimation(Canvas canvas) {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(0)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationCancel(AnimHolder animHolder) {
        if (animHolder == null) {
            return;
        }
        animHolder.mState = 0;
        animHolder.mPerformCounts = 0L;
    }

    public static void setAnchorZoneVisibility(boolean z) {
        if (DEBUG) {
            sAnchorZoneSwitch = z;
        }
    }

    private boolean setBaseRect(ComboPraiseConfig comboPraiseConfig) {
        Rect rect;
        if (isAnimationRunning() || comboPraiseConfig == null || (rect = comboPraiseConfig.mBaseRect) == null) {
            return false;
        }
        this.mBaseRect = rect;
        this.mStatusBarHeightFixed = false;
        this.mPkgTag = "";
        this.mElementInitialed = false;
        return true;
    }

    public static void setDebugInfoVisibility(boolean z) {
        if (DEBUG) {
            sDebugInfoSwitch = z;
        }
    }

    private boolean setNightMode(ComboPraiseConfig comboPraiseConfig) {
        if (isAnimationRunning() || comboPraiseConfig == null) {
            return false;
        }
        this.mNightMode = comboPraiseConfig.mNightMode;
        return true;
    }

    private void setOtherConfig(ComboPraiseConfig comboPraiseConfig) {
        if (comboPraiseConfig == null) {
            return;
        }
        this.mFirstPraiseAnimEnabled = comboPraiseConfig.mFirstPraiseAnimEnabled;
        comboPraiseConfig.mFirstPraiseAnimEnabled = false;
        this.mEnableVibrate = comboPraiseConfig.enableVibrate;
        if (comboPraiseConfig.vibrateTime <= 0) {
            comboPraiseConfig.vibrateTime = 90L;
        }
        if (comboPraiseConfig.vibrateAmplitude <= 0) {
            comboPraiseConfig.vibrateAmplitude = 30;
        }
        this.mVibrateTime = comboPraiseConfig.vibrateTime;
        this.mVibrateAmplitude = comboPraiseConfig.vibrateAmplitude;
    }

    private boolean setUBC(ComboPraiseConfig comboPraiseConfig) {
        ComboPraiseUBC comboPraiseUBC;
        if (isAnimationRunning() || comboPraiseConfig == null || (comboPraiseUBC = comboPraiseConfig.mUBC) == null) {
            return false;
        }
        this.mUBC = comboPraiseUBC;
        return true;
    }

    private boolean willRepeat(AnimHolder animHolder) {
        if (this.mPerformState != 1 || animHolder == null) {
            return false;
        }
        int i = animHolder.mKey;
        if (i != 1 && i != 2) {
            if (i != 4) {
                return false;
            }
            MultiAnimHolder multiAnimHolder = animHolder.mHeader;
            if (multiAnimHolder != null) {
                multiAnimHolder.recycleUsedAnimHolder(animHolder);
                return false;
            }
            return animHolder.mHasPendingClickEvent;
        }
        return animHolder.mHasPendingClickEvent;
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void addPraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(iPraiseAnimListener);
    }

    public void addPraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        if (this.mStatusListeners == null) {
            this.mStatusListeners = new ArrayList();
        }
        this.mStatusListeners.add(iPraiseStatusListener);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
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

    public void removePraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        List<IPraiseAnimListener> list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(iPraiseAnimListener);
        if (this.mListeners.isEmpty()) {
            this.mListeners = null;
        }
    }

    public void removePraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        List<IPraiseStatusListener> list = this.mStatusListeners;
        if (list == null) {
            return;
        }
        list.remove(iPraiseStatusListener);
        if (this.mStatusListeners.isEmpty()) {
            this.mStatusListeners = null;
        }
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void setAnimInfo(@Nullable String str) {
        setClickable(false);
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void setClickBlock(boolean z) {
        this.mClickLocked = z;
    }

    public void setEncourageAnimListener(IPraiseEncourageAnimListener iPraiseEncourageAnimListener) {
        this.mEncourageAnimListener = iPraiseEncourageAnimListener;
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void setPraiseConfig(ComboPraiseConfig comboPraiseConfig) {
        setDebugInfo(comboPraiseConfig);
        setNightMode(comboPraiseConfig);
        setUBC(comboPraiseConfig);
        setCallerSource(comboPraiseConfig);
        setBaseRect(comboPraiseConfig);
        setOtherConfig(comboPraiseConfig);
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public boolean setProvider(IResourceProvider iResourceProvider) {
        if (isAnimationRunning()) {
            return false;
        }
        IResourceProvider iResourceProvider2 = this.mResourceProvider;
        if (iResourceProvider2 != null) {
            iResourceProvider2.releaseResource();
        }
        this.mResourceProvider = iResourceProvider;
        this.mElementInitialed = false;
        if (iResourceProvider == null) {
            return false;
        }
        return true;
    }

    private void applyCurrentPackage() {
        String str;
        if (this.mBaseRect != null && this.mResourceProvider != null) {
            fixStatusBarHeightIfNeeded();
            int calculateLayoutStrategy = ILayoutStrategy.Factory.calculateLayoutStrategy(this.mBaseRect, this.mWidth, this.mHeight);
            if (this.mNightMode) {
                if (calculateLayoutStrategy != 0) {
                    if (calculateLayoutStrategy != 1) {
                        if (calculateLayoutStrategy == 2) {
                            str = PKG_TAG_NIGHT_R;
                        }
                        str = "";
                    } else {
                        str = PKG_TAG_NIGHT_M;
                    }
                } else {
                    str = PKG_TAG_NIGHT_L;
                }
            } else if (calculateLayoutStrategy != 0) {
                if (calculateLayoutStrategy != 1) {
                    if (calculateLayoutStrategy == 2) {
                        str = PKG_TAG_DAY_R;
                    }
                    str = "";
                } else {
                    str = PKG_TAG_DAY_M;
                }
            } else {
                str = PKG_TAG_DAY_L;
            }
            if (!this.mResourceProvider.containPackage(str)) {
                if (DEBUG) {
                    Log.d(TAG, "applyCurrentPackage failed, " + str + " is not contained");
                }
            } else if (TextUtils.equals(str, this.mPkgTag) && calculateLayoutStrategy == this.mLayoutStrategy) {
            } else {
                this.mResourceProvider.setCurrentPackage(str);
                this.mPkgTag = str;
                this.mLayoutStrategy = calculateLayoutStrategy;
                this.mElementInitialed = false;
                if (DEBUG) {
                    Log.d(TAG, "applyCurrentPackage success, LayoutStrategy:" + calculateLayoutStrategy + ", PkgTag:" + this.mPkgTag);
                }
            }
        } else if (DEBUG) {
            Log.d(TAG, "applyCurrentPackage failed, mBaseRect or mResourceProvider is null");
        }
    }

    private void fixStatusBarHeightIfNeeded() {
        if (this.mStatusBarHeightFixed) {
            return;
        }
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
        if (iArr[1] == 0 && !hasWindowFullscreenFlag) {
            this.mBaseRect.offset(0, DeviceUtil.ScreenInfo.getStatusBarHeight());
            this.mStatusBarHeightFixed = true;
            if (DEBUG) {
                Log.d(TAG, "need to fix status bar height(" + DeviceUtil.ScreenInfo.getStatusBarHeight() + SmallTailInfo.EMOTION_SUFFIX);
            }
        } else if (DEBUG) {
            Log.d(TAG, "no need to fix status bar height, pos = " + Arrays.toString(iArr) + ", hasWindowFullscreenFlag return " + hasWindowFullscreenFlag);
        }
    }

    private void drawDebugInfo(Canvas canvas) {
        if (!sDebugInfoSwitch) {
            return;
        }
        this.mDebugPaint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f));
        this.mDebugPaint.setStyle(Paint.Style.FILL);
        float f = this.mHeight / 5.0f;
        float f2 = this.mDebugPaint.getFontMetrics().descent - this.mDebugPaint.getFontMetrics().ascent;
        canvas.drawText(DEBUG_TEXT_CONSTANT, (this.mWidth - this.mDebugPaint.measureText(DEBUG_TEXT_CONSTANT)) / 2.0f, f, this.mDebugPaint);
        String[] strArr = {this.mDebugInfoText, String.format("praiseSrc: %s", this.mPraiseSource), String.format("praiseId: %s", this.mPraiseId), String.format("资源名: %s", this.mPkgTag)};
        for (int i = 0; i < 4; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                f += 50.0f + f2;
                canvas.drawText(strArr[i], (this.mWidth - this.mDebugPaint.measureText(strArr[i])) / 2.0f, f, this.mDebugPaint);
            }
        }
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
    }

    @Override // com.baidu.searchbox.ui.IPraiseAnimView
    public void click(boolean z) {
        if (this.mClickLocked) {
            return;
        }
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
        IPraiseEncourageAnimListener iPraiseEncourageAnimListener = this.mEncourageAnimListener;
        if (iPraiseEncourageAnimListener != null && iPraiseEncourageAnimListener.encourageAnimStart()) {
            notifyAnimationStart();
            notifyAnimationEnd();
            return;
        }
        if (PraiseEnvironment.getPerformanceLevel() == PraiseEnvironment.Performance.LEVEL_1) {
            this.mIsDegradedMode = true;
            this.mClickLocked = true;
        }
        if (TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) || TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_DYNAMIC_DETAIL_CONTENT)) {
            this.mClickLocked = true;
        }
        this.mClickTracker.setInitialClickCounts(this.mInitClickCounts);
        this.mClickTracker.addClick();
        sendPendingClickEvent();
        this.mClickCounts++;
        if (this.mEnableVibrate && z) {
            vibrate();
        }
        int i = this.mPerformState;
        if (i != 0) {
            if (i == 1) {
                triggerPraiseLevelAnimationIfNeeded();
                triggerEruptionAnimation(false);
            }
        } else {
            this.mPerformState = 1;
            this.mInitClickCounts = this.mClickCounts - 1;
            batchStartAnimation();
            if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource) && this.mFirstPraiseAnimEnabled) {
                if (DEBUG) {
                    Log.d(TAG, "FirstPraiseAnim trigger");
                }
                triggerPraiseLevelAnimationIfNeeded();
            }
        }
        triggerPraiseNumberAnimation();
    }

    private boolean generateAnimationIfNeeded() {
        IResourceProvider iResourceProvider = this.mResourceProvider;
        if (iResourceProvider == null) {
            if (DEBUG) {
                Log.d(TAG, "generateAnimationIfNeeded failed, mResourceProvider is null");
            }
            return false;
        } else if (!iResourceProvider.containPackage(this.mPkgTag)) {
            if (DEBUG) {
                Log.d(TAG, "generateAnimationIfNeeded failed, " + this.mPkgTag + " is not contained");
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getElementDuration(AnimHolder animHolder, ClickIntervalTracker.SpeedLevel speedLevel) {
        if (animHolder == null) {
            return 0;
        }
        int i = animHolder.mKey;
        if (i == 0) {
            return 400;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    return 0;
                }
                return 1000;
            }
            int i2 = animHolder.mShowType;
            if (i2 == 0) {
                return 700;
            }
            if (i2 == 2) {
                return 200;
            }
            if (speedLevel == ClickIntervalTracker.SpeedLevel.V1) {
                return 350;
            }
            if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                return 250;
            }
            if (speedLevel != ClickIntervalTracker.SpeedLevel.V3) {
                return 0;
            }
            return 150;
        } else if (animHolder.mShowType == 0 || speedLevel == ClickIntervalTracker.SpeedLevel.V1) {
            return 400;
        } else {
            if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                return 300;
            }
            if (speedLevel != ClickIntervalTracker.SpeedLevel.V3) {
                return 0;
            }
            return 200;
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

    private void notifyPraiseCntReachedIfNeeded() {
        AnimHolder animHolder;
        List<IPraiseStatusListener> list;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map != null && !map.isEmpty() && (animHolder = this.mAnimateMap.get(3)) != null && animHolder.mPerformCounts == this.mInteractRandomNum && !this.mInteractShow && (list = this.mStatusListeners) != null && !list.isEmpty() && this.mUBC != null) {
            for (IPraiseStatusListener iPraiseStatusListener : this.mStatusListeners) {
                iPraiseStatusListener.onTargetPraiseCntReached(this.mInteractRandomNum, "praise_combo", this.mUBC.getUBCSource(), this.mUBC.getNid());
                this.mInteractShow = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r0 != 4) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processAnimationEnd(AnimHolder animHolder) {
        if (animHolder == null) {
            return;
        }
        int i = animHolder.mKey;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.mRunningAnimeCounts--;
                    if (willRepeat(animHolder)) {
                        animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                        animHolder.mShowType = 1;
                        animHolder.mAnimator.setDuration(getElementDuration(animHolder, this.mClickTracker.getSpeedLevel()));
                        animHolder.mAnimator.start();
                    } else if (animHolder.mState == 1) {
                        animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                        animHolder.mShowType = 2;
                        animHolder.mAnimator.setDuration(getElementDuration(animHolder, ClickIntervalTracker.SpeedLevel.V1));
                        animHolder.mAnimator.start();
                        animHolder.mState = 0;
                        Map<Integer, AnimHolder> map = this.mAnimateMap;
                        if (map != null) {
                            setElementInvisible(map.get(3));
                        }
                        this.mClickLocked = true;
                        return;
                    } else {
                        animHolder.mPerformCounts = 0L;
                        setElementInvisible(animHolder);
                    }
                }
            } else {
                this.mRunningAnimeCounts--;
                if (willRepeat(animHolder)) {
                    animHolder.mAnimatedElement.setInterpolator(null);
                    animHolder.mShowType = 1;
                    animHolder.mAnimator.setDuration(getElementDuration(animHolder, this.mClickTracker.getSpeedLevel()));
                    animHolder.mAnimator.start();
                } else {
                    animHolder.mState = 0;
                    animHolder.mPerformCounts = 0L;
                    setElementInvisible(animHolder);
                }
            }
            notifyAnimationEnd();
        }
        this.mRunningAnimeCounts--;
        if (willRepeat(animHolder)) {
            animHolder.mAnimator.start();
        } else {
            animHolder.mState = 0;
            animHolder.mPerformCounts = 0L;
            setElementInvisible(animHolder);
        }
        notifyAnimationEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationStart(AnimHolder animHolder) {
        if (animHolder == null) {
            return;
        }
        animHolder.mHasPendingClickEvent = false;
        animHolder.mPerformCounts++;
        animHolder.mState = 1;
        animHolder.mAnimatedElement.setVisibility(true);
        int i = animHolder.mKey;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 4) {
                        this.mRunningAnimeCounts++;
                        ((EruptionAnimatedGroup) animHolder.mAnimatedElement).updateCurrentStrategy(speedLvlToEruptionStrategy(this.mClickTracker.getSpeedLevel()));
                        return;
                    }
                    return;
                }
                this.mRunningAnimeCounts++;
                ((PraiseLevelAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
                return;
            }
            animHolder.mAnimatedElement.setVisibility(false);
            this.mRunningAnimeCounts++;
            ((ShakeAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
            return;
        }
        this.mRunningAnimeCounts++;
    }

    private boolean setCallerSource(ComboPraiseConfig comboPraiseConfig) {
        String str;
        if (isAnimationRunning()) {
            return false;
        }
        String str2 = "";
        if (comboPraiseConfig == null) {
            this.mPraiseSource = "";
            this.mPraiseId = "";
            this.mClickCounts = 0L;
            this.mInitClickCounts = 0L;
            return false;
        }
        if (TextUtils.isEmpty(comboPraiseConfig.mPraiseSource)) {
            str = "";
        } else {
            str = comboPraiseConfig.mPraiseSource;
        }
        this.mPraiseSource = str;
        if (!TextUtils.isEmpty(comboPraiseConfig.mPraiseId)) {
            str2 = comboPraiseConfig.mPraiseId;
        }
        this.mPraiseId = str2;
        long praiseCounts = PraiseInfoManager.getInstance().getPraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId));
        this.mClickCounts = praiseCounts;
        if (praiseCounts == -1) {
            this.mClickCounts = 0L;
        }
        this.mInitClickCounts = this.mClickCounts;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEruptionAnimation(boolean z) {
        AnimHolder animHolder;
        Map<Integer, AnimHolder> map = this.mAnimateMap;
        if (map == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(4)) == null) {
            return;
        }
        if (animHolder.mHeader == null && !z) {
            return;
        }
        MultiAnimHolder multiAnimHolder = animHolder.mHeader;
        if (multiAnimHolder != null) {
            animHolder = multiAnimHolder.getUnunsedAnimHolder();
        }
        if (animHolder == null) {
            return;
        }
        animHolder.mPerformCounts = this.mClickCounts - 1;
        animHolder.mState = 0;
        animHolder.mCurrentFraction = 0.0f;
        animHolder.mAnimatedElement.setVisibility(false);
        animHolder.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
        animHolder.mAnimator.start();
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
        int i = this.mLayoutStrategy;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
                } else {
                    sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_RIGHT);
                }
            } else {
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_MIDDLE);
            }
        } else {
            sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_LEFT);
        }
        sb.append("_");
        int i2 = AnonymousClass9.$SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel[speedLevel.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
                } else {
                    sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_H);
                }
            } else {
                sb.append("N");
            }
        } else {
            sb.append("M");
        }
        this.mEruptionStrategy = sb.toString();
        if (DEBUG) {
            Log.d(TAG, "EruptionStrategy = " + this.mEruptionStrategy);
        }
        return this.mEruptionStrategy;
    }

    private void triggerPraiseLevelAnimationIfNeeded() {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        if (TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || this.mPraiseLevelTriggered || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(2)) == null) {
            return;
        }
        this.mPraiseLevelTriggered = true;
        animHolder.mAnimator.start();
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
        PraiseUBCHelper.praiseUBCEvent(this.mUBC, !this.mIsDegradedMode ? 1 : 0, this.mClickCounts - this.mInitClickCounts, PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId));
        this.mIsDegradedMode = false;
        invalidate();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        applyCurrentPackage();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        applyCurrentPackage();
    }

    public boolean setProvider(String str) {
        if (isAnimationRunning() || TextUtils.isEmpty(str)) {
            return false;
        }
        IResourceProvider iResourceProvider = this.mResourceProvider;
        if (iResourceProvider != null) {
            iResourceProvider.releaseResource();
        }
        IResourceProvider build = new ComboPraiseProvider.Builder(this.mContext).setProcessedResourcePath(str).build();
        this.mResourceProvider = build;
        this.mElementInitialed = false;
        if (build == null) {
            return false;
        }
        return true;
    }
}
