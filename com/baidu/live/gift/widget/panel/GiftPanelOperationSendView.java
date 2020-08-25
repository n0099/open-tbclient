package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable aXa;
    private float aXb;
    private boolean aXc;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.aXc = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aXc = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.aXc = false;
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
            if (!(z2 & true) && !this.aXc) {
                this.aXa.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aXa.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.aXa.setCornerRadius(this.aXb);
            } else {
                this.aXa.setCornerRadii(new float[]{0.0f, 0.0f, this.aXb, this.aXb, this.aXb, this.aXb, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aXa);
        }
    }

    private void init() {
        this.aXb = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aXa = new GradientDrawable();
        this.aXa.setShape(0);
        this.aXa.setCornerRadius(this.aXb);
        this.aXa.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aXa.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aXa.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aXa);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
