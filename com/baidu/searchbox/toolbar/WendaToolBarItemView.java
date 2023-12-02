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
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d022a, this);
        this.mWendaBarImg = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f092b16);
        this.mWendaBarTitleTv = (TextView) findViewById(R.id.obfuscated_res_0x7f092b17);
        this.mWendaBarDividingLineImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f092b15);
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
            FontSizeViewExtKt.setScaledWidthRes(this.mWendaBarImg, 0, R.dimen.obfuscated_res_0x7f0702ea);
            FontSizeViewExtKt.setScaledHeightRes(this.mWendaBarImg, 0, R.dimen.obfuscated_res_0x7f0702ea);
            if (scaledDrawableRes != null) {
                this.mWendaBarImg.setImageDrawable(scaledDrawableRes);
            }
        }
        FontSizeTextViewExtKt.setScaledSizeRes(this.mWendaBarTitleTv, 0, R.dimen.obfuscated_res_0x7f0702e6);
        FontSizeViewExtKt.setScaledWidthRes(this.mWendaBarDividingLineImg, 0, R.dimen.obfuscated_res_0x7f0702e0);
        FontSizeViewExtKt.setScaledHeightRes(this.mWendaBarDividingLineImg, 0, R.dimen.obfuscated_res_0x7f0702e6);
        FontSizeImageViewExtKt.setScaledImageDrawableRes(this.mWendaBarDividingLineImg, 0, R.drawable.obfuscated_res_0x7f0815d3);
    }

    public void updateWendaUI() {
        int i = this.mWendaBarStatus;
        if (i == -1) {
            return;
        }
        if (i == 0) {
            this.mWendaBarImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08155c));
            this.mWendaBarResInt = R.drawable.obfuscated_res_0x7f08155c;
        }
        if (this.mWendaBarStatus == 1) {
            this.mWendaBarImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08155d));
            this.mWendaBarResInt = R.drawable.obfuscated_res_0x7f08155d;
        }
        this.mWendaBarTitleTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603ec));
        this.mWendaBarDividingLineImg.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0815d3));
        onFontSizeChange();
    }
}
