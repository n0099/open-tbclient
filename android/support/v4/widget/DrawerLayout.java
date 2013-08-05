package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.aq;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f328a = {16842931};
    private int b;
    private int c;
    private float d;
    private Paint e;
    private final ad f;
    private final ad g;
    private final g h;
    private final g i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private d q;
    private float r;
    private float s;
    private Drawable t;
    private Drawable u;

    /* loaded from: classes.dex */
    public abstract class SimpleDrawerListener implements d {
    }

    public void setScrimColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setDrawerListener(d dVar) {
        this.q = dVar;
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void a(int i, int i2) {
        int a2 = android.support.v4.view.n.a(i2, aq.e(this));
        if (a2 == 3) {
            this.m = i;
        } else if (a2 == 5) {
            this.n = i;
        }
        if (i != 0) {
            (a2 == 3 ? this.f : this.g).e();
        }
        switch (i) {
            case 1:
                View a3 = a(a2);
                if (a3 != null) {
                    i(a3);
                    return;
                }
                return;
            case 2:
                View a4 = a(a2);
                if (a4 != null) {
                    h(a4);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int a(View view) {
        int e = e(view);
        if (e == 3) {
            return this.m;
        }
        if (e == 5) {
            return this.n;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, View view) {
        int i3 = 1;
        int a2 = this.f.a();
        int a3 = this.g.a();
        if (a2 != 1 && a3 != 1) {
            i3 = (a2 == 2 || a3 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            e eVar = (e) view.getLayoutParams();
            if (eVar.b == 0.0f) {
                b(view);
            } else if (eVar.b == 1.0f) {
                c(view);
            }
        }
        if (i3 != this.j) {
            this.j = i3;
            if (this.q != null) {
                this.q.a(i3);
            }
        }
    }

    void b(View view) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.d) {
            eVar.d = false;
            if (this.q != null) {
                this.q.b(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    void c(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.d) {
            eVar.d = true;
            if (this.q != null) {
                this.q.a(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    void a(View view, float f) {
        if (this.q != null) {
            this.q.a(view, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, float f) {
        e eVar = (e) view.getLayoutParams();
        if (f != eVar.b) {
            eVar.b = f;
            a(view, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d(View view) {
        return ((e) view.getLayoutParams()).b;
    }

    int e(View view) {
        return android.support.v4.view.n.a(((e) view.getLayoutParams()).f336a, aq.e(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((e) childAt.getLayoutParams()).d) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == (i & 7)) {
                return childAt;
            }
        }
        return null;
    }

    static String b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int e;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - eVar.leftMargin) - eVar.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - eVar.topMargin) - eVar.bottomMargin, 1073741824));
                } else if (g(childAt)) {
                    if ((0 & e(childAt) & 7) != 0) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + b(e) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    childAt.measure(getChildMeasureSpec(i, this.b + eVar.leftMargin + eVar.rightMargin, eVar.width), getChildMeasureSpec(i2, eVar.topMargin + eVar.bottomMargin, eVar.height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        this.k = true;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(eVar.leftMargin, eVar.topMargin, eVar.leftMargin + childAt.getMeasuredWidth(), eVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        i5 = (-measuredWidth) + ((int) (measuredWidth * eVar.b));
                    } else {
                        i5 = (i3 - i) - ((int) (measuredWidth * eVar.b));
                    }
                    switch (eVar.f336a & 112) {
                        case 16:
                            int i7 = i4 - i2;
                            int i8 = (i7 - measuredHeight) / 2;
                            if (i8 < eVar.topMargin) {
                                i8 = eVar.topMargin;
                            } else if (i8 + measuredHeight > i7 - eVar.bottomMargin) {
                                i8 = (i7 - eVar.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i8, measuredWidth + i5, measuredHeight + i8);
                            break;
                        case com.baidu.loginshare.e.i /* 80 */:
                            int i9 = i4 - i2;
                            childAt.layout(i5, (i9 - eVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i9 - eVar.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, eVar.topMargin, measuredWidth + i5, measuredHeight);
                            break;
                    }
                    if (eVar.b == 0.0f) {
                        childAt.setVisibility(4);
                    }
                }
            }
        }
        this.k = false;
        this.l = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.k) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((e) getChildAt(i).getLayoutParams()).b);
        }
        this.d = f;
        if (this.f.a(true) | this.g.a(true)) {
            aq.b(this);
        }
    }

    private static boolean k(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && k(childAt) && g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right <= i2) {
                            right = i2;
                        }
                        i2 = right;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        int i4 = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.d > 0.0f && f) {
            this.e.setColor((((int) (((this.c & (-16777216)) >>> 24) * this.d)) << 24) | (this.c & 16777215));
            canvas.drawRect(i2, 0.0f, i4, getHeight(), this.e);
        } else if (this.t != null && a(view, 3)) {
            int intrinsicWidth = this.t.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f.b(), 1.0f));
            this.t.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.t.setAlpha((int) (255.0f * max));
            this.t.draw(canvas);
        } else if (this.u != null && a(view, 5)) {
            int intrinsicWidth2 = this.u.getIntrinsicWidth();
            int left = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left) / this.g.b(), 1.0f));
            this.u.setBounds(left - intrinsicWidth2, view.getTop(), left, view.getBottom());
            this.u.setAlpha((int) (255.0f * max2));
            this.u.draw(canvas);
        }
        return drawChild;
    }

    boolean f(View view) {
        return ((e) view.getLayoutParams()).f336a == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(View view) {
        return (android.support.v4.view.n.a(((e) view.getLayoutParams()).f336a, aq.e(view)) & 7) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int a2 = android.support.v4.view.z.a(motionEvent);
        boolean a3 = this.f.a(motionEvent) | this.g.a(motionEvent);
        switch (a2) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.r = x;
                this.s = y;
                z = this.d > 0.0f && f(this.f.e((int) x, (int) y));
                this.o = false;
                this.p = false;
                break;
            case 1:
            case 3:
                a(true);
                this.o = false;
                this.p = false;
                z = false;
                break;
            case 2:
                if (this.f.c(3)) {
                    this.h.a();
                    this.i.a();
                    z = false;
                    break;
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        return a3 || z || d() || this.p;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View a2;
        this.f.b(motionEvent);
        this.g.b(motionEvent);
        switch (motionEvent.getAction() & Util.MASK_8BIT) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.r = x;
                this.s = y;
                this.o = false;
                this.p = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View e = this.f.e((int) x2, (int) y2);
                if (e != null && f(e)) {
                    float f = x2 - this.r;
                    float f2 = y2 - this.s;
                    int d = this.f.d();
                    if ((f * f) + (f2 * f2) < d * d && (a2 = a()) != null) {
                        z = a(a2) == 2;
                        a(z);
                        this.o = false;
                        break;
                    }
                }
                z = true;
                a(z);
                this.o = false;
                break;
            case 3:
                a(true);
                this.o = false;
                this.p = false;
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (!this.f.d(1) && !this.g.d(2)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
        this.o = z;
        if (z) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    void a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (g(childAt) && (!z || eVar.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    z2 |= this.f.a(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.g.a(childAt, getWidth(), childAt.getTop());
                }
                eVar.c = false;
            }
        }
        this.h.a();
        this.i.a();
        if (z2) {
            invalidate();
        }
    }

    public void h(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.l) {
            e eVar = (e) view.getLayoutParams();
            eVar.b = 1.0f;
            eVar.d = true;
        } else if (a(view, 3)) {
            this.f.a(view, 0, view.getTop());
        } else {
            this.g.a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public void i(View view) {
        if (!g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.l) {
            e eVar = (e) view.getLayoutParams();
            eVar.b = 0.0f;
            eVar.d = false;
        } else if (a(view, 3)) {
            this.f.a(view, -view.getWidth(), view.getTop());
        } else {
            this.g.a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public boolean j(View view) {
        if (g(view)) {
            return ((e) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    private boolean d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((e) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    private boolean e() {
        return f() != null;
    }

    private View f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && e()) {
            android.support.v4.view.s.b(keyEvent);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View f = f();
            if (f != null && a(f) == 0) {
                b();
            }
            return f != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View a2;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f329a != 0 && (a2 = a(savedState.f329a)) != null) {
            h(a2);
        }
        a(savedState.b, 3);
        a(savedState.c, 5);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            if (g(childAt)) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.d) {
                    savedState.f329a = eVar.f336a;
                    break;
                }
            }
            i++;
        }
        savedState.b = this.m;
        savedState.c = this.n;
        return savedState;
    }

    /* loaded from: classes.dex */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new f();

        /* renamed from: a  reason: collision with root package name */
        int f329a;
        int b;
        int c;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f329a = 0;
            this.b = 0;
            this.c = 0;
            this.f329a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f329a = 0;
            this.b = 0;
            this.c = 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f329a);
        }
    }
}
