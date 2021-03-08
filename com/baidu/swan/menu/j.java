package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {
    private static SparseArray<h> euI = new SparseArray<>();

    static {
        euI.put(5, new h(5, f.C0544f.aiapp_menu_text_night_mode, f.c.aiapp_menu_item_nightmode, true));
        euI.put(35, new h(35, f.C0544f.aiapp_menu_add_launcher, f.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        euI.put(39, new h(39, f.C0544f.aiapp_menu_restart, f.c.aiapp_menu_item_restart_selector, true));
        euI.put(4, new h(4, f.C0544f.aiapp_menu_text_share, f.c.aiapp_menu_item_share_arrow_selector, true));
        euI.put(37, new h(37, f.C0544f.aiapp_menu_authority_management, f.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        euI.put(38, new h(38, f.C0544f.aiapp_menu_text_favorite, f.c.aiapp_menu_item_add_fav_selector, true));
        euI.put(42, new h(42, f.C0544f.aiapp_menu_game_restart, f.c.aiapp_menu_item_restart_selector, true));
        euI.put(49, new h(49, f.C0544f.swan_app_menu_setting, f.c.swan_app_menu_item_setting_selector, true));
        euI.put(50, new h(50, f.C0544f.swanapp_menu_font_setting, f.c.swan_app_menu_item_font_setting_selector, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<h> lK(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(h.e(euI.get(38)));
                arrayList.add(h.e(euI.get(5)));
                arrayList.add(h.e(euI.get(4)));
                arrayList.add(h.e(euI.get(35)));
                arrayList.add(h.e(euI.get(42)));
                break;
            case 12:
            case 15:
                arrayList.add(h.e(euI.get(38)));
                arrayList.add(h.e(euI.get(4)));
                arrayList.add(h.e(euI.get(39)));
                arrayList.add(h.e(euI.get(35)));
                arrayList.add(h.e(euI.get(5)));
                arrayList.add(h.e(euI.get(49)));
                arrayList.add(h.e(euI.get(50)));
                break;
            case 13:
                arrayList.add(h.e(euI.get(35)));
                arrayList.add(h.e(euI.get(37)));
                break;
            case 16:
                arrayList.add(h.e(euI.get(5)));
                break;
            case 17:
            case 18:
                arrayList.add(h.e(euI.get(38)));
                arrayList.add(h.e(euI.get(4)));
                arrayList.add(h.e(euI.get(39)));
                arrayList.add(h.e(euI.get(35)));
                arrayList.add(h.e(euI.get(5)));
                arrayList.add(h.e(euI.get(49)));
                arrayList.add(h.e(euI.get(50)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h lL(int i) {
        return h.e(euI.get(i));
    }
}
