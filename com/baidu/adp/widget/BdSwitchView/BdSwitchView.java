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
    private SwitchState mState;
    private Paint paint;
    private int width;
    private float yO;
    private float yP;
    private Bitmap yQ;
    private Bitmap yR;
    private Bitmap yS;
    private boolean yT;
    private boolean yU;
    private boolean yV;
    private int yW;
    private a yX;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (yZ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (za) with 'values()' method */
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
        this.mState = SwitchState.ON;
        this.yT = false;
        this.yU = false;
        this.yV = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.yW = 0;
        this.yX = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.yT = false;
        this.yU = false;
        this.yV = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.yW = 0;
        this.yX = null;
        this.mRunnable = new com.baidu.adp.widget.BdSwitchView.a(this);
        init(context);
    }

    private void init(Context context) {
        this.yQ = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.yR = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.yS = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.yQ.getWidth();
        this.height = this.yQ.getHeight();
        this.yW = this.yS.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.yV) {
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
                this.yT = true;
                this.yO = motionEvent.getX();
                this.yP = this.yO;
                return true;
            case 1:
                this.yT = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.yP - this.yO) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.yV = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.yU && switchState != this.mState && this.yX != null) {
                    this.yX.a(this, this.mState);
                }
                this.yV = false;
                invalidate();
                return true;
            case 2:
                this.yP = motionEvent.getX();
                if (Math.abs(this.yP - this.yO) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.yP - this.yO) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.yT = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.yV = true;
                if (this.yP >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.yU && switchState2 != this.mState && this.yX != null) {
                    this.yX.a(this, this.mState);
                }
                this.yV = false;
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
        if (this.yT) {
            if (this.yP < this.width / 2.0f) {
                canvas.drawBitmap(this.yR, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.yQ, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.yQ, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.yR, 0.0f, 0.0f, this.paint);
        }
        if (this.yT) {
            if (this.yP > this.yQ.getWidth()) {
                f = this.width - (this.yW / 2.0f);
            } else {
                f = this.yP - (this.yW / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.yW;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.yW) {
            f = this.width - this.yW;
        }
        canvas.drawBitmap(this.yS, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.yV) {
            this.yV = true;
            if (switchState == SwitchState.ON) {
                this.yP = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.yP = 0.0f;
            }
            if (z && switchState != this.mState && this.yX != null) {
                this.yX.a(this, switchState);
            }
            this.mState = switchState;
            this.yV = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.yQ = bitmap;
        this.yR = bitmap2;
        this.yS = bitmap3;
        invalidate();
    }

    public void jr() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void js() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void jt() {
        a(SwitchState.ON, true);
    }

    public void O(boolean z) {
        if (this.mState != SwitchState.ON) {
            jt();
        }
    }

    public void ju() {
        a(SwitchState.OFF, true);
    }

    public void P(boolean z) {
        if (this.mState != SwitchState.OFF) {
            ju();
        }
    }

    public boolean eV() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.yU = true;
        this.yX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
