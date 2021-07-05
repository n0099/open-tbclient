package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Delegate mActivityImpl;
    public final int mCloseDrawerContentDescRes;
    public boolean mDrawerIndicatorEnabled;
    public final DrawerLayout mDrawerLayout;
    public boolean mDrawerSlideAnimationEnabled;
    public boolean mHasCustomUpIndicator;
    public Drawable mHomeAsUpIndicator;
    public final int mOpenDrawerContentDescRes;
    public DrawerArrowDrawable mSlider;
    public View.OnClickListener mToolbarNavigationClickListener;
    public boolean mWarnedForDisplayHomeAsUp;

    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i2);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i2);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* loaded from: classes.dex */
    public static class FrameworkActionBarDelegate implements Delegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Activity mActivity;
        public ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        public FrameworkActionBarDelegate(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActivity = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                android.app.ActionBar actionBar = this.mActivity.getActionBar();
                if (actionBar != null) {
                    return actionBar.getThemedContext();
                }
                return this.mActivity;
            }
            return (Context) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
                    Drawable drawable = obtainStyledAttributes.getDrawable(0);
                    obtainStyledAttributes.recycle();
                    return drawable;
                }
                return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                android.app.ActionBar actionBar = this.mActivity.getActionBar();
                return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    android.app.ActionBar actionBar = this.mActivity.getActionBar();
                    if (actionBar != null) {
                        actionBar.setHomeActionContentDescription(i2);
                        return;
                    }
                    return;
                }
                this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, i2);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i2) {
            android.app.ActionBar actionBar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048580, this, drawable, i2) == null) || (actionBar = this.mActivity.getActionBar()) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
                return;
            }
            actionBar.setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mActivity, drawable, i2);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    /* loaded from: classes.dex */
    public static class ToolbarCompatDelegate implements Delegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CharSequence mDefaultContentDescription;
        public final Drawable mDefaultUpIndicator;
        public final Toolbar mToolbar;

        public ToolbarCompatDelegate(Toolbar toolbar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mToolbar = toolbar;
            this.mDefaultUpIndicator = toolbar.getNavigationIcon();
            this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mToolbar.getContext() : (Context) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDefaultUpIndicator : (Drawable) invokeV.objValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@StringRes int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                if (i2 == 0) {
                    this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
                } else {
                    this.mToolbar.setNavigationContentDescription(i2);
                }
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, drawable, i2) == null) {
                this.mToolbar.setNavigationIcon(drawable);
                setActionBarDescription(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i2, @StringRes int i3) {
        this(activity, null, drawerLayout, null, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, drawerLayout, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Toolbar) objArr2[1], (DrawerLayout) objArr2[2], (DrawerArrowDrawable) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            if (f2 == 1.0f) {
                this.mSlider.setVerticalMirror(true);
            } else if (f2 == 0.0f) {
                this.mSlider.setVerticalMirror(false);
            }
            this.mSlider.setProgress(f2);
        }
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSlider : (DrawerArrowDrawable) invokeV.objValue;
    }

    public Drawable getThemeUpIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActivityImpl.getThemeUpIndicator() : (Drawable) invokeV.objValue;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mToolbarNavigationClickListener : (View.OnClickListener) invokeV.objValue;
    }

    public boolean isDrawerIndicatorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDrawerIndicatorEnabled : invokeV.booleanValue;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDrawerSlideAnimationEnabled : invokeV.booleanValue;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            if (!this.mHasCustomUpIndicator) {
                this.mHomeAsUpIndicator = getThemeUpIndicator();
            }
            syncState();
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            setPosition(0.0f);
            if (this.mDrawerIndicatorEnabled) {
                setActionBarDescription(this.mOpenDrawerContentDescRes);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            setPosition(1.0f);
            if (this.mDrawerIndicatorEnabled) {
                setActionBarDescription(this.mCloseDrawerContentDescRes);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, f2) == null) {
            if (this.mDrawerSlideAnimationEnabled) {
                setPosition(Math.min(1.0f, Math.max(0.0f, f2)));
            } else {
                setPosition(0.0f);
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, menuItem)) == null) {
            if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
                toggle();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setActionBarDescription(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mActivityImpl.setActionBarDescription(i2);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, drawable, i2) == null) {
            if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
                Log.w(androidx.legacy.app.ActionBarDrawerToggle.TAG, "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
                this.mWarnedForDisplayHomeAsUp = true;
            }
            this.mActivityImpl.setActionBarUpIndicator(drawable, i2);
        }
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawerArrowDrawable) == null) {
            this.mSlider = drawerArrowDrawable;
            syncState();
        }
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || z == this.mDrawerIndicatorEnabled) {
            return;
        }
        if (z) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        } else {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
        this.mDrawerIndicatorEnabled = z;
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mDrawerSlideAnimationEnabled = z;
            if (z) {
                return;
            }
            setPosition(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            if (drawable == null) {
                this.mHomeAsUpIndicator = getThemeUpIndicator();
                this.mHasCustomUpIndicator = false;
            } else {
                this.mHomeAsUpIndicator = drawable;
                this.mHasCustomUpIndicator = true;
            }
            if (this.mDrawerIndicatorEnabled) {
                return;
            }
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.mToolbarNavigationClickListener = onClickListener;
        }
    }

    public void syncState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                setPosition(1.0f);
            } else {
                setPosition(0.0f);
            }
            if (this.mDrawerIndicatorEnabled) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            }
        }
    }

    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int drawerLockMode = this.mDrawerLayout.getDrawerLockMode(GravityCompat.START);
            if (this.mDrawerLayout.isDrawerVisible(GravityCompat.START) && drawerLockMode != 2) {
                this.mDrawerLayout.closeDrawer(GravityCompat.START);
            } else if (drawerLockMode != 1) {
                this.mDrawerLayout.openDrawer(GravityCompat.START);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i2, @StringRes int i3) {
        this(activity, toolbar, drawerLayout, null, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, drawerLayout, toolbar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Toolbar) objArr2[1], (DrawerLayout) objArr2[2], (DrawerArrowDrawable) objArr2[3], ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, toolbar, drawerLayout, drawerArrowDrawable, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: androidx.appcompat.app.ActionBarDrawerToggle.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ActionBarDrawerToggle this$0;

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
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        ActionBarDrawerToggle actionBarDrawerToggle = this.this$0;
                        if (actionBarDrawerToggle.mDrawerIndicatorEnabled) {
                            actionBarDrawerToggle.toggle();
                            return;
                        }
                        View.OnClickListener onClickListener = actionBarDrawerToggle.mToolbarNavigationClickListener;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = new FrameworkActionBarDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        if (drawerArrowDrawable == null) {
            this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    public void setHomeAsUpIndicator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            setHomeAsUpIndicator(i2 != 0 ? this.mDrawerLayout.getResources().getDrawable(i2) : null);
        }
    }
}
