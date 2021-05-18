package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes2.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4850a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4850a == null) {
            f4850a = d.c();
        }
        return f4850a;
    }
}
