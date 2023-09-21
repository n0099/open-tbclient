package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
/* loaded from: classes4.dex */
public class CommonEmptyView extends RelativeLayout {
    public FrameLayout mBottomLayout;
    public ButtonStyle mButtonStyle;
    public ImageView mIcon;
    public int mIconResId;
    public TextView mLinkText;
    public TextView mRefreshTextBtn;
    public TextView mSubTitle;
    public TextView mTitle;

    /* loaded from: classes4.dex */
    public enum ButtonStyle {
        WHITE,
        BLUE
    }

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public void setButtonBackground(Drawable drawable) {
        this.mRefreshTextBtn.setBackground(drawable);
    }

    public void setButtonStyle(ButtonStyle buttonStyle) {
        this.mButtonStyle = buttonStyle;
        setButtonResources();
    }

    public void setButtonText(int i) {
        this.mRefreshTextBtn.setText(i);
    }

    public void setButtonTextColor(int i) {
        this.mRefreshTextBtn.setTextColor(i);
    }

    public void setIcon(int i) {
        this.mIconResId = i;
        FontSizeImageViewExtKt.setScaledImageDrawable(this.mIcon, 0, getResources().getDrawable(i), 2);
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.mLinkText.setVisibility(0);
        this.mLinkText.setOnClickListener(onClickListener);
    }

    public void setLinkText(int i) {
        this.mLinkText.setText(i);
    }

    public void setSubTitle(int i) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(i);
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.mRefreshTextBtn.setVisibility(0);
        this.mRefreshTextBtn.setOnClickListener(onClickListener);
    }

    public void setTitle(int i) {
        this.mTitle.setText(i);
    }

    @Deprecated
    public void setTitleColor(int i) {
        this.mTitle.setTextColor(i);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mButtonStyle = ButtonStyle.WHITE;
        this.mIconResId = com.baidu.tieba.R.drawable.obfuscated_res_0x7f08060a;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0218, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(com.baidu.tieba.R.color.obfuscated_res_0x7f06073d));
        this.mIcon = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a02);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a06);
        this.mSubTitle = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a05);
        TextView textView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a03);
        this.mLinkText = textView;
        textView.setOnTouchListener(new TouchStateListener(textView));
        TextView textView2 = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a01);
        this.mRefreshTextBtn = textView2;
        textView2.setOnTouchListener(new TouchStateListener(textView2));
        this.mBottomLayout = (FrameLayout) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a00);
        setResourceTextSize();
        setPageResources();
    }

    private void setResourceTextSize() {
        FontSizeTextViewExtKt.setScaledSizeRes(this.mTitle, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07024d);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mSubTitle, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07024c);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mLinkText, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07024b);
        FontSizeTextViewExtKt.setScaledSizeRes(this.mRefreshTextBtn, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f070249);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFontSizeUI() {
        setResourceTextSize();
        ImageView imageView = this.mIcon;
        if (imageView != null && this.mIconResId != -1) {
            FontSizeImageViewExtKt.setScaledImageDrawable(imageView, 0, getResources().getDrawable(this.mIconResId), 2);
        }
        setButtonResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.CommonEmptyView.1
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                CommonEmptyView.this.setPageResources();
            }
        });
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.ui.CommonEmptyView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                CommonEmptyView.this.updateFontSizeUI();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
    }

    @Deprecated
    public void resetIconWidthAndHeight() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIcon.getLayoutParams();
        int scaledSize = FontSizeHelper.getScaledSize(0, (float) com.baidu.tieba.R.dimen.obfuscated_res_0x7f070449, 2) / 2;
        layoutParams.width = scaledSize;
        layoutParams.height = scaledSize;
        this.mIcon.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.mBottomLayout;
        if (frameLayout != null && frameLayout.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
            int i = configuration.orientation;
            if (i == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070448);
            } else if (i == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070447);
            }
            this.mBottomLayout.setLayoutParams(layoutParams);
        }
    }

    public void setButtonResources() {
        if (this.mButtonStyle == ButtonStyle.BLUE) {
            this.mRefreshTextBtn.setBackground(FontSizeHelper.getScaledDrawableRes(0, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080613));
            this.mRefreshTextBtn.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603ab));
            return;
        }
        this.mRefreshTextBtn.setBackground(FontSizeHelper.getScaledDrawableRes(0, com.baidu.tieba.R.drawable.obfuscated_res_0x7f08060e));
        this.mRefreshTextBtn.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603ad));
    }

    public void setButtonText(String str) {
        this.mRefreshTextBtn.setText(str);
    }

    @Deprecated
    public void setButtonTextColor(ColorStateList colorStateList) {
        this.mRefreshTextBtn.setTextColor(colorStateList);
    }

    @Deprecated
    public void setIcon(Drawable drawable) {
        this.mIconResId = -1;
        FontSizeImageViewExtKt.setScaledImageDrawable(this.mIcon, 0, drawable, 2);
    }

    public void setLinkText(String str) {
        this.mLinkText.setText(str);
    }

    public void setSubTitle(String str) {
        this.mSubTitle.setVisibility(0);
        this.mSubTitle.setText(str);
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setPageResources() {
        setBackgroundColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060ba2));
        ImageView imageView = this.mIcon;
        if (imageView != null && this.mIconResId != -1) {
            FontSizeImageViewExtKt.setScaledImageDrawable(imageView, 0, getResources().getDrawable(this.mIconResId), 2);
        }
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603a7));
        }
        TextView textView2 = this.mSubTitle;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603a8));
        }
        TextView textView3 = this.mLinkText;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0603aa));
        }
        setButtonResources();
    }
}
