package com.baidu.live.ae;

import android.text.TextUtils;
import com.baidu.live.data.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class f {
    private long bBg;
    private t.a bBh;
    private List<String> bBi;

    public static f QB() {
        return a.bBj;
    }

    public void b(t.a aVar) {
        if (this.bBi != null) {
            this.bBi.clear();
        }
        bi(0L);
        this.bBh = aVar;
        if (this.bBh != null) {
            List<String> list = aVar.aIb;
            if (list != null && !list.isEmpty()) {
                if (this.bBi == null) {
                    this.bBi = new ArrayList();
                }
                this.bBi.addAll(list);
            }
            bi(aVar.endTime - aVar.aIa);
        }
    }

    public double m(boolean z, String str) {
        double a2;
        if (this.bBh == null || this.bBh.aHX != 1) {
            return 0.0d;
        }
        if (z) {
            if (QC()) {
                a2 = Math.max(a(str, this.bBh.aHZ), a(str, this.bBh.aHY));
            } else {
                a2 = a(str, this.bBh.aHY);
            }
        } else {
            a2 = QC() ? a(str, this.bBh.aHZ) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bBh != null) {
            if (this.bBh.aIc != null && !this.bBh.aIc.isEmpty()) {
                for (String str2 : this.bBh.aIc) {
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

    public boolean QC() {
        return this.bBg > 0;
    }

    public void bi(long j) {
        this.bBg = j;
    }

    public boolean hv(String str) {
        if (this.bBi == null || this.bBi.isEmpty()) {
            return false;
        }
        return this.bBi.contains(str);
    }

    public void release() {
        this.bBg = 0L;
        if (this.bBi != null) {
            this.bBi.clear();
        }
        this.bBh = null;
    }

    private f() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final f bBj = new f();
    }
}
