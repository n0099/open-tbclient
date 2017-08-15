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
    private int akB;
    private a akt;
    private ImageView aku;
    private int akv;
    private int akw;
    private int akx;
    private int aky;
    private int mRadius;
    private static final int akz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int akA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int akC = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akB = akz;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akB = akz;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akv = 0;
        this.akw = this.akv;
        this.akx = 1;
        this.aky = this.akx;
        this.akB = akz;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.akB = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, akz);
            this.aky = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.akx);
            this.akw = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.akv);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, akC);
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

    public void c(String str, int i, boolean z) {
        this.akt.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.akw) {
            case 0:
                this.akt.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.akt.setPadding(akA, akA, 0, 0);
                break;
        }
        switch (this.aky) {
            case 1:
                this.akt.setIsRound(true);
                if (this.akw == 0) {
                    ai.c(this.aku, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    ai.c(this.aku, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.akt.setIsRound(false);
                this.akt.setRadius(this.mRadius);
                ai.c(this.aku, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.akt.setIsRound(true);
                ai.c(this.aku, d.g.browser_null_drawable);
                return;
            default:
                this.akt.setIsRound(false);
                this.akt.setRadius(this.mRadius);
                ai.c(this.aku, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.akB != i) {
            this.akB = i;
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
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.akB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.akB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
