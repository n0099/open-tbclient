package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportSubMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SupportSubMenu mSubMenu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supportSubMenu};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (SupportMenu) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSubMenu = supportSubMenu;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mSubMenu.clearHeader();
        }
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getMenuItemWrapper(this.mSubMenu.getItem()) : (MenuItem) invokeV.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.mSubMenu.setHeaderIcon(i2);
            return this;
        }
        return (SubMenu) invokeI.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mSubMenu.setHeaderTitle(i2);
            return this;
        }
        return (SubMenu) invokeI.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.mSubMenu.setHeaderView(view);
            return this;
        }
        return (SubMenu) invokeL.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mSubMenu.setIcon(i2);
            return this;
        }
        return (SubMenu) invokeI.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawable)) == null) {
            this.mSubMenu.setHeaderIcon(drawable);
            return this;
        }
        return (SubMenu) invokeL.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequence)) == null) {
            this.mSubMenu.setHeaderTitle(charSequence);
            return this;
        }
        return (SubMenu) invokeL.objValue;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable)) == null) {
            this.mSubMenu.setIcon(drawable);
            return this;
        }
        return (SubMenu) invokeL.objValue;
    }
}
