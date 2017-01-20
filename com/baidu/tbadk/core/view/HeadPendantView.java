package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView adu;
    private HeadImageView adv;
    private boolean adw;
    private boolean adx;
    private boolean ady;
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

    public boolean vR() {
        return this.ady;
    }

    public void vS() {
        this.adw = true;
        if (this.adu == null) {
            this.adu = new TbImageView(this.mContext);
            this.adu.setDefaultBgResource(0);
            this.adu.setDefaultResource(0);
            this.adu.setDefaultErrorResource(0);
            this.adu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.adu);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.adw = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.adw && !this.adx) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.adx = true;
            this.adv.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dU(String str) {
        if (this.adu != null) {
            if (!StringUtils.isNull(str)) {
                this.ady = true;
                this.adu.setVisibility(0);
                this.adu.c(str, 10, false);
                return;
            }
            this.adu.setVisibility(8);
            this.ady = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.adu.setAutoChangeStyle(z);
        this.adv.setAutoChangeStyle(z);
    }

    private void init() {
        this.adv = new HeadImageView(this.mContext);
        this.adv.setDefaultBgResource(r.g.transparent_bg);
        this.adv.setDefaultResource(r.e.cp_bg_line_e);
        this.adv.setDefaultErrorResource(r.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.adv.setLayoutParams(layoutParams);
        addView(this.adv);
    }

    public TbImageView getPendantView() {
        return this.adu;
    }

    public HeadImageView getHeadView() {
        return this.adv;
    }
}
