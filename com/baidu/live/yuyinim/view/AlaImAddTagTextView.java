package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class AlaImAddTagTextView extends TextView {
    public AlaImAddTagTextView(Context context) {
        this(context, null);
    }

    public AlaImAddTagTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaImAddTagTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setText(a.i.ala_im_add_tag);
        setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        setTextSize(14.0f);
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.icon_arrow12_white_right), (Drawable) null);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_tbds20);
        setIncludeFontPadding(false);
        setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        setBackgroundResource(a.f.bg_add_tag);
    }
}
