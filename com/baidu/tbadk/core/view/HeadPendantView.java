package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aeh;
    private HeadImageView aei;
    private boolean aej;
    private boolean aek;
    private boolean ael;
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

    public boolean vV() {
        return this.ael;
    }

    public void vW() {
        this.aej = true;
        if (this.aeh == null) {
            this.aeh = new TbImageView(this.mContext);
            this.aeh.setDefaultBgResource(0);
            this.aeh.setDefaultResource(0);
            this.aeh.setDefaultErrorResource(0);
            this.aeh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aeh);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aej = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aej && !this.aek) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aek = true;
            this.aei.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dU(String str) {
        if (this.aeh != null) {
            if (!StringUtils.isNull(str)) {
                this.ael = true;
                this.aeh.setVisibility(0);
                this.aeh.c(str, 10, false);
                return;
            }
            this.aeh.setVisibility(8);
            this.ael = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aeh.setAutoChangeStyle(z);
        this.aei.setAutoChangeStyle(z);
    }

    private void init() {
        this.aei = new HeadImageView(this.mContext);
        this.aei.setDefaultBgResource(t.f.transparent_bg);
        this.aei.setDefaultResource(t.d.cp_bg_line_e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aei.setLayoutParams(layoutParams);
        addView(this.aei);
    }

    public TbImageView getPendantView() {
        return this.aeh;
    }

    public HeadImageView getHeadView() {
        return this.aei;
    }
}
