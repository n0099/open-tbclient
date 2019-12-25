package com.baidu.searchbox.picture.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.picture.component.view.PictureOriginButton;
import com.baidu.searchbox.picture.utils.Utils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class EnterAndExitAnimationHelper {
    private static final boolean DEBUG = true;
    private static final AccelerateDecelerateInterpolator DEFAULT_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    public static final int DURATION_IN = 340;
    public static final int DURATION_OUT = 240;
    public static final String KEY_PICTURE_ANIMA_STATE = "key_picture_anima_state";
    private static final String TAG = "EnterAndOutAnimationHel";
    private int mAvailableScreenHeight;
    private Context mContext;
    protected ExitAnimationListener mExitAnimationListener;
    protected boolean mHasRunEnterAnim;
    protected int mOriginHeight;
    protected int mOriginWidth;
    private int mScreenHeight;
    private int mScreenWidth;
    private ArrayList<Integer> mAnimationPos = new ArrayList<>();
    private boolean mHasExitAnim = false;
    private boolean mHasAnim = false;
    public boolean mReadyAnimation = false;
    public int mAnimPositionLeft = 0;
    public int mAnimPositionTop = 0;
    public int mAnimPositionRight = 0;
    public int mAnimPositionBottom = 0;
    private float[] mScale = new float[2];
    private float[] mTransition = new float[2];

    /* loaded from: classes11.dex */
    public interface ExitAnimationListener {
        void endExitAnimation();

        void startExitAnimation();
    }

    public EnterAndExitAnimationHelper(Context context, ArrayList<Integer> arrayList) {
        this.mContext = context;
        init(arrayList);
    }

    public void init(ArrayList<Integer> arrayList) {
        this.mAnimationPos = arrayList;
        if (hasRunAnim()) {
            this.mAnimationPos = new ArrayList<>();
            if (this.mHasAnim) {
                clearAnimationPos();
            }
        }
        if (checkAnimationData()) {
            this.mHasAnim = true;
            this.mHasExitAnim = true;
        }
        if (DeviceUtil.ScreenInfo.isScreenLand()) {
            clearAnimationPos();
        }
    }

    public void getImageSize() {
        this.mOriginWidth = this.mAnimPositionRight - this.mAnimPositionLeft;
        this.mOriginHeight = this.mAnimPositionBottom - this.mAnimPositionTop;
    }

    public boolean parseAnimationPos() {
        this.mReadyAnimation = false;
        if (!checkAnimationData()) {
            return this.mReadyAnimation;
        }
        if (this.mAnimationPos.size() == 4) {
            this.mAnimPositionTop = this.mAnimationPos.get(0).intValue();
            this.mAnimPositionLeft = this.mAnimationPos.get(1).intValue();
            this.mAnimPositionRight = this.mAnimationPos.get(2).intValue();
            this.mAnimPositionBottom = this.mAnimationPos.get(3).intValue();
            this.mReadyAnimation = true;
        }
        return this.mReadyAnimation;
    }

    public void resetAnimation() {
        this.mAnimPositionLeft = 0;
        this.mAnimPositionTop = 0;
        this.mAnimPositionRight = 0;
        this.mAnimPositionBottom = 0;
        this.mHasExitAnim = false;
        this.mReadyAnimation = false;
    }

    public void doReadyStartAnimLocationJob(HugePhotoDraweeView hugePhotoDraweeView) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mReadyAnimation && DeviceUtil.ScreenInfo.isScreenPortrait() && hugePhotoDraweeView != null) {
            if (this.mOriginHeight >= this.mAvailableScreenHeight) {
                layoutParams = new FrameLayout.LayoutParams(this.mOriginWidth, this.mOriginHeight);
                layoutParams.setMargins(this.mAnimPositionLeft, this.mAnimPositionTop, this.mAnimPositionRight, this.mAnimPositionBottom);
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.mOriginWidth, -1);
                layoutParams.setMargins(this.mAnimPositionLeft, 0, this.mAnimPositionRight, 0);
                if (!this.mHasRunEnterAnim) {
                    hugePhotoDraweeView.setTranslationY(-this.mTransition[1]);
                }
            }
            hugePhotoDraweeView.setLayoutParams(layoutParams);
            return;
        }
        resetAnimation();
    }

    public void doAnimationCountJob(String str) {
        boolean z;
        double d;
        if (this.mReadyAnimation && !TextUtils.isEmpty(str)) {
            getScreenSize();
            try {
                z = new File(str).exists();
            } catch (Exception e) {
                z = false;
            }
            if (!z && !Utils.inFrescoCache(str)) {
                this.mReadyAnimation = false;
                return;
            }
            this.mAvailableScreenHeight = this.mScreenHeight - DeviceUtil.ScreenInfo.getStatusBarHeight();
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String str2 = "";
            if (this.mOriginHeight <= this.mAvailableScreenHeight) {
                d = this.mScreenWidth / this.mOriginWidth;
            } else {
                d = this.mAvailableScreenHeight / this.mOriginHeight;
            }
            try {
                str2 = decimalFormat.format(d);
                this.mScale[0] = Float.valueOf(str2).floatValue();
                this.mScale[1] = Float.valueOf(str2).floatValue();
            } catch (Exception e2) {
                resetAnimation();
            }
            if (!this.mReadyAnimation || TextUtils.isEmpty(str2) || d == 0.0d || this.mScreenHeight < this.mScreenWidth) {
                resetAnimation();
                return;
            }
            this.mTransition[0] = (this.mScreenWidth / 2) - (this.mAnimPositionLeft + ((this.mAnimPositionRight - this.mAnimPositionLeft) / 2));
            this.mTransition[1] = (this.mAvailableScreenHeight / 2) - (this.mAnimPositionTop + ((this.mAnimPositionBottom - this.mAnimPositionTop) / 2));
        }
    }

    private void getScreenSize() {
        this.mScreenWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext.getApplicationContext());
        this.mScreenHeight = DeviceUtil.ScreenInfo.getDisplayHeight(this.mContext.getApplicationContext());
    }

    public void runEnterAnim(final HugePhotoDraweeView hugePhotoDraweeView, final View view) {
        if (hugePhotoDraweeView != null && view != null) {
            Log.d(TAG, "runEnterAnim: " + this.mScale[0] + "  " + this.mScale[1] + this.mTransition[0]);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(340L);
            duration.setInterpolator(DEFAULT_INTERPOLATOR);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.picture.component.EnterAndExitAnimationHelper.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    view.getBackground().setAlpha((int) (255.0f * floatValue));
                    hugePhotoDraweeView.setAlpha(1.0f);
                    hugePhotoDraweeView.setScaleX(((EnterAndExitAnimationHelper.this.mScale[0] - 1.0f) * floatValue) + 1.0f);
                    hugePhotoDraweeView.setScaleY(((EnterAndExitAnimationHelper.this.mScale[1] - 1.0f) * floatValue) + 1.0f);
                    hugePhotoDraweeView.setTranslationX(EnterAndExitAnimationHelper.this.mTransition[0] * floatValue);
                    if (EnterAndExitAnimationHelper.this.mOriginHeight >= EnterAndExitAnimationHelper.this.mAvailableScreenHeight) {
                        hugePhotoDraweeView.setTranslationY(floatValue * EnterAndExitAnimationHelper.this.mTransition[1]);
                    } else {
                        hugePhotoDraweeView.setTranslationY((1.0f - floatValue) * (-EnterAndExitAnimationHelper.this.mTransition[1]));
                    }
                    view.invalidate();
                }
            });
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.picture.component.EnterAndExitAnimationHelper.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DefaultSharedPrefsWrapper.getInstance().putBoolean(EnterAndExitAnimationHelper.KEY_PICTURE_ANIMA_STATE, true);
                    EnterAndExitAnimationHelper.this.mHasRunEnterAnim = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DefaultSharedPrefsWrapper.getInstance().putBoolean(EnterAndExitAnimationHelper.KEY_PICTURE_ANIMA_STATE, true);
                }
            });
            duration.start();
        }
    }

    public void doFinishJob(final HugePhotoDraweeView hugePhotoDraweeView, final View view, PictureOriginButton pictureOriginButton) {
        if (hugePhotoDraweeView != null && view != null) {
            if (pictureOriginButton != null) {
                pictureOriginButton.quit();
            }
            if (this.mExitAnimationListener != null) {
                this.mExitAnimationListener.startExitAnimation();
            }
            ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(240L);
            hugePhotoDraweeView.setAlpha(1.0f);
            duration.setInterpolator(DEFAULT_INTERPOLATOR);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.picture.component.EnterAndExitAnimationHelper.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    view.getBackground().setAlpha((int) (255.0f * floatValue));
                    hugePhotoDraweeView.setAlpha(1.0f);
                    hugePhotoDraweeView.setScaleX(((EnterAndExitAnimationHelper.this.mScale[0] - 1.0f) * floatValue) + 1.0f);
                    hugePhotoDraweeView.setScaleY(((EnterAndExitAnimationHelper.this.mScale[1] - 1.0f) * floatValue) + 1.0f);
                    hugePhotoDraweeView.setTranslationX(EnterAndExitAnimationHelper.this.mTransition[0] * floatValue);
                    if (EnterAndExitAnimationHelper.this.mOriginHeight >= EnterAndExitAnimationHelper.this.mAvailableScreenHeight) {
                        hugePhotoDraweeView.setTranslationY(floatValue * EnterAndExitAnimationHelper.this.mTransition[1]);
                    } else {
                        hugePhotoDraweeView.setTranslationY((1.0f - floatValue) * (-EnterAndExitAnimationHelper.this.mTransition[1]));
                    }
                    view.invalidate();
                }
            });
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.picture.component.EnterAndExitAnimationHelper.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (EnterAndExitAnimationHelper.this.mExitAnimationListener != null) {
                        EnterAndExitAnimationHelper.this.mExitAnimationListener.endExitAnimation();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }
            });
            duration.start();
        }
    }

    protected boolean checkAnimationData() {
        return this.mAnimationPos != null && this.mAnimationPos.size() == 4;
    }

    protected void clearAnimationPos() {
        if (this.mAnimationPos != null) {
            this.mAnimationPos.clear();
        }
        this.mHasExitAnim = false;
    }

    public boolean hasRunAnim() {
        return DefaultSharedPrefsWrapper.getInstance().getBoolean(KEY_PICTURE_ANIMA_STATE, false);
    }

    public void setEnterAndOutAnimation(ExitAnimationListener exitAnimationListener) {
        this.mExitAnimationListener = exitAnimationListener;
    }

    public boolean isHasAnim() {
        return this.mHasAnim;
    }

    public boolean ismHasExitAnim() {
        return this.mHasExitAnim;
    }

    public void setIsReadyAnimation(boolean z) {
        this.mReadyAnimation = z;
    }

    public boolean getIsReadyAnimation() {
        return this.mReadyAnimation;
    }
}
