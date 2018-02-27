package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Toolbar extends ViewGroup {
    private boolean JK;
    private boolean JL;
    private int Lg;
    private MenuPresenter.Callback Li;
    private MenuBuilder.Callback Lj;
    private CharSequence XA;
    private CharSequence XB;
    private int XC;
    private int XD;
    private final ArrayList<View> XE;
    private final ArrayList<View> XF;
    private final int[] XG;
    OnMenuItemClickListener XH;
    private final ActionMenuView.OnMenuItemClickListener XI;
    private ToolbarWidgetWrapper XJ;
    private ActionMenuPresenter XK;
    private a XL;
    private final Runnable XM;
    private TextView Xh;
    private TextView Xi;
    private ImageButton Xj;
    private ImageView Xk;
    private Drawable Xl;
    private CharSequence Xm;
    ImageButton Xn;
    View Xo;
    private int Xp;
    private int Xq;
    int Xr;
    private int Xs;
    private int Xt;
    private int Xu;
    private int Xv;
    private int Xw;
    private p Xx;
    private int Xy;
    private int Xz;
    private boolean kL;
    private int mGravity;
    private ActionMenuView mMenuView;
    private Context mPopupContext;

    /* loaded from: classes2.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.XE = new ArrayList<>();
        this.XF = new ArrayList<>();
        this.XG = new int[2];
        this.XI = new ActionMenuView.OnMenuItemClickListener() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.XH != null) {
                    return Toolbar.this.XH.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.XM = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.Xp = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.Xq = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.Xr = obtainStyledAttributes.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        dimensionPixelOffset = obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleMargins) ? obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.Xw = dimensionPixelOffset;
        this.Xv = dimensionPixelOffset;
        this.Xu = dimensionPixelOffset;
        this.Xt = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.Xt = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.Xu = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.Xv = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.Xw = dimensionPixelOffset5;
        }
        this.Xs = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ix();
        this.Xx.ad(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.Xx.ac(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.Xy = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.Xz = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.Xl = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.Xm = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
    }

    public void setPopupTheme(int i) {
        if (this.Lg != i) {
            this.Lg = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.Lg;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.Xt = i;
        this.Xv = i2;
        this.Xu = i3;
        this.Xw = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.Xt;
    }

    public void setTitleMarginStart(int i) {
        this.Xt = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.Xv;
    }

    public void setTitleMarginTop(int i) {
        this.Xv = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.Xu;
    }

    public void setTitleMarginEnd(int i) {
        this.Xu = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.Xw;
    }

    public void setTitleMarginBottom(int i) {
        this.Xw = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ix();
        this.Xx.K(i == 1);
    }

    public void setLogo(int i) {
        setLogo(AppCompatResources.getDrawable(getContext(), i));
    }

    @RestrictTo
    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    @RestrictTo
    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    @RestrictTo
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ir();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.XK);
                    peekMenu.removeMenuPresenter(this.XL);
                }
                if (this.XL == null) {
                    this.XL = new a();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.XL, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, null);
                    this.XL.initForMenu(this.mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.XL.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.Lg);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.XK = actionMenuPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    @RestrictTo
    public boolean isTitleTruncated() {
        Layout layout;
        if (this.Xh == null || (layout = this.Xh.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ip();
            if (!aE(this.Xk)) {
                h(this.Xk, true);
            }
        } else if (this.Xk != null && aE(this.Xk)) {
            removeView(this.Xk);
            this.XF.remove(this.Xk);
        }
        if (this.Xk != null) {
            this.Xk.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.Xk != null) {
            return this.Xk.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ip();
        }
        if (this.Xk != null) {
            this.Xk.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.Xk != null) {
            return this.Xk.getContentDescription();
        }
        return null;
    }

    private void ip() {
        if (this.Xk == null) {
            this.Xk = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.XL == null || this.XL.XO == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.XL == null ? null : this.XL.XO;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.XA;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Xh == null) {
                Context context = getContext();
                this.Xh = new AppCompatTextView(context);
                this.Xh.setSingleLine();
                this.Xh.setEllipsize(TextUtils.TruncateAt.END);
                if (this.Xp != 0) {
                    this.Xh.setTextAppearance(context, this.Xp);
                }
                if (this.XC != 0) {
                    this.Xh.setTextColor(this.XC);
                }
            }
            if (!aE(this.Xh)) {
                h(this.Xh, true);
            }
        } else if (this.Xh != null && aE(this.Xh)) {
            removeView(this.Xh);
            this.XF.remove(this.Xh);
        }
        if (this.Xh != null) {
            this.Xh.setText(charSequence);
        }
        this.XA = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.XB;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Xi == null) {
                Context context = getContext();
                this.Xi = new AppCompatTextView(context);
                this.Xi.setSingleLine();
                this.Xi.setEllipsize(TextUtils.TruncateAt.END);
                if (this.Xq != 0) {
                    this.Xi.setTextAppearance(context, this.Xq);
                }
                if (this.XD != 0) {
                    this.Xi.setTextColor(this.XD);
                }
            }
            if (!aE(this.Xi)) {
                h(this.Xi, true);
            }
        } else if (this.Xi != null && aE(this.Xi)) {
            removeView(this.Xi);
            this.XF.remove(this.Xi);
        }
        if (this.Xi != null) {
            this.Xi.setText(charSequence);
        }
        this.XB = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.Xp = i;
        if (this.Xh != null) {
            this.Xh.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.Xq = i;
        if (this.Xi != null) {
            this.Xi.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.XC = i;
        if (this.Xh != null) {
            this.Xh.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.XD = i;
        if (this.Xi != null) {
            this.Xi.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.Xj != null) {
            return this.Xj.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            is();
        }
        if (this.Xj != null) {
            this.Xj.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            is();
            if (!aE(this.Xj)) {
                h(this.Xj, true);
            }
        } else if (this.Xj != null && aE(this.Xj)) {
            removeView(this.Xj);
            this.XF.remove(this.Xj);
        }
        if (this.Xj != null) {
            this.Xj.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.Xj != null) {
            return this.Xj.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        is();
        this.Xj.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        iq();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        iq();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        iq();
        return this.mMenuView.getOverflowIcon();
    }

    private void iq() {
        ir();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.XL == null) {
                this.XL = new a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.XL, this.mPopupContext);
        }
    }

    private void ir() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.Lg);
            this.mMenuView.setOnMenuItemClickListener(this.XI);
            this.mMenuView.setMenuCallbacks(this.Li, this.Lj);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.Xr & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            h(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.XH = onMenuItemClickListener;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ix();
        this.Xx.ac(i, i2);
    }

    public int getContentInsetStart() {
        if (this.Xx != null) {
            return this.Xx.getStart();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        if (this.Xx != null) {
            return this.Xx.getEnd();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ix();
        this.Xx.ad(i, i2);
    }

    public int getContentInsetLeft() {
        if (this.Xx != null) {
            return this.Xx.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.Xx != null) {
            return this.Xx.getRight();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.Xy != Integer.MIN_VALUE ? this.Xy : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.Xy) {
            this.Xy = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        return this.Xz != Integer.MIN_VALUE ? this.Xz : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.Xz) {
            this.Xz = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.Xy, 0)) : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z;
        if (this.mMenuView != null) {
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            z = peekMenu != null && peekMenu.hasVisibleItems();
        } else {
            z = false;
        }
        if (z) {
            return Math.max(getContentInsetEnd(), Math.max(this.Xz, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return ViewCompat.getLayoutDirection(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return ViewCompat.getLayoutDirection(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    private void is() {
        if (this.Xj == null) {
            this.Xj = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.Xr & 112);
            this.Xj.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    void it() {
        if (this.Xn == null) {
            this.Xn = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.Xn.setImageDrawable(this.Xl);
            this.Xn.setContentDescription(this.Xm);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.Xr & 112);
            generateDefaultLayoutParams.XP = 2;
            this.Xn.setLayoutParams(generateDefaultLayoutParams);
            this.Xn.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void h(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.XP = 1;
        if (z && this.Xo != null) {
            view.setLayoutParams(layoutParams);
            this.XF.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.XL != null && this.XL.XO != null) {
            savedState.XQ = this.XL.XO.getItemId();
        }
        savedState.XR = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        MenuBuilder peekMenu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
        if (savedState.XQ != 0 && this.XL != null && peekMenu != null && (findItem = peekMenu.findItem(savedState.XQ)) != null) {
            MenuItemCompat.expandActionView(findItem);
        }
        if (savedState.XR) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.XM);
        post(this.XM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.XM);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.JK = false;
        }
        if (!this.JK) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.JK = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.JK = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.JL = false;
        }
        if (!this.JL) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.JL = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.JL = false;
        }
        return true;
    }

    private void b(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean iu() {
        if (this.kL) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (aB(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.XG;
        if (ViewUtils.isLayoutRtl(this)) {
            c = 0;
            c2 = 1;
        } else {
            c = 1;
            c2 = 0;
        }
        int i7 = 0;
        if (aB(this.Xj)) {
            b(this.Xj, i, 0, i2, 0, this.Xs);
            i7 = this.Xj.getMeasuredWidth() + aC(this.Xj);
            int max = Math.max(0, this.Xj.getMeasuredHeight() + aD(this.Xj));
            i6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.Xj));
            i5 = max;
        }
        if (aB(this.Xn)) {
            b(this.Xn, i, 0, i2, 0, this.Xs);
            i7 = this.Xn.getMeasuredWidth() + aC(this.Xn);
            i5 = Math.max(i5, this.Xn.getMeasuredHeight() + aD(this.Xn));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.Xn));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[c2] = Math.max(0, currentContentInsetStart - i7);
        int i8 = 0;
        if (aB(this.mMenuView)) {
            b(this.mMenuView, i, max2, i2, 0, this.Xs);
            i8 = this.mMenuView.getMeasuredWidth() + aC(this.mMenuView);
            i5 = Math.max(i5, this.mMenuView.getMeasuredHeight() + aD(this.mMenuView));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.mMenuView));
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max2 + Math.max(currentContentInsetEnd, i8);
        iArr[c] = Math.max(0, currentContentInsetEnd - i8);
        if (aB(this.Xo)) {
            max3 += a(this.Xo, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.Xo.getMeasuredHeight() + aD(this.Xo));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.Xo));
        }
        if (aB(this.Xk)) {
            max3 += a(this.Xk, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.Xk.getMeasuredHeight() + aD(this.Xk));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.Xk));
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i5;
        int i11 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((LayoutParams) childAt.getLayoutParams()).XP != 0) {
                i3 = i11;
                i4 = i10;
            } else if (aB(childAt)) {
                max3 += a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i10, childAt.getMeasuredHeight() + aD(childAt));
                i3 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(childAt));
                i4 = max4;
            } else {
                i3 = i11;
                i4 = i10;
            }
            i9++;
            i11 = i3;
            i10 = i4;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = this.Xv + this.Xw;
        int i15 = this.Xt + this.Xu;
        if (aB(this.Xh)) {
            a(this.Xh, i, max3 + i15, i2, i14, iArr);
            i12 = aC(this.Xh) + this.Xh.getMeasuredWidth();
            i13 = this.Xh.getMeasuredHeight() + aD(this.Xh);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.Xh));
        }
        if (aB(this.Xi)) {
            i12 = Math.max(i12, a(this.Xi, i, max3 + i15, i2, i14 + i13, iArr));
            i13 += this.Xi.getMeasuredHeight() + aD(this.Xi);
            i11 = ViewUtils.combineMeasuredStates(i11, ViewCompat.getMeasuredState(this.Xi));
        }
        int max5 = Math.max(i10, i13);
        int paddingLeft = i12 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i11);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i11 << 16);
        if (iu()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int max;
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i16 = width - paddingRight;
        int[] iArr = this.XG;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (!aB(this.Xj)) {
            i5 = i16;
            i6 = paddingLeft;
        } else if (z2) {
            i5 = b(this.Xj, i16, iArr, min);
            i6 = paddingLeft;
        } else {
            i6 = a(this.Xj, paddingLeft, iArr, min);
            i5 = i16;
        }
        if (aB(this.Xn)) {
            if (z2) {
                i5 = b(this.Xn, i5, iArr, min);
            } else {
                i6 = a(this.Xn, i6, iArr, min);
            }
        }
        if (aB(this.mMenuView)) {
            if (z2) {
                i6 = a(this.mMenuView, i6, iArr, min);
            } else {
                i5 = b(this.mMenuView, i5, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i6);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - i5));
        int max2 = Math.max(i6, currentContentInsetLeft);
        int min2 = Math.min(i5, (width - paddingRight) - currentContentInsetRight);
        if (aB(this.Xo)) {
            if (z2) {
                min2 = b(this.Xo, min2, iArr, min);
            } else {
                max2 = a(this.Xo, max2, iArr, min);
            }
        }
        if (!aB(this.Xk)) {
            i7 = min2;
            i8 = max2;
        } else if (z2) {
            i7 = b(this.Xk, min2, iArr, min);
            i8 = max2;
        } else {
            i7 = min2;
            i8 = a(this.Xk, max2, iArr, min);
        }
        boolean aB = aB(this.Xh);
        boolean aB2 = aB(this.Xi);
        int i17 = 0;
        if (aB) {
            LayoutParams layoutParams = (LayoutParams) this.Xh.getLayoutParams();
            i17 = 0 + layoutParams.bottomMargin + layoutParams.topMargin + this.Xh.getMeasuredHeight();
        }
        if (aB2) {
            LayoutParams layoutParams2 = (LayoutParams) this.Xi.getLayoutParams();
            i9 = layoutParams2.bottomMargin + layoutParams2.topMargin + this.Xi.getMeasuredHeight() + i17;
        } else {
            i9 = i17;
        }
        if (aB || aB2) {
            TextView textView = aB ? this.Xh : this.Xi;
            TextView textView2 = aB2 ? this.Xi : this.Xh;
            LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
            boolean z3 = (aB && this.Xh.getMeasuredWidth() > 0) || (aB2 && this.Xi.getMeasuredWidth() > 0);
            switch (this.mGravity & 112) {
                case 48:
                    i10 = layoutParams3.topMargin + getPaddingTop() + this.Xv;
                    break;
                case 80:
                    i10 = (((height - paddingBottom) - layoutParams4.bottomMargin) - this.Xw) - i9;
                    break;
                default:
                    int i18 = (((height - paddingTop) - paddingBottom) - i9) / 2;
                    if (i18 < layoutParams3.topMargin + this.Xv) {
                        max = layoutParams3.topMargin + this.Xv;
                    } else {
                        int i19 = (((height - paddingBottom) - i9) - i18) - paddingTop;
                        max = i19 < layoutParams3.bottomMargin + this.Xw ? Math.max(0, i18 - ((layoutParams4.bottomMargin + this.Xw) - i19)) : i18;
                    }
                    i10 = paddingTop + max;
                    break;
            }
            if (z2) {
                int i20 = (z3 ? this.Xt : 0) - iArr[1];
                int max3 = i7 - Math.max(0, i20);
                iArr[1] = Math.max(0, -i20);
                if (aB) {
                    int measuredWidth = max3 - this.Xh.getMeasuredWidth();
                    int measuredHeight = this.Xh.getMeasuredHeight() + i10;
                    this.Xh.layout(measuredWidth, i10, max3, measuredHeight);
                    int i21 = measuredWidth - this.Xu;
                    i10 = measuredHeight + ((LayoutParams) this.Xh.getLayoutParams()).bottomMargin;
                    i14 = i21;
                } else {
                    i14 = max3;
                }
                if (aB2) {
                    LayoutParams layoutParams5 = (LayoutParams) this.Xi.getLayoutParams();
                    int i22 = layoutParams5.topMargin + i10;
                    int measuredHeight2 = this.Xi.getMeasuredHeight() + i22;
                    this.Xi.layout(max3 - this.Xi.getMeasuredWidth(), i22, max3, measuredHeight2);
                    int i23 = layoutParams5.bottomMargin + measuredHeight2;
                    i15 = max3 - this.Xu;
                } else {
                    i15 = max3;
                }
                i7 = z3 ? Math.min(i14, i15) : max3;
            } else {
                int i24 = (z3 ? this.Xt : 0) - iArr[0];
                i8 += Math.max(0, i24);
                iArr[0] = Math.max(0, -i24);
                if (aB) {
                    int measuredWidth2 = this.Xh.getMeasuredWidth() + i8;
                    int measuredHeight3 = this.Xh.getMeasuredHeight() + i10;
                    this.Xh.layout(i8, i10, measuredWidth2, measuredHeight3);
                    int i25 = ((LayoutParams) this.Xh.getLayoutParams()).bottomMargin + measuredHeight3;
                    i11 = measuredWidth2 + this.Xu;
                    i12 = i25;
                } else {
                    i11 = i8;
                    i12 = i10;
                }
                if (aB2) {
                    LayoutParams layoutParams6 = (LayoutParams) this.Xi.getLayoutParams();
                    int i26 = i12 + layoutParams6.topMargin;
                    int measuredWidth3 = this.Xi.getMeasuredWidth() + i8;
                    int measuredHeight4 = this.Xi.getMeasuredHeight() + i26;
                    this.Xi.layout(i8, i26, measuredWidth3, measuredHeight4);
                    int i27 = layoutParams6.bottomMargin + measuredHeight4;
                    i13 = this.Xu + measuredWidth3;
                } else {
                    i13 = i8;
                }
                if (z3) {
                    i8 = Math.max(i11, i13);
                }
            }
        }
        d(this.XE, 3);
        int size = this.XE.size();
        int i28 = i8;
        for (int i29 = 0; i29 < size; i29++) {
            i28 = a(this.XE.get(i29), i28, iArr, min);
        }
        d(this.XE, 5);
        int size2 = this.XE.size();
        for (int i30 = 0; i30 < size2; i30++) {
            i7 = b(this.XE.get(i30), i7, iArr, min);
        }
        d(this.XE, 1);
        int a2 = a(this.XE, iArr);
        int i31 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (a2 / 2);
        int i32 = a2 + i31;
        if (i31 < i28) {
            i31 = i28;
        } else if (i32 > i7) {
            i31 -= i32 - i7;
        }
        int size3 = this.XE.size();
        int i33 = i31;
        for (int i34 = 0; i34 < size3; i34++) {
            i33 = a(this.XE.get(i34), i33, iArr, min);
        }
        this.XE.clear();
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = layoutParams.leftMargin - i6;
            int i8 = layoutParams.rightMargin - i5;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            i6 = Math.max(0, -i7);
            i5 = Math.max(0, -i8);
            i3++;
            i4 += view.getMeasuredWidth() + max + max2;
        }
        return i4;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int k = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k, max + measuredWidth, view.getMeasuredHeight() + k);
        return layoutParams.rightMargin + measuredWidth + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int k = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k, max, view.getMeasuredHeight() + k);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int k(View view, int i) {
        int max;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (cf(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < layoutParams.topMargin) {
                    max = layoutParams.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    max = i4 < layoutParams.bottomMargin ? Math.max(0, i3 - (layoutParams.bottomMargin - i4)) : i3;
                }
                return max + paddingTop;
        }
    }

    private int cf(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.mGravity & 112;
        }
    }

    private void d(List<View> list, int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.XP == 0 && aB(childAt) && cg(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.XP == 0 && aB(childAt2) && cg(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private int cg(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            case 2:
            case 4:
            default:
                return layoutDirection == 1 ? 5 : 3;
        }
    }

    private boolean aB(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int aC(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    private int aD(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @RestrictTo
    public DecorToolbar getWrapper() {
        if (this.XJ == null) {
            this.XJ = new ToolbarWidgetWrapper(this, true);
        }
        return this.XJ;
    }

    void iv() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).XP != 2 && childAt != this.mMenuView) {
                removeViewAt(childCount);
                this.XF.add(childAt);
            }
        }
    }

    void iw() {
        for (int size = this.XF.size() - 1; size >= 0; size--) {
            addView(this.XF.get(size));
        }
        this.XF.clear();
    }

    private boolean aE(View view) {
        return view.getParent() == this || this.XF.contains(view);
    }

    @RestrictTo
    public void setCollapsible(boolean z) {
        this.kL = z;
        requestLayout();
    }

    @RestrictTo
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.Li = callback;
        this.Lj = callback2;
        if (this.mMenuView != null) {
            this.mMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    private void ix() {
        if (this.Xx == null) {
            this.Xx = new p();
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {
        int XP;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.XP = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.XP = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.XP = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.XP = 0;
            this.XP = layoutParams.XP;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.XP = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.XP = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.XP = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v7.widget.Toolbar.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: k */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: ch */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int XQ;
        boolean XR;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.XQ = parcel.readInt();
            this.XR = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XQ);
            parcel.writeInt(this.XR ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements MenuPresenter {
        MenuItemImpl XO;
        MenuBuilder mMenu;

        a() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (this.mMenu != null && this.XO != null) {
                this.mMenu.collapseItemActionView(this.XO);
            }
            this.mMenu = menuBuilder;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public void updateMenuView(boolean z) {
            boolean z2 = false;
            if (this.XO != null) {
                if (this.mMenu != null) {
                    int size = this.mMenu.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.mMenu.getItem(i) != this.XO) {
                            i++;
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.mMenu, this.XO);
                }
            }
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback callback) {
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.it();
            if (Toolbar.this.Xn.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.Xn);
            }
            Toolbar.this.Xo = menuItemImpl.getActionView();
            this.XO = menuItemImpl;
            if (Toolbar.this.Xo.getParent() != Toolbar.this) {
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = 8388611 | (Toolbar.this.Xr & 112);
                generateDefaultLayoutParams.XP = 2;
                Toolbar.this.Xo.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.Xo);
            }
            Toolbar.this.iv();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (Toolbar.this.Xo instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.Xo).onActionViewExpanded();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.Xo instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.Xo).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.Xo);
            Toolbar.this.removeView(Toolbar.this.Xn);
            Toolbar.this.Xo = null;
            Toolbar.this.iw();
            this.XO = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // android.support.v7.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
        }
    }
}
