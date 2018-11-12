package com.baidu.searchbox.ng.ai.apps.impl.map.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class OpenLocationMenuItem {
    public static final int MENU_ITEM_HEIGHT = AiAppsUIUtils.dp2px(45.0f);
    private TextView mItem;
    private int mMarginBottom = AiAppsUIUtils.dp2px(1.0f);
    private OnMenuItemClickListener mMenuItemClickListener;
    private String mTitle;
    private MenuItemType mType;

    /* loaded from: classes4.dex */
    public enum MenuItemType {
        OPENLOCATION_PATH,
        OPENLOCATION_STREET_VIEW,
        OPENLOCATION_CANCEL,
        OPENLOCATION_BAIDU_MAP,
        OPENLOCATION_GAODE_MAP,
        OPENLOCATION_TENCENT_MAP,
        OPENLOCATION_SOUGOU_MAP,
        OPENLOCATION_GOOGLE_MAP
    }

    /* loaded from: classes4.dex */
    public interface OnMenuItemClickListener {
        void onMenuItemClick(OpenLocationMenuItem openLocationMenuItem);
    }

    public OpenLocationMenuItem(Context context, String str, MenuItemType menuItemType) {
        this.mItem = new TextView(context);
        this.mItem.setText(str);
        this.mItem.setTextSize(16.0f);
        this.mItem.setBackgroundResource(e.f.openlocation_bottommenu_itemclick_selector);
        this.mItem.setTextColor(-16777216);
        this.mItem.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, MENU_ITEM_HEIGHT);
        layoutParams.bottomMargin = this.mMarginBottom;
        layoutParams.gravity = 17;
        this.mItem.setLayoutParams(layoutParams);
        setTitle(str);
        setType(menuItemType);
        this.mItem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.item.OpenLocationMenuItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (OpenLocationMenuItem.this.mMenuItemClickListener != null) {
                    OpenLocationMenuItem.this.mMenuItemClickListener.onMenuItemClick(OpenLocationMenuItem.this);
                }
            }
        });
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public MenuItemType getType() {
        return this.mType;
    }

    public void setType(MenuItemType menuItemType) {
        this.mType = menuItemType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public TextView getItem() {
        return this.mItem;
    }
}
