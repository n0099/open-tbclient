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
    private final Rect FA;
    private final Paint FB;
    private int FC;
    private int FD;
    private int FE;
    private boolean FF;
    private final g FG;
    private final h FH;
    private final m FI;
    private j FJ;
    private l FK;
    private final List<k> FL;
    private i FM;
    private int Fo;
    private float Fr;
    private float Fs;
    private int Ft;
    private final int Fu;
    private boolean Fv;
    private boolean Fw;
    private TrackDirection Fx;
    private int Fy;
    private final Rect Fz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (FV) with 'values()' method */
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
        this.FB.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.Ft = (int) ((this.Fr - this.Fo) * (-f));
            } else if (f > 0.0f) {
                this.Ft = (int) ((this.Fo - this.Fs) * f);
            } else if (f == 0.0f) {
                this.Ft = 0;
                this.Fy = 10004;
            } else if (f == -1.0f) {
                this.Fr -= getMeasuredWidth();
                this.Fy = 10000;
            } else if (f == 1.0f) {
                this.Fr = getMeasuredWidth() - this.Fs;
                this.Fy = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Fr;
    }

    public int getRightOffset() {
        return (int) this.Fs;
    }

    public void setLeftTapBack(boolean z) {
        this.Fv = z;
    }

    public void setRightTapBack(boolean z) {
        this.Fw = z;
    }

    public int getState() {
        return this.Fy;
    }

    public void setLeftAnimationListener(j jVar) {
        this.FJ = jVar;
    }

    public void setRightAnimationListener(l lVar) {
        this.FK = lVar;
    }

    public void setHorizontalTrackListener(i iVar) {
        this.FM = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Ft, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Ft);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FB);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Ft;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Fx == TrackDirection.none) {
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
                    this.FG.removeMessages(-100);
                    this.FG.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.FG.removeMessages(-101);
                    this.FG.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Ft, 0.0f);
                    return f(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean f(int i, int i2) {
        return i2 >= this.FD - this.Fu && i2 <= this.FD + this.Fu && (i < this.FC - this.Fu || i > this.FC + this.Fu) && this.FI.au(i - this.FC);
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
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FF = false;
                    if (this.FI.FX) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.FI.mN();
                        m.a(this.FI);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FI.FX) {
                        if (!this.FF) {
                            if (x > this.FC) {
                                this.FE = this.FC + this.Fu;
                                this.FF = true;
                            } else {
                                this.FE = this.FC - this.Fu;
                                this.FF = true;
                            }
                        }
                        this.FI.av(this.FE - x);
                        this.FE = x;
                        this.FI.FW.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.Fz);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FA);
        switch (action) {
            case 0:
                if ((this.Fy != 10000 || !this.Fz.contains(x, y)) && (this.Fy != 10001 || !this.FA.contains(x, y))) {
                    return false;
                }
                if (!this.FI.FX) {
                    this.FE = x;
                    this.FI.au(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FI.FX) {
                    this.FI.mN();
                    m.a(this.FI);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FI.FX) {
            this.FI.av(this.FE - x);
            this.FE = x;
            this.FI.FW.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Fr != -1.0f) {
                this.Fz.set(i, i2, (int) (i + this.Fr), i4);
            }
            if (this.Fs != -1.0f) {
                this.FA.set((int) (i3 - this.Fs), i2, i3, i4);
            }
        }
        if (!this.FH.FU && !this.FI.FX) {
            mB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Fr) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Fs) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fo = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        switch (this.Fy) {
            case 10000:
                this.Ft = (int) (this.Fr - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Ft = (int) (getMeasuredWidth() - this.Fs);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ft = 0;
                invalidate();
                return;
        }
    }
}
