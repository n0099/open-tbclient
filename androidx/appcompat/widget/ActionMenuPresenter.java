package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ActionMenuPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseBooleanArray mActionButtonGroups;
    public ActionButtonSubmenu mActionButtonPopup;
    public int mActionItemWidthLimit;
    public boolean mExpandedActionViewsExclusive;
    public int mMaxItems;
    public boolean mMaxItemsSet;
    public int mMinCellSize;
    public int mOpenSubMenuId;
    public OverflowMenuButton mOverflowButton;
    public OverflowPopup mOverflowPopup;
    public Drawable mPendingOverflowIcon;
    public boolean mPendingOverflowIconSet;
    public ActionMenuPopupCallback mPopupCallback;
    public final PopupPresenterCallback mPopupPresenterCallback;
    public OpenOverflowRunnable mPostedOpenRunnable;
    public boolean mReserveOverflow;
    public boolean mReserveOverflowSet;
    public boolean mStrictWidthLimit;
    public int mWidthLimit;
    public boolean mWidthLimitSet;

    /* loaded from: classes.dex */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, SubMenuBuilder subMenuBuilder, View view2) {
            super(context, subMenuBuilder, view2, false, R.attr.obfuscated_res_0x7f04006a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter, context, subMenuBuilder, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (MenuBuilder) objArr2[1], (View) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view3 = actionMenuPresenter.mOverflowButton;
                setAnchorView(view3 == null ? (View) actionMenuPresenter.mMenuView : view3);
            }
            setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ActionMenuPresenter actionMenuPresenter = this.this$0;
                actionMenuPresenter.mActionButtonPopup = null;
                actionMenuPresenter.mOpenSubMenuId = 0;
                super.onDismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuPresenter this$0;

        public ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ActionButtonSubmenu actionButtonSubmenu = this.this$0.mActionButtonPopup;
                if (actionButtonSubmenu != null) {
                    return actionButtonSubmenu.getPopup();
                }
                return null;
            }
            return (ShowableListMenu) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OverflowPopup mPopup;
        public final /* synthetic */ ActionMenuPresenter this$0;

        public OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, OverflowPopup overflowPopup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter, overflowPopup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.this$0.mMenu != null) {
                    this.this$0.mMenu.changeMenuMode();
                }
                View view2 = (View) this.this$0.mMenuView;
                if (view2 != null && view2.getWindowToken() != null && this.mPopup.tryShow()) {
                    this.this$0.mOverflowPopup = this.mPopup;
                }
                this.this$0.mPostedOpenRunnable = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OverflowMenuButton(ActionMenuPresenter actionMenuPresenter, Context context) {
            super(context, null, R.attr.obfuscated_res_0x7f040069);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, this, actionMenuPresenter) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OverflowMenuButton this$1;
                public final /* synthetic */ ActionMenuPresenter val$this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this, this, actionMenuPresenter};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((View) newInitContext2.callArgs[0]);
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = actionMenuPresenter;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        OverflowPopup overflowPopup = this.this$1.this$0.mOverflowPopup;
                        if (overflowPopup == null) {
                            return null;
                        }
                        return overflowPopup.getPopup();
                    }
                    return (ShowableListMenu) invokeV.objValue;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        this.this$1.this$0.showOverflowMenu();
                        return true;
                    }
                    return invokeV.booleanValue;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        ActionMenuPresenter actionMenuPresenter2 = this.this$1.this$0;
                        if (actionMenuPresenter2.mPostedOpenRunnable != null) {
                            return false;
                        }
                        actionMenuPresenter2.hideOverflowMenu();
                        return true;
                    }
                    return invokeV.booleanValue;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (super.performClick()) {
                    return true;
                }
                playSoundEffect(0);
                this.this$0.showOverflowMenu();
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) {
                boolean frame = super.setFrame(i, i2, i3, i4);
                Drawable drawable = getDrawable();
                Drawable background = getBackground();
                if (drawable != null && background != null) {
                    int width = getWidth();
                    int height = getHeight();
                    int max = Math.max(width, height) / 2;
                    int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                    int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                    DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
                }
                return frame;
            }
            return invokeIIII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class OverflowPopup extends MenuPopupHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view2, boolean z) {
            super(context, menuBuilder, view2, z, R.attr.obfuscated_res_0x7f04006a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter, context, menuBuilder, view2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (MenuBuilder) objArr2[1], (View) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
            setGravity(8388613);
            setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.this$0.mMenu != null) {
                    this.this$0.mMenu.close();
                }
                this.this$0.mOverflowPopup = null;
                super.onDismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuPresenter this$0;

        public PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuPresenter;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, menuBuilder, z) == null) {
                if (menuBuilder instanceof SubMenuBuilder) {
                    menuBuilder.getRootMenu().close(false);
                }
                MenuPresenter.Callback callback = this.this$0.getCallback();
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder)) == null) {
                if (menuBuilder == this.this$0.mMenu) {
                    return false;
                }
                this.this$0.mOpenSubMenuId = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
                MenuPresenter.Callback callback = this.this$0.getCallback();
                if (callback == null) {
                    return false;
                }
                return callback.onOpenSubMenu(menuBuilder);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1988762949, "Landroidx/appcompat/widget/ActionMenuPresenter$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1988762949, "Landroidx/appcompat/widget/ActionMenuPresenter$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SavedState(parcel);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }
            };
        }

        public SavedState() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public SavedState(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeInt(this.openSubMenuId);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuPresenter(Context context) {
        super(context, R.layout.obfuscated_res_0x7f0d0003, R.layout.obfuscated_res_0x7f0d0002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            MenuView menuView = this.mMenuView;
            MenuView menuView2 = super.getMenuView(viewGroup);
            if (menuView != menuView2) {
                ((ActionMenuView) menuView2).setPresenter(this);
            }
            return menuView2;
        }
        return (MenuView) invokeL.objValue;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, configuration) == null) {
            if (!this.mMaxItemsSet) {
                this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
            }
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.onItemsChanged(true);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, parcelable) == null) && (parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                super.onSubMenuSelected(null);
                return;
            }
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.close(false);
            }
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mExpandedActionViewsExclusive = z;
        }
    }

    public void setItemLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mMaxItems = i;
            this.mMaxItemsSet = true;
        }
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, actionMenuView) == null) {
            this.mMenuView = actionMenuView;
            actionMenuView.initialize(this.mMenu);
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null) {
                overflowMenuButton.setImageDrawable(drawable);
                return;
            }
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mReserveOverflow = z;
            this.mReserveOverflowSet = true;
        }
    }

    private View findViewForItem(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, menuItem)) == null) {
            ViewGroup viewGroup = (ViewGroup) this.mMenuView;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, menuItemImpl, itemView) == null) {
            itemView.initialize(menuItemImpl, 0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
            if (this.mPopupCallback == null) {
                this.mPopupCallback = new ActionMenuPopupCallback(this);
            }
            actionMenuItemView.setPopupCallback(this.mPopupCallback);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            if (viewGroup.getChildAt(i) == this.mOverflowButton) {
                return false;
            }
            return super.filterLeftoverView(viewGroup, i);
        }
        return invokeLI.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, menuBuilder, z) == null) {
            dismissPopupMenus();
            super.onCloseMenu(menuBuilder, z);
        }
    }

    public void setWidthLimit(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.mWidthLimit = i;
            this.mStrictWidthLimit = z;
            this.mWidthLimitSet = true;
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, menuItemImpl)) == null) {
            return menuItemImpl.isActionButton();
        }
        return invokeIL.booleanValue;
    }

    public boolean dismissPopupMenus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return hideOverflowMenu() | hideSubMenus();
        }
        return invokeV.booleanValue;
    }

    public Drawable getOverflowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null) {
                return overflowMenuButton.getDrawable();
            }
            if (this.mPendingOverflowIconSet) {
                return this.mPendingOverflowIcon;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        MenuView menuView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
            if (openOverflowRunnable != null && (menuView = this.mMenuView) != null) {
                ((View) menuView).removeCallbacks(openOverflowRunnable);
                this.mPostedOpenRunnable = null;
                return true;
            }
            OverflowPopup overflowPopup = this.mOverflowPopup;
            if (overflowPopup != null) {
                overflowPopup.dismiss();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hideSubMenus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
            if (actionButtonSubmenu != null) {
                actionButtonSubmenu.dismiss();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mPostedOpenRunnable == null && !isOverflowMenuShowing()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            OverflowPopup overflowPopup = this.mOverflowPopup;
            if (overflowPopup != null && overflowPopup.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowReserved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mReserveOverflow;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SavedState savedState = new SavedState();
            savedState.openSubMenuId = this.mOpenSubMenuId;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        InterceptResult invokeV;
        ArrayList<MenuItemImpl> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this;
            MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
            View view2 = null;
            int i5 = 0;
            if (menuBuilder != null) {
                arrayList = menuBuilder.getVisibleItems();
                i = arrayList.size();
            } else {
                arrayList = null;
                i = 0;
            }
            int i6 = actionMenuPresenter.mMaxItems;
            int i7 = actionMenuPresenter.mActionItemWidthLimit;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
            boolean z3 = false;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                MenuItemImpl menuItemImpl = arrayList.get(i10);
                if (menuItemImpl.requiresActionButton()) {
                    i8++;
                } else if (menuItemImpl.requestsActionButton()) {
                    i9++;
                } else {
                    z3 = true;
                }
                if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                    i6 = 0;
                }
            }
            if (actionMenuPresenter.mReserveOverflow && (z3 || i9 + i8 > i6)) {
                i6--;
            }
            int i11 = i6 - i8;
            SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
            sparseBooleanArray.clear();
            if (actionMenuPresenter.mStrictWidthLimit) {
                int i12 = actionMenuPresenter.mMinCellSize;
                i3 = i7 / i12;
                i2 = i12 + ((i7 % i12) / i3);
            } else {
                i2 = 0;
                i3 = 0;
            }
            int i13 = 0;
            int i14 = 0;
            while (i13 < i) {
                MenuItemImpl menuItemImpl2 = arrayList.get(i13);
                if (menuItemImpl2.requiresActionButton()) {
                    View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view2, viewGroup);
                    if (actionMenuPresenter.mStrictWidthLimit) {
                        i3 -= ActionMenuView.measureChildForCells(itemView, i2, i3, makeMeasureSpec, i5);
                    } else {
                        itemView.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth = itemView.getMeasuredWidth();
                    i7 -= measuredWidth;
                    if (i14 == 0) {
                        i14 = measuredWidth;
                    }
                    int groupId = menuItemImpl2.getGroupId();
                    if (groupId != 0) {
                        sparseBooleanArray.put(groupId, true);
                    }
                    menuItemImpl2.setIsActionButton(true);
                    i4 = i;
                } else if (menuItemImpl2.requestsActionButton()) {
                    int groupId2 = menuItemImpl2.getGroupId();
                    boolean z4 = sparseBooleanArray.get(groupId2);
                    if ((i11 > 0 || z4) && i7 > 0 && (!actionMenuPresenter.mStrictWidthLimit || i3 > 0)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z5 = z;
                    i4 = i;
                    if (z) {
                        View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                        if (actionMenuPresenter.mStrictWidthLimit) {
                            int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i2, i3, makeMeasureSpec, 0);
                            i3 -= measureChildForCells;
                            if (measureChildForCells == 0) {
                                z5 = false;
                            }
                        } else {
                            itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        }
                        boolean z6 = z5;
                        int measuredWidth2 = itemView2.getMeasuredWidth();
                        i7 -= measuredWidth2;
                        if (i14 == 0) {
                            i14 = measuredWidth2;
                        }
                        if (!actionMenuPresenter.mStrictWidthLimit ? i7 + i14 > 0 : i7 >= 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z = z6 & z2;
                    }
                    if (z && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z4) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i15 = 0; i15 < i13; i15++) {
                            MenuItemImpl menuItemImpl3 = arrayList.get(i15);
                            if (menuItemImpl3.getGroupId() == groupId2) {
                                if (menuItemImpl3.isActionButton()) {
                                    i11++;
                                }
                                menuItemImpl3.setIsActionButton(false);
                            }
                        }
                    }
                    if (z) {
                        i11--;
                    }
                    menuItemImpl2.setIsActionButton(z);
                } else {
                    i4 = i;
                    menuItemImpl2.setIsActionButton(false);
                    i13++;
                    view2 = null;
                    actionMenuPresenter = this;
                    i = i4;
                    i5 = 0;
                }
                i13++;
                view2 = null;
                actionMenuPresenter = this;
                i = i4;
                i5 = 0;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view2, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, menuItemImpl, view2, viewGroup)) == null) {
            View actionView = menuItemImpl.getActionView();
            if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
                actionView = super.getItemView(menuItemImpl, view2, viewGroup);
            }
            if (menuItemImpl.isActionViewExpanded()) {
                i = 8;
            } else {
                i = 0;
            }
            actionView.setVisibility(i);
            ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
            ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
            if (!actionMenuView.checkLayoutParams(layoutParams)) {
                actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
            }
            return actionView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, menuBuilder) == null) {
            super.initForMenu(context, menuBuilder);
            Resources resources = context.getResources();
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
            if (!this.mReserveOverflowSet) {
                this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
            }
            if (!this.mWidthLimitSet) {
                this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
            }
            if (!this.mMaxItemsSet) {
                this.mMaxItems = actionBarPolicy.getMaxActionButtons();
            }
            int i = this.mWidthLimit;
            if (this.mReserveOverflow) {
                if (this.mOverflowButton == null) {
                    OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this, this.mSystemContext);
                    this.mOverflowButton = overflowMenuButton;
                    if (this.mPendingOverflowIconSet) {
                        overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                        this.mPendingOverflowIcon = null;
                        this.mPendingOverflowIconSet = false;
                    }
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i -= this.mOverflowButton.getMeasuredWidth();
            } else {
                this.mOverflowButton = null;
            }
            this.mActionItemWidthLimit = i;
            this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, subMenuBuilder)) == null) {
            boolean z = false;
            if (!subMenuBuilder.hasVisibleItems()) {
                return false;
            }
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (subMenuBuilder2.getParentMenu() != this.mMenu) {
                subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
            }
            View findViewForItem = findViewForItem(subMenuBuilder2.getItem());
            if (findViewForItem == null) {
                return false;
            }
            this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
            int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this, this.mContext, subMenuBuilder, findViewForItem);
            this.mActionButtonPopup = actionButtonSubmenu;
            actionButtonSubmenu.setForceShowIcon(z);
            this.mActionButtonPopup.show();
            super.onSubMenuSelected(subMenuBuilder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.mReserveOverflow && !isOverflowMenuShowing() && (menuBuilder = this.mMenu) != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !menuBuilder.getNonActionItems().isEmpty()) {
                OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
                this.mPostedOpenRunnable = openOverflowRunnable;
                ((View) this.mMenuView).post(openOverflowRunnable);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        ArrayList<MenuItemImpl> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.updateMenuView(z);
            ((View) this.mMenuView).requestLayout();
            MenuBuilder menuBuilder = this.mMenu;
            boolean z2 = false;
            if (menuBuilder != null) {
                ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
                int size = actionItems.size();
                for (int i = 0; i < size; i++) {
                    ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                    if (supportActionProvider != null) {
                        supportActionProvider.setSubUiVisibilityListener(this);
                    }
                }
            }
            MenuBuilder menuBuilder2 = this.mMenu;
            if (menuBuilder2 != null) {
                arrayList = menuBuilder2.getNonActionItems();
            } else {
                arrayList = null;
            }
            if (this.mReserveOverflow && arrayList != null) {
                int size2 = arrayList.size();
                if (size2 == 1) {
                    z2 = !arrayList.get(0).isActionViewExpanded();
                } else if (size2 > 0) {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.mOverflowButton == null) {
                    this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
                }
                ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
                if (viewGroup != this.mMenuView) {
                    if (viewGroup != null) {
                        viewGroup.removeView(this.mOverflowButton);
                    }
                    ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                    actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
                }
            } else {
                OverflowMenuButton overflowMenuButton = this.mOverflowButton;
                if (overflowMenuButton != null) {
                    ViewParent parent = overflowMenuButton.getParent();
                    MenuView menuView = this.mMenuView;
                    if (parent == menuView) {
                        ((ViewGroup) menuView).removeView(this.mOverflowButton);
                    }
                }
            }
            ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        }
    }
}
