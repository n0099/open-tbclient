package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long axN;
    private f.a axO;
    private List<String> axP;

    public static d zq() {
        return a.axQ;
    }

    public void c(long j, long j2, int i) {
        g gVar = new g();
        gVar.setId(i);
        gVar.addParam("benefit_userid", j);
        gVar.addParam("live_id", j2);
        gVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(gVar);
    }

    public void b(f.a aVar) {
        if (this.axP != null) {
            this.axP.clear();
        }
        I(0L);
        this.axO = aVar;
        if (this.axO != null) {
            List<String> list = aVar.XN;
            if (list != null && !list.isEmpty()) {
                if (this.axP == null) {
                    this.axP = new ArrayList();
                }
                this.axP.addAll(list);
            }
            I(aVar.endTime - aVar.currentTime);
        }
    }

    public double e(boolean z, String str) {
        double a2;
        if (this.axO == null || this.axO.XK != 1) {
            return 0.0d;
        }
        if (z) {
            if (zr()) {
                a2 = Math.max(a(str, this.axO.XM), a(str, this.axO.XL));
            } else {
                a2 = a(str, this.axO.XL);
            }
        } else {
            a2 = zr() ? a(str, this.axO.XM) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.axO != null) {
            if (this.axO.XO != null && !this.axO.XO.isEmpty()) {
                for (String str2 : this.axO.XO) {
                    if (str.equals(str2)) {
                        return d;
                    }
                }
            } else {
                return d;
            }
        }
        return 0.0d;
    }

    public boolean zr() {
        return this.axN > 0;
    }

    public void zs() {
        this.axN = 0L;
    }

    public void I(long j) {
        this.axN = j;
    }

    public boolean dY(String str) {
        if (this.axP == null || this.axP.isEmpty()) {
            return false;
        }
        return this.axP.contains(str);
    }

    public void release() {
        this.axN = 0L;
        if (this.axP != null) {
            this.axP.clear();
        }
        this.axO = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d axQ = new d();
    }
}
