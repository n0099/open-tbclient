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
    private float FG;
    private float FH;
    private Bitmap FI;
    private Bitmap FJ;
    private Bitmap FK;
    private boolean FL;
    private boolean FM;
    private boolean FN;
    private int FO;
    private a FP;
    private int height;
    private Runnable mRunnable;
    private SwitchState mState;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (FR) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (FS) with 'values()' method */
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
        this.FL = false;
        this.FM = false;
        this.FN = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FO = 0;
        this.FP = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.FL = false;
        this.FM = false;
        this.FN = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FO = 0;
        this.FP = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.FI = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.FJ = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.FK = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.FI.getWidth();
        this.height = this.FI.getHeight();
        this.FO = this.FK.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.FN) {
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
                this.FL = true;
                this.FG = motionEvent.getX();
                this.FH = this.FG;
                return true;
            case 1:
                this.FL = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.FH - this.FG) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.FN = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.FM && switchState != this.mState && this.FP != null) {
                    this.FP.a(this, this.mState);
                }
                this.FN = false;
                invalidate();
                return true;
            case 2:
                this.FH = motionEvent.getX();
                if (Math.abs(this.FH - this.FG) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.FH - this.FG) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.FL = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.FN = true;
                if (this.FH >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.FM && switchState2 != this.mState && this.FP != null) {
                    this.FP.a(this, this.mState);
                }
                this.FN = false;
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
        if (this.FL) {
            if (this.FH < this.width / 2.0f) {
                canvas.drawBitmap(this.FJ, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.FI, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.FI, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.FJ, 0.0f, 0.0f, this.paint);
        }
        if (this.FL) {
            if (this.FH > this.FI.getWidth()) {
                f = this.width - (this.FO / 2.0f);
            } else {
                f = this.FH - (this.FO / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.FO;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.FO) {
            f = this.width - this.FO;
        }
        canvas.drawBitmap(this.FK, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.FN) {
            this.FN = true;
            if (switchState == SwitchState.ON) {
                this.FH = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.FH = 0.0f;
            }
            if (z && switchState != this.mState && this.FP != null) {
                this.FP.a(this, switchState);
            }
            this.mState = switchState;
            this.FN = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.FI = bitmap;
        this.FJ = bitmap2;
        this.FK = bitmap3;
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

    public boolean fV() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.FM = true;
        this.FP = aVar;
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
