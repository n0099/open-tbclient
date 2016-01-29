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
    private SwitchState FK;
    private float FL;
    private float FM;
    private Bitmap FN;
    private Bitmap FO;
    private Bitmap FP;
    private boolean FQ;
    private boolean FR;
    private boolean FS;
    private int FT;
    private a FU;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (FW) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (FX) with 'values()' method */
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
        this.FK = SwitchState.ON;
        this.FQ = false;
        this.FR = false;
        this.FS = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FT = 0;
        this.FU = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FK = SwitchState.ON;
        this.FQ = false;
        this.FR = false;
        this.FS = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FT = 0;
        this.FU = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.FN = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.FO = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.FP = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.FN.getWidth();
        this.height = this.FN.getHeight();
        this.FT = this.FP.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.FS) {
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
                this.FQ = true;
                this.FL = motionEvent.getX();
                this.FM = this.FL;
                return true;
            case 1:
                this.FQ = false;
                SwitchState switchState = this.FK;
                if (Math.abs(this.FM - this.FL) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.FS = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.FK = SwitchState.ON;
                } else {
                    this.FK = SwitchState.OFF;
                }
                if (this.FR && switchState != this.FK && this.FU != null) {
                    this.FU.a(this, this.FK);
                }
                this.FS = false;
                invalidate();
                return true;
            case 2:
                this.FM = motionEvent.getX();
                if (Math.abs(this.FM - this.FL) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.FM - this.FL) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.FQ = false;
                SwitchState switchState2 = this.FK;
                removeCallbacks(this.mRunnable);
                this.FS = true;
                if (this.FM >= this.width / 2.0f) {
                    this.FK = SwitchState.ON;
                } else {
                    this.FK = SwitchState.OFF;
                }
                if (this.FR && switchState2 != this.FK && this.FU != null) {
                    this.FU.a(this, this.FK);
                }
                this.FS = false;
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
        if (this.FQ) {
            if (this.FM < this.width / 2.0f) {
                canvas.drawBitmap(this.FO, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.FN, 0.0f, 0.0f, this.paint);
            }
        } else if (this.FK == SwitchState.ON) {
            canvas.drawBitmap(this.FN, 0.0f, 0.0f, this.paint);
        } else if (this.FK == SwitchState.OFF) {
            canvas.drawBitmap(this.FO, 0.0f, 0.0f, this.paint);
        }
        if (this.FQ) {
            if (this.FM > this.FN.getWidth()) {
                f = this.width - (this.FT / 2.0f);
            } else {
                f = this.FM - (this.FT / 2.0f);
            }
        } else if (this.FK == SwitchState.ON) {
            f = this.width - this.FT;
        } else {
            f = this.FK == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.FT) {
            f = this.width - this.FT;
        }
        canvas.drawBitmap(this.FP, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.FS) {
            this.FS = true;
            if (switchState == SwitchState.ON) {
                this.FM = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.FM = 0.0f;
            }
            if (z && switchState != this.FK && this.FU != null) {
                this.FU.a(this, switchState);
            }
            this.FK = switchState;
            this.FS = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.FN = bitmap;
        this.FO = bitmap2;
        this.FP = bitmap3;
        invalidate();
    }

    public void mq() {
        if (this.FK != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mr() {
        if (this.FK != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void ms() {
        a(SwitchState.ON, true);
    }

    public void L(boolean z) {
        if (this.FK != SwitchState.ON) {
            ms();
        }
    }

    public void mt() {
        a(SwitchState.OFF, true);
    }

    public void M(boolean z) {
        if (this.FK != SwitchState.OFF) {
            mt();
        }
    }

    public boolean hI() {
        return this.FK == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.FR = true;
        this.FU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        if (this.FK == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.FK == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
