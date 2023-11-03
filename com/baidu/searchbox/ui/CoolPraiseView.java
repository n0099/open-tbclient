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
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
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
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class CoolPraiseView extends LinearLayout {
    public static final long BILLION = 100000000;
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final int LONG_PRESS_TIME_MS = 550;
    public static final long MILLION = 10000;
    public static final String NET_ERROR_TIP = "网络不给力，请稍后重试";
    public static final int REMOVE_VIEW_DELAY_TIME_MS = 200;
    public static final int START_DELAY_TIME_MS = 560;
    public static final String TAG = "CoolPraiseView";
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

    /* loaded from: classes4.dex */
    public interface ExtraTouchEventListener {
        void onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public interface LongPressListener {
        void onLongPressCancel();

        void onLongPressStart();
    }

    /* loaded from: classes4.dex */
    public interface OnClickPraiseListener {
        void onClick(boolean z, int i);
    }

    /* loaded from: classes4.dex */
    public static class PraiseAnimState {
        public static final int ANIM_STATE_PREVENTED = 3;
        public static final int ANIM_STATE_STARTED = 1;
        public static final int ANIM_STATE_STOPPED = 2;
        public int animState;
        public CoolPraiseView praiseView;

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

    private boolean handleLongPressEnd() {
        if (!this.mIsLongPressing) {
            if (DEBUG) {
                Log.d(TAG, "#handleLongPressEnd, remove longPress runnable");
            }
            this.mMainHandler.removeCallbacks(this.mLongClick);
        } else {
            this.mIsLongPressing = false;
            this.mPraiseIcon.setPressed(false);
            if (DEBUG) {
                Log.d(TAG, "#handleLongPressEnd, handle longPressCancel ");
            }
            LongPressListener longPressListener = this.mLongPressListener;
            if (longPressListener != null) {
                longPressListener.onLongPressCancel();
                return true;
            }
        }
        return false;
    }

    private void initPraiseDefaultIcon() {
        this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080513);
        this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080512);
    }

    private void initPraiseManager() {
        if (DEBUG) {
            Log.d(TAG, "initPraiseManager");
        }
        ComboPraiseManager comboPraiseManager = new ComboPraiseManager((Activity) this.mContext, "");
        this.mComboPraiseManager = comboPraiseManager;
        comboPraiseManager.setPraiseManagerCallback(new IPraiseManagerCallback() { // from class: com.baidu.searchbox.ui.CoolPraiseView.5
            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorHeight() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorHeight:" + CoolPraiseView.this.mPraiseIcon.getHeight());
                }
                return CoolPraiseView.this.mPraiseIcon.getHeight();
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
            public String getPraiseSource() {
                return CoolPraiseView.this.mPraiseSource;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public int getAnchorLeft() {
                CoolPraiseView.this.initPraiseLocation();
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getAnchorLeft:" + CoolPraiseView.this.mLocation[0]);
                }
                return CoolPraiseView.this.mLocation[0];
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
            public String getPraiseId() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "getPraiseId:" + CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId);
                }
                return CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId;
            }
        });
        this.mComboPraiseManager.setPraiseAnimListener(new IExPraiseAnimListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.6
            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
            public void onPraiseAnimEnd() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimEnd--" + CoolPraiseView.this.mPraiseId);
                }
                CoolPraiseView.this.mIsPlayingAnim = false;
                if (CoolPraiseView.this.mReversePraiseStatus) {
                    CoolPraiseView coolPraiseView = CoolPraiseView.this;
                    coolPraiseView.mIsPraised = !coolPraiseView.mIsPraised;
                    CoolPraiseView.this.mReversePraiseStatus = false;
                }
                if (CoolPraiseView.this.mIsAnimCancelling) {
                    CoolPraiseView.this.mIsAnimCancelling = false;
                    if (CoolPraiseView.this.mIsPraised) {
                        CoolPraiseView.access$510(CoolPraiseView.this);
                        CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                        coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
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
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(2, CoolPraiseView.this));
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
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(3, CoolPraiseView.this));
            }

            @Override // com.baidu.searchbox.ui.animview.praise.IPraiseAnimListener
            public void onPraiseAnimStart() {
                if (CoolPraiseView.DEBUG) {
                    Log.d(CoolPraiseView.TAG, "onPraiseAnimStart--" + CoolPraiseView.this.mPraiseId);
                }
                CoolPraiseView.this.mIsPlayingAnim = true;
                if (!CoolPraiseView.this.mIsPraised) {
                    CoolPraiseView.access$508(CoolPraiseView.this);
                    CoolPraiseView coolPraiseView = CoolPraiseView.this;
                    coolPraiseView.setPraiseCount(coolPraiseView.mPraiseCount);
                    CoolPraiseView.this.setPraiseUnProtected(true);
                    if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(true, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            Log.d(CoolPraiseView.TAG, "onClick called from onPraiseAnimStart, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                        }
                    }
                    CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                    coolPraiseView2.mIsPraised = !coolPraiseView2.mIsPraised;
                    CoolPraiseView.this.mReversePraiseStatus = true;
                }
                if (CoolPraiseView.this.mStatusProtecting) {
                    LinkageControlUtil.notifyDisableLinkageScroll();
                }
                BdEventBus.Companion.getDefault().post(new PraiseAnimState(1, CoolPraiseView.this));
            }
        });
    }

    private boolean isFullScreen() {
        int i = ((Activity) this.mContext).getWindow().getAttributes().flags & 1024;
        if (DEBUG) {
            Log.d(TAG, "isFullScreen flag:" + i);
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    private boolean isGuideAnimPlaying() {
        if (!this.mIsGuideHandAnimPlaying && !this.mIsGuideBubbleAnimPlaying) {
            return false;
        }
        return true;
    }

    private void setup() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CoolPraiseView.this.mIsPlayingAnim) {
                    return;
                }
                if (CoolPraiseView.this.isPraiseEnabled()) {
                    if (!CoolPraiseView.this.mIsPraised) {
                        CoolPraiseView.access$508(CoolPraiseView.this);
                        CoolPraiseView.this.setPraiseUnProtected(true);
                        CoolPraiseView coolPraiseView = CoolPraiseView.this;
                        coolPraiseView.setPraiseCount(coolPraiseView.mPraiseCount);
                    } else if (PraiseEnvironment.isCancelPraiseEnabled(CoolPraiseView.this.mPraiseSource)) {
                        CoolPraiseView.access$510(CoolPraiseView.this);
                        CoolPraiseView.this.setPraiseUnProtected(false);
                        CoolPraiseView coolPraiseView2 = CoolPraiseView.this;
                        coolPraiseView2.setPraiseCount(coolPraiseView2.mPraiseCount);
                        String str = CoolPraiseView.this.mPraiseSource;
                        PraiseInfoManager.getInstance().updatePraiseCounts(PraiseInfoManager.makePraiseInfoKey(str, CoolPraiseView.this.mPraiseIdPrefix + CoolPraiseView.this.mPraiseId), 0L);
                    }
                    if (CoolPraiseView.this.mOnClickPraiseListener != null) {
                        CoolPraiseView.this.mOnClickPraiseListener.onClick(CoolPraiseView.this.mIsPraised, CoolPraiseView.this.mPraiseCount);
                        if (CoolPraiseView.DEBUG) {
                            if (CoolPraiseView.this.mIsPraised) {
                                Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:false->true, praiseCnt:" + (CoolPraiseView.this.mPraiseCount - 1) + "->" + CoolPraiseView.this.mPraiseCount);
                                return;
                            }
                            Log.d(CoolPraiseView.TAG, "onClick called from setup, praiseStatus:true->false, praiseCnt:" + (CoolPraiseView.this.mPraiseCount + 1) + "->" + CoolPraiseView.this.mPraiseCount);
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

    public void cancelGuidePlay() {
        if (!isGuideAnimPlaying()) {
            return;
        }
        post(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.7
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

    public void clearLongPressCallback() {
        if (this.mLongPressListener != null) {
            this.mLongPressListener = null;
        }
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.clearLongPressCallback();
        }
    }

    public void disableStatusProtecting() {
        this.mStatusProtecting = false;
    }

    public View getIconView() {
        return this.mPraiseIcon;
    }

    public boolean getIsPraisedState() {
        return this.mIsPraised;
    }

    @Nullable
    public Drawable getPraisedResDrawable() {
        Drawable drawable = this.mPraisedResDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.mPraisedRes <= 0) {
            return null;
        }
        try {
            return AppRuntime.getAppContext().getResources().getDrawable(this.mPraisedRes);
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public Drawable getUnPraisedResDrawable() {
        Drawable drawable = this.mUnPraisedResDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (this.mUnPraisedRes <= 0) {
            return null;
        }
        try {
            return AppRuntime.getAppContext().getResources().getDrawable(this.mUnPraisedRes);
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public boolean isPraiseEnabled() {
        return this.mPraiseEnabled;
    }

    public void performAnimPrevented() {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.performAnimPrevented();
        }
    }

    public CoolPraiseView(Context context) {
        super(context);
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080513;
        this.mPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080512;
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
        this.mLongClick = new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            @Override // java.lang.Runnable
            public void run() {
                CoolPraiseView.this.mIsLongPressing = true;
                if (CoolPraiseView.this.mLongPressListener != null) {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#mLongClick, longPress start with no praise anim");
                    }
                    CoolPraiseView.this.mLongPressListener.onLongPressStart();
                }
            }
        };
        init(context, null);
    }

    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080513;
        this.mPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080512;
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
        this.mLongClick = new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            @Override // java.lang.Runnable
            public void run() {
                CoolPraiseView.this.mIsLongPressing = true;
                if (CoolPraiseView.this.mLongPressListener != null) {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#mLongClick, longPress start with no praise anim");
                    }
                    CoolPraiseView.this.mLongPressListener.onLongPressStart();
                }
            }
        };
        init(context, attributeSet);
    }

    public CoolPraiseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPraiseEnabled = true;
        this.mIsPraised = false;
        this.mPraiseCount = 0;
        this.mUnPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080513;
        this.mPraisedRes = com.baidu.tieba.R.drawable.obfuscated_res_0x7f080512;
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
        this.mLongClick = new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.3
            @Override // java.lang.Runnable
            public void run() {
                CoolPraiseView.this.mIsLongPressing = true;
                if (CoolPraiseView.this.mLongPressListener != null) {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#mLongClick, longPress start with no praise anim");
                    }
                    CoolPraiseView.this.mLongPressListener.onLongPressStart();
                }
            }
        };
        init(context, attributeSet);
    }

    public static /* synthetic */ int access$2308(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mGuidePlayRepeatCount;
        coolPraiseView.mGuidePlayRepeatCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$508(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$510(CoolPraiseView coolPraiseView) {
        int i = coolPraiseView.mPraiseCount;
        coolPraiseView.mPraiseCount = i - 1;
        return i;
    }

    public static String getLikeCountWithTenThousand(int i) {
        return convertLikeCount(i);
    }

    public CoolPraiseView disablePraiseAnimation(boolean z) {
        if (this.mStatusProtecting) {
            return this;
        }
        this.mDisableAnimation = z;
        return this;
    }

    public void setExtraTouchEventListener(ExtraTouchEventListener extraTouchEventListener) {
        this.mExtraTouchEventListener = extraTouchEventListener;
    }

    public CoolPraiseView setLikeLayoutBgDrawable(Drawable drawable) {
        this.mWrapperLayout.setBackground(drawable);
        return this;
    }

    public CoolPraiseView setLikeLayoutLp(LinearLayout.LayoutParams layoutParams) {
        this.mWrapperLayout.setLayoutParams(layoutParams);
        return this;
    }

    public void setLongPressListener(LongPressListener longPressListener) {
        if (this.mLongPressListener == null) {
            this.mLongPressListener = longPressListener;
            this.mComboPraiseManager.setComboPraiseLongPressListener(new ComboPraiseManager.ComboPraiseLongPressListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.10
                @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.ComboPraiseLongPressListener
                public void onComboPraiseLongPressCancel() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#ComboPraiseLongPressListener: cancel, mIsPlayingAnim: " + CoolPraiseView.this.mIsPlayingAnim);
                    }
                    if (CoolPraiseView.this.mLongPressListener != null && !CoolPraiseView.this.mIsPlayingAnim) {
                        CoolPraiseView.this.mLongPressListener.onLongPressCancel();
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.ComboPraiseManager.ComboPraiseLongPressListener
                public void onComboPraiseLongPressStart() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "#ComboPraiseLongPressListener: start, mIsPlayingAnim: " + CoolPraiseView.this.mIsPlayingAnim);
                    }
                    if (CoolPraiseView.this.mLongPressListener != null && !CoolPraiseView.this.mIsPlayingAnim) {
                        CoolPraiseView.this.mLongPressListener.onLongPressStart();
                    }
                }
            });
        }
    }

    public void setOnClickPraiseListener(OnClickPraiseListener onClickPraiseListener) {
        this.mOnClickPraiseListener = onClickPraiseListener;
    }

    public void setPraise(boolean z) {
        if (this.mStatusProtecting || this.mIsPlayingAnim) {
            return;
        }
        setPraiseUnProtected(z);
    }

    public void setPraiseCntsDefaultTextVisibility(boolean z) {
        this.mPraiseCntsDefaultTextShow = z;
    }

    public void setPraiseCntsLeftMargin(int i) {
        setPraiseCntsLeftMargin(i, true);
    }

    public void setPraiseCntsTopMargin(int i) {
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = i;
        }
    }

    public void setPraiseCntsVisibility(boolean z) {
        int i;
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public CoolPraiseView setPraiseCount(String str) {
        try {
            setPraiseCount(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Deprecated
    public CoolPraiseView setPraiseIcon(int i) {
        this.mPraiseIcon.setImageDrawable(getResources().getDrawable(i));
        return this;
    }

    public CoolPraiseView setPraiseIconPressedAlpha(float f) {
        this.mPraiseIcon.setPressedAlpha(f);
        return this;
    }

    public CoolPraiseView setPraiseId(String str) {
        this.mPraiseId = str;
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setPraiseId(str);
        }
        return this;
    }

    public void setPraiseLayoutLeftPadding(int i) {
        LinearLayout linearLayout = this.mWrapperLayout;
        if (linearLayout != null) {
            linearLayout.setPadding(i, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        }
    }

    public CoolPraiseView setPraiseSource(String str) {
        this.mPraiseSource = str;
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setPraiseSource(str);
            setPraiseCount(this.mPraiseCount);
        }
        return this;
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

    public void setPraiseable(boolean z) {
        this.mPraiseEnabled = z;
    }

    public CoolPraiseView setPrefixForPraiseId(String str) {
        this.mPraiseIdPrefix = str;
        return this;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PressedAlphaImageView pressedAlphaImageView = this.mPraiseIcon;
        if (pressedAlphaImageView != null) {
            pressedAlphaImageView.setScaleType(scaleType);
        }
    }

    public CoolPraiseView setUBC(String str) {
        return setUBC(str, "");
    }

    @Deprecated
    public static String displayLikeCount(int i, String str) {
        return convertLikeCount(i);
    }

    public static ColorStateList getPressedColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i2, i});
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        initView(context, attributeSet);
        setup();
    }

    private void setPraiseCntsLeftMargin(int i, boolean z) {
        if (z) {
            this.mPraiseCntsMarginLeft = i;
        }
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin = i;
        }
    }

    public void setPraiseCntsTextSize(int i, float f) {
        TextView textView = this.mPraiseCntsView;
        if (textView != null) {
            textView.setTextSize(i, f);
        }
    }

    public void setPraiseIconSize(int i, int i2) {
        PressedAlphaImageView pressedAlphaImageView = this.mPraiseIcon;
        if (pressedAlphaImageView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pressedAlphaImageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.mPraiseIcon.setLayoutParams(layoutParams);
    }

    public CoolPraiseView setPraiseStateIconRes(int i, int i2) {
        this.mUnPraisedResDrawable = null;
        this.mPraisedResDrawable = null;
        this.mUnPraisedRes = i;
        this.mPraisedRes = i2;
        setPraise(this.mIsPraised);
        return this;
    }

    public CoolPraiseView setPraiseStateTextColor(int i, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = null;
        try {
            colorStateList = ColorStateList.valueOf(i);
            try {
                colorStateList2 = ColorStateList.valueOf(i2);
            } catch (Resources.NotFoundException unused) {
            }
        } catch (Resources.NotFoundException unused2) {
            colorStateList = null;
        }
        return setPraiseStateTextRes(colorStateList, colorStateList2);
    }

    public CoolPraiseView setPraiseStateTextRes(int i, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = null;
        try {
            colorStateList = AppRuntime.getAppContext().getResources().getColorStateList(i);
            try {
                colorStateList2 = AppRuntime.getAppContext().getResources().getColorStateList(i2);
            } catch (Resources.NotFoundException unused) {
            }
        } catch (Resources.NotFoundException unused2) {
            colorStateList = null;
        }
        return setPraiseStateTextRes(colorStateList, colorStateList2);
    }

    public CoolPraiseView setUBC(String str, String str2) {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setUBCParams(new ComboPraiseUBC(str, str2));
        }
        return this;
    }

    public static String convertLikeCount(int i) {
        String string;
        double d;
        double d2;
        if (i <= 0) {
            return "";
        }
        long j = i;
        if (j < 10000) {
            return i + "";
        }
        if (j < BILLION) {
            string = AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1166);
            d = i;
            d2 = 10000.0d;
        } else {
            string = AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1161);
            d = i;
            d2 = 1.0E8d;
        }
        double d3 = d / d2;
        DecimalFormat decimalFormat = new DecimalFormat("####.#");
        return decimalFormat.format(d3) + string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPraiseUnProtected(boolean z) {
        this.mIsPraised = z;
        if (this.mUnPraisedTextColorStateList == null) {
            this.mUnPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0604fd);
        }
        if (this.mPraisedTextColorStateList == null) {
            this.mPraisedTextColorStateList = AppRuntime.getAppContext().getResources().getColorStateList(com.baidu.tieba.R.color.obfuscated_res_0x7f0604fc);
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

    private boolean doLoginIfNecessary() {
        if (!PraiseEnvironment.isPraiseLoginSupported(this.mPraiseSource)) {
            if (DEBUG) {
                Log.d(TAG, "isPraiseLoginSupported return false, so doLoginIfNecessary=true");
            }
            return true;
        } else if (this.mPraiseAnimBlock) {
            if (DEBUG) {
                Log.d(TAG, "mPraiseAnimBlock is true, so doLoginIfNecessary=false");
            }
            return false;
        } else if (!NetWorkUtils.isNetworkConnected()) {
            this.mPraiseAnimBlock = true;
            UniversalToast.makeText(this.mContext, "网络不给力，请稍后重试").showToast();
            if (DEBUG) {
                Log.d(TAG, "isNetworkConnected return false, so doLoginIfNecessary=false");
            }
            return false;
        } else if (ComboPraiseRuntime.getContext().isLogin()) {
            if (DEBUG) {
                Log.d(TAG, "isLogin return true, so doLoginIfNecessary=true");
            }
            return true;
        } else {
            ComboPraiseRuntime.getContext().doLogin(this.mContext, new ILoginStatusListener() { // from class: com.baidu.searchbox.ui.CoolPraiseView.2
                @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                public void loginFail() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginFail");
                    }
                }

                @Override // com.baidu.searchbox.ui.animview.praise.ioc.ILoginStatusListener
                public void loginSuccess() {
                    if (CoolPraiseView.DEBUG) {
                        Log.d(CoolPraiseView.TAG, "loginSuccess, performClick");
                    }
                    CoolPraiseView.this.performClick();
                }
            });
            this.mPraiseAnimBlock = true;
            if (DEBUG) {
                Log.d(TAG, "doLogin, so doLoginIfNecessary=false");
            }
            return false;
        }
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

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        float f;
        float f2;
        float f3;
        int i;
        boolean z;
        boolean z2;
        int i2;
        LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0237, (ViewGroup) this, true);
        this.mPraiseIcon = (PressedAlphaImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092931);
        this.mPraiseCntsView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092932);
        this.mWrapperLayout = (LinearLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f092930);
        if (attributeSet != null) {
            typedArray = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.widget.praise.R.styleable.coolPraiseView);
        } else {
            typedArray = null;
        }
        float f4 = 0.0f;
        if (typedArray != null) {
            f = typedArray.getDimension(0, 0.0f);
        } else {
            f = 0.0f;
        }
        if (typedArray != null) {
            f2 = typedArray.getDimension(7, 0.0f);
        } else {
            f2 = 0.0f;
        }
        if (typedArray != null) {
            f3 = typedArray.getDimension(1, 0.0f);
        } else {
            f3 = 0.0f;
        }
        if (typedArray != null) {
            i = (int) typedArray.getDimension(2, 0.0f);
        } else {
            i = 0;
        }
        if (typedArray != null) {
            f4 = typedArray.getDimension(6, 0.0f);
        }
        if (typedArray != null) {
            z = typedArray.getBoolean(3, true);
        } else {
            z = true;
        }
        if (typedArray != null) {
            z2 = typedArray.getBoolean(4, false);
        } else {
            z2 = false;
        }
        if (typedArray != null) {
            typedArray.recycle();
        }
        if (z2) {
            this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.mPraiseCntsView.setTypeface(Typeface.defaultFromStyle(0));
        }
        initPraiseDefaultIcon();
        LinearLayout linearLayout = this.mWrapperLayout;
        linearLayout.setPadding(i, linearLayout.getPaddingTop(), this.mWrapperLayout.getPaddingRight(), this.mWrapperLayout.getPaddingBottom());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPraiseIcon.getLayoutParams();
        layoutParams.width = (int) f2;
        layoutParams.height = (int) f;
        this.mPraiseIcon.setLayoutParams(layoutParams);
        this.mPraiseIcon.setDrawingCacheEnabled(true);
        TextView textView = this.mPraiseCntsView;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPraiseCntsView.getLayoutParams();
        int i3 = (int) f3;
        layoutParams2.leftMargin = i3;
        this.mPraiseCntsView.setLayoutParams(layoutParams2);
        this.mPraiseCntsView.setTextSize(0, f4);
        this.mPraiseCntsMarginLeft = i3;
        setPraiseUnProtected(false);
        initPraiseManager();
    }

    private void playBubble(int i, int i2) {
        this.mIsGuideBubbleAnimPlaying = true;
        this.mCoolPraiseGuideLottieView = new CoolPraiseGuideLottieView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mCoolPraiseGuideLottieView.getRealWidth(), this.mCoolPraiseGuideLottieView.getRealHeigth());
        layoutParams.leftMargin = i - (this.mCoolPraiseGuideLottieView.getRealWidth() / 2);
        layoutParams.topMargin = i2 - this.mCoolPraiseGuideLottieView.getRealHeigth();
        this.mGuidePlayRootView.addView(this.mCoolPraiseGuideLottieView, layoutParams);
        this.mCoolPraiseGuideLottieView.setAnimatorListenerAdapter(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.CoolPraiseView.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.9.1
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

    private void playHand(int i, int i2) {
        try {
            this.mGuideAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), com.baidu.tieba.R.animator.obfuscated_res_0x7f020000);
            this.mIsGuideHandAnimPlaying = true;
            this.mCopyPressedImageView = new PressedAlphaImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPraiseIcon.getWidth(), this.mPraiseIcon.getHeight());
            layoutParams.leftMargin = i - (this.mPraiseIcon.getWidth() / 2);
            layoutParams.topMargin = i2 - (this.mPraiseIcon.getHeight() / 2);
            this.mCopyPressedImageView.setImageBitmap(this.mPraiseIcon.getDrawingCache());
            this.mGuidePlayRootView.addView(this.mCopyPressedImageView, layoutParams);
            this.mGuidePlayRepeatCount = 0;
            this.mGuideAnimator.setTarget(this.mCopyPressedImageView);
            this.mCopyPressedImageView.setPivotX(0.0f);
            this.mCopyPressedImageView.setPivotY(this.mPraiseIcon.getHeight());
            this.mCopyPressedImageView.invalidate();
            this.mGuideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.ui.CoolPraiseView.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CoolPraiseView.this.mPraiseIcon.setVisibility(4);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (CoolPraiseView.this.mGuidePlayRepeatCount >= 1) {
                        CoolPraiseView.this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.8.1
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
            });
            this.mGuideAnimator.start();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (com.baidu.searchbox.ui.CoolPraiseView.DEBUG == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        android.util.Log.d(com.baidu.searchbox.ui.CoolPraiseView.TAG, r0.getClass().getSimpleName() + ", resetTouchEvent");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        r4.setAction(3);
        r0 = (android.view.View) r0;
        r0.dispatchTouchEvent(r4);
        r4.setAction(0);
        r0.dispatchTouchEvent(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
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

    public CoolPraiseView setPraiseCount(int i) {
        this.mPraiseCount = i;
        if (i <= 0) {
            this.mPraiseCount = 0;
            if (this.mPraiseCntsDefaultTextShow) {
                this.mPraiseCntsView.setText(getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1167));
                setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
            } else {
                this.mPraiseCntsView.setText("");
                setPraiseCntsLeftMargin(0, false);
            }
            if (PraiseEnvironment.isFirstPraiseAnimSupported(this.mPraiseSource)) {
                if (DEBUG) {
                    Log.d(TAG, "isFirstPraiseAnimSupported return true");
                }
                this.mPraiseCntsView.setText(getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1162));
            }
        } else {
            setPraiseCntsLeftMargin(this.mPraiseCntsMarginLeft, false);
            this.mPraiseCntsView.setText(getLikeCountWithTenThousand(i));
        }
        return this;
    }

    public boolean guidePlay(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        if (isGuideAnimPlaying()) {
            return false;
        }
        if (z && !ControlShowManager.getInstance().canShow()) {
            return false;
        }
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

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initPraiseLocation();
    }

    public synchronized void setPraiseIconResByName(String str, boolean z, int i, int i2) {
        setPraiseIconResByName(str, z, i, i2, null);
    }

    public CoolPraiseView setPraiseStateTextRes(int i, int i2, int i3, int i4) {
        return setPraiseStateTextRes(getPressedColorStateList(i, i2), getPressedColorStateList(i3, i4));
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
            ExtraTouchEventListener extraTouchEventListener = this.mExtraTouchEventListener;
            if (extraTouchEventListener != null) {
                extraTouchEventListener.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.mStatusProtecting = false;
                    LinkageControlUtil.notifyEnableLinkageScroll();
                }
            } else {
                this.mStatusProtecting = true;
                requestDisallowInterceptTouchEvent(true);
                this.mPraiseAnimPrevented = false;
            }
            if (!this.mPraiseAnimPrevented) {
                return true;
            }
            if (DEBUG) {
                Log.d(TAG, "Praise Animation Prevented");
            }
            requestDisallowInterceptTouchEvent(false);
            this.mPraiseAnimBlock = true;
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "Praise Animation disabled or prevented or praised");
            if (Build.VERSION.SDK_INT >= 19) {
                Log.d(TAG, "pos2:" + MotionEvent.actionToString(motionEvent.getAction()));
            } else {
                Log.d(TAG, "pos2:" + motionEvent.getAction());
            }
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            if (action2 == 1 || action2 == 3) {
                ExtraTouchEventListener extraTouchEventListener2 = this.mExtraTouchEventListener;
                if (extraTouchEventListener2 != null) {
                    extraTouchEventListener2.onTouchEvent(motionEvent);
                }
                this.mStatusProtecting = false;
                this.mPraiseAnimBlock = false;
                LinkageControlUtil.notifyEnableLinkageScroll();
                if (handleLongPressEnd()) {
                    return true;
                }
            }
        } else {
            ExtraTouchEventListener extraTouchEventListener3 = this.mExtraTouchEventListener;
            if (extraTouchEventListener3 != null) {
                extraTouchEventListener3.onTouchEvent(motionEvent);
            }
            if (DEBUG) {
                Log.d(TAG, "#onTouchEvent, post longClick runnable");
            }
            this.mMainHandler.postDelayed(this.mLongClick, 550L);
            if (this.mPraiseAnimBlock) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public synchronized void setPraiseIconResByName(final String str, final boolean z, final int i, final int i2, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.CoolPraiseView.1
            @Override // java.lang.Runnable
            public void run() {
                CoolPraiseView.this.setPraiseIconResByNameReal(str, z, i, i2, runnable);
            }
        }, 50L);
    }

    public synchronized void setPraiseIconResByNameReal(String str, boolean z, int i, int i2, Runnable runnable) {
        this.mDisableAnimation = z;
        String str2 = str + ".png";
        boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
        this.mPraiseIcon.refreshDrawableState();
        Drawable praiseIconByType = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, false);
        this.mUnPraisedResDrawable = praiseIconByType;
        if (praiseIconByType != null) {
            if (praiseIconByType.getConstantState() != null) {
                this.mUnPraisedResDrawable = this.mUnPraisedResDrawable.getConstantState().newDrawable().mutate();
            }
        } else if (i > 0) {
            this.mUnPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(i);
        }
        Drawable praiseIconByType2 = CoolPraiseIconResource.getPraiseIconByType(str2, nightModeSwitcherState, true);
        this.mPraisedResDrawable = praiseIconByType2;
        if (praiseIconByType2 != null) {
            if (praiseIconByType2.getConstantState() != null) {
                this.mPraisedResDrawable = this.mPraisedResDrawable.getConstantState().newDrawable().mutate();
            }
        } else if (i2 > 0) {
            this.mPraisedResDrawable = AppRuntime.getAppContext().getResources().getDrawable(i2);
        }
        setPraise(this.mIsPraised);
        requestLayout();
        invalidate();
        if (runnable != null) {
            runnable.run();
        }
    }

    public CoolPraiseView setPraiseStateTextRes(ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.mUnPraisedTextColorStateList = colorStateList;
        this.mPraisedTextColorStateList = colorStateList2;
        setPraise(this.mIsPraised);
        return this;
    }

    public CoolPraiseView setUBC(String str, String str2, String str3) {
        ComboPraiseManager comboPraiseManager = this.mComboPraiseManager;
        if (comboPraiseManager != null) {
            comboPraiseManager.setUBCParams(new ComboPraiseUBC(str, str2, str3));
        }
        return this;
    }
}
