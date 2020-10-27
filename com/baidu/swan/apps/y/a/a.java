package com.baidu.swan.apps.y.a;
/* loaded from: classes10.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a daT;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.daT = aVar;
    }

    public boolean isShow() {
        return this.daT != null && "show".equals(this.daT.getAction());
    }
}
