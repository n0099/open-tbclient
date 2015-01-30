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
    private int uD;
    private float uG;
    private float uH;
    private int uI;
    private final int uJ;
    private boolean uK;
    private boolean uL;
    private TrackDirection uM;
    private int uN;
    private final Rect uO;
    private final Rect uP;
    private final Paint uQ;
    private int uR;
    private int uS;
    private int uT;
    private boolean uU;
    private final f uV;
    private final g uW;
    private final l uX;
    private i uY;
    private k uZ;
    private final List<j> va;
    private h vb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (vk) with 'values()' method */
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
        this.uQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.uI = (int) ((this.uG - this.uD) * (-f));
            } else if (f > 0.0f) {
                this.uI = (int) ((this.uD - this.uH) * f);
            } else if (f == 0.0f) {
                this.uI = 0;
                this.uN = 10004;
            } else if (f == -1.0f) {
                this.uG -= getMeasuredWidth();
                this.uN = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.uG = getMeasuredWidth() - this.uH;
                this.uN = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.uG;
    }

    public int getRightOffset() {
        return (int) this.uH;
    }

    public void setLeftTapBack(boolean z) {
        this.uK = z;
    }

    public void setRightTapBack(boolean z) {
        this.uL = z;
    }

    public int getState() {
        return this.uN;
    }

    public void setLeftAnimationListener(i iVar) {
        this.uY = iVar;
    }

    public void setRightAnimationListener(k kVar) {
        this.uZ = kVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.vb = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.uI, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.uI);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.uQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.uI;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.uM == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.uN == 10004) {
            switch (action) {
                case 0:
                    this.uR = x;
                    this.uS = y;
                    this.uV.removeMessages(-100);
                    this.uV.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.uV.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.uV.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.uI, 0.0f);
                    return g(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i2 >= this.uS - this.uJ && i2 <= this.uS + this.uJ && (i < this.uR - this.uJ || i > this.uR + this.uJ) && this.uX.az(i - this.uR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.uN == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.uU = false;
                    if (this.uX.vm) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.uX.je();
                        l.a(this.uX);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.uX.vm) {
                        if (!this.uU) {
                            if (x > this.uR) {
                                this.uT = this.uR + this.uJ;
                                this.uU = true;
                            } else {
                                this.uT = this.uR - this.uJ;
                                this.uU = true;
                            }
                        }
                        this.uX.aA(this.uT - x);
                        this.uT = x;
                        this.uX.vl.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.uO);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.uP);
        switch (action) {
            case 0:
                if ((this.uN != 10000 || !this.uO.contains(x, y)) && (this.uN != 10001 || !this.uP.contains(x, y))) {
                    return false;
                }
                if (!this.uX.vm) {
                    this.uT = x;
                    this.uX.az(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.uX.vm) {
                    this.uX.je();
                    l.a(this.uX);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.uX.vm) {
            this.uX.aA(this.uT - x);
            this.uT = x;
            this.uX.vl.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.uG != -1.0f) {
                this.uO.set(i, i2, (int) (i + this.uG), i4);
            }
            if (this.uH != -1.0f) {
                this.uP.set((int) (i3 - this.uH), i2, i3, i4);
            }
        }
        if (!this.uW.vj && !this.uX.vm) {
            iS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.uG) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.uH) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.uD = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        switch (this.uN) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.uI = (int) (this.uG - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.uI = (int) (getMeasuredWidth() - this.uH);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.uI = 0;
                invalidate();
                return;
        }
    }
}
