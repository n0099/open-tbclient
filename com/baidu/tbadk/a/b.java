package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> alA = new AtomicReference<>(null);
    private static final d alB = vV();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b alC = new b();
    }

    public static b vV() {
        return a.alC;
    }
}
