package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aeb = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int aec = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1);
    private static int aee = 7;
    private a adV;
    private ImageView adW;
    private int adX;
    private int adY;
    private int adZ;
    private int aea;
    private int aed;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.adX = 0;
        this.adY = this.adX;
        this.adZ = 1;
        this.aea = this.adZ;
        this.aed = aeb;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adX = 0;
        this.adY = this.adX;
        this.adZ = 1;
        this.aea = this.adZ;
        this.aed = aeb;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adX = 0;
        this.adY = this.adX;
        this.adZ = 1;
        this.aea = this.adZ;
        this.aed = aeb;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.l.GodHeadImageView);
            this.aed = obtainStyledAttributes.getDimensionPixelSize(0, aeb);
            this.aea = obtainStyledAttributes.getInteger(3, this.adZ);
            this.adY = obtainStyledAttributes.getInteger(2, this.adX);
            this.mRadius = obtainStyledAttributes.getInteger(1, aee);
            obtainStyledAttributes.recycle();
        }
        this.adV = new a(getContext());
        this.adW = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.adV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.adV, layoutParams);
        addView(this.adW, new FrameLayout.LayoutParams(-1, -1));
        vR();
    }

    public void setShowType(int i) {
        this.adY = i;
        vR();
    }

    public void setShapeType(int i) {
        this.aea = i;
        vR();
    }

    public void c(String str, int i, boolean z) {
        this.adV.c(str, i, z);
    }

    private void vR() {
        switch (this.adY) {
            case 0:
                this.adV.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.adV.setPadding(aec, aec, 0, 0);
                break;
        }
        switch (this.aea) {
            case 1:
                this.adV.setIsRound(true);
                if (this.adY == 0) {
                    com.baidu.tbadk.core.util.av.c(this.adW, t.f.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.av.c(this.adW, t.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.adV.setIsRound(false);
                this.adV.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.av.c(this.adW, t.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.adV.setIsRound(true);
                com.baidu.tbadk.core.util.av.c(this.adW, t.f.browser_null_drawable);
                return;
            default:
                this.adV.setIsRound(false);
                this.adV.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.av.c(this.adW, t.f.pic_shen_avatar_square);
                return;
        }
    }

    public void vS() {
        vR();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        vR();
    }

    public void setExtraPadding(int i) {
        if (this.aed != i) {
            this.aed = i;
            this.adV.invalidate();
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
            if (GodHeadImageView.this.adY == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aed, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aed, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
