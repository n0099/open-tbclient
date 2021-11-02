package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.legacy.app.ActionBarDrawerToggle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AFFECTS_LOGO_MASK = 3;
    public static final long DEFAULT_FADE_DURATION_MS = 200;
    public static final String TAG = "ToolbarWidgetWrapper";
    public transient /* synthetic */ FieldHolder $fh;
    public ActionMenuPresenter mActionMenuPresenter;
    public View mCustomView;
    public int mDefaultNavigationContentDescription;
    public Drawable mDefaultNavigationIcon;
    public int mDisplayOpts;
    public CharSequence mHomeDescription;
    public Drawable mIcon;
    public Drawable mLogo;
    public boolean mMenuPrepared;
    public Drawable mNavIcon;
    public int mNavigationMode;
    public Spinner mSpinner;
    public CharSequence mSubtitle;
    public View mTabView;
    public CharSequence mTitle;
    public boolean mTitleSet;
    public Toolbar mToolbar;
    public Window.Callback mWindowCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toolbar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Toolbar) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int detectDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mToolbar.getNavigationIcon() != null) {
                this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
                return 15;
            }
            return 11;
        }
        return invokeV.intValue;
    }

    private void ensureSpinner() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, charSequence) == null) {
            this.mTitle = charSequence;
            if ((this.mDisplayOpts & 8) != 0) {
                this.mToolbar.setTitle(charSequence);
            }
        }
    }

    private void updateHomeAccessibility() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    private void updateNavigationIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if ((this.mDisplayOpts & 4) != 0) {
                Toolbar toolbar = this.mToolbar;
                Drawable drawable = this.mNavIcon;
                if (drawable == null) {
                    drawable = this.mDefaultNavigationIcon;
                }
                toolbar.setNavigationIcon(drawable);
                return;
            }
            this.mToolbar.setNavigationIcon((Drawable) null);
        }
    }

    private void updateToolbarLogo() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int i2 = this.mDisplayOpts;
            if ((i2 & 2) == 0) {
                drawable = null;
            } else if ((i2 & 1) != 0) {
                drawable = this.mLogo;
                if (drawable == null) {
                    drawable = this.mIcon;
                }
            } else {
                drawable = this.mIcon;
            }
            this.mToolbar.setLogo(drawable);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int i2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (viewPropertyAnimatorCompat = setupAnimatorToVisibility(i2, 200L)) == null) {
            return;
        }
        viewPropertyAnimatorCompat.start();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mToolbar.canShowOverflowMenu() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mToolbar.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mToolbar.dismissPopupMenus();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mToolbar.getContext() : (Context) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCustomView : (View) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDisplayOpts : invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                return spinner.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                return spinner.getSelectedItemPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mToolbar.getHeight() : invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mToolbar.getMenu() : (Menu) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mNavigationMode : invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mToolbar.getSubtitle() : (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mToolbar.getTitle() : (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mToolbar : (ViewGroup) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mToolbar.getVisibility() : invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTabView != null : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mToolbar.hasExpandedActionView() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mIcon != null : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mLogo != null : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mToolbar.hideOverflowMenu() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mToolbar.isOverflowMenuShowPending() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mToolbar.isOverflowMenuShowing() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mToolbar.isTitleTruncated() : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, sparseArray) == null) {
            this.mToolbar.restoreHierarchyState(sparseArray);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) {
            this.mToolbar.saveHierarchyState(sparseArray);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            ViewCompat.setBackground(this.mToolbar, drawable);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mToolbar.setCollapsible(z);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            View view2 = this.mCustomView;
            if (view2 != null && (this.mDisplayOpts & 16) != 0) {
                this.mToolbar.removeView(view2);
            }
            this.mCustomView = view;
            if (view == null || (this.mDisplayOpts & 16) == 0) {
                return;
            }
            this.mToolbar.addView(view);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || i2 == this.mDefaultNavigationContentDescription) {
            return;
        }
        this.mDefaultNavigationContentDescription = i2;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
            setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) || this.mDefaultNavigationIcon == drawable) {
            return;
        }
        this.mDefaultNavigationIcon = drawable;
        updateNavigationIcon();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            int i3 = this.mDisplayOpts ^ i2;
            this.mDisplayOpts = i2;
            if (i3 != 0) {
                if ((i3 & 4) != 0) {
                    if ((i2 & 4) != 0) {
                        updateHomeAccessibility();
                    }
                    updateNavigationIcon();
                }
                if ((i3 & 3) != 0) {
                    updateToolbarLogo();
                }
                if ((i3 & 8) != 0) {
                    if ((i2 & 8) != 0) {
                        this.mToolbar.setTitle(this.mTitle);
                        this.mToolbar.setSubtitle(this.mSubtitle);
                    } else {
                        this.mToolbar.setTitle((CharSequence) null);
                        this.mToolbar.setSubtitle((CharSequence) null);
                    }
                }
                if ((i3 & 16) == 0 || (view = this.mCustomView) == null) {
                    return;
                }
                if ((i2 & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, spinnerAdapter, onItemSelectedListener) == null) {
            ensureSpinner();
            this.mSpinner.setAdapter(spinnerAdapter);
            this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                spinner.setSelection(i2);
                return;
            }
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, scrollingTabContainerView) == null) {
            View view = this.mTabView;
            if (view != null) {
                ViewParent parent = view.getParent();
                Toolbar toolbar = this.mToolbar;
                if (parent == toolbar) {
                    toolbar.removeView(this.mTabView);
                }
            }
            this.mTabView = scrollingTabContainerView;
            if (scrollingTabContainerView == null || this.mNavigationMode != 2) {
                return;
            }
            this.mToolbar.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            setLogo(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, menu, callback) == null) {
            if (this.mActionMenuPresenter == null) {
                ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
                this.mActionMenuPresenter = actionMenuPresenter;
                actionMenuPresenter.setId(R.id.action_menu_presenter);
            }
            this.mActionMenuPresenter.setCallback(callback);
            this.mToolbar.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, callback, callback2) == null) {
            this.mToolbar.setMenuCallbacks(callback, callback2);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.mMenuPrepared = true;
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, charSequence) == null) {
            this.mHomeDescription = charSequence;
            updateHomeAccessibility();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, drawable) == null) {
            this.mNavIcon = drawable;
            updateNavigationIcon();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int i2) {
        int i3;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || i2 == (i3 = this.mNavigationMode)) {
            return;
        }
        if (i3 == 1) {
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                ViewParent parent = spinner.getParent();
                Toolbar toolbar = this.mToolbar;
                if (parent == toolbar) {
                    toolbar.removeView(this.mSpinner);
                }
            }
        } else if (i3 == 2 && (view = this.mTabView) != null) {
            ViewParent parent2 = view.getParent();
            Toolbar toolbar2 = this.mToolbar;
            if (parent2 == toolbar2) {
                toolbar2.removeView(this.mTabView);
            }
        }
        this.mNavigationMode = i2;
        if (i2 != 0) {
            if (i2 == 1) {
                ensureSpinner();
                this.mToolbar.addView(this.mSpinner, 0);
            } else if (i2 == 2) {
                View view2 = this.mTabView;
                if (view2 != null) {
                    this.mToolbar.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                    layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i2);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, charSequence) == null) {
            this.mSubtitle = charSequence;
            if ((this.mDisplayOpts & 8) != 0) {
                this.mToolbar.setSubtitle(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, charSequence) == null) {
            this.mTitleSet = true;
            setTitleInt(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.mToolbar.setVisibility(i2);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, callback) == null) {
            this.mWindowCallback = callback;
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, charSequence) == null) || this.mTitleSet) {
            return;
        }
        setTitleInt(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return ViewCompat.animate(this.mToolbar).alpha(i2 == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter(this, i2) { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean mCanceled;
                public final /* synthetic */ ToolbarWidgetWrapper this$0;
                public final /* synthetic */ int val$visibility;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$visibility = i2;
                    this.mCanceled = false;
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.mCanceled = true;
                    }
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.mCanceled) {
                        return;
                    }
                    this.this$0.mToolbar.setVisibility(this.val$visibility);
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                        this.this$0.mToolbar.setVisibility(0);
                    }
                }
            });
        }
        return (ViewPropertyAnimatorCompat) invokeCommon.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mToolbar.showOverflowMenu() : invokeV.booleanValue;
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toolbar, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, (ViewGroup) this.mToolbar, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.mToolbar;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i2);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ActionMenuItem mNavItem;
            public final /* synthetic */ ToolbarWidgetWrapper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, ActionBarDrawerToggle.ID_HOME, 0, 0, this.this$0.mTitle);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper;
                Window.Callback callback;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && (callback = (toolbarWidgetWrapper = this.this$0).mWindowCallback) != null && toolbarWidgetWrapper.mMenuPrepared) {
                    callback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) {
            this.mIcon = drawable;
            updateToolbarLogo();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, drawable) == null) {
            this.mLogo = drawable;
            updateToolbarLogo();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            setNavigationContentDescription(i2 == 0 ? null : getContext().getString(i2));
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            setNavigationIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        }
    }
}
