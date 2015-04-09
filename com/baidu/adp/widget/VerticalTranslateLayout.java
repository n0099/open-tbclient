package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int FA;
    private final int FF;
    private int FJ;
    private final Paint FM;
    private int FN;
    private int FO;
    private final List<x> FW;
    private int Fz;
    private int JA;
    private boolean JB;
    private boolean JC;
    private TrackDirection JD;
    private final Rect JE;
    private final Rect JF;
    private int JG;
    private boolean JH;
    private final u JI;
    private final v JJ;
    private final aa JK;
    private y JL;
    private w JM;
    private z JN;
    private float Jw;
    private float Jx;
    private float Jy;
    private float Jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JP) with 'values()' method */
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
        this.FM.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.JA = (int) ((this.Jw - this.FA) * (-f));
            } else if (f > 0.0f) {
                this.JA = (int) ((this.FA - this.Jy) * f);
            } else if (f == 0.0f) {
                this.JA = 0;
                this.FJ = 10004;
            } else if (f == -1.0f) {
                this.Jw -= this.FA;
                this.FJ = 10000;
            } else if (f == 1.0f) {
                this.Jw = this.FA - this.Jy;
                this.FJ = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Jw;
    }

    public int getBottomOffset() {
        return (int) this.Jy;
    }

    public void setTopTapBack(boolean z) {
        this.JB = z;
    }

    public void setBottomTapBack(boolean z) {
        this.JC = z;
    }

    public int getState() {
        return this.FJ;
    }

    public void setTopAnimationListener(y yVar) {
        this.JL = yVar;
    }

    public void setBottomAnimationListener(w wVar) {
        this.JM = wVar;
    }

    public void setVerticalTrackListener(z zVar) {
        this.JN = zVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.JA);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.JA);
        canvas.drawRect(0.0f, 0.0f, this.Fz, this.FA, this.FM);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.JA;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JD == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FJ == 10004) {
            switch (action) {
                case 0:
                    this.FN = x;
                    this.FO = y;
                    this.JI.removeMessages(-100);
                    this.JI.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.JI.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.JI.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.JA);
                    return f(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i >= this.FN - this.FF && i <= this.FN + this.FF && (i2 < this.FO - this.FF || i2 > this.FO + this.FF) && this.JK.aw(i2 - this.FO);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FJ == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JH = false;
                    if (this.JK.Gi) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JK.mu();
                        aa.a(this.JK);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JK.Gi) {
                        if (!this.JH) {
                            if (y > this.FO) {
                                this.JG = this.FO + this.FF;
                                this.JH = true;
                            } else {
                                this.JG = this.FO - this.FF;
                                this.JH = true;
                            }
                        }
                        this.JK.ax(this.JG - y);
                        this.JG = y;
                        this.JK.Gh.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FJ != 10000 || !this.JE.contains(x, y)) && (this.FJ != 10001 || !this.JF.contains(x, y))) {
                    return false;
                }
                if (!this.JK.Gi) {
                    this.JG = y;
                    this.JK.aw(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JK.Gi) {
                    this.JK.mu();
                    aa.a(this.JK);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JK.Gi) {
            this.JK.ax(this.JG - y);
            this.JG = y;
            this.JK.Gh.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Jw != -1.0f) {
                this.JE.set(i, i2, i3, (int) (i2 + this.Jw));
            }
            if (this.Jy != -1.0f) {
                this.JF.set(i, (int) (i4 - this.Jy), i3, i4);
            }
        }
        if (!this.JJ.Gf && !this.JK.Gi) {
            mi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Jx != -1.0f) {
            this.Jw = i3 - this.Jz;
        }
        if (this.Jz != -1.0f) {
            this.Jy = i3 - this.Jx;
        }
        if (!$assertionsDisabled && i3 < this.Jw) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Jy) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fz = getMeasuredWidth();
        this.FA = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        switch (this.FJ) {
            case 10000:
                this.JA = (int) (this.Jw - this.FA);
                invalidate();
                return;
            case 10001:
                this.JA = (int) (this.FA - this.Jy);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.JA = 0;
                invalidate();
                return;
        }
    }
}
