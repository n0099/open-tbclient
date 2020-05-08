package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long aRM;
    private f.a aRN;
    private List<String> aRO;

    public static d Eu() {
        return a.aRP;
    }

    public void a(long j, long j2, int i) {
        g gVar = new g();
        gVar.setId(i);
        gVar.addParam("benefit_userid", j);
        gVar.addParam("live_id", j2);
        gVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(gVar);
    }

    public void b(f.a aVar) {
        if (this.aRO != null) {
            this.aRO.clear();
        }
        ak(0L);
        this.aRN = aVar;
        if (this.aRN != null) {
            List<String> list = aVar.aqh;
            if (list != null && !list.isEmpty()) {
                if (this.aRO == null) {
                    this.aRO = new ArrayList();
                }
                this.aRO.addAll(list);
            }
            ak(aVar.endTime - aVar.currentTime);
        }
    }

    public double f(boolean z, String str) {
        double a2;
        if (this.aRN == null || this.aRN.aqe != 1) {
            return 0.0d;
        }
        if (z) {
            if (Ev()) {
                a2 = Math.max(a(str, this.aRN.aqg), a(str, this.aRN.aqf));
            } else {
                a2 = a(str, this.aRN.aqf);
            }
        } else {
            a2 = Ev() ? a(str, this.aRN.aqg) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.aRN != null) {
            if (this.aRN.aqi != null && !this.aRN.aqi.isEmpty()) {
                for (String str2 : this.aRN.aqi) {
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

    public boolean Ev() {
        return this.aRM > 0;
    }

    public void Ew() {
        this.aRM = 0L;
    }

    public void ak(long j) {
        this.aRM = j;
    }

    public boolean eQ(String str) {
        if (this.aRO == null || this.aRO.isEmpty()) {
            return false;
        }
        return this.aRO.contains(str);
    }

    public void release() {
        this.aRM = 0L;
        if (this.aRO != null) {
            this.aRO.clear();
        }
        this.aRN = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aRP = new d();
    }
}
