package com.baidu.adp.framework;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class d {
    private static d a = null;
    private int b;

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
        this.b = 0;
        this.b = (int) System.currentTimeMillis();
    }

    public synchronized int b() {
        int i;
        if (this.b <= 100000) {
            this.b = SapiErrorCode.DB_GATE_COMMUNICATION_ERROR;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}
