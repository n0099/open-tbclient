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
    private boolean JA;
    private int JB;
    private a JC;
    private float Ju;
    private Bitmap Jv;
    private Bitmap Jw;
    private Bitmap Jx;
    private boolean Jy;
    private boolean Jz;
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
        this.Jy = false;
        this.Jz = false;
        this.JA = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.JB = 0;
        this.JC = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mG();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Jy = false;
        this.Jz = false;
        this.JA = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.JB = 0;
        this.JC = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.mG();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Jv = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Jw = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Jx = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Jv.getWidth();
        this.height = this.Jv.getHeight();
        this.JB = this.Jx.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.JA) {
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
                this.Jy = true;
                this.mDownX = motionEvent.getX();
                this.Ju = this.mDownX;
                return true;
            case 1:
                this.Jy = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Ju - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.JA = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Jz && switchState != this.mState && this.JC != null) {
                    this.JC.a(this, this.mState);
                }
                this.JA = false;
                invalidate();
                return true;
            case 2:
                this.Ju = motionEvent.getX();
                if (Math.abs(this.Ju - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Ju - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Jy = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.JA = true;
                if (this.Ju >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Jz && switchState2 != this.mState && this.JC != null) {
                    this.JC.a(this, this.mState);
                }
                this.JA = false;
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
        if (this.Jy) {
            if (this.Ju < this.width / 2.0f) {
                canvas.drawBitmap(this.Jw, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Jv, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Jv, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Jw, 0.0f, 0.0f, this.paint);
        }
        if (this.Jy) {
            if (this.Ju > this.Jv.getWidth()) {
                f = this.width - (this.JB / 2.0f);
            } else {
                f = this.Ju - (this.JB / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.JB;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.JB) {
            f = this.width - this.JB;
        }
        canvas.drawBitmap(this.Jx, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.JA) {
            this.JA = true;
            if (switchState == SwitchState.ON) {
                this.Ju = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Ju = 0.0f;
            }
            if (z && switchState != this.mState && this.JC != null) {
                this.JC.a(this, switchState);
            }
            this.mState = switchState;
            this.JA = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Jv = bitmap;
        this.Jw = bitmap2;
        this.Jx = bitmap3;
        invalidate();
    }

    public void mC() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mD() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mE() {
        a(SwitchState.ON, true);
    }

    public void U(boolean z) {
        if (this.mState != SwitchState.ON) {
            mE();
        }
    }

    public void mF() {
        a(SwitchState.OFF, true);
    }

    public void V(boolean z) {
        if (this.mState != SwitchState.OFF) {
            mF();
        }
    }

    public boolean iq() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Jz = true;
        this.JC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
