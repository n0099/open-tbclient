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
    static final /* synthetic */ boolean ju;
    private int sA;
    private boolean sB;
    private final f sC;
    private final g sD;
    private final l sE;
    private i sF;
    private k sG;
    private final List<j> sH;
    private h sI;
    private int sj;
    private float sm;
    private float sn;
    private int so;
    private final int sq;
    private boolean sr;
    private boolean ss;
    private TrackDirection st;
    private int su;
    private final Rect sv;
    private final Rect sw;
    private final Paint sx;
    private int sy;
    private int sz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (sR) with 'values()' method */
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
        ju = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.sx.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.so = (int) ((this.sm - this.sj) * (-f));
            } else if (f > 0.0f) {
                this.so = (int) ((this.sj - this.sn) * f);
            } else if (f == 0.0f) {
                this.so = 0;
                this.su = 10004;
            } else if (f == -1.0f) {
                this.sm -= getMeasuredWidth();
                this.su = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.sm = getMeasuredWidth() - this.sn;
                this.su = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.sm;
    }

    public int getRightOffset() {
        return (int) this.sn;
    }

    public void setLeftTapBack(boolean z) {
        this.sr = z;
    }

    public void setRightTapBack(boolean z) {
        this.ss = z;
    }

    public int getState() {
        return this.su;
    }

    public void setLeftAnimationListener(i iVar) {
        this.sF = iVar;
    }

    public void setRightAnimationListener(k kVar) {
        this.sG = kVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.sI = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.so, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.so);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.sx);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.so;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.st == TrackDirection.none) {
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
                    this.sC.removeMessages(-100);
                    this.sC.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.sC.removeMessages(-101);
                    this.sC.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.so, 0.0f);
                    return e(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean e(int i, int i2) {
        return i2 >= this.sz - this.sq && i2 <= this.sz + this.sq && (i < this.sy - this.sq || i > this.sy + this.sq) && this.sE.ae(i - this.sy);
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
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.sB = false;
                    if (this.sE.sT) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.sE.hg();
                        l.a(this.sE);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.sE.sT) {
                        if (!this.sB) {
                            if (x > this.sy) {
                                this.sA = this.sy + this.sq;
                                this.sB = true;
                            } else {
                                this.sA = this.sy - this.sq;
                                this.sB = true;
                            }
                        }
                        this.sE.af(this.sA - x);
                        this.sA = x;
                        this.sE.sS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.sv);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.sw);
        switch (action) {
            case 0:
                if ((this.su != 10000 || !this.sv.contains(x, y)) && (this.su != 10001 || !this.sw.contains(x, y))) {
                    return false;
                }
                if (!this.sE.sT) {
                    this.sA = x;
                    this.sE.ae(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.sE.sT) {
                    this.sE.hg();
                    l.a(this.sE);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.sE.sT) {
            this.sE.af(this.sA - x);
            this.sA = x;
            this.sE.sS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.sm != -1.0f) {
                this.sv.set(i, i2, (int) (i + this.sm), i4);
            }
            if (this.sn != -1.0f) {
                this.sw.set((int) (i3 - this.sn), i2, i3, i4);
            }
        }
        if (!this.sD.sQ && !this.sE.sT) {
            gU();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!ju && i3 < this.sm) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!ju && i3 < this.sn) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.sj = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU() {
        switch (this.su) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.so = (int) (this.sm - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.so = (int) (getMeasuredWidth() - this.sn);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.so = 0;
                invalidate();
                return;
        }
    }
}
