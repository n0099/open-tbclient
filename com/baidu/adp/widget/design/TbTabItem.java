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

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f2432e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable f2433f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2434g;

    public TbTabItem(Context context) {
        this(context, null);
    }

    @SuppressLint({"RestrictedApi", "PrivateResource"})
    public TbTabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.f2432e = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.f2433f = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f2434g = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
