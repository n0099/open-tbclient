package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* loaded from: classes.dex */
public final class g extends MediaPlayer implements d {
    private static Object a = new Object();
    private static g b = null;
    private boolean c = false;
    private boolean d = true;
    private int e = -1;

    private g() {
    }

    public static g b() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    @Override // com.baidu.tbadk.core.voice.service.d
    public final int a() {
        return getCurrentPosition();
    }
}
