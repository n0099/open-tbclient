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
            ((GradientDrawable) findViewById.getBackground()).setColor(com.baidu.swan.apps.ae.a.c.cE(optString));
            ((Button) findViewById).setTextColor(com.baidu.swan.apps.ae.a.c.cE("#FFFFFF"));
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
                this.aJW.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aKd = x;
                    this.aKe = y;
                    this.aKb = true;
                    this.aKa = true;
                    postDelayed(this.aKf, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aKa) {
                    if (this.aKg != null) {
                        this.aKg.onClick();
                    }
                    removeCallbacks(this.aKf);
                } else if (this.aKb && this.aKg != null) {
                    this.aKg.Gz();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aKa);
                }
                if (this.aKc && !this.aKa && x >= 0.0f && x <= this.aJZ && y >= 0.0f && y <= this.mParentHeight + this.aJY) {
                    this.aJW.animate().x(this.aJZ - this.aJX).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.aKa = false;
                this.aKb = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aKd);
                float abs2 = Math.abs(y - this.aKe);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aKa = false;
                }
                p(x, y);
                break;
            case 3:
                this.aKa = false;
                this.aKb = false;
                break;
            case 4:
                this.aKa = false;
                this.aKb = false;
                break;
        }
        return this.aKa | this.aKb;
    }

    private void p(float f, float f2) {
        if (this.aJW != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aJX / 2));
            int i2 = (int) (f2 - (this.aJY / 2));
            int i3 = this.aJZ - this.aJX;
            int i4 = (this.mParentHeight - this.aJY) - 168;
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
            this.aJW.setX(i3);
            this.aJW.setY(i4);
            requestLayout();
        }
    }
}
