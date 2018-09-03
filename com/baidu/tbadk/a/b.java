package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> ZK = new AtomicReference<>(null);
    private static final d ZL = rr();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b ZM = new b();
    }

    public static b rr() {
        return a.ZM;
    }
}
