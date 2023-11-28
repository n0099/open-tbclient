package com.baidu.searchbox.ui.bubble.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.bubble.ArrowView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BubbleTextView extends BubbleBaseView {
    public static final float BUBBLE_MINI_ARROW_DOWN_HEIGHT = 6.0f;
    public static final float BUBBLE_MINI_ARROW_DOWN_WIDTH = 11.0f;
    public static final float BUBBLE_MINI_BOTTOM_PADDING = 2.0f;
    public static final float BUBBLE_MINI_LEFT_PADDING = 10.0f;
    public static final float BUBBLE_MINI_RIGHT_PADDING = 7.0f;
    public static final float BUBBLE_MINI_TOP_PADDING = 2.0f;
    public static final String TAG = "BubbleTextManager";
    public boolean isBold;
    public CharSequence mShowText;
    @ColorInt
    public int mTextDayColor = -1000;
    @ColorInt
    public int mTextNightColor = -1000;
    public int mUnit = -1;
    public float mSize = 0.0f;
    public boolean mIsMiniBubble = false;

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        return R.layout.obfuscated_res_0x7f0d019a;
    }

    public int getTextColor() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            int i = this.mTextNightColor;
            if (i != -1000) {
                return i;
            }
        } else {
            int i2 = this.mTextDayColor;
            if (i2 != -1000) {
                return i2;
            }
        }
        return AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060388);
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        if (!super.initViewIfNeed()) {
            return false;
        }
        int textColor = getTextColor();
        TextView textView = (TextView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090558);
        this.mBubbleText = textView;
        textView.setTextColor(textColor);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mBubbleText, 0, R.dimen.obfuscated_res_0x7f0701f8);
        this.mBubbleText.setVisibility(0);
        if (this.mIsMiniBubble) {
            adjustBubbleSize();
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean isValidate() {
        if (!TextUtils.isEmpty(this.mShowText) && super.isValidate()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        super.resetAll();
        this.mShowText = null;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void updateViewUI() {
        super.updateViewUI();
        TextView textView = this.mBubbleText;
        if (textView != null) {
            int i = this.mUnit;
            if (i >= 0) {
                float f = this.mSize;
                if (f > 0.0f) {
                    FontSizeTextViewExtKt.setScaledSize(textView, 0, i, f);
                    return;
                }
            }
            FontSizeTextViewExtKt.setScaledSizeRes(this.mBubbleText, 0, R.dimen.obfuscated_res_0x7f0701f8);
        }
    }

    private void adjustBubbleSize() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mBubbleContent;
        if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            layoutParams.width = -2;
            Context context = this.mBubbleContent.getContext();
            layoutParams.height = -2;
            this.mBubbleContent.setPadding(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f), DeviceUtils.ScreenInfo.dp2px(context, 7.0f), DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f));
            this.mBubbleContent.setLayoutParams(layoutParams);
            FontSizeTextViewExtKt.setScaledSize(this.mBubbleText, 0, 0, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701ed) * 1.0f);
        }
        ArrowView arrowView = this.mArrowDown;
        if (arrowView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) arrowView.getLayoutParams();
            layoutParams2.height = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 6.0f);
            layoutParams2.width = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 11.0f);
            this.mArrowDown.setLayoutParams(layoutParams2);
        }
    }

    public void isMiniBubble(boolean z) {
        this.mIsMiniBubble = z;
    }

    public void setText(CharSequence charSequence) {
        this.mShowText = charSequence;
    }

    public void setBubbleText(CharSequence charSequence, int i, int i2, float f, boolean z) {
        Typeface defaultFromStyle;
        TextView textView = this.mBubbleText;
        if (textView == null) {
            return;
        }
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        this.mBubbleText.setTextColor(i);
        TextView textView2 = this.mBubbleText;
        if (z) {
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView2.setTypeface(defaultFromStyle);
        if (i2 >= 0 && f > 0.0f) {
            FontSizeTextViewExtKt.setScaledSize(this.mBubbleText, 0, i2, f);
        }
    }

    public void setTextColor(@ColorInt int i, @ColorInt int i2) {
        this.mTextDayColor = i;
        this.mTextNightColor = i2;
    }
}
