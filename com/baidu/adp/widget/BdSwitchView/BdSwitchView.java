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
    private float Mk;
    private Bitmap Ml;
    private Bitmap Mm;
    private Bitmap Mn;
    private boolean Mo;
    private boolean Mp;
    private boolean Mq;
    private int Mr;
    private a Ms;
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
        this.Mo = false;
        this.Mp = false;
        this.Mq = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Mr = 0;
        this.Ms = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nW();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Mo = false;
        this.Mp = false;
        this.Mq = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Mr = 0;
        this.Ms = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.nW();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Ml = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Mm = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Mn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Ml.getWidth();
        this.height = this.Ml.getHeight();
        this.Mr = this.Mn.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Mq) {
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
                this.Mo = true;
                this.mDownX = motionEvent.getX();
                this.Mk = this.mDownX;
                return true;
            case 1:
                this.Mo = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Mk - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Mq = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Mp && switchState != this.mState && this.Ms != null) {
                    this.Ms.a(this, this.mState);
                }
                this.Mq = false;
                invalidate();
                return true;
            case 2:
                this.Mk = motionEvent.getX();
                if (Math.abs(this.Mk - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Mk - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Mo = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Mq = true;
                if (this.Mk >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Mp && switchState2 != this.mState && this.Ms != null) {
                    this.Ms.a(this, this.mState);
                }
                this.Mq = false;
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
        if (this.Mo) {
            if (this.Mk < this.width / 2.0f) {
                canvas.drawBitmap(this.Mm, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Ml, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Ml, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Mm, 0.0f, 0.0f, this.paint);
        }
        if (this.Mo) {
            if (this.Mk > this.Ml.getWidth()) {
                f = this.width - (this.Mr / 2.0f);
            } else {
                f = this.Mk - (this.Mr / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Mr;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Mr) {
            f = this.width - this.Mr;
        }
        canvas.drawBitmap(this.Mn, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Mq) {
            this.Mq = true;
            if (switchState == SwitchState.ON) {
                this.Mk = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Mk = 0.0f;
            }
            if (z && switchState != this.mState && this.Ms != null) {
                this.Ms.a(this, switchState);
            }
            this.mState = switchState;
            this.Mq = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Ml = bitmap;
        this.Mm = bitmap2;
        this.Mn = bitmap3;
        invalidate();
    }

    public void nS() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nT() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void nU() {
        a(SwitchState.ON, true);
    }

    public void ad(boolean z) {
        if (this.mState != SwitchState.ON) {
            nU();
        }
    }

    public void nV() {
        a(SwitchState.OFF, true);
    }

    public void ae(boolean z) {
        if (this.mState != SwitchState.OFF) {
            nV();
        }
    }

    public boolean jL() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Mp = true;
        this.Ms = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
