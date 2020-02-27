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
    private GradientDrawable apk;
    private float apl;
    private boolean apm;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.apm = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.apm = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.apm = false;
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
            if (!(z2 & true) && !this.apm) {
                this.apk.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.apk.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.apk.setCornerRadius(this.apl);
            } else {
                this.apk.setCornerRadii(new float[]{0.0f, 0.0f, this.apl, this.apl, this.apl, this.apl, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.apk);
        }
    }

    private void init() {
        this.apl = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.apk = new GradientDrawable();
        this.apk.setShape(0);
        this.apk.setCornerRadius(this.apl);
        this.apk.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.apk.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.apk.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.apk);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
