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
    private float KF;
    private Bitmap KG;
    private Bitmap KH;
    private Bitmap KI;
    private boolean KJ;
    private boolean KK;
    private boolean KL;
    private int KM;
    private a KN;
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
        this.KJ = false;
        this.KK = false;
        this.KL = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KM = 0;
        this.KN = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.no();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.KJ = false;
        this.KK = false;
        this.KL = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.KM = 0;
        this.KN = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.no();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.KG = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.KH = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.KI = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.KG.getWidth();
        this.height = this.KG.getHeight();
        this.KM = this.KI.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.KL) {
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
                this.KJ = true;
                this.mDownX = motionEvent.getX();
                this.KF = this.mDownX;
                return true;
            case 1:
                this.KJ = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.KF - this.mDownX) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.KL = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.KK && switchState != this.mState && this.KN != null) {
                    this.KN.a(this, this.mState);
                }
                this.KL = false;
                invalidate();
                return true;
            case 2:
                this.KF = motionEvent.getX();
                if (Math.abs(this.KF - this.mDownX) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.KF - this.mDownX) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.KJ = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.KL = true;
                if (this.KF >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.KK && switchState2 != this.mState && this.KN != null) {
                    this.KN.a(this, this.mState);
                }
                this.KL = false;
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
        if (this.KJ) {
            if (this.KF < this.width / 2.0f) {
                canvas.drawBitmap(this.KH, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.KG, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.KG, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.KH, 0.0f, 0.0f, this.paint);
        }
        if (this.KJ) {
            if (this.KF > this.KG.getWidth()) {
                f = this.width - (this.KM / 2.0f);
            } else {
                f = this.KF - (this.KM / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.KM;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.KM) {
            f = this.width - this.KM;
        }
        canvas.drawBitmap(this.KI, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.KL) {
            this.KL = true;
            if (switchState == SwitchState.ON) {
                this.KF = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.KF = 0.0f;
            }
            if (z && switchState != this.mState && this.KN != null) {
                this.KN.a(this, switchState);
            }
            this.mState = switchState;
            this.KL = false;
            invalidate();
        }
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.KG = bitmap;
        this.KH = bitmap2;
        this.KI = bitmap3;
        invalidate();
    }

    public void nk() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void nl() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void nm() {
        a(SwitchState.ON, true);
    }

    public void an(boolean z) {
        if (this.mState != SwitchState.ON) {
            nm();
        }
    }

    public void nn() {
        a(SwitchState.OFF, true);
    }

    public void ao(boolean z) {
        if (this.mState != SwitchState.OFF) {
            nn();
        }
    }

    public boolean iN() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.KK = true;
        this.KN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void no() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
