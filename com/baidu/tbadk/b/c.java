package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> cFw = new AtomicReference<>(null);
    private static final e cFx = avR();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c cFy = new c();
    }

    public static c avR() {
        return a.cFy;
    }
}
