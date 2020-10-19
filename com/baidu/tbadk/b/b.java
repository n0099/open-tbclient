package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> efF = new AtomicReference<>(null);
    private static final d efG = bdP();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b efH = new b();
    }

    public static b bdP() {
        return a.efH;
    }
}
