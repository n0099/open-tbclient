package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f9913a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static String f9914b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f9915c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public static int f9916d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f9917e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static BufferedReader f9918f = null;

    public static void a(Context context) {
        try {
            f9916d = 0;
            f9917e = 0;
            if (f9918f != null) {
                f9918f.close();
                f9918f = null;
            }
        } catch (Exception unused) {
        }
    }
}
