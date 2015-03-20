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
    private float FA;
    private float FB;
    private int FC;
    private final int FD;
    private boolean FE;
    private boolean FF;
    private TrackDirection FG;
    private int FH;
    private final Rect FI;
    private final Rect FJ;
    private final Paint FK;
    private int FL;
    private int FM;
    private int FN;
    private boolean FO;
    private final g FP;
    private final h FQ;
    private final m FR;
    private j FS;
    private l FT;
    private final List<k> FU;
    private i FV;
    private int Fx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (Ge) with 'values()' method */
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
        this.FK.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.FC = (int) ((this.FA - this.Fx) * (-f));
            } else if (f > 0.0f) {
                this.FC = (int) ((this.Fx - this.FB) * f);
            } else if (f == 0.0f) {
                this.FC = 0;
                this.FH = 10004;
            } else if (f == -1.0f) {
                this.FA -= getMeasuredWidth();
                this.FH = 10000;
            } else if (f == 1.0f) {
                this.FA = getMeasuredWidth() - this.FB;
                this.FH = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FA;
    }

    public int getRightOffset() {
        return (int) this.FB;
    }

    public void setLeftTapBack(boolean z) {
        this.FE = z;
    }

    public void setRightTapBack(boolean z) {
        this.FF = z;
    }

    public int getState() {
        return this.FH;
    }

    public void setLeftAnimationListener(j jVar) {
        this.FS = jVar;
    }

    public void setRightAnimationListener(l lVar) {
        this.FT = lVar;
    }

    public void setHorizontalTrackListener(i iVar) {
        this.FV = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FC, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.FC);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FK);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FC;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FG == TrackDirection.none) {
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
                    this.FP.removeMessages(-100);
                    this.FP.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.FP.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.FP.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FC, 0.0f);
                    return f(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i2 >= this.FM - this.FD && i2 <= this.FM + this.FD && (i < this.FL - this.FD || i > this.FL + this.FD) && this.FR.aw(i - this.FL);
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
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FO = false;
                    if (this.FR.Gg) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.FR.mu();
                        m.a(this.FR);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FR.Gg) {
                        if (!this.FO) {
                            if (x > this.FL) {
                                this.FN = this.FL + this.FD;
                                this.FO = true;
                            } else {
                                this.FN = this.FL - this.FD;
                                this.FO = true;
                            }
                        }
                        this.FR.ax(this.FN - x);
                        this.FN = x;
                        this.FR.Gf.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.FI);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FJ);
        switch (action) {
            case 0:
                if ((this.FH != 10000 || !this.FI.contains(x, y)) && (this.FH != 10001 || !this.FJ.contains(x, y))) {
                    return false;
                }
                if (!this.FR.Gg) {
                    this.FN = x;
                    this.FR.aw(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FR.Gg) {
                    this.FR.mu();
                    m.a(this.FR);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FR.Gg) {
            this.FR.ax(this.FN - x);
            this.FN = x;
            this.FR.Gf.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FA != -1.0f) {
                this.FI.set(i, i2, (int) (i + this.FA), i4);
            }
            if (this.FB != -1.0f) {
                this.FJ.set((int) (i3 - this.FB), i2, i3, i4);
            }
        }
        if (!this.FQ.Gd && !this.FR.Gg) {
            mi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FA) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FB) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fx = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        switch (this.FH) {
            case 10000:
                this.FC = (int) (this.FA - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.FC = (int) (getMeasuredWidth() - this.FB);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.FC = 0;
                invalidate();
                return;
        }
    }
}
