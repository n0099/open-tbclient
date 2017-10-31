package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> QC = new AtomicReference<>(null);
    private static final d QD = nq();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b QE = new b();
    }

    public static b nq() {
        return a.QE;
    }
}
