package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {
    public static MediaInstanceManagerProvider a;

    public static MediaInstanceManagerProvider getInstance() {
        if (a == null) {
            a = d.c();
        }
        return a;
    }
}
