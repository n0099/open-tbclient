package com.baidu.live.af;

import android.text.TextUtils;
import com.baidu.live.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class f {
    private long bCp;
    private p.a bCq;
    private List<String> bCr;

    public static f SV() {
        return a.bCs;
    }

    public void b(p.a aVar) {
        if (this.bCr != null) {
            this.bCr.clear();
        }
        be(0L);
        this.bCq = aVar;
        if (this.bCq != null) {
            List<String> list = aVar.aKs;
            if (list != null && !list.isEmpty()) {
                if (this.bCr == null) {
                    this.bCr = new ArrayList();
                }
                this.bCr.addAll(list);
            }
            be(aVar.endTime - aVar.aKr);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.bCq == null || this.bCq.aKo != 1) {
            return 0.0d;
        }
        if (z) {
            if (SW()) {
                a2 = Math.max(a(str, this.bCq.aKq), a(str, this.bCq.aKp));
            } else {
                a2 = a(str, this.bCq.aKp);
            }
        } else {
            a2 = SW() ? a(str, this.bCq.aKq) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bCq != null) {
            if (this.bCq.aKt != null && !this.bCq.aKt.isEmpty()) {
                for (String str2 : this.bCq.aKt) {
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

    public boolean SW() {
        return this.bCp > 0;
    }

    public void be(long j) {
        this.bCp = j;
    }

    public boolean ik(String str) {
        if (this.bCr == null || this.bCr.isEmpty()) {
            return false;
        }
        return this.bCr.contains(str);
    }

    public void release() {
        this.bCp = 0L;
        if (this.bCr != null) {
            this.bCr.clear();
        }
        this.bCq = null;
    }

    private f() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final f bCs = new f();
    }
}
