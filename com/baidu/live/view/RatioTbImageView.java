package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class RatioTbImageView extends TbImageView {
    private float asp;

    public RatioTbImageView(Context context) {
        super(context);
        this.asp = 1.7777778f;
    }

    public RatioTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.asp = 1.7777778f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_MHRatioTbImageView);
        this.asp = obtainStyledAttributes.getFloat(a.k.sdk_MHRatioTbImageView_sdk_wh_ratio, 1.7777778f);
        obtainStyledAttributes.recycle();
    }

    public RatioTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asp = 1.7777778f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_MHRatioTbImageView);
        this.asp = obtainStyledAttributes.getFloat(a.k.sdk_MHRatioTbImageView_sdk_wh_ratio, 1.7777778f);
        obtainStyledAttributes.recycle();
    }

    public void setWidthHeightRatio(float f) {
        this.asp = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) ((size / this.asp) + 0.5f), 1073741824));
    }
}
