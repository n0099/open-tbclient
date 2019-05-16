package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n {
    private static SparseArray<j> bqY = new SparseArray<>();

    static {
        bqY.put(5, new j(5, f.C0225f.aiapp_menu_text_night_mode, f.c.aiapp_menu_item_nightmode, true));
        bqY.put(34, new j(34, f.C0225f.aiapp_menu_ai_apps_home_page, f.c.aiapp_menu_item_ai_apps_home_page_selector, true));
        bqY.put(35, new j(35, f.C0225f.aiapp_menu_add_launcher, f.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        bqY.put(39, new j(39, f.C0225f.aiapp_menu_restart, f.c.aiapp_menu_item_restart_selector, true));
        bqY.put(36, new j(36, f.C0225f.aiapp_menu_about, f.c.aiapp_menu_item_ai_apps_about_selector, true));
        bqY.put(4, new j(4, f.C0225f.aiapp_menu_text_share, f.c.aiapp_menu_item_share_arrow_selector, true));
        bqY.put(37, new j(37, f.C0225f.aiapp_menu_authority_management, f.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        bqY.put(9, new j(9, f.C0225f.aiapp_menu_text_feedback, f.c.aiapp_menu_item_feedback_selector, true));
        bqY.put(38, new j(38, f.C0225f.aiapp_menu_text_favorite, f.c.aiapp_menu_item_nightmode, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<j> fw(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(j.d(bqY.get(4)));
                arrayList.add(j.d(bqY.get(36)));
                break;
            case 12:
                arrayList.add(j.d(bqY.get(4)));
                arrayList.add(j.d(bqY.get(34)));
                arrayList.add(j.d(bqY.get(39)));
                arrayList.add(j.d(bqY.get(36)));
                break;
            case 13:
                arrayList.add(j.d(bqY.get(37)));
                break;
            case 15:
                arrayList.add(j.d(bqY.get(4)));
                arrayList.add(j.d(bqY.get(39)));
                arrayList.add(j.d(bqY.get(36)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j fx(int i) {
        return j.d(bqY.get(i));
    }
}
