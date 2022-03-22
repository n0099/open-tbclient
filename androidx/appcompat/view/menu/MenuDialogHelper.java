package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog mDialog;
    public MenuBuilder mMenu;
    public ListMenuPresenter mPresenter;
    public MenuPresenter.Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {menuBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMenu = menuBuilder;
    }

    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (alertDialog = this.mDialog) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface, i) == null) {
            this.mMenu.performItemAction((MenuItemImpl) this.mPresenter.getAdapter().getItem(i), 0);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, menuBuilder, z) == null) {
            if (z || menuBuilder == this.mMenu) {
                dismiss();
            }
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dialogInterface) == null) {
            this.mPresenter.onCloseMenu(this.mMenu, true);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, dialogInterface, i, keyEvent)) == null) {
            if (i == 82 || i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    Window window2 = this.mDialog.getWindow();
                    if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                        return true;
                    }
                } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.mDialog.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                    this.mMenu.close(true);
                    dialogInterface.dismiss();
                    return true;
                }
            }
            return this.mMenu.performShortcut(i, keyEvent, 0);
        }
        return invokeLIL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, menuBuilder)) == null) {
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            this.mPresenterCallback = callback;
        }
    }

    public void show(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iBinder) == null) {
            MenuBuilder menuBuilder = this.mMenu;
            AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
            ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R$layout.abc_list_menu_item_layout);
            this.mPresenter = listMenuPresenter;
            listMenuPresenter.setCallback(this);
            this.mMenu.addMenuPresenter(this.mPresenter);
            builder.setAdapter(this.mPresenter.getAdapter(), this);
            View headerView = menuBuilder.getHeaderView();
            if (headerView != null) {
                builder.setCustomTitle(headerView);
            } else {
                builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
            }
            builder.setOnKeyListener(this);
            AlertDialog create = builder.create();
            this.mDialog = create;
            create.setOnDismissListener(this);
            WindowManager.LayoutParams attributes = this.mDialog.getWindow().getAttributes();
            attributes.type = 1003;
            if (iBinder != null) {
                attributes.token = iBinder;
            }
            attributes.flags |= 131072;
            this.mDialog.show();
        }
    }
}
