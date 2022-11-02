package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.tieba.R;
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

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.obfuscated_res_0x7f0f0039, R.drawable.obfuscated_res_0x7f080074);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toolbar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Toolbar) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        boolean z2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {toolbar, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        if (this.mTitle != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mTitleSet = z2;
        this.mNavIcon = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, androidx.appcompat.R.styleable.ActionBar, R.attr.obfuscated_res_0x7f04004f, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(15);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(27);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(20);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(17);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(10, 0));
            int resourceId = obtainStyledAttributes.getResourceId(9, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, (ViewGroup) this.mToolbar, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.mToolbar;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(22, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, ActionBarDrawerToggle.ID_HOME, 0, 0, this.this$0.mTitle);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ToolbarWidgetWrapper toolbarWidgetWrapper;
                Window.Callback callback;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && (callback = (toolbarWidgetWrapper = this.this$0).mWindowCallback) != null && toolbarWidgetWrapper.mMenuPrepared) {
                    callback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
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
            this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.obfuscated_res_0x7f040056);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void updateHomeAccessibility() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (this.mDisplayOpts & 4) != 0) {
            if (TextUtils.isEmpty(this.mHomeDescription)) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            } else {
                this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
            }
        }
    }

    private void updateNavigationIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
            int i = this.mDisplayOpts;
            if ((i & 2) != 0) {
                if ((i & 1) != 0) {
                    drawable = this.mLogo;
                    if (drawable == null) {
                        drawable = this.mIcon;
                    }
                } else {
                    drawable = this.mIcon;
                }
            } else {
                drawable = null;
            }
            this.mToolbar.setLogo(drawable);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mToolbar.canShowOverflowMenu();
        }
        return invokeV.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mToolbar.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCustomView;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mDisplayOpts;
        }
        return invokeV.intValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mToolbar.getHeight();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mToolbar.getMenu();
        }
        return (Menu) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mNavigationMode;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mToolbar.getSubtitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mToolbar.getTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mToolbar;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mToolbar.getVisibility();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mTabView != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mToolbar.hasExpandedActionView();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mIcon != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mLogo != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mToolbar.hideOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Log.i(TAG, "Progress display unsupported");
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Log.i(TAG, "Progress display unsupported");
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mToolbar.isOverflowMenuShowPending();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mToolbar.isOverflowMenuShowing();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mToolbar.isTitleTruncated();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.mMenuPrepared = true;
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mToolbar.showOverflowMenu();
        }
        return invokeV.booleanValue;
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

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200L)) != null) {
            viewPropertyAnimatorCompat.start();
        }
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
    public void setCustomView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            View view3 = this.mCustomView;
            if (view3 != null && (this.mDisplayOpts & 16) != 0) {
                this.mToolbar.removeView(view3);
            }
            this.mCustomView = view2;
            if (view2 != null && (this.mDisplayOpts & 16) != 0) {
                this.mToolbar.addView(view2);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048607, this, i) != null) || i == this.mDefaultNavigationContentDescription) {
            return;
        }
        this.mDefaultNavigationContentDescription = i;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
            setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) && this.mDefaultNavigationIcon != drawable) {
            this.mDefaultNavigationIcon = drawable;
            updateNavigationIcon();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            Spinner spinner = this.mSpinner;
            if (spinner != null) {
                spinner.setSelection(i);
                return;
            }
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            if (i != 0) {
                drawable = AppCompatResources.getDrawable(getContext(), i);
            } else {
                drawable = null;
            }
            setIcon(drawable);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            if (i != 0) {
                drawable = AppCompatResources.getDrawable(getContext(), i);
            } else {
                drawable = null;
            }
            setLogo(drawable);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i == 0) {
                string = null;
            } else {
                string = getContext().getString(i);
            }
            setNavigationContentDescription(string);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            if (i != 0) {
                drawable = AppCompatResources.getDrawable(getContext(), i);
            } else {
                drawable = null;
            }
            setNavigationIcon(drawable);
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
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.mToolbar.setVisibility(i);
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
        if ((interceptable == null || interceptable.invokeL(1048630, this, charSequence) == null) && !this.mTitleSet) {
            setTitleInt(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            int i2 = this.mDisplayOpts ^ i;
            this.mDisplayOpts = i;
            if (i2 != 0) {
                if ((i2 & 4) != 0) {
                    if ((i & 4) != 0) {
                        updateHomeAccessibility();
                    }
                    updateNavigationIcon();
                }
                if ((i2 & 3) != 0) {
                    updateToolbarLogo();
                }
                if ((i2 & 8) != 0) {
                    if ((i & 8) != 0) {
                        this.mToolbar.setTitle(this.mTitle);
                        this.mToolbar.setSubtitle(this.mSubtitle);
                    } else {
                        this.mToolbar.setTitle((CharSequence) null);
                        this.mToolbar.setSubtitle((CharSequence) null);
                    }
                }
                if ((i2 & 16) != 0 && (view2 = this.mCustomView) != null) {
                    if ((i & 16) != 0) {
                        this.mToolbar.addView(view2);
                    } else {
                        this.mToolbar.removeView(view2);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int i) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i) == null) && i != (i2 = this.mNavigationMode)) {
            if (i2 != 1) {
                if (i2 == 2 && (view2 = this.mTabView) != null) {
                    ViewParent parent = view2.getParent();
                    Toolbar toolbar = this.mToolbar;
                    if (parent == toolbar) {
                        toolbar.removeView(this.mTabView);
                    }
                }
            } else {
                Spinner spinner = this.mSpinner;
                if (spinner != null) {
                    ViewParent parent2 = spinner.getParent();
                    Toolbar toolbar2 = this.mToolbar;
                    if (parent2 == toolbar2) {
                        toolbar2.removeView(this.mSpinner);
                    }
                }
            }
            this.mNavigationMode = i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        View view3 = this.mTabView;
                        if (view3 != null) {
                            this.mToolbar.addView(view3, 0);
                            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
                }
                ensureSpinner();
                this.mToolbar.addView(this.mSpinner, 0);
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
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, callback, callback2) == null) {
            this.mToolbar.setMenuCallbacks(callback, callback2);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, scrollingTabContainerView) == null) {
            View view2 = this.mTabView;
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                Toolbar toolbar = this.mToolbar;
                if (parent == toolbar) {
                    toolbar.removeView(this.mTabView);
                }
            }
            this.mTabView = scrollingTabContainerView;
            if (scrollingTabContainerView != null && this.mNavigationMode == 2) {
                this.mToolbar.addView(scrollingTabContainerView, 0);
                Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
                scrollingTabContainerView.setAllowCollapse(true);
            }
        }
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
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, menu, callback) == null) {
            if (this.mActionMenuPresenter == null) {
                ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
                this.mActionMenuPresenter = actionMenuPresenter;
                actionMenuPresenter.setId(R.id.obfuscated_res_0x7f09006b);
            }
            this.mActionMenuPresenter.setCallback(callback);
            this.mToolbar.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        InterceptResult invokeCommon;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mToolbar);
            if (i == 0) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            return animate.alpha(f).setDuration(j).setListener(new ViewPropertyAnimatorListenerAdapter(this, i) { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2
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
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$visibility = i;
                    this.mCanceled = false;
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationCancel(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.mCanceled = true;
                    }
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && !this.mCanceled) {
                        this.this$0.mToolbar.setVisibility(this.val$visibility);
                    }
                }

                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                        this.this$0.mToolbar.setVisibility(0);
                    }
                }
            });
        }
        return (ViewPropertyAnimatorCompat) invokeCommon.objValue;
    }
}
