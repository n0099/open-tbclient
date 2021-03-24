package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4840a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4840a == null) {
            f4840a = d.c();
        }
        return f4840a;
    }
}
