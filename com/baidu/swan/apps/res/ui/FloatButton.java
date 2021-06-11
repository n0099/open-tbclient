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
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FloatButton extends FullScreenFloatView {
    public static final boolean s = k.f46875a;

    public FloatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(float f2, float f3) {
        if (this.f11162e == null) {
            return;
        }
        if (s) {
            Log.e("FloatButton", "move--> x = " + f2 + ", y = " + f3);
        }
        int i2 = this.f11163f;
        int i3 = (int) (f2 - (i2 / 2));
        int i4 = this.f11164g;
        int i5 = (int) (f3 - (i4 / 2));
        int i6 = this.f11165h - i2;
        int i7 = (this.f11166i - i4) - 168;
        if (i3 <= 0) {
            i3 = 0;
        }
        if (i5 <= 288) {
            i5 = 288;
        }
        if (i3 <= i6) {
            i6 = i3;
        }
        if (i5 <= i7) {
            i7 = i5;
        }
        if (s) {
            Log.e("FloatButton", "move--> left = 0, top = 288, mStatusBarHeight = " + this.j);
        }
        this.f11162e.setX(i6);
        this.f11162e.setY(i7);
        requestLayout();
    }

    @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FullScreenFloatView.c cVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11162e.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.n = x;
                this.o = y;
                this.l = true;
                this.k = true;
                postDelayed(this.p, ViewConfiguration.getTapTimeout());
            }
        } else if (action == 1) {
            if (this.k) {
                FullScreenFloatView.c cVar2 = this.q;
                if (cVar2 != null) {
                    cVar2.onClick();
                }
                removeCallbacks(this.p);
            } else if (this.l && (cVar = this.q) != null) {
                cVar.a();
            }
            if (s) {
                Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.k);
            }
            if (this.m && !this.k && x >= 0.0f) {
                int i2 = this.f11165h;
                if (x <= i2 && y >= 0.0f && y <= this.f11166i + this.f11164g) {
                    this.f11162e.animate().x(i2 - this.f11163f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
            }
            this.k = false;
            this.l = false;
        } else if (action == 2) {
            float abs = Math.abs(x - this.n);
            float abs2 = Math.abs(y - this.o);
            if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                this.k = false;
            }
            d(x, y);
        } else if (action == 3) {
            this.k = false;
            this.l = false;
        } else if (action == 4) {
            this.k = false;
            this.l = false;
        }
        return this.k | this.l;
    }

    public void setFloatButtonDefaultPosition() {
        findViewById(f.float_imgview).setBottom(n0.K(191.0f));
    }

    public void setFloatButtonDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        View findViewById = findViewById(f.float_imgview);
        if (findViewById instanceof Button) {
            findViewById.setBackground(drawable);
        }
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(f.float_imgview);
        String optString = jSONObject != null ? jSONObject.optString("backgroundColor", "#4E4E4E") : "#4E4E4E";
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.s(optString));
            ((Button) findViewById).setTextColor(SwanAppConfigData.s("#FFFFFF"));
            findViewById.setAlpha((float) 0.8999999761581421d);
        }
    }

    public FloatButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
