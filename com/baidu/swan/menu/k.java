package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class k {
    private static SparseArray<i> cvD = new SparseArray<>();

    static {
        cvD.put(5, new i(5, g.f.aiapp_menu_text_night_mode, g.c.aiapp_menu_item_nightmode, true));
        cvD.put(35, new i(35, g.f.aiapp_menu_add_launcher, g.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        cvD.put(39, new i(39, g.f.aiapp_menu_restart, g.c.aiapp_menu_item_restart_selector, true));
        cvD.put(36, new i(36, g.f.aiapp_menu_about, g.c.aiapp_menu_item_ai_apps_about_selector, true));
        cvD.put(4, new i(4, g.f.aiapp_menu_text_share, g.c.aiapp_menu_item_share_arrow_selector, true));
        cvD.put(37, new i(37, g.f.aiapp_menu_authority_management, g.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        cvD.put(38, new i(38, g.f.aiapp_menu_text_favorite, g.c.aiapp_menu_item_add_fav_selector, true));
        cvD.put(40, new i(40, g.f.aiapp_menu_swan_center, g.c.aiapp_menu_item_swan_center_selector, true));
        cvD.put(42, new i(42, g.f.aiapp_menu_game_restart, g.c.aiapp_menu_item_restart_selector, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: if  reason: not valid java name */
    public static List<i> m25if(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(i.f(cvD.get(38)));
                arrayList.add(i.f(cvD.get(5)));
                arrayList.add(i.f(cvD.get(4)));
                arrayList.add(i.f(cvD.get(35)));
                arrayList.add(i.f(cvD.get(42)));
                arrayList.add(i.f(cvD.get(36)));
                break;
            case 12:
            case 15:
                arrayList.add(i.f(cvD.get(38)));
                arrayList.add(i.f(cvD.get(4)));
                arrayList.add(i.f(cvD.get(39)));
                arrayList.add(i.f(cvD.get(35)));
                arrayList.add(i.f(cvD.get(5)));
                arrayList.add(i.f(cvD.get(40)));
                arrayList.add(i.f(cvD.get(36)));
                break;
            case 13:
                arrayList.add(i.f(cvD.get(35)));
                arrayList.add(i.f(cvD.get(37)));
                break;
            case 16:
                arrayList.add(i.f(cvD.get(5)));
                break;
            case 17:
            case 18:
                arrayList.add(i.f(cvD.get(38)));
                arrayList.add(i.f(cvD.get(4)));
                arrayList.add(i.f(cvD.get(39)));
                arrayList.add(i.f(cvD.get(35)));
                arrayList.add(i.f(cvD.get(5)));
                arrayList.add(i.f(cvD.get(36)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i ig(int i) {
        return i.f(cvD.get(i));
    }
}
