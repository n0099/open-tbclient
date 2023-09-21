package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
/* loaded from: classes4.dex */
public class SimpleLoadingDialog extends BaseLoadingDialog {
    public ImageView mCloseImgView;
    public boolean mHasCloseBtn;
    public TextView mMsgTxtView;
    public SmoothProgressBar mProgressBar;
    public View mRootView;

    public SimpleLoadingDialog(@NonNull Context context, @StringRes int i) {
        super(context, i);
        this.mHasCloseBtn = false;
    }

    public SimpleLoadingDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        super(context, charSequence);
        this.mHasCloseBtn = false;
    }

    @Override // com.baidu.searchbox.ui.BaseLoadingDialog
    public void initView() {
        int i;
        setContentView(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0247);
        this.mRootView = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091fa7);
        this.mProgressBar = (SmoothProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09163a);
        this.mMsgTxtView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09174d);
        this.mCloseImgView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09071e);
        this.mMsgTxtView.setText(this.mMsgText);
        this.mCloseImgView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.SimpleLoadingDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SimpleLoadingDialog simpleLoadingDialog = SimpleLoadingDialog.this;
                simpleLoadingDialog.mDismissType = 4;
                simpleLoadingDialog.dismiss();
            }
        });
        ImageView imageView = this.mCloseImgView;
        if (this.mHasCloseBtn) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        setPageResources();
        setFontResources();
    }

    public SimpleLoadingDialog setCloseButton() {
        this.mHasCloseBtn = true;
        return this;
    }

    @Override // com.baidu.searchbox.ui.BaseLoadingDialog
    public void setFontResources() {
        SmoothProgressBar smoothProgressBar = this.mProgressBar;
        if (smoothProgressBar != null) {
            FontSizeViewExtKt.setScaledSizeRes(smoothProgressBar, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f070794, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07078a);
            this.mProgressBar.setIndeterminateDrawable(FontSizeHelper.getScaledDrawableRes(0, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080575));
        }
        TextView textView = this.mMsgTxtView;
        if (textView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f070793);
        }
        ImageView imageView = this.mCloseImgView;
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes(imageView, 0, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07078d, com.baidu.tieba.R.dimen.obfuscated_res_0x7f07078b);
            this.mCloseImgView.setBackground(FontSizeHelper.getScaledDrawableRes(0, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080577));
        }
    }

    @Override // com.baidu.searchbox.ui.BaseLoadingDialog
    public void setPageResources() {
        Resources resources = AppRuntime.getAppContext().getResources();
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setBackground(resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080576));
        }
        SmoothProgressBar smoothProgressBar = this.mProgressBar;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080575));
        }
        TextView textView = this.mMsgTxtView;
        if (textView != null) {
            textView.setTextColor(resources.getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0601e3));
        }
        ImageView imageView = this.mCloseImgView;
        if (imageView != null) {
            imageView.setBackground(resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080577));
        }
    }
}
