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
    private float Dm;
    private Bitmap Dn;
    private Bitmap Do;
    private Bitmap Dp;
    private boolean Dq;
    private boolean Dr;
    private boolean Ds;
    private int Dt;
    private a Du;
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
        void a(View view2, SwitchState switchState);
    }

    public BdSwitchView(Context context) {
        super(context);
        this.mState = SwitchState.ON;
        this.Dq = false;
        this.Dr = false;
        this.Ds = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Dt = 0;
        this.Du = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.jQ();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Dq = false;
        this.Dr = false;
        this.Ds = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Dt = 0;
        this.Du = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.jQ();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Dn = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Do = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Dp = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Dn.getWidth();
        this.height = this.Dn.getHeight();
        this.Dt = this.Dp.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.Ds) {
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
                this.Dq = true;
                this.mDownX = motionEvent.getX();
                this.Dm = this.mDownX;
                return true;
            case 1:
                this.Dq = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Dm - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Ds = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Dr && switchState != this.mState && this.Du != null) {
                    this.Du.a(this, this.mState);
                }
                this.Ds = false;
                invalidate();
                return true;
            case 2:
                this.Dm = motionEvent.getX();
                if (Math.abs(this.Dm - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Dm - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Dq = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Ds = true;
                if (this.Dm >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Dr && switchState2 != this.mState && this.Du != null) {
                    this.Du.a(this, this.mState);
                }
                this.Ds = false;
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
        if (this.Dq) {
            if (this.Dm < this.width / 2.0f) {
                canvas.drawBitmap(this.Do, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Dn, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Dn, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Do, 0.0f, 0.0f, this.paint);
        }
        if (this.Dq) {
            if (this.Dm > this.Dn.getWidth()) {
                f = this.width - (this.Dt / 2.0f);
            } else {
                f = this.Dm - (this.Dt / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Dt;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Dt) {
            f = this.width - this.Dt;
        }
        canvas.drawBitmap(this.Dp, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Ds) {
            this.Ds = true;
            if (switchState == SwitchState.ON) {
                this.Dm = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Dm = 0.0f;
            }
            if (z && switchState != this.mState && this.Du != null) {
                this.Du.a(this, switchState);
            }
            this.mState = switchState;
            this.Ds = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Dn = bitmap;
        this.Do = bitmap2;
        this.Dp = bitmap3;
        invalidate();
    }

    public void jM() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void jN() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void jO() {
        a(SwitchState.ON, true);
    }

    public void T(boolean z) {
        if (this.mState != SwitchState.ON) {
            jO();
        }
    }

    public void jP() {
        a(SwitchState.OFF, true);
    }

    public void U(boolean z) {
        if (this.mState != SwitchState.OFF) {
            jP();
        }
    }

    public boolean fz() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Dr = true;
        this.Du = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
