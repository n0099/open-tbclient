package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f10281a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static String f10282b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10283c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public static int f10284d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f10285e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static BufferedReader f10286f = null;

    public static void a(Context context) {
        try {
            f10284d = 0;
            f10285e = 0;
            if (f10286f != null) {
                f10286f.close();
                f10286f = null;
            }
        } catch (Exception unused) {
        }
    }
}
