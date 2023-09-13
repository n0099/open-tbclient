package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class BdContextMenu extends BdMenu {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BdContextMenu";
    public transient /* synthetic */ FieldHolder $fh;
    public BdContextMenuView mMenuView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenu(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setPopupWindowWidth(view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
        setBackgroundDarken(true);
        setHaveAnimation(true);
    }

    private void onMenuSetChanged(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, view2) == null) {
            ((BdContextMenuView) view2).onMenuSetChanged();
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public View getMenuView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            BdContextMenuView bdContextMenuView = new BdContextMenuView(context);
            this.mMenuView = bdContextMenuView;
            return bdContextMenuView;
        }
        return (View) invokeL.objValue;
    }

    public void setLayoutInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mMenuView.setLayoutInCenter(z);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, popupWindow) == null) {
            popupWindow.showAtLocation(this.mViewToAttach, 17, 0, 0);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void ensureMenuLoaded(View view2, List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, list) == null) {
            ((BdContextMenuView) view2).layoutMenu(list);
        }
    }

    public void updateMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            onMenuSetChanged(getView());
            ensureMenuLoaded(getView(), this.mItems);
        }
    }
}
