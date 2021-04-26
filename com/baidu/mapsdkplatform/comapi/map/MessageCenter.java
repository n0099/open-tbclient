package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
/* loaded from: classes2.dex */
public class MessageCenter {
    public static void registMessage(int i2, Handler handler) {
        com.baidu.mapsdkplatform.comjni.engine.a.a(i2, handler);
    }

    public static void unregistMessage(int i2, Handler handler) {
        com.baidu.mapsdkplatform.comjni.engine.a.b(i2, handler);
    }
}
