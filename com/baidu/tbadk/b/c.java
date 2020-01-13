package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> cFI = new AtomicReference<>(null);
    private static final e cFJ = awk();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c cFK = new c();
    }

    public static c awk() {
        return a.cFK;
    }
}
