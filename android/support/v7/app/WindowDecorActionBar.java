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
    private static final Interpolator El;
    private static final Interpolator Em;
    private static final boolean En;
    DecorToolbar DP;
    private boolean DT;
    boolean EC;
    boolean ED;
    private boolean EE;
    ViewPropertyAnimatorCompatSet EG;
    private boolean EH;
    boolean EI;
    private Context Eo;
    ActionBarOverlayLayout Ep;
    ActionBarContainer Eq;
    ActionBarContextView Er;
    ScrollingTabContainerView Es;
    private TabImpl Et;
    private boolean Ev;
    ActionModeImpl Ew;
    ActionMode Ex;
    ActionMode.Callback Ey;
    private boolean Ez;
    private Activity mActivity;
    View mContentView;
    Context mContext;
    private Dialog mDialog;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private int Eu = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> DU = new ArrayList<>();
    private int EA = 0;
    boolean EB = true;
    private boolean EF = true;
    final ViewPropertyAnimatorListener EJ = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.1
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (WindowDecorActionBar.this.EB && WindowDecorActionBar.this.mContentView != null) {
                ViewCompat.setTranslationY(WindowDecorActionBar.this.mContentView, 0.0f);
                ViewCompat.setTranslationY(WindowDecorActionBar.this.Eq, 0.0f);
            }
            WindowDecorActionBar.this.Eq.setVisibility(8);
            WindowDecorActionBar.this.Eq.setTransitioning(false);
            WindowDecorActionBar.this.EG = null;
            WindowDecorActionBar.this.eq();
            if (WindowDecorActionBar.this.Ep != null) {
                ViewCompat.requestApplyInsets(WindowDecorActionBar.this.Ep);
            }
        }
    };
    final ViewPropertyAnimatorListener EK = new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.WindowDecorActionBar.2
        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar.this.EG = null;
            WindowDecorActionBar.this.Eq.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener EL = new ViewPropertyAnimatorUpdateListener() { // from class: android.support.v7.app.WindowDecorActionBar.3
        @Override // android.support.v4.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.Eq.getParent()).invalidate();
        }
    };

    static {
        $assertionsDisabled = !WindowDecorActionBar.class.desiredAssertionStatus();
        El = new AccelerateInterpolator();
        Em = new DecelerateInterpolator();
        En = Build.VERSION.SDK_INT >= 14;
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
        this.Ep = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        if (this.Ep != null) {
            this.Ep.setActionBarVisibilityCallback(this);
        }
        this.DP = T(view.findViewById(R.id.action_bar));
        this.Er = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.Eq = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        if (this.DP == null || this.Er == null || this.Eq == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.DP.getContext();
        boolean z = (this.DP.getDisplayOptions() & 4) != 0;
        if (z) {
            this.Ev = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
        x(actionBarPolicy.hasEmbeddedTabs());
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
        ViewCompat.setElevation(this.Eq, f);
    }

    @Override // android.support.v7.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.Eq);
    }

    @Override // android.support.v7.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        x(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    private void x(boolean z) {
        boolean z2 = true;
        this.Ez = z;
        if (!this.Ez) {
            this.DP.setEmbeddedTabView(null);
            this.Eq.setTabContainer(this.Es);
        } else {
            this.Eq.setTabContainer(null);
            this.DP.setEmbeddedTabView(this.Es);
        }
        boolean z3 = getNavigationMode() == 2;
        if (this.Es != null) {
            if (z3) {
                this.Es.setVisibility(0);
                if (this.Ep != null) {
                    ViewCompat.requestApplyInsets(this.Ep);
                }
            } else {
                this.Es.setVisibility(8);
            }
        }
        this.DP.setCollapsible(!this.Ez && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Ep;
        if (this.Ez || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void ep() {
        if (this.Es == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.Ez) {
                scrollingTabContainerView.setVisibility(0);
                this.DP.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    if (this.Ep != null) {
                        ViewCompat.requestApplyInsets(this.Ep);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.Eq.setTabContainer(scrollingTabContainerView);
            }
            this.Es = scrollingTabContainerView;
        }
    }

    void eq() {
        if (this.Ey != null) {
            this.Ey.onDestroyActionMode(this.Ex);
            this.Ex = null;
            this.Ey = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i) {
        this.EA = i;
    }

    @Override // android.support.v7.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z) {
        this.EH = z;
        if (!z && this.EG != null) {
            this.EG.cancel();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DU.add(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.DU.remove(onMenuVisibilityListener);
    }

    @Override // android.support.v7.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.DT) {
            this.DT = z;
            int size = this.DU.size();
            for (int i = 0; i < size; i++) {
                this.DU.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.DP.getViewGroup(), false));
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
        this.DP.setHomeButtonEnabled(z);
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
        switch (this.DP.getNavigationMode()) {
            case 1:
                this.DP.setDropdownSelectedPosition(i);
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
        if (this.Et != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.Es != null) {
            this.Es.removeAllTabs();
        }
        this.Eu = -1;
    }

    @Override // android.support.v7.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.DP.setTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.DP.setWindowTitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.DP.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.DP.setSubtitle(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Ev = true;
        }
        this.DP.setDisplayOptions(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.DP.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Ev = true;
        }
        this.DP.setDisplayOptions((displayOptions & (i2 ^ (-1))) | (i & i2));
    }

    @Override // android.support.v7.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.Eq.setPrimaryBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.Eq.setStackedBackground(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.support.v7.app.ActionBar
    public View getCustomView() {
        return this.DP.getCustomView();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getTitle() {
        return this.DP.getTitle();
    }

    @Override // android.support.v7.app.ActionBar
    public CharSequence getSubtitle() {
        return this.DP.getSubtitle();
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationMode() {
        return this.DP.getNavigationMode();
    }

    @Override // android.support.v7.app.ActionBar
    public int getDisplayOptions() {
        return this.DP.getDisplayOptions();
    }

    @Override // android.support.v7.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.Ew != null) {
            this.Ew.finish();
        }
        this.Ep.setHideOnContentScrollEnabled(false);
        this.Er.killMode();
        ActionModeImpl actionModeImpl = new ActionModeImpl(this.Er.getContext(), callback);
        if (actionModeImpl.dispatchOnCreate()) {
            this.Ew = actionModeImpl;
            actionModeImpl.invalidate();
            this.Er.initForMode(actionModeImpl);
            animateToMode(true);
            this.Er.sendAccessibilityEvent(32);
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
        this.Es.addTab(tab, z);
        a(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        ep();
        this.Es.addTab(tab, i, z);
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
        if (this.Es != null) {
            int position = this.Et != null ? this.Et.getPosition() : this.Eu;
            this.Es.removeTabAt(i);
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
            this.Eu = tab != null ? tab.getPosition() : -1;
            return;
        }
        if ((this.mActivity instanceof FragmentActivity) && !this.DP.getViewGroup().isInEditMode()) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            fragmentTransaction = null;
        }
        if (this.Et == tab) {
            if (this.Et != null) {
                this.Et.getCallback().onTabReselected(this.Et, fragmentTransaction);
                this.Es.animateToTab(tab.getPosition());
            }
        } else {
            this.Es.setTabSelected(tab != null ? tab.getPosition() : -1);
            if (this.Et != null) {
                this.Et.getCallback().onTabUnselected(this.Et, fragmentTransaction);
            }
            this.Et = (TabImpl) tab;
            if (this.Et != null) {
                this.Et.getCallback().onTabSelected(this.Et, fragmentTransaction);
            }
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    @Override // android.support.v7.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.Et;
    }

    @Override // android.support.v7.app.ActionBar
    public int getHeight() {
        return this.Eq.getHeight();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z) {
        this.EB = z;
    }

    @Override // android.support.v7.app.ActionBar
    public void show() {
        if (this.EC) {
            this.EC = false;
            y(false);
        }
    }

    private void es() {
        if (!this.EE) {
            this.EE = true;
            if (this.Ep != null) {
                this.Ep.setShowingForActionMode(true);
            }
            y(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.ED) {
            this.ED = false;
            y(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void hide() {
        if (!this.EC) {
            this.EC = true;
            y(false);
        }
    }

    private void et() {
        if (this.EE) {
            this.EE = false;
            if (this.Ep != null) {
                this.Ep.setShowingForActionMode(false);
            }
            y(false);
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.ED) {
            this.ED = true;
            y(true);
        }
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z) {
        if (z && !this.Ep.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.EI = z;
        this.Ep.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.Ep.isHideOnContentScrollEnabled();
    }

    @Override // android.support.v7.app.ActionBar
    public int getHideOffset() {
        return this.Ep.getActionBarHideOffset();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHideOffset(int i) {
        if (i != 0 && !this.Ep.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.Ep.setActionBarHideOffset(i);
    }

    static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void y(boolean z) {
        if (b(this.EC, this.ED, this.EE)) {
            if (!this.EF) {
                this.EF = true;
                doShow(z);
            }
        } else if (this.EF) {
            this.EF = false;
            doHide(z);
        }
    }

    public void doShow(boolean z) {
        int[] iArr;
        if (this.EG != null) {
            this.EG.cancel();
        }
        this.Eq.setVisibility(0);
        if (this.EA == 0 && En && (this.EH || z)) {
            ViewCompat.setTranslationY(this.Eq, 0.0f);
            float f = -this.Eq.getHeight();
            if (z) {
                this.Eq.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewCompat.setTranslationY(this.Eq, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Eq).translationY(0.0f);
            translationY.setUpdateListener(this.EL);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.EB && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, f);
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(Em);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.EK);
            this.EG = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
        } else {
            ViewCompat.setAlpha(this.Eq, 1.0f);
            ViewCompat.setTranslationY(this.Eq, 0.0f);
            if (this.EB && this.mContentView != null) {
                ViewCompat.setTranslationY(this.mContentView, 0.0f);
            }
            this.EK.onAnimationEnd(null);
        }
        if (this.Ep != null) {
            ViewCompat.requestApplyInsets(this.Ep);
        }
    }

    public void doHide(boolean z) {
        int[] iArr;
        if (this.EG != null) {
            this.EG.cancel();
        }
        if (this.EA == 0 && En && (this.EH || z)) {
            ViewCompat.setAlpha(this.Eq, 1.0f);
            this.Eq.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            float f = -this.Eq.getHeight();
            if (z) {
                this.Eq.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.Eq).translationY(f);
            translationY.setUpdateListener(this.EL);
            viewPropertyAnimatorCompatSet.play(translationY);
            if (this.EB && this.mContentView != null) {
                viewPropertyAnimatorCompatSet.play(ViewCompat.animate(this.mContentView).translationY(f));
            }
            viewPropertyAnimatorCompatSet.setInterpolator(El);
            viewPropertyAnimatorCompatSet.setDuration(250L);
            viewPropertyAnimatorCompatSet.setListener(this.EJ);
            this.EG = viewPropertyAnimatorCompatSet;
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        this.EJ.onAnimationEnd(null);
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        return this.EF && (height == 0 || getHideOffset() < height);
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
                viewPropertyAnimatorCompat2 = this.DP.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.Er.setupAnimatorToVisibility(0, 200L);
            } else {
                viewPropertyAnimatorCompat = this.DP.setupAnimatorToVisibility(0, 200L);
                viewPropertyAnimatorCompat2 = this.Er.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.DP.setVisibility(4);
            this.Er.setVisibility(0);
        } else {
            this.DP.setVisibility(0);
            this.Er.setVisibility(8);
        }
    }

    private boolean eu() {
        return ViewCompat.isLaidOut(this.Eq);
    }

    @Override // android.support.v7.app.ActionBar
    public Context getThemedContext() {
        if (this.Eo == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.Eo = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.Eo = this.mContext;
            }
        }
        return this.Eo;
    }

    @Override // android.support.v7.app.ActionBar
    public boolean isTitleTruncated() {
        return this.DP != null && this.DP.isTitleTruncated();
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.DP.setNavigationIcon(drawable);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeAsUpIndicator(int i) {
        this.DP.setNavigationIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.DP.setNavigationContentDescription(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    public void setHomeActionContentDescription(int i) {
        this.DP.setNavigationContentDescription(i);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        if (this.EG != null) {
            this.EG.cancel();
            this.EG = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // android.support.v7.app.ActionBar
    public boolean collapseActionView() {
        if (this.DP == null || !this.DP.hasExpandedActionView()) {
            return false;
        }
        this.DP.collapseActionView();
        return true;
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context EN;
        private ActionMode.Callback EO;
        private WeakReference<View> EP;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.EN = context;
            this.EO = callback;
            this.mMenu = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        @Override // android.support.v7.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.EN);
        }

        @Override // android.support.v7.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // android.support.v7.view.ActionMode
        public void finish() {
            if (WindowDecorActionBar.this.Ew == this) {
                if (!WindowDecorActionBar.b(WindowDecorActionBar.this.EC, WindowDecorActionBar.this.ED, false)) {
                    WindowDecorActionBar.this.Ex = this;
                    WindowDecorActionBar.this.Ey = this.EO;
                } else {
                    this.EO.onDestroyActionMode(this);
                }
                this.EO = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.Er.closeMode();
                WindowDecorActionBar.this.DP.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar.this.Ep.setHideOnContentScrollEnabled(WindowDecorActionBar.this.EI);
                WindowDecorActionBar.this.Ew = null;
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.Ew == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.EO.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.EO.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // android.support.v7.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.Er.setCustomView(view);
            this.EP = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.Er.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.Er.setTitle(charSequence);
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
            return WindowDecorActionBar.this.Er.getTitle();
        }

        @Override // android.support.v7.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.Er.getSubtitle();
        }

        @Override // android.support.v7.view.ActionMode
        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.Er.setTitleOptional(z);
        }

        @Override // android.support.v7.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.Er.isTitleOptional();
        }

        @Override // android.support.v7.view.ActionMode
        public View getCustomView() {
            if (this.EP != null) {
                return this.EP.get();
            }
            return null;
        }

        @Override // android.support.v7.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.EO != null) {
                return this.EO.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.EO == null) {
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
            if (this.EO != null) {
                invalidate();
                WindowDecorActionBar.this.Er.showOverflowMenu();
            }
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener EQ;
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
            return this.EQ;
        }

        @Override // android.support.v7.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.EQ = tabListener;
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
                WindowDecorActionBar.this.Es.updateTab(this.mPosition);
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
                WindowDecorActionBar.this.Es.updateTab(this.mPosition);
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
                WindowDecorActionBar.this.Es.updateTab(this.mPosition);
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
                WindowDecorActionBar.this.Es.updateTab(this.mPosition);
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
        this.DP.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.DP.setCustomView(view);
    }

    @Override // android.support.v7.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.DP.setDropdownParams(spinnerAdapter, new h(onNavigationListener));
    }

    @Override // android.support.v7.app.ActionBar
    public int getSelectedNavigationIndex() {
        switch (this.DP.getNavigationMode()) {
            case 1:
                return this.DP.getDropdownSelectedPosition();
            case 2:
                if (this.Et != null) {
                    return this.Et.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    @Override // android.support.v7.app.ActionBar
    public int getNavigationItemCount() {
        switch (this.DP.getNavigationMode()) {
            case 1:
                return this.DP.getDropdownItemCount();
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
        int navigationMode = this.DP.getNavigationMode();
        switch (navigationMode) {
            case 2:
                this.Eu = getSelectedNavigationIndex();
                selectTab(null);
                this.Es.setVisibility(8);
                break;
        }
        if (navigationMode != i && !this.Ez && this.Ep != null) {
            ViewCompat.requestApplyInsets(this.Ep);
        }
        this.DP.setNavigationMode(i);
        switch (i) {
            case 2:
                ep();
                this.Es.setVisibility(0);
                if (this.Eu != -1) {
                    setSelectedNavigationItem(this.Eu);
                    this.Eu = -1;
                    break;
                }
                break;
        }
        this.DP.setCollapsible(i == 2 && !this.Ez);
        ActionBarOverlayLayout actionBarOverlayLayout = this.Ep;
        if (i != 2 || this.Ez) {
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
        this.DP.setIcon(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.DP.setIcon(drawable);
    }

    public boolean hasIcon() {
        return this.DP.hasIcon();
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(int i) {
        this.DP.setLogo(i);
    }

    @Override // android.support.v7.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.DP.setLogo(drawable);
    }

    public boolean hasLogo() {
        return this.DP.hasLogo();
    }

    @Override // android.support.v7.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.Ev) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
