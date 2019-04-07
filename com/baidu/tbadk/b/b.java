package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bsF = new AtomicReference<>(null);
    private static final d bsG = UD();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bsH = new b();
    }

    public static b UD() {
        return a.bsH;
    }
}
