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
    private float asI;
    private Bitmap asJ;
    private Bitmap asK;
    private Bitmap asL;
    private boolean asM;
    private boolean asN;
    private boolean asO;
    private int asP;
    private a asQ;
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
        this.asM = false;
        this.asN = false;
        this.asO = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asP = 0;
        this.asQ = null;
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
        this.asM = false;
        this.asN = false;
        this.asO = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asP = 0;
        this.asQ = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rL();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asJ = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asK = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asL = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asJ.getWidth();
        this.height = this.asJ.getHeight();
        this.asP = this.asL.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.asO) {
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
                this.asM = true;
                this.mDownX = motionEvent.getX();
                this.asI = this.mDownX;
                return true;
            case 1:
                this.asM = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asI - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.asO = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asN && switchState != this.mState && this.asQ != null) {
                    this.asQ.a(this, this.mState);
                }
                this.asO = false;
                invalidate();
                return true;
            case 2:
                this.asI = motionEvent.getX();
                if (Math.abs(this.asI - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asI - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asM = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.asO = true;
                if (this.asI >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asN && switchState2 != this.mState && this.asQ != null) {
                    this.asQ.a(this, this.mState);
                }
                this.asO = false;
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
        if (this.asM) {
            if (this.asI < this.width / 2.0f) {
                canvas.drawBitmap(this.asK, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asJ, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asJ, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asK, 0.0f, 0.0f, this.paint);
        }
        if (this.asM) {
            if (this.asI > this.asJ.getWidth()) {
                f = this.width - (this.asP / 2.0f);
            } else {
                f = this.asI - (this.asP / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.asP;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.asP) {
            f = this.width - this.asP;
        }
        canvas.drawBitmap(this.asL, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.asO) {
            this.asO = true;
            if (switchState == SwitchState.ON) {
                this.asI = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asI = 0.0f;
            }
            if (z && switchState != this.mState && this.asQ != null) {
                this.asQ.a(this, switchState);
            }
            this.mState = switchState;
            this.asO = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asJ = bitmap;
        this.asK = bitmap2;
        this.asL = bitmap3;
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
        this.asN = true;
        this.asQ = aVar;
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
