package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    public SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    public BaseMenuWrapper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) {
            if (menuItem instanceof SupportMenuItem) {
                SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
                if (this.mMenuItems == null) {
                    this.mMenuItems = new SimpleArrayMap<>();
                }
                MenuItem menuItem2 = this.mMenuItems.get(menuItem);
                if (menuItem2 == null) {
                    MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, supportMenuItem);
                    this.mMenuItems.put(supportMenuItem, menuItemWrapperICS);
                    return menuItemWrapperICS;
                }
                return menuItem2;
            }
            return menuItem;
        }
        return (MenuItem) invokeL.objValue;
    }

    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subMenu)) == null) {
            if (subMenu instanceof SupportSubMenu) {
                SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
                if (this.mSubMenus == null) {
                    this.mSubMenus = new SimpleArrayMap<>();
                }
                SubMenu subMenu2 = this.mSubMenus.get(supportSubMenu);
                if (subMenu2 == null) {
                    SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.mContext, supportSubMenu);
                    this.mSubMenus.put(supportSubMenu, subMenuWrapperICS);
                    return subMenuWrapperICS;
                }
                return subMenu2;
            }
            return subMenu;
        }
        return (SubMenu) invokeL.objValue;
    }

    public final void internalClear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
            if (simpleArrayMap != null) {
                simpleArrayMap.clear();
            }
            SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.mSubMenus;
            if (simpleArrayMap2 != null) {
                simpleArrayMap2.clear();
            }
        }
    }

    public final void internalRemoveGroup(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.mMenuItems == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.mMenuItems.size()) {
            if (this.mMenuItems.keyAt(i2).getGroupId() == i) {
                this.mMenuItems.removeAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public final void internalRemoveItem(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.mMenuItems == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mMenuItems.size(); i2++) {
            if (this.mMenuItems.keyAt(i2).getItemId() == i) {
                this.mMenuItems.removeAt(i2);
                return;
            }
        }
    }
}
