package com.baidu.live.r;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.e;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private long asL;
    private e.a asM;
    private List<String> asN;

    public static d wH() {
        return a.asO;
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
        if (this.asN != null) {
            this.asN.clear();
        }
        E(0L);
        this.asM = aVar;
        if (this.asM != null) {
            List<String> list = aVar.VN;
            if (list != null && !list.isEmpty()) {
                if (this.asN == null) {
                    this.asN = new ArrayList();
                }
                this.asN.addAll(list);
            }
            E(aVar.endTime - aVar.VM);
        }
    }

    public double aW(boolean z) {
        double d;
        if (this.asM == null) {
            return 0.0d;
        }
        if (z) {
            if (wI()) {
                d = Math.max(this.asM.VL, this.asM.VK);
            } else {
                d = this.asM.VK;
            }
        } else {
            d = wI() ? this.asM.VL : 0.0d;
        }
        if (d == 1.0d || d < 0.0d) {
            d = 0.0d;
        }
        return d;
    }

    public boolean wI() {
        return this.asL > 0;
    }

    public void wJ() {
        this.asL = 0L;
    }

    public void E(long j) {
        this.asL = j;
    }

    public boolean dH(String str) {
        if (this.asN == null || this.asN.isEmpty()) {
            return false;
        }
        return this.asN.contains(str);
    }

    public void release() {
        this.asL = 0L;
        if (this.asN != null) {
            this.asN.clear();
        }
        this.asM = null;
    }

    private d() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final d asO = new d();
    }
}
