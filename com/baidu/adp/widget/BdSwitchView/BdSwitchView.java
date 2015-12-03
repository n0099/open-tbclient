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
    private SwitchState Fh;
    private float Fi;
    private float Fj;
    private Bitmap Fk;
    private Bitmap Fl;
    private Bitmap Fm;
    private boolean Fn;
    private boolean Fo;
    private boolean Fp;
    private int Fq;
    private a Fr;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Ft) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchState[] valuesCustom() {
            SwitchState[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchState[] switchStateArr = new SwitchState[length];
            System.arraycopy(valuesCustom, 0, switchStateArr, 0, length);
            return switchStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR;

        /* JADX DEBUG: Replace access to removed values field (Fu) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, SwitchState switchState);
    }

    public BdSwitchView(Context context) {
        super(context);
        this.Fh = SwitchState.ON;
        this.Fn = false;
        this.Fo = false;
        this.Fp = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fq = 0;
        this.Fr = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fh = SwitchState.ON;
        this.Fn = false;
        this.Fo = false;
        this.Fp = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fq = 0;
        this.Fr = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.Fk = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Fl = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Fm = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Fk.getWidth();
        this.height = this.Fk.getHeight();
        this.Fq = this.Fm.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fp) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (motionEvent.getX() > this.width || motionEvent.getY() > this.height) {
                    return false;
                }
                postDelayed(this.mRunnable, 200L);
                this.Fn = true;
                this.Fi = motionEvent.getX();
                this.Fj = this.Fi;
                return true;
            case 1:
                this.Fn = false;
                SwitchState switchState = this.Fh;
                if (Math.abs(this.Fj - this.Fi) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fp = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.Fh = SwitchState.ON;
                } else {
                    this.Fh = SwitchState.OFF;
                }
                if (this.Fo && switchState != this.Fh && this.Fr != null) {
                    this.Fr.a(this, this.Fh);
                }
                this.Fp = false;
                invalidate();
                return true;
            case 2:
                this.Fj = motionEvent.getX();
                if (Math.abs(this.Fj - this.Fi) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Fj - this.Fi) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Fn = false;
                SwitchState switchState2 = this.Fh;
                removeCallbacks(this.mRunnable);
                this.Fp = true;
                if (this.Fj >= this.width / 2.0f) {
                    this.Fh = SwitchState.ON;
                } else {
                    this.Fh = SwitchState.OFF;
                }
                if (this.Fo && switchState2 != this.Fh && this.Fr != null) {
                    this.Fr.a(this, this.Fh);
                }
                this.Fp = false;
                invalidate();
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.Fn) {
            if (this.Fj < this.width / 2.0f) {
                canvas.drawBitmap(this.Fl, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Fk, 0.0f, 0.0f, this.paint);
            }
        } else if (this.Fh == SwitchState.ON) {
            canvas.drawBitmap(this.Fk, 0.0f, 0.0f, this.paint);
        } else if (this.Fh == SwitchState.OFF) {
            canvas.drawBitmap(this.Fl, 0.0f, 0.0f, this.paint);
        }
        if (this.Fn) {
            if (this.Fj > this.Fk.getWidth()) {
                f = this.width - (this.Fq / 2.0f);
            } else {
                f = this.Fj - (this.Fq / 2.0f);
            }
        } else if (this.Fh == SwitchState.ON) {
            f = this.width - this.Fq;
        } else {
            f = this.Fh == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fq) {
            f = this.width - this.Fq;
        }
        canvas.drawBitmap(this.Fm, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fp) {
            this.Fp = true;
            if (switchState == SwitchState.ON) {
                this.Fj = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Fj = 0.0f;
            }
            if (z && switchState != this.Fh && this.Fr != null) {
                this.Fr.a(this, switchState);
            }
            this.Fh = switchState;
            this.Fp = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Fk = bitmap;
        this.Fl = bitmap2;
        this.Fm = bitmap3;
        invalidate();
    }

    public void mE() {
        if (this.Fh != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mF() {
        if (this.Fh != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mG() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.Fh != SwitchState.ON) {
            mG();
        }
    }

    public void mH() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.Fh != SwitchState.OFF) {
            mH();
        }
    }

    public boolean hA() {
        return this.Fh == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Fo = true;
        this.Fr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI() {
        if (this.Fh == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.Fh == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
