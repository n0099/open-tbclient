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
    private SwitchState EP;
    private float EQ;
    private float ER;
    private Bitmap ES;
    private Bitmap ET;
    private Bitmap EU;
    private boolean EV;
    private boolean EW;
    private boolean EX;
    private int EY;
    private b EZ;
    private int height;
    private Runnable mRunnable;
    private Paint paint;
    private int width;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF;

        /* JADX DEBUG: Replace access to removed values field (Fb) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Fc) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SwitchStyle[] valuesCustom() {
            SwitchStyle[] valuesCustom = values();
            int length = valuesCustom.length;
            SwitchStyle[] switchStyleArr = new SwitchStyle[length];
            System.arraycopy(valuesCustom, 0, switchStyleArr, 0, length);
            return switchStyleArr;
        }
    }

    public BdSwitchView(Context context) {
        super(context);
        this.EP = SwitchState.ON;
        this.EV = false;
        this.EW = false;
        this.EX = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EY = 0;
        this.EZ = null;
        this.mRunnable = new a(this);
        init(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EP = SwitchState.ON;
        this.EV = false;
        this.EW = false;
        this.EX = false;
        this.paint = new Paint();
        this.width = 0;
        this.height = 0;
        this.EY = 0;
        this.EZ = null;
        this.mRunnable = new a(this);
        init(context);
    }

    private void init(Context context) {
        this.ES = BitmapFactory.decodeResource(getResources(), R.drawable.bg_game_switch_open);
        this.ET = BitmapFactory.decodeResource(getResources(), R.drawable.bg_game_switch_close);
        this.EU = BitmapFactory.decodeResource(getResources(), R.drawable.btn_game_handle);
        this.width = this.ES.getWidth();
        this.height = this.ES.getHeight();
        this.EY = this.EU.getWidth();
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.EX) {
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
                this.EV = true;
                this.EQ = motionEvent.getX();
                this.ER = this.EQ;
                return true;
            case 1:
                this.EV = false;
                SwitchState switchState = this.EP;
                if (Math.abs(this.ER - this.EQ) <= 0.02d * this.width) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.mRunnable);
                this.EX = true;
                if (motionEvent.getX() >= this.width / 2) {
                    this.EP = SwitchState.ON;
                } else {
                    this.EP = SwitchState.OFF;
                }
                if (this.EW && switchState != this.EP && this.EZ != null) {
                    this.EZ.a(this, this.EP);
                }
                this.EX = false;
                invalidate();
                return true;
            case 2:
                this.ER = motionEvent.getX();
                if (Math.abs(this.ER - this.EQ) > 0.05d * this.width) {
                    removeCallbacks(this.mRunnable);
                    if (Math.abs(this.ER - this.EQ) > 0.1d * this.width) {
                        invalidate();
                    }
                }
                return true;
            case 3:
                this.EV = false;
                SwitchState switchState2 = this.EP;
                removeCallbacks(this.mRunnable);
                this.EX = true;
                if (this.ER >= this.width / 2) {
                    this.EP = SwitchState.ON;
                } else {
                    this.EP = SwitchState.OFF;
                }
                if (this.EW && switchState2 != this.EP && this.EZ != null) {
                    this.EZ.a(this, this.EP);
                }
                this.EX = false;
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
        if (this.EV) {
            if (this.ER < this.width / 2) {
                canvas.drawBitmap(this.ET, 0.0f, 0.0f, this.paint);
            } else {
                canvas.drawBitmap(this.ES, 0.0f, 0.0f, this.paint);
            }
        } else if (this.EP == SwitchState.ON) {
            canvas.drawBitmap(this.ES, 0.0f, 0.0f, this.paint);
        } else if (this.EP == SwitchState.OFF) {
            canvas.drawBitmap(this.ET, 0.0f, 0.0f, this.paint);
        }
        if (this.EV) {
            if (this.ER > this.ES.getWidth()) {
                f = this.width - (this.EY / 2);
            } else {
                f = this.ER - (this.EY / 2);
            }
        } else if (this.EP == SwitchState.ON) {
            f = this.width - this.EY;
        } else {
            f = this.EP == SwitchState.OFF ? 0.0f : 0.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.width - this.EY) {
            f = this.width - this.EY;
        }
        canvas.drawBitmap(this.EU, f, 0.0f, this.paint);
    }

    private void a(SwitchState switchState, boolean z) {
        if (!this.EX) {
            this.EX = true;
            if (switchState == SwitchState.ON) {
                this.ER = this.width;
            } else if (switchState == SwitchState.OFF) {
                this.ER = 0.0f;
            }
            if (z && switchState != this.EP && this.EZ != null) {
                this.EZ.a(this, switchState);
            }
            this.EP = switchState;
            this.EX = false;
            invalidate();
        }
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.ES = bitmap;
        this.ET = bitmap2;
        this.EU = bitmap3;
        invalidate();
    }

    public void mr() {
        if (this.EP != SwitchState.ON) {
            a(SwitchState.ON, false);
        }
    }

    public void ms() {
        if (this.EP != SwitchState.OFF) {
            a(SwitchState.OFF, false);
        }
    }

    public void mt() {
        a(SwitchState.ON, true);
    }

    public void N(boolean z) {
        if (this.EP != SwitchState.ON) {
            mt();
        }
    }

    public void mu() {
        a(SwitchState.OFF, true);
    }

    public void O(boolean z) {
        if (this.EP != SwitchState.OFF) {
            mu();
        }
    }

    public boolean hJ() {
        return this.EP == SwitchState.ON;
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        this.EW = true;
        this.EZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        if (this.EP == SwitchState.ON) {
            a(SwitchState.OFF, true);
        } else if (this.EP == SwitchState.OFF) {
            a(SwitchState.ON, true);
        }
    }
}
