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
    private float Hh;
    private float Hi;
    private Bitmap Hj;
    private Bitmap Hk;
    private Bitmap Hl;
    private boolean Hm;
    private boolean Hn;
    private boolean Ho;
    private int Hp;
    private a Hq;
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
        this.Hm = false;
        this.Hn = false;
        this.Ho = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Hp = 0;
        this.Hq = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kz();
            }
        };
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = SwitchState.ON;
        this.Hm = false;
        this.Hn = false;
        this.Ho = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.Hp = 0;
        this.Hq = null;
        this.mRunnable = new Runnable() { // from class: com.baidu.adp.widget.BdSwitchView.BdSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                BdSwitchView.this.kz();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.Hj = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
        this.Hk = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
        this.Hl = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
        this.width = this.Hj.getWidth();
        this.height = this.Hj.getHeight();
        this.Hp = this.Hl.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Ho) {
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
                this.Hm = true;
                this.Hh = motionEvent.getX();
                this.Hi = this.Hh;
                return true;
            case 1:
                this.Hm = false;
                SwitchState switchState = this.mState;
                if (Math.abs(this.Hi - this.Hh) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.Ho = true;
                if (motionEvent.getX() >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Hn && switchState != this.mState && this.Hq != null) {
                    this.Hq.a(this, this.mState);
                }
                this.Ho = false;
                invalidate();
                return true;
            case 2:
                this.Hi = motionEvent.getX();
                if (Math.abs(this.Hi - this.Hh) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.Hi - this.Hh) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.Hm = false;
                SwitchState switchState2 = this.mState;
                removeCallbacks(this.mRunnable);
                this.Ho = true;
                if (this.Hi >= this.width / 2.0f) {
                    this.mState = SwitchState.ON;
                } else {
                    this.mState = SwitchState.OFF;
                }
                if (this.Hn && switchState2 != this.mState && this.Hq != null) {
                    this.Hq.a(this, this.mState);
                }
                this.Ho = false;
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
        if (this.Hm) {
            if (this.Hi < this.width / 2.0f) {
                canvas.drawBitmap(this.Hk, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.Hj, 0.0f, 0.0f, this.paint);
            }
        } else if (this.mState == SwitchState.ON) {
            canvas.drawBitmap(this.Hj, 0.0f, 0.0f, this.paint);
        } else if (this.mState == SwitchState.OFF) {
            canvas.drawBitmap(this.Hk, 0.0f, 0.0f, this.paint);
        }
        if (this.Hm) {
            if (this.Hi > this.Hj.getWidth()) {
                f = this.width - (this.Hp / 2.0f);
            } else {
                f = this.Hi - (this.Hp / 2.0f);
            }
        } else if (this.mState == SwitchState.ON) {
            f = this.width - this.Hp;
        } else {
            f = this.mState == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.Hp) {
            f = this.width - this.Hp;
        }
        canvas.drawBitmap(this.Hl, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.Ho) {
            this.Ho = true;
            if (switchState == SwitchState.ON) {
                this.Hi = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.Hi = 0.0f;
            }
            if (z && switchState != this.mState && this.Hq != null) {
                this.Hq.a(this, switchState);
            }
            this.mState = switchState;
            this.Ho = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.Hj = bitmap;
        this.Hk = bitmap2;
        this.Hl = bitmap3;
        invalidate();
    }

    public void kv() {
        if (this.mState != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void kw() {
        if (this.mState != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void kx() {
        a(SwitchState.ON, true);
    }

    public void P(boolean z) {
        if (this.mState != SwitchState.ON) {
            kx();
        }
    }

    public void ky() {
        a(SwitchState.OFF, true);
    }

    public void Q(boolean z) {
        if (this.mState != SwitchState.OFF) {
            ky();
        }
    }

    public boolean ge() {
        return this.mState == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(a aVar) {
        this.Hn = true;
        this.Hq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        if (this.mState == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.mState == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
