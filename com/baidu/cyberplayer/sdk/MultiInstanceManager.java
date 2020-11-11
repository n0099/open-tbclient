package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes12.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1351a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1351a == null) {
            f1351a = d.c();
        }
        return f1351a;
    }
}
