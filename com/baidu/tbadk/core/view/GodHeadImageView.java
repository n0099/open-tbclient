package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aaG = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds6);
    private static final int aaH = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1);
    private static int aaJ = 7;
    private a aaA;
    private ImageView aaB;
    private int aaC;
    private int aaD;
    private int aaE;
    private int aaF;
    private int aaI;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aaC = 0;
        this.aaD = this.aaC;
        this.aaE = 1;
        this.aaF = this.aaE;
        this.aaI = aaG;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaC = 0;
        this.aaD = this.aaC;
        this.aaE = 1;
        this.aaF = this.aaE;
        this.aaI = aaG;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaC = 0;
        this.aaD = this.aaC;
        this.aaE = 1;
        this.aaF = this.aaE;
        this.aaI = aaG;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, u.l.GodHeadImageView);
            this.aaI = obtainStyledAttributes.getDimensionPixelSize(0, aaG);
            this.aaF = obtainStyledAttributes.getInteger(3, this.aaE);
            this.aaD = obtainStyledAttributes.getInteger(2, this.aaC);
            this.mRadius = obtainStyledAttributes.getInteger(1, aaJ);
            obtainStyledAttributes.recycle();
        }
        this.aaA = new a(getContext());
        this.aaB = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aaA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aaA, layoutParams);
        addView(this.aaB, new FrameLayout.LayoutParams(-1, -1));
        uP();
    }

    public void setShowType(int i) {
        this.aaD = i;
        uP();
    }

    public void setShapeType(int i) {
        this.aaF = i;
        uP();
    }

    public void c(String str, int i, boolean z) {
        this.aaA.c(str, i, z);
    }

    private void uP() {
        switch (this.aaD) {
            case 0:
                this.aaA.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aaA.setPadding(aaH, aaH, 0, 0);
                break;
        }
        switch (this.aaF) {
            case 1:
                this.aaA.setIsRound(true);
                if (this.aaD == 0) {
                    av.c(this.aaB, u.f.pic_shen_avatar_big);
                    return;
                } else {
                    av.c(this.aaB, u.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aaA.setIsRound(false);
                this.aaA.setRadius(this.mRadius);
                av.c(this.aaB, u.f.pic_frs_shen_avatar);
                return;
            default:
                this.aaA.setIsRound(false);
                this.aaA.setRadius(this.mRadius);
                av.c(this.aaB, u.f.pic_shen_avatar_square);
                return;
        }
    }

    public void uQ() {
        uP();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        uP();
    }

    public void setExtraPadding(int i) {
        if (this.aaI != i) {
            this.aaI = i;
            this.aaA.invalidate();
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
            if (GodHeadImageView.this.aaD == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aaI, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aaI, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
