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
    private boolean KA;
    private int KB;
    private a KC;
    private float Ku;
    private Bitmap Kv;
    private Bitmap Kw;
    private Bitmap Kx;
    private boolean Ky;
    private boolean Kz;
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
        this.Ky = false;
        this.Kz = false;
        this.KA = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KB = 0;
        this.KC = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mX();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Ky = false;
        this.Kz = false;
        this.KA = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KB = 0;
        this.KC = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mX();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Kv = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Kw = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Kx = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Kv.getWidth();
        this.height = this.Kv.getHeight();
        this.KB = this.Kx.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.KA) {
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
                this.Ky = true;
                this.mDownX = motionEvent.getX();
                this.Ku = this.mDownX;
                return true;
            case 1:
                this.Ky = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Ku - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.KA = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Kz && switchState != this.mState && this.KC != null) {
                    this.KC.a(this, this.mState);
                }
                this.KA = false;
                invalidate();
                return true;
            case 2:
                this.Ku = motionEvent.getX();
                if (Math.abs(this.Ku - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Ku - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Ky = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.KA = true;
                if (this.Ku >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Kz && switchState2 != this.mState && this.KC != null) {
                    this.KC.a(this, this.mState);
                }
                this.KA = false;
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
        if (this.Ky) {
            if (this.Ku < this.width / 2.0f) {
                canvas.drawBitmap(this.Kw, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Kv, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Kv, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Kw, 0.0f, 0.0f, this.paint);
        }
        if (this.Ky) {
            if (this.Ku > this.Kv.getWidth()) {
                f = this.width - (this.KB / 2.0f);
            } else {
                f = this.Ku - (this.KB / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.KB;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.KB) {
            f = this.width - this.KB;
        }
        canvas.drawBitmap(this.Kx, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.KA) {
            this.KA = true;
            if (switchState == SwitchState.ON) {
                this.Ku = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Ku = 0.0f;
            }
            if (z && switchState != this.mState && this.KC != null) {
                this.KC.a(this, switchState);
            }
            this.mState = switchState;
            this.KA = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Kv = bitmap;
        this.Kw = bitmap2;
        this.Kx = bitmap3;
        invalidate();
    }

    public void mT() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mU() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mV() {
        a(SwitchState.ON, true);
    }

    public void ak(boolean z) {
        if (this.mState != SwitchState.ON) {
            mV();
        }
    }

    public void mW() {
        a(SwitchState.OFF, true);
    }

    public void al(boolean z) {
        if (this.mState != SwitchState.OFF) {
            mW();
        }
    }

    public boolean iE() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Kz = true;
        this.KC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
