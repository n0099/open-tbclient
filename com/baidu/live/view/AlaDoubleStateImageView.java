package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class AlaDoubleStateImageView extends ImageView {
    private int bhH;
    private int bhI;
    private boolean isSelected;

    public AlaDoubleStateImageView(Context context) {
        super(context);
        this.isSelected = false;
    }

    public AlaDoubleStateImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
    }

    public AlaDoubleStateImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
    }

    public void setImageSrc(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.bhH = i;
            this.bhI = i2;
            setImageResource(this.bhH);
        }
    }

    public void setSelect(boolean z) {
        this.isSelected = z;
        if (z) {
            if (this.bhI > 0) {
                setImageResource(this.bhI);
            }
        } else if (this.bhH > 0) {
            setImageResource(this.bhH);
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }
}
