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
    static final /* synthetic */ boolean ju;
    private final List<u> sH;
    private int sj;
    private int sk;
    private final int sq;
    private int su;
    private final Paint sx;
    private int sy;
    private int sz;
    private float wD;
    private float wE;
    private float wF;
    private float wG;
    private int wH;
    private boolean wI;
    private boolean wJ;
    private TrackDirection wK;
    private final Rect wL;
    private final Rect wM;
    private int wN;
    private boolean wO;
    private final r wP;
    private final s wQ;
    private final x wR;
    private v wS;
    private t wT;
    private w wU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (wW) with 'values()' method */
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
        ju = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.sx.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.wH = (int) ((this.wD - this.sk) * (-f));
            } else if (f > 0.0f) {
                this.wH = (int) ((this.sk - this.wF) * f);
            } else if (f == 0.0f) {
                this.wH = 0;
                this.su = 10004;
            } else if (f == -1.0f) {
                this.wD -= this.sk;
                this.su = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.wD = this.sk - this.wF;
                this.su = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.wD;
    }

    public int getBottomOffset() {
        return (int) this.wF;
    }

    public void setTopTapBack(boolean z) {
        this.wI = z;
    }

    public void setBottomTapBack(boolean z) {
        this.wJ = z;
    }

    public int getState() {
        return this.su;
    }

    public void setTopAnimationListener(v vVar) {
        this.wS = vVar;
    }

    public void setBottomAnimationListener(t tVar) {
        this.wT = tVar;
    }

    public void setVerticalTrackListener(w wVar) {
        this.wU = wVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.wH);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.wH);
        canvas.drawRect(0.0f, 0.0f, this.sj, this.sk, this.sx);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.wH;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.wK == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.su == 10004) {
            switch (action) {
                case 0:
                    this.sy = x;
                    this.sz = y;
                    this.wP.removeMessages(-100);
                    this.wP.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.wP.removeMessages(-101);
                    this.wP.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.wH);
                    return e(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean e(int i, int i2) {
        return i >= this.sy - this.sq && i <= this.sy + this.sq && (i2 < this.sz - this.sq || i2 > this.sz + this.sq) && this.wR.ae(i2 - this.sz);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.su == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.wO = false;
                    if (this.wR.sT) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.wR.hg();
                        x.a(this.wR);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.wR.sT) {
                        if (!this.wO) {
                            if (y > this.sz) {
                                this.wN = this.sz + this.sq;
                                this.wO = true;
                            } else {
                                this.wN = this.sz - this.sq;
                                this.wO = true;
                            }
                        }
                        this.wR.af(this.wN - y);
                        this.wN = y;
                        this.wR.sS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.su != 10000 || !this.wL.contains(x, y)) && (this.su != 10001 || !this.wM.contains(x, y))) {
                    return false;
                }
                if (!this.wR.sT) {
                    this.wN = y;
                    this.wR.ae(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.wR.sT) {
                    this.wR.hg();
                    x.a(this.wR);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.wR.sT) {
            this.wR.af(this.wN - y);
            this.wN = y;
            this.wR.sS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.wD != -1.0f) {
                this.wL.set(i, i2, i3, (int) (i2 + this.wD));
            }
            if (this.wF != -1.0f) {
                this.wM.set(i, (int) (i4 - this.wF), i3, i4);
            }
        }
        if (!this.wQ.sQ && !this.wR.sT) {
            gU();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.wE != -1.0f) {
            this.wD = i3 - this.wG;
        }
        if (this.wG != -1.0f) {
            this.wF = i3 - this.wE;
        }
        if (!ju && i3 < this.wD) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!ju && i3 < this.wF) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.sj = getMeasuredWidth();
        this.sk = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU() {
        switch (this.su) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.wH = (int) (this.wD - this.sk);
                invalidate();
                return;
            case 10001:
                this.wH = (int) (this.sk - this.wF);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.wH = 0;
                invalidate();
                return;
        }
    }
}
