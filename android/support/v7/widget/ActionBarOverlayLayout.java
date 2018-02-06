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
    private DecorToolbar DO;
    private boolean EH;
    private final Rect KA;
    private final Rect KB;
    private ActionBarVisibilityCallback KC;
    private final int KD;
    private ScrollerCompat KE;
    ViewPropertyAnimatorCompat KF;
    final ViewPropertyAnimatorListener KG;
    private final Runnable KH;
    private final Runnable KI;
    private int Kl;
    private int Km;
    private ContentFrameLayout Kn;
    ActionBarContainer Ko;
    private Drawable Kp;
    private boolean Kq;
    private boolean Kr;
    private boolean Ks;
    boolean Kt;
    private int Ku;
    private int Kv;
    private final Rect Kw;
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
        this.Km = 0;
        this.Kw = new Rect();
        this.Kx = new Rect();
        this.Ky = new Rect();
        this.Kz = new Rect();
        this.KA = new Rect();
        this.KB = new Rect();
        this.KD = 600;
        this.KG = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.KF = null;
                ActionBarOverlayLayout.this.Kt = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.KF = null;
                ActionBarOverlayLayout.this.Kt = false;
            }
        };
        this.KH = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KF = ViewCompat.animate(ActionBarOverlayLayout.this.Ko).translationY(0.0f).setListener(ActionBarOverlayLayout.this.KG);
            }
        };
        this.KI = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KF = ViewCompat.animate(ActionBarOverlayLayout.this.Ko).translationY(-ActionBarOverlayLayout.this.Ko.getHeight()).setListener(ActionBarOverlayLayout.this.KG);
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    private void init(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.Kl = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Kp = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.Kp == null);
        obtainStyledAttributes.recycle();
        this.Kq = context.getApplicationInfo().targetSdkVersion < 19;
        this.KE = ScrollerCompat.create(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fg();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.KC = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.KC.onWindowVisibilityChanged(this.Km);
            if (this.Kv != 0) {
                onWindowSystemUiVisibilityChanged(this.Kv);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.Kr = z;
        this.Kq = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean isInOverlayMode() {
        return this.Kr;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.Ks = z;
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
        int i2 = this.Kv ^ i;
        this.Kv = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.KC != null) {
            this.KC.enableContentAnimations(z2 ? false : true);
            if (z || !z2) {
                this.KC.showForSystem();
            } else {
                this.KC.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.KC != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Km = i;
        if (this.KC != null) {
            this.KC.onWindowVisibilityChanged(i);
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
        boolean a = a(this.Ko, rect, true, true, false, true);
        this.Kz.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.Kz, this.Kw);
        if (!this.Kx.equals(this.Kw)) {
            this.Kx.set(this.Kw);
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
        measureChildWithMargins(this.Ko, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.Ko.getLayoutParams();
        int max = Math.max(0, this.Ko.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.Ko.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.Ko));
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.Kl;
            if (this.Ks && this.Ko.getTabContainer() != null) {
                measuredHeight += this.Kl;
            }
        } else {
            measuredHeight = this.Ko.getVisibility() != 8 ? this.Ko.getMeasuredHeight() : 0;
        }
        this.Ky.set(this.Kw);
        this.KA.set(this.Kz);
        if (!this.Kr && !z) {
            Rect rect = this.Ky;
            rect.top = measuredHeight + rect.top;
            this.Ky.bottom += 0;
        } else {
            Rect rect2 = this.KA;
            rect2.top = measuredHeight + rect2.top;
            this.KA.bottom += 0;
        }
        a(this.Kn, this.Ky, true, true, true, true);
        if (!this.KB.equals(this.KA)) {
            this.KB.set(this.KA);
            this.Kn.dispatchFitSystemWindows(this.KA);
        }
        measureChildWithMargins(this.Kn, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.Kn.getLayoutParams();
        int max3 = Math.max(max, this.Kn.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.Kn.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.Kn));
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
        if (this.Kp != null && !this.Kq) {
            int bottom = this.Ko.getVisibility() == 0 ? (int) (this.Ko.getBottom() + ViewCompat.getTranslationY(this.Ko) + 0.5f) : 0;
            this.Kp.setBounds(0, bottom, getWidth(), this.Kp.getIntrinsicHeight() + bottom);
            this.Kp.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.Ko.getVisibility() != 0) {
            return false;
        }
        return this.EH;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        this.Ku = getActionBarHideOffset();
        fg();
        if (this.KC != null) {
            this.KC.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.Ku += i2;
        setActionBarHideOffset(this.Ku);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.EH && !this.Kt) {
            if (this.Ku <= this.Ko.getHeight()) {
                fh();
            } else {
                fi();
            }
        }
        if (this.KC != null) {
            this.KC.onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.EH || !z) {
            return false;
        }
        if (g(f, f2)) {
            fk();
        } else {
            fj();
        }
        this.Kt = true;
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
        if (this.Kn == null) {
            this.Kn = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.Ko = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.DO = T(findViewById(R.id.action_bar));
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
        if (z != this.EH) {
            this.EH = z;
            if (!z) {
                fg();
                setActionBarHideOffset(0);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.EH;
    }

    public int getActionBarHideOffset() {
        if (this.Ko != null) {
            return -((int) ViewCompat.getTranslationY(this.Ko));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        fg();
        ViewCompat.setTranslationY(this.Ko, -Math.max(0, Math.min(i, this.Ko.getHeight())));
    }

    void fg() {
        removeCallbacks(this.KH);
        removeCallbacks(this.KI);
        if (this.KF != null) {
            this.KF.cancel();
        }
    }

    private void fh() {
        fg();
        postDelayed(this.KH, 600L);
    }

    private void fi() {
        fg();
        postDelayed(this.KI, 600L);
    }

    private void fj() {
        fg();
        this.KH.run();
    }

    private void fk() {
        fg();
        this.KI.run();
    }

    private boolean g(float f, float f2) {
        this.KE.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.KE.getFinalY() > this.Ko.getHeight();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        ff();
        this.DO.setWindowCallback(callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        ff();
        this.DO.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public CharSequence getTitle() {
        ff();
        return this.DO.getTitle();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void initFeature(int i) {
        ff();
        switch (i) {
            case 2:
                this.DO.initProgress();
                return;
            case 5:
                this.DO.initIndeterminateProgress();
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
        return this.DO.hasIcon();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasLogo() {
        ff();
        return this.DO.hasLogo();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(int i) {
        ff();
        this.DO.setIcon(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        ff();
        this.DO.setIcon(drawable);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setLogo(int i) {
        ff();
        this.DO.setLogo(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        ff();
        return this.DO.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        ff();
        return this.DO.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        ff();
        return this.DO.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean showOverflowMenu() {
        ff();
        return this.DO.showOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        ff();
        return this.DO.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenuPrepared() {
        ff();
        this.DO.setMenuPrepared();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        ff();
        this.DO.setMenu(menu, callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DO.saveHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DO.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void dismissPopups() {
        ff();
        this.DO.dismissPopupMenus();
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
