package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4996a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4996a == null) {
            f4996a = d.c();
        }
        return f4996a;
    }
}
