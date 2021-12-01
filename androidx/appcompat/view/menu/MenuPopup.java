package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mEpicenterBounds;

    public MenuPopup() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int measureIndividualMenuWidth(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, null, listAdapter, viewGroup, context, i2)) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            View view = null;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < count; i5++) {
                int itemViewType = listAdapter.getItemViewType(i5);
                if (itemViewType != i4) {
                    view = null;
                    i4 = itemViewType;
                }
                if (viewGroup == null) {
                    viewGroup = new FrameLayout(context);
                }
                view = listAdapter.getView(i5, view, viewGroup);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                if (measuredWidth >= i2) {
                    return i2;
                }
                if (measuredWidth > i3) {
                    i3 = measuredWidth;
                }
            }
            return i3;
        }
        return invokeLLLI.intValue;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder menuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, menuBuilder)) == null) {
            int size = menuBuilder.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = menuBuilder.getItem(i2);
                if (item.isVisible() && item.getIcon() != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static MenuAdapter toMenuAdapter(ListAdapter listAdapter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, listAdapter)) == null) {
            if (listAdapter instanceof HeaderViewListAdapter) {
                return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
            }
            return (MenuAdapter) listAdapter;
        }
        return (MenuAdapter) invokeL.objValue;
    }

    public abstract void addMenu(MenuBuilder menuBuilder);

    public boolean closeMenuOnSubMenuOpened() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public Rect getEpicenterBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEpicenterBounds : (Rect) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            throw new UnsupportedOperationException("MenuPopups manage their own views");
        }
        return (MenuView) invokeL.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, menuBuilder) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
            toMenuAdapter(listAdapter).mAdapterMenu.performItemAction((MenuItem) listAdapter.getItem(i2), this, closeMenuOnSubMenuOpened() ? 0 : 4);
        }
    }

    public abstract void setAnchorView(View view);

    public void setEpicenterBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            this.mEpicenterBounds = rect;
        }
    }

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int i2);

    public abstract void setHorizontalOffset(int i2);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z);

    public abstract void setVerticalOffset(int i2);
}
