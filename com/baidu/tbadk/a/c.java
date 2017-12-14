package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> QW = new AtomicReference<>(null);
    private static final e QX = nt();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c QY = new c();
    }

    public static c nt() {
        return a.QY;
    }
}
