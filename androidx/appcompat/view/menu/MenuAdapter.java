package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
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
public class MenuAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MenuBuilder mAdapterMenu;
    public int mExpandedIndex;
    public boolean mForceShowIcon;
    public final LayoutInflater mInflater;
    public final int mItemLayoutRes;
    public final boolean mOverflowOnly;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {menuBuilder, layoutInflater, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExpandedIndex = -1;
        this.mOverflowOnly = z;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = i;
        findExpandedIndex();
    }

    public void findExpandedIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MenuItemImpl expandedItem = this.mAdapterMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = this.mAdapterMenu.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.mExpandedIndex = i;
                        return;
                    }
                }
            }
            this.mExpandedIndex = -1;
        }
    }

    public MenuBuilder getAdapterMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAdapterMenu;
        }
        return (MenuBuilder) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<MenuItemImpl> visibleItems;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mOverflowOnly) {
                visibleItems = this.mAdapterMenu.getNonActionItems();
            } else {
                visibleItems = this.mAdapterMenu.getVisibleItems();
            }
            if (this.mExpandedIndex < 0) {
                return visibleItems.size();
            }
            return visibleItems.size() - 1;
        }
        return invokeV.intValue;
    }

    public boolean getForceShowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mForceShowIcon;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        InterceptResult invokeI;
        ArrayList<MenuItemImpl> visibleItems;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.mOverflowOnly) {
                visibleItems = this.mAdapterMenu.getNonActionItems();
            } else {
                visibleItems = this.mAdapterMenu.getVisibleItems();
            }
            int i2 = this.mExpandedIndex;
            if (i2 >= 0 && i >= i2) {
                i++;
            }
            return visibleItems.get(i);
        }
        return (MenuItemImpl) invokeI.objValue;
    }

    public void setForceShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mForceShowIcon = z;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
            }
            int groupId = getItem(i).getGroupId();
            int i3 = i - 1;
            if (i3 >= 0) {
                i2 = getItem(i3).getGroupId();
            } else {
                i2 = groupId;
            }
            ListMenuItemView listMenuItemView = (ListMenuItemView) view2;
            if (this.mAdapterMenu.isGroupDividerEnabled() && groupId != i2) {
                z = true;
            } else {
                z = false;
            }
            listMenuItemView.setGroupDividerEnabled(z);
            MenuView.ItemView itemView = (MenuView.ItemView) view2;
            if (this.mForceShowIcon) {
                listMenuItemView.setForceShowIcon(true);
            }
            itemView.initialize(getItem(i), 0);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
