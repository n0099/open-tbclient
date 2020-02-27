package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> cJJ = new AtomicReference<>(null);
    private static final d cJK = ayv();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b cJL = new b();
    }

    public static b ayv() {
        return a.cJL;
    }
}
