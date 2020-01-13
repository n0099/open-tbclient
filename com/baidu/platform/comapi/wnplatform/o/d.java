package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes6.dex */
public class d {
    private static String a = d.class.getSimpleName();
    private static String b = null;
    private static Handler c = new Handler();
    private static int d = 0;
    private static int e = 0;
    private static BufferedReader f = null;

    public static void a(Context context) {
        try {
            d = 0;
            e = 0;
            if (f != null) {
                f.close();
                f = null;
            }
        } catch (Exception e2) {
        }
    }
}
