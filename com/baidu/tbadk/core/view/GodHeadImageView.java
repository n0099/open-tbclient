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
    private a baj;
    private ImageView bak;
    private int bal;
    private int bam;
    private int ban;
    private int bao;
    private int baq;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int bap = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.bal = 0;
        this.bam = this.bal;
        this.ban = 1;
        this.bao = this.ban;
        this.baq = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bal = 0;
        this.bam = this.bal;
        this.ban = 1;
        this.bao = this.ban;
        this.baq = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bal = 0;
        this.bam = this.bal;
        this.ban = 1;
        this.bao = this.ban;
        this.baq = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.baq = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.bao = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.ban);
            this.bam = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.bal);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.baj = new a(getContext());
        this.bak = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.baj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.baj, layoutParams);
        addView(this.bak, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.bam = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.bao = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.baj.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.bam) {
            case 0:
                this.baj.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.baj.setPadding(bap, bap, 0, 0);
                break;
        }
        switch (this.bao) {
            case 1:
                this.baj.setIsRound(true);
                if (this.bam == 0) {
                    aj.c(this.bak, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.bak, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.baj.setIsRound(false);
                this.baj.setRadius(this.mRadius);
                aj.c(this.bak, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.baj.setIsRound(true);
                aj.c(this.bak, d.f.browser_null_drawable);
                return;
            default:
                this.baj.setIsRound(false);
                this.baj.setRadius(this.mRadius);
                aj.c(this.bak, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.baq != i) {
            this.baq = i;
            this.baj.invalidate();
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
            if (GodHeadImageView.this.bam == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.baq, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.baq, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
