package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> cJW = new AtomicReference<>(null);
    private static final d cJX = ayA();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b cJY = new b();
    }

    public static b ayA() {
        return a.cJY;
    }
}
