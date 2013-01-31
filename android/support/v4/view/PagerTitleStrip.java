package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup implements af {
    private static final int[] k = {16842804, 16842904, 16842901};
    ViewPager a;
    private TextView b;
    private TextView c;
    private TextView d;
    private int e;
    private float f;
    private int g;
    private boolean h;
    private boolean i;
    private final l j;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        k adapter = viewPager.getAdapter();
        viewPager.a(this.j);
        viewPager.setOnAdapterChangeListener(this.j);
        this.a = viewPager;
        a((k) null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        a(this.a.getAdapter(), (k) null);
        this.a.a((aj) null);
        this.a.setOnAdapterChangeListener(null);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, k kVar) {
        CharSequence charSequence = null;
        int count = kVar != null ? kVar.getCount() : 0;
        this.h = true;
        this.b.setText((i < 1 || kVar == null) ? null : kVar.getPageTitle(i - 1));
        this.c.setText(kVar != null ? kVar.getPageTitle(i) : null);
        if (i + 1 < count && kVar != null) {
            charSequence = kVar.getPageTitle(i + 1);
        }
        this.d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.e = i;
        if (!this.i) {
            a(i, this.f);
        }
        this.h = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.h) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar, k kVar2) {
        if (kVar != null) {
            kVar.unregisterDataSetObserver(this.j);
        }
        if (kVar2 != null) {
            kVar2.registerDataSetObserver(this.j);
        }
        if (this.a != null) {
            this.e = -1;
            this.f = -1.0f;
            a(this.a.getCurrentItem(), kVar2);
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (i != this.e) {
            a(i, this.a.getAdapter());
        } else if (f == this.f) {
            return;
        }
        this.i = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i5 = ((width - i3) - ((int) (f2 * i4))) - (measuredWidth2 / 2);
        int i6 = measuredWidth2 + i5;
        this.c.layout(i5, paddingTop, i6, this.c.getMeasuredHeight() + paddingTop);
        int min = Math.min(paddingLeft, (i5 - this.g) - measuredWidth);
        this.b.layout(min, paddingTop, measuredWidth + min, this.b.getMeasuredHeight() + paddingTop);
        int max = Math.max((width - paddingRight) - measuredWidth3, this.g + i6);
        this.d.layout(max, paddingTop, max + measuredWidth3, this.d.getMeasuredHeight() + paddingTop);
        this.f = f;
        this.i = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int i3 = 0;
        Drawable background = getBackground();
        if (background != null) {
            i3 = background.getIntrinsicHeight();
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size * 0.8f), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(i3, this.c.getMeasuredHeight() + paddingTop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            a(this.a.getCurrentItem(), 0.0f);
        }
    }
}
