package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a bFU;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.bFU = aVar;
    }

    public boolean isShow() {
        return this.bFU != null && "show".equals(this.bFU.getAction());
    }
}
