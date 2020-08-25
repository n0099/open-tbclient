package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class b implements d {
    public static final AtomicReference<d> dRq = new AtomicReference<>(null);
    private static final d dRr = ban();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static b dRs = new b();
    }

    public static b ban() {
        return a.dRs;
    }
}
