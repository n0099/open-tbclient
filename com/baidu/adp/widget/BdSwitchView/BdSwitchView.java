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
    private float FD;
    private float FE;
    private Bitmap FF;
    private Bitmap FG;
    private Bitmap FH;
    private boolean FI;
    private boolean FJ;
    private boolean FK;
    private int FL;
    private a FM;
    private int height;
    private Runnable mRunnable;
    private SwitchState mState;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (FO) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (FP) with 'values()' method */
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
        this.FI = false;
        this.FJ = false;
        this.FK = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FL = 0;
        this.FM = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.FI = false;
        this.FJ = false;
        this.FK = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FL = 0;
        this.FM = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.FF = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.FG = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.FH = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.FF.getWidth();
        this.height = this.FF.getHeight();
        this.FL = this.FH.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.FK) {
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
                this.FI = true;
                this.FD = motionEvent.getX();
                this.FE = this.FD;
                return true;
            case 1:
                this.FI = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.FE - this.FD) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.FK = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.FJ && switchState != this.mState && this.FM != null) {
                    this.FM.a(this, this.mState);
                }
                this.FK = false;
                invalidate();
                return true;
            case 2:
                this.FE = motionEvent.getX();
                if (Math.abs(this.FE - this.FD) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.FE - this.FD) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.FI = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.FK = true;
                if (this.FE >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.FJ && switchState2 != this.mState && this.FM != null) {
                    this.FM.a(this, this.mState);
                }
                this.FK = false;
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
        if (this.FI) {
            if (this.FE < this.width / 2.0f) {
                canvas.drawBitmap(this.FG, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.FF, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.FF, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.FG, 0.0f, 0.0f, this.paint);
        }
        if (this.FI) {
            if (this.FE > this.FF.getWidth()) {
                f = this.width - (this.FL / 2.0f);
            } else {
                f = this.FE - (this.FL / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.FL;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.FL) {
            f = this.width - this.FL;
        }
        canvas.drawBitmap(this.FH, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.FK) {
            this.FK = true;
            if (switchState == SwitchState.ON) {
                this.FE = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.FE = 0.0f;
            }
            if (z && switchState != this.mState && this.FM != null) {
                this.FM.a(this, switchState);
            }
            this.mState = switchState;
            this.FK = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.FF = bitmap;
        this.FG = bitmap2;
        this.FH = bitmap3;
        invalidate();
    }

    public void kp() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void kq() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void kr() {
        a(SwitchState.ON, true);
    }

    public void P(boolean z) {
        if (this.mState != SwitchState.ON) {
            kr();
        }
    }

    public void ks() {
        a(SwitchState.OFF, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.OFF) {
            ks();
        }
    }

    public boolean fU() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.FJ = true;
        this.FM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
