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
    private float Hf;
    private float Hg;
    private Bitmap Hh;
    private Bitmap Hi;
    private Bitmap Hj;
    private boolean Hk;
    private boolean Hl;
    private boolean Hm;
    private int Hn;
    private a Ho;
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
        this.Hk = false;
        this.Hl = false;
        this.Hm = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Hn = 0;
        this.Ho = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kA();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Hk = false;
        this.Hl = false;
        this.Hm = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Hn = 0;
        this.Ho = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kA();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Hh = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Hi = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Hj = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Hh.getWidth();
        this.height = this.Hh.getHeight();
        this.Hn = this.Hj.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Hm) {
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
                this.Hk = true;
                this.Hf = motionEvent.getX();
                this.Hg = this.Hf;
                return true;
            case 1:
                this.Hk = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Hg - this.Hf) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Hm = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Hl && switchState != this.mState && this.Ho != null) {
                    this.Ho.a(this, this.mState);
                }
                this.Hm = false;
                invalidate();
                return true;
            case 2:
                this.Hg = motionEvent.getX();
                if (Math.abs(this.Hg - this.Hf) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Hg - this.Hf) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Hk = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Hm = true;
                if (this.Hg >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Hl && switchState2 != this.mState && this.Ho != null) {
                    this.Ho.a(this, this.mState);
                }
                this.Hm = false;
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
        if (this.Hk) {
            if (this.Hg < this.width / 2.0f) {
                canvas.drawBitmap(this.Hi, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Hh, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Hh, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Hi, 0.0f, 0.0f, this.paint);
        }
        if (this.Hk) {
            if (this.Hg > this.Hh.getWidth()) {
                f = this.width - (this.Hn / 2.0f);
            } else {
                f = this.Hg - (this.Hn / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Hn;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Hn) {
            f = this.width - this.Hn;
        }
        canvas.drawBitmap(this.Hj, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Hm) {
            this.Hm = true;
            if (switchState == SwitchState.ON) {
                this.Hg = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Hg = 0.0f;
            }
            if (z && switchState != this.mState && this.Ho != null) {
                this.Ho.a(this, switchState);
            }
            this.mState = switchState;
            this.Hm = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Hh = bitmap;
        this.Hi = bitmap2;
        this.Hj = bitmap3;
        invalidate();
    }

    public void kw() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void kx() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void ky() {
        a(SwitchState.ON, true);
    }

    public void P(boolean z) {
        if (this.mState != SwitchState.ON) {
            ky();
        }
    }

    public void kz() {
        a(SwitchState.OFF, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.OFF) {
            kz();
        }
    }

    public boolean ge() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Hl = true;
        this.Ho = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
