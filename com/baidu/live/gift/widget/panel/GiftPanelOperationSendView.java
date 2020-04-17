package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable aHZ;
    private float aIa;
    private boolean aIb;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.aIb = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aIb = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.aIb = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setStyle(int i) {
        setStyle(i, false);
    }

    public void setStyle(int i, boolean z) {
        boolean z2;
        if (this.mStyle != i || z) {
            this.mStyle = i;
            switch (i) {
                case 2:
                    z2 = true;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
            if (!(z2 & true) && !this.aIb) {
                this.aHZ.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aHZ.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.aHZ.setCornerRadius(this.aIa);
            } else {
                this.aHZ.setCornerRadii(new float[]{0.0f, 0.0f, this.aIa, this.aIa, this.aIa, this.aIa, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aHZ);
        }
    }

    private void init() {
        this.aIa = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aHZ = new GradientDrawable();
        this.aHZ.setShape(0);
        this.aHZ.setCornerRadius(this.aIa);
        this.aHZ.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aHZ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aHZ.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aHZ);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
