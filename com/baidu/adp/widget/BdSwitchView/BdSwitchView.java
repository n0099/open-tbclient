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
    private float Fb;
    private float Fc;
    private Bitmap Fd;
    private Bitmap Fe;
    private Bitmap Ff;
    private boolean Fg;
    private boolean Fh;
    private boolean Fi;
    private int Fj;
    private a Fk;
    private int height;
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
        this.Fg = false;
        this.Fh = false;
        this.Fi = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fj = 0;
        this.Fk = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kr();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Fg = false;
        this.Fh = false;
        this.Fi = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fj = 0;
        this.Fk = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kr();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Fd = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Fe = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Ff = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Fd.getWidth();
        this.height = this.Fd.getHeight();
        this.Fj = this.Ff.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fi) {
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
                this.Fg = true;
                this.Fb = motionEvent.getX();
                this.Fc = this.Fb;
                return true;
            case 1:
                this.Fg = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Fc - this.Fb) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fi = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fh && switchState != this.mState && this.Fk != null) {
                    this.Fk.a(this, this.mState);
                }
                this.Fi = false;
                invalidate();
                return true;
            case 2:
                this.Fc = motionEvent.getX();
                if (Math.abs(this.Fc - this.Fb) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Fc - this.Fb) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Fg = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Fi = true;
                if (this.Fc >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fh && switchState2 != this.mState && this.Fk != null) {
                    this.Fk.a(this, this.mState);
                }
                this.Fi = false;
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
        if (this.Fg) {
            if (this.Fc < this.width / 2.0f) {
                canvas.drawBitmap(this.Fe, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Fd, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Fd, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Fe, 0.0f, 0.0f, this.paint);
        }
        if (this.Fg) {
            if (this.Fc > this.Fd.getWidth()) {
                f = this.width - (this.Fj / 2.0f);
            } else {
                f = this.Fc - (this.Fj / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Fj;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fj) {
            f = this.width - this.Fj;
        }
        canvas.drawBitmap(this.Ff, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fi) {
            this.Fi = true;
            if (switchState == SwitchState.ON) {
                this.Fc = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Fc = 0.0f;
            }
            if (z && switchState != this.mState && this.Fk != null) {
                this.Fk.a(this, switchState);
            }
            this.mState = switchState;
            this.Fi = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Fd = bitmap;
        this.Fe = bitmap2;
        this.Ff = bitmap3;
        invalidate();
    }

    public void kn() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void ko() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void kp() {
        a(SwitchState.ON, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.ON) {
            kp();
        }
    }

    public void kq() {
        a(SwitchState.OFF, true);
    }

    public void R(boolean z) {
        if (this.mState != SwitchState.OFF) {
            kq();
        }
    }

    public boolean fT() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Fh = true;
        this.Fk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
