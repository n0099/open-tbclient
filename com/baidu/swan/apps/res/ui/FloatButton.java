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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        findViewById(a.f.float_imgview).setBottom(af.U(191.0f));
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(a.f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.cG(optString));
            ((Button) findViewById).setTextColor(SwanAppConfigData.cG("#FFFFFF"));
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
                this.bKT.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.bLa = x;
                    this.aDc = y;
                    this.bKY = true;
                    this.bKX = true;
                    postDelayed(this.bLb, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.bKX) {
                    if (this.bLc != null) {
                        this.bLc.onClick();
                    }
                    removeCallbacks(this.bLb);
                } else if (this.bKY && this.bLc != null) {
                    this.bLc.WG();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.bKX);
                }
                if (this.bKZ && !this.bKX && x >= 0.0f && x <= this.bKW && y >= 0.0f && y <= this.mParentHeight + this.bKV) {
                    this.bKT.animate().x(this.bKW - this.bKU).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.bKX = false;
                this.bKY = false;
                break;
            case 2:
                float abs = Math.abs(x - this.bLa);
                float abs2 = Math.abs(y - this.aDc);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.bKX = false;
                }
                o(x, y);
                break;
            case 3:
                this.bKX = false;
                this.bKY = false;
                break;
            case 4:
                this.bKX = false;
                this.bKY = false;
                break;
        }
        return this.bKX | this.bKY;
    }

    private void o(float f, float f2) {
        if (this.bKT != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.bKU / 2));
            int i2 = (int) (f2 - (this.bKV / 2));
            int i3 = this.bKW - this.bKU;
            int i4 = (this.mParentHeight - this.bKV) - 168;
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
            this.bKT.setX(i3);
            this.bKT.setY(i4);
            requestLayout();
        }
    }
}
