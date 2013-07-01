package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.baidu.mapapi.MapView;
import com.baidu.zeus.bouncycastle.DERTags;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private android.support.v4.widget.h Q;
    private android.support.v4.widget.h R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private bq W;
    private bq X;
    private bp Y;
    private br Z;
    private Method aa;
    private int ab;
    private ArrayList ac;
    private final Runnable ae;
    private int af;
    private int b;
    private final ArrayList e;
    private final bm f;
    private final Rect g;
    private ae h;
    private int i;
    private int j;
    private Parcelable k;
    private ClassLoader l;
    private Scroller m;
    private bs n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f83a = {16842931};
    private static final Comparator c = new bi();
    private static final Interpolator d = new bj();
    private static final bu ad = new bu();

    /* loaded from: classes.dex */
    public class SimpleOnPageChangeListener implements bq {
        @Override // android.support.v4.view.bq
        public void a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.bq
        public void a_(int i) {
        }

        @Override // android.support.v4.view.bq
        public void b(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.e = new ArrayList();
        this.f = new bm();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ae = new bk(this);
        this.af = 0;
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList();
        this.f = new bm();
        this.g = new Rect();
        this.j = -1;
        this.k = null;
        this.l = null;
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.z = 1;
        this.J = -1;
        this.S = true;
        this.T = false;
        this.ae = new bk(this);
        this.af = 0;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.E = bd.a(viewConfiguration);
        this.L = (int) (400.0f * f);
        this.M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = new android.support.v4.widget.h(context);
        this.R = new android.support.v4.widget.h(context);
        this.N = (int) (25.0f * f);
        this.O = (int) (2.0f * f);
        this.C = (int) (16.0f * f);
        aq.a(this, new bo(this));
        if (aq.c(this) == 0) {
            aq.b(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ae);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.af != i) {
            this.af = i;
            if (this.Z != null) {
                b(i != 0);
            }
            if (this.W != null) {
                this.W.b(i);
            }
        }
    }

    public void setAdapter(ae aeVar) {
        if (this.h != null) {
            this.h.unregisterDataSetObserver(this.n);
            this.h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.e.size(); i++) {
                bm bmVar = (bm) this.e.get(i);
                this.h.destroyItem((ViewGroup) this, bmVar.b, bmVar.f92a);
            }
            this.h.finishUpdate((ViewGroup) this);
            this.e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        ae aeVar2 = this.h;
        this.h = aeVar;
        this.b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new bs(this, null);
            }
            this.h.registerDataSetObserver(this.n);
            this.y = false;
            boolean z = this.S;
            this.S = true;
            this.b = this.h.getCount();
            if (this.j >= 0) {
                this.h.restoreState(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z) {
                c();
            } else {
                requestLayout();
            }
        }
        if (this.Y != null && aeVar2 != aeVar) {
            this.Y.a(aeVar2, aeVar);
        }
    }

    private void g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((bn) getChildAt(i2).getLayoutParams()).f93a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public ae getAdapter() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(bp bpVar) {
        this.Y = bpVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.y = false;
        a(i, !this.S, false);
    }

    public void a(int i, boolean z) {
        this.y = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.i;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.h == null || this.h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!z2 && this.i == i && this.e.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (i < 0) {
                i = 0;
            } else if (i >= this.h.getCount()) {
                i = this.h.getCount() - 1;
            }
            int i3 = this.z;
            if (i > this.i + i3 || i < this.i - i3) {
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    ((bm) this.e.get(i4)).c = true;
                }
            }
            boolean z3 = this.i != i;
            if (this.S) {
                this.i = i;
                if (z3 && this.W != null) {
                    this.W.a_(i);
                }
                if (z3 && this.X != null) {
                    this.X.a_(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int i3;
        bm b = b(i);
        if (b != null) {
            i3 = (int) (Math.max(this.s, Math.min(b.e, this.t)) * getClientWidth());
        } else {
            i3 = 0;
        }
        if (z) {
            a(i3, 0, i2);
            if (z2 && this.W != null) {
                this.W.a_(i);
            }
            if (z2 && this.X != null) {
                this.X.a_(i);
                return;
            }
            return;
        }
        if (z2 && this.W != null) {
            this.W.a_(i);
        }
        if (z2 && this.X != null) {
            this.X.a_(i);
        }
        a(false);
        scrollTo(i3, 0);
    }

    public void setOnPageChangeListener(bq bqVar) {
        this.W = bqVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.aa == null) {
                try {
                    this.aa = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.aa.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ab == 2) {
            i2 = (i - 1) - i2;
        }
        return ((bn) ((View) this.ac.get(i2)).getLayoutParams()).f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq a(bq bqVar) {
        bq bqVar2 = this.X;
        this.X = bqVar;
        return bqVar2;
    }

    public int getOffscreenPageLimit() {
        return this.z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.z) {
            this.z = i;
            c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.o;
        this.o = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float a(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    void a(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a2 = (i6 * a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientWidth))) + i6;
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a2 / abs2)) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / ((clientWidth * this.h.getPageWidth(this.i)) + this.o)) + 1.0f) * 100.0f);
        }
        this.m.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        aq.b(this);
    }

    bm a(int i, int i2) {
        bm bmVar = new bm();
        bmVar.b = i;
        bmVar.f92a = this.h.instantiateItem((ViewGroup) this, i);
        bmVar.d = this.h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(bmVar);
        } else {
            this.e.add(i2, bmVar);
        }
        return bmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.h.getCount();
        this.b = count;
        boolean z3 = this.e.size() < (this.z * 2) + 1 && this.e.size() < count;
        boolean z4 = false;
        int i3 = this.i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.e.size()) {
            bm bmVar = (bm) this.e.get(i4);
            int itemPosition = this.h.getItemPosition(bmVar.f92a);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.h.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.h.destroyItem((ViewGroup) this, bmVar.b, bmVar.f92a);
                if (this.i == bmVar.b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.i, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (bmVar.b != itemPosition) {
                if (bmVar.b == this.i) {
                    i3 = itemPosition;
                }
                bmVar.b = itemPosition;
                i = i4;
                z = z4;
                i2 = i3;
                z2 = true;
            } else {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = i2;
            z4 = z;
            i4 = i + 1;
        }
        if (z4) {
            this.h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.e, c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                bn bnVar = (bn) getChildAt(i6).getLayoutParams();
                if (!bnVar.f93a) {
                    bnVar.c = 0.0f;
                }
            }
            a(i3, false, true);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        a(this.i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ff, code lost:
        if (r2.b == r17.i) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(int i) {
        bm bmVar;
        int i2;
        String hexString;
        int i3;
        bm bmVar2;
        bm a2;
        if (this.i == i) {
            bmVar = null;
            i2 = 2;
        } else {
            int i4 = this.i < i ? 66 : 17;
            bm b = b(this.i);
            this.i = i;
            bmVar = b;
            i2 = i4;
        }
        if (this.h == null) {
            h();
        } else if (this.y) {
            h();
        } else if (getWindowToken() != null) {
            this.h.startUpdate((ViewGroup) this);
            int i5 = this.z;
            int max = Math.max(0, this.i - i5);
            int count = this.h.getCount();
            int min = Math.min(count - 1, i5 + this.i);
            if (count != this.b) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
            }
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i3 >= this.e.size()) {
                    break;
                }
                bmVar2 = (bm) this.e.get(i3);
                if (bmVar2.b < this.i) {
                    i6 = i3 + 1;
                }
            }
            bmVar2 = null;
            bm a3 = (bmVar2 != null || count <= 0) ? bmVar2 : a(this.i, i3);
            if (a3 != null) {
                int i7 = i3 - 1;
                bm bmVar3 = i7 >= 0 ? (bm) this.e.get(i7) : null;
                float paddingLeft = (getPaddingLeft() / getClientWidth()) + (2.0f - a3.d);
                float f = 0.0f;
                int i8 = i3;
                int i9 = i7;
                for (int i10 = this.i - 1; i10 >= 0; i10--) {
                    if (f >= paddingLeft && i10 < max) {
                        if (bmVar3 == null) {
                            break;
                        } else if (i10 == bmVar3.b && !bmVar3.c) {
                            this.e.remove(i9);
                            this.h.destroyItem((ViewGroup) this, i10, bmVar3.f92a);
                            i9--;
                            i8--;
                            bmVar3 = i9 >= 0 ? (bm) this.e.get(i9) : null;
                        }
                    } else if (bmVar3 != null && i10 == bmVar3.b) {
                        f += bmVar3.d;
                        i9--;
                        bmVar3 = i9 >= 0 ? (bm) this.e.get(i9) : null;
                    } else {
                        f += a(i10, i9 + 1).d;
                        i8++;
                        bmVar3 = i9 >= 0 ? (bm) this.e.get(i9) : null;
                    }
                }
                float f2 = a3.d;
                int i11 = i8 + 1;
                if (f2 < 2.0f) {
                    bm bmVar4 = i11 < this.e.size() ? (bm) this.e.get(i11) : null;
                    float paddingRight = 2.0f + (getPaddingRight() / getClientWidth());
                    float f3 = f2;
                    int i12 = i11;
                    int i13 = this.i + 1;
                    while (i13 < count) {
                        if (f3 >= paddingRight && i13 > min) {
                            if (bmVar4 == null) {
                                break;
                            } else if (i13 == bmVar4.b && !bmVar4.c) {
                                this.e.remove(i12);
                                this.h.destroyItem((ViewGroup) this, i13, bmVar4.f92a);
                                bmVar4 = i12 < this.e.size() ? (bm) this.e.get(i12) : null;
                            }
                        } else if (bmVar4 != null && i13 == bmVar4.b) {
                            f3 += bmVar4.d;
                            i12++;
                            bmVar4 = i12 < this.e.size() ? (bm) this.e.get(i12) : null;
                        } else {
                            bm a4 = a(i13, i12);
                            i12++;
                            f3 += a4.d;
                            bmVar4 = i12 < this.e.size() ? (bm) this.e.get(i12) : null;
                        }
                        i13++;
                        bmVar4 = bmVar4;
                        f3 = f3;
                    }
                }
                a(a3, i8, bmVar);
            }
            this.h.setPrimaryItem((ViewGroup) this, this.i, a3 != null ? a3.f92a : null);
            this.h.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                bn bnVar = (bn) childAt.getLayoutParams();
                bnVar.f = i14;
                if (!bnVar.f93a && bnVar.c == 0.0f && (a2 = a(childAt)) != null) {
                    bnVar.c = a2.d;
                    bnVar.e = a2.b;
                }
            }
            h();
            if (hasFocus()) {
                View findFocus = findFocus();
                bm b2 = findFocus != null ? b(findFocus) : null;
                if (b2 == null || b2.b != this.i) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        bm a5 = a(childAt2);
                        if (a5 != null && a5.b == this.i && childAt2.requestFocus(i2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void h() {
        if (this.ab != 0) {
            if (this.ac == null) {
                this.ac = new ArrayList();
            } else {
                this.ac.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ac.add(getChildAt(i));
            }
            Collections.sort(this.ac, ad);
        }
    }

    private void a(bm bmVar, int i, bm bmVar2) {
        bm bmVar3;
        bm bmVar4;
        int count = this.h.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.o / clientWidth : 0.0f;
        if (bmVar2 != null) {
            int i2 = bmVar2.b;
            if (i2 < bmVar.b) {
                float f2 = bmVar2.e + bmVar2.d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bmVar.b && i4 < this.e.size()) {
                    Object obj = this.e.get(i4);
                    while (true) {
                        bmVar4 = (bm) obj;
                        if (i3 <= bmVar4.b || i4 >= this.e.size() - 1) {
                            break;
                        }
                        i4++;
                        obj = this.e.get(i4);
                    }
                    while (i3 < bmVar4.b) {
                        f2 += this.h.getPageWidth(i3) + f;
                        i3++;
                    }
                    bmVar4.e = f2;
                    f2 += bmVar4.d + f;
                    i3++;
                }
            } else if (i2 > bmVar.b) {
                int size = this.e.size() - 1;
                float f3 = bmVar2.e;
                int i5 = i2 - 1;
                while (i5 >= bmVar.b && size >= 0) {
                    Object obj2 = this.e.get(size);
                    while (true) {
                        bmVar3 = (bm) obj2;
                        if (i5 >= bmVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.e.get(size);
                    }
                    while (i5 > bmVar3.b) {
                        f3 -= this.h.getPageWidth(i5) + f;
                        i5--;
                    }
                    f3 -= bmVar3.d + f;
                    bmVar3.e = f3;
                    i5--;
                }
            }
        }
        int size2 = this.e.size();
        float f4 = bmVar.e;
        int i6 = bmVar.b - 1;
        this.s = bmVar.b == 0 ? bmVar.e : -3.4028235E38f;
        this.t = bmVar.b == count + (-1) ? (bmVar.e + bmVar.d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            bm bmVar5 = (bm) this.e.get(i7);
            float f5 = f4;
            while (i6 > bmVar5.b) {
                f5 -= this.h.getPageWidth(i6) + f;
                i6--;
            }
            f4 = f5 - (bmVar5.d + f);
            bmVar5.e = f4;
            if (bmVar5.b == 0) {
                this.s = f4;
            }
            i6--;
        }
        float f6 = bmVar.e + bmVar.d + f;
        int i8 = bmVar.b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            bm bmVar6 = (bm) this.e.get(i9);
            float f7 = f6;
            while (i8 < bmVar6.b) {
                f7 = this.h.getPageWidth(i8) + f + f7;
                i8++;
            }
            if (bmVar6.b == count - 1) {
                this.t = (bmVar6.d + f7) - 1.0f;
            }
            bmVar6.e = f7;
            f6 = f7 + bmVar6.d + f;
            i8++;
        }
        this.T = false;
    }

    /* loaded from: classes.dex */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = android.support.v4.a.a.a(new bt());

        /* renamed from: a  reason: collision with root package name */
        int f84a;
        Parcelable b;
        ClassLoader c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f84a);
            parcel.writeParcelable(this.b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f84a + "}";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f84a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f84a = this.i;
        if (this.h != null) {
            savedState.b = this.h.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.h != null) {
            this.h.restoreState(savedState.b, savedState.c);
            a(savedState.f84a, false, true);
            return;
        }
        this.j = savedState.f84a;
        this.k = savedState.b;
        this.l = savedState.c;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        bn bnVar = (bn) generateLayoutParams;
        bnVar.f93a |= view instanceof bl;
        if (this.w) {
            if (bnVar != null && bnVar.f93a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            bnVar.d = true;
            addViewInLayout(view, i, generateLayoutParams);
            return;
        }
        super.addView(view, i, generateLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    bm a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                bm bmVar = (bm) this.e.get(i2);
                if (!this.h.isViewFromObject(view, bmVar.f92a)) {
                    i = i2 + 1;
                } else {
                    return bmVar;
                }
            } else {
                return null;
            }
        }
    }

    bm b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return a(view);
            }
        }
        return null;
    }

    bm b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.e.size()) {
                bm bmVar = (bm) this.e.get(i3);
                if (bmVar.b != i) {
                    i2 = i3 + 1;
                } else {
                    return bmVar;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        bn bnVar;
        bn bnVar2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.D = Math.min(measuredWidth / 10, this.C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (bnVar2 = (bn) childAt.getLayoutParams()) != null && bnVar2.f93a) {
                int i7 = bnVar2.b & 7;
                int i8 = bnVar2.b & 112;
                int i9 = Integer.MIN_VALUE;
                int i10 = Integer.MIN_VALUE;
                boolean z = i8 == 48 || i8 == 80;
                boolean z2 = i7 == 3 || i7 == 5;
                if (z) {
                    i9 = 1073741824;
                } else if (z2) {
                    i10 = 1073741824;
                }
                if (bnVar2.width != -2) {
                    i3 = 1073741824;
                    i4 = bnVar2.width != -1 ? bnVar2.width : paddingLeft;
                } else {
                    i3 = i9;
                    i4 = paddingLeft;
                }
                if (bnVar2.height != -2) {
                    i10 = 1073741824;
                    if (bnVar2.height != -1) {
                        i5 = bnVar2.height;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5, i10));
                        if (!z) {
                            measuredHeight -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            paddingLeft -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i5 = measuredHeight;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5, i10));
                if (!z) {
                }
            }
        }
        this.u = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.w = true;
        c();
        this.w = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((bnVar = (bn) childAt2.getLayoutParams()) == null || !bnVar.f93a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (bnVar.c * paddingLeft), 1073741824), this.v);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.o, this.o);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.e.isEmpty()) {
            int paddingLeft = (int) ((((i - getPaddingLeft()) - getPaddingRight()) + i3) * (getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)));
            scrollTo(paddingLeft, getScrollY());
            if (!this.m.isFinished()) {
                this.m.startScroll(paddingLeft, 0, (int) (b(this.i).e * i), 0, this.m.getDuration() - this.m.timePassed());
                return;
            }
            return;
        }
        bm b = b(this.i);
        int min = (int) ((b != null ? Math.min(b.e, this.t) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bm a2;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                bn bnVar = (bn) childAt.getLayoutParams();
                if (bnVar.f93a) {
                    int i14 = bnVar.b & 7;
                    int i15 = bnVar.b & 112;
                    switch (i14) {
                        case 1:
                            i7 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            i7 = paddingLeft;
                            break;
                        case 3:
                            i7 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i7 = measuredWidth;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case MapView.LayoutParams.TOP /* 48 */:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = i7 + scrollX;
                    childAt.layout(i19, measuredHeight, childAt.getMeasuredWidth() + i19, childAt.getMeasuredHeight() + measuredHeight);
                    i5 = i12 + 1;
                    i6 = i8;
                    paddingBottom = i9;
                    i13++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingRight;
                    paddingTop = i6;
                    i12 = i5;
                }
            }
            i5 = i12;
            i6 = paddingTop;
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i12 = i5;
        }
        int i20 = (i10 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                bn bnVar2 = (bn) childAt2.getLayoutParams();
                if (!bnVar2.f93a && (a2 = a(childAt2)) != null) {
                    int i22 = ((int) (a2.e * i20)) + paddingLeft;
                    if (bnVar2.d) {
                        bnVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (bnVar2.c * i20), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.q = paddingTop;
        this.r = i11 - paddingBottom;
        this.V = i12;
        if (this.S) {
            a(this.i, false, 0, false);
        }
        this.S = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d(currX)) {
                    this.m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            aq.b(this);
            return;
        }
        a(true);
    }

    private boolean d(int i) {
        if (this.e.size() == 0) {
            this.U = false;
            a(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        bm i2 = i();
        int clientWidth = getClientWidth();
        int i3 = this.o + clientWidth;
        float f = this.o / clientWidth;
        int i4 = i2.b;
        float f2 = ((i / clientWidth) - i2.e) / (i2.d + f);
        this.U = false;
        a(i4, f2, (int) (i3 * f2));
        if (!this.U) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    protected void a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.V > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                bn bnVar = (bn) childAt.getLayoutParams();
                if (bnVar.f93a) {
                    switch (bnVar.b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i6 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i6;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i9 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        if (this.W != null) {
            this.W.a(i, f, i2);
        }
        if (this.X != null) {
            this.X.a(i, f, i2);
        }
        if (this.Z != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((bn) childAt2.getLayoutParams()).f93a) {
                    this.Z.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.U = true;
    }

    private void a(boolean z) {
        boolean z2 = this.af == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.e.size(); i++) {
            bm bmVar = (bm) this.e.get(i);
            if (bmVar.c) {
                bmVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                aq.a(this, this.ae);
            } else {
                this.ae.run();
            }
        }
    }

    private boolean a(float f, float f2) {
        return (f < ((float) this.D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.D)) && f2 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            aq.a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.A = false;
            this.B = false;
            this.J = -1;
            if (this.K != null) {
                this.K.recycle();
                this.K = null;
                return false;
            }
            return false;
        }
        if (action != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                float y = motionEvent.getY();
                this.I = y;
                this.G = y;
                this.J = z.b(motionEvent, 0);
                this.B = false;
                this.m.computeScrollOffset();
                if (this.af == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O) {
                    this.m.abortAnimation();
                    this.y = false;
                    c();
                    this.A = true;
                    setScrollState(1);
                    break;
                } else {
                    a(false);
                    this.A = false;
                    break;
                }
                break;
            case 2:
                int i = this.J;
                if (i != -1) {
                    int a2 = z.a(motionEvent, i);
                    float c2 = z.c(motionEvent, a2);
                    float f = c2 - this.F;
                    float abs = Math.abs(f);
                    float d2 = z.d(motionEvent, a2);
                    float abs2 = Math.abs(d2 - this.I);
                    if (f != 0.0f && !a(this.F, f) && a(this, false, (int) f, (int) c2, (int) d2)) {
                        this.F = c2;
                        this.G = d2;
                        this.B = true;
                        return false;
                    }
                    if (abs > this.E && 0.5f * abs > abs2) {
                        this.A = true;
                        setScrollState(1);
                        this.F = f > 0.0f ? this.H + this.E : this.H - this.E;
                        this.G = d2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.E) {
                        this.B = true;
                    }
                    if (this.A && b(c2)) {
                        aq.b(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        return this.A;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.P) {
            return true;
        }
        if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            if (this.h == null || this.h.getCount() == 0) {
                return false;
            }
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.m.abortAnimation();
                    this.y = false;
                    c();
                    this.A = true;
                    setScrollState(1);
                    float x = motionEvent.getX();
                    this.H = x;
                    this.F = x;
                    float y = motionEvent.getY();
                    this.I = y;
                    this.G = y;
                    this.J = z.b(motionEvent, 0);
                    break;
                case 1:
                    if (this.A) {
                        VelocityTracker velocityTracker = this.K;
                        velocityTracker.computeCurrentVelocity(1000, this.M);
                        int a2 = (int) al.a(velocityTracker, this.J);
                        this.y = true;
                        int clientWidth = getClientWidth();
                        int scrollX = getScrollX();
                        bm i = i();
                        a(a(i.b, ((scrollX / clientWidth) - i.e) / i.d, a2, (int) (z.c(motionEvent, z.a(motionEvent, this.J)) - this.H)), true, true, a2);
                        this.J = -1;
                        j();
                        z = this.R.c() | this.Q.c();
                        break;
                    }
                    break;
                case 2:
                    if (!this.A) {
                        int a3 = z.a(motionEvent, this.J);
                        float c2 = z.c(motionEvent, a3);
                        float abs = Math.abs(c2 - this.F);
                        float d2 = z.d(motionEvent, a3);
                        float abs2 = Math.abs(d2 - this.G);
                        if (abs > this.E && abs > abs2) {
                            this.A = true;
                            this.F = c2 - this.H > 0.0f ? this.H + this.E : this.H - this.E;
                            this.G = d2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.A) {
                        z = false | b(z.c(motionEvent, z.a(motionEvent, this.J)));
                        break;
                    }
                    break;
                case 3:
                    if (this.A) {
                        a(this.i, true, 0, false);
                        this.J = -1;
                        j();
                        z = this.R.c() | this.Q.c();
                        break;
                    }
                    break;
                case 5:
                    int b = z.b(motionEvent);
                    this.F = z.c(motionEvent, b);
                    this.J = z.b(motionEvent, b);
                    break;
                case 6:
                    a(motionEvent);
                    this.F = z.c(motionEvent, z.a(motionEvent, this.J));
                    break;
            }
            if (z) {
                aq.b(this);
            }
            return true;
        }
        return false;
    }

    private boolean b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        this.F = f;
        float scrollX = getScrollX() + (this.F - f);
        int clientWidth = getClientWidth();
        float f3 = clientWidth * this.s;
        float f4 = clientWidth * this.t;
        bm bmVar = (bm) this.e.get(0);
        bm bmVar2 = (bm) this.e.get(this.e.size() - 1);
        if (bmVar.b != 0) {
            f3 = bmVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bmVar2.b != this.h.getCount() - 1) {
            f2 = bmVar2.e * clientWidth;
            z2 = false;
        } else {
            f2 = f4;
        }
        if (scrollX < f3) {
            if (z) {
                r2 = this.Q.a(Math.abs(f3 - scrollX) / clientWidth);
            }
        } else if (scrollX > f2) {
            r2 = z2 ? this.R.a(Math.abs(scrollX - f2) / clientWidth) : false;
            f3 = f2;
        } else {
            f3 = scrollX;
        }
        this.F += f3 - ((int) f3);
        scrollTo((int) f3, getScrollY());
        d((int) f3);
        return r2;
    }

    private bm i() {
        int i;
        bm bmVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.o / clientWidth : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        bm bmVar2 = null;
        while (i3 < this.e.size()) {
            bm bmVar3 = (bm) this.e.get(i3);
            if (z || bmVar3.b == i2 + 1) {
                i = i3;
                bmVar = bmVar3;
            } else {
                bm bmVar4 = this.f;
                bmVar4.e = f2 + f3 + f;
                bmVar4.b = i2 + 1;
                bmVar4.d = this.h.getPageWidth(bmVar4.b);
                i = i3 - 1;
                bmVar = bmVar4;
            }
            float f4 = bmVar.e;
            float f5 = bmVar.d + f4 + f;
            if (z || scrollX >= f4) {
                if (scrollX < f5 || i == this.e.size() - 1) {
                    return bmVar;
                }
                f3 = f4;
                i2 = bmVar.b;
                z = false;
                f2 = bmVar.d;
                bmVar2 = bmVar;
                i3 = i + 1;
            } else {
                return bmVar2;
            }
        }
        return bmVar2;
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.N && Math.abs(i2) > this.L) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i = (int) ((i >= this.i ? 0.4f : 0.6f) + i + f);
        }
        if (this.e.size() > 0) {
            return Math.max(((bm) this.e.get(0)).b, Math.min(i, ((bm) this.e.get(this.e.size() - 1)).b));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int a2 = aq.a(this);
        if (a2 == 0 || (a2 == 1 && this.h != null && this.h.getCount() > 1)) {
            if (!this.Q.a()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.s * width);
                this.Q.a(height, width);
                z = false | this.Q.a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.R.a()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.t + 1.0f)) * width2);
                this.R.a(height2, width2);
                z |= this.R.a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.Q.b();
            this.R.b();
        }
        if (z) {
            aq.b(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.o > 0 && this.p != null && this.e.size() > 0 && this.h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = this.o / width;
            bm bmVar = (bm) this.e.get(0);
            float f3 = bmVar.e;
            int size = this.e.size();
            int i = bmVar.b;
            int i2 = ((bm) this.e.get(size - 1)).b;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > bmVar.b && i3 < size) {
                    i3++;
                    bmVar = (bm) this.e.get(i3);
                }
                if (i4 == bmVar.b) {
                    f = (bmVar.e + bmVar.d) * width;
                    f3 = bmVar.e + bmVar.d + f2;
                } else {
                    float pageWidth = this.h.getPageWidth(i4);
                    f = (f3 + pageWidth) * width;
                    f3 += pageWidth + f2;
                }
                if (this.o + f > scrollX) {
                    this.p.setBounds((int) f, this.q, (int) (this.o + f + 0.5f), this.r);
                    this.p.draw(canvas);
                }
                if (f > scrollX + width) {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = z.b(motionEvent);
        if (z.b(motionEvent, b) == this.J) {
            int i = b == 0 ? 1 : 0;
            this.F = z.c(motionEvent, i);
            this.J = z.b(motionEvent, i);
            if (this.K != null) {
                this.K.clear();
            }
        }
    }

    private void j() {
        this.A = false;
        this.B = false;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.x != z) {
            this.x = z;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && aq.a(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return c(17);
            case DERTags.IA5_STRING /* 22 */:
                return c(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (s.a(keyEvent)) {
                    return c(2);
                }
                if (!s.a(keyEvent, 1)) {
                    return false;
                }
                return c(1);
            default:
                return false;
        }
    }

    public boolean c(int i) {
        View view;
        boolean z;
        boolean d2;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = a(this.g, findNextFocus).left;
                int i3 = a(this.g, view).left;
                if (view != null && i2 >= i3) {
                    d2 = d();
                } else {
                    d2 = findNextFocus.requestFocus();
                }
            } else {
                if (i == 66) {
                    int i4 = a(this.g, findNextFocus).left;
                    int i5 = a(this.g, view).left;
                    if (view != null && i4 <= i5) {
                        d2 = e();
                    } else {
                        d2 = findNextFocus.requestFocus();
                    }
                }
                d2 = false;
            }
        } else if (i == 17 || i == 1) {
            d2 = d();
        } else {
            if (i == 66 || i == 2) {
                d2 = e();
            }
            d2 = false;
        }
        if (d2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d2;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean d() {
        if (this.i > 0) {
            a(this.i - 1, true);
            return true;
        }
        return false;
    }

    boolean e() {
        if (this.h == null || this.i >= this.h.getCount() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        bm a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        bm a2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        bm a2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        bm a2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new bn();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof bn) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new bn(getContext(), attributeSet);
    }
}
