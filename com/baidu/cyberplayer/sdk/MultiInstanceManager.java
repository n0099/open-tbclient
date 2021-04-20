package com.baidu.cyberplayer.sdk;
@Keep
/* loaded from: classes.dex */
public class MultiInstanceManager {

    /* renamed from: a  reason: collision with root package name */
    public static MediaInstanceManagerProvider f4876a;

    public static MediaInstanceManagerProvider getInstance() {
        if (f4876a == null) {
            f4876a = d.c();
        }
        return f4876a;
    }
}
