package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class FillParentWidthImageView extends ImageView {
    public FillParentWidthImageView(Context context) {
        super(context);
    }

    public FillParentWidthImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FillParentWidthImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Drawable drawable;
        int intrinsicWidth;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && layoutParams.width == -1 && layoutParams.height == -2 && getDrawable() != null && (intrinsicWidth = (drawable = getDrawable()).getIntrinsicWidth()) != 0) {
            int size = View.MeasureSpec.getSize(i);
            if (View.MeasureSpec.getMode(i) != 0 || size != 0) {
                setMeasuredDimension(size, (int) (size * (drawable.getIntrinsicHeight() / intrinsicWidth)));
                return;
            }
        }
        super.onMeasure(i, i2);
    }
}
