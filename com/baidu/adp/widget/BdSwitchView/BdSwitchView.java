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
    private Bitmap JA;
    private boolean JB;
    private boolean JC;
    private boolean JD;
    private int JE;
    private a JF;
    private float Jx;
    private Bitmap Jy;
    private Bitmap Jz;
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
        this.JB = false;
        this.JC = false;
        this.JD = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.JE = 0;
        this.JF = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mE();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.JB = false;
        this.JC = false;
        this.JD = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.JE = 0;
        this.JF = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mE();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Jy = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Jz = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.JA = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Jy.getWidth();
        this.height = this.Jy.getHeight();
        this.JE = this.JA.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.JD) {
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
                this.JB = true;
                this.mDownX = motionEvent.getX();
                this.Jx = this.mDownX;
                return true;
            case 1:
                this.JB = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Jx - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.JD = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.JC && switchState != this.mState && this.JF != null) {
                    this.JF.a(this, this.mState);
                }
                this.JD = false;
                invalidate();
                return true;
            case 2:
                this.Jx = motionEvent.getX();
                if (Math.abs(this.Jx - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Jx - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.JB = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.JD = true;
                if (this.Jx >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.JC && switchState2 != this.mState && this.JF != null) {
                    this.JF.a(this, this.mState);
                }
                this.JD = false;
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
        if (this.JB) {
            if (this.Jx < this.width / 2.0f) {
                canvas.drawBitmap(this.Jz, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Jy, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Jy, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Jz, 0.0f, 0.0f, this.paint);
        }
        if (this.JB) {
            if (this.Jx > this.Jy.getWidth()) {
                f = this.width - (this.JE / 2.0f);
            } else {
                f = this.Jx - (this.JE / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.JE;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.JE) {
            f = this.width - this.JE;
        }
        canvas.drawBitmap(this.JA, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.JD) {
            this.JD = true;
            if (switchState == SwitchState.ON) {
                this.Jx = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Jx = 0.0f;
            }
            if (z && switchState != this.mState && this.JF != null) {
                this.JF.a(this, switchState);
            }
            this.mState = switchState;
            this.JD = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Jy = bitmap;
        this.Jz = bitmap2;
        this.JA = bitmap3;
        invalidate();
    }

    public void mA() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mB() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mC() {
        a(SwitchState.ON, true);
    }

    public void V(boolean z) {
        if (this.mState != SwitchState.ON) {
            mC();
        }
    }

    public void mD() {
        a(SwitchState.OFF, true);
    }

    public void W(boolean z) {
        if (this.mState != SwitchState.OFF) {
            mD();
        }
    }

    public boolean ip() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.JC = true;
        this.JF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
