package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4773a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4773a == null) {
            f4773a = d.c();
        }
        return f4773a;
    }
}
