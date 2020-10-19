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
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.NetWorkUtils;
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
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.praise.resource.CoolPraiseIconResource;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.LinkageControlUtil;
/* loaded from: classes9.dex */
public class CoolPraiseView extends LinearLayout {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    private static final String NET_ERROR_TIP = "网络不给力，请稍后重试";
    private static final int REMOVE_VIEW_DELAY_TIME_MS = 200;
    private static final int START_DELAY_TIME_MS = 560;
    private static final String TAG = "CoolPraiseView";
    private ComboPraiseManager mComboPraiseManager;
    private Context mContext;
    private CoolPraiseGuideLottieView mCoolPraiseGuideLottieView;
    private PressedAlphaImageView mCopyPressedImageView;
    private boolean mDisableAnimation;
    private ExtraTouchEventListener mExtraTouchEventListener;
    private AnimatorSet mGuideAnimator;
    private int mGuidePlayRepeatCount;
    private ViewGroup mGuidePlayRootView;
    private boolean mIsAnimCancelling;
    private boolean mIsGuideBubbleAnimPlaying;
    private boolean mIsGuideHandAnimPlaying;
    private boolean mIsPraised;
    private int[] mLocation;
    private Handler mMainHandler;
    private OnClickPraiseListener mOnClickPraiseListener;
    private boolean mPraiseAnimBlock;
    private boolean mPraiseAnimPrevented;
    private TextView mPraiseCntsView;
    private int mPraiseCount;
    private boolean mPraiseEnabled;
    private PressedAlphaImageView mPraiseIcon;
    private String mPraiseId;
    private String mPraiseIdPrefix;
    private String mPraiseSource;
    private int mPraisedRes;
    private Drawable mPraisedResDrawable;
    private ColorStateList mPraisedTextColorStateList;
    private boolean mReversePraiseStatus;
    private boolean mStatusProtecting;
    private int mUnPraisedRes;
    private Drawable mUnPraisedResDrawable;
    private ColorStateList mUnPraisedTextColorStateList;
    private LinearLayout mWrapperLayout;

    /* loaded from: classes9.dex */
    public interface ExtraTouchEventListener {
        void onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes9.dex */
    public interface OnClickPraiseListener {
        void onClick(boolean z, int i);
    }

    static /* synthetic */ int access$2308(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mGuidePlayRepeatCount;
        coolPraiseView.mGuidePlayRepeatCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$608(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$610(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i - 1;
        return i;
    }

    public CoolPraiseView(Context context) {
        super(context);
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
        this.mOnClickPraiseListener = null;
        init(context, null);
    }

    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
        this.mOnClickPraiseListener = null;
        init(context, attributeSet);
    }

    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.mOnClickPraiseListener = null;
        init(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
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
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        initPraiseDefaultIcon();
        this.mWrapperLayout.setPadding(dimension4, this.mWrapperLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPraiseIcon.getLayoutParams();
        layoutParams.width = (int) dimension2;
        layoutParams.height = (int) dimension;
        this.mPraiseIcon.setLayoutParams(layoutParams);
        this.mPraiseIcon.setDrawingCacheEnabled(true);
        this.mPraiseCntsView.setVisibility(z ? 0 : 8);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams();
        layoutParams2.leftMargin = (int) dimension3;
        this.mPraiseCntsView.setLayoutParams(layoutParams2);
        this.mPraiseCntsView.setTextSize(0, dimension5);
        setPraiseUnProtected(false);
        initPraiseManager();
    }

    public boolean isPraiseEnabled() {
        return this.mPraiseEnabled;
    }

    public void setPraiseable(boolean z) {
        this.mPraiseEnabled = z;
    }

    public void setOnClickPraiseListener(OnClickPraiseListener onClickPraiseListener) {
        this.mOnClickPraiseListener = onClickPraiseListener;
    }

    public boolean getIsPraisedState() {
        return this.mIsPraised;
    }

    public static String displayLikeCount(int i, String str) {
        return i > 9999 ? String.valueOf((((int) ((i / 1000.0d) + 0.5d)) / 10.0d) + str) : String.valueOf(i);
    }

    public static String getLikeCountWithTenThousand(int i) {
        return displayLikeCount(i, AppRuntime.getAppContext().getResources().getString(com.baidu.android.common.widget.praise.R.string.common_comment_ten_thousand));
    }

    public void setPraise(boolean z) {
        if (!this.mStatusProtecting) {
            setPraiseUnProtected(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPraiseUnProtected(boolean z) {
        this.mIsPraised = z;
        if (this.mUnPraisedTextColorStateList == null) {
            this.mUnPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.android.common.widget.praise.R.color.comment_item_unlike_text_color_selector);
        }
        if (this.mPraisedTextColorStateList == null) {
            this.mPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.android.common.widget.praise.R.color.comment_item_like_text_color_selector);
        }
        if (z) {
            if (this.mPraisedResDrawable != null) {
                this.mPraiseIcon.setImageDrawable(this.mPraisedResDrawable);
            } else {
                this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mPraisedRes));
            }
            if (this.mPraisedTextColorStateList != null) {
                this.mPraiseCntsView.setTextColor(this.mPraisedTextColorStateList);
                return;
            }
            return;
        }
        if (this.mUnPraisedResDrawable != null) {
            this.mPraiseIcon.setImageDrawable(this.mUnPraisedResDrawable);
        } else {
            this.mPraiseIcon.setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(this.mUnPraisedRes));
        }
        if (this.mUnPraisedTextColorStateList != null) {
            this.mPraiseCntsView.setTextColor(this.mUnPraisedTextColorStateList);
        }
    }

