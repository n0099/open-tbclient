package com.baidu.platform.comapi.wnplatform.p;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f3142a = d.class.getSimpleName();
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
