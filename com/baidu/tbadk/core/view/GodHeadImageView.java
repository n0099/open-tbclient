package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int aem = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
    private static final int aen = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
    private static int aep = 7;
    private a aeg;
    private ImageView aeh;
    private int aei;
    private int aej;
    private int aek;
    private int ael;
    private int aeo;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aei = 0;
        this.aej = this.aei;
        this.aek = 1;
        this.ael = this.aek;
        this.aeo = aem;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aei = 0;
        this.aej = this.aei;
        this.aek = 1;
        this.ael = this.aek;
        this.aeo = aem;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aei = 0;
        this.aej = this.aei;
        this.aek = 1;
        this.ael = this.aek;
        this.aeo = aem;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.l.GodHeadImageView);
            this.aeo = obtainStyledAttributes.getDimensionPixelSize(0, aem);
            this.ael = obtainStyledAttributes.getInteger(3, this.aek);
            this.aej = obtainStyledAttributes.getInteger(2, this.aei);
            this.mRadius = obtainStyledAttributes.getInteger(1, aep);
            obtainStyledAttributes.recycle();
        }
        this.aeg = new a(getContext());
        this.aeh = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aeg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aeg, layoutParams);
        addView(this.aeh, new FrameLayout.LayoutParams(-1, -1));
        wf();
    }

    public void setShowType(int i) {
        this.aej = i;
        wf();
    }

    public void setShapeType(int i) {
        this.ael = i;
        wf();
    }

    public void c(String str, int i, boolean z) {
        this.aeg.c(str, i, z);
    }

    private void wf() {
        switch (this.aej) {
            case 0:
                this.aeg.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aeg.setPadding(aen, aen, 0, 0);
                break;
        }
        switch (this.ael) {
            case 1:
                this.aeg.setIsRound(true);
                if (this.aej == 0) {
                    av.c(this.aeh, r.f.pic_shen_avatar_big);
                    return;
                } else {
                    av.c(this.aeh, r.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aeg.setIsRound(false);
                this.aeg.setRadius(this.mRadius);
                av.c(this.aeh, r.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.aeg.setIsRound(true);
                av.c(this.aeh, r.f.browser_null_drawable);
                return;
            default:
                this.aeg.setIsRound(false);
                this.aeg.setRadius(this.mRadius);
                av.c(this.aeh, r.f.pic_shen_avatar_square);
                return;
        }
    }

    public void wg() {
        wf();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        wf();
    }

    public void setExtraPadding(int i) {
        if (this.aeo != i) {
            this.aeo = i;
            this.aeg.invalidate();
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
            if (GodHeadImageView.this.aej == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aeo, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aeo, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
