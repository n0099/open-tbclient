package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> eod = new AtomicReference<>(null);
    private static final d eoe = bfI();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b eog = new b();
    }

    public static b bfI() {
        return a.eog;
    }
}
