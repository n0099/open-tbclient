package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> QV = new AtomicReference<>(null);
    private static final d QW = nt();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b QX = new b();
    }

    public static b nt() {
        return a.QX;
    }
}
