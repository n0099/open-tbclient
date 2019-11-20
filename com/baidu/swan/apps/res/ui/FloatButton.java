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
        findViewById(a.f.float_imgview).setBottom(z.U(191.0f));
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(a.f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(com.baidu.swan.apps.ae.a.c.bR(optString));
            ((Button) findViewById).setTextColor(com.baidu.swan.apps.ae.a.c.bR("#FFFFFF"));
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
                this.bcS.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bcZ = x;
                    this.aqo = y;
                    this.bcX = true;
                    this.bcW = true;
                    postDelayed(this.bda, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bcW) {
                    if (this.bdb != null) {
                        this.bdb.onClick();
                    }
                    removeCallbacks(this.bda);
                } else if (this.bcX && this.bdb != null) {
                    this.bdb.Lu();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bcW);
                }
                if (this.bcY && !this.bcW && x >= 0.0f && x <= this.bcV && y >= 0.0f && y <= this.mParentHeight + this.bcU) {
                    this.bcS.animate().x(this.bcV - this.bcT).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.bcW = false;
                this.bcX = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bcZ);
                float abs2 = Math.abs(y - this.aqo);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bcW = false;
                }
                o(x, y);
                break;
            case 3:
                this.bcW = false;
                this.bcX = false;
                break;
            case 4:
                this.bcW = false;
                this.bcX = false;
                break;
        }
        return this.bcW | this.bcX;
    }

    private void o(float f, float f2) {
        if (this.bcS != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bcT / 2));
            int i2 = (int) (f2 - (this.bcU / 2));
            int i3 = this.bcV - this.bcT;
            int i4 = (this.mParentHeight - this.bcU) - 168;
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
            this.bcS.setX(i3);
            this.bcS.setY(i4);
            requestLayout();
        }
    }
}
