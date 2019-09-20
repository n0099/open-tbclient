package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bBe = new AtomicReference<>(null);
    private static final d bBf = aak();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bBg = new b();
    }

    public static b aak() {
        return a.bBg;
    }
}
