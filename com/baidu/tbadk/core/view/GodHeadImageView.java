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
    private static final int ajS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int ajT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int ajV = 7;
    private a ajM;
    private ImageView ajN;
    private int ajO;
    private int ajP;
    private int ajQ;
    private int ajR;
    private int ajU;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.ajO = 0;
        this.ajP = this.ajO;
        this.ajQ = 1;
        this.ajR = this.ajQ;
        this.ajU = ajS;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajO = 0;
        this.ajP = this.ajO;
        this.ajQ = 1;
        this.ajR = this.ajQ;
        this.ajU = ajS;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajO = 0;
        this.ajP = this.ajO;
        this.ajQ = 1;
        this.ajR = this.ajQ;
        this.ajU = ajS;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.ajU = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, ajS);
            this.ajR = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.ajQ);
            this.ajP = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.ajO);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, ajV);
            obtainStyledAttributes.recycle();
        }
        this.ajM = new a(getContext());
        this.ajN = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ajM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ajM, layoutParams);
        addView(this.ajN, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ajP = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ajR = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.ajM.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.ajP) {
            case 0:
                this.ajM.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ajM.setPadding(ajT, ajT, 0, 0);
                break;
        }
        switch (this.ajR) {
            case 1:
                this.ajM.setIsRound(true);
                if (this.ajP == 0) {
                    aj.c(this.ajN, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.ajN, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ajM.setIsRound(false);
                this.ajM.setRadius(this.mRadius);
                aj.c(this.ajN, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.ajM.setIsRound(true);
                aj.c(this.ajN, d.g.browser_null_drawable);
                return;
            default:
                this.ajM.setIsRound(false);
                this.ajM.setRadius(this.mRadius);
                aj.c(this.ajN, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ajU != i) {
            this.ajU = i;
            this.ajM.invalidate();
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
            if (GodHeadImageView.this.ajP == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ajU, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ajU, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
