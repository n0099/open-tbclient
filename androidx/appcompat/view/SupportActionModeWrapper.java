package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public final ActionMode mWrappedObject;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<SupportActionModeWrapper> mActionModes;
        public final Context mContext;
        public final SimpleArrayMap<Menu, Menu> mMenus;
        public final ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, callback};
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
            this.mWrappedCallback = callback;
            this.mActionModes = new ArrayList<>();
            this.mMenus = new SimpleArrayMap<>();
        }

        private Menu getMenuWrapper(Menu menu) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, menu)) == null) {
                Menu menu2 = this.mMenus.get(menu);
                if (menu2 == null) {
                    MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.mContext, (SupportMenu) menu);
                    this.mMenus.put(menu, menuWrapperICS);
                    return menuWrapperICS;
                }
                return menu2;
            }
            return (Menu) invokeL.objValue;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, actionMode)) == null) {
                int size = this.mActionModes.size();
                for (int i = 0; i < size; i++) {
                    SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(i);
                    if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                        return supportActionModeWrapper;
                    }
                }
                SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
                this.mActionModes.add(supportActionModeWrapper2);
                return supportActionModeWrapper2;
            }
            return (android.view.ActionMode) invokeL.objValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, actionMode, menuItem)) == null) ? this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) menuItem)) : invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, actionMode, menu)) == null) ? this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu)) : invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, actionMode) == null) {
                this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(actionMode));
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, actionMode, menu)) == null) ? this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(actionMode), getMenuWrapper(menu)) : invokeLL.booleanValue;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, actionMode};
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
        this.mWrappedObject = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mWrappedObject.finish();
        }
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrappedObject.getCustomView() : (View) invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new MenuWrapperICS(this.mContext, (SupportMenu) this.mWrappedObject.getMenu()) : (Menu) invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWrappedObject.getMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWrappedObject.getSubtitle() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWrappedObject.getTag() : invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mWrappedObject.getTitle() : (CharSequence) invokeV.objValue;
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mWrappedObject.getTitleOptionalHint() : invokeV.booleanValue;
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mWrappedObject.invalidate();
        }
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mWrappedObject.isTitleOptional() : invokeV.booleanValue;
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            this.mWrappedObject.setCustomView(view2);
        }
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            this.mWrappedObject.setSubtitle(charSequence);
        }
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            this.mWrappedObject.setTag(obj);
        }
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) {
            this.mWrappedObject.setTitle(charSequence);
        }
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mWrappedObject.setTitleOptionalHint(z);
        }
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mWrappedObject.setSubtitle(i);
        }
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mWrappedObject.setTitle(i);
        }
    }
}
