package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public MenuItem add(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) ? getMenuItemWrapper(this.mWrappedObject.add(charSequence)) : (MenuItem) invokeL.objValue;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), componentName, intentArr, intent, Integer.valueOf(i5), menuItemArr})) == null) {
            MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
            int addIntentOptions = this.mWrappedObject.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
            if (menuItemArr2 != null) {
                int length = menuItemArr2.length;
                for (int i6 = 0; i6 < length; i6++) {
                    menuItemArr[i6] = getMenuItemWrapper(menuItemArr2[i6]);
                }
            }
            return addIntentOptions;
        }
        return invokeCommon.intValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) ? getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence)) : (SubMenu) invokeL.objValue;
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
    public MenuItem findItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? getMenuItemWrapper(this.mWrappedObject.findItem(i2)) : (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? getMenuItemWrapper(this.mWrappedObject.getItem(i2)) : (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mWrappedObject.hasVisibleItems() : invokeV.booleanValue;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) ? this.mWrappedObject.isShortcutKey(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) ? this.mWrappedObject.performIdentifierAction(i2, i3) : invokeII.booleanValue;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), keyEvent, Integer.valueOf(i3)})) == null) ? this.mWrappedObject.performShortcut(i2, keyEvent, i3) : invokeCommon.booleanValue;
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            internalRemoveGroup(i2);
            this.mWrappedObject.removeGroup(i2);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            internalRemoveItem(i2);
            this.mWrappedObject.removeItem(i2);
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mWrappedObject.setGroupCheckable(i2, z, z2);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mWrappedObject.setGroupEnabled(i2, z);
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mWrappedObject.setGroupVisible(i2, z);
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
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mWrappedObject.size() : invokeV.intValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? getMenuItemWrapper(this.mWrappedObject.add(i2)) : (MenuItem) invokeI.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2)) : (SubMenu) invokeI.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence})) == null) ? getMenuItemWrapper(this.mWrappedObject.add(i2, i3, i4, charSequence)) : (MenuItem) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence})) == null) ? getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2, i3, i4, charSequence)) : (SubMenu) invokeCommon.objValue;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) ? getMenuItemWrapper(this.mWrappedObject.add(i2, i3, i4, i5)) : (MenuItem) invokeIIII.objValue;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048582, this, i2, i3, i4, i5)) == null) ? getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2, i3, i4, i5)) : (SubMenu) invokeIIII.objValue;
    }
}
