package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> eIX = new AtomicReference<>(null);
    private static final d eIY = bnl();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b eIZ = new b();
    }

    public static b bnl() {
        return a.eIZ;
    }
}
