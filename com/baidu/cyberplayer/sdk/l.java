package com.baidu.cyberplayer.sdk;

import com.baidu.searchbox.playerserver.PlayerPolicyManager;
/* loaded from: classes2.dex */
public class l {
    public static final l a = new l();

    public static l a() {
        return a;
    }

    public static void b() {
        if (o.m()) {
            PlayerPolicyManager.getInstance().update();
        }
    }

    public void a(String str) {
        d.a(str);
    }
}
