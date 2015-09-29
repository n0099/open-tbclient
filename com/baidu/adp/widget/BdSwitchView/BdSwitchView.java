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
    private SwitchState EQ;
    private float ER;
    private float ES;
    private Bitmap ET;
    private Bitmap EU;
    private Bitmap EV;
    private boolean EW;
    private boolean EX;
    private boolean EY;
    private int EZ;
    private a Fa;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Fc) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Fd) with 'values()' method */
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
        this.EQ = SwitchState.ON;
        this.EW = false;
        this.EX = false;
        this.EY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EZ = 0;
        this.Fa = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EQ = SwitchState.ON;
        this.EW = false;
        this.EX = false;
        this.EY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EZ = 0;
        this.Fa = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.ET = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.EU = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.EV = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.ET.getWidth();
        this.height = this.ET.getHeight();
        this.EZ = this.EV.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.EY) {
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
                this.EW = true;
                this.ER = motionEvent.getX();
                this.ES = this.ER;
                return true;
            case 1:
                this.EW = false;
                SwitchState switchState = this.EQ;
                if (Math.abs(this.ES - this.ER) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.EY = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.EQ = SwitchState.ON;
                } else {
                    this.EQ = SwitchState.OFF;
                }
                if (this.EX && switchState != this.EQ && this.Fa != null) {
                    this.Fa.a(this, this.EQ);
                }
                this.EY = false;
                invalidate();
                return true;
            case 2:
                this.ES = motionEvent.getX();
                if (Math.abs(this.ES - this.ER) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.ES - this.ER) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.EW = false;
                SwitchState switchState2 = this.EQ;
                removeCallbacks(this.mRunnable);
                this.EY = true;
                if (this.ES >= this.width / 2.0f) {
                    this.EQ = SwitchState.ON;
                } else {
                    this.EQ = SwitchState.OFF;
                }
                if (this.EX && switchState2 != this.EQ && this.Fa != null) {
                    this.Fa.a(this, this.EQ);
                }
                this.EY = false;
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
        if (this.EW) {
            if (this.ES < this.width / 2.0f) {
                canvas.drawBitmap(this.EU, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.ET, 0.0f, 0.0f, this.paint);
            }
        } else if (this.EQ == SwitchState.ON) {
            canvas.drawBitmap(this.ET, 0.0f, 0.0f, this.paint);
        } else if (this.EQ == SwitchState.OFF) {
            canvas.drawBitmap(this.EU, 0.0f, 0.0f, this.paint);
        }
        if (this.EW) {
            if (this.ES > this.ET.getWidth()) {
                f = this.width - (this.EZ / 2.0f);
            } else {
                f = this.ES - (this.EZ / 2.0f);
            }
        } else if (this.EQ == SwitchState.ON) {
            f = this.width - this.EZ;
        } else {
            f = this.EQ == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.EZ) {
            f = this.width - this.EZ;
        }
        canvas.drawBitmap(this.EV, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.EY) {
            this.EY = true;
            if (switchState == SwitchState.ON) {
                this.ES = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.ES = 0.0f;
            }
            if (z && switchState != this.EQ && this.Fa != null) {
                this.Fa.a(this, switchState);
            }
            this.EQ = switchState;
            this.EY = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.ET = bitmap;
        this.EU = bitmap2;
        this.EV = bitmap3;
        invalidate();
    }

    public void mz() {
        if (this.EQ != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mA() {
        if (this.EQ != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mB() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.EQ != SwitchState.ON) {
            mB();
        }
    }

    public void mC() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.EQ != SwitchState.OFF) {
            mC();
        }
    }

    public boolean hx() {
        return this.EQ == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.EX = true;
        this.Fa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD() {
        if (this.EQ == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.EQ == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
