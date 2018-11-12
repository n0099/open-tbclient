package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aib = new AtomicReference<>(null);
    private static final e aic = uT();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c aid = new c();
    }

    public static c uT() {
        return a.aid;
    }
}
