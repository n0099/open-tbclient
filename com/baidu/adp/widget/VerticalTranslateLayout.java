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
    private int uA;
    private int uB;
    private final int uG;
    private int uK;
    private final Paint uN;
    private int uO;
    private int uP;
    private final List<u> uX;
    private float yC;
    private float yD;
    private float yE;
    private float yF;
    private int yG;
    private boolean yH;
    private boolean yI;
    private TrackDirection yJ;
    private final Rect yK;
    private final Rect yL;
    private int yM;
    private boolean yN;
    private final r yO;
    private final s yP;
    private final x yQ;
    private v yR;
    private t yS;
    private w yT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (yV) with 'values()' method */
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
        this.uN.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.yG = (int) ((this.yC - this.uB) * (-f));
            } else if (f > 0.0f) {
                this.yG = (int) ((this.uB - this.yE) * f);
            } else if (f == 0.0f) {
                this.yG = 0;
                this.uK = 10004;
            } else if (f == -1.0f) {
                this.yC -= this.uB;
                this.uK = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.yC = this.uB - this.yE;
                this.uK = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.yC;
    }

    public int getBottomOffset() {
        return (int) this.yE;
    }

    public void setTopTapBack(boolean z) {
        this.yH = z;
    }

    public void setBottomTapBack(boolean z) {
        this.yI = z;
    }

    public int getState() {
        return this.uK;
    }

    public void setTopAnimationListener(v vVar) {
        this.yR = vVar;
    }

    public void setBottomAnimationListener(t tVar) {
        this.yS = tVar;
    }

    public void setVerticalTrackListener(w wVar) {
        this.yT = wVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.yG);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.yG);
        canvas.drawRect(0.0f, 0.0f, this.uA, this.uB, this.uN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.yG;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.yJ == TrackDirection.none) {
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
                    this.yO.removeMessages(-100);
                    this.yO.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.yO.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.yO.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.yG);
                    return g(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i >= this.uO - this.uG && i <= this.uO + this.uG && (i2 < this.uP - this.uG || i2 > this.uP + this.uG) && this.yQ.az(i2 - this.uP);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.yN = false;
                    if (this.yQ.vj) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.yQ.iX();
                        x.a(this.yQ);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.yQ.vj) {
                        if (!this.yN) {
                            if (y > this.uP) {
                                this.yM = this.uP + this.uG;
                                this.yN = true;
                            } else {
                                this.yM = this.uP - this.uG;
                                this.yN = true;
                            }
                        }
                        this.yQ.aA(this.yM - y);
                        this.yM = y;
                        this.yQ.vi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.uK != 10000 || !this.yK.contains(x, y)) && (this.uK != 10001 || !this.yL.contains(x, y))) {
                    return false;
                }
                if (!this.yQ.vj) {
                    this.yM = y;
                    this.yQ.az(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.yQ.vj) {
                    this.yQ.iX();
                    x.a(this.yQ);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.yQ.vj) {
            this.yQ.aA(this.yM - y);
            this.yM = y;
            this.yQ.vi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.yC != -1.0f) {
                this.yK.set(i, i2, i3, (int) (i2 + this.yC));
            }
            if (this.yE != -1.0f) {
                this.yL.set(i, (int) (i4 - this.yE), i3, i4);
            }
        }
        if (!this.yP.vg && !this.yQ.vj) {
            iL();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.yD != -1.0f) {
            this.yC = i3 - this.yF;
        }
        if (this.yF != -1.0f) {
            this.yE = i3 - this.yD;
        }
        if (!$assertionsDisabled && i3 < this.yC) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.yE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.uA = getMeasuredWidth();
        this.uB = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        switch (this.uK) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.yG = (int) (this.yC - this.uB);
                invalidate();
                return;
            case 10001:
                this.yG = (int) (this.uB - this.yE);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.yG = 0;
                invalidate();
                return;
        }
    }
}
