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
    private int width;
    private SwitchState wk;
    private float wl;
    private float wm;
    private Bitmap wn;
    private Bitmap wo;
    private Bitmap wp;
    private boolean wq;
    private boolean wr;
    private boolean ws;
    private int wt;
    private a wu;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (ww) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (wx) with 'values()' method */
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
        this.wk = SwitchState.ON;
        this.wq = false;
        this.wr = false;
        this.ws = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wt = 0;
        this.wu = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wk = SwitchState.ON;
        this.wq = false;
        this.wr = false;
        this.ws = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.wt = 0;
        this.wu = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.wn = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.wo = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.wp = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.wn.getWidth();
        this.height = this.wn.getHeight();
        this.wt = this.wp.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ws) {
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
                this.wq = true;
                this.wl = motionEvent.getX();
                this.wm = this.wl;
                return true;
            case 1:
                this.wq = false;
                SwitchState switchState = this.wk;
                if (Math.abs(this.wm - this.wl) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.ws = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.wk = SwitchState.ON;
                } else {
                    this.wk = SwitchState.OFF;
                }
                if (this.wr && switchState != this.wk && this.wu != null) {
                    this.wu.a(this, this.wk);
                }
                this.ws = false;
                invalidate();
                return true;
            case 2:
                this.wm = motionEvent.getX();
                if (Math.abs(this.wm - this.wl) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.wm - this.wl) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.wq = false;
                SwitchState switchState2 = this.wk;
                removeCallbacks(this.mRunnable);
                this.ws = true;
                if (this.wm >= this.width / 2.0f) {
                    this.wk = SwitchState.ON;
                } else {
                    this.wk = SwitchState.OFF;
                }
                if (this.wr && switchState2 != this.wk && this.wu != null) {
                    this.wu.a(this, this.wk);
                }
                this.ws = false;
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
        if (this.wq) {
            if (this.wm < this.width / 2.0f) {
                canvas.drawBitmap(this.wo, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.wn, 0.0f, 0.0f, this.paint);
            }
        } else if (this.wk == SwitchState.ON) {
            canvas.drawBitmap(this.wn, 0.0f, 0.0f, this.paint);
        } else if (this.wk == SwitchState.OFF) {
            canvas.drawBitmap(this.wo, 0.0f, 0.0f, this.paint);
        }
        if (this.wq) {
            if (this.wm > this.wn.getWidth()) {
                f = this.width - (this.wt / 2.0f);
            } else {
                f = this.wm - (this.wt / 2.0f);
            }
        } else if (this.wk == SwitchState.ON) {
            f = this.width - this.wt;
        } else {
            f = this.wk == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.wt) {
            f = this.width - this.wt;
        }
        canvas.drawBitmap(this.wp, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.ws) {
            this.ws = true;
            if (switchState == SwitchState.ON) {
                this.wm = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.wm = 0.0f;
            }
            if (z && switchState != this.wk && this.wu != null) {
                this.wu.a(this, switchState);
            }
            this.wk = switchState;
            this.ws = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.wn = bitmap;
        this.wo = bitmap2;
        this.wp = bitmap3;
        invalidate();
    }

    public void iz() {
        if (this.wk != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void iA() {
        if (this.wk != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void iB() {
        a(SwitchState.ON, true);
    }

    public void K(boolean z) {
        if (this.wk != SwitchState.ON) {
            iB();
        }
    }

    public void iC() {
        a(SwitchState.OFF, true);
    }

    public void L(boolean z) {
        if (this.wk != SwitchState.OFF) {
            iC();
        }
    }

    public boolean ed() {
        return this.wk == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.wr = true;
        this.wu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD() {
        if (this.wk == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.wk == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
