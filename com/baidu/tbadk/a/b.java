package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> ahl = new AtomicReference<>(null);
    private static final d ahm = uH();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b ahn = new b();
    }

    public static b uH() {
        return a.ahn;
    }
}
