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
    private static final int aiD = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aiE = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int aiG = 7;
    private int aiA;
    private int aiB;
    private int aiC;
    private int aiF;
    private a aix;
    private ImageView aiy;
    private int aiz;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aiz = 0;
        this.aiA = this.aiz;
        this.aiB = 1;
        this.aiC = this.aiB;
        this.aiF = aiD;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiz = 0;
        this.aiA = this.aiz;
        this.aiB = 1;
        this.aiC = this.aiB;
        this.aiF = aiD;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiz = 0;
        this.aiA = this.aiz;
        this.aiB = 1;
        this.aiC = this.aiB;
        this.aiF = aiD;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.aiF = obtainStyledAttributes.getDimensionPixelSize(0, aiD);
            this.aiC = obtainStyledAttributes.getInteger(3, this.aiB);
            this.aiA = obtainStyledAttributes.getInteger(2, this.aiz);
            this.mRadius = obtainStyledAttributes.getInteger(1, aiG);
            obtainStyledAttributes.recycle();
        }
        this.aix = new a(getContext());
        this.aiy = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aix.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aix, layoutParams);
        addView(this.aiy, new FrameLayout.LayoutParams(-1, -1));
        wk();
    }

    public void setShowType(int i) {
        this.aiA = i;
        wk();
    }

    public void setShapeType(int i) {
        this.aiC = i;
        wk();
    }

    public void c(String str, int i, boolean z) {
        this.aix.c(str, i, z);
    }

    private void wk() {
        switch (this.aiA) {
            case 0:
                this.aix.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aix.setPadding(aiE, aiE, 0, 0);
                break;
        }
        switch (this.aiC) {
            case 1:
                this.aix.setIsRound(true);
                if (this.aiA == 0) {
                    com.baidu.tbadk.core.util.aq.c(this.aiy, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.aiy, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aix.setIsRound(false);
                this.aix.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiy, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aix.setIsRound(true);
                com.baidu.tbadk.core.util.aq.c(this.aiy, w.g.browser_null_drawable);
                return;
            default:
                this.aix.setIsRound(false);
                this.aix.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.aiy, w.g.pic_shen_avatar_square);
                return;
        }
    }

    public void wl() {
        wk();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        wk();
    }

    public void setExtraPadding(int i) {
        if (this.aiF != i) {
            this.aiF = i;
            this.aix.invalidate();
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
            if (GodHeadImageView.this.aiA == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aiF, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aiF, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
