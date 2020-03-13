package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long axP;
    private f.a axQ;
    private List<String> axR;

    public static d zs() {
        return a.axS;
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
        if (this.axR != null) {
            this.axR.clear();
        }
        I(0L);
        this.axQ = aVar;
        if (this.axQ != null) {
            List<String> list = aVar.XN;
            if (list != null && !list.isEmpty()) {
                if (this.axR == null) {
                    this.axR = new ArrayList();
                }
                this.axR.addAll(list);
            }
            I(aVar.endTime - aVar.currentTime);
        }
    }

    public double e(boolean z, String str) {
        double a2;
        if (this.axQ == null || this.axQ.XK != 1) {
            return 0.0d;
        }
        if (z) {
            if (zt()) {
                a2 = Math.max(a(str, this.axQ.XM), a(str, this.axQ.XL));
            } else {
                a2 = a(str, this.axQ.XL);
            }
        } else {
            a2 = zt() ? a(str, this.axQ.XM) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.axQ != null) {
            if (this.axQ.XO != null && !this.axQ.XO.isEmpty()) {
                for (String str2 : this.axQ.XO) {
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
        return this.axP > 0;
    }

    public void zu() {
        this.axP = 0L;
    }

    public void I(long j) {
        this.axP = j;
    }

    public boolean dY(String str) {
        if (this.axR == null || this.axR.isEmpty()) {
            return false;
        }
        return this.axR.contains(str);
    }

    public void release() {
        this.axP = 0L;
        if (this.axR != null) {
            this.axR.clear();
        }
        this.axQ = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d axS = new d();
    }
}
