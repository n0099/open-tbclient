package com.baidu.mapapi;

import android.content.Context;
/* loaded from: classes15.dex */
public class BMapManager {
    public static void destroy() {
        com.baidu.mapsdkplatform.comapi.a.a().d();
    }

    public static Context getContext() {
        return com.baidu.mapsdkplatform.comapi.a.a().e();
    }

    public static void init() {
        com.baidu.mapsdkplatform.comapi.a.a().b();
    }
}
