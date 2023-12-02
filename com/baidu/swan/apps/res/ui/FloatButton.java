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
import com.baidu.tieba.R;
import com.baidu.tieba.bk3;
import com.baidu.tieba.vm1;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.chromium.net.NetError;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FloatButton extends FullScreenFloatView {
    public static final boolean o = vm1.a;

    public void setFloatButtonDefaultPosition() {
        findViewById(R.id.float_imgview).setBottom(bk3.O(191.0f));
    }

    public FloatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void d(float f, float f2) {
        if (this.a == null) {
            return;
        }
        if (o) {
            Log.e("FloatButton", "move--> x = " + f + ", y = " + f2);
        }
        int i = this.b;
        int i2 = (int) (f - (i / 2));
        int i3 = this.c;
        int i4 = (int) (f2 - (i3 / 2));
        int i5 = this.d - i;
        int i6 = (this.e - i3) + NetError.ERR_CT_STH_PARSING_FAILED;
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
        if (o) {
            Log.e("FloatButton", "move--> left = 0, top = 288, mStatusBarHeight = " + this.f);
        }
        this.a.setX(i5);
        this.a.setY(i6);
        requestLayout();
    }

    @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FullScreenFloatView.c cVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 4) {
                            this.g = false;
                            this.h = false;
                        }
                    } else {
                        this.g = false;
                        this.h = false;
                    }
                } else {
                    float abs = Math.abs(x - this.j);
                    float abs2 = Math.abs(y - this.k);
                    if (Math.sqrt((abs2 * abs2) + (abs * abs)) > 10.0d) {
                        this.g = false;
                    }
                    d(x, y);
                }
            } else {
                if (this.g) {
                    FullScreenFloatView.c cVar2 = this.m;
                    if (cVar2 != null) {
                        cVar2.onClick();
                    }
                    removeCallbacks(this.l);
                } else if (this.h && (cVar = this.m) != null) {
                    cVar.onDrag();
                }
                if (o) {
                    Log.e("FloatButton", "ACTION_UP--> x = " + x + ", y = " + y + ",mIsClickDrag = " + this.g);
                }
                if (this.i && !this.g && x >= 0.0f) {
                    int i = this.d;
                    if (x <= i && y >= 0.0f && y <= this.e + this.c) {
                        this.a.animate().x(i - this.b).setInterpolator(new AccelerateInterpolator()).setDuration(300L).start();
                    }
                }
                this.g = false;
                this.h = false;
            }
        } else {
            this.a.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                this.j = x;
                this.k = y;
                this.h = true;
                this.g = true;
                postDelayed(this.l, ViewConfiguration.getTapTimeout());
            }
        }
        return this.g | this.h;
    }

    public void setFloatButtonDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        View findViewById = findViewById(R.id.float_imgview);
        if (findViewById instanceof Button) {
            findViewById.setBackground(drawable);
        }
    }

    public void setFloatButtonStyle(JSONObject jSONObject) {
        View findViewById = findViewById(R.id.float_imgview);
        String str = "#4E4E4E";
        if (jSONObject != null) {
            str = jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "#4E4E4E");
        }
        if (findViewById instanceof Button) {
            ((GradientDrawable) findViewById.getBackground()).setColor(SwanAppConfigData.t(str));
            ((Button) findViewById).setTextColor(SwanAppConfigData.t("#FFFFFF"));
            findViewById.setAlpha((float) 0.8999999761581421d);
        }
    }
}
