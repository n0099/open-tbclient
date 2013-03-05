package android.support.v4.view;

import android.content.Context;
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
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.MapView;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int[] a = {16842931};
    private static final Comparator b = new ad();
    private static final Interpolator c = new ae();
    private float A;
    private float B;
    private int C;
    private VelocityTracker D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private android.support.v4.widget.d I;
    private android.support.v4.widget.d J;
    private boolean K;
    private boolean L;
    private int M;
    private aj N;
    private aj O;
    private ai P;
    private int Q;
    private final ArrayList d;
    private k e;
    private int f;
    private int g;
    private Parcelable h;
    private ClassLoader i;
    private Scroller j;
    private ak k;
    private int l;
    private Drawable m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private int y;
    private float z;

    /* loaded from: classes.dex */
    public class SimpleOnPageChangeListener implements aj {
        @Override // android.support.v4.view.aj
        public void a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.aj
        public void a(int i) {
        }

        @Override // android.support.v4.view.aj
        public void b(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.d = new ArrayList();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.v = 1;
        this.C = -1;
        this.K = true;
        this.Q = 0;
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.v = 1;
        this.C = -1;
        this.K = true;
        this.Q = 0;
        a();
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.j = new Scroller(context, c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.y = y.a(viewConfiguration);
        this.E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.F = viewConfiguration.getScaledMaximumFlingVelocity();
        this.I = new android.support.v4.widget.d(context);
        this.J = new android.support.v4.widget.d(context);
        this.G = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    private void setScrollState(int i) {
        if (this.Q != i) {
            this.Q = i;
            if (this.N != null) {
                this.N.b(i);
            }
        }
    }

    public void setAdapter(k kVar) {
        if (this.e != null) {
            this.e.unregisterDataSetObserver(this.k);
            this.e.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.d.size(); i++) {
                ag agVar = (ag) this.d.get(i);
                this.e.destroyItem((ViewGroup) this, agVar.b, agVar.a);
            }
            this.e.finishUpdate((ViewGroup) this);
            this.d.clear();
            g();
            this.f = 0;
            scrollTo(0, 0);
        }
        k kVar2 = this.e;
        this.e = kVar;
        if (this.e != null) {
            if (this.k == null) {
                this.k = new ak(this, null);
            }
            this.e.registerDataSetObserver(this.k);
            this.t = false;
            if (this.g >= 0) {
                this.e.restoreState(this.h, this.i);
                a(this.g, false, true);
                this.g = -1;
                this.h = null;
                this.i = null;
            } else {
                c();
            }
        }
        if (this.P != null && kVar2 != kVar) {
            this.P.a(kVar2, kVar);
        }
    }

    private void g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((ah) getChildAt(i2).getLayoutParams()).a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public k getAdapter() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(ai aiVar) {
        this.P = aiVar;
    }

    public void setCurrentItem(int i) {
        this.t = false;
        a(i, !this.K, false);
    }

    public void a(int i, boolean z) {
        this.t = false;
        a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f;
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.e == null || this.e.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!z2 && this.f == i && this.d.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (i < 0) {
                i = 0;
            } else if (i >= this.e.getCount()) {
                i = this.e.getCount() - 1;
            }
            int i3 = this.v;
            if (i > this.f + i3 || i < this.f - i3) {
                for (int i4 = 0; i4 < this.d.size(); i4++) {
                    ((ag) this.d.get(i4)).c = true;
                }
            }
            boolean z3 = this.f != i;
            this.f = i;
            c();
            int width = (getWidth() + this.l) * i;
            if (z) {
                a(width, 0, i2);
                if (z3 && this.N != null) {
                    this.N.a(i);
                }
                if (z3 && this.O != null) {
                    this.O.a(i);
                    return;
                }
                return;
            }
            if (z3 && this.N != null) {
                this.N.a(i);
            }
            if (z3 && this.O != null) {
                this.O.a(i);
            }
            h();
            scrollTo(width, 0);
        }
    }

    public void setOnPageChangeListener(aj ajVar) {
        this.N = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj a(aj ajVar) {
        aj ajVar2 = this.O;
        this.O = ajVar;
        return ajVar2;
    }

    public int getOffscreenPageLimit() {
        return this.v;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.v) {
            this.v = i;
            c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.l;
        this.l = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.l;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.m = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.m;
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
            h();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        this.u = true;
        setScrollState(2);
        int width = getWidth();
        int i6 = width / 2;
        float a2 = (i6 * a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / width))) + i6;
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a2 / abs2)) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / (width + this.l)) + 1.0f) * 100.0f);
        }
        this.j.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        invalidate();
    }

    void a(int i, int i2) {
        ag agVar = new ag();
        agVar.b = i;
        agVar.a = this.e.instantiateItem((ViewGroup) this, i);
        if (i2 < 0) {
            this.d.add(agVar);
        } else {
            this.d.add(i2, agVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        boolean z3 = true;
        int i3 = 0;
        boolean z4 = false;
        int i4 = -1;
        boolean z5 = this.d.size() < 3 && this.d.size() < this.e.getCount();
        while (i3 < this.d.size()) {
            ag agVar = (ag) this.d.get(i3);
            int itemPosition = this.e.getItemPosition(agVar.a);
            if (itemPosition == -1) {
                i = i3;
                z = z4;
                i2 = i4;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.d.remove(i3);
                int i5 = i3 - 1;
                if (!z4) {
                    this.e.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.e.destroyItem((ViewGroup) this, agVar.b, agVar.a);
                if (this.f == agVar.b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.f, this.e.getCount() - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i4;
                    z2 = true;
                }
            } else if (agVar.b != itemPosition) {
                if (agVar.b == this.f) {
                    i4 = itemPosition;
                }
                agVar.b = itemPosition;
                i = i3;
                z = z4;
                i2 = i4;
                z2 = true;
            } else {
                i = i3;
                z = z4;
                i2 = i4;
                z2 = z5;
            }
            z5 = z2;
            i4 = i2;
            z4 = z;
            i3 = i + 1;
        }
        if (z4) {
            this.e.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.d, b);
        if (i4 >= 0) {
            a(i4, false, true);
        } else {
            z3 = z5;
        }
        if (z3) {
            c();
            requestLayout();
        }
    }

    void c() {
        ag agVar;
        if (this.e != null && !this.t && getWindowToken() != null) {
            this.e.startUpdate((ViewGroup) this);
            int i = this.v;
            int max = Math.max(0, this.f - i);
            int min = Math.min(this.e.getCount() - 1, i + this.f);
            int i2 = 0;
            int i3 = -1;
            while (i2 < this.d.size()) {
                ag agVar2 = (ag) this.d.get(i2);
                if ((agVar2.b < max || agVar2.b > min) && !agVar2.c) {
                    this.d.remove(i2);
                    i2--;
                    this.e.destroyItem((ViewGroup) this, agVar2.b, agVar2.a);
                } else if (i3 < min && agVar2.b > max) {
                    int i4 = i3 + 1;
                    if (i4 < max) {
                        i4 = max;
                    }
                    while (i4 <= min && i4 < agVar2.b) {
                        a(i4, i2);
                        i4++;
                        i2++;
                    }
                }
                int i5 = i2;
                int i6 = agVar2.b;
                int i7 = i5 + 1;
                i3 = i6;
                i2 = i7;
            }
            int i8 = this.d.size() > 0 ? ((ag) this.d.get(this.d.size() - 1)).b : -1;
            if (i8 < min) {
                int i9 = i8 + 1;
                if (i9 <= max) {
                    i9 = max;
                }
                while (i9 <= min) {
                    a(i9, -1);
                    i9++;
                }
            }
            int i10 = 0;
            while (true) {
                if (i10 < this.d.size()) {
                    if (((ag) this.d.get(i10)).b != this.f) {
                        i10++;
                    } else {
                        agVar = (ag) this.d.get(i10);
                        break;
                    }
                } else {
                    agVar = null;
                    break;
                }
            }
            this.e.setPrimaryItem((ViewGroup) this, this.f, agVar != null ? agVar.a : null);
            this.e.finishUpdate((ViewGroup) this);
            if (hasFocus()) {
                View findFocus = findFocus();
                ag b2 = findFocus != null ? b(findFocus) : null;
                if (b2 == null || b2.b != this.f) {
                    for (int i11 = 0; i11 < getChildCount(); i11++) {
                        View childAt = getChildAt(i11);
                        ag a2 = a(childAt);
                        if (a2 != null && a2.b == this.f && childAt.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = android.support.v4.a.a.a(new al());
        int a;
        Parcelable b;
        ClassLoader c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f;
        if (this.e != null) {
            savedState.b = this.e.saveState();
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
        if (this.e != null) {
            this.e.restoreState(savedState.b, savedState.c);
            a(savedState.a, false, true);
            return;
        }
        this.g = savedState.a;
        this.h = savedState.b;
        this.i = savedState.c;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        ah ahVar = (ah) generateLayoutParams;
        ahVar.a |= view instanceof af;
        if (this.r) {
            if (ahVar != null && ahVar.a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(view, i, generateLayoutParams);
            view.measure(this.p, this.q);
            return;
        }
        super.addView(view, i, generateLayoutParams);
    }

    ag a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.size()) {
                ag agVar = (ag) this.d.get(i2);
                if (!this.e.isViewFromObject(view, agVar.a)) {
                    i = i2 + 1;
                } else {
                    return agVar;
                }
            } else {
                return null;
            }
        }
    }

    ag b(View view) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar;
        int i3;
        int i4;
        ah ahVar2;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (ahVar2 = (ah) childAt.getLayoutParams()) != null && ahVar2.a) {
                int i6 = ahVar2.b & 7;
                int i7 = ahVar2.b & 112;
                Log.d("ViewPager", "gravity: " + ahVar2.b + " hgrav: " + i6 + " vgrav: " + i7);
                int i8 = Integer.MIN_VALUE;
                int i9 = Integer.MIN_VALUE;
                boolean z = i7 == 48 || i7 == 80;
                boolean z2 = i6 == 3 || i6 == 5;
                if (z) {
                    i8 = 1073741824;
                } else if (z2) {
                    i9 = 1073741824;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, i8), View.MeasureSpec.makeMeasureSpec(measuredHeight, i9));
                if (z) {
                    i3 = measuredHeight - childAt.getMeasuredHeight();
                    i4 = measuredWidth;
                } else if (z2) {
                    i4 = measuredWidth - childAt.getMeasuredWidth();
                    i3 = measuredHeight;
                }
                i5++;
                measuredWidth = i4;
                measuredHeight = i3;
            }
            i3 = measuredHeight;
            i4 = measuredWidth;
            i5++;
            measuredWidth = i4;
            measuredHeight = i3;
        }
        this.p = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.q = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.r = true;
        c();
        this.r = false;
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8 && ((ahVar = (ah) childAt2.getLayoutParams()) == null || !ahVar.a)) {
                childAt2.measure(this.p, this.q);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.l, this.l);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollX = getScrollX();
            int i6 = i2 + i4;
            int i7 = (int) ((((scrollX % i6) / i6) + (scrollX / i6)) * i5);
            scrollTo(i7, getScrollY());
            if (!this.j.isFinished()) {
                this.j.startScroll(i7, 0, i5 * this.f, 0, this.j.getDuration() - this.j.timePassed());
                return;
            }
            return;
        }
        int i8 = this.f * i5;
        if (i8 != getScrollX()) {
            h();
            scrollTo(i8, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        this.r = true;
        c();
        this.r = false;
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
                ah ahVar = (ah) childAt.getLayoutParams();
                if (ahVar.a) {
                    int i14 = ahVar.b & 7;
                    int i15 = ahVar.b & 112;
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
                } else {
                    ag a2 = a(childAt);
                    if (a2 != null) {
                        int i20 = (a2.b * (this.l + i10)) + paddingLeft;
                        childAt.layout(i20, paddingTop, childAt.getMeasuredWidth() + i20, childAt.getMeasuredHeight() + paddingTop);
                    }
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
        this.n = paddingTop;
        this.o = i11 - paddingBottom;
        this.M = i12;
        this.K = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.j.isFinished() && this.j.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.j.getCurrX();
            int currY = this.j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                b(currX);
            }
            invalidate();
            return;
        }
        h();
    }

    private void b(int i) {
        int width = getWidth() + this.l;
        int i2 = i % width;
        this.L = false;
        a(i / width, i2 / width, i2);
        if (!this.L) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.M > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                ah ahVar = (ah) childAt.getLayoutParams();
                if (ahVar.a) {
                    switch (ahVar.b & 7) {
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
        if (this.N != null) {
            this.N.a(i, f, i2);
        }
        if (this.O != null) {
            this.O.a(i, f, i2);
        }
        this.L = true;
    }

    private void h() {
        boolean z = this.u;
        if (z) {
            setScrollingCacheEnabled(false);
            this.j.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.j.getCurrX();
            int currY = this.j.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.t = false;
        this.u = false;
        boolean z2 = z;
        for (int i = 0; i < this.d.size(); i++) {
            ag agVar = (ag) this.d.get(i);
            if (agVar.c) {
                z2 = true;
                agVar.c = false;
            }
        }
        if (z2) {
            c();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.w = false;
            this.x = false;
            this.C = -1;
            if (this.D != null) {
                this.D.recycle();
                this.D = null;
                return false;
            }
            return false;
        }
        if (action != 0) {
            if (this.w) {
                return true;
            }
            if (this.x) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.z = x;
                this.A = x;
                this.B = motionEvent.getY();
                this.C = f.b(motionEvent, 0);
                if (this.Q == 2) {
                    this.w = true;
                    this.x = false;
                    setScrollState(1);
                    break;
                } else {
                    h();
                    this.w = false;
                    this.x = false;
                    break;
                }
            case 2:
                int i = this.C;
                if (i != -1) {
                    int a2 = f.a(motionEvent, i);
                    float c2 = f.c(motionEvent, a2);
                    float f = c2 - this.A;
                    float abs = Math.abs(f);
                    float d = f.d(motionEvent, a2);
                    float abs2 = Math.abs(d - this.B);
                    if (a(this, false, (int) f, (int) c2, (int) d)) {
                        this.A = c2;
                        this.z = c2;
                        this.B = d;
                        return false;
                    } else if (abs > this.y && abs > abs2) {
                        this.w = true;
                        setScrollState(1);
                        this.A = c2;
                        setScrollingCacheEnabled(true);
                        break;
                    } else if (abs2 > this.y) {
                        this.x = true;
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (!this.w) {
            if (this.D == null) {
                this.D = VelocityTracker.obtain();
            }
            this.D.addMovement(motionEvent);
        }
        return this.w;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int scrollX;
        boolean z;
        float f;
        if (this.H) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.e == null || this.e.getCount() == 0) {
            return false;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                h();
                float x = motionEvent.getX();
                this.z = x;
                this.A = x;
                this.C = f.b(motionEvent, 0);
                break;
            case 1:
                if (this.w) {
                    VelocityTracker velocityTracker = this.D;
                    velocityTracker.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, this.F);
                    int a2 = (int) m.a(velocityTracker, this.C);
                    this.t = true;
                    int width = getWidth() + this.l;
                    a(a(getScrollX() / width, (scrollX % width) / width, a2, (int) (f.c(motionEvent, f.a(motionEvent, this.C)) - this.z)), true, true, a2);
                    this.C = -1;
                    i();
                    r0 = this.I.c() | this.J.c();
                    break;
                }
                break;
            case 2:
                if (!this.w) {
                    int a3 = f.a(motionEvent, this.C);
                    float c2 = f.c(motionEvent, a3);
                    float abs = Math.abs(c2 - this.A);
                    float abs2 = Math.abs(f.d(motionEvent, a3) - this.B);
                    if (abs > this.y && abs > abs2) {
                        this.w = true;
                        this.A = c2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.w) {
                    float c3 = f.c(motionEvent, f.a(motionEvent, this.C));
                    float f2 = this.A - c3;
                    this.A = c3;
                    float scrollX2 = getScrollX() + f2;
                    int width2 = getWidth();
                    int i = width2 + this.l;
                    int count = this.e.getCount() - 1;
                    float max = Math.max(0, (this.f - 1) * i);
                    float min = Math.min(this.f + 1, count) * i;
                    if (scrollX2 < max) {
                        z = max == 0.0f ? this.I.a((-scrollX2) / width2) : false;
                        f = max;
                    } else if (scrollX2 > min) {
                        z = min == ((float) (count * i)) ? this.J.a((scrollX2 - min) / width2) : false;
                        f = min;
                    } else {
                        z = false;
                        f = scrollX2;
                    }
                    this.A += f - ((int) f);
                    scrollTo((int) f, getScrollY());
                    b((int) f);
                    r0 = z;
                    break;
                }
                break;
            case 3:
                if (this.w) {
                    a(this.f, true, true);
                    this.C = -1;
                    i();
                    r0 = this.I.c() | this.J.c();
                    break;
                }
                break;
            case 5:
                int a4 = f.a(motionEvent);
                this.A = f.c(motionEvent, a4);
                this.C = f.b(motionEvent, a4);
                break;
            case 6:
                a(motionEvent);
                this.A = f.c(motionEvent, f.a(motionEvent, this.C));
                break;
        }
        if (r0) {
            invalidate();
        }
        return true;
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.G && Math.abs(i2) > this.E) {
            if (i2 <= 0) {
                return i + 1;
            }
            return i;
        }
        return (int) (i + f + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int a2 = r.a(this);
        if (a2 == 0 || (a2 == 1 && this.e != null && this.e.getCount() > 1)) {
            if (!this.I.a()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), 0.0f);
                this.I.a(height, getWidth());
                z = false | this.I.a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.J.a()) {
                int save2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int count = this.e != null ? this.e.getCount() : 1;
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), ((-count) * (this.l + width)) + this.l);
                this.J.a(height2, width);
                z |= this.J.a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.I.b();
            this.J.b();
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l > 0 && this.m != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i = scrollX % (this.l + width);
            if (i != 0) {
                int i2 = (scrollX - i) + width;
                this.m.setBounds(i2, this.n, this.l + i2, this.o);
                this.m.draw(canvas);
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int a2 = f.a(motionEvent);
        if (f.b(motionEvent, a2) == this.C) {
            int i = a2 == 0 ? 1 : 0;
            this.A = f.c(motionEvent, i);
            this.C = f.b(motionEvent, i);
            if (this.D != null) {
                this.D.clear();
            }
        }
    }

    private void i() {
        this.w = false;
        this.x = false;
        if (this.D != null) {
            this.D.recycle();
            this.D = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.s != z) {
            this.s = z;
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
        return z && r.a(view, -i);
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
                return a(17);
            case DERTags.IA5_STRING /* 22 */:
                return a(66);
            case BDLocation.TypeGpsLocation /* 61 */:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (a.a(keyEvent)) {
                    return a(2);
                }
                if (!a.a(keyEvent, 1)) {
                    return false;
                }
                return a(1);
            default:
                return false;
        }
    }

    public boolean a(int i) {
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null && findNextFocus != findFocus) {
            if (i == 17) {
                if (findFocus != null && findNextFocus.getLeft() >= findFocus.getLeft()) {
                    d = d();
                } else {
                    d = findNextFocus.requestFocus();
                }
            } else {
                if (i == 66) {
                    if (findFocus != null && findNextFocus.getLeft() <= findFocus.getLeft()) {
                        d = e();
                    } else {
                        d = findNextFocus.requestFocus();
                    }
                }
                d = false;
            }
        } else if (i == 17 || i == 1) {
            d = d();
        } else {
            if (i == 66 || i == 2) {
                d = e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    boolean d() {
        if (this.f > 0) {
            a(this.f - 1, true);
            return true;
        }
        return false;
    }

    boolean e() {
        if (this.e == null || this.f >= this.e.getCount() - 1) {
            return false;
        }
        a(this.f + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        ag a2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.f) {
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
        ag a2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        ag a2;
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
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.f && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ag a2;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.b == this.f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ah();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ah) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ah(getContext(), attributeSet);
    }
}
