package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aes;
    private HeadImageView aet;
    private boolean aeu;
    private boolean aev;
    private boolean aew;
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

    public boolean wj() {
        return this.aew;
    }

    public void wk() {
        this.aeu = true;
        if (this.aes == null) {
            this.aes = new TbImageView(this.mContext);
            this.aes.setDefaultBgResource(0);
            this.aes.setDefaultResource(0);
            this.aes.setDefaultErrorResource(0);
            this.aes.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aes);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aeu = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aeu && !this.aev) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aev = true;
            this.aet.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dX(String str) {
        if (this.aes != null) {
            if (!StringUtils.isNull(str)) {
                this.aew = true;
                this.aes.setVisibility(0);
                this.aes.c(str, 10, false);
                return;
            }
            this.aes.setVisibility(8);
            this.aew = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aes.setAutoChangeStyle(z);
        this.aet.setAutoChangeStyle(z);
    }

    private void init() {
        this.aet = new HeadImageView(this.mContext);
        this.aet.setDefaultBgResource(r.f.transparent_bg);
        this.aet.setDefaultResource(r.d.cp_bg_line_e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aet.setLayoutParams(layoutParams);
        addView(this.aet);
    }

    public TbImageView getPendantView() {
        return this.aes;
    }

    public HeadImageView getHeadView() {
        return this.aet;
    }
}
