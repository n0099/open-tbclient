package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> Qq = new AtomicReference<>(null);
    private static final e Qr = np();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c Qs = new c();
    }

    public static c np() {
        return a.Qs;
    }
}
