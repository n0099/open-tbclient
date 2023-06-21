package com.baidu.nadcore.download.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.am0;
import com.baidu.tieba.tm0;
/* loaded from: classes3.dex */
public class DefaultDownloadViewLP extends FrameLayout implements tm0<DefaultDownloadViewLP> {
    public BannerDownloadView a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm0
    @NonNull
    public DefaultDownloadViewLP getRealView() {
        return this;
    }

    public void setAbsorbColor(int i) {
    }

    public DefaultDownloadViewLP(@NonNull Context context) {
        this(context, null);
    }

    private void setProgress(float f) {
        BannerDownloadView bannerDownloadView = this.a;
        if (bannerDownloadView != null) {
            bannerDownloadView.setProgress(f);
        }
    }

    private void setText(String str) {
        BannerDownloadView bannerDownloadView = this.a;
        if (bannerDownloadView != null) {
            bannerDownloadView.setText(str);
        }
    }

    @Override // com.baidu.tieba.tm0
    public void b(@NonNull ViewGroup viewGroup) {
        if (!(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
        viewGroup.bringToFront();
    }

    public void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nad_download_lp_view, this);
        setBackgroundResource(R.color.nad_white);
        this.a = (BannerDownloadView) findViewById(R.id.lp_download_btn);
    }

    public void d(boolean z) {
        int i;
        View findViewById = findViewById(R.id.nad_download_lp_safe_tip);
        if (findViewById == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    public DefaultDownloadViewLP(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.tieba.tm0
    public void update(String str, @NonNull am0 am0Var) {
        if (am0Var.c == AdDownloadStatus.DOWNLOADING) {
            str = getResources().getString(R.string.nad_download_progress_text) + str;
            setProgress(am0Var.i);
        } else {
            setProgress(0.0f);
        }
        setText(str);
        postInvalidate();
    }

    public DefaultDownloadViewLP(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
