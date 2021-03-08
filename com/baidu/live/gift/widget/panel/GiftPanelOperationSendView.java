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
/* loaded from: classes10.dex */
public class GiftPanelOperationSendView extends TextView {
    private GradientDrawable bjx;
    private float bjy;
    private boolean bjz;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.bjz = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.bjz = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.bjz = false;
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
            if (!(z2 & true) && !this.bjz) {
                this.bjx.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.bjx.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.bjx.setCornerRadius(this.bjy);
            } else {
                this.bjx.setCornerRadii(new float[]{0.0f, 0.0f, this.bjy, this.bjy, this.bjy, this.bjy, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.bjx);
        }
    }

    private void init() {
        this.bjy = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
        this.bjx = new GradientDrawable();
        this.bjx.setShape(0);
        this.bjx.setCornerRadius(this.bjy);
        this.bjx.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.bjx.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.bjx.setColors(new int[]{-57498, -45747});
        }
        setBackgroundDrawable(this.bjx);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize26));
        setIncludeFontPadding(false);
    }
}
