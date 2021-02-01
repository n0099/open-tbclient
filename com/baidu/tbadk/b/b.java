package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> eGt = new AtomicReference<>(null);
    private static final d eGu = bjM();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b eGv = new b();
    }

    public static b bjM() {
        return a.eGv;
    }
}
