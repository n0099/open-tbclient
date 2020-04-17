package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> djc = new AtomicReference<>(null);
    private static final d djd = aGL();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dje = new b();
    }

    public static b aGL() {
        return a.dje;
    }
}
