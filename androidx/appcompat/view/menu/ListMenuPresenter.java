package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    public transient /* synthetic */ FieldHolder $fh;
    public MenuAdapter mAdapter;
    public MenuPresenter.Callback mCallback;
    public Context mContext;
    public int mId;
    public LayoutInflater mInflater;
    public int mItemIndexOffset;
    public int mItemLayoutRes;
    public MenuBuilder mMenu;
    public ExpandedMenuView mMenuView;
    public int mThemeRes;

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder, menuItemImpl)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mExpandedIndex;
        public final /* synthetic */ ListMenuPresenter this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
        }

        public MenuAdapter(ListMenuPresenter listMenuPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listMenuPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listMenuPresenter;
            this.mExpandedIndex = -1;
            findExpandedIndex();
        }

        public void findExpandedIndex() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MenuItemImpl expandedItem = this.this$0.mMenu.getExpandedItem();
                if (expandedItem != null) {
                    ArrayList<MenuItemImpl> nonActionItems = this.this$0.mMenu.getNonActionItems();
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

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int size = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
                if (this.mExpandedIndex < 0) {
                    return size;
                }
                return size - 1;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                findExpandedIndex();
                super.notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                ArrayList<MenuItemImpl> nonActionItems = this.this$0.mMenu.getNonActionItems();
                int i2 = i + this.this$0.mItemIndexOffset;
                int i3 = this.mExpandedIndex;
                if (i3 >= 0 && i2 >= i3) {
                    i2++;
                }
                return nonActionItems.get(i2);
            }
            return (MenuItemImpl) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    ListMenuPresenter listMenuPresenter = this.this$0;
                    view2 = listMenuPresenter.mInflater.inflate(listMenuPresenter.mItemLayoutRes, viewGroup, false);
                }
                ((MenuView.ItemView) view2).initialize(getItem(i), 0);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    public ListMenuPresenter(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mItemLayoutRes = i;
        this.mThemeRes = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, menuBuilder) == null) {
            if (this.mThemeRes != 0) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.mThemeRes);
                this.mContext = contextThemeWrapper;
                this.mInflater = LayoutInflater.from(contextThemeWrapper);
            } else if (this.mContext != null) {
                this.mContext = context;
                if (this.mInflater == null) {
                    this.mInflater = LayoutInflater.from(context);
                }
            }
            this.mMenu = menuBuilder;
            MenuAdapter menuAdapter = this.mAdapter;
            if (menuAdapter != null) {
                menuAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mAdapter == null) {
                this.mAdapter = new MenuAdapter(this);
            }
            return this.mAdapter;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mId;
        }
        return invokeV.intValue;
    }

    public int getItemIndexOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mItemIndexOffset;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mMenuView == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            saveHierarchyState(bundle);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            if (this.mMenuView == null) {
                this.mMenuView = (ExpandedMenuView) this.mInflater.inflate(R.layout.obfuscated_res_0x7f0d000d, viewGroup, false);
                if (this.mAdapter == null) {
                    this.mAdapter = new MenuAdapter(this);
                }
                this.mMenuView.setAdapter((ListAdapter) this.mAdapter);
                this.mMenuView.setOnItemClickListener(this);
            }
            return this.mMenuView;
        }
        return (MenuView) invokeL.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, menuBuilder, z) == null) && (callback = this.mCallback) != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.mMenu.performItemAction(this.mAdapter.getItem(i), this, 0);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            restoreHierarchyState((Bundle) parcelable);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, subMenuBuilder)) == null) {
            if (!subMenuBuilder.hasVisibleItems()) {
                return false;
            }
            new MenuDialogHelper(subMenuBuilder).show(null);
            MenuPresenter.Callback callback = this.mCallback;
            if (callback != null) {
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) && (sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list")) != null) {
            this.mMenuView.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            ExpandedMenuView expandedMenuView = this.mMenuView;
            if (expandedMenuView != null) {
                expandedMenuView.saveHierarchyState(sparseArray);
            }
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, callback) == null) {
            this.mCallback = callback;
        }
    }

    public void setId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mId = i;
        }
    }

    public void setItemIndexOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mItemIndexOffset = i;
            if (this.mMenuView != null) {
                updateMenuView(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        MenuAdapter menuAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (menuAdapter = this.mAdapter) != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
