package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aiY;
    private HeadImageView aiZ;
    private boolean aja;
    private boolean ajb;
    private boolean ajc;
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
        return this.ajc;
    }

    public void wL() {
        this.aja = true;
        if (this.aiY == null) {
            this.aiY = new TbImageView(this.mContext);
            this.aiY.setDefaultBgResource(0);
            this.aiY.setDefaultResource(0);
            this.aiY.setDefaultErrorResource(0);
            this.aiY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aiY);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aja = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aja && !this.ajb) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.ajb = true;
            this.aiZ.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dU(String str) {
        if (this.aiY != null) {
            if (!StringUtils.isNull(str)) {
                this.ajc = true;
                this.aiY.setVisibility(0);
                this.aiY.c(str, 10, false);
                return;
            }
            this.aiY.setVisibility(8);
            this.ajc = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aiY.setAutoChangeStyle(z);
        this.aiZ.setAutoChangeStyle(z);
    }

    private void init() {
        this.aiZ = new HeadImageView(this.mContext);
        this.aiZ.setDefaultBgResource(w.g.transparent_bg);
        this.aiZ.setDefaultResource(w.e.cp_bg_line_e);
        this.aiZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aiZ.setLayoutParams(layoutParams);
        addView(this.aiZ);
    }

    public TbImageView getPendantView() {
        return this.aiY;
    }

    public HeadImageView getHeadView() {
        return this.aiZ;
    }
}
