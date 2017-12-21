package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> QX = new AtomicReference<>(null);
    private static final e QY = nt();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c QZ = new c();
    }

    public static c nt() {
        return a.QZ;
    }
}
