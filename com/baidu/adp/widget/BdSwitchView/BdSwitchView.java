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
    private float LP;
    private Bitmap LQ;
    private Bitmap LR;
    private Bitmap LS;
    private boolean LU;
    private boolean LV;
    private boolean LW;
    private int LX;
    private a LY;
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
        this.LU = false;
        this.LV = false;
        this.LW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.LX = 0;
        this.LY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nM();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.LU = false;
        this.LV = false;
        this.LW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.LX = 0;
        this.LY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nM();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.LQ = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.LR = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.LS = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.LQ.getWidth();
        this.height = this.LQ.getHeight();
        this.LX = this.LS.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.LW) {
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
                this.LU = true;
                this.mDownX = motionEvent.getX();
                this.LP = this.mDownX;
                return true;
            case 1:
                this.LU = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.LP - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.LW = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.LV && switchState != this.mState && this.LY != null) {
                    this.LY.a(this, this.mState);
                }
                this.LW = false;
                invalidate();
                return true;
            case 2:
                this.LP = motionEvent.getX();
                if (Math.abs(this.LP - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.LP - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.LU = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.LW = true;
                if (this.LP >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.LV && switchState2 != this.mState && this.LY != null) {
                    this.LY.a(this, this.mState);
                }
                this.LW = false;
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
        if (this.LU) {
            if (this.LP < this.width / 2.0f) {
                canvas.drawBitmap(this.LR, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.LQ, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.LQ, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.LR, 0.0f, 0.0f, this.paint);
        }
        if (this.LU) {
            if (this.LP > this.LQ.getWidth()) {
                f = this.width - (this.LX / 2.0f);
            } else {
                f = this.LP - (this.LX / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.LX;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.LX) {
            f = this.width - this.LX;
        }
        canvas.drawBitmap(this.LS, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.LW) {
            this.LW = true;
            if (switchState == SwitchState.ON) {
                this.LP = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.LP = 0.0f;
            }
            if (z && switchState != this.mState && this.LY != null) {
                this.LY.a(this, switchState);
            }
            this.mState = switchState;
            this.LW = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.LQ = bitmap;
        this.LR = bitmap2;
        this.LS = bitmap3;
        invalidate();
    }

    public void nI() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nJ() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void nK() {
        a(SwitchState.ON, true);
    }

    public void ae(boolean z) {
        if (this.mState != SwitchState.ON) {
            nK();
        }
    }

    public void nL() {
        a(SwitchState.OFF, true);
    }

    public void af(boolean z) {
        if (this.mState != SwitchState.OFF) {
            nL();
        }
    }

    public boolean jw() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.LV = true;
        this.LY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
