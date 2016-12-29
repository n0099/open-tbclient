package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aed = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
    private static final int aee = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
    private static int aeg = 7;
    private a adX;
    private ImageView adY;
    private int adZ;
    private int aea;
    private int aeb;
    private int aec;
    private int aef;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.adZ = 0;
        this.aea = this.adZ;
        this.aeb = 1;
        this.aec = this.aeb;
        this.aef = aed;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adZ = 0;
        this.aea = this.adZ;
        this.aeb = 1;
        this.aec = this.aeb;
        this.aef = aed;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adZ = 0;
        this.aea = this.adZ;
        this.aeb = 1;
        this.aec = this.aeb;
        this.aef = aed;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.l.GodHeadImageView);
            this.aef = obtainStyledAttributes.getDimensionPixelSize(0, aed);
            this.aec = obtainStyledAttributes.getInteger(3, this.aeb);
            this.aea = obtainStyledAttributes.getInteger(2, this.adZ);
            this.mRadius = obtainStyledAttributes.getInteger(1, aeg);
            obtainStyledAttributes.recycle();
        }
        this.adX = new a(getContext());
        this.adY = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.adX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.adX, layoutParams);
        addView(this.adY, new FrameLayout.LayoutParams(-1, -1));
        vT();
    }

    public void setShowType(int i) {
        this.aea = i;
        vT();
    }

    public void setShapeType(int i) {
        this.aec = i;
        vT();
    }

    public void c(String str, int i, boolean z) {
        this.adX.c(str, i, z);
    }

    private void vT() {
        switch (this.aea) {
            case 0:
                this.adX.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.adX.setPadding(aee, aee, 0, 0);
                break;
        }
        switch (this.aec) {
            case 1:
                this.adX.setIsRound(true);
                if (this.aea == 0) {
                    com.baidu.tbadk.core.util.ar.c(this.adY, r.f.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.ar.c(this.adY, r.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.adX.setIsRound(false);
                this.adX.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.ar.c(this.adY, r.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.adX.setIsRound(true);
                com.baidu.tbadk.core.util.ar.c(this.adY, r.f.browser_null_drawable);
                return;
            default:
                this.adX.setIsRound(false);
                this.adX.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.ar.c(this.adY, r.f.pic_shen_avatar_square);
                return;
        }
    }

    public void vU() {
        vT();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        vT();
    }

    public void setExtraPadding(int i) {
        if (this.aef != i) {
            this.aef = i;
            this.adX.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.aea == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aef, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aef, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
