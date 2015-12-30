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
    private Bitmap FA;
    private Bitmap FB;
    private Bitmap FC;
    private boolean FD;
    private boolean FE;
    private boolean FF;
    private int FG;
    private a FH;
    private SwitchState Fx;
    private float Fy;
    private float Fz;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (FJ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (FK) with 'values()' method */
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
        this.Fx = SwitchState.ON;
        this.FD = false;
        this.FE = false;
        this.FF = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FG = 0;
        this.FH = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fx = SwitchState.ON;
        this.FD = false;
        this.FE = false;
        this.FF = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.FG = 0;
        this.FH = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.FA = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.FB = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.FC = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.FA.getWidth();
        this.height = this.FA.getHeight();
        this.FG = this.FC.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.FF) {
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
                this.FD = true;
                this.Fy = motionEvent.getX();
                this.Fz = this.Fy;
                return true;
            case 1:
                this.FD = false;
                SwitchState switchState = this.Fx;
                if (Math.abs(this.Fz - this.Fy) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.FF = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.Fx = SwitchState.ON;
                } else {
                    this.Fx = SwitchState.OFF;
                }
                if (this.FE && switchState != this.Fx && this.FH != null) {
                    this.FH.a(this, this.Fx);
                }
                this.FF = false;
                invalidate();
                return true;
            case 2:
                this.Fz = motionEvent.getX();
                if (Math.abs(this.Fz - this.Fy) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Fz - this.Fy) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.FD = false;
                SwitchState switchState2 = this.Fx;
                removeCallbacks(this.mRunnable);
                this.FF = true;
                if (this.Fz >= this.width / 2.0f) {
                    this.Fx = SwitchState.ON;
                } else {
                    this.Fx = SwitchState.OFF;
                }
                if (this.FE && switchState2 != this.Fx && this.FH != null) {
                    this.FH.a(this, this.Fx);
                }
                this.FF = false;
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
        if (this.FD) {
            if (this.Fz < this.width / 2.0f) {
                canvas.drawBitmap(this.FB, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.FA, 0.0f, 0.0f, this.paint);
            }
        } else if (this.Fx == SwitchState.ON) {
            canvas.drawBitmap(this.FA, 0.0f, 0.0f, this.paint);
        } else if (this.Fx == SwitchState.OFF) {
            canvas.drawBitmap(this.FB, 0.0f, 0.0f, this.paint);
        }
        if (this.FD) {
            if (this.Fz > this.FA.getWidth()) {
                f = this.width - (this.FG / 2.0f);
            } else {
                f = this.Fz - (this.FG / 2.0f);
            }
        } else if (this.Fx == SwitchState.ON) {
            f = this.width - this.FG;
        } else {
            f = this.Fx == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.FG) {
            f = this.width - this.FG;
        }
        canvas.drawBitmap(this.FC, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.FF) {
            this.FF = true;
            if (switchState == SwitchState.ON) {
                this.Fz = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Fz = 0.0f;
            }
            if (z && switchState != this.Fx && this.FH != null) {
                this.FH.a(this, switchState);
            }
            this.Fx = switchState;
            this.FF = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.FA = bitmap;
        this.FB = bitmap2;
        this.FC = bitmap3;
        invalidate();
    }

    public void mc() {
        if (this.Fx != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void md() {
        if (this.Fx != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void me() {
        a(SwitchState.ON, true);
    }

    public void L(boolean z) {
        if (this.Fx != SwitchState.ON) {
            me();
        }
    }

    public void mf() {
        a(SwitchState.OFF, true);
    }

    public void M(boolean z) {
        if (this.Fx != SwitchState.OFF) {
            mf();
        }
    }

    public boolean hA() {
        return this.Fx == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.FE = true;
        this.FH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg() {
        if (this.Fx == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.Fx == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
