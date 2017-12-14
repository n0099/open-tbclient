package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private a akq;
    private ImageView akr;
    private int aks;
    private int akt;
    private int aku;
    private int akv;
    private int akx;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int akw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.aks = 0;
        this.akt = this.aks;
        this.aku = 1;
        this.akv = this.aku;
        this.akx = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aks = 0;
        this.akt = this.aks;
        this.aku = 1;
        this.akv = this.aku;
        this.akx = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aks = 0;
        this.akt = this.aks;
        this.aku = 1;
        this.akv = this.aku;
        this.akx = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.akx = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.akv = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.aku);
            this.akt = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.aks);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.akq = new a(getContext());
        this.akr = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.akq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.akq, layoutParams);
        addView(this.akr, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.akt = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.akv = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.akq.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.akt) {
            case 0:
                this.akq.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.akq.setPadding(akw, akw, 0, 0);
                break;
        }
        switch (this.akv) {
            case 1:
                this.akq.setIsRound(true);
                if (this.akt == 0) {
                    aj.c(this.akr, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.akr, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.akq.setIsRound(false);
                this.akq.setRadius(this.mRadius);
                aj.c(this.akr, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.akq.setIsRound(true);
                aj.c(this.akr, d.f.browser_null_drawable);
                return;
            default:
                this.akq.setIsRound(false);
                this.akq.setRadius(this.mRadius);
                aj.c(this.akr, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.akx != i) {
            this.akx = i;
            this.akq.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.akt == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.akx, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.akx, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
