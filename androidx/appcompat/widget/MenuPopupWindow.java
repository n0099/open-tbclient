package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MenuPopupWindow";
    public static Method sSetTouchModalMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public MenuItemHoverListener mHoverListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class MenuDropDownListView extends DropDownListView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mAdvanceKey;
        public MenuItemHoverListener mHoverListener;
        public MenuItem mHoveredMenuItem;
        public final int mRetreatKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.mAdvanceKey = 21;
                this.mRetreatKey = 22;
                return;
            }
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }

        public void clearSelection() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                setSelection(-1);
            }
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i2, boolean z) {
            return super.lookForSelectablePosition(i2, z);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i2, int i3, int i4, int i5, int i6) {
            return super.measureHeightOfChildrenCompat(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i2) {
            return super.onForwardedEvent(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            int i2;
            MenuAdapter menuAdapter;
            int pointToPosition;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
                if (this.mHoverListener != null) {
                    ListAdapter adapter = getAdapter();
                    if (adapter instanceof HeaderViewListAdapter) {
                        HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                        i2 = headerViewListAdapter.getHeadersCount();
                        menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                    } else {
                        i2 = 0;
                        menuAdapter = (MenuAdapter) adapter;
                    }
                    MenuItemImpl menuItemImpl = null;
                    if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < menuAdapter.getCount()) {
                        menuItemImpl = menuAdapter.getItem(i3);
                    }
                    MenuItem menuItem = this.mHoveredMenuItem;
                    if (menuItem != menuItemImpl) {
                        MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                        if (menuItem != null) {
                            this.mHoverListener.onItemHoverExit(adapterMenu, menuItem);
                        }
                        this.mHoveredMenuItem = menuItemImpl;
                        if (menuItemImpl != null) {
                            this.mHoverListener.onItemHoverEnter(adapterMenu, menuItemImpl);
                        }
                    }
                }
                return super.onHoverEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
                if (listMenuItemView != null && i2 == this.mAdvanceKey) {
                    if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                        performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                    }
                    return true;
                } else if (listMenuItemView != null && i2 == this.mRetreatKey) {
                    setSelection(-1);
                    ((MenuAdapter) getAdapter()).getAdapterMenu().close(false);
                    return true;
                } else {
                    return super.onKeyDown(i2, keyEvent);
                }
            }
            return invokeIL.booleanValue;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, menuItemHoverListener) == null) {
                this.mHoverListener = menuItemHoverListener;
            }
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-423505149, "Landroidx/appcompat/widget/MenuPopupWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-423505149, "Landroidx/appcompat/widget/MenuPopupWindow;");
                return;
            }
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i(TAG, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    @NonNull
    public DropDownListView createDropDownListView(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, context, z)) == null) {
            MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
            menuDropDownListView.setHoverListener(this);
            return menuDropDownListView;
        }
        return (DropDownListView) invokeLZ.objValue;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder, menuItem) == null) || (menuItemHoverListener = this.mHoverListener) == null) {
            return;
        }
        menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, menuBuilder, menuItem) == null) || (menuItemHoverListener = this.mHoverListener) == null) {
            return;
        }
        menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
    }

    public void setEnterTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.mPopup.setEnterTransition((Transition) obj);
    }

    public void setExitTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.mPopup.setExitTransition((Transition) obj);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, menuItemHoverListener) == null) {
            this.mHoverListener = menuItemHoverListener;
        }
    }

    public void setTouchModal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = sSetTouchModalMethod;
                if (method != null) {
                    try {
                        method.invoke(this.mPopup, Boolean.valueOf(z));
                        return;
                    } catch (Exception unused) {
                        Log.i(TAG, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        return;
                    }
                }
                return;
            }
            this.mPopup.setTouchModal(z);
        }
    }
}
