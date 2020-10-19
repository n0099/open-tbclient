package com.baidu.swan.games.view.recommend.popview;

import com.baidu.swan.apps.storage.c.h;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes10.dex */
public class c {
    public static void putString(String str, String str2) {
        h.aGy().putString(str, str2);
    }

    public static String getString(String str) {
        return h.aGy().getString(str, null);
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    }
}
