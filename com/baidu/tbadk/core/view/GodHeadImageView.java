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
    private int baB;
    private a bau;
    private ImageView bav;
    private int baw;
    private int bax;
    private int bay;
    private int baz;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int baA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.baw = 0;
        this.bax = this.baw;
        this.bay = 1;
        this.baz = this.bay;
        this.baB = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baw = 0;
        this.bax = this.baw;
        this.bay = 1;
        this.baz = this.bay;
        this.baB = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baw = 0;
        this.bax = this.baw;
        this.bay = 1;
        this.baz = this.bay;
        this.baB = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.baB = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.baz = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.bay);
            this.bax = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.baw);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.bau = new a(getContext());
        this.bav = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.bau.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.bau, layoutParams);
        addView(this.bav, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.bax = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.baz = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.bau.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.bax) {
            case 0:
                this.bau.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.bau.setPadding(baA, baA, 0, 0);
                break;
        }
        switch (this.baz) {
            case 1:
                this.bau.setIsRound(true);
                if (this.bax == 0) {
                    aj.c(this.bav, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.bav, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.bau.setIsRound(false);
                this.bau.setRadius(this.mRadius);
                aj.c(this.bav, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.bau.setIsRound(true);
                aj.c(this.bav, d.f.browser_null_drawable);
                return;
            default:
                this.bau.setIsRound(false);
                this.bau.setRadius(this.mRadius);
                aj.c(this.bav, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.baB != i) {
            this.baB = i;
            this.bau.invalidate();
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
            if (GodHeadImageView.this.bax == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.baB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.baB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
