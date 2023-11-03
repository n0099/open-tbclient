package com.baidu.searchbox.ui.bubble.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.CustomLinkByEllipsize;
import com.baidu.searchbox.ui.CustomLinkMovementMethod;
import com.baidu.searchbox.ui.bubble.ArrowView;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.shadow.MaskViewGroup;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BubbleBaseView {
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleViews";
    public View mAnchorLayer;
    public View mAnchorView;
    public ArrowView mArrowDown;
    public ArrowView mArrowLeft;
    public ArrowView mArrowRight;
    public ArrowView mArrowUp;
    public View mBgView;
    public ArrowView mBubbleArrow;
    public ViewGroup mBubbleContent;
    public TextView mBubbleText;
    public View mBubbleView;
    public ViewGroup mRootView;
    public MaskViewGroup mShadow;
    public CustomLinkByEllipsize mTvEllipse;
    @ColorInt
    public int mBgColorDay = -1000;
    @ColorInt
    public int mBgColorNight = -1000;
    public int mShadowColorDay = -1000;
    public boolean mIsShadowDeviate = true;

    public int getBubbleViewResId() {
        return R.layout.obfuscated_res_0x7f0d0194;
    }

    public void updateViewUI() {
    }

    /* renamed from: com.baidu.searchbox.ui.bubble.views.BubbleBaseView$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition;

        static {
            int[] iArr = new int[BubblePosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition = iArr;
            try {
                iArr[BubblePosition.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void dismissAllArrowView() {
        this.mArrowUp.setVisibility(8);
        this.mArrowDown.setVisibility(8);
        this.mArrowLeft.setVisibility(8);
        this.mArrowRight.setVisibility(8);
    }

    public String getAnchorViewName() {
        View view2 = this.mAnchorView;
        if (view2 != null) {
            return view2.getClass().getSimpleName();
        }
        return "NULL";
    }

    public int getBgColor() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            int i = this.mBgColorNight;
            if (i != -1000) {
                return i;
            }
        } else {
            int i2 = this.mBgColorDay;
            if (i2 != -1000) {
                return i2;
            }
        }
        return AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060387);
    }

    public int getBgColorDay() {
        return this.mBgColorDay;
    }

    public int getBgColorNight() {
        return this.mBgColorNight;
    }

    public boolean isValidate() {
        if (this.mAnchorView != null && this.mRootView != null) {
            return true;
        }
        return false;
    }

    public boolean isViewsValidate() {
        if (this.mAnchorView != null && this.mRootView != null && this.mBubbleView != null) {
            return true;
        }
        return false;
    }

    public void removeAnchorView() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && this.mBubbleView != null && this.mBgView != null) {
            viewGroup.removeView(this.mAnchorLayer);
        }
    }

    public void removeBGView() {
        View view2;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && this.mBubbleView != null && (view2 = this.mBgView) != null) {
            viewGroup.removeView(view2);
        }
    }

    public void removemBubbleView() {
        View view2;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && (view2 = this.mBubbleView) != null && this.mBgView != null) {
            viewGroup.removeView(view2);
        }
    }

    public void resetAll() {
        TextView textView;
        if (this.mTvEllipse != null && (textView = this.mBubbleText) != null) {
            textView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mTvEllipse);
            this.mTvEllipse = null;
        }
        this.mRootView = null;
        this.mBubbleView = null;
        this.mBubbleContent = null;
        this.mBubbleArrow = null;
        this.mBubbleText = null;
        this.mAnchorView = null;
        this.mArrowUp = null;
        this.mArrowDown = null;
        this.mBgView = null;
        this.mAnchorLayer = null;
        this.mShadow = null;
    }

    public void resetAnchorParams() {
        ViewGroup.LayoutParams layoutParams;
        View view2 = this.mAnchorLayer;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.mAnchorLayer.setLayoutParams(layoutParams);
        }
    }

    public void safeAddAnchorView() {
        if (this.mAnchorLayer != null) {
            BubbleHistory.getInstance().trackBubbleOpHistory("——>checksafe anchor layer begin");
            checkSafe(this.mAnchorLayer);
            BubbleHistory.getInstance().trackBubbleOpHistory("——>checksafe anchor layer end");
            this.mRootView.addView(this.mAnchorLayer);
        }
    }

    public void safeAddBGView() {
        if (this.mBgView != null) {
            BubbleHistory.getInstance().trackBubbleOpHistory("——>check bg view begin");
            checkSafe(this.mBgView);
            BubbleHistory.getInstance().trackBubbleOpHistory("——>check bg view end");
            this.mRootView.addView(this.mBgView);
        }
    }

    public void safeAddBubbleView() {
        if (this.mBubbleView != null) {
            BubbleHistory.getInstance().trackBubbleOpHistory("——>check bubble view begin");
            checkSafe(this.mBubbleView);
            BubbleHistory.getInstance().trackBubbleOpHistory("——>check bubble view end");
            this.mBubbleView.setVisibility(4);
            this.mRootView.addView(this.mBubbleView);
        }
    }

    @Nullable
    private ViewGroup getContentViewFromWindow(@NonNull View view2) {
        Context context = view2.getContext();
        if (context instanceof Activity) {
            return (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    public void checkSafe(View view2) {
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
            BubbleHistory.getInstance().trackBubbleOpHistory("——>checkSafe remove view end");
        }
    }

    public void postAnchorView(Runnable runnable) {
        View view2 = this.mAnchorView;
        if (view2 != null) {
            view2.post(runnable);
        }
    }

    public void setAnchor(View view2) {
        this.mAnchorView = view2;
        if (view2 != null) {
            ViewGroup viewGroup = (ViewGroup) view2.getRootView().findViewById(16908290);
            this.mRootView = viewGroup;
            if (viewGroup == null) {
                this.mRootView = getContentViewFromWindow(this.mAnchorView);
            }
        }
    }

    public void setAnchorClick(View.OnClickListener onClickListener) {
        View view2 = this.mAnchorLayer;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void setBGClick(View.OnClickListener onClickListener) {
        View view2 = this.mBgView;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void setBubbleClick(View.OnClickListener onClickListener) {
        View view2 = this.mBubbleView;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void setDayModeBackground(@ColorInt int i) {
        this.mBgColorDay = i;
    }

    public void setDayModeShadowColor(@ColorInt int i) {
        this.mShadowColorDay = i;
    }

    public void setIsShadowDeviate(boolean z) {
        this.mIsShadowDeviate = z;
    }

    public void setNightModeBackground(@ColorInt int i) {
        this.mBgColorNight = i;
    }

    public void showBubbleOnLocation(int[] iArr) {
        View view2 = this.mBubbleView;
        if (view2 != null) {
            view2.setX(iArr[0]);
            this.mBubbleView.setY(iArr[1]);
            this.mBubbleContent.setVisibility(0);
            this.mBubbleView.setVisibility(0);
            this.mBubbleArrow.setVisibility(0);
            this.mBgView.setVisibility(0);
            MaskViewGroup maskViewGroup = this.mShadow;
            if (maskViewGroup != null) {
                maskViewGroup.setVisibility(0);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    public void initLinkBubble() {
        final Resources resources = AppRuntime.getAppContext().getResources();
        this.mBubbleText.setLinkTextColor(resources.getColorStateList(R.color.obfuscated_res_0x7f060773));
        this.mBubbleText.setHighlightColor(0);
        CustomLinkMovementMethod customLinkMovementMethod = new CustomLinkMovementMethod();
        customLinkMovementMethod.setLinkMovementListener(new CustomLinkMovementMethod.OnLinkMovementListener() { // from class: com.baidu.searchbox.ui.bubble.views.BubbleBaseView.1
            @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
            public void onLinkTouch(TextView textView, MotionEvent motionEvent) {
            }

            @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
            public void onNoLinkTouch(TextView textView, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BubbleBaseView.this.mBubbleText.setLinkTextColor(resources.getColor(R.color.obfuscated_res_0x7f0604d5));
                } else {
                    BubbleBaseView.this.mBubbleText.setLinkTextColor(resources.getColorStateList(R.color.obfuscated_res_0x7f060773));
                }
            }
        });
        this.mBubbleText.setMovementMethod(customLinkMovementMethod);
        if (this.mTvEllipse == null) {
            this.mTvEllipse = new CustomLinkByEllipsize(this.mBubbleText);
        }
        this.mBubbleText.getViewTreeObserver().addOnGlobalLayoutListener(this.mTvEllipse);
    }

    public boolean initViewIfNeed() {
        if (this.mBubbleView != null) {
            return false;
        }
        View inflate = LayoutInflater.from(this.mAnchorView.getContext()).inflate(getBubbleViewResId(), this.mRootView, false);
        this.mBubbleView = inflate;
        inflate.setVisibility(4);
        this.mBubbleContent = (ViewGroup) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f09052c);
        this.mShadow = (MaskViewGroup) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f09220d);
        this.mArrowUp = (ArrowView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090527);
        this.mArrowDown = (ArrowView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090524);
        this.mArrowLeft = (ArrowView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090525);
        this.mArrowRight = (ArrowView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090526);
        int bgColor = getBgColor();
        MaskViewGroup maskViewGroup = this.mShadow;
        if (maskViewGroup != null) {
            if (!this.mIsShadowDeviate) {
                maskViewGroup.setShadowDy(0.0f);
            } else {
                maskViewGroup.setShadowDy(DeviceUtils.ScreenInfo.dp2px(this.mAnchorView.getContext(), 2.0f));
            }
            if (NightModeHelper.getNightModeSwitcherState()) {
                this.mShadow.setDrawShadow(false);
            } else {
                int i = this.mShadowColorDay;
                if (i == -1000) {
                    i = bgColor;
                }
                this.mShadow.setShadowColor(i);
            }
        }
        if (this.mBubbleContent.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(bgColor);
        }
        this.mBubbleContent.setVisibility(4);
        this.mArrowUp.setArrowViewColor(bgColor);
        this.mArrowDown.setArrowViewColor(bgColor);
        this.mArrowLeft.setArrowViewColor(bgColor);
        this.mArrowRight.setArrowViewColor(bgColor);
        View view2 = new View(this.mAnchorView.getContext());
        this.mBgView = view2;
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mBgView.setVisibility(4);
        this.mAnchorLayer = new View(this.mAnchorView.getContext());
        return true;
    }

    public void setAnchorAndRootView(View view2, ViewGroup viewGroup) {
        this.mAnchorView = view2;
        this.mRootView = viewGroup;
        if (viewGroup == null && view2 != null) {
            ViewGroup viewGroup2 = (ViewGroup) view2.getRootView().findViewById(16908290);
            this.mRootView = viewGroup2;
            if (viewGroup2 == null) {
                this.mRootView = getContentViewFromWindow(this.mAnchorView);
            }
        }
    }

    public void showAnchorLayer() {
        View view2 = this.mAnchorLayer;
        if (view2 != null && this.mAnchorView != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = this.mAnchorView.getMeasuredWidth();
            layoutParams.height = this.mAnchorView.getMeasuredHeight();
            this.mAnchorLayer.setLayoutParams(layoutParams);
            int[] iArr = new int[2];
            this.mAnchorView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.mRootView.getLocationOnScreen(iArr2);
            this.mAnchorLayer.setX(iArr[0] - iArr2[0]);
            this.mAnchorLayer.setY(iArr[1] - iArr2[1]);
        }
    }

    public void showArrowView(BubblePosition bubblePosition) {
        dismissAllArrowView();
        int i = AnonymousClass2.$SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[bubblePosition.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.mArrowRight.setDirection(3);
                        this.mBubbleArrow = this.mArrowRight;
                        return;
                    }
                    return;
                }
                this.mArrowLeft.setDirection(1);
                ArrowView arrowView = this.mArrowLeft;
                this.mBubbleArrow = arrowView;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin - ((int) arrowView.dpToPixel(1.0f)), marginLayoutParams.bottomMargin);
                    this.mBubbleArrow.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            this.mArrowDown.setDirection(4);
            this.mBubbleArrow = this.mArrowDown;
            return;
        }
        this.mArrowUp.setDirection(2);
        ArrowView arrowView2 = this.mArrowUp;
        this.mBubbleArrow = arrowView2;
        if (Build.VERSION.SDK_INT <= 25) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin - ((int) arrowView2.dpToPixel(1.0f)));
            this.mBubbleArrow.setLayoutParams(marginLayoutParams2);
        }
    }

    public void updateBubble(int i, int i2) {
        ArrowView arrowView;
        TextView textView;
        ViewGroup viewGroup = this.mBubbleContent;
        if (viewGroup != null && (viewGroup.getBackground() instanceof GradientDrawable) && (arrowView = this.mBubbleArrow) != null && (arrowView instanceof ArrowView) && (textView = this.mBubbleText) != null && textView.getVisibility() == 0 && !TextUtils.isEmpty(this.mBubbleText.getText())) {
            ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(i);
            this.mBubbleArrow.setArrowViewColor(i);
            this.mBubbleText.setTextColor(i2);
        }
    }
}
