package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bTM = new AtomicReference<>(null);
    private static final d bTN = aeY();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bTO = new b();
    }

    public static b aeY() {
        return a.bTO;
    }
}
