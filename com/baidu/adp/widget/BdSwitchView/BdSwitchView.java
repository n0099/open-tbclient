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
    private SwitchState SZ;
    private a Ta;
    private Bitmap bg_off;
    private Bitmap bg_on;
    private int btn_width;
    private int height;
    private float mDownX;
    private boolean mIsChangeingSate;
    private boolean mIsSetChangeListener;
    private boolean mIsSlipping;
    private float mNowX;
    private Runnable mRunnable;
    private Paint paint;
    private Bitmap slipping_btn;
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
        this.SZ = SwitchState.ON;
        this.mIsSlipping = false;
        this.mIsSetChangeListener = false;
        this.mIsChangeingSate = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.btn_width = 0;
        this.Ta = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.changeState();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SZ = SwitchState.ON;
        this.mIsSlipping = false;
        this.mIsSetChangeListener = false;
        this.mIsChangeingSate = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.btn_width = 0;
        this.Ta = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.changeState();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.bg_on = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.bg_off = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.slipping_btn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.bg_on.getWidth();
        this.height = this.bg_on.getHeight();
        this.btn_width = this.slipping_btn.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mIsChangeingSate) {
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
                this.mIsSlipping = true;
                this.mDownX = motionEvent.getX();
                this.mNowX = this.mDownX;
                return true;
            case 1:
                this.mIsSlipping = false;
                SwitchState switchState = this.SZ;
                if (Math.abs(this.mNowX - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.mIsChangeingSate = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.SZ = SwitchState.ON;
                } else {
                    this.SZ = SwitchState.OFF;
                }
                if (this.mIsSetChangeListener && switchState != this.SZ && this.Ta != null) {
                    this.Ta.a(this, this.SZ);
                }
                this.mIsChangeingSate = false;
                invalidate();
                return true;
            case 2:
                this.mNowX = motionEvent.getX();
                if (Math.abs(this.mNowX - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.mNowX - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.mIsSlipping = false;
                SwitchState switchState2 = this.SZ;
                removeCallbacks(this.mRunnable);
                this.mIsChangeingSate = true;
                if (this.mNowX >= this.width / 2.0f) {
                    this.SZ = SwitchState.ON;
                } else {
                    this.SZ = SwitchState.OFF;
                }
                if (this.mIsSetChangeListener && switchState2 != this.SZ && this.Ta != null) {
                    this.Ta.a(this, this.SZ);
                }
                this.mIsChangeingSate = false;
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
        if (this.mIsSlipping) {
            if (this.mNowX < this.width / 2.0f) {
                canvas.drawBitmap(this.bg_off, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.bg_on, 0.0f, 0.0f, this.paint);
            }
        } else if (this.SZ == SwitchState.ON) {
            canvas.drawBitmap(this.bg_on, 0.0f, 0.0f, this.paint);
        } else if (this.SZ == SwitchState.OFF) {
            canvas.drawBitmap(this.bg_off, 0.0f, 0.0f, this.paint);
        }
        if (this.mIsSlipping) {
            if (this.mNowX > this.bg_on.getWidth()) {
                f = this.width - (this.btn_width / 2.0f);
            } else {
                f = this.mNowX - (this.btn_width / 2.0f);
            }
        } else if (this.SZ == SwitchState.ON) {
            f = this.width - this.btn_width;
        } else {
            f = this.SZ == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.btn_width) {
            f = this.width - this.btn_width;
        }
        canvas.drawBitmap(this.slipping_btn, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.mIsChangeingSate) {
            this.mIsChangeingSate = true;
            if (switchState == SwitchState.ON) {
                this.mNowX = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.mNowX = 0.0f;
            }
            if (z && switchState != this.SZ && this.Ta != null) {
                this.Ta.a(this, switchState);
            }
            this.SZ = switchState;
            this.mIsChangeingSate = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.bg_on = bitmap;
        this.bg_off = bitmap2;
        this.slipping_btn = bitmap3;
        invalidate();
    }

    public void turnOnNoCallback() {
        if (this.SZ != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void turnOffNoCallback() {
        if (this.SZ != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void turnOn() {
        a(SwitchState.ON, true);
    }

    public void turnOn(boolean z) {
        if (this.SZ != SwitchState.ON) {
            turnOn();
        }
    }

    public void turnOff() {
        a(SwitchState.OFF, true);
    }

    public void turnOff(boolean z) {
        if (this.SZ != SwitchState.OFF) {
            turnOff();
        }
    }

    public boolean isOn() {
        return this.SZ == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.mIsSetChangeListener = true;
        this.Ta = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState() {
        if (this.SZ == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.SZ == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
