package com.baidu.mapapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.MapView;
import java.lang.reflect.Method;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends View {
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private Paint I;
    private MapView.a M;

    /* renamed from: a  reason: collision with root package name */
    boolean f543a;
    int b;
    int c;
    int d;
    double e;
    int f;
    int g;
    private int n;
    private int o;
    private int p;
    private int q;
    private MapView r;
    private List s;
    private boolean t;
    private boolean u;
    private long v;
    private long w;
    private long x;
    private float y;
    private float z;
    private static Bitmap h = null;
    private static ShortBuffer i = null;
    private static short[] j = null;
    private static int k = 0;
    private static int l = 0;
    private static int m = 0;
    private static Method J = null;
    private static Method K = null;
    private static Method L = null;

    public a(Context context, MapView mapView) {
        super(context);
        this.f543a = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = new ArrayList();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.t = false;
        this.u = true;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.e = 1.0d;
        this.E = 0;
        this.f = 0;
        this.g = 0;
        this.F = 0;
        this.G = false;
        this.H = 0;
        this.I = new Paint();
        this.M = MapView.a.DRAW_RETICLE_OVER;
        this.r = mapView;
        this.I.setColor(-7829368);
        this.I.setStyle(Paint.Style.STROKE);
    }

    private void c(Canvas canvas) {
    }

    private void d(Canvas canvas) {
        long nanoTime = (System.nanoTime() * 1000) / 1000000000;
        for (Overlay overlay : this.s) {
            overlay.draw(canvas, this.r, false, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (h != null && h.isRecycled()) {
            h.recycle();
        }
        l = 0;
        m = 0;
        h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        int minZoomLevel = this.r.getMinZoomLevel();
        int maxZoomLevel = this.r.getMaxZoomLevel();
        if (minZoomLevel > i2 || i2 > maxZoomLevel) {
            return;
        }
        Mj.MapProc(4098, i2, 1);
    }

    public void a(int i2, int i3, int i4) {
        this.F += i2;
        this.E = 3;
        if (i3 == 0 && i4 == 0) {
            this.f = h.getWidth() / 2;
            this.g = h.getHeight() / 2;
        } else {
            this.f = i3;
            this.g = i4;
        }
        Mj.p = 1;
        invalidate();
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i5 <= 0 || i4 <= 0) {
            return;
        }
        int i6 = ((i4 + 3) / 4) * 4;
        int i7 = ((i5 + 3) / 4) * 4;
        if (l == i6 && m == i7) {
            return;
        }
        for (Overlay overlay : this.s) {
            overlay.a(i2, i3, i6, i7);
        }
        int i8 = i6 * i7 * 2;
        if (i8 > k) {
            j = new short[i8];
            i = ShortBuffer.allocate(i8);
            k = i8;
        }
        if (h != null && !h.isRecycled()) {
            h.recycle();
        }
        try {
            h = Bitmap.createBitmap(i6, i7, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            System.gc();
            if (h != null && !h.isRecycled()) {
                h.recycle();
            }
        }
        Mj.p = 1;
        Mj.renderUpdateScreen(j, i6, i7);
        l = i6;
        m = i7;
    }

    protected void a(Canvas canvas) {
        canvas.drawRGB(192, 192, 192);
        Matrix matrix = new Matrix();
        if (this.H == 1 || this.e == 1.0d) {
            canvas.drawBitmap(h, this.c, this.d, (Paint) null);
            return;
        }
        double abs = Math.abs(this.e);
        matrix.postScale((float) abs, (float) abs, this.f, this.g);
        matrix.postTranslate(this.c, this.d);
        canvas.drawBitmap(h, matrix, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.u = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        boolean z = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z = ((Overlay) this.s.get(size)).onKeyDown(i2, keyEvent, this.r);
            if (z) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MotionEvent motionEvent) {
        int i2;
        if (Integer.parseInt(Build.VERSION.SDK) <= 4) {
            i2 = 1;
        } else {
            try {
                if (J == null) {
                    Class<?> cls = Class.forName("android.view.MotionEvent");
                    J = cls.getMethod("getPointerCount", null);
                    L = cls.getMethod("getX", Integer.TYPE);
                    K = cls.getMethod("getY", Integer.TYPE);
                }
                i2 = ((Integer) J.invoke(motionEvent, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                i2 = 0;
            }
        }
        if (i2 == 2) {
            try {
                this.y = ((Float) L.invoke(motionEvent, 0)).floatValue();
                this.z = ((Float) K.invoke(motionEvent, 0)).floatValue();
                this.A = ((Float) L.invoke(motionEvent, 1)).floatValue();
                this.B = ((Float) K.invoke(motionEvent, 1)).floatValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.D = ((float) Math.sqrt(((this.y - this.A) * (this.y - this.A)) + ((this.z - this.B) * (this.z - this.B)))) / 2.0f;
            if (this.E != 0) {
                double d = this.D / this.C;
                double log = (Math.log(this.D / this.C) / Math.log(2.0d)) + this.r.getZoomLevel();
                int i3 = (this.f + this.c) - (l / 2);
                int i4 = (this.g + this.d) - (m / 2);
                if (d > 1.0d && log >= this.r.getMaxZoomLevel()) {
                    b(this.r.getMaxZoomLevel() - this.r.getZoomLevel(), i3, i4);
                    this.E = 0;
                    invalidate();
                } else if (d >= 1.0d || log > this.r.getMinZoomLevel()) {
                    this.e = d;
                    invalidate();
                } else {
                    b(this.r.getMinZoomLevel() - this.r.getZoomLevel(), i3, i4);
                    this.E = 0;
                    invalidate();
                }
                if (this.H == 1) {
                    double log2 = Math.log(this.D / this.C) / Math.log(3.0d);
                    int i5 = log2 >= 0.0d ? (int) (log2 + 0.5d) : (int) (log2 - 0.5d);
                    if (i5 != 0) {
                        this.C = this.D;
                        b(i5, (this.f + this.c) - (l / 2), (this.g + this.d) - (m / 2));
                    }
                } else {
                    this.e = this.D / this.C;
                    invalidate();
                }
            } else if (this.D > Mj.j * 30.0f) {
                this.t = false;
                this.f = (int) (((this.y + this.A) / 2.0f) - this.c);
                this.g = (int) (((this.z + this.B) / 2.0f) - this.d);
                this.C = this.D;
                this.E = 1;
            }
        } else if (this.E == 1) {
            this.E = 2;
            invalidate();
        }
        if (this.E != 0) {
            return false;
        }
        for (int size = this.s.size() - 1; size >= 0; size--) {
            if (((Overlay) this.s.get(size)).onTouchEvent(motionEvent, this.r)) {
                return true;
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.n = (int) motionEvent.getX();
                this.o = (int) motionEvent.getY();
                this.c = 0;
                this.d = 0;
                this.t = true;
                Mj.l = (int) motionEvent.getX();
                Mj.m = (int) motionEvent.getY();
                Mj.MapProc(4, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case 1:
                if (!this.t) {
                    return true;
                }
                this.t = false;
                if (this.c != 0 || this.d != 0) {
                    this.c = 0;
                    this.d = 0;
                }
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.u) {
                    int i6 = (int) (50.0f * Mj.j);
                    if (this.x - this.w < 1000 && Math.abs(x - this.n) < i6 && Math.abs(y - this.o) < i6) {
                        this.v++;
                    }
                    if (this.v == 1) {
                        this.w = System.currentTimeMillis();
                    } else if (this.v >= 2) {
                        this.x = System.currentTimeMillis();
                        if (this.x - this.w < 1000 && Math.abs(this.p - x) < i6 && Math.abs(this.q - y) < i6) {
                            if (this.r.getZoomLevel() < 18) {
                                a(1, x, y);
                            }
                            this.v = 0L;
                            this.w = 0L;
                            this.x = 0L;
                            break;
                        } else {
                            this.v = 0L;
                            this.w = 0L;
                            this.x = 0L;
                        }
                    }
                }
                int i7 = (int) (10.0f * Mj.j);
                if (Math.abs(this.n - x) < i7 && Math.abs(this.o - y) < i7) {
                    x = this.n;
                    y = this.o;
                }
                this.p = x;
                this.q = y;
                Mj.n = x;
                Mj.o = y;
                Mj.MapProc(5, x, y);
                if (Math.abs(x - this.n) < 20 && Math.abs(y - this.o) < 20) {
                    for (int size2 = this.s.size() - 1; size2 >= 0; size2--) {
                        Overlay overlay = (Overlay) this.s.get(size2);
                        GeoPoint fromPixels = this.r.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (overlay instanceof ItemizedOverlay ? ((ItemizedOverlay) overlay).onTap(fromPixels, this.r) : overlay.onTap(fromPixels, this.r)) {
                            return true;
                        }
                    }
                    break;
                }
                break;
            case 2:
                if (this.t) {
                    this.c = ((int) motionEvent.getX()) - this.n;
                    this.d = ((int) motionEvent.getY()) - this.o;
                    invalidate();
                    Mj.MapProc(3, (int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        this.H = i2;
    }

    void b(int i2, int i3, int i4) {
        int minZoomLevel = this.r.getMinZoomLevel();
        int maxZoomLevel = this.r.getMaxZoomLevel();
        int zoomLevel = this.r.getZoomLevel() + i2;
        if (minZoomLevel > zoomLevel || zoomLevel > maxZoomLevel) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("act", 1001);
        bundle.putInt("opt", 10020600);
        bundle.putInt("level", i2);
        bundle.putInt("x", this.f);
        bundle.putInt("y", this.g);
        bundle.putInt("dx", i3);
        bundle.putInt("dy", i4);
        Mj.sendBundle(bundle);
    }

    protected void b(Canvas canvas) {
        a(canvas);
        if (this.G || this.e == 1.0d) {
            switch (this.M) {
                case DRAW_RETICLE_NEVER:
                    d(canvas);
                    return;
                case DRAW_RETICLE_OVER:
                    d(canvas);
                    c(canvas);
                    return;
                case DRAW_RETICLE_UNDER:
                    c(canvas);
                    d(canvas);
                    return;
                default:
                    c(canvas);
                    d(canvas);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.G = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        boolean z = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z = ((Overlay) this.s.get(size)).onKeyUp(i2, keyEvent, this.r);
            if (z) {
                break;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(MotionEvent motionEvent) {
        boolean z = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z = ((Overlay) this.s.get(size)).onTrackballEvent(motionEvent, this.r);
            if (z) {
                break;
            }
        }
        return z;
    }

    public final List c() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        for (int size = this.s.size() - 1; size >= 0; size--) {
            if (((Overlay) this.s.get(size)) instanceof MyLocationOverlay) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        double d;
        this.r.e();
        switch (this.E) {
            case 0:
                if (j != null && this.f543a) {
                    this.c = 0;
                    this.d = 0;
                    i.rewind();
                    i.put(j);
                    i.rewind();
                    h.copyPixelsFromBuffer(i);
                    this.f543a = false;
                    this.e = 1.0d;
                }
                if (this.e > 1.0d && this.r.getZoomLevel() == this.r.getMaxZoomLevel()) {
                    this.e = 1.0d;
                }
                if (this.e < 1.0d && this.r.getZoomLevel() == this.r.getMinZoomLevel()) {
                    this.e = 1.0d;
                }
                b(canvas);
                return;
            case 1:
                if (this.H == 1 && j != null && this.f543a) {
                    this.c = 0;
                    this.d = 0;
                    i.rewind();
                    i.put(j);
                    i.rewind();
                    h.copyPixelsFromBuffer(i);
                    this.f543a = false;
                    this.e = 1.0d;
                }
                if (this.e > 1.0d && this.r.getZoomLevel() == this.r.getMaxZoomLevel()) {
                    this.e = 1.0d;
                }
                if (this.e < 1.0d && this.r.getZoomLevel() == this.r.getMinZoomLevel()) {
                    this.e = 1.0d;
                }
                b(canvas);
                return;
            case 2:
                if (this.H == 1) {
                    this.E = 0;
                    b(canvas);
                    return;
                }
                double log = Math.log(this.e) / Math.log(2.0d);
                int i2 = log >= 0.0d ? (int) (0.5d + log) : (int) (log - 0.5d);
                int i3 = (int) ((i2 - log) * 10.0d);
                if (i3 != 0) {
                    if (i3 > 0) {
                        d = log + 0.1d;
                        int i4 = i3 - 1;
                    } else {
                        d = log - 0.1d;
                        int i5 = i3 + 1;
                    }
                    this.e = Math.pow(2.0d, d);
                    this.r.getZoomLevel();
                    b(canvas);
                    postInvalidate();
                    return;
                }
                this.e = Math.pow(2.0d, i2);
                b(canvas);
                if (log != 0.0d) {
                    int i6 = (this.f + this.c) - (l / 2);
                    int i7 = (this.g + this.d) - (m / 2);
                    int zoomLevel = this.r.getZoomLevel();
                    if (i2 + zoomLevel > this.r.getMaxZoomLevel()) {
                        i2 = this.r.getMaxZoomLevel() - zoomLevel;
                    }
                    if (i2 + zoomLevel < this.r.getMinZoomLevel()) {
                        i2 = this.r.getMinZoomLevel() - zoomLevel;
                    }
                    b(i2, i6, i7);
                }
                this.E = 0;
                return;
            case 3:
                if (this.H == 1) {
                    b(canvas);
                    b(this.F, 0, 0);
                    this.E = 0;
                    this.F = 0;
                    return;
                }
                double log2 = Math.log(this.e) / Math.log(2.0d);
                if (this.F > 0) {
                    this.e = (Math.pow(2.0d, (int) log2) / 10.0d) + this.e;
                } else if (this.F < 0) {
                    this.e -= Math.pow(2.0d, (int) log2) / 20.0d;
                }
                if ((this.e < this.F * 2 && this.e > 0.0d) || (this.F < 0 && this.e > (-1.0f) / (this.F * 2))) {
                    b(canvas);
                    postInvalidate();
                    return;
                }
                b(canvas);
                b(this.F, 0, 0);
                this.E = 0;
                this.F = 0;
                return;
            default:
                b(canvas);
                return;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a(i2, i3, i4 - i2, i5 - i3);
    }
}
