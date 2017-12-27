package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
@RestrictTo
/* loaded from: classes2.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    Window.Callback DR;
    private int XZ;
    private View Ya;
    private Spinner Yb;
    private Drawable Yc;
    private Drawable Yd;
    private boolean Ye;
    private CharSequence Yf;
    boolean Yg;
    private int Yh;
    private int Yi;
    private Drawable Yj;
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private Drawable mIcon;
    CharSequence mTitle;
    Toolbar mZ;
    private CharSequence ym;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.Yh = 0;
        this.Yi = 0;
        this.mZ = toolbar;
        this.mTitle = toolbar.getTitle();
        this.ym = toolbar.getSubtitle();
        this.Ye = this.mTitle != null;
        this.Yd = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.Yj = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable != null) {
                setLogo(drawable);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable2 != null) {
                setIcon(drawable2);
            }
            if (this.Yd == null && this.Yj != null) {
                setNavigationIcon(this.Yj);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.mZ.getContext()).inflate(resourceId, (ViewGroup) this.mZ, false));
                setDisplayOptions(this.XZ | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.mZ.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mZ.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.mZ.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                this.mZ.setTitleTextAppearance(this.mZ.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                this.mZ.setSubtitleTextAppearance(this.mZ.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.mZ.setPopupTheme(resourceId4);
            }
        } else {
            this.XZ = iy();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.Yf = this.mZ.getNavigationContentDescription();
        this.mZ.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.1
            final ActionMenuItem Yk;

            {
                this.Yk = new ActionMenuItem(ToolbarWidgetWrapper.this.mZ.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.DR != null && ToolbarWidgetWrapper.this.Yg) {
                    ToolbarWidgetWrapper.this.DR.onMenuItemSelected(0, this.Yk);
                }
            }
        });
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.Yi) {
            this.Yi = i;
            if (TextUtils.isEmpty(this.mZ.getNavigationContentDescription())) {
                setNavigationContentDescription(this.Yi);
            }
        }
    }

    private int iy() {
        if (this.mZ.getNavigationIcon() == null) {
            return 11;
        }
        this.Yj = this.mZ.getNavigationIcon();
        return 15;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.mZ;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public Context getContext() {
        return this.mZ.getContext();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.mZ.hasExpandedActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void collapseActionView() {
        this.mZ.collapseActionView();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.DR = callback;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.Ye) {
            m(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.mZ.getTitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.Ye = true;
        m(charSequence);
    }

    private void m(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.XZ & 8) != 0) {
            this.mZ.setTitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.mZ.getSubtitle();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        this.ym = charSequence;
        if ((this.XZ & 8) != 0) {
            this.mZ.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasIcon() {
        return this.mIcon != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasLogo() {
        return this.Yc != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        iz();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        this.Yc = drawable;
        iz();
    }

    private void iz() {
        Drawable drawable = null;
        if ((this.XZ & 2) != 0) {
            if ((this.XZ & 1) != 0) {
                drawable = this.Yc != null ? this.Yc : this.mIcon;
            } else {
                drawable = this.mIcon;
            }
        }
        this.mZ.setLogo(drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.mZ.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.mZ.isOverflowMenuShowing();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.mZ.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mZ.showOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.mZ.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenuPrepared() {
        this.Yg = true;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mZ.getContext());
            this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mZ.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.mZ.dismissPopupMenus();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.XZ;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        int i2 = this.XZ ^ i;
        this.XZ = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    iC();
                }
                iB();
            }
            if ((i2 & 3) != 0) {
                iz();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.mZ.setTitle(this.mTitle);
                    this.mZ.setSubtitle(this.ym);
                } else {
                    this.mZ.setTitle((CharSequence) null);
                    this.mZ.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.mCustomView != null) {
                if ((i & 16) != 0) {
                    this.mZ.addView(this.mCustomView);
                } else {
                    this.mZ.removeView(this.mCustomView);
                }
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.Ya != null && this.Ya.getParent() == this.mZ) {
            this.mZ.removeView(this.Ya);
        }
        this.Ya = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.Yh == 2) {
            this.mZ.addView(this.Ya, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.Ya.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        return this.Ya != null;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.mZ.isTitleTruncated();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.mZ.setCollapsible(z);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getNavigationMode() {
        return this.Yh;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationMode(int i) {
        int i2 = this.Yh;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.Yb != null && this.Yb.getParent() == this.mZ) {
                        this.mZ.removeView(this.Yb);
                        break;
                    }
                    break;
                case 2:
                    if (this.Ya != null && this.Ya.getParent() == this.mZ) {
                        this.mZ.removeView(this.Ya);
                        break;
                    }
                    break;
            }
            this.Yh = i;
            switch (i) {
                case 0:
                    return;
                case 1:
                    iA();
                    this.mZ.addView(this.Yb, 0);
                    return;
                case 2:
                    if (this.Ya != null) {
                        this.mZ.addView(this.Ya, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.Ya.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388691;
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    private void iA() {
        if (this.Yb == null) {
            this.Yb = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.Yb.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        iA();
        this.Yb.setAdapter(spinnerAdapter);
        this.Yb.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i) {
        if (this.Yb == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.Yb.setSelection(i);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        if (this.Yb != null) {
            return this.Yb.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getDropdownItemCount() {
        if (this.Yb != null) {
            return this.Yb.getCount();
        }
        return 0;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setCustomView(View view) {
        if (this.mCustomView != null && (this.XZ & 16) != 0) {
            this.mZ.removeView(this.mCustomView);
        }
        this.mCustomView = view;
        if (view != null && (this.XZ & 16) != 0) {
            this.mZ.addView(this.mCustomView);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200L);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        return ViewCompat.animate(this.mZ).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.v7.widget.ToolbarWidgetWrapper.2
            private boolean mCanceled = false;

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mZ.setVisibility(0);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mZ.setVisibility(i);
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }
        });
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.Yd = drawable;
        iB();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.Yj != drawable) {
            this.Yj = drawable;
            iB();
        }
    }

    private void iB() {
        if ((this.XZ & 4) != 0) {
            this.mZ.setNavigationIcon(this.Yd != null ? this.Yd : this.Yj);
        } else {
            this.mZ.setNavigationIcon((Drawable) null);
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.Yf = charSequence;
        iC();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : getContext().getString(i));
    }

    private void iC() {
        if ((this.XZ & 4) != 0) {
            if (TextUtils.isEmpty(this.Yf)) {
                this.mZ.setNavigationContentDescription(this.Yi);
            } else {
                this.mZ.setNavigationContentDescription(this.Yf);
            }
        }
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mZ.saveHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mZ.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.mZ, drawable);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getHeight() {
        return this.mZ.getHeight();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setVisibility(int i) {
        this.mZ.setVisibility(i);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public int getVisibility() {
        return this.mZ.getVisibility();
    }

    @Override // android.support.v7.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mZ.setMenuCallbacks(callback, callback2);
    }

    @Override // android.support.v7.widget.DecorToolbar
    public Menu getMenu() {
        return this.mZ.getMenu();
    }
}
