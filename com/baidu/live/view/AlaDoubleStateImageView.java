package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class AlaDoubleStateImageView extends ImageView {
    private int bsN;
    private int bsO;
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
            this.bsN = i;
            this.bsO = i2;
            setImageResource(this.bsN);
        }
    }

    public void setSelect(boolean z) {
        this.isSelected = z;
        if (z) {
            if (this.bsO > 0) {
                setImageResource(this.bsO);
            }
        } else if (this.bsN > 0) {
            setImageResource(this.bsN);
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }
}
