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
    private SwitchState FQ;
    private float FR;
    private float FS;
    private Bitmap FT;
    private Bitmap FU;
    private Bitmap FV;
    private boolean FW;
    private boolean FX;
    private boolean FY;
    private int FZ;
    private a Ga;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Gc) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Gd) with 'values()' method */
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
        this.FQ = SwitchState.ON;
        this.FW = false;
        this.FX = false;
        this.FY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FZ = 0;
        this.Ga = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FQ = SwitchState.ON;
        this.FW = false;
        this.FX = false;
        this.FY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FZ = 0;
        this.Ga = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.FT = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.FU = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.FV = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.FT.getWidth();
        this.height = this.FT.getHeight();
        this.FZ = this.FV.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.FY) {
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
                this.FW = true;
                this.FR = motionEvent.getX();
                this.FS = this.FR;
                return true;
            case 1:
                this.FW = false;
                SwitchState switchState = this.FQ;
                if (Math.abs(this.FS - this.FR) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.FY = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.FQ = SwitchState.ON;
                } else {
                    this.FQ = SwitchState.OFF;
                }
                if (this.FX && switchState != this.FQ && this.Ga != null) {
                    this.Ga.a(this, this.FQ);
                }
                this.FY = false;
                invalidate();
                return true;
            case 2:
                this.FS = motionEvent.getX();
                if (Math.abs(this.FS - this.FR) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.FS - this.FR) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.FW = false;
                SwitchState switchState2 = this.FQ;
                removeCallbacks(this.mRunnable);
                this.FY = true;
                if (this.FS >= this.width / 2.0f) {
                    this.FQ = SwitchState.ON;
                } else {
                    this.FQ = SwitchState.OFF;
                }
                if (this.FX && switchState2 != this.FQ && this.Ga != null) {
                    this.Ga.a(this, this.FQ);
                }
                this.FY = false;
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
        if (this.FW) {
            if (this.FS < this.width / 2.0f) {
                canvas.drawBitmap(this.FU, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.FT, 0.0f, 0.0f, this.paint);
            }
        } else if (this.FQ == SwitchState.ON) {
            canvas.drawBitmap(this.FT, 0.0f, 0.0f, this.paint);
        } else if (this.FQ == SwitchState.OFF) {
            canvas.drawBitmap(this.FU, 0.0f, 0.0f, this.paint);
        }
        if (this.FW) {
            if (this.FS > this.FT.getWidth()) {
                f = this.width - (this.FZ / 2.0f);
            } else {
                f = this.FS - (this.FZ / 2.0f);
            }
        } else if (this.FQ == SwitchState.ON) {
            f = this.width - this.FZ;
        } else {
            f = this.FQ == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.FZ) {
            f = this.width - this.FZ;
        }
        canvas.drawBitmap(this.FV, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.FY) {
            this.FY = true;
            if (switchState == SwitchState.ON) {
                this.FS = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.FS = 0.0f;
            }
            if (z && switchState != this.FQ && this.Ga != null) {
                this.Ga.a(this, switchState);
            }
            this.FQ = switchState;
            this.FY = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.FT = bitmap;
        this.FU = bitmap2;
        this.FV = bitmap3;
        invalidate();
    }

    public void mi() {
        if (this.FQ != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mj() {
        if (this.FQ != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mk() {
        a(SwitchState.ON, true);
    }

    public void K(boolean z) {
        if (this.FQ != SwitchState.ON) {
            mk();
        }
    }

    public void ml() {
        a(SwitchState.OFF, true);
    }

    public void L(boolean z) {
        if (this.FQ != SwitchState.OFF) {
            ml();
        }
    }

    public boolean hO() {
        return this.FQ == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.FX = true;
        this.Ga = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm() {
        if (this.FQ == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.FQ == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
