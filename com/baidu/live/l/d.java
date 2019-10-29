package com.baidu.live.l;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.c;
import com.baidu.live.message.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private long akZ;
    private c.a ala;
    private List<String> alb;

    public static d uI() {
        return a.alc;
    }

    public void c(long j, long j2, int i) {
        e eVar = new e();
        eVar.setId(i);
        eVar.addParam("benefit_userid", j);
        eVar.addParam("live_id", j2);
        eVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(eVar);
    }

    public void a(c.a aVar) {
        if (this.alb != null) {
            this.alb.clear();
        }
        D(0L);
        this.ala = aVar;
        if (this.ala != null) {
            List<String> list = aVar.Pq;
            if (list != null && !list.isEmpty()) {
                if (this.alb == null) {
                    this.alb = new ArrayList();
                }
                this.alb.addAll(list);
            }
            D(aVar.endTime - aVar.Pp);
        }
    }

    public double aF(boolean z) {
        double d;
        if (this.ala == null) {
            return 0.0d;
        }
        if (z) {
            if (uJ()) {
                d = Math.max(this.ala.Po, this.ala.Pn);
            } else {
                d = this.ala.Pn;
            }
        } else {
            d = uJ() ? this.ala.Po : 0.0d;
        }
        if (d == 1.0d || d < 0.0d) {
            d = 0.0d;
        }
        return d;
    }

    public boolean uJ() {
        return this.akZ > 0;
    }

    public void uK() {
        this.akZ = 0L;
    }

    public void D(long j) {
        this.akZ = j;
    }

    public boolean cO(String str) {
        if (this.alb == null || this.alb.isEmpty()) {
            return false;
        }
        return this.alb.contains(str);
    }

    public void release() {
        this.akZ = 0L;
        if (this.alb != null) {
            this.alb.clear();
        }
        this.ala = null;
    }

    private d() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final d alc = new d();
    }
}
