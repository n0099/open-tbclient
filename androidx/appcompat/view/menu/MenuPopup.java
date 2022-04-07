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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int measureIndividualMenuWidth(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, null, listAdapter, viewGroup, context, i)) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            View view2 = null;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                int itemViewType = listAdapter.getItemViewType(i4);
                if (itemViewType != i3) {
                    view2 = null;
                    i3 = itemViewType;
                }
                if (viewGroup == null) {
                    viewGroup = new FrameLayout(context);
                }
                view2 = listAdapter.getView(i4, view2, viewGroup);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view2.getMeasuredWidth();
                if (measuredWidth >= i) {
                    return i;
                }
                if (measuredWidth > i2) {
                    i2 = measuredWidth;
                }
            }
            return i2;
        }
        return invokeLLLI.intValue;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder menuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, menuBuilder)) == null) {
            int size = menuBuilder.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menuBuilder.getItem(i);
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
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
            toMenuAdapter(listAdapter).mAdapterMenu.performItemAction((MenuItem) listAdapter.getItem(i), this, closeMenuOnSubMenuOpened() ? 0 : 4);
        }
    }

    public abstract void setAnchorView(View view2);

    public void setEpicenterBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            this.mEpicenterBounds = rect;
        }
    }

    public abstract void setForceShowIcon(boolean z);

    public abstract void setGravity(int i);

    public abstract void setHorizontalOffset(int i);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    public abstract void setShowTitle(boolean z);

    public abstract void setVerticalOffset(int i);
}
