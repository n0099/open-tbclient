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
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        findViewById(a.f.float_imgview).setBottom(ah.V(191.0f));
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(a.f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.rT(optString));
            ((Button) findViewById).setTextColor(SwanAppConfigData.rT("#FFFFFF"));
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
                this.dxK.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dxQ = x;
                    this.bNR = y;
                    this.dxO = true;
                    this.dxN = true;
                    postDelayed(this.dxR, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dxN) {
                    if (this.dxS != null) {
                        this.dxS.onClick();
                    }
                    removeCallbacks(this.dxR);
                } else if (this.dxO && this.dxS != null) {
                    this.dxS.aAd();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dxN);
                }
                if (this.dxP && !this.dxN && x >= 0.0f && x <= this.mParentWidth && y >= 0.0f && y <= this.mParentHeight + this.dxM) {
                    this.dxK.animate().x(this.mParentWidth - this.dxL).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.dxN = false;
                this.dxO = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dxQ);
                float abs2 = Math.abs(y - this.bNR);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dxN = false;
                }
                o(x, y);
                break;
            case 3:
                this.dxN = false;
                this.dxO = false;
                break;
            case 4:
                this.dxN = false;
                this.dxO = false;
                break;
        }
        return this.dxN | this.dxO;
    }

    private void o(float f, float f2) {
        if (this.dxK != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dxL / 2));
            int i2 = (int) (f2 - (this.dxM / 2));
            int i3 = this.mParentWidth - this.dxL;
            int i4 = (this.mParentHeight - this.dxM) - 168;
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
            this.dxK.setX(i3);
            this.dxK.setY(i4);
            requestLayout();
        }
    }
}
