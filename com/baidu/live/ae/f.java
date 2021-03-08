package com.baidu.live.ae;

import android.text.TextUtils;
import com.baidu.live.data.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class f {
    private long bCG;
    private t.a bCH;
    private List<String> bCI;

    public static f QE() {
        return a.bCJ;
    }

    public void b(t.a aVar) {
        if (this.bCI != null) {
            this.bCI.clear();
        }
        bi(0L);
        this.bCH = aVar;
        if (this.bCH != null) {
            List<String> list = aVar.aJB;
            if (list != null && !list.isEmpty()) {
                if (this.bCI == null) {
                    this.bCI = new ArrayList();
                }
                this.bCI.addAll(list);
            }
            bi(aVar.endTime - aVar.aJA);
        }
    }

    public double m(boolean z, String str) {
        double a2;
        if (this.bCH == null || this.bCH.aJx != 1) {
            return 0.0d;
        }
        if (z) {
            if (QF()) {
                a2 = Math.max(a(str, this.bCH.aJz), a(str, this.bCH.aJy));
            } else {
                a2 = a(str, this.bCH.aJy);
            }
        } else {
            a2 = QF() ? a(str, this.bCH.aJz) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bCH != null) {
            if (this.bCH.aJC != null && !this.bCH.aJC.isEmpty()) {
                for (String str2 : this.bCH.aJC) {
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

    public boolean QF() {
        return this.bCG > 0;
    }

    public void bi(long j) {
        this.bCG = j;
    }

    public boolean hB(String str) {
        if (this.bCI == null || this.bCI.isEmpty()) {
            return false;
        }
        return this.bCI.contains(str);
    }

    public void release() {
        this.bCG = 0L;
        if (this.bCI != null) {
            this.bCI.clear();
        }
        this.bCH = null;
    }

    private f() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final f bCJ = new f();
    }
}
