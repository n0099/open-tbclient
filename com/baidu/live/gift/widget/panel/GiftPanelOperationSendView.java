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
    private GradientDrawable aeD;
    private float aeE;
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
                this.aeD.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aeD.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                setEnabled(false);
            }
            if (!(z & true)) {
                this.aeD.setCornerRadius(this.aeE);
            } else {
                this.aeD.setCornerRadii(new float[]{0.0f, 0.0f, this.aeE, this.aeE, this.aeE, this.aeE, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aeD);
        }
    }

    private void init() {
        this.aeE = getResources().getDimensionPixelOffset(a.e.sdk_ds28);
        this.aeD = new GradientDrawable();
        this.aeD.setShape(0);
        this.aeD.setCornerRadius(this.aeE);
        this.aeD.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aeD.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aeD.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aeD);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize24));
    }
}
