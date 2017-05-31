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
    private static final int aia = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
    private static final int aib = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
    private static int aid = 7;
    private a ahU;
    private ImageView ahV;
    private int ahW;
    private int ahX;
    private int ahY;
    private int ahZ;
    private int aic;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.ahW = 0;
        this.ahX = this.ahW;
        this.ahY = 1;
        this.ahZ = this.ahY;
        this.aic = aia;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahW = 0;
        this.ahX = this.ahW;
        this.ahY = 1;
        this.ahZ = this.ahY;
        this.aic = aia;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahW = 0;
        this.ahX = this.ahW;
        this.ahY = 1;
        this.ahZ = this.ahY;
        this.aic = aia;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.GodHeadImageView);
            this.aic = obtainStyledAttributes.getDimensionPixelSize(0, aia);
            this.ahZ = obtainStyledAttributes.getInteger(3, this.ahY);
            this.ahX = obtainStyledAttributes.getInteger(2, this.ahW);
            this.mRadius = obtainStyledAttributes.getInteger(1, aid);
            obtainStyledAttributes.recycle();
        }
        this.ahU = new a(getContext());
        this.ahV = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ahU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ahU, layoutParams);
        addView(this.ahV, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ahX = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ahZ = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.ahU.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.ahX) {
            case 0:
                this.ahU.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ahU.setPadding(aib, aib, 0, 0);
                break;
        }
        switch (this.ahZ) {
            case 1:
                this.ahU.setIsRound(true);
                if (this.ahX == 0) {
                    com.baidu.tbadk.core.util.aq.c(this.ahV, w.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.ahV, w.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ahU.setIsRound(false);
                this.ahU.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.ahV, w.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.ahU.setIsRound(true);
                com.baidu.tbadk.core.util.aq.c(this.ahV, w.g.browser_null_drawable);
                return;
            default:
                this.ahU.setIsRound(false);
                this.ahU.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.aq.c(this.ahV, w.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aic != i) {
            this.aic = i;
            this.ahU.invalidate();
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
            if (GodHeadImageView.this.ahX == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aic, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aic, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
