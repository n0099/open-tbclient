package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bSV = new AtomicReference<>(null);
    private static final d bSW = aeW();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bSX = new b();
    }

    public static b aeW() {
        return a.bSX;
    }
}
