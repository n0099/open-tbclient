package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZ_POSITION_LEFT = 0;
    public static final int HORIZ_POSITION_RIGHT = 1;
    public static final int ITEM_LAYOUT = 2131558411;
    public static final int SUBMENU_TIMEOUT_MS = 200;
    public transient /* synthetic */ FieldHolder $fh;
    public View mAnchorView;
    public final View.OnAttachStateChangeListener mAttachStateChangeListener;
    public final Context mContext;
    public int mDropDownGravity;
    public boolean mForceShowIcon;
    public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final MenuItemHoverListener mMenuItemHoverListener;
    public final int mMenuMaxWidth;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final List<MenuBuilder> mPendingMenus;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;
    public int mRawDropDownGravity;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public final List<CascadingMenuInfo> mShowingMenus;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HorizPosition {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1230074893, "Landroidx/appcompat/view/menu/CascadingMenuPopup;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1230074893, "Landroidx/appcompat/view/menu/CascadingMenuPopup;");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, parcelable) == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class CascadingMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {menuPopupWindow, menuBuilder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }

        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.window.getListView();
            }
            return (ListView) invokeV.objValue;
        }
    }

    public CascadingMenuPopup(Context context, View view2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CascadingMenuPopup this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.isShowing() && this.this$0.mShowingMenus.size() > 0 && !this.this$0.mShowingMenus.get(0).window.isModal()) {
                    View view3 = this.this$0.mShownAnchorView;
                    if (view3 != null && view3.isShown()) {
                        for (CascadingMenuInfo cascadingMenuInfo : this.this$0.mShowingMenus) {
                            cascadingMenuInfo.window.show();
                        }
                        return;
                    }
                    this.this$0.dismiss();
                }
            }
        };
        this.mAttachStateChangeListener = new View.OnAttachStateChangeListener(this) { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CascadingMenuPopup this$0;

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view3) == null) {
                    ViewTreeObserver viewTreeObserver = this.this$0.mTreeObserver;
                    if (viewTreeObserver != null) {
                        if (!viewTreeObserver.isAlive()) {
                            this.this$0.mTreeObserver = view3.getViewTreeObserver();
                        }
                        CascadingMenuPopup cascadingMenuPopup = this.this$0;
                        cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
                    }
                    view3.removeOnAttachStateChangeListener(this);
                }
            }
        };
        this.mMenuItemHoverListener = new MenuItemHoverListener(this) { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CascadingMenuPopup this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.appcompat.widget.MenuItemHoverListener
            public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, menuBuilder, menuItem) == null) {
                    CascadingMenuInfo cascadingMenuInfo = null;
                    this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
                    int size = this.this$0.mShowingMenus.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 < size) {
                            if (menuBuilder == this.this$0.mShowingMenus.get(i5).menu) {
                                break;
                            }
                            i5++;
                        } else {
                            i5 = -1;
                            break;
                        }
                    }
                    if (i5 == -1) {
                        return;
                    }
                    int i6 = i5 + 1;
                    if (i6 < this.this$0.mShowingMenus.size()) {
                        cascadingMenuInfo = this.this$0.mShowingMenus.get(i6);
                    }
                    this.this$0.mSubMenuHoverHandler.postAtTime(new Runnable(this, cascadingMenuInfo, menuItem, menuBuilder) { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass3 this$1;
                        public final /* synthetic */ MenuItem val$item;
                        public final /* synthetic */ MenuBuilder val$menu;
                        public final /* synthetic */ CascadingMenuInfo val$nextInfo;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, cascadingMenuInfo, menuItem, menuBuilder};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i7 = newInitContext2.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$nextInfo = cascadingMenuInfo;
                            this.val$item = menuItem;
                            this.val$menu = menuBuilder;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                CascadingMenuInfo cascadingMenuInfo2 = this.val$nextInfo;
                                if (cascadingMenuInfo2 != null) {
                                    this.this$1.this$0.mShouldCloseImmediately = true;
                                    cascadingMenuInfo2.menu.close(false);
                                    this.this$1.this$0.mShouldCloseImmediately = false;
                                }
                                if (this.val$item.isEnabled() && this.val$item.hasSubMenu()) {
                                    this.val$menu.performItemAction(this.val$item, 4);
                                }
                            }
                        }
                    }, menuBuilder, SystemClock.uptimeMillis() + 200);
                }
            }

            @Override // androidx.appcompat.widget.MenuItemHoverListener
            public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder, menuItem) == null) {
                    this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
                }
            }
        };
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mAnchorView = view2;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mOverflowOnly = z;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700a2));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
            menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
            menuPopupWindow.setOnItemClickListener(this);
            menuPopupWindow.setOnDismissListener(this);
            menuPopupWindow.setAnchorView(this.mAnchorView);
            menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
            menuPopupWindow.setModal(true);
            menuPopupWindow.setInputMethodMode(2);
            return menuPopupWindow;
        }
        return (MenuPopupWindow) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (size = this.mShowingMenus.size()) > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int size = this.mShowingMenus.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    cascadingMenuInfo = this.mShowingMenus.get(i);
                    if (!cascadingMenuInfo.window.isShowing()) {
                        break;
                    }
                    i++;
                } else {
                    cascadingMenuInfo = null;
                    break;
                }
            }
            if (cascadingMenuInfo != null) {
                cascadingMenuInfo.menu.close(false);
            }
        }
    }

    private int findIndexOfAddedMenu(MenuBuilder menuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, menuBuilder)) == null) {
            int size = this.mShowingMenus.size();
            for (int i = 0; i < size; i++) {
                if (menuBuilder == this.mShowingMenus.get(i).menu) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, menuBuilder) == null) {
            menuBuilder.addMenuPresenter(this, this.mContext);
            if (isShowing()) {
                showMenu(menuBuilder);
            } else {
                this.mPendingMenus.add(menuBuilder);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && this.mAnchorView != view2) {
            this.mAnchorView = view2;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(view2));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, callback) == null) {
            this.mPresenterCallback = callback;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mForceShowIcon = z;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mHasXOffset = true;
            this.mXOffset = i;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onDismissListener) == null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mShowTitle = z;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mHasYOffset = true;
            this.mYOffset = i;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
                MenuPopup.toMenuAdapter(cascadingMenuInfo.getListView().getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, menuBuilder, menuBuilder2)) == null) {
            int size = menuBuilder.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menuBuilder.getItem(i);
                if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                    return item;
                }
            }
            return null;
        }
        return (MenuItem) invokeLL.objValue;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        InterceptResult invokeLL;
        MenuAdapter menuAdapter;
        int i;
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, cascadingMenuInfo, menuBuilder)) == null) {
            MenuItem findMenuItemForSubmenu = findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder);
            if (findMenuItemForSubmenu == null) {
                return null;
            }
            ListView listView = cascadingMenuInfo.getListView();
            ListAdapter adapter = listView.getAdapter();
            int i2 = 0;
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i = headerViewListAdapter.getHeadersCount();
                menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
            } else {
                menuAdapter = (MenuAdapter) adapter;
                i = 0;
            }
            int count = menuAdapter.getCount();
            while (true) {
                if (i2 < count) {
                    if (findMenuItemForSubmenu == menuAdapter.getItem(i2)) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 == -1 || (firstVisiblePosition = (i2 + i) - listView.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= listView.getChildCount()) {
                return null;
            }
            return listView.getChildAt(firstVisiblePosition);
        }
        return (View) invokeLL.objValue;
    }

    private int getInitialMenuPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mShowingMenus.isEmpty()) {
                return null;
            }
            List<CascadingMenuInfo> list = this.mShowingMenus;
            return list.get(list.size() - 1).getListView();
        }
        return (ListView) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mShowingMenus.size() <= 0 || !this.mShowingMenus.get(0).window.isShowing()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private int getNextMenuPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            List<CascadingMenuInfo> list = this.mShowingMenus;
            ListView listView = list.get(list.size() - 1).getListView();
            int[] iArr = new int[2];
            listView.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
            if (this.mLastPosition == 1) {
                if (iArr[0] + listView.getWidth() + i <= rect.right) {
                    return 1;
                }
                return 0;
            } else if (iArr[0] - i < 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return invokeI.intValue;
    }

    private void showMenu(MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View view2;
        boolean z;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, menuBuilder) == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.mOverflowOnly, ITEM_LAYOUT);
            if (!isShowing() && this.mForceShowIcon) {
                menuAdapter.setForceShowIcon(true);
            } else if (isShowing()) {
                menuAdapter.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(menuBuilder));
            }
            int measureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter, null, this.mContext, this.mMenuMaxWidth);
            MenuPopupWindow createPopupWindow = createPopupWindow();
            createPopupWindow.setAdapter(menuAdapter);
            createPopupWindow.setContentWidth(measureIndividualMenuWidth);
            createPopupWindow.setDropDownGravity(this.mDropDownGravity);
            if (this.mShowingMenus.size() > 0) {
                List<CascadingMenuInfo> list = this.mShowingMenus;
                cascadingMenuInfo = list.get(list.size() - 1);
                view2 = findParentViewForSubmenu(cascadingMenuInfo, menuBuilder);
            } else {
                cascadingMenuInfo = null;
                view2 = null;
            }
            if (view2 != null) {
                createPopupWindow.setTouchModal(false);
                createPopupWindow.setEnterTransition(null);
                int nextMenuPosition = getNextMenuPosition(measureIndividualMenuWidth);
                if (nextMenuPosition == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.mLastPosition = nextMenuPosition;
                if (Build.VERSION.SDK_INT >= 26) {
                    createPopupWindow.setAnchorView(view2);
                    i2 = 0;
                    i = 0;
                } else {
                    int[] iArr = new int[2];
                    this.mAnchorView.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    view2.getLocationOnScreen(iArr2);
                    if ((this.mDropDownGravity & 7) == 5) {
                        iArr[0] = iArr[0] + this.mAnchorView.getWidth();
                        iArr2[0] = iArr2[0] + view2.getWidth();
                    }
                    i = iArr2[0] - iArr[0];
                    i2 = iArr2[1] - iArr[1];
                }
                if ((this.mDropDownGravity & 5) == 5) {
                    if (!z) {
                        measureIndividualMenuWidth = view2.getWidth();
                        i3 = i - measureIndividualMenuWidth;
                    }
                    i3 = i + measureIndividualMenuWidth;
                } else {
                    if (z) {
                        measureIndividualMenuWidth = view2.getWidth();
                        i3 = i + measureIndividualMenuWidth;
                    }
                    i3 = i - measureIndividualMenuWidth;
                }
                createPopupWindow.setHorizontalOffset(i3);
                createPopupWindow.setOverlapAnchor(true);
                createPopupWindow.setVerticalOffset(i2);
            } else {
                if (this.mHasXOffset) {
                    createPopupWindow.setHorizontalOffset(this.mXOffset);
                }
                if (this.mHasYOffset) {
                    createPopupWindow.setVerticalOffset(this.mYOffset);
                }
                createPopupWindow.setEpicenterBounds(getEpicenterBounds());
            }
            this.mShowingMenus.add(new CascadingMenuInfo(createPopupWindow, menuBuilder, this.mLastPosition));
            createPopupWindow.show();
            ListView listView = createPopupWindow.getListView();
            listView.setOnKeyListener(this);
            if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.getHeaderTitle() != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.obfuscated_res_0x7f0d0012, (ViewGroup) listView, false);
                frameLayout.setEnabled(false);
                ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
                listView.addHeaderView(frameLayout, null, false);
                createPopupWindow.show();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int findIndexOfAddedMenu;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048582, this, menuBuilder, z) != null) || (findIndexOfAddedMenu = findIndexOfAddedMenu(menuBuilder)) < 0) {
            return;
        }
        int i = findIndexOfAddedMenu + 1;
        if (i < this.mShowingMenus.size()) {
            this.mShowingMenus.get(i).menu.close(false);
        }
        CascadingMenuInfo remove = this.mShowingMenus.remove(findIndexOfAddedMenu);
        remove.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately) {
            remove.window.setExitTransition(null);
            remove.window.setAnimationStyle(0);
        }
        remove.window.dismiss();
        int size = this.mShowingMenus.size();
        if (size > 0) {
            this.mLastPosition = this.mShowingMenus.get(size - 1).position;
        } else {
            this.mLastPosition = getInitialMenuPosition();
        }
        if (size == 0) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, true);
            }
            ViewTreeObserver viewTreeObserver = this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                }
                this.mTreeObserver = null;
            }
            this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
            this.mOnDismissListener.onDismiss();
        } else if (z) {
            this.mShowingMenus.get(0).menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i, keyEvent)) == null) {
            if (keyEvent.getAction() == 1 && i == 82) {
                dismiss();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, subMenuBuilder)) == null) {
            for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
                if (subMenuBuilder == cascadingMenuInfo.menu) {
                    cascadingMenuInfo.getListView().requestFocus();
                    return true;
                }
            }
            if (subMenuBuilder.hasVisibleItems()) {
                addMenu(subMenuBuilder);
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || isShowing()) {
            return;
        }
        for (MenuBuilder menuBuilder : this.mPendingMenus) {
            showMenu(menuBuilder);
        }
        this.mPendingMenus.clear();
        View view2 = this.mAnchorView;
        this.mShownAnchorView = view2;
        if (view2 != null) {
            if (this.mTreeObserver == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }
}
