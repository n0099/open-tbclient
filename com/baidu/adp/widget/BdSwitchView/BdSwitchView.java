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
    private boolean MA;
    private boolean MC;
    private boolean MD;
    private int ME;
    private a MF;
    private float Mw;
    private Bitmap Mx;
    private Bitmap My;
    private Bitmap Mz;
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
        this.MA = false;
        this.MC = false;
        this.MD = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.ME = 0;
        this.MF = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nX();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.MA = false;
        this.MC = false;
        this.MD = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.ME = 0;
        this.MF = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nX();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Mx = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.My = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Mz = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Mx.getWidth();
        this.height = this.Mx.getHeight();
        this.ME = this.Mz.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.MD) {
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
                this.MA = true;
                this.mDownX = motionEvent.getX();
                this.Mw = this.mDownX;
                return true;
            case 1:
                this.MA = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Mw - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.MD = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.MC && switchState != this.mState && this.MF != null) {
                    this.MF.a(this, this.mState);
                }
                this.MD = false;
                invalidate();
                return true;
            case 2:
                this.Mw = motionEvent.getX();
                if (Math.abs(this.Mw - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Mw - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.MA = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.MD = true;
                if (this.Mw >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.MC && switchState2 != this.mState && this.MF != null) {
                    this.MF.a(this, this.mState);
                }
                this.MD = false;
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
        if (this.MA) {
            if (this.Mw < this.width / 2.0f) {
                canvas.drawBitmap(this.My, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Mx, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Mx, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.My, 0.0f, 0.0f, this.paint);
        }
        if (this.MA) {
            if (this.Mw > this.Mx.getWidth()) {
                f = this.width - (this.ME / 2.0f);
            } else {
                f = this.Mw - (this.ME / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.ME;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.ME) {
            f = this.width - this.ME;
        }
        canvas.drawBitmap(this.Mz, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.MD) {
            this.MD = true;
            if (switchState == SwitchState.ON) {
                this.Mw = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Mw = 0.0f;
            }
            if (z && switchState != this.mState && this.MF != null) {
                this.MF.a(this, switchState);
            }
            this.mState = switchState;
            this.MD = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Mx = bitmap;
        this.My = bitmap2;
        this.Mz = bitmap3;
        invalidate();
    }

    public void nT() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nU() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void nV() {
        a(SwitchState.ON, true);
    }

    public void ar(boolean z) {
        if (this.mState != SwitchState.ON) {
            nV();
        }
    }

    public void nW() {
        a(SwitchState.OFF, true);
    }

    public void as(boolean z) {
        if (this.mState != SwitchState.OFF) {
            nW();
        }
    }

    public boolean jJ() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.MC = true;
        this.MF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nX() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
