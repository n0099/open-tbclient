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
                this.aJy.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.aJF = x;
                    this.aJG = y;
                    this.aJD = true;
                    this.aJC = true;
                    postDelayed(this.aJH, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.aJC) {
                    if (this.aJI != null) {
                        this.aJI.onClick();
                    }
                    removeCallbacks(this.aJH);
                } else if (this.aJD && this.aJI != null) {
                    this.aJI.Gv();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.aJC);
                }
                if (this.aJE && !this.aJC && x >= 0.0f && x <= this.aJB && y >= 0.0f && y <= this.mParentHeight + this.aJA) {
                    this.aJy.animate().x(this.aJB - this.aJz).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.aJC = false;
                this.aJD = false;
                break;
            case 2:
                float abs = Math.abs(x - this.aJF);
                float abs2 = Math.abs(y - this.aJG);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.aJC = false;
                }
                p(x, y);
                break;
            case 3:
                this.aJC = false;
                this.aJD = false;
                break;
            case 4:
                this.aJC = false;
                this.aJD = false;
                break;
        }
        return this.aJC | this.aJD;
    }

    private void p(float f, float f2) {
        if (this.aJy != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.aJz / 2));
            int i2 = (int) (f2 - (this.aJA / 2));
            int i3 = this.aJB - this.aJz;
            int i4 = (this.mParentHeight - this.aJA) - 168;
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
            this.aJy.setX(i3);
            this.aJy.setY(i4);
            requestLayout();
        }
    }
}
