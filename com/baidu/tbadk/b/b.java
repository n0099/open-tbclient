package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bzJ = new AtomicReference<>(null);
    private static final d bzK = Zh();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bzL = new b();
    }

    public static b Zh() {
        return a.bzL;
    }
}
