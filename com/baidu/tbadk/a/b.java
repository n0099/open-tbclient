package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> aaf = new AtomicReference<>(null);
    private static final d aag = rI();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b aah = new b();
    }

    public static b rI() {
        return a.aah;
    }
}
