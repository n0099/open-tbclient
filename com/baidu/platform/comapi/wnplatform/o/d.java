package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f10354a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static String f10355b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10356c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public static int f10357d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f10358e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static BufferedReader f10359f = null;

    public static void a(Context context) {
        try {
            f10357d = 0;
            f10358e = 0;
            if (f10359f != null) {
                f10359f.close();
                f10359f = null;
            }
        } catch (Exception unused) {
        }
    }
}
