package com.baidu.searchbox.ng.aiapps.menu;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppMenuStyle {
    private static final boolean DEBUG = false;
    public static final int MENU_STYLE_AI_APPS_ABOUT = 13;
    public static final int MENU_STYLE_AI_APPS_AD_LANDING = 16;
    public static final int MENU_STYLE_AI_APPS_CONTENT = 12;
    public static final int MENU_STYLE_AI_APPS_HOME = 15;
    public static final int MENU_STYLE_MINI_VIDEO_DETAIN_LANDING = 17;
    private static SparseArray<AiAppMenuItem> sPresetItems = new SparseArray<>();

    static {
        sPresetItems.put(5, new AiAppMenuItem(5, R.string.aiapp_menu_text_night_mode, R.drawable.aiapp_menu_item_nightmode, true));
        sPresetItems.put(34, new AiAppMenuItem(34, R.string.aiapp_menu_ai_apps_home_page, R.drawable.aiapp_menu_item_ai_apps_home_page_selector, true));
        sPresetItems.put(35, new AiAppMenuItem(35, R.string.aiapp_menu_add_launcher, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        sPresetItems.put(36, new AiAppMenuItem(36, R.string.aiapp_menu_about, R.drawable.aiapp_menu_item_ai_apps_about_selector, true));
        sPresetItems.put(4, new AiAppMenuItem(4, R.string.aiapp_menu_text_share, R.drawable.aiapp_menu_item_share_arrow_selector, true));
        sPresetItems.put(37, new AiAppMenuItem(37, R.string.aiapp_menu_authority_management, R.drawable.aiapp_menu_item_ai_apps_authority_management_selector, true));
        sPresetItems.put(9, new AiAppMenuItem(9, R.string.aiapp_menu_text_feedback, R.drawable.aiapp_menu_item_feedback_selector, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<AiAppMenuItem> getMenuItems(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 12:
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(4)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(34)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(35)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(36)));
                break;
            case 13:
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(37)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(35)));
                break;
            case 15:
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(4)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(35)));
                arrayList.add(AiAppMenuItem.makeCopy(sPresetItems.get(36)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AiAppMenuItem getMenuItem(int i) {
        return AiAppMenuItem.makeCopy(sPresetItems.get(i));
    }
}
