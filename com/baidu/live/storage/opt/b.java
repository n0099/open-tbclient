package com.baidu.live.storage.opt;

import com.baidu.live.d;
import com.baidu.live.storage.opt.a.a;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.live.storage.opt.a.a bBu;
    private com.baidu.live.storage.opt.a bBv;
    private volatile boolean boI;
    private volatile long mQuota;

    /* renamed from: com.baidu.live.storage.opt.b$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 extends a.AbstractC0199a {
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b Rg() {
        return a.bBw;
    }

    public synchronized boolean G(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.boI && this.mQuota > 0 && this.bBv != null) {
                try {
                    z = this.bBv.a(this.mQuota, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    public void release() {
        if (this.bBv != null) {
            this.bBv.release();
        }
        if (this.bBu != null) {
            this.bBu.release();
        }
        this.boI = false;
    }

    private b() {
        this.mQuota = d.xc().getLong("storage_opt_quota", 0L);
        this.bBv = new c();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final b bBw = new b(null);
    }
}
