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
    private static final int aje = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
    private static final int ajf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
    private static int ajh = 7;
    private a aiY;
    private ImageView aiZ;
    private int aja;
    private int ajb;
    private int ajc;
    private int ajd;
    private int ajg;
    private int mRadius;

    public GodHeadImageView(Context context) {
        super(context);
        this.aja = 0;
        this.ajb = this.aja;
        this.ajc = 1;
        this.ajd = this.ajc;
        this.ajg = aje;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aja = 0;
        this.ajb = this.aja;
        this.ajc = 1;
        this.ajd = this.ajc;
        this.ajg = aje;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aja = 0;
        this.ajb = this.aja;
        this.ajc = 1;
        this.ajd = this.ajc;
        this.ajg = aje;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.n.GodHeadImageView);
            this.ajg = obtainStyledAttributes.getDimensionPixelSize(d.n.GodHeadImageView_extra_padding, aje);
            this.ajd = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_shape_type, this.ajc);
            this.ajb = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_show_type, this.aja);
            this.mRadius = obtainStyledAttributes.getInteger(d.n.GodHeadImageView_extra_radius, ajh);
            obtainStyledAttributes.recycle();
        }
        this.aiY = new a(getContext());
        this.aiZ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aiY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aiY, layoutParams);
        addView(this.aiZ, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ajb = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ajd = i;
        refreshUI();
    }

    public void c(String str, int i, boolean z) {
        this.aiY.c(str, i, z);
    }

    private void refreshUI() {
        switch (this.ajb) {
            case 0:
                this.aiY.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aiY.setPadding(ajf, ajf, 0, 0);
                break;
        }
        switch (this.ajd) {
            case 1:
                this.aiY.setIsRound(true);
                if (this.ajb == 0) {
                    ai.c(this.aiZ, d.g.pic_shen_avatar_big);
                    return;
                } else {
                    ai.c(this.aiZ, d.g.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aiY.setIsRound(false);
                this.aiY.setRadius(this.mRadius);
                ai.c(this.aiZ, d.g.pic_frs_shen_avatar);
                return;
            case 3:
                this.aiY.setIsRound(true);
                ai.c(this.aiZ, d.g.browser_null_drawable);
                return;
            default:
                this.aiY.setIsRound(false);
                this.aiY.setRadius(this.mRadius);
                ai.c(this.aiZ, d.g.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ajg != i) {
            this.ajg = i;
            this.aiY.invalidate();
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
            if (GodHeadImageView.this.ajb == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ajg, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ajg, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
