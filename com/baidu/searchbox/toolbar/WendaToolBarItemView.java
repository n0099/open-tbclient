package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class WendaToolBarItemView extends LinearLayout implements IFontSizeViewListener {
    public boolean mIsResponseFontSize;
    public ImageView mWendaBarDividingLineImg;
    public BdBaseImageView mWendaBarImg;
    public int mWendaBarResInt;
    public int mWendaBarStatus;
    public TextView mWendaBarTitleTv;

    public WendaToolBarItemView(Context context) {
        super(context);
        this.mWendaBarStatus = -1;
        this.mIsResponseFontSize = false;
        this.mWendaBarResInt = -1;
        initView();
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
        BdBaseImageView bdBaseImageView = this.mWendaBarImg;
        if (bdBaseImageView != null) {
            bdBaseImageView.setIsResponseFontSize(z);
        }
    }

    public void setWendaBarStatus(int i) {
        this.mWendaBarStatus = i;
    }

    public WendaToolBarItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWendaBarStatus = -1;
        this.mIsResponseFontSize = false;
        this.mWendaBarResInt = -1;
        initView();
    }

    public WendaToolBarItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWendaBarStatus = -1;
        this.mIsResponseFontSize = false;
        this.mWendaBarResInt = -1;
        initView();
    }

    private void initView() {
        setGravity(5);
        setOrientation(0);
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0215, this);
        this.mWendaBarImg = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f09293e);
        this.mWendaBarTitleTv = (TextView) findViewById(R.id.obfuscated_res_0x7f09293f);
        this.mWendaBarDividingLineImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f09293d);
    }

    public TextView getWendaBarTitleTv() {
        return this.mWendaBarTitleTv;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }

    @Override // com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void onFontSizeChange() {
        int i;
        if (!isResponseFontSize()) {
            return;
        }
        if (this.mWendaBarImg != null && (i = this.mWendaBarResInt) != -1) {
            Drawable scaledDrawableRes = FontSizeHelper.getScaledDrawableRes(0, i);
            FontSizeViewExtKt.setScaledWidthRes(this.mWendaBarImg, 0, R.dimen.obfuscated_res_0x7f0702e3);
            FontSizeViewExtKt.setScaledHeightRes(this.mWendaBarImg, 0, R.dimen.obfuscated_res_0x7f0702e3);
            if (scaledDrawableRes != null) {
                this.mWendaBarImg.setImageDrawable(scaledDrawableRes);
            }
        }
        FontSizeTextViewExtKt.setScaledSizeRes(this.mWendaBarTitleTv, 0, R.dimen.obfuscated_res_0x7f0702df);
        FontSizeViewExtKt.setScaledWidthRes(this.mWendaBarDividingLineImg, 0, R.dimen.obfuscated_res_0x7f0702d9);
        FontSizeViewExtKt.setScaledHeightRes(this.mWendaBarDividingLineImg, 0, R.dimen.obfuscated_res_0x7f0702df);
        FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mWendaBarDividingLineImg, 0, R.drawable.obfuscated_res_0x7f081522);
    }

    public void updateWendaUI() {
        int i = this.mWendaBarStatus;
        if (i == -1) {
            return;
        }
        if (i == 0) {
            this.mWendaBarImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081496));
            this.mWendaBarResInt = R.drawable.obfuscated_res_0x7f081496;
        }
        if (this.mWendaBarStatus == 1) {
            this.mWendaBarImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081497));
            this.mWendaBarResInt = R.drawable.obfuscated_res_0x7f081497;
        }
        this.mWendaBarTitleTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603e2));
        this.mWendaBarDividingLineImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081522));
        onFontSizeChange();
    }
}
