package com.baidu.swan.menu;

import android.util.SparseArray;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n {
    private static SparseArray<j> bKd = new SparseArray<>();

    static {
        bKd.put(5, new j(5, f.C0263f.aiapp_menu_text_night_mode, f.c.aiapp_menu_item_nightmode, true));
        bKd.put(34, new j(34, f.C0263f.aiapp_menu_ai_apps_home_page, f.c.aiapp_menu_item_ai_apps_home_page_selector, true));
        bKd.put(35, new j(35, f.C0263f.aiapp_menu_add_launcher, f.c.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        bKd.put(39, new j(39, f.C0263f.aiapp_menu_restart, f.c.aiapp_menu_item_restart_selector, true));
        bKd.put(36, new j(36, f.C0263f.aiapp_menu_about, f.c.aiapp_menu_item_ai_apps_about_selector, true));
        bKd.put(4, new j(4, f.C0263f.aiapp_menu_text_share, f.c.aiapp_menu_item_share_arrow_selector, true));
        bKd.put(37, new j(37, f.C0263f.aiapp_menu_authority_management, f.c.aiapp_menu_item_ai_apps_authority_management_selector, true));
        bKd.put(9, new j(9, f.C0263f.aiapp_menu_text_feedback, f.c.aiapp_menu_item_feedback_selector, true));
        bKd.put(38, new j(38, f.C0263f.aiapp_menu_text_favorite, f.c.aiapp_menu_item_nightmode, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<j> gv(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                arrayList.add(j.d(bKd.get(4)));
                arrayList.add(j.d(bKd.get(36)));
                break;
            case 12:
                arrayList.add(j.d(bKd.get(4)));
                arrayList.add(j.d(bKd.get(34)));
                arrayList.add(j.d(bKd.get(39)));
                arrayList.add(j.d(bKd.get(36)));
                break;
            case 13:
                arrayList.add(j.d(bKd.get(37)));
                break;
            case 15:
                arrayList.add(j.d(bKd.get(4)));
                arrayList.add(j.d(bKd.get(39)));
                arrayList.add(j.d(bKd.get(36)));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j gw(int i) {
        return j.d(bKd.get(i));
    }
}
