package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private static final int ado = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds6);
    private static final int adp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1);
    private static int adr = 7;
    private a adi;
    private ImageView adj;
    private int adk;
    private int adl;
    private int adm;
    private int adn;
    private int adq;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.adk = 0;
        this.adl = this.adk;
        this.adm = 1;
        this.adn = this.adm;
        this.adq = ado;
        this.mRadius = 7;
        b((AttributeSet) null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adk = 0;
        this.adl = this.adk;
        this.adm = 1;
        this.adn = this.adm;
        this.adq = ado;
        this.mRadius = 7;
        b(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adk = 0;
        this.adl = this.adk;
        this.adm = 1;
        this.adn = this.adm;
        this.adq = ado;
        this.mRadius = 7;
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.n.GodHeadImageView);
            this.adq = obtainStyledAttributes.getDimensionPixelSize(0, ado);
            this.adn = obtainStyledAttributes.getInteger(3, this.adm);
            this.adl = obtainStyledAttributes.getInteger(2, this.adk);
            this.mRadius = obtainStyledAttributes.getInteger(1, adr);
            obtainStyledAttributes.recycle();
        }
        this.adi = new a(getContext());
        this.adj = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.adi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.adi, layoutParams);
        addView(this.adj, new FrameLayout.LayoutParams(-1, -1));
        vN();
    }

    public void setShowType(int i) {
        this.adl = i;
        vN();
    }

    public void setShapeType(int i) {
        this.adn = i;
        vN();
    }

    public void c(String str, int i, boolean z) {
        this.adi.c(str, i, z);
    }

    private void vN() {
        switch (this.adl) {
            case 0:
                this.adi.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.adi.setPadding(adp, adp, 0, 0);
                break;
        }
        switch (this.adn) {
            case 1:
                this.adi.setIsRound(true);
                if (this.adl == 0) {
                    com.baidu.tbadk.core.util.ap.c(this.adj, r.g.pic_shen_avatar_big);
                    return;
                } else {
                    com.baidu.tbadk.core.util.ap.c(this.adj, r.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.adi.setIsRound(false);
                this.adi.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.ap.c(this.adj, r.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.adi.setIsRound(true);
                com.baidu.tbadk.core.util.ap.c(this.adj, r.g.browser_null_drawable);
                return;
            default:
                this.adi.setIsRound(false);
                this.adi.setRadius(this.mRadius);
                com.baidu.tbadk.core.util.ap.c(this.adj, r.g.pic_shen_avatar_square);
                return;
        }
    }

    public void vO() {
        vN();
    }

    public void setRadius(int i) {
        this.mRadius = i;
        vN();
    }

    public void setExtraPadding(int i) {
        if (this.adq != i) {
            this.adq = i;
            this.adi.invalidate();
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
            if (GodHeadImageView.this.adl == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.adq, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.adq, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
