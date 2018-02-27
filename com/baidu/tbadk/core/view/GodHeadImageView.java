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
    private a bah;
    private ImageView bai;
    private int baj;
    private int bak;
    private int bal;
    private int bam;
    private int bao;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int ban = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.baj = 0;
        this.bak = this.baj;
        this.bal = 1;
        this.bam = this.bal;
        this.bao = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baj = 0;
        this.bak = this.baj;
        this.bal = 1;
        this.bam = this.bal;
        this.bao = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baj = 0;
        this.bak = this.baj;
        this.bal = 1;
        this.bam = this.bal;
        this.bao = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.bao = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.bam = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.bal);
            this.bak = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.baj);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.bah = new a(getContext());
        this.bai = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bah.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.bah, layoutParams);
        addView(this.bai, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.bak = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.bam = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.bah.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.bak) {
            case 0:
                this.bah.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.bah.setPadding(ban, ban, 0, 0);
                break;
        }
        switch (this.bam) {
            case 1:
                this.bah.setIsRound(true);
                if (this.bak == 0) {
                    aj.c(this.bai, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.bai, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.bah.setIsRound(false);
                this.bah.setRadius(this.mRadius);
                aj.c(this.bai, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.bah.setIsRound(true);
                aj.c(this.bai, d.f.browser_null_drawable);
                return;
            default:
                this.bah.setIsRound(false);
                this.bah.setRadius(this.mRadius);
                aj.c(this.bai, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.bao != i) {
            this.bao = i;
            this.bah.invalidate();
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
            if (GodHeadImageView.this.bak == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.bao, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.bao, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
