package com.baidu.live.l;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.c;
import com.baidu.live.message.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private long akH;
    private c.a akI;
    private List<String> akJ;

    public static d uJ() {
        return a.akK;
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
        if (this.akJ != null) {
            this.akJ.clear();
        }
        C(0L);
        this.akI = aVar;
        if (this.akI != null) {
            List<String> list = aVar.OP;
            if (list != null && !list.isEmpty()) {
                if (this.akJ == null) {
                    this.akJ = new ArrayList();
                }
                this.akJ.addAll(list);
            }
            C(aVar.endTime - aVar.OO);
        }
    }

    public double aF(boolean z) {
        double d;
        if (this.akI == null) {
            return 0.0d;
        }
        if (z) {
            if (uK()) {
                d = Math.max(this.akI.OM, this.akI.OL);
            } else {
                d = this.akI.OL;
            }
        } else {
            d = uK() ? this.akI.OM : 0.0d;
        }
        if (d == 1.0d || d < 0.0d) {
            d = 0.0d;
        }
        return d;
    }

    public boolean uK() {
        return this.akH > 0;
    }

    public void uL() {
        this.akH = 0L;
    }

    public void C(long j) {
        this.akH = j;
    }

    public boolean cO(String str) {
        if (this.akJ == null || this.akJ.isEmpty()) {
            return false;
        }
        return this.akJ.contains(str);
    }

    public void release() {
        this.akH = 0L;
        if (this.akJ != null) {
            this.akJ.clear();
        }
        this.akI = null;
    }

    private d() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final d akK = new d();
    }
}
