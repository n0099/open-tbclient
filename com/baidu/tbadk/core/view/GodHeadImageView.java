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
    private static final int aiS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aiT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int aiV = 7;
    private a aiM;
    private ImageView aiN;
    private int aiO;
    private int aiP;
    private int aiQ;
    private int aiR;
    private int aiU;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aiO = 0;
        this.aiP = this.aiO;
        this.aiQ = 1;
        this.aiR = this.aiQ;
        this.aiU = aiS;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiO = 0;
        this.aiP = this.aiO;
        this.aiQ = 1;
        this.aiR = this.aiQ;
        this.aiU = aiS;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiO = 0;
        this.aiP = this.aiO;
        this.aiQ = 1;
        this.aiR = this.aiQ;
        this.aiU = aiS;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.aiU = obtainStyledAttributes.getDimensionPixelSize(0, aiS);
            this.aiR = obtainStyledAttributes.getInteger(3, this.aiQ);
            this.aiP = obtainStyledAttributes.getInteger(2, this.aiO);
            this.mRadius = obtainStyledAttributes.getInteger(1, aiV);
            obtainStyledAttributes.recycle();
        }
        this.aiM = new a(getContext());
        this.aiN = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aiM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aiM, layoutParams);
        addView(this.aiN, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aiP = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aiR = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.aiM.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.aiP) {
            case 0:
                this.aiM.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aiM.setPadding(aiT, aiT, 0, 0);
                break;
        }
        switch (this.aiR) {
            case 1:
                this.aiM.setIsRound(true);
                if (this.aiP == 0) {
                    com.baidu.tbadk.core.util.aq.c(this.aiN, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.aiN, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aiM.setIsRound(false);
                this.aiM.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiN, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aiM.setIsRound(true);
                com.baidu.tbadk.core.util.aq.c(this.aiN, w.g.browser_null_drawable);
                return;
            default:
                this.aiM.setIsRound(false);
                this.aiM.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiN, w.g.pic_shen_avatar_square);
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
        if (this.aiU != i) {
            this.aiU = i;
            this.aiM.invalidate();
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
            if (GodHeadImageView.this.aiP == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aiU, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aiU, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
