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
    private DecorContentParent CQ;
    private a CT;
    private d CU;
    ActionMode CV;
    ActionBarContextView CW;
    PopupWindow CX;
    Runnable CY;
    ViewPropertyAnimatorCompat CZ;
    private boolean Da;
    private ViewGroup Db;
    private View Dc;
    private boolean Dd;
    private boolean De;
    private boolean Df;
    private PanelFeatureState[] Dg;
    private PanelFeatureState Dh;
    private boolean Di;
    boolean Dj;
    int Dk;
    private final Runnable Dl;
    private boolean Dm;
    private g Dn;
    private TextView mTitleView;
    private Rect nF;
    private Rect nG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.CZ = null;
        this.Dl = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImplV9.this.Dk & 1) != 0) {
                    AppCompatDelegateImplV9.this.az(0);
                }
                if ((AppCompatDelegateImplV9.this.Dk & 4096) != 0) {
                    AppCompatDelegateImplV9.this.az(108);
                }
                AppCompatDelegateImplV9.this.Dj = false;
                AppCompatDelegateImplV9.this.Dk = 0;
            }
        };
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        if ((this.Cs instanceof Activity) && NavUtils.getParentActivityName((Activity) this.Cs) != null) {
            ActionBar dV = dV();
            if (dV == null) {
                this.Dm = true;
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
        if (this.Cw && this.Cv == null) {
            if (this.Cs instanceof Activity) {
                this.Cv = new WindowDecorActionBar((Activity) this.Cs, this.Cx);
            } else if (this.Cs instanceof Dialog) {
                this.Cv = new WindowDecorActionBar((Dialog) this.Cs);
            }
            if (this.Cv != null) {
                this.Cv.setDefaultDisplayHomeAsUpEnabled(this.Dm);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.Cs instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.lh = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                m mVar = new m(toolbar, ((Activity) this.mContext).getTitle(), this.Ct);
                this.Cv = mVar;
                this.BG.setCallback(mVar.ek());
            } else {
                this.Cv = null;
                this.BG.setCallback(this.Ct);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public View findViewById(int i) {
        ec();
        return this.BG.findViewById(i);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.Cw && this.Da && (supportActionBar = getSupportActionBar()) != null) {
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
        ViewGroup viewGroup = (ViewGroup) this.Db.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Cs.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(int i) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.Db.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.Cs.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.Db.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Cs.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ((ViewGroup) this.Db.findViewById(16908290)).addView(view, layoutParams);
        this.Cs.onContentChanged();
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        if (this.Dj) {
            this.BG.getDecorView().removeCallbacks(this.Dl);
        }
        super.onDestroy();
        if (this.Cv != null) {
            this.Cv.onDestroy();
        }
    }

    private void ec() {
        if (!this.Da) {
            this.Db = ed();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                f(title);
            }
            ee();
            h(this.Db);
            this.Da = true;
            PanelFeatureState j = j(0, false);
            if (isDestroyed()) {
                return;
            }
            if (j == null || j.Dw == null) {
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
        this.Cz = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        this.BG.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (!this.CA) {
            if (this.Cz) {
                this.Cx = false;
                this.Cw = false;
                viewGroup2 = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            } else if (this.Cw) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                } else {
                    context = this.mContext;
                }
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.CQ = (DecorContentParent) viewGroup3.findViewById(R.id.decor_content_parent);
                this.CQ.setWindowCallback(dW());
                if (this.Cx) {
                    this.CQ.initFeature(109);
                }
                if (this.Dd) {
                    this.CQ.initFeature(2);
                }
                if (this.De) {
                    this.CQ.initFeature(5);
                }
                viewGroup2 = viewGroup3;
            } else {
                viewGroup2 = null;
            }
        } else {
            if (this.Cy) {
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
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Cw + ", windowActionBarOverlay: " + this.Cx + ", android:windowIsFloating: " + this.Cz + ", windowActionModeOverlay: " + this.Cy + ", windowNoTitle: " + this.CA + " }");
        }
        if (this.CQ == null) {
            this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup4 = (ViewGroup) this.BG.findViewById(16908290);
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
        this.BG.setContentView(viewGroup2);
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
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.Db.findViewById(16908290);
        View decorView = this.BG.getDecorView();
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
        if (this.CA && aB == 108) {
            return false;
        }
        if (this.Cw && aB == 1) {
            this.Cw = false;
        }
        switch (aB) {
            case 1:
                eh();
                this.CA = true;
                return true;
            case 2:
                eh();
                this.Dd = true;
                return true;
            case 5:
                eh();
                this.De = true;
                return true;
            case 10:
                eh();
                this.Cy = true;
                return true;
            case 108:
                eh();
                this.Cw = true;
                return true;
            case 109:
                eh();
                this.Cx = true;
                return true;
            default:
                return this.BG.requestFeature(aB);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int aB = aB(i);
        switch (aB) {
            case 1:
                return this.CA;
            case 2:
                return this.Dd;
            case 5:
                return this.De;
            case 10:
                return this.Cy;
            case 108:
                return this.Cw;
            case 109:
                return this.Cx;
            default:
                return this.BG.hasFeature(aB);
        }
    }

    @Override // android.support.v7.app.b
    void f(CharSequence charSequence) {
        if (this.CQ != null) {
            this.CQ.setWindowTitle(charSequence);
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
            PanelFeatureState j = j(i, true);
            if (j.isOpen) {
                a(j, false);
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
        return dW.onMenuItemSelected(a2.Ds, menuItem);
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
        if (this.CV != null) {
            this.CV.finish();
        }
        b bVar = new b(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.CV = supportActionBar.startActionMode(bVar);
            if (this.CV != null && this.Cu != null) {
                this.Cu.onSupportActionModeStarted(this.CV);
            }
        }
        if (this.CV == null) {
            this.CV = a(bVar);
        }
        return this.CV;
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
        if (this.CV != null) {
            this.CV.finish();
        }
        if (!(callback instanceof b)) {
            callback = new b(callback);
        }
        if (this.Cu == null || isDestroyed()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.Cu.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.CV = actionMode;
        } else {
            if (this.CW == null) {
                if (this.Cz) {
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
                    this.CW = new ActionBarContextView(context);
                    this.CX = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.CX, 2);
                    this.CX.setContentView(this.CW);
                    this.CX.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    this.CW.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.CX.setHeight(-2);
                    this.CY = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImplV9.this.CX.showAtLocation(AppCompatDelegateImplV9.this.CW, 55, 0, 0);
                            AppCompatDelegateImplV9.this.eg();
                            if (AppCompatDelegateImplV9.this.ef()) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CW, 0.0f);
                                AppCompatDelegateImplV9.this.CZ = ViewCompat.animate(AppCompatDelegateImplV9.this.CW).alpha(1.0f);
                                AppCompatDelegateImplV9.this.CZ.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(View view) {
                                        AppCompatDelegateImplV9.this.CW.setVisibility(0);
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(View view) {
                                        ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CW, 1.0f);
                                        AppCompatDelegateImplV9.this.CZ.setListener(null);
                                        AppCompatDelegateImplV9.this.CZ = null;
                                    }
                                });
                                return;
                            }
                            ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CW, 1.0f);
                            AppCompatDelegateImplV9.this.CW.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.Db.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                        this.CW = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.CW != null) {
                eg();
                this.CW.killMode();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.CW.getContext(), this.CW, callback, this.CX == null);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.CW.initForMode(standaloneActionMode);
                    this.CV = standaloneActionMode;
                    if (ef()) {
                        ViewCompat.setAlpha(this.CW, 0.0f);
                        this.CZ = ViewCompat.animate(this.CW).alpha(1.0f);
                        this.CZ.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.6
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(View view) {
                                AppCompatDelegateImplV9.this.CW.setVisibility(0);
                                AppCompatDelegateImplV9.this.CW.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV9.this.CW.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CW.getParent());
                                }
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(View view) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CW, 1.0f);
                                AppCompatDelegateImplV9.this.CZ.setListener(null);
                                AppCompatDelegateImplV9.this.CZ = null;
                            }
                        });
                    } else {
                        ViewCompat.setAlpha(this.CW, 1.0f);
                        this.CW.setVisibility(0);
                        this.CW.sendAccessibilityEvent(32);
                        if (this.CW.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.CW.getParent());
                        }
                    }
                    if (this.CX != null) {
                        this.BG.getDecorView().post(this.CY);
                    }
                } else {
                    this.CV = null;
                }
            }
        }
        if (this.CV != null && this.Cu != null) {
            this.Cu.onSupportActionModeStarted(this.CV);
        }
        return this.CV;
    }

    final boolean ef() {
        return this.Da && this.Db != null && ViewCompat.isLaidOut(this.Db);
    }

    void eg() {
        if (this.CZ != null) {
            this.CZ.cancel();
        }
    }

    boolean onBackPressed() {
        if (this.CV != null) {
            this.CV.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // android.support.v7.app.b
    boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.onKeyShortcut(i, keyEvent)) {
            if (this.Dh != null && a(this.Dh, keyEvent.getKeyCode(), keyEvent, 1)) {
                if (this.Dh != null) {
                    this.Dh.Dz = true;
                    return true;
                }
                return true;
            }
            if (this.Dh == null) {
                PanelFeatureState j = j(0, true);
                b(j, keyEvent);
                boolean a2 = a(j, keyEvent.getKeyCode(), keyEvent, 1);
                j.isPrepared = false;
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
        if (keyEvent.getKeyCode() == 82 && this.Cs.dispatchKeyEvent(keyEvent)) {
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
                boolean z = this.Di;
                this.Di = false;
                PanelFeatureState j = j(0, false);
                if (j != null && j.isOpen) {
                    if (z) {
                        return true;
                    }
                    a(j, true);
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
                this.Di = (keyEvent.getFlags() & 128) != 0;
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
        if (this.Dn == null) {
            this.Dn = new g();
        }
        return this.Dn.a(view, str, context, attributeSet, z && a((ViewParent) view), z, true, VectorEnabledTintResources.shouldBeUsed());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.BG.getDecorView();
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
        if (!(this.Cs instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.Cs).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.isOpen && !isDestroyed()) {
            if (panelFeatureState.Ds == 0) {
                Context context = this.mContext;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback dW = dW();
            if (dW != null && !dW.onMenuOpened(panelFeatureState.Ds, panelFeatureState.Dw)) {
                a(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null && b(panelFeatureState, keyEvent)) {
                if (panelFeatureState.Dt == null || panelFeatureState.DA) {
                    if (panelFeatureState.Dt == null) {
                        if (!a(panelFeatureState) || panelFeatureState.Dt == null) {
                            return;
                        }
                    } else if (panelFeatureState.DA && panelFeatureState.Dt.getChildCount() > 0) {
                        panelFeatureState.Dt.removeAllViews();
                    }
                    if (c(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.Du.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                        panelFeatureState.Dt.setBackgroundResource(panelFeatureState.background);
                        ViewParent parent = panelFeatureState.Du.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(panelFeatureState.Du);
                        }
                        panelFeatureState.Dt.addView(panelFeatureState.Du, layoutParams3);
                        if (!panelFeatureState.Du.hasFocus()) {
                            panelFeatureState.Du.requestFocus();
                        }
                        i = -2;
                    } else {
                        return;
                    }
                } else if (panelFeatureState.Dv == null || (layoutParams = panelFeatureState.Dv.getLayoutParams()) == null || layoutParams.width != -1) {
                    i = -2;
                }
                panelFeatureState.Dz = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                layoutParams4.gravity = panelFeatureState.gravity;
                layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView(panelFeatureState.Dt, layoutParams4);
                panelFeatureState.isOpen = true;
            }
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.U(getActionBarThemedContext());
        panelFeatureState.Dt = new c(panelFeatureState.Dy);
        panelFeatureState.gravity = 81;
        return true;
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        if (this.CQ != null && this.CQ.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.CQ.isOverflowMenuShowPending())) {
            Window.Callback dW = dW();
            if (!this.CQ.isOverflowMenuShowing() || !z) {
                if (dW != null && !isDestroyed()) {
                    if (this.Dj && (this.Dk & 1) != 0) {
                        this.BG.getDecorView().removeCallbacks(this.Dl);
                        this.Dl.run();
                    }
                    PanelFeatureState j = j(0, true);
                    if (j.Dw != null && !j.DB && dW.onPreparePanel(0, j.Dv, j.Dw)) {
                        dW.onMenuOpened(108, j.Dw);
                        this.CQ.showOverflowMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            this.CQ.hideOverflowMenu();
            if (!isDestroyed()) {
                dW.onPanelClosed(108, j(0, true).Dw);
                return;
            }
            return;
        }
        PanelFeatureState j2 = j(0, true);
        j2.DA = true;
        a(j2, false);
        a(j2, (KeyEvent) null);
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context contextThemeWrapper;
        Context context = this.mContext;
        if ((panelFeatureState.Ds == 0 || panelFeatureState.Ds == 108) && this.CQ != null) {
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
        if (panelFeatureState.Dv != null) {
            panelFeatureState.Du = panelFeatureState.Dv;
            return true;
        } else if (panelFeatureState.Dw == null) {
            return false;
        } else {
            if (this.CU == null) {
                this.CU = new d();
            }
            panelFeatureState.Du = (View) panelFeatureState.a(this.CU);
            return panelFeatureState.Du != null;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (isDestroyed()) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        if (this.Dh != null && this.Dh != panelFeatureState) {
            a(this.Dh, false);
        }
        Window.Callback dW = dW();
        if (dW != null) {
            panelFeatureState.Dv = dW.onCreatePanelView(panelFeatureState.Ds);
        }
        boolean z = panelFeatureState.Ds == 0 || panelFeatureState.Ds == 108;
        if (z && this.CQ != null) {
            this.CQ.setMenuPrepared();
        }
        if (panelFeatureState.Dv == null && (!z || !(dV() instanceof m))) {
            if (panelFeatureState.Dw == null || panelFeatureState.DB) {
                if (panelFeatureState.Dw == null && (!b(panelFeatureState) || panelFeatureState.Dw == null)) {
                    return false;
                }
                if (z && this.CQ != null) {
                    if (this.CT == null) {
                        this.CT = new a();
                    }
                    this.CQ.setMenu(panelFeatureState.Dw, this.CT);
                }
                panelFeatureState.Dw.stopDispatchingItemsChanged();
                if (!dW.onCreatePanelMenu(panelFeatureState.Ds, panelFeatureState.Dw)) {
                    panelFeatureState.b(null);
                    if (!z || this.CQ == null) {
                        return false;
                    }
                    this.CQ.setMenu(null, this.CT);
                    return false;
                }
                panelFeatureState.DB = false;
            }
            panelFeatureState.Dw.stopDispatchingItemsChanged();
            if (panelFeatureState.DC != null) {
                panelFeatureState.Dw.restoreActionViewStates(panelFeatureState.DC);
                panelFeatureState.DC = null;
            }
            if (!dW.onPreparePanel(0, panelFeatureState.Dv, panelFeatureState.Dw)) {
                if (z && this.CQ != null) {
                    this.CQ.setMenu(null, this.CT);
                }
                panelFeatureState.Dw.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.Dw.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.Dw.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.Dz = false;
        this.Dh = panelFeatureState;
        return true;
    }

    void a(MenuBuilder menuBuilder) {
        if (!this.Df) {
            this.Df = true;
            this.CQ.dismissPopups();
            Window.Callback dW = dW();
            if (dW != null && !isDestroyed()) {
                dW.onPanelClosed(108, menuBuilder);
            }
            this.Df = false;
        }
    }

    void closePanel(int i) {
        a(j(i, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Ds == 0 && this.CQ != null && this.CQ.isOverflowMenuShowing()) {
            a(panelFeatureState.Dw);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.Dt != null) {
            windowManager.removeView(panelFeatureState.Dt);
            if (z) {
                a(panelFeatureState.Ds, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.Dz = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.Du = null;
        panelFeatureState.DA = true;
        if (this.Dh == panelFeatureState) {
            this.Dh = null;
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState j = j(i, true);
            if (!j.isOpen) {
                return b(j, keyEvent);
            }
        }
        return false;
    }

    private boolean c(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2 = true;
        if (this.CV != null) {
            return false;
        }
        PanelFeatureState j = j(i, true);
        if (i == 0 && this.CQ != null && this.CQ.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if (!this.CQ.isOverflowMenuShowing()) {
                if (!isDestroyed() && b(j, keyEvent)) {
                    z2 = this.CQ.showOverflowMenu();
                }
                z2 = false;
            } else {
                z2 = this.CQ.hideOverflowMenu();
            }
        } else if (j.isOpen || j.Dz) {
            boolean z3 = j.isOpen;
            a(j, true);
            z2 = z3;
        } else {
            if (j.isPrepared) {
                if (j.DB) {
                    j.isPrepared = false;
                    z = b(j, keyEvent);
                } else {
                    z = true;
                }
                if (z) {
                    a(j, keyEvent);
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
            if (panelFeatureState == null && i >= 0 && i < this.Dg.length) {
                panelFeatureState = this.Dg[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Dw;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !isDestroyed()) {
            this.Cs.onPanelClosed(i, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Dg;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Dw == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PanelFeatureState j(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.Dg;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.Dg = panelFeatureStateArr2;
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
            if ((panelFeatureState.isPrepared || b(panelFeatureState, keyEvent)) && panelFeatureState.Dw != null) {
                z = panelFeatureState.Dw.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.CQ == null) {
                a(panelFeatureState, true);
            }
        }
        return z;
    }

    private void invalidatePanelMenu(int i) {
        this.Dk |= 1 << i;
        if (!this.Dj) {
            ViewCompat.postOnAnimation(this.BG.getDecorView(), this.Dl);
            this.Dj = true;
        }
    }

    void az(int i) {
        PanelFeatureState j;
        PanelFeatureState j2 = j(i, true);
        if (j2.Dw != null) {
            Bundle bundle = new Bundle();
            j2.Dw.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                j2.DC = bundle;
            }
            j2.Dw.stopDispatchingItemsChanged();
            j2.Dw.clear();
        }
        j2.DB = true;
        j2.DA = true;
        if ((i == 108 || i == 0) && this.CQ != null && (j = j(0, false)) != null) {
            j.isPrepared = false;
            b(j, (KeyEvent) null);
        }
    }

    int aA(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.CW == null || !(this.CW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.CW.getLayoutParams();
            if (this.CW.isShown()) {
                if (this.nF == null) {
                    this.nF = new Rect();
                    this.nG = new Rect();
                }
                Rect rect = this.nF;
                Rect rect2 = this.nG;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.Db, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.Dc == null) {
                        this.Dc = new View(this.mContext);
                        this.Dc.setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.Db.addView(this.Dc, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.Dc.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.Dc.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                r3 = this.Dc != null;
                if (!this.Cy && r3) {
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
                this.CW.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.Dc != null) {
            this.Dc.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void eh() {
        if (this.Da) {
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
        if (this.CQ != null) {
            this.CQ.dismissPopups();
        }
        if (this.CX != null) {
            this.BG.getDecorView().removeCallbacks(this.CY);
            if (this.CX.isShowing()) {
                try {
                    this.CX.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.CX = null;
        }
        eg();
        PanelFeatureState j = j(0, false);
        if (j != null && j.Dw != null) {
            j.Dw.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ActionMode.Callback {
        private ActionMode.Callback Dq;

        public b(ActionMode.Callback callback) {
            this.Dq = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.Dq.onCreateActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.Dq.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.Dq.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.Dq.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV9.this.CX != null) {
                AppCompatDelegateImplV9.this.BG.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.CY);
            }
            if (AppCompatDelegateImplV9.this.CW != null) {
                AppCompatDelegateImplV9.this.eg();
                AppCompatDelegateImplV9.this.CZ = ViewCompat.animate(AppCompatDelegateImplV9.this.CW).alpha(0.0f);
                AppCompatDelegateImplV9.this.CZ.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.b.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV9.this.CW.setVisibility(8);
                        if (AppCompatDelegateImplV9.this.CX != null) {
                            AppCompatDelegateImplV9.this.CX.dismiss();
                        } else if (AppCompatDelegateImplV9.this.CW.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CW.getParent());
                        }
                        AppCompatDelegateImplV9.this.CW.removeAllViews();
                        AppCompatDelegateImplV9.this.CZ.setListener(null);
                        AppCompatDelegateImplV9.this.CZ = null;
                    }
                });
            }
            if (AppCompatDelegateImplV9.this.Cu != null) {
                AppCompatDelegateImplV9.this.Cu.onSupportActionModeFinished(AppCompatDelegateImplV9.this.CV);
            }
            AppCompatDelegateImplV9.this.CV = null;
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
                    AppCompatDelegateImplV9.this.a(a.Ds, a, rootMenu);
                    AppCompatDelegateImplV9.this.a(a, true);
                    return;
                }
                AppCompatDelegateImplV9.this.a(a, z);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback dW;
            if (menuBuilder == null && AppCompatDelegateImplV9.this.Cw && (dW = AppCompatDelegateImplV9.this.dW()) != null && !AppCompatDelegateImplV9.this.isDestroyed()) {
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
        boolean DA = false;
        boolean DB;
        Bundle DC;
        int Ds;
        ViewGroup Dt;
        View Du;
        View Dv;
        MenuBuilder Dw;
        ListMenuPresenter Dx;
        Context Dy;
        boolean Dz;
        int background;
        int gravity;
        boolean isOpen;
        boolean isPrepared;
        public boolean qwertyMode;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int i) {
            this.Ds = i;
        }

        public boolean hasPanelItems() {
            if (this.Du == null) {
                return false;
            }
            return this.Dv != null || this.Dx.getAdapter().getCount() > 0;
        }

        public void clearMenuPresenters() {
            if (this.Dw != null) {
                this.Dw.removeMenuPresenter(this.Dx);
            }
            this.Dx = null;
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
            this.Dy = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void b(MenuBuilder menuBuilder) {
            if (menuBuilder != this.Dw) {
                if (this.Dw != null) {
                    this.Dw.removeMenuPresenter(this.Dx);
                }
                this.Dw = menuBuilder;
                if (menuBuilder == null || this.Dx == null) {
                    return;
                }
                menuBuilder.addMenuPresenter(this.Dx);
            }
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.Dw == null) {
                return null;
            }
            if (this.Dx == null) {
                this.Dx = new ListMenuPresenter(this.Dy, R.layout.abc_list_menu_item_layout);
                this.Dx.setCallback(callback);
                this.Dw.addMenuPresenter(this.Dx);
            }
            return this.Dx.getMenuView(this.Dt);
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
            int Ds;
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
                parcel.writeInt(this.Ds);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            static SavedState g(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.Ds = parcel.readInt();
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
