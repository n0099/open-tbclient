package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes17.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1354a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1354a == null) {
            f1354a = d.c();
        }
        return f1354a;
    }
}
