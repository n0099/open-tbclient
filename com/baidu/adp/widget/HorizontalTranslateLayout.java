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
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private float FC;
    private float FD;
    private int FE;
    private final int FF;
    private boolean FG;
    private boolean FH;
    private TrackDirection FI;
    private int FJ;
    private final Rect FK;
    private final Rect FL;
    private final Paint FM;
    private int FN;
    private int FO;
    private int FP;
    private boolean FQ;
    private final g FR;
    private final h FS;
    private final m FT;
    private j FU;
    private l FV;
    private final List<k> FW;
    private i FX;
    private int Fz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (Gg) with 'values()' method */
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
        this.FM.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.FE = (int) ((this.FC - this.Fz) * (-f));
            } else if (f > 0.0f) {
                this.FE = (int) ((this.Fz - this.FD) * f);
            } else if (f == 0.0f) {
                this.FE = 0;
                this.FJ = 10004;
            } else if (f == -1.0f) {
                this.FC -= getMeasuredWidth();
                this.FJ = 10000;
            } else if (f == 1.0f) {
                this.FC = getMeasuredWidth() - this.FD;
                this.FJ = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FC;
    }

    public int getRightOffset() {
        return (int) this.FD;
    }

    public void setLeftTapBack(boolean z) {
        this.FG = z;
    }

    public void setRightTapBack(boolean z) {
        this.FH = z;
    }

    public int getState() {
        return this.FJ;
    }

    public void setLeftAnimationListener(j jVar) {
        this.FU = jVar;
    }

    public void setRightAnimationListener(l lVar) {
        this.FV = lVar;
    }

    public void setHorizontalTrackListener(i iVar) {
        this.FX = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FE, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.FE);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FM);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FE;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FI == TrackDirection.none) {
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
                    this.FR.removeMessages(-100);
                    this.FR.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.FR.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.FR.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FE, 0.0f);
                    return f(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i2 >= this.FO - this.FF && i2 <= this.FO + this.FF && (i < this.FN - this.FF || i > this.FN + this.FF) && this.FT.aw(i - this.FN);
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
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FQ = false;
                    if (this.FT.Gi) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.FT.mu();
                        m.a(this.FT);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FT.Gi) {
                        if (!this.FQ) {
                            if (x > this.FN) {
                                this.FP = this.FN + this.FF;
                                this.FQ = true;
                            } else {
                                this.FP = this.FN - this.FF;
                                this.FQ = true;
                            }
                        }
                        this.FT.ax(this.FP - x);
                        this.FP = x;
                        this.FT.Gh.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.FK);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FL);
        switch (action) {
            case 0:
                if ((this.FJ != 10000 || !this.FK.contains(x, y)) && (this.FJ != 10001 || !this.FL.contains(x, y))) {
                    return false;
                }
                if (!this.FT.Gi) {
                    this.FP = x;
                    this.FT.aw(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FT.Gi) {
                    this.FT.mu();
                    m.a(this.FT);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FT.Gi) {
            this.FT.ax(this.FP - x);
            this.FP = x;
            this.FT.Gh.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FC != -1.0f) {
                this.FK.set(i, i2, (int) (i + this.FC), i4);
            }
            if (this.FD != -1.0f) {
                this.FL.set((int) (i3 - this.FD), i2, i3, i4);
            }
        }
        if (!this.FS.Gf && !this.FT.Gi) {
            mi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FC) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FD) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fz = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        switch (this.FJ) {
            case 10000:
                this.FE = (int) (this.FC - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.FE = (int) (getMeasuredWidth() - this.FD);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.FE = 0;
                invalidate();
                return;
        }
    }
}
