package com.baidu.live.aa;

import android.text.TextUtils;
import com.baidu.live.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private long bsv;
    private o.a bsw;
    private List<String> bsx;

    public static f Px() {
        return a.bsy;
    }

    public void b(o.a aVar) {
        if (this.bsx != null) {
            this.bsx.clear();
        }
        aG(0L);
        this.bsw = aVar;
        if (this.bsw != null) {
            List<String> list = aVar.aHi;
            if (list != null && !list.isEmpty()) {
                if (this.bsx == null) {
                    this.bsx = new ArrayList();
                }
                this.bsx.addAll(list);
            }
            aG(aVar.endTime - aVar.currentTime);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.bsw == null || this.bsw.aHf != 1) {
            return 0.0d;
        }
        if (z) {
            if (Py()) {
                a2 = Math.max(a(str, this.bsw.aHh), a(str, this.bsw.aHg));
            } else {
                a2 = a(str, this.bsw.aHg);
            }
        } else {
            a2 = Py() ? a(str, this.bsw.aHh) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bsw != null) {
            if (this.bsw.aHj != null && !this.bsw.aHj.isEmpty()) {
                for (String str2 : this.bsw.aHj) {
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

    public boolean Py() {
        return this.bsv > 0;
    }

    public void aG(long j) {
        this.bsv = j;
    }

    public boolean hT(String str) {
        if (this.bsx == null || this.bsx.isEmpty()) {
            return false;
        }
        return this.bsx.contains(str);
    }

    public void release() {
        this.bsv = 0L;
        if (this.bsx != null) {
            this.bsx.clear();
        }
        this.bsw = null;
    }

    private f() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final f bsy = new f();
    }
}
