package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes5.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1719a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1719a == null) {
            f1719a = d.c();
        }
        return f1719a;
    }
}
