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
    private static final Interpolator Ek;
    private static final Interpolator El;
    private static final boolean Em;
    DecorToolbar DO;
    private boolean DS;
    boolean EB;
    boolean EC;
    private boolean ED;
    ViewPropertyAnimatorCompatSet EF;
    private boolean EG;
    boolean EH;
    private Context En;
    ActionBarOverlayLayout Eo;
    ActionBarContainer Ep;
    ActionBarContextView Eq;
    ScrollingTabContainerView Er;
    private TabImpl Es;
    private boolean Eu;
    ActionModeImpl Ev;
    ActionMode Ew;
    ActionMode.Callback Ex;
    private boolean Ey;
    private Activity mActivity;
    View mContentView;
    Context mContext;
    private Dialog mDialog;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private int Et = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> DT = new ArrayList<>();
    private int Ez = 0;
    boolean EA = true;
    private boolean EE = true;
    final ViewPropertyAnimatorListener EI = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (WindowDecorActionBar.this.EA && WindowDecorActionBar.this.mContentView != null) {
                ViewCompat.setTranslationY(WindowDecorActionBar.this.mContentView, 0.0f);
                ViewCompat.setTranslationY(WindowDecorActionBar.this.Ep, 0.0f);
            }
            WindowDecorActionBar.this.Ep.setVisibility(8);
            WindowDecorActionBar.this.Ep.setTransitioning(false);
            WindowDecorActionBar.this.EF = null;
            WindowDecorActionBar.this.eq();
            if (WindowDecorActionBar.this.Eo != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.Eo);
            }
        }
    };
    final ViewPropertyAnimatorListener EJ = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar.this.EF = null;
            WindowDecorActionBar.this.Ep.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener EK = new ViewPropertyAnimatorUpdateListener() { // from class: android.support.v7.app.WindowDecorActionBar.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.Ep.getParent()).invalidate();
        }
    };

    static {
        $assertionsDisabled = !WindowDecorActionBar.class.desiredAssertionStatus();
        Ek = new AccelerateInterpolator();
        El = new DecelerateInterpolator();
        Em = Build.VERSION.SDK_INT >= 14;
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
        this.Eo = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.Eo != null) {
            this.Eo.setActionBarVisibilityCallback(this);
        }
        this.DO = T(view.findViewById(R.id.action_bar));
        this.Eq = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.Ep = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        if (this.DO == null || this.Eq == null || this.Ep == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.DO.getContext();
        boolean z = (this.DO.getDisplayOptions() & 4) != 0;
        if (z) {
            this.Eu = true;
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
        ViewCompat.setElevation(this.Ep, f);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.Ep);
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        z(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void z(boolean z) {
        boolean z2 = true;
        this.Ey = z;
        if (!this.Ey) {
            this.DO.setEmbeddedTabView(null);
            this.Ep.setTabContainer(this.Er);
        } else {
            this.Ep.setTabContainer(null);
            this.DO.setEmbeddedTabView(this.Er);
        }
        boolean z3 = getNavigationMode() == 2;
        if (this.Er != null) {
            if (z3) {
                this.Er.setVisibility(0);
                if (this.Eo != null) {
                    ViewCompat.requestApplyInsets(this.Eo);
                }
            } else {
                this.Er.setVisibility(8);
            }
        }
        this.DO.setCollapsible(!this.Ey && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Eo;
        if (this.Ey || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void ep() {
        if (this.Er == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.Ey) {
                scrollingTabContainerView.setVisibility(0);
                this.DO.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.Eo != null) {
                        ViewCompat.requestApplyInsets(this.Eo);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.Ep.setTabContainer(scrollingTabContainerView);
            }
            this.Er = scrollingTabContainerView;
        }
    }

    void eq() {
        if (this.Ex != null) {
            this.Ex.onDestroyActionMode(this.Ew);
            this.Ew = null;
            this.Ex = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        this.Ez = i;
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        this.EG = z;
        if (!z && this.EF != null) {
            this.EF.cancel();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DT.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DT.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.DS) {
            this.DS = z;
            int size = this.DT.size();
            for (int i = 0; i < size; i++) {
                this.DT.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.DO.getViewGroup(), false));
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
        this.DO.setHomeButtonEnabled(z);
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
        switch (this.DO.getNavigationMode()) {
            case 1:
                this.DO.setDropdownSelectedPosition(i);
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
        if (this.Es != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.Er != null) {
            this.Er.removeAllTabs();
        }
        this.Et = -1;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.DO.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.DO.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.DO.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.DO.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Eu = true;
        }
        this.DO.setDisplayOptions(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.DO.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Eu = true;
        }
        this.DO.setDisplayOptions((displayOptions & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.Ep.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.Ep.setStackedBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.DO.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.DO.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.DO.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return this.DO.getNavigationMode();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.DO.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.Ev != null) {
            this.Ev.finish();
        }
        this.Eo.setHideOnContentScrollEnabled(false);
        this.Eq.killMode();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.Eq.getContext(), callback);
        if (actionModeImpl.dispatchOnCreate()) {
            this.Ev = actionModeImpl;
            actionModeImpl.invalidate();
            this.Eq.initForMode(actionModeImpl);
            animateToMode(true);
            this.Eq.sendAccessibilityEvent(32);
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
        this.Er.addTab(tab, z);
        a(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        ep();
        this.Er.addTab(tab, i, z);
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
        if (this.Er != null) {
            int position = this.Es != null ? this.Es.getPosition() : this.Et;
            this.Er.removeTabAt(i);
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
            this.Et = tab != null ? tab.getPosition() : -1;
            return;
        }
        if ((this.mActivity instanceof FragmentActivity) && !this.DO.getViewGroup().isInEditMode()) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            fragmentTransaction = null;
        }
        if (this.Es == tab) {
            if (this.Es != null) {
                this.Es.getCallback().onTabReselected(this.Es, fragmentTransaction);
                this.Er.animateToTab(tab.getPosition());
            }
        } else {
            this.Er.setTabSelected(tab != null ? tab.getPosition() : -1);
            if (this.Es != null) {
                this.Es.getCallback().onTabUnselected(this.Es, fragmentTransaction);
            }
            this.Es = (TabImpl) tab;
            if (this.Es != null) {
                this.Es.getCallback().onTabSelected(this.Es, fragmentTransaction);
            }
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.Es;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.Ep.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.EA = z;
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        if (this.EB) {
            this.EB = false;
            A(false);
        }
    }

    private void es() {
        if (!this.ED) {
            this.ED = true;
            if (this.Eo != null) {
                this.Eo.setShowingForActionMode(true);
            }
            A(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.EC) {
            this.EC = false;
            A(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        if (!this.EB) {
            this.EB = true;
            A(false);
        }
    }

    private void et() {
        if (this.ED) {
            this.ED = false;
            if (this.Eo != null) {
                this.Eo.setShowingForActionMode(false);
            }
            A(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.EC) {
            this.EC = true;
            A(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.Eo.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.EH = z;
        this.Eo.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.Eo.isHideOnContentScrollEnabled();
    }

    @Override // android.support.v7.app.ActionBar
    public int getHideOffset() {
        return this.Eo.getActionBarHideOffset();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.Eo.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.Eo.setActionBarHideOffset(i);
    }

    static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void A(boolean z) {
        if (b(this.EB, this.EC, this.ED)) {
            if (!this.EE) {
                this.EE = true;
                doShow(z);
            }
        } else if (this.EE) {
            this.EE = false;
            doHide(z);
        }
    }

    public void doShow(boolean z) {
        int[] iArr;
        if (this.EF != null) {
            this.EF.cancel();
        }
        this.Ep.setVisibility(0);
        if (this.Ez == 0 && Em && (this.EG || z)) {
            ViewCompat.setTranslationY(this.Ep, 0.0f);
            float f = -this.Ep.getHeight();
            if (z) {
                this.Ep.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewCompat.setTranslationY(this.Ep, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Ep).translationY(0.0f);
            translationY.setUpdateListener(this.EK);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.EA && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(El);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.EJ);
            this.EF = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        } else {
            ViewCompat.setAlpha(this.Ep, 1.0f);
            ViewCompat.setTranslationY(this.Ep, 0.0f);
            if (this.EA && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, 0.0f);
            }
            this.EJ.onAnimationEnd(null);
        }
        if (this.Eo != null) {
            ViewCompat.requestApplyInsets(this.Eo);
        }
    }

    public void doHide(boolean z) {
        int[] iArr;
        if (this.EF != null) {
            this.EF.cancel();
        }
        if (this.Ez == 0 && Em && (this.EG || z)) {
            ViewCompat.setAlpha(this.Ep, 1.0f);
            this.Ep.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = -this.Ep.getHeight();
            if (z) {
                this.Ep.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Ep).translationY(f);
            translationY.setUpdateListener(this.EK);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.EA && this.mContentView != null) {
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(Ek);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.EI);
            this.EF = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        this.EI.onAnimationEnd(null);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.EE && (height == 0 || getHideOffset() < height);
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
                viewPropertyAnimatorCompat2 = this.DO.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.Eq.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.DO.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.Eq.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.DO.setVisibility(4);
            this.Eq.setVisibility(0);
        } else {
            this.DO.setVisibility(0);
            this.Eq.setVisibility(8);
        }
    }

    private boolean eu() {
        return ViewCompat.isLaidOut(this.Ep);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        if (this.En == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.En = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.En = this.mContext;
            }
        }
        return this.En;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return this.DO != null && this.DO.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.DO.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.DO.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.DO.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.DO.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        if (this.EF != null) {
            this.EF.cancel();
            this.EF = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.DO == null || !this.DO.hasExpandedActionView()) {
            return false;
        }
        this.DO.collapseActionView();
        return true;
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context EM;
        private ActionMode.Callback EN;
        private WeakReference<View> EO;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.EM = context;
            this.EN = callback;
            this.mMenu = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        @Override // android.support.v7.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.EM);
        }

        @Override // android.support.v7.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // android.support.v7.view.ActionMode
        public void finish() {
            if (WindowDecorActionBar.this.Ev == this) {
                if (!WindowDecorActionBar.b(WindowDecorActionBar.this.EB, WindowDecorActionBar.this.EC, false)) {
                    WindowDecorActionBar.this.Ew = this;
                    WindowDecorActionBar.this.Ex = this.EN;
                } else {
                    this.EN.onDestroyActionMode(this);
                }
                this.EN = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.Eq.closeMode();
                WindowDecorActionBar.this.DO.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.Eo.setHideOnContentScrollEnabled(WindowDecorActionBar.this.EH);
                WindowDecorActionBar.this.Ev = null;
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.Ev == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.EN.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.EN.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.Eq.setCustomView(view);
            this.EO = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.Eq.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.Eq.setTitle(charSequence);
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
            return WindowDecorActionBar.this.Eq.getTitle();
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.Eq.getSubtitle();
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.Eq.setTitleOptional(z);
        }

        @Override // android.support.v7.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.Eq.isTitleOptional();
        }

        @Override // android.support.v7.view.ActionMode
        public View getCustomView() {
            if (this.EO != null) {
                return this.EO.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.EN != null) {
                return this.EN.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.EN == null) {
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
            if (this.EN != null) {
                invalidate();
                WindowDecorActionBar.this.Eq.showOverflowMenu();
            }
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener EP;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private CharSequence mText;
        private Object rs;
        private CharSequence rt;

        public TabImpl() {
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public Object getTag() {
            return this.rs;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.rs = obj;
            return this;
        }

        public ActionBar.TabListener getCallback() {
            return this.EP;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.EP = tabListener;
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
                WindowDecorActionBar.this.Er.updateTab(this.mPosition);
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
                WindowDecorActionBar.this.Er.updateTab(this.mPosition);
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
                WindowDecorActionBar.this.Er.updateTab(this.mPosition);
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
            this.rt = charSequence;
            if (this.mPosition >= 0) {
                WindowDecorActionBar.this.Er.updateTab(this.mPosition);
            }
            return this;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.rt;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view) {
        this.DO.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.DO.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.DO.setDropdownParams(spinnerAdapter, new h(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        switch (this.DO.getNavigationMode()) {
            case 1:
                return this.DO.getDropdownSelectedPosition();
            case 2:
                if (this.Es != null) {
                    return this.Es.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        switch (this.DO.getNavigationMode()) {
            case 1:
                return this.DO.getDropdownItemCount();
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
        int navigationMode = this.DO.getNavigationMode();
        switch (navigationMode) {
            case 2:
                this.Et = getSelectedNavigationIndex();
                selectTab(null);
                this.Er.setVisibility(8);
                break;
        }
        if (navigationMode != i && !this.Ey && this.Eo != null) {
            ViewCompat.requestApplyInsets(this.Eo);
        }
        this.DO.setNavigationMode(i);
        switch (i) {
            case 2:
                ep();
                this.Er.setVisibility(0);
                if (this.Et != -1) {
                    setSelectedNavigationItem(this.Et);
                    this.Et = -1;
                    break;
                }
                break;
        }
        this.DO.setCollapsible(i == 2 && !this.Ey);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Eo;
        if (i != 2 || this.Ey) {
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
        this.DO.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.DO.setIcon(drawable);
    }

    public boolean hasIcon() {
        return this.DO.hasIcon();
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.DO.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.DO.setLogo(drawable);
    }

    public boolean hasLogo() {
        return this.DO.hasLogo();
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.Eu) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
