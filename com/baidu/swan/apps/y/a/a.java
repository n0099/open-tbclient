package com.baidu.swan.apps.y.a;
/* loaded from: classes25.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a dmg;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.dmg = aVar;
    }

    public boolean isShow() {
        return this.dmg != null && "show".equals(this.dmg.getAction());
    }
}
