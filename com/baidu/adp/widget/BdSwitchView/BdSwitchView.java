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
    private float MJ;
    private Bitmap MK;
    private Bitmap MM;
    private Bitmap MN;
    private boolean MO;
    private boolean MP;
    private boolean MQ;
    private int MR;
    private a MS;
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
        this.MO = false;
        this.MP = false;
        this.MQ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.MR = 0;
        this.MS = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.oc();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.MO = false;
        this.MP = false;
        this.MQ = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.MR = 0;
        this.MS = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.oc();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.MK = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.MM = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.MN = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.MK.getWidth();
        this.height = this.MK.getHeight();
        this.MR = this.MN.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.MQ) {
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
                this.MO = true;
                this.mDownX = motionEvent.getX();
                this.MJ = this.mDownX;
                return true;
            case 1:
                this.MO = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.MJ - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.MQ = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.MP && switchState != this.mState && this.MS != null) {
                    this.MS.a(this, this.mState);
                }
                this.MQ = false;
                invalidate();
                return true;
            case 2:
                this.MJ = motionEvent.getX();
                if (Math.abs(this.MJ - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.MJ - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.MO = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.MQ = true;
                if (this.MJ >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.MP && switchState2 != this.mState && this.MS != null) {
                    this.MS.a(this, this.mState);
                }
                this.MQ = false;
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
        if (this.MO) {
            if (this.MJ < this.width / 2.0f) {
                canvas.drawBitmap(this.MM, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.MK, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.MK, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.MM, 0.0f, 0.0f, this.paint);
        }
        if (this.MO) {
            if (this.MJ > this.MK.getWidth()) {
                f = this.width - (this.MR / 2.0f);
            } else {
                f = this.MJ - (this.MR / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.MR;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.MR) {
            f = this.width - this.MR;
        }
        canvas.drawBitmap(this.MN, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.MQ) {
            this.MQ = true;
            if (switchState == SwitchState.ON) {
                this.MJ = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.MJ = 0.0f;
            }
            if (z && switchState != this.mState && this.MS != null) {
                this.MS.a(this, switchState);
            }
            this.mState = switchState;
            this.MQ = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.MK = bitmap;
        this.MM = bitmap2;
        this.MN = bitmap3;
        invalidate();
    }

    public void nY() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nZ() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void oa() {
        a(SwitchState.ON, true);
    }

    public void as(boolean z) {
        if (this.mState != SwitchState.ON) {
            oa();
        }
    }

    public void ob() {
        a(SwitchState.OFF, true);
    }

    public void at(boolean z) {
        if (this.mState != SwitchState.OFF) {
            ob();
        }
    }

    public boolean jK() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.MP = true;
        this.MS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
