package com.baidu.mobads;

import android.content.Context;
import android.os.Looper;
/* loaded from: classes2.dex */
public class CpuInfoManager {

    /* loaded from: classes2.dex */
    public interface UrlListener {
        void onUrl(String str);
    }

    public static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.baidu.mobads.f.c.a().a((com.baidu.mobads.f.a) new m(runnable));
        } else {
            runnable.run();
        }
    }

    public static void getCpuInfoUrl(Context context, String str, int i, UrlListener urlListener) {
        a(new k(context, i, str, urlListener));
    }
}
