package com.baidu.searchbox.dns.d;

import java.util.Map;
/* loaded from: classes2.dex */
public class a extends com.baidu.searchbox.dns.d.b.a {
    private c A;
    private boolean y;
    private String z;

    public a(boolean z, String str) {
        this.y = z;
        this.z = str;
    }

    private synchronized c j() {
        if (this.A == null) {
            this.A = new c(this.y, this.z);
        }
        return this.A;
    }

    private void a(com.baidu.searchbox.dns.d.a.b bVar) {
        Map<String, com.baidu.searchbox.dns.d.a.a> t = bVar.t();
        if (t != null && !t.isEmpty()) {
            for (Map.Entry<String, com.baidu.searchbox.dns.d.a.a> entry : t.entrySet()) {
                com.baidu.searchbox.dns.a.a.e().a(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    public void start() {
        b.m().a(this.z, this);
        super.start();
    }

    @Override // com.baidu.searchbox.dns.d.b.a
    protected void k() {
        com.baidu.searchbox.dns.d.a.b F = j().F();
        if (F != null) {
            a(F);
        }
        b.m().e(this.z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.dns.d.b.a
    public String l() {
        return "DNS_TASK";
    }
}
