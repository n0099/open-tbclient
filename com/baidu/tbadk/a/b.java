package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> Qn = new AtomicReference<>(null);
    private static final d Qo = nn();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b Qp = new b();
    }

    public static b nn() {
        return a.Qp;
    }
}
