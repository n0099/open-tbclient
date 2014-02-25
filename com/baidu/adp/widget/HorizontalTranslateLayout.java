package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean a;
    private h A;
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
    private final f s;
    private final g t;
    private final n u;
    private i v;
    private l w;
    private final List<k> x;
    private j y;
    private m z;

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
                this.k = 10000;
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

    public void setLeftAnimationListener(i iVar) {
        this.v = iVar;
    }

    public void setRightAnimationListener(l lVar) {
        this.w = lVar;
    }

    public void setLeftTrackListener(j jVar) {
        this.y = jVar;
    }

    public void setRightTrackListener(m mVar) {
        this.z = mVar;
    }

    public void setHorizontalTrackListener(h hVar) {
        this.A = hVar;
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
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.k == 10004) {
            switch (action) {
                case 0:
                    this.o = x;
                    this.p = y;
                    this.s.removeMessages(-100);
                    this.s.removeMessages(SapiErrorCode.GETTING_CERT);
                    this.s.removeMessages(SapiErrorCode.SENT_SUCCEED);
                    this.s.removeMessages(SapiErrorCode.GET_CERT_FAIL);
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
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.k == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.r = false;
                    if (this.u.b) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.u.a();
                        n.a(this.u);
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
                        this.u.a.addMovement(motionEvent);
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
                    n.a(this.u);
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
            this.u.a.addMovement(motionEvent);
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
        if (!a && i3 < this.d) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!a && i3 < this.e) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        switch (this.k) {
            case 10000:
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
