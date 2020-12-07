package com.baidu.live.yuyingift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable bhV;
    private float bhW;
    private boolean bhX;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.bhX = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bhX = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.bhX = false;
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
            if (!(z2 & true) && !this.bhX) {
                this.bhV.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.bhV.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.bhV.setCornerRadius(this.bhW);
            } else {
                this.bhV.setCornerRadii(new float[]{0.0f, 0.0f, this.bhW, this.bhW, this.bhW, this.bhW, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.bhV);
        }
    }

    private void init() {
        this.bhW = getResources().getDimensionPixelOffset(a.d.sdk_ds28);
        this.bhV = new GradientDrawable();
        this.bhV.setShape(0);
        this.bhV.setCornerRadius(this.bhW);
        this.bhV.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.bhV.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.bhV.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.bhV);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize26));
    }
}
