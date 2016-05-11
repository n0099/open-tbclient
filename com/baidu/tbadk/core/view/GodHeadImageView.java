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
    private static final int aan = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int aao = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1);
    private static int aaq = 7;
    private a aah;
    private ImageView aai;
    private int aaj;
    private int aak;
    private int aal;
    private int aam;
    private int aap;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aaj = 0;
        this.aak = this.aaj;
        this.aal = 1;
        this.aam = this.aal;
        this.aap = aan;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaj = 0;
        this.aak = this.aaj;
        this.aal = 1;
        this.aam = this.aal;
        this.aap = aan;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaj = 0;
        this.aak = this.aaj;
        this.aal = 1;
        this.aam = this.aal;
        this.aap = aan;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.l.GodHeadImageView);
            this.aap = obtainStyledAttributes.getDimensionPixelSize(0, aan);
            this.aam = obtainStyledAttributes.getInteger(3, this.aal);
            this.aak = obtainStyledAttributes.getInteger(2, this.aaj);
            this.mRadius = obtainStyledAttributes.getInteger(1, aaq);
            obtainStyledAttributes.recycle();
        }
        this.aah = new a(getContext());
        this.aai = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aah.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aah, layoutParams);
        addView(this.aai, new FrameLayout.LayoutParams(-1, -1));
        uP();
    }

    public void setShowType(int i) {
        this.aak = i;
        uP();
    }

    public void setShapeType(int i) {
        this.aam = i;
        uP();
    }

    public void c(String str, int i, boolean z) {
        this.aah.c(str, i, z);
    }

    private void uP() {
        switch (this.aak) {
            case 0:
                this.aah.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aah.setPadding(aao, aao, 0, 0);
                break;
        }
        switch (this.aam) {
            case 1:
                this.aah.setIsRound(true);
                if (this.aak == 0) {
                    com.baidu.tbadk.core.util.at.c(this.aai, t.f.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.at.c(this.aai, t.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aah.setIsRound(false);
                this.aah.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.at.c(this.aai, t.f.pic_frs_shen_avatar);
                return;
            default:
                this.aah.setIsRound(false);
                this.aah.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.at.c(this.aai, t.f.pic_shen_avatar_square);
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
        if (this.aap != i) {
            this.aap = i;
            this.aah.invalidate();
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
            if (GodHeadImageView.this.aak == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aap, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aap, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
