package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f553a;
    private i A;
    private int b;
    private int c;
    private float d;
    private float e;
    private int f;
    private final int g;
    private boolean h;
    private boolean i;
    private TrackDirection j;
    private int k;
    private final Rect l;
    private final Rect m;
    private final Paint n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private final g s;
    private final h t;
    private final o u;
    private j v;
    private m w;
    private final List<l> x;
    private k y;
    private n z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    static {
        f553a = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(HorizontalTranslateLayout horizontalTranslateLayout, int i) {
        int i2 = horizontalTranslateLayout.f - i;
        horizontalTranslateLayout.f = i2;
        return i2;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.n.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.f = (int) ((this.d - this.b) * (-f));
            } else if (f > 0.0f) {
                this.f = (int) ((this.b - this.e) * f);
            } else if (f == 0.0f) {
                this.f = 0;
                this.k = 10004;
            } else if (f == -1.0f) {
                this.d -= getMeasuredWidth();
                this.k = VersionUtils.CUR_DEVELOPMENT;
            } else if (f == 1.0f) {
                this.d = getMeasuredWidth() - this.e;
                this.k = PushConstants.ERROR_NETWORK_ERROR;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.d;
    }

    public int getRightOffset() {
        return (int) this.e;
    }

    public void setLeftTapBack(boolean z) {
        this.h = z;
    }

    public void setRightTapBack(boolean z) {
        this.i = z;
    }

    public int getState() {
        return this.k;
    }

    public void setLeftAnimationListener(j jVar) {
        this.v = jVar;
    }

    public void setRightAnimationListener(m mVar) {
        this.w = mVar;
    }

    public void setLeftTrackListener(k kVar) {
        this.y = kVar;
    }

    public void setRightTrackListener(n nVar) {
        this.z = nVar;
    }

    public void setHorizontalTrackListener(i iVar) {
        this.A = iVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.f);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.n);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.j == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & Util.MASK_8BIT;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.k == 10004) {
            switch (action) {
                case 0:
                    this.o = x;
                    this.p = y;
                    this.s.removeMessages(-100);
                    this.s.removeMessages(-104);
                    this.s.removeMessages(-101);
                    this.s.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.f, 0.0f);
                    return a(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean a(int i, int i2) {
        return i2 >= this.p - this.g && i2 <= this.p + this.g && (i < this.o - this.g || i > this.o + this.g) && this.u.a(i - this.o);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & Util.MASK_8BIT;
        if (this.k == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.r = false;
                    if (this.u.b) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.u.a();
                        o.a(this.u);
                        return true;
                    }
                    return true;
                case 2:
                    if (this.u.b) {
                        if (!this.r) {
                            if (x > this.o) {
                                this.q = this.o + this.g;
                                this.r = true;
                            } else {
                                this.q = this.o - this.g;
                                this.r = true;
                            }
                        }
                        this.u.b(this.q - x);
                        this.q = x;
                        this.u.f607a.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.l);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.m);
        switch (action) {
            case 0:
                if ((this.k != 10000 || !this.l.contains(x, y)) && (this.k != 10001 || !this.m.contains(x, y))) {
                    return false;
                }
                if (!this.u.b) {
                    this.q = x;
                    this.u.a(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.u.b) {
                    this.u.a();
                    o.a(this.u);
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.u.b) {
            this.u.b(this.q - x);
            this.q = x;
            this.u.f607a.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.d != -1.0f) {
                this.l.set(i, i2, (int) (i + this.d), i4);
            }
            if (this.e != -1.0f) {
                this.m.set((int) (i3 - this.e), i2, i3, i4);
            }
        }
        if (!this.t.g && !this.u.b) {
            a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!f553a && i3 < this.d) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!f553a && i3 < this.e) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        switch (this.k) {
            case VersionUtils.CUR_DEVELOPMENT /* 10000 */:
                this.f = (int) (this.d - getMeasuredWidth());
                invalidate();
                return;
            case PushConstants.ERROR_NETWORK_ERROR /* 10001 */:
                this.f = (int) (getMeasuredWidth() - this.e);
                invalidate();
                return;
            case PushConstants.ERROR_SERVICE_NOT_AVAILABLE /* 10002 */:
            case PushConstants.ERROR_SERVICE_NOT_AVAILABLE_TEMP /* 10003 */:
            default:
                return;
            case 10004:
                this.f = 0;
                invalidate();
                return;
        }
    }
}
