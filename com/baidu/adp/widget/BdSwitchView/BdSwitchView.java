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
    private float Fd;
    private float Fe;
    private Bitmap Ff;
    private Bitmap Fg;
    private Bitmap Fh;
    private boolean Fi;
    private boolean Fj;
    private boolean Fk;
    private int Fl;
    private a Fm;
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
        this.Fi = false;
        this.Fj = false;
        this.Fk = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fl = 0;
        this.Fm = null;
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
        this.Fi = false;
        this.Fj = false;
        this.Fk = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fl = 0;
        this.Fm = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kq();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Ff = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Fg = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Fh = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Ff.getWidth();
        this.height = this.Ff.getHeight();
        this.Fl = this.Fh.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fk) {
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
                this.Fi = true;
                this.Fd = motionEvent.getX();
                this.Fe = this.Fd;
                return true;
            case 1:
                this.Fi = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Fe - this.Fd) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fk = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fj && switchState != this.mState && this.Fm != null) {
                    this.Fm.a(this, this.mState);
                }
                this.Fk = false;
                invalidate();
                return true;
            case 2:
                this.Fe = motionEvent.getX();
                if (Math.abs(this.Fe - this.Fd) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Fe - this.Fd) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Fi = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Fk = true;
                if (this.Fe >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Fj && switchState2 != this.mState && this.Fm != null) {
                    this.Fm.a(this, this.mState);
                }
                this.Fk = false;
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
        if (this.Fi) {
            if (this.Fe < this.width / 2.0f) {
                canvas.drawBitmap(this.Fg, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Ff, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Ff, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Fg, 0.0f, 0.0f, this.paint);
        }
        if (this.Fi) {
            if (this.Fe > this.Ff.getWidth()) {
                f = this.width - (this.Fl / 2.0f);
            } else {
                f = this.Fe - (this.Fl / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Fl;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fl) {
            f = this.width - this.Fl;
        }
        canvas.drawBitmap(this.Fh, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fk) {
            this.Fk = true;
            if (switchState == SwitchState.ON) {
                this.Fe = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Fe = 0.0f;
            }
            if (z && switchState != this.mState && this.Fm != null) {
                this.Fm.a(this, switchState);
            }
            this.mState = switchState;
            this.Fk = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Ff = bitmap;
        this.Fg = bitmap2;
        this.Fh = bitmap3;
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
        this.Fj = true;
        this.Fm = aVar;
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
