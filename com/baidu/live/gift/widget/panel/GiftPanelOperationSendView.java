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
/* loaded from: classes3.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable aQu;
    private float aQv;
    private boolean aQw;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.aQw = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.aQw = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.aQw = false;
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
            if (!(z2 & true) && !this.aQw) {
                this.aQu.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.aQu.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.aQu.setCornerRadius(this.aQv);
            } else {
                this.aQu.setCornerRadii(new float[]{0.0f, 0.0f, this.aQv, this.aQv, this.aQv, this.aQv, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.aQu);
        }
    }

    private void init() {
        this.aQv = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aQu = new GradientDrawable();
        this.aQu.setShape(0);
        this.aQu.setCornerRadius(this.aQv);
        this.aQu.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.aQu.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.aQu.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.aQu);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
