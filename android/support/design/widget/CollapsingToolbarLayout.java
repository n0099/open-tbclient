package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.s;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    WindowInsetsCompat kK;
    private final Rect mTmpRect;
    private boolean mV;
    private int mW;
    private Toolbar mZ;
    private View na;
    private View nb;
    private int nc;
    private int nd;
    private int ne;
    private int nf;
    private int ng;
    final d nh;
    private boolean ni;
    private boolean nj;
    private Drawable nk;
    Drawable nl;
    private int nm;
    private boolean nn;
    private s np;
    private long nq;
    private int nr;
    private AppBarLayout.OnOffsetChangedListener ns;
    int nt;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mV = true;
        this.mTmpRect = new Rect();
        this.nr = -1;
        r.R(context);
        this.nh = new d(this);
        this.nh.a(android.support.design.widget.a.kE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.nh.r(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.nh.s(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.ng = dimensionPixelSize;
        this.nf = dimensionPixelSize;
        this.ne = dimensionPixelSize;
        this.nd = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.nd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.nf = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.ne = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.ng = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.ni = obtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        this.nh.u(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.nh.t(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.nh.u(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.nh.t(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.nr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.nq = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.mW = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CollapsingToolbarLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.a(windowInsetsCompat);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.ns == null) {
                this.ns = new a();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.ns);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.ns != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(this.ns);
        }
        super.onDetachedFromWindow();
    }

    WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!z.d(this.kK, windowInsetsCompat2)) {
            this.kK = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        bq();
        if (this.mZ == null && this.nk != null && this.nm > 0) {
            this.nk.mutate().setAlpha(this.nm);
            this.nk.draw(canvas);
        }
        if (this.ni && this.nj) {
            this.nh.draw(canvas);
        }
        if (this.nl != null && this.nm > 0) {
            int systemWindowInsetTop = this.kK != null ? this.kK.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.nl.setBounds(0, -this.nt, getWidth(), systemWindowInsetTop - this.nt);
                this.nl.mutate().setAlpha(this.nm);
                this.nl.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.nk != null && this.nm > 0 && u(view)) {
            this.nk.mutate().setAlpha(this.nm);
            this.nk.draw(canvas);
            return true;
        }
        return drawChild;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.nk != null) {
            this.nk.setBounds(0, 0, i, i2);
        }
    }

    private void bq() {
        Toolbar toolbar;
        if (this.mV) {
            this.mZ = null;
            this.na = null;
            if (this.mW != -1) {
                this.mZ = (Toolbar) findViewById(this.mW);
                if (this.mZ != null) {
                    this.na = v(this.mZ);
                }
            }
            if (this.mZ == null) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        toolbar = null;
                        break;
                    }
                    View childAt = getChildAt(i);
                    if (!(childAt instanceof Toolbar)) {
                        i++;
                    } else {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                this.mZ = toolbar;
            }
            br();
            this.mV = false;
        }
    }

    private boolean u(View view) {
        return this.nc >= 0 && this.nc == indexOfChild(view) + 1;
    }

    private View v(View view) {
        View view2 = view;
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view2 = (View) parent;
            }
        }
        return view2;
    }

    private void br() {
        if (!this.ni && this.nb != null) {
            ViewParent parent = this.nb.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.nb);
            }
        }
        if (this.ni && this.mZ != null) {
            if (this.nb == null) {
                this.nb = new View(getContext());
            }
            if (this.nb.getParent() == null) {
                this.mZ.addView(this.nb, -1, -1);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        bq();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int titleMarginStart;
        int titleMarginEnd;
        super.onLayout(z, i, i2, i3, i4);
        if (this.kK != null) {
            int systemWindowInsetTop = this.kK.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.ni && this.nb != null) {
            this.nj = ViewCompat.isAttachedToWindow(this.nb) && this.nb.getVisibility() == 0;
            if (this.nj) {
                boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
                int y = y(this.na != null ? this.na : this.mZ);
                v.b(this, this.nb, this.mTmpRect);
                d dVar = this.nh;
                int i6 = this.mTmpRect.left;
                if (z2) {
                    titleMarginStart = this.mZ.getTitleMarginEnd();
                } else {
                    titleMarginStart = this.mZ.getTitleMarginStart();
                }
                int i7 = i6 + titleMarginStart;
                int titleMarginTop = this.mZ.getTitleMarginTop() + this.mTmpRect.top + y;
                int i8 = this.mTmpRect.right;
                if (z2) {
                    titleMarginEnd = this.mZ.getTitleMarginStart();
                } else {
                    titleMarginEnd = this.mZ.getTitleMarginEnd();
                }
                dVar.d(i7, titleMarginTop, titleMarginEnd + i8, (y + this.mTmpRect.bottom) - this.mZ.getTitleMarginBottom());
                this.nh.c(z2 ? this.nf : this.nd, this.mTmpRect.top + this.ne, (i3 - i) - (z2 ? this.nd : this.nf), (i4 - i2) - this.ng);
                this.nh.bn();
            }
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            x(getChildAt(i9)).cK();
        }
        if (this.mZ != null) {
            if (this.ni && TextUtils.isEmpty(this.nh.getText())) {
                this.nh.setText(this.mZ.getTitle());
            }
            if (this.na == null || this.na == this) {
                setMinimumHeight(w(this.mZ));
                this.nc = indexOfChild(this.mZ);
            } else {
                setMinimumHeight(w(this.na));
                this.nc = indexOfChild(this.na);
            }
        } else {
            this.nc = -1;
        }
        bs();
    }

    private static int w(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return marginLayoutParams.bottomMargin + view.getHeight() + marginLayoutParams.topMargin;
        }
        return view.getHeight();
    }

    static y x(View view) {
        y yVar = (y) view.getTag(R.id.view_offset_helper);
        if (yVar == null) {
            y yVar2 = new y(view);
            view.setTag(R.id.view_offset_helper, yVar2);
            return yVar2;
        }
        return yVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.nh.setText(charSequence);
    }

    public CharSequence getTitle() {
        if (this.ni) {
            return this.nh.getText();
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.ni) {
            this.ni = z;
            br();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.ni;
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.nn != z) {
            if (z2) {
                w(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.nn = z;
        }
    }

    private void w(int i) {
        bq();
        if (this.np == null) {
            this.np = z.cE();
            this.np.setDuration(this.nq);
            this.np.setInterpolator(i > this.nm ? android.support.design.widget.a.kC : android.support.design.widget.a.kD);
            this.np.a(new s.c() { // from class: android.support.design.widget.CollapsingToolbarLayout.2
                @Override // android.support.design.widget.s.c
                public void a(s sVar) {
                    CollapsingToolbarLayout.this.setScrimAlpha(sVar.cA());
                }
            });
        } else if (this.np.isRunning()) {
            this.np.cancel();
        }
        this.np.q(this.nm, i);
        this.np.start();
    }

    void setScrimAlpha(int i) {
        if (i != this.nm) {
            if (this.nk != null && this.mZ != null) {
                ViewCompat.postInvalidateOnAnimation(this.mZ);
            }
            this.nm = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrim(Drawable drawable) {
        if (this.nk != drawable) {
            if (this.nk != null) {
                this.nk.setCallback(null);
            }
            this.nk = drawable != null ? drawable.mutate() : null;
            if (this.nk != null) {
                this.nk.setBounds(0, 0, getWidth(), getHeight());
                this.nk.setCallback(this);
                this.nk.setAlpha(this.nm);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.nk;
    }

    public void setStatusBarScrim(Drawable drawable) {
        if (this.nl != drawable) {
            if (this.nl != null) {
                this.nl.setCallback(null);
            }
            this.nl = drawable != null ? drawable.mutate() : null;
            if (this.nl != null) {
                if (this.nl.isStateful()) {
                    this.nl.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.nl, ViewCompat.getLayoutDirection(this));
                this.nl.setVisible(getVisibility() == 0, false);
                this.nl.setCallback(this);
                this.nl.setAlpha(this.nm);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.nl;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.nk;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (this.nh != null) {
            z |= this.nh.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.nk || drawable == this.nl;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.nl != null && this.nl.isVisible() != z) {
            this.nl.setVisible(z, false);
        }
        if (this.nk != null && this.nk.isVisible() != z) {
            this.nk.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.nl;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.nh.t(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.nh.b(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.nh.s(i);
    }

    public int getCollapsedTitleGravity() {
        return this.nh.bd();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.nh.u(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.nh.c(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.nh.r(i);
    }

    public int getExpandedTitleGravity() {
        return this.nh.bc();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.nh.a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.nh.be();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.nh.b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.nh.bf();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.nd = i;
        this.ne = i2;
        this.nf = i3;
        this.ng = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.nd;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.nd = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.ne;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.ne = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.nf;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.nf = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.ng;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.ng = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.nr != i) {
            this.nr = i;
            bs();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.nr >= 0) {
            return this.nr;
        }
        int systemWindowInsetTop = this.kK != null ? this.kK.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min(systemWindowInsetTop + (minimumHeight * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.nq = j;
    }

    public long getScrimAnimationDuration() {
        return this.nq;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        int nv;
        float nw;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.nv = 0;
            this.nw = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.nv = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.nv = 0;
            this.nw = 0.5f;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            this.nv = 0;
            this.nw = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.nv = 0;
            this.nw = 0.5f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.nv = 0;
            this.nw = 0.5f;
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.nv = 0;
            this.nw = 0.5f;
        }

        public void setCollapseMode(int i) {
            this.nv = i;
        }

        public int getCollapseMode() {
            return this.nv;
        }

        public void setParallaxMultiplier(float f) {
            this.nw = f;
        }

        public float getParallaxMultiplier() {
            return this.nw;
        }
    }

    final void bs() {
        if (this.nk != null || this.nl != null) {
            setScrimsShown(getHeight() + this.nt < getScrimVisibleHeightTrigger());
        }
    }

    final int y(View view) {
        return ((getHeight() - x(view).cM()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* loaded from: classes2.dex */
    private class a implements AppBarLayout.OnOffsetChangedListener {
        a() {
        }

        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout.this.nt = i;
            int systemWindowInsetTop = CollapsingToolbarLayout.this.kK != null ? CollapsingToolbarLayout.this.kK.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                y x = CollapsingToolbarLayout.x(childAt);
                switch (layoutParams.nv) {
                    case 1:
                        x.setTopAndBottomOffset(m.constrain(-i, 0, CollapsingToolbarLayout.this.y(childAt)));
                        break;
                    case 2:
                        x.setTopAndBottomOffset(Math.round(layoutParams.nw * (-i)));
                        break;
                }
            }
            CollapsingToolbarLayout.this.bs();
            if (CollapsingToolbarLayout.this.nl != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.nh.h(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
        }
    }
}
