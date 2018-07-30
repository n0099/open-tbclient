package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> ZM = new AtomicReference<>(null);
    private static final e ZN = rv();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c ZO = new c();
    }

    public static c rv() {
        return a.ZO;
    }
}
