package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable ael;
    private float aem;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        boolean z;
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 2:
                    z = true;
                    break;
                case 3:
                    z = true;
                    break;
                case 4:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!(z & true)) {
                this.ael.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.ael.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                setEnabled(false);
            }
            if (!(z & true)) {
                this.ael.setCornerRadius(this.aem);
            } else {
                this.ael.setCornerRadii(new float[]{0.0f, 0.0f, this.aem, this.aem, this.aem, this.aem, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.ael);
        }
    }

    private void init() {
        this.aem = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
        this.ael = new GradientDrawable();
        this.ael.setShape(0);
        this.ael.setCornerRadius(this.aem);
        this.ael.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.ael.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.ael.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.ael);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize24));
    }
}
