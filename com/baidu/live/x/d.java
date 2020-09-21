package com.baidu.live.x;

import android.text.TextUtils;
import com.baidu.live.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private long bnh;
    private l.a bni;
    private List<String> bnj;

    public static d NU() {
        return a.bnk;
    }

    public void b(l.a aVar) {
        if (this.bnj != null) {
            this.bnj.clear();
        }
        ar(0L);
        this.bni = aVar;
        if (this.bni != null) {
            List<String> list = aVar.aEw;
            if (list != null && !list.isEmpty()) {
                if (this.bnj == null) {
                    this.bnj = new ArrayList();
                }
                this.bnj.addAll(list);
            }
            ar(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.bni == null || this.bni.aEt != 1) {
            return 0.0d;
        }
        if (z) {
            if (NV()) {
                a2 = Math.max(a(str, this.bni.aEv), a(str, this.bni.aEu));
            } else {
                a2 = a(str, this.bni.aEu);
            }
        } else {
            a2 = NV() ? a(str, this.bni.aEv) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bni != null) {
            if (this.bni.aEx != null && !this.bni.aEx.isEmpty()) {
                for (String str2 : this.bni.aEx) {
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

    public boolean NV() {
        return this.bnh > 0;
    }

    public void NW() {
        this.bnh = 0L;
    }

    public void ar(long j) {
        this.bnh = j;
    }

    public boolean ht(String str) {
        if (this.bnj == null || this.bnj.isEmpty()) {
            return false;
        }
        return this.bnj.contains(str);
    }

    public void release() {
        this.bnh = 0L;
        if (this.bnj != null) {
            this.bnj.clear();
        }
        this.bni = null;
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d bnk = new d();
    }
}
