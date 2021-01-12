package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class AlaDoubleStateImageView extends ImageView {
    private int bOM;
    private int bON;
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
            this.bOM = i;
            this.bON = i2;
            setImageResource(this.bOM);
        }
    }

    public void setSelect(boolean z) {
        this.isSelected = z;
        if (z) {
            if (this.bON > 0) {
                setImageResource(this.bON);
            }
        } else if (this.bOM > 0) {
            setImageResource(this.bOM);
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.isSelected;
    }
}
