package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long aRH;
    private f.a aRI;
    private List<String> aRJ;

    public static d Ev() {
        return a.aRK;
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
        if (this.aRJ != null) {
            this.aRJ.clear();
        }
        ak(0L);
        this.aRI = aVar;
        if (this.aRI != null) {
            List<String> list = aVar.aqb;
            if (list != null && !list.isEmpty()) {
                if (this.aRJ == null) {
                    this.aRJ = new ArrayList();
                }
                this.aRJ.addAll(list);
            }
            ak(aVar.endTime - aVar.currentTime);
        }
    }

    public double f(boolean z, String str) {
        double a2;
        if (this.aRI == null || this.aRI.apY != 1) {
            return 0.0d;
        }
        if (z) {
            if (Ew()) {
                a2 = Math.max(a(str, this.aRI.aqa), a(str, this.aRI.apZ));
            } else {
                a2 = a(str, this.aRI.apZ);
            }
        } else {
            a2 = Ew() ? a(str, this.aRI.aqa) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.aRI != null) {
            if (this.aRI.aqc != null && !this.aRI.aqc.isEmpty()) {
                for (String str2 : this.aRI.aqc) {
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

    public boolean Ew() {
        return this.aRH > 0;
    }

    public void Ex() {
        this.aRH = 0L;
    }

    public void ak(long j) {
        this.aRH = j;
    }

    public boolean eQ(String str) {
        if (this.aRJ == null || this.aRJ.isEmpty()) {
            return false;
        }
        return this.aRJ.contains(str);
    }

    public void release() {
        this.aRH = 0L;
        if (this.aRJ != null) {
            this.aRJ.clear();
        }
        this.aRI = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aRK = new d();
    }
}
