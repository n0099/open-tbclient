package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private long beA;
    private i.a beB;
    private List<String> beC;

    public static d Hz() {
        return a.beD;
    }

    public void b(i.a aVar) {
        if (this.beC != null) {
            this.beC.clear();
        }
        ap(0L);
        this.beB = aVar;
        if (this.beB != null) {
            List<String> list = aVar.ayz;
            if (list != null && !list.isEmpty()) {
                if (this.beC == null) {
                    this.beC = new ArrayList();
                }
                this.beC.addAll(list);
            }
            ap(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.beB == null || this.beB.ayw != 1) {
            return 0.0d;
        }
        if (z) {
            if (HA()) {
                a2 = Math.max(a(str, this.beB.ayy), a(str, this.beB.ayx));
            } else {
                a2 = a(str, this.beB.ayx);
            }
        } else {
            a2 = HA() ? a(str, this.beB.ayy) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.beB != null) {
            if (this.beB.ayA != null && !this.beB.ayA.isEmpty()) {
                for (String str2 : this.beB.ayA) {
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

    public boolean HA() {
        return this.beA > 0;
    }

    public void HB() {
        this.beA = 0L;
    }

    public void ap(long j) {
        this.beA = j;
    }

    public boolean fI(String str) {
        if (this.beC == null || this.beC.isEmpty()) {
            return false;
        }
        return this.beC.contains(str);
    }

    public void release() {
        this.beA = 0L;
        if (this.beC != null) {
            this.beC.clear();
        }
        this.beB = null;
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d beD = new d();
    }
}
