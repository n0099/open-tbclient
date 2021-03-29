package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdSwitchView extends View implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public SwitchState f2241e;

    /* renamed from: f  reason: collision with root package name */
    public float f2242f;

    /* renamed from: g  reason: collision with root package name */
    public float f2243g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f2244h;
    public Bitmap i;
    public Bitmap j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public b r;
    public Runnable s;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdSwitchView.this.b();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void OnSwitchStateChange(View view, SwitchState switchState);
    }

    public BdSwitchView(Context context) {
        super(context);
        this.f2241e = SwitchState.ON;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new Paint();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = new a();
        c(context);
    }

    public final void b() {
        SwitchState switchState = this.f2241e;
        if (switchState == SwitchState.ON) {
            e(SwitchState.OFF, true);
        } else if (switchState == SwitchState.OFF) {
            e(SwitchState.ON, true);
        }
    }

    public final void c(Context context) {
        this.f2244h = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.i = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.j = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.o = this.f2244h.getWidth();
        this.p = this.f2244h.getHeight();
        this.q = this.j.getWidth();
        setOnTouchListener(this);
    }

    public boolean d() {
        return this.f2241e == SwitchState.ON;
    }

    public final void e(SwitchState switchState, boolean z) {
        b bVar;
        if (this.m) {
            return;
        }
        this.m = true;
        if (switchState == SwitchState.ON) {
            this.f2243g = this.o;
        } else if (switchState == SwitchState.OFF) {
            this.f2243g = 0.0f;
        }
        if (z && switchState != this.f2241e && (bVar = this.r) != null) {
            bVar.OnSwitchStateChange(this, switchState);
        }
        this.f2241e = switchState;
        this.m = false;
        invalidate();
    }

    public void f() {
        e(SwitchState.OFF, true);
    }

    public void g(boolean z) {
        if (this.f2241e == SwitchState.OFF) {
            return;
        }
        f();
    }

    public void h() {
        SwitchState switchState = this.f2241e;
        SwitchState switchState2 = SwitchState.OFF;
        if (switchState == switchState2) {
            return;
        }
        e(switchState2, false);
    }

    public void i() {
        e(SwitchState.ON, true);
    }

    public void j(boolean z) {
        if (this.f2241e == SwitchState.ON) {
            return;
        }
        i();
    }

    public void k() {
        SwitchState switchState = this.f2241e;
        SwitchState switchState2 = SwitchState.ON;
        if (switchState == switchState2) {
            return;
        }
        e(switchState2, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        int i;
        super.onDraw(canvas);
        if (this.k) {
            if (this.f2243g < this.o / 2.0f) {
                canvas.drawBitmap(this.i, 0.0f, 0.0f, this.n);
            } else {
                canvas.drawBitmap(this.f2244h, 0.0f, 0.0f, this.n);
            }
        } else {
            SwitchState switchState = this.f2241e;
            if (switchState == SwitchState.ON) {
                canvas.drawBitmap(this.f2244h, 0.0f, 0.0f, this.n);
            } else if (switchState == SwitchState.OFF) {
                canvas.drawBitmap(this.i, 0.0f, 0.0f, this.n);
            }
        }
        if (this.k) {
            if (this.f2243g > this.f2244h.getWidth()) {
                f3 = this.o;
                i = this.q;
            } else {
                f3 = this.f2243g;
                i = this.q;
            }
            f2 = f3 - (i / 2.0f);
        } else if (this.f2241e == SwitchState.ON) {
            f2 = this.o - this.q;
        } else {
            SwitchState switchState2 = SwitchState.OFF;
            f2 = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else {
            int i2 = this.o;
            int i3 = this.q;
            if (f2 > i2 - i3) {
                f2 = i2 - i3;
            }
        }
        canvas.drawBitmap(this.j, f2, 0.0f, this.n);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.o, this.p);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        SwitchState switchState;
        b bVar;
        SwitchState switchState2;
        b bVar2;
        if (this.m) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getX() > this.o || motionEvent.getY() > this.p) {
                return false;
            }
            postDelayed(this.s, 200L);
            this.k = true;
            float x = motionEvent.getX();
            this.f2242f = x;
            this.f2243g = x;
            return true;
        } else if (action == 1) {
            this.k = false;
            SwitchState switchState3 = this.f2241e;
            if (Math.abs(this.f2243g - this.f2242f) <= this.o * 0.02d) {
                invalidate();
                return true;
            }
            removeCallbacks(this.s);
            this.m = true;
            if (motionEvent.getX() >= this.o / 2.0f) {
                this.f2241e = SwitchState.ON;
            } else {
                this.f2241e = SwitchState.OFF;
            }
            if (this.l && switchState3 != (switchState = this.f2241e) && (bVar = this.r) != null) {
                bVar.OnSwitchStateChange(this, switchState);
            }
            this.m = false;
            invalidate();
            return true;
        } else if (action == 2) {
            float x2 = motionEvent.getX();
            this.f2243g = x2;
            if (Math.abs(x2 - this.f2242f) > this.o * 0.05d) {
                removeCallbacks(this.s);
                if (Math.abs(this.f2243g - this.f2242f) > this.o * 0.1d) {
                    invalidate();
                }
            }
            return true;
        } else if (action != 3) {
            return true;
        } else {
            this.k = false;
            SwitchState switchState4 = this.f2241e;
            removeCallbacks(this.s);
            this.m = true;
            if (this.f2243g >= this.o / 2.0f) {
                this.f2241e = SwitchState.ON;
            } else {
                this.f2241e = SwitchState.OFF;
            }
            if (this.l && switchState4 != (switchState2 = this.f2241e) && (bVar2 = this.r) != null) {
                bVar2.OnSwitchStateChange(this, switchState2);
            }
            this.m = false;
            invalidate();
            return true;
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.f2244h = bitmap;
        this.i = bitmap2;
        this.j = bitmap3;
        invalidate();
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        this.l = true;
        this.r = bVar;
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2241e = SwitchState.ON;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new Paint();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = new a();
        c(context);
    }
}
