package com.baidu.swan.game.ad.d;

import com.baidu.swan.game.ad.a.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes9.dex */
public class a {
    public static void a(AdElementInfo adElementInfo, b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.ahG()) {
                a(l(str, 0, 0), bVar);
            }
            for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
                a(l(str2, 0, 0), bVar);
            }
        }
    }

    public static void b(AdElementInfo adElementInfo, b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getThirdClickTrackingUrls()) {
                a(l(str, 0, 0), bVar);
            }
        }
    }

    public static void c(AdElementInfo adElementInfo, b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getStartTrackers()) {
                a(l(str, 0, 0), bVar);
            }
        }
    }

    public static void d(AdElementInfo adElementInfo, b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getSkipTrackers()) {
                a(l(str, 0, 0), bVar);
            }
        }
    }

    public static void a(int i, int i2, AdElementInfo adElementInfo, b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getCloseTrackers()) {
                a(l(str, i, i2), bVar);
            }
        }
    }

    private static String l(String str, int i, int i2) {
        return str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0").replaceAll("%25%25cur_time%25%25", "" + i).replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
    }

    private static void a(String str, b bVar) {
        bVar.nr(str);
    }
}
