package com.baidu.live.w;

import android.text.TextUtils;
import com.baidu.live.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private long bkl;
    private i.a bkm;
    private List<String> bkn;

    public static d Nr() {
        return a.bko;
    }

    public void b(i.a aVar) {
        if (this.bkn != null) {
            this.bkn.clear();
        }
        aq(0L);
        this.bkm = aVar;
        if (this.bkm != null) {
            List<String> list = aVar.aDB;
            if (list != null && !list.isEmpty()) {
                if (this.bkn == null) {
                    this.bkn = new ArrayList();
                }
                this.bkn.addAll(list);
            }
            aq(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.bkm == null || this.bkm.aDy != 1) {
            return 0.0d;
        }
        if (z) {
            if (Ns()) {
                a2 = Math.max(a(str, this.bkm.aDA), a(str, this.bkm.aDz));
            } else {
                a2 = a(str, this.bkm.aDz);
            }
        } else {
            a2 = Ns() ? a(str, this.bkm.aDA) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bkm != null) {
            if (this.bkm.aDC != null && !this.bkm.aDC.isEmpty()) {
                for (String str2 : this.bkm.aDC) {
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
        return this.bkl > 0;
    }

    public void Nt() {
        this.bkl = 0L;
    }

    public void aq(long j) {
        this.bkl = j;
    }

    public boolean hc(String str) {
        if (this.bkn == null || this.bkn.isEmpty()) {
            return false;
        }
        return this.bkn.contains(str);
    }

    public void release() {
        this.bkl = 0L;
        if (this.bkn != null) {
            this.bkn.clear();
        }
        this.bkm = null;
    }

    private d() {
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d bko = new d();
    }
}
