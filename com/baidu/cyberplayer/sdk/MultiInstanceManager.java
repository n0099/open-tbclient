package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4841a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4841a == null) {
            f4841a = d.c();
        }
        return f4841a;
    }
}
