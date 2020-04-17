package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a ceQ;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.ceQ = aVar;
    }

    public boolean isShow() {
        return this.ceQ != null && "show".equals(this.ceQ.getAction());
    }
}
