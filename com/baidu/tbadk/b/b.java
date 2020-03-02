package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> cJK = new AtomicReference<>(null);
    private static final d cJL = ayx();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b cJM = new b();
    }

    public static b ayx() {
        return a.cJM;
    }
}
