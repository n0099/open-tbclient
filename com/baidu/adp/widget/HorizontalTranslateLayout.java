package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int uA;
    private float uD;
    private float uE;
    private int uF;
    private final int uG;
    private boolean uH;
    private boolean uI;
    private TrackDirection uJ;
    private int uK;
    private final Rect uL;
    private final Rect uM;
    private final Paint uN;
    private int uO;
    private int uP;
    private int uQ;
    private boolean uR;
    private final f uS;
    private final g uT;
    private final l uU;
    private i uV;
    private k uW;
    private final List<j> uX;
    private h uY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (vh) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TrackDirection[] valuesCustom() {
            TrackDirection[] valuesCustom = values();
            int length = valuesCustom.length;
            TrackDirection[] trackDirectionArr = new TrackDirection[length];
            System.arraycopy(valuesCustom, 0, trackDirectionArr, 0, length);
            return trackDirectionArr;
        }
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.uN.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.uF = (int) ((this.uD - this.uA) * (-f));
            } else if (f > 0.0f) {
                this.uF = (int) ((this.uA - this.uE) * f);
            } else if (f == 0.0f) {
                this.uF = 0;
                this.uK = 10004;
            } else if (f == -1.0f) {
                this.uD -= getMeasuredWidth();
                this.uK = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.uD = getMeasuredWidth() - this.uE;
                this.uK = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.uD;
    }

    public int getRightOffset() {
        return (int) this.uE;
    }

    public void setLeftTapBack(boolean z) {
        this.uH = z;
    }

    public void setRightTapBack(boolean z) {
        this.uI = z;
    }

    public int getState() {
        return this.uK;
    }

    public void setLeftAnimationListener(i iVar) {
        this.uV = iVar;
    }

    public void setRightAnimationListener(k kVar) {
        this.uW = kVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.uY = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.uF, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.uF);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.uN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.uF;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.uJ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.uK == 10004) {
            switch (action) {
                case 0:
                    this.uO = x;
                    this.uP = y;
                    this.uS.removeMessages(-100);
                    this.uS.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.uS.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.uS.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.uF, 0.0f);
                    return g(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i2 >= this.uP - this.uG && i2 <= this.uP + this.uG && (i < this.uO - this.uG || i > this.uO + this.uG) && this.uU.az(i - this.uO);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.uK == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.uR = false;
                    if (this.uU.vj) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.uU.iX();
                        l.a(this.uU);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.uU.vj) {
                        if (!this.uR) {
                            if (x > this.uO) {
                                this.uQ = this.uO + this.uG;
                                this.uR = true;
                            } else {
                                this.uQ = this.uO - this.uG;
                                this.uR = true;
                            }
                        }
                        this.uU.aA(this.uQ - x);
                        this.uQ = x;
                        this.uU.vi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.uL);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.uM);
        switch (action) {
            case 0:
                if ((this.uK != 10000 || !this.uL.contains(x, y)) && (this.uK != 10001 || !this.uM.contains(x, y))) {
                    return false;
                }
                if (!this.uU.vj) {
                    this.uQ = x;
                    this.uU.az(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.uU.vj) {
                    this.uU.iX();
                    l.a(this.uU);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.uU.vj) {
            this.uU.aA(this.uQ - x);
            this.uQ = x;
            this.uU.vi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.uD != -1.0f) {
                this.uL.set(i, i2, (int) (i + this.uD), i4);
            }
            if (this.uE != -1.0f) {
                this.uM.set((int) (i3 - this.uE), i2, i3, i4);
            }
        }
        if (!this.uT.vg && !this.uU.vj) {
            iL();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.uD) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.uE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.uA = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        switch (this.uK) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.uF = (int) (this.uD - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.uF = (int) (getMeasuredWidth() - this.uE);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.uF = 0;
                invalidate();
                return;
        }
    }
}
