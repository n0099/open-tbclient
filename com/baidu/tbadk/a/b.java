package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> RW = new AtomicReference<>(null);
    private static final d RX = oo();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b RY = new b();
    }

    public static b oo() {
        return a.RY;
    }
}
