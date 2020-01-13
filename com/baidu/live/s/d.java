package com.baidu.live.s;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.e;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private long atx;
    private e.a aty;
    private List<String> atz;

    public static d wY() {
        return a.atA;
    }

    public void c(long j, long j2, int i) {
        g gVar = new g();
        gVar.setId(i);
        gVar.addParam("benefit_userid", j);
        gVar.addParam("live_id", j2);
        gVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(gVar);
    }

    public void a(e.a aVar) {
        if (this.atz != null) {
            this.atz.clear();
        }
        E(0L);
        this.aty = aVar;
        if (this.aty != null) {
            List<String> list = aVar.Wc;
            if (list != null && !list.isEmpty()) {
                if (this.atz == null) {
                    this.atz = new ArrayList();
                }
                this.atz.addAll(list);
            }
            E(aVar.endTime - aVar.currentTime);
        }
    }

    public double aY(boolean z) {
        double d;
        if (this.aty == null) {
            return 0.0d;
        }
        if (z) {
            if (wZ()) {
                d = Math.max(this.aty.Wb, this.aty.Wa);
            } else {
                d = this.aty.Wa;
            }
        } else {
            d = wZ() ? this.aty.Wb : 0.0d;
        }
        if (d == 1.0d || d < 0.0d) {
            d = 0.0d;
        }
        return d;
    }

    public boolean wZ() {
        return this.atx > 0;
    }

    public void xa() {
        this.atx = 0L;
    }

    public void E(long j) {
        this.atx = j;
    }

    public boolean dJ(String str) {
        if (this.atz == null || this.atz.isEmpty()) {
            return false;
        }
        return this.atz.contains(str);
    }

    public void release() {
        this.atx = 0L;
        if (this.atz != null) {
            this.atz.clear();
        }
        this.aty = null;
    }

    private d() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final d atA = new d();
    }
}
