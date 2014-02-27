package com.baidu.adp.framework;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class e {
    private static e a = null;
    private int b;

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private e() {
        this.b = 0;
        this.b = (int) System.currentTimeMillis();
    }

    public final synchronized int b() {
        int i;
        if (this.b >= 0 && this.b <= 100000) {
            this.b = SapiErrorCode.DB_GATE_COMMUNICATION_ERROR;
        }
        i = this.b;
        this.b = i + 1;
        return i;
    }
}
