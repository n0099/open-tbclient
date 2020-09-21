package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> dTE = new AtomicReference<>(null);
    private static final d dTF = bbh();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dTG = new b();
    }

    public static b bbh() {
        return a.dTG;
    }
}
