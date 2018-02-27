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
    private DecorContentParent CL;
    private a CM;
    private d CN;
    ActionMode CO;
    ActionBarContextView CP;
    PopupWindow CQ;
    Runnable CT;
    ViewPropertyAnimatorCompat CU;
    private boolean CV;
    private ViewGroup CW;
    private View CX;
    private boolean CY;
    private boolean CZ;
    private boolean Da;
    private PanelFeatureState[] Db;
    private PanelFeatureState Dc;
    private boolean Dd;
    boolean De;
    int Df;
    private final Runnable Dg;
    private boolean Dh;
    private g Di;
    private TextView mTitleView;
    private Rect nF;
    private Rect nG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.CU = null;
        this.Dg = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.1
            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImplV9.this.Df & 1) != 0) {
                    AppCompatDelegateImplV9.this.az(0);
                }
                if ((AppCompatDelegateImplV9.this.Df & 4096) != 0) {
                    AppCompatDelegateImplV9.this.az(108);
                }
                AppCompatDelegateImplV9.this.De = false;
                AppCompatDelegateImplV9.this.Df = 0;
            }
        };
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        if ((this.Cn instanceof Activity) && NavUtils.getParentActivityName((Activity) this.Cn) != null) {
            ActionBar dV = dV();
            if (dV == null) {
                this.Dh = true;
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
        if (this.Cr && this.Cq == null) {
            if (this.Cn instanceof Activity) {
                this.Cq = new WindowDecorActionBar((Activity) this.Cn, this.Cs);
            } else if (this.Cn instanceof Dialog) {
                this.Cq = new WindowDecorActionBar((Dialog) this.Cn);
            }
            if (this.Cq != null) {
                this.Cq.setDefaultDisplayHomeAsUpEnabled(this.Dh);
            }
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.Cn instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.lh = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                m mVar = new m(toolbar, ((Activity) this.mContext).getTitle(), this.Co);
                this.Cq = mVar;
                this.BB.setCallback(mVar.ek());
            } else {
                this.Cq = null;
                this.BB.setCallback(this.Co);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public View findViewById(int i) {
        ec();
        return this.BB.findViewById(i);
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.Cr && this.CV && (supportActionBar = getSupportActionBar()) != null) {
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
        ViewGroup viewGroup = (ViewGroup) this.CW.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Cn.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(int i) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.CW.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.Cn.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ViewGroup viewGroup = (ViewGroup) this.CW.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Cn.onContentChanged();
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ec();
        ((ViewGroup) this.CW.findViewById(16908290)).addView(view, layoutParams);
        this.Cn.onContentChanged();
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        if (this.De) {
            this.BB.getDecorView().removeCallbacks(this.Dg);
        }
        super.onDestroy();
        if (this.Cq != null) {
            this.Cq.onDestroy();
        }
    }

    private void ec() {
        if (!this.CV) {
            this.CW = ed();
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                f(title);
            }
            ee();
            h(this.CW);
            this.CV = true;
            PanelFeatureState j = j(0, false);
            if (isDestroyed()) {
                return;
            }
            if (j == null || j.Dr == null) {
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
        this.Cu = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        this.BB.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (!this.Cv) {
            if (this.Cu) {
                this.Cs = false;
                this.Cr = false;
                viewGroup2 = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
            } else if (this.Cr) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                } else {
                    context = this.mContext;
                }
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.CL = (DecorContentParent) viewGroup3.findViewById(R.id.decor_content_parent);
                this.CL.setWindowCallback(dW());
                if (this.Cs) {
                    this.CL.initFeature(109);
                }
                if (this.CY) {
                    this.CL.initFeature(2);
                }
                if (this.CZ) {
                    this.CL.initFeature(5);
                }
                viewGroup2 = viewGroup3;
            } else {
                viewGroup2 = null;
            }
        } else {
            if (this.Ct) {
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
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Cr + ", windowActionBarOverlay: " + this.Cs + ", android:windowIsFloating: " + this.Cu + ", windowActionModeOverlay: " + this.Ct + ", windowNoTitle: " + this.Cv + " }");
        }
        if (this.CL == null) {
            this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup2);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup2.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup4 = (ViewGroup) this.BB.findViewById(16908290);
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
        this.BB.setContentView(viewGroup2);
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
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.CW.findViewById(16908290);
        View decorView = this.BB.getDecorView();
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
        if (this.Cv && aB == 108) {
            return false;
        }
        if (this.Cr && aB == 1) {
            this.Cr = false;
        }
        switch (aB) {
            case 1:
                eh();
                this.Cv = true;
                return true;
            case 2:
                eh();
                this.CY = true;
                return true;
            case 5:
                eh();
                this.CZ = true;
                return true;
            case 10:
                eh();
                this.Ct = true;
                return true;
            case 108:
                eh();
                this.Cr = true;
                return true;
            case 109:
                eh();
                this.Cs = true;
                return true;
            default:
                return this.BB.requestFeature(aB);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        int aB = aB(i);
        switch (aB) {
            case 1:
                return this.Cv;
            case 2:
                return this.CY;
            case 5:
                return this.CZ;
            case 10:
                return this.Ct;
            case 108:
                return this.Cr;
            case 109:
                return this.Cs;
            default:
                return this.BB.hasFeature(aB);
        }
    }

    @Override // android.support.v7.app.b
    void f(CharSequence charSequence) {
        if (this.CL != null) {
            this.CL.setWindowTitle(charSequence);
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
        return dW.onMenuItemSelected(a2.Dn, menuItem);
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
        if (this.CO != null) {
            this.CO.finish();
        }
        b bVar = new b(callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.CO = supportActionBar.startActionMode(bVar);
            if (this.CO != null && this.Cp != null) {
                this.Cp.onSupportActionModeStarted(this.CO);
            }
        }
        if (this.CO == null) {
            this.CO = a(bVar);
        }
        return this.CO;
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
        if (this.CO != null) {
            this.CO.finish();
        }
        if (!(callback instanceof b)) {
            callback = new b(callback);
        }
        if (this.Cp == null || isDestroyed()) {
            actionMode = null;
        } else {
            try {
                actionMode = this.Cp.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
                actionMode = null;
            }
        }
        if (actionMode != null) {
            this.CO = actionMode;
        } else {
            if (this.CP == null) {
                if (this.Cu) {
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
                    this.CP = new ActionBarContextView(context);
                    this.CQ = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.CQ, 2);
                    this.CQ.setContentView(this.CP);
                    this.CQ.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    this.CP.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    this.CQ.setHeight(-2);
                    this.CT = new Runnable() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImplV9.this.CQ.showAtLocation(AppCompatDelegateImplV9.this.CP, 55, 0, 0);
                            AppCompatDelegateImplV9.this.eg();
                            if (AppCompatDelegateImplV9.this.ef()) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CP, 0.0f);
                                AppCompatDelegateImplV9.this.CU = ViewCompat.animate(AppCompatDelegateImplV9.this.CP).alpha(1.0f);
                                AppCompatDelegateImplV9.this.CU.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.5.1
                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationStart(View view) {
                                        AppCompatDelegateImplV9.this.CP.setVisibility(0);
                                    }

                                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                                    public void onAnimationEnd(View view) {
                                        ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CP, 1.0f);
                                        AppCompatDelegateImplV9.this.CU.setListener(null);
                                        AppCompatDelegateImplV9.this.CU = null;
                                    }
                                });
                                return;
                            }
                            ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CP, 1.0f);
                            AppCompatDelegateImplV9.this.CP.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.CW.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                        this.CP = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.CP != null) {
                eg();
                this.CP.killMode();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.CP.getContext(), this.CP, callback, this.CQ == null);
                if (callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.CP.initForMode(standaloneActionMode);
                    this.CO = standaloneActionMode;
                    if (ef()) {
                        ViewCompat.setAlpha(this.CP, 0.0f);
                        this.CU = ViewCompat.animate(this.CP).alpha(1.0f);
                        this.CU.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.6
                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationStart(View view) {
                                AppCompatDelegateImplV9.this.CP.setVisibility(0);
                                AppCompatDelegateImplV9.this.CP.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV9.this.CP.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CP.getParent());
                                }
                            }

                            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                            public void onAnimationEnd(View view) {
                                ViewCompat.setAlpha(AppCompatDelegateImplV9.this.CP, 1.0f);
                                AppCompatDelegateImplV9.this.CU.setListener(null);
                                AppCompatDelegateImplV9.this.CU = null;
                            }
                        });
                    } else {
                        ViewCompat.setAlpha(this.CP, 1.0f);
                        this.CP.setVisibility(0);
                        this.CP.sendAccessibilityEvent(32);
                        if (this.CP.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.CP.getParent());
                        }
                    }
                    if (this.CQ != null) {
                        this.BB.getDecorView().post(this.CT);
                    }
                } else {
                    this.CO = null;
                }
            }
        }
        if (this.CO != null && this.Cp != null) {
            this.Cp.onSupportActionModeStarted(this.CO);
        }
        return this.CO;
    }

    final boolean ef() {
        return this.CV && this.CW != null && ViewCompat.isLaidOut(this.CW);
    }

    void eg() {
        if (this.CU != null) {
            this.CU.cancel();
        }
    }

    boolean onBackPressed() {
        if (this.CO != null) {
            this.CO.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // android.support.v7.app.b
    boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.onKeyShortcut(i, keyEvent)) {
            if (this.Dc != null && a(this.Dc, keyEvent.getKeyCode(), keyEvent, 1)) {
                if (this.Dc != null) {
                    this.Dc.Du = true;
                    return true;
                }
                return true;
            }
            if (this.Dc == null) {
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
        if (keyEvent.getKeyCode() == 82 && this.Cn.dispatchKeyEvent(keyEvent)) {
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
                boolean z = this.Dd;
                this.Dd = false;
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
                this.Dd = (keyEvent.getFlags() & 128) != 0;
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
        if (this.Di == null) {
            this.Di = new g();
        }
        return this.Di.a(view, str, context, attributeSet, z && a((ViewParent) view), z, true, VectorEnabledTintResources.shouldBeUsed());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.BB.getDecorView();
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
        if (!(this.Cn instanceof LayoutInflater.Factory) || (onCreateView = ((LayoutInflater.Factory) this.Cn).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return onCreateView;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        ViewGroup.LayoutParams layoutParams;
        int i = -1;
        if (!panelFeatureState.isOpen && !isDestroyed()) {
            if (panelFeatureState.Dn == 0) {
                Context context = this.mContext;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
                if (z && z2) {
                    return;
                }
            }
            Window.Callback dW = dW();
            if (dW != null && !dW.onMenuOpened(panelFeatureState.Dn, panelFeatureState.Dr)) {
                a(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null && b(panelFeatureState, keyEvent)) {
                if (panelFeatureState.Do == null || panelFeatureState.Dv) {
                    if (panelFeatureState.Do == null) {
                        if (!a(panelFeatureState) || panelFeatureState.Do == null) {
                            return;
                        }
                    } else if (panelFeatureState.Dv && panelFeatureState.Do.getChildCount() > 0) {
                        panelFeatureState.Do.removeAllViews();
                    }
                    if (c(panelFeatureState) && panelFeatureState.hasPanelItems()) {
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.Dp.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams3 = layoutParams2 == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams2;
                        panelFeatureState.Do.setBackgroundResource(panelFeatureState.background);
                        ViewParent parent = panelFeatureState.Dp.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(panelFeatureState.Dp);
                        }
                        panelFeatureState.Do.addView(panelFeatureState.Dp, layoutParams3);
                        if (!panelFeatureState.Dp.hasFocus()) {
                            panelFeatureState.Dp.requestFocus();
                        }
                        i = -2;
                    } else {
                        return;
                    }
                } else if (panelFeatureState.Dq == null || (layoutParams = panelFeatureState.Dq.getLayoutParams()) == null || layoutParams.width != -1) {
                    i = -2;
                }
                panelFeatureState.Du = false;
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                layoutParams4.gravity = panelFeatureState.gravity;
                layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView(panelFeatureState.Do, layoutParams4);
                panelFeatureState.isOpen = true;
            }
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.U(getActionBarThemedContext());
        panelFeatureState.Do = new c(panelFeatureState.Dt);
        panelFeatureState.gravity = 81;
        return true;
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        if (this.CL != null && this.CL.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.CL.isOverflowMenuShowPending())) {
            Window.Callback dW = dW();
            if (!this.CL.isOverflowMenuShowing() || !z) {
                if (dW != null && !isDestroyed()) {
                    if (this.De && (this.Df & 1) != 0) {
                        this.BB.getDecorView().removeCallbacks(this.Dg);
                        this.Dg.run();
                    }
                    PanelFeatureState j = j(0, true);
                    if (j.Dr != null && !j.Dw && dW.onPreparePanel(0, j.Dq, j.Dr)) {
                        dW.onMenuOpened(108, j.Dr);
                        this.CL.showOverflowMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            this.CL.hideOverflowMenu();
            if (!isDestroyed()) {
                dW.onPanelClosed(108, j(0, true).Dr);
                return;
            }
            return;
        }
        PanelFeatureState j2 = j(0, true);
        j2.Dv = true;
        a(j2, false);
        a(j2, (KeyEvent) null);
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context contextThemeWrapper;
        Context context = this.mContext;
        if ((panelFeatureState.Dn == 0 || panelFeatureState.Dn == 108) && this.CL != null) {
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
        if (panelFeatureState.Dq != null) {
            panelFeatureState.Dp = panelFeatureState.Dq;
            return true;
        } else if (panelFeatureState.Dr == null) {
            return false;
        } else {
            if (this.CN == null) {
                this.CN = new d();
            }
            panelFeatureState.Dp = (View) panelFeatureState.a(this.CN);
            return panelFeatureState.Dp != null;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (isDestroyed()) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        if (this.Dc != null && this.Dc != panelFeatureState) {
            a(this.Dc, false);
        }
        Window.Callback dW = dW();
        if (dW != null) {
            panelFeatureState.Dq = dW.onCreatePanelView(panelFeatureState.Dn);
        }
        boolean z = panelFeatureState.Dn == 0 || panelFeatureState.Dn == 108;
        if (z && this.CL != null) {
            this.CL.setMenuPrepared();
        }
        if (panelFeatureState.Dq == null && (!z || !(dV() instanceof m))) {
            if (panelFeatureState.Dr == null || panelFeatureState.Dw) {
                if (panelFeatureState.Dr == null && (!b(panelFeatureState) || panelFeatureState.Dr == null)) {
                    return false;
                }
                if (z && this.CL != null) {
                    if (this.CM == null) {
                        this.CM = new a();
                    }
                    this.CL.setMenu(panelFeatureState.Dr, this.CM);
                }
                panelFeatureState.Dr.stopDispatchingItemsChanged();
                if (!dW.onCreatePanelMenu(panelFeatureState.Dn, panelFeatureState.Dr)) {
                    panelFeatureState.b(null);
                    if (!z || this.CL == null) {
                        return false;
                    }
                    this.CL.setMenu(null, this.CM);
                    return false;
                }
                panelFeatureState.Dw = false;
            }
            panelFeatureState.Dr.stopDispatchingItemsChanged();
            if (panelFeatureState.Dx != null) {
                panelFeatureState.Dr.restoreActionViewStates(panelFeatureState.Dx);
                panelFeatureState.Dx = null;
            }
            if (!dW.onPreparePanel(0, panelFeatureState.Dq, panelFeatureState.Dr)) {
                if (z && this.CL != null) {
                    this.CL.setMenu(null, this.CM);
                }
                panelFeatureState.Dr.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.Dr.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.Dr.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.Du = false;
        this.Dc = panelFeatureState;
        return true;
    }

    void a(MenuBuilder menuBuilder) {
        if (!this.Da) {
            this.Da = true;
            this.CL.dismissPopups();
            Window.Callback dW = dW();
            if (dW != null && !isDestroyed()) {
                dW.onPanelClosed(108, menuBuilder);
            }
            this.Da = false;
        }
    }

    void closePanel(int i) {
        a(j(i, true), true);
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Dn == 0 && this.CL != null && this.CL.isOverflowMenuShowing()) {
            a(panelFeatureState.Dr);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.Do != null) {
            windowManager.removeView(panelFeatureState.Do);
            if (z) {
                a(panelFeatureState.Dn, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.Du = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.Dp = null;
        panelFeatureState.Dv = true;
        if (this.Dc == panelFeatureState) {
            this.Dc = null;
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
        if (this.CO != null) {
            return false;
        }
        PanelFeatureState j = j(i, true);
        if (i == 0 && this.CL != null && this.CL.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if (!this.CL.isOverflowMenuShowing()) {
                if (!isDestroyed() && b(j, keyEvent)) {
                    z2 = this.CL.showOverflowMenu();
                }
                z2 = false;
            } else {
                z2 = this.CL.hideOverflowMenu();
            }
        } else if (j.isOpen || j.Du) {
            boolean z3 = j.isOpen;
            a(j, true);
            z2 = z3;
        } else {
            if (j.isPrepared) {
                if (j.Dw) {
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
            if (panelFeatureState == null && i >= 0 && i < this.Db.length) {
                panelFeatureState = this.Db[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Dr;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !isDestroyed()) {
            this.Cn.onPanelClosed(i, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Db;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Dr == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PanelFeatureState j(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.Db;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.Db = panelFeatureStateArr2;
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
            if ((panelFeatureState.isPrepared || b(panelFeatureState, keyEvent)) && panelFeatureState.Dr != null) {
                z = panelFeatureState.Dr.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.CL == null) {
                a(panelFeatureState, true);
            }
        }
        return z;
    }

    private void invalidatePanelMenu(int i) {
        this.Df |= 1 << i;
        if (!this.De) {
            ViewCompat.postOnAnimation(this.BB.getDecorView(), this.Dg);
            this.De = true;
        }
    }

    void az(int i) {
        PanelFeatureState j;
        PanelFeatureState j2 = j(i, true);
        if (j2.Dr != null) {
            Bundle bundle = new Bundle();
            j2.Dr.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                j2.Dx = bundle;
            }
            j2.Dr.stopDispatchingItemsChanged();
            j2.Dr.clear();
        }
        j2.Dw = true;
        j2.Dv = true;
        if ((i == 108 || i == 0) && this.CL != null && (j = j(0, false)) != null) {
            j.isPrepared = false;
            b(j, (KeyEvent) null);
        }
    }

    int aA(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.CP == null || !(this.CP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.CP.getLayoutParams();
            if (this.CP.isShown()) {
                if (this.nF == null) {
                    this.nF = new Rect();
                    this.nG = new Rect();
                }
                Rect rect = this.nF;
                Rect rect2 = this.nG;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.CW, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.CX == null) {
                        this.CX = new View(this.mContext);
                        this.CX.setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.CW.addView(this.CX, -1, new ViewGroup.LayoutParams(-1, i));
                        z3 = true;
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.CX.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.CX.setLayoutParams(layoutParams);
                        }
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                r3 = this.CX != null;
                if (!this.Ct && r3) {
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
                this.CP.setLayoutParams(marginLayoutParams);
            }
            z = z2;
        }
        if (this.CX != null) {
            this.CX.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void eh() {
        if (this.CV) {
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
        if (this.CL != null) {
            this.CL.dismissPopups();
        }
        if (this.CQ != null) {
            this.BB.getDecorView().removeCallbacks(this.CT);
            if (this.CQ.isShowing()) {
                try {
                    this.CQ.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.CQ = null;
        }
        eg();
        PanelFeatureState j = j(0, false);
        if (j != null && j.Dr != null) {
            j.Dr.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ActionMode.Callback {
        private ActionMode.Callback Dl;

        public b(ActionMode.Callback callback) {
            this.Dl = callback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.Dl.onCreateActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.Dl.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.Dl.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.Dl.onDestroyActionMode(actionMode);
            if (AppCompatDelegateImplV9.this.CQ != null) {
                AppCompatDelegateImplV9.this.BB.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.CT);
            }
            if (AppCompatDelegateImplV9.this.CP != null) {
                AppCompatDelegateImplV9.this.eg();
                AppCompatDelegateImplV9.this.CU = ViewCompat.animate(AppCompatDelegateImplV9.this.CP).alpha(0.0f);
                AppCompatDelegateImplV9.this.CU.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.app.AppCompatDelegateImplV9.b.1
                    @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImplV9.this.CP.setVisibility(8);
                        if (AppCompatDelegateImplV9.this.CQ != null) {
                            AppCompatDelegateImplV9.this.CQ.dismiss();
                        } else if (AppCompatDelegateImplV9.this.CP.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV9.this.CP.getParent());
                        }
                        AppCompatDelegateImplV9.this.CP.removeAllViews();
                        AppCompatDelegateImplV9.this.CU.setListener(null);
                        AppCompatDelegateImplV9.this.CU = null;
                    }
                });
            }
            if (AppCompatDelegateImplV9.this.Cp != null) {
                AppCompatDelegateImplV9.this.Cp.onSupportActionModeFinished(AppCompatDelegateImplV9.this.CO);
            }
            AppCompatDelegateImplV9.this.CO = null;
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
                    AppCompatDelegateImplV9.this.a(a.Dn, a, rootMenu);
                    AppCompatDelegateImplV9.this.a(a, true);
                    return;
                }
                AppCompatDelegateImplV9.this.a(a, z);
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback dW;
            if (menuBuilder == null && AppCompatDelegateImplV9.this.Cr && (dW = AppCompatDelegateImplV9.this.dW()) != null && !AppCompatDelegateImplV9.this.isDestroyed()) {
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
        int Dn;
        ViewGroup Do;
        View Dp;
        View Dq;
        MenuBuilder Dr;
        ListMenuPresenter Ds;
        Context Dt;
        boolean Du;
        boolean Dv = false;
        boolean Dw;
        Bundle Dx;
        int background;
        int gravity;
        boolean isOpen;
        boolean isPrepared;
        public boolean qwertyMode;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int i) {
            this.Dn = i;
        }

        public boolean hasPanelItems() {
            if (this.Dp == null) {
                return false;
            }
            return this.Dq != null || this.Ds.getAdapter().getCount() > 0;
        }

        public void clearMenuPresenters() {
            if (this.Dr != null) {
                this.Dr.removeMenuPresenter(this.Ds);
            }
            this.Ds = null;
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
            this.Dt = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void b(MenuBuilder menuBuilder) {
            if (menuBuilder != this.Dr) {
                if (this.Dr != null) {
                    this.Dr.removeMenuPresenter(this.Ds);
                }
                this.Dr = menuBuilder;
                if (menuBuilder == null || this.Ds == null) {
                    return;
                }
                menuBuilder.addMenuPresenter(this.Ds);
            }
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.Dr == null) {
                return null;
            }
            if (this.Ds == null) {
                this.Ds = new ListMenuPresenter(this.Dt, R.layout.abc_list_menu_item_layout);
                this.Ds.setCallback(callback);
                this.Dr.addMenuPresenter(this.Ds);
            }
            return this.Ds.getMenuView(this.Do);
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
            int Dn;
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
                parcel.writeInt(this.Dn);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            static SavedState g(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.Dn = parcel.readInt();
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
