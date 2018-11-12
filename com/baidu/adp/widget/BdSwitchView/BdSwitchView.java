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
    private float Mn;
    private Bitmap Mo;
    private Bitmap Mp;
    private Bitmap Mq;
    private boolean Mr;
    private boolean Ms;
    private boolean Mt;
    private int Mu;
    private a Mv;
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
        this.Mr = false;
        this.Ms = false;
        this.Mt = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Mu = 0;
        this.Mv = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nU();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Mr = false;
        this.Ms = false;
        this.Mt = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Mu = 0;
        this.Mv = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nU();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Mo = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Mp = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Mq = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Mo.getWidth();
        this.height = this.Mo.getHeight();
        this.Mu = this.Mq.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Mt) {
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
                this.Mr = true;
                this.mDownX = motionEvent.getX();
                this.Mn = this.mDownX;
                return true;
            case 1:
                this.Mr = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Mn - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Mt = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Ms && switchState != this.mState && this.Mv != null) {
                    this.Mv.a(this, this.mState);
                }
                this.Mt = false;
                invalidate();
                return true;
            case 2:
                this.Mn = motionEvent.getX();
                if (Math.abs(this.Mn - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Mn - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Mr = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Mt = true;
                if (this.Mn >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Ms && switchState2 != this.mState && this.Mv != null) {
                    this.Mv.a(this, this.mState);
                }
                this.Mt = false;
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
        if (this.Mr) {
            if (this.Mn < this.width / 2.0f) {
                canvas.drawBitmap(this.Mp, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Mo, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Mo, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Mp, 0.0f, 0.0f, this.paint);
        }
        if (this.Mr) {
            if (this.Mn > this.Mo.getWidth()) {
                f = this.width - (this.Mu / 2.0f);
            } else {
                f = this.Mn - (this.Mu / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Mu;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Mu) {
            f = this.width - this.Mu;
        }
        canvas.drawBitmap(this.Mq, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Mt) {
            this.Mt = true;
            if (switchState == SwitchState.ON) {
                this.Mn = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Mn = 0.0f;
            }
            if (z && switchState != this.mState && this.Mv != null) {
                this.Mv.a(this, switchState);
            }
            this.mState = switchState;
            this.Mt = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Mo = bitmap;
        this.Mp = bitmap2;
        this.Mq = bitmap3;
        invalidate();
    }

    public void nQ() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nR() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void nS() {
        a(SwitchState.ON, true);
    }

    public void ar(boolean z) {
        if (this.mState != SwitchState.ON) {
            nS();
        }
    }

    public void nT() {
        a(SwitchState.OFF, true);
    }

    public void as(boolean z) {
        if (this.mState != SwitchState.OFF) {
            nT();
        }
    }

    public boolean jJ() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Ms = true;
        this.Mv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
