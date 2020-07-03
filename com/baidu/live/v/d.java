package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long beh;
    private i.a bei;
    private List<String> bej;

    public static d Ht() {
        return a.bek;
    }

    public void b(i.a aVar) {
        if (this.bej != null) {
            this.bej.clear();
        }
        ap(0L);
        this.bei = aVar;
        if (this.bei != null) {
            List<String> list = aVar.axm;
            if (list != null && !list.isEmpty()) {
                if (this.bej == null) {
                    this.bej = new ArrayList();
                }
                this.bej.addAll(list);
            }
            ap(aVar.endTime - aVar.currentTime);
        }
    }

    public double g(boolean z, String str) {
        double a2;
        if (this.bei == null || this.bei.axj != 1) {
            return 0.0d;
        }
        if (z) {
            if (Hu()) {
                a2 = Math.max(a(str, this.bei.axl), a(str, this.bei.axk));
            } else {
                a2 = a(str, this.bei.axk);
            }
        } else {
            a2 = Hu() ? a(str, this.bei.axl) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.bei != null) {
            if (this.bei.axn != null && !this.bei.axn.isEmpty()) {
                for (String str2 : this.bei.axn) {
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

    public boolean Hu() {
        return this.beh > 0;
    }

    public void Hv() {
        this.beh = 0L;
    }

    public void ap(long j) {
        this.beh = j;
    }

    public boolean fK(String str) {
        if (this.bej == null || this.bej.isEmpty()) {
            return false;
        }
        return this.bej.contains(str);
    }

    public void release() {
        this.beh = 0L;
        if (this.bej != null) {
            this.bej.clear();
        }
        this.bei = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d bek = new d();
    }
}
