package com.baidu.live.im.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class ImBarrageItemGiftCountView extends TextView {
    public ImBarrageItemGiftCountView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds18));
        setBackgroundDrawable(gradientDrawable);
        setGravity(17);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize18));
        setIncludeFontPadding(false);
    }
}
