package com.baidu.nps.utils;

import android.app.Application;
import d.b.z.c.a.b;
/* loaded from: classes2.dex */
public class ContextHolder {
    public static Application sApplicationContext = b.b().a();

    public static Application getApplicationContext() {
        return sApplicationContext;
    }

    public static void setApplicationContext(Application application) {
        sApplicationContext = application;
    }
}
