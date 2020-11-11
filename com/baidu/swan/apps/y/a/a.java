package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a dgO;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.dgO = aVar;
    }

    public boolean isShow() {
        return this.dgO != null && "show".equals(this.dgO.getAction());
    }
}
