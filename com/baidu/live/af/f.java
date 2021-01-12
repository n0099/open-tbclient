package com.baidu.live.af;

import android.text.TextUtils;
import com.baidu.live.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class f {
    private long bxD;
    private p.a bxE;
    private List<String> bxF;

    public static f Pa() {
        return a.bxG;
    }

    public void b(p.a aVar) {
        if (this.bxF != null) {
            this.bxF.clear();
        }
        be(0L);
        this.bxE = aVar;
        if (this.bxE != null) {
            List<String> list = aVar.aFF;
            if (list != null && !list.isEmpty()) {
                if (this.bxF == null) {
                    this.bxF = new ArrayList();
                }
                this.bxF.addAll(list);
            }
            be(aVar.endTime - aVar.aFE);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.bxE == null || this.bxE.aFB != 1) {
            return 0.0d;
        }
        if (z) {
            if (Pb()) {
                a2 = Math.max(a(str, this.bxE.aFD), a(str, this.bxE.aFC));
            } else {
                a2 = a(str, this.bxE.aFC);
            }
        } else {
            a2 = Pb() ? a(str, this.bxE.aFD) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bxE != null) {
            if (this.bxE.aFG != null && !this.bxE.aFG.isEmpty()) {
                for (String str2 : this.bxE.aFG) {
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

    public boolean Pb() {
        return this.bxD > 0;
    }

    public void be(long j) {
        this.bxD = j;
    }

    public boolean gZ(String str) {
        if (this.bxF == null || this.bxF.isEmpty()) {
            return false;
        }
        return this.bxF.contains(str);
    }

    public void release() {
        this.bxD = 0L;
        if (this.bxF != null) {
            this.bxF.clear();
        }
        this.bxE = null;
    }

    private f() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final f bxG = new f();
    }
}
