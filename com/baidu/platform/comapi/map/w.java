package com.baidu.platform.comapi.map;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class w {
    static boolean a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        if (a) {
            Log.d("MapTrace-" + str, "thread:" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        }
    }
}
