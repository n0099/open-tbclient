package com.baidu.swan.games.view.recommend.popview;

import com.baidu.swan.e.f;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes11.dex */
public class c {
    public static void putString(String str, String str2) {
        a.aEu().putString(str, str2);
    }

    public static String getString(String str) {
        return a.aEu().getString(str, null);
    }

    /* loaded from: classes11.dex */
    private static class a extends f {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.games.view.recommend.popview.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0451a {
            private static final a djM = new a();
        }

        private a() {
            super("com.baidu.searchbox.game_guide");
        }

        public static final a aEu() {
            return C0451a.djM;
        }
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    }
}
