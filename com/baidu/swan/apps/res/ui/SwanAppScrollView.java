package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.ext.widget.dialog.BoxScrollView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.vm1;
/* loaded from: classes4.dex */
public class SwanAppScrollView extends ScrollView {
    public static final boolean b = vm1.a;
    public int a;

    public SwanAppScrollView(Context context) {
        super(context);
        this.a = -1;
    }

    public void setMaxHeight(int i) {
        this.a = i;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
    }

    public SwanAppScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
    }

    private int getLimitHeight() {
        int i = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012e);
        return ((i - (dimensionPixelSize * 2)) - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070132)) - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012a);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (b) {
            Log.d(BoxScrollView.TAG, "onLayout( " + z + StringUtil.ARRAY_ELEMENT_SEPARATOR + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (b) {
            Log.d(BoxScrollView.TAG, "onMeasure( " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int i3 = this.a;
        if (i3 > 0) {
            size = Math.min(size, i3);
        }
        measureChildren(i, i2);
        int measuredHeight = getChildAt(0).getMeasuredHeight();
        int measuredWidth = getChildAt(0).getMeasuredWidth();
        if (measuredHeight > 0) {
            size = Math.min(measuredHeight, size);
        }
        if (measuredWidth > 0) {
            size2 = Math.min(measuredWidth, size2);
        }
        if (getLimitHeight() < size) {
            size = getLimitHeight();
        }
        setMeasuredDimension(size2, size);
    }
}
