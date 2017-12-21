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
    private int akA;
    private a akt;
    private ImageView aku;
    private int akv;
    private int akw;
    private int akx;
    private int aky;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int akz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akA = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akA = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akA = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.akA = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.aky = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.akx);
            this.akw = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.akv);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.akt = new a(getContext());
        this.aku = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.akt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.akt, layoutParams);
        addView(this.aku, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.akw = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aky = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.akt.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.akw) {
            case 0:
                this.akt.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.akt.setPadding(akz, akz, 0, 0);
                break;
        }
        switch (this.aky) {
            case 1:
                this.akt.setIsRound(true);
                if (this.akw == 0) {
                    aj.c(this.aku, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.aku, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.akt.setIsRound(false);
                this.akt.setRadius(this.mRadius);
                aj.c(this.aku, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.akt.setIsRound(true);
                aj.c(this.aku, d.f.browser_null_drawable);
                return;
            default:
                this.akt.setIsRound(false);
                this.akt.setRadius(this.mRadius);
                aj.c(this.aku, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.akA != i) {
            this.akA = i;
            this.akt.invalidate();
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
            if (GodHeadImageView.this.akw == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.akA, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.akA, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
