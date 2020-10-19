package com.baidu.live.x;

import android.text.TextUtils;
import com.baidu.live.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private long bqU;
    private l.a bqV;
    private List<String> bqW;

    public static d OZ() {
        return a.bqX;
    }

    public void b(l.a aVar) {
        if (this.bqW != null) {
            this.bqW.clear();
        }
        as(0L);
        this.bqV = aVar;
        if (this.bqV != null) {
            List<String> list = aVar.aHA;
            if (list != null && !list.isEmpty()) {
                if (this.bqW == null) {
                    this.bqW = new ArrayList();
                }
                this.bqW.addAll(list);
            }
            as(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.bqV == null || this.bqV.aHx != 1) {
            return 0.0d;
        }
        if (z) {
            if (Pa()) {
                a2 = Math.max(a(str, this.bqV.aHz), a(str, this.bqV.aHy));
            } else {
                a2 = a(str, this.bqV.aHy);
            }
        } else {
            a2 = Pa() ? a(str, this.bqV.aHz) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bqV != null) {
            if (this.bqV.aHB != null && !this.bqV.aHB.isEmpty()) {
                for (String str2 : this.bqV.aHB) {
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

    public boolean Pa() {
        return this.bqU > 0;
    }

    public void Pb() {
        this.bqU = 0L;
    }

    public void as(long j) {
        this.bqU = j;
    }

    public boolean hK(String str) {
        if (this.bqW == null || this.bqW.isEmpty()) {
            return false;
        }
        return this.bqW.contains(str);
    }

    public void release() {
        this.bqU = 0L;
        if (this.bqW != null) {
            this.bqW.clear();
        }
        this.bqV = null;
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d bqX = new d();
    }
}
