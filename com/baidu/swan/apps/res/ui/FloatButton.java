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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        findViewById(a.f.float_imgview).setBottom(ah.O(191.0f));
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(a.f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.sa(optString));
            ((Button) findViewById).setTextColor(SwanAppConfigData.sa("#FFFFFF"));
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
                this.dmj.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dmq = x;
                    this.bDx = y;
                    this.dmo = true;
                    this.dmn = true;
                    postDelayed(this.dmr, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dmn) {
                    if (this.dms != null) {
                        this.dms.onClick();
                    }
                    removeCallbacks(this.dmr);
                } else if (this.dmo && this.dms != null) {
                    this.dms.ayV();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dmn);
                }
                if (this.dmp && !this.dmn && x >= 0.0f && x <= this.dmm && y >= 0.0f && y <= this.mParentHeight + this.dml) {
                    this.dmj.animate().x(this.dmm - this.dmk).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.dmn = false;
                this.dmo = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dmq);
                float abs2 = Math.abs(y - this.bDx);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dmn = false;
                }
                n(x, y);
                break;
            case 3:
                this.dmn = false;
                this.dmo = false;
                break;
            case 4:
                this.dmn = false;
                this.dmo = false;
                break;
        }
        return this.dmn | this.dmo;
    }

    private void n(float f, float f2) {
        if (this.dmj != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dmk / 2));
            int i2 = (int) (f2 - (this.dml / 2));
            int i3 = this.dmm - this.dmk;
            int i4 = (this.mParentHeight - this.dml) - 168;
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
            this.dmj.setX(i3);
            this.dmj.setY(i4);
            requestLayout();
        }
    }
}
