package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class RatioTbImageView extends TbImageView {
    private float bKq;

    public RatioTbImageView(Context context) {
        super(context);
        this.bKq = 1.7777778f;
    }

    public RatioTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKq = 1.7777778f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_MHRatioTbImageView);
        this.bKq = obtainStyledAttributes.getFloat(a.j.sdk_MHRatioTbImageView_sdk_wh_ratio, 1.7777778f);
        obtainStyledAttributes.recycle();
    }

    public RatioTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKq = 1.7777778f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_MHRatioTbImageView);
        this.bKq = obtainStyledAttributes.getFloat(a.j.sdk_MHRatioTbImageView_sdk_wh_ratio, 1.7777778f);
        obtainStyledAttributes.recycle();
    }

    public void setWidthHeightRatio(float f) {
        this.bKq = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) ((size / this.bKq) + 0.5f), 1073741824));
    }
}
