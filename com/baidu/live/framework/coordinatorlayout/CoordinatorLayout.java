package com.baidu.live.framework.coordinatorlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.dc0;
import com.baidu.tieba.eb0;
import com.baidu.tieba.ec0;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final String u;
    public static final Class<?>[] v;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> w;
    public static final Comparator<View> x;
    public static final Pools.Pool<Rect> y;
    public final List<View> a;
    public final dc0<View> b;
    public final List<View> c;
    public final List<View> d;
    public Paint e;
    public final int[] f;
    public final int[] g;
    public boolean h;
    public boolean i;
    public int[] j;
    public View k;
    public View l;
    public f m;
    public boolean n;
    public WindowInsetsCompat o;
    public boolean p;
    public Drawable q;
    public ViewGroup.OnHierarchyChangeListener r;
    public OnApplyWindowInsetsListener s;
    public final NestedScrollingParentHelper t;

    /* loaded from: classes3.dex */
    public interface b {
        @NonNull
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes3.dex */
    public @interface c {
        Class<? extends Behavior> value();
    }

    public static int L(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    public static int M(int i) {
        if ((i & 7) == 0) {
            i |= GravityCompat.START;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    public static int N(int i) {
        return i == 0 ? BadgeDrawable.TOP_END : i;
    }

    public static int c(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* loaded from: classes3.dex */
    public static abstract class Behavior<V extends View> {
        @Deprecated
        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
        }

        public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return -16777216;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return 0.0f;
        }

        public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void g(@NonNull e eVar) {
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
            return false;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2) {
        }

        public void j() {
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
            return false;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, float f, float f2, boolean z) {
            return false;
        }

        public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, float f, float f2) {
            return false;
        }

        @Deprecated
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, @NonNull int[] iArr) {
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i) {
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect, boolean z) {
            return false;
        }

        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        }

        @Deprecated
        public boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i) {
            return false;
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            if (d(coordinatorLayout, v) > 0.0f) {
                return true;
            }
            return false;
        }

        @Nullable
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (i2 == 0) {
                return z(coordinatorLayout, v, view2, view3, i);
            }
            return false;
        }

        public void v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (i2 == 0) {
                u(coordinatorLayout, v, view2, view3, i);
            }
        }

        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i) {
            if (i == 0) {
                B(coordinatorLayout, v, view2);
            }
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, @NonNull int[] iArr, int i3) {
            if (i3 == 0) {
                p(coordinatorLayout, v, view2, i, i2, iArr);
            }
        }

        @Deprecated
        public void s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                r(coordinatorLayout, v, view2, i, i2, i3, i4);
            }
        }

        public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            s(coordinatorLayout, v, view2, i, i2, i3, i4, i5);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            CoordinatorLayout.this.Q(windowInsetsCompat);
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view2, view3);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            CoordinatorLayout.this.B(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view2, view3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public Behavior a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public e(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public View d(CoordinatorLayout coordinatorLayout, View view2) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !s(view2, coordinatorLayout)) {
                m(view2, coordinatorLayout);
            }
            return this.k;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view2) {
            boolean z;
            boolean z2 = this.m;
            if (z2) {
                return true;
            }
            Behavior behavior = this.a;
            if (behavior != null) {
                z = behavior.a(coordinatorLayout, view2);
            } else {
                z = false;
            }
            boolean z3 = z | z2;
            this.m = z3;
            return z3;
        }

        public void q(int i, boolean z) {
            if (i != 0) {
                if (i == 1) {
                    this.o = z;
                    return;
                }
                return;
            }
            this.n = z;
        }

        public final boolean r(View view2, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((e) view2.getLayoutParams()).g, i);
            if (absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.h, i) & absoluteGravity) == absoluteGravity) {
                return true;
            }
            return false;
        }

        public final boolean s(View view2, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view3 = this.k;
            for (ViewParent parent = view3.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view2) {
                    if (parent instanceof View) {
                        view3 = (View) parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view3;
            return true;
        }

        public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, eb0.LiveCoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(0, 0);
            this.f = obtainStyledAttributes.getResourceId(1, -1);
            this.d = obtainStyledAttributes.getInteger(2, 0);
            this.e = obtainStyledAttributes.getInteger(6, -1);
            this.g = obtainStyledAttributes.getInt(5, 0);
            this.h = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.E(context, attributeSet, AppBarLayout.ScrollingViewBehavior.class.getName());
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public boolean i(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.o;
            }
            return this.n;
        }

        public void k(int i) {
            q(i, false);
        }

        public void n(@Nullable Behavior behavior) {
            Behavior behavior2 = this.a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.a = behavior;
                this.b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        public void o(boolean z) {
            this.p = z;
        }

        public void p(Rect rect) {
            this.q.set(rect);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public boolean a() {
            if (this.k == null && this.f != -1) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        @Nullable
        public Behavior e() {
            return this.a;
        }

        public boolean f() {
            return this.p;
        }

        public Rect g() {
            return this.q;
        }

        public void j() {
            this.p = false;
        }

        public void l() {
            this.m = false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            Behavior behavior;
            if (view3 != this.l && !r(view3, ViewCompat.getLayoutDirection(coordinatorLayout)) && ((behavior = this.a) == null || !behavior.e(coordinatorLayout, view2, view3))) {
                return false;
            }
            return true;
        }

        public final void m(View view2, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f);
            this.k = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    return;
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view2) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        return;
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.l = findViewById;
            } else if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.k = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.B(0);
            return true;
        }
    }

    static {
        String str;
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        u = str;
        if (Build.VERSION.SDK_INT >= 21) {
            x = new g();
        } else {
            x = null;
        }
        v = new Class[]{Context.class, AttributeSet.class};
        w = new ThreadLocal<>();
        y = new Pools.SynchronizedPool(12);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable y2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior e2 = ((e) childAt.getLayoutParams()).e();
            if (id != -1 && e2 != null && (y2 = e2.y(this, childAt)) != null) {
                sparseArray.append(id, y2);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public SparseArray<Parcelable> behaviorStates;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.behaviorStates.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i2 = sparseArray.size();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            int[] iArr = new int[i2];
            Parcelable[] parcelableArr = new Parcelable[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = this.behaviorStates.keyAt(i3);
                parcelableArr[i3] = this.behaviorStates.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Comparator<View> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view2, View view3) {
            float z = ViewCompat.getZ(view2);
            float z2 = ViewCompat.getZ(view3);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return 1;
            }
            return 0;
        }
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public static void I(@NonNull Rect rect) {
        rect.setEmpty();
        y.release(rect);
    }

    public final WindowInsetsCompat Q(WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        if (!ObjectsCompat.equals(this.o, windowInsetsCompat)) {
            this.o = windowInsetsCompat;
            boolean z2 = true;
            if (windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.p = z;
            setWillNotDraw((z || getBackground() != null) ? false : false);
            e(windowInsetsCompat);
            requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof e) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public final WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        Behavior e2;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt) && (e2 = ((e) childAt.getLayoutParams()).e()) != null) {
                e2.f(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    public void f(@NonNull View view2) {
        List g2 = this.b.g(view2);
        if (g2 != null && !g2.isEmpty()) {
            for (int i = 0; i < g2.size(); i++) {
                View view3 = (View) g2.get(i);
                Behavior e2 = ((e) view3.getLayoutParams()).e();
                if (e2 != null) {
                    e2.h(this, view3, view2);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: i */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    @NonNull
    public List<View> l(@NonNull View view2) {
        List<View> h = this.b.h(view2);
        this.d.clear();
        if (h != null) {
            this.d.addAll(h);
        }
        return this.d;
    }

    @NonNull
    public List<View> m(@NonNull View view2) {
        List g2 = this.b.g(view2);
        this.d.clear();
        if (g2 != null) {
            this.d.addAll(g2);
        }
        return this.d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.p && this.q != null) {
            WindowInsetsCompat windowInsetsCompat = this.o;
            if (windowInsetsCompat != null) {
                i = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.q.setBounds(0, 0, getWidth(), i);
                this.q.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            K(true);
        }
        boolean F = F(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            K(true);
        }
        return F;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        onStopNestedScroll(view2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.h) {
            K(false);
            this.h = true;
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        R();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.r = onHierarchyChangeListener;
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.q;
        if (drawable != null && drawable.isVisible() != z) {
            this.q.setVisible(z, false);
        }
    }

    public final void t(List<View> list) {
        int i;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            if (isChildrenDrawingOrderEnabled) {
                i = getChildDrawingOrder(childCount, i2);
            } else {
                i = i2;
            }
            list.add(getChildAt(i));
        }
        Comparator<View> comparator = x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean u(View view2) {
        return this.b.j(view2);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.q) {
            return false;
        }
        return true;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040473);
    }

    public void C(@NonNull View view2, int i) {
        e eVar = (e) view2.getLayoutParams();
        if (eVar.a()) {
            return;
        }
        View view3 = eVar.k;
        if (view3 != null) {
            x(view2, view3, i);
            return;
        }
        int i2 = eVar.e;
        if (i2 >= 0) {
            y(view2, i2, i);
        } else {
            w(view2, i);
        }
    }

    public void H(View view2, Rect rect) {
        ((e) view2.getLayoutParams()).p(rect);
    }

    public final void O(View view2, int i) {
        e eVar = (e) view2.getLayoutParams();
        int i2 = eVar.i;
        if (i2 != i) {
            ViewCompat.offsetLeftAndRight(view2, i - i2);
            eVar.i = i;
        }
    }

    public final void P(View view2, int i) {
        e eVar = (e) view2.getLayoutParams();
        int i2 = eVar.j;
        if (i2 != i) {
            ViewCompat.offsetTopAndBottom(view2, i - i2);
            eVar.j = i;
        }
    }

    public void n(View view2, Rect rect) {
        ec0.a(this, view2, rect);
    }

    public void r(View view2, Rect rect) {
        rect.set(((e) view2.getLayoutParams()).g());
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.a = new ArrayList();
        this.b = new dc0<>();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = new int[2];
        this.g = new int[2];
        this.t = new NestedScrollingParentHelper(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, eb0.LiveCoordinatorLayout, 0, R.style.obfuscated_res_0x7f10012f);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, eb0.LiveCoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, eb0.LiveCoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R.style.obfuscated_res_0x7f10012f);
            } else {
                saveAttributeDataForStyleable(context, eb0.LiveCoordinatorLayout, attributeSet, obtainStyledAttributes, i, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.j = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.j.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.j;
                iArr[i2] = (int) (iArr[i2] * f2);
            }
        }
        this.q = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        R();
        super.setOnHierarchyChangeListener(new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior E(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(u)) {
            str = u + IStringUtil.EXTENSION_SEPARATOR + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = w.get();
            if (map == null) {
                map = new HashMap<>();
                w.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        e eVar = (e) view2.getLayoutParams();
        Behavior behavior = eVar.a;
        if (behavior != null) {
            float d2 = behavior.d(this, view2);
            if (d2 > 0.0f) {
                if (this.e == null) {
                    this.e = new Paint();
                }
                this.e.setColor(eVar.a.c(this, view2));
                this.e.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view2.isOpaque()) {
                    canvas.clipRect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view2, j);
    }

    public final void y(View view2, int i, int i2) {
        e eVar = (e) view2.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(N(eVar.c), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int q = q(i) - measuredWidth;
        int i5 = 0;
        if (i3 != 1) {
            if (i3 == 5) {
                q += measuredWidth;
            }
        } else {
            q += measuredWidth / 2;
        }
        if (i4 != 16) {
            if (i4 == 80) {
                i5 = measuredHeight + 0;
            }
        } else {
            i5 = 0 + (measuredHeight / 2);
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(q, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view2.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    @NonNull
    public static Rect a() {
        Rect acquire = y.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    public void J() {
        if (this.i && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        this.n = false;
    }

    public final void R() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.s == null) {
                this.s = new a();
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.s);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public void b() {
        if (this.i) {
            if (this.m == null) {
                this.m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public void g() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (u(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.n) {
            if (z) {
                b();
            } else {
                J();
            }
        }
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        G();
        return Collections.unmodifiableList(this.a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.o;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.t.getNestedScrollAxes();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        K(false);
        if (this.n) {
            if (this.m == null) {
                this.m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        if (this.o == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        K(false);
        if (this.n && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        View view2 = this.l;
        if (view2 != null) {
            onStopNestedScroll(view2);
        }
        this.i = false;
    }

    public void A(View view2, int i) {
        Behavior e2;
        e eVar = (e) view2.getLayoutParams();
        if (eVar.k != null) {
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            n(eVar.k, a2);
            boolean z = false;
            k(view2, false, a3);
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            p(view2, i, a2, a4, eVar, measuredWidth, measuredHeight);
            z = (a4.left == a3.left && a4.top == a3.top) ? true : true;
            d(eVar, a4, measuredWidth, measuredHeight);
            int i2 = a4.left - a3.left;
            int i3 = a4.top - a3.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view2, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view2, i3);
            }
            if (z && (e2 = eVar.e()) != null) {
                e2.h(this, view2, eVar.k);
            }
            I(a2);
            I(a3);
            I(a4);
        }
    }

    public final boolean F(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.c;
        t(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = list.get(i2);
            e eVar = (e) view2.getLayoutParams();
            Behavior e2 = eVar.e();
            if ((z || z2) && actionMasked != 0) {
                if (e2 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i != 0) {
                        if (i == 1) {
                            e2.D(this, view2, motionEvent2);
                        }
                    } else {
                        e2.k(this, view2, motionEvent2);
                    }
                }
            } else {
                if (!z && e2 != null) {
                    if (i != 0) {
                        if (i == 1) {
                            z = e2.D(this, view2, motionEvent);
                        }
                    } else {
                        z = e2.k(this, view2, motionEvent);
                    }
                    if (z) {
                        this.k = view2;
                    }
                }
                boolean c2 = eVar.c();
                boolean h = eVar.h(this, view2);
                if (h && !c2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (h && !z2) {
                    break;
                }
            }
        }
        list.clear();
        return z;
    }

    @SuppressLint({"SwitchIntDef"})
    public final void B(int i) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.a.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = this.a.get(i2);
            e eVar = (e) view2.getLayoutParams();
            if (i != 0 || view2.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (eVar.l == this.a.get(i3)) {
                        A(view2, layoutDirection);
                    }
                }
                k(view2, true, a3);
                if (eVar.g != 0 && !a3.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.g, layoutDirection);
                    int i4 = absoluteGravity & 112;
                    if (i4 != 48) {
                        if (i4 == 80) {
                            a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                        }
                    } else {
                        a2.top = Math.max(a2.top, a3.bottom);
                    }
                    int i5 = absoluteGravity & 7;
                    if (i5 != 3) {
                        if (i5 == 5) {
                            a2.right = Math.max(a2.right, getWidth() - a3.left);
                        }
                    } else {
                        a2.left = Math.max(a2.left, a3.right);
                    }
                }
                if (eVar.h != 0 && view2.getVisibility() == 0) {
                    z(view2, a2, layoutDirection);
                }
                if (i != 2) {
                    r(view2, a4);
                    if (!a4.equals(a3)) {
                        H(view2, a3);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view3 = this.a.get(i6);
                    e eVar2 = (e) view3.getLayoutParams();
                    Behavior e2 = eVar2.e();
                    if (e2 != null && e2.e(this, view3, view2)) {
                        if (i == 0 && eVar2.f()) {
                            eVar2.j();
                        } else {
                            if (i != 2) {
                                z = e2.h(this, view3, view2);
                            } else {
                                e2.i(this, view3, view2);
                                z = true;
                            }
                            if (i == 1) {
                                eVar2.o(z);
                            }
                        }
                    }
                }
            }
        }
        I(a2);
        I(a3);
        I(a4);
    }

    public void D(View view2, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view2, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4) {
        onNestedScroll(view2, i, i2, i3, i4, 0);
    }

    public final void G() {
        this.a.clear();
        this.b.c();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e s = s(childAt);
            s.d(this, childAt);
            this.b.b(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (s.b(this, childAt, childAt2)) {
                        if (!this.b.d(childAt2)) {
                            this.b.b(childAt2);
                        }
                        this.b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.a.addAll(this.b.i());
        Collections.reverse(this.a);
    }

    public final void K(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior e2 = ((e) childAt.getLayoutParams()).e();
            if (e2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    e2.k(this, childAt, obtain);
                } else {
                    e2.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).l();
        }
        this.k = null;
        this.h = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Behavior e2;
        boolean D;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.k == null) {
            z = F(motionEvent, 1);
        } else {
            z = false;
        }
        View view2 = this.k;
        if (view2 != null && (e2 = ((e) view2.getLayoutParams()).e()) != null) {
            D = e2.D(this, this.k, motionEvent);
            motionEvent2 = null;
            if (this.k != null) {
                D |= super.onTouchEvent(motionEvent);
            } else if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                K(false);
            }
            return D;
        }
        D = false;
        motionEvent2 = null;
        if (this.k != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        K(false);
        return D;
    }

    public final int q(int i) {
        int[] iArr = this.j;
        if (iArr == null) {
            Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    public final void d(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f2, float f3, boolean z) {
        Behavior e2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (e2 = eVar.e()) != null) {
                    z2 |= e2.n(this, childAt, view2, f2, f3, z);
                }
            }
        }
        if (z2) {
            B(1);
        }
        return z2;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                Behavior e2 = eVar.e();
                if (e2 != null) {
                    boolean A = e2.A(this, childAt, view2, view3, i, i2);
                    z |= A;
                    eVar.q(i2, A);
                } else {
                    eVar.q(i2, false);
                }
            }
        }
        return z;
    }

    public void k(View view2, boolean z, Rect rect) {
        if (!view2.isLayoutRequested() && view2.getVisibility() != 8) {
            if (z) {
                n(view2, rect);
                return;
            } else {
                rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i) {
        onNestedScrollAccepted(view2, view3, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        return onStartNestedScroll(view2, view3, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        Behavior e2 = ((e) view2.getLayoutParams()).e();
        if (e2 != null && e2.w(this, view2, rect, z)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view2, rect, z);
    }

    public boolean v(@NonNull View view2, int i, int i2) {
        Rect a2 = a();
        n(view2, a2);
        try {
            return a2.contains(i, i2);
        } finally {
            I(a2);
        }
    }

    public final void x(View view2, View view3, int i) {
        Rect a2 = a();
        Rect a3 = a();
        try {
            n(view3, a2);
            o(view2, i, a2, a3);
            view2.layout(a3.left, a3.top, a3.right, a3.bottom);
        } finally {
            I(a2);
            I(a3);
        }
    }

    public void o(View view2, int i, Rect rect, Rect rect2) {
        e eVar = (e) view2.getLayoutParams();
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        p(view2, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        d(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        onNestedPreScroll(view2, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        Behavior e2;
        this.t.onNestedScrollAccepted(view2, view3, i, i2);
        this.l = view3;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i2) && (e2 = eVar.e()) != null) {
                e2.v(this, childAt, view2, view3, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior e2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.a.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = this.a.get(i5);
            if (view2.getVisibility() != 8 && ((e2 = ((e) view2.getLayoutParams()).e()) == null || !e2.l(this, view2, layoutDirection))) {
                C(view2, layoutDirection);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        Behavior e2;
        e eVar;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        G();
        g();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 1) {
            z = true;
        } else {
            z = false;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i13 = paddingLeft + paddingRight;
        int i14 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (this.o != null && ViewCompat.getFitsSystemWindows(this)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int size3 = this.a.size();
        int i15 = suggestedMinimumWidth;
        int i16 = suggestedMinimumHeight;
        int i17 = 0;
        int i18 = 0;
        while (i18 < size3) {
            View view2 = this.a.get(i18);
            if (view2.getVisibility() == 8) {
                i11 = i18;
                i8 = size3;
                i9 = paddingLeft;
            } else {
                e eVar2 = (e) view2.getLayoutParams();
                int i19 = eVar2.e;
                if (i19 >= 0 && mode != 0) {
                    int q = q(i19);
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(N(eVar2.c), layoutDirection) & 7;
                    i3 = i17;
                    if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                        i4 = Math.max(0, (size - paddingRight) - q);
                    } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                        i4 = Math.max(0, q - paddingLeft);
                    }
                    if (!z2 && !ViewCompat.getFitsSystemWindows(view2)) {
                        i5 = View.MeasureSpec.makeMeasureSpec(size - (this.o.getSystemWindowInsetLeft() + this.o.getSystemWindowInsetRight()), mode);
                        i6 = View.MeasureSpec.makeMeasureSpec(size2 - (this.o.getSystemWindowInsetTop() + this.o.getSystemWindowInsetBottom()), mode2);
                    } else {
                        i5 = i;
                        i6 = i2;
                    }
                    e2 = eVar2.e();
                    if (e2 == null) {
                        eVar = eVar2;
                        i10 = i3;
                        i11 = i18;
                        i7 = i16;
                        i9 = paddingLeft;
                        i12 = i15;
                        i8 = size3;
                    } else {
                        eVar = eVar2;
                        i7 = i16;
                        i8 = size3;
                        i9 = paddingLeft;
                        i10 = i3;
                        i11 = i18;
                        i12 = i15;
                    }
                    D(view2, i5, i4, i6, 0);
                    e eVar3 = eVar;
                    int max = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar3).leftMargin + ((ViewGroup.MarginLayoutParams) eVar3).rightMargin);
                    int max2 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin);
                    i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                    i15 = max;
                    i16 = max2;
                } else {
                    i3 = i17;
                }
                i4 = 0;
                if (!z2) {
                }
                i5 = i;
                i6 = i2;
                e2 = eVar2.e();
                if (e2 == null) {
                }
                D(view2, i5, i4, i6, 0);
                e eVar32 = eVar;
                int max3 = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar32).leftMargin + ((ViewGroup.MarginLayoutParams) eVar32).rightMargin);
                int max22 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar32).topMargin + ((ViewGroup.MarginLayoutParams) eVar32).bottomMargin);
                i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                i15 = max3;
                i16 = max22;
            }
            i18 = i11 + 1;
            paddingLeft = i9;
            size3 = i8;
        }
        int i20 = i17;
        setMeasuredDimension(View.resolveSizeAndState(i15, i, (-16777216) & i20), View.resolveSizeAndState(i16, i2, i20 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f2, float f3) {
        Behavior e2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (e2 = eVar.e()) != null) {
                    z |= e2.o(this, childAt, view2, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        Behavior e2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i3) && (e2 = eVar.e()) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e2.q(this, childAt, view2, i, i2, iArr2, i3);
                    int[] iArr3 = this.f;
                    if (i > 0) {
                        min = Math.max(i4, iArr3[0]);
                    } else {
                        min = Math.min(i4, iArr3[0]);
                    }
                    i4 = min;
                    int[] iArr4 = this.f;
                    if (i2 > 0) {
                        min2 = Math.max(i5, iArr4[1]);
                    } else {
                        min2 = Math.min(i5, iArr4[1]);
                    }
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            B(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view2, i, i2, i3, i4, 0, this.g);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view2, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        Behavior e2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i5) && (e2 = eVar.e()) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    e2.t(this, childAt, view2, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.f;
                    if (i3 > 0) {
                        min = Math.max(i6, iArr3[0]);
                    } else {
                        min = Math.min(i6, iArr3[0]);
                    }
                    i6 = min;
                    if (i4 > 0) {
                        min2 = Math.max(i7, this.f[1]);
                    } else {
                        min2 = Math.min(i7, this.f[1]);
                    }
                    i7 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            B(1);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior e2 = s(childAt).e();
            if (id != -1 && e2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                e2.x(this, childAt, parcelable2);
            }
        }
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.q;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable4.setVisible(z, false);
                this.q.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view2, int i) {
        this.t.onStopNestedScroll(view2, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i)) {
                Behavior e2 = eVar.e();
                if (e2 != null) {
                    e2.C(this, childAt, view2, i);
                }
                eVar.k(i);
                eVar.j();
            }
        }
        this.l = null;
    }

    public final void p(View view2, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(L(eVar.c), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(M(eVar.d), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 7;
        int i7 = absoluteGravity2 & 112;
        if (i6 != 1) {
            if (i6 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i7 != 16) {
            if (i7 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i4 != 1) {
            if (i4 != 5) {
                width -= i2;
            }
        } else {
            width -= i2 / 2;
        }
        if (i5 != 16) {
            if (i5 != 80) {
                height -= i3;
            }
        } else {
            height -= i3 / 2;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    public e s(View view2) {
        e eVar = (e) view2.getLayoutParams();
        if (!eVar.b) {
            if (view2 instanceof b) {
                Behavior behavior = ((b) view2).getBehavior();
                if (behavior == null) {
                    Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Attached behavior class is null");
                }
                eVar.n(behavior);
                eVar.b = true;
            } else {
                c cVar = null;
                for (Class<?> cls = view2.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.n(cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                eVar.b = true;
            }
        }
        return eVar;
    }

    public final void w(View view2, int i) {
        e eVar = (e) view2.getLayoutParams();
        Rect a2 = a();
        a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.o != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view2)) {
            a2.left += this.o.getSystemWindowInsetLeft();
            a2.top += this.o.getSystemWindowInsetTop();
            a2.right -= this.o.getSystemWindowInsetRight();
            a2.bottom -= this.o.getSystemWindowInsetBottom();
        }
        Rect a3 = a();
        GravityCompat.apply(M(eVar.c), view2.getMeasuredWidth(), view2.getMeasuredHeight(), a2, a3, i);
        view2.layout(a3.left, a3.top, a3.right, a3.bottom);
        I(a2);
        I(a3);
    }

    public final void z(View view2, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (ViewCompat.isLaidOut(view2) && view2.getWidth() > 0 && view2.getHeight() > 0) {
            e eVar = (e) view2.getLayoutParams();
            Behavior e2 = eVar.e();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            if (e2 != null && e2.b(this, view2, a2)) {
                if (!a3.contains(a2)) {
                    return;
                }
            } else {
                a2.set(a3);
            }
            I(a3);
            if (a2.isEmpty()) {
                I(a2);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.h, i);
            boolean z3 = true;
            if ((absoluteGravity & 48) == 48 && (i6 = (a2.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.j) < (i7 = rect.top)) {
                P(view2, i7 - i6);
                z = true;
            } else {
                z = false;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.j) < (i5 = rect.bottom)) {
                P(view2, height - i5);
                z = true;
            }
            if (!z) {
                P(view2, 0);
            }
            if ((absoluteGravity & 3) == 3 && (i3 = (a2.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.i) < (i4 = rect.left)) {
                O(view2, i4 - i3);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.i) < (i2 = rect.right)) {
                O(view2, width - i2);
            } else {
                z3 = z2;
            }
            if (!z3) {
                O(view2, 0);
            }
            I(a2);
        }
    }
}
