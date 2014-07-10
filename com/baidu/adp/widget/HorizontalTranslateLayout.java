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
    static final /* synthetic */ boolean a;
    private int b;
    private float c;
    private float d;
    private int e;
    private final int f;
    private boolean g;
    private boolean h;
    private TrackDirection i;
    private int j;
    private final Rect k;
    private final Rect l;
    private final Paint m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private final f r;
    private final g s;
    private final l t;
    private i u;
    private k v;
    private final List<j> w;
    private h x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        a = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.m.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.e = (int) ((this.c - this.b) * (-f));
            } else if (f > 0.0f) {
                this.e = (int) ((this.b - this.d) * f);
            } else if (f == 0.0f) {
                this.e = 0;
                this.j = 10004;
            } else if (f == -1.0f) {
                this.c -= getMeasuredWidth();
                this.j = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.c = getMeasuredWidth() - this.d;
                this.j = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.c;
    }

    public int getRightOffset() {
        return (int) this.d;
    }

    public void setLeftTapBack(boolean z) {
        this.g = z;
    }

    public void setRightTapBack(boolean z) {
        this.h = z;
    }

    public int getState() {
        return this.j;
    }

    public void setLeftAnimationListener(i iVar) {
        this.u = iVar;
    }

    public void setRightAnimationListener(k kVar) {
        this.v = kVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.x = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.e, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.e);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.m);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.i == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.j == 10004) {
            switch (action) {
                case 0:
                    this.n = x;
                    this.o = y;
                    this.r.removeMessages(-100);
                    this.r.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.r.removeMessages(-101);
                    this.r.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.e, 0.0f);
                    return a(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean a(int i, int i2) {
        return i2 >= this.o - this.f && i2 <= this.o + this.f && (i < this.n - this.f || i > this.n + this.f) && this.t.a(i - this.n);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.j == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.q = false;
                    if (this.t.b) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.t.a();
                        l.a(this.t);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.t.b) {
                        if (!this.q) {
                            if (x > this.n) {
                                this.p = this.n + this.f;
                                this.q = true;
                            } else {
                                this.p = this.n - this.f;
                                this.q = true;
                            }
                        }
                        this.t.b(this.p - x);
                        this.p = x;
                        this.t.a.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.k);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.l);
        switch (action) {
            case 0:
                if ((this.j != 10000 || !this.k.contains(x, y)) && (this.j != 10001 || !this.l.contains(x, y))) {
                    return false;
                }
                if (!this.t.b) {
                    this.p = x;
                    this.t.a(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.t.b) {
                    this.t.a();
                    l.a(this.t);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.t.b) {
            this.t.b(this.p - x);
            this.p = x;
            this.t.a.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.c != -1.0f) {
                this.k.set(i, i2, (int) (i + this.c), i4);
            }
            if (this.d != -1.0f) {
                this.l.set((int) (i3 - this.d), i2, i3, i4);
            }
        }
        if (!this.s.g && !this.t.b) {
            a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!a && i3 < this.c) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!a && i3 < this.d) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.b = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        switch (this.j) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.e = (int) (this.c - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.e = (int) (getMeasuredWidth() - this.d);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.e = 0;
                invalidate();
                return;
        }
    }
}
