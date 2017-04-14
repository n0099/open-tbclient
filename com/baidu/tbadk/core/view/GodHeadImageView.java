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
    private static final int aiR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aiS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int aiU = 7;
    private a aiL;
    private ImageView aiM;
    private int aiN;
    private int aiO;
    private int aiP;
    private int aiQ;
    private int aiT;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aiN = 0;
        this.aiO = this.aiN;
        this.aiP = 1;
        this.aiQ = this.aiP;
        this.aiT = aiR;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiN = 0;
        this.aiO = this.aiN;
        this.aiP = 1;
        this.aiQ = this.aiP;
        this.aiT = aiR;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiN = 0;
        this.aiO = this.aiN;
        this.aiP = 1;
        this.aiQ = this.aiP;
        this.aiT = aiR;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.aiT = obtainStyledAttributes.getDimensionPixelSize(0, aiR);
            this.aiQ = obtainStyledAttributes.getInteger(3, this.aiP);
            this.aiO = obtainStyledAttributes.getInteger(2, this.aiN);
            this.mRadius = obtainStyledAttributes.getInteger(1, aiU);
            obtainStyledAttributes.recycle();
        }
        this.aiL = new a(getContext());
        this.aiM = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aiL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aiL, layoutParams);
        addView(this.aiM, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aiO = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aiQ = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.aiL.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.aiO) {
            case 0:
                this.aiL.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aiL.setPadding(aiS, aiS, 0, 0);
                break;
        }
        switch (this.aiQ) {
            case 1:
                this.aiL.setIsRound(true);
                if (this.aiO == 0) {
                    com.baidu.tbadk.core.util.aq.c(this.aiM, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.aiM, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aiL.setIsRound(false);
                this.aiL.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiM, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aiL.setIsRound(true);
                com.baidu.tbadk.core.util.aq.c(this.aiM, w.g.browser_null_drawable);
                return;
            default:
                this.aiL.setIsRound(false);
                this.aiL.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiM, w.g.pic_shen_avatar_square);
                return;
        }
    }

    public void wH() {
        refreshUI();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aiT != i) {
            this.aiT = i;
            this.aiL.invalidate();
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
            if (GodHeadImageView.this.aiO == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aiT, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aiT, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
