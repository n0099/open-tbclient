package com.baidu.adp.lib.debug.a;
/* loaded from: classes.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f149a = "StrictMode";
    private String[] b = {"StrictMode", "policy", "violation"};

    @Override // com.baidu.adp.lib.debug.a.a
    public void b() {
        super.b();
        try {
            j.a(this.f149a, new n(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
