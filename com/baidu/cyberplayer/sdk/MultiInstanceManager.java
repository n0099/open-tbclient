package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes4.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1717a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1717a == null) {
            f1717a = d.c();
        }
        return f1717a;
    }
}
