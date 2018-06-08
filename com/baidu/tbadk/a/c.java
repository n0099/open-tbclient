package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aaf = new AtomicReference<>(null);
    private static final e aag = rK();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c aah = new c();
    }

    public static c rK() {
        return a.aah;
    }
}
