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
    private static final int[] Rd = {16843830};
    private static final int[] Re = {16842987};
    static final boolean Rf;
    static final boolean Rg;
    static final boolean Rh;
    private static final boolean Ri;
    private static final Class<?>[] Rj;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final long Se;
    static long Sf = 0;
    static final Interpolator Sv;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    boolean RA;
    private int RB;
    boolean RC;
    boolean RD;
    private boolean RE;
    private int RF;
    boolean RG;
    private List<OnChildAttachStateChangeListener> RH;
    boolean RI;
    private int RJ;
    private int RK;
    private EdgeEffectCompat RL;
    private EdgeEffectCompat RO;
    private EdgeEffectCompat RP;
    private EdgeEffectCompat RQ;
    ItemAnimator RR;
    private int RT;
    private int RU;
    private int RV;
    private int RW;
    private int RX;
    private OnFlingListener RY;
    private final int RZ;
    private final c Rk;
    final Recycler Rl;
    private SavedState Rm;
    android.support.v7.widget.c Rn;
    k Ro;
    final v Rp;
    boolean Rq;
    final Runnable Rr;
    final RectF Rs;
    Adapter Rt;
    LayoutManager Ru;
    RecyclerListener Rv;
    final ArrayList<ItemDecoration> Rw;
    private final ArrayList<OnItemTouchListener> Rx;
    private OnItemTouchListener Ry;
    boolean Rz;
    private final int Sa;
    private float Sb;
    private boolean Sc;
    final d Sd;
    e Sg;
    final State Sh;
    private OnScrollListener Si;
    private List<OnScrollListener> Sj;
    boolean Sk;
    boolean Sl;
    private ItemAnimator.a Sm;
    boolean Sn;
    RecyclerViewAccessibilityDelegate So;
    private ChildDrawingOrderCallback Sp;
    private final int[] Sq;
    private NestedScrollingChildHelper Sr;
    private final int[] Ss;
    private final List<ViewHolder> St;
    private Runnable Su;
    private final v.b Sw;
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
        Rf = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        Rg = Build.VERSION.SDK_INT >= 23;
        Rh = Build.VERSION.SDK_INT >= 16;
        Ri = Build.VERSION.SDK_INT >= 21;
        Rj = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        Se = TimeUnit.MILLISECONDS.toNanos(4L);
        Sf = 0L;
        Sv = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
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
        this.Rk = new c();
        this.Rl = new Recycler();
        this.Rp = new v();
        this.Rr = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.RA && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.RD) {
                        RecyclerView.this.RC = true;
                    } else {
                        RecyclerView.this.gv();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.nG = new Rect();
        this.Rs = new RectF();
        this.Rw = new ArrayList<>();
        this.Rx = new ArrayList<>();
        this.RB = 0;
        this.RI = false;
        this.RJ = 0;
        this.RK = 0;
        this.RR = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.RT = -1;
        this.Sb = Float.MIN_VALUE;
        this.Sc = true;
        this.Sd = new d();
        this.Sg = Ri ? new e() : null;
        this.Sh = new State();
        this.Sk = false;
        this.Sl = false;
        this.Sm = new b();
        this.Sn = false;
        this.Sq = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.Ss = new int[2];
        this.St = new ArrayList();
        this.Su = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.RR != null) {
                    RecyclerView.this.RR.runPendingAnimations();
                }
                RecyclerView.this.Sn = false;
            }
        };
        this.Sw = new v.b() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.v.b
            public void c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.Rl.m(viewHolder);
                RecyclerView.this.b(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.v.b
            public void d(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.a(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.v.b
            public void e(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.RI) {
                    if (RecyclerView.this.RR.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.gL();
                    }
                } else if (RecyclerView.this.RR.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.gL();
                }
            }

            @Override // android.support.v7.widget.v.b
            public void g(ViewHolder viewHolder) {
                RecyclerView.this.Ru.removeAndRecycleView(viewHolder.itemView, RecyclerView.this.Rl);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Re, i, 0);
            this.Rq = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.Rq = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.RZ = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Sa = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.RR.a(this.Sm);
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
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, Rd, i, 0);
                z = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.So;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.So = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.So);
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
                        Constructor constructor2 = asSubclass.getConstructor(Rj);
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
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void gt() {
        this.Ro = new k(new k.b() { // from class: android.support.v7.widget.RecyclerView.5
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
        this.Rn = new android.support.v7.widget.c(new c.a() { // from class: android.support.v7.widget.RecyclerView.6
            @Override // android.support.v7.widget.c.a
            public ViewHolder bd(int i) {
                ViewHolder k = RecyclerView.this.k(i, true);
                if (k == null || RecyclerView.this.Ro.Z(k.itemView)) {
                    return null;
                }
                return k;
            }

            @Override // android.support.v7.widget.c.a
            public void B(int i, int i2) {
                RecyclerView.this.b(i, i2, true);
                RecyclerView.this.Sk = true;
                RecyclerView.this.Sh.Tr += i2;
            }

            @Override // android.support.v7.widget.c.a
            public void C(int i, int i2) {
                RecyclerView.this.b(i, i2, false);
                RecyclerView.this.Sk = true;
            }

            @Override // android.support.v7.widget.c.a
            public void e(int i, int i2, Object obj) {
                RecyclerView.this.f(i, i2, obj);
                RecyclerView.this.Sl = true;
            }

            @Override // android.support.v7.widget.c.a
            public void h(c.b bVar) {
                j(bVar);
            }

            void j(c.b bVar) {
                switch (bVar.cmd) {
                    case 1:
                        RecyclerView.this.Ru.onItemsAdded(RecyclerView.this, bVar.Mr, bVar.Mt);
                        return;
                    case 2:
                        RecyclerView.this.Ru.onItemsRemoved(RecyclerView.this, bVar.Mr, bVar.Mt);
                        return;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        return;
                    case 4:
                        RecyclerView.this.Ru.onItemsUpdated(RecyclerView.this, bVar.Mr, bVar.Mt, bVar.Ms);
                        return;
                    case 8:
                        RecyclerView.this.Ru.onItemsMoved(RecyclerView.this, bVar.Mr, bVar.Mt, 1);
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
                RecyclerView.this.Sk = true;
            }

            @Override // android.support.v7.widget.c.a
            public void E(int i, int i2) {
                RecyclerView.this.T(i, i2);
                RecyclerView.this.Sk = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.Rz = z;
    }

    public boolean hasFixedSize() {
        return this.Rz;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.Rq) {
            gE();
        }
        this.Rq = z;
        super.setClipToPadding(z);
        if (this.RA) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.Rq;
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
        if (this.Rt != null) {
            this.Rt.unregisterAdapterDataObserver(this.Rk);
            this.Rt.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            if (this.RR != null) {
                this.RR.endAnimations();
            }
            if (this.Ru != null) {
                this.Ru.removeAndRecycleAllViews(this.Rl);
                this.Ru.b(this.Rl);
            }
            this.Rl.clear();
        }
        this.Rn.reset();
        Adapter adapter2 = this.Rt;
        this.Rt = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.Rk);
            adapter.onAttachedToRecyclerView(this);
        }
        if (this.Ru != null) {
            this.Ru.onAdapterChanged(adapter2, this.Rt);
        }
        this.Rl.a(adapter2, this.Rt, z);
        this.Sh.Ts = true;
        gZ();
    }

    public Adapter getAdapter() {
        return this.Rt;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.Rv = recyclerListener;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.Ru != null ? this.Ru.getBaseline() : super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.RH == null) {
            this.RH = new ArrayList();
        }
        this.RH.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.RH != null) {
            this.RH.remove(onChildAttachStateChangeListener);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.RH != null) {
            this.RH.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.Ru) {
            stopScroll();
            if (this.Ru != null) {
                if (this.RR != null) {
                    this.RR.endAnimations();
                }
                this.Ru.removeAndRecycleAllViews(this.Rl);
                this.Ru.b(this.Rl);
                this.Rl.clear();
                if (this.mIsAttached) {
                    this.Ru.a(this, this.Rl);
                }
                this.Ru.b((RecyclerView) null);
                this.Ru = null;
            } else {
                this.Rl.clear();
            }
            this.Ro.fS();
            this.Ru = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.SG != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.SG);
                }
                this.Ru.b(this);
                if (this.mIsAttached) {
                    this.Ru.c(this);
                }
            }
            this.Rl.hg();
            requestLayout();
        }
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.RY = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.RY;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.Rm != null) {
            savedState.a(this.Rm);
        } else if (this.Ru != null) {
            savedState.Tf = this.Ru.onSaveInstanceState();
        } else {
            savedState.Tf = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.Rm = (SavedState) parcelable;
        super.onRestoreInstanceState(this.Rm.getSuperState());
        if (this.Ru != null && this.Rm.Tf != null) {
            this.Ru.onRestoreInstanceState(this.Rm.Tf);
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
        this.Rl.m(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.Ro.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.Ro.g(view, true);
        } else {
            this.Ro.aa(view);
        }
    }

    boolean an(View view) {
        gx();
        boolean ac = this.Ro.ac(view);
        if (ac) {
            ViewHolder ap = ap(view);
            this.Rl.m(ap);
            this.Rl.k(ap);
        }
        H(!ac);
        return ac;
    }

    public LayoutManager getLayoutManager() {
        return this.Ru;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.Rl.getRecycledViewPool();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.Rl.setRecycledViewPool(recycledViewPool);
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.Rl.setViewCacheExtension(viewCacheExtension);
    }

    public void setItemViewCacheSize(int i) {
        this.Rl.setViewCacheSize(i);
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
        if (this.Ru != null) {
            this.Ru.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.Rw.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.Rw.add(itemDecoration);
        } else {
            this.Rw.add(i, itemDecoration);
        }
        gV();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        if (this.Ru != null) {
            this.Ru.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.Rw.remove(itemDecoration);
        if (this.Rw.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        gV();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.Sp) {
            this.Sp = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.Sp != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.Si = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.Sj == null) {
            this.Sj = new ArrayList();
        }
        this.Sj.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        if (this.Sj != null) {
            this.Sj.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        if (this.Sj != null) {
            this.Sj.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.RD) {
            stopScroll();
            if (this.Ru == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.Ru.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    void br(int i) {
        if (this.Ru != null) {
            this.Ru.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.RD) {
            if (this.Ru == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.Ru.smoothScrollToPosition(this, this.Sh, i);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.Ru == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.RD) {
            boolean canScrollHorizontally = this.Ru.canScrollHorizontally();
            boolean canScrollVertically = this.Ru.canScrollVertically();
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
        if (!this.RA || this.RI) {
            TraceCompat.beginSection("RV FullInvalidate");
            gO();
            TraceCompat.endSection();
        } else if (this.Rn.fD()) {
            if (this.Rn.ba(4) && !this.Rn.ba(11)) {
                TraceCompat.beginSection("RV PartialInvalidate");
                gx();
                this.Rn.fB();
                if (!this.RC) {
                    if (gw()) {
                        gO();
                    } else {
                        this.Rn.fC();
                    }
                }
                H(true);
                TraceCompat.endSection();
            } else if (this.Rn.fD()) {
                TraceCompat.beginSection("RV FullInvalidate");
                gO();
                TraceCompat.endSection();
            }
        }
    }

    private boolean gw() {
        int childCount = this.Ro.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder ap = ap(this.Ro.getChildAt(i));
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
        if (this.Rt != null) {
            gx();
            gH();
            TraceCompat.beginSection("RV Scroll");
            if (i != 0) {
                i7 = this.Ru.scrollHorizontallyBy(i, this.Rl, this.Sh);
                i6 = i - i7;
            } else {
                i7 = 0;
                i6 = 0;
            }
            if (i2 != 0) {
                i8 = this.Ru.scrollVerticallyBy(i2, this.Rl, this.Sh);
                i9 = i2 - i8;
            } else {
                i8 = 0;
                i9 = 0;
            }
            TraceCompat.endSection();
            ha();
            gI();
            H(false);
            i5 = i9;
            i4 = i7;
            i3 = i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.Rw.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i3, i6, i5, this.mScrollOffset)) {
            this.RW -= this.mScrollOffset[0];
            this.RX -= this.mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
            }
            int[] iArr = this.Ss;
            iArr[0] = iArr[0] + this.mScrollOffset[0];
            int[] iArr2 = this.Ss;
            iArr2[1] = iArr2[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                c(motionEvent.getX(), i6, motionEvent.getY(), i5);
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
        if (this.Ru != null && this.Ru.canScrollHorizontally()) {
            return this.Ru.computeHorizontalScrollOffset(this.Sh);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        if (this.Ru != null && this.Ru.canScrollHorizontally()) {
            return this.Ru.computeHorizontalScrollExtent(this.Sh);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollRange() {
        if (this.Ru != null && this.Ru.canScrollHorizontally()) {
            return this.Ru.computeHorizontalScrollRange(this.Sh);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        if (this.Ru != null && this.Ru.canScrollVertically()) {
            return this.Ru.computeVerticalScrollOffset(this.Sh);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        if (this.Ru != null && this.Ru.canScrollVertically()) {
            return this.Ru.computeVerticalScrollExtent(this.Sh);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollRange() {
        if (this.Ru != null && this.Ru.canScrollVertically()) {
            return this.Ru.computeVerticalScrollRange(this.Sh);
        }
        return 0;
    }

    void gx() {
        this.RB++;
        if (this.RB == 1 && !this.RD) {
            this.RC = false;
        }
    }

    void H(boolean z) {
        if (this.RB < 1) {
            this.RB = 1;
        }
        if (!z) {
            this.RC = false;
        }
        if (this.RB == 1) {
            if (z && this.RC && !this.RD && this.Ru != null && this.Rt != null) {
                gO();
            }
            if (!this.RD) {
                this.RC = false;
            }
        }
        this.RB--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.RD) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.RD = false;
                if (this.RC && this.Ru != null && this.Rt != null) {
                    requestLayout();
                }
                this.RC = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.RD = true;
            this.RE = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.RD;
    }

    public void smoothScrollBy(int i, int i2) {
        if (this.Ru == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.RD) {
            if (!this.Ru.canScrollHorizontally()) {
                i = 0;
            }
            int i3 = this.Ru.canScrollVertically() ? i2 : 0;
            if (i != 0 || i3 != 0) {
                this.Sd.smoothScrollBy(i, i3);
            }
        }
    }

    public boolean fling(int i, int i2) {
        if (this.Ru == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.RD) {
            return false;
        } else {
            boolean canScrollHorizontally = this.Ru.canScrollHorizontally();
            boolean canScrollVertically = this.Ru.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.RZ) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.RZ) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling(i, i2)) {
                return false;
            }
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(i, i2, z);
            if (this.RY == null || !this.RY.onFling(i, i2)) {
                if (z) {
                    this.Sd.aa(Math.max(-this.Sa, Math.min(i, this.Sa)), Math.max(-this.Sa, Math.min(i2, this.Sa)));
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
        this.Sd.stop();
        if (this.Ru != null) {
            this.Ru.he();
        }
    }

    public int getMinFlingVelocity() {
        return this.RZ;
    }

    public int getMaxFlingVelocity() {
        return this.Sa;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        if (r7.RO.onPull((-r11) / getHeight(), r8 / getWidth()) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r7.RQ.onPull(r11 / getHeight(), 1.0f - (r8 / getWidth())) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(float f, float f2, float f3, float f4) {
        boolean z = true;
        boolean z2 = false;
        if (f2 < 0.0f) {
            gA();
            if (this.RL.onPull((-f2) / getWidth(), 1.0f - (f3 / getHeight()))) {
                z2 = true;
            }
        } else if (f2 > 0.0f) {
            gB();
            if (this.RP.onPull(f2 / getWidth(), f3 / getHeight())) {
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
        boolean onRelease = this.RL != null ? this.RL.onRelease() : false;
        if (this.RO != null) {
            onRelease |= this.RO.onRelease();
        }
        if (this.RP != null) {
            onRelease |= this.RP.onRelease();
        }
        if (this.RQ != null) {
            onRelease |= this.RQ.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void P(int i, int i2) {
        boolean z = false;
        if (this.RL != null && !this.RL.isFinished() && i > 0) {
            z = this.RL.onRelease();
        }
        if (this.RP != null && !this.RP.isFinished() && i < 0) {
            z |= this.RP.onRelease();
        }
        if (this.RO != null && !this.RO.isFinished() && i2 > 0) {
            z |= this.RO.onRelease();
        }
        if (this.RQ != null && !this.RQ.isFinished() && i2 < 0) {
            z |= this.RQ.onRelease();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void Q(int i, int i2) {
        if (i < 0) {
            gA();
            this.RL.onAbsorb(-i);
        } else if (i > 0) {
            gB();
            this.RP.onAbsorb(i);
        }
        if (i2 < 0) {
            gC();
            this.RO.onAbsorb(-i2);
        } else if (i2 > 0) {
            gD();
            this.RQ.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void gA() {
        if (this.RL == null) {
            this.RL = new EdgeEffectCompat(getContext());
            if (this.Rq) {
                this.RL.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.RL.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gB() {
        if (this.RP == null) {
            this.RP = new EdgeEffectCompat(getContext());
            if (this.Rq) {
                this.RP.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.RP.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gC() {
        if (this.RO == null) {
            this.RO = new EdgeEffectCompat(getContext());
            if (this.Rq) {
                this.RO.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.RO.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void gD() {
        if (this.RQ == null) {
            this.RQ = new EdgeEffectCompat(getContext());
            if (this.Rq) {
                this.RQ.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.RQ.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void gE() {
        this.RQ = null;
        this.RO = null;
        this.RP = null;
        this.RL = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        boolean z2 = true;
        View onInterceptFocusSearch = this.Ru.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch == null) {
            boolean z3 = (this.Rt == null || this.Ru == null || isComputingLayout() || this.RD) ? false : true;
            FocusFinder focusFinder = FocusFinder.getInstance();
            if (z3 && (i == 2 || i == 1)) {
                if (this.Ru.canScrollVertically()) {
                    z = focusFinder.findNextFocus(this, view, i == 2 ? TransportMediator.KEYCODE_MEDIA_RECORD : 33) == null;
                } else {
                    z = false;
                }
                if (z || !this.Ru.canScrollHorizontally()) {
                    z2 = z;
                } else {
                    if (focusFinder.findNextFocus(this, view, (i == 2) ^ (this.Ru.getLayoutDirection() == 1) ? 66 : 17) != null) {
                        z2 = false;
                    }
                }
                if (z2) {
                    gv();
                    if (findContainingItemView(view) == null) {
                        return null;
                    }
                    gx();
                    this.Ru.onFocusSearchFailed(view, i, this.Rl, this.Sh);
                    H(false);
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
                    view2 = this.Ru.onFocusSearchFailed(view, i, this.Rl, this.Sh);
                    H(false);
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
            if (c(view, view2, (i == 2) ^ (this.Ru.getLayoutDirection() == 1) ? 66 : 17)) {
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
        if (!this.Ru.onRequestChildFocus(this, this.Sh, view, view2) && view2 != null) {
            this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.SS) {
                    Rect rect = layoutParams2.Pi;
                    this.mTempRect.left -= rect.left;
                    this.mTempRect.right += rect.right;
                    this.mTempRect.top -= rect.top;
                    Rect rect2 = this.mTempRect;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, !this.RA);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.Ru.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.Ru == null || !this.Ru.onAddFocusables(this, arrayList, i, i2)) {
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
        this.RJ = 0;
        this.mIsAttached = true;
        if (!this.RA || isLayoutRequested()) {
            z = false;
        }
        this.RA = z;
        if (this.Ru != null) {
            this.Ru.c(this);
        }
        this.Sn = false;
        if (Ri && Sf == 0) {
            float f = 60.0f;
            Display display = ViewCompat.getDisplay(this);
            if (display != null && display.getRefreshRate() >= 30.0f) {
                f = display.getRefreshRate();
            }
            Sf = 1.0E9f / f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.RR != null) {
            this.RR.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.Ru != null) {
            this.Ru.a(this, this.Rl);
        }
        this.St.clear();
        removeCallbacks(this.Su);
        this.Rp.onDetach();
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
        } else if (this.RK > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks might be run during a measure & layout pass where you cannot change the RecyclerView data. Any method call that might change the structure of the RecyclerView or the adapter contents should be postponed to the next frame.", new IllegalStateException(""));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.Rx.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.Rx.remove(onItemTouchListener);
        if (this.Ry == onItemTouchListener) {
            this.Ry = null;
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.Ry = null;
        }
        int size = this.Rx.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.Rx.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.Ry = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean h(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.Ry != null) {
            if (action == 0) {
                this.Ry = null;
            } else {
                this.Ry.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.Ry = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.Rx.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = this.Rx.get(i);
                if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent)) {
                    this.Ry = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.RD) {
            return false;
        }
        if (g(motionEvent)) {
            gG();
            return true;
        } else if (this.Ru != null) {
            boolean canScrollHorizontally = this.Ru.canScrollHorizontally();
            boolean canScrollVertically = this.Ru.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            switch (actionMasked) {
                case 0:
                    if (this.RE) {
                        this.RE = false;
                    }
                    this.RT = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.RW = x;
                    this.RU = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.RX = y;
                    this.RV = y;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.Ss;
                    this.Ss[1] = 0;
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
                    int findPointerIndex = motionEvent.findPointerIndex(this.RT);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.RT + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i2 = x2 - this.RU;
                        int i3 = y2 - this.RV;
                        if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                            z = false;
                        } else {
                            this.RW = ((i2 < 0 ? -1 : 1) * this.mTouchSlop) + this.RU;
                            z = true;
                        }
                        if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                            this.RX = this.RV + ((i3 >= 0 ? 1 : -1) * this.mTouchSlop);
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
                    this.RT = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.RW = x3;
                    this.RU = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.RX = y3;
                    this.RV = y3;
                    break;
                case 6:
                    i(motionEvent);
                    break;
            }
            return this.mScrollState == 1;
        } else {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.Rx.size();
        for (int i = 0; i < size; i++) {
            this.Rx.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.RD || this.RE) {
            return false;
        }
        if (h(motionEvent)) {
            gG();
            return true;
        } else if (this.Ru != null) {
            boolean canScrollHorizontally = this.Ru.canScrollHorizontally();
            boolean canScrollVertically = this.Ru.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.Ss;
                this.Ss[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation(this.Ss[0], this.Ss[1]);
            switch (actionMasked) {
                case 0:
                    this.RT = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.RW = x;
                    this.RU = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.RX = y;
                    this.RV = y;
                    int i = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i |= 2;
                    }
                    startNestedScroll(i);
                    break;
                case 1:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.Sa);
                    float f = canScrollHorizontally ? -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.RT) : 0.0f;
                    float f2 = canScrollVertically ? -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.RT) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !fling((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    gF();
                    z2 = true;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.RT);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.RT + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i2 = this.RW - x2;
                    int i3 = this.RX - y2;
                    if (dispatchNestedPreScroll(i2, i3, this.mScrollConsumed, this.mScrollOffset)) {
                        i2 -= this.mScrollConsumed[0];
                        i3 -= this.mScrollConsumed[1];
                        obtain.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
                        int[] iArr2 = this.Ss;
                        iArr2[0] = iArr2[0] + this.mScrollOffset[0];
                        int[] iArr3 = this.Ss;
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
                        this.RW = x2 - this.mScrollOffset[0];
                        this.RX = y2 - this.mScrollOffset[1];
                        if (a(canScrollHorizontally ? i2 : 0, canScrollVertically ? i3 : 0, obtain)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        if (Ri) {
                            this.Sg.ab(i2, i3);
                            break;
                        }
                    }
                    break;
                case 3:
                    gG();
                    break;
                case 5:
                    this.RT = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.RW = x3;
                    this.RU = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.RX = y3;
                    this.RV = y3;
                    break;
                case 6:
                    i(motionEvent);
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

    private void i(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.RT) {
            int i = actionIndex == 0 ? 1 : 0;
            this.RT = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.RW = x;
            this.RU = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.RX = y;
            this.RV = y;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.Ru != null && !this.RD && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            float f = this.Ru.canScrollVertically() ? -MotionEventCompat.getAxisValue(motionEvent, 9) : 0.0f;
            float axisValue = this.Ru.canScrollHorizontally() ? MotionEventCompat.getAxisValue(motionEvent, 10) : 0.0f;
            if (f != 0.0f || axisValue != 0.0f) {
                float scrollFactor = getScrollFactor();
                a((int) (axisValue * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.Sb == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.Sb = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                return 0.0f;
            }
        }
        return this.Sb;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.Ru == null) {
            R(i, i2);
        } else if (this.Ru.SK) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.Ru.onMeasure(this.Rl, this.Sh, i, i2);
            if (!z && this.Rt != null) {
                if (this.Sh.To == 1) {
                    gS();
                }
                this.Ru.W(i, i2);
                this.Sh.Tx = true;
                gT();
                this.Ru.X(i, i2);
                if (this.Ru.gj()) {
                    this.Ru.W(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.Sh.Tx = true;
                    gT();
                    this.Ru.X(i, i2);
                }
            }
        } else if (this.Rz) {
            this.Ru.onMeasure(this.Rl, this.Sh, i, i2);
        } else {
            if (this.RG) {
                gx();
                gN();
                if (this.Sh.Tv) {
                    this.Sh.Tt = true;
                } else {
                    this.Rn.fE();
                    this.Sh.Tt = false;
                }
                this.RG = false;
                H(false);
            }
            if (this.Rt != null) {
                this.Sh.mItemCount = this.Rt.getItemCount();
            } else {
                this.Sh.mItemCount = 0;
            }
            gx();
            this.Ru.onMeasure(this.Rl, this.Sh, i, i2);
            H(false);
            this.Sh.Tt = false;
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
        if (this.RR != null) {
            this.RR.endAnimations();
            this.RR.a(null);
        }
        this.RR = itemAnimator;
        if (this.RR != null) {
            this.RR.a(this.Sm);
        }
    }

    void gH() {
        this.RJ++;
    }

    void gI() {
        this.RJ--;
        if (this.RJ < 1) {
            this.RJ = 0;
            gK();
            hb();
        }
    }

    boolean gJ() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void gK() {
        int i = this.RF;
        this.RF = 0;
        if (i != 0 && gJ()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.RJ > 0;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
            this.RF = (contentChangeTypes != 0 ? contentChangeTypes : 0) | this.RF;
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
        return this.RR;
    }

    void gL() {
        if (!this.Sn && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.Su);
            this.Sn = true;
        }
    }

    private boolean gM() {
        return this.RR != null && this.Ru.supportsPredictiveItemAnimations();
    }

    private void gN() {
        boolean z = true;
        if (this.RI) {
            this.Rn.reset();
            gZ();
            this.Ru.onItemsChanged(this);
        }
        if (gM()) {
            this.Rn.fB();
        } else {
            this.Rn.fE();
        }
        boolean z2 = this.Sk || this.Sl;
        this.Sh.Tu = this.RA && this.RR != null && (this.RI || z2 || this.Ru.SJ) && (!this.RI || this.Rt.hasStableIds());
        State state = this.Sh;
        if (!this.Sh.Tu || !z2 || this.RI || !gM()) {
            z = false;
        }
        state.Tv = z;
    }

    void gO() {
        if (this.Rt == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.Ru == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.Sh.Tx = false;
            if (this.Sh.To == 1) {
                gS();
                this.Ru.d(this);
                gT();
            } else if (this.Rn.fF() || this.Ru.getWidth() != getWidth() || this.Ru.getHeight() != getHeight()) {
                this.Ru.d(this);
                gT();
            } else {
                this.Ru.d(this);
            }
            gU();
        }
    }

    private void gP() {
        View focusedChild = (this.Sc && hasFocus() && this.Rt != null) ? getFocusedChild() : null;
        ViewHolder findContainingViewHolder = focusedChild == null ? null : findContainingViewHolder(focusedChild);
        if (findContainingViewHolder == null) {
            gQ();
            return;
        }
        this.Sh.Tz = this.Rt.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        this.Sh.Ty = this.RI ? -1 : findContainingViewHolder.getAdapterPosition();
        this.Sh.TA = ao(findContainingViewHolder.itemView);
    }

    private void gQ() {
        this.Sh.Tz = -1L;
        this.Sh.Ty = -1;
        this.Sh.TA = -1;
    }

    private void gR() {
        View view;
        View focusedChild;
        if (this.Sc && this.Rt != null && hasFocus()) {
            if (isFocused() || ((focusedChild = getFocusedChild()) != null && this.Ro.Z(focusedChild))) {
                ViewHolder viewHolder = null;
                if (this.Sh.Ty != -1) {
                    viewHolder = findViewHolderForAdapterPosition(this.Sh.Ty);
                }
                if (viewHolder == null && this.Sh.Tz != -1 && this.Rt.hasStableIds()) {
                    viewHolder = findViewHolderForItemId(this.Sh.Tz);
                }
                if (viewHolder != null && !viewHolder.itemView.hasFocus() && viewHolder.itemView.hasFocusable()) {
                    View view2 = viewHolder.itemView;
                    if (this.Sh.TA == -1 || (view = viewHolder.itemView.findViewById(this.Sh.TA)) == null || !view.isFocusable()) {
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
        this.Sh.by(1);
        this.Sh.Tx = false;
        gx();
        this.Rp.clear();
        gH();
        gP();
        gN();
        State state = this.Sh;
        state.Tw = (this.Sh.Tu && this.Sl) ? false : false;
        this.Sl = false;
        this.Sk = false;
        this.Sh.Tt = this.Sh.Tv;
        this.Sh.mItemCount = this.Rt.getItemCount();
        f(this.Sq);
        if (this.Sh.Tu) {
            int childCount = this.Ro.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder ap = ap(this.Ro.getChildAt(i));
                if (!ap.shouldIgnore() && (!ap.isInvalid() || this.Rt.hasStableIds())) {
                    this.Rp.b(ap, this.RR.recordPreLayoutInformation(this.Sh, ap, ItemAnimator.h(ap), ap.getUnmodifiedPayloads()));
                    if (this.Sh.Tw && ap.isUpdated() && !ap.isRemoved() && !ap.shouldIgnore() && !ap.isInvalid()) {
                        this.Rp.a(e(ap), ap);
                    }
                }
            }
        }
        if (this.Sh.Tv) {
            gW();
            boolean z2 = this.Sh.Ts;
            this.Sh.Ts = false;
            this.Ru.onLayoutChildren(this.Rl, this.Sh);
            this.Sh.Ts = z2;
            for (int i2 = 0; i2 < this.Ro.getChildCount(); i2++) {
                ViewHolder ap2 = ap(this.Ro.getChildAt(i2));
                if (!ap2.shouldIgnore() && !this.Rp.r(ap2)) {
                    int h = ItemAnimator.h(ap2);
                    boolean hasAnyOfTheFlags = ap2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        h |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.RR.recordPreLayoutInformation(this.Sh, ap2, h, ap2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        a(ap2, recordPreLayoutInformation);
                    } else {
                        this.Rp.c(ap2, recordPreLayoutInformation);
                    }
                }
            }
            gX();
        } else {
            gX();
        }
        gI();
        H(false);
        this.Sh.To = 2;
    }

    private void gT() {
        gx();
        gH();
        this.Sh.by(6);
        this.Rn.fE();
        this.Sh.mItemCount = this.Rt.getItemCount();
        this.Sh.Tr = 0;
        this.Sh.Tt = false;
        this.Ru.onLayoutChildren(this.Rl, this.Sh);
        this.Sh.Ts = false;
        this.Rm = null;
        this.Sh.Tu = this.Sh.Tu && this.RR != null;
        this.Sh.To = 4;
        gI();
        H(false);
    }

    private void gU() {
        this.Sh.by(4);
        gx();
        gH();
        this.Sh.To = 1;
        if (this.Sh.Tu) {
            for (int childCount = this.Ro.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder ap = ap(this.Ro.getChildAt(childCount));
                if (!ap.shouldIgnore()) {
                    long e2 = e(ap);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.RR.recordPostLayoutInformation(this.Sh, ap);
                    ViewHolder n = this.Rp.n(e2);
                    if (n != null && !n.shouldIgnore()) {
                        boolean o = this.Rp.o(n);
                        boolean o2 = this.Rp.o(ap);
                        if (o && n == ap) {
                            this.Rp.d(ap, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo p = this.Rp.p(n);
                            this.Rp.d(ap, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo q = this.Rp.q(ap);
                            if (p == null) {
                                a(e2, ap, n);
                            } else {
                                a(n, ap, p, q, o, o2);
                            }
                        }
                    } else {
                        this.Rp.d(ap, recordPostLayoutInformation);
                    }
                }
            }
            this.Rp.a(this.Sw);
        }
        this.Ru.b(this.Rl);
        this.Sh.Tq = this.Sh.mItemCount;
        this.RI = false;
        this.Sh.Tu = false;
        this.Sh.Tv = false;
        this.Ru.SJ = false;
        if (this.Rl.SY != null) {
            this.Rl.SY.clear();
        }
        this.Ru.onLayoutCompleted(this.Sh);
        gI();
        H(false);
        this.Rp.clear();
        if (S(this.Sq[0], this.Sq[1])) {
            V(0, 0);
        }
        gR();
        gQ();
    }

    private void a(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.Ro.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder ap = ap(this.Ro.getChildAt(i));
            if (ap != viewHolder && e(ap) == j) {
                if (this.Rt != null && this.Rt.hasStableIds()) {
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
        if (this.Sh.Tw && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.Rp.a(e(viewHolder), viewHolder);
        }
        this.Rp.b(viewHolder, itemHolderInfo);
    }

    private void f(int[] iArr) {
        int childCount = this.Ro.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            ViewHolder ap = ap(this.Ro.getChildAt(i3));
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
        f(this.Sq);
        return (this.Sq[0] == i && this.Sq[1] == i2) ? false : true;
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
        return this.Rt.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.RR.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            gL();
        }
    }

    void b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        d(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.RR.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
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
            this.Rl.m(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.RR.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            gL();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        gO();
        TraceCompat.endSection();
        this.RA = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.RB == 0 && !this.RD) {
            super.requestLayout();
        } else {
            this.RC = true;
        }
    }

    void gV() {
        int fT = this.Ro.fT();
        for (int i = 0; i < fT; i++) {
            ((LayoutParams) this.Ro.bi(i).getLayoutParams()).SS = true;
        }
        this.Rl.gV();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        super.draw(canvas);
        int size = this.Rw.size();
        for (int i = 0; i < size; i++) {
            this.Rw.get(i).onDrawOver(canvas, this, this.Sh);
        }
        if (this.RL == null || this.RL.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.Rq ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate(paddingBottom + (-getHeight()), 0.0f);
            z = this.RL != null && this.RL.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.RO != null && !this.RO.isFinished()) {
            int save2 = canvas.save();
            if (this.Rq) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.RO != null && this.RO.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.RP != null && !this.RP.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.Rq ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.RP != null && this.RP.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.RQ != null && !this.RQ.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.Rq) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.RQ != null && this.RQ.draw(canvas)) {
                z3 = true;
            }
            z |= z3;
            canvas.restoreToCount(save4);
        }
        if (z || this.RR == null || this.Rw.size() <= 0 || !this.RR.isRunning()) {
            z2 = z;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.Rw.size();
        for (int i = 0; i < size; i++) {
            this.Rw.get(i).onDraw(canvas, this, this.Sh);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.Ru.checkLayoutParams((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.Ru == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Ru.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.Ru == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Ru.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.Ru == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return this.Ru.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        return this.RR != null && this.RR.isRunning();
    }

    void gW() {
        int fT = this.Ro.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Ro.bi(i));
            if (!ap.shouldIgnore()) {
                ap.saveOldPosition();
            }
        }
    }

    void gX() {
        int fT = this.Ro.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Ro.bi(i));
            if (!ap.shouldIgnore()) {
                ap.clearOldPosition();
            }
        }
        this.Rl.gX();
    }

    void T(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int fT = this.Ro.fT();
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
            ViewHolder ap = ap(this.Ro.bi(i6));
            if (ap != null && ap.mPosition >= i5 && ap.mPosition <= i4) {
                if (ap.mPosition == i) {
                    ap.offsetPosition(i2 - i, false);
                } else {
                    ap.offsetPosition(i3, false);
                }
                this.Sh.Ts = true;
            }
        }
        this.Rl.T(i, i2);
        requestLayout();
    }

    void U(int i, int i2) {
        int fT = this.Ro.fT();
        for (int i3 = 0; i3 < fT; i3++) {
            ViewHolder ap = ap(this.Ro.bi(i3));
            if (ap != null && !ap.shouldIgnore() && ap.mPosition >= i) {
                ap.offsetPosition(i2, false);
                this.Sh.Ts = true;
            }
        }
        this.Rl.U(i, i2);
        requestLayout();
    }

    void b(int i, int i2, boolean z) {
        int i3 = i + i2;
        int fT = this.Ro.fT();
        for (int i4 = 0; i4 < fT; i4++) {
            ViewHolder ap = ap(this.Ro.bi(i4));
            if (ap != null && !ap.shouldIgnore()) {
                if (ap.mPosition >= i3) {
                    ap.offsetPosition(-i2, z);
                    this.Sh.Ts = true;
                } else if (ap.mPosition >= i) {
                    ap.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.Sh.Ts = true;
                }
            }
        }
        this.Rl.b(i, i2, z);
        requestLayout();
    }

    void f(int i, int i2, Object obj) {
        int fT = this.Ro.fT();
        int i3 = i + i2;
        for (int i4 = 0; i4 < fT; i4++) {
            View bi = this.Ro.bi(i4);
            ViewHolder ap = ap(bi);
            if (ap != null && !ap.shouldIgnore() && ap.mPosition >= i && ap.mPosition < i3) {
                ap.addFlags(2);
                ap.addChangePayload(obj);
                ((LayoutParams) bi.getLayoutParams()).SS = true;
            }
        }
        this.Rl.Y(i, i2);
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        return this.RR == null || this.RR.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    void gY() {
        if (!this.RI) {
            this.RI = true;
            int fT = this.Ro.fT();
            for (int i = 0; i < fT; i++) {
                ViewHolder ap = ap(this.Ro.bi(i));
                if (ap != null && !ap.shouldIgnore()) {
                    ap.addFlags(512);
                }
            }
            this.Rl.hk();
        }
    }

    void gZ() {
        int fT = this.Ro.fT();
        for (int i = 0; i < fT; i++) {
            ViewHolder ap = ap(this.Ro.bi(i));
            if (ap != null && !ap.shouldIgnore()) {
                ap.addFlags(6);
            }
        }
        gV();
        this.Rl.gZ();
    }

    public void invalidateItemDecorations() {
        if (this.Rw.size() != 0) {
            if (this.Ru != null) {
                this.Ru.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            gV();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.Sc;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.Sc = z;
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
        return ((LayoutParams) view.getLayoutParams()).SR;
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
        if (this.Rt == null || !this.Rt.hasStableIds() || (ap = ap(view)) == null) {
            return -1L;
        }
        return ap.getItemId();
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return k(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return k(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        if (this.RI) {
            return null;
        }
        int fT = this.Ro.fT();
        int i2 = 0;
        ViewHolder viewHolder = null;
        while (i2 < fT) {
            ViewHolder ap = ap(this.Ro.bi(i2));
            if (ap == null || ap.isRemoved() || f(ap) != i) {
                ap = viewHolder;
            } else if (!this.Ro.Z(ap.itemView)) {
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
    ViewHolder k(int i, boolean z) {
        int fT = this.Ro.fT();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < fT; i2++) {
            ViewHolder ap = ap(this.Ro.bi(i2));
            if (ap != null && !ap.isRemoved()) {
                if (z) {
                    if (ap.mPosition != i) {
                        continue;
                    }
                    if (this.Ro.Z(ap.itemView)) {
                        return ap;
                    }
                    viewHolder = ap;
                } else {
                    if (ap.getLayoutPosition() != i) {
                        continue;
                    }
                    if (this.Ro.Z(ap.itemView)) {
                    }
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        if (this.Rt == null || !this.Rt.hasStableIds()) {
            return null;
        }
        int fT = this.Ro.fT();
        int i = 0;
        ViewHolder viewHolder = null;
        while (i < fT) {
            ViewHolder ap = ap(this.Ro.bi(i));
            if (ap == null || ap.isRemoved() || ap.getItemId() != j) {
                ap = viewHolder;
            } else if (!this.Ro.Z(ap.itemView)) {
                return ap;
            }
            i++;
            viewHolder = ap;
        }
        return viewHolder;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.Ro.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Ro.getChildAt(childCount);
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
        int childCount = this.Ro.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.Ro.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void offsetChildrenHorizontal(int i) {
        int childCount = this.Ro.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.Ro.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        d(view, rect);
    }

    static void d(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.Pi;
        int left = (view.getLeft() - rect2.left) - layoutParams.leftMargin;
        int top = (view.getTop() - rect2.top) - layoutParams.topMargin;
        int right = view.getRight() + rect2.right + layoutParams.rightMargin;
        int bottom = view.getBottom();
        rect.set(left, top, right, layoutParams.bottomMargin + rect2.bottom + bottom);
    }

    Rect aq(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.SS) {
            return layoutParams.Pi;
        }
        if (this.Sh.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.Pi;
        }
        Rect rect = layoutParams.Pi;
        rect.set(0, 0, 0, 0);
        int size = this.Rw.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.Rw.get(i).getItemOffsets(this.mTempRect, view, this, this.Sh);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.SS = false;
        return rect;
    }

    public void onScrolled(int i, int i2) {
    }

    void V(int i, int i2) {
        this.RK++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.Si != null) {
            this.Si.onScrolled(this, i, i2);
        }
        if (this.Sj != null) {
            for (int size = this.Sj.size() - 1; size >= 0; size--) {
                this.Sj.get(size).onScrolled(this, i, i2);
            }
        }
        this.RK--;
    }

    public void onScrollStateChanged(int i) {
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.Ru != null) {
            this.Ru.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (this.Si != null) {
            this.Si.onScrollStateChanged(this, i);
        }
        if (this.Sj != null) {
            for (int size = this.Sj.size() - 1; size >= 0; size--) {
                this.Sj.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.RA || this.RI || this.Rn.fD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        long TF;
        int[] TG;
        private int Tj;
        private int Tk;

        e() {
        }

        public void ab(int i, int i2) {
            if (RecyclerView.Ri && RecyclerView.this.Rt != null && RecyclerView.this.Ru != null && RecyclerView.this.Ru.ge() > 0) {
                this.Tj = i;
                this.Tk = i2;
                this.TF = System.nanoTime();
                RecyclerView.this.post(this);
            }
        }

        public boolean bz(int i) {
            if (this.TG != null) {
                for (int i2 = 0; i2 < this.TG.length; i2++) {
                    if (this.TG[i2] == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public void hq() {
            if (this.TG != null) {
                Arrays.fill(this.TG, -1);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4526=4] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("RV Prefetch");
                int ge = RecyclerView.this.Ru.ge();
                if (RecyclerView.this.Rt == null || RecyclerView.this.Ru == null || !RecyclerView.this.Ru.isItemPrefetchEnabled() || ge < 1 || RecyclerView.this.hasPendingAdapterUpdates()) {
                    return;
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(RecyclerView.this.getDrawingTime());
                if (nanos == 0 || RecyclerView.Sf == 0) {
                    return;
                }
                long nanoTime = System.nanoTime();
                long j = nanos + RecyclerView.Sf;
                if (nanoTime - this.TF > RecyclerView.Sf || j - nanoTime < RecyclerView.Se) {
                    return;
                }
                if (this.TG == null || this.TG.length < ge) {
                    this.TG = new int[ge];
                }
                Arrays.fill(this.TG, -1);
                RecyclerView.this.Rl.c(this.TG, RecyclerView.this.Ru.a(this.Tj, this.Tk, RecyclerView.this.Sh, this.TG));
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private int TB;
        private int TC;
        private ScrollerCompat mScroller;
        private Interpolator mInterpolator = RecyclerView.Sv;
        private boolean TD = false;
        private boolean TE = false;

        public d() {
            this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.Sv);
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
            if (RecyclerView.this.Ru == null) {
                stop();
                return;
            }
            hn();
            RecyclerView.this.gv();
            ScrollerCompat scrollerCompat = this.mScroller;
            SmoothScroller smoothScroller = RecyclerView.this.Ru.SH;
            if (scrollerCompat.computeScrollOffset()) {
                int currX = scrollerCompat.getCurrX();
                int currY = scrollerCompat.getCurrY();
                int i5 = currX - this.TB;
                int i6 = currY - this.TC;
                int i7 = 0;
                int i8 = 0;
                this.TB = currX;
                this.TC = currY;
                int i9 = 0;
                int i10 = 0;
                if (RecyclerView.this.Rt != null) {
                    RecyclerView.this.gx();
                    RecyclerView.this.gH();
                    TraceCompat.beginSection("RV Scroll");
                    if (i5 != 0) {
                        i7 = RecyclerView.this.Ru.scrollHorizontallyBy(i5, RecyclerView.this.Rl, RecyclerView.this.Sh);
                        i9 = i5 - i7;
                    }
                    if (i6 != 0) {
                        i8 = RecyclerView.this.Ru.scrollVerticallyBy(i6, RecyclerView.this.Rl, RecyclerView.this.Sh);
                        i10 = i6 - i8;
                    }
                    TraceCompat.endSection();
                    RecyclerView.this.ha();
                    RecyclerView.this.gI();
                    RecyclerView.this.H(false);
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.Sh.getItemCount();
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
                        if (!RecyclerView.this.Rw.isEmpty()) {
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
                        boolean z = (i5 != 0 && i6 == 0) || (i5 == 0 && RecyclerView.this.Ru.canScrollHorizontally() && i7 == i5) || (i6 == 0 && RecyclerView.this.Ru.canScrollVertically() && i == i6);
                        if (!scrollerCompat.isFinished() || !z) {
                            RecyclerView.this.setScrollState(0);
                            if (RecyclerView.Ri) {
                                RecyclerView.this.Sg.hq();
                            }
                        } else {
                            hp();
                            if (RecyclerView.Ri) {
                                RecyclerView.this.Sg.ab(i5, i6);
                            }
                        }
                    }
                }
                int i13 = i9;
                i = i8;
                i2 = i13;
                if (!RecyclerView.this.Rw.isEmpty()) {
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
                if (RecyclerView.Ri) {
                }
            }
            if (smoothScroller != null) {
                if (smoothScroller.isPendingInitialRun()) {
                    smoothScroller.Z(0, 0);
                }
                if (!this.TE) {
                    smoothScroller.stop();
                }
            }
            ho();
        }

        private void hn() {
            this.TE = false;
            this.TD = true;
        }

        private void ho() {
            this.TD = false;
            if (this.TE) {
                hp();
            }
        }

        void hp() {
            if (this.TD) {
                this.TE = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void aa(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.TC = 0;
            this.TB = 0;
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
            a(i, i2, i3, RecyclerView.Sv);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.TC = 0;
            this.TB = 0;
            this.mScroller.startScroll(0, 0, i, i2, i3);
            hp();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }
    }

    void ha() {
        int childCount = this.Ro.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.Ro.getChildAt(i);
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
            if (RecyclerView.this.Rt.hasStableIds()) {
                RecyclerView.this.Sh.Ts = true;
                RecyclerView.this.gY();
            } else {
                RecyclerView.this.Sh.Ts = true;
                RecyclerView.this.gY();
            }
            if (!RecyclerView.this.Rn.fD()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rn.d(i, i2, obj)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rn.z(i, i2)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rn.A(i, i2)) {
                hl();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.Rn.g(i, i2, i3)) {
                hl();
            }
        }

        void hl() {
            if (RecyclerView.Rh && RecyclerView.this.Rz && RecyclerView.this.mIsAttached) {
                ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.Rr);
                return;
            }
            RecyclerView.this.RG = true;
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class RecycledViewPool {
        private SparseArray<ArrayList<ViewHolder>> SU = new SparseArray<>();
        private SparseIntArray SV = new SparseIntArray();
        private int SW = 0;

        public void clear() {
            this.SU.clear();
        }

        public void setMaxRecycledViews(int i, int i2) {
            this.SV.put(i, i2);
            ArrayList<ViewHolder> arrayList = this.SU.get(i);
            if (arrayList != null) {
                while (arrayList.size() > i2) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        public ViewHolder getRecycledView(int i) {
            ArrayList<ViewHolder> arrayList = this.SU.get(i);
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
            if (this.SV.get(itemViewType) > bs.size()) {
                viewHolder.resetInternal();
                bs.add(viewHolder);
            }
        }

        void a(Adapter adapter) {
            this.SW++;
        }

        void detach() {
            this.SW--;
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                detach();
            }
            if (!z && this.SW == 0) {
                clear();
            }
            if (adapter2 != null) {
                a(adapter2);
            }
        }

        private ArrayList<ViewHolder> bs(int i) {
            ArrayList<ViewHolder> arrayList = this.SU.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.SU.put(i, arrayList);
                if (this.SV.indexOfKey(i) < 0) {
                    this.SV.put(i, 5);
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public final class Recycler {
        private RecycledViewPool Td;
        private ViewCacheExtension Te;
        final ArrayList<ViewHolder> SX = new ArrayList<>();
        ArrayList<ViewHolder> SY = null;
        final ArrayList<ViewHolder> SZ = new ArrayList<>();
        private final List<ViewHolder> Ta = Collections.unmodifiableList(this.SX);
        private int Tb = 2;
        int Tc = 2;

        public Recycler() {
        }

        public void clear() {
            this.SX.clear();
            hh();
        }

        public void setViewCacheSize(int i) {
            this.Tb = i;
            hg();
        }

        void hg() {
            int i = 0;
            if (RecyclerView.this.Ru != null && RecyclerView.Ri && RecyclerView.this.Ru.isItemPrefetchEnabled()) {
                i = RecyclerView.this.Ru.ge();
            }
            this.Tc = i + this.Tb;
            for (int size = this.SZ.size() - 1; size >= 0 && this.SZ.size() > this.Tc; size--) {
                bt(size);
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.Ta;
        }

        boolean i(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.Sh.isPreLayout();
            }
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.this.Rt.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
            }
            if (RecyclerView.this.Sh.isPreLayout() || RecyclerView.this.Rt.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.Rt.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.Rt.getItemId(viewHolder.mPosition);
            }
            return false;
        }

        public void bindViewToPosition(View view, int i) {
            LayoutParams layoutParams;
            ViewHolder ap = RecyclerView.ap(view);
            if (ap == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int bb = RecyclerView.this.Rn.bb(i);
            if (bb < 0 || bb >= RecyclerView.this.Rt.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bb + ").state:" + RecyclerView.this.Sh.getItemCount());
            }
            ap.mOwnerRecyclerView = RecyclerView.this;
            RecyclerView.this.Rt.bindViewHolder(ap, bb);
            at(view);
            if (RecyclerView.this.Sh.isPreLayout()) {
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
            layoutParams.SS = true;
            layoutParams.SR = ap;
            layoutParams.ST = ap.itemView.getParent() == null;
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.Sh.getItemCount()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.Sh.getItemCount());
            }
            return !RecyclerView.this.Sh.isPreLayout() ? i : RecyclerView.this.Rn.bb(i);
        }

        public View getViewForPosition(int i) {
            return l(i, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01b3  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        View l(int i, boolean z) {
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
            if (i < 0 || i >= RecyclerView.this.Sh.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.Sh.getItemCount());
            }
            if (RecyclerView.this.Sh.isPreLayout()) {
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
                int bb = RecyclerView.this.Rn.bb(i);
                if (bb < 0 || bb >= RecyclerView.this.Rt.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + bb + ").state:" + RecyclerView.this.Sh.getItemCount());
                }
                int itemViewType = RecyclerView.this.Rt.getItemViewType(bb);
                if (RecyclerView.this.Rt.hasStableIds() && (viewHolder = a(RecyclerView.this.Rt.getItemId(bb), itemViewType, z)) != null) {
                    viewHolder.mPosition = bb;
                    z3 = true;
                }
                if (viewHolder == null && this.Te != null && (viewForPositionAndType = this.Te.getViewForPositionAndType(this, i, itemViewType)) != null) {
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
                    if (RecyclerView.Rf) {
                        j(viewHolder);
                    }
                }
                if (viewHolder == null) {
                    viewHolder2 = RecyclerView.this.Rt.createViewHolder(RecyclerView.this, itemViewType);
                    z4 = z3;
                    if (z4 && !RecyclerView.this.Sh.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                        viewHolder2.setFlags(0, 8192);
                        if (RecyclerView.this.Sh.Tu) {
                            RecyclerView.this.a(viewHolder2, RecyclerView.this.RR.recordPreLayoutInformation(RecyclerView.this.Sh, viewHolder2, ItemAnimator.h(viewHolder2) | 4096, viewHolder2.getUnmodifiedPayloads()));
                        }
                    }
                    if (!RecyclerView.this.Sh.isPreLayout() && viewHolder2.isBound()) {
                        viewHolder2.mPreLayoutPosition = i;
                        z5 = false;
                    } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                        int bb2 = RecyclerView.this.Rn.bb(i);
                        viewHolder2.mOwnerRecyclerView = RecyclerView.this;
                        RecyclerView.this.Rt.bindViewHolder(viewHolder2, bb2);
                        at(viewHolder2.itemView);
                        if (RecyclerView.this.Sh.isPreLayout()) {
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
                    layoutParams2.SR = viewHolder2;
                    if (z4 || !z5) {
                        z6 = false;
                    }
                    layoutParams2.ST = z6;
                    return viewHolder2.itemView;
                }
            }
            viewHolder2 = viewHolder;
            z4 = z3;
            if (z4) {
                viewHolder2.setFlags(0, 8192);
                if (RecyclerView.this.Sh.Tu) {
                }
            }
            if (!RecyclerView.this.Sh.isPreLayout()) {
            }
            if (viewHolder2.isBound()) {
            }
            int bb22 = RecyclerView.this.Rn.bb(i);
            viewHolder2.mOwnerRecyclerView = RecyclerView.this;
            RecyclerView.this.Rt.bindViewHolder(viewHolder2, bb22);
            at(viewHolder2.itemView);
            if (RecyclerView.this.Sh.isPreLayout()) {
            }
            z5 = true;
            layoutParams = viewHolder2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            layoutParams2.SR = viewHolder2;
            if (z4) {
            }
            z6 = false;
            layoutParams2.ST = z6;
            return viewHolder2.itemView;
        }

        private void at(View view) {
            if (RecyclerView.this.gJ()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.So.getItemDelegate());
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
            for (int size = this.SZ.size() - 1; size >= 0; size--) {
                bt(size);
            }
            this.SZ.clear();
            if (RecyclerView.Ri) {
                RecyclerView.this.Sg.hq();
            }
        }

        void bt(int i) {
            l(this.SZ.get(i));
            this.SZ.remove(i);
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
                if ((RecyclerView.this.Rt != null && doesTransientStatePreventRecycling && RecyclerView.this.Rt.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.Tc <= 0 || viewHolder.hasAnyOfTheFlags(14)) {
                        z = false;
                    } else {
                        int size = this.SZ.size();
                        if (size >= this.Tc && size > 0) {
                            bt(0);
                            size--;
                        }
                        if (RecyclerView.Ri && size > 0 && !RecyclerView.this.Sg.bz(viewHolder.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.Sg.bz(this.SZ.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.SZ.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        l(viewHolder);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.Rp.u(viewHolder);
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
                if (ap.isInvalid() && !ap.isRemoved() && !RecyclerView.this.Rt.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                }
                ap.setScrapContainer(this, false);
                this.SX.add(ap);
                return;
            }
            if (this.SY == null) {
                this.SY = new ArrayList<>();
            }
            ap.setScrapContainer(this, true);
            this.SY.add(ap);
        }

        void m(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.SY.remove(viewHolder);
            } else {
                this.SX.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        int hi() {
            return this.SX.size();
        }

        View bu(int i) {
            return this.SX.get(i).itemView;
        }

        void hj() {
            this.SX.clear();
            if (this.SY != null) {
                this.SY.clear();
            }
        }

        ViewHolder bv(int i) {
            int size;
            int bb;
            if (this.SY == null || (size = this.SY.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.SY.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (RecyclerView.this.Rt.hasStableIds() && (bb = RecyclerView.this.Rn.bb(i)) > 0 && bb < RecyclerView.this.Rt.getItemCount()) {
                long itemId = RecyclerView.this.Rt.getItemId(bb);
                for (int i3 = 0; i3 < size; i3++) {
                    ViewHolder viewHolder2 = this.SY.get(i3);
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
            int size2 = this.SX.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ViewHolder viewHolder = this.SX.get(i3);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.Sh.Tt || !viewHolder.isRemoved())) {
                    if (i2 != -1 && viewHolder.getItemViewType() != i2) {
                        Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has wrong view type! (found " + viewHolder.getItemViewType() + " but expected " + i2 + ")");
                        if (z && (F = RecyclerView.this.Ro.F(i, i2)) != null) {
                            ViewHolder ap = RecyclerView.ap(F);
                            RecyclerView.this.Ro.ab(F);
                            int indexOfChild = RecyclerView.this.Ro.indexOfChild(F);
                            if (indexOfChild == -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ap);
                            }
                            RecyclerView.this.Ro.detachViewFromParent(indexOfChild);
                            av(F);
                            ap.addFlags(8224);
                            return ap;
                        }
                        size = this.SZ.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ViewHolder viewHolder2 = this.SZ.get(i4);
                            if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i) {
                                if (!z) {
                                    this.SZ.remove(i4);
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
            size = this.SZ.size();
            while (i4 < size) {
            }
            return null;
        }

        ViewHolder a(long j, int i, boolean z) {
            for (int size = this.SX.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SX.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.Sh.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                            return viewHolder;
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.SX.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        au(viewHolder.itemView);
                    }
                }
            }
            for (int size2 = this.SZ.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.SZ.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.SZ.remove(size2);
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
            if (RecyclerView.this.Rv != null) {
                RecyclerView.this.Rv.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.Rt != null) {
                RecyclerView.this.Rt.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.Sh != null) {
                RecyclerView.this.Rp.u(viewHolder);
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
            int size = this.SZ.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.SZ.get(i6);
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
            int size = this.SZ.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.SZ.get(i3);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        void b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.SZ.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SZ.get(size);
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
            this.Te = viewCacheExtension;
        }

        void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            if (this.Td != null) {
                this.Td.detach();
            }
            this.Td = recycledViewPool;
            if (recycledViewPool != null) {
                this.Td.a(RecyclerView.this.getAdapter());
            }
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.Td == null) {
                this.Td = new RecycledViewPool();
            }
            return this.Td;
        }

        void Y(int i, int i2) {
            int layoutPosition;
            int i3 = i + i2;
            for (int size = this.SZ.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.SZ.get(size);
                if (viewHolder != null && (layoutPosition = viewHolder.getLayoutPosition()) >= i && layoutPosition < i3) {
                    viewHolder.addFlags(2);
                    bt(size);
                }
            }
        }

        void hk() {
            int size = this.SZ.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.SZ.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(512);
                }
            }
        }

        void gZ() {
            if (RecyclerView.this.Rt != null && RecyclerView.this.Rt.hasStableIds()) {
                int size = this.SZ.size();
                for (int i = 0; i < size; i++) {
                    ViewHolder viewHolder = this.SZ.get(i);
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
            int size = this.SZ.size();
            for (int i = 0; i < size; i++) {
                this.SZ.get(i).clearOldPosition();
            }
            int size2 = this.SX.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.SX.get(i2).clearOldPosition();
            }
            if (this.SY != null) {
                int size3 = this.SY.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.SY.get(i3).clearOldPosition();
                }
            }
        }

        void gV() {
            int size = this.SZ.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.SZ.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.SS = true;
                }
            }
        }

        boolean bw(int i) {
            int fT = RecyclerView.this.Ro.fT();
            for (int i2 = 0; i2 < fT; i2++) {
                if (RecyclerView.ap(RecyclerView.this.Ro.bi(i2)).mPosition == i) {
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
        private final a Sy = new a();
        private boolean Sz = false;

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
                ((LayoutParams) layoutParams).SS = true;
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
            this.Sz = z;
        }

        public long getItemId(int i) {
            return -1L;
        }

        public final boolean hasStableIds() {
            return this.Sz;
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
            return this.Sy.hasObservers();
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.Sy.registerObserver(adapterDataObserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.Sy.unregisterObserver(adapterDataObserver);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.Sy.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.Sy.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.Sy.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.Sy.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.Sy.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.Sy.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.Sy.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.Sy.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.Sy.notifyItemRangeRemoved(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.Sy.notifyItemRangeRemoved(i, i2);
        }
    }

    void ar(View view) {
        ViewHolder ap = ap(view);
        onChildDetachedFromWindow(view);
        if (this.Rt != null && ap != null) {
            this.Rt.onViewDetachedFromWindow(ap);
        }
        if (this.RH != null) {
            for (int size = this.RH.size() - 1; size >= 0; size--) {
                this.RH.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void as(View view) {
        ViewHolder ap = ap(view);
        onChildAttachedToWindow(view);
        if (this.Rt != null && ap != null) {
            this.Rt.onViewAttachedToWindow(ap);
        }
        if (this.RH != null) {
            for (int size = this.RH.size() - 1; size >= 0; size--) {
                this.RH.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class LayoutManager {
        k Ro;
        RecyclerView SG;
        SmoothScroller SH;
        private int SO;
        private int SQ;
        private int mHeight;
        private int mWidth;
        boolean SJ = false;
        boolean nL = false;
        boolean SK = false;
        private boolean SL = true;
        private boolean SM = true;

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
                this.SG = null;
                this.Ro = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.SG = recyclerView;
                this.Ro = recyclerView.Ro;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.SO = 1073741824;
            this.SQ = 1073741824;
        }

        void W(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.SO = View.MeasureSpec.getMode(i);
            if (this.SO == 0 && !RecyclerView.Rg) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.SQ = View.MeasureSpec.getMode(i2);
            if (this.SQ == 0 && !RecyclerView.Rg) {
                this.mHeight = 0;
            }
        }

        void X(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int childCount = getChildCount();
            if (childCount == 0) {
                this.SG.R(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Rect rect = this.SG.mTempRect;
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
            this.SG.mTempRect.set(i7, i3, i6, i4);
            setMeasuredDimension(this.SG.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            if (this.SG != null) {
                this.SG.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.SG != null) {
                this.SG.assertInLayoutOrScroll(str);
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
            if (this.SG != null) {
                this.SG.assertNotInLayoutOrScroll(str);
            }
        }

        public void setAutoMeasureEnabled(boolean z) {
            this.SK = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.SK;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.SM) {
                this.SM = z;
                if (this.SG != null) {
                    this.SG.Rl.hg();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.SM;
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
            if (this.SG != null) {
                ViewCompat.postOnAnimation(this.SG, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            if (this.SG != null) {
                return this.SG.removeCallbacks(runnable);
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
            return this.SG != null && this.SG.Rq;
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
            if (this.SH != null && smoothScroller != this.SH && this.SH.isRunning()) {
                this.SH.stop();
            }
            this.SH = smoothScroller;
            this.SH.a(this.SG, this);
        }

        public boolean isSmoothScrolling() {
            return this.SH != null && this.SH.isRunning();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.SG);
        }

        public void endAnimation(View view) {
            if (this.SG.RR != null) {
                this.SG.RR.endAnimation(RecyclerView.ap(view));
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
                this.SG.Rp.s(ap);
            } else {
                this.SG.Rp.t(ap);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (ap.wasReturnedFromScrap() || ap.isScrap()) {
                if (ap.isScrap()) {
                    ap.unScrap();
                } else {
                    ap.clearReturnedFromScrapFlag();
                }
                this.Ro.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.SG) {
                int indexOfChild = this.Ro.indexOfChild(view);
                if (i == -1) {
                    i = this.Ro.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.SG.indexOfChild(view));
                }
                if (indexOfChild != i) {
                    this.SG.Ru.moveView(indexOfChild, i);
                }
            } else {
                this.Ro.b(view, i, false);
                layoutParams.SS = true;
                if (this.SH != null && this.SH.isRunning()) {
                    this.SH.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.ST) {
                ap.itemView.invalidate();
                layoutParams.ST = false;
            }
        }

        public void removeView(View view) {
            this.Ro.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.Ro.removeViewAt(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.Ro.removeViewAt(childCount);
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
            if (this.SG == null || (findContainingItemView = this.SG.findContainingItemView(view)) == null || this.Ro.Z(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder ap = RecyclerView.ap(childAt);
                if (ap != null && ap.getLayoutPosition() == i && !ap.shouldIgnore() && (this.SG.Sh.isPreLayout() || !ap.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int indexOfChild = this.Ro.indexOfChild(view);
            if (indexOfChild >= 0) {
                a(indexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            a(i, getChildAt(i));
        }

        private void a(int i, View view) {
            this.Ro.detachViewFromParent(i);
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap.isRemoved()) {
                this.SG.Rp.s(ap);
            } else {
                this.SG.Rp.t(ap);
            }
            this.Ro.a(view, i, layoutParams, ap.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.SG.removeDetachedView(view, false);
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
            a(recycler, this.Ro.indexOfChild(view), view);
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
            if (this.Ro != null) {
                return this.Ro.getChildCount();
            }
            return 0;
        }

        public View getChildAt(int i) {
            if (this.Ro != null) {
                return this.Ro.getChildAt(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.SO;
        }

        public int getHeightMode() {
            return this.SQ;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            if (this.SG != null) {
                return this.SG.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            if (this.SG != null) {
                return this.SG.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            if (this.SG != null) {
                return this.SG.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            if (this.SG != null) {
                return this.SG.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            if (this.SG != null) {
                return ViewCompat.getPaddingStart(this.SG);
            }
            return 0;
        }

        public int getPaddingEnd() {
            if (this.SG != null) {
                return ViewCompat.getPaddingEnd(this.SG);
            }
            return 0;
        }

        public boolean isFocused() {
            return this.SG != null && this.SG.isFocused();
        }

        public boolean hasFocus() {
            return this.SG != null && this.SG.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            if (this.SG == null || (focusedChild = this.SG.getFocusedChild()) == null || this.Ro.Z(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            Adapter adapter = this.SG != null ? this.SG.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            if (this.SG != null) {
                this.SG.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            if (this.SG != null) {
                this.SG.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.SG || this.SG.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            }
            ViewHolder ap = RecyclerView.ap(view);
            ap.addFlags(128);
            this.SG.Rp.u(ap);
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
                if (ap.isInvalid() && !ap.isRemoved() && !this.SG.Rt.hasStableIds()) {
                    removeViewAt(i);
                    recycler.k(ap);
                    return;
                }
                detachViewAt(i);
                recycler.av(view);
                this.SG.Rp.v(ap);
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
                        this.SG.removeDetachedView(bu, false);
                    }
                    if (this.SG.RR != null) {
                        this.SG.RR.endAnimation(ap);
                    }
                    ap.setIsRecyclable(true);
                    recycler.au(bu);
                }
            }
            recycler.hj();
            if (hi > 0) {
                this.SG.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect aq = this.SG.aq(view);
            int i3 = aq.top;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), aq.left + aq.right + i + getPaddingLeft() + getPaddingRight(), layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), aq.bottom + i3 + i2 + getPaddingTop() + getPaddingBottom(), layoutParams.height, canScrollVertically());
            if (b(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.SL && h(view.getMeasuredWidth(), i, layoutParams.width) && h(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.SL && h(view.getWidth(), i, layoutParams.width) && h(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.SL;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.SL = z;
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
            Rect aq = this.SG.aq(view);
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
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pi;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pi;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).Pi;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.Pi;
            view.layout(rect.left + i + layoutParams.leftMargin, rect.top + i2 + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).Pi;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.SG != null && (matrix = ViewCompat.getMatrix(view)) != null && !matrix.isIdentity()) {
                RectF rectF = this.SG.Rs;
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
            if (this.SG == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.SG.aq(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pi.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pi.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pi.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).Pi.right;
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
            this.SG.R(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.SG.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.SG);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.SG);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        void he() {
            if (this.SH != null) {
                this.SH.stop();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SmoothScroller smoothScroller) {
            if (this.SH == smoothScroller) {
                this.SH = null;
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
            onInitializeAccessibilityNodeInfo(this.SG.Rl, this.SG.Sh, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.SG, -1) || ViewCompat.canScrollHorizontally(this.SG, -1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.SG, 1) || ViewCompat.canScrollHorizontally(this.SG, 1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.SG.Rl, this.SG.Sh, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            if (this.SG != null && asRecord != null) {
                if (!ViewCompat.canScrollVertically(this.SG, 1) && !ViewCompat.canScrollVertically(this.SG, -1) && !ViewCompat.canScrollHorizontally(this.SG, -1) && !ViewCompat.canScrollHorizontally(this.SG, 1)) {
                    z = false;
                }
                asRecord.setScrollable(z);
                if (this.SG.Rt != null) {
                    asRecord.setItemCount(this.SG.Rt.getItemCount());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder ap = RecyclerView.ap(view);
            if (ap != null && !ap.isRemoved() && !this.Ro.Z(ap.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.SG.Rl, this.SG.Sh, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.SJ = true;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            if (this.SG == null || this.SG.Rt == null || !canScrollVertically()) {
                return 1;
            }
            return this.SG.Rt.getItemCount();
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            if (this.SG == null || this.SG.Rt == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.SG.Rt.getItemCount();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.SG.Rl, this.SG.Sh, i, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle) {
            int height;
            int i2;
            int width;
            if (this.SG == null) {
                return false;
            }
            switch (i) {
                case 4096:
                    height = ViewCompat.canScrollVertically(this.SG, 1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                    if (ViewCompat.canScrollHorizontally(this.SG, 1)) {
                        i2 = height;
                        width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                        break;
                    }
                    i2 = height;
                    width = 0;
                    break;
                case 8192:
                    height = ViewCompat.canScrollVertically(this.SG, -1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                    if (ViewCompat.canScrollHorizontally(this.SG, -1)) {
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
            this.SG.scrollBy(width, i2);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.SG.Rl, this.SG.Sh, view, i, bundle);
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
                ((LayoutParams) this.itemView.getLayoutParams()).SS = true;
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
            this.St.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    void hb() {
        for (int size = this.St.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.St.get(size);
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
        this.St.clear();
    }

    int f(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.Rn.bc(viewHolder.mPosition);
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
        final Rect Pi;
        ViewHolder SR;
        boolean SS;
        boolean ST;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Pi = new Rect();
            this.SS = true;
            this.ST = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.Pi = new Rect();
            this.SS = true;
            this.ST = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.Pi = new Rect();
            this.SS = true;
            this.ST = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Pi = new Rect();
            this.SS = true;
            this.ST = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.Pi = new Rect();
            this.SS = true;
            this.ST = false;
        }

        public boolean viewNeedsUpdate() {
            return this.SR.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.SR.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.SR.isRemoved();
        }

        public boolean isItemChanged() {
            return this.SR.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.SR.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.SR.getLayoutPosition();
        }

        public int getViewAdapterPosition() {
            return this.SR.getAdapterPosition();
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
        private RecyclerView SG;
        private boolean Th;
        private LayoutManager mLayoutManager;
        private boolean mRunning;
        private View yH;
        private int Tg = -1;
        private final Action Ti = new Action(0, 0);

        /* loaded from: classes2.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        void a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.SG = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.Tg == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.SG.Sh.Tg = this.Tg;
            this.mRunning = true;
            this.Th = true;
            this.yH = findViewByPosition(getTargetPosition());
            onStart();
            this.SG.Sd.hp();
        }

        public void setTargetPosition(int i) {
            this.Tg = i;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                onStop();
                this.SG.Sh.Tg = -1;
                this.yH = null;
                this.Tg = -1;
                this.Th = false;
                this.mRunning = false;
                this.mLayoutManager.a(this);
                this.mLayoutManager = null;
                this.SG = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.Th;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.Tg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z(int i, int i2) {
            RecyclerView recyclerView = this.SG;
            if (!this.mRunning || this.Tg == -1 || recyclerView == null) {
                stop();
            }
            this.Th = false;
            if (this.yH != null) {
                if (getChildPosition(this.yH) == this.Tg) {
                    onTargetFound(this.yH, recyclerView.Sh, this.Ti);
                    this.Ti.e(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.yH = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.Sh, this.Ti);
                boolean hm = this.Ti.hm();
                this.Ti.e(recyclerView);
                if (hm) {
                    if (this.mRunning) {
                        this.Th = true;
                        recyclerView.Sd.hp();
                        return;
                    }
                    stop();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.SG.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.SG.Ru.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.SG.Ru.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.SG.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.yH = view;
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
            private int Tj;
            private int Tk;
            private int Tl;
            private boolean Tm;
            private int Tn;
            private int mDuration;
            private Interpolator mInterpolator;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public Action(int i, int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.Tl = -1;
                this.Tm = false;
                this.Tn = 0;
                this.Tj = i;
                this.Tk = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            public void jumpTo(int i) {
                this.Tl = i;
            }

            boolean hm() {
                return this.Tl >= 0;
            }

            void e(RecyclerView recyclerView) {
                if (this.Tl >= 0) {
                    int i = this.Tl;
                    this.Tl = -1;
                    recyclerView.br(i);
                    this.Tm = false;
                } else if (this.Tm) {
                    validate();
                    if (this.mInterpolator == null) {
                        if (this.mDuration == Integer.MIN_VALUE) {
                            recyclerView.Sd.smoothScrollBy(this.Tj, this.Tk);
                        } else {
                            recyclerView.Sd.i(this.Tj, this.Tk, this.mDuration);
                        }
                    } else {
                        recyclerView.Sd.a(this.Tj, this.Tk, this.mDuration, this.mInterpolator);
                    }
                    this.Tn++;
                    if (this.Tn > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.Tm = false;
                } else {
                    this.Tn = 0;
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
                return this.Tj;
            }

            public void setDx(int i) {
                this.Tm = true;
                this.Tj = i;
            }

            public int getDy() {
                return this.Tk;
            }

            public void setDy(int i) {
                this.Tm = true;
                this.Tk = i;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public void setDuration(int i) {
                this.Tm = true;
                this.mDuration = i;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.Tm = true;
                this.mInterpolator = interpolator;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.Tj = i;
                this.Tk = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.Tm = true;
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
        Parcelable Tf;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Tf = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.Tf, 0);
        }

        void a(SavedState savedState) {
            this.Tf = savedState.Tf;
        }
    }

    /* loaded from: classes2.dex */
    public static class State {
        int TA;
        private SparseArray<Object> Tp;
        int Ty;
        long Tz;
        private int Tg = -1;
        int To = 1;
        int mItemCount = 0;
        int Tq = 0;
        int Tr = 0;
        boolean Ts = false;
        boolean Tt = false;
        boolean Tu = false;
        boolean Tv = false;
        boolean Tw = false;
        boolean Tx = false;

        void by(int i) {
            if ((this.To & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.To));
            }
        }

        public boolean isMeasuring() {
            return this.Tx;
        }

        public boolean isPreLayout() {
            return this.Tt;
        }

        public boolean willRunPredictiveAnimations() {
            return this.Tv;
        }

        public boolean willRunSimpleAnimations() {
            return this.Tu;
        }

        public void remove(int i) {
            if (this.Tp != null) {
                this.Tp.remove(i);
            }
        }

        public <T> T get(int i) {
            if (this.Tp == null) {
                return null;
            }
            return (T) this.Tp.get(i);
        }

        public void put(int i, Object obj) {
            if (this.Tp == null) {
                this.Tp = new SparseArray<>();
            }
            this.Tp.put(i, obj);
        }

        public int getTargetScrollPosition() {
            return this.Tg;
        }

        public boolean hasTargetScrollPosition() {
            return this.Tg != -1;
        }

        public boolean didStructureChange() {
            return this.Ts;
        }

        public int getItemCount() {
            return this.Tt ? this.Tq - this.Tr : this.mItemCount;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.Tg + ", mData=" + this.Tp + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.Tq + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.Tr + ", mStructureChanged=" + this.Ts + ", mInPreLayout=" + this.Tt + ", mRunSimpleAnimations=" + this.Tu + ", mRunPredictiveAnimations=" + this.Tv + '}';
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
        private a SA = null;
        private ArrayList<ItemAnimatorFinishedListener> SB = new ArrayList<>();
        private long SC = 120;
        private long SD = 120;
        private long SE = 250;
        private long SF = 250;

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
            return this.SE;
        }

        public void setMoveDuration(long j) {
            this.SE = j;
        }

        public long getAddDuration() {
            return this.SC;
        }

        public void setAddDuration(long j) {
            this.SC = j;
        }

        public long getRemoveDuration() {
            return this.SD;
        }

        public void setRemoveDuration(long j) {
            this.SD = j;
        }

        public long getChangeDuration() {
            return this.SF;
        }

        public void setChangeDuration(long j) {
            this.SF = j;
        }

        void a(a aVar) {
            this.SA = aVar;
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
            if (this.SA != null) {
                this.SA.onAnimationFinished(viewHolder);
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
                    this.SB.add(itemAnimatorFinishedListener);
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
            int size = this.SB.size();
            for (int i = 0; i < size; i++) {
                this.SB.get(i).onAnimationsFinished();
            }
            this.SB.clear();
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
        return this.Sp == null ? super.getChildDrawingOrder(i, i2) : this.Sp.onGetChildDrawingOrder(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.Sr == null) {
            this.Sr = new NestedScrollingChildHelper(this);
        }
        return this.Sr;
    }
}
