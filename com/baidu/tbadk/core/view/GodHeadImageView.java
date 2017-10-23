package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int ajH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int ajI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int ajK = 7;
    private a ajB;
    private ImageView ajC;
    private int ajD;
    private int ajE;
    private int ajF;
    private int ajG;
    private int ajJ;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.ajD = 0;
        this.ajE = this.ajD;
        this.ajF = 1;
        this.ajG = this.ajF;
        this.ajJ = ajH;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajD = 0;
        this.ajE = this.ajD;
        this.ajF = 1;
        this.ajG = this.ajF;
        this.ajJ = ajH;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajD = 0;
        this.ajE = this.ajD;
        this.ajF = 1;
        this.ajG = this.ajF;
        this.ajJ = ajH;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.ajJ = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, ajH);
            this.ajG = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.ajF);
            this.ajE = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.ajD);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, ajK);
            obtainStyledAttributes.recycle();
        }
        this.ajB = new a(getContext());
        this.ajC = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ajB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ajB, layoutParams);
        addView(this.ajC, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ajE = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ajG = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.ajB.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.ajE) {
            case 0:
                this.ajB.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ajB.setPadding(ajI, ajI, 0, 0);
                break;
        }
        switch (this.ajG) {
            case 1:
                this.ajB.setIsRound(true);
                if (this.ajE == 0) {
                    aj.c(this.ajC, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.ajC, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ajB.setIsRound(false);
                this.ajB.setRadius(this.mRadius);
                aj.c(this.ajC, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.ajB.setIsRound(true);
                aj.c(this.ajC, d.g.browser_null_drawable);
                return;
            default:
                this.ajB.setIsRound(false);
                this.ajB.setRadius(this.mRadius);
                aj.c(this.ajC, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ajJ != i) {
            this.ajJ = i;
            this.ajB.invalidate();
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
            if (GodHeadImageView.this.ajE == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ajJ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ajJ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
