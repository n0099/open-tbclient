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
    private static final int ajT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int ajU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int ajW = 7;
    private a ajN;
    private ImageView ajO;
    private int ajP;
    private int ajQ;
    private int ajR;
    private int ajS;
    private int ajV;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.ajP = 0;
        this.ajQ = this.ajP;
        this.ajR = 1;
        this.ajS = this.ajR;
        this.ajV = ajT;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajP = 0;
        this.ajQ = this.ajP;
        this.ajR = 1;
        this.ajS = this.ajR;
        this.ajV = ajT;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajP = 0;
        this.ajQ = this.ajP;
        this.ajR = 1;
        this.ajS = this.ajR;
        this.ajV = ajT;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.ajV = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, ajT);
            this.ajS = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.ajR);
            this.ajQ = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.ajP);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, ajW);
            obtainStyledAttributes.recycle();
        }
        this.ajN = new a(getContext());
        this.ajO = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ajN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ajN, layoutParams);
        addView(this.ajO, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ajQ = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ajS = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.ajN.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.ajQ) {
            case 0:
                this.ajN.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ajN.setPadding(ajU, ajU, 0, 0);
                break;
        }
        switch (this.ajS) {
            case 1:
                this.ajN.setIsRound(true);
                if (this.ajQ == 0) {
                    aj.c(this.ajO, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.ajO, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ajN.setIsRound(false);
                this.ajN.setRadius(this.mRadius);
                aj.c(this.ajO, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.ajN.setIsRound(true);
                aj.c(this.ajO, d.g.browser_null_drawable);
                return;
            default:
                this.ajN.setIsRound(false);
                this.ajN.setRadius(this.mRadius);
                aj.c(this.ajO, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ajV != i) {
            this.ajV = i;
            this.ajN.invalidate();
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
            if (GodHeadImageView.this.ajQ == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ajV, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ajV, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
