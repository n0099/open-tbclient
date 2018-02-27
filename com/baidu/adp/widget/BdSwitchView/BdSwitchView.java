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
    private float asH;
    private Bitmap asI;
    private Bitmap asJ;
    private Bitmap asK;
    private boolean asL;
    private boolean asM;
    private boolean asN;
    private int asO;
    private a asP;
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
        this.asL = false;
        this.asM = false;
        this.asN = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asO = 0;
        this.asP = null;
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
        this.asL = false;
        this.asM = false;
        this.asN = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asO = 0;
        this.asP = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rL();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asI = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asJ = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asK = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asI.getWidth();
        this.height = this.asI.getHeight();
        this.asO = this.asK.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.asN) {
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
                this.asL = true;
                this.mDownX = motionEvent.getX();
                this.asH = this.mDownX;
                return true;
            case 1:
                this.asL = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asH - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.asN = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asM && switchState != this.mState && this.asP != null) {
                    this.asP.a(this, this.mState);
                }
                this.asN = false;
                invalidate();
                return true;
            case 2:
                this.asH = motionEvent.getX();
                if (Math.abs(this.asH - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asH - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asL = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.asN = true;
                if (this.asH >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asM && switchState2 != this.mState && this.asP != null) {
                    this.asP.a(this, this.mState);
                }
                this.asN = false;
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
        if (this.asL) {
            if (this.asH < this.width / 2.0f) {
                canvas.drawBitmap(this.asJ, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asI, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asI, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asJ, 0.0f, 0.0f, this.paint);
        }
        if (this.asL) {
            if (this.asH > this.asI.getWidth()) {
                f = this.width - (this.asO / 2.0f);
            } else {
                f = this.asH - (this.asO / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.asO;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.asO) {
            f = this.width - this.asO;
        }
        canvas.drawBitmap(this.asK, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.asN) {
            this.asN = true;
            if (switchState == SwitchState.ON) {
                this.asH = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asH = 0.0f;
            }
            if (z && switchState != this.mState && this.asP != null) {
                this.asP.a(this, switchState);
            }
            this.mState = switchState;
            this.asN = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asI = bitmap;
        this.asJ = bitmap2;
        this.asK = bitmap3;
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
        this.asM = true;
        this.asP = aVar;
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
