package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes12.dex */
public class a extends com.baidu.searchbox.dns.d.b.a {
    private boolean E;
    private String F;
    private c G;
    private int H;

    public a(boolean z, String str, int i) {
        this.E = z;
        this.F = str;
        this.H = i;
    }

    private synchronized c l() {
        if (this.G == null) {
            this.G = new c(this.E, this.F, this.H);
        }
        return this.G;
    }

    private void a(com.baidu.searchbox.dns.d.a.b bVar) {
        Map<String, com.baidu.searchbox.dns.d.a.a> A = bVar.A();
        if (A != null && !A.isEmpty()) {
            for (Map.Entry<String, com.baidu.searchbox.dns.d.a.a> entry : A.entrySet()) {
                com.baidu.searchbox.dns.a.a.e().a(entry.getKey(), entry.getValue());
            }
        }
        Map<String, com.baidu.searchbox.dns.d.a.a> B = bVar.B();
        if (B != null && !B.isEmpty()) {
            for (Map.Entry<String, com.baidu.searchbox.dns.d.a.a> entry2 : B.entrySet()) {
                com.baidu.searchbox.dns.a.a.e().b(entry2.getKey(), entry2.getValue());
            }
        }
        String C = bVar.C();
        if (!TextUtils.isEmpty(C)) {
            com.baidu.searchbox.dns.a.a.e().e(C);
        }
        String D = bVar.D();
        if (!TextUtils.isEmpty(D)) {
            com.baidu.searchbox.dns.a.a.e().f(D);
        }
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    public void start() {
        b.o().a(this.F, this);
        super.start();
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    protected void m() {
        com.baidu.searchbox.dns.d.a.b x = l().x();
        if (x != null) {
            a(x);
        }
        b.o().j(this.F);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.b.a
    public String n() {
        return "DNS_TASK";
    }
}
