package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> ahY = new AtomicReference<>(null);
    private static final d ahZ = uR();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b aia = new b();
    }

    public static b uR() {
        return a.aia;
    }
}
