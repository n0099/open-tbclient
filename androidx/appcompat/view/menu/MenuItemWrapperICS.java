package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "MenuItemWrapper";
    public transient /* synthetic */ FieldHolder $fh;
    public Method mSetExclusiveCheckableMethod;
    public final SupportMenuItem mWrappedObject;

    /* loaded from: classes.dex */
    public class ActionProviderWrapper extends ActionProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final android.view.ActionProvider mInner;
        public final /* synthetic */ MenuItemWrapperICS this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuItemWrapperICS, context, actionProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = menuItemWrapperICS;
            this.mInner = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean hasSubMenu() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInner.hasSubMenu() : invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInner.onCreateActionView() : (View) invokeV.objValue;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mInner.onPerformDefaultAction() : invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subMenu) == null) {
                this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(subMenu));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes.dex */
    public class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionProvider.VisibilityListener mListener;
        public final /* synthetic */ MenuItemWrapperICS this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionProviderWrapperJB(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
            super(menuItemWrapperICS, context, actionProvider);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuItemWrapperICS, context, actionProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((MenuItemWrapperICS) objArr2[0], (Context) objArr2[1], (android.view.ActionProvider) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = menuItemWrapperICS;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean isVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInner.isVisible() : invokeV.booleanValue;
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (visibilityListener = this.mListener) == null) {
                return;
            }
            visibilityListener.onActionProviderVisibilityChanged(z);
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, menuItem)) == null) ? this.mInner.onCreateActionView(menuItem) : (View) invokeL.objValue;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mInner.overridesItemVisibility() : invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mInner.refreshVisibility();
            }
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, visibilityListener) == null) {
                this.mListener = visibilityListener;
                this.mInner.setVisibilityListener(visibilityListener != null ? this : null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final android.view.CollapsibleActionView mWrappedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWrappedView = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        public View getWrappedView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (View) this.mWrappedView : (View) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mWrappedView.onActionViewCollapsed();
            }
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mWrappedView.onActionViewExpanded();
            }
        }
    }

    /* loaded from: classes.dex */
    public class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MenuItem.OnActionExpandListener mObject;
        public final /* synthetic */ MenuItemWrapperICS this$0;

        public OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnActionExpandListener onActionExpandListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuItemWrapperICS, onActionExpandListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = menuItemWrapperICS;
            this.mObject = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) ? this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem)) : invokeL.booleanValue;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItem)) == null) ? this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem)) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MenuItem.OnMenuItemClickListener mObject;
        public final /* synthetic */ MenuItemWrapperICS this$0;

        public OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuItemWrapperICS, onMenuItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = menuItemWrapperICS;
            this.mObject = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) ? this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(menuItem)) : invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supportMenuItem};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (supportMenuItem != null) {
            this.mWrappedObject = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mWrappedObject.collapseActionView() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrappedObject.expandActionView() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            androidx.core.view.ActionProvider supportActionProvider = this.mWrappedObject.getSupportActionProvider();
            if (supportActionProvider instanceof ActionProviderWrapper) {
                return ((ActionProviderWrapper) supportActionProvider).mInner;
            }
            return null;
        }
        return (android.view.ActionProvider) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View actionView = this.mWrappedObject.getActionView();
            return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWrappedObject.getAlphabeticModifiers() : invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWrappedObject.getAlphabeticShortcut() : invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mWrappedObject.getContentDescription() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mWrappedObject.getGroupId() : invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWrappedObject.getIcon() : (Drawable) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mWrappedObject.getIconTintList() : (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mWrappedObject.getIconTintMode() : (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWrappedObject.getIntent() : (Intent) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mWrappedObject.getItemId() : invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mWrappedObject.getMenuInfo() : (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mWrappedObject.getNumericModifiers() : invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mWrappedObject.getNumericShortcut() : invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mWrappedObject.getOrder() : invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getSubMenuWrapper(this.mWrappedObject.getSubMenu()) : (SubMenu) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mWrappedObject.getTitle() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mWrappedObject.getTitleCondensed() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mWrappedObject.getTooltipText() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mWrappedObject.hasSubMenu() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mWrappedObject.isActionViewExpanded() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mWrappedObject.isCheckable() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mWrappedObject.isChecked() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mWrappedObject.isEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mWrappedObject.isVisible() : invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        InterceptResult invokeL;
        androidx.core.view.ActionProvider actionProviderWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, actionProvider)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                actionProviderWrapper = new ActionProviderWrapperJB(this, this.mContext, actionProvider);
            } else {
                actionProviderWrapper = new ActionProviderWrapper(this, this.mContext, actionProvider);
            }
            SupportMenuItem supportMenuItem = this.mWrappedObject;
            if (actionProvider == null) {
                actionProviderWrapper = null;
            }
            supportMenuItem.setSupportActionProvider(actionProviderWrapper);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view)) == null) {
            if (view instanceof android.view.CollapsibleActionView) {
                view = new CollapsibleActionViewWrapper(view);
            }
            this.mWrappedObject.setActionView(view);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.mWrappedObject.setAlphabeticShortcut(c2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            this.mWrappedObject.setCheckable(z);
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            this.mWrappedObject.setChecked(z);
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, charSequence)) == null) {
            this.mWrappedObject.setContentDescription(charSequence);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            this.mWrappedObject.setEnabled(z);
            return this;
        }
        return (MenuItem) invokeZ.objValue;
    }

    public void setExclusiveCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            try {
                if (this.mSetExclusiveCheckableMethod == null) {
                    this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                }
                this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e2);
            }
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, drawable)) == null) {
            this.mWrappedObject.setIcon(drawable);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, colorStateList)) == null) {
            this.mWrappedObject.setIconTintList(colorStateList);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, mode)) == null) {
            this.mWrappedObject.setIconTintMode(mode);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, intent)) == null) {
            this.mWrappedObject.setIntent(intent);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.mWrappedObject.setNumericShortcut(c2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, onActionExpandListener)) == null) {
            this.mWrappedObject.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(this, onActionExpandListener) : null);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, onMenuItemClickListener)) == null) {
            this.mWrappedObject.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(this, onMenuItemClickListener) : null);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            this.mWrappedObject.setShortcut(c2, c3);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.mWrappedObject.setShowAsAction(i);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            this.mWrappedObject.setShowAsActionFlags(i);
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, charSequence)) == null) {
            this.mWrappedObject.setTitle(charSequence);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, charSequence)) == null) {
            this.mWrappedObject.setTitleCondensed(charSequence);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, charSequence)) == null) {
            this.mWrappedObject.setTooltipText(charSequence);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) ? this.mWrappedObject.setVisible(z) : (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i)})) == null) {
            this.mWrappedObject.setAlphabeticShortcut(c2, i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            this.mWrappedObject.setIcon(i);
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i)})) == null) {
            this.mWrappedObject.setNumericShortcut(c2, i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.mWrappedObject.setShortcut(c2, c3, i, i2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            this.mWrappedObject.setTitle(i);
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            this.mWrappedObject.setActionView(i);
            View actionView = this.mWrappedObject.getActionView();
            if (actionView instanceof android.view.CollapsibleActionView) {
                this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(actionView));
            }
            return this;
        }
        return (MenuItem) invokeI.objValue;
    }
}
