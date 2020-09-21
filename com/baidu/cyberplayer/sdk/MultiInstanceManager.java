package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes10.dex */
public class MultiInstanceManager {
    private static MediaInstanceManagerProvider a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (a == null) {
            a = d.c();
        }
        return a;
    }
}
