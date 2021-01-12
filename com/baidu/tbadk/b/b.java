package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> eEm = new AtomicReference<>(null);
    private static final d eEn = bjr();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b eEo = new b();
    }

    public static b bjr() {
        return a.eEo;
    }
}
