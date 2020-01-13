package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> cFF = new AtomicReference<>(null);
    private static final d cFG = awi();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b cFH = new b();
    }

    public static b awi() {
        return a.cFH;
    }
}
