package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> aFB = new AtomicReference<>(null);
    private static final d aFC = uU();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b aFD = new b();
    }

    public static b uU() {
        return a.aFD;
    }
}
