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
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private SwitchState wL;
    private float wM;
    private float wN;
    private Bitmap wO;
    private Bitmap wP;
    private Bitmap wQ;
    private boolean wR;
    private boolean wS;
    private boolean wT;
    private int wU;
    private a wV;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (wX) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (wY) with 'values()' method */
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
        this.wL = SwitchState.ON;
        this.wR = false;
        this.wS = false;
        this.wT = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wU = 0;
        this.wV = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wL = SwitchState.ON;
        this.wR = false;
        this.wS = false;
        this.wT = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wU = 0;
        this.wV = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.wO = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.wP = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.wQ = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.wO.getWidth();
        this.height = this.wO.getHeight();
        this.wU = this.wQ.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.wT) {
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
                this.wR = true;
                this.wM = motionEvent.getX();
                this.wN = this.wM;
                return true;
            case 1:
                this.wR = false;
                SwitchState switchState = this.wL;
                if (Math.abs(this.wN - this.wM) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.wT = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.wL = SwitchState.ON;
                } else {
                    this.wL = SwitchState.OFF;
                }
                if (this.wS && switchState != this.wL && this.wV != null) {
                    this.wV.a(this, this.wL);
                }
                this.wT = false;
                invalidate();
                return true;
            case 2:
                this.wN = motionEvent.getX();
                if (Math.abs(this.wN - this.wM) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.wN - this.wM) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.wR = false;
                SwitchState switchState2 = this.wL;
                removeCallbacks(this.mRunnable);
                this.wT = true;
                if (this.wN >= this.width / 2.0f) {
                    this.wL = SwitchState.ON;
                } else {
                    this.wL = SwitchState.OFF;
                }
                if (this.wS && switchState2 != this.wL && this.wV != null) {
                    this.wV.a(this, this.wL);
                }
                this.wT = false;
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
        if (this.wR) {
            if (this.wN < this.width / 2.0f) {
                canvas.drawBitmap(this.wP, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.wO, 0.0f, 0.0f, this.paint);
            }
        } else if (this.wL == SwitchState.ON) {
            canvas.drawBitmap(this.wO, 0.0f, 0.0f, this.paint);
        } else if (this.wL == SwitchState.OFF) {
            canvas.drawBitmap(this.wP, 0.0f, 0.0f, this.paint);
        }
        if (this.wR) {
            if (this.wN > this.wO.getWidth()) {
                f = this.width - (this.wU / 2.0f);
            } else {
                f = this.wN - (this.wU / 2.0f);
            }
        } else if (this.wL == SwitchState.ON) {
            f = this.width - this.wU;
        } else {
            f = this.wL == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.wU) {
            f = this.width - this.wU;
        }
        canvas.drawBitmap(this.wQ, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.wT) {
            this.wT = true;
            if (switchState == SwitchState.ON) {
                this.wN = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.wN = 0.0f;
            }
            if (z && switchState != this.wL && this.wV != null) {
                this.wV.a(this, switchState);
            }
            this.wL = switchState;
            this.wT = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.wO = bitmap;
        this.wP = bitmap2;
        this.wQ = bitmap3;
        invalidate();
    }

    public void iy() {
        if (this.wL != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void iz() {
        if (this.wL != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void iA() {
        a(SwitchState.ON, true);
    }

    public void M(boolean z) {
        if (this.wL != SwitchState.ON) {
            iA();
        }
    }

    public void iB() {
        a(SwitchState.OFF, true);
    }

    public void N(boolean z) {
        if (this.wL != SwitchState.OFF) {
            iB();
        }
    }

    public boolean ec() {
        return this.wL == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.wS = true;
        this.wV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC() {
        if (this.wL == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.wL == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
