package android.support.design.widget;

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
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.baidu.ar.util.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {
    static final Comparator<View> nA;
    static final String nx;
    static final Class<?>[] ny;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> nz;
    private WindowInsetsCompat kK;
    private boolean mDrawStatusBarBackground;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> nB;
    private final e<View> nC;
    private final List<View> nD;
    private final List<View> nE;
    private final Rect nF;
    private final Rect nG;
    private final Rect nH;
    private final Rect nI;
    private final int[] nJ;
    private boolean nK;
    private boolean nL;
    private int[] nM;
    private View nN;
    private View nO;
    private View nP;
    private b nQ;
    private boolean nR;
    ViewGroup.OnHierarchyChangeListener nS;
    private OnApplyWindowInsetsListener nT;

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface DispatchChangeEvent {
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        nx = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            nA = new c();
        } else {
            nA = null;
        }
        ny = new Class[]{Context.class, AttributeSet.class};
        nz = new ThreadLocal<>();
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nB = new ArrayList();
        this.nC = new e<>();
        this.nD = new ArrayList();
        this.nE = new ArrayList();
        this.nF = new Rect();
        this.nG = new Rect();
        this.nH = new Rect();
        this.nI = new Rect();
        this.nJ = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        r.R(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, R.style.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.nM = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.nM.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.nM;
                iArr[i2] = (int) (iArr[i2] * f);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        by();
        super.setOnHierarchyChangeListener(new a());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.nS = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bt();
        if (this.nR) {
            if (this.nQ == null) {
                this.nQ = new b();
            }
            getViewTreeObserver().addOnPreDrawListener(this.nQ);
        }
        if (this.kK == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.nL = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bt();
        if (this.nR && this.nQ != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.nQ);
        }
        if (this.nP != null) {
            onStopNestedScroll(this.nP);
        }
        this.nL = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.mStatusBarBackground != drawable) {
            if (this.mStatusBarBackground != null) {
                this.mStatusBarBackground.setCallback(null);
            }
            this.mStatusBarBackground = drawable != null ? drawable.mutate() : null;
            if (this.mStatusBarBackground != null) {
                if (this.mStatusBarBackground.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final WindowInsetsCompat b(WindowInsetsCompat windowInsetsCompat) {
        boolean z = true;
        if (!z.d(this.kK, windowInsetsCompat)) {
            this.kK = windowInsetsCompat;
            this.mDrawStatusBarBackground = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
            if (this.mDrawStatusBarBackground || getBackground() != null) {
                z = false;
            }
            setWillNotDraw(z);
            WindowInsetsCompat c2 = c(windowInsetsCompat);
            requestLayout();
            return c2;
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.kK;
    }

    private void bt() {
        if (this.nN != null) {
            Behavior behavior = ((LayoutParams) this.nN.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.onTouchEvent(this, this.nN, obtain);
                obtain.recycle();
            }
            this.nN = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((LayoutParams) getChildAt(i).getLayoutParams()).bC();
        }
        this.nK = false;
    }

    private void g(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (nA != null) {
            Collections.sort(list, nA);
        }
    }

    private boolean b(MotionEvent motionEvent, int i) {
        boolean z;
        MotionEvent motionEvent2;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        MotionEvent motionEvent3 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        List<View> list = this.nD;
        g(list);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                View view = list.get(i2);
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if ((z3 || z4) && actionMasked != 0) {
                    if (behavior != null) {
                        if (motionEvent3 == null) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        } else {
                            motionEvent2 = motionEvent3;
                        }
                        switch (i) {
                            case 0:
                                behavior.onInterceptTouchEvent(this, view, motionEvent2);
                                break;
                            case 1:
                                behavior.onTouchEvent(this, view, motionEvent2);
                                break;
                        }
                        z2 = z4;
                        z = z3;
                    } else {
                        motionEvent2 = motionEvent3;
                        z = z3;
                        z2 = z4;
                    }
                } else {
                    if (!z3 && behavior != null) {
                        switch (i) {
                            case 0:
                                z3 = behavior.onInterceptTouchEvent(this, view, motionEvent);
                                break;
                            case 1:
                                z3 = behavior.onTouchEvent(this, view, motionEvent);
                                break;
                        }
                        if (z3) {
                            this.nN = view;
                        }
                    }
                    z = z3;
                    boolean bB = layoutParams.bB();
                    boolean b2 = layoutParams.b(this, view);
                    boolean z5 = b2 && !bB;
                    if (!b2 || z5) {
                        MotionEvent motionEvent4 = motionEvent3;
                        z2 = z5;
                        motionEvent2 = motionEvent4;
                    }
                }
                i2++;
                z4 = z2;
                z3 = z;
                motionEvent3 = motionEvent2;
            } else {
                z = z3;
            }
        }
        list.clear();
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            bt();
        }
        boolean b2 = b(motionEvent, 0);
        if (0 != 0) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            bt();
        }
        return b2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = null;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.nN == null) {
            boolean b2 = b(motionEvent, 1);
            if (!b2) {
                z = b2;
                z2 = false;
                if (this.nN != null) {
                    z2 |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    if (0 != 0) {
                        motionEvent2 = null;
                    } else {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    super.onTouchEvent(motionEvent2);
                    motionEvent3 = motionEvent2;
                }
                if (!z2 || actionMasked == 0) {
                }
                if (motionEvent3 != null) {
                    motionEvent3.recycle();
                }
                if (actionMasked != 1 || actionMasked == 3) {
                    bt();
                }
                return z2;
            }
            z = b2;
        } else {
            z = false;
        }
        Behavior behavior = ((LayoutParams) this.nN.getLayoutParams()).getBehavior();
        z2 = behavior != null ? behavior.onTouchEvent(this, this.nN, motionEvent) : false;
        if (this.nN != null) {
        }
        if (!z2) {
        }
        if (motionEvent3 != null) {
        }
        if (actionMasked != 1) {
        }
        bt();
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.nK) {
            bt();
            this.nK = true;
        }
    }

    private int x(int i) {
        if (this.nM == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i < 0 || i >= this.nM.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        } else {
            return this.nM[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        HashMap hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Constants.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(nx)) {
            str = nx + '.' + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = nz.get();
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                nz.set(hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            Constructor<Behavior> constructor = hashMap.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(ny);
                constructor.setAccessible(true);
                hashMap.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    LayoutParams z(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.nW) {
            DefaultBehavior defaultBehavior = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            DefaultBehavior defaultBehavior2 = defaultBehavior;
            if (defaultBehavior2 != null) {
                try {
                    layoutParams.setBehavior(defaultBehavior2.value().newInstance());
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior2.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            layoutParams.nW = true;
        }
        return layoutParams;
    }

    private void bu() {
        this.nB.clear();
        this.nC.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            z(childAt).c(this, childAt);
            this.nC.f(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (z(childAt2).b(this, childAt2, childAt)) {
                        if (!this.nC.contains(childAt2)) {
                            this.nC.f(childAt2);
                        }
                        this.nC.c(childAt, childAt2);
                    }
                }
            }
        }
        this.nB.addAll(this.nC.bI());
        Collections.reverse(this.nB);
    }

    void a(View view, Rect rect) {
        v.b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        bu();
        bv();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        boolean z = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.kK != null && ViewCompat.getFitsSystemWindows(this);
        int size3 = this.nB.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = suggestedMinimumHeight;
        int i10 = suggestedMinimumWidth;
        while (i7 < size3) {
            View view = this.nB.get(i7);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i11 = 0;
            if (layoutParams.keyline >= 0 && mode != 0) {
                int x = x(layoutParams.keyline);
                int absoluteGravity = GravityCompat.getAbsoluteGravity(z(layoutParams.gravity), layoutDirection) & 7;
                if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                    i11 = Math.max(0, (size - paddingRight) - x);
                } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                    i11 = Math.max(0, x - paddingLeft);
                }
            }
            if (!z2 || ViewCompat.getFitsSystemWindows(view)) {
                i3 = i2;
                i4 = i;
            } else {
                int systemWindowInsetLeft = this.kK.getSystemWindowInsetLeft() + this.kK.getSystemWindowInsetRight();
                int systemWindowInsetTop = this.kK.getSystemWindowInsetTop() + this.kK.getSystemWindowInsetBottom();
                i4 = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetLeft, mode);
                i3 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetTop, mode2);
            }
            Behavior behavior = layoutParams.getBehavior();
            if (behavior == null || !behavior.onMeasureChild(this, view, i4, i11, i3, 0)) {
                onMeasureChild(view, i4, i11, i3, 0);
            }
            int max = Math.max(i10, view.getMeasuredWidth() + i5 + layoutParams.leftMargin + layoutParams.rightMargin);
            int max2 = Math.max(i9, view.getMeasuredHeight() + i6 + layoutParams.topMargin + layoutParams.bottomMargin);
            i7++;
            i8 = ViewCompat.combineMeasuredStates(i8, ViewCompat.getMeasuredState(view));
            i9 = max2;
            i10 = max;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i10, i, (-16777216) & i8), ViewCompat.resolveSizeAndState(i9, i2, i8 << 16));
    }

    private WindowInsetsCompat c(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        Behavior behavior;
        if (!windowInsetsCompat.isConsumed()) {
            int childCount = getChildCount();
            int i = 0;
            WindowInsetsCompat windowInsetsCompat3 = windowInsetsCompat;
            while (true) {
                if (i >= childCount) {
                    windowInsetsCompat2 = windowInsetsCompat3;
                    break;
                }
                View childAt = getChildAt(i);
                if (!ViewCompat.getFitsSystemWindows(childAt) || (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) == null) {
                    windowInsetsCompat2 = windowInsetsCompat3;
                } else {
                    windowInsetsCompat2 = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat3);
                    if (windowInsetsCompat2.isConsumed()) {
                        break;
                    }
                }
                i++;
                windowInsetsCompat3 = windowInsetsCompat2;
            }
            return windowInsetsCompat2;
        }
        return windowInsetsCompat;
    }

    public void onLayoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.bA()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (layoutParams.oa != null) {
            a(view, layoutParams.oa, i);
        } else if (layoutParams.keyline >= 0) {
            a(view, layoutParams.keyline, i);
        } else {
            d(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.nB.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.nB.get(i5);
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
            if (behavior == null || !behavior.onLayoutChild(this, view, layoutDirection)) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int systemWindowInsetTop = this.kK != null ? this.kK.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        by();
    }

    void b(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).b(rect);
    }

    void c(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).bz());
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(A(layoutParams.gravity), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(y(layoutParams.anchorGravity), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 112;
        switch (absoluteGravity2 & 7) {
            case 1:
                width = (rect.width() / 2) + rect.left;
                break;
            case 5:
                width = rect.right;
                break;
            default:
                width = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                height = rect.top + (rect.height() / 2);
                break;
            case 80:
                height = rect.bottom;
                break;
            default:
                height = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                width -= i2 / 2;
                break;
            case 5:
                break;
            default:
                width -= i2;
                break;
        }
        switch (i5) {
            case 16:
                height -= i3 / 2;
                break;
            case 80:
                break;
            default:
                height -= i3;
                break;
        }
        rect2.set(width, height, width + i2, height + i3);
    }

    private void a(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(max, max2, max + i, max2 + i2);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        a(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = this.nF;
        Rect rect2 = this.nG;
        a(view2, rect);
        a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(z(layoutParams.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int x = x(i) - measuredWidth;
        int i5 = 0;
        switch (i3) {
            case 1:
                x += measuredWidth / 2;
                break;
            case 5:
                x += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i5 = 0 + (measuredHeight / 2);
                break;
            case 80:
                i5 = 0 + measuredHeight;
                break;
        }
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(x, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
    }

    private void d(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = this.nF;
        rect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.kK != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += this.kK.getSystemWindowInsetLeft();
            rect.top += this.kK.getSystemWindowInsetTop();
            rect.right -= this.kK.getSystemWindowInsetRight();
            rect.bottom -= this.kK.getSystemWindowInsetBottom();
        }
        Rect rect2 = this.nG;
        GravityCompat.apply(y(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int y(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    private static int z(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private static int A(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.nV != null) {
            float scrimOpacity = layoutParams.nV.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.nV.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(m.constrain(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void B(int i) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.nB.size();
        Rect rect = this.nI;
        rect.setEmpty();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.nB.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            for (int i3 = 0; i3 < i2; i3++) {
                if (layoutParams.ob == this.nB.get(i3)) {
                    g(view, layoutDirection);
                }
            }
            Rect rect2 = this.nF;
            a(view, true, rect2);
            if (layoutParams.insetEdge != 0 && !rect2.isEmpty()) {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                switch (absoluteGravity & 112) {
                    case 48:
                        rect.top = Math.max(rect.top, rect2.bottom);
                        break;
                    case 80:
                        rect.bottom = Math.max(rect.bottom, getHeight() - rect2.top);
                        break;
                }
                switch (absoluteGravity & 7) {
                    case 3:
                        rect.left = Math.max(rect.left, rect2.right);
                        break;
                    case 5:
                        rect.right = Math.max(rect.right, getWidth() - rect2.left);
                        break;
                }
            }
            if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                a(view, rect, layoutDirection);
            }
            if (i == 0) {
                Rect rect3 = this.nG;
                c(view, rect3);
                if (!rect3.equals(rect2)) {
                    b(view, rect2);
                }
            }
            for (int i4 = i2 + 1; i4 < size; i4++) {
                View view2 = this.nB.get(i4);
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                Behavior behavior = layoutParams2.getBehavior();
                if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                    if (i == 0 && layoutParams2.bF()) {
                        layoutParams2.bG();
                    } else {
                        switch (i) {
                            case 2:
                                behavior.onDependentViewRemoved(this, view2, view);
                                z = true;
                                break;
                            default:
                                z = behavior.onDependentViewChanged(this, view2, view);
                                break;
                        }
                        if (i == 1) {
                            layoutParams2.l(z);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int height;
        int i3;
        if (ViewCompat.isLaidOut(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i);
            Behavior behavior = layoutParams.getBehavior();
            Rect rect2 = this.nH;
            if (behavior != null && behavior.getInsetDodgeRect(this, view, rect2)) {
                if (!rect2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    throw new IllegalArgumentException("Rect should intersect with child's bounds.");
                }
            } else {
                rect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            if (!rect2.isEmpty()) {
                if ((absoluteGravity & 48) != 48 || (i3 = (rect2.top - layoutParams.topMargin) - layoutParams.nZ) >= rect.top) {
                    z = false;
                } else {
                    f(view, rect.top - i3);
                    z = true;
                }
                if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - rect2.bottom) - layoutParams.bottomMargin) + layoutParams.nZ) < rect.bottom) {
                    f(view, height - rect.bottom);
                    z = true;
                }
                if (!z) {
                    f(view, 0);
                }
                if ((absoluteGravity & 3) != 3 || (i2 = (rect2.left - layoutParams.leftMargin) - layoutParams.nY) >= rect.left) {
                    z2 = false;
                } else {
                    e(view, rect.left - i2);
                    z2 = true;
                }
                if ((absoluteGravity & 5) == 5) {
                    int width = layoutParams.nY + ((getWidth() - rect2.right) - layoutParams.rightMargin);
                    if (width < rect.right) {
                        e(view, width - rect.right);
                        z3 = true;
                        if (z3) {
                            e(view, 0);
                            return;
                        }
                        return;
                    }
                }
                z3 = z2;
                if (z3) {
                }
            }
        }
    }

    private void e(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.nY != i) {
            ViewCompat.offsetLeftAndRight(view, i - layoutParams.nY);
            layoutParams.nY = i;
        }
    }

    private void f(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.nZ != i) {
            ViewCompat.offsetTopAndBottom(view, i - layoutParams.nZ);
            layoutParams.nZ = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List g = this.nC.g(view);
        if (g != null && !g.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < g.size()) {
                    View view2 = (View) g.get(i2);
                    Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                    if (behavior != null) {
                        behavior.onDependentViewChanged(this, view2, view);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public List<View> getDependencies(View view) {
        List h = this.nC.h(view);
        this.nE.clear();
        if (h != null) {
            this.nE.addAll(h);
        }
        return this.nE;
    }

    public List<View> getDependents(View view) {
        List g = this.nC.g(view);
        this.nE.clear();
        if (g != null) {
            this.nE.addAll(g);
        }
        return this.nE;
    }

    final List<View> getDependencySortedChildren() {
        bu();
        return Collections.unmodifiableList(this.nB);
    }

    void bv() {
        boolean z = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (!A(getChildAt(i))) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z != this.nR) {
            if (z) {
                bw();
            } else {
                bx();
            }
        }
    }

    private boolean A(View view) {
        return this.nC.i(view);
    }

    void bw() {
        if (this.nL) {
            if (this.nQ == null) {
                this.nQ = new b();
            }
            getViewTreeObserver().addOnPreDrawListener(this.nQ);
        }
        this.nR = true;
    }

    void bx() {
        if (this.nL && this.nQ != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.nQ);
        }
        this.nR = false;
    }

    void g(View view, int i) {
        Behavior behavior;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.oa != null) {
            Rect rect = this.nF;
            Rect rect2 = this.nG;
            Rect rect3 = this.nH;
            a(layoutParams.oa, rect);
            a(view, false, rect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, rect, rect3, layoutParams, measuredWidth, measuredHeight);
            boolean z = (rect3.left == rect2.left && rect3.top == rect2.top) ? false : true;
            a(layoutParams, rect3, measuredWidth, measuredHeight);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view, i3);
            }
            if (z && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onDependentViewChanged(this, view, layoutParams.oa);
            }
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect rect = this.nF;
        a(view, rect);
        return rect.contains(i, i2);
    }

    public boolean doViewsOverlap(View view, View view2) {
        if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
            Rect rect = this.nF;
            a(view, view.getParent() != this, rect);
            Rect rect2 = this.nG;
            a(view2, view2.getParent() != this, rect2);
            return rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z;
        int childCount = getChildCount();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if (behavior != null) {
                boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i);
                z = z2 | onStartNestedScroll;
                layoutParams.k(onStartNestedScroll);
            } else {
                layoutParams.k(false);
                z = z2;
            }
            i2++;
            z2 = z;
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        Behavior behavior;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        this.nO = view;
        this.nP = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE() && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE()) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view);
                }
                layoutParams.bD();
                layoutParams.bG();
            }
        }
        this.nO = null;
        this.nP = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE()) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onNestedScroll(this, childAt, view, i, i2, i3, i4);
                    z = true;
                } else {
                    z = z2;
                }
            } else {
                z = z2;
            }
            i5++;
            z2 = z;
        }
        if (z2) {
            B(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        boolean z;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        boolean z2 = false;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE()) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    int[] iArr2 = this.nJ;
                    this.nJ[1] = 0;
                    iArr2[0] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i, i2, this.nJ);
                    i3 = i > 0 ? Math.max(i5, this.nJ[0]) : Math.min(i5, this.nJ[0]);
                    i4 = i2 > 0 ? Math.max(i6, this.nJ[1]) : Math.min(i6, this.nJ[1]);
                    z = true;
                } else {
                    z = z2;
                    i3 = i5;
                    i4 = i6;
                }
            } else {
                z = z2;
                i3 = i5;
                i4 = i6;
            }
            i7++;
            i6 = i4;
            i5 = i3;
            z2 = z;
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            B(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean onNestedFling;
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE()) {
                Behavior behavior = layoutParams.getBehavior();
                onNestedFling = behavior != null ? behavior.onNestedFling(this, childAt, view, f, f2, z) | z2 : z2;
            } else {
                onNestedFling = z2;
            }
            i++;
            z2 = onNestedFling;
        }
        if (z2) {
            B(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        boolean onNestedPreFling;
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.bE()) {
                Behavior behavior = layoutParams.getBehavior();
                onNestedPreFling = behavior != null ? behavior.onNestedPreFling(this, childAt, view, f, f2) | z : z;
            } else {
                onNestedPreFling = z;
            }
            i++;
            z = onNestedPreFling;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.B(0);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Comparator<View> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float z = ViewCompat.getZ(view);
            float z2 = ViewCompat.getZ(view2);
            if (z > z2) {
                return -1;
            }
            if (z < z2) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        @Deprecated
        public boolean isDirty(CoordinatorLayout coordinatorLayout, V v) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).og = obj;
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).og;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        Behavior nV;
        boolean nW;
        int nX;
        int nY;
        int nZ;
        View oa;
        View ob;
        private boolean oc;
        private boolean od;
        private boolean oe;
        final Rect of;
        Object og;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.nW = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.nX = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.of = new Rect();
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.nW = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.nX = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.of = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.nX = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.nW = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.nW) {
                this.nV = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.nV != null) {
                this.nV.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.nW = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.nX = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.of = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.nW = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.nX = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.of = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.nW = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.nX = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.of = new Rect();
        }

        public int getAnchorId() {
            return this.nX;
        }

        public void setAnchorId(int i) {
            bH();
            this.nX = i;
        }

        public Behavior getBehavior() {
            return this.nV;
        }

        public void setBehavior(Behavior behavior) {
            if (this.nV != behavior) {
                if (this.nV != null) {
                    this.nV.onDetachedFromLayoutParams();
                }
                this.nV = behavior;
                this.og = null;
                this.nW = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        void b(Rect rect) {
            this.of.set(rect);
        }

        Rect bz() {
            return this.of;
        }

        boolean bA() {
            return this.oa == null && this.nX != -1;
        }

        boolean bB() {
            if (this.nV == null) {
                this.oc = false;
            }
            return this.oc;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.oc) {
                return true;
            }
            boolean blocksInteractionBelow = (this.nV != null ? this.nV.blocksInteractionBelow(coordinatorLayout, view) : false) | this.oc;
            this.oc = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        void bC() {
            this.oc = false;
        }

        void bD() {
            this.od = false;
        }

        void k(boolean z) {
            this.od = z;
        }

        boolean bE() {
            return this.od;
        }

        boolean bF() {
            return this.oe;
        }

        void l(boolean z) {
            this.oe = z;
        }

        void bG() {
            this.oe = false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.ob || h(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || (this.nV != null && this.nV.layoutDependsOn(coordinatorLayout, view, view2));
        }

        void bH() {
            this.ob = null;
            this.oa = null;
        }

        View c(CoordinatorLayout coordinatorLayout, View view) {
            if (this.nX == -1) {
                this.ob = null;
                this.oa = null;
                return null;
            }
            if (this.oa == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.oa;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.oa = coordinatorLayout.findViewById(this.nX);
            if (this.oa != null) {
                if (this.oa == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.ob = null;
                        this.oa = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                View view2 = this.oa;
                for (ViewParent parent = this.oa.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.ob = null;
                            this.oa = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.ob = view2;
            } else if (coordinatorLayout.isInEditMode()) {
                this.ob = null;
                this.oa = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.nX) + " to anchor view " + view);
            }
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.oa.getId() != this.nX) {
                return false;
            }
            View view2 = this.oa;
            for (ViewParent parent = this.oa.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.ob = null;
                    this.oa = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.ob = view2;
            return true;
        }

        private boolean h(View view, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & absoluteGravity) == absoluteGravity;
        }
    }

    /* loaded from: classes2.dex */
    private class a implements ViewGroup.OnHierarchyChangeListener {
        a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.nS != null) {
                CoordinatorLayout.this.nS.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.B(2);
            if (CoordinatorLayout.this.nS != null) {
                CoordinatorLayout.this.nS.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.oh;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = z(childAt).getBehavior();
            if (id != -1 && behavior != null && (parcelable2 = sparseArray.get(id)) != null) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (id != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.oh = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void by() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (ViewCompat.getFitsSystemWindows(this)) {
                if (this.nT == null) {
                    this.nT = new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CoordinatorLayout.1
                        @Override // android.support.v4.view.OnApplyWindowInsetsListener
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            return CoordinatorLayout.this.b(windowInsetsCompat);
                        }
                    };
                }
                ViewCompat.setOnApplyWindowInsetsListener(this, this.nT);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.design.widget.CoordinatorLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: d */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: C */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        SparseArray<Parcelable> oh;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.oh = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.oh.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.oh != null ? this.oh.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.oh.keyAt(i2);
                parcelableArr[i2] = this.oh.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
