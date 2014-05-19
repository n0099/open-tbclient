package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* loaded from: classes.dex */
public class f extends MediaPlayer implements c {
    private static Object a = new Object();
    private static f b = null;
    private boolean c = false;
    private boolean d = true;
    private int e = -1;

    private f() {
    }

    public static f b() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int a() {
        return getCurrentPosition();
    }
}
