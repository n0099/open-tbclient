package com.baidu.searchbox.ui.bubble;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.CustomLinkMovementMethod;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class BubbleManager implements View.OnClickListener {
    private static final float ANIMATION_OFFSET = 11.0f;
    private static final int AUTO_DISMISS_INTERVAL = 7000;
    private static final float BUBBLE_BETWEEN_PADDING = 2.0f;
    private static final float BUBBLE_SCREEN_PADDING = 15.0f;
    private static final boolean DEBUG = false;
    private static final String TAG = "BubbleManager";
    private View mAnchorLayer;
    private View mAnchorView;
    private View mArrowDown;
    private View mArrowLeft;
    private View mArrowRight;
    private View mArrowUp;
    private boolean mAutoDismiss;
    private int mAutoDismissInterval;
    private float mBetweenPadding;
    @ColorInt
    private int mBgColor;
    private View mBgView;
    private View mBubbleArrow;
    private BubblePosition mBubbleForceShowPosition;
    private BubbleHandler mBubbleHandler;
    private TextView mBubbleText;
    private View mBubbleView;
    private boolean mEnableAnchorClk;
    private boolean mEnableAnimation;
    private boolean mEnableBgClk;
    private boolean mEnableClkDismiss;
    private boolean mIsAutoDetectShowPosition;
    private boolean mIsShowing;
    private ObjectAnimator mObjectAnimator;
    private float mOffsetOfArrow;
    private OnAnchorClickListener mOnAnchorClickListener;
    private OnBubbleEventListener mOnBubbleEventListener;
    private ViewGroup mRootView;
    private CharSequence mShowText;
    private float mSize;
    @ColorInt
    private int mTextColor;
    private int mUnit;

    /* loaded from: classes13.dex */
    public interface OnAnchorClickListener {
        void onAnchorClick();
    }

    /* loaded from: classes13.dex */
    public interface OnBubbleEventListener {
        void onBubbleClick();

        void onBubbleDismiss();

        void onBubbleShow();
    }

    private BubbleManager() {
        this.mAutoDismiss = true;
        this.mUnit = -1;
        this.mSize = -1.0f;
        this.mAutoDismissInterval = AUTO_DISMISS_INTERVAL;
        this.mBetweenPadding = 2.0f;
        this.mBgColor = -872415232;
        this.mTextColor = -1;
        this.mEnableClkDismiss = true;
        this.mIsAutoDetectShowPosition = true;
        this.mBubbleForceShowPosition = BubblePosition.INVALID;
    }

    public void dismissBubble() {
        if (this.mIsShowing && this.mRootView != null && this.mBubbleView != null) {
            if (this.mObjectAnimator != null && this.mObjectAnimator.isRunning()) {
                this.mObjectAnimator.cancel();
            }
            if (this.mEnableBgClk && this.mBgView != null) {
                this.mRootView.removeView(this.mBgView);
            }
            if (this.mEnableAnchorClk && this.mAnchorLayer != null) {
                this.mRootView.removeView(this.mAnchorLayer);
            }
            this.mRootView.removeView(this.mBubbleView);
            this.mIsShowing = false;
            if (this.mBubbleHandler != null) {
                this.mBubbleHandler.removeMessages(0);
            }
            if (this.mOnBubbleEventListener != null) {
                this.mOnBubbleEventListener.onBubbleDismiss();
            }
            resetAll();
        }
    }

    private void resetAll() {
        this.mRootView = null;
        this.mBubbleView = null;
        this.mBubbleArrow = null;
        this.mBubbleText = null;
        this.mAnchorView = null;
        this.mOnBubbleEventListener = null;
        this.mBubbleHandler = null;
        this.mArrowUp = null;
        this.mArrowDown = null;
        this.mBgView = null;
        this.mAnchorLayer = null;
        this.mObjectAnimator = null;
        this.mShowText = null;
    }

    public boolean isDismissed() {
        return !this.mIsShowing;
    }

    public void showBubble() {
        if (isValidate() && isDismissed()) {
            show();
        }
    }

    private boolean isValidate() {
        return (TextUtils.isEmpty(this.mShowText) || this.mAnchorView == null || this.mRootView == null) ? false : true;
    }

    private void show() {
        initViewIfNeed();
        if (this.mEnableBgClk && this.mBgView != null) {
            checkSafe(this.mBgView);
            this.mRootView.addView(this.mBgView);
        }
        if (this.mEnableAnchorClk && this.mAnchorLayer != null) {
            checkSafe(this.mAnchorLayer);
            this.mRootView.addView(this.mAnchorLayer);
        }
        checkSafe(this.mBubbleView);
        this.mRootView.addView(this.mBubbleView);
        this.mBubbleView.setVisibility(4);
        if (!this.mEnableClkDismiss) {
            initLinkBubble();
        }
        this.mBubbleText.setText(this.mShowText);
        this.mBubbleText.setTextColor(this.mTextColor);
        if (this.mUnit >= 0 && this.mSize > 0.0f) {
            this.mBubbleText.setTextSize(this.mUnit, this.mSize);
        }
        this.mAnchorView.post(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.BubbleManager.1
            @Override // java.lang.Runnable
            public void run() {
                BubblePosition detectShowPosition = BubbleManager.this.detectShowPosition();
                if (detectShowPosition == BubblePosition.INVALID) {
                    BubbleManager.this.mRootView.removeView(BubbleManager.this.mBubbleView);
                    if (BubbleManager.this.mEnableBgClk && BubbleManager.this.mBgView != null) {
                        BubbleManager.this.mRootView.removeView(BubbleManager.this.mBgView);
                    }
                    if (BubbleManager.this.mEnableAnchorClk && BubbleManager.this.mAnchorLayer != null) {
                        BubbleManager.this.mRootView.removeView(BubbleManager.this.mAnchorLayer);
                        return;
                    }
                    return;
                }
                BubbleManager.this.showArrowView(detectShowPosition);
                BubbleManager.this.showBubbleView(detectShowPosition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBubbleView(final BubblePosition bubblePosition) {
        this.mAnchorView.post(new Runnable() { // from class: com.baidu.searchbox.ui.bubble.BubbleManager.2
            @Override // java.lang.Runnable
            public void run() {
                int[] showPosition = BubbleManager.this.getShowPosition(bubblePosition);
                BubbleManager.this.mBubbleView.setX(showPosition[0]);
                BubbleManager.this.mBubbleView.setY(showPosition[1]);
                BubbleManager.this.mBubbleView.setVisibility(0);
                if (BubbleManager.this.mEnableAnimation) {
                    int dp2px = DeviceUtil.ScreenInfo.dp2px(null, BubbleManager.this.mBetweenPadding + BubbleManager.ANIMATION_OFFSET);
                    if (bubblePosition == BubblePosition.UP || bubblePosition == BubblePosition.DOWN) {
                        BubbleManager.this.animation(BubbleManager.this.mBubbleView, showPosition[0], showPosition[0], bubblePosition == BubblePosition.UP ? dp2px + showPosition[1] : showPosition[1] - dp2px, showPosition[1]);
                    } else if (bubblePosition == BubblePosition.RIGHT || bubblePosition == BubblePosition.LEFT) {
                        BubbleManager.this.animation(BubbleManager.this.mBubbleView, bubblePosition == BubblePosition.LEFT ? dp2px + showPosition[0] : showPosition[0] - dp2px, showPosition[0], showPosition[1], showPosition[1]);
                    }
                }
                if (BubbleManager.this.mEnableAnchorClk && BubbleManager.this.mAnchorLayer != null) {
                    ViewGroup.LayoutParams layoutParams = BubbleManager.this.mAnchorLayer.getLayoutParams();
                    layoutParams.width = BubbleManager.this.mAnchorView.getMeasuredWidth();
                    layoutParams.height = BubbleManager.this.mAnchorView.getMeasuredHeight();
                    BubbleManager.this.mAnchorLayer.setLayoutParams(layoutParams);
                    int[] iArr = new int[2];
                    BubbleManager.this.mAnchorView.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    BubbleManager.this.mRootView.getLocationOnScreen(iArr2);
                    BubbleManager.this.mAnchorLayer.setX(iArr[0] - iArr2[0]);
                    BubbleManager.this.mAnchorLayer.setY(iArr[1] - iArr2[1]);
                }
                BubbleManager.this.mIsShowing = true;
                if (BubbleManager.this.mAutoDismiss) {
                    BubbleManager.this.mBubbleHandler.sendEmptyMessageDelayed(0, BubbleManager.this.mAutoDismissInterval);
                }
                if (BubbleManager.this.mOnBubbleEventListener != null) {
                    BubbleManager.this.mOnBubbleEventListener.onBubbleShow();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showArrowView(BubblePosition bubblePosition) {
        dismissAllArrowView();
        switch (bubblePosition) {
            case DOWN:
                this.mArrowUp.setVisibility(0);
                ((ArrowView) this.mArrowUp).setDirection(2);
                this.mBubbleArrow = this.mArrowUp;
                return;
            case UP:
                this.mArrowDown.setVisibility(0);
                ((ArrowView) this.mArrowDown).setDirection(4);
                this.mBubbleArrow = this.mArrowDown;
                return;
            case RIGHT:
                this.mArrowLeft.setVisibility(0);
                ((ArrowView) this.mArrowLeft).setDirection(1);
                this.mBubbleArrow = this.mArrowLeft;
                return;
            case LEFT:
                this.mArrowRight.setVisibility(0);
                ((ArrowView) this.mArrowRight).setDirection(3);
                this.mBubbleArrow = this.mArrowRight;
                return;
            default:
                return;
        }
    }

    private void dismissAllArrowView() {
        this.mArrowUp.setVisibility(8);
        this.mArrowDown.setVisibility(8);
        this.mArrowLeft.setVisibility(8);
        this.mArrowRight.setVisibility(8);
    }

    private void initLinkBubble() {
        final Resources resources = AppRuntime.getAppContext().getResources();
        this.mBubbleText.setLinkTextColor(resources.getColorStateList(R.color.home_tab_bubble_tips_text_color));
        this.mBubbleText.setHighlightColor(0);
        CustomLinkMovementMethod customLinkMovementMethod = new CustomLinkMovementMethod();
        customLinkMovementMethod.setLinkMovementListener(new CustomLinkMovementMethod.OnLinkMovementListener() { // from class: com.baidu.searchbox.ui.bubble.BubbleManager.3
            @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
            public void onLinkTouch(TextView textView, MotionEvent motionEvent) {
            }

            @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
            public void onNoLinkTouch(TextView textView, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BubbleManager.this.mBubbleText.setLinkTextColor(resources.getColor(R.color.bubble_link_text_color));
                } else {
                    BubbleManager.this.mBubbleText.setLinkTextColor(resources.getColorStateList(R.color.home_tab_bubble_tips_text_color));
                }
            }
        });
        this.mBubbleText.setMovementMethod(customLinkMovementMethod);
    }

    private void checkSafe(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animation(View view, float f, float f2, float f3, float f4) {
        if (this.mObjectAnimator != null && this.mObjectAnimator.isRunning()) {
            this.mObjectAnimator.cancel();
        }
        this.mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationX", f, f2), PropertyValuesHolder.ofFloat("translationY", f3, f4)).setDuration(300L);
        this.mObjectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getShowPosition(BubblePosition bubblePosition) {
        int[] iArr = new int[2];
        this.mAnchorView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.mRootView.getLocationOnScreen(iArr2);
        int[] iArr3 = new int[2];
        if (bubblePosition == BubblePosition.UP) {
            iArr3[0] = (iArr[0] - iArr2[0]) + (this.mAnchorView.getMeasuredWidth() / 2);
            iArr3[1] = (iArr[1] - iArr2[1]) - DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
        } else if (bubblePosition == BubblePosition.DOWN) {
            iArr3[0] = (iArr[0] - iArr2[0]) + (this.mAnchorView.getMeasuredWidth() / 2);
            iArr3[1] = (iArr[1] - iArr2[1]) + this.mAnchorView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
        } else if (bubblePosition == BubblePosition.LEFT) {
            iArr3[0] = (iArr[0] - iArr2[0]) - DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
            iArr3[1] = (iArr[1] - iArr2[1]) + (this.mAnchorView.getMeasuredHeight() / 2);
        } else if (bubblePosition == BubblePosition.RIGHT) {
            iArr3[0] = (iArr[0] - iArr2[0]) + this.mAnchorView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding);
            iArr3[1] = (iArr[1] - iArr2[1]) + (this.mAnchorView.getMeasuredHeight() / 2);
        }
        int[] adjustPosition = adjustPosition(iArr3, bubblePosition);
        if (bubblePosition == BubblePosition.UP || bubblePosition == BubblePosition.DOWN) {
            this.mBubbleArrow.setX(((iArr3[0] - adjustPosition[0]) - Math.max(this.mArrowDown.getMeasuredWidth() / 2, this.mArrowUp.getMeasuredWidth() / 2)) + this.mOffsetOfArrow);
        } else if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
            this.mBubbleArrow.setY(((iArr3[1] - adjustPosition[1]) - Math.max(this.mArrowLeft.getMeasuredHeight() / 2, this.mArrowRight.getMeasuredHeight() / 2)) + this.mOffsetOfArrow);
        }
        return adjustPosition;
    }

    private int[] adjustPosition(int[] iArr, BubblePosition bubblePosition) {
        if (bubblePosition != BubblePosition.INVALID) {
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = this.mBubbleView.getMeasuredWidth();
            int measuredHeight = this.mBubbleView.getMeasuredHeight();
            int measuredWidth2 = this.mRootView.getMeasuredWidth();
            int measuredHeight2 = this.mRootView.getMeasuredHeight();
            if (bubblePosition == BubblePosition.UP || bubblePosition == BubblePosition.DOWN) {
                if (measuredWidth / 2 >= i) {
                    iArr2[0] = DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), BUBBLE_SCREEN_PADDING);
                } else if (measuredWidth / 2 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), BUBBLE_SCREEN_PADDING);
                } else {
                    iArr2[0] = iArr[0] - (this.mBubbleView.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - this.mBubbleView.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            } else if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                if (measuredHeight / 2 >= i2) {
                    iArr2[1] = DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), BUBBLE_SCREEN_PADDING);
                } else if (measuredHeight / 2 >= measuredHeight2 - i2) {
                    iArr2[1] = (measuredHeight2 - measuredHeight) - DeviceUtil.ScreenInfo.dp2px(this.mRootView.getContext(), BUBBLE_SCREEN_PADDING);
                } else {
                    iArr2[1] = iArr[1] - (this.mBubbleView.getMeasuredHeight() / 2);
                }
                if (bubblePosition == BubblePosition.LEFT) {
                    iArr2[0] = iArr[0] - this.mBubbleView.getMeasuredWidth();
                } else {
                    iArr2[0] = iArr[0];
                }
            }
            return iArr2;
        }
        return iArr;
    }

    private void initViewIfNeed() {
        if (this.mBubbleView == null) {
            this.mBubbleView = LayoutInflater.from(this.mAnchorView.getContext()).inflate(R.layout.bubble_tip, this.mRootView, false);
            this.mBubbleText = (TextView) this.mBubbleView.findViewById(R.id.bubble_text);
            this.mArrowUp = this.mBubbleView.findViewById(R.id.bubble_arrow_up);
            this.mArrowDown = this.mBubbleView.findViewById(R.id.bubble_arrow_down);
            this.mArrowLeft = this.mBubbleView.findViewById(R.id.bubble_arrow_left);
            this.mArrowRight = this.mBubbleView.findViewById(R.id.bubble_arrow_right);
            this.mBubbleView.setOnClickListener(this);
            this.mTextColor = this.mRootView.getContext().getResources().getColor(R.color.white_text);
            this.mBgColor = this.mRootView.getContext().getResources().getColor(R.color.bubble_bg_color);
            this.mBubbleText.setTextColor(this.mTextColor);
            if (this.mBubbleText.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.mBubbleText.getBackground()).setColor(this.mBgColor);
            }
            if (this.mArrowUp instanceof ArrowView) {
                ((ArrowView) this.mArrowUp).setArrowViewColor(this.mBgColor);
            }
            if (this.mArrowDown instanceof ArrowView) {
                ((ArrowView) this.mArrowDown).setArrowViewColor(this.mBgColor);
            }
            if (this.mArrowLeft instanceof ArrowView) {
                ((ArrowView) this.mArrowLeft).setArrowViewColor(this.mBgColor);
            }
            if (this.mArrowRight instanceof ArrowView) {
                ((ArrowView) this.mArrowRight).setArrowViewColor(this.mBgColor);
            }
            this.mBubbleHandler = new BubbleHandler(this);
            this.mBgView = new View(this.mAnchorView.getContext());
            this.mBgView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mBgView.setOnClickListener(this);
            this.mAnchorLayer = new View(this.mAnchorView.getContext());
            this.mAnchorLayer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.BubbleManager.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BubbleManager.this.onClickCore(view);
                    if (BubbleManager.this.mOnAnchorClickListener != null) {
                        BubbleManager.this.mOnAnchorClickListener.onAnchorClick();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubblePosition detectShowPosition() {
        if (this.mIsAutoDetectShowPosition) {
            if (isDisplayableAtUp()) {
                return BubblePosition.UP;
            }
            if (isDisplayableAtDown()) {
                return BubblePosition.DOWN;
            }
            if (isDisplayableAtLeft()) {
                return BubblePosition.LEFT;
            }
            if (isDisplayableAtRight()) {
                return BubblePosition.RIGHT;
            }
            return BubblePosition.INVALID;
        } else if (isDisplayableAtPosition(this.mBubbleForceShowPosition)) {
            return this.mBubbleForceShowPosition;
        } else {
            return BubblePosition.INVALID;
        }
    }

    private boolean isDisplayableAtPosition(BubblePosition bubblePosition) {
        switch (bubblePosition) {
            case DOWN:
                return isDisplayableAtDown();
            case UP:
                return isDisplayableAtUp();
            case RIGHT:
                return isDisplayableAtRight();
            case LEFT:
                return isDisplayableAtLeft();
            default:
                return false;
        }
    }

    private boolean isDisplayableAtUp() {
        return this.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) <= getAnchorInRoot()[1] && isVerticalArrowShowAbleThreshold();
    }

    private boolean isDisplayableAtDown() {
        return this.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) <= (this.mRootView.getMeasuredHeight() - this.mAnchorView.getMeasuredHeight()) - getAnchorInRoot()[1] && isVerticalArrowShowAbleThreshold();
    }

    private boolean isDisplayableAtLeft() {
        return this.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) <= getAnchorInRoot()[0] && isHorizontalArrowShowAble();
    }

    private boolean isDisplayableAtRight() {
        return this.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(this.mAnchorView.getContext(), this.mBetweenPadding) <= (this.mRootView.getMeasuredWidth() - this.mAnchorView.getMeasuredWidth()) - getAnchorInRoot()[0] && isHorizontalArrowShowAble();
    }

    private int[] getAnchorInRoot() {
        int[] iArr = new int[2];
        this.mAnchorView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.mRootView.getLocationOnScreen(iArr2);
        return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
    }

    private int getAnchorCenterLeftMargin() {
        return getAnchorInRoot()[0] + (this.mAnchorView.getMeasuredWidth() / 2);
    }

    private int getAnchorCenterRightMargin() {
        return (this.mRootView.getMeasuredWidth() - getAnchorInRoot()[0]) - (this.mAnchorView.getMeasuredWidth() / 2);
    }

    private int getAnchorCenterUpMargin() {
        return getAnchorInRoot()[1] + (this.mAnchorView.getMeasuredHeight() / 2);
    }

    private int getAnchorCenterDownMargin() {
        return (this.mRootView.getMeasuredHeight() - getAnchorInRoot()[1]) - (this.mAnchorView.getMeasuredHeight() / 2);
    }

    private boolean isHorizontalArrowShowAble() {
        Context context = this.mAnchorView.getContext();
        int dimensionPixelSize = (context.getResources().getDimensionPixelSize(R.dimen.bubble_horizontal_arrow_view_height) / 2) + DeviceUtil.ScreenInfo.dp2px(context, BUBBLE_SCREEN_PADDING) + context.getResources().getDimensionPixelSize(R.dimen.bubble_radius);
        return dimensionPixelSize <= getAnchorCenterUpMargin() && dimensionPixelSize <= getAnchorCenterDownMargin();
    }

    private boolean isVerticalArrowShowAbleThreshold() {
        Context context = this.mAnchorView.getContext();
        int dimensionPixelSize = (context.getResources().getDimensionPixelSize(R.dimen.bubble_vertical_arrow_view_width) / 2) + DeviceUtil.ScreenInfo.dp2px(context, BUBBLE_SCREEN_PADDING) + (context.getResources().getDimensionPixelSize(R.dimen.bubble_radius) / 2);
        return dimensionPixelSize <= getAnchorCenterLeftMargin() && dimensionPixelSize <= getAnchorCenterRightMargin();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onClickCore(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickCore(View view) {
        if (this.mOnBubbleEventListener != null) {
            this.mOnBubbleEventListener.onBubbleClick();
        }
        if (this.mEnableClkDismiss) {
            dismissBubble();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(CharSequence charSequence) {
        this.mShowText = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnchor(View view) {
        this.mAnchorView = view;
        if (this.mAnchorView != null) {
            this.mRootView = (ViewGroup) this.mAnchorView.getRootView().findViewById(16908290);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontSizew(int i, float f) {
        this.mUnit = i;
        this.mSize = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnchorAndRootView(View view, ViewGroup viewGroup) {
        this.mAnchorView = view;
        this.mRootView = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextColor(@ColorInt int i) {
        this.mTextColor = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackground(@ColorInt int i) {
        this.mBgColor = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoDismiss(boolean z) {
        this.mAutoDismiss = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoDismissInterval(int i) {
        if (i <= 0) {
            this.mAutoDismissInterval = AUTO_DISMISS_INTERVAL;
        } else {
            this.mAutoDismissInterval = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaddingBetweenAnchor(float f) {
        this.mBetweenPadding = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
        this.mOnBubbleEventListener = onBubbleEventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnAnchorEventListener(OnAnchorClickListener onAnchorClickListener) {
        this.mOnAnchorClickListener = onAnchorClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableBgClk(boolean z) {
        this.mEnableBgClk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableAnchorClk(boolean z) {
        this.mEnableAnchorClk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableAnimation(boolean z) {
        this.mEnableAnimation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffsetOfArrow(float f) {
        this.mOffsetOfArrow = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableClkDismiss(boolean z) {
        this.mEnableClkDismiss = z;
    }

    public View getBubbleView() {
        return this.mBubbleView;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    /* loaded from: classes13.dex */
    public static class Builder {
        private BubbleManager mBubbleManager;

        private Builder() {
            this.mBubbleManager = new BubbleManager();
        }

        public BubbleManager build() {
            return this.mBubbleManager;
        }

        public Builder setText(CharSequence charSequence) {
            this.mBubbleManager.setText(charSequence);
            return this;
        }

        public Builder setTextColor(@ColorInt int i) {
            this.mBubbleManager.setTextColor(i);
            return this;
        }

        public Builder setAnchor(View view) {
            this.mBubbleManager.setAnchor(view);
            return this;
        }

        public Builder setAnchorAndRootView(View view, ViewGroup viewGroup) {
            this.mBubbleManager.setAnchorAndRootView(view, viewGroup);
            return this;
        }

        public Builder setFontSize(int i, float f) {
            this.mBubbleManager.setFontSizew(i, f);
            return this;
        }

        public Builder setBackground(@ColorInt int i) {
            this.mBubbleManager.setBackground(i);
            return this;
        }

        public Builder setAutoDismiss(boolean z) {
            this.mBubbleManager.setAutoDismiss(z);
            return this;
        }

        public Builder setAutoDismissInterval(int i) {
            this.mBubbleManager.setAutoDismissInterval(i);
            return this;
        }

        public Builder setPaddingBetweenAnchor(float f) {
            this.mBubbleManager.setPaddingBetweenAnchor(f);
            return this;
        }

        public Builder setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
            this.mBubbleManager.setOnBubbleEventListener(onBubbleEventListener);
            return this;
        }

        public Builder setOnAnchorClickListener(OnAnchorClickListener onAnchorClickListener) {
            this.mBubbleManager.setOnAnchorEventListener(onAnchorClickListener);
            return this;
        }

        public Builder enableBgClk(boolean z) {
            this.mBubbleManager.enableBgClk(z);
            return this;
        }

        public Builder enableAnchorClk(boolean z) {
            this.mBubbleManager.enableAnchorClk(z);
            return this;
        }

        public Builder enableAnimation(boolean z) {
            this.mBubbleManager.enableAnimation(z);
            return this;
        }

        public Builder setOffsetOfArrow(float f) {
            this.mBubbleManager.setOffsetOfArrow(f);
            return this;
        }

        public Builder enableClkDismiss(boolean z) {
            this.mBubbleManager.enableClkDismiss(z);
            return this;
        }

        public Builder isAutoDetectShowPosition(boolean z) {
            this.mBubbleManager.mIsAutoDetectShowPosition = z;
            return this;
        }

        public Builder setForceShowPosition(BubblePosition bubblePosition) {
            this.mBubbleManager.mIsAutoDetectShowPosition = false;
            this.mBubbleManager.mBubbleForceShowPosition = bubblePosition;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class BubbleHandler extends Handler {
        static final int MSG_DISMISS = 0;
        private final WeakReference<BubbleManager> mBubbleManager;

        BubbleHandler(BubbleManager bubbleManager) {
            this.mBubbleManager = new WeakReference<>(bubbleManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BubbleManager bubbleManager;
            if (message.what == 0 && (bubbleManager = this.mBubbleManager.get()) != null) {
                bubbleManager.dismissBubble();
            }
        }
    }
}
