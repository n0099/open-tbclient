package com.baidu.pass.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.pass.R;
/* loaded from: classes4.dex */
public class MaxHeightScrollView extends ScrollView implements com.baidu.pass.a {
    private int a;

    public MaxHeightScrollView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sapi_sdk_max_height_scroll_view);
        this.a = obtainStyledAttributes.getLayoutDimension(R.styleable.sapi_sdk_max_height_scroll_view_sapi_sdk_max_height, this.a);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
