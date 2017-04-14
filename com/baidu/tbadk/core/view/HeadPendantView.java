package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aiX;
    private HeadImageView aiY;
    private boolean aiZ;
    private boolean aja;
    private boolean ajb;
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

    public boolean wK() {
        return this.ajb;
    }

    public void wL() {
        this.aiZ = true;
        if (this.aiX == null) {
            this.aiX = new TbImageView(this.mContext);
            this.aiX.setDefaultBgResource(0);
            this.aiX.setDefaultResource(0);
            this.aiX.setDefaultErrorResource(0);
            this.aiX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aiX);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aiZ = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aiZ && !this.aja) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aja = true;
            this.aiY.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dU(String str) {
        if (this.aiX != null) {
            if (!StringUtils.isNull(str)) {
                this.ajb = true;
                this.aiX.setVisibility(0);
                this.aiX.c(str, 10, false);
                return;
            }
            this.aiX.setVisibility(8);
            this.ajb = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aiX.setAutoChangeStyle(z);
        this.aiY.setAutoChangeStyle(z);
    }

    private void init() {
        this.aiY = new HeadImageView(this.mContext);
        this.aiY.setDefaultBgResource(w.g.transparent_bg);
        this.aiY.setDefaultResource(w.e.cp_bg_line_e);
        this.aiY.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aiY.setLayoutParams(layoutParams);
        addView(this.aiY);
    }

    public TbImageView getPendantView() {
        return this.aiX;
    }

    public HeadImageView getHeadView() {
        return this.aiY;
    }
}
