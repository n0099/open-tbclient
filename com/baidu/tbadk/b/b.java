package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> dxg = new AtomicReference<>(null);
    private static final d dxh = aMy();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b dxi = new b();
    }

    public static b aMy() {
        return a.dxi;
    }
}
