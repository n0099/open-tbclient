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
    private GradientDrawable bfB;
    private float bfC;
    private boolean bfD;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.bfD = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bfD = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.bfD = false;
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
            if (!(z2 & true) && !this.bfD) {
                this.bfB.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.bfB.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.bfB.setCornerRadius(this.bfC);
            } else {
                this.bfB.setCornerRadii(new float[]{0.0f, 0.0f, this.bfC, this.bfC, this.bfC, this.bfC, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.bfB);
        }
    }

    private void init() {
        this.bfC = getResources().getDimensionPixelOffset(a.d.sdk_ds28);
        this.bfB = new GradientDrawable();
        this.bfB.setShape(0);
        this.bfB.setCornerRadius(this.bfC);
        this.bfB.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.bfB.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.bfB.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.bfB);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize26));
    }
}
