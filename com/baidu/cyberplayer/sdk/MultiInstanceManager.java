package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes6.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1769a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1769a == null) {
            f1769a = d.c();
        }
        return f1769a;
    }
}
