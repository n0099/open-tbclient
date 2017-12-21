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
    private float EP;
    private float EQ;
    private Bitmap ER;
    private Bitmap ES;
    private Bitmap ET;
    private boolean EU;
    private boolean EV;
    private boolean EW;
    private int EX;
    private a EY;
    private int height;
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
        this.EU = false;
        this.EV = false;
        this.EW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EX = 0;
        this.EY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kn();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.EU = false;
        this.EV = false;
        this.EW = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EX = 0;
        this.EY = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kn();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ER = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.ES = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.ET = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.ER.getWidth();
        this.height = this.ER.getHeight();
        this.EX = this.ET.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.EW) {
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
                this.EU = true;
                this.EP = motionEvent.getX();
                this.EQ = this.EP;
                return true;
            case 1:
                this.EU = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.EQ - this.EP) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.EW = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.EV && switchState != this.mState && this.EY != null) {
                    this.EY.a(this, this.mState);
                }
                this.EW = false;
                invalidate();
                return true;
            case 2:
                this.EQ = motionEvent.getX();
                if (Math.abs(this.EQ - this.EP) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.EQ - this.EP) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.EU = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.EW = true;
                if (this.EQ >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.EV && switchState2 != this.mState && this.EY != null) {
                    this.EY.a(this, this.mState);
                }
                this.EW = false;
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
        if (this.EU) {
            if (this.EQ < this.width / 2.0f) {
                canvas.drawBitmap(this.ES, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.ER, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.ER, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.ES, 0.0f, 0.0f, this.paint);
        }
        if (this.EU) {
            if (this.EQ > this.ER.getWidth()) {
                f = this.width - (this.EX / 2.0f);
            } else {
                f = this.EQ - (this.EX / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.EX;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.EX) {
            f = this.width - this.EX;
        }
        canvas.drawBitmap(this.ET, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.EW) {
            this.EW = true;
            if (switchState == SwitchState.ON) {
                this.EQ = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.EQ = 0.0f;
            }
            if (z && switchState != this.mState && this.EY != null) {
                this.EY.a(this, switchState);
            }
            this.mState = switchState;
            this.EW = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.ER = bitmap;
        this.ES = bitmap2;
        this.ET = bitmap3;
        invalidate();
    }

    public void kj() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void kk() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void kl() {
        a(SwitchState.ON, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.ON) {
            kl();
        }
    }

    public void km() {
        a(SwitchState.OFF, true);
    }

    public void R(boolean z) {
        if (this.mState != SwitchState.OFF) {
            km();
        }
    }

    public boolean fS() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.EV = true;
        this.EY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
