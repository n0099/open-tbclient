package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes17.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1353a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1353a == null) {
            f1353a = d.c();
        }
        return f1353a;
    }
}
