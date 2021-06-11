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
    public final CharSequence f2442e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable f2443f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2444g;

    public TbTabItem(Context context) {
        this(context, null);
    }

    @SuppressLint({"RestrictedApi", "PrivateResource"})
    public TbTabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.f2442e = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.f2443f = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f2444g = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
