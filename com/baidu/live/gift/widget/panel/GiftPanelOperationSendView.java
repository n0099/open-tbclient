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
    private GradientDrawable aNO;
    private float aNP;
    private boolean aNQ;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.aNQ = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aNQ = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.aNQ = false;
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
            if (!(z2 & true) && !this.aNQ) {
                this.aNO.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aNO.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.aNO.setCornerRadius(this.aNP);
            } else {
                this.aNO.setCornerRadii(new float[]{0.0f, 0.0f, this.aNP, this.aNP, this.aNP, this.aNP, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aNO);
        }
    }

    private void init() {
        this.aNP = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aNO = new GradientDrawable();
        this.aNO.setShape(0);
        this.aNO.setCornerRadius(this.aNP);
        this.aNO.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aNO.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aNO.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aNO);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
