package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cEo;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cEo = aVar;
    }

    public boolean isShow() {
        return this.cEo != null && "show".equals(this.cEo.getAction());
    }
}
