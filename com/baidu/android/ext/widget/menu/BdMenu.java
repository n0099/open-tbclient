package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public abstract class BdMenu {
    protected Context mContext;
    protected View.OnKeyListener mKeyClickListener;
    private View mMenu;
    protected BdMenuItem.OnItemClickListener mMenuItemClickListener;
    private OnMenuItemsUpdateListener mMenuItemsUpdateListener;
    protected PopupWindow mPopupWindow;
    protected Resources mResources;
    protected BdMenuStateChangeListener mStateChangeListener;
    protected final View mViewToAttach;
    private boolean mDismissOnClick = true;
    private boolean mIsBackgroundDarken = false;
    private float mBgDarkAlpha = 0.5f;
    private boolean mIsHaveAnimation = false;
    private int mPopAnimStyle = R.style.pop_window_anim;
    private Runnable mDismissMenuTask = new Runnable() { // from class: com.baidu.android.ext.widget.menu.BdMenu.5
        @Override // java.lang.Runnable
        public void run() {
            BdMenu.this.dismiss();
        }
    };
    protected List<BdMenuItem> mItems = new ArrayList();
    private int mPopupWindowWidth = -2;
    private boolean mCurrentMode = NightModeHelper.getNightModeSwitcherState();

    /* loaded from: classes12.dex */
    public interface OnMenuItemsUpdateListener {
        void onMenuItemUpdated(List<BdMenuItem> list);
    }

    /* loaded from: classes12.dex */
    public interface OnMenuSetChangedListener {
        void onMenuItemUpdated(BdMenuItem bdMenuItem);

        void onMenuSetChanged();
    }

    protected abstract void ensureMenuLoaded(View view, List<BdMenuItem> list);

    protected abstract View getMenuView(Context context);

    protected abstract void showMenu(PopupWindow popupWindow);

    public BdMenu(View view) {
        this.mViewToAttach = view;
        this.mContext = this.mViewToAttach.getContext();
        this.mResources = this.mViewToAttach.getResources();
        prepareMenuView(this.mContext);
    }

    public View getView() {
        return this.mMenu;
    }

    public void setMenuStateChangeListener(BdMenuStateChangeListener bdMenuStateChangeListener) {
        this.mStateChangeListener = bdMenuStateChangeListener;
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        this.mMenuItemClickListener = onItemClickListener;
    }

    public void setMenuItemsUpdateListener(OnMenuItemsUpdateListener onMenuItemsUpdateListener) {
        this.mMenuItemsUpdateListener = onMenuItemsUpdateListener;
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.mKeyClickListener = onKeyListener;
    }

    public void setPopupWindowWidth(int i) {
        this.mPopupWindowWidth = i;
    }

    public BdMenuItem addMenuItem(BdMenuItem bdMenuItem) {
        bdMenuItem.setMenu(this);
        if (this.mDismissOnClick) {
            bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.android.ext.widget.menu.BdMenu.1
                @Override // com.baidu.android.ext.widget.menu.BdMenuItem.OnItemClickListener
                public void onClick(BdMenuItem bdMenuItem2) {
                    if (bdMenuItem2.isAutoDismiss()) {
                        BdMenu.this.dismiss(bdMenuItem2.getDismissDelayTime());
                    }
                    if (BdMenu.this.mMenuItemClickListener != null) {
                        BdMenu.this.mMenuItemClickListener.onClick(bdMenuItem2);
                    }
                }
            });
        } else {
            bdMenuItem.setOnClickListener(this.mMenuItemClickListener);
        }
        this.mItems.add(bdMenuItem);
        return bdMenuItem;
    }

    public BdMenuItem add(int i, CharSequence charSequence) {
        return addInternal(i, charSequence, null);
    }

    public BdMenuItem add(int i, int i2) {
        return addInternal(i, this.mResources.getString(i2), null);
    }

    public BdMenuItem add(int i, CharSequence charSequence, Drawable drawable) {
        return addInternal(i, charSequence, drawable);
    }

    public BdMenuItem add(int i, int i2, int i3) {
        return addInternal(i, this.mResources.getString(i2), this.mResources.getDrawable(i3));
    }

    public int findItemIndex(int i) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public BdMenuItem findItem(int i) {
        int findItemIndex = findItemIndex(i);
        if (findItemIndex > -1) {
            return this.mItems.get(findItemIndex);
        }
        return null;
    }

    public void removeItemAt(int i) {
        if (i >= 0 && i < this.mItems.size()) {
            this.mItems.remove(i);
        }
    }

    public void removeItem(int i) {
        removeItemAt(findItemIndex(i));
    }

    public void clear() {
        this.mItems.clear();
    }

    public void notifyMenuSetChanged() {
        ((OnMenuSetChangedListener) this.mMenu).onMenuSetChanged();
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        ((OnMenuSetChangedListener) this.mMenu).onMenuItemUpdated(bdMenuItem);
    }

    public void showNotDismissOnTouch() {
        showPopUpWindow(false);
    }

    public void show() {
        if (NightModeHelper.getNightModeSwitcherState() != this.mCurrentMode) {
            prepareMenuView(this.mContext);
            this.mPopupWindow = null;
        }
        showPopUpWindow(true);
        this.mCurrentMode = NightModeHelper.getNightModeSwitcherState();
    }

    public boolean isShowing() {
        return this.mPopupWindow != null && this.mPopupWindow.isShowing();
    }

    public void dismiss() {
        if (this.mPopupWindow != null) {
            try {
                this.mPopupWindow.dismiss();
            } catch (Exception e) {
            }
        }
    }

    public void dismiss(long j) {
        if (this.mViewToAttach != null) {
            this.mViewToAttach.removeCallbacks(this.mDismissMenuTask);
            if (j > 0) {
                this.mViewToAttach.postDelayed(this.mDismissMenuTask, j);
            } else {
                dismiss();
            }
        }
    }

    public void toggle() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            dismiss();
        } else {
            show();
        }
    }

    protected void prepareMenuView(Context context) {
        this.mMenu = getMenuView(context);
        this.mMenu.setFocusable(true);
        this.mMenu.setFocusableInTouchMode(true);
        if (!(this.mMenu instanceof OnMenuSetChangedListener)) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.mMenu.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.android.ext.widget.menu.BdMenu.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (i == 4 || i == 82)) {
                    BdMenu.this.dismiss();
                    if (BdMenu.this.mKeyClickListener != null) {
                        BdMenu.this.mKeyClickListener.onKey(view, i, keyEvent);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    protected void setDismissOnClick(boolean z) {
        this.mDismissOnClick = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackgroundDarken(boolean z) {
        this.mIsBackgroundDarken = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHaveAnimation(boolean z) {
        this.mIsHaveAnimation = z;
    }

    protected void setBgDarkAlpha(float f) {
        this.mBgDarkAlpha = f;
    }

    protected void setPopAnimStyle(@StyleRes int i) {
        this.mPopAnimStyle = i;
    }

    protected BdMenuItem addInternal(int i, CharSequence charSequence, Drawable drawable) {
        return addMenuItem(new BdMenuItem(this.mContext, i, charSequence, drawable));
    }

    protected void updateMenuItems(List<BdMenuItem> list) {
        if (this.mMenuItemsUpdateListener != null) {
            this.mMenuItemsUpdateListener.onMenuItemUpdated(list);
        }
    }

    private void showPopUpWindow(boolean z) {
        if (this.mStateChangeListener != null) {
            this.mStateChangeListener.onShowMenu();
        }
        updateMenuItems(this.mItems);
        ensureMenuLoaded(this.mMenu, this.mItems);
        dismiss();
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow(this.mMenu, this.mPopupWindowWidth, -2, true);
            if (this.mIsHaveAnimation) {
                this.mPopupWindow.setAnimationStyle(this.mPopAnimStyle);
            }
            if (z) {
                this.mPopupWindow.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.pop_transparent_bg));
                this.mPopupWindow.setTouchable(true);
            } else {
                this.mPopupWindow.setTouchable(false);
            }
            this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.android.ext.widget.menu.BdMenu.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (BdMenu.this.mIsBackgroundDarken) {
                        BdMenu.this.clearBackgroundDarkenStatus();
                    }
                    if (BdMenu.this.mStateChangeListener != null) {
                        BdMenu.this.mStateChangeListener.onDismissMenu();
                    }
                }
            });
        }
        if (this.mViewToAttach == null) {
            if (this.mStateChangeListener != null) {
                this.mStateChangeListener.onDismissMenu();
                return;
            }
            return;
        }
        this.mViewToAttach.post(new Runnable() { // from class: com.baidu.android.ext.widget.menu.BdMenu.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BdMenu.this.mIsBackgroundDarken) {
                        BdMenu.this.darkenTheBackground(BdMenu.this.mBgDarkAlpha);
                    }
                    BdMenu.this.showMenu(BdMenu.this.mPopupWindow);
                } catch (Exception e) {
                }
            }
        });
        this.mMenu.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void darkenTheBackground(float f) {
        if (this.mViewToAttach != null) {
            ViewGroup viewGroup = (ViewGroup) this.mViewToAttach.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(ViewCompat.MEASURED_STATE_MASK);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (255.0f * f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackgroundDarkenStatus() {
        if (this.mViewToAttach != null) {
            ((ViewGroup) this.mViewToAttach.getRootView()).getOverlay().clear();
        }
    }
}
