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
    private float uA;
    private float uB;
    private int uC;
    private final int uD;
    private boolean uE;
    private boolean uF;
    private TrackDirection uG;
    private int uH;
    private final Rect uI;
    private final Rect uJ;
    private final Paint uK;
    private int uL;
    private int uM;
    private int uN;
    private boolean uO;
    private final f uP;
    private final g uQ;
    private final l uR;
    private i uS;
    private k uT;
    private final List<j> uU;
    private h uV;
    private int ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (ve) with 'values()' method */
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
        this.uK.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.uC = (int) ((this.uA - this.ux) * (-f));
            } else if (f > 0.0f) {
                this.uC = (int) ((this.ux - this.uB) * f);
            } else if (f == 0.0f) {
                this.uC = 0;
                this.uH = 10004;
            } else if (f == -1.0f) {
                this.uA -= getMeasuredWidth();
                this.uH = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.uA = getMeasuredWidth() - this.uB;
                this.uH = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.uA;
    }

    public int getRightOffset() {
        return (int) this.uB;
    }

    public void setLeftTapBack(boolean z) {
        this.uE = z;
    }

    public void setRightTapBack(boolean z) {
        this.uF = z;
    }

    public int getState() {
        return this.uH;
    }

    public void setLeftAnimationListener(i iVar) {
        this.uS = iVar;
    }

    public void setRightAnimationListener(k kVar) {
        this.uT = kVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.uV = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.uC, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.uC);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.uK);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.uC;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.uG == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.uH == 10004) {
            switch (action) {
                case 0:
                    this.uL = x;
                    this.uM = y;
                    this.uP.removeMessages(-100);
                    this.uP.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.uP.removeMessages(-101);
                    this.uP.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.uC, 0.0f);
                    return g(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i2 >= this.uM - this.uD && i2 <= this.uM + this.uD && (i < this.uL - this.uD || i > this.uL + this.uD) && this.uR.au(i - this.uL);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.uH == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.uO = false;
                    if (this.uR.vg) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.uR.jd();
                        l.a(this.uR);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.uR.vg) {
                        if (!this.uO) {
                            if (x > this.uL) {
                                this.uN = this.uL + this.uD;
                                this.uO = true;
                            } else {
                                this.uN = this.uL - this.uD;
                                this.uO = true;
                            }
                        }
                        this.uR.av(this.uN - x);
                        this.uN = x;
                        this.uR.vf.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.uI);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.uJ);
        switch (action) {
            case 0:
                if ((this.uH != 10000 || !this.uI.contains(x, y)) && (this.uH != 10001 || !this.uJ.contains(x, y))) {
                    return false;
                }
                if (!this.uR.vg) {
                    this.uN = x;
                    this.uR.au(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.uR.vg) {
                    this.uR.jd();
                    l.a(this.uR);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.uR.vg) {
            this.uR.av(this.uN - x);
            this.uN = x;
            this.uR.vf.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.uA != -1.0f) {
                this.uI.set(i, i2, (int) (i + this.uA), i4);
            }
            if (this.uB != -1.0f) {
                this.uJ.set((int) (i3 - this.uB), i2, i3, i4);
            }
        }
        if (!this.uQ.vd && !this.uR.vg) {
            iR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.uA) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.uB) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.ux = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        switch (this.uH) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.uC = (int) (this.uA - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.uC = (int) (getMeasuredWidth() - this.uB);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.uC = 0;
                invalidate();
                return;
        }
    }
}
