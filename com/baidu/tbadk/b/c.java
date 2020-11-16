package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> esu = new AtomicReference<>(null);
    private static final e esv = bhE();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c esw = new c();
    }

    public static c bhE() {
        return a.esw;
    }
}
