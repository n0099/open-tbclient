package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> dTH = new AtomicReference<>(null);
    private static final e dTI = bbj();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c dTJ = new c();
    }

    public static c bbj() {
        return a.dTJ;
    }
}
