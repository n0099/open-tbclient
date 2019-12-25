package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable amk;
    private float aml;
    private boolean amm;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.amm = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.amm = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.amm = false;
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
            if (!(z2 & true) && !this.amm) {
                this.amk.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.amk.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.amk.setCornerRadius(this.aml);
            } else {
                this.amk.setCornerRadii(new float[]{0.0f, 0.0f, this.aml, this.aml, this.aml, this.aml, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.amk);
        }
    }

    private void init() {
        this.aml = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.amk = new GradientDrawable();
        this.amk.setShape(0);
        this.amk.setCornerRadius(this.aml);
        this.amk.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.amk.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.amk.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.amk);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
