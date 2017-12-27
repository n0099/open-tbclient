package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AppCompatDelegateImplV9 extends android.support.v7.app.b implements LayoutInflaterFactory, MenuBuilder.Callback {
    private DecorContentParent CT;
    private a CU;
    private d CV;
    ActionMode CW;
    ActionBarContextView CX;
    PopupWindow CY;
    Runnable CZ;
    ViewPropertyAnimatorCompat Da;
    private boolean Db;
    private ViewGroup Dc;
    private View Dd;
    private boolean De;
    private boolean Df;
    private boolean Dg;
    private PanelFeatureState[] Dh;
    private PanelFeatureState Di;
    private boolean Dj;
    boolean Dk;
    int Dl;
    private final Runnable Dm;
    private boolean Dn;
    private g Do;
    private TextView mTitleView;
    private Rect nF;
    private Rect nG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.Da = null;
        this.Dm = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImplV9.this.Dl & 1) != 0) {
                    AppCompatDelegateImplV9.this.az(0);
                }
                if ((AppCompatDelegateImplV9.this.Dl & 4096) != 0) {
                    AppCompatDelegateImplV9.this.az(108);
                }
                AppCompatDelegateImplV9.this.Dk = false;
                AppCompatDelegateImplV9.this.Dl = 0;
            }
        };
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        if ((this.Ct instanceof Activity) && NavUtils.getParentActivityName((Activity) this.Ct) != null) {
            ActionBar dV = dV();
            if (dV == null) {
                this.Dn = true;
            } else {
                dV.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        ec();
    }

    @Override // android.support.v7.app.b
    public void dU() {
        ec();
        if (this.Cx && this.Cw == null) {
            if (this.Ct instanceof Activity) {
                this.Cw = new WindowDecorActionBar((Activity) this.Ct, this.Cy);
            } else if (this.Ct instanceof Dialog) {
                this.Cw = new WindowDecorActionBar((Dialog) this.Ct);
            }
            if (this.Cw != null) {
                this.Cw.setDefaultDisplayHomeAsUpEnabled(this.Dn);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.Ct instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.lh = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                m mVar = new m(toolbar, ((Activity) this.mContext).getTitle(), this.Cu);
                this.Cw = mVar;
                this.BH.setCallback(mVar.ek());
            } else {
                this.Cw = null;
                this.BH.setCallback(this.Cu);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public View findViewById(int i) {
        ec();
        return this.BH.findViewById(i);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.Cx && this.Db && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight();
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.Dc.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Ct.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(int i) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.Dc.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.Ct.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.Dc.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Ct.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ((ViewGroup) this.Dc.findViewById(16908290)).addView(view, layoutParams);
        this.Ct.onContentChanged();
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        if (this.Dk) {
            this.BH.getDecorView().removeCallbacks(this.Dm);
        }
        super.onDestroy();
        if (this.Cw != null) {
            this.Cw.onDestroy();
        }
    }

    private void ec() {
        if (!this.Db) {
            this.Dc = ed();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                f(title);
            }
            ee();
            h(this.Dc);
            this.Db = true;
            PanelFeatureState g = g(0, false);
            if (isDestroyed()) {
                return;
            }
            if (g == null || g.Dx == null) {
                invalidatePanelMenu(108);
            }
        }
    }

    private ViewGroup ed() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Context context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
            requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.CA = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        this.BH.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (!this.CB) {
            if (this.CA) {
                this.Cy = false;
                this.Cx = false;
                viewGroup2 = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            } else if (this.Cx) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                } else {
                    context = this.mContext;
                }
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.CT = (DecorContentParent) viewGroup3.findViewById(R.id.decor_content_parent);
                this.CT.setWindowCallback(dW());
                if (this.Cy) {
                    this.CT.initFeature(109);
                }
                if (this.De) {
                    this.CT.initFeature(2);
                }
                if (this.Df) {
                    this.CT.initFeature(5);
                }
                viewGroup2 = viewGroup3;
            } else {
                viewGroup2 = null;
            }
        } else {
            if (this.Cz) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.2
                    @Override // android.support.v4.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                        int aA = AppCompatDelegateImplV9.this.aA(systemWindowInsetTop);
                        if (systemWindowInsetTop != aA) {
                            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), aA, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                    }
                });
                viewGroup2 = viewGroup;
            } else {
                ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.3
                    @Override // android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                    public void onFitSystemWindows(Rect rect) {
                        rect.top = AppCompatDelegateImplV9.this.aA(rect.top);
                    }
                });
                viewGroup2 = viewGroup;
            }
        }
        if (viewGroup2 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Cx + ", windowActionBarOverlay: " + this.Cy + ", android:windowIsFloating: " + this.CA + ", windowActionModeOverlay: " + this.Cz + ", windowNoTitle: " + this.CB + " }");
        }
        if (this.CT == null) {
            this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup4 = (ViewGroup) this.BH.findViewById(16908290);
        if (viewGroup4 != null) {
            while (viewGroup4.getChildCount() > 0) {
                View childAt = viewGroup4.getChildAt(0);
                viewGroup4.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup4.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup4 instanceof FrameLayout) {
                ((FrameLayout) viewGroup4).setForeground(null);
            }
        }
        this.BH.setContentView(viewGroup2);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: android.support.v7.app.AppCompatDelegateImplV9.4
            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            public void onAttachedFromWindow() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.OnAttachListener
            public void onDetachedFromWindow() {
                AppCompatDelegateImplV9.this.dismissPopups();
            }
        });
        return viewGroup2;
    }

    void h(ViewGroup viewGroup) {
    }

    private void ee() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.Dc.findViewById(16908290);
        View decorView = this.BH.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int aB = aB(i);
        if (this.CB && aB == 108) {
            return false;
        }
        if (this.Cx && aB == 1) {
            this.Cx = false;
        }
        switch (aB) {
            case 1:
                eh();
                this.CB = true;
                return true;
            case 2:
                eh();
                this.De = true;
                return true;
            case 5:
                eh();
                this.Df = true;
                return true;
            case 10:
                eh();
                this.Cz = true;
                return true;
            case 108:
                eh();
                this.Cx = true;
                return true;
            case 109:
                eh();
                this.Cy = true;
                return true;
            default:
                return this.BH.requestFeature(aB);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int aB = aB(i);
        switch (aB) {
            case 1:
                return this.CB;
            case 2:
                return this.De;
            case 5:
                return this.Df;
            case 10:
                return this.Cz;
            case 108:
                return this.Cx;
            case 109:
                return this.Cy;
            default:
                return this.BH.hasFeature(aB);
        }
    }

    @Override // android.support.v7.app.b
    void f(CharSequence charSequence) {
        if (this.CT != null) {
            this.CT.setWindowTitle(charSequence);
        } else if (dV() != null) {
            dV().setWindowTitle(charSequence);
        } else if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
        }
    }

    @Override // android.support.v7.app.b
    void onPanelClosed(int i, Menu menu) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState g = g(i, true);
            if (g.isOpen) {
                a(g, false);
            }
        }
    }

    @Override // android.support.v7.app.b
    boolean onMenuOpened(int i, Menu menu) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback dW = dW();
        if (dW == null || isDestroyed() || (a2 = a((Menu) menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return dW.onMenuItemSelected(a2.Dt, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        a(menuBuilder, true);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.CW != null) {
            this.CW.finish();
        }
        b bVar = new b(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.CW = supportActionBar.startActionMode(bVar);
            if (this.CW != null && this.Cv != null) {
                this.Cv.onSupportActionModeStarted(this.CW);
            }
        }
        if (this.CW == null) {
            this.CW = a(bVar);
        }
        return this.CW;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    @Override // android.support.v7.app.b
    ActionMode a(ActionMode.Callback callback) {
        ActionMode actionMode;
        Context context;
        eg();
        if (this.CW != null) {
            this.CW.finish();
        }
        if (!(callback instanceof b)) {
            callback = new b(callback);
        }
        if (this.Cv == null || isDestroyed()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.Cv.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.CW = actionMode;
        } else {
            if (this.CX == null) {
                if (this.CA) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.mContext.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = this.mContext.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        context = new ContextThemeWrapper(this.mContext, 0);
                        context.getTheme().setTo(newTheme);
                    } else {
                        context = this.mContext;
                    }
                    this.CX = new ActionBarContextView(context);
                    this.CY = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.CY, 2);
                    this.CY.setContentView(this.CX);
                    this.CY.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    this.CX.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.CY.setHeight(-2);
                    this.CZ = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImplV9.this.CY.showAtLocation(AppCompatDelegateImplV9.this.CX, 55, 0, 0);
                            AppCompatDelegateImplV9.this.eg();
                            if (AppCompatDelegateImplV9.this.ef()) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CX, 0.0f);
                                AppCompatDelegateImplV9.this.Da = ViewCompat.animate(AppCompatDelegateImplV9.this.CX).alpha(1.0f);
                                AppCompatDelegateImplV9.this.Da.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(View view) {
                                        AppCompatDelegateImplV9.this.CX.setVisibility(0);
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(View view) {
                                        ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CX, 1.0f);
                                        AppCompatDelegateImplV9.this.Da.setListener(null);
                                        AppCompatDelegateImplV9.this.Da = null;
                                    }
                                });
                                return;
                            }
                            ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CX, 1.0f);
                            AppCompatDelegateImplV9.this.CX.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.Dc.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                        this.CX = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.CX != null) {
                eg();
                this.CX.killMode();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.CX.getContext(), this.CX, callback, this.CY == null);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.CX.initForMode(standaloneActionMode);
                    this.CW = standaloneActionMode;
                    if (ef()) {
                        ViewCompat.setAlpha(this.CX, 0.0f);
                        this.Da = ViewCompat.animate(this.CX).alpha(1.0f);
                        this.Da.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.6
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(View view) {
                                AppCompatDelegateImplV9.this.CX.setVisibility(0);
                                AppCompatDelegateImplV9.this.CX.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV9.this.CX.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CX.getParent());
                                }
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(View view) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CX, 1.0f);
                                AppCompatDelegateImplV9.this.Da.setListener(null);
                                AppCompatDelegateImplV9.this.Da = null;
                            }
                        });
                    } else {
                        ViewCompat.setAlpha(this.CX, 1.0f);
                        this.CX.setVisibility(0);
                        this.CX.sendAccessibilityEvent(32);
                        if (this.CX.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.CX.getParent());
                        }
                    }
                    if (this.CY != null) {
                        this.BH.getDecorView().post(this.CZ);
                    }
                } else {
                    this.CW = null;
                }
            }
        }
        if (this.CW != null && this.Cv != null) {
            this.Cv.onSupportActionModeStarted(this.CW);
        }
        return this.CW;
    }

    final boolean ef() {
        return this.Db && this.Dc != null && ViewCompat.isLaidOut(this.Dc);
    }

    void eg() {
        if (this.Da != null) {
            this.Da.cancel();
        }
    }

    boolean onBackPressed() {
        if (this.CW != null) {
            this.CW.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // android.support.v7.app.b
    boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.onKeyShortcut(i, keyEvent)) {
            if (this.Di != null && a(this.Di, keyEvent.getKeyCode(), keyEvent, 1)) {
                if (this.Di != null) {
                    this.Di.DA = true;
                    return true;
                }
                return true;
            }
            if (this.Di == null) {
                PanelFeatureState g = g(0, true);
                b(g, keyEvent);
                boolean a2 = a(g, keyEvent.getKeyCode(), keyEvent, 1);
                g.isPrepared = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.support.v7.app.b
    boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.Ct.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 82:
                c(0, keyEvent);
                return true;
            case 4:
                boolean z = this.Dj;
                this.Dj = false;
                PanelFeatureState g = g(0, false);
                if (g != null && g.isOpen) {
                    if (z) {
                        return true;
                    }
                    a(g, true);
                    return true;
                } else if (onBackPressed()) {
                    return true;
                }
                break;
        }
        return false;
    }

    boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 82:
                b(0, keyEvent);
                return true;
            case 4:
                this.Dj = (keyEvent.getFlags() & 128) != 0;
                break;
        }
        if (Build.VERSION.SDK_INT < 11) {
            onKeyShortcut(i, keyEvent);
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public View createView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = Build.VERSION.SDK_INT < 21;
        if (this.Do == null) {
            this.Do = new g();
        }
        return this.Do.a(view, str, context, attributeSet, z && a((ViewParent) view), z, true, VectorEnabledTintResources.shouldBeUsed());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.BH.getDecorView();
        for (ViewParent viewParent2 = viewParent; viewParent2 != null; viewParent2 = viewParent2.getParent()) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        } else if (!(LayoutInflaterCompat.getFactory(from) instanceof AppCompatDelegateImplV9)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.support.v4.view.LayoutInflaterFactory
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 != null ? a2 : createView(view, str, context, attributeSet);
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView;
        if (!(this.Ct instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.Ct).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.isOpen && !isDestroyed()) {
            if (panelFeatureState.Dt == 0) {
                Context context = this.mContext;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback dW = dW();
            if (dW != null && !dW.onMenuOpened(panelFeatureState.Dt, panelFeatureState.Dx)) {
                a(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null && b(panelFeatureState, keyEvent)) {
                if (panelFeatureState.Du == null || panelFeatureState.DB) {
                    if (panelFeatureState.Du == null) {
                        if (!a(panelFeatureState) || panelFeatureState.Du == null) {
                            return;
                        }
                    } else if (panelFeatureState.DB && panelFeatureState.Du.getChildCount() > 0) {
                        panelFeatureState.Du.removeAllViews();
                    }
                    if (c(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.Dv.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                        panelFeatureState.Du.setBackgroundResource(panelFeatureState.background);
                        ViewParent parent = panelFeatureState.Dv.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(panelFeatureState.Dv);
                        }
                        panelFeatureState.Du.addView(panelFeatureState.Dv, layoutParams3);
                        if (!panelFeatureState.Dv.hasFocus()) {
                            panelFeatureState.Dv.requestFocus();
                        }
                        i = -2;
                    } else {
                        return;
                    }
                } else if (panelFeatureState.Dw == null || (layoutParams = panelFeatureState.Dw.getLayoutParams()) == null || layoutParams.width != -1) {
                    i = -2;
                }
                panelFeatureState.DA = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                layoutParams4.gravity = panelFeatureState.gravity;
                layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView(panelFeatureState.Du, layoutParams4);
                panelFeatureState.isOpen = true;
            }
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.U(getActionBarThemedContext());
        panelFeatureState.Du = new c(panelFeatureState.Dz);
        panelFeatureState.gravity = 81;
        return true;
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        if (this.CT != null && this.CT.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.CT.isOverflowMenuShowPending())) {
            Window.Callback dW = dW();
            if (!this.CT.isOverflowMenuShowing() || !z) {
                if (dW != null && !isDestroyed()) {
                    if (this.Dk && (this.Dl & 1) != 0) {
                        this.BH.getDecorView().removeCallbacks(this.Dm);
                        this.Dm.run();
                    }
                    PanelFeatureState g = g(0, true);
                    if (g.Dx != null && !g.DC && dW.onPreparePanel(0, g.Dw, g.Dx)) {
                        dW.onMenuOpened(108, g.Dx);
                        this.CT.showOverflowMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            this.CT.hideOverflowMenu();
            if (!isDestroyed()) {
                dW.onPanelClosed(108, g(0, true).Dx);
                return;
            }
            return;
        }
        PanelFeatureState g2 = g(0, true);
        g2.DB = true;
        a(g2, false);
        a(g2, (KeyEvent) null);
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context contextThemeWrapper;
        Context context = this.mContext;
        if ((panelFeatureState.Dt == 0 || panelFeatureState.Dt == 108) && this.CT != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Resources.Theme theme3 = theme2;
            if (theme3 != null) {
                contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme3);
                MenuBuilder menuBuilder = new MenuBuilder(contextThemeWrapper);
                menuBuilder.setCallback(this);
                panelFeatureState.b(menuBuilder);
                return true;
            }
        }
        contextThemeWrapper = context;
        MenuBuilder menuBuilder2 = new MenuBuilder(contextThemeWrapper);
        menuBuilder2.setCallback(this);
        panelFeatureState.b(menuBuilder2);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.Dw != null) {
            panelFeatureState.Dv = panelFeatureState.Dw;
            return true;
        } else if (panelFeatureState.Dx == null) {
            return false;
        } else {
            if (this.CV == null) {
                this.CV = new d();
            }
            panelFeatureState.Dv = (View) panelFeatureState.a(this.CV);
            return panelFeatureState.Dv != null;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (isDestroyed()) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        if (this.Di != null && this.Di != panelFeatureState) {
            a(this.Di, false);
        }
        Window.Callback dW = dW();
        if (dW != null) {
            panelFeatureState.Dw = dW.onCreatePanelView(panelFeatureState.Dt);
        }
        boolean z = panelFeatureState.Dt == 0 || panelFeatureState.Dt == 108;
        if (z && this.CT != null) {
            this.CT.setMenuPrepared();
        }
        if (panelFeatureState.Dw == null && (!z || !(dV() instanceof m))) {
            if (panelFeatureState.Dx == null || panelFeatureState.DC) {
                if (panelFeatureState.Dx == null && (!b(panelFeatureState) || panelFeatureState.Dx == null)) {
                    return false;
                }
                if (z && this.CT != null) {
                    if (this.CU == null) {
                        this.CU = new a();
                    }
                    this.CT.setMenu(panelFeatureState.Dx, this.CU);
                }
                panelFeatureState.Dx.stopDispatchingItemsChanged();
                if (!dW.onCreatePanelMenu(panelFeatureState.Dt, panelFeatureState.Dx)) {
                    panelFeatureState.b(null);
                    if (!z || this.CT == null) {
                        return false;
                    }
                    this.CT.setMenu(null, this.CU);
                    return false;
                }
                panelFeatureState.DC = false;
            }
            panelFeatureState.Dx.stopDispatchingItemsChanged();
            if (panelFeatureState.DD != null) {
                panelFeatureState.Dx.restoreActionViewStates(panelFeatureState.DD);
                panelFeatureState.DD = null;
            }
            if (!dW.onPreparePanel(0, panelFeatureState.Dw, panelFeatureState.Dx)) {
                if (z && this.CT != null) {
                    this.CT.setMenu(null, this.CU);
                }
                panelFeatureState.Dx.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.Dx.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.Dx.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.DA = false;
        this.Di = panelFeatureState;
        return true;
    }

    void a(MenuBuilder menuBuilder) {
        if (!this.Dg) {
            this.Dg = true;
            this.CT.dismissPopups();
            Window.Callback dW = dW();
            if (dW != null && !isDestroyed()) {
                dW.onPanelClosed(108, menuBuilder);
            }
            this.Dg = false;
        }
    }

    void closePanel(int i) {
        a(g(i, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Dt == 0 && this.CT != null && this.CT.isOverflowMenuShowing()) {
            a(panelFeatureState.Dx);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.Du != null) {
            windowManager.removeView(panelFeatureState.Du);
            if (z) {
                a(panelFeatureState.Dt, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.DA = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.Dv = null;
        panelFeatureState.DB = true;
        if (this.Di == panelFeatureState) {
            this.Di = null;
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState g = g(i, true);
            if (!g.isOpen) {
                return b(g, keyEvent);
            }
        }
        return false;
    }

    private boolean c(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.CW != null) {
            return false;
        }
        PanelFeatureState g = g(i, true);
        if (i == 0 && this.CT != null && this.CT.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if (!this.CT.isOverflowMenuShowing()) {
                if (!isDestroyed() && b(g, keyEvent)) {
                    z2 = this.CT.showOverflowMenu();
                }
                z2 = false;
            } else {
                z2 = this.CT.hideOverflowMenu();
            }
        } else if (g.isOpen || g.DA) {
            boolean z3 = g.isOpen;
            a(g, true);
            z2 = z3;
        } else {
            if (g.isPrepared) {
                if (g.DC) {
                    g.isPrepared = false;
                    z = b(g, keyEvent);
                } else {
                    z = true;
                }
                if (z) {
                    a(g, keyEvent);
                }
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Dh.length) {
                panelFeatureState = this.Dh[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Dx;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !isDestroyed()) {
            this.Ct.onPanelClosed(i, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Dh;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Dx == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PanelFeatureState g(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.Dh;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.Dh = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
            panelFeatureStateArr[i] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.isPrepared || b(panelFeatureState, keyEvent)) && panelFeatureState.Dx != null) {
                z = panelFeatureState.Dx.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.CT == null) {
                a(panelFeatureState, true);
            }
        }
        return z;
    }

    private void invalidatePanelMenu(int i) {
        this.Dl |= 1 << i;
        if (!this.Dk) {
            ViewCompat.postOnAnimation(this.BH.getDecorView(), this.Dm);
            this.Dk = true;
        }
    }

    void az(int i) {
        PanelFeatureState g;
        PanelFeatureState g2 = g(i, true);
        if (g2.Dx != null) {
            Bundle bundle = new Bundle();
            g2.Dx.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                g2.DD = bundle;
            }
            g2.Dx.stopDispatchingItemsChanged();
            g2.Dx.clear();
        }
        g2.DC = true;
        g2.DB = true;
        if ((i == 108 || i == 0) && this.CT != null && (g = g(0, false)) != null) {
            g.isPrepared = false;
            b(g, (KeyEvent) null);
        }
    }

    int aA(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.CX == null || !(this.CX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.CX.getLayoutParams();
            if (this.CX.isShown()) {
                if (this.nF == null) {
                    this.nF = new Rect();
                    this.nG = new Rect();
                }
                Rect rect = this.nF;
                Rect rect2 = this.nG;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.Dc, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.Dd == null) {
                        this.Dd = new View(this.mContext);
                        this.Dd.setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.Dc.addView(this.Dd, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.Dd.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.Dd.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                r3 = this.Dd != null;
                if (!this.Cz && r3) {
                    i = 0;
                }
                boolean z4 = z3;
                z2 = r3;
                r3 = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                r3 = false;
                z2 = false;
            }
            if (r3) {
                this.CX.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.Dd != null) {
            this.Dd.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void eh() {
        if (this.Db) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int aB(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i;
        }
    }

    void dismissPopups() {
        if (this.CT != null) {
            this.CT.dismissPopups();
        }
        if (this.CY != null) {
            this.BH.getDecorView().removeCallbacks(this.CZ);
            if (this.CY.isShowing()) {
                try {
                    this.CY.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.CY = null;
        }
        eg();
        PanelFeatureState g = g(0, false);
        if (g != null && g.Dx != null) {
            g.Dx.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ActionMode.Callback {
        private ActionMode.Callback Dr;

        public b(ActionMode.Callback callback) {
            this.Dr = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.Dr.onCreateActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.Dr.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.Dr.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.Dr.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV9.this.CY != null) {
                AppCompatDelegateImplV9.this.BH.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.CZ);
            }
            if (AppCompatDelegateImplV9.this.CX != null) {
                AppCompatDelegateImplV9.this.eg();
                AppCompatDelegateImplV9.this.Da = ViewCompat.animate(AppCompatDelegateImplV9.this.CX).alpha(0.0f);
                AppCompatDelegateImplV9.this.Da.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.b.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV9.this.CX.setVisibility(8);
                        if (AppCompatDelegateImplV9.this.CY != null) {
                            AppCompatDelegateImplV9.this.CY.dismiss();
                        } else if (AppCompatDelegateImplV9.this.CX.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CX.getParent());
                        }
                        AppCompatDelegateImplV9.this.CX.removeAllViews();
                        AppCompatDelegateImplV9.this.Da.setListener(null);
                        AppCompatDelegateImplV9.this.Da = null;
                    }
                });
            }
            if (AppCompatDelegateImplV9.this.Cv != null) {
                AppCompatDelegateImplV9.this.Cv.onSupportActionModeFinished(AppCompatDelegateImplV9.this.CW);
            }
            AppCompatDelegateImplV9.this.CW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class d implements MenuPresenter.Callback {
        d() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState a = appCompatDelegateImplV9.a((Menu) menuBuilder);
            if (a != null) {
                if (z2) {
                    AppCompatDelegateImplV9.this.a(a.Dt, a, rootMenu);
                    AppCompatDelegateImplV9.this.a(a, true);
                    return;
                }
                AppCompatDelegateImplV9.this.a(a, z);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback dW;
            if (menuBuilder == null && AppCompatDelegateImplV9.this.Cx && (dW = AppCompatDelegateImplV9.this.dW()) != null && !AppCompatDelegateImplV9.this.isDestroyed()) {
                dW.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements MenuPresenter.Callback {
        a() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback dW = AppCompatDelegateImplV9.this.dW();
            if (dW != null) {
                dW.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImplV9.this.a(menuBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class PanelFeatureState {
        boolean DA;
        boolean DB = false;
        boolean DC;
        Bundle DD;
        int Dt;
        ViewGroup Du;
        View Dv;
        View Dw;
        MenuBuilder Dx;
        ListMenuPresenter Dy;
        Context Dz;
        int background;
        int gravity;
        boolean isOpen;
        boolean isPrepared;
        public boolean qwertyMode;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int i) {
            this.Dt = i;
        }

        public boolean hasPanelItems() {
            if (this.Dv == null) {
                return false;
            }
            return this.Dw != null || this.Dy.getAdapter().getCount() > 0;
        }

        public void clearMenuPresenters() {
            if (this.Dx != null) {
                this.Dx.removeMenuPresenter(this.Dy);
            }
            this.Dy = null;
        }

        void U(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.Dz = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void b(MenuBuilder menuBuilder) {
            if (menuBuilder != this.Dx) {
                if (this.Dx != null) {
                    this.Dx.removeMenuPresenter(this.Dy);
                }
                this.Dx = menuBuilder;
                if (menuBuilder == null || this.Dy == null) {
                    return;
                }
                menuBuilder.addMenuPresenter(this.Dy);
            }
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.Dx == null) {
                return null;
            }
            if (this.Dy == null) {
                this.Dy = new ListMenuPresenter(this.Dz, R.layout.abc_list_menu_item_layout);
                this.Dy.setCallback(callback);
                this.Dx.addMenuPresenter(this.Dy);
            }
            return this.Dy.getMenuView(this.Du);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
                /* renamed from: h */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.g(parcel, classLoader);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
                /* renamed from: aC */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            int Dt;
            boolean isOpen;
            Bundle menuState;

            SavedState() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.Dt);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            static SavedState g(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.Dt = parcel.readInt();
                savedState.isOpen = parcel.readInt() == 1;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV9.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && v((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImplV9.this.closePanel(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }

        private boolean v(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }
}
