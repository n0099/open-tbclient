package com.baidu.live.ae;

import android.text.TextUtils;
import com.baidu.live.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private long bxE;
    private o.a bxF;
    private List<String> bxG;

    public static f RR() {
        return a.bxH;
    }

    public void b(o.a aVar) {
        if (this.bxG != null) {
            this.bxG.clear();
        }
        be(0L);
        this.bxF = aVar;
        if (this.bxF != null) {
            List<String> list = aVar.aJT;
            if (list != null && !list.isEmpty()) {
                if (this.bxG == null) {
                    this.bxG = new ArrayList();
                }
                this.bxG.addAll(list);
            }
            be(aVar.endTime - aVar.aJS);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.bxF == null || this.bxF.aJP != 1) {
            return 0.0d;
        }
        if (z) {
            if (RS()) {
                a2 = Math.max(a(str, this.bxF.aJR), a(str, this.bxF.aJQ));
            } else {
                a2 = a(str, this.bxF.aJQ);
            }
        } else {
            a2 = RS() ? a(str, this.bxF.aJR) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bxF != null) {
            if (this.bxF.aJU != null && !this.bxF.aJU.isEmpty()) {
                for (String str2 : this.bxF.aJU) {
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

    public boolean RS() {
        return this.bxE > 0;
    }

    public void be(long j) {
        this.bxE = j;
    }

    public boolean ix(String str) {
        if (this.bxG == null || this.bxG.isEmpty()) {
            return false;
        }
        return this.bxG.contains(str);
    }

    public void release() {
        this.bxE = 0L;
        if (this.bxG != null) {
            this.bxG.clear();
        }
        this.bxF = null;
    }

    private f() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final f bxH = new f();
    }
}
