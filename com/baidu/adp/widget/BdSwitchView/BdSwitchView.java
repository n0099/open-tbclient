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
    private SwitchState ES;
    private float ET;
    private float EU;
    private Bitmap EV;
    private Bitmap EW;
    private Bitmap EX;
    private boolean EY;
    private boolean EZ;
    private boolean Fa;
    private int Fb;
    private a Fc;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Fe) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Ff) with 'values()' method */
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
        this.ES = SwitchState.ON;
        this.EY = false;
        this.EZ = false;
        this.Fa = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fb = 0;
        this.Fc = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ES = SwitchState.ON;
        this.EY = false;
        this.EZ = false;
        this.Fa = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fb = 0;
        this.Fc = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.EV = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.EW = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.EX = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.EV.getWidth();
        this.height = this.EV.getHeight();
        this.Fb = this.EX.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fa) {
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
                this.EY = true;
                this.ET = motionEvent.getX();
                this.EU = this.ET;
                return true;
            case 1:
                this.EY = false;
                SwitchState switchState = this.ES;
                if (Math.abs(this.EU - this.ET) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fa = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.ES = SwitchState.ON;
                } else {
                    this.ES = SwitchState.OFF;
                }
                if (this.EZ && switchState != this.ES && this.Fc != null) {
                    this.Fc.a(this, this.ES);
                }
                this.Fa = false;
                invalidate();
                return true;
            case 2:
                this.EU = motionEvent.getX();
                if (Math.abs(this.EU - this.ET) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.EU - this.ET) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.EY = false;
                SwitchState switchState2 = this.ES;
                removeCallbacks(this.mRunnable);
                this.Fa = true;
                if (this.EU >= this.width / 2.0f) {
                    this.ES = SwitchState.ON;
                } else {
                    this.ES = SwitchState.OFF;
                }
                if (this.EZ && switchState2 != this.ES && this.Fc != null) {
                    this.Fc.a(this, this.ES);
                }
                this.Fa = false;
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
        if (this.EY) {
            if (this.EU < this.width / 2.0f) {
                canvas.drawBitmap(this.EW, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.EV, 0.0f, 0.0f, this.paint);
            }
        } else if (this.ES == SwitchState.ON) {
            canvas.drawBitmap(this.EV, 0.0f, 0.0f, this.paint);
        } else if (this.ES == SwitchState.OFF) {
            canvas.drawBitmap(this.EW, 0.0f, 0.0f, this.paint);
        }
        if (this.EY) {
            if (this.EU > this.EV.getWidth()) {
                f = this.width - (this.Fb / 2.0f);
            } else {
                f = this.EU - (this.Fb / 2.0f);
            }
        } else if (this.ES == SwitchState.ON) {
            f = this.width - this.Fb;
        } else {
            f = this.ES == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fb) {
            f = this.width - this.Fb;
        }
        canvas.drawBitmap(this.EX, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fa) {
            this.Fa = true;
            if (switchState == SwitchState.ON) {
                this.EU = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.EU = 0.0f;
            }
            if (z && switchState != this.ES && this.Fc != null) {
                this.Fc.a(this, switchState);
            }
            this.ES = switchState;
            this.Fa = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.EV = bitmap;
        this.EW = bitmap2;
        this.EX = bitmap3;
        invalidate();
    }

    public void mA() {
        if (this.ES != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mB() {
        if (this.ES != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mC() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.ES != SwitchState.ON) {
            mC();
        }
    }

    public void mD() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.ES != SwitchState.OFF) {
            mD();
        }
    }

    public boolean hy() {
        return this.ES == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.EZ = true;
        this.Fc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE() {
        if (this.ES == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.ES == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
