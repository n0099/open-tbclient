package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> eHX = new AtomicReference<>(null);
    private static final e eHY = bjQ();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c eHZ = new c();
    }

    public static c bjQ() {
        return a.eHZ;
    }
}
