package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.i;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long aZa;
    private i.a aZb;
    private List<String> aZc;

    public static d Gl() {
        return a.aZd;
    }

    public void a(long j, long j2, int i) {
        g gVar = new g();
        gVar.setId(i);
        gVar.addParam("benefit_userid", j);
        gVar.addParam("live_id", j2);
        gVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(gVar);
    }

    public void b(i.a aVar) {
        if (this.aZc != null) {
            this.aZc.clear();
        }
        ap(0L);
        this.aZb = aVar;
        if (this.aZb != null) {
            List<String> list = aVar.avg;
            if (list != null && !list.isEmpty()) {
                if (this.aZc == null) {
                    this.aZc = new ArrayList();
                }
                this.aZc.addAll(list);
            }
            ap(aVar.endTime - aVar.currentTime);
        }
    }

    public double f(boolean z, String str) {
        double a2;
        if (this.aZb == null || this.aZb.avd != 1) {
            return 0.0d;
        }
        if (z) {
            if (Gm()) {
                a2 = Math.max(a(str, this.aZb.avf), a(str, this.aZb.ave));
            } else {
                a2 = a(str, this.aZb.ave);
            }
        } else {
            a2 = Gm() ? a(str, this.aZb.avf) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.aZb != null) {
            if (this.aZb.avh != null && !this.aZb.avh.isEmpty()) {
                for (String str2 : this.aZb.avh) {
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

    public boolean Gm() {
        return this.aZa > 0;
    }

    public void Gn() {
        this.aZa = 0L;
    }

    public void ap(long j) {
        this.aZa = j;
    }

    public boolean fC(String str) {
        if (this.aZc == null || this.aZc.isEmpty()) {
            return false;
        }
        return this.aZc.contains(str);
    }

    public void release() {
        this.aZa = 0L;
        if (this.aZc != null) {
            this.aZc.clear();
        }
        this.aZb = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aZd = new d();
    }
}
