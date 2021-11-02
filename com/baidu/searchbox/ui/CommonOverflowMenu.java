package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class CommonOverflowMenu extends BdMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDelatX;
    public int mDelatY;
    public int mGravity;
    public CommonOverflowMenuView mMenuView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenu(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setPopupWindowWidth(view.getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.discovery_feedback_width));
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view, list) == null) && (view instanceof CommonOverflowMenuView)) {
            CommonOverflowMenuView commonOverflowMenuView = (CommonOverflowMenuView) view;
            commonOverflowMenuView.setMaxHeightRes(com.baidu.android.common.ui.R.dimen.bd_action_bar_menu_max_height);
            commonOverflowMenuView.layoutMenu(list);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public View getMenuView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            CommonOverflowMenuView commonOverflowMenuView = new CommonOverflowMenuView(context);
            commonOverflowMenuView.setOrientation(1);
            this.mMenuView = commonOverflowMenuView;
            return commonOverflowMenuView;
        }
        return (View) invokeL.objValue;
    }

    public void setItemBackgroundRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mMenuView.setItemBackground(i2);
        }
    }

    public void setItemTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mMenuView.setItemTextColor(i2);
        }
    }

    public void setMenuBackgroundRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mMenuView.setBackgroundResource(i2);
        }
    }

    public void setMenuDivider(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.mMenuView.setItemDivider(i2, i3);
        }
    }

    public void setShowAtLocation(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            this.mGravity = i2;
            this.mDelatX = i3;
            this.mDelatY = i4;
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, popupWindow) == null) {
            popupWindow.showAtLocation(this.mViewToAttach, this.mGravity, this.mDelatX, this.mDelatY);
            if (popupWindow.isShowing()) {
                popupWindow.setAnimationStyle(com.baidu.android.common.ui.R.style.brower_menu);
                popupWindow.update(this.mDelatX, this.mDelatY, -1, -1, true);
            }
        }
    }
}
