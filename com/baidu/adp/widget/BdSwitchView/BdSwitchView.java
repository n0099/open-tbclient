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
    private SwitchState EY;
    private float EZ;
    private float Fa;
    private Bitmap Fb;
    private Bitmap Fc;
    private Bitmap Fd;
    private boolean Fe;
    private boolean Ff;
    private boolean Fg;
    private int Fh;
    private b Fi;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Fk) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Fl) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    public BdSwitchView(Context context) {
        super(context);
        this.EY = SwitchState.ON;
        this.Fe = false;
        this.Ff = false;
        this.Fg = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fh = 0;
        this.Fi = null;
        this.mRunnable = new a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EY = SwitchState.ON;
        this.Fe = false;
        this.Ff = false;
        this.Fg = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Fh = 0;
        this.Fi = null;
        this.mRunnable = new a(this);
        init(context);
    }

    private void init(Context context) {
        this.Fb = BitmapFactory.decodeResource(getResources(), R.drawable.bg_game_switch_open);
        this.Fc = BitmapFactory.decodeResource(getResources(), R.drawable.bg_game_switch_close);
        this.Fd = BitmapFactory.decodeResource(getResources(), R.drawable.btn_game_handle);
        this.width = this.Fb.getWidth();
        this.height = this.Fb.getHeight();
        this.Fh = this.Fd.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Fg) {
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
                this.Fe = true;
                this.EZ = motionEvent.getX();
                this.Fa = this.EZ;
                return true;
            case 1:
                this.Fe = false;
                SwitchState switchState = this.EY;
                if (Math.abs(this.Fa - this.EZ) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Fg = true;
                if (motionEvent.getX() >= this.width / 2) {
                    this.EY = SwitchState.ON;
                } else {
                    this.EY = SwitchState.OFF;
                }
                if (this.Ff && switchState != this.EY && this.Fi != null) {
                    this.Fi.a(this, this.EY);
                }
                this.Fg = false;
                invalidate();
                return true;
            case 2:
                this.Fa = motionEvent.getX();
                if (Math.abs(this.Fa - this.EZ) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Fa - this.EZ) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Fe = false;
                SwitchState switchState2 = this.EY;
                removeCallbacks(this.mRunnable);
                this.Fg = true;
                if (this.Fa >= this.width / 2) {
                    this.EY = SwitchState.ON;
                } else {
                    this.EY = SwitchState.OFF;
                }
                if (this.Ff && switchState2 != this.EY && this.Fi != null) {
                    this.Fi.a(this, this.EY);
                }
                this.Fg = false;
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
        if (this.Fe) {
            if (this.Fa < this.width / 2) {
                canvas.drawBitmap(this.Fc, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Fb, 0.0f, 0.0f, this.paint);
            }
        } else if (this.EY == SwitchState.ON) {
            canvas.drawBitmap(this.Fb, 0.0f, 0.0f, this.paint);
        } else if (this.EY == SwitchState.OFF) {
            canvas.drawBitmap(this.Fc, 0.0f, 0.0f, this.paint);
        }
        if (this.Fe) {
            if (this.Fa > this.Fb.getWidth()) {
                f = this.width - (this.Fh / 2);
            } else {
                f = this.Fa - (this.Fh / 2);
            }
        } else if (this.EY == SwitchState.ON) {
            f = this.width - this.Fh;
        } else {
            f = this.EY == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Fh) {
            f = this.width - this.Fh;
        }
        canvas.drawBitmap(this.Fd, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Fg) {
            this.Fg = true;
            if (switchState == SwitchState.ON) {
                this.Fa = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Fa = 0.0f;
            }
            if (z && switchState != this.EY && this.Fi != null) {
                this.Fi.a(this, switchState);
            }
            this.EY = switchState;
            this.Fg = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Fb = bitmap;
        this.Fc = bitmap2;
        this.Fd = bitmap3;
        invalidate();
    }

    public void lY() {
        if (this.EY != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void lZ() {
        if (this.EY != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void ma() {
        a(SwitchState.ON, true);
    }

    public void L(boolean z) {
        if (this.EY != SwitchState.ON) {
            ma();
        }
    }

    public void mb() {
        a(SwitchState.OFF, true);
    }

    public void M(boolean z) {
        if (this.EY != SwitchState.OFF) {
            mb();
        }
    }

    public boolean hZ() {
        return this.EY == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        this.Ff = true;
        this.Fi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc() {
        if (this.EY == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.EY == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
