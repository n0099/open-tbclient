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
    private float asQ;
    private Bitmap asR;
    private Bitmap asS;
    private Bitmap asT;
    private boolean asU;
    private boolean asV;
    private boolean asW;
    private int asX;
    private a asY;
    private int height;
    private float mDownX;
    private Runnable mRunnable;
    private SwitchState mState;
    private Paint paint;
    private int width;

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
    public interface a {
        void a(View view, SwitchState switchState);
    }

    public BdSwitchView(Context context) {
        super(context);
        this.mState = SwitchState.ON;
        this.asU = false;
        this.asV = false;
        this.asW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asX = 0;
        this.asY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rL();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.asU = false;
        this.asV = false;
        this.asW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asX = 0;
        this.asY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rL();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asR = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asS = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asT = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asR.getWidth();
        this.height = this.asR.getHeight();
        this.asX = this.asT.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.asW) {
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
                this.asU = true;
                this.mDownX = motionEvent.getX();
                this.asQ = this.mDownX;
                return true;
            case 1:
                this.asU = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asQ - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.asW = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asV && switchState != this.mState && this.asY != null) {
                    this.asY.a(this, this.mState);
                }
                this.asW = false;
                invalidate();
                return true;
            case 2:
                this.asQ = motionEvent.getX();
                if (Math.abs(this.asQ - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asQ - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asU = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.asW = true;
                if (this.asQ >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asV && switchState2 != this.mState && this.asY != null) {
                    this.asY.a(this, this.mState);
                }
                this.asW = false;
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
        if (this.asU) {
            if (this.asQ < this.width / 2.0f) {
                canvas.drawBitmap(this.asS, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asR, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asR, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asS, 0.0f, 0.0f, this.paint);
        }
        if (this.asU) {
            if (this.asQ > this.asR.getWidth()) {
                f = this.width - (this.asX / 2.0f);
            } else {
                f = this.asQ - (this.asX / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.asX;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.asX) {
            f = this.width - this.asX;
        }
        canvas.drawBitmap(this.asT, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.asW) {
            this.asW = true;
            if (switchState == SwitchState.ON) {
                this.asQ = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asQ = 0.0f;
            }
            if (z && switchState != this.mState && this.asY != null) {
                this.asY.a(this, switchState);
            }
            this.mState = switchState;
            this.asW = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asR = bitmap;
        this.asS = bitmap2;
        this.asT = bitmap3;
        invalidate();
    }

    public void rH() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void rI() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void rJ() {
        a(SwitchState.ON, true);
    }

    public void aA(boolean z) {
        if (this.mState != SwitchState.ON) {
            rJ();
        }
    }

    public void rK() {
        a(SwitchState.OFF, true);
    }

    public void aB(boolean z) {
        if (this.mState != SwitchState.OFF) {
            rK();
        }
    }

    public boolean nv() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.asV = true;
        this.asY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
