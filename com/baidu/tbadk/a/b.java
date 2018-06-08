package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> aac = new AtomicReference<>(null);
    private static final d aad = rI();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b aae = new b();
    }

    public static b rI() {
        return a.aae;
    }
}
