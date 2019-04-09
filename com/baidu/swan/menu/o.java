package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    private static final boolean DEBUG = a.DEBUG;
    private static SparseArray<k> bkW = new SparseArray<>();

    static {
        bkW.put(5, new k(5, g.f.aiapp_menu_text_night_mode, g.c.aiapp_menu_item_nightmode, true));
        bkW.put(34, new k(34, g.f.aiapp_menu_ai_apps_home_page, g.c.aiapp_menu_item_ai_apps_home_page_selector, true));
        bkW.put(35, new k(35, g.f.aiapp_menu_add_launcher, g.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        bkW.put(39, new k(39, g.f.aiapp_menu_restart, g.c.aiapp_menu_item_restart_selector, true));
        bkW.put(36, new k(36, g.f.aiapp_menu_about, g.c.aiapp_menu_item_ai_apps_about_selector, true));
        bkW.put(4, new k(4, g.f.aiapp_menu_text_share, g.c.aiapp_menu_item_share_arrow_selector, true));
        bkW.put(37, new k(37, g.f.aiapp_menu_authority_management, g.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        bkW.put(9, new k(9, g.f.aiapp_menu_text_feedback, g.c.aiapp_menu_item_feedback_selector, true));
        bkW.put(38, new k(38, g.f.aiapp_menu_text_favorite, g.c.aiapp_menu_item_nightmode, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<k> eX(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(k.d(bkW.get(38)));
                arrayList.add(k.d(bkW.get(5)));
                arrayList.add(k.d(bkW.get(4)));
                arrayList.add(k.d(bkW.get(35)));
                arrayList.add(k.d(bkW.get(36)));
                break;
            case 12:
                arrayList.add(k.d(bkW.get(38)));
                arrayList.add(k.d(bkW.get(5)));
                arrayList.add(k.d(bkW.get(4)));
                arrayList.add(k.d(bkW.get(34)));
                arrayList.add(k.d(bkW.get(35)));
                arrayList.add(k.d(bkW.get(39)));
                arrayList.add(k.d(bkW.get(36)));
                break;
            case 13:
                arrayList.add(k.d(bkW.get(37)));
                arrayList.add(k.d(bkW.get(35)));
                arrayList.add(k.d(bkW.get(9)));
                break;
            case 15:
                arrayList.add(k.d(bkW.get(38)));
                arrayList.add(k.d(bkW.get(5)));
                arrayList.add(k.d(bkW.get(4)));
                arrayList.add(k.d(bkW.get(35)));
                arrayList.add(k.d(bkW.get(39)));
                arrayList.add(k.d(bkW.get(36)));
                break;
            case 16:
                arrayList.add(k.d(bkW.get(5)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k eY(int i) {
        return k.d(bkW.get(i));
    }
}
