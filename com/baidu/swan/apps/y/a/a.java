package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cEs;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cEs = aVar;
    }

    public boolean isShow() {
        return this.cEs != null && "show".equals(this.cEs.getAction());
    }
}
