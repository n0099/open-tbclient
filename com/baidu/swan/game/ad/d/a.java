package com.baidu.swan.game.ad.d;

import com.baidu.swan.game.ad.b.b;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.swan.game.ad.a.a aVar, b bVar) {
        if (aVar != null) {
            for (String str : aVar.k()) {
                a(k(str, 0, 0), bVar);
            }
            for (String str2 : aVar.l()) {
                a(k(str2, 0, 0), bVar);
            }
        }
    }

    public static void b(com.baidu.swan.game.ad.a.a aVar, b bVar) {
        if (aVar != null) {
            for (String str : aVar.QJ()) {
                a(k(str, 0, 0), bVar);
            }
        }
    }

    public static void c(com.baidu.swan.game.ad.a.a aVar, b bVar) {
        if (aVar != null) {
            for (String str : aVar.QK()) {
                a(k(str, 0, 0), bVar);
            }
        }
    }

    public static void d(com.baidu.swan.game.ad.a.a aVar, b bVar) {
        if (aVar != null) {
            for (String str : aVar.o()) {
                a(k(str, 0, 0), bVar);
            }
        }
    }

    public static void a(int i, int i2, com.baidu.swan.game.ad.a.a aVar, b bVar) {
        if (aVar != null) {
            for (String str : aVar.p()) {
                a(k(str, i, i2), bVar);
            }
        }
    }

    private static String k(String str, int i, int i2) {
        return str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0").replaceAll("%25%25cur_time%25%25", "" + i).replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
    }

    private static void a(String str, b bVar) {
        bVar.a(str);
    }
}
