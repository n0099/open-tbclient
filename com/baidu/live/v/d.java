package com.baidu.live.v;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.f;
import com.baidu.live.message.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private long ayd;
    private f.a aye;
    private List<String> ayf;

    public static d zz() {
        return a.ayg;
    }

    public void c(long j, long j2, int i) {
        g gVar = new g();
        gVar.setId(i);
        gVar.addParam("benefit_userid", j);
        gVar.addParam("live_id", j2);
        gVar.addParam("activity_id", i);
        MessageManager.getInstance().sendMessage(gVar);
    }

    public void b(f.a aVar) {
        if (this.ayf != null) {
            this.ayf.clear();
        }
        I(0L);
        this.aye = aVar;
        if (this.aye != null) {
            List<String> list = aVar.XX;
            if (list != null && !list.isEmpty()) {
                if (this.ayf == null) {
                    this.ayf = new ArrayList();
                }
                this.ayf.addAll(list);
            }
            I(aVar.endTime - aVar.currentTime);
        }
    }

    public double e(boolean z, String str) {
        double a2;
        if (this.aye == null || this.aye.XU != 1) {
            return 0.0d;
        }
        if (z) {
            if (zA()) {
                a2 = Math.max(a(str, this.aye.XW), a(str, this.aye.XV));
            } else {
                a2 = a(str, this.aye.XV);
            }
        } else {
            a2 = zA() ? a(str, this.aye.XW) : 0.0d;
        }
        if (a2 == 1.0d || a2 < 0.0d) {
            return 0.0d;
        }
        return a2;
    }

    private double a(String str, double d) {
        if (!TextUtils.isEmpty(str) && this.aye != null) {
            if (this.aye.XY != null && !this.aye.XY.isEmpty()) {
                for (String str2 : this.aye.XY) {
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

    public boolean zA() {
        return this.ayd > 0;
    }

    public void zB() {
        this.ayd = 0L;
    }

    public void I(long j) {
        this.ayd = j;
    }

    public boolean dX(String str) {
        if (this.ayf == null || this.ayf.isEmpty()) {
            return false;
        }
        return this.ayf.contains(str);
    }

    public void release() {
        this.ayd = 0L;
        if (this.ayf != null) {
            this.ayf.clear();
        }
        this.aye = null;
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d ayg = new d();
    }
}
