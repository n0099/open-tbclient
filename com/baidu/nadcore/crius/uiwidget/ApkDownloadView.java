package com.baidu.nadcore.crius.uiwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.jj0;
/* loaded from: classes2.dex */
public class ApkDownloadView extends FrameLayout {
    public int a;
    public jj0 b;

    public ApkDownloadView(@NonNull Context context) {
        super(context);
        this.a = 0;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public void setBorderRadius(float f) {
        if (f >= 0.0f) {
            this.b.setBorderRadius(f);
        }
    }

    public void setDownloadStyle(int i) {
        if (i == this.a || i == 1) {
            return;
        }
        NadCriusMiniVideoDownloadView nadCriusMiniVideoDownloadView = new NadCriusMiniVideoDownloadView(getContext());
        removeAllViews();
        addView(nadCriusMiniVideoDownloadView);
        this.b = nadCriusMiniVideoDownloadView;
        this.a = i;
    }

    public void setProgressColor(int i) {
        this.b.setProgressColor(i);
    }

    public void setStrokeColor(int i) {
        this.b.setStrokeColor(i);
    }

    public void setStrokeWidth(float f) {
        this.b.setStrokeWidth(f);
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTextSize(float f) {
        this.b.setTextSize(f);
    }

    public ApkDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }

    public ApkDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
    }

    public jj0 getRealDownloadView() {
        return this.b;
    }
}
