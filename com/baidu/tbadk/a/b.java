package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> aFD = new AtomicReference<>(null);
    private static final d aFE = uV();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b aFF = new b();
    }

    public static b uV() {
        return a.aFF;
    }
}
