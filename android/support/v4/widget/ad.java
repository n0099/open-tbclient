package android.support.v4.widget;

import android.support.v4.view.al;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.baidu.location.LocationClientOption;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ad {
    private static final Interpolator v = new ae();

    /* renamed from: a  reason: collision with root package name */
    private int f352a;
    private int b;
    private int c;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private m q;
    private final af r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;

    public int a() {
        return this.f352a;
    }

    public int b() {
        return this.o;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.c = i;
        this.r.b(view, i);
        b(1);
    }

    public View c() {
        return this.s;
    }

    public int d() {
        return this.b;
    }

    public void e() {
        this.c = -1;
        g();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public void f() {
        e();
        if (this.f352a == 2) {
            int b = this.q.b();
            int c = this.q.c();
            this.q.g();
            int b2 = this.q.b();
            int c2 = this.q.c();
            this.r.a(this.s, b2, c2, b2 - b, c2 - c);
        }
        b(0);
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.c = -1;
        return a(i, i2, 0, 0);
    }

    public boolean a(int i, int i2) {
        if (!this.t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return a(i, i2, (int) al.a(this.l, this.c), (int) al.b(this.l, this.c));
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.g();
            b(0);
            return false;
        }
        this.q.a(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        b(2);
        return true;
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int b = b(i3, (int) this.n, (int) this.m);
        int b2 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        float f = b != 0 ? abs3 / i5 : abs / i6;
        return (int) (((b2 != 0 ? abs4 / i5 : abs2 / i6) * a(i2, b2, this.r.b(view))) + (f * a(i, b, this.r.a(view))));
    }

    private int a(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float a2 = (a(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private float a(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    public boolean a(boolean z) {
        boolean z2;
        if (this.f352a == 2) {
            boolean f = this.q.f();
            int b = this.q.b();
            int c = this.q.c();
            int left = b - this.s.getLeft();
            int top = c - this.s.getTop();
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.r.a(this.s, b, c, left, top);
            }
            if (f && b == this.q.d() && c == this.q.e()) {
                this.q.g();
                z2 = this.q.a();
            } else {
                z2 = f;
            }
            if (!z2) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    b(0);
                }
            }
        }
        return this.f352a == 2;
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.f352a == 1) {
            b(0);
        }
    }

    private void g() {
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    private void e(int i) {
        if (this.d != null) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k &= (1 << i) ^ (-1);
        }
    }

    private void f(int i) {
        if (this.d == null || this.d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.d != null) {
                System.arraycopy(this.d, 0, fArr, 0, this.d.length);
                System.arraycopy(this.e, 0, fArr2, 0, this.e.length);
                System.arraycopy(this.f, 0, fArr3, 0, this.f.length);
                System.arraycopy(this.g, 0, fArr4, 0, this.g.length);
                System.arraycopy(this.h, 0, iArr, 0, this.h.length);
                System.arraycopy(this.i, 0, iArr2, 0, this.i.length);
                System.arraycopy(this.j, 0, iArr3, 0, this.j.length);
            }
            this.d = fArr;
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private void a(float f, float f2, int i) {
        f(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = f((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void c(MotionEvent motionEvent) {
        int c = android.support.v4.view.z.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = android.support.v4.view.z.b(motionEvent, i);
            float c2 = android.support.v4.view.z.c(motionEvent, i);
            float d = android.support.v4.view.z.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }

    public boolean a(int i) {
        return (this.k & (1 << i)) != 0;
    }

    void b(int i) {
        if (this.f352a != i) {
            this.f352a = i;
            this.r.a(i);
            if (i == 0) {
                this.s = null;
            }
        }
    }

    boolean b(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view != null && this.r.a(view, i)) {
            this.c = i;
            a(view, i);
            return true;
        }
        return false;
    }

    public boolean a(MotionEvent motionEvent) {
        int i;
        View e;
        View e2;
        int a2 = android.support.v4.view.z.a(motionEvent);
        int b = android.support.v4.view.z.b(motionEvent);
        if (a2 == 0) {
            e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (a2) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int b2 = android.support.v4.view.z.b(motionEvent, 0);
                a(x, y, b2);
                View e3 = e((int) x, (int) y);
                if (e3 == this.s && this.f352a == 2) {
                    b(e3, b2);
                }
                int i2 = this.h[b2];
                if ((this.p & i2) != 0) {
                    this.r.a(i2 & this.p, b2);
                    break;
                }
                break;
            case 1:
            case 3:
                e();
                break;
            case 2:
                int c = android.support.v4.view.z.c(motionEvent);
                for (i = 0; i < c; i = i + 1) {
                    int b3 = android.support.v4.view.z.b(motionEvent, i);
                    float c2 = android.support.v4.view.z.c(motionEvent, i);
                    float d = android.support.v4.view.z.d(motionEvent, i);
                    float f = c2 - this.d[b3];
                    float f2 = d - this.e[b3];
                    b(f, f2, b3);
                    i = (this.f352a == 1 || ((e = e((int) c2, (int) d)) != null && a(e, f, f2) && b(e, b3))) ? 0 : i + 1;
                    c(motionEvent);
                    break;
                }
                c(motionEvent);
                break;
            case 5:
                int b4 = android.support.v4.view.z.b(motionEvent, b);
                float c3 = android.support.v4.view.z.c(motionEvent, b);
                float d2 = android.support.v4.view.z.d(motionEvent, b);
                a(c3, d2, b4);
                if (this.f352a == 0) {
                    int i3 = this.h[b4];
                    if ((this.p & i3) != 0) {
                        this.r.a(i3 & this.p, b4);
                        break;
                    }
                } else if (this.f352a == 2 && (e2 = e((int) c3, (int) d2)) == this.s) {
                    b(e2, b4);
                    break;
                }
                break;
            case 6:
                e(android.support.v4.view.z.b(motionEvent, b));
                break;
        }
        return this.f352a == 1;
    }

    public void b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int a2 = android.support.v4.view.z.a(motionEvent);
        int b = android.support.v4.view.z.b(motionEvent);
        if (a2 == 0) {
            e();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (a2) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int b2 = android.support.v4.view.z.b(motionEvent, 0);
                View e = e((int) x, (int) y);
                a(x, y, b2);
                b(e, b2);
                int i3 = this.h[b2];
                if ((this.p & i3) != 0) {
                    this.r.a(i3 & this.p, b2);
                    return;
                }
                return;
            case 1:
                if (this.f352a == 1) {
                    h();
                }
                e();
                return;
            case 2:
                if (this.f352a == 1) {
                    int a3 = android.support.v4.view.z.a(motionEvent, this.c);
                    float c = android.support.v4.view.z.c(motionEvent, a3);
                    float d = android.support.v4.view.z.d(motionEvent, a3);
                    int i4 = (int) (c - this.f[this.c]);
                    int i5 = (int) (d - this.g[this.c]);
                    b(this.s.getLeft() + i4, this.s.getTop() + i5, i4, i5);
                    c(motionEvent);
                    return;
                }
                int c2 = android.support.v4.view.z.c(motionEvent);
                while (i2 < c2) {
                    int b3 = android.support.v4.view.z.b(motionEvent, i2);
                    float c3 = android.support.v4.view.z.c(motionEvent, i2);
                    float d2 = android.support.v4.view.z.d(motionEvent, i2);
                    float f = c3 - this.d[b3];
                    float f2 = d2 - this.e[b3];
                    b(f, f2, b3);
                    if (this.f352a != 1) {
                        View e2 = e((int) c3, (int) d2);
                        if (!a(e2, f, f2) || !b(e2, b3)) {
                            i2++;
                        }
                    }
                    c(motionEvent);
                    return;
                }
                c(motionEvent);
                return;
            case 3:
                if (this.f352a == 1) {
                    a(0.0f, 0.0f);
                }
                e();
                return;
            case 4:
            default:
                return;
            case 5:
                int b4 = android.support.v4.view.z.b(motionEvent, b);
                float c4 = android.support.v4.view.z.c(motionEvent, b);
                float d3 = android.support.v4.view.z.d(motionEvent, b);
                a(c4, d3, b4);
                if (this.f352a == 0) {
                    b(e((int) c4, (int) d3), b4);
                    int i6 = this.h[b4];
                    if ((this.p & i6) != 0) {
                        this.r.a(i6 & this.p, b4);
                        return;
                    }
                    return;
                } else if (d((int) c4, (int) d3)) {
                    b(this.s, b4);
                    return;
                } else {
                    return;
                }
            case 6:
                int b5 = android.support.v4.view.z.b(motionEvent, b);
                if (this.f352a == 1 && b5 == this.c) {
                    int c5 = android.support.v4.view.z.c(motionEvent);
                    while (true) {
                        if (i2 >= c5) {
                            i = -1;
                        } else {
                            int b6 = android.support.v4.view.z.b(motionEvent, i2);
                            if (b6 != this.c) {
                                if (e((int) android.support.v4.view.z.c(motionEvent, i2), (int) android.support.v4.view.z.d(motionEvent, i2)) == this.s && b(this.s, b6)) {
                                    i = this.c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        h();
                    }
                }
                e(b5);
                return;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = a(f, f2, i, 1) ? 1 : 0;
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        if (abs > this.b || abs2 > this.b) {
            if (abs >= abs2 * 0.5f || !this.r.b(i2)) {
                return (this.i[i] & i2) == 0 && abs > ((float) this.b);
            }
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.a(view) > 0;
        boolean z2 = this.r.b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
    }

    public boolean c(int i) {
        int length = this.d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(int i, int i2) {
        if (a(i2)) {
            boolean z = (i & 1) == 1;
            boolean z2 = (i & 2) == 2;
            float f = this.f[i2] - this.d[i2];
            float f2 = this.g[i2] - this.e[i2];
            return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
        }
        return false;
    }

    public boolean d(int i) {
        int length = this.h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean c(int i, int i2) {
        return a(i2) && (this.h[i2] & i) != 0;
    }

    private void h() {
        this.l.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, this.m);
        a(a(al.a(this.l, this.c), this.n, this.m), a(al.b(this.l, this.c), this.n, this.m));
    }

    private void b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i5 = this.r.a(this.s, i, i3);
            this.s.offsetLeftAndRight(i5 - left);
        } else {
            i5 = i;
        }
        if (i4 != 0) {
            i6 = this.r.b(this.s, i2, i4);
            this.s.offsetTopAndBottom(i6 - top);
        } else {
            i6 = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.r.a(this.s, i5, i6, i5 - left, i6 - top);
        }
    }

    public boolean d(int i, int i2) {
        return b(this.s, i, i2);
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View e(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int f(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }
}
