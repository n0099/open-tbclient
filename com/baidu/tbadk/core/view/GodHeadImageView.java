package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aip = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aiq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int ais = 7;
    private a aij;
    private ImageView aik;
    private int ail;
    private int aim;
    private int ain;
    private int aio;
    private int air;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.ail = 0;
        this.aim = this.ail;
        this.ain = 1;
        this.aio = this.ain;
        this.air = aip;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ail = 0;
        this.aim = this.ail;
        this.ain = 1;
        this.aio = this.ain;
        this.air = aip;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ail = 0;
        this.aim = this.ail;
        this.ain = 1;
        this.aio = this.ain;
        this.air = aip;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.air = obtainStyledAttributes.getDimensionPixelSize(0, aip);
            this.aio = obtainStyledAttributes.getInteger(3, this.ain);
            this.aim = obtainStyledAttributes.getInteger(2, this.ail);
            this.mRadius = obtainStyledAttributes.getInteger(1, ais);
            obtainStyledAttributes.recycle();
        }
        this.aij = new a(getContext());
        this.aik = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aij.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aij, layoutParams);
        addView(this.aik, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aim = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aio = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.aij.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.aim) {
            case 0:
                this.aij.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aij.setPadding(aiq, aiq, 0, 0);
                break;
        }
        switch (this.aio) {
            case 1:
                this.aij.setIsRound(true);
                if (this.aim == 0) {
                    com.baidu.tbadk.core.util.aq.c(this.aik, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.aik, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aij.setIsRound(false);
                this.aij.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aik, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aij.setIsRound(true);
                com.baidu.tbadk.core.util.aq.c(this.aik, w.g.browser_null_drawable);
                return;
            default:
                this.aij.setIsRound(false);
                this.aij.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aik, w.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.air != i) {
            this.air = i;
            this.aij.invalidate();
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
            if (GodHeadImageView.this.aim == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.air, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.air, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
