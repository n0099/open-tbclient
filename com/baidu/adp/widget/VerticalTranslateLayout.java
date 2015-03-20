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
    private final int FD;
    private int FH;
    private final Paint FK;
    private int FL;
    private int FM;
    private final List<x> FU;
    private int Fx;
    private int Fy;
    private boolean JA;
    private TrackDirection JB;
    private final Rect JC;
    private final Rect JD;
    private int JE;
    private boolean JF;
    private final u JG;
    private final v JH;
    private final aa JI;
    private y JJ;
    private w JK;
    private z JL;
    private float Ju;
    private float Jv;
    private float Jw;
    private float Jx;
    private int Jy;
    private boolean Jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JN) with 'values()' method */
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
        this.FK.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.Jy = (int) ((this.Ju - this.Fy) * (-f));
            } else if (f > 0.0f) {
                this.Jy = (int) ((this.Fy - this.Jw) * f);
            } else if (f == 0.0f) {
                this.Jy = 0;
                this.FH = 10004;
            } else if (f == -1.0f) {
                this.Ju -= this.Fy;
                this.FH = 10000;
            } else if (f == 1.0f) {
                this.Ju = this.Fy - this.Jw;
                this.FH = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ju;
    }

    public int getBottomOffset() {
        return (int) this.Jw;
    }

    public void setTopTapBack(boolean z) {
        this.Jz = z;
    }

    public void setBottomTapBack(boolean z) {
        this.JA = z;
    }

    public int getState() {
        return this.FH;
    }

    public void setTopAnimationListener(y yVar) {
        this.JJ = yVar;
    }

    public void setBottomAnimationListener(w wVar) {
        this.JK = wVar;
    }

    public void setVerticalTrackListener(z zVar) {
        this.JL = zVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Jy);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Jy);
        canvas.drawRect(0.0f, 0.0f, this.Fx, this.Fy, this.FK);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Jy;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JB == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FH == 10004) {
            switch (action) {
                case 0:
                    this.FL = x;
                    this.FM = y;
                    this.JG.removeMessages(-100);
                    this.JG.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.JG.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.JG.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Jy);
                    return f(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i >= this.FL - this.FD && i <= this.FL + this.FD && (i2 < this.FM - this.FD || i2 > this.FM + this.FD) && this.JI.aw(i2 - this.FM);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FH == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JF = false;
                    if (this.JI.Gg) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JI.mu();
                        aa.a(this.JI);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JI.Gg) {
                        if (!this.JF) {
                            if (y > this.FM) {
                                this.JE = this.FM + this.FD;
                                this.JF = true;
                            } else {
                                this.JE = this.FM - this.FD;
                                this.JF = true;
                            }
                        }
                        this.JI.ax(this.JE - y);
                        this.JE = y;
                        this.JI.Gf.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FH != 10000 || !this.JC.contains(x, y)) && (this.FH != 10001 || !this.JD.contains(x, y))) {
                    return false;
                }
                if (!this.JI.Gg) {
                    this.JE = y;
                    this.JI.aw(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JI.Gg) {
                    this.JI.mu();
                    aa.a(this.JI);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JI.Gg) {
            this.JI.ax(this.JE - y);
            this.JE = y;
            this.JI.Gf.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ju != -1.0f) {
                this.JC.set(i, i2, i3, (int) (i2 + this.Ju));
            }
            if (this.Jw != -1.0f) {
                this.JD.set(i, (int) (i4 - this.Jw), i3, i4);
            }
        }
        if (!this.JH.Gd && !this.JI.Gg) {
            mi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Jv != -1.0f) {
            this.Ju = i3 - this.Jx;
        }
        if (this.Jx != -1.0f) {
            this.Jw = i3 - this.Jv;
        }
        if (!$assertionsDisabled && i3 < this.Ju) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Jw) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fx = getMeasuredWidth();
        this.Fy = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        switch (this.FH) {
            case 10000:
                this.Jy = (int) (this.Ju - this.Fy);
                invalidate();
                return;
            case 10001:
                this.Jy = (int) (this.Fy - this.Jw);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Jy = 0;
                invalidate();
                return;
        }
    }
}
