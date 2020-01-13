package com.baidu.swan.games.view.recommend.popview;

import com.baidu.android.util.time.DateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes10.dex */
public class c {
    public static void putString(String str, String str2) {
        a.aoS().putString(str, str2);
    }

    public static String getString(String str) {
        return a.aoS().getString(str, null);
    }

    /* loaded from: classes10.dex */
    private static class a extends com.baidu.swan.d.e {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.games.view.recommend.popview.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0343a {
            private static final a cqG = new a();
        }

        private a() {
            super("com.baidu.searchbox.game_guide");
        }

        public static final a aoS() {
            return C0343a.cqG;
        }
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat(DateTimeUtil.DATE_FORMAT_CN).format(new Date(System.currentTimeMillis()));
    }
}
