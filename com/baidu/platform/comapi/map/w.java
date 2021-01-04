package com.baidu.platform.comapi.map;

import android.util.Log;
/* loaded from: classes15.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    static boolean f4366a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        if (f4366a) {
            Log.d("MapTrace-" + str, "thread:" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + "," + str2);
        }
    }
}
