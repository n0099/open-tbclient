package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int afp = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int afq = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
    private static int afs = 7;
    private a afj;
    private ImageView afk;
    private int afl;
    private int afm;
    private int afn;
    private int afo;
    private int afr;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.afl = 0;
        this.afm = this.afl;
        this.afn = 1;
        this.afo = this.afn;
        this.afr = afp;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afl = 0;
        this.afm = this.afl;
        this.afn = 1;
        this.afo = this.afn;
        this.afr = afp;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afl = 0;
        this.afm = this.afl;
        this.afn = 1;
        this.afo = this.afn;
        this.afr = afp;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.l.GodHeadImageView);
            this.afr = obtainStyledAttributes.getDimensionPixelSize(0, afp);
            this.afo = obtainStyledAttributes.getInteger(3, this.afn);
            this.afm = obtainStyledAttributes.getInteger(2, this.afl);
            this.mRadius = obtainStyledAttributes.getInteger(1, afs);
            obtainStyledAttributes.recycle();
        }
        this.afj = new a(getContext());
        this.afk = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.afj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.afj, layoutParams);
        addView(this.afk, new FrameLayout.LayoutParams(-1, -1));
        wO();
    }

    public void setShowType(int i) {
        this.afm = i;
        wO();
    }

    public void setShapeType(int i) {
        this.afo = i;
        wO();
    }

    public void d(String str, int i, boolean z) {
        this.afj.d(str, i, z);
    }

    private void wO() {
        switch (this.afm) {
            case 0:
                this.afj.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.afj.setPadding(afq, afq, 0, 0);
                break;
        }
        switch (this.afo) {
            case 1:
                this.afj.setIsRound(true);
                if (this.afm == 0) {
                    ar.c(this.afk, t.f.pic_shen_avatar_big);
                    return;
                } else {
                    ar.c(this.afk, t.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.afj.setIsRound(false);
                this.afj.setRadius(this.mRadius);
                ar.c(this.afk, t.f.pic_frs_shen_avatar);
                return;
            default:
                this.afj.setIsRound(false);
                this.afj.setRadius(this.mRadius);
                ar.c(this.afk, t.f.pic_shen_avatar_square);
                return;
        }
    }

    public void wP() {
        wO();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        wO();
    }

    public void setExtraPadding(int i) {
        if (this.afr != i) {
            this.afr = i;
            this.afj.invalidate();
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
            if (GodHeadImageView.this.afm == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.afr, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.afr, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
