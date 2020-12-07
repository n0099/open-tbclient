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
/* loaded from: classes25.dex */
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
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.sI(optString));
            ((Button) findViewById).setTextColor(SwanAppConfigData.sI("#FFFFFF"));
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
                this.dtl.getHitRect(rect);
                if (rect.contains((int) x, (int) y)) {
                    this.dtt = x;
                    this.bIF = y;
                    this.dtq = true;
                    this.dtp = true;
                    postDelayed(this.dtu, ViewConfiguration.getTapTimeout());
                    break;
                }
                break;
            case 1:
                if (this.dtp) {
                    if (this.dtv != null) {
                        this.dtv.onClick();
                    }
                    removeCallbacks(this.dtu);
                } else if (this.dtq && this.dtv != null) {
                    this.dtv.aCe();
                }
                if (DEBUG) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.dtp);
                }
                if (this.dtr && !this.dtp && x >= 0.0f && x <= this.dto && y >= 0.0f && y <= this.mParentHeight + this.dtn) {
                    this.dtl.animate().x(this.dto - this.dtm).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                }
                this.dtp = false;
                this.dtq = false;
                break;
            case 2:
                float abs = Math.abs(x - this.dtt);
                float abs2 = Math.abs(y - this.bIF);
                if (Math.sqrt((abs * abs) + (abs2 * abs2)) > 10.0d) {
                    this.dtp = false;
                }
                n(x, y);
                break;
            case 3:
                this.dtp = false;
                this.dtq = false;
                break;
            case 4:
                this.dtp = false;
                this.dtq = false;
                break;
        }
        return this.dtp | this.dtq;
    }

    private void n(float f, float f2) {
        if (this.dtl != null) {
            if (DEBUG) {
                Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
            }
            int i = (int) (f - (this.dtm / 2));
            int i2 = (int) (f2 - (this.dtn / 2));
            int i3 = this.dto - this.dtm;
            int i4 = (this.mParentHeight - this.dtn) - 168;
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
            this.dtl.setX(i3);
            this.dtl.setY(i4);
            requestLayout();
        }
    }
}
