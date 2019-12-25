package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> cFt = new AtomicReference<>(null);
    private static final d cFu = avP();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b cFv = new b();
    }

    public static b avP() {
        return a.cFv;
    }
}
