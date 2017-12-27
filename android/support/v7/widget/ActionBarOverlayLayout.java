package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
@RestrictTo
/* loaded from: classes2.dex */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {
    static final int[] ATTRS = {R.attr.actionBarSize, 16842841};
    private DecorToolbar DP;
    private boolean EI;
    private final Rect KA;
    private final Rect KB;
    private final Rect KC;
    private ActionBarVisibilityCallback KD;
    private final int KE;
    private ScrollerCompat KF;
    ViewPropertyAnimatorCompat KG;
    final ViewPropertyAnimatorListener KH;
    private final Runnable KI;
    private final Runnable KJ;
    private int Km;
    private int Kn;
    private ContentFrameLayout Ko;
    ActionBarContainer Kp;
    private Drawable Kq;
    private boolean Kr;
    private boolean Ks;
    private boolean Kt;
    boolean Ku;
    private int Kv;
    private int Kw;
    private final Rect Kx;
    private final Rect Ky;
    private final Rect Kz;
    private final NestedScrollingParentHelper mParentHelper;

    /* loaded from: classes2.dex */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kn = 0;
        this.Kx = new Rect();
        this.Ky = new Rect();
        this.Kz = new Rect();
        this.KA = new Rect();
        this.KB = new Rect();
        this.KC = new Rect();
        this.KE = 600;
        this.KH = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.KG = null;
                ActionBarOverlayLayout.this.Ku = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.KG = null;
                ActionBarOverlayLayout.this.Ku = false;
            }
        };
        this.KI = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KG = ViewCompat.animate(ActionBarOverlayLayout.this.Kp).translationY(0.0f).setListener(ActionBarOverlayLayout.this.KH);
            }
        };
        this.KJ = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KG = ViewCompat.animate(ActionBarOverlayLayout.this.Kp).translationY(-ActionBarOverlayLayout.this.Kp.getHeight()).setListener(ActionBarOverlayLayout.this.KH);
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    private void init(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.Km = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Kq = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.Kq == null);
        obtainStyledAttributes.recycle();
        this.Kr = context.getApplicationInfo().targetSdkVersion < 19;
        this.KF = ScrollerCompat.create(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fg();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.KD = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.KD.onWindowVisibilityChanged(this.Kn);
            if (this.Kw != 0) {
                onWindowSystemUiVisibilityChanged(this.Kw);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.Ks = z;
        this.Kr = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean isInOverlayMode() {
        return this.Ks;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.Kt = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        ff();
        int i2 = this.Kw ^ i;
        this.Kw = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.KD != null) {
            this.KD.enableContentAnimations(z2 ? false : true);
            if (z || !z2) {
                this.KD.showForSystem();
            } else {
                this.KD.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.KD != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Kn = i;
        if (this.KD != null) {
            this.KD.onWindowVisibilityChanged(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        ff();
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0) {
        }
        boolean a = a(this.Kp, rect, true, true, false, true);
        this.KA.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.KA, this.Kx);
        if (!this.Ky.equals(this.Kx)) {
            this.Ky.set(this.Kx);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        ff();
        measureChildWithMargins(this.Kp, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.Kp.getLayoutParams();
        int max = Math.max(0, this.Kp.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.Kp.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.Kp));
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.Km;
            if (this.Kt && this.Kp.getTabContainer() != null) {
                measuredHeight += this.Km;
            }
        } else {
            measuredHeight = this.Kp.getVisibility() != 8 ? this.Kp.getMeasuredHeight() : 0;
        }
        this.Kz.set(this.Kx);
        this.KB.set(this.KA);
        if (!this.Ks && !z) {
            Rect rect = this.Kz;
            rect.top = measuredHeight + rect.top;
            this.Kz.bottom += 0;
        } else {
            Rect rect2 = this.KB;
            rect2.top = measuredHeight + rect2.top;
            this.KB.bottom += 0;
        }
        a(this.Ko, this.Kz, true, true, true, true);
        if (!this.KC.equals(this.KB)) {
            this.KC.set(this.KB);
            this.Ko.dispatchFitSystemWindows(this.KB);
        }
        measureChildWithMargins(this.Ko, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.Ko.getLayoutParams();
        int max3 = Math.max(max, this.Ko.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.Ko.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.Ko));
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Kq != null && !this.Kr) {
            int bottom = this.Kp.getVisibility() == 0 ? (int) (this.Kp.getBottom() + ViewCompat.getTranslationY(this.Kp) + 0.5f) : 0;
            this.Kq.setBounds(0, bottom, getWidth(), this.Kq.getIntrinsicHeight() + bottom);
            this.Kq.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.Kp.getVisibility() != 0) {
            return false;
        }
        return this.EI;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        this.Kv = getActionBarHideOffset();
        fg();
        if (this.KD != null) {
            this.KD.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.Kv += i2;
        setActionBarHideOffset(this.Kv);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.EI && !this.Ku) {
            if (this.Kv <= this.Kp.getHeight()) {
                fh();
            } else {
                fi();
            }
        }
        if (this.KD != null) {
            this.KD.onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.EI || !z) {
            return false;
        }
        if (g(f, f2)) {
            fk();
        } else {
            fj();
        }
        this.Ku = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    void ff() {
        if (this.Ko == null) {
            this.Ko = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.Kp = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.DP = T(findViewById(R.id.action_bar));
        }
    }

    private DecorToolbar T(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.EI) {
            this.EI = z;
            if (!z) {
                fg();
                setActionBarHideOffset(0);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.EI;
    }

    public int getActionBarHideOffset() {
        if (this.Kp != null) {
            return -((int) ViewCompat.getTranslationY(this.Kp));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        fg();
        ViewCompat.setTranslationY(this.Kp, -Math.max(0, Math.min(i, this.Kp.getHeight())));
    }

    void fg() {
        removeCallbacks(this.KI);
        removeCallbacks(this.KJ);
        if (this.KG != null) {
            this.KG.cancel();
        }
    }

    private void fh() {
        fg();
        postDelayed(this.KI, 600L);
    }

    private void fi() {
        fg();
        postDelayed(this.KJ, 600L);
    }

    private void fj() {
        fg();
        this.KI.run();
    }

    private void fk() {
        fg();
        this.KJ.run();
    }

    private boolean g(float f, float f2) {
        this.KF.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.KF.getFinalY() > this.Kp.getHeight();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        ff();
        this.DP.setWindowCallback(callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        ff();
        this.DP.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public CharSequence getTitle() {
        ff();
        return this.DP.getTitle();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void initFeature(int i) {
        ff();
        switch (i) {
            case 2:
                this.DP.initProgress();
                return;
            case 5:
                this.DP.initIndeterminateProgress();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setUiOptions(int i) {
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasIcon() {
        ff();
        return this.DP.hasIcon();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasLogo() {
        ff();
        return this.DP.hasLogo();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(int i) {
        ff();
        this.DP.setIcon(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        ff();
        this.DP.setIcon(drawable);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setLogo(int i) {
        ff();
        this.DP.setLogo(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        ff();
        return this.DP.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        ff();
        return this.DP.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        ff();
        return this.DP.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean showOverflowMenu() {
        ff();
        return this.DP.showOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        ff();
        return this.DP.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenuPrepared() {
        ff();
        this.DP.setMenuPrepared();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        ff();
        this.DP.setMenu(menu, callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DP.saveHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DP.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void dismissPopups() {
        ff();
        this.DP.dismissPopupMenus();
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }
}
