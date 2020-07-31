package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> dIj = new AtomicReference<>(null);
    private static final d dIk = aRW();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dIl = new b();
    }

    public static b aRW() {
        return a.dIl;
    }
}
