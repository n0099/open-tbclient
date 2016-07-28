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
    private static final int abq = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds6);
    private static final int abr = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1);
    private static int abu = 7;
    private a abk;
    private ImageView abl;
    private int abm;
    private int abn;
    private int abo;
    private int abp;
    private int abt;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.abm = 0;
        this.abn = this.abm;
        this.abo = 1;
        this.abp = this.abo;
        this.abt = abq;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abm = 0;
        this.abn = this.abm;
        this.abo = 1;
        this.abp = this.abo;
        this.abt = abq;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abm = 0;
        this.abn = this.abm;
        this.abo = 1;
        this.abp = this.abo;
        this.abt = abq;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, u.l.GodHeadImageView);
            this.abt = obtainStyledAttributes.getDimensionPixelSize(0, abq);
            this.abp = obtainStyledAttributes.getInteger(3, this.abo);
            this.abn = obtainStyledAttributes.getInteger(2, this.abm);
            this.mRadius = obtainStyledAttributes.getInteger(1, abu);
            obtainStyledAttributes.recycle();
        }
        this.abk = new a(getContext());
        this.abl = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.abk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.abk, layoutParams);
        addView(this.abl, new FrameLayout.LayoutParams(-1, -1));
        uP();
    }

    public void setShowType(int i) {
        this.abn = i;
        uP();
    }

    public void setShapeType(int i) {
        this.abp = i;
        uP();
    }

    public void c(String str, int i, boolean z) {
        this.abk.c(str, i, z);
    }

    private void uP() {
        switch (this.abn) {
            case 0:
                this.abk.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.abk.setPadding(abr, abr, 0, 0);
                break;
        }
        switch (this.abp) {
            case 1:
                this.abk.setIsRound(true);
                if (this.abn == 0) {
                    av.c(this.abl, u.f.pic_shen_avatar_big);
                    return;
                } else {
                    av.c(this.abl, u.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.abk.setIsRound(false);
                this.abk.setRadius(this.mRadius);
                av.c(this.abl, u.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.abk.setIsRound(true);
                av.c(this.abl, u.f.browser_null_drawable);
                return;
            default:
                this.abk.setIsRound(false);
                this.abk.setRadius(this.mRadius);
                av.c(this.abl, u.f.pic_shen_avatar_square);
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
        if (this.abt != i) {
            this.abt = i;
            this.abk.invalidate();
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
            if (GodHeadImageView.this.abn == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.abt, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.abt, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
