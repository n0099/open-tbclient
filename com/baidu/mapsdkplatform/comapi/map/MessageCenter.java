package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
/* loaded from: classes4.dex */
public class MessageCenter {
    public static void registMessage(int i, Handler handler) {
        com.baidu.mapsdkplatform.comjni.engine.a.a(i, handler);
    }

    public static void unregistMessage(int i, Handler handler) {
        com.baidu.mapsdkplatform.comjni.engine.a.b(i, handler);
    }
}
