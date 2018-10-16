package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppMenu implements View.OnKeyListener, OnAiAppMenuItemClickListener {
    private static final String COMMON_MENU_SOURCE_DEFAULT = "searchbox";
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppMenu";
    private Context mContext;
    private AiAppMenuMode mCurMenuMode;
    private OnAiAppMenuItemClickListener mDefaultClickListener;
    private MenuDisplayCallback mDisplayCallback;
    private OnAiAppMenuItemClickListener mItemClickListener;
    private List<AiAppMenuItem> mItemsList;
    private View.OnKeyListener mKeyListener;
    private String mMenuSource;
    private AiAppMenuView mMenuView;
    private AiAppMenuStatisticProcessor mStatisticProcessor;
    private String mStatisticSource;
    private int mStyle;

    /* loaded from: classes2.dex */
    public interface MenuDisplayCallback {
        void onDisplayChanged(AiAppMenu aiAppMenu, boolean z);
    }

    public AiAppMenu(Context context, View view, int i) {
        this(context, view, i, COMMON_MENU_SOURCE_DEFAULT);
    }

    public AiAppMenu(Context context, View view, int i, @Nullable IAiAppMenuDecorate iAiAppMenuDecorate) {
        this(context, view, i, COMMON_MENU_SOURCE_DEFAULT, iAiAppMenuDecorate);
    }

    public AiAppMenu(Context context, View view, int i, String str) {
        this(context, view, i, str, null);
    }

    public AiAppMenu(Context context, View view, int i, String str, @Nullable IAiAppMenuDecorate iAiAppMenuDecorate) {
        this.mItemsList = new ArrayList();
        this.mMenuSource = COMMON_MENU_SOURCE_DEFAULT;
        this.mCurMenuMode = null;
        if (i >= 0) {
            this.mContext = context;
            this.mStyle = i;
            this.mMenuSource = str;
            this.mItemsList = AiAppMenuStyle.getMenuItems(this.mStyle);
            if (AiAppMenuFactoryInit.mListenerFactory != null) {
                this.mDefaultClickListener = AiAppMenuFactoryInit.mListenerFactory.createMenuClickListener();
                this.mStatisticProcessor = AiAppMenuFactoryInit.mListenerFactory.createStatisticProcessor();
            }
            this.mMenuView = new AiAppMenuView(this.mContext, view, this.mStyle, iAiAppMenuDecorate);
            this.mMenuView.setMenu(this);
            this.mMenuView.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.searchbox.ng.aiapps.menu.AiAppMenu.1
                @Override // com.baidu.searchbox.ng.aiapps.menu.view.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (AiAppMenu.this.mDisplayCallback != null) {
                        AiAppMenu.this.mDisplayCallback.onDisplayChanged(AiAppMenu.this, false);
                    }
                }
            });
        }
    }

    public void setStatisticSource(String str) {
        this.mStatisticSource = str;
        this.mMenuView.setStatisticSource(this.mStatisticSource);
    }

    public void setMenuSource(String str) {
        this.mMenuSource = str;
        this.mMenuView.setMenuSource(str);
    }

    public void setDisplayCallback(MenuDisplayCallback menuDisplayCallback) {
        this.mDisplayCallback = menuDisplayCallback;
    }

    public void setOnItemClickListener(OnAiAppMenuItemClickListener onAiAppMenuItemClickListener) {
        this.mItemClickListener = onAiAppMenuItemClickListener;
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.mKeyListener = onKeyListener;
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener
    public boolean onClick(View view, AiAppMenuItem aiAppMenuItem) {
        if (aiAppMenuItem.isEnable()) {
            if (shouldDismiss(aiAppMenuItem)) {
                dismiss(true);
            }
            boolean z = false;
            if (this.mItemClickListener != null) {
                z = this.mItemClickListener.onClick(view, aiAppMenuItem);
            }
            if (!z && this.mDefaultClickListener != null) {
                return this.mDefaultClickListener.onClick(view, aiAppMenuItem);
            }
            return z;
        }
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.mKeyListener != null) {
            return this.mKeyListener.onKey(view, i, keyEvent);
        }
        return false;
    }

    public PopupWindow getMenuView() {
        return this.mMenuView;
    }

    public void show(boolean z) {
        if (isShowing()) {
            dismiss(true);
            return;
        }
        handleMenuShowStat();
        updateData(z);
        this.mMenuView.updateMenu(this.mItemsList);
        this.mMenuView.showView();
        if (this.mDisplayCallback != null) {
            this.mDisplayCallback.onDisplayChanged(this, true);
        }
    }

    public void dismiss() {
        dismiss(true);
    }

    public void dismiss(boolean z) {
        this.mMenuView.dismissView(z);
        if (this.mDisplayCallback != null) {
            this.mDisplayCallback.onDisplayChanged(this, false);
        }
    }

    public boolean isShowing() {
        return this.mMenuView != null && this.mMenuView.isShowing();
    }

    public void notifyDataChanged() {
        if (this.mMenuView != null) {
            this.mMenuView.notifyDataChanged();
        }
    }

    public void addMenuItem(int i, int i2) {
        AiAppMenuItem menuItem;
        int i3 = 0;
        boolean z = false;
        for (AiAppMenuItem aiAppMenuItem : this.mItemsList) {
            z = aiAppMenuItem.getItemId() == i ? true : z;
        }
        if (!z && (menuItem = AiAppMenuStyle.getMenuItem(i)) != null) {
            int size = this.mItemsList.size();
            if (i2 > 0) {
                i3 = i2 >= size ? size : i2;
            }
            this.mItemsList.add(i3, menuItem);
        }
    }

    public void removeMenuItem(int i) {
        if (this.mItemsList != null) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.mItemsList.size(); i3++) {
                if (this.mItemsList.get(i3).getItemId() == i) {
                    i2 = i3;
                }
            }
            if (i2 > -1) {
                this.mItemsList.remove(i2);
            }
        }
    }

    public void removeAllMenuItems() {
        if (this.mItemsList != null) {
            this.mItemsList.clear();
        }
    }

    public void showSubMenu(BaseMenuView baseMenuView) {
        this.mMenuView.showSubMenu(baseMenuView);
    }

    public void addSubMenu(BaseMenuView baseMenuView) {
        this.mMenuView.addSubMenu(baseMenuView);
    }

    public void setState(int i, boolean z) {
        if (this.mItemsList != null && this.mItemsList.size() != 0) {
            for (AiAppMenuItem aiAppMenuItem : this.mItemsList) {
                if (aiAppMenuItem.getItemId() == i) {
                    aiAppMenuItem.setEnable(z);
                    return;
                }
            }
        }
    }

    private boolean shouldDismiss(AiAppMenuItem aiAppMenuItem) {
        return true;
    }

    private void handleUpdateData(boolean z) {
        this.mCurMenuMode = AiAppMenuMode.NORMAL;
        this.mMenuView.setMode(this.mCurMenuMode);
        for (AiAppMenuItem aiAppMenuItem : this.mItemsList) {
            switch (aiAppMenuItem.getItemId()) {
                case 5:
                    aiAppMenuItem.setTitle(z ? R.string.aiapp_menu_text_day_mode : R.string.aiapp_menu_text_night_mode);
                    aiAppMenuItem.setIcon(R.drawable.aiapp_menu_item_nightmode);
                    break;
            }
            aiAppMenuItem.setOnItemClickListener(this);
        }
    }

    private void updateData(boolean z) {
        if (this.mItemsList != null) {
            handleUpdateData(z);
        }
    }

    private void handleMenuShowStat() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", this.mStatisticSource);
        hashMap.put("source", this.mMenuSource);
        hashMap.put("type", AiAppMenuStatisticConstants.TOOLBAR_MENU_TYPE_MENU);
        if (this.mStatisticProcessor != null) {
            this.mStatisticProcessor.doStatistic(AiAppMenuStatisticConstants.TOOLBAR_MENU_STAT_KEY_MENU, hashMap);
        }
    }
}
