package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cSv;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cSv = aVar;
    }

    public boolean isShow() {
        return this.cSv != null && "show".equals(this.cSv.getAction());
    }
}
