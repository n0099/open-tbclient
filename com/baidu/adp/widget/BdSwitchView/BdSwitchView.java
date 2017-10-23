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
    private float Fe;
    private float Ff;
    private Bitmap Fg;
    private Bitmap Fh;
    private Bitmap Fi;
    private boolean Fj;
    private boolean Fk;
    private boolean Fl;
    private int Fm;
    private a Fn;
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
        this.Fj = false;
        this.Fk = false;
        this.Fl = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fm = 0;
        this.Fn = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kq();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Fj = false;
        this.Fk = false;
        this.Fl = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fm = 0;
        this.Fn = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kq();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Fg = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Fh = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Fi = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Fg.getWidth();
        this.height = this.Fg.getHeight();
        this.Fm = this.Fi.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fl) {
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
                this.Fj = true;
                this.Fe = motionEvent.getX();
                this.Ff = this.Fe;
                return true;
            case 1:
                this.Fj = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Ff - this.Fe) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fl = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fk && switchState != this.mState && this.Fn != null) {
                    this.Fn.a(this, this.mState);
                }
                this.Fl = false;
                invalidate();
                return true;
            case 2:
                this.Ff = motionEvent.getX();
                if (Math.abs(this.Ff - this.Fe) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Ff - this.Fe) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Fj = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Fl = true;
                if (this.Ff >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fk && switchState2 != this.mState && this.Fn != null) {
                    this.Fn.a(this, this.mState);
                }
                this.Fl = false;
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
        if (this.Fj) {
            if (this.Ff < this.width / 2.0f) {
                canvas.drawBitmap(this.Fh, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Fg, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Fg, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Fh, 0.0f, 0.0f, this.paint);
        }
        if (this.Fj) {
            if (this.Ff > this.Fg.getWidth()) {
                f = this.width - (this.Fm / 2.0f);
            } else {
                f = this.Ff - (this.Fm / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Fm;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fm) {
            f = this.width - this.Fm;
        }
        canvas.drawBitmap(this.Fi, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fl) {
            this.Fl = true;
            if (switchState == SwitchState.ON) {
                this.Ff = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Ff = 0.0f;
            }
            if (z && switchState != this.mState && this.Fn != null) {
                this.Fn.a(this, switchState);
            }
            this.mState = switchState;
            this.Fl = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Fg = bitmap;
        this.Fh = bitmap2;
        this.Fi = bitmap3;
        invalidate();
    }

    public void km() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void kn() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void ko() {
        a(SwitchState.ON, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.ON) {
            ko();
        }
    }

    public void kp() {
        a(SwitchState.OFF, true);
    }

    public void R(boolean z) {
        if (this.mState != SwitchState.OFF) {
            kp();
        }
    }

    public boolean fS() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Fk = true;
        this.Fn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
