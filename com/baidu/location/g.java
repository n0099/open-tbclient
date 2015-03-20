package com.baidu.location;

import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
class g implements a0, n {
    private static g bt = null;
    public boolean bu = false;
    public long br = 0;
    private long bq = 0;
    private long bs = 0;

    private g() {
    }

    public static g h() {
        if (bt == null) {
            bt = new g();
        }
        return bt;
    }

    public void i() {
        if (this.bu) {
            return;
        }
        this.bq = System.currentTimeMillis();
    }

    /* renamed from: new  reason: not valid java name */
    public long m289new(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e) {
            return -1L;
        }
    }

    /* renamed from: try  reason: not valid java name */
    public void m290try(String str) {
        if (this.bu) {
            return;
        }
        this.bs = System.currentTimeMillis();
        long j = (this.bs - this.bq) / 2;
        if (j > 3000 || j < 0) {
            return;
        }
        long m289new = m289new(str);
        if (m289new > 0) {
            this.br = (j + m289new) - System.currentTimeMillis();
            this.bu = false;
        }
    }
}
