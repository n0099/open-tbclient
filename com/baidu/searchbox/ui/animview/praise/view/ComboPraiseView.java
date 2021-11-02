package com.baidu.searchbox.ui.animview.praise.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ComboPraiseView extends View implements IPraiseAnimListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean ANCHOR_ZONE_SWITCH = false;
    public static final boolean DEBUG;
    public static boolean DEBUG_INFO_SWITCH = false;
    public static final int DEBUG_PAINT_COLOR = -65536;
    public static final int DEBUG_PAINT_STROKE_WIDTH = 10;
    public static final int DEBUG_PAINT_TEXT_SIZE = 15;
    public static final String DEBUG_TEXT_CONSTANT = "浮层显示中(DEBUG模式，仅用于测试)";
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
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, AnimHolder> mAnimateMap;
    public Rect mBaseRect;
    public long mClickCounts;
    public boolean mClickLocked;
    public ClickIntervalTracker mClickTracker;
    public Context mContext;
    public String mDebugInfoText;
    public Paint mDebugPaint;
    public boolean mElementInitialed;
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
    public int mWidth;

    /* renamed from: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView$9  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-983320410, "Lcom/baidu/searchbox/ui/animview/praise/view/ComboPraiseView$9;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-983320410, "Lcom/baidu/searchbox/ui/animview/praise/view/ComboPraiseView$9;");
                    return;
                }
            }
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

    /* loaded from: classes7.dex */
    public interface IAction<T> {
        public static final int ACTION_BREAK = 1;
        public static final int ACTION_CONTINUE = 0;

        int doAction(T t);
    }

    /* loaded from: classes7.dex */
    public static class MultiAnimHolder extends AnimHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<AnimHolder> mUnusedAnimHolder;
        public List<AnimHolder> mUsedAnimHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiAnimHolder() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void animHolderUnusedForEach(IAction<AnimHolder> iAction) {
            List<AnimHolder> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iAction) == null) || iAction == null || (list = this.mUnusedAnimHolder) == null || list.isEmpty()) {
                return;
            }
            Iterator<AnimHolder> it = this.mUnusedAnimHolder.iterator();
            while (it.hasNext() && iAction.doAction(it.next()) != 1) {
            }
        }

        public void animHolderUsedForEach(IAction<AnimHolder> iAction) {
            List<AnimHolder> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iAction) == null) || iAction == null || (list = this.mUsedAnimHolder) == null || list.isEmpty()) {
                return;
            }
            Iterator<AnimHolder> it = this.mUsedAnimHolder.iterator();
            while (it.hasNext() && iAction.doAction(it.next()) != 1) {
            }
        }

        public AnimHolder getUnunsedAnimHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<AnimHolder> list = this.mUnusedAnimHolder;
                if (list == null || list.isEmpty()) {
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
            return (AnimHolder) invokeV.objValue;
        }

        public void recycleUsedAnimHolder(AnimHolder animHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animHolder) == null) || animHolder == null || (animHolder instanceof MultiAnimHolder)) {
                return;
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-689290597, "Lcom/baidu/searchbox/ui/animview/praise/view/ComboPraiseView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-689290597, "Lcom/baidu/searchbox/ui/animview/praise/view/ComboPraiseView;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
        DEBUG_INFO_SWITCH = false;
        ANCHOR_ZONE_SWITCH = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboPraiseView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    private void addDataToAnimateMap(Map<Integer, List<IAnimatedElement>> map, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65551, this, map, i2) == null) || map == null || map.isEmpty()) {
            return;
        }
        if (this.mAnimateMap == null) {
            this.mAnimateMap = new HashMap();
        }
        List<IAnimatedElement> list = map.get(Integer.valueOf(i2));
        if (list == null || list.isEmpty()) {
            return;
        }
        AnimHolder newInstance = AnimHolder.newInstance(i2, list);
        MultiAnimHolder multiAnimHolder = newInstance.mHeader;
        if (multiAnimHolder != null) {
            multiAnimHolder.animHolderUnusedForEach(new IAction<AnimHolder>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                public int doAction(AnimHolder animHolder) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, animHolder)) == null) {
                        animHolder.mAnimatedElement.setVisibility(false);
                        return 0;
                    }
                    return invokeL.intValue;
                }
            });
        }
        this.mAnimateMap.put(Integer.valueOf(i2), newInstance);
        initValueAnimator(i2, newInstance);
    }

    private void applyCurrentPackage() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.mBaseRect != null && this.mResourceProvider != null) {
                fixStatusBarHeightIfNeeded();
                int calculateLayoutStrategy = ILayoutStrategy.Factory.calculateLayoutStrategy(this.mBaseRect, this.mWidth, this.mHeight);
                if (this.mNightMode) {
                    if (calculateLayoutStrategy == 0) {
                        str = PKG_TAG_NIGHT_L;
                    } else if (calculateLayoutStrategy != 1) {
                        if (calculateLayoutStrategy == 2) {
                            str = PKG_TAG_NIGHT_R;
                        }
                        str = "";
                    } else {
                        str = PKG_TAG_NIGHT_M;
                    }
                } else if (calculateLayoutStrategy == 0) {
                    str = PKG_TAG_DAY_L;
                } else if (calculateLayoutStrategy != 1) {
                    if (calculateLayoutStrategy == 2) {
                        str = PKG_TAG_DAY_R;
                    }
                    str = "";
                } else {
                    str = PKG_TAG_DAY_M;
                }
                if (!this.mResourceProvider.containPackage(str)) {
                    if (DEBUG) {
                        String str2 = "applyCurrentPackage failed, " + str + " is not contained";
                        return;
                    }
                    return;
                } else if (TextUtils.equals(str, this.mPkgTag) && calculateLayoutStrategy == this.mLayoutStrategy) {
                    return;
                } else {
                    this.mResourceProvider.setCurrentPackage(str);
                    this.mPkgTag = str;
                    this.mLayoutStrategy = calculateLayoutStrategy;
                    this.mElementInitialed = false;
                    if (DEBUG) {
                        String str3 = "applyCurrentPackage success, LayoutStrategy:" + calculateLayoutStrategy + ", PkgTag:" + this.mPkgTag;
                        return;
                    }
                    return;
                }
            }
            boolean z = DEBUG;
        }
    }

    private void batchStartAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            notifyAnimationStart();
            mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseView this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                        AnimHolder value = entry.getValue();
                        if (value.mHeader == null) {
                            value.mPerformCounts = this.this$0.mClickCounts - 1;
                            value.mState = 0;
                            value.mCurrentFraction = 0.0f;
                            value.mAnimatedElement.setVisibility(false);
                        }
                        int i2 = value.mKey;
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 == 2) {
                                    value.mShowType = 0;
                                } else if (i2 == 3) {
                                    value.mAnimatedElement.setVisibility(true);
                                } else if (i2 == 4) {
                                    if (!PraiseEnvironment.isFirstPraiseAnimSupported(this.this$0.mPraiseSource) || !this.this$0.mFirstPraiseAnimEnabled) {
                                        this.this$0.triggerEruptionAnimation(true);
                                    } else {
                                        boolean unused = ComboPraiseView.DEBUG;
                                    }
                                }
                            } else if (TextUtils.equals(this.this$0.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) || TextUtils.equals(this.this$0.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                                return 0;
                            } else {
                                value.mAnimatedElement.setInterpolator(new AccelerateDecelerateInterpolator());
                                value.mShowType = 0;
                                value.mAnimator.start();
                            }
                        } else if (!TextUtils.equals(this.this$0.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_FEED_VIDEO_LIST) && !TextUtils.equals(this.this$0.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN)) {
                            value.mAnimator.start();
                        }
                        return 0;
                    }
                    return invokeL.intValue;
                }
            });
        }
    }

    private void drawAnchorZone(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, canvas) == null) && ANCHOR_ZONE_SWITCH && this.mBaseRect != null) {
            this.mDebugPaint.setStrokeWidth(1.0f);
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            Rect rect = this.mBaseRect;
            canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, this.mDebugPaint);
        }
    }

    private void drawDebugInfo(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, canvas) == null) && DEBUG_INFO_SWITCH) {
            this.mDebugPaint.setStrokeWidth(DeviceUtil.ScreenInfo.dp2px(this.mContext, 10.0f));
            this.mDebugPaint.setStyle(Paint.Style.FILL);
            float f2 = this.mHeight / 5.0f;
            float f3 = this.mDebugPaint.getFontMetrics().descent - this.mDebugPaint.getFontMetrics().ascent;
            canvas.drawText(DEBUG_TEXT_CONSTANT, (this.mWidth - this.mDebugPaint.measureText(DEBUG_TEXT_CONSTANT)) / 2.0f, f2, this.mDebugPaint);
            String[] strArr = {this.mDebugInfoText, String.format("praiseSrc: %s", this.mPraiseSource), String.format("praiseId: %s", this.mPraiseId), String.format("资源名: %s", this.mPkgTag)};
            for (int i2 = 0; i2 < 4; i2++) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    f2 += 50.0f + f3;
                    canvas.drawText(strArr[i2], (this.mWidth - this.mDebugPaint.measureText(strArr[i2])) / 2.0f, f2, this.mDebugPaint);
                }
            }
            this.mDebugPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
        }
    }

    private void fixStatusBarHeightIfNeeded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || this.mStatusBarHeightFixed) {
            return;
        }
        if (Build.VERSION.SDK_INT > 21) {
            if (DEBUG) {
                String str = "no need to fix status bar height, API = " + Build.VERSION.SDK_INT + ", praiseSource = " + this.mPraiseSource;
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
                String str2 = "need to fix status bar height(" + DeviceUtil.ScreenInfo.getStatusBarHeight() + SmallTailInfo.EMOTION_SUFFIX;
            }
        } else if (DEBUG) {
            String str3 = "no need to fix status bar height, pos = " + Arrays.toString(iArr) + ", hasWindowFullscreenFlag return " + hasWindowFullscreenFlag;
        }
    }

    private boolean generateAnimationIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            IResourceProvider iResourceProvider = this.mResourceProvider;
            if (iResourceProvider == null) {
                boolean z = DEBUG;
                return false;
            } else if (!iResourceProvider.containPackage(this.mPkgTag)) {
                if (DEBUG) {
                    String str = "generateAnimationIfNeeded failed, " + this.mPkgTag + " is not contained";
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
                    String str2 = "generateAnimationIfNeeded success, LayoutStrategy:" + this.mLayoutStrategy + ", PkgTag:" + this.mPkgTag;
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener getAnimatorListener(AnimHolder animHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, this, animHolder)) == null) ? new Animator.AnimatorListener(this, animHolder) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseView this$0;
            public final /* synthetic */ AnimHolder val$animHolder;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, animHolder};
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
                this.val$animHolder = animHolder;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.this$0.processAnimationCancel(this.val$animHolder);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.this$0.post(new Runnable(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.4.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass4 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass4 anonymousClass4 = this.this$1;
                                anonymousClass4.this$0.processAnimationEnd(anonymousClass4.val$animHolder);
                            }
                        }
                    });
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                    this.this$0.processAnimationStart(this.val$animHolder);
                }
            }
        } : (Animator.AnimatorListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator.AnimatorUpdateListener getAnimatorUpdateListener(AnimHolder animHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, this, animHolder)) == null) ? new ValueAnimator.AnimatorUpdateListener(this, animHolder) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseView this$0;
            public final /* synthetic */ AnimHolder val$animHolder;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, animHolder};
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
                this.val$animHolder = animHolder;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimHolder animHolder2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) || (animHolder2 = this.val$animHolder) == null) {
                    return;
                }
                animHolder2.mCurrentFraction = valueAnimator.getAnimatedFraction();
                this.this$0.invalidate();
            }
        } : (ValueAnimator.AnimatorUpdateListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getElementDuration(AnimHolder animHolder, ClickIntervalTracker.SpeedLevel speedLevel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, animHolder, speedLevel)) == null) {
            if (animHolder == null) {
                return 0;
            }
            int i2 = animHolder.mKey;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (animHolder.mShowType == 0 || speedLevel == ClickIntervalTracker.SpeedLevel.V1) {
                        return 400;
                    }
                    if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                        return 300;
                    }
                    return speedLevel == ClickIntervalTracker.SpeedLevel.V3 ? 200 : 0;
                } else if (i2 != 2) {
                    return i2 != 4 ? 0 : 1000;
                } else {
                    int i3 = animHolder.mShowType;
                    if (i3 == 0) {
                        return 700;
                    }
                    if (i3 == 2) {
                        return 200;
                    }
                    if (speedLevel == ClickIntervalTracker.SpeedLevel.V1) {
                        return 350;
                    }
                    if (speedLevel == ClickIntervalTracker.SpeedLevel.V2) {
                        return 250;
                    }
                    return speedLevel == ClickIntervalTracker.SpeedLevel.V3 ? 150 : 0;
                }
            }
            return 400;
        }
        return invokeLL.intValue;
    }

    private Map<Integer, List<IAnimatedElement>> getElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(4, 2);
            return new PraiseAnimElementBuilder(this.mContext, 0).setBaseLeft(this.mBaseRect.left).setBaseTop(this.mBaseRect.top).setBaseWidth(this.mBaseRect.width()).setBaseHeight(this.mBaseRect.height()).setDrawableCallback(this).setResourceProvider(this.mResourceProvider).setLayoutStrategy(this.mLayoutStrategy).setCanvasSize(this.mWidth, this.mHeight).setElementCnts(hashMap).build();
        }
        return (Map) invokeV.objValue;
    }

    private Map<Integer, List<IAnimatedElement>> getElementsWithPreBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            IPraiseElementBuilder.FetchConfig fetchConfig = new IPraiseElementBuilder.FetchConfig();
            fetchConfig.setLeft(this.mBaseRect.left).setTop(this.mBaseRect.top).setWidth(this.mBaseRect.width()).setHeight(this.mBaseRect.height()).setDrawableCallback(this).setStrategy(this.mLayoutStrategy).setCanvasHeight(this.mHeight).setCanvasWidth(this.mWidth).setPkgTag(this.mPkgTag);
            return PraiseAnimElementBuilderEx.getInstance().getResult(fetchConfig);
        }
        return (Map) invokeV.objValue;
    }

    private boolean hasWindowFullscreenFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            if (getContext() instanceof Activity) {
                return ComboPraiseManager.hasWindowFullscreenFlag(((Activity) getContext()).getWindow());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, context) == null) {
            this.mContext = context;
            addPraiseAnimListener(this);
            initDebugPaint();
            initInteractNum();
        }
    }

    private void initDebugPaint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && this.mDebugPaint == null) {
            Paint paint = new Paint();
            this.mDebugPaint = paint;
            paint.setAntiAlias(true);
            this.mDebugPaint.setColor(-65536);
            this.mDebugPaint.setTextSize(DeviceUtil.ScreenInfo.dp2px(this.mContext, 15.0f));
        }
    }

    private void initInteractNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mInteractRandomNum = 1;
        }
    }

    private void initValueAnimator(int i2, AnimHolder animHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65567, this, i2, animHolder) == null) || animHolder == null) {
            return;
        }
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 4) {
            MultiAnimHolder multiAnimHolder = animHolder.mHeader;
            if (multiAnimHolder != null) {
                multiAnimHolder.animHolderUnusedForEach(new IAction<AnimHolder>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComboPraiseView this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                    public int doAction(AnimHolder animHolder2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, animHolder2)) == null) {
                            animHolder2.mAnimator.setDuration(this.this$0.getElementDuration(animHolder2, ClickIntervalTracker.SpeedLevel.V1));
                            animHolder2.mAnimator.addUpdateListener(this.this$0.getAnimatorUpdateListener(animHolder2));
                            animHolder2.mAnimator.addListener(this.this$0.getAnimatorListener(animHolder2));
                            return 0;
                        }
                        return invokeL.intValue;
                    }
                });
                return;
            }
            animHolder.mAnimator.setDuration(getElementDuration(animHolder, ClickIntervalTracker.SpeedLevel.V1));
            animHolder.mAnimator.addUpdateListener(getAnimatorUpdateListener(animHolder));
            animHolder.mAnimator.addListener(getAnimatorListener(animHolder));
        }
    }

    public static boolean isAnchorZoneVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (DEBUG) {
                return ANCHOR_ZONE_SWITCH;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isDebugInfoVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            if (DEBUG) {
                return DEBUG_INFO_SWITCH;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void mapForEach(IAction<Map.Entry<Integer, AnimHolder>> iAction) {
        Map<Integer, AnimHolder> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, this, iAction) == null) || iAction == null || (map = this.mAnimateMap) == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, AnimHolder> entry : this.mAnimateMap.entrySet()) {
            if (iAction != null && iAction.doAction(entry) == 1) {
                return;
            }
        }
    }

    private void notifyAnimationEnd() {
        List<IPraiseAnimListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65571, this) == null) || this.mRunningAnimeCounts != 0 || (list = this.mListeners) == null || list.isEmpty()) {
            return;
        }
        for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
            iPraiseAnimListener.onPraiseAnimEnd();
        }
    }

    private void notifyAnimationStart() {
        List<IPraiseAnimListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65572, this) == null) || (list = this.mListeners) == null || list.isEmpty()) {
            return;
        }
        for (IPraiseAnimListener iPraiseAnimListener : this.mListeners) {
            iPraiseAnimListener.onPraiseAnimStart();
        }
    }

    private void notifyPraiseCntReachedIfNeeded() {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        List<IPraiseStatusListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(3)) == null || animHolder.mPerformCounts != this.mInteractRandomNum || this.mInteractShow || (list = this.mStatusListeners) == null || list.isEmpty() || this.mUBC == null) {
            return;
        }
        for (IPraiseStatusListener iPraiseStatusListener : this.mStatusListeners) {
            iPraiseStatusListener.onTargetPraiseCntReached(this.mInteractRandomNum, "praise_combo", this.mUBC.getUBCSource(), this.mUBC.getNid());
            this.mInteractShow = true;
        }
    }

    private void performEruptionAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65574, this, canvas) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(4)) == null) {
            return;
        }
        MultiAnimHolder multiAnimHolder = animHolder.mHeader;
        if (multiAnimHolder != null) {
            multiAnimHolder.animHolderUsedForEach(new IAction<AnimHolder>(this, canvas) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseView this$0;
                public final /* synthetic */ Canvas val$canvas;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, canvas};
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
                    this.val$canvas = canvas;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                public int doAction(AnimHolder animHolder2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, animHolder2)) == null) {
                        animHolder2.mAnimatedElement.dispatchAnimate(this.val$canvas, animHolder2.mCurrentFraction, animHolder2.mPerformCounts);
                        return 0;
                    }
                    return invokeL.intValue;
                }
            });
        } else {
            animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
        }
    }

    private void performPraiseLevelAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65575, this, canvas) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(2)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, this.mClickCounts);
    }

    private void performPraiseNumberAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, canvas) == null) || TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(3)) == null) {
            return;
        }
        long j = animHolder.mPerformCounts;
        if (j <= this.mInitClickCounts + 1 || j > 2000) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, 1.0f, j);
    }

    private void performShakeAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65577, this, canvas) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(1)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
    }

    private void performWaveAnimation(Canvas canvas) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65578, this, canvas) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(0)) == null) {
            return;
        }
        animHolder.mAnimatedElement.dispatchAnimate(canvas, animHolder.mCurrentFraction, animHolder.mPerformCounts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAnimationCancel(AnimHolder animHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65579, this, animHolder) == null) || animHolder == null) {
            return;
        }
        animHolder.mState = 0;
        animHolder.mPerformCounts = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r0 != 4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processAnimationEnd(AnimHolder animHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, this, animHolder) == null) || animHolder == null) {
            return;
        }
        int i2 = animHolder.mKey;
        if (i2 != 0) {
            if (i2 == 1) {
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
            } else if (i2 == 2) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65581, this, animHolder) == null) || animHolder == null) {
            return;
        }
        animHolder.mHasPendingClickEvent = false;
        animHolder.mPerformCounts++;
        animHolder.mState = 1;
        animHolder.mAnimatedElement.setVisibility(true);
        int i2 = animHolder.mKey;
        if (i2 == 0) {
            this.mRunningAnimeCounts++;
        } else if (i2 == 1) {
            animHolder.mAnimatedElement.setVisibility(false);
            this.mRunningAnimeCounts++;
            ((ShakeAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
        } else if (i2 == 2) {
            this.mRunningAnimeCounts++;
            ((PraiseLevelAnimElement) animHolder.mAnimatedElement).setShowType(animHolder.mShowType);
        } else if (i2 != 4) {
        } else {
            this.mRunningAnimeCounts++;
            ((EruptionAnimatedGroup) animHolder.mAnimatedElement).updateCurrentStrategy(speedLvlToEruptionStrategy(this.mClickTracker.getSpeedLevel()));
        }
    }

    private void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseView this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                        if (entry.getValue().mHeader == null) {
                            entry.getValue().mAnimatedElement.releaseResouces();
                            return 0;
                        }
                        return 0;
                    }
                    return invokeL.intValue;
                }
            });
            Map<Integer, AnimHolder> map = this.mAnimateMap;
            if (map != null) {
                map.clear();
            }
            this.mElementInitialed = false;
        }
    }

    private void sendPendingClickEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            mapForEach(new IAction<Map.Entry<Integer, AnimHolder>>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseView this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                public int doAction(Map.Entry<Integer, AnimHolder> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                        AnimHolder value = entry.getValue();
                        MultiAnimHolder multiAnimHolder = value.mHeader;
                        if (multiAnimHolder != null) {
                            multiAnimHolder.animHolderUsedForEach(new IAction<AnimHolder>(this) { // from class: com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.5.1
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
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView.IAction
                                public int doAction(AnimHolder animHolder) {
                                    InterceptResult invokeL2;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeL2 = interceptable3.invokeL(1048576, this, animHolder)) == null) {
                                        animHolder.mHasPendingClickEvent = true;
                                        return 0;
                                    }
                                    return invokeL2.intValue;
                                }
                            });
                            return 0;
                        }
                        value.mHasPendingClickEvent = true;
                        return 0;
                    }
                    return invokeL.intValue;
                }
            });
        }
    }

    public static void setAnchorZoneVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65584, null, z) == null) && DEBUG) {
            ANCHOR_ZONE_SWITCH = z;
        }
    }

    private boolean setBaseRect(ComboPraiseConfig comboPraiseConfig) {
        InterceptResult invokeL;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, this, comboPraiseConfig)) == null) {
            if (isAnimationRunning() || comboPraiseConfig == null || (rect = comboPraiseConfig.mBaseRect) == null) {
                return false;
            }
            this.mBaseRect = rect;
            this.mStatusBarHeightFixed = false;
            this.mPkgTag = "";
            this.mElementInitialed = false;
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean setCallerSource(ComboPraiseConfig comboPraiseConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, this, comboPraiseConfig)) == null) {
            if (isAnimationRunning()) {
                return false;
            }
            if (comboPraiseConfig == null) {
                this.mPraiseSource = "";
                this.mPraiseId = "";
                this.mClickCounts = 0L;
                this.mInitClickCounts = 0L;
                return false;
            }
            this.mPraiseSource = TextUtils.isEmpty(comboPraiseConfig.mPraiseSource) ? "" : comboPraiseConfig.mPraiseSource;
            this.mPraiseId = TextUtils.isEmpty(comboPraiseConfig.mPraiseId) ? "" : comboPraiseConfig.mPraiseId;
            long praiseCounts = PraiseInfoManager.getInstance().getPraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.mPraiseSource, this.mPraiseId));
            this.mClickCounts = praiseCounts;
            if (praiseCounts == -1) {
                this.mClickCounts = 0L;
            }
            this.mInitClickCounts = this.mClickCounts;
            return true;
        }
        return invokeL.booleanValue;
    }

    private void setDebugInfo(ComboPraiseConfig comboPraiseConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65587, this, comboPraiseConfig) == null) || comboPraiseConfig == null) {
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

    public static void setDebugInfoVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65588, null, z) == null) && DEBUG) {
            DEBUG_INFO_SWITCH = z;
        }
    }

    private void setElementInvisible(AnimHolder animHolder) {
        AnimHolder animHolder2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65589, this, animHolder) == null) || animHolder == null) {
            return;
        }
        int i2 = animHolder.mKey;
        if (i2 == 0) {
            animHolder.mAnimatedElement.setVisibility(false);
        } else if (i2 != 2) {
            if (i2 == 3) {
                animHolder.mAnimatedElement.setVisibility(false);
            } else if (i2 != 4) {
            } else {
                animHolder.mAnimatedElement.setVisibility(false);
            }
        } else {
            animHolder.mAnimatedElement.setVisibility(false);
            Map<Integer, AnimHolder> map = this.mAnimateMap;
            if (map == null || (animHolder2 = map.get(1)) == null) {
                return;
            }
            animHolder2.mAnimatedElement.setVisibility(false);
        }
    }

    private boolean setNightMode(ComboPraiseConfig comboPraiseConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, this, comboPraiseConfig)) == null) {
            if (isAnimationRunning() || comboPraiseConfig == null) {
                return false;
            }
            this.mNightMode = comboPraiseConfig.mNightMode;
            return true;
        }
        return invokeL.booleanValue;
    }

    private void setOtherConfig(ComboPraiseConfig comboPraiseConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65591, this, comboPraiseConfig) == null) || comboPraiseConfig == null) {
            return;
        }
        this.mFirstPraiseAnimEnabled = comboPraiseConfig.mFirstPraiseAnimEnabled;
        comboPraiseConfig.mFirstPraiseAnimEnabled = false;
    }

    private boolean setUBC(ComboPraiseConfig comboPraiseConfig) {
        InterceptResult invokeL;
        ComboPraiseUBC comboPraiseUBC;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, this, comboPraiseConfig)) == null) {
            if (isAnimationRunning() || comboPraiseConfig == null || (comboPraiseUBC = comboPraiseConfig.mUBC) == null) {
                return false;
            }
            this.mUBC = comboPraiseUBC;
            return true;
        }
        return invokeL.booleanValue;
    }

    private String speedLvlToEruptionStrategy(ClickIntervalTracker.SpeedLevel speedLevel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, this, speedLevel)) == null) {
            if (DEBUG) {
                String str = "SpeedLevel = " + speedLevel;
            }
            if (speedLevel == this.mLastSpeedLevel) {
                return this.mEruptionStrategy;
            }
            this.mLastSpeedLevel = speedLevel;
            StringBuilder sb = new StringBuilder();
            int i2 = this.mLayoutStrategy;
            if (i2 == 0) {
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_LEFT);
            } else if (i2 == 1) {
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_MIDDLE);
            } else if (i2 != 2) {
                this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
            } else {
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_RIGHT);
            }
            sb.append("_");
            int i3 = AnonymousClass9.$SwitchMap$com$baidu$searchbox$ui$animview$praise$ClickIntervalTracker$SpeedLevel[speedLevel.ordinal()];
            if (i3 == 1) {
                sb.append("M");
            } else if (i3 == 2) {
                sb.append("N");
            } else if (i3 != 3) {
                this.mLastSpeedLevel = ClickIntervalTracker.SpeedLevel.V0;
            } else {
                sb.append(IEruptionStrategyGroup.STRATEGY_MODIFIER_H);
            }
            this.mEruptionStrategy = sb.toString();
            if (DEBUG) {
                String str2 = "EruptionStrategy = " + this.mEruptionStrategy;
            }
            return this.mEruptionStrategy;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerEruptionAnimation(boolean z) {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65594, this, z) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(4)) == null) {
            return;
        }
        if (animHolder.mHeader != null || z) {
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
    }

    private void triggerPraiseLevelAnimationIfNeeded() {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65595, this) == null) || TextUtils.equals(this.mPraiseSource, PraiseSourceDef.NA_PRAISE_SRC_MINI_VIDEO_DETAIL_SCREEN) || this.mPraiseLevelTriggered || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(2)) == null) {
            return;
        }
        this.mPraiseLevelTriggered = true;
        animHolder.mAnimator.start();
    }

    private void triggerPraiseNumberAnimation() {
        Map<Integer, AnimHolder> map;
        AnimHolder animHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65596, this) == null) || (map = this.mAnimateMap) == null || map.isEmpty() || (animHolder = this.mAnimateMap.get(3)) == null || !animHolder.mHasPendingClickEvent) {
            return;
        }
        animHolder.mPerformCounts++;
        animHolder.mHasPendingClickEvent = false;
    }

    private boolean willRepeat(AnimHolder animHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, this, animHolder)) == null) {
            if (this.mPerformState != 1 || animHolder == null) {
                return false;
            }
            int i2 = animHolder.mKey;
            if (i2 == 1 || i2 == 2) {
                return animHolder.mHasPendingClickEvent;
            }
            if (i2 != 4) {
                return false;
            }
            MultiAnimHolder multiAnimHolder = animHolder.mHeader;
            if (multiAnimHolder != null) {
                multiAnimHolder.recycleUsedAnimHolder(animHolder);
                return false;
            }
            return animHolder.mHasPendingClickEvent;
        }
        return invokeL.booleanValue;
    }

    public void addPraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iPraiseAnimListener) == null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(iPraiseAnimListener);
        }
    }

    public void addPraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iPraiseStatusListener) == null) {
            if (this.mStatusListeners == null) {
                this.mStatusListeners = new ArrayList();
            }
            this.mStatusListeners.add(iPraiseStatusListener);
        }
    }

    public void click() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mClickLocked) {
            return;
        }
        if (!generateAnimationIfNeeded()) {
            applyCurrentPackage();
            notifyAnimationStart();
            notifyAnimationEnd();
            boolean z = DEBUG;
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
        long j = this.mClickCounts + 1;
        this.mClickCounts = j;
        int i2 = this.mPerformState;
        if (i2 == 0) {
            this.mPerformState = 1;
            this.mInitClickCounts = j - 1;
            batchStartAnimation();
            if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource) && this.mFirstPraiseAnimEnabled) {
                boolean z2 = DEBUG;
                triggerPraiseLevelAnimationIfNeeded();
            }
        } else if (i2 == 1) {
            triggerPraiseLevelAnimationIfNeeded();
            triggerEruptionAnimation(false);
        }
        triggerPraiseNumberAnimation();
    }

    public boolean isAnimationRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPerformState != 0 : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            releaseResource();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
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
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            applyCurrentPackage();
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
    public void onPraiseAnimEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    }

    @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
    public void onPraiseAnimStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mPraiseLevelTriggered = false;
            PraiseUBCHelper.beginPraiseAnimeFlow();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            this.mWidth = i2;
            this.mHeight = i3;
            applyCurrentPackage();
        }
    }

    public void removePraiseAnimListener(IPraiseAnimListener iPraiseAnimListener) {
        List<IPraiseAnimListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, iPraiseAnimListener) == null) || (list = this.mListeners) == null) {
            return;
        }
        list.remove(iPraiseAnimListener);
        if (this.mListeners.isEmpty()) {
            this.mListeners = null;
        }
    }

    public void removePraiseStatusListener(IPraiseStatusListener iPraiseStatusListener) {
        List<IPraiseStatusListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iPraiseStatusListener) == null) || (list = this.mStatusListeners) == null) {
            return;
        }
        list.remove(iPraiseStatusListener);
        if (this.mStatusListeners.isEmpty()) {
            this.mStatusListeners = null;
        }
    }

    public void setClickBlock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mClickLocked = z;
        }
    }

    public void setPraiseConfig(ComboPraiseConfig comboPraiseConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, comboPraiseConfig) == null) {
            setDebugInfo(comboPraiseConfig);
            setNightMode(comboPraiseConfig);
            setUBC(comboPraiseConfig);
            setCallerSource(comboPraiseConfig);
            setBaseRect(comboPraiseConfig);
            setOtherConfig(comboPraiseConfig);
        }
    }

    public boolean setProvider(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) {
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
            return build != null;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public static class AnimHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ValueAnimator createValueAnimator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? ValueAnimator.ofFloat(0.0f, 1.0f) : (ValueAnimator) invokeI.objValue;
        }

        public static MultiAnimHolder newHeaderInstance(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                MultiAnimHolder multiAnimHolder = new MultiAnimHolder();
                multiAnimHolder.mKey = i2;
                multiAnimHolder.mState = 0;
                multiAnimHolder.mAnimatedElement = null;
                multiAnimHolder.mAnimator = null;
                multiAnimHolder.mUnusedAnimHolder = new ArrayList();
                multiAnimHolder.mHeader = multiAnimHolder;
                return multiAnimHolder;
            }
            return (MultiAnimHolder) invokeI.objValue;
        }

        public static AnimHolder newInstance(int i2, IAnimatedElement iAnimatedElement) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, iAnimatedElement)) == null) {
                AnimHolder animHolder = new AnimHolder();
                animHolder.mKey = i2;
                animHolder.mUsedCnts = 0;
                animHolder.mState = 0;
                animHolder.mAnimatedElement = iAnimatedElement;
                animHolder.mAnimator = createValueAnimator(i2);
                return animHolder;
            }
            return (AnimHolder) invokeIL.objValue;
        }

        public static AnimHolder newInstance(int i2, List<IAnimatedElement> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, list)) == null) {
                if (list == null || list.isEmpty()) {
                    return null;
                }
                if (list.size() == 1) {
                    return newInstance(i2, list.get(0));
                }
                MultiAnimHolder newHeaderInstance = newHeaderInstance(i2);
                for (int i3 = 0; i3 < list.size(); i3++) {
                    AnimHolder newInstance = newInstance(i2, list.get(i3));
                    newInstance.mHeader = newHeaderInstance;
                    newHeaderInstance.mUnusedAnimHolder.add(newInstance);
                }
                return newHeaderInstance;
            }
            return (AnimHolder) invokeIL.objValue;
        }
    }

    public boolean setProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
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
            return build != null;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboPraiseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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

    public boolean setProvider(IResourceProvider iResourceProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, iResourceProvider)) == null) {
            if (isAnimationRunning()) {
                return false;
            }
            IResourceProvider iResourceProvider2 = this.mResourceProvider;
            if (iResourceProvider2 != null) {
                iResourceProvider2.releaseResource();
            }
            this.mResourceProvider = iResourceProvider;
            this.mElementInitialed = false;
            return iResourceProvider != null;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboPraiseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
}
