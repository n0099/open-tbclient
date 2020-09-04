package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> dRu = new AtomicReference<>(null);
    private static final d dRv = ban();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dRw = new b();
    }

    public static b ban() {
        return a.dRw;
    }
}
