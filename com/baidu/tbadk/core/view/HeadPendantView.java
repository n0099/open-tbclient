package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aej;
    private HeadImageView aek;
    private boolean ael;
    private boolean aem;
    private boolean aen;
    private Context mContext;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public boolean vX() {
        return this.aen;
    }

    public void vY() {
        this.ael = true;
        if (this.aej == null) {
            this.aej = new TbImageView(this.mContext);
            this.aej.setDefaultBgResource(0);
            this.aej.setDefaultResource(0);
            this.aej.setDefaultErrorResource(0);
            this.aej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aej);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.ael = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ael && !this.aem) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aem = true;
            this.aek.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dW(String str) {
        if (this.aej != null) {
            if (!StringUtils.isNull(str)) {
                this.aen = true;
                this.aej.setVisibility(0);
                this.aej.c(str, 10, false);
                return;
            }
            this.aej.setVisibility(8);
            this.aen = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aej.setAutoChangeStyle(z);
        this.aek.setAutoChangeStyle(z);
    }

    private void init() {
        this.aek = new HeadImageView(this.mContext);
        this.aek.setDefaultBgResource(r.f.transparent_bg);
        this.aek.setDefaultResource(r.d.cp_bg_line_e);
        this.aek.setDefaultErrorResource(r.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aek.setLayoutParams(layoutParams);
        addView(this.aek);
    }

    public TbImageView getPendantView() {
        return this.aej;
    }

    public HeadImageView getHeadView() {
        return this.aek;
    }
}
