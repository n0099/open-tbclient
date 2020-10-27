package com.baidu.live.z;

import android.text.TextUtils;
import com.baidu.live.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private long bsM;
    private o.a bsN;
    private List<String> bsO;

    public static f PF() {
        return a.bsP;
    }

    public void b(o.a aVar) {
        if (this.bsO != null) {
            this.bsO.clear();
        }
        au(0L);
        this.bsN = aVar;
        if (this.bsN != null) {
            List<String> list = aVar.aIb;
            if (list != null && !list.isEmpty()) {
                if (this.bsO == null) {
                    this.bsO = new ArrayList();
                }
                this.bsO.addAll(list);
            }
            au(aVar.endTime - aVar.currentTime);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.bsN == null || this.bsN.aHY != 1) {
            return 0.0d;
        }
        if (z) {
            if (PG()) {
                a2 = Math.max(a(str, this.bsN.aIa), a(str, this.bsN.aHZ));
            } else {
                a2 = a(str, this.bsN.aHZ);
            }
        } else {
            a2 = PG() ? a(str, this.bsN.aIa) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bsN != null) {
            if (this.bsN.aIc != null && !this.bsN.aIc.isEmpty()) {
                for (String str2 : this.bsN.aIc) {
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

    public boolean PG() {
        return this.bsM > 0;
    }

    public void PH() {
        this.bsM = 0L;
    }

    public void au(long j) {
        this.bsM = j;
    }

    public boolean hS(String str) {
        if (this.bsO == null || this.bsO.isEmpty()) {
            return false;
        }
        return this.bsO.contains(str);
    }

    public void release() {
        this.bsM = 0L;
        if (this.bsO != null) {
            this.bsO.clear();
        }
        this.bsN = null;
    }

    private f() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final f bsP = new f();
    }
}
