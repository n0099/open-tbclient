package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long axO;
    private f.a axP;
    private List<String> axQ;

    public static d zs() {
        return a.axR;
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
        if (this.axQ != null) {
            this.axQ.clear();
        }
        I(0L);
        this.axP = aVar;
        if (this.axP != null) {
            List<String> list = aVar.XN;
            if (list != null && !list.isEmpty()) {
                if (this.axQ == null) {
                    this.axQ = new ArrayList();
                }
                this.axQ.addAll(list);
            }
            I(aVar.endTime - aVar.currentTime);
        }
    }

    public double e(boolean z, String str) {
        double a2;
        if (this.axP == null || this.axP.XK != 1) {
            return 0.0d;
        }
        if (z) {
            if (zt()) {
                a2 = Math.max(a(str, this.axP.XM), a(str, this.axP.XL));
            } else {
                a2 = a(str, this.axP.XL);
            }
        } else {
            a2 = zt() ? a(str, this.axP.XM) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.axP != null) {
            if (this.axP.XO != null && !this.axP.XO.isEmpty()) {
                for (String str2 : this.axP.XO) {
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

    public boolean zt() {
        return this.axO > 0;
    }

    public void zu() {
        this.axO = 0L;
    }

    public void I(long j) {
        this.axO = j;
    }

    public boolean dY(String str) {
        if (this.axQ == null || this.axQ.isEmpty()) {
            return false;
        }
        return this.axQ.contains(str);
    }

    public void release() {
        this.axO = 0L;
        if (this.axQ != null) {
            this.axQ.clear();
        }
        this.axP = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d axR = new d();
    }
}
