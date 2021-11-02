package com.baidu.searchbox.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.ui.animview.praise.IExPraiseAnimListener;
import com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.praise.PraiseInfoManager;
import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener;
import com.baidu.searchbox.ui.animview.praise.resource.CoolPraiseIconResource;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class CoolPraiseView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long BILLION = 100000000;
    public static final boolean DEBUG;
    public static final int LONG_PRESS_TIME_MS = 550;
    public static final long MILLION = 10000;
    public static final String NET_ERROR_TIP = "网络不给力，请稍后重试";
    public static final int REMOVE_VIEW_DELAY_TIME_MS = 200;
    public static final int START_DELAY_TIME_MS = 560;
    public static final String TAG = "CoolPraiseView";
    public transient /* synthetic */ FieldHolder $fh;
    public ComboPraiseManager mComboPraiseManager;
    public Context mContext;
    public CoolPraiseGuideLottieView mCoolPraiseGuideLottieView;
    public PressedAlphaImageView mCopyPressedImageView;
    public boolean mDisableAnimation;
    public ExtraTouchEventListener mExtraTouchEventListener;
    public AnimatorSet mGuideAnimator;
    public int mGuidePlayRepeatCount;
    public ViewGroup mGuidePlayRootView;
    public boolean mIsAnimCancelling;
    public boolean mIsGuideBubbleAnimPlaying;
    public boolean mIsGuideHandAnimPlaying;
    public boolean mIsLongPressing;
    public boolean mIsPlayingAnim;
    public boolean mIsPraised;
    public int[] mLocation;
    public Runnable mLongClick;
    public LongPressListener mLongPressListener;
    public Handler mMainHandler;
    public OnClickPraiseListener mOnClickPraiseListener;
    public boolean mPraiseAnimBlock;
    public boolean mPraiseAnimPrevented;
    public boolean mPraiseCntsDefaultTextShow;
    public int mPraiseCntsMarginLeft;
    public TextView mPraiseCntsView;
    public int mPraiseCount;
    public boolean mPraiseEnabled;
    public PressedAlphaImageView mPraiseIcon;
    public String mPraiseId;
    public String mPraiseIdPrefix;
    public String mPraiseSource;
    public int mPraisedRes;
    public Drawable mPraisedResDrawable;
    public ColorStateList mPraisedTextColorStateList;
    public boolean mReversePraiseStatus;
    public boolean mStatusProtecting;
    public int mUnPraisedRes;
    public Drawable mUnPraisedResDrawable;
    public ColorStateList mUnPraisedTextColorStateList;
    public LinearLayout mWrapperLayout;

    /* loaded from: classes7.dex */
    public interface ExtraTouchEventListener {
        void onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public interface LongPressListener {
        void onLongPressCancel();

        void onLongPressStart();
    }

    /* loaded from: classes7.dex */
    public interface OnClickPraiseListener {
        void onClick(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2008248816, "Lcom/baidu/searchbox/ui/CoolPraiseView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2008248816, "Lcom/baidu/searchbox/ui/CoolPraiseView;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseView(Context context) {
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
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_unlike_icon_selector;
        this.mPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_like_icon_selector;
        this.mDisableAnimation = false;
        this.mPraiseIdPrefix = "";
        this.mLocation = new int[4];
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsGuideHandAnimPlaying = false;
        this.mIsGuideBubbleAnimPlaying = false;
        this.mIsLongPressing = false;
        this.mIsPlayingAnim = false;
        this.mPraiseCntsDefaultTextShow = true;
        this.mOnClickPraiseListener = null;
        this.mLongClick = new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CoolPraiseView this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mIsLongPressing = true;
                    if (this.this$0.mLongPressListener != null) {
                        boolean unused = CoolPraiseView.DEBUG;
                        this.this$0.mLongPressListener.onLongPressStart();
                    }
                }
            }
        };
        init(context, null);
    }

    public static /* synthetic */ int access$1108(CoolPraiseView coolPraiseView) {
        int i2 = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$1110(CoolPraiseView coolPraiseView) {
        int i2 = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int access$2808(CoolPraiseView coolPraiseView) {
        int i2 = coolPraiseView.mGuidePlayRepeatCount;
        coolPraiseView.mGuidePlayRepeatCount = i2 + 1;
        return i2;
    }

    public static String convertLikeCount(int i2) {
        InterceptResult invokeI;
        String string;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65582, null, i2)) == null) {
            if (i2 <= 0) {
                return "";
            }
            long j = i2;
            if (j < 10000) {
                return i2 + "";
            }
            if (j < BILLION) {
                string = AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_ten_thousand);
                d2 = i2;
                d3 = 10000.0d;
            } else {
                string = AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_billion_unit);
                d2 = i2;
                d3 = 1.0E8d;
            }
            double d4 = d2 / d3;
            DecimalFormat decimalFormat = new DecimalFormat("####.#");
            return decimalFormat.format(d4) + string;
        }
        return (String) invokeI.objValue;
    }

    @Deprecated
    public static String displayLikeCount(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65583, null, i2, str)) == null) ? convertLikeCount(i2) : (String) invokeIL.objValue;
    }

    private boolean doLoginIfNecessary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            if (!PraiseEnvironment.isPraiseLoginSupported(this.mPraiseSource)) {
                boolean z = DEBUG;
                return true;
            } else if (this.mPraiseAnimBlock) {
                boolean z2 = DEBUG;
                return false;
            } else if (!NetWorkUtils.isNetworkConnected()) {
                this.mPraiseAnimBlock = true;
                UniversalToast.makeText(this.mContext, NET_ERROR_TIP).showToast();
                boolean z3 = DEBUG;
                return false;
            } else if (ComboPraiseRuntime.getContext().isLogin()) {
                boolean z4 = DEBUG;
                return true;
            } else {
                ComboPraiseRuntime.getContext().doLogin(this.mContext, new ILoginStatusListener(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CoolPraiseView this$0;

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

                    @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                    public void loginFail() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            boolean unused = CoolPraiseView.DEBUG;
                        }
                    }

                    @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                    public void loginSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            boolean unused = CoolPraiseView.DEBUG;
                            this.this$0.performClick();
                        }
                    }
                });
                this.mPraiseAnimBlock = true;
                boolean z5 = DEBUG;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getLikeCountWithTenThousand(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65585, null, i2)) == null) ? displayLikeCount(i2, AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_ten_thousand)) : (String) invokeI.objValue;
    }

    public static ColorStateList getPressedColorStateList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65586, null, i2, i3)) == null) ? new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i3, i2}) : (ColorStateList) invokeII.objValue;
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65587, this, context, attributeSet) == null) {
            this.mContext = context;
            initView(context, attributeSet);
            setup();
        }
    }

    private void initPraiseDefaultIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.android.common.widget.praise.R.drawable.comment_item_unlike_icon_selector);
            this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.android.common.widget.praise.R.drawable.comment_item_like_icon_selector);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPraiseLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            this.mPraiseIcon.getLocationOnScreen(this.mLocation);
            if (DEBUG) {
                String str = "initPraiseLocation isFullScreen" + isFullScreen();
            }
            if (isFullScreen()) {
                return;
            }
            int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
            int[] iArr = this.mLocation;
            iArr[1] = iArr[1] - statusBarHeight;
        }
    }

    private void initPraiseManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            boolean z = DEBUG;
            ComboPraiseManager comboPraiseManager = new ComboPraiseManager((Activity) this.mContext, "");
            this.mComboPraiseManager = comboPraiseManager;
            comboPraiseManager.setPraiseManagerCallback(new IPraiseManagerCallback(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

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

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public int getAnchorHeight() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "getAnchorHeight:" + this.this$0.mPraiseIcon.getHeight();
                        }
                        return this.this$0.mPraiseIcon.getHeight();
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public int getAnchorLeft() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        this.this$0.initPraiseLocation();
                        if (CoolPraiseView.DEBUG) {
                            String str = "getAnchorLeft:" + this.this$0.mLocation[0];
                        }
                        return this.this$0.mLocation[0];
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public int getAnchorTop() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "getAnchorTop:" + this.this$0.mLocation[1];
                        }
                        return this.this$0.mLocation[1];
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public int getAnchorWidth() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "getAnchorWidth:" + this.this$0.mPraiseIcon.getWidth();
                        }
                        return this.this$0.mPraiseIcon.getWidth();
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public String getPraiseId() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        if (CoolPraiseView.DEBUG) {
                            r0 = "getPraiseId:" + this.this$0.mPraiseIdPrefix + this.this$0.mPraiseId;
                        }
                        return this.this$0.mPraiseIdPrefix + this.this$0.mPraiseId;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
                public String getPraiseSource() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? this.this$0.mPraiseSource : (String) invokeV.objValue;
                }
            });
            this.mComboPraiseManager.setPraiseAnimListener(new IExPraiseAnimListener(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

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
                    CoolPraiseView coolPraiseView;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "onPraiseAnimEnd--" + this.this$0.mPraiseId;
                        }
                        this.this$0.mIsPlayingAnim = false;
                        if (this.this$0.mReversePraiseStatus) {
                            this.this$0.mIsPraised = !coolPraiseView.mIsPraised;
                            this.this$0.mReversePraiseStatus = false;
                        }
                        if (this.this$0.mIsAnimCancelling) {
                            this.this$0.mIsAnimCancelling = false;
                            if (this.this$0.mIsPraised) {
                                CoolPraiseView.access$1110(this.this$0);
                                CoolPraiseView coolPraiseView2 = this.this$0;
                                coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                                this.this$0.setPraiseUnProtected(false);
                                if (this.this$0.mOnClickPraiseListener != null) {
                                    this.this$0.mOnClickPraiseListener.onClick(false, this.this$0.mPraiseCount);
                                    if (CoolPraiseView.DEBUG) {
                                        String str2 = "onClick called from onPraiseAnimEnd, praiseStatus:true->false, praiseCnt:" + (this.this$0.mPraiseCount + 1) + "->" + this.this$0.mPraiseCount;
                                    }
                                }
                            }
                        }
                        this.this$0.mStatusProtecting = false;
                        this.this$0.mPraiseAnimBlock = false;
                        LinkageControlUtil.notifyEnableLinkageScroll();
                        BdEventBus.Companion.getDefault().post(new PraiseAnimState(2, this.this$0));
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IExPraiseAnimListener
                public void onPraiseAnimPrevented(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "onPraiseAnimPrevented--" + this.this$0.mPraiseId + ", reason:" + i2;
                        }
                        if (i2 == 1) {
                            this.this$0.mIsAnimCancelling = true;
                        }
                        this.this$0.mPraiseAnimPrevented = true;
                        LinkageControlUtil.notifyDisableLinkageScroll();
                        BdEventBus.Companion.getDefault().post(new PraiseAnimState(3, this.this$0));
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
                public void onPraiseAnimStart() {
                    CoolPraiseView coolPraiseView;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "onPraiseAnimStart--" + this.this$0.mPraiseId;
                        }
                        this.this$0.mIsPlayingAnim = true;
                        if (!this.this$0.mIsPraised) {
                            CoolPraiseView.access$1108(this.this$0);
                            CoolPraiseView coolPraiseView2 = this.this$0;
                            coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                            this.this$0.setPraiseUnProtected(true);
                            if (this.this$0.mOnClickPraiseListener != null) {
                                this.this$0.mOnClickPraiseListener.onClick(true, this.this$0.mPraiseCount);
                                if (CoolPraiseView.DEBUG) {
                                    String str2 = "onClick called from onPraiseAnimStart, praiseStatus:false->true, praiseCnt:" + (this.this$0.mPraiseCount - 1) + "->" + this.this$0.mPraiseCount;
                                }
                            }
                            this.this$0.mIsPraised = !coolPraiseView.mIsPraised;
                            this.this$0.mReversePraiseStatus = true;
                        }
                        if (this.this$0.mStatusProtecting) {
                            LinkageControlUtil.notifyDisableLinkageScroll();
                        }
                        BdEventBus.Companion.getDefault().post(new PraiseAnimState(1, this.this$0));
                    }
                }
            });
        }
    }

    private void initView(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65591, this, context, attributeSet) == null) {
            LayoutInflater.from(context).inflate(com.baidu.android.common.widget.praise.R.layout.cool_praise_view, (ViewGroup) this, true);
            this.mPraiseIcon = (PressedAlphaImageView) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like_icon);
            this.mPraiseCntsView = (TextView) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like_text);
            this.mWrapperLayout = (LinearLayout) findViewById(com.baidu.android.common.widget.praise.R.id.video_detail_like);
            TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, com.baidu.android.common.widget.praise.R.styleable.coolPraiseView) : null;
            float dimension = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pHeight, 0.0f) : 0.0f;
            float dimension2 = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pWidth, 0.0f) : 0.0f;
            float dimension3 = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pMarginLeft, 0.0f) : 0.0f;
            int dimension4 = obtainStyledAttributes != null ? (int) obtainStyledAttributes.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pPaddingLeft, 0.0f) : 0;
            float dimension5 = obtainStyledAttributes != null ? obtainStyledAttributes.getDimension(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pTextSize, 0.0f) : 0.0f;
            boolean z = obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pShowText, true) : true;
            boolean z2 = obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(com.baidu.android.common.widget.praise.R.styleable.coolPraiseView_pTextBold, false) : false;
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            if (z2) {
                this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(0));
            }
            initPraiseDefaultIcon();
            LinearLayout linearLayout = this.mWrapperLayout;
            linearLayout.setPadding(dimension4, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPraiseIcon.getLayoutParams();
            layoutParams.width = (int) dimension2;
            layoutParams.height = (int) dimension;
            this.mPraiseIcon.setLayoutParams(layoutParams);
            this.mPraiseIcon.setDrawingCacheEnabled(true);
            this.mPraiseCntsView.setVisibility(z ? 0 : 8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams();
            int i2 = (int) dimension3;
            layoutParams2.leftMargin = i2;
            this.mPraiseCntsView.setLayoutParams(layoutParams2);
            this.mPraiseCntsView.setTextSize(0, dimension5);
            this.mPraiseCntsMarginLeft = i2;
            setPraiseUnProtected(false);
            initPraiseManager();
        }
    }

    private boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, this)) == null) {
            int i2 = ((Activity) this.mContext).getWindow().getAttributes().flags & 1024;
            if (DEBUG) {
                String str = "isFullScreen flag:" + i2;
            }
            return i2 != 0;
        }
        return invokeV.booleanValue;
    }

    private boolean isGuideAnimPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) ? this.mIsGuideHandAnimPlaying || this.mIsGuideBubbleAnimPlaying : invokeV.booleanValue;
    }

    private void playBubble(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65594, this, i2, i3) == null) {
            this.mIsGuideBubbleAnimPlaying = true;
            this.mCoolPraiseGuideLottieView = new CoolPraiseGuideLottieView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mCoolPraiseGuideLottieView.getRealWidth(), this.mCoolPraiseGuideLottieView.getRealHeigth());
            layoutParams.leftMargin = i2 - (this.mCoolPraiseGuideLottieView.getRealWidth() / 2);
            layoutParams.topMargin = i3 - this.mCoolPraiseGuideLottieView.getRealHeigth();
            this.mGuidePlayRootView.addView(this.mCoolPraiseGuideLottieView, layoutParams);
            this.mCoolPraiseGuideLottieView.setAnimatorListenerAdapter(new AnimatorListenerAdapter(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.mMainHandler.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.9.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass9 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
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
                                    this.this$1.this$0.mGuidePlayRootView.removeView(this.this$1.this$0.mCoolPraiseGuideLottieView);
                                    this.this$1.this$0.mIsGuideBubbleAnimPlaying = false;
                                }
                            }
                        }, 200L);
                    }
                }
            });
            this.mCoolPraiseGuideLottieView.play();
        }
    }

    private void playHand(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65595, this, i2, i3) == null) {
            this.mIsGuideHandAnimPlaying = true;
            this.mCopyPressedImageView = new PressedAlphaImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPraiseIcon.getWidth(), this.mPraiseIcon.getHeight());
            layoutParams.leftMargin = i2 - (this.mPraiseIcon.getWidth() / 2);
            layoutParams.topMargin = i3 - (this.mPraiseIcon.getHeight() / 2);
            this.mCopyPressedImageView.setImageBitmap(this.mPraiseIcon.getDrawingCache());
            this.mGuidePlayRootView.addView(this.mCopyPressedImageView, layoutParams);
            this.mGuidePlayRepeatCount = 0;
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), com.baidu.android.common.widget.praise.R.animator.bd_praise_guide_animator);
            this.mGuideAnimator = animatorSet;
            animatorSet.setTarget(this.mCopyPressedImageView);
            this.mCopyPressedImageView.setPivotX(0.0f);
            this.mCopyPressedImageView.setPivotY(this.mPraiseIcon.getHeight());
            this.mCopyPressedImageView.invalidate();
            this.mGuideAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        if (this.this$0.mGuidePlayRepeatCount >= 1) {
                            this.this$0.mMainHandler.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass8 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
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
                                        this.this$1.this$0.mGuidePlayRootView.removeView(this.this$1.this$0.mCopyPressedImageView);
                                        this.this$1.this$0.mIsGuideHandAnimPlaying = false;
                                    }
                                }
                            }, 200L);
                            this.this$0.mPraiseIcon.setVisibility(0);
                            return;
                        }
                        this.this$0.mGuideAnimator.setStartDelay(560L);
                        this.this$0.mGuideAnimator.start();
                        CoolPraiseView.access$2808(this.this$0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.this$0.mPraiseIcon.setVisibility(4);
                    }
                }
            });
            this.mGuideAnimator.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        if (com.baidu.searchbox.ui.CoolPraiseView.DEBUG == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r0 = r0.getClass().getSimpleName() + ", resetTouchEvent";
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        r5.setAction(3);
        r0 = (android.view.View) r0;
        r0.dispatchTouchEvent(r5);
        r5.setAction(0);
        r0.dispatchTouchEvent(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetTouchEvent(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65596, this, motionEvent) == null) {
            ViewParent parent = getParent();
            while (parent != null && !(parent instanceof ListView) && !(parent instanceof RecyclerView)) {
                parent = parent.getParent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPraiseUnProtected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65598, this, z) == null) {
            this.mIsPraised = z;
            if (this.mUnPraisedTextColorStateList == null) {
                this.mUnPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.android.common.widget.praise.R.color.comment_item_unlike_text_color_selector);
            }
            if (this.mPraisedTextColorStateList == null) {
                this.mPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.android.common.widget.praise.R.color.comment_item_like_text_color_selector);
            }
            if (z) {
                Drawable drawable = this.mPraisedResDrawable;
                if (drawable != null) {
                    this.mPraiseIcon.setImageDrawable(drawable);
                } else {
                    this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mPraisedRes));
                }
                ColorStateList colorStateList = this.mPraisedTextColorStateList;
                if (colorStateList != null) {
                    this.mPraiseCntsView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            Drawable drawable2 = this.mUnPraisedResDrawable;
            if (drawable2 != null) {
                this.mPraiseIcon.setImageDrawable(drawable2);
            } else {
                this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mUnPraisedRes));
            }
            ColorStateList colorStateList2 = this.mUnPraisedTextColorStateList;
            if (colorStateList2 != null) {
                this.mPraiseCntsView.setTextColor(colorStateList2);
            }
        }
    }

    private void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

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

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.this$0.mIsLongPressing) {
                            boolean unused = CoolPraiseView.DEBUG;
                            this.this$0.mMainHandler.removeCallbacks(this.this$0.mLongClick);
                        } else if (this.this$0.mLongPressListener != null) {
                            this.this$0.mIsLongPressing = false;
                            boolean unused2 = CoolPraiseView.DEBUG;
                            this.this$0.mLongPressListener.onLongPressCancel();
                            return;
                        }
                        if (this.this$0.mIsPlayingAnim) {
                            return;
                        }
                        if (this.this$0.isPraiseEnabled()) {
                            if (this.this$0.mIsPraised) {
                                if (PraiseEnvironment.isCancelPraiseEnabled(this.this$0.mPraiseSource)) {
                                    CoolPraiseView.access$1110(this.this$0);
                                    this.this$0.setPraiseUnProtected(false);
                                    CoolPraiseView coolPraiseView = this.this$0;
                                    coolPraiseView.setPraiseCount(coolPraiseView.mPraiseCount);
                                    PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(this.this$0.mPraiseSource, this.this$0.mPraiseIdPrefix + this.this$0.mPraiseId), 0L);
                                }
                            } else {
                                CoolPraiseView.access$1108(this.this$0);
                                this.this$0.setPraiseUnProtected(true);
                                CoolPraiseView coolPraiseView2 = this.this$0;
                                coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                            }
                            if (this.this$0.mOnClickPraiseListener != null) {
                                this.this$0.mOnClickPraiseListener.onClick(this.this$0.mIsPraised, this.this$0.mPraiseCount);
                                if (CoolPraiseView.DEBUG) {
                                    if (this.this$0.mIsPraised) {
                                        String str = "onClick called from setup, praiseStatus:false->true, praiseCnt:" + (this.this$0.mPraiseCount - 1) + "->" + this.this$0.mPraiseCount;
                                        return;
                                    }
                                    String str2 = "onClick called from setup, praiseStatus:true->false, praiseCnt:" + (this.this$0.mPraiseCount + 1) + "->" + this.this$0.mPraiseCount;
                                }
                            }
                        } else if (this.this$0.mOnClickPraiseListener != null) {
                            this.this$0.mOnClickPraiseListener.onClick(this.this$0.mIsPraised, this.this$0.mPraiseCount);
                            if (CoolPraiseView.DEBUG) {
                                String str3 = "onClick called from setup, praiseStatus:" + this.this$0.mIsPraised + "praiseCnt:" + this.this$0.mPraiseCount;
                            }
                        }
                    }
                }
            });
        }
    }

    public void cancelGuidePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isGuideAnimPlaying()) {
            post(new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

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
                        if (this.this$0.mGuideAnimator != null) {
                            this.this$0.mGuideAnimator.cancel();
                        }
                        if (this.this$0.mGuidePlayRootView != null && this.this$0.mCopyPressedImageView != null) {
                            this.this$0.mGuidePlayRootView.removeView(this.this$0.mCopyPressedImageView);
                            this.this$0.mPraiseIcon.setVisibility(0);
                        }
                        if (this.this$0.mGuidePlayRootView == null || this.this$0.mCoolPraiseGuideLottieView == null) {
                            return;
                        }
                        this.this$0.mCoolPraiseGuideLottieView.cancel();
                        this.this$0.mGuidePlayRootView.removeView(this.this$0.mCoolPraiseGuideLottieView);
                    }
                }
            });
        }
    }

    public CoolPraiseView disablePraiseAnimation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (this.mStatusProtecting) {
                return this;
            }
            this.mDisableAnimation = z;
            return this;
        }
        return (CoolPraiseView) invokeZ.objValue;
    }

    public void disableStatusProtecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mStatusProtecting = false;
        }
    }

    public boolean getIsPraisedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsPraised : invokeV.booleanValue;
    }

    public boolean guidePlay(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (isGuideAnimPlaying()) {
                return false;
            }
            if (!z || ControlShowManager.getInstance().canShow()) {
                int[] iArr = new int[2];
                this.mPraiseIcon.getLocationOnScreen(iArr);
                int width = iArr[0] + (this.mPraiseIcon.getWidth() / 2);
                int height = iArr[1] + (this.mPraiseIcon.getHeight() / 2);
                if (viewGroup == null) {
                    this.mGuidePlayRootView = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
                } else {
                    this.mGuidePlayRootView = viewGroup;
                }
                playHand(width, height);
                playBubble(width, height);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean isPraiseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPraiseEnabled : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            initPraiseLocation();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (doLoginIfNecessary() && ((!PraiseEnvironment.isCancelPraiseEnabled(this.mPraiseSource) || !this.mIsPraised) && !this.mDisableAnimation && ComboPraiseManager.isPraiseEnabled(this.mPraiseSource) && !this.mPraiseAnimBlock)) {
                if (DEBUG) {
                    if (DeviceUtil.OSInfo.hasKitKat()) {
                        String str = "pos1:" + MotionEvent.actionToString(motionEvent.getAction());
                    } else {
                        String str2 = "pos1:" + motionEvent.getAction();
                    }
                }
                if (this.mPraiseCount == 0 && !this.mStatusProtecting) {
                    this.mComboPraiseManager.setFirstPraiseAnimEnabled(true);
                }
                this.mComboPraiseManager.onTouchForNA(motionEvent);
                ExtraTouchEventListener extraTouchEventListener = this.mExtraTouchEventListener;
                if (extraTouchEventListener != null) {
                    extraTouchEventListener.onTouchEvent(motionEvent);
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.mStatusProtecting = true;
                    requestDisallowInterceptTouchEvent(true);
                    this.mPraiseAnimPrevented = false;
                } else if (action == 1 || action == 3) {
                    this.mStatusProtecting = false;
                    LinkageControlUtil.notifyEnableLinkageScroll();
                }
                if (this.mPraiseAnimPrevented) {
                    boolean z = DEBUG;
                    requestDisallowInterceptTouchEvent(false);
                    this.mPraiseAnimBlock = true;
                    return false;
                }
                return true;
            }
            if (DEBUG) {
                if (Build.VERSION.SDK_INT >= 19) {
                    String str3 = "pos2:" + MotionEvent.actionToString(motionEvent.getAction());
                } else {
                    String str4 = "pos2:" + motionEvent.getAction();
                }
            }
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                ExtraTouchEventListener extraTouchEventListener2 = this.mExtraTouchEventListener;
                if (extraTouchEventListener2 != null) {
                    extraTouchEventListener2.onTouchEvent(motionEvent);
                }
                boolean z2 = DEBUG;
                this.mMainHandler.postDelayed(this.mLongClick, 550L);
                if (this.mPraiseAnimBlock) {
                    return true;
                }
            } else if (action2 == 1 || action2 == 3) {
                ExtraTouchEventListener extraTouchEventListener3 = this.mExtraTouchEventListener;
                if (extraTouchEventListener3 != null) {
                    extraTouchEventListener3.onTouchEvent(motionEvent);
                }
                this.mStatusProtecting = false;
                this.mPraiseAnimBlock = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setExtraTouchEventListener(ExtraTouchEventListener extraTouchEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, extraTouchEventListener) == null) {
            this.mExtraTouchEventListener = extraTouchEventListener;
        }
    }

    public CoolPraiseView setLikeLayoutBgDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, drawable)) == null) {
            this.mWrapperLayout.setBackground(drawable);
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    public CoolPraiseView setLikeLayoutLp(LinearLayout.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, layoutParams)) == null) {
            this.mWrapperLayout.setLayoutParams(layoutParams);
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    public void setLongPressListener(LongPressListener longPressListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, longPressListener) == null) && this.mLongPressListener == null) {
            this.mLongPressListener = longPressListener;
            this.mComboPraiseManager.setComboPraiseLongPressListener(new ComboPraiseManager.ComboPraiseLongPressListener(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CoolPraiseView this$0;

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

                @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.ComboPraiseLongPressListener
                public void onComboPraiseLongPressCancel() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "#ComboPraiseLongPressListener: cancel, mIsPlayingAnim: " + this.this$0.mIsPlayingAnim;
                        }
                        if (this.this$0.mLongPressListener == null || this.this$0.mIsPlayingAnim) {
                            return;
                        }
                        this.this$0.mLongPressListener.onLongPressCancel();
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.ComboPraiseLongPressListener
                public void onComboPraiseLongPressStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (CoolPraiseView.DEBUG) {
                            String str = "#ComboPraiseLongPressListener: start, mIsPlayingAnim: " + this.this$0.mIsPlayingAnim;
                        }
                        if (this.this$0.mLongPressListener == null || this.this$0.mIsPlayingAnim) {
                            return;
                        }
                        this.this$0.mLongPressListener.onLongPressStart();
                    }
                }
            });
        }
    }

    public void setOnClickPraiseListener(OnClickPraiseListener onClickPraiseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickPraiseListener) == null) {
            this.mOnClickPraiseListener = onClickPraiseListener;
        }
    }

    public void setPraise(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.mStatusProtecting) {
            return;
        }
        setPraiseUnProtected(z);
    }

    public void setPraiseCntsDefaultTextVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mPraiseCntsDefaultTextShow = z;
        }
    }

    public void setPraiseCntsLeftMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            setPraiseCntsLeftMargin(i2, true);
        }
    }

    public void setPraiseCntsTextSize(int i2, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (textView = this.mPraiseCntsView) == null) {
            return;
        }
        textView.setTextSize(i2, f2);
    }

    public void setPraiseCntsTopMargin(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (textView = this.mPraiseCntsView) == null) {
            return;
        }
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = i2;
    }

    public void setPraiseCntsVisibility(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (textView = this.mPraiseCntsView) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public CoolPraiseView setPraiseCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.mPraiseCount = i2;
            if (i2 <= 0) {
                this.mPraiseCount = 0;
                if (this.mPraiseCntsDefaultTextShow) {
                    this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_text));
                    setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
                } else {
                    this.mPraiseCntsView.setText("");
                    setPraiseCntsLeftMargin(0, false);
                }
                if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource)) {
                    boolean z = DEBUG;
                    this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.praise_firstpraise));
                }
            } else {
                setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
                this.mPraiseCntsView.setText(getLikeCountWithTenThousand(i2));
            }
            return this;
        }
        return (CoolPraiseView) invokeI.objValue;
    }

    @Deprecated
    public CoolPraiseView setPraiseIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.mPraiseIcon.setImageDrawable(getResources().getDrawable(i2));
            return this;
        }
        return (CoolPraiseView) invokeI.objValue;
    }

    public CoolPraiseView setPraiseIconPressedAlpha(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f2)) == null) {
            this.mPraiseIcon.setPressedAlpha(f2);
            return this;
        }
        return (CoolPraiseView) invokeF.objValue;
    }

    public synchronized void setPraiseIconResByName(String str, boolean z, int i2, int i3, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), runnable}) == null) {
            synchronized (this) {
                postDelayed(new Runnable(this, z, str, i2, i3, runnable) { // from class: com.baidu.searchbox.ui.CoolPraiseView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CoolPraiseView this$0;
                    public final /* synthetic */ Runnable val$callback;
                    public final /* synthetic */ boolean val$isDisableAnimation;
                    public final /* synthetic */ String val$name;
                    public final /* synthetic */ int val$praisedTextRes;
                    public final /* synthetic */ int val$unPraisedTextRes;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), str, Integer.valueOf(i2), Integer.valueOf(i3), runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$isDisableAnimation = z;
                        this.val$name = str;
                        this.val$unPraisedTextRes = i2;
                        this.val$praisedTextRes = i3;
                        this.val$callback = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mDisableAnimation = this.val$isDisableAnimation;
                            String str2 = this.val$name + ".png";
                            boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
                            this.this$0.mPraiseIcon.refreshDrawableState();
                            this.this$0.mUnPraisedResDrawable = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, false);
                            if (this.this$0.mUnPraisedResDrawable != null) {
                                if (this.this$0.mUnPraisedResDrawable.getConstantState() != null) {
                                    CoolPraiseView coolPraiseView = this.this$0;
                                    coolPraiseView.mUnPraisedResDrawable = coolPraiseView.mUnPraisedResDrawable.getConstantState().newDrawable().mutate();
                                }
                            } else if (this.val$unPraisedTextRes > 0) {
                                this.this$0.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(this.val$unPraisedTextRes);
                            }
                            this.this$0.mPraisedResDrawable = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, true);
                            if (this.this$0.mPraisedResDrawable != null) {
                                if (this.this$0.mPraisedResDrawable.getConstantState() != null) {
                                    CoolPraiseView coolPraiseView2 = this.this$0;
                                    coolPraiseView2.mPraisedResDrawable = coolPraiseView2.mPraisedResDrawable.getConstantState().newDrawable().mutate();
                                }
                            } else if (this.val$praisedTextRes > 0) {
                                this.this$0.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(this.val$praisedTextRes);
                            }
                            CoolPraiseView coolPraiseView3 = this.this$0;
                            coolPraiseView3.setPraise(coolPraiseView3.mIsPraised);
                            this.this$0.requestLayout();
                            this.this$0.invalidate();
                            Runnable runnable2 = this.val$callback;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                        }
                    }
                }, 50L);
            }
        }
    }

    public void setPraiseIconSize(int i2, int i3) {
        PressedAlphaImageView pressedAlphaImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) || (pressedAlphaImageView = this.mPraiseIcon) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pressedAlphaImageView.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.mPraiseIcon.setLayoutParams(layoutParams);
    }

    public CoolPraiseView setPraiseId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.mPraiseId = str;
            ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
            if (comboPraiseManager != null) {
                comboPraiseManager.setPraiseId(str);
            }
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    public void setPraiseLayoutLeftPadding(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (linearLayout = this.mWrapperLayout) == null) {
            return;
        }
        linearLayout.setPadding(i2, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
    }

    public CoolPraiseView setPraiseSource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.mPraiseSource = str;
            ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
            if (comboPraiseManager != null) {
                comboPraiseManager.setPraiseSource(str);
                setPraiseCount(this.mPraiseCount);
            }
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    public CoolPraiseView setPraiseStateIconRes(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
            this.mUnPraisedResDrawable = null;
            this.mPraisedResDrawable = null;
            this.mUnPraisedRes = i2;
            this.mPraisedRes = i3;
            setPraise(this.mIsPraised);
            return this;
        }
        return (CoolPraiseView) invokeII.objValue;
    }

    public CoolPraiseView setPraiseStateTextRes(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048607, this, i2, i3, i4, i5)) == null) ? setPraiseStateTextRes(getPressedColorStateList(i2, i3), getPressedColorStateList(i4, i5)) : (CoolPraiseView) invokeIIII.objValue;
    }

    @Deprecated
    public CoolPraiseView setPraiseTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{i2});
            if (this.mIsPraised) {
                this.mPraisedTextColorStateList = colorStateList;
            } else {
                this.mUnPraisedTextColorStateList = colorStateList;
            }
            this.mPraiseCntsView.setTextColor(colorStateList);
            return this;
        }
        return (CoolPraiseView) invokeI.objValue;
    }

    public void setPraiseable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.mPraiseEnabled = z;
        }
    }

    public CoolPraiseView setPrefixForPraiseId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.mPraiseIdPrefix = str;
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PressedAlphaImageView pressedAlphaImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, scaleType) == null) || (pressedAlphaImageView = this.mPraiseIcon) == null) {
            return;
        }
        pressedAlphaImageView.setScaleType(scaleType);
    }

    public CoolPraiseView setUBC(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, str, str2)) == null) {
            ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
            if (comboPraiseManager != null) {
                comboPraiseManager.setUBCParams(new ComboPraiseUBC(str, str2));
            }
            return this;
        }
        return (CoolPraiseView) invokeLL.objValue;
    }

    private void setPraiseCntsLeftMargin(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65597, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.mPraiseCntsMarginLeft = i2;
            }
            TextView textView = this.mPraiseCntsView;
            if (textView != null) {
                ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin = i2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PraiseAnimState {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ANIM_STATE_PREVENTED = 3;
        public static final int ANIM_STATE_STARTED = 1;
        public static final int ANIM_STATE_STOPPED = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public int animState;
        public CoolPraiseView praiseView;

        public PraiseAnimState(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.animState = -1;
            this.animState = i2;
        }

        public int getAnimState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.animState : invokeV.intValue;
        }

        public CoolPraiseView getPraiseView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.praiseView : (CoolPraiseView) invokeV.objValue;
        }

        public PraiseAnimState(int i2, CoolPraiseView coolPraiseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), coolPraiseView};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.animState = -1;
            this.animState = i2;
            this.praiseView = coolPraiseView;
        }
    }

    public synchronized void setPraiseIconResByName(String str, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                setPraiseIconResByName(str, z, i2, i3, null);
            }
        }
    }

    public CoolPraiseView setUBC(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? setUBC(str, "") : (CoolPraiseView) invokeL.objValue;
    }

    public CoolPraiseView setPraiseStateTextRes(int i2, int i3) {
        InterceptResult invokeII;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048606, this, i2, i3)) == null) {
            ColorStateList colorStateList2 = null;
            try {
                colorStateList = AppRuntime.getAppContext().getResources().getColorStateList(i2);
                try {
                    colorStateList2 = AppRuntime.getAppContext().getResources().getColorStateList(i3);
                } catch (Resources.NotFoundException unused) {
                }
            } catch (Resources.NotFoundException unused2) {
                colorStateList = null;
            }
            return setPraiseStateTextRes(colorStateList, colorStateList2);
        }
        return (CoolPraiseView) invokeII.objValue;
    }

    public CoolPraiseView setPraiseStateTextRes(ColorStateList colorStateList, ColorStateList colorStateList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, colorStateList, colorStateList2)) == null) {
            this.mUnPraisedTextColorStateList = colorStateList;
            this.mPraisedTextColorStateList = colorStateList2;
            setPraise(this.mIsPraised);
            return this;
        }
        return (CoolPraiseView) invokeLL.objValue;
    }

    public CoolPraiseView setPraiseCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            try {
                setPraiseCount(Integer.parseInt(str));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return this;
        }
        return (CoolPraiseView) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_unlike_icon_selector;
        this.mPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_like_icon_selector;
        this.mDisableAnimation = false;
        this.mPraiseIdPrefix = "";
        this.mLocation = new int[4];
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsGuideHandAnimPlaying = false;
        this.mIsGuideBubbleAnimPlaying = false;
        this.mIsLongPressing = false;
        this.mIsPlayingAnim = false;
        this.mPraiseCntsDefaultTextShow = true;
        this.mOnClickPraiseListener = null;
        this.mLongClick = new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CoolPraiseView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mIsLongPressing = true;
                    if (this.this$0.mLongPressListener != null) {
                        boolean unused = CoolPraiseView.DEBUG;
                        this.this$0.mLongPressListener.onLongPressStart();
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_unlike_icon_selector;
        this.mPraisedRes = com.baidu.android.common.widget.praise.R.drawable.comment_item_like_icon_selector;
        this.mDisableAnimation = false;
        this.mPraiseIdPrefix = "";
        this.mLocation = new int[4];
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsGuideHandAnimPlaying = false;
        this.mIsGuideBubbleAnimPlaying = false;
        this.mIsLongPressing = false;
        this.mIsPlayingAnim = false;
        this.mPraiseCntsDefaultTextShow = true;
        this.mOnClickPraiseListener = null;
        this.mLongClick = new Runnable(this) { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CoolPraiseView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mIsLongPressing = true;
                    if (this.this$0.mLongPressListener != null) {
                        boolean unused = CoolPraiseView.DEBUG;
                        this.this$0.mLongPressListener.onLongPressStart();
                    }
                }
            }
        };
        init(context, attributeSet);
    }
}
