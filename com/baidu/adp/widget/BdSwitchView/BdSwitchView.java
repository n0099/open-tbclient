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
    private float asS;
    private Bitmap asT;
    private Bitmap asU;
    private Bitmap asV;
    private boolean asW;
    private boolean asX;
    private boolean asY;
    private int asZ;
    private a ata;
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
        this.asW = false;
        this.asX = false;
        this.asY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asZ = 0;
        this.ata = null;
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
        this.asW = false;
        this.asX = false;
        this.asY = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.asZ = 0;
        this.ata = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.rM();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.asT = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.asU = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.asV = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.asT.getWidth();
        this.height = this.asT.getHeight();
        this.asZ = this.asV.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.asY) {
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
                this.asW = true;
                this.mDownX = motionEvent.getX();
                this.asS = this.mDownX;
                return true;
            case 1:
                this.asW = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.asS - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.asY = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asX && switchState != this.mState && this.ata != null) {
                    this.ata.a(this, this.mState);
                }
                this.asY = false;
                invalidate();
                return true;
            case 2:
                this.asS = motionEvent.getX();
                if (Math.abs(this.asS - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.asS - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.asW = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.asY = true;
                if (this.asS >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.asX && switchState2 != this.mState && this.ata != null) {
                    this.ata.a(this, this.mState);
                }
                this.asY = false;
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
        if (this.asW) {
            if (this.asS < this.width / 2.0f) {
                canvas.drawBitmap(this.asU, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.asT, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.asT, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.asU, 0.0f, 0.0f, this.paint);
        }
        if (this.asW) {
            if (this.asS > this.asT.getWidth()) {
                f = this.width - (this.asZ / 2.0f);
            } else {
                f = this.asS - (this.asZ / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.asZ;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.asZ) {
            f = this.width - this.asZ;
        }
        canvas.drawBitmap(this.asV, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.asY) {
            this.asY = true;
            if (switchState == SwitchState.ON) {
                this.asS = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.asS = 0.0f;
            }
            if (z && switchState != this.mState && this.ata != null) {
                this.ata.a(this, switchState);
            }
            this.mState = switchState;
            this.asY = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.asT = bitmap;
        this.asU = bitmap2;
        this.asV = bitmap3;
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
        this.asX = true;
        this.ata = aVar;
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
