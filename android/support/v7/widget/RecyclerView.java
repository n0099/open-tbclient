package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.v4.media.TransportMediator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.c;
import android.support.v7.widget.k;
import android.support.v7.widget.v;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.baidu.ar.util.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    private static final int[] QW = {16843830};
    private static final int[] QX = {16842987};
    static final boolean QY;
    static final boolean QZ;
    private static final long RX;
    static long RY = 0;
    static final boolean Ra;
    private static final boolean Rb;
    private static final Class<?>[] Rc;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final Interpolator So;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    private List<OnChildAttachStateChangeListener> RA;
    boolean RB;
    private int RC;
    private int RD;
    private EdgeEffectCompat RE;
    private EdgeEffectCompat RF;
    private EdgeEffectCompat RG;
    private EdgeEffectCompat RH;
    ItemAnimator RI;
    private int RJ;
    private int RK;
    private int RL;
    private int RO;
    private int RP;
    private OnFlingListener RQ;
    private final int RR;
    private final int RT;
    private float RU;
    private boolean RV;
    final d RW;
    e RZ;
    private final c Rd;
    final Recycler Re;
    private SavedState Rf;
    android.support.v7.widget.c Rg;
    k Rh;
    final v Ri;
    boolean Rj;
    final Runnable Rk;
    final RectF Rl;
    Adapter Rm;
    LayoutManager Rn;
    RecyclerListener Ro;
    final ArrayList<ItemDecoration> Rp;
    private final ArrayList<OnItemTouchListener> Rq;
    private OnItemTouchListener Rr;
    boolean Rs;
    boolean Rt;
    private int Ru;
    boolean Rv;
    boolean Rw;
    private boolean Rx;
    private int Ry;
    boolean Rz;
    final State Sa;
    private OnScrollListener Sb;
    private List<OnScrollListener> Sc;
    boolean Sd;
    boolean Se;
    private ItemAnimator.a Sf;
    boolean Sg;
    RecyclerViewAccessibilityDelegate Sh;
    private ChildDrawingOrderCallback Si;
    private final int[] Sj;
    private NestedScrollingChildHelper Sk;
    private final int[] Sl;
    private final List<ViewHolder> Sm;
    private Runnable Sn;
    private final v.b Sp;
    private final AccessibilityManager mAccessibilityManager;
    boolean mIsAttached;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private int mScrollState;
    final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final Rect nG;

    /* loaded from: classes2.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* loaded from: classes2.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    /* loaded from: classes2.dex */
    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i, int i2);
    }

    static {
        QY = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        QZ = Build.VERSION.SDK_INT >= 23;
        Ra = Build.VERSION.SDK_INT >= 16;
        Rb = Build.VERSION.SDK_INT >= 21;
        Rc = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        RX = TimeUnit.MILLISECONDS.toNanos(4L);
        RY = 0L;
        So = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        this.Rd = new c();
        this.Re = new Recycler();
        this.Ri = new v();
        this.Rk = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.Rt && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.Rw) {
                        RecyclerView.this.Rv = true;
                    } else {
                        RecyclerView.this.gv();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.nG = new Rect();
        this.Rl = new RectF();
        this.Rp = new ArrayList<>();
        this.Rq = new ArrayList<>();
        this.Ru = 0;
        this.RB = false;
        this.RC = 0;
        this.RD = 0;
        this.RI = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.RJ = -1;
        this.RU = Float.MIN_VALUE;
        this.RV = true;
        this.RW = new d();
        this.RZ = Rb ? new e() : null;
        this.Sa = new State();
        this.Sd = false;
        this.Se = false;
        this.Sf = new b();
        this.Sg = false;
        this.Sj = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.Sl = new int[2];
        this.Sm = new ArrayList();
        this.Sn = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.RI != null) {
                    RecyclerView.this.RI.runPendingAnimations();
                }
                RecyclerView.this.Sg = false;
            }
        };
        this.Sp = new v.b() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.v.b
            public void c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.Re.m(viewHolder);
                RecyclerView.this.b(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.v.b
            public void d(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.a(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.v.b
            public void e(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.RB) {
                    if (RecyclerView.this.RI.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.gL();
                    }
                } else if (RecyclerView.this.RI.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.gL();
                }
            }

            @Override // android.support.v7.widget.v.b
            public void g(ViewHolder viewHolder) {
                RecyclerView.this.Rn.removeAndRecycleView(viewHolder.itemView, RecyclerView.this.Re);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, QX, i, 0);
            this.Rj = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.Rj = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.RR = viewConfiguration.getScaledMinimumFlingVelocity();
        this.RT = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.RI.a(this.Sf);
        gu();
        gt();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, QW, i, 0);
                z = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.Sh;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.Sh = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.Sh);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String I = I(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(I).asSubclass(LayoutManager.class);
                    try {
                        Constructor constructor2 = asSubclass.getConstructor(Rc);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = constructor2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + I, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + I, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + I, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + I, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + I, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + I, e8);
                }
            }
        }
    }

    private String I(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(Constants.DOT) ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void gt() {
        this.Rh = new k(new k.b() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // android.support.v7.widget.k.b
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.k.b
            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.as(view);
            }

            @Override // android.support.v7.widget.k.b
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.k.b
            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.ar(childAt);
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // android.support.v7.widget.k.b
            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.k.b
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    RecyclerView.this.ar(getChildAt(i));
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // android.support.v7.widget.k.b
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.ap(view);
            }

            @Override // android.support.v7.widget.k.b
            public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder ap = RecyclerView.ap(view);
                if (ap != null) {
                    if (!ap.isTmpDetached() && !ap.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + ap);
                    }
                    ap.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // android.support.v7.widget.k.b
            public void detachViewFromParent(int i) {
                ViewHolder ap;
                View childAt = getChildAt(i);
                if (childAt != null && (ap = RecyclerView.ap(childAt)) != null) {
                    if (ap.isTmpDetached() && !ap.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + ap);
                    }
                    ap.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // android.support.v7.widget.k.b
            public void ad(View view) {
                ViewHolder ap = RecyclerView.ap(view);
                if (ap == null) {
                    return;
                }
                ap.onEnteredHiddenState(RecyclerView.this);
            }

            @Override // android.support.v7.widget.k.b
            public void ae(View view) {
                ViewHolder ap = RecyclerView.ap(view);
                if (ap == null) {
                    return;
                }
                ap.onLeftHiddenState(RecyclerView.this);
            }
        });
    }

    void gu() {
        this.Rg = new android.support.v7.widget.c(new c.a() { // from class: android.support.v7.widget.RecyclerView.6
            @Override // android.support.v7.widget.c.a
            public ViewHolder bd(int i) {
                ViewHolder n = RecyclerView.this.n(i, true);
                if (n == null || RecyclerView.this.Rh.Z(n.itemView)) {
                    return null;
                }
                return n;
            }

            @Override // android.support.v7.widget.c.a
            public void B(int i, int i2) {
                RecyclerView.this.b(i, i2, true);
                RecyclerView.this.Sd = true;
                RecyclerView.this.Sa.Tk += i2;
            }

            @Override // android.support.v7.widget.c.a
            public void C(int i, int i2) {
                RecyclerView.this.b(i, i2, false);
                RecyclerView.this.Sd = true;
            }

            @Override // android.support.v7.widget.c.a
            public void e(int i, int i2, Object obj) {
                RecyclerView.this.f(i, i2, obj);
                RecyclerView.this.Se = true;
            }

            @Override // android.support.v7.widget.c.a
            public void h(c.b bVar) {
                j(bVar);
            }

            void j(c.b bVar) {
                switch (bVar.cmd) {
                    case 1:
                        RecyclerView.this.Rn.onItemsAdded(RecyclerView.this, bVar.Ml, bVar.Mn);
                        return;
                    case 2:
                        RecyclerView.this.Rn.onItemsRemoved(RecyclerView.this, bVar.Ml, bVar.Mn);
                        return;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        return;
                    case 4:
                        RecyclerView.this.Rn.onItemsUpdated(RecyclerView.this, bVar.Ml, bVar.Mn, bVar.Mm);
                        return;
                    case 8:
                        RecyclerView.this.Rn.onItemsMoved(RecyclerView.this, bVar.Ml, bVar.Mn, 1);
                        return;
                }
            }

            @Override // android.support.v7.widget.c.a
            public void i(c.b bVar) {
                j(bVar);
            }

            @Override // android.support.v7.widget.c.a
            public void D(int i, int i2) {
                RecyclerView.this.U(i, i2);
                RecyclerView.this.Sd = true;
            }

            @Override // android.support.v7.widget.c.a
            public void E(int i, int i2) {
                RecyclerView.this.T(i, i2);
                RecyclerView.this.Sd = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.Rs = z;
    }

    public boolean hasFixedSize() {
        return this.Rs;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.Rj) {
            gE();
        }
        this.Rj = z;
        super.setClipToPadding(z);
        if (this.Rt) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.Rj;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        a(adapter, true, z);
        gY();
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        a(adapter, false, true);
        requestLayout();
    }

    private void a(Adapter adapter, boolean z, boolean z2) {
        if (this.Rm != null) {
            this.Rm.unregisterAdapterDataObserver(this.Rd);
            this.Rm.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            if (this.RI != null) {
                this.RI.endAnimations();
            }
            if (this.Rn != null) {
                this.Rn.removeAndRecycleAllViews(this.Re);
                this.Rn.b(this.Re);
            }
            this.Re.clear();
        }
        this.Rg.reset();
        Adapter adapter2 = this.Rm;
        this.Rm = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.Rd);
            adapter.onAttachedToRecyclerView(this);
        }
        if (this.Rn != null) {
            this.Rn.onAdapterChanged(adapter2, this.Rm);
        }
        this.Re.a(adapter2, this.Rm, z);
        this.Sa.Tl = true;
        gZ();
    }

    public Adapter getAdapter() {
        return this.Rm;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.Ro = recyclerListener;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.Rn != null ? this.Rn.getBaseline() : super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.RA == null) {
            this.RA = new ArrayList();
        }
        this.RA.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.RA != null) {
            this.RA.remove(onChildAttachStateChangeListener);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.RA != null) {
            this.RA.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.Rn) {
            stopScroll();
            if (this.Rn != null) {
                if (this.RI != null) {
                    this.RI.endAnimations();
                }
                this.Rn.removeAndRecycleAllViews(this.Re);
                this.Rn.b(this.Re);
                this.Re.clear();
                if (this.mIsAttached) {
                    this.Rn.a(this, this.Re);
                }
                this.Rn.b((RecyclerView) null);
                this.Rn = null;
            } else {
                this.Re.clear();
            }
            this.Rh.fS();
            this.Rn = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.Sz != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.Sz);
                }
                this.Rn.b(this);
                if (this.mIsAttached) {
                    this.Rn.c(this);
                }
            }
            this.Re.hg();
            requestLayout();
        }
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.RQ = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.RQ;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.Rf != null) {
            savedState.a(this.Rf);
        } else if (this.Rn != null) {
            savedState.SY = this.Rn.onSaveInstanceState();
        } else {
            savedState.SY = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.Rf = (SavedState) parcelable;
        super.onRestoreInstanceState(this.Rf.getSuperState());
        if (this.Rn != null && this.Rf.SY != null) {
            this.Rn.onRestoreInstanceState(this.Rf.SY);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void d(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.Re.m(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.Rh.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.Rh.g(view, true);
        } else {
            this.Rh.aa(view);
        }
    }

    boolean an(View view) {
        gx();
        boolean ac = this.Rh.ac(view);
        if (ac) {
            ViewHolder ap = ap(view);
            this.Re.m(ap);
            this.Re.k(ap);
        }
        J(!ac);
        return ac;
    }

    public LayoutManager getLayoutManager() {
        return this.Rn;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.Re.getRecycledViewPool();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.Re.setRecycledViewPool(recycledViewPool);
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.Re.setViewCacheExtension(viewCacheExtension);
    }

    public void setItemViewCacheSize(int i) {
        this.Re.setViewCacheSize(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                gy();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        if (this.Rn != null) {
            this.Rn.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.Rp.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.Rp.add(itemDecoration);
        } else {
            this.Rp.add(i, itemDecoration);
        }
        gV();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        if (this.Rn != null) {
            this.Rn.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.Rp.remove(itemDecoration);
        if (this.Rp.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        gV();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.Si) {
            this.Si = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.Si != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.Sb = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.Sc == null) {
            this.Sc = new ArrayList();
        }
        this.Sc.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        if (this.Sc != null) {
            this.Sc.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        if (this.Sc != null) {
            this.Sc.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.Rw) {
            stopScroll();
            if (this.Rn == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.Rn.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    void br(int i) {
        if (this.Rn != null) {
            this.Rn.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.Rw) {
            if (this.Rn == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.Rn.smoothScrollToPosition(this, this.Sa, i);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.Rn == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.Rw) {
            boolean canScrollHorizontally = this.Rn.canScrollHorizontally();
            boolean canScrollVertically = this.Rn.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                a(i, i2, (MotionEvent) null);
            }
        }
    }

    void gv() {
        if (!this.Rt || this.RB) {
            TraceCompat.beginSection("RV FullInvalidate");
            gO();
            TraceCompat.endSection();
        } else if (this.Rg.fD()) {
            if (this.Rg.ba(4) && !this.Rg.ba(11)) {
                TraceCompat.beginSection("RV PartialInvalidate");
                gx();
                this.Rg.fB();
                if (!this.Rv) {
                    if (gw()) {
                        gO();
                    } else {
                        this.Rg.fC();
                    }
                }
                J(true);
                TraceCompat.endSection();
            } else if (this.Rg.fD()) {
                TraceCompat.beginSection("RV FullInvalidate");
                gO();
                TraceCompat.endSection();
            }
        }
    }

    private boolean gw() {
        int childCount = this.Rh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder ap = ap(this.Rh.getChildAt(i));
            if (ap != null && !ap.shouldIgnore() && ap.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        gv();
        if (this.Rm != null) {
            gx();
            gH();
            TraceCompat.beginSection("RV Scroll");
            if (i != 0) {
                i7 = this.Rn.scrollHorizontallyBy(i, this.Re, this.Sa);
                i6 = i - i7;
            } else {
                i7 = 0;
                i6 = 0;
            }
            if (i2 != 0) {
                i8 = this.Rn.scrollVerticallyBy(i2, this.Re, this.Sa);
                i9 = i2 - i8;
            } else {
                i8 = 0;
                i9 = 0;
            }
            TraceCompat.endSection();
            ha();
            gI();
            J(false);
            i5 = i9;
            i4 = i7;
            i3 = i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.Rp.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i3, i6, i5, this.mScrollOffset)) {
            this.RO -= this.mScrollOffset[0];
            this.RP -= this.mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
            }
            int[] iArr = this.Sl;
            iArr[0] = iArr[0] + this.mScrollOffset[0];
            int[] iArr2 = this.Sl;
            iArr2[1] = iArr2[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                d(motionEvent.getX(), i6, motionEvent.getY(), i5);
            }
            P(i, i2);
        }
        if (i4 != 0 || i3 != 0) {
            V(i4, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i3 == 0) ? false : true;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        if (this.Rn != null && this.Rn.canScrollHorizontally()) {
            return this.Rn.computeHorizontalScrollOffset(this.Sa);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        if (this.Rn != null && this.Rn.canScrollHorizontally()) {
            return this.Rn.computeHorizontalScrollExtent(this.Sa);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollRange() {
        if (this.Rn != null && this.Rn.canScrollHorizontally()) {
            return this.Rn.computeHorizontalScrollRange(this.Sa);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        if (this.Rn != null && this.Rn.canScrollVertically()) {
            return this.Rn.computeVerticalScrollOffset(this.Sa);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        if (this.Rn != null && this.Rn.canScrollVertically()) {
            return this.Rn.computeVerticalScrollExtent(this.Sa);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollRange() {
        if (this.Rn != null && this.Rn.canScrollVertically()) {
            return this.Rn.computeVerticalScrollRange(this.Sa);
        }
        return 0;
    }

    void gx() {
        this.Ru++;
        if (this.Ru == 1 && !this.Rw) {
            this.Rv = false;
        }
    }

    void J(boolean z) {
        if (this.Ru < 1) {
            this.Ru = 1;
        }
        if (!z) {
            this.Rv = false;
        }
        if (this.Ru == 1) {
            if (z && this.Rv && !this.Rw && this.Rn != null && this.Rm != null) {
                gO();
            }
            if (!this.Rw) {
                this.Rv = false;
            }
        }
        this.Ru--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.Rw) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.Rw = false;
                if (this.Rv && this.Rn != null && this.Rm != null) {
                    requestLayout();
                }
                this.Rv = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.Rw = true;
            this.Rx = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.Rw;
    }

    public void smoothScrollBy(int i, int i2) {
        if (this.Rn == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.Rw) {
            if (!this.Rn.canScrollHorizontally()) {
                i = 0;
            }
            int i3 = this.Rn.canScrollVertically() ? i2 : 0;
            if (i != 0 || i3 != 0) {
                this.RW.smoothScrollBy(i, i3);
            }
        }
    }

    public boolean fling(int i, int i2) {
        if (this.Rn == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.Rw) {
            return false;
        } else {
            boolean canScrollHorizontally = this.Rn.canScrollHorizontally();
            boolean canScrollVertically = this.Rn.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.RR) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.RR) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling(i, i2)) {
                return false;
            }
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(i, i2, z);
            if (this.RQ == null || !this.RQ.onFling(i, i2)) {
                if (z) {
                    this.RW.aa(Math.max(-this.RT, Math.min(i, this.RT)), Math.max(-this.RT, Math.min(i2, this.RT)));
                    return true;
                }
                return false;
            }
            return true;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        gy();
    }

    private void gy() {
        this.RW.stop();
        if (this.Rn != null) {
            this.Rn.he();
        }
    }

    public int getMinFlingVelocity() {
        return this.RR;
    }

    public int getMaxFlingVelocity() {
        return this.RT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if (r7.RF.onPull((-r11) / getHeight(), r8 / getWidth()) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r7.RH.onPull(r11 / getHeight(), 1.0f - (r8 / getWidth())) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(float f, float f2, float f3, float f4) {
        boolean z = true;
        boolean z2 = false;
        if (f2 < 0.0f) {
            gA();
            if (this.RE.onPull((-f2) / getWidth(), 1.0f - (f3 / getHeight()))) {
                z2 = true;
            }
        } else if (f2 > 0.0f) {
            gB();
            if (this.RG.onPull(f2 / getWidth(), f3 / getHeight())) {
                z2 = true;
            }
        }
        if (f4 < 0.0f) {
            gC();
        } else {
            if (f4 > 0.0f) {
                gD();
            }
            z = z2;
        }
        if (z || f2 != 0.0f || f4 != 0.0f) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void gz() {
        boolean onRelease = this.RE != null ? this.RE.onRelease() : false;
        if (this.RF != null) {
            onRelease |= this.RF.onRelease();
        }
        if (this.RG != null) {
            onRelease |= this.RG.onRelease();
        }
        if (this.RH != null) {
            onRelease |= this.RH.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void P(int i, int i2) {
        boolean z = false;
        if (this.RE != null && !this.RE.isFinished() && i > 0) {
            z = this.RE.onRelease();
        }
        if (this.RG != null && !this.RG.isFinished() && i < 0) {
            z |= this.RG.onRelease();
        }
        if (this.RF != null && !this.RF.isFinished() && i2 > 0) {
            z |= this.RF.onRelease();
        }
        if (this.RH != null && !this.RH.isFinished() && i2 < 0) {
            z |= this.RH.onRelease();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void Q(int i, int i2) {
        if (i < 0) {
            gA();
            this.RE.onAbsorb(-i);
        } else if (i > 0) {
            gB();
            this.RG.onAbsorb(i);
        }
        if (i2 < 0) {
            gC();
            this.RF.onAbsorb(-i2);
        } else if (i2 > 0) {
            gD();
            this.RH.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void gA() {
        if (this.RE == null) {
            this.RE = new EdgeEffectCompat(getContext());
            if (this.Rj) {
                this.RE.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.RE.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gB() {
        if (this.RG == null) {
            this.RG = new EdgeEffectCompat(getContext());
            if (this.Rj) {
                this.RG.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.RG.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gC() {
        if (this.RF == null) {
            this.RF = new EdgeEffectCompat(getContext());
            if (this.Rj) {
                this.RF.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.RF.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void gD() {
        if (this.RH == null) {
            this.RH = new EdgeEffectCompat(getContext());
            if (this.Rj) {
                this.RH.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.RH.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void gE() {
        this.RH = null;
        this.RF = null;
        this.RG = null;
        this.RE = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        boolean z2 = true;
        View onInterceptFocusSearch = this.Rn.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch == null) {
            boolean z3 = (this.Rm == null || this.Rn == null || isComputingLayout() || this.Rw) ? false : true;
            FocusFinder focusFinder = FocusFinder.getInstance();
            if (z3 && (i == 2 || i == 1)) {
                if (this.Rn.canScrollVertically()) {
                    z = focusFinder.findNextFocus(this, view, i == 2 ? TransportMediator.KEYCODE_MEDIA_RECORD : 33) == null;
                } else {
                    z = false;
                }
                if (z || !this.Rn.canScrollHorizontally()) {
                    z2 = z;
                } else {
                    if (focusFinder.findNextFocus(this, view, (i == 2) ^ (this.Rn.getLayoutDirection() == 1) ? 66 : 17) != null) {
                        z2 = false;
                    }
                }
                if (z2) {
                    gv();
                    if (findContainingItemView(view) == null) {
                        return null;
                    }
                    gx();
                    this.Rn.onFocusSearchFailed(view, i, this.Re, this.Sa);
                    J(false);
                }
                view2 = focusFinder.findNextFocus(this, view, i);
            } else {
                View findNextFocus = focusFinder.findNextFocus(this, view, i);
                if (findNextFocus == null && z3) {
                    gv();
                    if (findContainingItemView(view) == null) {
                        return null;
                    }
                    gx();
                    view2 = this.Rn.onFocusSearchFailed(view, i, this.Re, this.Sa);
                    J(false);
                } else {
                    view2 = findNextFocus;
                }
            }
            return !b(view, view2, i) ? super.focusSearch(view, i) : view2;
        }
        return onInterceptFocusSearch;
    }

    private boolean b(View view, View view2, int i) {
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i == 2 || i == 1) {
            if (c(view, view2, (i == 2) ^ (this.Rn.getLayoutDirection() == 1) ? 66 : 17)) {
                return true;
            }
            if (i == 2) {
                return c(view, view2, TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            return c(view, view2, 33);
        }
        return c(view, view2, i);
    }

    private boolean c(View view, View view2, int i) {
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.nG.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.nG);
        switch (i) {
            case 17:
                return (this.mTempRect.right > this.nG.right || this.mTempRect.left >= this.nG.right) && this.mTempRect.left > this.nG.left;
            case 33:
                return (this.mTempRect.bottom > this.nG.bottom || this.mTempRect.top >= this.nG.bottom) && this.mTempRect.top > this.nG.top;
            case 66:
                return (this.mTempRect.left < this.nG.left || this.mTempRect.right <= this.nG.left) && this.mTempRect.right < this.nG.right;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                return (this.mTempRect.top < this.nG.top || this.mTempRect.bottom <= this.nG.top) && this.mTempRect.bottom < this.nG.bottom;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.Rn.onRequestChildFocus(this, this.Sa, view, view2) && view2 != null) {
            this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.SJ) {
                    Rect rect = layoutParams2.Pc;
                    this.mTempRect.left -= rect.left;
                    this.mTempRect.right += rect.right;
                    this.mTempRect.top -= rect.top;
                    Rect rect2 = this.mTempRect;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, !this.Rt);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.Rn.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.Rn == null || !this.Rn.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        boolean z = true;
        super.onAttachedToWindow();
        this.RC = 0;
        this.mIsAttached = true;
        if (!this.Rt || isLayoutRequested()) {
            z = false;
        }
        this.Rt = z;
        if (this.Rn != null) {
            this.Rn.c(this);
        }
        this.Sg = false;
        if (Rb && RY == 0) {
            float f = 60.0f;
            Display display = ViewCompat.getDisplay(this);
            if (display != null && display.getRefreshRate() >= 30.0f) {
                f = display.getRefreshRate();
            }
            RY = 1.0E9f / f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.RI != null) {
            this.RI.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.Rn != null) {
            this.Rn.a(this, this.Re);
        }
        this.Sm.clear();
        removeCallbacks(this.Sn);
        this.Ri.onDetach();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        } else if (this.RD > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks might be run during a measure & layout pass where you cannot change the RecyclerView data. Any method call that might change the structure of the RecyclerView or the adapter contents should be postponed to the next frame.", new IllegalStateException(""));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.Rq.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.Rq.remove(onItemTouchListener);
        if (this.Rr == onItemTouchListener) {
            this.Rr = null;
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.Rr = null;
        }
        int size = this.Rq.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.Rq.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.Rr = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean l(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.Rr != null) {
            if (action == 0) {
                this.Rr = null;
            } else {
                this.Rr.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.Rr = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.Rq.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = this.Rq.get(i);
                if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent)) {
                    this.Rr = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.Rw) {
            return false;
        }
        if (k(motionEvent)) {
            gG();
            return true;
        } else if (this.Rn != null) {
            boolean canScrollHorizontally = this.Rn.canScrollHorizontally();
            boolean canScrollVertically = this.Rn.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            switch (actionMasked) {
                case 0:
                    if (this.Rx) {
                        this.Rx = false;
                    }
                    this.RJ = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.RO = x;
                    this.RK = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.RP = y;
                    this.RL = y;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.Sl;
                    this.Sl[1] = 0;
                    iArr[0] = 0;
                    int i = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i |= 2;
                    }
                    startNestedScroll(i);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.RJ);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.RJ + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i2 = x2 - this.RK;
                        int i3 = y2 - this.RL;
                        if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                            z = false;
                        } else {
                            this.RO = ((i2 < 0 ? -1 : 1) * this.mTouchSlop) + this.RK;
                            z = true;
                        }
                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            this.RP = this.RL + ((i3 >= 0 ? 1 : -1) * this.mTouchSlop);
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                            break;
                        }
                    }
                    break;
                case 3:
                    gG();
                    break;
                case 5:
                    this.RJ = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.RO = x3;
                    this.RK = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.RP = y3;
                    this.RL = y3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            return this.mScrollState == 1;
        } else {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.Rq.size();
        for (int i = 0; i < size; i++) {
            this.Rq.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.Rw || this.Rx) {
            return false;
        }
        if (l(motionEvent)) {
            gG();
            return true;
        } else if (this.Rn != null) {
            boolean canScrollHorizontally = this.Rn.canScrollHorizontally();
            boolean canScrollVertically = this.Rn.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.Sl;
                this.Sl[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation(this.Sl[0], this.Sl[1]);
            switch (actionMasked) {
                case 0:
                    this.RJ = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.RO = x;
                    this.RK = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.RP = y;
                    this.RL = y;
                    int i = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i |= 2;
                    }
                    startNestedScroll(i);
                    break;
                case 1:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.RT);
                    float f = canScrollHorizontally ? -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.RJ) : 0.0f;
                    float f2 = canScrollVertically ? -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.RJ) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    gF();
                    z2 = true;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.RJ);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.RJ + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i2 = this.RO - x2;
                    int i3 = this.RP - y2;
                    if (dispatchNestedPreScroll(i2, i3, this.mScrollConsumed, this.mScrollOffset)) {
                        i2 -= this.mScrollConsumed[0];
                        i3 -= this.mScrollConsumed[1];
                        obtain.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
                        int[] iArr2 = this.Sl;
                        iArr2[0] = iArr2[0] + this.mScrollOffset[0];
                        int[] iArr3 = this.Sl;
                        iArr3[1] = iArr3[1] + this.mScrollOffset[1];
                    }
                    if (this.mScrollState != 1) {
                        if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                            z = false;
                        } else {
                            if (i2 > 0) {
                                i2 -= this.mTouchSlop;
                            } else {
                                i2 += this.mTouchSlop;
                            }
                            z = true;
                        }
                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            if (i3 > 0) {
                                i3 -= this.mTouchSlop;
                            } else {
                                i3 += this.mTouchSlop;
                            }
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                    if (this.mScrollState == 1) {
                        this.RO = x2 - this.mScrollOffset[0];
                        this.RP = y2 - this.mScrollOffset[1];
                        if (a(canScrollHorizontally ? i2 : 0, canScrollVertically ? i3 : 0, obtain)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        if (Rb) {
                            this.RZ.ab(i2, i3);
                            break;
                        }
                    }
                    break;
                case 3:
                    gG();
                    break;
                case 5:
                    this.RJ = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.RO = x3;
                    this.RK = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.RP = y3;
                    this.RL = y3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (!z2) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        } else {
            return false;
        }
    }

    private void gF() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll();
        gz();
    }

    private void gG() {
        gF();
        setScrollState(0);
    }

    private void m(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.RJ) {
            int i = actionIndex == 0 ? 1 : 0;
            this.RJ = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.RO = x;
            this.RK = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.RP = y;
            this.RL = y;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.Rn != null && !this.Rw && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            float f = this.Rn.canScrollVertically() ? -MotionEventCompat.getAxisValue(motionEvent, 9) : 0.0f;
            float axisValue = this.Rn.canScrollHorizontally() ? MotionEventCompat.getAxisValue(motionEvent, 10) : 0.0f;
            if (f != 0.0f || axisValue != 0.0f) {
                float scrollFactor = getScrollFactor();
                a((int) (axisValue * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.RU == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.RU = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                return 0.0f;
            }
        }
        return this.RU;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.Rn == null) {
            R(i, i2);
        } else if (this.Rn.SC) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.Rn.onMeasure(this.Re, this.Sa, i, i2);
            if (!z && this.Rm != null) {
                if (this.Sa.Th == 1) {
                    gS();
                }
                this.Rn.W(i, i2);
                this.Sa.Tq = true;
                gT();
                this.Rn.X(i, i2);
                if (this.Rn.gj()) {
                    this.Rn.W(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.Sa.Tq = true;
                    gT();
                    this.Rn.X(i, i2);
                }
            }
        } else if (this.Rs) {
            this.Rn.onMeasure(this.Re, this.Sa, i, i2);
        } else {
            if (this.Rz) {
                gx();
                gN();
                if (this.Sa.To) {
                    this.Sa.Tm = true;
                } else {
                    this.Rg.fE();
                    this.Sa.Tm = false;
                }
                this.Rz = false;
                J(false);
            }
            if (this.Rm != null) {
                this.Sa.mItemCount = this.Rm.getItemCount();
            } else {
                this.Sa.mItemCount = 0;
            }
            gx();
            this.Rn.onMeasure(this.Re, this.Sa, i, i2);
            J(false);
            this.Sa.Tm = false;
        }
    }

    void R(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            gE();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.RI != null) {
            this.RI.endAnimations();
            this.RI.a(null);
        }
        this.RI = itemAnimator;
        if (this.RI != null) {
            this.RI.a(this.Sf);
        }
    }

    void gH() {
        this.RC++;
    }

    void gI() {
        this.RC--;
        if (this.RC < 1) {
            this.RC = 0;
            gK();
            hb();
        }
    }

    boolean gJ() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void gK() {
        int i = this.Ry;
        this.Ry = 0;
        if (i != 0 && gJ()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.RC > 0;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
            this.Ry = (contentChangeTypes != 0 ? contentChangeTypes : 0) | this.Ry;
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.RI;
    }

    void gL() {
        if (!this.Sg && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.Sn);
            this.Sg = true;
        }
    }

    private boolean gM() {
        return this.RI != null && this.Rn.supportsPredictiveItemAnimations();
    }

    private void gN() {
        boolean z = true;
        if (this.RB) {
            this.Rg.reset();
            gZ();
            this.Rn.onItemsChanged(this);
        }
        if (gM()) {
            this.Rg.fB();
        } else {
            this.Rg.fE();
        }
        boolean z2 = this.Sd || this.Se;
        this.Sa.Tn = this.Rt && this.RI != null && (this.RB || z2 || this.Rn.SB) && (!this.RB || this.Rm.hasStableIds());
        State state = this.Sa;
        if (!this.Sa.Tn || !z2 || this.RB || !gM()) {
            z = false;
        }
        state.To = z;
    }

    void gO() {
        if (this.Rm == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.Rn == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.Sa.Tq = false;
            if (this.Sa.Th == 1) {
                gS();
                this.Rn.d(this);
                gT();
            } else if (this.Rg.fF() || this.Rn.getWidth() != getWidth() || this.Rn.getHeight() != getHeight()) {
                this.Rn.d(this);
                gT();
            } else {
                this.Rn.d(this);
            }
            gU();
        }
    }

    private void gP() {
        View focusedChild = (this.RV && hasFocus() && this.Rm != null) ? getFocusedChild() : null;
        ViewHolder findContainingViewHolder = focusedChild == null ? null : findContainingViewHolder(focusedChild);
        if (findContainingViewHolder == null) {
            gQ();
            return;
        }
        this.Sa.Ts = this.Rm.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        this.Sa.Tr = this.RB ? -1 : findContainingViewHolder.getAdapterPosition();
        this.Sa.Tt = ao(findContainingViewHolder.itemView);
    }

    private void gQ() {
        this.Sa.Ts = -1L;
        this.Sa.Tr = -1;
        this.Sa.Tt = -1;
    }

    private void gR() {
        View view;
        View focusedChild;
        if (this.RV && this.Rm != null && hasFocus()) {
            if (isFocused() || ((focusedChild = getFocusedChild()) != null && this.Rh.Z(focusedChild))) {
                ViewHolder viewHolder = null;
                if (this.Sa.Tr != -1) {
                    viewHolder = findViewHolderForAdapterPosition(this.Sa.Tr);
                }
                if (viewHolder == null && this.Sa.Ts != -1 && this.Rm.hasStableIds()) {
                    viewHolder = findViewHolderForItemId(this.Sa.Ts);
                }
                if (viewHolder != null && !viewHolder.itemView.hasFocus() && viewHolder.itemView.hasFocusable()) {
                    View view2 = viewHolder.itemView;
                    if (this.Sa.Tt == -1 || (view = viewHolder.itemView.findViewById(this.Sa.Tt)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private int ao(View view) {
        int i;
        int id = view.getId();
        while (true) {
            i = id;
            View view2 = view;
            if (view2.isFocused() || !(view2 instanceof ViewGroup) || !view2.hasFocus()) {
                break;
            }
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != -1 ? view.getId() : i;
        }
        return i;
    }

    private void gS() {
        boolean z = true;
        this.Sa.by(1);
        this.Sa.Tq = false;
        gx();
        this.Ri.clear();
        gH();
        gP();
        gN();
        State state = this.Sa;
        state.Tp = (this.Sa.Tn && this.Se) ? false : false;
        this.Se = false;
        this.Sd = false;
        this.Sa.Tm = this.Sa.To;
        this.Sa.mItemCount = this.Rm.getItemCount();
        g(this.Sj);
        if (this.Sa.Tn) {
            int childCount = this.Rh.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder ap = ap(this.Rh.getChildAt(i));
                if (!ap.shouldIgnore() && (!ap.isInvalid() || this.Rm.hasStableIds())) {
                    this.Ri.b(ap, this.RI.recordPreLayoutInformation(this.Sa, ap, ItemAnimator.h(ap), ap.getUnmodifiedPayloads()));
                    if (this.Sa.Tp && ap.isUpdated() && !ap.isRemoved() && !ap.shouldIgnore() && !ap.isInvalid()) {
                        this.Ri.a(e(ap), ap);
                    }
                }
            }
        }
        if (this.Sa.To) {
            gW();
            boolean z2 = this.Sa.Tl;
            this.Sa.Tl = false;
            this.Rn.onLayoutChildren(this.Re, this.Sa);
            this.Sa.Tl = z2;
            for (int i2 = 0; i2 < this.Rh.getChildCount(); i2++) {
                ViewHolder ap2 = ap(this.Rh.getChildAt(i2));
                if (!ap2.shouldIgnore() && !this.Ri.r(ap2)) {
                    int h = ItemAnimator.h(ap2);
                    boolean hasAnyOfTheFlags = ap2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        h |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.RI.recordPreLayoutInformation(this.Sa, ap2, h, ap2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        a(ap2, recordPreLayoutInformation);
                    } else {
                        this.Ri.c(ap2, recordPreLayoutInformation);
                    }
                }
            }
            gX();
        } else {
            gX();
        }
        gI();
        J(false);
        this.Sa.Th = 2;
    }

    private void gT() {
        gx();
        gH();
        this.Sa.by(6);
        this.Rg.fE();
        this.Sa.mItemCount = this.Rm.getItemCount();
        this.Sa.Tk = 0;
        this.Sa.Tm = false;
        this.Rn.onLayoutChildren(this.Re, this.Sa);
        this.Sa.Tl = false;
        this.Rf = null;
        this.Sa.Tn = this.Sa.Tn && this.RI != null;
        this.Sa.Th = 4;
        gI();
        J(false);
    }

    private void gU() {
        this.Sa.by(4);
        gx();
        gH();
        this.Sa.Th = 1;
        if (this.Sa.Tn) {
            for (int childCount = this.Rh.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder ap = ap(this.Rh.getChildAt(childCount));
                if (!ap.shouldIgnore()) {
                    long e2 = e(ap);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.RI.recordPostLayoutInformation(this.Sa, ap);
                    ViewHolder n = this.Ri.n(e2);
                    if (n != null && !n.shouldIgnore()) {
                        boolean o = this.Ri.o(n);
                        boolean o2 = this.Ri.o(ap);
                        if (o && n == ap) {
                            this.Ri.d(ap, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo p = this.Ri.p(n);
                            this.Ri.d(ap, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo q = this.Ri.q(ap);
                            if (p == null) {
                                a(e2, ap, n);
                            } else {
                                a(n, ap, p, q, o, o2);
                            }
                        }
                    } else {
                        this.Ri.d(ap, recordPostLayoutInformation);
                    }
                }
            }
            this.Ri.a(this.Sp);
        }
        this.Rn.b(this.Re);
        this.Sa.Tj = this.Sa.mItemCount;
        this.RB = false;
        this.Sa.Tn = false;
        this.Sa.To = false;
        this.Rn.SB = false;
        if (this.Re.SR != null) {
            this.Re.SR.clear();
        }
        this.Rn.onLayoutCompleted(this.Sa);
        gI();
        J(false);
        this.Ri.clear();
        if (S(this.Sj[0], this.Sj[1])) {
            V(0, 0);
        }
        gR();
        gQ();
    }

    private void a(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.Rh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder ap = ap(this.Rh.getChildAt(i));
            if (ap != viewHolder && e(ap) == j) {
                if (this.Rm != null && this.Rm.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + ap + " \n View Holder 2:" + viewHolder);
                } else {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + ap + " \n View Holder 2:" + viewHolder);
                }
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder);
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.Sa.Tp && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.Ri.a(e(viewHolder), viewHolder);
        }
        this.Ri.b(viewHolder, itemHolderInfo);
    }

    private void g(int[] iArr) {
        int childCount = this.Rh.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            ViewHolder ap = ap(this.Rh.getChildAt(i3));
            if (!ap.shouldIgnore()) {
                int layoutPosition = ap.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
            i3++;
            i = i;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean S(int i, int i2) {
        g(this.Sj);
        return (this.Sj[0] == i && this.Sj[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        ViewHolder ap = ap(view);
        if (ap != null) {
            if (ap.isTmpDetached()) {
                ap.clearTmpDetachFlag();
            } else if (!ap.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + ap);
            }
        }
        ar(view);
        super.removeDetachedView(view, z);
    }

    long e(ViewHolder viewHolder) {
        return this.Rm.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.RI.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            gL();
        }
    }

    void b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        d(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.RI.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            gL();
        }
    }

    private void a(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            d(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                d(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            d(viewHolder);
            this.Re.m(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.RI.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            gL();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        gO();
        TraceCompat.endSection();
        this.Rt = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.Ru == 0 && !this.Rw) {
            super.requestLayout();
        } else {
            this.Rv = true;
        }
    }

    void gV() {
        int fT = this.Rh.fT();
        for (int i = 0; i < fT; i++) {
            ((LayoutParams) this.Rh.bi(i).getLayoutParams()).SJ = true;
        }
        this.Re.gV();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        super.draw(canvas);
        int size = this.Rp.size();
        for (int i = 0; i < size; i++) {
            this.Rp.get(i).onDrawOver(canvas, this, this.Sa);
        }
        if (this.RE == null || this.RE.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.Rj ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate(paddingBottom + (-getHeight()), 0.0f);
            z = this.RE != null && this.RE.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.RF != null && !this.RF.isFinished()) {
            int save2 = canvas.save();
            if (this.Rj) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.RF != null && this.RF.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.RG != null && !this.RG.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.Rj ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.RG != null && this.RG.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.RH != null && !this.RH.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.Rj) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.RH != null && this.RH.draw(canvas)) {
                z3 = true;
            }
            z |= z3;
            canvas.restoreToCount(save4);
        }
        if (z || this.RI == null || this.Rp.size() <= 0 || !this.RI.isRunning()) {
            z2 = z;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.Rp.size();
        for (int i = 0; i < size; i++) {
            this.Rp.get(i).onDraw(canvas, this, this.Sa);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.Rn.checkLayoutParams((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.Rn == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Rn.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.Rn == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Rn.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.Rn == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Rn.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        return this.RI != null && this.RI.isRunning();
    }

    void gW() {
        int fT = this.Rh.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Rh.bi(i));
            if (!ap.shouldIgnore()) {
                ap.saveOldPosition();
            }
        }
    }

    void gX() {
        int fT = this.Rh.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Rh.bi(i));
            if (!ap.shouldIgnore()) {
                ap.clearOldPosition();
            }
        }
        this.Re.gX();
    }

    void T(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int fT = this.Rh.fT();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < fT; i6++) {
            ViewHolder ap = ap(this.Rh.bi(i6));
            if (ap != null && ap.mPosition >= i5 && ap.mPosition <= i4) {
                if (ap.mPosition == i) {
                    ap.offsetPosition(i2 - i, false);
                } else {
                    ap.offsetPosition(i3, false);
                }
                this.Sa.Tl = true;
            }
        }
        this.Re.T(i, i2);
        requestLayout();
    }

    void U(int i, int i2) {
        int fT = this.Rh.fT();
        for (int i3 = 0; i3 < fT; i3++) {
            ViewHolder ap = ap(this.Rh.bi(i3));
            if (ap != null && !ap.shouldIgnore() && ap.mPosition >= i) {
                ap.offsetPosition(i2, false);
                this.Sa.Tl = true;
            }
        }
        this.Re.U(i, i2);
        requestLayout();
    }

    void b(int i, int i2, boolean z) {
        int i3 = i + i2;
        int fT = this.Rh.fT();
        for (int i4 = 0; i4 < fT; i4++) {
            ViewHolder ap = ap(this.Rh.bi(i4));
            if (ap != null && !ap.shouldIgnore()) {
                if (ap.mPosition >= i3) {
                    ap.offsetPosition(-i2, z);
                    this.Sa.Tl = true;
                } else if (ap.mPosition >= i) {
                    ap.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.Sa.Tl = true;
                }
            }
        }
        this.Re.b(i, i2, z);
        requestLayout();
    }

    void f(int i, int i2, Object obj) {
        int fT = this.Rh.fT();
        int i3 = i + i2;
        for (int i4 = 0; i4 < fT; i4++) {
            View bi = this.Rh.bi(i4);
            ViewHolder ap = ap(bi);
            if (ap != null && !ap.shouldIgnore() && ap.mPosition >= i && ap.mPosition < i3) {
                ap.addFlags(2);
                ap.addChangePayload(obj);
                ((LayoutParams) bi.getLayoutParams()).SJ = true;
            }
        }
        this.Re.Y(i, i2);
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        return this.RI == null || this.RI.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    void gY() {
        if (!this.RB) {
            this.RB = true;
            int fT = this.Rh.fT();
            for (int i = 0; i < fT; i++) {
                ViewHolder ap = ap(this.Rh.bi(i));
                if (ap != null && !ap.shouldIgnore()) {
                    ap.addFlags(512);
                }
            }
            this.Re.hk();
        }
    }

    void gZ() {
        int fT = this.Rh.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Rh.bi(i));
            if (ap != null && !ap.shouldIgnore()) {
                ap.addFlags(6);
            }
        }
        gV();
        this.Re.gZ();
    }

    public void invalidateItemDecorations() {
        if (this.Rp.size() != 0) {
            if (this.Rn != null) {
                this.Rn.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            gV();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.RV;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.RV = z;
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return ap(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = (View) parent;
            view2 = view3;
            parent = view3.getParent();
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    static ViewHolder ap(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).SH;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder ap = ap(view);
        if (ap != null) {
            return ap.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder ap = ap(view);
        if (ap != null) {
            return ap.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        ViewHolder ap;
        if (this.Rm == null || !this.Rm.hasStableIds() || (ap = ap(view)) == null) {
            return -1L;
        }
        return ap.getItemId();
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return n(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return n(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        if (this.RB) {
            return null;
        }
        int fT = this.Rh.fT();
        int i2 = 0;
        ViewHolder viewHolder = null;
        while (i2 < fT) {
            ViewHolder ap = ap(this.Rh.bi(i2));
            if (ap == null || ap.isRemoved() || f(ap) != i) {
                ap = viewHolder;
            } else if (!this.Rh.Z(ap.itemView)) {
                return ap;
            }
            i2++;
            viewHolder = ap;
        }
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ViewHolder n(int i, boolean z) {
        int fT = this.Rh.fT();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < fT; i2++) {
            ViewHolder ap = ap(this.Rh.bi(i2));
            if (ap != null && !ap.isRemoved()) {
                if (z) {
                    if (ap.mPosition != i) {
                        continue;
                    }
                    if (this.Rh.Z(ap.itemView)) {
                        return ap;
                    }
                    viewHolder = ap;
                } else {
                    if (ap.getLayoutPosition() != i) {
                        continue;
                    }
                    if (this.Rh.Z(ap.itemView)) {
                    }
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        if (this.Rm == null || !this.Rm.hasStableIds()) {
            return null;
        }
        int fT = this.Rh.fT();
        int i = 0;
        ViewHolder viewHolder = null;
        while (i < fT) {
            ViewHolder ap = ap(this.Rh.bi(i));
            if (ap == null || ap.isRemoved() || ap.getItemId() != j) {
                ap = viewHolder;
            } else if (!this.Rh.Z(ap.itemView)) {
                return ap;
            }
            i++;
            viewHolder = ap;
        }
        return viewHolder;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.Rh.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Rh.getChildAt(childCount);
            float translationX = ViewCompat.getTranslationX(childAt);
            float translationY = ViewCompat.getTranslationY(childAt);
            if (f >= childAt.getLeft() + translationX && f <= translationX + childAt.getRight() && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int childCount = this.Rh.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.Rh.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void offsetChildrenHorizontal(int i) {
        int childCount = this.Rh.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.Rh.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        d(view, rect);
    }

    static void d(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.Pc;
        int left = (view.getLeft() - rect2.left) - layoutParams.leftMargin;
        int top = (view.getTop() - rect2.top) - layoutParams.topMargin;
        int right = view.getRight() + rect2.right + layoutParams.rightMargin;
        int bottom = view.getBottom();
        rect.set(left, top, right, layoutParams.bottomMargin + rect2.bottom + bottom);
    }

    Rect aq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.SJ) {
            return layoutParams.Pc;
        }
        if (this.Sa.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.Pc;
        }
        Rect rect = layoutParams.Pc;
        rect.set(0, 0, 0, 0);
        int size = this.Rp.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.Rp.get(i).getItemOffsets(this.mTempRect, view, this, this.Sa);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.SJ = false;
        return rect;
    }

    public void onScrolled(int i, int i2) {
    }

    void V(int i, int i2) {
        this.RD++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.Sb != null) {
            this.Sb.onScrolled(this, i, i2);
        }
        if (this.Sc != null) {
            for (int size = this.Sc.size() - 1; size >= 0; size--) {
                this.Sc.get(size).onScrolled(this, i, i2);
            }
        }
        this.RD--;
    }

    public void onScrollStateChanged(int i) {
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.Rn != null) {
            this.Rn.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (this.Sb != null) {
            this.Sb.onScrollStateChanged(this, i);
        }
        if (this.Sc != null) {
            for (int size = this.Sc.size() - 1; size >= 0; size--) {
                this.Sc.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.Rt || this.RB || this.Rg.fD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        private int Tc;
        private int Td;
        long Ty;
        int[] Tz;

        e() {
        }

        public void ab(int i, int i2) {
            if (RecyclerView.Rb && RecyclerView.this.Rm != null && RecyclerView.this.Rn != null && RecyclerView.this.Rn.ge() > 0) {
                this.Tc = i;
                this.Td = i2;
                this.Ty = System.nanoTime();
                RecyclerView.this.post(this);
            }
        }

        public boolean bz(int i) {
            if (this.Tz != null) {
                for (int i2 = 0; i2 < this.Tz.length; i2++) {
                    if (this.Tz[i2] == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public void hq() {
            if (this.Tz != null) {
                Arrays.fill(this.Tz, -1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4526=4] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("RV Prefetch");
                int ge = RecyclerView.this.Rn.ge();
                if (RecyclerView.this.Rm == null || RecyclerView.this.Rn == null || !RecyclerView.this.Rn.isItemPrefetchEnabled() || ge < 1 || RecyclerView.this.hasPendingAdapterUpdates()) {
                    return;
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(RecyclerView.this.getDrawingTime());
                if (nanos == 0 || RecyclerView.RY == 0) {
                    return;
                }
                long nanoTime = System.nanoTime();
                long j = nanos + RecyclerView.RY;
                if (nanoTime - this.Ty > RecyclerView.RY || j - nanoTime < RecyclerView.RX) {
                    return;
                }
                if (this.Tz == null || this.Tz.length < ge) {
                    this.Tz = new int[ge];
                }
                Arrays.fill(this.Tz, -1);
                RecyclerView.this.Re.c(this.Tz, RecyclerView.this.Rn.a(this.Tc, this.Td, RecyclerView.this.Sa, this.Tz));
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private int Tu;
        private int Tv;
        private ScrollerCompat mScroller;
        private Interpolator mInterpolator = RecyclerView.So;
        private boolean Tw = false;
        private boolean Tx = false;

        public d() {
            this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.So);
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0151  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            if (RecyclerView.this.Rn == null) {
                stop();
                return;
            }
            hn();
            RecyclerView.this.gv();
            ScrollerCompat scrollerCompat = this.mScroller;
            SmoothScroller smoothScroller = RecyclerView.this.Rn.SA;
            if (scrollerCompat.computeScrollOffset()) {
                int currX = scrollerCompat.getCurrX();
                int currY = scrollerCompat.getCurrY();
                int i5 = currX - this.Tu;
                int i6 = currY - this.Tv;
                int i7 = 0;
                int i8 = 0;
                this.Tu = currX;
                this.Tv = currY;
                int i9 = 0;
                int i10 = 0;
                if (RecyclerView.this.Rm != null) {
                    RecyclerView.this.gx();
                    RecyclerView.this.gH();
                    TraceCompat.beginSection("RV Scroll");
                    if (i5 != 0) {
                        i7 = RecyclerView.this.Rn.scrollHorizontallyBy(i5, RecyclerView.this.Re, RecyclerView.this.Sa);
                        i9 = i5 - i7;
                    }
                    if (i6 != 0) {
                        i8 = RecyclerView.this.Rn.scrollVerticallyBy(i6, RecyclerView.this.Re, RecyclerView.this.Sa);
                        i10 = i6 - i8;
                    }
                    TraceCompat.endSection();
                    RecyclerView.this.ha();
                    RecyclerView.this.gI();
                    RecyclerView.this.J(false);
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.Sa.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                            int i11 = i9;
                            i = i8;
                            i2 = i11;
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.Z(i5 - i9, i6 - i10);
                            int i12 = i9;
                            i = i8;
                            i2 = i12;
                        } else {
                            smoothScroller.Z(i5 - i9, i6 - i10);
                        }
                        if (!RecyclerView.this.Rp.isEmpty()) {
                            RecyclerView.this.invalidate();
                        }
                        if (RecyclerView.this.getOverScrollMode() != 2) {
                            RecyclerView.this.P(i5, i6);
                        }
                        if (i2 == 0 || i10 != 0) {
                            int currVelocity = (int) scrollerCompat.getCurrVelocity();
                            if (i2 != currX) {
                                i3 = 0;
                            } else {
                                if (i2 < 0) {
                                    i4 = -currVelocity;
                                } else {
                                    i4 = i2 > 0 ? currVelocity : 0;
                                }
                                i3 = i4;
                            }
                            if (i10 != currY) {
                                currVelocity = 0;
                            } else if (i10 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i10 <= 0) {
                                currVelocity = 0;
                            }
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                                RecyclerView.this.Q(i3, currVelocity);
                            }
                            if ((i3 == 0 || i2 == currX || scrollerCompat.getFinalX() == 0) && (currVelocity != 0 || i10 == currY || scrollerCompat.getFinalY() == 0)) {
                                scrollerCompat.abortAnimation();
                            }
                        }
                        if (i7 == 0 || i != 0) {
                            RecyclerView.this.V(i7, i);
                        }
                        if (!RecyclerView.this.awakenScrollBars()) {
                            RecyclerView.this.invalidate();
                        }
                        boolean z = (i5 != 0 && i6 == 0) || (i5 == 0 && RecyclerView.this.Rn.canScrollHorizontally() && i7 == i5) || (i6 == 0 && RecyclerView.this.Rn.canScrollVertically() && i == i6);
                        if (!scrollerCompat.isFinished() || !z) {
                            RecyclerView.this.setScrollState(0);
                            if (RecyclerView.Rb) {
                                RecyclerView.this.RZ.hq();
                            }
                        } else {
                            hp();
                            if (RecyclerView.Rb) {
                                RecyclerView.this.RZ.ab(i5, i6);
                            }
                        }
                    }
                }
                int i13 = i9;
                i = i8;
                i2 = i13;
                if (!RecyclerView.this.Rp.isEmpty()) {
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                }
                if (i2 == 0) {
                }
                int currVelocity2 = (int) scrollerCompat.getCurrVelocity();
                if (i2 != currX) {
                }
                if (i10 != currY) {
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                }
                if (i3 == 0) {
                }
                scrollerCompat.abortAnimation();
                if (i7 == 0) {
                }
                RecyclerView.this.V(i7, i);
                if (!RecyclerView.this.awakenScrollBars()) {
                }
                if (i6 == 0) {
                }
                if (i5 != 0) {
                }
                if (!scrollerCompat.isFinished()) {
                }
                RecyclerView.this.setScrollState(0);
                if (RecyclerView.Rb) {
                }
            }
            if (smoothScroller != null) {
                if (smoothScroller.isPendingInitialRun()) {
                    smoothScroller.Z(0, 0);
                }
                if (!this.Tx) {
                    smoothScroller.stop();
                }
            }
            ho();
        }

        private void hn() {
            this.Tx = false;
            this.Tw = true;
        }

        private void ho() {
            this.Tw = false;
            if (this.Tx) {
                hp();
            }
        }

        void hp() {
            if (this.Tw) {
                this.Tx = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void aa(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.Tv = 0;
            this.Tu = 0;
            this.mScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            hp();
        }

        public void smoothScrollBy(int i, int i2) {
            h(i, i2, 0, 0);
        }

        public void h(int i, int i2, int i3, int i4) {
            i(i, i2, i(i, i2, i3, i4));
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
        }

        private int i(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / width)) * i6) + i6;
            if (sqrt > 0) {
                i5 = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / sqrt)) * 4;
            } else {
                i5 = (int) ((((z ? abs : abs2) / width) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void i(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.So);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.Tv = 0;
            this.Tu = 0;
            this.mScroller.startScroll(0, 0, i, i2, i3);
            hp();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }
    }

    void ha() {
        int childCount = this.Rh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Rh.getChildAt(i);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends AdapterDataObserver {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rm.hasStableIds()) {
                RecyclerView.this.Sa.Tl = true;
                RecyclerView.this.gY();
            } else {
                RecyclerView.this.Sa.Tl = true;
                RecyclerView.this.gY();
            }
            if (!RecyclerView.this.Rg.fD()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rg.d(i, i2, obj)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rg.z(i, i2)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rg.A(i, i2)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rg.g(i, i2, i3)) {
                hl();
            }
        }

        void hl() {
            if (RecyclerView.Ra && RecyclerView.this.Rs && RecyclerView.this.mIsAttached) {
                ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.Rk);
                return;
            }
            RecyclerView.this.Rz = true;
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class RecycledViewPool {
        private SparseArray<ArrayList<ViewHolder>> SL = new SparseArray<>();
        private SparseIntArray SM = new SparseIntArray();
        private int SO = 0;

        public void clear() {
            this.SL.clear();
        }

        public void setMaxRecycledViews(int i, int i2) {
            this.SM.put(i, i2);
            ArrayList<ViewHolder> arrayList = this.SL.get(i);
            if (arrayList != null) {
                while (arrayList.size() > i2) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        public ViewHolder getRecycledView(int i) {
            ArrayList<ViewHolder> arrayList = this.SL.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            ViewHolder viewHolder = arrayList.get(size);
            arrayList.remove(size);
            return viewHolder;
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> bs = bs(itemViewType);
            if (this.SM.get(itemViewType) > bs.size()) {
                viewHolder.resetInternal();
                bs.add(viewHolder);
            }
        }

        void a(Adapter adapter) {
            this.SO++;
        }

        void detach() {
            this.SO--;
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                detach();
            }
            if (!z && this.SO == 0) {
                clear();
            }
            if (adapter2 != null) {
                a(adapter2);
            }
        }

        private ArrayList<ViewHolder> bs(int i) {
            ArrayList<ViewHolder> arrayList = this.SL.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.SL.put(i, arrayList);
                if (this.SM.indexOfKey(i) < 0) {
                    this.SM.put(i, 5);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public final class Recycler {
        final ArrayList<ViewHolder> SQ = new ArrayList<>();
        ArrayList<ViewHolder> SR = null;
        final ArrayList<ViewHolder> SS = new ArrayList<>();
        private final List<ViewHolder> ST = Collections.unmodifiableList(this.SQ);
        private int SU = 2;
        int SV = 2;
        private RecycledViewPool SW;
        private ViewCacheExtension SX;

        public Recycler() {
        }

        public void clear() {
            this.SQ.clear();
            hh();
        }

        public void setViewCacheSize(int i) {
            this.SU = i;
            hg();
        }

        void hg() {
            int i = 0;
            if (RecyclerView.this.Rn != null && RecyclerView.Rb && RecyclerView.this.Rn.isItemPrefetchEnabled()) {
                i = RecyclerView.this.Rn.ge();
            }
            this.SV = i + this.SU;
            for (int size = this.SS.size() - 1; size >= 0 && this.SS.size() > this.SV; size--) {
                bt(size);
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.ST;
        }

        boolean i(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.Sa.isPreLayout();
            }
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.this.Rm.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
            }
            if (RecyclerView.this.Sa.isPreLayout() || RecyclerView.this.Rm.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.Rm.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.Rm.getItemId(viewHolder.mPosition);
            }
            return false;
        }

        public void bindViewToPosition(View view, int i) {
            LayoutParams layoutParams;
            ViewHolder ap = RecyclerView.ap(view);
            if (ap == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int bb = RecyclerView.this.Rg.bb(i);
            if (bb < 0 || bb >= RecyclerView.this.Rm.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bb + ").state:" + RecyclerView.this.Sa.getItemCount());
            }
            ap.mOwnerRecyclerView = RecyclerView.this;
            RecyclerView.this.Rm.bindViewHolder(ap, bb);
            at(view);
            if (RecyclerView.this.Sa.isPreLayout()) {
                ap.mPreLayoutPosition = i;
            }
            ViewGroup.LayoutParams layoutParams2 = ap.itemView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                ap.itemView.setLayoutParams(layoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                ap.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.SJ = true;
            layoutParams.SH = ap;
            layoutParams.SK = ap.itemView.getParent() == null;
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.Sa.getItemCount()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.Sa.getItemCount());
            }
            return !RecyclerView.this.Sa.isPreLayout() ? i : RecyclerView.this.Rg.bb(i);
        }

        public View getViewForPosition(int i) {
            return o(i, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01b3  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        View o(int i, boolean z) {
            ViewHolder viewHolder;
            boolean z2;
            boolean z3;
            ViewHolder viewHolder2;
            boolean z4;
            boolean z5;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            View viewForPositionAndType;
            boolean z6 = true;
            if (i < 0 || i >= RecyclerView.this.Sa.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.Sa.getItemCount());
            }
            if (RecyclerView.this.Sa.isPreLayout()) {
                ViewHolder bv = bv(i);
                z2 = bv != null;
                viewHolder = bv;
            } else {
                viewHolder = null;
                z2 = false;
            }
            if (viewHolder != null || (viewHolder = c(i, -1, z)) == null) {
                z3 = z2;
            } else if (i(viewHolder)) {
                z3 = true;
            } else {
                if (!z) {
                    viewHolder.addFlags(4);
                    if (viewHolder.isScrap()) {
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        viewHolder.unScrap();
                    } else if (viewHolder.wasReturnedFromScrap()) {
                        viewHolder.clearReturnedFromScrapFlag();
                    }
                    k(viewHolder);
                }
                viewHolder = null;
                z3 = z2;
            }
            if (viewHolder == null) {
                int bb = RecyclerView.this.Rg.bb(i);
                if (bb < 0 || bb >= RecyclerView.this.Rm.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bb + ").state:" + RecyclerView.this.Sa.getItemCount());
                }
                int itemViewType = RecyclerView.this.Rm.getItemViewType(bb);
                if (RecyclerView.this.Rm.hasStableIds() && (viewHolder = a(RecyclerView.this.Rm.getItemId(bb), itemViewType, z)) != null) {
                    viewHolder.mPosition = bb;
                    z3 = true;
                }
                if (viewHolder == null && this.SX != null && (viewForPositionAndType = this.SX.getViewForPositionAndType(this, i, itemViewType)) != null) {
                    viewHolder = RecyclerView.this.getChildViewHolder(viewForPositionAndType);
                    if (viewHolder == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    }
                    if (viewHolder.shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (viewHolder == null && (viewHolder = getRecycledViewPool().getRecycledView(itemViewType)) != null) {
                    viewHolder.resetInternal();
                    if (RecyclerView.QY) {
                        j(viewHolder);
                    }
                }
                if (viewHolder == null) {
                    viewHolder2 = RecyclerView.this.Rm.createViewHolder(RecyclerView.this, itemViewType);
                    z4 = z3;
                    if (z4 && !RecyclerView.this.Sa.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                        viewHolder2.setFlags(0, 8192);
                        if (RecyclerView.this.Sa.Tn) {
                            RecyclerView.this.a(viewHolder2, RecyclerView.this.RI.recordPreLayoutInformation(RecyclerView.this.Sa, viewHolder2, ItemAnimator.h(viewHolder2) | 4096, viewHolder2.getUnmodifiedPayloads()));
                        }
                    }
                    if (!RecyclerView.this.Sa.isPreLayout() && viewHolder2.isBound()) {
                        viewHolder2.mPreLayoutPosition = i;
                        z5 = false;
                    } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                        int bb2 = RecyclerView.this.Rg.bb(i);
                        viewHolder2.mOwnerRecyclerView = RecyclerView.this;
                        RecyclerView.this.Rm.bindViewHolder(viewHolder2, bb2);
                        at(viewHolder2.itemView);
                        if (RecyclerView.this.Sa.isPreLayout()) {
                            viewHolder2.mPreLayoutPosition = i;
                        }
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    layoutParams = viewHolder2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        viewHolder2.itemView.setLayoutParams(layoutParams2);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                        viewHolder2.itemView.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams2 = (LayoutParams) layoutParams;
                    }
                    layoutParams2.SH = viewHolder2;
                    if (z4 || !z5) {
                        z6 = false;
                    }
                    layoutParams2.SK = z6;
                    return viewHolder2.itemView;
                }
            }
            viewHolder2 = viewHolder;
            z4 = z3;
            if (z4) {
                viewHolder2.setFlags(0, 8192);
                if (RecyclerView.this.Sa.Tn) {
                }
            }
            if (!RecyclerView.this.Sa.isPreLayout()) {
            }
            if (viewHolder2.isBound()) {
            }
            int bb22 = RecyclerView.this.Rg.bb(i);
            viewHolder2.mOwnerRecyclerView = RecyclerView.this;
            RecyclerView.this.Rm.bindViewHolder(viewHolder2, bb22);
            at(viewHolder2.itemView);
            if (RecyclerView.this.Sa.isPreLayout()) {
            }
            z5 = true;
            layoutParams = viewHolder2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            layoutParams2.SH = viewHolder2;
            if (z4) {
            }
            z6 = false;
            layoutParams2.SK = z6;
            return viewHolder2.itemView;
        }

        private void at(View view) {
            if (RecyclerView.this.gJ()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.Sh.getItemDelegate());
                }
            }
        }

        private void j(ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof ViewGroup) {
                d((ViewGroup) viewHolder.itemView, false);
            }
        }

        private void d(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    d((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void recycleView(View view) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (ap.isScrap()) {
                ap.unScrap();
            } else if (ap.wasReturnedFromScrap()) {
                ap.clearReturnedFromScrapFlag();
            }
            k(ap);
        }

        void hh() {
            for (int size = this.SS.size() - 1; size >= 0; size--) {
                bt(size);
            }
            this.SS.clear();
            if (RecyclerView.Rb) {
                RecyclerView.this.RZ.hq();
            }
        }

        void bt(int i) {
            l(this.SS.get(i));
            this.SS.remove(i);
        }

        void k(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = false;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + viewHolder.isScrap() + " isAttached:" + (viewHolder.itemView.getParent() != null));
            } else if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder);
            } else {
                if (viewHolder.shouldIgnore()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                }
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.Rm != null && doesTransientStatePreventRecycling && RecyclerView.this.Rm.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.SV <= 0 || viewHolder.hasAnyOfTheFlags(14)) {
                        z = false;
                    } else {
                        int size = this.SS.size();
                        if (size >= this.SV && size > 0) {
                            bt(0);
                            size--;
                        }
                        if (RecyclerView.Rb && size > 0 && !RecyclerView.this.RZ.bz(viewHolder.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.RZ.bz(this.SS.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.SS.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        l(viewHolder);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.Ri.u(viewHolder);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    viewHolder.mOwnerRecyclerView = null;
                }
            }
        }

        void l(ViewHolder viewHolder) {
            ViewCompat.setAccessibilityDelegate(viewHolder.itemView, null);
            n(viewHolder);
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        void au(View view) {
            ViewHolder ap = RecyclerView.ap(view);
            ap.mScrapContainer = null;
            ap.mInChangeScrap = false;
            ap.clearReturnedFromScrapFlag();
            k(ap);
        }

        void av(View view) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap.hasAnyOfTheFlags(12) || !ap.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(ap)) {
                if (ap.isInvalid() && !ap.isRemoved() && !RecyclerView.this.Rm.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                }
                ap.setScrapContainer(this, false);
                this.SQ.add(ap);
                return;
            }
            if (this.SR == null) {
                this.SR = new ArrayList<>();
            }
            ap.setScrapContainer(this, true);
            this.SR.add(ap);
        }

        void m(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.SR.remove(viewHolder);
            } else {
                this.SQ.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        int hi() {
            return this.SQ.size();
        }

        View bu(int i) {
            return this.SQ.get(i).itemView;
        }

        void hj() {
            this.SQ.clear();
            if (this.SR != null) {
                this.SR.clear();
            }
        }

        ViewHolder bv(int i) {
            int size;
            int bb;
            if (this.SR == null || (size = this.SR.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.SR.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (RecyclerView.this.Rm.hasStableIds() && (bb = RecyclerView.this.Rg.bb(i)) > 0 && bb < RecyclerView.this.Rm.getItemCount()) {
                long itemId = RecyclerView.this.Rm.getItemId(bb);
                for (int i3 = 0; i3 < size; i3++) {
                    ViewHolder viewHolder2 = this.SR.get(i3);
                    if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                        viewHolder2.addFlags(32);
                        return viewHolder2;
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        ViewHolder c(int i, int i2, boolean z) {
            int size;
            View F;
            int size2 = this.SQ.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ViewHolder viewHolder = this.SQ.get(i3);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.Sa.Tm || !viewHolder.isRemoved())) {
                    if (i2 != -1 && viewHolder.getItemViewType() != i2) {
                        Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has wrong view type! (found " + viewHolder.getItemViewType() + " but expected " + i2 + ")");
                        if (z && (F = RecyclerView.this.Rh.F(i, i2)) != null) {
                            ViewHolder ap = RecyclerView.ap(F);
                            RecyclerView.this.Rh.ab(F);
                            int indexOfChild = RecyclerView.this.Rh.indexOfChild(F);
                            if (indexOfChild == -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ap);
                            }
                            RecyclerView.this.Rh.detachViewFromParent(indexOfChild);
                            av(F);
                            ap.addFlags(8224);
                            return ap;
                        }
                        size = this.SS.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ViewHolder viewHolder2 = this.SS.get(i4);
                            if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i) {
                                if (!z) {
                                    this.SS.remove(i4);
                                    return viewHolder2;
                                } else {
                                    return viewHolder2;
                                }
                            }
                        }
                        return null;
                    } else {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
            }
            if (z) {
            }
            size = this.SS.size();
            while (i4 < size) {
            }
            return null;
        }

        ViewHolder a(long j, int i, boolean z) {
            for (int size = this.SQ.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SQ.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.Sa.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                            return viewHolder;
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.SQ.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        au(viewHolder.itemView);
                    }
                }
            }
            for (int size2 = this.SS.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.SS.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.SS.remove(size2);
                            return viewHolder2;
                        }
                        return viewHolder2;
                    } else if (!z) {
                        bt(size2);
                    }
                }
            }
            return null;
        }

        void n(ViewHolder viewHolder) {
            if (RecyclerView.this.Ro != null) {
                RecyclerView.this.Ro.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.Rm != null) {
                RecyclerView.this.Rm.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.Sa != null) {
                RecyclerView.this.Ri.u(viewHolder);
            }
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            getRecycledViewPool().a(adapter, adapter2, z);
        }

        void T(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.SS.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.SS.get(i6);
                if (viewHolder != null && viewHolder.mPosition >= i5 && viewHolder.mPosition <= i4) {
                    if (viewHolder.mPosition == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i3, false);
                    }
                }
            }
        }

        void U(int i, int i2) {
            int size = this.SS.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.SS.get(i3);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        void b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.SS.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SS.get(size);
                if (viewHolder != null) {
                    if (viewHolder.mPosition >= i3) {
                        viewHolder.offsetPosition(-i2, z);
                    } else if (viewHolder.mPosition >= i) {
                        viewHolder.addFlags(8);
                        bt(size);
                    }
                }
            }
        }

        void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.SX = viewCacheExtension;
        }

        void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            if (this.SW != null) {
                this.SW.detach();
            }
            this.SW = recycledViewPool;
            if (recycledViewPool != null) {
                this.SW.a(RecyclerView.this.getAdapter());
            }
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.SW == null) {
                this.SW = new RecycledViewPool();
            }
            return this.SW;
        }

        void Y(int i, int i2) {
            int layoutPosition;
            int i3 = i + i2;
            for (int size = this.SS.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SS.get(size);
                if (viewHolder != null && (layoutPosition = viewHolder.getLayoutPosition()) >= i && layoutPosition < i3) {
                    viewHolder.addFlags(2);
                    bt(size);
                }
            }
        }

        void hk() {
            int size = this.SS.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.SS.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(512);
                }
            }
        }

        void gZ() {
            if (RecyclerView.this.Rm != null && RecyclerView.this.Rm.hasStableIds()) {
                int size = this.SS.size();
                for (int i = 0; i < size; i++) {
                    ViewHolder viewHolder = this.SS.get(i);
                    if (viewHolder != null) {
                        viewHolder.addFlags(6);
                        viewHolder.addChangePayload(null);
                    }
                }
                return;
            }
            hh();
        }

        void gX() {
            int size = this.SS.size();
            for (int i = 0; i < size; i++) {
                this.SS.get(i).clearOldPosition();
            }
            int size2 = this.SQ.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.SQ.get(i2).clearOldPosition();
            }
            if (this.SR != null) {
                int size3 = this.SR.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.SR.get(i3).clearOldPosition();
                }
            }
        }

        void gV() {
            int size = this.SS.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.SS.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.SJ = true;
                }
            }
        }

        boolean bw(int i) {
            int fT = RecyclerView.this.Rh.fT();
            for (int i2 = 0; i2 < fT; i2++) {
                if (RecyclerView.ap(RecyclerView.this.Rh.bi(i2)).mPosition == i) {
                    return true;
                }
            }
            return false;
        }

        void c(int[] iArr, int i) {
            if (i != 0) {
                int i2 = iArr[i - 1];
                if (i2 < 0) {
                    throw new IllegalArgumentException("Recycler requested to prefetch invalid view " + i2);
                }
                View view = null;
                if (!bw(i2)) {
                    view = getViewForPosition(i2);
                }
                if (i > 1) {
                    c(iArr, i - 1);
                }
                if (view != null) {
                    recycleView(view);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final a Sr = new a();
        private boolean Ss = false;

        public abstract int getItemCount();

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            TraceCompat.beginSection("RV CreateView");
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            onCreateViewHolder.mItemViewType = i;
            TraceCompat.endSection();
            return onCreateViewHolder;
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).SJ = true;
            }
            TraceCompat.endSection();
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.Ss = z;
        }

        public long getItemId(int i) {
            return -1L;
        }

        public final boolean hasStableIds() {
            return this.Ss;
        }

        public void onViewRecycled(VH vh) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public final boolean hasObservers() {
            return this.Sr.hasObservers();
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.Sr.registerObserver(adapterDataObserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.Sr.unregisterObserver(adapterDataObserver);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.Sr.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.Sr.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.Sr.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.Sr.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.Sr.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.Sr.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.Sr.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.Sr.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.Sr.notifyItemRangeRemoved(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.Sr.notifyItemRangeRemoved(i, i2);
        }
    }

    void ar(View view) {
        ViewHolder ap = ap(view);
        onChildDetachedFromWindow(view);
        if (this.Rm != null && ap != null) {
            this.Rm.onViewDetachedFromWindow(ap);
        }
        if (this.RA != null) {
            for (int size = this.RA.size() - 1; size >= 0; size--) {
                this.RA.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void as(View view) {
        ViewHolder ap = ap(view);
        onChildAttachedToWindow(view);
        if (this.Rm != null && ap != null) {
            this.Rm.onViewAttachedToWindow(ap);
        }
        if (this.RA != null) {
            for (int size = this.RA.size() - 1; size >= 0; size--) {
                this.RA.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class LayoutManager {
        k Rh;
        SmoothScroller SA;
        private int SF;
        private int SG;
        RecyclerView Sz;
        private int mHeight;
        private int mWidth;
        boolean SB = false;
        boolean nL = false;
        boolean SC = false;
        private boolean SD = true;
        private boolean SE = true;

        /* loaded from: classes2.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.Sz = null;
                this.Rh = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.Sz = recyclerView;
                this.Rh = recyclerView.Rh;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.SF = 1073741824;
            this.SG = 1073741824;
        }

        void W(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.SF = View.MeasureSpec.getMode(i);
            if (this.SF == 0 && !RecyclerView.QZ) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.SG = View.MeasureSpec.getMode(i2);
            if (this.SG == 0 && !RecyclerView.QZ) {
                this.mHeight = 0;
            }
        }

        void X(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.Sz.R(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Rect rect = this.Sz.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left < i7 ? rect.left : i7;
                int i9 = rect.right > i6 ? rect.right : i6;
                int i10 = rect.top < i3 ? rect.top : i3;
                i5++;
                i4 = rect.bottom > i4 ? rect.bottom : i4;
                i3 = i10;
                i6 = i9;
                i7 = i8;
            }
            this.Sz.mTempRect.set(i7, i3, i6, i4);
            setMeasuredDimension(this.Sz.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            if (this.Sz != null) {
                this.Sz.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.Sz != null) {
                this.Sz.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            if (this.Sz != null) {
                this.Sz.assertNotInLayoutOrScroll(str);
            }
        }

        public void setAutoMeasureEnabled(boolean z) {
            this.SC = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.SC;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.SE) {
                this.SE = z;
                if (this.Sz != null) {
                    this.Sz.Re.hg();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.SE;
        }

        int ge() {
            return 0;
        }

        int a(int i, int i2, State state, int[] iArr) {
            return 0;
        }

        void c(RecyclerView recyclerView) {
            this.nL = true;
            onAttachedToWindow(recyclerView);
        }

        void a(RecyclerView recyclerView, Recycler recycler) {
            this.nL = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public boolean isAttachedToWindow() {
            return this.nL;
        }

        public void postOnAnimation(Runnable runnable) {
            if (this.Sz != null) {
                ViewCompat.postOnAnimation(this.Sz, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            if (this.Sz != null) {
                return this.Sz.removeCallbacks(runnable);
            }
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            return this.Sz != null && this.Sz.Rj;
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State state) {
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public void scrollToPosition(int i) {
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            if (this.SA != null && smoothScroller != this.SA && this.SA.isRunning()) {
                this.SA.stop();
            }
            this.SA = smoothScroller;
            this.SA.a(this.Sz, this);
        }

        public boolean isSmoothScrolling() {
            return this.SA != null && this.SA.isRunning();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.Sz);
        }

        public void endAnimation(View view) {
            if (this.Sz.RI != null) {
                this.Sz.RI.endAnimation(RecyclerView.ap(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            d(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            d(view, i, false);
        }

        private void d(View view, int i, boolean z) {
            ViewHolder ap = RecyclerView.ap(view);
            if (z || ap.isRemoved()) {
                this.Sz.Ri.s(ap);
            } else {
                this.Sz.Ri.t(ap);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (ap.wasReturnedFromScrap() || ap.isScrap()) {
                if (ap.isScrap()) {
                    ap.unScrap();
                } else {
                    ap.clearReturnedFromScrapFlag();
                }
                this.Rh.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.Sz) {
                int indexOfChild = this.Rh.indexOfChild(view);
                if (i == -1) {
                    i = this.Rh.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.Sz.indexOfChild(view));
                }
                if (indexOfChild != i) {
                    this.Sz.Rn.moveView(indexOfChild, i);
                }
            } else {
                this.Rh.b(view, i, false);
                layoutParams.SJ = true;
                if (this.SA != null && this.SA.isRunning()) {
                    this.SA.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.SK) {
                ap.itemView.invalidate();
                layoutParams.SK = false;
            }
        }

        public void removeView(View view) {
            this.Rh.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.Rh.removeViewAt(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.Rh.removeViewAt(childCount);
            }
        }

        public int getBaseline() {
            return -1;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.ap(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            if (this.Sz == null || (findContainingItemView = this.Sz.findContainingItemView(view)) == null || this.Rh.Z(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder ap = RecyclerView.ap(childAt);
                if (ap != null && ap.getLayoutPosition() == i && !ap.shouldIgnore() && (this.Sz.Sa.isPreLayout() || !ap.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int indexOfChild = this.Rh.indexOfChild(view);
            if (indexOfChild >= 0) {
                a(indexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            a(i, getChildAt(i));
        }

        private void a(int i, View view) {
            this.Rh.detachViewFromParent(i);
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap.isRemoved()) {
                this.Sz.Ri.s(ap);
            } else {
                this.Sz.Ri.t(ap);
            }
            this.Rh.a(view, i, layoutParams, ap.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.Sz.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            a(recycler, this.Rh.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            a(recycler, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public int getChildCount() {
            if (this.Rh != null) {
                return this.Rh.getChildCount();
            }
            return 0;
        }

        public View getChildAt(int i) {
            if (this.Rh != null) {
                return this.Rh.getChildAt(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.SF;
        }

        public int getHeightMode() {
            return this.SG;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            if (this.Sz != null) {
                return this.Sz.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            if (this.Sz != null) {
                return this.Sz.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            if (this.Sz != null) {
                return this.Sz.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            if (this.Sz != null) {
                return this.Sz.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            if (this.Sz != null) {
                return ViewCompat.getPaddingStart(this.Sz);
            }
            return 0;
        }

        public int getPaddingEnd() {
            if (this.Sz != null) {
                return ViewCompat.getPaddingEnd(this.Sz);
            }
            return 0;
        }

        public boolean isFocused() {
            return this.Sz != null && this.Sz.isFocused();
        }

        public boolean hasFocus() {
            return this.Sz != null && this.Sz.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            if (this.Sz == null || (focusedChild = this.Sz.getFocusedChild()) == null || this.Rh.Z(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            Adapter adapter = this.Sz != null ? this.Sz.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            if (this.Sz != null) {
                this.Sz.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            if (this.Sz != null) {
                this.Sz.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.Sz || this.Sz.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            }
            ViewHolder ap = RecyclerView.ap(view);
            ap.addFlags(128);
            this.Sz.Ri.u(ap);
        }

        public void stopIgnoringView(View view) {
            ViewHolder ap = RecyclerView.ap(view);
            ap.stopIgnoring();
            ap.resetInternal();
            ap.addFlags(4);
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                a(recycler, childCount, getChildAt(childCount));
            }
        }

        private void a(Recycler recycler, int i, View view) {
            ViewHolder ap = RecyclerView.ap(view);
            if (!ap.shouldIgnore()) {
                if (ap.isInvalid() && !ap.isRemoved() && !this.Sz.Rm.hasStableIds()) {
                    removeViewAt(i);
                    recycler.k(ap);
                    return;
                }
                detachViewAt(i);
                recycler.av(view);
                this.Sz.Ri.v(ap);
            }
        }

        void b(Recycler recycler) {
            int hi = recycler.hi();
            for (int i = hi - 1; i >= 0; i--) {
                View bu = recycler.bu(i);
                ViewHolder ap = RecyclerView.ap(bu);
                if (!ap.shouldIgnore()) {
                    ap.setIsRecyclable(false);
                    if (ap.isTmpDetached()) {
                        this.Sz.removeDetachedView(bu, false);
                    }
                    if (this.Sz.RI != null) {
                        this.Sz.RI.endAnimation(ap);
                    }
                    ap.setIsRecyclable(true);
                    recycler.au(bu);
                }
            }
            recycler.hj();
            if (hi > 0) {
                this.Sz.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect aq = this.Sz.aq(view);
            int i3 = aq.top;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), aq.left + aq.right + i + getPaddingLeft() + getPaddingRight(), layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), aq.bottom + i3 + i2 + getPaddingTop() + getPaddingBottom(), layoutParams.height, canScrollVertically());
            if (b(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.SD && h(view.getMeasuredWidth(), i, layoutParams.width) && h(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.SD && h(view.getWidth(), i, layoutParams.width) && h(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.SD;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.SD = z;
        }

        private static boolean h(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                switch (mode) {
                    case Integer.MIN_VALUE:
                        return size >= i;
                    case 0:
                        return true;
                    case 1073741824:
                        return size == i;
                    default:
                        return false;
                }
            }
            return false;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect aq = this.Sz.aq(view);
            int i3 = aq.top;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), aq.left + aq.right + i + getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), aq.bottom + i3 + i2 + getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height, canScrollVertically());
            if (b(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        @Deprecated
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = 1073741824;
            int max = Math.max(0, i - i2);
            if (z) {
                if (i3 < 0) {
                    i4 = 0;
                    i3 = 0;
                }
            } else if (i3 < 0) {
                if (i3 == -1) {
                    i3 = max;
                } else if (i3 == -2) {
                    i4 = Integer.MIN_VALUE;
                    i3 = max;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i4);
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (z) {
                if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i5);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pc;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pc;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pc;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.Pc;
            view.layout(rect.left + i + layoutParams.leftMargin, rect.top + i2 + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).Pc;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.Sz != null && (matrix = ViewCompat.getMatrix(view)) != null && !matrix.isIdentity()) {
                RectF rectF = this.Sz.Rl;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.d(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            if (this.Sz == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.Sz.aq(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pc.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pc.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pc.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pc.right;
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int min;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = left + rect.width();
            int height2 = top + rect.height();
            int min2 = Math.min(0, left - paddingLeft);
            int min3 = Math.min(0, top - paddingTop);
            int max = Math.max(0, width2 - width);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min2, width2 - width);
                }
                min = max;
            } else {
                min = min2 != 0 ? min2 : Math.min(left - paddingLeft, max);
            }
            int min4 = min3 != 0 ? min3 : Math.min(top - paddingTop, max2);
            if (min != 0 || min4 != 0) {
                if (z) {
                    recyclerView.scrollBy(min, min4);
                } else {
                    recyclerView.smoothScrollBy(min, min4);
                }
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.Sz.R(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.Sz.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.Sz);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.Sz);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        void he() {
            if (this.SA != null) {
                this.SA.stop();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SmoothScroller smoothScroller) {
            if (this.SA == smoothScroller) {
                this.SA = null;
            }
        }

        public void onScrollStateChanged(int i) {
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.ap(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            onInitializeAccessibilityNodeInfo(this.Sz.Re, this.Sz.Sa, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.Sz, -1) || ViewCompat.canScrollHorizontally(this.Sz, -1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.Sz, 1) || ViewCompat.canScrollHorizontally(this.Sz, 1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.Sz.Re, this.Sz.Sa, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            if (this.Sz != null && asRecord != null) {
                if (!ViewCompat.canScrollVertically(this.Sz, 1) && !ViewCompat.canScrollVertically(this.Sz, -1) && !ViewCompat.canScrollHorizontally(this.Sz, -1) && !ViewCompat.canScrollHorizontally(this.Sz, 1)) {
                    z = false;
                }
                asRecord.setScrollable(z);
                if (this.Sz.Rm != null) {
                    asRecord.setItemCount(this.Sz.Rm.getItemCount());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap != null && !ap.isRemoved() && !this.Rh.Z(ap.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.Sz.Re, this.Sz.Sa, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.SB = true;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            if (this.Sz == null || this.Sz.Rm == null || !canScrollVertically()) {
                return 1;
            }
            return this.Sz.Rm.getItemCount();
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            if (this.Sz == null || this.Sz.Rm == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.Sz.Rm.getItemCount();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.Sz.Re, this.Sz.Sa, i, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle) {
            int height;
            int i2;
            int width;
            if (this.Sz == null) {
                return false;
            }
            switch (i) {
                case 4096:
                    height = ViewCompat.canScrollVertically(this.Sz, 1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                    if (ViewCompat.canScrollHorizontally(this.Sz, 1)) {
                        i2 = height;
                        width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                        break;
                    }
                    i2 = height;
                    width = 0;
                    break;
                case 8192:
                    height = ViewCompat.canScrollVertically(this.Sz, -1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                    if (ViewCompat.canScrollHorizontally(this.Sz, -1)) {
                        i2 = height;
                        width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                        break;
                    }
                    i2 = height;
                    width = 0;
                    break;
                default:
                    width = 0;
                    i2 = 0;
                    break;
            }
            if (i2 == 0 && width == 0) {
                return false;
            }
            this.Sz.scrollBy(width, i2);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.Sz.Re, this.Sz.Sa, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        void d(RecyclerView recyclerView) {
            W(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean gj() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hf() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ItemDecoration {
        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    /* loaded from: classes2.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        private int mFlags;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        private Recycler mScrapContainer = null;
        private boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        private int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).SJ = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getAdapterPosition() {
            if (this.mOwnerRecyclerView == null) {
                return -1;
            }
            return this.mOwnerRecyclerView.f(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.m(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (this.mFlags & i) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (this.mFlags & (i2 ^ (-1))) | (i & i2);
        }

        void addFlags(int i) {
            this.mFlags |= i;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((this.mFlags & 1024) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                if (this.mPayloads == null || this.mPayloads.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            recyclerView.a(this, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ").append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.mIsRecyclableCount == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean a(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.Sm.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    void hb() {
        for (int size = this.Sm.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.Sm.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore()) {
                int i = viewHolder.mPendingAccessibilityState;
                if (i != -1) {
                    ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                    viewHolder.mPendingAccessibilityState = -1;
                }
            } else {
                return;
            }
        }
        this.Sm.clear();
    }

    int f(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.Rg.bc(viewHolder.mPosition);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect Pc;
        ViewHolder SH;
        boolean SJ;
        boolean SK;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Pc = new Rect();
            this.SJ = true;
            this.SK = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.Pc = new Rect();
            this.SJ = true;
            this.SK = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.Pc = new Rect();
            this.SJ = true;
            this.SK = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Pc = new Rect();
            this.SJ = true;
            this.SK = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.Pc = new Rect();
            this.SJ = true;
            this.SK = false;
        }

        public boolean viewNeedsUpdate() {
            return this.SH.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.SH.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.SH.isRemoved();
        }

        public boolean isItemChanged() {
            return this.SH.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.SH.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.SH.getLayoutPosition();
        }

        public int getViewAdapterPosition() {
            return this.SH.getAdapterPosition();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SmoothScroller {
        private RecyclerView Sz;
        private boolean Ta;
        private LayoutManager mLayoutManager;
        private boolean mRunning;
        private View yB;
        private int SZ = -1;
        private final Action Tb = new Action(0, 0);

        /* loaded from: classes2.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        void a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.Sz = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.SZ == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.Sz.Sa.SZ = this.SZ;
            this.mRunning = true;
            this.Ta = true;
            this.yB = findViewByPosition(getTargetPosition());
            onStart();
            this.Sz.RW.hp();
        }

        public void setTargetPosition(int i) {
            this.SZ = i;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                onStop();
                this.Sz.Sa.SZ = -1;
                this.yB = null;
                this.SZ = -1;
                this.Ta = false;
                this.mRunning = false;
                this.mLayoutManager.a(this);
                this.mLayoutManager = null;
                this.Sz = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.Ta;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.SZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z(int i, int i2) {
            RecyclerView recyclerView = this.Sz;
            if (!this.mRunning || this.SZ == -1 || recyclerView == null) {
                stop();
            }
            this.Ta = false;
            if (this.yB != null) {
                if (getChildPosition(this.yB) == this.SZ) {
                    onTargetFound(this.yB, recyclerView.Sa, this.Tb);
                    this.Tb.e(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.yB = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.Sa, this.Tb);
                boolean hm = this.Tb.hm();
                this.Tb.e(recyclerView);
                if (hm) {
                    if (this.mRunning) {
                        this.Ta = true;
                        recyclerView.RW.hp();
                        return;
                    }
                    stop();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.Sz.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.Sz.Rn.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.Sz.Rn.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.Sz.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.yB = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            double sqrt = Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x = (float) (pointF.x / sqrt);
            pointF.y = (float) (pointF.y / sqrt);
        }

        /* loaded from: classes2.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private int Tc;
            private int Td;
            private int Te;
            private boolean Tf;
            private int Tg;
            private int mDuration;
            private Interpolator mInterpolator;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public Action(int i, int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.Te = -1;
                this.Tf = false;
                this.Tg = 0;
                this.Tc = i;
                this.Td = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            public void jumpTo(int i) {
                this.Te = i;
            }

            boolean hm() {
                return this.Te >= 0;
            }

            void e(RecyclerView recyclerView) {
                if (this.Te >= 0) {
                    int i = this.Te;
                    this.Te = -1;
                    recyclerView.br(i);
                    this.Tf = false;
                } else if (this.Tf) {
                    validate();
                    if (this.mInterpolator == null) {
                        if (this.mDuration == Integer.MIN_VALUE) {
                            recyclerView.RW.smoothScrollBy(this.Tc, this.Td);
                        } else {
                            recyclerView.RW.i(this.Tc, this.Td, this.mDuration);
                        }
                    } else {
                        recyclerView.RW.a(this.Tc, this.Td, this.mDuration, this.mInterpolator);
                    }
                    this.Tg++;
                    if (this.Tg > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.Tf = false;
                } else {
                    this.Tg = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int getDx() {
                return this.Tc;
            }

            public void setDx(int i) {
                this.Tf = true;
                this.Tc = i;
            }

            public int getDy() {
                return this.Td;
            }

            public void setDy(int i) {
                this.Tf = true;
                this.Td = i;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public void setDuration(int i) {
                this.Tf = true;
                this.mDuration = i;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.Tf = true;
                this.mInterpolator = interpolator;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.Tc = i;
                this.Td = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.Tf = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends Observable<AdapterDataObserver> {
        a() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: i */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: bx */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        Parcelable SY;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.SY = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.SY, 0);
        }

        void a(SavedState savedState) {
            this.SY = savedState.SY;
        }
    }

    /* loaded from: classes2.dex */
    public static class State {
        private SparseArray<Object> Ti;
        int Tr;
        long Ts;
        int Tt;
        private int SZ = -1;
        int Th = 1;
        int mItemCount = 0;
        int Tj = 0;
        int Tk = 0;
        boolean Tl = false;
        boolean Tm = false;
        boolean Tn = false;
        boolean To = false;
        boolean Tp = false;
        boolean Tq = false;

        void by(int i) {
            if ((this.Th & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.Th));
            }
        }

        public boolean isMeasuring() {
            return this.Tq;
        }

        public boolean isPreLayout() {
            return this.Tm;
        }

        public boolean willRunPredictiveAnimations() {
            return this.To;
        }

        public boolean willRunSimpleAnimations() {
            return this.Tn;
        }

        public void remove(int i) {
            if (this.Ti != null) {
                this.Ti.remove(i);
            }
        }

        public <T> T get(int i) {
            if (this.Ti == null) {
                return null;
            }
            return (T) this.Ti.get(i);
        }

        public void put(int i, Object obj) {
            if (this.Ti == null) {
                this.Ti = new SparseArray<>();
            }
            this.Ti.put(i, obj);
        }

        public int getTargetScrollPosition() {
            return this.SZ;
        }

        public boolean hasTargetScrollPosition() {
            return this.SZ != -1;
        }

        public boolean didStructureChange() {
            return this.Tl;
        }

        public int getItemCount() {
            return this.Tm ? this.Tj - this.Tk : this.mItemCount;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.SZ + ", mData=" + this.Ti + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.Tj + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.Tk + ", mStructureChanged=" + this.Tl + ", mInPreLayout=" + this.Tm + ", mRunSimpleAnimations=" + this.Tn + ", mRunPredictiveAnimations=" + this.To + '}';
        }
    }

    /* loaded from: classes2.dex */
    private class b implements ItemAnimator.a {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.a
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.an(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private a St = null;
        private ArrayList<ItemAnimatorFinishedListener> Su = new ArrayList<>();
        private long Sv = 120;
        private long Sw = 120;
        private long Sx = 250;
        private long Sy = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes2.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a {
            void onAnimationFinished(ViewHolder viewHolder);
        }

        public abstract boolean animateAppearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public abstract void runPendingAnimations();

        public long getMoveDuration() {
            return this.Sx;
        }

        public void setMoveDuration(long j) {
            this.Sx = j;
        }

        public long getAddDuration() {
            return this.Sv;
        }

        public void setAddDuration(long j) {
            this.Sv = j;
        }

        public long getRemoveDuration() {
            return this.Sw;
        }

        public void setRemoveDuration(long j) {
            this.Sw = j;
        }

        public long getChangeDuration() {
            return this.Sy;
        }

        public void setChangeDuration(long j) {
            this.Sy = j;
        }

        void a(a aVar) {
            this.St = aVar;
        }

        public ItemHolderInfo recordPreLayoutInformation(State state, ViewHolder viewHolder, int i, List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public ItemHolderInfo recordPostLayoutInformation(State state, ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        static int h(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int adapterPosition = viewHolder.getAdapterPosition();
                if (oldPosition != -1 && adapterPosition != -1 && oldPosition != adapterPosition) {
                    return i | 2048;
                }
                return i;
            }
            return i;
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            if (this.St != null) {
                this.St.onAnimationFinished(viewHolder);
            }
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
        }

        public final void dispatchAnimationStarted(ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public void onAnimationStarted(ViewHolder viewHolder) {
        }

        public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.Su.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.Su.size();
            for (int i = 0; i < size; i++) {
                this.Su.get(i).onAnimationsFinished();
            }
            this.Su.clear();
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        /* loaded from: classes2.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo setFrom(ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        return this.Si == null ? super.getChildDrawingOrder(i, i2) : this.Si.onGetChildDrawingOrder(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.Sk == null) {
            this.Sk = new NestedScrollingChildHelper(this);
        }
        return this.Sk;
    }
}
