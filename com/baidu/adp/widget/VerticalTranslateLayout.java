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
    static final /* synthetic */ boolean a;
    private y A;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private final int i;
    private boolean j;
    private boolean k;
    private TrackDirection l;
    private int m;
    private final Rect n;
    private final Rect o;
    private final Paint p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private final t u;
    private final u v;
    private final z w;
    private x x;
    private v y;
    private final List<w> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
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
        a = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.p.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.h = (int) ((this.d - this.c) * (-f));
            } else if (f > 0.0f) {
                this.h = (int) ((this.c - this.f) * f);
            } else if (f == 0.0f) {
                this.h = 0;
                this.m = 10004;
            } else if (f == -1.0f) {
                this.d -= this.c;
                this.m = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            } else if (f == 1.0f) {
                this.d = this.c - this.f;
                this.m = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.d;
    }

    public int getBottomOffset() {
        return (int) this.f;
    }

    public void setTopTapBack(boolean z) {
        this.j = z;
    }

    public void setBottomTapBack(boolean z) {
        this.k = z;
    }

    public int getState() {
        return this.m;
    }

    public void setTopAnimationListener(x xVar) {
        this.x = xVar;
    }

    public void setBottomAnimationListener(v vVar) {
        this.y = vVar;
    }

    public void setVerticalTrackListener(y yVar) {
        this.A = yVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.h);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.h);
        canvas.drawRect(0.0f, 0.0f, this.b, this.c, this.p);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.l == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.m == 10004) {
            switch (action) {
                case 0:
                    this.q = x;
                    this.r = y;
                    this.u.removeMessages(-100);
                    this.u.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.u.removeMessages(-101);
                    this.u.removeMessages(SapiErrorCode.GET_CERT_FAIL);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.h);
                    return a(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean a(int i, int i2) {
        return i >= this.q - this.i && i <= this.q + this.i && (i2 < this.r - this.i || i2 > this.r + this.i) && this.w.a(i2 - this.r);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.m == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.t = false;
                    if (this.w.b) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.w.a();
                        z.a(this.w);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.w.b) {
                        if (!this.t) {
                            if (y > this.r) {
                                this.s = this.r + this.i;
                                this.t = true;
                            } else {
                                this.s = this.r - this.i;
                                this.t = true;
                            }
                        }
                        this.w.b(this.s - y);
                        this.s = y;
                        this.w.a.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.m != 10000 || !this.n.contains(x, y)) && (this.m != 10001 || !this.o.contains(x, y))) {
                    return false;
                }
                if (!this.w.b) {
                    this.s = y;
                    this.w.a(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.w.b) {
                    this.w.a();
                    z.a(this.w);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.w.b) {
            this.w.b(this.s - y);
            this.s = y;
            this.w.a.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.d != -1.0f) {
                this.n.set(i, i2, i3, (int) (i2 + this.d));
            }
            if (this.f != -1.0f) {
                this.o.set(i, (int) (i4 - this.f), i3, i4);
            }
        }
        if (!this.v.g && !this.w.b) {
            a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.e != -1.0f) {
            this.d = i3 - this.g;
        }
        if (this.g != -1.0f) {
            this.f = i3 - this.e;
        }
        if (!a && i3 < this.d) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!a && i3 < this.f) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        switch (this.m) {
            case TbConfig.BIG_IMAGE_MIN_CAPACITY /* 10000 */:
                this.h = (int) (this.d - this.c);
                invalidate();
                return;
            case 10001:
                this.h = (int) (this.c - this.f);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.h = 0;
                invalidate();
                return;
        }
    }
}
