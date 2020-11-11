package com.baidu.live.aa;

import android.text.TextUtils;
import com.baidu.live.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private long bui;
    private o.a buj;
    private List<String> buk;

    public static f Qg() {
        return a.bul;
    }

    public void b(o.a aVar) {
        if (this.buk != null) {
            this.buk.clear();
        }
        aG(0L);
        this.buj = aVar;
        if (this.buj != null) {
            List<String> list = aVar.aIT;
            if (list != null && !list.isEmpty()) {
                if (this.buk == null) {
                    this.buk = new ArrayList();
                }
                this.buk.addAll(list);
            }
            aG(aVar.endTime - aVar.currentTime);
        }
    }

    public double i(boolean z, String str) {
        double a2;
        if (this.buj == null || this.buj.aIQ != 1) {
            return 0.0d;
        }
        if (z) {
            if (Qh()) {
                a2 = Math.max(a(str, this.buj.aIS), a(str, this.buj.aIR));
            } else {
                a2 = a(str, this.buj.aIR);
            }
        } else {
            a2 = Qh() ? a(str, this.buj.aIS) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.buj != null) {
            if (this.buj.aIU != null && !this.buj.aIU.isEmpty()) {
                for (String str2 : this.buj.aIU) {
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

    public boolean Qh() {
        return this.bui > 0;
    }

    public void aG(long j) {
        this.bui = j;
    }

    public boolean hZ(String str) {
        if (this.buk == null || this.buk.isEmpty()) {
            return false;
        }
        return this.buk.contains(str);
    }

    public void release() {
        this.bui = 0L;
        if (this.buk != null) {
            this.buk.clear();
        }
        this.buj = null;
    }

    private f() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final f bul = new f();
    }
}
