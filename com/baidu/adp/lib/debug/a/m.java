package com.baidu.adp.lib.debug.a;
/* loaded from: classes.dex */
public class m extends a {
    private String a = "StrictMode";
    private String[] b = {"StrictMode", "policy", "violation"};

    @Override // com.baidu.adp.lib.debug.a.a
    public void b() {
        super.b();
        try {
            j.a(this.a, new n(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
