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
    private final Paint FB;
    private int FC;
    private int FD;
    private final List<x> FL;
    private int Fo;
    private int Fp;
    private final int Fu;
    private int Fy;
    private final v JA;
    private final aa JB;
    private y JC;
    private w JD;
    private z JE;
    private float Jn;
    private float Jo;
    private float Jp;
    private float Jq;
    private int Jr;
    private boolean Js;
    private boolean Jt;
    private TrackDirection Ju;
    private final Rect Jv;
    private final Rect Jw;
    private int Jx;
    private boolean Jy;
    private final u Jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JG) with 'values()' method */
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
        this.FB.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.Jr = (int) ((this.Jn - this.Fp) * (-f));
            } else if (f > 0.0f) {
                this.Jr = (int) ((this.Fp - this.Jp) * f);
            } else if (f == 0.0f) {
                this.Jr = 0;
                this.Fy = 10004;
            } else if (f == -1.0f) {
                this.Jn -= this.Fp;
                this.Fy = 10000;
            } else if (f == 1.0f) {
                this.Jn = this.Fp - this.Jp;
                this.Fy = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Jn;
    }

    public int getBottomOffset() {
        return (int) this.Jp;
    }

    public void setTopTapBack(boolean z) {
        this.Js = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Jt = z;
    }

    public int getState() {
        return this.Fy;
    }

    public void setTopAnimationListener(y yVar) {
        this.JC = yVar;
    }

    public void setBottomAnimationListener(w wVar) {
        this.JD = wVar;
    }

    public void setVerticalTrackListener(z zVar) {
        this.JE = zVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Jr);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Jr);
        canvas.drawRect(0.0f, 0.0f, this.Fo, this.Fp, this.FB);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Jr;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ju == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fy == 10004) {
            switch (action) {
                case 0:
                    this.FC = x;
                    this.FD = y;
                    this.Jz.removeMessages(-100);
                    this.Jz.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.Jz.removeMessages(-101);
                    this.Jz.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Jr);
                    return f(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i >= this.FC - this.Fu && i <= this.FC + this.Fu && (i2 < this.FD - this.Fu || i2 > this.FD + this.Fu) && this.JB.au(i2 - this.FD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fy == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.Jy = false;
                    if (this.JB.FX) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JB.mN();
                        aa.a(this.JB);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JB.FX) {
                        if (!this.Jy) {
                            if (y > this.FD) {
                                this.Jx = this.FD + this.Fu;
                                this.Jy = true;
                            } else {
                                this.Jx = this.FD - this.Fu;
                                this.Jy = true;
                            }
                        }
                        this.JB.av(this.Jx - y);
                        this.Jx = y;
                        this.JB.FW.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fy != 10000 || !this.Jv.contains(x, y)) && (this.Fy != 10001 || !this.Jw.contains(x, y))) {
                    return false;
                }
                if (!this.JB.FX) {
                    this.Jx = y;
                    this.JB.au(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JB.FX) {
                    this.JB.mN();
                    aa.a(this.JB);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JB.FX) {
            this.JB.av(this.Jx - y);
            this.Jx = y;
            this.JB.FW.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Jn != -1.0f) {
                this.Jv.set(i, i2, i3, (int) (i2 + this.Jn));
            }
            if (this.Jp != -1.0f) {
                this.Jw.set(i, (int) (i4 - this.Jp), i3, i4);
            }
        }
        if (!this.JA.FU && !this.JB.FX) {
            mB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Jo != -1.0f) {
            this.Jn = i3 - this.Jq;
        }
        if (this.Jq != -1.0f) {
            this.Jp = i3 - this.Jo;
        }
        if (!$assertionsDisabled && i3 < this.Jn) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Jp) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fo = getMeasuredWidth();
        this.Fp = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        switch (this.Fy) {
            case 10000:
                this.Jr = (int) (this.Jn - this.Fp);
                invalidate();
                return;
            case 10001:
                this.Jr = (int) (this.Fp - this.Jp);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Jr = 0;
                invalidate();
                return;
        }
    }
}
