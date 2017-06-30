package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> PI = new AtomicReference<>(null);
    private static final d PJ = nr();

    private b() {
    }

    /* synthetic */ b(b bVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b PK = new b(null);
    }

    public static b nr() {
        return a.PK;
    }
}
