package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class c implements e {
    public static final AtomicReference<e> dRt = new AtomicReference<>(null);
    private static final e dRu = bap();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static c dRv = new c();
    }

    public static c bap() {
        return a.dRv;
    }
}
