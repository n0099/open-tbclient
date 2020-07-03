package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> dCm = new AtomicReference<>(null);
    private static final d dCn = aOb();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dCo = new b();
    }

    public static b aOb() {
        return a.dCo;
    }
}
