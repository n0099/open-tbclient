package android.support.v4.widget;

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
import android.support.v4.view.aq;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final z f348a;
    private int b;
    private int c;
    private Drawable d;
    private final int e;
    private boolean f;
    private View g;
    private float h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private float m;
    private float n;
    private x o;
    private final ad p;
    private boolean q;
    private boolean r;
    private final Rect s;
    private final ArrayList<v> t;

    /* loaded from: classes.dex */
    public class SimplePanelSlideListener implements x {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f348a = new ac();
        } else if (i >= 16) {
            f348a = new ab();
        } else {
            f348a = new aa();
        }
    }

    public void setParallaxDistance(int i) {
        this.l = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.l;
    }

    public void setSliderFadeColor(int i) {
        this.b = i;
    }

    public int getSliderFadeColor() {
        return this.b;
    }

    public void setCoveredFadeColor(int i) {
        this.c = i;
    }

    public int getCoveredFadeColor() {
        return this.c;
    }

    public void setPanelSlideListener(x xVar) {
        this.o = xVar;
    }

    void a(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null && c(view)) {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                int max = Math.max(paddingLeft, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                int min = Math.min(width, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                childAt.setVisibility(i5);
            } else {
                return;
            }
        }
    }

    void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean c(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        int size = this.t.size();
        for (int i = 0; i < size; i++) {
            this.t.get(i).run();
        }
        this.t.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int paddingTop;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i4;
        int i5;
        boolean z;
        float f;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 == 0) {
            throw new IllegalStateException("Height must not be UNSPECIFIED");
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                i3 = 0;
                paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                i3 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i3;
                break;
            default:
                i3 = 0;
                paddingTop = -1;
                break;
        }
        boolean z2 = false;
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        int i6 = 0;
        int i7 = i3;
        float f2 = 0.0f;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            w wVar = (w) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                wVar.c = false;
                i4 = paddingLeft;
                f = f2;
                i5 = i7;
                z = z2;
            } else {
                if (wVar.f359a > 0.0f) {
                    f2 += wVar.f359a;
                    if (wVar.width == 0) {
                        i4 = paddingLeft;
                        f = f2;
                        i5 = i7;
                        z = z2;
                    }
                }
                int i8 = wVar.leftMargin + wVar.rightMargin;
                if (wVar.width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i8, Integer.MIN_VALUE);
                } else if (wVar.width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(size - i8, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(wVar.width, 1073741824);
                }
                if (wVar.height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (wVar.height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(wVar.height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i7) {
                    i7 = Math.min(measuredHeight, paddingTop);
                }
                int i9 = paddingLeft - measuredWidth;
                boolean z3 = i9 < 0;
                wVar.b = z3;
                boolean z4 = z3 | z2;
                if (wVar.b) {
                    this.g = childAt;
                }
                i4 = i9;
                i5 = i7;
                float f3 = f2;
                z = z4;
                f = f3;
            }
            i6++;
            z2 = z;
            i7 = i5;
            f2 = f;
            paddingLeft = i4;
        }
        if (z2 || f2 > 0.0f) {
            int i10 = size - this.e;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2.getVisibility() != 8) {
                    w wVar2 = (w) childAt2.getLayoutParams();
                    boolean z5 = wVar2.width == 0 && wVar2.f359a > 0.0f;
                    int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                    if (z2 && childAt2 != this.g) {
                        if (wVar2.width < 0 && (measuredWidth2 > i10 || wVar2.f359a > 0.0f)) {
                            if (z5) {
                                if (wVar2.height == -2) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (wVar2.height == -1) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(wVar2.height, 1073741824);
                                }
                            } else {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), makeMeasureSpec2);
                        }
                    } else if (wVar2.f359a > 0.0f) {
                        if (wVar2.width == 0) {
                            if (wVar2.height == -2) {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                            } else if (wVar2.height == -1) {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(wVar2.height, 1073741824);
                            }
                        } else {
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                        }
                        if (z2) {
                            int i12 = size - (wVar2.rightMargin + wVar2.leftMargin);
                            int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                            if (measuredWidth2 != i12) {
                                childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                            }
                        } else {
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((wVar2.f359a * Math.max(0, paddingLeft)) / f2)) + measuredWidth2, 1073741824), makeMeasureSpec);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(size, i7);
        this.f = z2;
        if (this.p.a() != 0 && !z2) {
            this.p.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.r) {
            this.h = (this.f && this.q) ? 1.0f : 0.0f;
        }
        int i8 = 0;
        int i9 = paddingLeft;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                i6 = i9;
            } else {
                w wVar = (w) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (wVar.b) {
                    int min = (Math.min(paddingLeft, (i7 - paddingRight) - this.e) - i9) - (wVar.leftMargin + wVar.rightMargin);
                    this.j = min;
                    wVar.c = ((wVar.leftMargin + i9) + min) + (measuredWidth / 2) > i7 - paddingRight;
                    i6 = wVar.leftMargin + ((int) (min * this.h)) + i9;
                    i5 = 0;
                } else if (!this.f || this.l == 0) {
                    i5 = 0;
                    i6 = paddingLeft;
                } else {
                    i5 = (int) ((1.0f - this.h) * this.l);
                    i6 = paddingLeft;
                }
                int i10 = i6 - i5;
                childAt.layout(i10, paddingTop, i10 + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
            i8++;
            i9 = i6;
        }
        if (this.r) {
            if (this.f) {
                if (this.l != 0) {
                    a(this.h);
                }
                if (((w) this.g.getLayoutParams()).c) {
                    a(this.g, this.h, this.b);
                }
            } else {
                for (int i11 = 0; i11 < childCount; i11++) {
                    a(getChildAt(i11), 0.0f, this.b);
                }
            }
            a(this.g);
        }
        this.r = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.r = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f) {
            this.q = view == this.g;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int a2 = android.support.v4.view.z.a(motionEvent);
        if (!this.f && a2 == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.q = !this.p.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f || (this.k && a2 != 0)) {
            this.p.e();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (a2 == 3 || a2 == 1) {
            this.p.e();
            return false;
        } else {
            switch (a2) {
                case 0:
                    this.k = false;
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.m = x;
                    this.n = y;
                    if (this.p.b(this.g, (int) x, (int) y) && b(this.g)) {
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                default:
                    z = false;
                    break;
                case 2:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float abs = Math.abs(x2 - this.m);
                    float abs2 = Math.abs(y2 - this.n);
                    if (abs > this.p.d() && abs2 > abs) {
                        this.p.e();
                        this.k = true;
                        return false;
                    }
                    z = false;
                    break;
            }
            return this.p.a(motionEvent) || z;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        this.p.b(motionEvent);
        switch (motionEvent.getAction() & Util.MASK_8BIT) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.m = x;
                this.n = y;
                return true;
            case 1:
                if (!b(this.g)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.m;
                float f2 = y2 - this.n;
                int d = this.p.d();
                if ((f * f) + (f2 * f2) >= d * d || !this.p.b(this.g, (int) x2, (int) y2)) {
                    return true;
                }
                a(this.g, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean a(View view, int i) {
        if (this.r || a(0.0f, i)) {
            this.q = false;
            return true;
        }
        return false;
    }

    private boolean b(View view, int i) {
        if (this.r || a(1.0f, i)) {
            this.q = true;
            return true;
        }
        return false;
    }

    public boolean b() {
        return b(this.g, 0);
    }

    public boolean c() {
        return a(this.g, 0);
    }

    public boolean d() {
        return !this.f || this.h == 1.0f;
    }

    public boolean e() {
        return this.f;
    }

    private void a(View view, float f, int i) {
        w wVar = (w) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (16777215 & i);
            if (wVar.d == null) {
                wVar.d = new Paint();
            }
            wVar.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (aq.d(view) != 2) {
                aq.a(view, 2, wVar.d);
            }
            d(view);
        } else if (aq.d(view) != 0) {
            if (wVar.d != null) {
                wVar.d.setColorFilter(null);
            }
            v vVar = new v(this, view);
            this.t.add(vVar);
            aq.a(this, vVar);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        w wVar = (w) view.getLayoutParams();
        int save = canvas.save(2);
        if (this.f && !wVar.b && this.g != null) {
            canvas.getClipBounds(this.s);
            this.s.right = Math.min(this.s.right, this.g.getLeft());
            canvas.clipRect(this.s);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (wVar.c && this.h > 0.0f) {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, view.getLeft(), view.getTop(), wVar.d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        } else {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        f348a.a(this, view);
    }

    boolean a(float f, int i) {
        if (this.f) {
            int paddingLeft = getPaddingLeft();
            if (this.p.a(this.g, (int) (((w) this.g.getLayoutParams()).leftMargin + paddingLeft + (this.j * f)), this.g.getTop())) {
                a();
                aq.b(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.a(true)) {
            if (!this.f) {
                this.p.f();
            } else {
                aq.b(this);
            }
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        this.d = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && this.d != null) {
            int intrinsicWidth = this.d.getIntrinsicWidth();
            int left = childAt.getLeft();
            this.d.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
            this.d.draw(canvas);
        }
    }

    private void a(float f) {
        w wVar = (w) this.g.getLayoutParams();
        boolean z = wVar.c && wVar.leftMargin <= 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.g) {
                this.i = f;
                childAt.offsetLeftAndRight(((int) ((1.0f - this.i) * this.l)) - ((int) ((1.0f - f) * this.l)));
                if (z) {
                    a(childAt, 1.0f - this.i, this.c);
                }
            }
        }
    }

    boolean b(View view) {
        if (view == null) {
            return false;
        }
        return this.f && ((w) view.getLayoutParams()).c && this.h > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new w();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new w((ViewGroup.MarginLayoutParams) layoutParams) : new w(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof w) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new w(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f349a = e() ? d() : this.q;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f349a) {
            b();
        } else {
            c();
        }
        this.q = savedState.f349a;
    }

    /* loaded from: classes.dex */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: a  reason: collision with root package name */
        boolean f349a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f349a = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f349a ? 1 : 0);
        }
    }
}
