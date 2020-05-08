package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> djg = new AtomicReference<>(null);
    private static final d djh = aGJ();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dji = new b();
    }

    public static b aGJ() {
        return a.dji;
    }
}
