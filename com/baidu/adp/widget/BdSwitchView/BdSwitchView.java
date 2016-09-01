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
    private SwitchState yX;
    private float yY;
    private float yZ;
    private Bitmap za;
    private Bitmap zb;
    private Bitmap zc;
    private boolean zd;
    private boolean ze;
    private boolean zf;
    private int zg;
    private a zh;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (zj) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (zk) with 'values()' method */
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
        this.yX = SwitchState.ON;
        this.zd = false;
        this.ze = false;
        this.zf = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.zg = 0;
        this.zh = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yX = SwitchState.ON;
        this.zd = false;
        this.ze = false;
        this.zf = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.zg = 0;
        this.zh = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.za = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.zb = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.zc = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.za.getWidth();
        this.height = this.za.getHeight();
        this.zg = this.zc.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zf) {
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
                this.zd = true;
                this.yY = motionEvent.getX();
                this.yZ = this.yY;
                return true;
            case 1:
                this.zd = false;
                SwitchState switchState = this.yX;
                if (Math.abs(this.yZ - this.yY) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.zf = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.yX = SwitchState.ON;
                } else {
                    this.yX = SwitchState.OFF;
                }
                if (this.ze && switchState != this.yX && this.zh != null) {
                    this.zh.a(this, this.yX);
                }
                this.zf = false;
                invalidate();
                return true;
            case 2:
                this.yZ = motionEvent.getX();
                if (Math.abs(this.yZ - this.yY) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.yZ - this.yY) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.zd = false;
                SwitchState switchState2 = this.yX;
                removeCallbacks(this.mRunnable);
                this.zf = true;
                if (this.yZ >= this.width / 2.0f) {
                    this.yX = SwitchState.ON;
                } else {
                    this.yX = SwitchState.OFF;
                }
                if (this.ze && switchState2 != this.yX && this.zh != null) {
                    this.zh.a(this, this.yX);
                }
                this.zf = false;
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
        if (this.zd) {
            if (this.yZ < this.width / 2.0f) {
                canvas.drawBitmap(this.zb, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.za, 0.0f, 0.0f, this.paint);
            }
        } else if (this.yX == SwitchState.ON) {
            canvas.drawBitmap(this.za, 0.0f, 0.0f, this.paint);
        } else if (this.yX == SwitchState.OFF) {
            canvas.drawBitmap(this.zb, 0.0f, 0.0f, this.paint);
        }
        if (this.zd) {
            if (this.yZ > this.za.getWidth()) {
                f = this.width - (this.zg / 2.0f);
            } else {
                f = this.yZ - (this.zg / 2.0f);
            }
        } else if (this.yX == SwitchState.ON) {
            f = this.width - this.zg;
        } else {
            f = this.yX == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.zg) {
            f = this.width - this.zg;
        }
        canvas.drawBitmap(this.zc, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.zf) {
            this.zf = true;
            if (switchState == SwitchState.ON) {
                this.yZ = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.yZ = 0.0f;
            }
            if (z && switchState != this.yX && this.zh != null) {
                this.zh.a(this, switchState);
            }
            this.yX = switchState;
            this.zf = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.za = bitmap;
        this.zb = bitmap2;
        this.zc = bitmap3;
        invalidate();
    }

    public void jt() {
        if (this.yX != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void ju() {
        if (this.yX != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void jv() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.yX != SwitchState.ON) {
            jv();
        }
    }

    public void jw() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.yX != SwitchState.OFF) {
            jw();
        }
    }

    public boolean eX() {
        return this.yX == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.ze = true;
        this.zh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx() {
        if (this.yX == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.yX == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
