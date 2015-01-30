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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int uD;
    private int uE;
    private final int uJ;
    private int uN;
    private final Paint uQ;
    private int uR;
    private int uS;
    private final List<u> va;
    private float yF;
    private float yG;
    private float yH;
    private float yI;
    private int yJ;
    private boolean yK;
    private boolean yL;
    private TrackDirection yM;
    private final Rect yN;
    private final Rect yO;
    private int yP;
    private boolean yQ;
    private final r yR;
    private final s yS;
    private final x yT;
    private v yU;
    private t yV;
    private w yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (yY) with 'values()' method */
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
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.uQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.yJ = (int) ((this.yF - this.uE) * (-f));
            } else if (f > 0.0f) {
                this.yJ = (int) ((this.uE - this.yH) * f);
            } else if (f == 0.0f) {
                this.yJ = 0;
                this.uN = 10004;
            } else if (f == -1.0f) {
                this.yF -= this.uE;
                this.uN = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.yF = this.uE - this.yH;
                this.uN = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.yF;
    }

    public int getBottomOffset() {
        return (int) this.yH;
    }

    public void setTopTapBack(boolean z) {
        this.yK = z;
    }

    public void setBottomTapBack(boolean z) {
        this.yL = z;
    }

    public int getState() {
        return this.uN;
    }

    public void setTopAnimationListener(v vVar) {
        this.yU = vVar;
    }

    public void setBottomAnimationListener(t tVar) {
        this.yV = tVar;
    }

    public void setVerticalTrackListener(w wVar) {
        this.yW = wVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.yJ);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.yJ);
        canvas.drawRect(0.0f, 0.0f, this.uD, this.uE, this.uQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.yJ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.yM == TrackDirection.none) {
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
                    this.yR.removeMessages(-100);
                    this.yR.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.yR.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.yR.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.yJ);
                    return g(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i >= this.uR - this.uJ && i <= this.uR + this.uJ && (i2 < this.uS - this.uJ || i2 > this.uS + this.uJ) && this.yT.az(i2 - this.uS);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.yQ = false;
                    if (this.yT.vm) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.yT.je();
                        x.a(this.yT);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.yT.vm) {
                        if (!this.yQ) {
                            if (y > this.uS) {
                                this.yP = this.uS + this.uJ;
                                this.yQ = true;
                            } else {
                                this.yP = this.uS - this.uJ;
                                this.yQ = true;
                            }
                        }
                        this.yT.aA(this.yP - y);
                        this.yP = y;
                        this.yT.vl.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.uN != 10000 || !this.yN.contains(x, y)) && (this.uN != 10001 || !this.yO.contains(x, y))) {
                    return false;
                }
                if (!this.yT.vm) {
                    this.yP = y;
                    this.yT.az(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.yT.vm) {
                    this.yT.je();
                    x.a(this.yT);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.yT.vm) {
            this.yT.aA(this.yP - y);
            this.yP = y;
            this.yT.vl.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.yF != -1.0f) {
                this.yN.set(i, i2, i3, (int) (i2 + this.yF));
            }
            if (this.yH != -1.0f) {
                this.yO.set(i, (int) (i4 - this.yH), i3, i4);
            }
        }
        if (!this.yS.vj && !this.yT.vm) {
            iS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.yG != -1.0f) {
            this.yF = i3 - this.yI;
        }
        if (this.yI != -1.0f) {
            this.yH = i3 - this.yG;
        }
        if (!$assertionsDisabled && i3 < this.yF) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.yH) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.uD = getMeasuredWidth();
        this.uE = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        switch (this.uN) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.yJ = (int) (this.yF - this.uE);
                invalidate();
                return;
            case 10001:
                this.yJ = (int) (this.uE - this.yH);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.yJ = 0;
                invalidate();
                return;
        }
    }
}
