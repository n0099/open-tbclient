package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> efI = new AtomicReference<>(null);
    private static final e efJ = bdR();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c efK = new c();
    }

    public static c bdR() {
        return a.efK;
    }
}
