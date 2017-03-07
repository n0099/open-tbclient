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
    private float Gc;
    private float Gd;
    private Bitmap Ge;
    private Bitmap Gf;
    private Bitmap Gg;
    private boolean Gh;
    private boolean Gi;
    private boolean Gj;
    private int Gk;
    private a Gl;
    private int height;
    private Runnable mRunnable;
    private SwitchState mState;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Gn) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Go) with 'values()' method */
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
        this.mState = SwitchState.ON;
        this.Gh = false;
        this.Gi = false;
        this.Gj = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Gk = 0;
        this.Gl = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Gh = false;
        this.Gi = false;
        this.Gj = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Gk = 0;
        this.Gl = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.Ge = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Gf = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Gg = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Ge.getWidth();
        this.height = this.Ge.getHeight();
        this.Gk = this.Gg.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Gj) {
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
                this.Gh = true;
                this.Gc = motionEvent.getX();
                this.Gd = this.Gc;
                return true;
            case 1:
                this.Gh = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Gd - this.Gc) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Gj = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Gi && switchState != this.mState && this.Gl != null) {
                    this.Gl.a(this, this.mState);
                }
                this.Gj = false;
                invalidate();
                return true;
            case 2:
                this.Gd = motionEvent.getX();
                if (Math.abs(this.Gd - this.Gc) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Gd - this.Gc) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Gh = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Gj = true;
                if (this.Gd >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Gi && switchState2 != this.mState && this.Gl != null) {
                    this.Gl.a(this, this.mState);
                }
                this.Gj = false;
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
        if (this.Gh) {
            if (this.Gd < this.width / 2.0f) {
                canvas.drawBitmap(this.Gf, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Ge, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Ge, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Gf, 0.0f, 0.0f, this.paint);
        }
        if (this.Gh) {
            if (this.Gd > this.Ge.getWidth()) {
                f = this.width - (this.Gk / 2.0f);
            } else {
                f = this.Gd - (this.Gk / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Gk;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Gk) {
            f = this.width - this.Gk;
        }
        canvas.drawBitmap(this.Gg, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Gj) {
            this.Gj = true;
            if (switchState == SwitchState.ON) {
                this.Gd = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Gd = 0.0f;
            }
            if (z && switchState != this.mState && this.Gl != null) {
                this.Gl.a(this, switchState);
            }
            this.mState = switchState;
            this.Gj = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Ge = bitmap;
        this.Gf = bitmap2;
        this.Gg = bitmap3;
        invalidate();
    }

    public void kl() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void km() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void kn() {
        a(SwitchState.ON, true);
    }

    public void P(boolean z) {
        if (this.mState != SwitchState.ON) {
            kn();
        }
    }

    public void ko() {
        a(SwitchState.OFF, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.OFF) {
            ko();
        }
    }

    public boolean fP() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Gi = true;
        this.Gl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
