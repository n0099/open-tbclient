package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes12.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1349a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1349a == null) {
            f1349a = d.c();
        }
        return f1349a;
    }
}
