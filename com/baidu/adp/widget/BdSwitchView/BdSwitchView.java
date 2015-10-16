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
    private SwitchState ER;
    private float ES;
    private float ET;
    private Bitmap EU;
    private Bitmap EV;
    private Bitmap EW;
    private boolean EX;
    private boolean EY;
    private boolean EZ;
    private int Fa;
    private a Fb;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Fd) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Fe) with 'values()' method */
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
        this.ER = SwitchState.ON;
        this.EX = false;
        this.EY = false;
        this.EZ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fa = 0;
        this.Fb = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ER = SwitchState.ON;
        this.EX = false;
        this.EY = false;
        this.EZ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fa = 0;
        this.Fb = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.EU = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.EV = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.EW = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.EU.getWidth();
        this.height = this.EU.getHeight();
        this.Fa = this.EW.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.EZ) {
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
                this.EX = true;
                this.ES = motionEvent.getX();
                this.ET = this.ES;
                return true;
            case 1:
                this.EX = false;
                SwitchState switchState = this.ER;
                if (Math.abs(this.ET - this.ES) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.EZ = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.ER = SwitchState.ON;
                } else {
                    this.ER = SwitchState.OFF;
                }
                if (this.EY && switchState != this.ER && this.Fb != null) {
                    this.Fb.a(this, this.ER);
                }
                this.EZ = false;
                invalidate();
                return true;
            case 2:
                this.ET = motionEvent.getX();
                if (Math.abs(this.ET - this.ES) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.ET - this.ES) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.EX = false;
                SwitchState switchState2 = this.ER;
                removeCallbacks(this.mRunnable);
                this.EZ = true;
                if (this.ET >= this.width / 2.0f) {
                    this.ER = SwitchState.ON;
                } else {
                    this.ER = SwitchState.OFF;
                }
                if (this.EY && switchState2 != this.ER && this.Fb != null) {
                    this.Fb.a(this, this.ER);
                }
                this.EZ = false;
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
        if (this.EX) {
            if (this.ET < this.width / 2.0f) {
                canvas.drawBitmap(this.EV, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.EU, 0.0f, 0.0f, this.paint);
            }
        } else if (this.ER == SwitchState.ON) {
            canvas.drawBitmap(this.EU, 0.0f, 0.0f, this.paint);
        } else if (this.ER == SwitchState.OFF) {
            canvas.drawBitmap(this.EV, 0.0f, 0.0f, this.paint);
        }
        if (this.EX) {
            if (this.ET > this.EU.getWidth()) {
                f = this.width - (this.Fa / 2.0f);
            } else {
                f = this.ET - (this.Fa / 2.0f);
            }
        } else if (this.ER == SwitchState.ON) {
            f = this.width - this.Fa;
        } else {
            f = this.ER == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fa) {
            f = this.width - this.Fa;
        }
        canvas.drawBitmap(this.EW, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.EZ) {
            this.EZ = true;
            if (switchState == SwitchState.ON) {
                this.ET = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.ET = 0.0f;
            }
            if (z && switchState != this.ER && this.Fb != null) {
                this.Fb.a(this, switchState);
            }
            this.ER = switchState;
            this.EZ = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.EU = bitmap;
        this.EV = bitmap2;
        this.EW = bitmap3;
        invalidate();
    }

    public void mz() {
        if (this.ER != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void mA() {
        if (this.ER != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mB() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.ER != SwitchState.ON) {
            mB();
        }
    }

    public void mC() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.ER != SwitchState.OFF) {
            mC();
        }
    }

    public boolean hx() {
        return this.ER == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.EY = true;
        this.Fb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD() {
        if (this.ER == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.ER == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
