package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SupportMenu mWrappedObject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supportMenu};
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
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return getMenuItemWrapper(this.mWrappedObject.add(i));
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i));
        }
        return (SubMenu) invokeI.objValue;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return getMenuItemWrapper(this.mWrappedObject.findItem(i));
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return getMenuItemWrapper(this.mWrappedObject.getItem(i));
        }
        return (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            internalRemoveGroup(i);
            this.mWrappedObject.removeGroup(i);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            internalRemoveItem(i);
            this.mWrappedObject.removeItem(i);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mWrappedObject.setQwertyMode(z);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4)) == null) {
            return getMenuItemWrapper(this.mWrappedObject.add(i, i2, i3, i4));
        }
        return (MenuItem) invokeIIII.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048582, this, i, i2, i3, i4)) == null) {
            return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i, i2, i3, i4));
        }
        return (SubMenu) invokeIIII.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), charSequence})) == null) {
            return getMenuItemWrapper(this.mWrappedObject.add(i, i2, i3, charSequence));
        }
        return (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), charSequence})) == null) {
            return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i, i2, i3, charSequence));
        }
        return (SubMenu) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
            return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
        }
        return (MenuItem) invokeL.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
            return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
        }
        return (SubMenu) invokeL.objValue;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        InterceptResult invokeCommon;
        MenuItem[] menuItemArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), componentName, intentArr, intent, Integer.valueOf(i4), menuItemArr})) == null) {
            if (menuItemArr != null) {
                menuItemArr2 = new MenuItem[menuItemArr.length];
            } else {
                menuItemArr2 = null;
            }
            int addIntentOptions = this.mWrappedObject.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
            if (menuItemArr2 != null) {
                int length = menuItemArr2.length;
                for (int i5 = 0; i5 < length; i5++) {
                    menuItemArr[i5] = getMenuItemWrapper(menuItemArr2[i5]);
                }
            }
            return addIntentOptions;
        }
        return invokeCommon.intValue;
    }

    @Override // android.view.Menu
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            internalClear();
            this.mWrappedObject.clear();
        }
    }

    @Override // android.view.Menu
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mWrappedObject.close();
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mWrappedObject.hasVisibleItems();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.Menu
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mWrappedObject.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            return this.mWrappedObject.isShortcutKey(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            return this.mWrappedObject.performIdentifierAction(i, i2);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mWrappedObject.setGroupEnabled(i, z);
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mWrappedObject.setGroupVisible(i, z);
        }
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), keyEvent, Integer.valueOf(i2)})) == null) {
            return this.mWrappedObject.performShortcut(i, keyEvent, i2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mWrappedObject.setGroupCheckable(i, z, z2);
        }
    }
}
