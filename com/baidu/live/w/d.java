package com.baidu.live.w;

import android.text.TextUtils;
import com.baidu.live.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private long bko;
    private i.a bkp;
    private List<String> bkq;

    public static d Nr() {
        return a.bkr;
    }

    public void b(i.a aVar) {
        if (this.bkq != null) {
            this.bkq.clear();
        }
        aq(0L);
        this.bkp = aVar;
        if (this.bkp != null) {
            List<String> list = aVar.aDD;
            if (list != null && !list.isEmpty()) {
                if (this.bkq == null) {
                    this.bkq = new ArrayList();
                }
                this.bkq.addAll(list);
            }
            aq(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.bkp == null || this.bkp.aDA != 1) {
            return 0.0d;
        }
        if (z) {
            if (Ns()) {
                a2 = Math.max(a(str, this.bkp.aDC), a(str, this.bkp.aDB));
            } else {
                a2 = a(str, this.bkp.aDB);
            }
        } else {
            a2 = Ns() ? a(str, this.bkp.aDC) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bkp != null) {
            if (this.bkp.aDE != null && !this.bkp.aDE.isEmpty()) {
                for (String str2 : this.bkp.aDE) {
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

    public boolean Ns() {
        return this.bko > 0;
    }

    public void Nt() {
        this.bko = 0L;
    }

    public void aq(long j) {
        this.bko = j;
    }

    public boolean hd(String str) {
        if (this.bkq == null || this.bkq.isEmpty()) {
            return false;
        }
        return this.bkq.contains(str);
    }

    public void release() {
        this.bko = 0L;
        if (this.bkq != null) {
            this.bkq.clear();
        }
        this.bkp = null;
    }

    private d() {
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d bkr = new d();
    }
}
