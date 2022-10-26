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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mInner.hasSubMenu();
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mInner.onCreateActionView();
            }
            return (View) invokeV.objValue;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean onPerformDefaultAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mInner.onPerformDefaultAction();
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public void onPrepareSubMenu(SubMenu subMenu) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subMenu) == null) {
                this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(subMenu));
            }
        }
    }

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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mInner.isVisible();
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean overridesItemVisibility() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mInner.overridesItemVisibility();
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.view.ActionProvider
        public void refreshVisibility() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mInner.refreshVisibility();
            }
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (visibilityListener = this.mListener) != null) {
                visibilityListener.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // androidx.core.view.ActionProvider
        public View onCreateActionView(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, menuItem)) == null) {
                return this.mInner.onCreateActionView(menuItem);
            }
            return (View) invokeL.objValue;
        }

        @Override // androidx.core.view.ActionProvider
        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            ActionProviderWrapperJB actionProviderWrapperJB;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, visibilityListener) == null) {
                this.mListener = visibilityListener;
                android.view.ActionProvider actionProvider = this.mInner;
                if (visibilityListener != null) {
                    actionProviderWrapperJB = this;
                } else {
                    actionProviderWrapperJB = null;
                }
                actionProvider.setVisibilityListener(actionProviderWrapperJB);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final android.view.CollapsibleActionView mWrappedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollapsibleActionViewWrapper(View view2) {
            super(view2.getContext());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.mWrappedView = (android.view.CollapsibleActionView) view2;
            addView(view2);
        }

        public View getWrappedView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (View) this.mWrappedView;
            }
            return (View) invokeV.objValue;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) {
                return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem));
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuItem)) == null) {
                return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem));
            }
            return invokeL.booleanValue;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) {
                return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(menuItem));
            }
            return invokeL.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mWrappedObject.collapseActionView();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mWrappedObject.expandActionView();
        }
        return invokeV.booleanValue;
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
            if (actionView instanceof CollapsibleActionViewWrapper) {
                return ((CollapsibleActionViewWrapper) actionView).getWrappedView();
            }
            return actionView;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mWrappedObject.getAlphabeticModifiers();
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mWrappedObject.getAlphabeticShortcut();
        }
        return invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mWrappedObject.getContentDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mWrappedObject.getGroupId();
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mWrappedObject.getIcon();
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mWrappedObject.getIconTintList();
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mWrappedObject.getIconTintMode();
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mWrappedObject.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mWrappedObject.getItemId();
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mWrappedObject.getMenuInfo();
        }
        return (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mWrappedObject.getNumericModifiers();
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mWrappedObject.getNumericShortcut();
        }
        return invokeV.charValue;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mWrappedObject.getOrder();
        }
        return invokeV.intValue;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
        }
        return (SubMenu) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mWrappedObject.getTitle();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mWrappedObject.getTitleCondensed();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mWrappedObject.getTooltipText();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mWrappedObject.hasSubMenu();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mWrappedObject.isActionViewExpanded();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mWrappedObject.isCheckable();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mWrappedObject.isChecked();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mWrappedObject.isEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mWrappedObject.isVisible();
        }
        return invokeV.booleanValue;
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

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Character.valueOf(c)})) == null) {
            this.mWrappedObject.setAlphabeticShortcut(c);
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
    public MenuItem setNumericShortcut(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Character.valueOf(c)})) == null) {
            this.mWrappedObject.setNumericShortcut(c);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        InterceptResult invokeL;
        OnActionExpandListenerWrapper onActionExpandListenerWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, onActionExpandListener)) == null) {
            SupportMenuItem supportMenuItem = this.mWrappedObject;
            if (onActionExpandListener != null) {
                onActionExpandListenerWrapper = new OnActionExpandListenerWrapper(this, onActionExpandListener);
            } else {
                onActionExpandListenerWrapper = null;
            }
            supportMenuItem.setOnActionExpandListener(onActionExpandListenerWrapper);
            return this;
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        InterceptResult invokeL;
        OnMenuItemClickListenerWrapper onMenuItemClickListenerWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, onMenuItemClickListener)) == null) {
            SupportMenuItem supportMenuItem = this.mWrappedObject;
            if (onMenuItemClickListener != null) {
                onMenuItemClickListenerWrapper = new OnMenuItemClickListenerWrapper(this, onMenuItemClickListener);
            } else {
                onMenuItemClickListenerWrapper = null;
            }
            supportMenuItem.setOnMenuItemClickListener(onMenuItemClickListenerWrapper);
            return this;
        }
        return (MenuItem) invokeL.objValue;
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            return this.mWrappedObject.setVisible(z);
        }
        return (MenuItem) invokeZ.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            if (view2 instanceof android.view.CollapsibleActionView) {
                view2 = new CollapsibleActionViewWrapper(view2);
            }
            this.mWrappedObject.setActionView(view2);
            return this;
        }
        return (MenuItem) invokeL.objValue;
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
    public MenuItem setAlphabeticShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            this.mWrappedObject.setAlphabeticShortcut(c, i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            this.mWrappedObject.setNumericShortcut(c, i);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Character.valueOf(c), Character.valueOf(c2)})) == null) {
            this.mWrappedObject.setShortcut(c, c2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }

    public void setExclusiveCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            try {
                if (this.mSetExclusiveCheckableMethod == null) {
                    this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                }
                this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, Boolean.valueOf(z));
            } catch (Exception e) {
                Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e);
            }
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Character.valueOf(c), Character.valueOf(c2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.mWrappedObject.setShortcut(c, c2, i, i2);
            return this;
        }
        return (MenuItem) invokeCommon.objValue;
    }
}
