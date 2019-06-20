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
    private int KA;
    private a KB;
    private float Kt;
    private Bitmap Ku;
    private Bitmap Kv;
    private Bitmap Kw;
    private boolean Kx;
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
        this.Kx = false;
        this.Ky = false;
        this.Kz = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KA = 0;
        this.KB = null;
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
        this.Kx = false;
        this.Ky = false;
        this.Kz = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KA = 0;
        this.KB = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mX();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Ku = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Kv = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Kw = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Ku.getWidth();
        this.height = this.Ku.getHeight();
        this.KA = this.Kw.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Kz) {
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
                this.Kx = true;
                this.mDownX = motionEvent.getX();
                this.Kt = this.mDownX;
                return true;
            case 1:
                this.Kx = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Kt - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Kz = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Ky && switchState != this.mState && this.KB != null) {
                    this.KB.a(this, this.mState);
                }
                this.Kz = false;
                invalidate();
                return true;
            case 2:
                this.Kt = motionEvent.getX();
                if (Math.abs(this.Kt - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Kt - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Kx = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Kz = true;
                if (this.Kt >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Ky && switchState2 != this.mState && this.KB != null) {
                    this.KB.a(this, this.mState);
                }
                this.Kz = false;
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
        if (this.Kx) {
            if (this.Kt < this.width / 2.0f) {
                canvas.drawBitmap(this.Kv, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Ku, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Ku, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Kv, 0.0f, 0.0f, this.paint);
        }
        if (this.Kx) {
            if (this.Kt > this.Ku.getWidth()) {
                f = this.width - (this.KA / 2.0f);
            } else {
                f = this.Kt - (this.KA / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.KA;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.KA) {
            f = this.width - this.KA;
        }
        canvas.drawBitmap(this.Kw, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Kz) {
            this.Kz = true;
            if (switchState == SwitchState.ON) {
                this.Kt = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Kt = 0.0f;
            }
            if (z && switchState != this.mState && this.KB != null) {
                this.KB.a(this, switchState);
            }
            this.mState = switchState;
            this.Kz = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Ku = bitmap;
        this.Kv = bitmap2;
        this.Kw = bitmap3;
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
        this.Ky = true;
        this.KB = aVar;
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
