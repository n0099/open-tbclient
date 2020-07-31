package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> dIm = new AtomicReference<>(null);
    private static final e dIn = aRY();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c dIo = new c();
    }

    public static c aRY() {
        return a.dIo;
    }
}
