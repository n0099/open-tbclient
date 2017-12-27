package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    WeakReference<View> lA;
    private BottomSheetCallback lB;
    private int lC;
    boolean lD;
    private final ViewDragHelper.Callback lE;
    private float lk;
    private int ll;
    private boolean lm;
    private int ln;
    int lo;
    int lp;
    boolean lq;
    private boolean lr;
    ViewDragHelper lt;
    private boolean lu;
    private int lw;
    private boolean lx;
    int ly;
    int mActivePointerId;
    int mState;
    private VelocityTracker mVelocityTracker;
    WeakReference<V> mViewRef;

    /* loaded from: classes2.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.mState = 4;
        this.lE = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.mState == 1 || BottomSheetBehavior.this.lD) {
                    return false;
                }
                if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i && (view2 = BottomSheetBehavior.this.lA.get()) != null && ViewCompat.canScrollVertically(view2, -1)) {
                    return false;
                }
                return BottomSheetBehavior.this.mViewRef != null && BottomSheetBehavior.this.mViewRef.get() == view;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.p(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.o(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < 0.0f) {
                    i = BottomSheetBehavior.this.lo;
                } else if (BottomSheetBehavior.this.lq && BottomSheetBehavior.this.m(view, f2)) {
                    i = BottomSheetBehavior.this.ly;
                    i2 = 5;
                } else if (f2 == 0.0f) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.lo) < Math.abs(top - BottomSheetBehavior.this.lp)) {
                        i = BottomSheetBehavior.this.lo;
                    } else {
                        i = BottomSheetBehavior.this.lp;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.lp;
                    i2 = 4;
                }
                if (BottomSheetBehavior.this.lt.settleCapturedViewAt(view.getLeft(), i)) {
                    BottomSheetBehavior.this.o(2);
                    ViewCompat.postOnAnimation(view, new a(view, i2));
                    return;
                }
                BottomSheetBehavior.this.o(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return m.constrain(i, BottomSheetBehavior.this.lo, BottomSheetBehavior.this.lq ? BottomSheetBehavior.this.ly : BottomSheetBehavior.this.lp);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return BottomSheetBehavior.this.lq ? BottomSheetBehavior.this.ly - BottomSheetBehavior.this.lo : BottomSheetBehavior.this.lp - BottomSheetBehavior.this.lo;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 4;
        this.lE = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.mState == 1 || BottomSheetBehavior.this.lD) {
                    return false;
                }
                if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i && (view2 = BottomSheetBehavior.this.lA.get()) != null && ViewCompat.canScrollVertically(view2, -1)) {
                    return false;
                }
                return BottomSheetBehavior.this.mViewRef != null && BottomSheetBehavior.this.mViewRef.get() == view;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.p(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.o(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < 0.0f) {
                    i = BottomSheetBehavior.this.lo;
                } else if (BottomSheetBehavior.this.lq && BottomSheetBehavior.this.m(view, f2)) {
                    i = BottomSheetBehavior.this.ly;
                    i2 = 5;
                } else if (f2 == 0.0f) {
                    int top = view.getTop();
                    if (Math.abs(top - BottomSheetBehavior.this.lo) < Math.abs(top - BottomSheetBehavior.this.lp)) {
                        i = BottomSheetBehavior.this.lo;
                    } else {
                        i = BottomSheetBehavior.this.lp;
                        i2 = 4;
                    }
                } else {
                    i = BottomSheetBehavior.this.lp;
                    i2 = 4;
                }
                if (BottomSheetBehavior.this.lt.settleCapturedViewAt(view.getLeft(), i)) {
                    BottomSheetBehavior.this.o(2);
                    ViewCompat.postOnAnimation(view, new a(view, i2));
                    return;
                }
                BottomSheetBehavior.this.o(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return m.constrain(i, BottomSheetBehavior.this.lo, BottomSheetBehavior.this.lq ? BottomSheetBehavior.this.ly : BottomSheetBehavior.this.lp);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                return BottomSheetBehavior.this.lq ? BottomSheetBehavior.this.ly - BottomSheetBehavior.this.lo : BottomSheetBehavior.this.lp - BottomSheetBehavior.this.lo;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && peekValue.data == -1) {
            setPeekHeight(peekValue.data);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.lk = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.mState);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.ly = coordinatorLayout.getHeight();
        if (this.lm) {
            if (this.ln == 0) {
                this.ln = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            i2 = Math.max(this.ln, this.ly - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i2 = this.ll;
        }
        this.lo = Math.max(0, this.ly - v.getHeight());
        this.lp = Math.max(this.ly - i2, this.lo);
        if (this.mState == 3) {
            ViewCompat.offsetTopAndBottom(v, this.lo);
        } else if (this.lq && this.mState == 5) {
            ViewCompat.offsetTopAndBottom(v, this.ly);
        } else if (this.mState == 4) {
            ViewCompat.offsetTopAndBottom(v, this.lp);
        } else if (this.mState == 1 || this.mState == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.lt == null) {
            this.lt = ViewDragHelper.create(coordinatorLayout, this.lE);
        }
        this.mViewRef = new WeakReference<>(v);
        this.lA = new WeakReference<>(t(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (!v.isShown()) {
            this.lu = true;
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                int x = (int) motionEvent.getX();
                this.lC = (int) motionEvent.getY();
                View view = this.lA.get();
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.lC)) {
                    this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.lD = true;
                }
                this.lu = this.mActivePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.lC);
                break;
            case 1:
            case 3:
                this.lD = false;
                this.mActivePointerId = -1;
                if (this.lu) {
                    this.lu = false;
                    return false;
                }
                break;
        }
        if (this.lu || !this.lt.shouldInterceptTouchEvent(motionEvent)) {
            View view2 = this.lA.get();
            if (actionMasked != 2 || view2 == null || this.lu || this.mState == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(this.lC - motionEvent.getY()) <= this.lt.getTouchSlop()) {
                z = false;
            }
            return z;
        }
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.mState == 1 && actionMasked == 0) {
                return true;
            }
            this.lt.processTouchEvent(motionEvent);
            if (actionMasked == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked == 2 && !this.lu && Math.abs(this.lC - motionEvent.getY()) > this.lt.getTouchSlop()) {
                this.lt.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.lu;
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.lw = 0;
        this.lx = false;
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == this.lA.get()) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.lo) {
                    iArr[1] = top - this.lo;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    o(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    o(1);
                }
            } else if (i2 < 0 && !ViewCompat.canScrollVertically(view, -1)) {
                if (i3 <= this.lp || this.lq) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    o(1);
                } else {
                    iArr[1] = top - this.lp;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    o(4);
                }
            }
            p(v.getTop());
            this.lw = i2;
            this.lx = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.lo) {
            o(3);
        } else if (view == this.lA.get() && this.lx) {
            if (this.lw > 0) {
                i = this.lo;
            } else if (this.lq && m(v, getYVelocity())) {
                i = this.ly;
                i2 = 5;
            } else if (this.lw == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.lo) < Math.abs(top - this.lp)) {
                    i = this.lo;
                } else {
                    i = this.lp;
                    i2 = 4;
                }
            } else {
                i = this.lp;
                i2 = 4;
            }
            if (this.lt.smoothSlideViewTo(v, v.getLeft(), i)) {
                o(2);
                ViewCompat.postOnAnimation(v, new a(v, i2));
            } else {
                o(i2);
            }
            this.lx = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.lA.get() && (this.mState != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    public final void setPeekHeight(int i) {
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.lm) {
                this.lm = true;
            }
            z = false;
        } else {
            if (this.lm || this.ll != i) {
                this.lm = false;
                this.ll = Math.max(0, i);
                this.lp = this.ly - i;
            }
            z = false;
        }
        if (z && this.mState == 4 && this.mViewRef != null && (v = this.mViewRef.get()) != null) {
            v.requestLayout();
        }
    }

    public final int getPeekHeight() {
        if (this.lm) {
            return -1;
        }
        return this.ll;
    }

    public void setHideable(boolean z) {
        this.lq = z;
    }

    public boolean isHideable() {
        return this.lq;
    }

    public void setSkipCollapsed(boolean z) {
        this.lr = z;
    }

    public boolean getSkipCollapsed() {
        return this.lr;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.lB = bottomSheetCallback;
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.mViewRef == null) {
                if (i == 4 || i == 3 || (this.lq && i == 5)) {
                    this.mState = i;
                    return;
                }
                return;
            }
            final V v = this.mViewRef.get();
            if (v != null) {
                ViewParent parent = v.getParent();
                if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
                    v.post(new Runnable() { // from class: android.support.design.widget.BottomSheetBehavior.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BottomSheetBehavior.this.c(v, i);
                        }
                    });
                } else {
                    c(v, i);
                }
            }
        }
    }

    public final int getState() {
        return this.mState;
    }

    void o(int i) {
        if (this.mState != i) {
            this.mState = i;
            V v = this.mViewRef.get();
            if (v != null && this.lB != null) {
                this.lB.onStateChanged(v, i);
            }
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    boolean m(View view, float f) {
        if (this.lr) {
            return true;
        }
        return view.getTop() >= this.lp && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.lp)) / ((float) this.ll) > 0.5f;
    }

    private View t(View view) {
        if (!(view instanceof NestedScrollingChild)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View t = t(viewGroup.getChildAt(i));
                    if (t != null) {
                        return t;
                    }
                }
            }
            return null;
        }
        return view;
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.lk);
        return VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
    }

    void c(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.lp;
        } else if (i == 3) {
            i2 = this.lo;
        } else if (this.lq && i == 5) {
            i2 = this.ly;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        o(2);
        if (this.lt.smoothSlideViewTo(view, view.getLeft(), i2)) {
            ViewCompat.postOnAnimation(view, new a(view, i));
        }
    }

    void p(int i) {
        V v = this.mViewRef.get();
        if (v != null && this.lB != null) {
            if (i > this.lp) {
                this.lB.onSlide(v, (this.lp - i) / (this.ly - this.lp));
            } else {
                this.lB.onSlide(v, (this.lp - i) / (this.lp - this.lo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private final int mTargetState;
        private final View mView;

        a(View view, int i) {
            this.mView = view;
            this.mTargetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.lt != null && BottomSheetBehavior.this.lt.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else {
                BottomSheetBehavior.this.o(this.mTargetState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.design.widget.BottomSheetBehavior.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: c */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: q */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) behavior;
    }
}
