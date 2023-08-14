package com.baidu.searchbox.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.searchbox.ui.PressedAlphaImageView;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PraiseToolBarItemView extends RelativeLayout implements IFontSizeViewListener {
    public boolean mIsMiniVideo;
    public boolean mIsMiniVideoVerticalLandingStyle;
    public boolean mIsResponseFontSize;
    public TextView mPraiseTips;
    public CoolPraiseView mPraiseView;

    public PraiseToolBarItemView(Context context) {
        super(context);
        this.mIsResponseFontSize = false;
        initView();
    }

    public void setIsMiniVideoVerticalLandingStyle(boolean z) {
        this.mIsMiniVideoVerticalLandingStyle = z;
        onFontSizeChange();
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
    }

    public PraiseToolBarItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsResponseFontSize = false;
        initView();
    }

    public PraiseToolBarItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsResponseFontSize = false;
        initView();
    }

    private void initView() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070260);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070262);
        CoolPraiseView coolPraiseView = new CoolPraiseView(getContext());
        this.mPraiseView = coolPraiseView;
        coolPraiseView.setClickable(true);
        this.mPraiseView.setGravity(17);
        this.mPraiseView.setId(R.id.obfuscated_res_0x7f091d18);
        PressedAlphaImageView pressedAlphaImageView = (PressedAlphaImageView) this.mPraiseView.findViewById(R.id.obfuscated_res_0x7f0928ac);
        ViewGroup.LayoutParams layoutParams = pressedAlphaImageView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070252);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        pressedAlphaImageView.setLayoutParams(layoutParams);
        ((TextView) this.mPraiseView.findViewById(R.id.obfuscated_res_0x7f0928ad)).setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset2);
        layoutParams2.leftMargin = dimensionPixelOffset;
        layoutParams2.rightMargin = dimensionPixelOffset;
        this.mPraiseView.setLayoutParams(layoutParams2);
        addView(this.mPraiseView);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.obfuscated_res_0x7f091d18);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070264);
        TextView textView = new TextView(getContext());
        this.mPraiseTips = textView;
        textView.setLayoutParams(layoutParams3);
        this.mPraiseTips.setGravity(17);
        this.mPraiseTips.setTextSize(11, 2.0f);
        this.mPraiseTips.setPadding(getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070265), 0, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070265), 0);
        this.mPraiseTips.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060648));
        this.mPraiseTips.setVisibility(8);
        addView(this.mPraiseTips);
    }

    public CoolPraiseView getCoolPraiseView() {
        return this.mPraiseView;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        if (!isResponseFontSize()) {
            return;
        }
        PressedAlphaImageView pressedAlphaImageView = (PressedAlphaImageView) this.mPraiseView.findViewById(R.id.obfuscated_res_0x7f0928ac);
        if (pressedAlphaImageView != null) {
            FontSizeViewExtKt.setScaledWidthRes(pressedAlphaImageView, 0, R.dimen.obfuscated_res_0x7f070252);
            FontSizeViewExtKt.setScaledHeightRes(pressedAlphaImageView, 0, R.dimen.obfuscated_res_0x7f070252);
        }
        TextView textView = (TextView) this.mPraiseView.findViewById(R.id.obfuscated_res_0x7f0928ad);
        if (textView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e0);
        }
        TextView textView2 = this.mPraiseTips;
        if (textView2 != null) {
            if (this.mIsMiniVideo) {
                FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.obfuscated_res_0x7f07024e);
            } else {
                FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.obfuscated_res_0x7f0702e2);
            }
        }
    }

    public void setPraise(boolean z) {
        this.mPraiseView.setPraise(z);
        if (z) {
            this.mPraiseTips.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607eb));
        } else if (this.mIsMiniVideo) {
            this.mPraiseTips.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060647));
        } else {
            this.mPraiseTips.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060648));
        }
    }

    public void setPraiseStatus(ToolBarNewType toolBarNewType, String str) {
        if (this.mPraiseView != null) {
            if (toolBarNewType == ToolBarNewType.STRING_TIP) {
                TextView textView = this.mPraiseTips;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.mPraiseTips.setText(str);
                    if (this.mIsMiniVideoVerticalLandingStyle) {
                        if (this.mPraiseView.getIsPraisedState()) {
                            this.mPraiseTips.setTextColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f0607eb));
                            return;
                        } else {
                            this.mPraiseTips.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060647));
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            TextView textView2 = this.mPraiseTips;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void updateToMiniVideoUI(View view2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.mPraiseTips != null) {
            this.mIsMiniVideo = true;
            int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 4.0f);
            if (this.mIsMiniVideoVerticalLandingStyle) {
                CoolPraiseView coolPraiseView = this.mPraiseView;
                if (coolPraiseView != null && (layoutParams2 = (RelativeLayout.LayoutParams) coolPraiseView.getLayoutParams()) != null) {
                    layoutParams2.width = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070267);
                    this.mPraiseView.setLayoutParams(layoutParams2);
                }
                TextView textView = this.mPraiseTips;
                if (textView != null) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f);
                        this.mPraiseTips.setLayoutParams(layoutParams3);
                    }
                    this.mPraiseTips.getPaint().setFakeBoldText(false);
                }
                if (view2 != null && (layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams()) != null) {
                    layoutParams.rightMargin = DeviceUtil.ScreenInfo.dp2px(getContext(), 2.0f);
                    view2.setLayoutParams(layoutParams);
                }
                this.mPraiseTips.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060647));
                this.mPraiseTips.setBackground(null);
                this.mPraiseTips.getPaint().setFakeBoldText(false);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mPraiseTips.getLayoutParams();
                if (layoutParams4 == null) {
                    layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                }
                if (DeviceUtil.OSInfo.hasJellyBeanMR1()) {
                    layoutParams4.removeRule(10);
                } else {
                    layoutParams4.addRule(10, 0);
                }
                layoutParams4.addRule(15);
                layoutParams4.setMargins(-DeviceUtil.ScreenInfo.dp2px(getContext(), 17.0f), 0, 0, 0);
                this.mPraiseTips.setLayoutParams(layoutParams4);
                this.mPraiseTips.setPadding(0, DeviceUtil.ScreenInfo.dp2px(getContext(), 1.0f), 0, 0);
            } else {
                this.mPraiseTips.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060647));
                this.mPraiseTips.setPadding(dp2px, 0, dp2px, 1);
            }
            this.mPraiseTips.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024e));
        }
        onFontSizeChange();
    }
}
