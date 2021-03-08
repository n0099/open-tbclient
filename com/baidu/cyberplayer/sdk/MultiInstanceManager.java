package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes4.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1390a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1390a == null) {
            f1390a = d.c();
        }
        return f1390a;
    }
}
