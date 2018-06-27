package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aai = new AtomicReference<>(null);
    private static final e aaj = rK();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c aak = new c();
    }

    public static c rK() {
        return a.aak;
    }
}