    public CoolPraiseView setPraiseStateIconRes(int i, int i2) {
        this.mUnPraisedResDrawable = null;
        this.mPraisedResDrawable = null;
        this.mUnPraisedRes = i;
        this.mPraisedRes = i2;
        setPraise(this.mIsPraised);
        return this;
    }

    public CoolPraiseView setPraiseStateTextRes(int i, int i2, int i3, int i4) {
        return setPraiseStateTextRes(getPressedColorStateList(i, i2), getPressedColorStateList(i3, i4));
    }

    private static ColorStateList getPressedColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i2, i});
    }

    public CoolPraiseView setPraiseStateTextRes(int i, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = null;
        try {
            colorStateList = AppRuntime.getAppContext().getResources().getColorStateList(i);
            try {
                colorStateList2 = AppRuntime.getAppContext().getResources().getColorStateList(i2);
            } catch (Resources.NotFoundException e) {
            }
        } catch (Resources.NotFoundException e2) {
            colorStateList = null;
        }
        return setPraiseStateTextRes(colorStateList, colorStateList2);
    }

    public CoolPraiseView setPraiseStateTextRes(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.mUnPraisedTextColorStateList = colorStateList;
        this.mPraisedTextColorStateList = colorStateList2;
        setPraise(this.mIsPraised);
        return this;
    }

    public synchronized void setPraiseIconResByName(final String str, final boolean z, final int i, final int i2, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.1
            @Override // java.lang.Runnable
            public void run() {
                CoolPraiseView.this.mDisableAnimation = z;
                String str2 = str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
                boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
                CoolPraiseView.this.mPraiseIcon.refreshDrawableState();
                CoolPraiseView.this.mUnPraisedResDrawable = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, false);
                if (CoolPraiseView.this.mUnPraisedResDrawable != null) {
                    if (CoolPraiseView.this.mUnPraisedResDrawable.getConstantState() != null) {
                        CoolPraiseView.this.mUnPraisedResDrawable = CoolPraiseView.this.mUnPraisedResDrawable.getConstantState().newDrawable().mutate();
                    }
                } else if (i > 0) {
                    CoolPraiseView.this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(i);
                }
                CoolPraiseView.this.mPraisedResDrawable = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, true);
                if (CoolPraiseView.this.mPraisedResDrawable != null) {
                    if (CoolPraiseView.this.mPraisedResDrawable.getConstantState() != null) {
                        CoolPraiseView.this.mPraisedResDrawable = CoolPraiseView.this.mPraisedResDrawable.getConstantState().newDrawable().mutate();
                    }
                } else if (i2 > 0) {
                    CoolPraiseView.this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(i2);
                }
                CoolPraiseView.this.setPraise(CoolPraiseView.this.mIsPraised);
                CoolPraiseView.this.requestLayout();
                CoolPraiseView.this.invalidate();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, 50L);
    }

    public synchronized void setPraiseIconResByName(String str, boolean z, int i, int i2) {
        setPraiseIconResByName(str, z, i, i2, null);
    }

    @Deprecated
    public CoolPraiseView setPraiseTextColor(int i) {
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{i});
        if (this.mIsPraised) {
            this.mPraisedTextColorStateList = colorStateList;
        } else {
            this.mUnPraisedTextColorStateList = colorStateList;
        }
        this.mPraiseCntsView.setTextColor(colorStateList);
        return this;
    }

    @Deprecated
    public CoolPraiseView setPraiseIcon(int i) {
        this.mPraiseIcon.setImageDrawable(getResources().getDrawable(i));
        return this;
    }

    public CoolPraiseView setUBC(String str, String str2) {
        if (this.mComboPraiseManager != null) {
            this.mComboPraiseManager.setUBCParams(new ComboPraiseUBC(str, str2));
        }
        return this;
    }

    public CoolPraiseView setUBC(String str) {
        return setUBC(str, "");
    }

    public CoolPraiseView setPraiseSource(String str) {
        this.mPraiseSource = str;
        if (this.mComboPraiseManager != null) {
            this.mComboPraiseManager.setPraiseSource(this.mPraiseSource);
            setPraiseCount(this.mPraiseCount);
        }
        return this;
    }

    public CoolPraiseView setPraiseId(String str) {
        this.mPraiseId = str;
        if (this.mComboPraiseManager != null) {
            this.mComboPraiseManager.setPraiseId(this.mPraiseId);
        }
        return this;
    }

    public CoolPraiseView setPraiseCount(int i) {
        this.mPraiseCount = i;
        if (i <= 0) {
            this.mPraiseCount = 0;
            this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.common_comment_like));
            if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource)) {
                if (DEBUG) {
                    Log.d(TAG, "isFirstPraiseAnimSupported return true");
                }
                this.mPraiseCntsView.setText(getResources().getString(com.baidu.android.common.widget.praise.R.string.common_comment_firstpraise));
            }
        } else {
            this.mPraiseCntsView.setText(getLikeCountWithTenThousand(i));
        }
        return this;
    }

    public CoolPraiseView setPraiseCount(String str) {
        try {
            setPraiseCount(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CoolPraiseView setLikeLayoutLp(LinearLayout.LayoutParams layoutParams) {
        this.mWrapperLayout.setLayoutParams(layoutParams);
        return this;
    }

    public CoolPraiseView setLikeLayoutBgDrawable(Drawable drawable) {
        this.mWrapperLayout.setBackground(drawable);
        return this;
    }

    private boolean doLoginIfNecessary() {
        if (!PraiseEnvironment.isPraiseLoginSupported(this.mPraiseSource)) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseLoginSupported return false, so doLoginIfNecessary=true");
                return true;
            }
            return true;
        } else if (this.mPraiseAnimBlock) {
            if (DEBUG) {
                Log.d(TAG, "mPraiseAnimBlock is true, so doLoginIfNecessary=false");
            }
            return false;
        } else if (!NetWorkUtils.isNetworkConnected()) {
            this.mPraiseAnimBlock = true;
            UniversalToast.makeText(this.mContext, NET_ERROR_TIP).showToast();
            if (DEBUG) {
                Log.d(TAG, "isNetworkConnected return false, so doLoginIfNecessary=false");
            }
            return false;
        } else if (ComboPraiseRuntime.getContext().isLogin()) {
            if (DEBUG) {
                Log.d(TAG, "isLogin return true, so doLoginIfNecessary=true");
                return true;
            }
            return true;
        } else {
            ComboPraiseRuntime.getContext().doLogin(this.mContext, new ILoginStatusListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.2
                @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                public void loginSuccess() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginSuccess, performClick");
                    }
                    CoolPraiseView.this.performClick();
                }

                @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                public void loginFail() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginFail");
                    }
                }
            });
            this.mPraiseAnimBlock = true;
            if (DEBUG) {
                Log.d(TAG, "doLogin, so doLoginIfNecessary=false");
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (doLoginIfNecessary() && ((!PraiseEnvironment.isCancelPraiseEnabled(this.mPraiseSource) || !this.mIsPraised) && !this.mDisableAnimation && ComboPraiseManager.isPraiseEnabled(this.mPraiseSource) && !this.mPraiseAnimBlock)) {
            if (DEBUG) {
                Log.d(TAG, "Praise Animation Triggered");
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    Log.d(TAG, "pos1:" + MotionEvent.actionToString(motionEvent.getAction()));
                } else {
                    Log.d(TAG, "pos1:" + motionEvent.getAction());
                }
            }
            if (this.mPraiseCount == 0 && !this.mStatusProtecting) {
                this.mComboPraiseManager.setFirstPraiseAnimEnabled(true);
            }
            this.mComboPraiseManager.onTouchForNA(motionEvent);
            if (this.mExtraTouchEventListener != null) {
                this.mExtraTouchEventListener.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction()) {
                case 0:
                    this.mStatusProtecting = true;
                    requestDisallowInterceptTouchEvent(true);
                    this.mPraiseAnimPrevented = false;
                    break;
                case 1:
                case 3:
                    this.mStatusProtecting = false;
                    LinkageControlUtil.notifyEnableLinkageScroll();
                    break;
            }
            if (this.mPraiseAnimPrevented) {
                if (DEBUG) {
                    Log.d(TAG, "Praise Animation Prevented");
                }
                requestDisallowInterceptTouchEvent(false);
                this.mPraiseAnimBlock = true;
                return false;
            }
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "Praise Animation disabled or prevented or praised");
            if (DeviceUtil.OSInfo.hasKitKat()) {
                Log.d(TAG, "pos2:" + MotionEvent.actionToString(motionEvent.getAction()));
            } else {
                Log.d(TAG, "pos2:" + motionEvent.getAction());
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mExtraTouchEventListener != null) {
                    this.mExtraTouchEventListener.onTouchEvent(motionEvent);
                }
                if (this.mPraiseAnimBlock) {
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mExtraTouchEventListener != null) {
                    this.mExtraTouchEventListener.onTouchEvent(motionEvent);
                }
                this.mStatusProtecting = false;
                this.mPraiseAnimBlock = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (com.baidu.searchbox.ui.CoolPraiseView.DEBUG == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        android.util.Log.d(com.baidu.searchbox.ui.CoolPraiseView.TAG, r1.getClass().getSimpleName() + ", resetTouchEvent");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        r5.setAction(3);
        ((android.view.View) r1).dispatchTouchEvent(r5);
        r5.setAction(0);
        ((android.view.View) r1).dispatchTouchEvent(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof ListView) && !(parent instanceof RecyclerView)) {
            parent = parent.getParent();
        }
    }

    public CoolPraiseView disablePraiseAnimation(boolean z) {
        if (!this.mStatusProtecting) {
            this.mDisableAnimation = z;
        }
        return this;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initPraiseLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPraiseLocation() {
        this.mPraiseIcon.getLocationOnScreen(this.mLocation);
        if (DEBUG) {
            Log.d(TAG, "initPraiseLocation isFullScreen" + isFullScreen());
        }
        if (!isFullScreen()) {
            int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
            int[] iArr = this.mLocation;
            iArr[1] = iArr[1] - statusBarHeight;
        }
    }

    private boolean isFullScreen() {
        int i = ((Activity) this.mContext).getWindow().getAttributes().flags & 1024;
        if (DEBUG) {
            Log.d(TAG, "isFullScreen flag:" + i);
        }
        return i != 0;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        initView(context, attributeSet);
        setup();
    }

    private void setup() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CoolPraiseView.this.isPraiseEnabled()) {
                    if (CoolPraiseView.this.mIsPraised) {
                        if (PraiseEnvironment.isCancelPraiseEnabled(CoolPraiseView.this.mPraiseSource)) {
                            CoolPraiseView.access$610(CoolPraiseView.this);
                            CoolPraiseView.this.setPraiseUnProtected(false);
                            CoolPraiseView.this.setPraiseCount(CoolPraiseView.this.mPraiseCount);
                            PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(CoolPraiseView.this.mPraiseSource, CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId), 0L);
                        }
                    } else {
                        CoolPraiseView.access$608(CoolPraiseView.this);
                        CoolPraiseView.this.setPraiseUnProtected(true);
                        CoolPraiseView.this.setPraiseCount(CoolPraiseView.this.mPraiseCount);
                    }
                    if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(CoolPraiseView.this.mIsPraised, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            if (CoolPraiseView.this.mIsPraised) {
                                Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            } else {
                                Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:true->false, praiseCnt:" + (CoolPraiseView.this.mPraiseCount + 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            }
                        }
                    }
                } else if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                    CoolPraiseView.this.mOnClickPraiseListener.onClick(CoolPraiseView.this.mIsPraised, CoolPraiseView.this.mPraiseCount);
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:" + CoolPraiseView.this.mIsPraised + "praiseCnt:" + CoolPraiseView.this.mPraiseCount);
                    }
                }
            }
        });
    }

    private void initPraiseManager() {
        if (DEBUG) {
            Log.d(TAG, "initPraiseManager");
        }
        this.mComboPraiseManager = new ComboPraiseManager((Activity) this.mContext, "");
        this.mComboPraiseManager.setPraiseManagerCallback(new IPraiseManagerCallback() { // from class: com.baidu.searchbox.ui.CoolPraiseView.4
            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorLeft() {
                CoolPraiseView.this.initPraiseLocation();
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorLeft:" + CoolPraiseView.this.mLocation[0]);
                }
                return CoolPraiseView.this.mLocation[0];
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorTop() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorTop:" + CoolPraiseView.this.mLocation[1]);
                }
                return CoolPraiseView.this.mLocation[1];
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorWidth() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorWidth:" + CoolPraiseView.this.mPraiseIcon.getWidth());
                }
                return CoolPraiseView.this.mPraiseIcon.getWidth();
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorHeight() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorHeight:" + CoolPraiseView.this.mPraiseIcon.getHeight());
                }
                return CoolPraiseView.this.mPraiseIcon.getHeight();
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public String getPraiseSource() {
                return CoolPraiseView.this.mPraiseSource;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public String getPraiseId() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getPraiseId:" + CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId);
                }
                return CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId;
            }
        });
        this.mComboPraiseManager.setPraiseAnimListener(new IExPraiseAnimListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.5
            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
            public void onPraiseAnimStart() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimStart--" + CoolPraiseView.this.mPraiseId);
                }
                if (!CoolPraiseView.this.mIsPraised) {
                    CoolPraiseView.access$608(CoolPraiseView.this);
                    CoolPraiseView.this.setPraiseCount(CoolPraiseView.this.mPraiseCount);
                    CoolPraiseView.this.setPraiseUnProtected(true);
                    if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(true, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            Log.d(CoolPraiseView.TAG, "onClick called from onPraiseAnimStart, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                        }
                    }
                    CoolPraiseView.this.mIsPraised = !CoolPraiseView.this.mIsPraised;
                    CoolPraiseView.this.mReversePraiseStatus = true;
                }
                if (CoolPraiseView.this.mStatusProtecting) {
                    LinkageControlUtil.notifyDisableLinkageScroll();
                }
                EventBusWrapper.post(new PraiseAnimState(1, CoolPraiseView.this));
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IExPraiseAnimListener
            public void onPraiseAnimPrevented(int i) {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimPrevented--" + CoolPraiseView.this.mPraiseId + ", reason:" + i);
                }
                if (i == 1) {
                    CoolPraiseView.this.mIsAnimCancelling = true;
                }
                CoolPraiseView.this.mPraiseAnimPrevented = true;
                LinkageControlUtil.notifyDisableLinkageScroll();
                EventBusWrapper.post(new PraiseAnimState(3, CoolPraiseView.this));
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
            public void onPraiseAnimEnd() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimEnd--" + CoolPraiseView.this.mPraiseId);
                }
                if (CoolPraiseView.this.mReversePraiseStatus) {
                    CoolPraiseView.this.mIsPraised = !CoolPraiseView.this.mIsPraised;
                    CoolPraiseView.this.mReversePraiseStatus = false;
                }
                if (CoolPraiseView.this.mIsAnimCancelling) {
                    CoolPraiseView.this.mIsAnimCancelling = false;
                    if (CoolPraiseView.this.mIsPraised) {
                        CoolPraiseView.access$610(CoolPraiseView.this);
                        CoolPraiseView.this.setPraiseCount(CoolPraiseView.this.mPraiseCount);
                        CoolPraiseView.this.setPraiseUnProtected(false);
                        if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                            CoolPraiseView.this.mOnClickPraiseListener.onClick(false, CoolPraiseView.this.mPraiseCount);
                            if (CoolPraiseView.DEBUG) {
                                Log.d(CoolPraiseView.TAG, "onClick called from onPraiseAnimEnd, praiseStatus:true->false, praiseCnt:" + (CoolPraiseView.this.mPraiseCount + 1) + "->" + CoolPraiseView.this.mPraiseCount);
                            }
                        }
                    }
                }
                CoolPraiseView.this.mStatusProtecting = false;
                CoolPraiseView.this.mPraiseAnimBlock = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
                EventBusWrapper.post(new PraiseAnimState(2, CoolPraiseView.this));
            }
        });
    }

    public CoolPraiseView setPraiseIconPressedAlpha(float f) {
        this.mPraiseIcon.setPressedAlpha(f);
        return this;
    }

    public CoolPraiseView setPrefixForPraiseId(String str) {
        this.mPraiseIdPrefix = str;
        return this;
    }

    /* loaded from: classes9.dex */
    public static class PraiseAnimState {
        public static final int ANIM_STATE_PREVENTED = 3;
        public static final int ANIM_STATE_STARTED = 1;
        public static final int ANIM_STATE_STOPPED = 2;
        private int animState;
        private CoolPraiseView praiseView;

        public PraiseAnimState(int i) {
            this.animState = -1;
            this.animState = i;
        }

        public PraiseAnimState(int i, CoolPraiseView coolPraiseView) {
            this.animState = -1;
            this.animState = i;
            this.praiseView = coolPraiseView;
        }

        public int getAnimState() {
            return this.animState;
        }

        public CoolPraiseView getPraiseView() {
            return this.praiseView;
        }
    }

    public void setExtraTouchEventListener(ExtraTouchEventListener extraTouchEventListener) {
        this.mExtraTouchEventListener = extraTouchEventListener;
    }

    public void setPraiseLayoutLeftPadding(int i) {
        if (this.mWrapperLayout != null) {
            this.mWrapperLayout.setPadding(i, this.mWrapperLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        }
    }

    public void setPraiseIconSize(int i, int i2) {
        if (this.mPraiseIcon != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPraiseIcon.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mPraiseIcon.setLayoutParams(layoutParams);
        }
    }

    public void setPraiseCntsVisibility(boolean z) {
        if (this.mPraiseCntsView != null) {
            this.mPraiseCntsView.setVisibility(z ? 0 : 8);
        }
    }

    public void setPraiseCntsTextSize(int i, float f) {
        if (this.mPraiseCntsView != null) {
            this.mPraiseCntsView.setTextSize(i, f);
        }
    }

    public void setPraiseCntsLeftMargin(int i) {
        if (this.mPraiseCntsView != null) {
            ((LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams()).leftMargin = i;
        }
    }

    public void setPraiseCntsTopMargin(int i) {
        if (this.mPraiseCntsView != null) {
            ((LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams()).topMargin = i;
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.mPraiseIcon != null) {
            this.mPraiseIcon.setScaleType(scaleType);
        }
    }

    public boolean guidePlay(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (isGuideAnimPlaying()) {
            return false;
        }
        if (!z || ControlShowManager.getInstance().canShow()) {
            int[] iArr = new int[2];
            this.mPraiseIcon.getLocationOnScreen(iArr);
            int width = (this.mPraiseIcon.getWidth() / 2) + iArr[0];
            int height = (this.mPraiseIcon.getHeight() / 2) + iArr[1];
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

    public void cancelGuidePlay() {
        if (isGuideAnimPlaying()) {
            post(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (CoolPraiseView.this.mGuideAnimator != null) {
                        CoolPraiseView.this.mGuideAnimator.cancel();
                    }
                    if (CoolPraiseView.this.mGuidePlayRootView != null && CoolPraiseView.this.mCopyPressedImageView != null) {
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCopyPressedImageView);
                        CoolPraiseView.this.mPraiseIcon.setVisibility(0);
                    }
                    if (CoolPraiseView.this.mGuidePlayRootView != null && CoolPraiseView.this.mCoolPraiseGuideLottieView != null) {
                        CoolPraiseView.this.mCoolPraiseGuideLottieView.cancel();
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCoolPraiseGuideLottieView);
                    }
                }
            });
        }
    }

    private boolean isGuideAnimPlaying() {
        return this.mIsGuideHandAnimPlaying || this.mIsGuideBubbleAnimPlaying;
    }

    private void playHand(int i, int i2) {
        this.mIsGuideHandAnimPlaying = true;
        this.mCopyPressedImageView = new PressedAlphaImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPraiseIcon.getWidth(), this.mPraiseIcon.getHeight());
        layoutParams.leftMargin = i - (this.mPraiseIcon.getWidth() / 2);
        layoutParams.topMargin = i2 - (this.mPraiseIcon.getHeight() / 2);
        this.mCopyPressedImageView.setImageBitmap(this.mPraiseIcon.getDrawingCache());
        this.mGuidePlayRootView.addView(this.mCopyPressedImageView, layoutParams);
        this.mGuidePlayRepeatCount = 0;
        this.mGuideAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), com.baidu.android.common.widget.praise.R.animator.bd_praise_guide_animator);
        this.mGuideAnimator.setTarget(this.mCopyPressedImageView);
        this.mCopyPressedImageView.setPivotX(0.0f);
        this.mCopyPressedImageView.setPivotY(this.mPraiseIcon.getHeight());
        this.mCopyPressedImageView.invalidate();
        this.mGuideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.CoolPraiseView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CoolPraiseView.this.mGuidePlayRepeatCount >= 1) {
                    CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCopyPressedImageView);
                            CoolPraiseView.this.mIsGuideHandAnimPlaying = false;
                        }
                    }, 200L);
                    CoolPraiseView.this.mPraiseIcon.setVisibility(0);
                    return;
                }
                CoolPraiseView.this.mGuideAnimator.setStartDelay(560L);
                CoolPraiseView.this.mGuideAnimator.start();
                CoolPraiseView.access$2308(CoolPraiseView.this);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CoolPraiseView.this.mPraiseIcon.setVisibility(4);
            }
        });
        this.mGuideAnimator.start();
    }

    private void playBubble(int i, int i2) {
        this.mIsGuideBubbleAnimPlaying = true;
        this.mCoolPraiseGuideLottieView = new CoolPraiseGuideLottieView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mCoolPraiseGuideLottieView.getRealWidth(), this.mCoolPraiseGuideLottieView.getRealHeigth());
        layoutParams.leftMargin = i - (this.mCoolPraiseGuideLottieView.getRealWidth() / 2);
        layoutParams.topMargin = i2 - this.mCoolPraiseGuideLottieView.getRealHeigth();
        this.mGuidePlayRootView.addView(this.mCoolPraiseGuideLottieView, layoutParams);
        this.mCoolPraiseGuideLottieView.setAnimatorListenerAdapter(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.CoolPraiseView.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CoolPraiseView.this.mGuidePlayRootView.removeView(CoolPraiseView.this.mCoolPraiseGuideLottieView);
                        CoolPraiseView.this.mIsGuideBubbleAnimPlaying = false;
                    }
                }, 200L);
            }
        });
        this.mCoolPraiseGuideLottieView.play();
    }

    private void initPraiseDefaultIcon() {
        this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.android.common.widget.praise.R.drawable.comment_item_unlike_icon_selector);
        this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.android.common.widget.praise.R.drawable.comment_item_like_icon_selector);
    }
}
