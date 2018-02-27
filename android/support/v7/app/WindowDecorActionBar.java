package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@RestrictTo
/* loaded from: classes2.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Interpolator Ef;
    private static final Interpolator Eg;
    private static final boolean Eh;
    DecorToolbar DJ;
    private boolean DN;
    ViewPropertyAnimatorCompatSet EA;
    private boolean EB;
    boolean EC;
    private Context Ei;
    ActionBarOverlayLayout Ej;
    ActionBarContainer Ek;
    ActionBarContextView El;
    ScrollingTabContainerView Em;
    private TabImpl En;
    private boolean Ep;
    ActionModeImpl Eq;
    ActionMode Er;
    ActionMode.Callback Es;
    private boolean Et;
    boolean Ew;
    boolean Ex;
    private boolean Ey;
    private Activity mActivity;
    View mContentView;
    Context mContext;
    private Dialog mDialog;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private int Eo = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> DO = new ArrayList<>();
    private int Eu = 0;
    boolean Ev = true;
    private boolean Ez = true;
    final ViewPropertyAnimatorListener ED = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (WindowDecorActionBar.this.Ev && WindowDecorActionBar.this.mContentView != null) {
                ViewCompat.setTranslationY(WindowDecorActionBar.this.mContentView, 0.0f);
                ViewCompat.setTranslationY(WindowDecorActionBar.this.Ek, 0.0f);
            }
            WindowDecorActionBar.this.Ek.setVisibility(8);
            WindowDecorActionBar.this.Ek.setTransitioning(false);
            WindowDecorActionBar.this.EA = null;
            WindowDecorActionBar.this.eq();
            if (WindowDecorActionBar.this.Ej != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.Ej);
            }
        }
    };
    final ViewPropertyAnimatorListener EE = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar.this.EA = null;
            WindowDecorActionBar.this.Ek.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener EF = new ViewPropertyAnimatorUpdateListener() { // from class: android.support.v7.app.WindowDecorActionBar.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.Ek.getParent()).invalidate();
        }
    };

    static {
        $assertionsDisabled = !WindowDecorActionBar.class.desiredAssertionStatus();
        Ef = new AccelerateInterpolator();
        Eg = new DecelerateInterpolator();
        Eh = Build.VERSION.SDK_INT >= 14;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.mDialog = dialog;
        init(dialog.getWindow().getDecorView());
    }

    @RestrictTo
    public WindowDecorActionBar(View view) {
        if (!$assertionsDisabled && !view.isInEditMode()) {
            throw new AssertionError();
        }
        init(view);
    }

    private void init(View view) {
        this.Ej = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.Ej != null) {
            this.Ej.setActionBarVisibilityCallback(this);
        }
        this.DJ = T(view.findViewById(R.id.action_bar));
        this.El = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.Ek = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        if (this.DJ == null || this.El == null || this.Ek == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.DJ.getContext();
        boolean z = (this.DJ.getDisplayOptions() & 4) != 0;
        if (z) {
            this.Ep = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
        z(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private DecorToolbar T(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    @Override // android.support.v7.app.ActionBar
    public void setElevation(float f) {
        ViewCompat.setElevation(this.Ek, f);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.Ek);
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        z(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void z(boolean z) {
        boolean z2 = true;
        this.Et = z;
        if (!this.Et) {
            this.DJ.setEmbeddedTabView(null);
            this.Ek.setTabContainer(this.Em);
        } else {
            this.Ek.setTabContainer(null);
            this.DJ.setEmbeddedTabView(this.Em);
        }
        boolean z3 = getNavigationMode() == 2;
        if (this.Em != null) {
            if (z3) {
                this.Em.setVisibility(0);
                if (this.Ej != null) {
                    ViewCompat.requestApplyInsets(this.Ej);
                }
            } else {
                this.Em.setVisibility(8);
            }
        }
        this.DJ.setCollapsible(!this.Et && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Ej;
        if (this.Et || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void ep() {
        if (this.Em == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.Et) {
                scrollingTabContainerView.setVisibility(0);
                this.DJ.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.Ej != null) {
                        ViewCompat.requestApplyInsets(this.Ej);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.Ek.setTabContainer(scrollingTabContainerView);
            }
            this.Em = scrollingTabContainerView;
        }
    }

    void eq() {
        if (this.Es != null) {
            this.Es.onDestroyActionMode(this.Er);
            this.Er = null;
            this.Es = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        this.Eu = i;
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        this.EB = z;
        if (!z && this.EA != null) {
            this.EA.cancel();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DO.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DO.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.DN) {
            this.DN = z;
            int size = this.DO.size();
            for (int i = 0; i < size; i++) {
                this.DO.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.DJ.getViewGroup(), false));
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeButtonEnabled(boolean z) {
        this.DJ.setHomeButtonEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    @Override // android.support.v7.app.ActionBar
    public void setSelectedNavigationItem(int i) {
        switch (this.DJ.getNavigationMode()) {
            case 1:
                this.DJ.setDropdownSelectedPosition(i);
                return;
            case 2:
                selectTab(this.mTabs.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void removeAllTabs() {
        er();
    }

    private void er() {
        if (this.En != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.Em != null) {
            this.Em.removeAllTabs();
        }
        this.Eo = -1;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.DJ.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.DJ.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.DJ.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.DJ.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Ep = true;
        }
        this.DJ.setDisplayOptions(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.DJ.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Ep = true;
        }
        this.DJ.setDisplayOptions((displayOptions & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.Ek.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.Ek.setStackedBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.DJ.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.DJ.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.DJ.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return this.DJ.getNavigationMode();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.DJ.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.Eq != null) {
            this.Eq.finish();
        }
        this.Ej.setHideOnContentScrollEnabled(false);
        this.El.killMode();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.El.getContext(), callback);
        if (actionModeImpl.dispatchOnCreate()) {
            this.Eq = actionModeImpl;
            actionModeImpl.invalidate();
            this.El.initForMode(actionModeImpl);
            animateToMode(true);
            this.El.sendAccessibilityEvent(32);
            return actionModeImpl;
        }
        return null;
    }

    private void a(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.mTabs.add(i, tabImpl);
        int size = this.mTabs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.mTabs.get(i2).setPosition(i2);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z) {
        ep();
        this.Em.addTab(tab, z);
        a(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        ep();
        this.Em.addTab(tab, i, z);
        a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // android.support.v7.app.ActionBar
    public void removeTabAt(int i) {
        if (this.Em != null) {
            int position = this.En != null ? this.En.getPosition() : this.Eo;
            this.Em.removeTabAt(i);
            TabImpl remove = this.mTabs.remove(i);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i2 = i; i2 < size; i2++) {
                this.mTabs.get(i2).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1)));
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        if (getNavigationMode() != 2) {
            this.Eo = tab != null ? tab.getPosition() : -1;
            return;
        }
        if ((this.mActivity instanceof FragmentActivity) && !this.DJ.getViewGroup().isInEditMode()) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            fragmentTransaction = null;
        }
        if (this.En == tab) {
            if (this.En != null) {
                this.En.getCallback().onTabReselected(this.En, fragmentTransaction);
                this.Em.animateToTab(tab.getPosition());
            }
        } else {
            this.Em.setTabSelected(tab != null ? tab.getPosition() : -1);
            if (this.En != null) {
                this.En.getCallback().onTabUnselected(this.En, fragmentTransaction);
            }
            this.En = (TabImpl) tab;
            if (this.En != null) {
                this.En.getCallback().onTabSelected(this.En, fragmentTransaction);
            }
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.En;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.Ek.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.Ev = z;
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        if (this.Ew) {
            this.Ew = false;
            A(false);
        }
    }

    private void es() {
        if (!this.Ey) {
            this.Ey = true;
            if (this.Ej != null) {
                this.Ej.setShowingForActionMode(true);
            }
            A(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.Ex) {
            this.Ex = false;
            A(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        if (!this.Ew) {
            this.Ew = true;
            A(false);
        }
    }

    private void et() {
        if (this.Ey) {
            this.Ey = false;
            if (this.Ej != null) {
                this.Ej.setShowingForActionMode(false);
            }
            A(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.Ex) {
            this.Ex = true;
            A(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.Ej.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.EC = z;
        this.Ej.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.Ej.isHideOnContentScrollEnabled();
    }

    @Override // android.support.v7.app.ActionBar
    public int getHideOffset() {
        return this.Ej.getActionBarHideOffset();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.Ej.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.Ej.setActionBarHideOffset(i);
    }

    static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void A(boolean z) {
        if (b(this.Ew, this.Ex, this.Ey)) {
            if (!this.Ez) {
                this.Ez = true;
                doShow(z);
            }
        } else if (this.Ez) {
            this.Ez = false;
            doHide(z);
        }
    }

    public void doShow(boolean z) {
        int[] iArr;
        if (this.EA != null) {
            this.EA.cancel();
        }
        this.Ek.setVisibility(0);
        if (this.Eu == 0 && Eh && (this.EB || z)) {
            ViewCompat.setTranslationY(this.Ek, 0.0f);
            float f = -this.Ek.getHeight();
            if (z) {
                this.Ek.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewCompat.setTranslationY(this.Ek, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Ek).translationY(0.0f);
            translationY.setUpdateListener(this.EF);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.Ev && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(Eg);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.EE);
            this.EA = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        } else {
            ViewCompat.setAlpha(this.Ek, 1.0f);
            ViewCompat.setTranslationY(this.Ek, 0.0f);
            if (this.Ev && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, 0.0f);
            }
            this.EE.onAnimationEnd(null);
        }
        if (this.Ej != null) {
            ViewCompat.requestApplyInsets(this.Ej);
        }
    }

    public void doHide(boolean z) {
        int[] iArr;
        if (this.EA != null) {
            this.EA.cancel();
        }
        if (this.Eu == 0 && Eh && (this.EB || z)) {
            ViewCompat.setAlpha(this.Ek, 1.0f);
            this.Ek.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = -this.Ek.getHeight();
            if (z) {
                this.Ek.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Ek).translationY(f);
            translationY.setUpdateListener(this.EF);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.Ev && this.mContentView != null) {
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(Ef);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.ED);
            this.EA = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        this.ED.onAnimationEnd(null);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.Ez && (height == 0 || getHideOffset() < height);
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            es();
        } else {
            et();
        }
        if (eu()) {
            if (z) {
                viewPropertyAnimatorCompat2 = this.DJ.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.El.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.DJ.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.El.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.DJ.setVisibility(4);
            this.El.setVisibility(0);
        } else {
            this.DJ.setVisibility(0);
            this.El.setVisibility(8);
        }
    }

    private boolean eu() {
        return ViewCompat.isLaidOut(this.Ek);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        if (this.Ei == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.Ei = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.Ei = this.mContext;
            }
        }
        return this.Ei;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return this.DJ != null && this.DJ.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.DJ.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.DJ.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.DJ.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.DJ.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        if (this.EA != null) {
            this.EA.cancel();
            this.EA = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.DJ == null || !this.DJ.hasExpandedActionView()) {
            return false;
        }
        this.DJ.collapseActionView();
        return true;
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context EH;
        private ActionMode.Callback EI;
        private WeakReference<View> EJ;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.EH = context;
            this.EI = callback;
            this.mMenu = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        @Override // android.support.v7.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.EH);
        }

        @Override // android.support.v7.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // android.support.v7.view.ActionMode
        public void finish() {
            if (WindowDecorActionBar.this.Eq == this) {
                if (!WindowDecorActionBar.b(WindowDecorActionBar.this.Ew, WindowDecorActionBar.this.Ex, false)) {
                    WindowDecorActionBar.this.Er = this;
                    WindowDecorActionBar.this.Es = this.EI;
                } else {
                    this.EI.onDestroyActionMode(this);
                }
                this.EI = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.El.closeMode();
                WindowDecorActionBar.this.DJ.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.Ej.setHideOnContentScrollEnabled(WindowDecorActionBar.this.EC);
                WindowDecorActionBar.this.Eq = null;
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.Eq == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.EI.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.EI.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.El.setCustomView(view);
            this.EJ = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.El.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.El.setTitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.El.getTitle();
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.El.getSubtitle();
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.El.setTitleOptional(z);
        }

        @Override // android.support.v7.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.El.isTitleOptional();
        }

        @Override // android.support.v7.view.ActionMode
        public View getCustomView() {
            if (this.EJ != null) {
                return this.EJ.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.EI != null) {
                return this.EI.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.EI == null) {
                return false;
            }
            if (subMenuBuilder.hasVisibleItems()) {
                new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
                return true;
            }
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.EI != null) {
                invalidate();
                WindowDecorActionBar.this.El.showOverflowMenu();
            }
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener EK;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private CharSequence mText;
        private Object rr;
        private CharSequence rs;

        public TabImpl() {
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public Object getTag() {
            return this.rr;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.rr = obj;
            return this;
        }

        public ActionBar.TabListener getCallback() {
            return this.EK;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.EK = tabListener;
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public View getCustomView() {
            return this.mCustomView;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                WindowDecorActionBar.this.Em.updateTab(this.mPosition);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.mIcon;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public CharSequence getText() {
            return this.mText;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            if (this.mPosition >= 0) {
                WindowDecorActionBar.this.Em.updateTab(this.mPosition);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, i));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            if (this.mPosition >= 0) {
                WindowDecorActionBar.this.Em.updateTab(this.mPosition);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.mContext.getResources().getText(i));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(i));
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.rs = charSequence;
            if (this.mPosition >= 0) {
                WindowDecorActionBar.this.Em.updateTab(this.mPosition);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.rs;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        this.DJ.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.DJ.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.DJ.setDropdownParams(spinnerAdapter, new h(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        switch (this.DJ.getNavigationMode()) {
            case 1:
                return this.DJ.getDropdownSelectedPosition();
            case 2:
                if (this.En != null) {
                    return this.En.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        switch (this.DJ.getNavigationMode()) {
            case 1:
                return this.DJ.getDropdownItemCount();
            case 2:
                return this.mTabs.size();
            default:
                return 0;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getTabCount() {
        return this.mTabs.size();
    }

    @Override // android.support.v7.app.ActionBar
    public void setNavigationMode(int i) {
        boolean z = true;
        int navigationMode = this.DJ.getNavigationMode();
        switch (navigationMode) {
            case 2:
                this.Eo = getSelectedNavigationIndex();
                selectTab(null);
                this.Em.setVisibility(8);
                break;
        }
        if (navigationMode != i && !this.Et && this.Ej != null) {
            ViewCompat.requestApplyInsets(this.Ej);
        }
        this.DJ.setNavigationMode(i);
        switch (i) {
            case 2:
                ep();
                this.Em.setVisibility(0);
                if (this.Eo != -1) {
                    setSelectedNavigationItem(this.Eo);
                    this.Eo = -1;
                    break;
                }
                break;
        }
        this.DJ.setCollapsible(i == 2 && !this.Et);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Ej;
        if (i != 2 || this.Et) {
            z = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z);
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getTabAt(int i) {
        return this.mTabs.get(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(int i) {
        this.DJ.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.DJ.setIcon(drawable);
    }

    public boolean hasIcon() {
        return this.DJ.hasIcon();
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.DJ.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.DJ.setLogo(drawable);
    }

    public boolean hasLogo() {
        return this.DJ.hasLogo();
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.Ep) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
