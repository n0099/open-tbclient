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
/* loaded from: classes4.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable aZw;
    private float aZx;
    private boolean aZy;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.aZy = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aZy = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.aZy = false;
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
            if (!(z2 & true) && !this.aZy) {
                this.aZw.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aZw.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.aZw.setCornerRadius(this.aZx);
            } else {
                this.aZw.setCornerRadii(new float[]{0.0f, 0.0f, this.aZx, this.aZx, this.aZx, this.aZx, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aZw);
        }
    }

    private void init() {
        this.aZx = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aZw = new GradientDrawable();
        this.aZw.setShape(0);
        this.aZw.setCornerRadius(this.aZx);
        this.aZw.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aZw.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aZw.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aZw);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
