package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4750a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4750a == null) {
            f4750a = d.c();
        }
        return f4750a;
    }
}
