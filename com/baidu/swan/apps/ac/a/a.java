package com.baidu.swan.apps.ac.a;
/* loaded from: classes9.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a bBb;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.bBb = aVar;
    }

    public boolean isShow() {
        return this.bBb != null && "show".equals(this.bBb.getAction());
    }
}
