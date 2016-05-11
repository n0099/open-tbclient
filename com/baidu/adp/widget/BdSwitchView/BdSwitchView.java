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
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private SwitchState wi;
    private int width;
    private float wj;
    private float wk;
    private Bitmap wl;
    private Bitmap wm;
    private Bitmap wn;
    private boolean wo;
    private boolean wp;
    private boolean wq;
    private int wr;
    private a ws;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (wu) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchState[] valuesCustom() {
            SwitchState[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchState[] switchStateArr = new SwitchState[length];
            System.arraycopy(valuesCustom, 0, switchStateArr, 0, length);
            return switchStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR;

        /* JADX DEBUG: Replace access to removed values field (wv) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, SwitchState switchState);
    }

    public BdSwitchView(Context context) {
        super(context);
        this.wi = SwitchState.ON;
        this.wo = false;
        this.wp = false;
        this.wq = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wr = 0;
        this.ws = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wi = SwitchState.ON;
        this.wo = false;
        this.wp = false;
        this.wq = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wr = 0;
        this.ws = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.wl = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.wm = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.wn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.wl.getWidth();
        this.height = this.wl.getHeight();
        this.wr = this.wn.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.wq) {
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
                this.wo = true;
                this.wj = motionEvent.getX();
                this.wk = this.wj;
                return true;
            case 1:
                this.wo = false;
                SwitchState switchState = this.wi;
                if (Math.abs(this.wk - this.wj) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.wq = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.wi = SwitchState.ON;
                } else {
                    this.wi = SwitchState.OFF;
                }
                if (this.wp && switchState != this.wi && this.ws != null) {
                    this.ws.a(this, this.wi);
                }
                this.wq = false;
                invalidate();
                return true;
            case 2:
                this.wk = motionEvent.getX();
                if (Math.abs(this.wk - this.wj) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.wk - this.wj) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.wo = false;
                SwitchState switchState2 = this.wi;
                removeCallbacks(this.mRunnable);
                this.wq = true;
                if (this.wk >= this.width / 2.0f) {
                    this.wi = SwitchState.ON;
                } else {
                    this.wi = SwitchState.OFF;
                }
                if (this.wp && switchState2 != this.wi && this.ws != null) {
                    this.ws.a(this, this.wi);
                }
                this.wq = false;
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
        if (this.wo) {
            if (this.wk < this.width / 2.0f) {
                canvas.drawBitmap(this.wm, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.wl, 0.0f, 0.0f, this.paint);
            }
        } else if (this.wi == SwitchState.ON) {
            canvas.drawBitmap(this.wl, 0.0f, 0.0f, this.paint);
        } else if (this.wi == SwitchState.OFF) {
            canvas.drawBitmap(this.wm, 0.0f, 0.0f, this.paint);
        }
        if (this.wo) {
            if (this.wk > this.wl.getWidth()) {
                f = this.width - (this.wr / 2.0f);
            } else {
                f = this.wk - (this.wr / 2.0f);
            }
        } else if (this.wi == SwitchState.ON) {
            f = this.width - this.wr;
        } else {
            f = this.wi == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.wr) {
            f = this.width - this.wr;
        }
        canvas.drawBitmap(this.wn, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.wq) {
            this.wq = true;
            if (switchState == SwitchState.ON) {
                this.wk = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.wk = 0.0f;
            }
            if (z && switchState != this.wi && this.ws != null) {
                this.ws.a(this, switchState);
            }
            this.wi = switchState;
            this.wq = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.wl = bitmap;
        this.wm = bitmap2;
        this.wn = bitmap3;
        invalidate();
    }

    public void iw() {
        if (this.wi != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void ix() {
        if (this.wi != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void iy() {
        a(SwitchState.ON, true);
    }

    public void K(boolean z) {
        if (this.wi != SwitchState.ON) {
            iy();
        }
    }

    public void iz() {
        a(SwitchState.OFF, true);
    }

    public void L(boolean z) {
        if (this.wi != SwitchState.OFF) {
            iz();
        }
    }

    public boolean ec() {
        return this.wi == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.wp = true;
        this.ws = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA() {
        if (this.wi == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.wi == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
