package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BdMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mBgDarkAlpha;
    public Context mContext;
    public boolean mCurrentMode;
    public Runnable mDismissMenuTask;
    public boolean mDismissOnClick;
    public boolean mIsBackgroundDarken;
    public boolean mIsHaveAnimation;
    public List<BdMenuItem> mItems;
    public View.OnKeyListener mKeyClickListener;
    public View mMenu;
    public BdMenuItem.OnItemClickListener mMenuItemClickListener;
    public OnMenuItemsUpdateListener mMenuItemsUpdateListener;
    public int mPopAnimStyle;
    public PopupWindow mPopupWindow;
    public int mPopupWindowWidth;
    public Resources mResources;
    public BdMenuStateChangeListener mStateChangeListener;
    public final View mViewToAttach;

    /* loaded from: classes6.dex */
    public interface OnMenuItemsUpdateListener {
        void onMenuItemUpdated(List<BdMenuItem> list);
    }

    /* loaded from: classes6.dex */
    public interface OnMenuSetChangedListener {
        void onMenuItemUpdated(BdMenuItem bdMenuItem);

        void onMenuSetChanged();
    }

    public BdMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDismissOnClick = true;
        this.mIsBackgroundDarken = false;
        this.mBgDarkAlpha = 0.5f;
        this.mIsHaveAnimation = false;
        this.mPopAnimStyle = R.style.pop_window_anim;
        this.mDismissMenuTask = new Runnable(this) { // from class: com.baidu.android.ext.widget.menu.BdMenu.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMenu this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.dismiss();
                }
            }
        };
        this.mViewToAttach = view;
        this.mContext = view.getContext();
        this.mResources = this.mViewToAttach.getResources();
        this.mItems = new ArrayList();
        this.mPopupWindowWidth = -2;
        this.mCurrentMode = NightModeHelper.getNightModeSwitcherState();
        prepareMenuView(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackgroundDarkenStatus() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (view = this.mViewToAttach) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void darkenTheBackground(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, this, f2) == null) || (view = this.mViewToAttach) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private void showPopUpWindow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            BdMenuStateChangeListener bdMenuStateChangeListener = this.mStateChangeListener;
            if (bdMenuStateChangeListener != null) {
                bdMenuStateChangeListener.onShowMenu();
            }
            updateMenuItems(this.mItems);
            ensureMenuLoaded(this.mMenu, this.mItems);
            dismiss();
            if (this.mPopupWindow == null) {
                PopupWindow popupWindow = new PopupWindow(this.mMenu, this.mPopupWindowWidth, -2, true);
                this.mPopupWindow = popupWindow;
                if (this.mIsHaveAnimation) {
                    popupWindow.setAnimationStyle(this.mPopAnimStyle);
                }
                if (z) {
                    this.mPopupWindow.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.pop_transparent_bg));
                    this.mPopupWindow.setTouchable(true);
                } else {
                    this.mPopupWindow.setTouchable(false);
                }
                this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener(this) { // from class: com.baidu.android.ext.widget.menu.BdMenu.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdMenu this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.this$0.mIsBackgroundDarken) {
                                this.this$0.clearBackgroundDarkenStatus();
                            }
                            BdMenuStateChangeListener bdMenuStateChangeListener2 = this.this$0.mStateChangeListener;
                            if (bdMenuStateChangeListener2 != null) {
                                bdMenuStateChangeListener2.onDismissMenu();
                            }
                        }
                    }
                });
            }
            View view = this.mViewToAttach;
            if (view == null) {
                BdMenuStateChangeListener bdMenuStateChangeListener2 = this.mStateChangeListener;
                if (bdMenuStateChangeListener2 != null) {
                    bdMenuStateChangeListener2.onDismissMenu();
                    return;
                }
                return;
            }
            view.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.menu.BdMenu.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMenu this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.this$0.mIsBackgroundDarken) {
                                this.this$0.darkenTheBackground(this.this$0.mBgDarkAlpha);
                            }
                            this.this$0.showMenu(this.this$0.mPopupWindow);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            this.mMenu.postInvalidate();
        }
    }

    public BdMenuItem add(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, charSequence)) == null) ? addInternal(i2, charSequence, null) : (BdMenuItem) invokeIL.objValue;
    }

    public BdMenuItem addInternal(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, charSequence, drawable)) == null) ? addMenuItem(new BdMenuItem(this.mContext, i2, charSequence, drawable)) : (BdMenuItem) invokeILL.objValue;
    }

    public BdMenuItem addMenuItem(BdMenuItem bdMenuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdMenuItem)) == null) {
            bdMenuItem.setMenu(this);
            if (this.mDismissOnClick) {
                bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener(this) { // from class: com.baidu.android.ext.widget.menu.BdMenu.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdMenu this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.ext.widget.menu.BdMenuItem.OnItemClickListener
                    public void onClick(BdMenuItem bdMenuItem2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bdMenuItem2) == null) {
                            if (bdMenuItem2.isAutoDismiss()) {
                                this.this$0.dismiss(bdMenuItem2.getDismissDelayTime());
                            }
                            BdMenuItem.OnItemClickListener onItemClickListener = this.this$0.mMenuItemClickListener;
                            if (onItemClickListener != null) {
                                onItemClickListener.onClick(bdMenuItem2);
                            }
                        }
                    }
                });
            } else {
                bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
            }
            this.mItems.add(bdMenuItem);
            return bdMenuItem;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mItems.clear();
        }
    }

    public void dismiss() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (popupWindow = this.mPopupWindow) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception unused) {
        }
    }

    public abstract void ensureMenuLoaded(View view, List<BdMenuItem> list);

    public BdMenuItem findItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int findItemIndex = findItemIndex(i2);
            if (findItemIndex > -1) {
                return this.mItems.get(findItemIndex);
            }
            return null;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public int findItemIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int size = this.mItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mItems.get(i3).getItemId() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public abstract View getMenuView(Context context);

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMenu : (View) invokeV.objValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PopupWindow popupWindow = this.mPopupWindow;
            return popupWindow != null && popupWindow.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdMenuItem) == null) {
            ((OnMenuSetChangedListener) this.mMenu).onMenuItemUpdated(bdMenuItem);
        }
    }

    public void notifyMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ((OnMenuSetChangedListener) this.mMenu).onMenuSetChanged();
        }
    }

    public void prepareMenuView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            View menuView = getMenuView(context);
            this.mMenu = menuView;
            menuView.setFocusable(true);
            this.mMenu.setFocusableInTouchMode(true);
            View view = this.mMenu;
            if (view instanceof OnMenuSetChangedListener) {
                view.setOnKeyListener(new View.OnKeyListener(this) { // from class: com.baidu.android.ext.widget.menu.BdMenu.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdMenu this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnKeyListener
                    public boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                        InterceptResult invokeLIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view2, i2, keyEvent)) == null) {
                            if (keyEvent.getAction() == 1) {
                                if (i2 == 4 || i2 == 82) {
                                    this.this$0.dismiss();
                                    View.OnKeyListener onKeyListener = this.this$0.mKeyClickListener;
                                    if (onKeyListener != null) {
                                        onKeyListener.onKey(view2, i2, keyEvent);
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return invokeLIL.booleanValue;
                    }
                });
                return;
            }
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
    }

    public void removeItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            removeItemAt(findItemIndex(i2));
        }
    }

    public void removeItemAt(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 < 0 || i2 >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i2);
    }

    public void setBackgroundDarken(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsBackgroundDarken = z;
        }
    }

    public void setBgDarkAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mBgDarkAlpha = f2;
        }
    }

    public void setDismissOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mDismissOnClick = z;
        }
    }

    public void setHaveAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mIsHaveAnimation = z;
        }
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onItemClickListener) == null) {
            this.mMenuItemClickListener = onItemClickListener;
        }
    }

    public void setMenuItemsUpdateListener(OnMenuItemsUpdateListener onMenuItemsUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onMenuItemsUpdateListener) == null) {
            this.mMenuItemsUpdateListener = onMenuItemsUpdateListener;
        }
    }

    public void setMenuStateChangeListener(BdMenuStateChangeListener bdMenuStateChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdMenuStateChangeListener) == null) {
            this.mStateChangeListener = bdMenuStateChangeListener;
        }
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onKeyListener) == null) {
            this.mKeyClickListener = onKeyListener;
        }
    }

    public void setPopAnimStyle(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mPopAnimStyle = i2;
        }
    }

    public void setPopupWindowWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mPopupWindowWidth = i2;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (NightModeHelper.getNightModeSwitcherState() != this.mCurrentMode) {
                prepareMenuView(this.mContext);
                this.mPopupWindow = null;
            }
            showPopUpWindow(true);
            this.mCurrentMode = NightModeHelper.getNightModeSwitcherState();
        }
    }

    public abstract void showMenu(PopupWindow popupWindow);

    public void showNotDismissOnTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            showPopUpWindow(false);
        }
    }

    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                dismiss();
            } else {
                show();
            }
        }
    }

    public void updateMenuItems(List<BdMenuItem> list) {
        OnMenuItemsUpdateListener onMenuItemsUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, list) == null) || (onMenuItemsUpdateListener = this.mMenuItemsUpdateListener) == null) {
            return;
        }
        onMenuItemsUpdateListener.onMenuItemUpdated(list);
    }

    public BdMenuItem add(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? addInternal(i2, this.mResources.getString(i3), null) : (BdMenuItem) invokeII.objValue;
    }

    public BdMenuItem add(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, charSequence, drawable)) == null) ? addInternal(i2, charSequence, drawable) : (BdMenuItem) invokeILL.objValue;
    }

    public void dismiss(long j) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) || (view = this.mViewToAttach) == null) {
            return;
        }
        view.removeCallbacks(this.mDismissMenuTask);
        if (j > 0) {
            this.mViewToAttach.postDelayed(this.mDismissMenuTask, j);
        } else {
            dismiss();
        }
    }

    public BdMenuItem add(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4)) == null) ? addInternal(i2, this.mResources.getString(i3), this.mResources.getDrawable(i4)) : (BdMenuItem) invokeIII.objValue;
    }
}
