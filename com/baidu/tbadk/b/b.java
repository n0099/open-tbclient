package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> eHU = new AtomicReference<>(null);
    private static final d eHV = bjO();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b eHW = new b();
    }

    public static b bjO() {
        return a.eHW;
    }
}
