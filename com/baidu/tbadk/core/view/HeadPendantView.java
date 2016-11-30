package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aeQ;
    private HeadImageView aeR;
    private boolean aeS;
    private boolean aeT;
    private boolean aeU;
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

    public boolean wn() {
        return this.aeU;
    }

    public void wo() {
        this.aeS = true;
        if (this.aeQ == null) {
            this.aeQ = new TbImageView(this.mContext);
            this.aeQ.setDefaultBgResource(0);
            this.aeQ.setDefaultResource(0);
            this.aeQ.setDefaultErrorResource(0);
            this.aeQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aeQ);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aeS = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aeS && !this.aeT) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aeT = true;
            this.aeR.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dZ(String str) {
        if (this.aeQ != null) {
            if (!StringUtils.isNull(str)) {
                this.aeU = true;
                this.aeQ.setVisibility(0);
                this.aeQ.c(str, 10, false);
                return;
            }
            this.aeQ.setVisibility(8);
            this.aeU = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aeQ.setAutoChangeStyle(z);
        this.aeR.setAutoChangeStyle(z);
    }

    private void init() {
        this.aeR = new HeadImageView(this.mContext);
        this.aeR.setDefaultBgResource(r.f.transparent_bg);
        this.aeR.setDefaultResource(r.d.cp_bg_line_e);
        this.aeR.setDefaultErrorResource(r.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aeR.setLayoutParams(layoutParams);
        addView(this.aeR);
    }

    public TbImageView getPendantView() {
        return this.aeQ;
    }

    public HeadImageView getHeadView() {
        return this.aeR;
    }
}
