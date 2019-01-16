package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> alX = new AtomicReference<>(null);
    private static final e alY = we();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c alZ = new c();
    }

    public static c we() {
        return a.alZ;
    }
}
