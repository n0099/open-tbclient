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
    private float asT;
    private Bitmap asU;
    private Bitmap asV;
    private Bitmap asW;
    private boolean asX;
    private boolean asY;
    private boolean asZ;
    private int ata;
    private a atb;
    private int height;
    private float mDownX;
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
        this.asX = false;
        this.asY = false;
        this.asZ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.ata = 0;
        this.atb = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rM();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.asX = false;
        this.asY = false;
        this.asZ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.ata = 0;
        this.atb = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rM();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asU = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asV = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asW = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asU.getWidth();
        this.height = this.asU.getHeight();
        this.ata = this.asW.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.asZ) {
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
                this.asX = true;
                this.mDownX = motionEvent.getX();
                this.asT = this.mDownX;
                return true;
            case 1:
                this.asX = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asT - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.asZ = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asY && switchState != this.mState && this.atb != null) {
                    this.atb.a(this, this.mState);
                }
                this.asZ = false;
                invalidate();
                return true;
            case 2:
                this.asT = motionEvent.getX();
                if (Math.abs(this.asT - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asT - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asX = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.asZ = true;
                if (this.asT >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asY && switchState2 != this.mState && this.atb != null) {
                    this.atb.a(this, this.mState);
                }
                this.asZ = false;
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
        if (this.asX) {
            if (this.asT < this.width / 2.0f) {
                canvas.drawBitmap(this.asV, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asU, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asU, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asV, 0.0f, 0.0f, this.paint);
        }
        if (this.asX) {
            if (this.asT > this.asU.getWidth()) {
                f = this.width - (this.ata / 2.0f);
            } else {
                f = this.asT - (this.ata / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.ata;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.ata) {
            f = this.width - this.ata;
        }
        canvas.drawBitmap(this.asW, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.asZ) {
            this.asZ = true;
            if (switchState == SwitchState.ON) {
                this.asT = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asT = 0.0f;
            }
            if (z && switchState != this.mState && this.atb != null) {
                this.atb.a(this, switchState);
            }
            this.mState = switchState;
            this.asZ = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asU = bitmap;
        this.asV = bitmap2;
        this.asW = bitmap3;
        invalidate();
    }

    public void rI() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void rJ() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void rK() {
        a(SwitchState.ON, true);
    }

    public void aw(boolean z) {
        if (this.mState != SwitchState.ON) {
            rK();
        }
    }

    public void rL() {
        a(SwitchState.OFF, true);
    }

    public void ax(boolean z) {
        if (this.mState != SwitchState.OFF) {
            rL();
        }
    }

    public boolean nu() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.asY = true;
        this.atb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
