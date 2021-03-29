package com.baidu.platform.comapi.wnplatform.o;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f10355a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static String f10356b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f10357c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public static int f10358d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f10359e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static BufferedReader f10360f = null;

    public static void a(Context context) {
        try {
            f10358d = 0;
            f10359e = 0;
            if (f10360f != null) {
                f10360f.close();
                f10360f = null;
            }
        } catch (Exception unused) {
        }
    }
}
