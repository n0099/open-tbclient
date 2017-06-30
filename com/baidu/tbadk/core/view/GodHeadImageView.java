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
    private static final int aiI = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aiJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int aiL = 7;
    private a aiC;
    private ImageView aiD;
    private int aiE;
    private int aiF;
    private int aiG;
    private int aiH;
    private int aiK;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aiE = 0;
        this.aiF = this.aiE;
        this.aiG = 1;
        this.aiH = this.aiG;
        this.aiK = aiI;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiE = 0;
        this.aiF = this.aiE;
        this.aiG = 1;
        this.aiH = this.aiG;
        this.aiK = aiI;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiE = 0;
        this.aiF = this.aiE;
        this.aiG = 1;
        this.aiH = this.aiG;
        this.aiK = aiI;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.aiK = obtainStyledAttributes.getDimensionPixelSize(0, aiI);
            this.aiH = obtainStyledAttributes.getInteger(3, this.aiG);
            this.aiF = obtainStyledAttributes.getInteger(2, this.aiE);
            this.mRadius = obtainStyledAttributes.getInteger(1, aiL);
            obtainStyledAttributes.recycle();
        }
        this.aiC = new a(getContext());
        this.aiD = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aiC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aiC, layoutParams);
        addView(this.aiD, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aiF = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aiH = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.aiC.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.aiF) {
            case 0:
                this.aiC.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aiC.setPadding(aiJ, aiJ, 0, 0);
                break;
        }
        switch (this.aiH) {
            case 1:
                this.aiC.setIsRound(true);
                if (this.aiF == 0) {
                    com.baidu.tbadk.core.util.as.c(this.aiD, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.as.c(this.aiD, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aiC.setIsRound(false);
                this.aiC.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.as.c(this.aiD, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aiC.setIsRound(true);
                com.baidu.tbadk.core.util.as.c(this.aiD, w.g.browser_null_drawable);
                return;
            default:
                this.aiC.setIsRound(false);
                this.aiC.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.as.c(this.aiD, w.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aiK != i) {
            this.aiK = i;
            this.aiC.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.aiF == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aiK, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aiK, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
