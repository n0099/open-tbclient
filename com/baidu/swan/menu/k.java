package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class k {
    private static SparseArray<i> dux = new SparseArray<>();

    static {
        dux.put(5, new i(5, g.f.aiapp_menu_text_night_mode, g.c.aiapp_menu_item_nightmode, true));
        dux.put(35, new i(35, g.f.aiapp_menu_add_launcher, g.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        dux.put(39, new i(39, g.f.aiapp_menu_restart, g.c.aiapp_menu_item_restart_selector, true));
        dux.put(4, new i(4, g.f.aiapp_menu_text_share, g.c.aiapp_menu_item_share_arrow_selector, true));
        dux.put(37, new i(37, g.f.aiapp_menu_authority_management, g.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        dux.put(38, new i(38, g.f.aiapp_menu_text_favorite, g.c.aiapp_menu_item_add_fav_selector, true));
        dux.put(42, new i(42, g.f.aiapp_menu_game_restart, g.c.aiapp_menu_item_restart_selector, true));
        dux.put(49, new i(49, g.f.swan_app_menu_setting, g.c.swan_app_menu_item_setting_selector, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<i> jy(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(i.e(dux.get(38)));
                arrayList.add(i.e(dux.get(5)));
                arrayList.add(i.e(dux.get(4)));
                arrayList.add(i.e(dux.get(35)));
                arrayList.add(i.e(dux.get(42)));
                break;
            case 12:
            case 15:
                arrayList.add(i.e(dux.get(38)));
                arrayList.add(i.e(dux.get(4)));
                arrayList.add(i.e(dux.get(39)));
                arrayList.add(i.e(dux.get(35)));
                arrayList.add(i.e(dux.get(5)));
                arrayList.add(i.e(dux.get(49)));
                break;
            case 13:
                arrayList.add(i.e(dux.get(35)));
                arrayList.add(i.e(dux.get(37)));
                break;
            case 16:
                arrayList.add(i.e(dux.get(5)));
                break;
            case 17:
            case 18:
                arrayList.add(i.e(dux.get(38)));
                arrayList.add(i.e(dux.get(4)));
                arrayList.add(i.e(dux.get(39)));
                arrayList.add(i.e(dux.get(35)));
                arrayList.add(i.e(dux.get(5)));
                arrayList.add(i.e(dux.get(49)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i jz(int i) {
        return i.e(dux.get(i));
    }
}
