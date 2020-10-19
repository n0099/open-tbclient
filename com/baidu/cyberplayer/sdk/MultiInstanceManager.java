package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes12.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    private static MediaInstanceManagerProvider f1352a = null;

    public static MediaInstanceManagerProvider getInstance() {
        if (f1352a == null) {
            f1352a = d.c();
        }
        return f1352a;
    }
}
