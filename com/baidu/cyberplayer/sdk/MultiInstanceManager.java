package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes3.dex */
public class MultiInstanceManager {
    public static volatile MediaInstanceManagerProvider a;

    public static MediaInstanceManagerProvider getInstance() {
        if (a == null) {
            synchronized (MediaInstanceManagerProvider.class) {
                if (a == null && f.a(1)) {
                    a = f.c();
                }
            }
        }
        return a;
    }
}
