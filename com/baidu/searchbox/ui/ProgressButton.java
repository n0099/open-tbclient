package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class ProgressButton extends RelativeLayout {
    public static final int IN_PROGRESS = 2;
    public static final int NOT_IN_PROGRESS = 1;
    public String defaultText;
    public SmoothProgressBar progressBar;
    public String progressText;
    public TextView progressTextView;

    public ProgressButton(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0838, this);
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setIndeterminate(boolean z) {
        this.progressBar.setIndeterminate(z);
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.progressBar.setIndeterminateDrawable(drawable);
    }

    public void setProgressText(String str) {
        this.progressText = str;
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public int getProgressStatus() {
        if (!TextUtils.isEmpty(this.progressText) && TextUtils.equals(this.progressText, this.progressTextView.getText())) {
            return 2;
        }
        return 1;
    }

    public String getProgressText() {
        return this.progressText;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.progressBar = (SmoothProgressBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091657);
        this.progressTextView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091655);
        stopProgress();
    }

    public void startProgress() {
        this.progressBar.setVisibility(0);
        this.progressTextView.setText(this.progressText);
    }

    public void stopProgress() {
        this.progressBar.setVisibility(8);
        this.progressTextView.setText(this.defaultText);
    }
}
