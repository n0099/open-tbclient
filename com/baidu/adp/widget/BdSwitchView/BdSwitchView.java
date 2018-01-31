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
    private float asV;
    private Bitmap asW;
    private Bitmap asX;
    private Bitmap asY;
    private boolean asZ;
    private boolean ata;
    private boolean atb;
    private int atc;
    private a atd;
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
        this.asZ = false;
        this.ata = false;
        this.atb = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.atc = 0;
        this.atd = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rN();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.asZ = false;
        this.ata = false;
        this.atb = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.atc = 0;
        this.atd = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rN();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asW = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asX = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asY = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asW.getWidth();
        this.height = this.asW.getHeight();
        this.atc = this.asY.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.atb) {
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
                this.asZ = true;
                this.mDownX = motionEvent.getX();
                this.asV = this.mDownX;
                return true;
            case 1:
                this.asZ = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asV - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.atb = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.ata && switchState != this.mState && this.atd != null) {
                    this.atd.a(this, this.mState);
                }
                this.atb = false;
                invalidate();
                return true;
            case 2:
                this.asV = motionEvent.getX();
                if (Math.abs(this.asV - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asV - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asZ = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.atb = true;
                if (this.asV >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.ata && switchState2 != this.mState && this.atd != null) {
                    this.atd.a(this, this.mState);
                }
                this.atb = false;
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
        if (this.asZ) {
            if (this.asV < this.width / 2.0f) {
                canvas.drawBitmap(this.asX, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asW, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asW, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asX, 0.0f, 0.0f, this.paint);
        }
        if (this.asZ) {
            if (this.asV > this.asW.getWidth()) {
                f = this.width - (this.atc / 2.0f);
            } else {
                f = this.asV - (this.atc / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.atc;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.atc) {
            f = this.width - this.atc;
        }
        canvas.drawBitmap(this.asY, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.atb) {
            this.atb = true;
            if (switchState == SwitchState.ON) {
                this.asV = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asV = 0.0f;
            }
            if (z && switchState != this.mState && this.atd != null) {
                this.atd.a(this, switchState);
            }
            this.mState = switchState;
            this.atb = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asW = bitmap;
        this.asX = bitmap2;
        this.asY = bitmap3;
        invalidate();
    }

    public void rJ() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void rK() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void rL() {
        a(SwitchState.ON, true);
    }

    public void ax(boolean z) {
        if (this.mState != SwitchState.ON) {
            rL();
        }
    }

    public void rM() {
        a(SwitchState.OFF, true);
    }

    public void ay(boolean z) {
        if (this.mState != SwitchState.OFF) {
            rM();
        }
    }

    public boolean nv() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.ata = true;
        this.atd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
