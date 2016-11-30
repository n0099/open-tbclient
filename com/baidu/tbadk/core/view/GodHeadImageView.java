package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aeK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
    private static final int aeL = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
    private static int aeN = 7;
    private a aeE;
    private ImageView aeF;
    private int aeG;
    private int aeH;
    private int aeI;
    private int aeJ;
    private int aeM;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aeG = 0;
        this.aeH = this.aeG;
        this.aeI = 1;
        this.aeJ = this.aeI;
        this.aeM = aeK;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeG = 0;
        this.aeH = this.aeG;
        this.aeI = 1;
        this.aeJ = this.aeI;
        this.aeM = aeK;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeG = 0;
        this.aeH = this.aeG;
        this.aeI = 1;
        this.aeJ = this.aeI;
        this.aeM = aeK;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.l.GodHeadImageView);
            this.aeM = obtainStyledAttributes.getDimensionPixelSize(0, aeK);
            this.aeJ = obtainStyledAttributes.getInteger(3, this.aeI);
            this.aeH = obtainStyledAttributes.getInteger(2, this.aeG);
            this.mRadius = obtainStyledAttributes.getInteger(1, aeN);
            obtainStyledAttributes.recycle();
        }
        this.aeE = new a(getContext());
        this.aeF = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aeE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aeE, layoutParams);
        addView(this.aeF, new FrameLayout.LayoutParams(-1, -1));
        wj();
    }

    public void setShowType(int i) {
        this.aeH = i;
        wj();
    }

    public void setShapeType(int i) {
        this.aeJ = i;
        wj();
    }

    public void c(String str, int i, boolean z) {
        this.aeE.c(str, i, z);
    }

    private void wj() {
        switch (this.aeH) {
            case 0:
                this.aeE.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aeE.setPadding(aeL, aeL, 0, 0);
                break;
        }
        switch (this.aeJ) {
            case 1:
                this.aeE.setIsRound(true);
                if (this.aeH == 0) {
                    at.c(this.aeF, r.f.pic_shen_avatar_big);
                    return;
                } else {
                    at.c(this.aeF, r.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aeE.setIsRound(false);
                this.aeE.setRadius(this.mRadius);
                at.c(this.aeF, r.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.aeE.setIsRound(true);
                at.c(this.aeF, r.f.browser_null_drawable);
                return;
            default:
                this.aeE.setIsRound(false);
                this.aeE.setRadius(this.mRadius);
                at.c(this.aeF, r.f.pic_shen_avatar_square);
                return;
        }
    }

    public void wk() {
        wj();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        wj();
    }

    public void setExtraPadding(int i) {
        if (this.aeM != i) {
            this.aeM = i;
            this.aeE.invalidate();
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
            if (GodHeadImageView.this.aeH == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aeM, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aeM, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
