package com.baidu.adp.widget.design;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
/* loaded from: classes.dex */
public final class TbTabItem extends View {
    final int YI;
    final Drawable mIcon;
    final CharSequence mText;

    public TbTabItem(Context context) {
        this(context, null);
    }

    @SuppressLint({"RestrictedApi", "PrivateResource"})
    public TbTabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.mText = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.mIcon = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.YI = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
