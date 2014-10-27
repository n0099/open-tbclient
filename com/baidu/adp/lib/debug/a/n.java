package com.baidu.adp.lib.debug.a;
/* loaded from: classes.dex */
public class n extends a {
    private String gF = "StrictMode";
    private String[] gG = {"StrictMode", "policy", "violation"};

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        super.start();
        try {
            k.a(this.gF, new o(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
