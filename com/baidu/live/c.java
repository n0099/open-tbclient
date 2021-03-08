package com.baidu.live;
/* loaded from: classes10.dex */
public class c {
    private static volatile c axE;
    private boolean axF;

    private c() {
    }

    public static c xe() {
        if (axE == null) {
            synchronized (d.class) {
                if (axE == null) {
                    axE = new c();
                }
            }
        }
        return axE;
    }

    public void aV(boolean z) {
        this.axF = z;
    }
}
