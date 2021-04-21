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
import d.b.h0.a.f;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FloatButton extends FullScreenFloatView {
    public static final boolean s = k.f45772a;

    public FloatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(float f2, float f3) {
        if (this.f12133e == null) {
            return;
        }
        if (s) {
            Log.e("FloatButton", "move--> x = " + f2 + ", y = " + f3);
        }
        int i = this.f12134f;
        int i2 = (int) (f2 - (i / 2));
        int i3 = this.f12135g;
        int i4 = (int) (f3 - (i3 / 2));
        int i5 = this.f12136h - i;
        int i6 = (this.i - i3) - 168;
        if (i2 <= 0) {
            i2 = 0;
        }
        if (i4 <= 288) {
            i4 = 288;
        }
        if (i2 <= i5) {
            i5 = i2;
        }
        if (i4 <= i6) {
            i6 = i4;
        }
        if (s) {
            Log.e("FloatButton", "move--> left = 0, top = 288, mStatusBarHeight = " + this.j);
        }
        this.f12133e.setX(i5);
        this.f12133e.setY(i6);
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
            this.f12133e.getHitRect(rect);
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
                int i = this.f12136h;
                if (x <= i && y >= 0.0f && y <= this.i + this.f12135g) {
                    this.f12133e.animate().x(i - this.f12134f).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
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
        findViewById(f.float_imgview).setBottom(h0.H(191.0f));
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

    public FloatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
