package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> Qk = new AtomicReference<>(null);
    private static final d Ql = ns();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b Qm = new b();
    }

    public static b ns() {
        return a.Qm;
    }
}
