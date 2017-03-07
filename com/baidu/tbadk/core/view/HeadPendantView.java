package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aiJ;
    private HeadImageView aiK;
    private boolean aiL;
    private boolean aiM;
    private boolean aiN;
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

    public boolean wo() {
        return this.aiN;
    }

    public void wp() {
        this.aiL = true;
        if (this.aiJ == null) {
            this.aiJ = new TbImageView(this.mContext);
            this.aiJ.setDefaultBgResource(0);
            this.aiJ.setDefaultResource(0);
            this.aiJ.setDefaultErrorResource(0);
            this.aiJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aiJ);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aiL = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aiL && !this.aiM) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aiM = true;
            this.aiK.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dO(String str) {
        if (this.aiJ != null) {
            if (!StringUtils.isNull(str)) {
                this.aiN = true;
                this.aiJ.setVisibility(0);
                this.aiJ.c(str, 10, false);
                return;
            }
            this.aiJ.setVisibility(8);
            this.aiN = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aiJ.setAutoChangeStyle(z);
        this.aiK.setAutoChangeStyle(z);
    }

    private void init() {
        this.aiK = new HeadImageView(this.mContext);
        this.aiK.setDefaultBgResource(w.g.transparent_bg);
        this.aiK.setDefaultResource(w.e.cp_bg_line_e);
        this.aiK.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aiK.setLayoutParams(layoutParams);
        addView(this.aiK);
    }

    public TbImageView getPendantView() {
        return this.aiJ;
    }

    public HeadImageView getHeadView() {
        return this.aiK;
    }
}
