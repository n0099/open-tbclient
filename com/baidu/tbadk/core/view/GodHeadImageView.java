package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private a akr;
    private ImageView aks;
    private int akt;
    private int aku;
    private int akv;
    private int akw;
    private int akz;
    private int mRadius;
    private static final int akx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int aky = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int akA = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.akt = 0;
        this.aku = this.akt;
        this.akv = 1;
        this.akw = this.akv;
        this.akz = akx;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akt = 0;
        this.aku = this.akt;
        this.akv = 1;
        this.akw = this.akv;
        this.akz = akx;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akt = 0;
        this.aku = this.akt;
        this.akv = 1;
        this.akw = this.akv;
        this.akz = akx;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.akz = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, akx);
            this.akw = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.akv);
            this.aku = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.akt);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, akA);
            obtainStyledAttributes.recycle();
        }
        this.akr = new a(getContext());
        this.aks = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.akr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.akr, layoutParams);
        addView(this.aks, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aku = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.akw = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.akr.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.aku) {
            case 0:
                this.akr.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.akr.setPadding(aky, aky, 0, 0);
                break;
        }
        switch (this.akw) {
            case 1:
                this.akr.setIsRound(true);
                if (this.aku == 0) {
                    ai.c(this.aks, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    ai.c(this.aks, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.akr.setIsRound(false);
                this.akr.setRadius(this.mRadius);
                ai.c(this.aks, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.akr.setIsRound(true);
                ai.c(this.aks, d.g.browser_null_drawable);
                return;
            default:
                this.akr.setIsRound(false);
                this.akr.setRadius(this.mRadius);
                ai.c(this.aks, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.akz != i) {
            this.akz = i;
            this.akr.invalidate();
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
            if (GodHeadImageView.this.aku == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.akz, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.akz, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
