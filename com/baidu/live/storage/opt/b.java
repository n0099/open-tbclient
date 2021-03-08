package com.baidu.live.storage.opt;

import com.baidu.live.d;
import com.baidu.live.storage.opt.a.a;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.live.storage.opt.a.a bCU;
    private com.baidu.live.storage.opt.a bCV;
    private volatile boolean bqi;
    private volatile long mQuota;

    /* renamed from: com.baidu.live.storage.opt.b$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 extends a.AbstractC0205a {
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b Rj() {
        return a.bCW;
    }

    public synchronized boolean I(Object obj) {
        boolean z = true;
        synchronized (this) {
            if (this.bqi && this.mQuota > 0 && this.bCV != null) {
                try {
                    z = this.bCV.a(this.mQuota, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    public void release() {
        if (this.bCV != null) {
            this.bCV.release();
        }
        if (this.bCU != null) {
            this.bCU.release();
        }
        this.bqi = false;
    }

    private b() {
        this.mQuota = d.xf().getLong("storage_opt_quota", 0L);
        this.bCV = new c();
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final b bCW = new b(null);
    }
}
