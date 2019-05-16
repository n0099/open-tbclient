package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FloatButton extends FullScreenFloatView {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public FloatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setFloatButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            View findViewById = findViewById(a.f.float_imgview);
            if (findViewById instanceof Button) {
                findViewById.setBackground(drawable);
            }
        }
    }

    public void setFloatButtonDefaultPosition() {
        findViewById(a.f.float_imgview).setBottom(z.af(191.0f));
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(a.f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(com.baidu.swan.apps.ae.a.c.parseColor(optString));
            ((Button) findViewById).setTextColor(com.baidu.swan.apps.ae.a.c.parseColor("#FFFFFF"));
            findViewById.setAlpha((float) 0.8999999761581421d);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        switch (motionEvent.getAction()) {
            case 0:
                this.aIQ.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aIX = x;
                    this.aIY = y;
                    this.aIV = true;
                    this.aIU = true;
                    postDelayed(this.aIZ, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aIU) {
                    if (this.aJa != null) {
                        this.aJa.onClick();
                    }
                    removeCallbacks(this.aIZ);
                } else if (this.aIV && this.aJa != null) {
                    this.aJa.FL();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aIU);
                }
                if (this.aIW && !this.aIU && x >= 0.0f && x <= this.aIT && y >= 0.0f && y <= this.mParentHeight + this.aIS) {
                    this.aIQ.animate().x(this.aIT - this.aIR).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.aIU = false;
                this.aIV = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aIX);
                float abs2 = Math.abs(y - this.aIY);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aIU = false;
                }
                p(x, y);
                break;
            case 3:
                this.aIU = false;
                this.aIV = false;
                break;
            case 4:
                this.aIU = false;
                this.aIV = false;
                break;
        }
        return this.aIU | this.aIV;
    }

    private void p(float f, float f2) {
        if (this.aIQ != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aIR / 2));
            int i2 = (int) (f2 - (this.aIS / 2));
            int i3 = this.aIT - this.aIR;
            int i4 = (this.mParentHeight - this.aIS) - 168;
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 288) {
                i2 = 288;
            }
            if (i <= i3) {
                i3 = i;
            }
            if (i2 <= i4) {
                i4 = i2;
            }
            if (DEBUG) {
                Log.e("FloatButton", "move--> left = 0, top = 288, mStatusBarHeight = " + this.mStatusBarHeight);
            }
            this.aIQ.setX(i3);
            this.aIQ.setY(i4);
            requestLayout();
        }
    }
}
