package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes19.dex */
public class ProgressButton extends RelativeLayout {
    public static final int IN_PROGRESS = 2;
    public static final int NOT_IN_PROGRESS = 1;
    private String defaultText;
    private SmoothProgressBar progressBar;
    private String progressText;
    private TextView progressTextView;

    public ProgressButton(Context context) {
        super(context);
        init(context);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.progress_button, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.progressBar = (SmoothProgressBar) findViewById(com.baidu.android.common.ui.R.id.local_video_scan_progress);
        this.progressTextView = (TextView) findViewById(com.baidu.android.common.ui.R.id.local_video_scan_button);
        stopProgress();
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public String getProgressText() {
        return this.progressText;
    }

    public void setProgressText(String str) {
        this.progressText = str;
    }

    public void startProgress() {
        this.progressBar.setVisibility(0);
        this.progressTextView.setText(this.progressText);
    }

    public void stopProgress() {
        this.progressBar.setVisibility(8);
        this.progressTextView.setText(this.defaultText);
    }

    public int getProgressStatus() {
        return (TextUtils.isEmpty(this.progressText) || !TextUtils.equals(this.progressText, this.progressTextView.getText())) ? 1 : 2;
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.progressBar.setIndeterminateDrawable(drawable);
    }

    public void setIndeterminate(boolean z) {
        this.progressBar.setIndeterminate(z);
    }
}
