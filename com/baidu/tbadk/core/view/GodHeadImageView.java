package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aeO = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
    private static final int aeP = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
    private static int aeR = 7;
    private a aeI;
    private ImageView aeJ;
    private int aeK;
    private int aeL;
    private int aeM;
    private int aeN;
    private int aeQ;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aeK = 0;
        this.aeL = this.aeK;
        this.aeM = 1;
        this.aeN = this.aeM;
        this.aeQ = aeO;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeK = 0;
        this.aeL = this.aeK;
        this.aeM = 1;
        this.aeN = this.aeM;
        this.aeQ = aeO;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeK = 0;
        this.aeL = this.aeK;
        this.aeM = 1;
        this.aeN = this.aeM;
        this.aeQ = aeO;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.l.GodHeadImageView);
            this.aeQ = obtainStyledAttributes.getDimensionPixelSize(0, aeO);
            this.aeN = obtainStyledAttributes.getInteger(3, this.aeM);
            this.aeL = obtainStyledAttributes.getInteger(2, this.aeK);
            this.mRadius = obtainStyledAttributes.getInteger(1, aeR);
            obtainStyledAttributes.recycle();
        }
        this.aeI = new a(getContext());
        this.aeJ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aeI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aeI, layoutParams);
        addView(this.aeJ, new FrameLayout.LayoutParams(-1, -1));
        xg();
    }

    public void setShowType(int i) {
        this.aeL = i;
        xg();
    }

    public void setShapeType(int i) {
        this.aeN = i;
        xg();
    }

    public void c(String str, int i, boolean z) {
        this.aeI.c(str, i, z);
    }

    private void xg() {
        switch (this.aeL) {
            case 0:
                this.aeI.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aeI.setPadding(aeP, aeP, 0, 0);
                break;
        }
        switch (this.aeN) {
            case 1:
                this.aeI.setIsRound(true);
                if (this.aeL == 0) {
                    at.c(this.aeJ, t.f.pic_shen_avatar_big);
                    return;
                } else {
                    at.c(this.aeJ, t.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aeI.setIsRound(false);
                this.aeI.setRadius(this.mRadius);
                at.c(this.aeJ, t.f.pic_frs_shen_avatar);
                return;
            default:
                this.aeI.setIsRound(false);
                this.aeI.setRadius(this.mRadius);
                at.c(this.aeJ, t.f.pic_shen_avatar_square);
                return;
        }
    }

    public void xh() {
        xg();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        xg();
    }

    public void setExtraPadding(int i) {
        if (this.aeQ != i) {
            this.aeQ = i;
            this.aeI.invalidate();
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
            if (GodHeadImageView.this.aeL == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aeQ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aeQ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
