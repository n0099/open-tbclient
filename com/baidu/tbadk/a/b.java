package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> QT = new AtomicReference<>(null);
    private static final d QU = nr();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b QV = new b();
    }

    public static b nr() {
        return a.QV;
    }
}
