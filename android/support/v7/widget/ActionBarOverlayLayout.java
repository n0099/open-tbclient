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
    private DecorToolbar DJ;
    private boolean EC;
    ViewPropertyAnimatorCompat KA;
    final ViewPropertyAnimatorListener KB;
    private final Runnable KC;
    private final Runnable KD;
    private int Kg;
    private int Kh;
    private ContentFrameLayout Ki;
    ActionBarContainer Kj;
    private Drawable Kk;
    private boolean Kl;
    private boolean Km;
    private boolean Kn;
    boolean Ko;
    private int Kp;
    private int Kq;
    private final Rect Kr;
    private final Rect Ks;
    private final Rect Kt;
    private final Rect Ku;
    private final Rect Kv;
    private final Rect Kw;
    private ActionBarVisibilityCallback Kx;
    private final int Ky;
    private ScrollerCompat Kz;
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
        this.Kh = 0;
        this.Kr = new Rect();
        this.Ks = new Rect();
        this.Kt = new Rect();
        this.Ku = new Rect();
        this.Kv = new Rect();
        this.Kw = new Rect();
        this.Ky = 600;
        this.KB = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ActionBarOverlayLayout.this.KA = null;
                ActionBarOverlayLayout.this.Ko = false;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ActionBarOverlayLayout.this.KA = null;
                ActionBarOverlayLayout.this.Ko = false;
            }
        };
        this.KC = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KA = ViewCompat.animate(ActionBarOverlayLayout.this.Kj).translationY(0.0f).setListener(ActionBarOverlayLayout.this.KB);
            }
        };
        this.KD = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.fg();
                ActionBarOverlayLayout.this.KA = ViewCompat.animate(ActionBarOverlayLayout.this.Kj).translationY(-ActionBarOverlayLayout.this.Kj.getHeight()).setListener(ActionBarOverlayLayout.this.KB);
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    private void init(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.Kg = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Kk = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.Kk == null);
        obtainStyledAttributes.recycle();
        this.Kl = context.getApplicationInfo().targetSdkVersion < 19;
        this.Kz = ScrollerCompat.create(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fg();
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.Kx = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.Kx.onWindowVisibilityChanged(this.Kh);
            if (this.Kq != 0) {
                onWindowSystemUiVisibilityChanged(this.Kq);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.Km = z;
        this.Kl = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean isInOverlayMode() {
        return this.Km;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.Kn = z;
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
        int i2 = this.Kq ^ i;
        this.Kq = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.Kx != null) {
            this.Kx.enableContentAnimations(z2 ? false : true);
            if (z || !z2) {
                this.Kx.showForSystem();
            } else {
                this.Kx.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.Kx != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.Kh = i;
        if (this.Kx != null) {
            this.Kx.onWindowVisibilityChanged(i);
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
        boolean a = a(this.Kj, rect, true, true, false, true);
        this.Ku.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.Ku, this.Kr);
        if (!this.Ks.equals(this.Kr)) {
            this.Ks.set(this.Kr);
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
        measureChildWithMargins(this.Kj, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.Kj.getLayoutParams();
        int max = Math.max(0, this.Kj.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + this.Kj.getMeasuredHeight() + layoutParams.topMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.Kj));
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.Kg;
            if (this.Kn && this.Kj.getTabContainer() != null) {
                measuredHeight += this.Kg;
            }
        } else {
            measuredHeight = this.Kj.getVisibility() != 8 ? this.Kj.getMeasuredHeight() : 0;
        }
        this.Kt.set(this.Kr);
        this.Kv.set(this.Ku);
        if (!this.Km && !z) {
            Rect rect = this.Kt;
            rect.top = measuredHeight + rect.top;
            this.Kt.bottom += 0;
        } else {
            Rect rect2 = this.Kv;
            rect2.top = measuredHeight + rect2.top;
            this.Kv.bottom += 0;
        }
        a(this.Ki, this.Kt, true, true, true, true);
        if (!this.Kw.equals(this.Kv)) {
            this.Kw.set(this.Kv);
            this.Ki.dispatchFitSystemWindows(this.Kv);
        }
        measureChildWithMargins(this.Ki, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.Ki.getLayoutParams();
        int max3 = Math.max(max, this.Ki.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, layoutParams2.bottomMargin + this.Ki.getMeasuredHeight() + layoutParams2.topMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.Ki));
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
        if (this.Kk != null && !this.Kl) {
            int bottom = this.Kj.getVisibility() == 0 ? (int) (this.Kj.getBottom() + ViewCompat.getTranslationY(this.Kj) + 0.5f) : 0;
            this.Kk.setBounds(0, bottom, getWidth(), this.Kk.getIntrinsicHeight() + bottom);
            this.Kk.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.Kj.getVisibility() != 0) {
            return false;
        }
        return this.EC;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        this.Kp = getActionBarHideOffset();
        fg();
        if (this.Kx != null) {
            this.Kx.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.Kp += i2;
        setActionBarHideOffset(this.Kp);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.EC && !this.Ko) {
            if (this.Kp <= this.Kj.getHeight()) {
                fh();
            } else {
                fi();
            }
        }
        if (this.Kx != null) {
            this.Kx.onContentScrollStopped();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.EC || !z) {
            return false;
        }
        if (g(f, f2)) {
            fk();
        } else {
            fj();
        }
        this.Ko = true;
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
        if (this.Ki == null) {
            this.Ki = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.Kj = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.DJ = T(findViewById(R.id.action_bar));
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
        if (z != this.EC) {
            this.EC = z;
            if (!z) {
                fg();
                setActionBarHideOffset(0);
            }
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.EC;
    }

    public int getActionBarHideOffset() {
        if (this.Kj != null) {
            return -((int) ViewCompat.getTranslationY(this.Kj));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        fg();
        ViewCompat.setTranslationY(this.Kj, -Math.max(0, Math.min(i, this.Kj.getHeight())));
    }

    void fg() {
        removeCallbacks(this.KC);
        removeCallbacks(this.KD);
        if (this.KA != null) {
            this.KA.cancel();
        }
    }

    private void fh() {
        fg();
        postDelayed(this.KC, 600L);
    }

    private void fi() {
        fg();
        postDelayed(this.KD, 600L);
    }

    private void fj() {
        fg();
        this.KC.run();
    }

    private void fk() {
        fg();
        this.KD.run();
    }

    private boolean g(float f, float f2) {
        this.Kz.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.Kz.getFinalY() > this.Kj.getHeight();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        ff();
        this.DJ.setWindowCallback(callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        ff();
        this.DJ.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public CharSequence getTitle() {
        ff();
        return this.DJ.getTitle();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void initFeature(int i) {
        ff();
        switch (i) {
            case 2:
                this.DJ.initProgress();
                return;
            case 5:
                this.DJ.initIndeterminateProgress();
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
        return this.DJ.hasIcon();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasLogo() {
        ff();
        return this.DJ.hasLogo();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(int i) {
        ff();
        this.DJ.setIcon(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        ff();
        this.DJ.setIcon(drawable);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setLogo(int i) {
        ff();
        this.DJ.setLogo(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        ff();
        return this.DJ.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        ff();
        return this.DJ.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        ff();
        return this.DJ.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean showOverflowMenu() {
        ff();
        return this.DJ.showOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        ff();
        return this.DJ.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenuPrepared() {
        ff();
        this.DJ.setMenuPrepared();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        ff();
        this.DJ.setMenu(menu, callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DJ.saveHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        ff();
        this.DJ.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void dismissPopups() {
        ff();
        this.DJ.dismissPopupMenus();
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
