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
    private GradientDrawable bee;
    private float bef;
    private boolean beh;
    private int mStyle;

    public GiftPanelOperationSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.beh = true;
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                this.beh = false;
            }
            setStyle(this.mStyle, true);
        } else {
            this.beh = false;
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
            if (!(z2 & true) && !this.beh) {
                this.bee.clearColorFilter();
                setTextColor(-1);
                setEnabled(true);
            } else {
                this.bee.setColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
                setTextColor(-2130706433);
                if (!z) {
                    setEnabled(false);
                }
            }
            if (!(z2 & true)) {
                this.bee.setCornerRadius(this.bef);
            } else {
                this.bee.setCornerRadii(new float[]{0.0f, 0.0f, this.bef, this.bef, this.bef, this.bef, 0.0f, 0.0f});
            }
            setBackgroundDrawable(this.bee);
        }
    }

    private void init() {
        this.bef = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
        this.bee = new GradientDrawable();
        this.bee.setShape(0);
        this.bee.setCornerRadius(this.bef);
        this.bee.setGradientType(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.bee.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            this.bee.setColors(new int[]{-49865, -40664});
        }
        setBackgroundDrawable(this.bee);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize26));
    }
}
