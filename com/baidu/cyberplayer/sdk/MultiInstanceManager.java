package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes6.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1768a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1768a == null) {
            f1768a = d.c();
        }
        return f1768a;
    }
}
