package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private TbImageView aiv;
    private HeadImageView aiw;
    private boolean aix;
    private boolean aiy;
    private boolean aiz;
    private Context mContext;
    private BdUniqueId mPageId;

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
        return this.aiz;
    }

    public void vY() {
        this.aix = true;
        if (this.aiv == null) {
            this.aiv = new TbImageView(this.mContext);
            this.aiv.setPageId(this.mPageId);
            this.aiv.setDefaultBgResource(0);
            this.aiv.setDefaultResource(0);
            this.aiv.setDefaultErrorResource(0);
            this.aiv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aiv);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aix = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aix && !this.aiy) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aiy = true;
            this.aiw.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dS(String str) {
        if (this.aiv != null) {
            if (!StringUtils.isNull(str)) {
                this.aiz = true;
                this.aiv.setVisibility(0);
                this.aiv.c(str, 10, false);
                return;
            }
            this.aiv.setVisibility(8);
            this.aiz = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aiv.setAutoChangeStyle(z);
        this.aiw.setAutoChangeStyle(z);
    }

    private void init() {
        this.aiw = new HeadImageView(this.mContext);
        this.aiw.setDefaultBgResource(w.g.transparent_bg);
        this.aiw.setDefaultResource(w.e.cp_bg_line_e);
        this.aiw.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aiw.setLayoutParams(layoutParams);
        addView(this.aiw);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aiw != null) {
            this.aiw.setPageId(bdUniqueId);
        }
        if (this.aiv != null) {
            this.aiv.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aiv;
    }

    public HeadImageView getHeadView() {
        return this.aiw;
    }
}
