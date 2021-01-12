package com.baidu.swan.games.view.recommend.popview;

import com.baidu.swan.apps.storage.c.h;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class b {
    public static void putString(String str, String str2) {
        h.aLO().putString(str, str2);
    }

    public static String getString(String str) {
        return h.aLO().getString(str, null);
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    }
}
