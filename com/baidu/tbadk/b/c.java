package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bzM = new AtomicReference<>(null);
    private static final e bzN = Zj();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bzO = new c();
    }

    public static c Zj() {
        return a.bzO;
    }
}
