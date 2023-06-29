package com.baidu.nadcore.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.tieba.id1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class SlidingPaneLayout extends ViewGroup {
    public static final f A;
    public int a;
    public int b;
    public Drawable c;
    public final int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public View h;
    public float i;
    public float j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public float o;
    public float p;
    public e q;
    public final id1 r;
    public double s;
    public double t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final Rect x;
    public final ArrayList<c> y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface e {
        void onPanelClosed(View view2);

        void onPanelOpened(View view2);

        void onPanelSlide(View view2, float f);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(SlidingPaneLayout slidingPaneLayout, View view2);
    }

    public abstract void m(Activity activity);

    public abstract void q();

    public abstract void r();

    public abstract void w(boolean z);

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] e = {16843137};
        public float a;
        public boolean b;
        public boolean c;
        public Paint d;

        public LayoutParams() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AccessibilityDelegateCompat {
        public final Rect a = new Rect();

        public b() {
        }

        public boolean filter(View view2) {
            return SlidingPaneLayout.this.y(view2);
        }

        public final void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.a;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view2, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view2);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view2);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
            if (!filter(view2)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public final View a;

        public c(View view2) {
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.a, 0, null);
                SlidingPaneLayout.this.x(this.a);
            }
            SlidingPaneLayout.this.y.remove(this);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends id1.c {
        public int a;

        public d() {
        }

        @Override // com.baidu.tieba.id1.c
        public int d(View view2) {
            return SlidingPaneLayout.this.k;
        }

        @Override // com.baidu.tieba.id1.c
        public void g(int i, int i2) {
            if (!SlidingPaneLayout.this.f) {
                SlidingPaneLayout.this.r();
            }
            SlidingPaneLayout.this.r.c(SlidingPaneLayout.this.h, i2);
        }

        @Override // com.baidu.tieba.id1.c
        public void j(View view2, int i) {
            SlidingPaneLayout.this.G();
        }

        @Override // com.baidu.tieba.id1.c
        public boolean n(View view2, int i) {
            if (SlidingPaneLayout.this.l) {
                return false;
            }
            if (!SlidingPaneLayout.this.f) {
                SlidingPaneLayout.this.r();
            }
            return ((LayoutParams) view2.getLayoutParams()).b;
        }

        @Override // com.baidu.tieba.id1.c
        public int a(View view2, int i, int i2) {
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) SlidingPaneLayout.this.h.getLayoutParams())).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.k + paddingLeft);
        }

        @Override // com.baidu.tieba.id1.c
        public boolean f() {
            return SlidingPaneLayout.this.f;
        }

        @Override // com.baidu.tieba.id1.c
        public void k(int i) {
            if (SlidingPaneLayout.this.r.y() == 0) {
                if (SlidingPaneLayout.this.i == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                    slidingPaneLayout.I(slidingPaneLayout.h);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.t(slidingPaneLayout2.h);
                    SlidingPaneLayout.this.v = false;
                    return;
                }
                SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                slidingPaneLayout3.u(slidingPaneLayout3.h);
                SlidingPaneLayout.this.v = true;
            }
        }

        @Override // com.baidu.tieba.id1.c
        public void l(View view2, int i, int i2, int i3, int i4) {
            this.a = i;
            SlidingPaneLayout.this.C(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // com.baidu.tieba.id1.c
        public void m(View view2, float f, float f2) {
            int i;
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view2.getLayoutParams())).leftMargin;
            if (!SlidingPaneLayout.this.g && !SlidingPaneLayout.this.f) {
                return;
            }
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 == 0 && SlidingPaneLayout.this.i > 0.25f) {
                if (SlidingPaneLayout.this.z) {
                    i = SlidingPaneLayout.this.k;
                } else {
                    i = this.a + 10;
                }
                SlidingPaneLayout.this.r.J(paddingLeft + i, view2.getTop());
                SlidingPaneLayout.this.invalidate();
                return;
            }
            if (i2 > 0) {
                paddingLeft += SlidingPaneLayout.this.k;
            }
            SlidingPaneLayout.this.r.J(paddingLeft, view2.getTop());
            SlidingPaneLayout.this.invalidate();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            A = new h();
        } else {
            A = new g();
        }
    }

    public boolean B() {
        return this.e;
    }

    public boolean D() {
        return E(this.h, 0);
    }

    public void G() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.r.l(true)) {
            if (!this.e) {
                this.r.a();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public int getCoveredFadeColor() {
        return this.b;
    }

    public int getParallaxDistance() {
        return this.n;
    }

    public int getSliderFadeColor() {
        return this.a;
    }

    public boolean o() {
        return p(this.h, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.w = true;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).run();
        }
        this.y.clear();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (B()) {
            z = z();
        } else {
            z = this.v;
        }
        savedState.isOpen = z;
        return savedState;
    }

    public boolean z() {
        if (this.e && this.i != 1.0f) {
            return false;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean isOpen;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isOpen = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements f {
        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view2) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends g {
        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.g, com.baidu.nadcore.widget.SlidingPaneLayout.f
        public void a(SlidingPaneLayout slidingPaneLayout, View view2) {
            ViewCompat.setLayerPaint(view2, ((LayoutParams) view2.getLayoutParams()).d);
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public static boolean J(View view2) {
        Drawable background;
        if (Build.VERSION.SDK_INT >= 18 || (background = view2.getBackground()) == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void A(boolean z) {
        this.u = z;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            D();
        } else {
            o();
        }
        this.v = savedState.isOpen;
    }

    public void setActivityIsTranslucent(boolean z) {
        this.f = z;
    }

    public void setAutoSlideToRight(boolean z) {
        this.z = z;
    }

    public void setCanSlideRegionFactor(double d2) {
        this.s = d2;
    }

    public void setCoveredFadeColor(int i) {
        this.b = i;
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        this.g = z;
    }

    public void setPanelSlideListener(e eVar) {
        this.q = eVar;
    }

    public void setParallaxDistance(int i) {
        this.n = i;
        requestLayout();
    }

    public void setShadowDrawable(Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.a = i;
    }

    public void t(View view2) {
        e eVar = this.q;
        if (eVar != null) {
            eVar.onPanelClosed(view2);
        }
        sendAccessibilityEvent(32);
    }

    public void u(View view2) {
        e eVar = this.q;
        if (eVar != null) {
            eVar.onPanelOpened(view2);
        }
        sendAccessibilityEvent(32);
    }

    public void v(View view2) {
        e eVar = this.q;
        if (eVar != null) {
            eVar.onPanelSlide(view2, this.i);
        }
    }

    public final void x(View view2) {
        A.a(this, view2);
    }

    public boolean y(View view2) {
        if (view2 == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (!this.e || !layoutParams.c || this.i <= 0.0f) {
            return false;
        }
        return true;
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean E(View view2, int i) {
        if (!this.w && !H(1.0f, i)) {
            return false;
        }
        this.v = true;
        return true;
    }

    public final boolean p(View view2, int i) {
        if (!this.w && !H(0.0f, i)) {
            return false;
        }
        this.v = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        boolean z;
        super.requestChildFocus(view2, view3);
        if (!isInTouchMode() && !this.e) {
            if (view2 == this.h) {
                z = true;
            } else {
                z = false;
            }
            this.v = z;
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -858993460;
        this.g = true;
        this.s = 0.25d;
        this.t = 0.15d;
        this.u = true;
        this.w = true;
        this.x = new Rect();
        this.y = new ArrayList<>();
        this.z = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.d = 5;
        this.m = context.getResources().getDisplayMetrics().widthPixels;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new b());
        ViewCompat.setImportantForAccessibility(this, 1);
        id1 m = id1.m(this, 0.5f, new d());
        this.r = m;
        m.H(1);
        this.r.I(f2 * 400.0f);
    }

    public final void C(int i) {
        View view2;
        if (!this.e || (view2 = this.h) == null) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        float paddingLeft = (i - (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin)) / this.k;
        this.i = paddingLeft;
        if (this.n != 0) {
            F(paddingLeft);
        }
        if (layoutParams.c) {
            s(this.h, this.i, this.a);
        }
        v(this.h);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view2;
        try {
            super.draw(canvas);
            if (getChildCount() > 1) {
                view2 = getChildAt(1);
            } else {
                view2 = null;
            }
            if (this.u && view2 != null && this.c != null) {
                int intrinsicWidth = this.c.getIntrinsicWidth();
                int left = view2.getLeft();
                int top = view2.getTop();
                int bottom = view2.getBottom();
                this.c.setBounds(left - intrinsicWidth, top, left, bottom);
                this.c.draw(canvas);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void F(float f2) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        if (layoutParams.c && ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.h) {
                int i2 = this.n;
                this.j = f2;
                childAt.offsetLeftAndRight(((int) ((1.0f - this.j) * i2)) - ((int) ((1.0f - f2) * i2)));
                if (z) {
                    s(childAt, 1.0f - this.j, this.b);
                }
            }
        }
    }

    public boolean H(float f2, int i) {
        if (!this.e) {
            return false;
        }
        int paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.h.getLayoutParams())).leftMargin + (f2 * this.k));
        id1 id1Var = this.r;
        View view2 = this.h;
        if (!id1Var.L(view2, paddingLeft, view2.getTop())) {
            return false;
        }
        G();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void I(View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        int i5;
        View view3 = view2;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view3 != null && J(view2)) {
            i = view2.getLeft();
            i2 = view2.getRight();
            i3 = view2.getTop();
            i4 = view2.getBottom();
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount && (childAt = getChildAt(i6)) != view3) {
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i && max2 >= i3 && min <= i2 && min2 <= i4) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            childAt.setVisibility(i5);
            i6++;
            view3 = view2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    if (Math.abs(motionEvent.getY() - this.p) > Math.abs(x - this.o)) {
                        return true;
                    }
                }
            } else if (y(this.h)) {
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                float f2 = x2 - this.o;
                float f3 = y - this.p;
                int x3 = this.r.x();
                if ((f2 * f2) + (f3 * f3) < x3 * x3 && this.r.A(this.h, (int) x2, (int) y)) {
                    p(this.h, 0);
                }
            }
        } else {
            float x4 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.o = x4;
            this.p = y2;
        }
        try {
            this.r.B(motionEvent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ObsoleteSdkInt"})
    public boolean drawChild(Canvas canvas, View view2, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        int save = canvas.save();
        if (this.e && !layoutParams.b && this.h != null && this.z) {
            canvas.getClipBounds(this.x);
            Rect rect = this.x;
            rect.right = Math.min(rect.right, this.h.getLeft());
            canvas.clipRect(this.x);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view2, j);
        } else if (layoutParams.c && this.i > 0.0f) {
            if (!view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, view2.getLeft(), view2.getTop(), layoutParams.d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view2 + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view2, j);
            }
        } else {
            if (view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view2, j);
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean n(View view2, boolean z, int i, int i2, int i3) {
        int i4;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && n(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z && ViewCompat.canScrollHorizontally(view2, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
        if (y(r13.h) != false) goto L33;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View childAt;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!this.e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.v = !this.r.A(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (motionEvent.getX() >= ((int) (this.m * this.s))) {
            this.r.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (this.e && (!this.l || actionMasked == 0)) {
            if (actionMasked != 3 && actionMasked != 1) {
                if (actionMasked != 0) {
                    if (actionMasked == 2) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float abs = Math.abs(x - this.o);
                        float abs2 = Math.abs(y - this.p);
                        int x2 = this.r.x();
                        if (abs <= 0.0f || abs <= abs2 || !this.e || x >= this.m * this.t) {
                            if ((abs > x2 && abs2 > abs) || n(this, false, Math.round(x - this.o), Math.round(x), Math.round(y))) {
                                this.r.b();
                                this.l = true;
                                return false;
                            }
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    this.l = false;
                    float x3 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.o = x3;
                    this.p = y2;
                    if (this.r.A(this.h, (int) x3, (int) y2)) {
                    }
                    z = false;
                }
                try {
                    z2 = this.r.K(motionEvent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
                if (z2 || z) {
                    return true;
                }
                return false;
            }
            this.r.b();
            return false;
        } else {
            this.r.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean z2;
        float f2;
        int i7 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.w) {
            if (this.e && this.v) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            this.i = f2;
        }
        int i8 = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int i10 = i7 - paddingRight;
                    int min = (Math.min(paddingLeft, i10 - this.d) - i8) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.k = min;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i8 + min + (measuredWidth / 2) > i10) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    layoutParams.c = z2;
                    i8 += ((int) (min * this.i)) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                } else if (this.e && (i5 = this.n) != 0) {
                    i6 = (int) ((1.0f - this.i) * i5);
                    i8 = paddingLeft;
                    int i11 = i8 - i6;
                    childAt.layout(i11, paddingTop, measuredWidth + i11, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getWidth();
                } else {
                    i8 = paddingLeft;
                }
                i6 = 0;
                int i112 = i8 - i6;
                childAt.layout(i112, paddingTop, measuredWidth + i112, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
        }
        if (this.w) {
            if (this.e) {
                if (this.n != 0) {
                    F(this.i);
                }
                if (((LayoutParams) this.h.getLayoutParams()).c) {
                    s(this.h, this.i, this.a);
                }
            } else {
                for (int i12 = 0; i12 < childCount; i12++) {
                    s(getChildAt(i12), 0.0f, this.a);
                }
            }
            I(this.h);
        }
        this.w = false;
    }

    @Override // android.view.View
    @SuppressLint({"BDThrowableCheck"})
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        boolean z;
        int measuredWidth;
        int i5;
        int makeMeasureSpec;
        int i6;
        int makeMeasureSpec2;
        int i7;
        int i8;
        int makeMeasureSpec3;
        int i9;
        int makeMeasureSpec4;
        boolean z2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (mode2 == 0) {
            if (isInEditMode()) {
                if (mode2 == 0) {
                    mode2 = Integer.MIN_VALUE;
                    size2 = 300;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
        boolean z3 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i3 = 0;
                paddingTop = 0;
            } else {
                i3 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i3;
            }
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.h = null;
        float f2 = 0.0f;
        int i10 = 0;
        boolean z4 = false;
        float f3 = 0.0f;
        while (true) {
            i4 = 8;
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.c = z3;
            } else {
                float f4 = layoutParams.a;
                if (f4 > f2) {
                    f3 += f4;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i12 == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i11, Integer.MIN_VALUE);
                    i8 = -1;
                } else {
                    i8 = -1;
                    if (i12 == -1) {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i11, 1073741824);
                    } else {
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    }
                }
                int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i13 == -2) {
                    i9 = Integer.MIN_VALUE;
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else {
                    i9 = Integer.MIN_VALUE;
                    if (i13 == i8) {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                    } else {
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                    }
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i9 && measuredHeight > i3) {
                    i3 = Math.min(measuredHeight, paddingTop);
                }
                paddingLeft -= measuredWidth2;
                if (paddingLeft < 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                layoutParams.b = z2;
                z4 |= z2;
                if (z2) {
                    this.h = childAt;
                }
            }
            i10++;
            z3 = false;
            f2 = 0.0f;
        }
        if (z4 || f3 > 0.0f) {
            int i14 = size - this.d;
            int i15 = 0;
            while (i15 < childCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.a > 0.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            measuredWidth = 0;
                        } else {
                            measuredWidth = childAt2.getMeasuredWidth();
                        }
                        if (z4 && childAt2 != this.h) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth > i14 || layoutParams2.a > 0.0f)) {
                                if (z) {
                                    int i16 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i16 == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i6 = 1073741824;
                                    } else if (i16 == -1) {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                    }
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (this.z) {
                                    i7 = i14;
                                } else {
                                    i7 = size;
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.a > 0.0f) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                int i17 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i17 == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i5 = 1073741824;
                                } else if (i17 == -1) {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i5 = 1073741824;
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                                }
                            } else {
                                i5 = 1073741824;
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z4) {
                                int i18 = size - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i18, i5);
                                if (measuredWidth != i18) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                            } else {
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((layoutParams2.a * Math.max(0, paddingLeft)) / f3)), 1073741824), makeMeasureSpec);
                                i15++;
                                i4 = 8;
                            }
                        }
                    }
                }
                i15++;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, i3);
        this.e = z4;
        if (this.r.y() != 0 && !z4) {
            this.r.a();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.w = true;
        }
    }

    public final void s(View view2, float f2, int i) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (f2 > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f2)) << 24) | (i & 16777215);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view2) != 2) {
                ViewCompat.setLayerType(view2, 2, layoutParams.d);
            }
            x(view2);
        } else if (ViewCompat.getLayerType(view2) != 0) {
            Paint paint = layoutParams.d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            c cVar = new c(view2);
            this.y.add(cVar);
            ViewCompat.postOnAnimation(this, cVar);
        }
    }
}
