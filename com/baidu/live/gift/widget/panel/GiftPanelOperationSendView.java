package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable bjE;
    private float bjF;
    private boolean bjG;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.bjG = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bjG = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.bjG = false;
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
            if (!(z2 & true) && !this.bjG) {
                this.bjE.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.bjE.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.bjE.setCornerRadius(this.bjF);
            } else {
                this.bjE.setCornerRadii(new float[]{0.0f, 0.0f, this.bjF, this.bjF, this.bjF, this.bjF, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.bjE);
        }
    }

    private void init() {
        this.bjF = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
        this.bjE = new GradientDrawable();
        this.bjE.setShape(0);
        this.bjE.setCornerRadius(this.bjF);
        this.bjE.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.bjE.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.bjE.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.bjE);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize26));
        setIncludeFontPadding(false);
    }
}
